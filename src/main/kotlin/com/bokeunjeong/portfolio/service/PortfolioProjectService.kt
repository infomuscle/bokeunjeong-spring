package com.bokeunjeong.portfolio.service

import com.bokeunjeong.portfolio.dto.PortfolioProjectDto
import com.bokeunjeong.portfolio.repository.PortfolioProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PortfolioProjectService {

    @Autowired
    lateinit var portfolioProjectRepository: PortfolioProjectRepository

    @Transactional
    fun save(project: PortfolioProjectDto): PortfolioProjectDto {

        portfolioProjectRepository.save(project)
        return project
    }
}