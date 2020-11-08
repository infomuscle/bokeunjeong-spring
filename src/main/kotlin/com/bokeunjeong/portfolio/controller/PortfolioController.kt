package com.bokeunjeong.portfolio.controller

import com.bokeunjeong.portfolio.dto.PortfolioContactDto
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

    var colors: Map<String, String> = mapOf(
            Pair("Language", "bg-info"),
            Pair("Framework", "bg-success"),
            Pair("Database", "bg-danger"),
            Pair("Tool", "bg-primary"),
            Pair("Design", "bg-warning")
    )

    @GetMapping
    fun index(model: Model): String {

        var projects: List<PortfolioProjectDto> = portfolioService.findAllProjects()
        model.addAttribute("projects", projects)

        var skills: LinkedHashMap<String, MutableList<PortfolioSkillDto>> = getSkills()
        model.addAttribute("skills", skills.entries)

        var contacts: List<PortfolioContactDto> = portfolioService.findAllContacts()
        model.addAttribute("contacts", contacts)

        return "index"
    }

    private fun getSkills(): LinkedHashMap<String, MutableList<PortfolioSkillDto>> {

        var skills = LinkedHashMap<String, MutableList<PortfolioSkillDto>>()
        for (skill: PortfolioSkillDto in portfolioService.findAllUsingSkills()) {
            skill.color = colors.get(skill.type).toString()
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

