package com.bokeunjeong.portfolio.model.entity;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class Introduction {

    @Id
    @Column(name = "introduction_id")
    private String id;

    private String title;

    private String description;

    private Boolean display;
}
