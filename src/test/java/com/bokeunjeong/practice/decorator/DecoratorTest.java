package com.bokeunjeong.practice.decorator;

import com.bokeunjeong.practice.pattern.decorator.beverage.Beverage;
import com.bokeunjeong.practice.pattern.decorator.beverage.DarkRoast;
import com.bokeunjeong.practice.pattern.decorator.beverage.Espresso;
import com.bokeunjeong.practice.pattern.decorator.beverage.HouseBlend;
import com.bokeunjeong.practice.pattern.decorator.condiment.Mocha;
import com.bokeunjeong.practice.pattern.decorator.condiment.Soy;
import com.bokeunjeong.practice.pattern.decorator.condiment.Whip;
import org.junit.jupiter.api.Test;

public class DecoratorTest {

    @Test
    void test1() {

        Beverage beverage = new Espresso();
        System.out.println(String.format("%s $%s", beverage.getDescription(), beverage.cost()));

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(String.format("%s $%s", beverage2.getDescription(), beverage2.cost()));

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(String.format("%s $%s", beverage3.getDescription(), beverage3.cost()));
    }
}
