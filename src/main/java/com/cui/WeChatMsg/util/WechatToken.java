package com.cui.WeChatMsg.util;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class WechatToken {
    Logger logger = Logger.getLogger(this.getClass()); //创建Log4j日志对象

    /**
     * 获取微信Token
     * @return Token
     */
    public String getToken(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxf013d5e2080f0542&secret=0a4b9552a1820078a001efc7de513257";
        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
        String body = response.getBody();
        int index = body.indexOf('"',body.indexOf("access_token"))+3;
        String Token = body.substring(index,body.indexOf('"',index));
        logger.info("WeChatToken:"+Token);
        return Token;
    }
}
