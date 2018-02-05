package com.richinfo.framework.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 此类描述的是：获取应用信息
 * @author: lornezhang
 * @version: 2017年8月8日 下午5:24:10
 */
@RestController
public class ApplicationInfo {

	@Value("${server.port}")
	private String port;
	
	@RequestMapping(value="/getInfo")
	public String getAppInfo(@RequestParam String name){
		return "hello "+name+",server port "+port;
	}
}
