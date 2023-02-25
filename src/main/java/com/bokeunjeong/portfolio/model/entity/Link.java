package com.bokeunjeong.portfolio.model.entity;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class Link {

    @Id
    @Column(name = "link_id")
    private String id;

    private String title;

    private String url;

    private Integer column;

    private Boolean display;

}
