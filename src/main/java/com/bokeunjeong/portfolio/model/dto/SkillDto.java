package com.bokeunjeong.portfolio.model.dto;

import com.bokeunjeong.portfolio.model.entity.Skill;
import lombok.Data;

@Data
public class SkillDto {

    private String name;
    private String type;
    private Integer proficiency;
    private String image;
    private String category;
    private String detail;

    public SkillDto(Skill skill) {
        this.name = skill.getName();
        this.type = skill.getType().name();
        this.proficiency = skill.getProficiency().getLevel();
        this.image = skill.getImage();
        this.category = skill.getCategory().name();
        this.detail = skill.getProficiency().getDetail();
    }
}
