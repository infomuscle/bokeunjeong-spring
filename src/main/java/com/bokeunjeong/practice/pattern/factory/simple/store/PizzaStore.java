package com.bokeunjeong.practice.pattern.factory.simple.store;


import com.bokeunjeong.practice.pattern.factory.simple.SimplePizzaFacotry;
import com.bokeunjeong.practice.pattern.factory.simple.pizza.Pizza;

public class PizzaStore {

    SimplePizzaFacotry facotry;

    public PizzaStore(SimplePizzaFacotry facotry) {
        this.facotry = facotry;
    }

    public final Pizza orderPizza(String type) {
        Pizza pizza = facotry.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
