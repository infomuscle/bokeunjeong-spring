package com.bokeunjeong.practice.pattern.adapter;

import com.bokeunjeong.practice.pattern.adapter.duck.*;
import org.junit.jupiter.api.Test;

public class AdapterTest {

    @Test
    void test1() {
        Duck duck = new MallardDuck();

        Turkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println();
        System.out.println("The Duck says...");
        testDuck(duck);

        System.out.println();
        System.out.println("The TurkeyAdapter says...");
        testDuck(turkeyAdapter);
    }

    private void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
