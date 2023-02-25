package com.bokeunjeong.portfolio.model.entity;


import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Skill {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "proficiency")
    private Integer proficiency;

    @Column(name = "logo")
    private String image;

    @Column(name = "display")
    private Boolean display;

    @Column(name = "category")
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proficiency", insertable = false, updatable = false)
    private SkillProficiency skillProficiency;
}
