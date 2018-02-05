package com.richinfo.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 此类描述的是：服务治理平台启动类
 * @author: lornezhang
 * @version: 2017年8月8日 下午5:57:17
 */
@SpringBootApplication
@EnableEurekaClient
public class MsaAdminApplication {

	private static Logger logger = LoggerFactory.getLogger(MsaAdminApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MsaAdminApplication.class, args);
		
		logger.info("MSA ADMIN SERVICE START");
	}
}
