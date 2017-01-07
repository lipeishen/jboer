package com.dcits.jb.core.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class WebConnectionUtil {
	
	public static String sendPostRequest(String url,Map paramMap,String userId){
		CloseableHttpClient httpclient=null;
		CloseableHttpResponse response=null;
		
		try{
			httpclient = HttpClients.createDefault();
			HttpPost httppost = new HttpPost(url);
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			if(userId != null || "".equals(userId) ){
				formparams.add(new BasicNameValuePair("userId",userId));
			}
			Set keSet=paramMap.entrySet();
			for(Iterator itr=keSet.iterator();itr.hasNext();){
				Map.Entry me=(Map.Entry)itr.next();
				Object key=me.getKey();
				Object valueObj=me.getValue();
				String[] value=new String[1];
				if(valueObj == null){
					value[0] = "";
				}else{
					if(valueObj instanceof String[]){  
			            value=(String[])valueObj;  
			        }else{  
			            value[0]=valueObj.toString();  
			        }
				}
				for(int k=0;k<value.length;k++){  
					formparams.add(new BasicNameValuePair(key.toString(),StringUtil.filterSpecialChar(value[k])));
		        }
			}
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(uefEntity);

			response = httpclient.execute(httppost);
			if(response.getStatusLine().getStatusCode() == 200){
				HttpEntity entity = response.getEntity();
				String resultInfo = EntityUtils.toString(entity, "UTF-8");
				return resultInfo;
			}else{
				return response.getStatusLine().getStatusCode() + "";
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(httpclient != null){
					httpclient.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(response != null){
					response.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "404";
	}
	
	public static String sendPostRequest(String url,Map paramMap){
		CloseableHttpClient httpclient=null;
		CloseableHttpResponse response=null;
		
		try{
			httpclient = HttpClients.createDefault();
			HttpPost httppost = new HttpPost(url);
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			Set keSet=paramMap.entrySet();
			for(Iterator itr=keSet.iterator();itr.hasNext();){
				Map.Entry me=(Map.Entry)itr.next();
				Object key=me.getKey();
				Object valueObj=me.getValue();
				String[] value=new String[1];
				if(valueObj == null){
					value[0] = "";
				}else{
					if(valueObj instanceof String[]){  
			            value=(String[])valueObj;  
			        }else{  
			            value[0]=valueObj.toString();  
			        }
				}
				for(int k=0;k<value.length;k++){  
					formparams.add(new BasicNameValuePair(key.toString(),StringUtil.filterSpecialChar(value[k])));
		        }
			}
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(uefEntity);

			response = httpclient.execute(httppost);
			if(response.getStatusLine().getStatusCode() == 200){
				HttpEntity entity = response.getEntity();
				String resultInfo = EntityUtils.toString(entity, "UTF-8");
				return resultInfo;
			}else{
				return response.getStatusLine().getStatusCode() + "";
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(httpclient != null){
					httpclient.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(response != null){
					response.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "404";
	}
	
	
	
	public static String downloadFileToImgService(String remoteUtl,String imgUrl,String tempUrl){
		CloseableHttpClient httpclientRemote=null;
		CloseableHttpResponse responseRemote=null;
		
		CloseableHttpClient httpclientImg=null;
		CloseableHttpResponse responseImg=null;
		
		try{
			httpclientRemote = HttpClients.createDefault();
			HttpGet httpgetRemote = new HttpGet(remoteUtl);
			
			responseRemote = httpclientRemote.execute(httpgetRemote);
			if(responseRemote.getStatusLine().getStatusCode() != 200){
				return "";
			}
			HttpEntity resEntityRemote = responseRemote.getEntity();
			InputStream isRemote = resEntityRemote.getContent();
			//写入文件
			File file = null;
			
			boolean isDownSuccess = true;
			BufferedOutputStream bos = null;
			try{
				BufferedInputStream bif = new BufferedInputStream(isRemote);
				byte bf[] = new byte[28];
				bif.read(bf);
				String suffix = FileTypeUtil.getSuffix(bf);
				file = new File(tempUrl + "/" + UuidUtil.get32Uuid()+suffix);
				bos = new BufferedOutputStream(new FileOutputStream(file));
				if(!file.exists()){
					file.createNewFile();
				}
				bos.write(bf, 0, 28);
				byte b[] = new byte[1024*3];
				int len = 0;
				while((len=bif.read(b)) != -1){
					bos.write(b, 0, len);
				}
			}catch(Exception e){
				e.printStackTrace();
				isDownSuccess = false;
			}finally{
				try {
					if(bos != null){
						bos.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(!isDownSuccess){
				return "";
			}
			
			httpclientImg = HttpClients.createDefault();
			HttpPost httpPostImg = new HttpPost(imgUrl);
			MultipartEntityBuilder requestEntity = MultipartEntityBuilder.create();
			requestEntity.addBinaryBody("userFile", file);
			
			HttpEntity httprequestImgEntity = requestEntity.build();
			httpPostImg.setEntity(httprequestImgEntity);
			responseImg = httpclientImg.execute(httpPostImg);
			if(responseImg.getStatusLine().getStatusCode() != 200){
				return "";
			}
			HttpEntity entity = responseImg.getEntity();
			String json = EntityUtils.toString(entity, "UTF-8");
			json = json.replaceAll("\"","");
			String[] jsonMap = json.split(",");
			String resultInfo = "";
			for(int i = 0;i < jsonMap.length;i++){
				String str = jsonMap[i];
				if(str.startsWith("url:")){
					resultInfo = str.substring(4);
				}else if(str.startsWith("{url:")){
					resultInfo = str.substring(5);
				}
			}
			if(resultInfo.endsWith("}")){
				resultInfo = resultInfo.substring(0,resultInfo.length()-1);
			}
			try{
				if(file != null){
					file.delete();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return resultInfo;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(httpclientRemote != null){
					httpclientRemote.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(responseRemote != null){
					responseRemote.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(httpclientImg != null){
					httpclientImg.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(responseImg != null){
					responseImg.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	public static String downloadFileToImgService(File file,String imgUrl){
		CloseableHttpClient httpclientImg=null;
		CloseableHttpResponse responseImg=null;
		
		try{
			httpclientImg = HttpClients.createDefault();
			HttpPost httpPostImg = new HttpPost(imgUrl);
			MultipartEntityBuilder requestEntity = MultipartEntityBuilder.create();
			requestEntity.addBinaryBody("userFile", file);
			
			HttpEntity httprequestImgEntity = requestEntity.build();
			httpPostImg.setEntity(httprequestImgEntity);
			responseImg = httpclientImg.execute(httpPostImg);
			if(responseImg.getStatusLine().getStatusCode() != 200){
				return "";
			}
			HttpEntity entity = responseImg.getEntity();
			String json = EntityUtils.toString(entity, "UTF-8");
			json = json.replaceAll("\"","");
			String[] jsonMap = json.split(",");
			String resultInfo = "";
			for(int i = 0;i < jsonMap.length;i++){
				String str = jsonMap[i];
				if(str.startsWith("url:")){
					resultInfo = str.substring(4);
				}else if(str.startsWith("{url:")){
					resultInfo = str.substring(5);
				}
			}
			if(resultInfo.endsWith("}")){
				resultInfo = resultInfo.substring(0,resultInfo.length()-1);
			}
			return resultInfo;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(httpclientImg != null){
					httpclientImg.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(responseImg != null){
					responseImg.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	public static String sendGetRequest(String url){
		CloseableHttpClient httpclient=null;
		CloseableHttpResponse response=null;
		try{
			httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);

			response = httpclient.execute(httpGet);
			if(response.getStatusLine().getStatusCode() == 200){
				HttpEntity entity = response.getEntity();
				String resultInfo = EntityUtils.toString(entity, "UTF-8");
				return resultInfo;
			}else{
				return response.getStatusLine().getStatusCode() + "";
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(httpclient != null){
					httpclient.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(response != null){
					response.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "404";
	}
	
	public static String sendHttpsPostRequestUseStream(String url,String param){
		CloseableHttpClient httpclient=null;
		CloseableHttpResponse response=null;
		
		try{
			SSLContext ctx = SSLContext.getInstance("TLS");
			X509TrustManager xtm = new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					
				}

				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					
				}

				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			};
			TrustManager[] tm = {xtm};
			ctx.init(null,tm,null);
			HostnameVerifier hv = new HostnameVerifier(){
				public boolean verify(String arg0, SSLSession arg1) {
					return true;
				}
			};
			httpclient = HttpClients.custom().setSSLHostnameVerifier(hv).setSSLContext(ctx).build();
			HttpPost httpPost = new HttpPost(url);
			StringEntity strEntity = new StringEntity(param,"utf-8");
			httpPost.setEntity(strEntity);
			
 			response = httpclient.execute(httpPost);
			if(response.getStatusLine().getStatusCode() == 200){
				HttpEntity entity = response.getEntity();
				String resultInfo = EntityUtils.toString(entity, "UTF-8");
				return resultInfo;
			}else{
				return response.getStatusLine().getStatusCode() + "";
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(httpclient != null){
					httpclient.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(response != null){
					response.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "404";
	}
	
	public static String sendHttpsPostRequestUseStream(String url,Map paramMap){
		CloseableHttpClient httpclient=null;
		CloseableHttpResponse response=null;
		
		try{
			SSLContext ctx = SSLContext.getInstance("TLS");
			X509TrustManager xtm = new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					
				}

				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					
				}

				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			};
			TrustManager[] tm = {xtm};
			ctx.init(null,tm,null);
			HostnameVerifier hv = new HostnameVerifier(){
				public boolean verify(String arg0, SSLSession arg1) {
					return true;
				}
			};
			httpclient = HttpClients.custom().setSSLHostnameVerifier(hv).setSSLContext(ctx).build();
			HttpPost httpPost = new HttpPost(url);
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			Set keSet=paramMap.entrySet();
			for(Iterator itr=keSet.iterator();itr.hasNext();){
				Map.Entry me=(Map.Entry)itr.next();
				Object key=me.getKey();
				Object valueObj=me.getValue();
				String[] value=new String[1];
				if(valueObj == null){
					value[0] = "";
				}else{
					if(valueObj instanceof String[]){  
			            value=(String[])valueObj;  
			        }else{  
			            value[0]=valueObj.toString();  
			        }
				}
				for(int k=0;k<value.length;k++){  
					formparams.add(new BasicNameValuePair(key.toString(),StringUtil.filterSpecialChar(value[k])));
		        }
			}
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httpPost.setEntity(uefEntity);
			
 			response = httpclient.execute(httpPost);
			if(response.getStatusLine().getStatusCode() == 200){
				HttpEntity entity = response.getEntity();
				String resultInfo = EntityUtils.toString(entity, "UTF-8");
				return resultInfo;
			}else{
				return response.getStatusLine().getStatusCode() + "";
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(httpclient != null){
					httpclient.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(response != null){
					response.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "404";
	}
	
	public static String sendHttpsGetRequestUseStream(String url){
		CloseableHttpClient httpclient=null;
		CloseableHttpResponse response=null;
		
		try{
			SSLContext ctx = SSLContext.getInstance("TLS");
			X509TrustManager xtm = new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					
				}

				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					
				}

				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			};
			TrustManager[] tm = {xtm};
			ctx.init(null,tm,null);
			HostnameVerifier hv = new HostnameVerifier(){
				public boolean verify(String arg0, SSLSession arg1) {
					return true;
				}
			};
			httpclient = HttpClients.custom().setSSLHostnameVerifier(hv).setSSLContext(ctx).build();
			HttpGet httpGet = new HttpGet(url);
			
 			response = httpclient.execute(httpGet);
			if(response.getStatusLine().getStatusCode() == 200){
				HttpEntity entity = response.getEntity();
				String resultInfo = EntityUtils.toString(entity, "UTF-8");
				return resultInfo;
			}else{
				return response.getStatusLine().getStatusCode() + "";
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(httpclient != null){
					httpclient.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(response != null){
					response.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "404";
	}
	
	public static String sendHttpsPostRequestUseStreamForYZL(String url,OauthToken param){
		CloseableHttpClient httpclient=null;
		CloseableHttpResponse response=null;
		
		try{
			SSLContext ctx = SSLContext.getInstance("TLS");
			X509TrustManager xtm = new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					
				}

				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					
				}

				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			};
			TrustManager[] tm = {xtm};
			ctx.init(null,tm,null);
			HostnameVerifier hv = new HostnameVerifier(){
				public boolean verify(String arg0, SSLSession arg1) {
					return true;
				}
			};
			httpclient = HttpClients.custom().setSSLHostnameVerifier(hv).setSSLContext(ctx).build();
			HttpPost httpPost = new HttpPost(url);
			StringEntity strEntity = new StringEntity(param.toString(),"utf-8");
			httpPost.setEntity(strEntity);
			httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
			
 			response = httpclient.execute(httpPost);
			if(response.getStatusLine().getStatusCode() == 200){
				HttpEntity entity = response.getEntity();
				String resultInfo = EntityUtils.toString(entity, "UTF-8");
				return resultInfo;
			}else{
				return response.getStatusLine().getStatusCode() + "";
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(httpclient != null){
					httpclient.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(response != null){
					response.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "404";
	}
}
