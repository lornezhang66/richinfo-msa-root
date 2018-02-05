package com.richinfo.admin.util.reg;

import java.util.regex.Pattern;

/**
 * 正则表达式设置
 * @author zhangxl
 *
 */
public interface Reg {

	/** 用户名-注册*/
	public static final Pattern ACCOUNT_REGIST = Pattern.compile("^[a-zA-Z][\\w\\d]{2,29}$");
	
	/** 用户名-登录（之前有部分用户的登录名有中文）*/
	public static final Pattern ACCOUNT_LOGIN = Pattern.compile("^[a-zA-Z\\u4e00-\\u9fa5][\\w\\u4e00-\\u9fa5\\d]{2,29}$");
	
	/** 手机号码*/
	public static final Pattern PHONE = Pattern.compile("^1[3-8]\\d{9}$");
	
	/** 座机号码*/
	public static final Pattern TELEPHONE = Pattern.compile("^((0[1-9]{2,3}\\-)|(0[1-9]{2,3}))?([0-9]{7,8})$");
	
	/** 车牌号*/
	public static final Pattern VEHICLE_NUM = Pattern.compile("^[\\u4e00-\\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$");
	
	/** 身份证号*/
	public static final Pattern ID_CARD = Pattern.compile("^(^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$)|(^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[Xx])$)$");
	
	/** 邮箱*/
	public static final Pattern MAIL = Pattern.compile("^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$");
	
	/** 定义script的正则表达式   */
	public static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; 
	
	/** // 定义style的正则表达式  */
    public static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>";
    
    /** // 定义HTML标签的正则表达式  */
    public static final String regEx_html = "<[^>]+>";
    
    /** //定义空格回车换行符  */
    public static final String regEx_space = "\\s*|\t|\r|\n";
}
