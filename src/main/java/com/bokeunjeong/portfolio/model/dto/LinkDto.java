package com.bokeunjeong.portfolio.model.dto;

import com.bokeunjeong.portfolio.model.entity.Link;
import lombok.Data;

@Data
public class LinkDto {

    private String title;
    private String url;

    public LinkDto(Link link) {
        this.title = link.getTitle();
        this.url = link.getUrl();
    }
}
