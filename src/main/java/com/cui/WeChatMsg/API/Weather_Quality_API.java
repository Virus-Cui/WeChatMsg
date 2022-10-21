package com.cui.WeChatMsg.API;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.cui.WeChatMsg.entity.Weather_Quality_Entity;
import org.springframework.stereotype.Component;

import java.util.HashMap;


/**
 * 和风天气API
 */
@Component
public class Weather_Quality_API {
    private String APIKey = "6d34230d43fc4cd7ac057674559cd378";
    private String location = "101010100";
    public Weather_Quality_Entity getNowWeather() {
        String data = HttpUtil.get("https://devapi.qweather.com/v7/weather/now?key="+APIKey+"&location="+location);
        HashMap map = JSON.parseObject(data, HashMap.class);
        Weather_Quality_Entity now = JSON.parseObject(String.valueOf(map.get("now")), Weather_Quality_Entity.class);
        return now;
    }
}
