package com.bokeunjeong.practice.pattern.factory.store;

import com.bokeunjeong.practice.pattern.factory.pizza.Pizza;

public abstract class PizzaStore {

    // SimplePizzaFacotry facotry;

    // public PizzaStore(SimplePizzaFacotry facotry) {
    //     this.facotry = facotry;
    // }

    public final Pizza orderPizza(String type) {
        // Pizza pizza = facotry.createPizza(type);
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    abstract Pizza createPizza(String type);

}
