package com.bokeunjeong.portfolio.model.entity;

import com.bokeunjeong.portfolio.model.base.BaseEntity;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity(name = "INTRODUCTION")
public class Introduction extends BaseEntity {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DISPLAY")
    private Boolean display;
}
