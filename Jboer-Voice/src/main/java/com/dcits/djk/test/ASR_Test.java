package com.dcits.djk.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.http.HttpStatus;

import com.dcits.djk.MD5;
import com.dcits.djk.env.FileDealEnv;


public class ASR_Test {

	private static String URL = "http://test.api.hcicloud.com:8880/asr/recognise";
	private static String filepath;
	private static int filelen;
	
//	private static String string = "http://222.82.253.98:8005/asr/recognise";
	private static String app_key = "3d5d5478";
	private static String dev_key = "ef0b85fa92eb1c66ab7e6cb28ba292d4";
	private static String cap_key = "asr.cloud.freetalk";
	
	
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
			myPost.setRequestHeader("x-task-config", "capkey=" + cap_key + ",audioformat=pcm16k16bit");
			String str = date + dev_key;
			System.out.println(str);
			myPost.setRequestHeader("x-session-key", MD5.getMD5(str.getBytes()));
			myPost.setRequestHeader("x-udid", "101:123456789");
			
			filepath=FileDealEnv.getFileVoicePath();
			System.out.println(filepath);
			File fileSrc = new File(filepath+"test.pcm");
			if (!fileSrc.exists()){
				System.out.println("文件不存在！");
				return;
			}
			
			byte [] content = null;
			
			FileInputStream rd = new FileInputStream(fileSrc);
			filelen = rd.available();
			content = new byte[filelen];
				
			rd.read(content);
		
			
			RequestEntity entity = new StringRequestEntity(new String(content, "iso-8859-1"), "application/octet-stream", "iso-8859-1");
			myPost.setRequestEntity(entity);
			int statusCode = client.executeMethod(myPost);
//			String.format("%d", statusCode);
			System.out.println(statusCode);
			
			if (statusCode == HttpStatus.SC_OK) {
				InputStream txtis = myPost.getResponseBodyAsStream(); 
				BufferedReader br = new BufferedReader(new InputStreamReader(txtis));
				
				String tempbf;
				StringBuffer html = new StringBuffer(256);
				while((tempbf = br.readLine()) != null){
					html.append(tempbf);
				}
				
				System.out.println(html.toString());
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
