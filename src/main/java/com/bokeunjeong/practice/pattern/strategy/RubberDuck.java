package com.bokeunjeong.practice.pattern.strategy;

public class RubberDuck extends Duck {

    public RubberDuck() {
        this.flyBehavior = () -> System.out.println("I can't fly.");
        this.quackBehavior = () -> System.out.println("Squeak.");
    }

    @Override
    public void display() {
        System.out.println("I'm a RubberDuck.");
    }
}
