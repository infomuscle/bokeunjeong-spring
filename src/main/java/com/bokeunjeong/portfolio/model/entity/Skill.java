package com.bokeunjeong.portfolio.model.entity;

import com.bokeunjeong.portfolio.model.base.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity(name = "SKILL")
public class Skill extends BaseEntity {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "PROFICIENCY")
    private Integer proficiency;

    @Column(name = "LOGO")
    private String image;

    @Column(name = "DISPLAY")
    private Boolean display;

    @Column(name = "CATEGORY")
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROFICIENCY", insertable = false, updatable = false)
    private SkillProficiency skillProficiency;
}
