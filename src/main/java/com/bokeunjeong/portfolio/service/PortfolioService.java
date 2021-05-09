package com.bokeunjeong.portfolio.service;

import com.bokeunjeong.portfolio.model.Contact;
import com.bokeunjeong.portfolio.model.Project;
import com.bokeunjeong.portfolio.model.Skill;
import com.bokeunjeong.portfolio.repository.PortfolioContactRepository;
import com.bokeunjeong.portfolio.repository.PortfolioProjectRepository;
import com.bokeunjeong.portfolio.repository.PortfolioSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.groupingBy;

@Service
public class PortfolioService {

    private final PortfolioProjectRepository portfolioProjectRepository;
    private final PortfolioSkillRepository portfolioSkillRepository;
    private final PortfolioContactRepository portfolioContactRepository;

    @Autowired
    public PortfolioService(PortfolioProjectRepository portfolioProjectRepository, PortfolioSkillRepository portfolioSkillRepository, PortfolioContactRepository portfolioContactRepository) {
        this.portfolioProjectRepository = portfolioProjectRepository;
        this.portfolioSkillRepository = portfolioSkillRepository;
        this.portfolioContactRepository = portfolioContactRepository;
    }


    /**
     * 전체 프로젝트 조회
     */
   public List<Project> getAllProjects() {
        return portfolioProjectRepository.findAllByDisplayOrderByIdDesc(true);
    }

    /**
     * 전체 프로젝트 조회 후 유형별로 분류한 맵 리턴
     */
    public Map<String, List<Project>> getProjectsByType() {
        return portfolioProjectRepository.findAllByDisplayOrderByIdDesc(true).stream().collect(groupingBy(Project::getType));
    }

    /**
     * ID로 프로젝트 조회
     */
    public Project getProjectOf(String id) throws Exception {
        return Optional.ofNullable(portfolioProjectRepository.findById(id)).get().orElseThrow(Exception::new);

    }

    /**
     * TYPE으로 모든 프로젝트 조회
     */
    public List<Project> getProjectsOf(String type) {
        return portfolioProjectRepository.findAllByTypeOrderByIdDesc(type);
    }

    /**
     * 전체 기술 스택 조회
     */
    public List<Skill> getSkills() {
        return portfolioSkillRepository.findAllByDisplay(true);
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
