package com.bokeunjeong.portfolio.model.entity;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity(name = "SKILL_PROFICIENCY")
public class SkillProficiency {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DETAIL")
    private String detail;
}
