package com.bokeunjeong.portfolio.service

import com.bokeunjeong.portfolio.dto.PortfolioContactDto
import com.bokeunjeong.portfolio.dto.PortfolioProjectDto
import com.bokeunjeong.portfolio.dto.PortfolioSkillDto
import com.bokeunjeong.portfolio.repository.PortfolioContactRepository
import com.bokeunjeong.portfolio.repository.PortfolioProjectRepository
import com.bokeunjeong.portfolio.repository.PortfolioSkillRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PortfolioService {

    @Autowired
    lateinit var portfolioProjectRepository: PortfolioProjectRepository

    @Autowired
    lateinit var portfolioSkillRepository: PortfolioSkillRepository

    @Autowired
    lateinit var portfolioContactRepository: PortfolioContactRepository

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

    fun findAllContacts(): List<PortfolioContactDto> {
        return portfolioContactRepository.findAll()
    }
}