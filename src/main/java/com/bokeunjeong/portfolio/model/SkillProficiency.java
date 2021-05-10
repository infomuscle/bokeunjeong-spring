package com.bokeunjeong.portfolio.model;

import com.bokeunjeong.portfolio.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Getter
@Setter
@Entity(name = "SKILL_PROFICIENCY")
public class SkillProficiency extends BaseEntity {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DETAIL")
    private String detail;

}
