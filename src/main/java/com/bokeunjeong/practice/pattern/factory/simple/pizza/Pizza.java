package com.bokeunjeong.practice.pattern.factory.simple.pizza;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

    protected String name;
    protected String dough;
    protected String sauce;
    protected List<String> toppings = new ArrayList<>();

    public void prepare() {
        System.out.println(String.format("Prepare: %s", name));
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings:");
        for (String topping : toppings) {
            System.out.println(String.format("    %s", topping));
        }
    }

    public void bake() {
        System.out.println("Bake for 25 minutes at 350.");
    }

    public void cut() {
        System.out.println("Cut the pizza into diagonal slices.");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box.");
    }

    public String getName() {
        return name;
    }
}
