package com.bokeunjeong.portfolio.controller.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@Slf4j
@RestControllerAdvice("com.bokeunjeong.portfolio.controller")
public class PortfolioApiControllerAdvice {
    @ExceptionHandler
    public ResponseEntity handleException(Exception e) throws IOException {
        log.info(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
