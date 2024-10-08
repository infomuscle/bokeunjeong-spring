package com.bokeunjeong.portfolio.configuration;

import com.bokeunjeong.portfolio.controller.interceptor.PortfolioApiInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfiguration implements WebMvcConfigurer {

    private final PortfolioApiInterceptor portfolioApiInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(portfolioApiInterceptor).addPathPatterns("/api/v1/**");
    }
}
