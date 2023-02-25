package com.bokeunjeong.portfolio.model.entity;


import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Skill {

    @Id
    @Column(name = "skill_id")
    private String id;

    private String name;

    private String type;

    private Integer proficiency;

    private String image;

    private Boolean display;

    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proficiency", insertable = false, updatable = false)
    private SkillProficiency skillProficiency;


    enum Type {
        LANGUAGE, FRAMEWORK, DATABASE, TOOL
    }
}
