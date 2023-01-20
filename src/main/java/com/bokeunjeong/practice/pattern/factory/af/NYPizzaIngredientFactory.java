package com.bokeunjeong.practice.pattern.factory.af;

import com.bokeunjeong.practice.pattern.factory.af.ingredient.cheese.Cheese;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.cheese.ReggianoCheese;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.clams.Clams;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.clams.FreshClams;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.dough.Dough;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.dough.ThinCrustDough;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.pepperoni.Pepperoni;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.pepperoni.SlicedPepperoni;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.sauce.MarinaraSauce;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.sauce.Sauce;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.veggies.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }
}
