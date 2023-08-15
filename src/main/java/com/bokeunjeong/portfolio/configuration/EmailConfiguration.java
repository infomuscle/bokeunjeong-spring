package com.bokeunjeong.portfolio.configuration;

import com.bokeunjeong.portfolio.util.CryptoUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.nio.charset.StandardCharsets;
import java.util.Properties;

@Configuration
public class EmailConfiguration {

    @Bean
    public JavaMailSender javaMailSender(RedisTemplate<String, String> redisTemplate) {

        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();

        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.timeout", 10000);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.debug", true);

        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setUsername("infomuscle10@gmail.com");
        javaMailSender.setPassword(CryptoUtil.decrypt(valueOperations.get("gmail_password")));
        javaMailSender.setPort(587);
        javaMailSender.setJavaMailProperties(properties);
        javaMailSender.setDefaultEncoding(StandardCharsets.UTF_8.name());

        return javaMailSender;
    }
}
