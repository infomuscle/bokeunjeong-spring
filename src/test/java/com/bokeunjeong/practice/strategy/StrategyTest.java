package com.bokeunjeong.practice.strategy;

import com.bokeunjeong.practice.strategy.behavior.fly.FlyRocketPowered;
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
