package com.cui.WeChatMsg.entity;

public class Air_Quality_Entity {
    private String aqi;
    private String level;
    private String category;
    private String fxDate;
    private String primary;

    public Air_Quality_Entity() {
    }

    public Air_Quality_Entity(String aqi, String level, String category, String fxDate, String primary) {
        this.aqi = aqi;
        this.level = level;
        this.category = category;
        this.fxDate = fxDate;
        this.primary = primary;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFxDate() {
        return fxDate;
    }

    public void setFxDate(String fxDate) {
        this.fxDate = fxDate;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    @Override
    public String toString() {
        return "air{" +
                "aqi='" + aqi + '\'' +
                ", level='" + level + '\'' +
                ", category='" + category + '\'' +
                ", fxDate='" + fxDate + '\'' +
                ", primary='" + primary + '\'' +
                '}';
    }
}
