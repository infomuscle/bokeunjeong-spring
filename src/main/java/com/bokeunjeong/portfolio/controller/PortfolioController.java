package com.bokeunjeong.portfolio.controller;

import com.bokeunjeong.portfolio.model.Contact;
import com.bokeunjeong.portfolio.service.PortfolioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

        model.addAttribute("projects", portfolioService.getProjects());
        model.addAttribute("skills", portfolioService.getSkills());
        model.addAttribute("contacts", portfolioService.getContacts());

        return "index";
    }

    @GetMapping("/contacts")
    public @ResponseBody
    List<Contact> listContacts() {

        return portfolioService.getContacts();
    }

}
