package com.bokeunjeong.portfolio.repository;

import com.bokeunjeong.portfolio.model.dto.*;

import java.util.List;

public interface PortfolioRepository {

    List<IntroductionDto> findIntroductions();

    List<LinkDto> findLinks();

    List<ProjectDto> findProjets();

    List<SkillDto> findSkills();

    List<ContactDto> findContacts();

}
