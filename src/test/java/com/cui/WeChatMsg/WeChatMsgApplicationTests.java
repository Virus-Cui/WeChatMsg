package com.cui.WeChatMsg;

import com.cui.WeChatMsg.API.Weather_Quality_API;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class WeChatMsgApplicationTests {
	@Autowired
	private Weather_Quality_API Weather_Quality_API;
	@Test
	void contextLoads() {
		System.out.println(Weather_Quality_API.getNowWeather());
	}

}
