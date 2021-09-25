package com.bokeunjeong.portfolio.model;


import com.bokeunjeong.portfolio.model.base.BaseEntity;
import com.bokeunjeong.portfolio.model.base.YearMonth;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CLIENT")
    private String client;

    @AttributeOverrides({
            @AttributeOverride(name = "year", column = @Column(name = "START_YEAR")),
            @AttributeOverride(name = "month", column = @Column(name = "START_MONTH"))
    })
    @Embedded
    private YearMonth startYearMonth;

    @AttributeOverrides({
            @AttributeOverride(name = "year", column = @Column(name = "END_YEAR")),
            @AttributeOverride(name = "month", column = @Column(name = "END_MONTH"))
    })
    @Embedded
    private YearMonth endYearMonth;

    @Column(name = "IMG")
    private String image;

    @Column(name = "URL")
    private String url;

    @Column(name = "DISPLAY")
    private Boolean display;

    @OneToMany(mappedBy = "projectId")
    private List<ProjectDetail> details;

}
