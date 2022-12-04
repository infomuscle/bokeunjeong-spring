package com.bokeunjeong.practice.pattern.factory.store;

import com.bokeunjeong.practice.pattern.factory.pizza.Pizza;
import com.bokeunjeong.practice.pattern.factory.pizza.california.CaliforniaStyleCheesePizza;
import com.bokeunjeong.practice.pattern.factory.pizza.california.CaliforniaStyleClamPizza;
import com.bokeunjeong.practice.pattern.factory.pizza.california.CaliforniaStylePepperoniPizza;
import com.bokeunjeong.practice.pattern.factory.pizza.california.CaliforniaStyleVeggiePizza;

public class CaliforniaPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new CaliforniaStyleCheesePizza();
        } else if (type.equals("veggie")) {
            return new CaliforniaStyleVeggiePizza();
        } else if (type.equals("clam")) {
            return new CaliforniaStyleClamPizza();
        } else if (type.equals("pepperoni")) {
            return new CaliforniaStylePepperoniPizza();
        } else {
            return null;
        }
    }
}
