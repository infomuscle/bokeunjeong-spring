package com.bokeunjeong.portfolio.repository.jpa;

import com.bokeunjeong.portfolio.model.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioSkillRepository extends JpaRepository<Skill, String> {

    public List<Skill> findAllByDisplay(Boolean display);

    public List<Skill> findAllByCategoryAndDisplay(String category, Boolean display);

}
