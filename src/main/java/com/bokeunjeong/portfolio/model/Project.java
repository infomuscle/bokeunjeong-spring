package com.bokeunjeong.portfolio.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Project {

    private String id;
    private String name;
    private String category;
    private String description;
    private String client;
    private Date startDate;
    private Date endDate;
    private String image;
    private String url;

}
