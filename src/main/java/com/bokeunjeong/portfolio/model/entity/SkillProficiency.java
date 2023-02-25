package com.bokeunjeong.portfolio.model.entity;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class SkillProficiency {

    @Id
    @Column(name = "skill_proficiency_id")
    private Integer id;

    private String detail;
}
