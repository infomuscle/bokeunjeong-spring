package com.bokeunjeong.other.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/other")
public class OtherController {

    @GetMapping
    public @ResponseBody String other() {

        return "TEST";
    }

}
