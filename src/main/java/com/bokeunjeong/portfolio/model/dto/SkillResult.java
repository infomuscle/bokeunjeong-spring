package com.bokeunjeong.portfolio.model.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Data
public class SkillResult {

    private String category;
    private List<SkillDto> language;
    private List<SkillDto> database;
    private List<SkillDto> framework;
    private List<SkillDto> tool;

    public SkillResult(String category, List<SkillDto> skills) {
        Map<String, List<SkillDto>> map = skills.stream().filter(s -> category.equals(s.getCategory())).collect(groupingBy(SkillDto::getType));
        this.language = map.get("Language");
        this.database = map.get("Database");
        this.framework = map.get("Framework");
        this.tool = map.get("Tool");
        this.category = category;
    }
}
