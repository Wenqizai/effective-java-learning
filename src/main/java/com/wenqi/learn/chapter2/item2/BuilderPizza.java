package com.wenqi.learn.chapter2.item2;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Wenqi Liang
 * @date 2021/11/20
 */
public abstract class BuilderPizza {
    // Builder pattern for class hierarchies
    // 用于层次结构的构造器模式

    public enum Topping{HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            topping.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract BuilderPizza build();

        // Subclasses must override this method to return "this"
        protected abstract T self();
    }

    BuilderPizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // See Item 50
    }
}
