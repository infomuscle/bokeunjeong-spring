package com.bokeunjeong.portfolio.model.entity.composite;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;


@Getter
@Setter
@Embeddable
public class YearMonth {

    private Integer year;
    private Integer month;

    @Override
    public String toString() {
        return Month.of(month).getDisplayName(TextStyle.SHORT, Locale.ENGLISH) + " " + year;
    }
}
