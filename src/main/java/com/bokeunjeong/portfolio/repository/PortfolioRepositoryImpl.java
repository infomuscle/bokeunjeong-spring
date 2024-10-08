package com.bokeunjeong.portfolio.repository;

import com.bokeunjeong.portfolio.model.dto.*;
import com.bokeunjeong.portfolio.repository.jpa.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PortfolioRepositoryImpl implements PortfolioRepository {

    private final PortfolioIntroductionRepository portfolioIntroductionRepository;
    private final PortfolioLinkRepository portfolioLinkRepository;
    private final PortfolioProjectRepository portfolioProjectRepository;
    private final PortfolioSkillRepository portfolioSkillRepository;
    private final PortfolioContactRepository portfolioContactRepository;

    @Override
    public List<IntroductionDto> findIntroductions() {
        return portfolioIntroductionRepository.findAllByDisplay(true).stream().map(IntroductionDto::new).collect(Collectors.toList());
    }

    @Override
    public List<LinkDto> findLinks() {
        return portfolioLinkRepository.findAllByDisplay(true).stream().map(LinkDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ProjectDto> findProjets() {
        return portfolioProjectRepository.findAllToDisplay().stream().map(ProjectDto::new).collect(Collectors.toList());
    }

    @Override
    public List<SkillDto> findSkills() {
        return portfolioSkillRepository.findAllToDisplay().stream().map(SkillDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> findContacts() {
        return portfolioContactRepository.findAll().stream().map(ContactDto::new).collect(Collectors.toList());
    }
}
