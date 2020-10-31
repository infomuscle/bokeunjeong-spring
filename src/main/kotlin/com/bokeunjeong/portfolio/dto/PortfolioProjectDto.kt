package com.bokeunjeong.portfolio.dto

import lombok.Builder
import lombok.NoArgsConstructor
import java.util.*
import javax.persistence.*

@NoArgsConstructor
@Entity(name = "project")
class PortfolioProjectDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_NO")
    var no: Int = 0

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


    @Builder
    constructor(name: String) {
        this.name = name
    }
}