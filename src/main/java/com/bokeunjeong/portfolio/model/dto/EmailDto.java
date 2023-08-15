package com.bokeunjeong.portfolio.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmailDto {

    private String name;
    private String email;
    private String subject;
    private String message;

}
