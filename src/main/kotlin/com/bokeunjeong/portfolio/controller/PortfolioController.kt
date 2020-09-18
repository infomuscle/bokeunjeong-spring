package com.bokeunjeong.portfolio.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


@Controller
class PortfolioController{

    @GetMapping
    fun index(): String {

        return "index"
    }
}