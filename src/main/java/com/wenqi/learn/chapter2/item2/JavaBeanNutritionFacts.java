package com.wenqi.learn.chapter2.item2;

/**
 * JavaBean方式设置参数, 更加灵活
 * 但是须注意对象的可变性和线程安全问题
 * @author Wenqi Liang
 * @date 2021/11/20
 */
public class JavaBeanNutritionFacts {
    // JavaBeans Pattern - allows inconsistency, mandates mutability

    // Parameters initialized to default values (if any)
    private int servingSize = -1; // Required; no default value
    private int servings = -1; // Required; no default value
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;

    public JavaBeanNutritionFacts() {
    }

    // Setters
    public void setServingSize(int val) {
        servingSize = val;
    }

    public void setServings(int val) {
        servings = val;
    }

    public void setCalories(int val) {
        calories = val;
    }

    public void setFat(int val) {
        fat = val;
    }

    public void setSodium(int val) {
        sodium = val;
    }

    public void setCarbohydrate(int val) {
        carbohydrate = val;
    }
}
