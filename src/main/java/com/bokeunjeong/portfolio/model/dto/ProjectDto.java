package com.bokeunjeong.portfolio.model.dto;

import com.bokeunjeong.portfolio.model.entity.Project;
import com.bokeunjeong.portfolio.model.entity.ProjectDetail;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProjectDto {

    private String name;
    private String type;
    private String description;
    private String client;
    private String startAt;
    private String endAt;
    private String image;
    private String url;
    private List<String> details;

    public ProjectDto(Project project) {
        this.name = project.getName();
        this.type = project.getType();
        this.description = project.getDescription();
        this.startAt = project.getStartYearMonth().toString();
        this.endAt = (project.getEndYearMonth() != null) ? project.getEndYearMonth().toString() : "Present";
        this.client = project.getClient();
        this.image = project.getImage();
        this.url = project.getUrl();
        this.details = project.getDetails().stream().map(ProjectDetail::getDetail).collect(Collectors.toList());
    }
}
