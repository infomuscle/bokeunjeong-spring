package com.bokeunjeong.practice.pattern.strategy.behavior.quack;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< Quiet >>");
    }
}
