package com.bokeunjeong.portfolio.controller;

import com.bokeunjeong.portfolio.model.entity.Contact;
import com.bokeunjeong.portfolio.model.entity.Link;
import com.bokeunjeong.portfolio.model.entity.Project;
import com.bokeunjeong.portfolio.model.entity.Skill;
import com.bokeunjeong.portfolio.service.PortfolioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

        Map<String, List<Project>> projects = portfolioService.getProjectsByType();
        Map<String, List<Skill>> workSkills = portfolioService.getSkillsByTypeOf("Work");
        Map<String, List<Skill>> personalSkills = portfolioService.getSkillsByTypeOf("Personal");
        Map<Boolean, List<Link>> linksByColumn = portfolioService.getAllLinks();

        log.info(projects.toString());
        model.addAttribute("introductions", portfolioService.getAllIntroductions());
        model.addAttribute("link1", linksByColumn.getOrDefault(true, null));
        model.addAttribute("link2", linksByColumn.getOrDefault(false, null));
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

    @PostMapping("/email")
    public @ResponseBody
    String sendEmail() {

        return "OK";
    }
}
