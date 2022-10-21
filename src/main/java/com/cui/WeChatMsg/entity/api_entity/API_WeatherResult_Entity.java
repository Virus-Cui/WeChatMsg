package com.cui.WeChatMsg.entity.api_entity;

/**
 * 天气父类
 */
public class API_WeatherResult_Entity {
    private String color;
    private String value;

    public API_WeatherResult_Entity() {
    }

    public API_WeatherResult_Entity(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
