package com.bokeunjeong.portfolio.model.entity;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity(name = "LINK")
public class Link {

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
