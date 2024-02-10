package com.noodles.logapi.configuration;

import com.noodles.logapi.annotation.EnableLogRecord;
import com.noodles.logapi.support.aop.BeanFactoryLogRecordAdvisor;
import com.noodles.logapi.support.aop.LogRecordInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 组装注解组件
 *
 * @Author: noodles
 * @Date: 2022/01/10 21:52
 */
@Slf4j
@Configuration
public class LogRecordProxyAutoConfiguration implements ImportAware {

    private AnnotationAttributes enableLogRecord;

    @Bean
    public BeanFactoryLogRecordAdvisor beanFactoryLogRecordAdvisor() {
        BeanFactoryLogRecordAdvisor advisor = new BeanFactoryLogRecordAdvisor();
        advisor.setAdvice(logRecordInterceptor());
        return advisor;
    }

    @Bean
    public LogRecordInterceptor logRecordInterceptor() {
        return new LogRecordInterceptor();
    }

    @Override
    public void setImportMetadata(AnnotationMetadata annotationMetadata) {
        this.enableLogRecord = AnnotationAttributes.fromMap(
                annotationMetadata.getAnnotationAttributes(EnableLogRecord.class.getName(), false));
        if (enableLogRecord == null) {
            log.error("enableLogRecord is not import");
        }
    }
}
