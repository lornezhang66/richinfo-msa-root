package com.richinfo.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 此类描述的是：spring boot启动类
 * @author: lornezhang
 * @version: 2017年8月8日 下午5:21:49
 */
@SpringBootApplication
@EnableEurekaClient
public class MsaFrameworkApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(MsaFrameworkApplication.class, args);
	}
}
