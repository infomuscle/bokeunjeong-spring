package com.bokeunjeong.portfolio.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static com.bokeunjeong.portfolio.model.entity.Project.Type.WORK;

@Data
public class ProjectResult {

    List<ProjectDto> works = new ArrayList<>();
    List<ProjectDto> sides = new ArrayList<>();

    public ProjectResult(List<ProjectDto> projects) {
        projects.stream().forEach(p -> {
            if (WORK.name().equals(p.getType())) {
                this.works.add(p);
            } else {
                this.sides.add(p);
            }
        });
    }
}
