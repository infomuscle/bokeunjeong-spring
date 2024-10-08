package com.bokeunjeong.practice.pattern.strategy.duck;

import com.bokeunjeong.practice.pattern.strategy.behavior.fly.FlyBehavior;
import com.bokeunjeong.practice.pattern.strategy.behavior.quack.QuackBehavior;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("Every Duck float, even DecoyDuck.");
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
