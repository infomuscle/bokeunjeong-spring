package com.bokeunjeong.portfolio.dto

import lombok.Builder
import lombok.NoArgsConstructor
import javax.persistence.*

@NoArgsConstructor
@Entity(name = "contact")
class PortfolioContactDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTACT_NO")
    var no: Int = 0

    @Column(name = "TYPE")
    var type: String = ""

    @Column(name = "DETAIL")
    var detail: String = ""

    @Column(name = "ICON")
    var icon: String = ""

    @Builder
    constructor(type: String) {
        this.type = type
    }
}