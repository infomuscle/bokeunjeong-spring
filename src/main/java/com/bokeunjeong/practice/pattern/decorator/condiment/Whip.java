package com.bokeunjeong.practice.pattern.decorator.condiment;

import com.bokeunjeong.practice.pattern.decorator.beverage.Beverage;

import java.util.Map;

public class Whip extends CondimentDecorator {

    private static Map<Size, Double> COSTS = Map.of(Size.TALL, .10, Size.GRANDE, .15, Size.VENTI, .20);

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return String.format("%s, %s", beverage.getDescription(), "Whip");
    }

    @Override
    public double cost() {
        return beverage.cost() + COSTS.get(beverage.getSize());
    }
}
