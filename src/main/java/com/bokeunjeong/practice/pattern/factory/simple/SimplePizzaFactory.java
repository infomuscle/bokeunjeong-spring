package com.bokeunjeong.practice.pattern.factory.simple;


import com.bokeunjeong.practice.pattern.factory.simple.pizza.Pizza;
import com.bokeunjeong.practice.pattern.factory.simple.pizza.CheesePizza;
import com.bokeunjeong.practice.pattern.factory.simple.pizza.ClamPizza;
import com.bokeunjeong.practice.pattern.factory.simple.pizza.PepperoniPizza;
import com.bokeunjeong.practice.pattern.factory.simple.pizza.VeggiePizza;

public class SimplePizzaFactory {

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
