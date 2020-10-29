package com.bokeunjeong.portfolio.controller

import com.bokeunjeong.portfolio.dto.PortfolioProjectDto
import com.bokeunjeong.portfolio.dto.PortfolioSkillDto
import com.bokeunjeong.portfolio.dto.ProjectContactDto
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

        var contacts: MutableList<ProjectContactDto> = getContacts()
        model.addAttribute("contacts", contacts)

        return "index"
    }

    private fun getSkills(): HashMap<String, MutableList<PortfolioSkillDto>> {

        var skills = HashMap<String, MutableList<PortfolioSkillDto>>()
        for (skill: PortfolioSkillDto in portfolioService.findAllSkills()) {
            if (!skills.containsKey(skill.type)) {
                skills.put(skill.type, mutableListOf<PortfolioSkillDto>())
            }
            var list: MutableList<PortfolioSkillDto>? = skills.get(skill.type)
            list?.add(skill)
        }
        log.info(skills.toString())

        return skills
    }

    private fun getContacts(): MutableList<ProjectContactDto> {
        var contacts: MutableList<ProjectContactDto> = mutableListOf()

        var icons: List<String> = listOf("fa-map-marked-alt", "fa-envelope", "fa-mobile-alt")
        var types: List<String> = listOf("address", "email", "phone")
        var details: List<String> = listOf("Samhaksa Street, Songpa, Seoul, KR", "infomuscle10@gmail.com", "+82 10-6301-1628")

        for (i in 0..2) {
            var contact = ProjectContactDto()
            contact.icon = icons[i]
            contact.type = types[i]
            contact.detail = details[i]

            contacts.add(contact)
        }

        return contacts
    }
}

