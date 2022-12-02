package com.bokeunjeong.practice.pattern.decorator.condiment;

import com.bokeunjeong.practice.pattern.decorator.beverage.Beverage;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return String.format("%s, %s", beverage.getDescription(), "Soy");
    }

    @Override
    public double cost() {
        return beverage.cost() + .15;
    }
}
