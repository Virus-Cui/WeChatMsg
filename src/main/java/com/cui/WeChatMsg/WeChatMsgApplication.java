package com.cui.WeChatMsg;

import com.cui.WeChatMsg.util.CommandUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeChatMsgApplication {
    public static void main(String[] args) {
        Thread thread = new Thread(new CommandUtil(),"");
        thread.start();
        SpringApplication.run(WeChatMsgApplication.class, args);
    }

}
