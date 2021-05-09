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


    public List<Project> getAllProjects() {
        return portfolioProjectRepository.findAllByDisplayOrderByIdDesc(true);
    }

    // DB 두번 찌르기 vs 한번찌르고 맵으로 분류 뭐가 더 빠를까?
    public Map<String, List<Project>> getProjectsByType() {
        return portfolioProjectRepository.findAllByDisplayOrderByIdDesc(true).stream().collect(groupingBy(Project::getType));
    }

    public Project getProjectOf(String id) throws Exception {

        Optional<Project> project = portfolioProjectRepository.findById(id);

        return Optional.ofNullable(project).get().orElseThrow(Exception::new);

    }

    public List<Project> getProjectsOf(String type) {
        return portfolioProjectRepository.findAllByTypeOrderByIdDesc(type);
    }

    public List<Skill> getSkills() {
        return portfolioSkillRepository.findAllByDisplay(true);
    }

    public List<Contact> getContacts() {
        return portfolioContactRepository.findAll();
    }

}
