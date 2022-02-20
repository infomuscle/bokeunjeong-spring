package com.bokeunjeong.portfolio.model.dto;

import com.bokeunjeong.portfolio.model.entity.Contact;
import lombok.Data;

@Data
public class ContactDto {

    private String type;
    private String detail;
    private String icon;

    public ContactDto(Contact contact) {
        this.type = contact.getType();
        this.detail = contact.getDetail();
        this.icon = contact.getIcon();
    }
}
