package com.bokeunjeong.portfolio.model.dto;

import com.bokeunjeong.portfolio.model.entity.Project;
import com.bokeunjeong.portfolio.model.entity.ProjectDetail;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.bokeunjeong.portfolio.model.entity.ProjectDetail.Type.DESCRIPTION;
import static com.bokeunjeong.portfolio.model.entity.ProjectDetail.Type.LINK;

@Data
public class ProjectDto {

    private String name;
    private String type;
    private String description;
    private String client;
    private String startAt;
    private String endAt;
    private String image;
    private List<String> urls;
    private List<String> details;

    public ProjectDto(Project project) {
        this.name = project.getName();
        this.type = project.getType().name();
        this.description = project.getDescription();
        this.startAt = project.getStartYearMonth().toString();
        this.endAt = (project.getEndYearMonth() != null) ? project.getEndYearMonth().toString() : "Present";
        this.client = project.getClient();
        this.image = project.getImage();
        this.urls = project.getDetails().stream().filter(pd -> LINK.equals(pd.getType())).sorted(Comparator.comparing(ProjectDetail::getSequence)).map(ProjectDetail::getDetail).collect(Collectors.toList());
        this.details = project.getDetails().stream().filter(pd -> DESCRIPTION.equals(pd.getType())).sorted(Comparator.comparing(ProjectDetail::getSequence)).map(ProjectDetail::getDetail).collect(Collectors.toList());
    }
}
