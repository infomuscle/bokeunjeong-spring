package com.bokeunjeong.portfolio.study;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

public class CallByValueReferenceTest {

    @Test
    void callByValuePrimitiveTest() {
        int num = 0;
        System.out.println("before num: " + num);
        plusOne(num);
        System.out.println("after num: " + num);
    }

    void plusOne(int num) {
        num += 1;
    }

    @Test
    void callByValueWrapperTest() {
        Integer num = 0;
        System.out.println("1.callByValueTest# before num: " + System.identityHashCode(num));
        plusOne(num);
        System.out.println("4.callByValueTest# after num: " + System.identityHashCode(num));
    }

    void plusOne(Integer num) {
        System.out.println("2.plusOne# before num: " + System.identityHashCode(num));
        num += 1;
        System.out.println("3.plusOne# after num: " + System.identityHashCode(num));
        System.out.println("3-1.plusOne# after num: " + System.identityHashCode(1));
    }

    @Test
    void callByValueClassTest() {
        Number num = new Number(0);
        System.out.println("before num: " + num);
        plusOne(num);
        System.out.println("after num: " + num);
    }

    void plusOne(Number num) {
        num.value += 1;
    }

    @Test
    void callByValueStringTest() {
        String num = "0";
        System.out.println("before num: " + num);
        plusOne(num);
        System.out.println("after num: " + num);
    }

    void plusOne(String num) {
        num += "1";
    }


    @Data
    @AllArgsConstructor
    static class Number {
        private int value;
    }
}

