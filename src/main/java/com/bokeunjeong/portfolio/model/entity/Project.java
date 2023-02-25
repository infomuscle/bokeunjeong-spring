package com.bokeunjeong.portfolio.model.entity;


import com.bokeunjeong.portfolio.model.entity.composite.YearMonth;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class Project {

    @Id
    @Column(name = "project_id")
    private String id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Type type;

    private String description;

    private String client;

    @AttributeOverrides({
            @AttributeOverride(name = "year", column = @Column(name = "start_year")),
            @AttributeOverride(name = "month", column = @Column(name = "start_month"))
    })
    @Embedded
    private YearMonth startYearMonth;

    @AttributeOverrides({
            @AttributeOverride(name = "year", column = @Column(name = "end_year")),
            @AttributeOverride(name = "month", column = @Column(name = "end_month"))
    })
    @Embedded
    private YearMonth endYearMonth;

    private String image;

    private String url;

    private Boolean display;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<ProjectDetail> details;


    public enum Type {
        WORK, PERSONAL
    }
}
