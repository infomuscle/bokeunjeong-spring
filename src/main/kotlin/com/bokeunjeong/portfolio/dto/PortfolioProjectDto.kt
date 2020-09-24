package com.bokeunjeong.portfolio.dto

import lombok.Getter
import lombok.Setter
import java.util.*

@Getter
@Setter
class PortfolioProjectDto {

    var title: String = ""
    var client: String = ""
    var description: String = ""

    var startDt: Date = Date()
    var endDt: Date = Date()


}