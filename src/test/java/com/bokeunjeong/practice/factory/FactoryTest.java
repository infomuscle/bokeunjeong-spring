package com.bokeunjeong.practice.factory;

import com.bokeunjeong.practice.pattern.factory.pizza.Pizza;
import com.bokeunjeong.practice.pattern.factory.store.ChicagoPizzaStore;
import com.bokeunjeong.practice.pattern.factory.store.NYPizzaStore;
import com.bokeunjeong.practice.pattern.factory.store.PizzaStore;
import org.junit.jupiter.api.Test;

public class FactoryTest {

    @Test
    void test1() {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza;

        pizza = nyStore.orderPizza("cheese");
        System.out.println(String.format("Ethan ordered a %s", pizza.getName()));
        System.out.println();

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println(String.format("Joel ordered a %s", pizza.getName()));
        System.out.println();
    }
}
