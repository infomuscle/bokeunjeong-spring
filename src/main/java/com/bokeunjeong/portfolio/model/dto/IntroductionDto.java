package com.bokeunjeong.portfolio.model.dto;

import com.bokeunjeong.portfolio.model.entity.Introduction;
import lombok.Data;

@Data
public class IntroductionDto {

    private String title;
    private String description;

    public IntroductionDto(Introduction introduction) {
        this.title = introduction.getTitle();
        this.description = introduction.getDescription();
    }
}
