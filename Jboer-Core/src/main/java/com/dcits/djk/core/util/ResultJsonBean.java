package com.dcits.djk.core.util;

public class ResultJsonBean {
	
	public static String success(String returnJson){
		if(returnJson == null || returnJson.equals("")){
			returnJson = "{}";
		}
		String resultCode = "1";
		String errorCode = "0";
		String errorMsg = "";
		return getJson(resultCode,errorCode,errorMsg,returnJson);
	}
	
	public static String fail(String errorCode,String errorMsg,String returnJson){
		if(returnJson == null || returnJson.equals("")){
			returnJson = "{}";
		}
		String resultCode = "0";
		return getJson(resultCode,errorCode,errorMsg,returnJson);
	}
	
	private static String getJson(String resultCode,String errorCode,String errorMsg,String returnJson){
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"resultCode\":\""+StringUtil.getNullStr(resultCode)+"\",");
		sb.append("\"errorCode\":\""+StringUtil.getNullStr(errorCode)+"\",");
		sb.append("\"errorMsg\":\""+StringUtil.getNullStr(errorMsg)+"\",");
		sb.append("\"returnJson\":"+StringUtil.getNullStr(returnJson));
		sb.append("}");
		return sb.toString();
	}
}
