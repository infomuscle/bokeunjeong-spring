package com.bokeunjeong.portfolio.controller;

import com.bokeunjeong.portfolio.model.dto.PortfolioResponse;
import com.bokeunjeong.portfolio.service.PortfolioApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PortfolioApiController {
    private final PortfolioApiService portfolioApiService;

    @GetMapping("/api/v1/portfolio")
    public PortfolioResponse getPortfolio() {
        try {
            return portfolioApiService.getPortfolio();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/api/v1/portfolio/resume")
    public ResponseEntity<Resource> getPortfolioResume() {
        try {
            Resource resource = portfolioApiService.getPortfolioResume();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename(resource.getFilename()).build());
            headers.setContentLength(resource.getFile().length());
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

            return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/api/v1/portfolio/email")
    public String sendEmail() {

        return "OK";
    }
}
