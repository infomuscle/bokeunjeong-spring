package com.bokeunjeong.practice.strategy;

import com.bokeunjeong.practice.strategy.behavior.fly.FlyBehavior;
import com.bokeunjeong.practice.strategy.behavior.quack.Quack;
import com.bokeunjeong.practice.strategy.behavior.quack.QuackBehavior;
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
        System.out.println("모든 오리는 물에 뜹니다. 가짜 오리도 뜨죠.");
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(Quack quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
