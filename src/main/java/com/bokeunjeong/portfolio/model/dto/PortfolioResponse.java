package com.bokeunjeong.portfolio.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PortfolioResponse {

    List<IntroductionDto> introductions;
    LinkResult links;
    ProjectResult projects;
    SkillResult workSkills;
    SkillResult personalSkills;
    List<ContactDto> contacts;
}