package com.bokeunjeong.portfolio.model;


import com.bokeunjeong.portfolio.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.YearMonth;
import java.util.List;

@Getter
@Setter
@Entity(name = "PROJECT")
public class Project extends BaseEntity {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CLIENT")
    private String client;

    @Column(name = "START_DATE")
    private YearMonth startYearMonth;

    @Column(name = "END_DATE")
    private YearMonth endYearMonth;

    @Column(name = "IMG")
    private String image;

    @Column(name = "URL")
    private String url;

    @Column(name = "DISPLAY")
    private Boolean display;

    @OneToMany(mappedBy = "project")
    private List<ProjectDetail> details;

}
