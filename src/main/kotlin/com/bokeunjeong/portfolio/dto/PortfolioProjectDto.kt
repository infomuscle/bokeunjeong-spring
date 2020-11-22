package com.bokeunjeong.portfolio.dto

import lombok.Builder
import lombok.NoArgsConstructor
import java.time.LocalDate
import java.util.*
import javax.persistence.*


@NoArgsConstructor
@Entity(name = "PROJECT")
class PortfolioProjectDto {

    @Id
    @Column(name = "PROJECT_ID")
    var id: String = ""

    @Column(name = "PROJECT_NAME")
    var name: String = ""

    @Column(name = "CATEGORY")
    var category: String = ""

    @Column(name = "CLIENT")
    var client: String = ""

    @Column(name = "DESCRIPTION")
    var description: String = ""

    @Column(name = "PROJECT_START_DT")
    var startDt: Date? = null

    @Column(name = "PROJECT_END_DT")
    var endDt: Date? = null

    @Column(name = "PROJECT_IMG")
    var img: String = ""

    @Column(name = "URL")
    var url: String = ""

    @Transient
    var no: Int = 0

    @Transient
    var color: String = ""

    @Transient
    var startDtStr: String? = ""

    @Transient
    var endDtStr: String? = ""

    @ManyToMany
    @JoinTable(
            name = "PROJECT_SKILL",
            joinColumns = [JoinColumn(name = "PROJECT_ID")],
            inverseJoinColumns = [JoinColumn(name = "SKILL_ID")])
    var projectSkills: List<PortfolioSkillDto> = ArrayList<PortfolioSkillDto>()

    @Builder
    constructor(name: String) {
        this.name = name
    }
}