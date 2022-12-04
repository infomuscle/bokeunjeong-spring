package com.bokeunjeong.practice.pattern.factory;

import com.bokeunjeong.practice.pattern.factory.pizza.Pizza;
import com.bokeunjeong.practice.pattern.factory.pizza.simple.CheesePizza;
import com.bokeunjeong.practice.pattern.factory.pizza.simple.ClamPizza;
import com.bokeunjeong.practice.pattern.factory.pizza.simple.PepperoniPizza;
import com.bokeunjeong.practice.pattern.factory.pizza.simple.VeggiePizza;

public class SimplePizzaFacotry {

    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        }
        // else if (type.equals("greek")) {
        //     pizza = new GreekPizza();
        // }
        else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }

        return pizza;
    }
}
