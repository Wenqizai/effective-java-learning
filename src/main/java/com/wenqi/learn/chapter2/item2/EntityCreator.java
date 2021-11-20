package com.wenqi.learn.chapter2.item2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 构造器通用类
 * @author Wenqi Liang
 * @date 2021/11/20
 */
public class EntityCreator<T> {

    private Class<T> classInstance;
    private T entityObj;

    public EntityCreator(Class<T> classInstance, Object... initParams) throws Exception {
        this.classInstance = classInstance;
        Class<?>[] paramTypes = new Class<?>[initParams.length];
        for (int index = 0; index < initParams.length; index++) {
            String checkStr = initParams[index].getClass().getSimpleName();
            if (checkStr.contains("Integer")) {
                paramTypes[index] = int.class;
            }
            if (checkStr.contains("Double")) {
                paramTypes[index] = double.class;
            }
            if (checkStr.contains("Boolean")) {
                paramTypes[index] = boolean.class;
            }
            if (checkStr.contains("String")) {
                paramTypes[index] = initParams[index].getClass();
            }
            Constructor<T> constructor = classInstance.getDeclaredConstructor(paramTypes);
            constructor.setAccessible(true);
            this.entityObj = constructor.newInstance(initParams);
        }
    }

    public EntityCreator<T> setValue(String paramName, Object paramValue) throws Exception {
        Field field = classInstance.getDeclaredField(paramName);
        field.setAccessible(true);
        field.set(entityObj, paramValue);
        return this;
    }

    public T build() {
        return entityObj;
    }

    public static void main(String[] args) throws Exception {
        ContructNutritionFacts nutritionFacts = new EntityCreator<>(ContructNutritionFacts.class, 20, 30)
                .setValue("calories", 100)
                .setValue("", 25)
                .setValue("carbohydrate", 27)
                .build();
    }
}
