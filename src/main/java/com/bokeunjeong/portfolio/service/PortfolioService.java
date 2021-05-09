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
import java.util.Optional;

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


    public List<Project> getProjects() {
        return portfolioProjectRepository.findAllByDisplayOrderByIdDesc(true);
    }

    public Project getProjectOf(String id) throws Exception {

        Optional<Project> project = portfolioProjectRepository.findById(id);

        return Optional.ofNullable(project).get().orElseThrow(Exception::new);

    }

    public List<Skill> getSkills() {
        return portfolioSkillRepository.findAllByDisplay(true);
    }

    public List<Contact> getContacts() {
        return portfolioContactRepository.findAll();
    }

}
