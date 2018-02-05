package com.richinfo.admin.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.richinfo.admin.util.reg.Reg;

public class StringUtil {

	/**
	 * @Description: 判断字符串是否为空
	 * @param str 要判断的字符串
	 * @return true: 为空； false：不为空
	 */
	public static boolean isEmpty(String str){
		return str == null || str.trim().equals("");
	}
	/**
	 * long转字符串
	 * @param lon
	 * @return
	 */
	public static String long2String(Long lon){
		if(lon==null || lon==0L){
			return null;
		}
		return String.valueOf(lon);
	}
	/**
	 * @Description: 判断字符串是否不为空
	 * @param str 要判断的字符串
	 * @return true: 不为空； false：为空
	 */
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
	
	/**
	 * @Description: 返回不为null的字符串
	 * @param str
	 * @return
	 */
	public static String returnNotNull(String str){
		return str == null ? "" : str;
	}
	public static String returnNotNull(Object str){
		return str == null ? "" : ""+str;
	}

	/**
	 * 此方法描述的是：删除HTML标签
	 * @author: zhangxl
	 * @version: 2016年10月10日 下午4:20:35
	 */
	private static String delHTMLTag(String htmlStr) {
		Pattern p_script = Pattern.compile(Reg.regEx_script,Pattern.CASE_INSENSITIVE);
		Matcher m_script = p_script.matcher(htmlStr);
		htmlStr = m_script.replaceAll(""); // 过滤script标签

		Pattern p_style = Pattern.compile(Reg.regEx_style, Pattern.CASE_INSENSITIVE);
		Matcher m_style = p_style.matcher(htmlStr);
		htmlStr = m_style.replaceAll(""); // 过滤style标签

		Pattern p_html = Pattern.compile(Reg.regEx_html, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(htmlStr);
		htmlStr = m_html.replaceAll(""); // 过滤html标签

		Pattern p_space = Pattern.compile(Reg.regEx_space, Pattern.CASE_INSENSITIVE);
		Matcher m_space = p_space.matcher(htmlStr);
		htmlStr = m_space.replaceAll(""); // 过滤空格回车标签
		return htmlStr.trim(); // 返回文本字符串
	}
	
	/**
	 * 此方法描述的是：根据HTML 获取文本
	 * @author: zhangxl
	 * @version: 2016年10月10日 下午4:13:00
	 */
	public static String getTextFromHtml(String html){
		html = delHTMLTag(html);  
		html = html.replaceAll("&nbsp;", "");  
		html = html.substring(0, html.indexOf("。")+1);  
		return html;
	}
	
	/**
	 * 广义匹配，如user:*匹配 user:add,user:update,user:query等等
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean generalMatch(String str1,String str2){
		int index = str1.indexOf("*");//优先匹配*
		if(index==-1 || index>str2.length()){
			return false;
		}
		return str1.substring(0,index).equals(str2.substring(0,index));
	}
	/**
	 * ids转Long型数组
	 * @param ids
	 * @param split 分隔符
	 * @return
	 */
	public static Long[] string2LongArr(String ids,String split){
		if(StringUtil.isEmpty(ids)){
			return null;
		}
		if(StringUtil.isEmpty(split)){
			split = ",";
		}
		try {
			String[] strArr = ids.split(split);
			Long[] longArr = new Long[strArr.length];
			for (int i = 0; i < strArr.length; i++) {
				longArr[i] = Long.parseLong(strArr[i]);
			}
			return longArr;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}		
		return null;
	}
	/**
	 * ids转Integer型数组
	 * @param ids
	 * @param split 分隔符
	 * @return
	 */
	public static Integer[] string2IntegerArr(String ids,String split){
		if(StringUtil.isEmpty(ids)){
			return null;
		}
		if(StringUtil.isEmpty(split)){
			split = ",";
		}
		try {
			String[] strArr = ids.split(split);
			Integer[] integerArr = new Integer[strArr.length];
			for (int i = 0; i < strArr.length; i++) {
				integerArr[i] = Integer.parseInt(strArr[i]);
			}
			return integerArr;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}		
		return null;
	}
	final static Map<Integer, String> zoneNum = new HashMap<Integer, String>();
	static {
        zoneNum.put(11, "北京");
        zoneNum.put(12, "天津");
        zoneNum.put(13, "河北");
        zoneNum.put(14, "山西");
        zoneNum.put(15, "内蒙古");
        zoneNum.put(21, "辽宁");
        zoneNum.put(22, "吉林");
        zoneNum.put(23, "黑龙江");
        zoneNum.put(31, "上海");
        zoneNum.put(32, "江苏");
        zoneNum.put(33, "浙江");
        zoneNum.put(34, "安徽");
        zoneNum.put(35, "福建");
        zoneNum.put(36, "江西");
        zoneNum.put(37, "山东");
        zoneNum.put(41, "河南");
        zoneNum.put(42, "湖北");
        zoneNum.put(43, "湖南");
        zoneNum.put(44, "广东");
        zoneNum.put(45, "广西");
        zoneNum.put(46, "海南");
        zoneNum.put(50, "重庆");
        zoneNum.put(51, "四川");
        zoneNum.put(52, "贵州");
        zoneNum.put(53, "云南");
        zoneNum.put(54, "西藏");
        zoneNum.put(61, "陕西");
        zoneNum.put(62, "甘肃");
        zoneNum.put(63, "青海");
        zoneNum.put(64, "新疆");
        zoneNum.put(71, "台湾");
        zoneNum.put(81, "香港");
        zoneNum.put(82, "澳门");
        zoneNum.put(91, "外国");
    }
     
    final static int[] PARITYBIT = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
    final static int[] POWER_LIST = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 
        5, 8, 4, 2};
     
	/**
	 * 此方法描述的是：验证手机号
	 * @author: zhangxl
	 * @version: 2016年11月10日 上午11:31:42
	 */
    public static boolean checkTelphone(String telPhone){
		if(isEmpty(telPhone))
			return false;
		return Reg.PHONE.matcher(telPhone).find();
    }
    /**
     * 此方法描述的是：验证邮箱
     * @author: zhangxl
     * @version: 2016年11月11日 下午4:01:19
     */
    public static boolean checkEmail(String email){
    	if(isEmpty(email))
    		return false;
    	return Reg.MAIL.matcher(email).find();
    }
    
	public static boolean checkIdCard(String idCard){
        if(idCard == null || (idCard.length() != 15 && idCard.length() != 18))
            return false;
        final char[] cs = idCard.toUpperCase().toCharArray();
        //校验位数
        int power = 0;
        for(int i=0; i<cs.length; i++){
            if(i==cs.length-1 && cs[i] == 'X')
                break;//最后一位可以 是X或x
            if(cs[i]<'0' || cs[i]>'9')
                return false;
            if(i < cs.length -1){
                power += (cs[i] - '0') * POWER_LIST[i];
            }
        }
         
        //校验区位码
        if(!zoneNum.containsKey(Integer.valueOf(idCard.substring(0,2)))){
            return false;
        }
         
        //校验年份
        String year = idCard.length() == 15 ? getIdcardCalendar() + idCard.substring(6,8) :idCard.substring(6, 10);
         
        final int iyear = Integer.parseInt(year);
        if(iyear < 1900 || iyear > Calendar.getInstance().get(Calendar.YEAR))
            return false;//1900年的PASS，超过今年的PASS
         
        //校验月份
        String month = idCard.length() == 15 ? idCard.substring(8, 10) : idCard.substring(10,12);
        final int imonth = Integer.parseInt(month);
        if(imonth <1 || imonth >12){
            return false;
        }
         
        //校验天数      
        String day = idCard.length() ==15 ? idCard.substring(10, 12) : idCard.substring(12, 14);
        final int iday = Integer.parseInt(day);
        if(iday < 1 || iday > 31)
            return false;       
         
        //校验"校验码"
        if(idCard.length() == 15)
            return true;
        return cs[cs.length -1 ] == PARITYBIT[power % 11];
	}
	
    private static int getIdcardCalendar() {        
        GregorianCalendar curDay = new GregorianCalendar();
        int curYear = curDay.get(Calendar.YEAR);
        int year2bit = Integer.parseInt(String.valueOf(curYear).substring(2));          
        return  year2bit;
    }
    
    public static final char UNDERLINE='_';
    
    public static String camelToUnderline(String param){  
        if (param==null||"".equals(param.trim())){  
            return "";  
        }  
        int len=param.length();  
        StringBuilder sb=new StringBuilder(len);  
        for (int i = 0; i < len; i++) {  
            char c=param.charAt(i);  
            if (Character.isUpperCase(c)){  
                sb.append(UNDERLINE);  
                sb.append(Character.toLowerCase(c));  
            }else{  
                sb.append(c);  
            }  
        }  
        return sb.toString();  
    }  
    public static String underlineToCamel(String param){  
        if (param==null||"".equals(param.trim())){  
            return "";  
        }  
        int len=param.length();  
        StringBuilder sb=new StringBuilder(len);  
        for (int i = 0; i < len; i++) {  
            char c=param.charAt(i);  
            if (c==UNDERLINE){  
               if (++i<len){  
                   sb.append(Character.toUpperCase(param.charAt(i)));  
               }  
            }else{  
                sb.append(c);  
            }  
        }  
        return sb.toString();  
    }  
    public static String underlineToCamel2(String param){  
        if (param==null||"".equals(param.trim())){  
            return "";  
        }  
        StringBuilder sb=new StringBuilder(param);  
        Matcher mc= Pattern.compile("_").matcher(param);  
        int i=0;  
        while (mc.find()){  
            int position=mc.end()-(i++);  
            //String.valueOf(Character.toUpperCase(sb.charAt(position)));  
            sb.replace(position-1,position+1,sb.substring(position,position+1).toUpperCase());  
        }  
        return sb.toString();  
    }  
    public static void main(String[] args) {
//		System.out.println(checkEmail("327317650@qq.com"));
    	System.out.println(camelToUnderline("myBase"));
	}
    
}
