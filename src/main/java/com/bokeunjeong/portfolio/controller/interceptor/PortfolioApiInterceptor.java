package com.bokeunjeong.portfolio.controller.interceptor;

import com.bokeunjeong.portfolio.model.entity.HttpInterface;
import com.bokeunjeong.portfolio.repository.jpa.HttpInterfaceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
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
        log.info("PortfolioApiInterceptor.afterCompletion# request.getContextPath(): {} ", request.getContextPath());
        log.info("PortfolioApiInterceptor.afterCompletion# request.getServletContext(): {} ", request.getServletContext());
        log.info("PortfolioApiInterceptor.afterCompletion# request.getHttpServletMapping(): {} ", request.getHttpServletMapping());
        log.info("PortfolioApiInterceptor.afterCompletion# request.getRequestURI(): {} ", request.getRequestURI());
        log.info("PortfolioApiInterceptor.afterCompletion# request.getRequestURL(): {} ", request.getRequestURL());
        log.info("PortfolioApiInterceptor.afterCompletion# request.getRemoteHost(): {} ", request.getRemoteHost());
        log.info("PortfolioApiInterceptor.afterCompletion# request.getLocalPort(): {} ", request.getLocalPort());
        log.info("PortfolioApiInterceptor.afterCompletion# request.getServerPort(): {} ", request.getServerPort());
        log.info("PortfolioApiInterceptor.afterCompletion# request.getRemotePort(): {} ", request.getRemotePort());
        log.info("PortfolioApiInterceptor.afterCompletion# request.getLocalAddr(): {} ", request.getLocalAddr());
        log.info("PortfolioApiInterceptor.afterCompletion# request.getRemoteAddr(): {} ", request.getRemoteAddr());
        log.info("PortfolioApiInterceptor.afterCompletion# request.getPathInfo(): {} ", request.getPathInfo());
        log.info("PortfolioApiInterceptor.afterCompletion# request.getQueryString(): {} ", request.getQueryString());
        log.info("PortfolioApiInterceptor.afterCompletion# request.getCookies(): {} ", request.getCookies());

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            log.info("PortfolioApiInterceptor.afterCompletion# {}: {} ", headerName, headerValue);
        }

        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            String attributeValue = request.getHeader(attributeName);
            log.info("PortfolioApiInterceptor.afterCompletion# {}: {} ", attributeName, attributeValue);
        }

        httpInterfaceRepository.save(new HttpInterface(request));
    }
}
