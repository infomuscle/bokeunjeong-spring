package com.bokeunjeong.portfolio.repository

import com.bokeunjeong.portfolio.dto.PortfolioProjectDto
import org.springframework.data.jpa.repository.JpaRepository


interface PortfolioProjectRepository : JpaRepository<PortfolioProjectDto, Int> {
    fun findByNo(no: Int): List<PortfolioProjectDto>
    fun findByName(name: String): List<PortfolioProjectDto>
}