package com.bokeunjeong.portfolio.model.entity;


import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class ProjectDetail {

    @Id
    @Column(name = "project_detail_id")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "display_sequence")
    private Integer sequence;

    @Column(name = "detail")
    private String detail;

    @Enumerated(EnumType.STRING)
    private Type type;


    public enum Type {
        DESCRIPTION, LINK
    }
}
