package com.bokeunjeong.portfolio.model.entity;


import com.bokeunjeong.portfolio.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity(name = "CONTACT")
public class Contact extends BaseEntity {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DETAIL")
    private String detail;

    @Column(name = "ICON")
    private String icon;
}
