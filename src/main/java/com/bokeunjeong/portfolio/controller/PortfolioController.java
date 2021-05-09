package com.bokeunjeong.portfolio.controller;

import com.bokeunjeong.portfolio.model.Contact;
import com.bokeunjeong.portfolio.model.Project;
import com.bokeunjeong.portfolio.model.Skill;
import com.bokeunjeong.portfolio.service.PortfolioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class PortfolioController {

    private final PortfolioService portfolioService;

    @Autowired
    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }


    @GetMapping("/")
    public String index(Model model) {

        long startedAt = System.currentTimeMillis();
        Map<String, List<Project>> projects = portfolioService.getProjectsByType();
        long finishedAt = System.currentTimeMillis();
        log.info("전체 조회 후 맵 분류 소요시간: {}", finishedAt - startedAt);

        startedAt = System.currentTimeMillis();
        List<Project> workProjects = portfolioService.getProjectsOf("Work");
        List<Project> personalProjects = portfolioService.getProjectsOf("Personal");
        finishedAt = System.currentTimeMillis();
        log.info("각각 조회 소요시간: {}", finishedAt - startedAt);

        Map<String, List<Skill>> workSkills = portfolioService.getSkillsByTypeOf("Work");
        Map<String, List<Skill>> personalSkills = portfolioService.getSkillsByTypeOf("Personal");


        log.info(projects.toString());
        model.addAttribute("workProjects", projects.get("Work"));
        model.addAttribute("sideProjects", projects.get("Personal"));
        model.addAttribute("workSkills", workSkills);
        model.addAttribute("personalSkills", personalSkills);
        model.addAttribute("contacts", portfolioService.getContacts());

        return "index";
    }

    @GetMapping("/contacts")
    public @ResponseBody
    List<Contact> listContacts() {

        return portfolioService.getContacts();
    }

}
