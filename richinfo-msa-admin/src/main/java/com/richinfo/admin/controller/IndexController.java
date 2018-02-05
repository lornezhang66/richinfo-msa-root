package com.richinfo.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 此类描述的是：服务治理平台入口
 * @author: lornezhang
 * @version: 2017年8月8日 下午6:13:16
 */
@RestController
public class IndexController {

	/**
	 * 此方法描述的是：index
	 * @author: lornezhang
	 * @version: 2017年8月8日 下午6:14:35
	 */
	@RequestMapping(value="/index")
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView("/html/index.html");
		return mav;
	}
	
}
