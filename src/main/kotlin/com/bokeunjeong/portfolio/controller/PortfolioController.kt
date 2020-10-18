package com.bokeunjeong.portfolio.controller

import com.bokeunjeong.portfolio.dto.PortfolioProjectDto
import com.bokeunjeong.portfolio.repository.PortfolioProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class PortfolioController {

    @Autowired
    lateinit var portfolioProjectRepository: PortfolioProjectRepository

    @GetMapping
    fun index(model: Model): String {

        var projects: List<PortfolioProjectDto> = portfolioProjectRepository.findAll()
        model.addAttribute("projects", projects)

        return "index"
    }
}