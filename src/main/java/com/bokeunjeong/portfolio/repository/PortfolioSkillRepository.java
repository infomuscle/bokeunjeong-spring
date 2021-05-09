package com.bokeunjeong.portfolio.repository;

import com.bokeunjeong.portfolio.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioSkillRepository extends JpaRepository<Skill, String> {

    public List<Skill> findAllByDisplay(Boolean display);

}
