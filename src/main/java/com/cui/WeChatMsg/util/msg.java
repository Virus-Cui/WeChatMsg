package com.cui.WeChatMsg.util;

import com.cui.WeChatMsg.WeChat.send;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class msg implements Runnable{
    private send send = new send();
    Logger logger = Logger.getLogger(this.getClass());
    @Override
    public void run() {
        Scanner input = new Scanner(System.in);
        while (true) {
            switch (input.next()) {
                case "send":
                    logger.info("发送信息");
                        send.sendMsg();
                    break;
                case "stop":
                case "quit":
                case "exit":
                    logger.error("退出");
                    System.exit(0);
                    break;
                default:
                    logger.warn("未知命令");
                    break;
            }
        }
    }
}
