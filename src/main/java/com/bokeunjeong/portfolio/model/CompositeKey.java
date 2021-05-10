package com.bokeunjeong.portfolio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class CompositeKey implements Serializable {

    @Column(name = "ID")
    private String id;

    @Column(name = "SEQ")
    private Integer seq;

    public CompositeKey() {

    }

    public CompositeKey(String id, Integer seq) {
        this.id = id;
        this.seq = seq;
    }
}
