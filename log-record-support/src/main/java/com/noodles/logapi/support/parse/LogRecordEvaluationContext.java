package com.noodles.logapi.support.parse;

import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;

/**
 * @Author: noodles
 * @Date: 2022/01/11 11:47
 */
public class LogRecordEvaluationContext extends StandardEvaluationContext {
    public LogRecordEvaluationContext(Method method, Object[] arguments, ParameterNameDiscoverer parameterNameDiscoverer) {
        String[] parameterNames = parameterNameDiscoverer.getParameterNames(method);
        if (parameterNames != null) {
            for (int i = 0; i < parameterNames.length; i++) {
                setVariable(parameterNames[i], arguments[i]);
            }
        }
    }
}
