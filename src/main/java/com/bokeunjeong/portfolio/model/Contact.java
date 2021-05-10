package com.bokeunjeong.portfolio.model;


import com.bokeunjeong.portfolio.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
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

    public Contact() {

    }

    public Contact(String id, String type, String detail, String icon) {
        this.id = id;
        this.type = type;
        this.detail = detail;
        this.icon = icon;
    }

}
