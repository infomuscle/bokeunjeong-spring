package com.bokeunjeong.practice.strategy.behavior.quack;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< Quiet >>");
    }
}
