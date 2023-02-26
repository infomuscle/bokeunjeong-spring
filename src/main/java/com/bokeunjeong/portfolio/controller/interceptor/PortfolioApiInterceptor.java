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
import java.util.Enumeration;

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
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            log.info("PortfolioApiInterceptor.afterCompletion# header {}: {} ", headerName, headerValue);
        }

        log.info("PortfolioApiInterceptor.afterCompletion# Attributes");
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            Object attributeValue = request.getAttribute(attributeName);
            log.info("PortfolioApiInterceptor.afterCompletion# attribute {}: {} ", attributeName, attributeValue);
        }

        httpInterfaceRepository.save(new HttpInterface(request));
    }
}
