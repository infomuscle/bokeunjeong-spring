package com.bokeunjeong.portfolio.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


@Controller
class PortfolioController {

    @GetMapping
    fun index(): String {
        return "index"
    }

    @GetMapping("/about")
    fun about(): String {
        return "about"
    }

    @GetMapping("/projects")
    fun projects(): String {
        return "projects"
    }

    @GetMapping("/contact")
    fun contact(): String {
        return "contact"
    }
}