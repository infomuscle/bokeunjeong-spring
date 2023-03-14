package com.bokeunjeong.portfolio.study;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

public class CallByValueReferenceTest {

    @Test
    void callByValuePrimitiveTest() {
        int num = 0;
        System.out.println("before num: " + num);
        plusOnePrimitive(num);
        System.out.println("after num: " + num);
    }

    void plusOnePrimitive(int num) {
        num = 1;
    }

    @Test
    void callByValueWrapperTest() {
        Integer num = 0;
        System.out.println(System.identityHashCode(num));
        System.out.println("before num: " + num);
        plusOneWrapper(num);
        System.out.println("after num: " + num);
    }

    void plusOneWrapper(Integer num) {
        System.out.println(System.identityHashCode(num));
        num = 1;
    }

    @Test
    void callByValueClassTest() {
        Number num = new Number(0);
        System.out.println("before num: " + num);
        plusOneClass(num);
        System.out.println("after num: " + num);
    }

    void plusOneClass(Number num) {
        num.value = 1;
    }

    @Test
    void testCallByValueString() {
        String num = "0";
        System.out.println("before num: " + num);
        plusOneString(num);
        System.out.println("after num: " + num);
    }

    void plusOneString(String num) {
        num = "1";
    }


    @Data
    @AllArgsConstructor
    static class Number {
        private int value;
    }
}

