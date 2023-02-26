package com.bokeunjeong.portfolio.repository.jpa;

import com.bokeunjeong.portfolio.model.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioSkillRepository extends JpaRepository<Skill, String> {

    @Query("select s from Skill s join fetch s.proficiency where s.display=true")
    public List<Skill> findAllToDisplay();

}
