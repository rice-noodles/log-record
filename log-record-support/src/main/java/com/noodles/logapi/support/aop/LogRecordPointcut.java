package com.noodles.logapi.support.aop;

import com.noodles.logapi.annotation.LogRecord;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @Author: noodles
 * @Date: 2022/01/10 22:05
 */
public class LogRecordPointcut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> clazz) {
        return method.getAnnotation(LogRecord.class) != null;
    }
}
