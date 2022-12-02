package com.bokeunjeong.practice.strategy;

import com.bokeunjeong.practice.strategy.behavior.fly.FlyWithWings;
import com.bokeunjeong.practice.strategy.behavior.quack.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("저는 물오리입니다.");
    }
}
