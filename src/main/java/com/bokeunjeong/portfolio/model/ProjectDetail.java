package com.bokeunjeong.portfolio.model;

import com.bokeunjeong.portfolio.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "PROJECT_DETAIL")
public class ProjectDetail extends BaseEntity {

    @EmbeddedId
    private CompositeKey pk;

    @Column(name = "DETAIL")
    private String detail;

    @ManyToOne
    @JoinColumn(name = "id")
    private Project project;

    public ProjectDetail() {

    }

    public ProjectDetail(Boolean isTest, String id, Integer seq, String detail) {
        if (isTest) {
            this.pk = new CompositeKey(id, seq);
            this.detail = detail;
        }
    }

}
