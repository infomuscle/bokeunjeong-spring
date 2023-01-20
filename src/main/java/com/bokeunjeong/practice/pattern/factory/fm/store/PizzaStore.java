package com.bokeunjeong.practice.pattern.factory.fm.store;

import com.bokeunjeong.practice.pattern.factory.fm.pizza.Pizza;

public abstract class PizzaStore {

    public final Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    abstract Pizza createPizza(String type);

}
