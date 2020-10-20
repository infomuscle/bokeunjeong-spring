package com.bokeunjeong.portfolio.dto

import lombok.Builder
import lombok.NoArgsConstructor
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@NoArgsConstructor
@Entity(name = "skill")
class PortfolioSkillDto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var skillNo: Int = 0

    var skillName: String = ""

    var skillType: String = ""
    var skillLevel: String = ""

    var skillImg: String = ""

    @Builder
    constructor(skillName: String) {
        this.skillName = skillName
    }
}
