package com.bokeunjeong.portfolio.model.entity;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class SkillProficiency {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "detail")
    private String detail;
}
