package com.wenqi.learn.chapter6.item39;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker annotation type declaration
 * 标记注解类型声明
 *
 * Indicates that the annotated method is a test method.
 * Use only on parameterless static methods.
 *
 * @author liangwenqi
 * @date 2022/2/14
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
}
