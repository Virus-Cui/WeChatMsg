package com.cui.WeChatMsg.API;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.cui.WeChatMsg.API.config.HeFengCfg;
import com.cui.WeChatMsg.entity.Air_Quality_Entity;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Air_Quality_API {
    public static void main(String[] args) {
        Air_Quality_API Air_Quality_API = new Air_Quality_API();
        System.out.println(Air_Quality_API.getAirInfo());
    }

    public Air_Quality_Entity getAirInfo(){
        Air_Quality_Entity Air_Quality_Entity = null;
        String s = HttpUtil.get("https://devapi.qweather.com/v7/air/5d?key=6d34230d43fc4cd7ac057674559cd378&location=101010100");
        HashMap map = JSON.parseObject(s, HashMap.class);
        Set set = map.keySet();
        for (Object o : set) {
            if (String.valueOf(o).equals("daily")) {
                ArrayList airs = JSON.parseObject(String.valueOf(map.get(String.valueOf(o))), ArrayList.class);
                Air_Quality_Entity = JSON.parseObject(String.valueOf(airs.get(0)), Air_Quality_Entity.class);
            }
        }
        return Air_Quality_Entity;
    }
}
