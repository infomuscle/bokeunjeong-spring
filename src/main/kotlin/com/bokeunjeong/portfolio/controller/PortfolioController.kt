package com.bokeunjeong.portfolio.controller

import com.bokeunjeong.portfolio.dto.PortfolioProjectDto
import com.bokeunjeong.portfolio.dto.PortfolioSkillDto
import com.bokeunjeong.portfolio.service.PortfolioService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class PortfolioController {

    val log = LoggerFactory.getLogger(javaClass)

    @Autowired
    lateinit var portfolioService: PortfolioService

    var levels = mapOf(Pair("Advanced", 3), Pair("Intermediate", 2), Pair("Beginner", 1))

    @GetMapping
    fun index(model: Model): String {

        var projects: List<PortfolioProjectDto> = portfolioService.findAllProjects()
        model.addAttribute("projects", projects)

        var skills: HashMap<String, MutableList<PortfolioSkillDto>> = getSkills()
        model.addAttribute("skills", skills.entries)
        return "index"
    }

    private fun getSkills(): HashMap<String, MutableList<PortfolioSkillDto>> {

        var skills = HashMap<String, MutableList<PortfolioSkillDto>>()
        for (skill in portfolioService.findAllSkills()) {
            if (!skills.containsKey(skill.type)) {
                skills.put(skill.type, mutableListOf<PortfolioSkillDto>())
            }
            var list: MutableList<PortfolioSkillDto>? = skills.get(skill.type)
            list?.add(skill)
        }
        log.info(skills.toString())

        return skills
    }
}

