package com.bokeunjeong.portfolio.controller;

import com.bokeunjeong.portfolio.model.dto.PortfolioResponse;
import com.bokeunjeong.portfolio.service.PortfolioApiService;
import com.bokeunjeong.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PortfolioApiController {

    private final PortfolioService portfolioService;
    private final PortfolioApiService portfolioApiService;

    @GetMapping("/api/v1/portfolio")
    public PortfolioResponse getPortfolio() {
        try {
            return portfolioApiService.getPortfolio();
        } catch (Exception e) {
            return null;
        }
    }
}
