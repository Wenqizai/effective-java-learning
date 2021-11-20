package com.wenqi.learn.chapter2.item2;

/**
 * 多参数构造器, 容易搞混参数而出错
 * @author Wenqi Liang
 * @date 2021/11/20
 */
public class ContructNutritionFacts {
    // Telescoping constructor pattern - does not scale well!
    // 伸缩构造函数模式 - 不能很好地扩展
    private final int servingSize; // (mL) required
    private final int servings; // (per container) required
    private final int calories; // (per serving) optional
    private final int fat; // (g/serving) optional
    private final int sodium; // (mg/serving) optional
    private final int carbohydrate; // (g/serving) optional

    public ContructNutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public ContructNutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public ContructNutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public ContructNutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public ContructNutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

}
