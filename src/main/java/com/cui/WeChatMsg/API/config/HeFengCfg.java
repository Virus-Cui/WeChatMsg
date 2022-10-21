package com.cui.WeChatMsg.API.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class HeFengCfg {
    private String key;
    private String location;

    public HeFengCfg() {
    }

    public HeFengCfg(String key, String location) {
        this.key = key;
        this.location = location;
    }

    public String getKey() {
        return key;
    }
    @Value("${key}")
    public void setKey(String key) {
        this.key = key;
    }

    public String getLocation() {
        return location;
    }
    @Value("${location}")
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "HeFengCfg{" +
                "key='" + key + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
