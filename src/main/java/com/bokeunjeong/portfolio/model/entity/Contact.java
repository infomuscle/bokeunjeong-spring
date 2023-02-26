package com.bokeunjeong.portfolio.model.entity;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class Contact {

    @Id
    @Column(name = "contact_id")
    private String id;

    private String type;

    private String detail;

    private String icon;
}
