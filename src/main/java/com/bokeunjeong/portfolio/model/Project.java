package com.bokeunjeong.portfolio.model;


import com.bokeunjeong.portfolio.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "PROJECT")
public class Project extends BaseEntity {

    @Id
    @Column(name = "PROJECT_ID")
    private String id;

    @Column(name = "PROJECT_NAME")
    private String name;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CLIENT")
    private String client;

    @Column(name = "PROJECT_START_DT")
    private Date startDate;

    @Column(name = "PROJECT_END_DT")
    private Date endDate;

    @Column(name = "PROJECT_IMG")
    private String image;

    @Column(name = "URL")
    private String url;

    @Column(name = "DISPLAY")
    private Boolean display;

    @OneToMany(mappedBy = "project")
    private List<ProjectDetail> details;

}
