package com.cui.WeChatMsg.entity;

public class System_Time_Entity {
    private String color;
    private String value;


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

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
