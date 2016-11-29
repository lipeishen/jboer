package com.dcits.djk.core.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class StringUtil {
	private final static char[] specialChar = {'<','>','&','"','\'','￠','£','¥','§','©','®','×','÷'};
	private final static String[] specialStr = {"&lt;","&gt;","&amp;","&quot;","&apos;","&cent;","&pound;","&yen;","&sect;","&copy;","&reg;","&times;","&divide;"};
	
	public static String unionTwoStringArray(String stra,String strb){
		if(stra == null || "".equals(stra)){
			return strb;
		}else if(strb == null || "".equals(strb)){
			return stra;
		}else{
			String strc = stra + "," + strb;
			String[] str = strc.split(",");
			Set<String> set = new TreeSet<String>();
			for (int i = 0; i < str.length; i++) {
				set.add(str[i]);
			}
			Iterator<String> it = set.iterator();
			StringBuffer strsb = new StringBuffer();
			while(it.hasNext()){
				strsb.append(it.next());
				strsb.append(",");
			}
			String resultStr = strsb.toString();
			resultStr = resultStr.substring(0,resultStr.length()-1);
			return resultStr;
		}
	}
	
	public static String getServiceNameByPath(String path){
		char[] ch = path.toCharArray();
		if(ch[0] != 47){
			return "";
		}
		int ax = 0;
		for(int i = 1;i < ch.length;i++){
			char cha = ch[i];
			if(cha == 47){
				ax = i;
				break;
			}
		}
		if(ax == 0){
			return "";
		}
		return path.substring(1,ax);
		
	}
	
	public static String getNullObjToStr(Object obj){
		if(obj == null){
			return "";
		}else{
			return obj.toString();
		}
	}
	
	public static String getNullStr(String str){
		if(str == null){
			return "";
		}else{
			return str;
		}
	}
	/**
	 * 处理" " or null or "null" 方法
	 * @param str
	 * @return
	 */
	public static String sNull(String str){
		if(str == null){
			return "";
		}else if("".equals(str.trim()) || "null".equals(str.trim())){
			return "";
		}else{
			return str;
		}
	}
	public static String getStDatetimeStrByDate(Date date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(date == null){
			return "";
		}
		String datetime = df.format(date);
		return datetime;
	}
	
	public static String getStDateStrByDate(Date date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if(date == null){
			return "";
		}
		String datetime = df.format(date);
		return datetime;
	}
	
	public static String getStDatetimeStrByNow(){
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = df.format(date);
		return datetime;
	}
	
	public static String getStDateStrByNow(){
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = df.format(date);
		return datetime;
	}
	
	public static String strarrayToStr(String[] strarray){
		if(strarray != null && strarray.length > 0){
			StringBuffer strsb = new StringBuffer();
			for(int i = 0;i < strarray.length;i++){
				if(i == 0){
					strsb.append(strarray[i]);
				}else{
					strsb.append(","+strarray[i]);
				}
			}
			return strsb.toString();
		}else{
			return null;
		}
	}
	
	public static String[] strToStrarray(String str){
		if(str == null || str.equals("")){
			return null;
		}else{
			return str.split(",");
		}
	}
	
	public static String listToStr(List<String> list){
		String str="";
		for(int i=0;i<list.size();i++){
			if(i==0){
				str=(String)list.get(i);
			}else{
				str+=","+(String)list.get(i);
			}
		}
		return str;
	}
	
	public static String filterSpecialChar(String s){
		if(s == null || s.equals("")){
			return "";
		}
		char[] cs = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i < cs.length;i++){
			char c = cs[i];
			int sign = -1;
			for(int j = 0;j < specialChar.length;j++){
				char sc = specialChar[j];
				if(c == sc){
					sign = j + 1;
					break;
				}
			}
			if(sign > 0){
				sb.append(specialStr[sign-1]);
			}else{
				sb.append(c);
			}
		}
		return sb.toString();
	}
}