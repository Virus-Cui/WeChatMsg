package com.cui.WeChatMsg.API;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.cui.WeChatMsg.API.config.HeFengCfg;
import com.cui.WeChatMsg.entity.Weather_Quality_Entity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;


/**
 * 和风天气API
 */
@Component
public class Weather_Quality_API {
    @Resource
    private HeFengCfg cfg;
    public Weather_Quality_Entity getNowWeather() {
        System.out.println(cfg);
        String data = HttpUtil.get("https://devapi.qweather.com/v7/weather/now?key=" + cfg.getKey() + "&location=" + cfg.getLocation());
        HashMap map = JSON.parseObject(data, HashMap.class);
        Weather_Quality_Entity now = JSON.parseObject(String.valueOf(map.get("now")), Weather_Quality_Entity.class);
        return now;
    }
}
