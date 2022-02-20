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
        this.type = skill.getType();
        this.proficiency = skill.getProficiency();
        this.image = skill.getImage();
        this.category = skill.getCategory();
        this.detail = skill.getSkillProficiency().getDetail();
    }
}
