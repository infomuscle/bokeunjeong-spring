package com.bokeunjeong.portfolio.service;

import com.bokeunjeong.portfolio.model.dto.EmailDto;
import com.bokeunjeong.portfolio.model.dto.PortfolioResponse;
import org.springframework.core.io.Resource;

public interface PortfolioApiService {

    PortfolioResponse getPortfolio();

    Resource getPortfolioResume();

    void sendEmail(EmailDto emailDto);

}
