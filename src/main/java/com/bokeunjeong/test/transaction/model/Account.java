package com.bokeunjeong.test.transaction.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.text.StringEscapeUtils;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "ACCOUNT")
public class Account {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "AMOUNT")
    private Long amount;


    public Account() {

    }

    public Account(Long amount) {
        this.amount = amount;
    }

    public Account(Long id, Long amount) {
        this.id = id;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return StringEscapeUtils.unescapeJava(ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE));
    }

}
