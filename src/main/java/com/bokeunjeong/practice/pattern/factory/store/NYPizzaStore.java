package com.bokeunjeong.practice.pattern.factory.store;

import com.bokeunjeong.practice.pattern.factory.pizza.Pizza;
import com.bokeunjeong.practice.pattern.factory.pizza.ny.NYStyleCheesePizza;
import com.bokeunjeong.practice.pattern.factory.pizza.ny.NYStyleClamPizza;
import com.bokeunjeong.practice.pattern.factory.pizza.ny.NYStylePepperoniPizza;
import com.bokeunjeong.practice.pattern.factory.pizza.ny.NYStyleVeggiePizza;

public class NYPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (type.equals("veggie")) {
            return new NYStyleVeggiePizza();
        } else if (type.equals("clam")) {
            return new NYStyleClamPizza();
        } else if (type.equals("pepperoni")) {
            return new NYStylePepperoniPizza();
        } else {
            return null;
        }
    }
}
