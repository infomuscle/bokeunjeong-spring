package com.bokeunjeong.portfolio.model.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;


@Getter
@Setter
@Embeddable
public class YearMonth {

    private Integer year;

    private Integer month;

    public String getMonth() {
        return String.format("%02d", this.month);
    }

}
