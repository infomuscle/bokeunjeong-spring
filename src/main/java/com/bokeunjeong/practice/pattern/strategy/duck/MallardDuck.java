package com.bokeunjeong.practice.pattern.strategy.duck;

import com.bokeunjeong.practice.pattern.strategy.behavior.fly.FlyWithWings;
import com.bokeunjeong.practice.pattern.strategy.behavior.quack.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a MallardDuck.");
    }
}
