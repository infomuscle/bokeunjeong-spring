package com.bokeunjeong.portfolio.controller;

import com.bokeunjeong.portfolio.model.Contact;
import com.bokeunjeong.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PortfolioController {

    private final PortfolioService portfolioService;

    @Autowired
    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }


    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/contacts")
    public @ResponseBody
    List<Contact> listContacts() {

        return portfolioService.getContacts();
    }

}
