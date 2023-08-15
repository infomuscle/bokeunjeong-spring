package com.bokeunjeong.portfolio.controller;

import com.bokeunjeong.portfolio.model.dto.EmailDto;
import com.bokeunjeong.portfolio.model.dto.PortfolioResponse;
import com.bokeunjeong.portfolio.service.PortfolioApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PortfolioApiController {

    private final PortfolioApiService portfolioApiService;

    @GetMapping("/api/v1/portfolio")
    public PortfolioResponse getPortfolio() {
        return portfolioApiService.getPortfolio();
    }

    @GetMapping("/api/v1/portfolio/resume")
    public ResponseEntity<Resource> getPortfolioResume() {
        Resource resource = portfolioApiService.getPortfolioResume();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(resource.getFilename()).build());

        return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
    }

    @PostMapping("/api/v1/portfolio/email")
    public String sendEmail(@RequestBody EmailDto emailDto) {
        log.info("PortfolioApiController.sendEmail# emailDto: {} ", emailDto);

        portfolioApiService.sendEmail(emailDto);

        return "OK";
    }
}
