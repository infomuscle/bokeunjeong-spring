package com.bokeunjeong.portfolio.model;

import com.bokeunjeong.portfolio.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "PROJECT_DETAIL")
public class ProjectDetail extends BaseEntity {

    @Id
    @Column(name = "SEQ")
    private String seq;

    @Column(name = "DETAIL")
    private String detail;

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

}
