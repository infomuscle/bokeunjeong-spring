package com.bokeunjeong.practice.pattern.factory.af.store;

import com.bokeunjeong.practice.pattern.factory.af.ChicagoPizzaIngredientFactory;
import com.bokeunjeong.practice.pattern.factory.af.PizzaIngredientFactory;
import com.bokeunjeong.practice.pattern.factory.af.pizza.*;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String item) {

        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

        if (item.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("");
        } else if (item.equals("veggie")) {
            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("");
        } else if (item.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("");
        } else if (item.equals("pepperoni")) {
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("");
        }

        return pizza;
    }
}
