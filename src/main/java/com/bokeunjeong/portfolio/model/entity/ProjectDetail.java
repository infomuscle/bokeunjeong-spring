package com.bokeunjeong.portfolio.model.entity;


import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
public class ProjectDetail  {

    @Id
    @Column(name = "project_detail_id")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "sequence")
    private Integer sequence;

    @Column(name = "detail")
    private String detail;
}
