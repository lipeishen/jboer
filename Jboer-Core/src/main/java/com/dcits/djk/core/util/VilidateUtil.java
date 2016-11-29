package com.dcits.djk.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xingyxa
 * @date 创建时间：2016年3月16日 下午3:37:54
 * @version 1.0
 * @since 1.8
 */
public class VilidateUtil {
	public static void main(String[] args){
		System.out.println(isValidAccount("汉字"));
		//校验特殊字符
		String regEx = "[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）&;—|{}【】‘；： ”“'。，、？]";
		//校验中文
		String regEx2="[\u4e00-\u9fa5]";
		//校验首字母
		String regEx3="^[a-zA-Z]{1}";
		//校验密码
		String regEx4="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
		//校验手机号
		String regEx5="^1[3|4|5|6|7|8|9][0-9]{9}$";
		//校验固定电话
//		String regEx6 = "^(\d{3,5}[-]?\d{6,8})$";
	}
	/**
	 * 验证邮箱
	 * @author  xingyxa 
	 * @param email
	 * @return boolean
	 */
	public static boolean isEmail(String email) {
		String str = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);
		return m.matches();
	}
	/**
	 * 手机号验证 
	 * @author  xingyxa 
	 * @param mobiles
	 * @return boolean
	 */
	public static boolean isMobileNO(String mobiles){     
        Pattern p = Pattern.compile("^1[3|4|5|6|7|8|9][0-9]{9}$");     
        Matcher m = p.matcher(mobiles);     
        return m.matches();     
    } 
	/**
	 * 电话号码验证 
	 * @author  xingyxa 
	 * @param str
	 * @return boolean
	 */
	public static boolean isPhone(String str) {   
        Pattern p1 = null,p2 = null;  
        Matcher m = null;  
        boolean b = false;    
        p1 = Pattern.compile("^[0][0-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的  
        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的  
        if(str.length() >9)  
        {   m = p1.matcher(str);  
            b = m.matches();    
        }else{  
            m = p2.matcher(str);  
            b = m.matches();   
        }    
        return b;  
	 }  
	/**
	 * 验证日期格式
	 * @author  xingyxa 
	 * @param str
	 * @return boolean
	 */
	public static boolean isValidDate(String str) {
	      boolean convertSuccess=true;
	       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	       try {
	          format.setLenient(false);
	          format.parse(str);
	       } catch (ParseException e) {
	           e.printStackTrace();
	    	   // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
	           convertSuccess=false;
	       } 
	       return convertSuccess;
	}
	/**
	 * 验证国内邮编
	 * @author  xingyxa 
	 * @param str
	 * @return boolean
	 */
	public static boolean isValidzipcode(String str) {
	      Pattern p = Pattern.compile("^[1-9]\\d{5}$");     
          Matcher m = p.matcher(str);     
          return m.matches();   
	}
	/**
	 * 验证非汉字
	 * @author  xingyxa 
	 * @param str
	 * @return boolean
	 */
	public static boolean isValidCHS(String str) {
	      Pattern p = Pattern.compile("^[\u0391-\uFFE5]+$");     
          Matcher m = p.matcher(str);   
          return m.matches();   
	}
	/**
	 * 验证只能包含 _ 数字 字母
	 * @author  xingyxa 
	 * @param str
	 * @return boolean
	 */
	public static boolean isValidAccount(String str) {
	      Pattern p = Pattern.compile("^[\\w]+$");     
          Matcher m = p.matcher(str);   
          return m.matches();   
	}
}
