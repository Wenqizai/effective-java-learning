package com.wenqi.learn.chapter2.item2;

/**
 * @author Wenqi Liang
 * @date 2021/11/20
 */
public class Calzone extends BuilderPizza {
    private final boolean sauceInside;

    public static class Builder extends BuilderPizza.Builder<Builder> {
        private boolean sauceInside = false; // Default

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        public Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }
}
