package com.wenqi.learn.chapter6.item39;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation type with a parameter
 * 带参数的注解类型
 *
 * Indicates that the annotated method is a test method that
 * must throw the designated exception to succeed.
 *
 * @author liangwenqi
 * @date 2022/2/14
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
    Class<? extends Throwable> value();
}
