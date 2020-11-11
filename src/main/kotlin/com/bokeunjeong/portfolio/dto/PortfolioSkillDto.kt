package com.bokeunjeong.portfolio.dto

import lombok.Builder
import lombok.NoArgsConstructor
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Transient

@NoArgsConstructor
@Entity(name = "SKILL")
class PortfolioSkillDto {

    @Id
    @Column(name = "SKILL_ID")
    var id: String = ""

    @Column(name = "SKILL_NAME")
    var name: String = ""

    @Column(name = "SKILL_TYPE")
    var type: String = ""

    @Column(name = "SKILL_LEVEL")
    var level: String = ""

    @Column(name = "SKILL_PROFICIENCY")
    var proficiency: String = ""

    @Column(name = "SKILL_LOGO")
    var logo: String = ""

    @Column(name = "USE_YN")
    var useYn: String = ""

    @Transient
    var color: String = ""

    @Builder
    constructor(name: String) {
        this.name = name
    }
}
