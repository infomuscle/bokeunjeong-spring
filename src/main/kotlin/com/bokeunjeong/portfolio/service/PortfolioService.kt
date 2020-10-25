package com.bokeunjeong.portfolio.service

import com.bokeunjeong.portfolio.dto.PortfolioProjectDto
import com.bokeunjeong.portfolio.dto.PortfolioSkillDto
import com.bokeunjeong.portfolio.repository.PortfolioProjectRepository
import com.bokeunjeong.portfolio.repository.PortfolioSkillRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.ui.Model

@Service
class PortfolioService {

    @Autowired
    lateinit var portfolioProjectRepository: PortfolioProjectRepository

    @Autowired
    lateinit var portfolioSkillRepository: PortfolioSkillRepository

    @Transactional
    fun saveProject(project: PortfolioProjectDto): PortfolioProjectDto {

        portfolioProjectRepository.save(project)
        return project
    }

    @Transactional
    fun saveSkill(skill: PortfolioSkillDto): PortfolioSkillDto {

        portfolioSkillRepository.save(skill)
        return skill
    }

    fun findAllProjects(): List<PortfolioProjectDto> {
        return portfolioProjectRepository.findAll()
    }

    fun findAllSkills(): List<PortfolioSkillDto> {
        return portfolioSkillRepository.findAll()
    }
}