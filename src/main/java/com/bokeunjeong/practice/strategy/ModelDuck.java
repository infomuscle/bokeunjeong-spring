package com.bokeunjeong.practice.strategy;

import com.bokeunjeong.practice.strategy.behavior.fly.FlyNoWay;
import com.bokeunjeong.practice.strategy.behavior.quack.Quack;

public class ModelDuck extends Duck {
    public ModelDuck() {
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("This is ModelDuck.");
    }
}
