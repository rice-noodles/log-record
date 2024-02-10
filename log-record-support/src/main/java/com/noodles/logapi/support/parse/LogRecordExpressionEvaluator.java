package com.noodles.logapi.support.parse;

import org.springframework.context.expression.CachedExpressionEvaluator;
import org.springframework.expression.EvaluationContext;

import java.lang.reflect.Method;

/**
 * @Author: noodles
 * @Date: 2022/01/12 12:13
 */
public class LogRecordExpressionEvaluator extends CachedExpressionEvaluator {

    public EvaluationContext createEvaluationContext(Method method, Object[] arguments) {
        EvaluationContext evaluationContext = new LogRecordEvaluationContext(method, arguments, getParameterNameDiscoverer());
        return evaluationContext;
    }
}
