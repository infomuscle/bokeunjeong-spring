package com.bokeunjeong.practice.pattern.adapter.duck;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TurkeyAdapter implements Duck {

    Turkey turkey;

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
