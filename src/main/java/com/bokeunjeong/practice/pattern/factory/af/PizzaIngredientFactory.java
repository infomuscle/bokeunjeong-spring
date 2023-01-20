package com.bokeunjeong.practice.pattern.factory.af;

import com.bokeunjeong.practice.pattern.factory.af.ingredient.cheese.Cheese;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.clams.Clams;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.dough.Dough;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.pepperoni.Pepperoni;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.sauce.Sauce;
import com.bokeunjeong.practice.pattern.factory.af.ingredient.veggies.Veggies;

public interface PizzaIngredientFactory {

    public Dough createDough();

    public Sauce createSauce();

    public Cheese createCheese();

    public Veggies[] createVeggies();

    public Pepperoni createPepperoni();

    public Clams createClam();

}
