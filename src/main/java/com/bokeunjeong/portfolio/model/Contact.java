package com.bokeunjeong.portfolio.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Contact {

    @Id
    @Column(name = "CONTACT_NO")
    private String id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DETAIL")
    private String detail;

    @Column(name = "ICON")
    private String icon;

}
