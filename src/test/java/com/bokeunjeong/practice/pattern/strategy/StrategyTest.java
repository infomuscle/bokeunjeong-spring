package com.bokeunjeong.practice.pattern.strategy;

import com.bokeunjeong.practice.pattern.strategy.behavior.fly.FlyRocketPowered;
import com.bokeunjeong.practice.pattern.strategy.duck.Duck;
import com.bokeunjeong.practice.pattern.strategy.duck.MallardDuck;
import com.bokeunjeong.practice.pattern.strategy.duck.ModelDuck;
import org.junit.jupiter.api.Test;

public class StrategyTest {


    @Test
    void test1() {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
