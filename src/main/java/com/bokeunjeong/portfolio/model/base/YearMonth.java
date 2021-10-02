package com.bokeunjeong.portfolio.model.base;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;


@Getter
@Setter
@Embeddable
public class YearMonth {

    private Integer year;

    private Integer month;

    public String getMonth() {

        return Month.of(month).getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
    }

}
