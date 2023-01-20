package com.bokeunjeong.practice.pattern.factory.simple.store;


import com.bokeunjeong.practice.pattern.factory.simple.SimplePizzaFactory;
import com.bokeunjeong.practice.pattern.factory.simple.pizza.Pizza;

public class PizzaStore {

    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public final Pizza orderPizza(String type) {
        Pizza pizza = factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
