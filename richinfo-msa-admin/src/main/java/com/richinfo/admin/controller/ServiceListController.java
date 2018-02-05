package com.richinfo.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.shared.Application;
import com.richinfo.admin.service.ServiceListService;
import com.richinfo.admin.util.ResultMap;

/**
 * 此类描述的是：服务列表
 * @author: lornezhang
 * @version: 2017年8月9日 下午4:20:01
 */
@RestController
public class ServiceListController {

	@Autowired
	private ServiceListService servicesListService;
	/**
	 * 此方法描述的是：获取Eureka的服务列表
	 * @author: lornezhang
	 * @version: 2017年8月9日 下午4:46:25
	 */
	@RequestMapping("/eureka/getservicelist")
	public ResultMap getServiceList(ModelMap modelMap){
		ResultMap map = new ResultMap();
		List<Application> list = servicesListService.getServicesList();
		map.put("list", list);
		return map;
	}
	
	
}
