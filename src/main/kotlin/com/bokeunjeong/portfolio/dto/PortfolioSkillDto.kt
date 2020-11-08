package com.bokeunjeong.portfolio.dto

import lombok.Builder
import lombok.NoArgsConstructor
import javax.persistence.*

@NoArgsConstructor
@Entity(name = "SKILL")
class PortfolioSkillDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SKILL_NO")
    var no: Int = 0

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
    var leveler : List<String> = listOf()

    @Builder
    constructor(name: String) {
        this.name = name
    }
}
