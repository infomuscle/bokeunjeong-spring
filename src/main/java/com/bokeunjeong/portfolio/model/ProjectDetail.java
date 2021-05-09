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
    private ProjectDetailId id;

    @Column(name = "DETAIL")
    private String detail;

    @ManyToOne
    @JoinColumn(name = "id")
    private Project project;

    @Getter
    @Setter
    @Embeddable
    static class ProjectDetailId implements Serializable {

        @Column(name = "ID")
        private String id;

        @Column(name = "SEQ")
        private Integer seq;

    }
}
