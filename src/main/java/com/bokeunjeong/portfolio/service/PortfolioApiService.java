package com.bokeunjeong.portfolio.service;

import com.bokeunjeong.portfolio.model.dto.*;
import com.bokeunjeong.portfolio.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PortfolioApiService {

    private final PortfolioIntroductionRepository portfolioIntroductionRepository;
    private final PortfolioProjectRepository portfolioProjectRepository;
    private final PortfolioSkillRepository portfolioSkillRepository;
    private final PortfolioContactRepository portfolioContactRepository;
    private final PortfolioLinkRepository portfolioLinkRepository;
    private final ResourceLoader resourceLoader;

    public PortfolioResponse getPortfolio() {
        PortfolioResponse response = new PortfolioResponse();
        response.setIntroductions(getIntroductions());
        response.setLinks(getLinks());
        response.setProjects(new ProjectResult(getProjects()));
        response.setSkills(getSkills());
        response.setContacts(getContacts());

        return response;
    }

    private List<IntroductionDto> getIntroductions() {
        return portfolioIntroductionRepository.findAllByDisplay(true).stream().map(IntroductionDto::new).collect(Collectors.toList());
    }

    private List<LinkDto> getLinks() {
        return portfolioLinkRepository.findAllByDisplay(true).stream().map(LinkDto::new).collect(Collectors.toList());
    }

    private List<ProjectDto> getProjects() {
        return portfolioProjectRepository.findAllByDisplayOrderByIdDesc(true).stream().map(ProjectDto::new).collect(Collectors.toList());
    }

    private List<SkillDto> getSkills() {
        return portfolioSkillRepository.findAllByDisplay(true).stream().map(SkillDto::new).collect(Collectors.toList());
    }

    private List<ContactDto> getContacts() {
        return portfolioContactRepository.findAll().stream().map(ContactDto::new).collect(Collectors.toList());
    }

    public Resource getPortfolioResume() {
        Resource resource = resourceLoader.getResource("classpath:static/resume_bokeunjeong.pdf");
        if (resource.exists()) {
            return resource;
        }

        throw new RuntimeException("Cannt find file.");
    }
}
