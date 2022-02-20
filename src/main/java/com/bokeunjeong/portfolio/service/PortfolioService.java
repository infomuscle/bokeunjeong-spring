package com.bokeunjeong.portfolio.service;

import com.bokeunjeong.portfolio.model.entity.*;
import com.bokeunjeong.portfolio.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioProjectRepository portfolioProjectRepository;
    private final PortfolioSkillRepository portfolioSkillRepository;
    private final PortfolioContactRepository portfolioContactRepository;
    private final PortfolioIntroductionRepository portfolioIntroductionRepository;
    private final PortfolioLinkRepository portfolioLinkRepository;

    /**
     * 전체 소개 조회
     */
    public List<Introduction> getAllIntroductions() {
        return portfolioIntroductionRepository.findAllByDisplay(true);
    }

    /**
     * 전체 링크 조회
     */
    public Map<Boolean, List<Link>> getAllLinks() {
        List<Link> links = portfolioLinkRepository.findAllByDisplay(true);
        return links.stream().collect(Collectors.partitioningBy(link -> link.getColumn() == 1));
    }

    /**
     * 전체 프로젝트 조회 후 유형별로 분류한 맵 리턴
     */
    public Map<String, List<Project>> getProjectsByType() {
        return portfolioProjectRepository.findAllByDisplayOrderByIdDesc(true).stream().collect(groupingBy(Project::getType));
    }

    public Map<String, List<Skill>> getSkillsByTypeOf(String category) {
        return portfolioSkillRepository.findAllByCategoryAndDisplay(category, true).stream().collect(groupingBy(Skill::getType));
    }

    /**
     * 전체 연락처 조회
     */
    public List<Contact> getContacts() {
        return portfolioContactRepository.findAll();
    }

}
