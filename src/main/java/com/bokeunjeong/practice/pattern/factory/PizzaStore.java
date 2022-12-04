package com.bokeunjeong.practice.pattern.factory;

public class PizzaStore {

    SimplePizzaFacotry facotry;

    public PizzaStore(SimplePizzaFacotry facotry) {
        this.facotry = facotry;
    }

    Pizza orderPizza(String type) {
        Pizza pizza = facotry.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
