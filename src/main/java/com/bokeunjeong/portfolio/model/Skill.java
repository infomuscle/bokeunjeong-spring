package com.bokeunjeong.portfolio.model;

import com.bokeunjeong.portfolio.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Skill extends BaseEntity {

    @Id
    @Column(name = "SKILL_ID")
    private String id;

    @Column(name = "SKILL_NAME")
    private String name;

    @Column(name = "SKILL_TYPE")
    private String type;

    @Column(name = "SKILL_LEVEL")
    private String level;

    @Column(name = "SKILL_PROFICIENCY")
    private String proficiency;

    @Column(name = "SKILL_LOGO")
    private String image;

    @Column(name = "USE_YN")
    private Boolean display;

}
