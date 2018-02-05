package com.richinfo.admin.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.richinfo.admin.util.HttpUtil;

/**
 * 此类描述的是：服务列表
 * @author: lornezhang
 * @version: 2017年8月9日 下午5:12:18
 */
@Service
public class ServiceListService {

	@Autowired
	private EurekaClient eurekaClient;
	
	/**
	 * 此方法描述的是：获取注册中心服务列表
	 * @author: lornezhang
	 * @version: 2017年8月9日 下午5:13:30
	 */
	public List<Application> getServicesList(){
		List<Application> apps = eurekaClient.getApplications().getRegisteredApplications();
		Collections.sort(apps, new Comparator<Application>() {
	        public int compare(Application l, Application r) {
	            return l.getName().compareTo(r.getName());
	        }
	    });
		for(Application app : apps){
			Collections.sort(app.getInstances(), new Comparator<InstanceInfo>() {
		        public int compare(InstanceInfo l, InstanceInfo r) {
		            return l.getPort() - r.getPort();
		        }
		    });
		}
		return apps;
	}
	
	/**
	 * 此方法描述的是：修改服务状态
	 * @author: lornezhang
	 * @version: 2017年8月9日 下午5:18:14
	 */
	public void updateStatic(String appName, String instanceId, String status){
		Application application = eurekaClient.getApplication(appName);
		InstanceInfo instanceInfo = application.getByInstanceId(instanceId);
		instanceInfo.setStatus(InstanceStatus.toEnum(status));
		HttpUtil.post(instanceInfo.getHomePageUrl() + "eureka-client/status", "status=" + status);
		
		List<InstanceInfo> instanceInfos = application.getInstances();
		for(InstanceInfo item : instanceInfos){
			HttpUtil.post(item.getHomePageUrl() + "eureka-client/status/" + appName, "instanceId=" + instanceId + "&status=" + status);
		}
		
		
	}
}
