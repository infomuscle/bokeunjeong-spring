package com.bokeunjeong.portfolio.model.entity;

import com.bokeunjeong.portfolio.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity(name = "LINK")
public class Link extends BaseEntity {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "URL")
    private String url;

    @Column(name = "COLUMN")
    private Integer column;

    @Column(name = "DISPLAY")
    private Boolean display;
}
