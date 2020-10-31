package com.bokeunjeong.portfolio.repository

import com.bokeunjeong.portfolio.dto.PortfolioSkillDto
import org.springframework.data.jpa.repository.JpaRepository


interface PortfolioSkillRepository : JpaRepository<PortfolioSkillDto, Int> {
    fun findByNo(no: Int): List<PortfolioSkillDto>
    fun findByName(name: String): List<PortfolioSkillDto>
    fun findByType(type: String): List<PortfolioSkillDto>
    fun findByUseYn(useYn: String): List<PortfolioSkillDto>
}