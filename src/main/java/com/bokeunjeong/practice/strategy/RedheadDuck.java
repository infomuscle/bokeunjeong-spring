package com.bokeunjeong.practice.strategy;

import com.bokeunjeong.practice.strategy.behavior.fly.FlyWithWings;
import com.bokeunjeong.practice.strategy.behavior.quack.Quack;

public class RedheadDuck extends Duck {
    public RedheadDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a RedheadDuck.");
    }
}
