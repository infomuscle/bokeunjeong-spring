package com.bokeunjeong.practice.pattern.factory.af;

import com.bokeunjeong.practice.pattern.factory.af.ingredient.cheese.Cheese;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.cheese.MozzarellaCheese;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.clams.Clams;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.clams.FrozenClams;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.dough.Dough;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.dough.ThickCrustDough;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.pepperoni.Pepperoni;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.pepperoni.SlicedPepperoni;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.sauce.PlumTomatoSauce;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.sauce.Sauce;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.veggies.BlackOlives;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.veggies.EggPlant;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.veggies.Spinach;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.veggies.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {new BlackOlives(), new Spinach(), new EggPlant()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FrozenClams();
    }
}
