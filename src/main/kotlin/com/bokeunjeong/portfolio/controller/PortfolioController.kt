package com.bokeunjeong.portfolio.controller

import com.bokeunjeong.portfolio.dto.PortfolioProjectDto
import com.bokeunjeong.portfolio.dto.PortfolioSkillDto
import com.bokeunjeong.portfolio.service.PortfolioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class PortfolioController {

    @Autowired
    lateinit var portfolioService: PortfolioService

    @GetMapping
    fun index(model: Model): String {

        var projects: List<PortfolioProjectDto> = portfolioService.findAllProjects()
        model.addAttribute("projects", projects)

        var skills: List<PortfolioSkillDto> = portfolioService.findAllSkills()
        model.addAttribute("skills", skills)

        return "index"
    }
}