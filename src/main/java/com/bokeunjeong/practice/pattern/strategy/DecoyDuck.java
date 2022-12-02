package com.bokeunjeong.practice.pattern.strategy;

import com.bokeunjeong.practice.pattern.strategy.behavior.fly.FlyNoWay;
import com.bokeunjeong.practice.pattern.strategy.behavior.quack.MuteQuack;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new MuteQuack());
    }

    @Override
    public void display() {
        System.out.println("I'm a DecoyDuck.");
    }
}
