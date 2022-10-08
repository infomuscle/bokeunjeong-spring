package com.bokeunjeong.portfolio.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice("com.bokeunjeong.portfolio.controller")
public class PortfolioApiControllerAdvice {
    @ExceptionHandler
    public ResponseEntity handleException(Exception e) {
        log.info(e.getMessage(), e);
        return ResponseEntity.ok(e.getMessage());
    }
}
