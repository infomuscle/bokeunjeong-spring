package com.bokeunjeong.portfolio.model.entity;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Entity(name = "PROJECT_DETAIL")
public class ProjectDetail implements Serializable {

    @Id
    @Column(name = "PROJECT_ID")
    private String projectId;

    @Id
    @Column(name = "SEQ")
    private String seq;

    @Column(name = "DETAIL")
    private String detail;
}
