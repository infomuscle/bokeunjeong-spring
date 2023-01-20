package com.bokeunjeong.practice.pattern.factory.fm.store;

import com.bokeunjeong.practice.pattern.factory.fm.pizza.Pizza;
import com.bokeunjeong.practice.pattern.factory.fm.pizza.chicago.ChicagoStyleCheesePizza;
import com.bokeunjeong.practice.pattern.factory.fm.pizza.chicago.ChicagoStyleClamPizza;
import com.bokeunjeong.practice.pattern.factory.fm.pizza.chicago.ChicagoStylePepperoniPizza;
import com.bokeunjeong.practice.pattern.factory.fm.pizza.chicago.ChicagoStyleVeggiePizza;

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
