package com.cui.WeChatMsg;

import com.cui.WeChatMsg.WeChat.send;
import com.cui.WeChatMsg.util.msg;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeChatMsgApplication {
    public static void main(String[] args) {
        Thread thread = new Thread(new msg(),"");
        thread.start();
        SpringApplication.run(WeChatMsgApplication.class, args);
    }

}
