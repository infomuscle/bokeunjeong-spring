package com.bokeunjeong.portfolio.dto

import lombok.Builder
import lombok.NoArgsConstructor
import javax.persistence.*

@NoArgsConstructor
@Entity(name = "skill")
class PortfolioSkillDto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "SKILL_NO")
    var no: Int = 0

    @Column(name = "SKILL_NAME")
    var name: String = ""

    @Column(name = "SKILL_TYPE")
    var type: String = ""

    @Column(name = "SKILL_LEVEL")
    var level: String = ""

    @Column(name = "SKILL_LOGO")
    var img: String = ""

    @Builder
    constructor(name: String) {
        this.name = name
    }
}
