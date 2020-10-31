package com.bokeunjeong.portfolio.repository

import com.bokeunjeong.portfolio.dto.PortfolioContactDto
import org.springframework.data.jpa.repository.JpaRepository

interface PortfolioContactRepository : JpaRepository<PortfolioContactDto, Int> {
    fun findByType(type: String): List<PortfolioContactDto>
}