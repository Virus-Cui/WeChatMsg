package com.cui.WeChatMsg.WeChat;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.cui.WeChatMsg.API.Weather_Quality_API;
import com.cui.WeChatMsg.entity.api_entity.API_WeatherResult_Entity;
import com.cui.WeChatMsg.entity.System_Time_Entity;
import com.cui.WeChatMsg.entity.Weather_Quality_Entity;
import com.cui.WeChatMsg.util.WechatToken;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class send {
    Logger logger = Logger.getLogger(this.getClass());
    @Value("${touser}")
    private String touser;
    @Value("${template_id}")
    private String template_id;
    @Value("${appid}")
    private String appid;
    private WechatToken token = new WechatToken();
    private Weather_Quality_API Weather_Quality_API = new Weather_Quality_API();

    /**
     * 定时任务 每天七点运行
     *
     * @return ERRCODE
     */
    @Async
    @PostConstruct
    @Scheduled(cron = "0 0 7 * * ?")
    public String sendMsg() {
        String msg = JSON.toJSONString(this.getMsg());
        System.out.println(msg);
        logger.info("请求JSON:" + msg);
        String post = HttpUtil.post(this.getUrl(), msg);
        logger.info("响应JSON" + post);
        HashMap<String,Object> info = JSON.parseObject(post,HashMap.class);
        Set<String> keys = info.keySet();
        for (String str : keys) {
            if(str.equals("errcode") && !(String.valueOf(info.get(str)).equals("0"))){
                logger.error("接口请求失败");
                return post;
            }
        }
        logger.info("请求成功");
        return post;
    }

    /**
     * 获取请求URL
     * @return URL
     */
    public String getUrl() {
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + token.getToken();
        logger.info("获取URL:" + url);
        return url;
    }

    /**
     * 获取POST请求头
     * @return JSON格式参数
     */
    public Map<String, Object> getMsg() {
        Weather_Quality_Entity nowWeatherQualityEntity = Weather_Quality_API.getNowWeather();
        Map<String, Object> map = new HashMap<>();
        map.put("touser", touser);
        map.put("template_id", template_id);
        map.put("appid", appid);
        //添加数据
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("time", JSON.toJSON(new System_Time_Entity("#000",new SimpleDateFormat("yyyy-MM-dd HH").format(new Date())+"时"))); //时间
        if(Integer.parseInt(nowWeatherQualityEntity.getTemp())<15){
            dataMap.put("temp", JSON.toJSON(new API_WeatherResult_Entity("#3574f0", nowWeatherQualityEntity.getTemp() + "℃ (-_-)"))); //温度
        }else if(Integer.parseInt(nowWeatherQualityEntity.getTemp())>=16 && Integer.parseInt(nowWeatherQualityEntity.getTemp())<28){
            dataMap.put("temp", JSON.toJSON(new API_WeatherResult_Entity("#4f8453", nowWeatherQualityEntity.getTemp() + "℃ (^_^)"))); //温度
        }else {
            dataMap.put("temp", JSON.toJSON(new API_WeatherResult_Entity("#93254a", nowWeatherQualityEntity.getTemp() + "℃ (-_-)"))); //温度
        }
        dataMap.put("humidity", JSON.toJSON(new API_WeatherResult_Entity("#000", nowWeatherQualityEntity.getHumidity()+"%"))); //湿度
        dataMap.put("vis", JSON.toJSON(new API_WeatherResult_Entity("#000", nowWeatherQualityEntity.getVis() + "KM"))); //能见度
        dataMap.put("windSpeed", JSON.toJSON(new API_WeatherResult_Entity("#000", nowWeatherQualityEntity.getWindSpeed() + "KM/s"))); //风速
        dataMap.put("windDir", JSON.toJSON(new API_WeatherResult_Entity("#000", nowWeatherQualityEntity.getWindDir()))); //风向
        dataMap.put("windScale", JSON.toJSON(new API_WeatherResult_Entity("#000", nowWeatherQualityEntity.getWindScale() + "级"))); //风力等级
        dataMap.put("text", JSON.toJSON(new API_WeatherResult_Entity("#000", nowWeatherQualityEntity.getText())));
        //将数据添加到请求中
        map.put("data", dataMap);
        return map;
    }
}
