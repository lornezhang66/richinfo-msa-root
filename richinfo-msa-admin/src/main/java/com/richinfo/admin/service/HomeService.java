package com.richinfo.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

/**
 * 此类描述的是：首页业务处理类
 * @author: lornezhang
 * @version: 2017年8月9日 下午2:28:57
 */
@Service
public class HomeService {
	
	@Autowired
	EurekaClient eurekaClient;
	
	/**
	 * 此方法描述的是：获取服务数量
	 * @author: lornezhang
	 * @version: 2017年8月9日 下午2:48:44
	 */
	public Map<String, Object> getCount(){
		Map<String, Object> map = new HashMap<>();
		List<Application> apps = eurekaClient.getApplications().getRegisteredApplications();
		int appCount = apps.size();
		int nodeCount = 0;
		int enableNodeCount = 0;
		for(Application app : apps){
			nodeCount += app.getInstancesAsIsFromEureka().size();
			List<InstanceInfo> instances = app.getInstances();
			for(InstanceInfo instance : instances){
				if(instance.getStatus().name().equals(InstanceStatus.UP.name())){
					enableNodeCount ++;
				}
			}
		}
		
		map.put("appCount", appCount);
		map.put("nodeCount", nodeCount);
		map.put("enableNodeCount", enableNodeCount);
		return map;
	}
	
}
