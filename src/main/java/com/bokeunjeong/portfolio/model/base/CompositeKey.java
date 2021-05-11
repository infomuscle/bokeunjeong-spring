package com.bokeunjeong.portfolio.model.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class CompositeKey implements Serializable {

    private String id;

    private Integer seq;

    public CompositeKey() {

    }

    public CompositeKey(String id, Integer seq) {
        this.id = id;
        this.seq = seq;
    }
}
