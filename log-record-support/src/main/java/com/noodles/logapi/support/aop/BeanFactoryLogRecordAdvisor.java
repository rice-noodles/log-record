package com.noodles.logapi.support.aop;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;

/**
 * @Author: noodles
 * @Date: 2022/01/10 22:12
 */
public class BeanFactoryLogRecordAdvisor extends AbstractBeanFactoryPointcutAdvisor {

    private final LogRecordPointcut logRecordPointcut = new LogRecordPointcut();

    @Override
    public Pointcut getPointcut() {
        return logRecordPointcut;
    }
}
