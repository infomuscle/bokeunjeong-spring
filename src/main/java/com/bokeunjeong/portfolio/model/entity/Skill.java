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

    @Enumerated(value = EnumType.STRING)
    private Type type;

    private Boolean display;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_proficiency_id")
    private SkillProficiency proficiency;


    public enum Type {
        LANGUAGE, FRAMEWORK, DATABASE, TOOL
    }

    public enum Category {
        WORK, PERSONAL
    }
}
