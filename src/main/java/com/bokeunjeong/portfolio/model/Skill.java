package com.bokeunjeong.portfolio.model;

import com.bokeunjeong.portfolio.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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

    @ManyToOne
    @JoinColumn(name = "proficiency")
    private SkillProficiency skillProficiency;

}
