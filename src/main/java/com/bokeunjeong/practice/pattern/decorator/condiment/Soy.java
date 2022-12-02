package com.bokeunjeong.practice.pattern.decorator.condiment;

import com.bokeunjeong.practice.pattern.decorator.beverage.Beverage;

import java.util.Map;

public class Soy extends CondimentDecorator {

    private static Map<Size, Double> COSTS = Map.of(Size.TALL, .10, Size.GRANDE, .15, Size.VENTI, .20);

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return String.format("%s, %s", beverage.getDescription(), "Soy");
    }

    @Override
    public double cost() {
        return beverage.cost() + COSTS.get(beverage.getSize());
    }
}
