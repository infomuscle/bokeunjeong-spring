package com.bokeunjeong.practice.pattern.factory.af.store;


import com.bokeunjeong.practice.pattern.factory.af.pizza.Pizza;

public abstract class PizzaStore {

    public final Pizza orderPizza(String item) {
        Pizza pizza = createPizza(item);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    abstract Pizza createPizza(String item);

}
