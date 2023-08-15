package com.bokeunjeong.portfolio.configuration;

import com.bokeunjeong.portfolio.util.CryptoUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CryptoConfiguration {

    private final RedisTemplate<String, String> redisTemplate;

    @PostConstruct
    public void initializeCrypto() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();

        CryptoUtil.cryptoKey = valueOperations.get("crypto_key");
        CryptoUtil.cryptoIv = valueOperations.get("crypto_iv");
    }
}
