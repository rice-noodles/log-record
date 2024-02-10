package com.noodles.logapi.support;

import com.noodles.logapi.configuration.LogRecordProxyAutoConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: noodles
 * @Date: 2022/01/10 21:44
 */
public class LogRecordConfigureSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{LogRecordProxyAutoConfiguration.class.getName()};
    }
}
