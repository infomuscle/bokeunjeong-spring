package com.bokeunjeong.portfolio.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class PortfolioResponse {

    List<IntroductionDto> introductions;
    List<LinkDto> links;
    ProjectResult projects;
    List<SkillDto> skills;
    List<ContactDto> contacts;
}