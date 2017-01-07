package com.dcits.jb.manager.env;

import com.dcits.jb.core.util.PropertyUtil;

/** 
  * @author  xingyxa 
  * @date 创建时间：2016年3月8日 下午4:52:17 
  * @version 1.0 
  * @since  1.8 
*/
public class CxfFileuploadEnv {
	private static String fileUploadUrl;
	private static String fileShowUrl;
	private static String tempUrl;
	private static String webserviceTjUrl; 

	
	static{
		if(tempUrl == null || tempUrl.equals("")){
			CxfFileuploadEnv.tempUrl = PropertyUtil.getPropertyManager("fileupload").getProperty("tempUrl");
		}
		if(webserviceTjUrl == null || webserviceTjUrl.equals("")){
			CxfFileuploadEnv.webserviceTjUrl = PropertyUtil.getPropertyManager("fileupload").getProperty("webserviceTjUrl");
		}
		if(fileUploadUrl == null || fileUploadUrl.equals("")){
			CxfFileuploadEnv.fileUploadUrl = PropertyUtil.getPropertyManager("fileupload").getProperty("fileUploadUrl");
		}
		if(fileShowUrl == null || fileShowUrl.equals("")){
			CxfFileuploadEnv.fileShowUrl = PropertyUtil.getPropertyManager("fileupload").getProperty("fileShowUrl");
		}
	}
	/**
	 * 获取远程保存图片的URL
	 * @author  xingyxa 
	 * @return
	 */
	public static String getFileUploadUrl() {
		return CxfFileuploadEnv.fileUploadUrl;
	}
	/**
	 * 获取展示图片的URL
	 * @author  xingyxa 
	 * @return
	 */
	public static String getFileShowUrl() {
		return CxfFileuploadEnv.fileShowUrl;
	}
	/**
	 * 上传图片的本地临时文件夹
	 * @author cuiwt
	 * @return
	 */
	public static String gettempUrl() {
		return CxfFileuploadEnv.tempUrl;
	}
	/**
	 * 上传图片的本地临时文件夹
	 * @author cuiwt
	 * @return
	 */
	public static String getWebserviceTjUrl() {
		return CxfFileuploadEnv.webserviceTjUrl;
	}
}
