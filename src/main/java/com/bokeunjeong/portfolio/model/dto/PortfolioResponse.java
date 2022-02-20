package com.bokeunjeong.portfolio.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class PortfolioResponse {

    List<IntroductionDto> introductions;
    List<LinkDto> links;
    ProjectResult projects;
    List<SkillResult> skills;
    List<ContactDto> contacts;
}