package com.wenqi.learn.chapter5.item33;

import java.lang.reflect.AnnotatedElement;

/**
 * @author liangwenqi
 * @date 2022/2/9
 */
public class Annotation {
    /**
     * Use of asSubclass to safely cast to a bounded type token
     * 使用 asSubclass 安全地转换为有界类型标记
     *
     * @param element
     * @param annotationTypeName
     * @return
     */
    static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
        // Unbounded type token
        Class<?> annotationType = null;
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }
}
