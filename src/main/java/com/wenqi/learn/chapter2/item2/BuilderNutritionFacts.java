package com.wenqi.learn.chapter2.item2;

/**
 * 建造者模式创建对象
 * 兼顾JavaBean的易读和构造器的安全性
 * @author Wenqi Liang
 * @date 2021/11/20
 */
public class BuilderNutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;
        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }
        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public BuilderNutritionFacts build() {
            return new BuilderNutritionFacts(this);
        }
    }

    private BuilderNutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        Builder builder = new Builder(1, 2).calories(1).carbohydrate(2);
        new BuilderNutritionFacts(builder);
    }
}
