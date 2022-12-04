package com.bokeunjeong.practice.pattern.factory.store;

import com.bokeunjeong.practice.pattern.factory.pizza.Pizza;
import com.bokeunjeong.practice.pattern.factory.pizza.chicago.ChicagoStyleCheesePizza;
import com.bokeunjeong.practice.pattern.factory.pizza.chicago.ChicagoStyleClamPizza;
import com.bokeunjeong.practice.pattern.factory.pizza.chicago.ChicagoStylePepperoniPizza;
import com.bokeunjeong.practice.pattern.factory.pizza.chicago.ChicagoStyleVeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (type.equals("veggie")) {
            return new ChicagoStyleVeggiePizza();
        } else if (type.equals("clam")) {
            return new ChicagoStyleClamPizza();
        } else if (type.equals("pepperoni")) {
            return new ChicagoStylePepperoniPizza();
        } else {
            return null;
        }
    }
}
