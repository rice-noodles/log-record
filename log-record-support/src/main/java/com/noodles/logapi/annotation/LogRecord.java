package com.noodles.logapi.annotation;

import java.lang.annotation.*;

/**
 * @Author: noodles
 * @Date: 2022/01/10 21:37
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogRecord {
    String content();

    String operator() default "";
}
