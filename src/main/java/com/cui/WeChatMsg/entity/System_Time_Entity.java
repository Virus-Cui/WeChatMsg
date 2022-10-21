package com.cui.WeChatMsg.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class System_Time_Entity {
    private String color;
    private String value;

    public System_Time_Entity() {
    }

    public System_Time_Entity(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public System_Time_Entity(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    @Value("${msg}")
    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }
    @Value("${msg-color}")
    public void setColor(String color) {
        this.color = color;
    }
}
