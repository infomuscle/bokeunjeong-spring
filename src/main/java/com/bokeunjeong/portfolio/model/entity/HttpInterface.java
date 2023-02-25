package com.bokeunjeong.portfolio.model.entity;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class HttpInterface {

    @Id
    @GeneratedValue
    @Column(name = "http_interface_id")
    private String id;

}
