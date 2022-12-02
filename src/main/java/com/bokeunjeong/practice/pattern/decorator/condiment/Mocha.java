package com.bokeunjeong.practice.pattern.decorator.condiment;

import com.bokeunjeong.practice.pattern.decorator.beverage.Beverage;

import java.util.Map;

public class Mocha extends CondimentDecorator {

    private static Map<Size, Double> COSTS = Map.of(Size.TALL, .20, Size.GRANDE, .25, Size.VENTI, .30);

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return String.format("%s, %s", beverage.getDescription(), "Mocha");
    }

    @Override
    public double cost() {
        return beverage.cost() + COSTS.get(beverage.getSize());
    }
}
