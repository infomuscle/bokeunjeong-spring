package com.bokeunjeong.portfolio.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LinkResult {

    private List<LinkDto> column1 = new ArrayList<>();
    private List<LinkDto> column2 = new ArrayList<>();

    public LinkResult(List<LinkDto> links) {
        links.stream().forEach(l -> {
            if (l.getColumn() == 1) {
                this.column1.add(l);
            } else {
                this.column2.add(l);
            }
        });
    }
}
