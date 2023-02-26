package com.bokeunjeong.portfolio.controller.interceptor;

import com.bokeunjeong.portfolio.model.entity.HttpInterface;
import com.bokeunjeong.portfolio.repository.jpa.HttpInterfaceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
@RequiredArgsConstructor
public class PortfolioApiInterceptor implements HandlerInterceptor {

    private final HttpInterfaceRepository httpInterfaceRepository;

    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        httpInterfaceRepository.save(new HttpInterface(request));
    }
}
