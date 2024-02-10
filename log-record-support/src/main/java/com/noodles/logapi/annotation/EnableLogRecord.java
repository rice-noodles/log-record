package com.noodles.logapi.annotation;

import com.noodles.logapi.support.LogRecordConfigureSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author: noodles
 * @Date: 2022/01/10 21:41
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LogRecordConfigureSelector.class)
public @interface EnableLogRecord {
}
