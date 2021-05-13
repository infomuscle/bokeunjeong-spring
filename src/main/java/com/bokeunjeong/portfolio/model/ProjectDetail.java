package com.bokeunjeong.portfolio.model;

import com.bokeunjeong.portfolio.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "PROJECT_DETAIL")
public class ProjectDetail extends BaseEntity implements Serializable {

    @Id
    @Column(name = "PROJECT_ID")
    private String projectId;

    @Id
    @Column(name = "SEQ")
    private String seq;

    @Column(name = "DETAIL")
    private String detail;

}
