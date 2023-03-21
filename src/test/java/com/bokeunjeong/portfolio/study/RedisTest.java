package com.bokeunjeong.portfolio.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;

@Slf4j
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    // @Test
    void test1() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("test-key-spring", "test-value-spring");

        String key = "topQueries";

        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.incrementScore(key, "jpa", 1);
        zSetOperations.incrementScore(key, "redis", 1);
        zSetOperations.incrementScore(key, "jpa", 1);
        zSetOperations.incrementScore(key, "jpa", 1);
        zSetOperations.incrementScore(key, "rabbitmq", 1);

        Set<ZSetOperations.TypedTuple<String>> topQueries = zSetOperations.reverseRangeByScoreWithScores(key, 0, 9);
        for (ZSetOperations.TypedTuple<String> topQuery : topQueries) {
            log.info("RedisTest.test1# topQuery: {}, {} ", topQuery.getScore(), topQuery.getValue());
        }
    }
}
