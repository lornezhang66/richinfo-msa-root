package com.richinfo.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richinfo.admin.service.HomeService;
import com.richinfo.admin.util.ResultMap;

/**
 * 此类描述的是：home
 * @author: lornezhang
 * @version: 2017年8月9日 上午11:20:08
 */
@RestController
public class HomeController {

	@Autowired
	private HomeService homeService;
	
	/**
	 * 此方法描述的是：获取eureka注册中心的服务数
	 * @author: lornezhang
	 * @version: 2017年8月9日 上午11:20:55
	 */
	@RequestMapping("/eureka/home")
	public ResultMap getCount(){
		ResultMap map= new ResultMap();
		Map<String, Object> m = homeService.getCount();
		map.putAll(m);
		return map;
	}
	
}
