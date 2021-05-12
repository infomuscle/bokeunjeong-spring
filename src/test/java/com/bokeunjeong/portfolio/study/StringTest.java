package com.bokeunjeong.portfolio.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisplayName("String 테스트")
public class StringTest {

    private final Logger log = (Logger) LoggerFactory.getLogger(StringTest.class);

    @Test
    @DisplayName("String equals() && hashCode() 테스트")
    public void _01_StringTest() {

        String a = "12345";
        String b = new String("12345");

        log.info("a.equals(b): {}", a.equals(b));       // true
        log.info("a == b: {}", a == b);                 // false
        log.info("a.hashCode(): {}", a.hashCode());     // 46792755
        log.info("b.hashCode(): {}", b.hashCode());     // 46792755

    }

    @Test
    @DisplayName("MyObject equals() && hashCode() 테스트")
    public void _02_StringTest() {

        MyObject a = new MyObject();
        MyObject b = new MyObject();

        log.info("a.equals(b): {}", a.equals(b));       // false
        log.info("a == b: {}", a == b);                 // false
        log.info("a.hashCode(): {}", a.hashCode());     // 694823333
        log.info("b.hashCode(): {}", b.hashCode());     // 1562549798

    }

    static class MyObject {
        private Long id;
    }

}
