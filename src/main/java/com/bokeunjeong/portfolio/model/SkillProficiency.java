package com.bokeunjeong.portfolio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Getter
@Setter
@Entity(name = "SKILL_PROFICIENCY")
public class SkillProficiency {

    @Id
    private Integer Id;

    @Column(name = "DETAIL")
    private String detail;
}
