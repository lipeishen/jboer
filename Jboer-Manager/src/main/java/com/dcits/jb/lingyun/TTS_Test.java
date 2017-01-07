package com.dcits.jb.lingyun;


import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.dcits.jb.manager.env.FileDealEnv;
import com.dcits.jb.manager.util.MD5;

public class TTS_Test {

	private static String URL = "http://test.api.hcicloud.com:8880/tts/synthtext";
	private static String responseString;
	private static String app_key = "3d5d5478";
	private static String dev_key = "ef0b85fa92eb1c66ab7e6cb28ba292d4";
	private static String cap_key = "tts.cloud.wangjing";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpClient client = new HttpClient();
		PostMethod myPost = new PostMethod(URL);
		
		
		try {
			
			myPost.setRequestHeader("Content-Type", "text/xml");
			myPost.setRequestHeader("charset", "utf-8");
			myPost.setRequestHeader("x-app-key", app_key);
			myPost.setRequestHeader("x-sdk-version", "3.6");

			String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
			myPost.setRequestHeader("x-request-date", date);
			myPost.setRequestHeader("x-task-config", "capkey=" + cap_key + ",audioformat=auto,pitch=5,volume=5,speed=5");
			String str = date + dev_key;
			System.out.println(str);
			myPost.setRequestHeader("x-session-key", MD5.getMD5(str.getBytes()));
			myPost.setRequestHeader("x-udid", "101:123456789");
			
			RequestEntity entity = new StringRequestEntity("一二三四五", "text/html", "utf-8");
			myPost.setRequestEntity(entity);
			int statusCode = client.executeMethod(myPost);
		//	String output = String.format("%d", statusCode);
			System.out.println(statusCode);
			
			if (statusCode == HttpStatus.SC_OK) {
				BufferedInputStream bis = new BufferedInputStream(
						
				myPost.getResponseBodyAsStream());
				byte[] bytes = new byte[1024];
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				int count = 0;
				while ((count = bis.read(bytes)) != -1) {
					bos.write(bytes, 0, count);
				}
				byte[] strByte = bos.toByteArray();
				//responseString = new String(strByte, 0, strByte.length, "utf-8");
				responseString = new String(strByte, 0, strByte.length, "iso-8859-1");
				
				//System.out.println(responseString);
				//output = String.format("%s", responseString);
	//			output = String.format("%d", responseString.indexOf("</ResponseInfo>"));
				System.out.println(responseString.substring(0, responseString.indexOf("</ResponseInfo>") + 15));
				responseString = responseString.substring(responseString.indexOf("</ResponseInfo>") + 15);
				
				strByte = responseString.getBytes("iso-8859-1");
				String path = FileDealEnv.getFileVoicePath();
				System.out.println(path);
				//output = String.format("%s", path);
				File file = new File(path, "nihao1.pcm");
				if (!file.exists())
					file.createNewFile();
				FileOutputStream outStream = new FileOutputStream(file);
				outStream.write(strByte, 0, strByte.length);
				outStream.close();
				bos.close();
				bis.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
