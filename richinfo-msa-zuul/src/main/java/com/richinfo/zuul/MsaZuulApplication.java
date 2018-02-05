package com.richinfo.zuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.richinfo.zuul.Filter.MsaZuulFilter;

/**
 * 此类描述的是：msa zuul 网关
 * @author: lornezhang
 * @version: 2017年8月10日 上午10:33:38
 */
@SpringBootApplication
@EnableZuulProxy
public class MsaZuulApplication {

	private static Logger logger = LoggerFactory.getLogger(MsaZuulApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MsaZuulApplication.class, args);
		
		logger.info("MSA ZUUL SERVER START");
	}

	/**
	 * 此方法描述的是：初始化过滤器
	 * @author: lornezhang
	 * @version: 2017年8月10日 上午11:29:57
	 */
	@Bean
	public MsaZuulFilter msaZuulFilter(){
		return new MsaZuulFilter();
	}
}
