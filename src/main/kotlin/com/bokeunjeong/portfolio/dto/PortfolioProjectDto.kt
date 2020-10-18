package com.bokeunjeong.portfolio.dto

import lombok.Builder
import lombok.NoArgsConstructor
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@NoArgsConstructor
@Entity(name = "project")
class PortfolioProjectDto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var no: Int = 0

    var name: String = ""

    var client: String = ""

    var description: String = ""

    var startDt: Date = Date()

    var endDt: Date = Date()

    @Builder
    constructor(name: String) {
        this.name = name
    }

}