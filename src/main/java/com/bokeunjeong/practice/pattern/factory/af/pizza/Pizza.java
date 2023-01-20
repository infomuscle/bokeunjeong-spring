package com.bokeunjeong.practice.pattern.factory.af.pizza;

import com.bokeunjeong.practice.pattern.factory.af.ingredient.cheese.Cheese;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.clams.Clams;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.dough.Dough;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.pepperoni.Pepperoni;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.sauce.Sauce;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.veggies.Veggies;

public abstract class Pizza {

    String name;

    Dough dough;
    Sauce sauce;
    Veggies veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clam;

    public abstract void prepare();

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public void setName(String name) {
        this.name = name;
    }
}
