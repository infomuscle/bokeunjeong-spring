package com.bokeunjeong.practice.pattern.strategy.duck;

import com.bokeunjeong.practice.pattern.strategy.behavior.fly.FlyNoWay;
import com.bokeunjeong.practice.pattern.strategy.behavior.quack.Quack;

public class ModelDuck extends Duck {
    public ModelDuck() {
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a ModelDuck.");
    }
}
