package com.bokeunjeong.portfolio.model.base;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.text.StringEscapeUtils;

public class BaseEntity {
    @Override
    public String toString() {
        return StringEscapeUtils.unescapeJava(ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE));
    }
}
