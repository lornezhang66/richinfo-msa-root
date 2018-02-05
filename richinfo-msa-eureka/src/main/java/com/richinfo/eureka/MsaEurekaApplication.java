package com.richinfo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 此类描述的是：注册中心启动类
 * @author: lornezhang
 * @version: 2017年8月8日 下午3:49:06
 */
@SpringBootApplication
@EnableEurekaServer
public class MsaEurekaApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(MsaEurekaApplication.class, args);
	}
}
