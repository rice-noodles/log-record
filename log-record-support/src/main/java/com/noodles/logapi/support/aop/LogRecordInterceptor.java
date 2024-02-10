package com.noodles.logapi.support.aop;

import com.noodles.logapi.annotation.LogRecord;
import com.noodles.logapi.beans.LogRecordOps;
import com.noodles.logapi.service.LogRecordService;
import com.noodles.logapi.support.parse.LogRecordExpressionEvaluator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author: noodles
 * @Date: 2022/01/10 22:01
 */
@Slf4j
public class LogRecordInterceptor implements MethodInterceptor, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private LogRecordService<Object> logRecordService;

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        MethodExecuteResult executeResult = new MethodExecuteResult(true, null);
        Object result = null;
        try {
            result = methodInvocation.proceed();
        } catch (Exception e) {
            executeResult = new MethodExecuteResult(false, e);
        }
        Method method = methodInvocation.getMethod();
        LogRecord logRecord = method.getAnnotation(LogRecord.class);
        if (logRecord != null) {
            LogRecordOps logRecordOps = buildLogRecordOps(method, executeResult);
            // throw exception directly if parse error
            String content = parseTemplate(logRecordOps.getContent(), method, methodInvocation.getArguments());
            logRecordOps.setContent(content);
            try {
                setLogRecordService(applicationContext.getBean(LogRecordService.class));
            } catch (Exception ignore) {
                log.warn("a configured LogRecordService is not found");
            }
            if (logRecordService != null) {
                logRecordService.record(logRecordOps);
            }
        }
        if (executeResult.throwable != null) {
            throw executeResult.throwable;
        }
        return result;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 解析 SpEL模板
     *
     * @param content
     * @param method
     * @param arguments
     * @return
     */
    public String parseTemplate(String content, Method method, Object[] arguments) {
        LogRecordExpressionEvaluator expressionEvaluator = new LogRecordExpressionEvaluator();
        EvaluationContext evaluationContext = expressionEvaluator.createEvaluationContext(method, arguments);

        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(content, new TemplateParserContext());
        return expression.getValue(evaluationContext, String.class);
    }

    public void setLogRecordService(LogRecordService<Object> logRecordService) {
        this.logRecordService = logRecordService;
    }

    public LogRecordOps buildLogRecordOps(Method method, MethodExecuteResult executeResult) {
        LogRecord logRecord = method.getAnnotation(LogRecord.class);
        return LogRecordOps.builder()
                .content(logRecord.content())
                .success(executeResult.success)
                .user("default")
                .date(new Date())
                .build();
    }

    @AllArgsConstructor
    @NoArgsConstructor
    static class MethodExecuteResult {
        private boolean success;
        private Throwable throwable;
    }
}


