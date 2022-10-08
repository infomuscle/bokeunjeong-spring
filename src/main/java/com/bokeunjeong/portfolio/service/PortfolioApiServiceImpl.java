package com.bokeunjeong.portfolio.service;

import com.bokeunjeong.portfolio.model.dto.PortfolioResponse;
import com.bokeunjeong.portfolio.model.dto.ProjectResult;
import com.bokeunjeong.portfolio.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PortfolioApiServiceImpl implements PortfolioApiService {

    private final ResourceLoader resourceLoader;
    private final PortfolioRepository portfolioRepository;

    public PortfolioResponse getPortfolio() {
        PortfolioResponse response = new PortfolioResponse();
        response.setIntroductions(portfolioRepository.findIntroductions());
        response.setLinks(portfolioRepository.findLinks());
        response.setProjects(new ProjectResult(portfolioRepository.findProjets()));
        response.setSkills(portfolioRepository.findSkills());
        response.setContacts(portfolioRepository.findContacts());

        return response;
    }

    public Resource getPortfolioResume() {
        Resource resource = resourceLoader.getResource("classpath:static/resume_bokeunjeong.pdf");
        if (resource.exists()) {
            return resource;
        }

        throw new RuntimeException("Cannt find file.");
    }
}
