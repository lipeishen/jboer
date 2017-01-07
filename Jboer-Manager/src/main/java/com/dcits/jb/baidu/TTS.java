package com.dcits.jb.baidu;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.dcits.jb.baidu.json.JSONObject;

public class TTS {
	    private static final String serverURL = "http://tsn.baidu.com/text2audio";
	    private static String token = "";
	    //put your own params here
	    private static final String apiKey = "ROymsLbbkB6PlPXTjbnY70Kx";
	    private static final String secretKey = "sxnalkP0ZXSKFCj9aMyknVqYm67aCAyk";
	    private static final String cuid = "7541281";
	    private static final String tnsUrl="http://tsn.baidu.com/text2audio?tex=***&lan=zh&cuid=***&ctp=1&tok=***";

	    static  {
	        try {
				getToken();
			} catch (Exception e) {
				e.printStackTrace();
			}
	        
	    }
	    

	    /**
	     * @author lips
	     * 获取token
	     * 
	     * @throws Exception
	     */
	    private static void getToken() throws Exception {
	        String getTokenURL = "https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials" + 
	            "&client_id=" + apiKey + "&client_secret=" + secretKey;
	        HttpURLConnection conn = (HttpURLConnection) new URL(getTokenURL).openConnection();
	        token = new JSONObject(printResponse(conn)).getString("access_token");
	    }
	    
	    /**
	     * get 方式实现语音合成
	     * @author lips
	     */
	    private static void TextToVoice(String text){
	    	

	    	
	    }
	    
	    
	    //处理转化结果
	    private static String printResponse(HttpURLConnection conn) throws Exception {
	        if (conn.getResponseCode() != 200) {
	            // request error
	            return "";
	        }
	        InputStream is = conn.getInputStream();
	        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	        String line;
	        StringBuffer response = new StringBuffer();
	        while ((line = rd.readLine()) != null) {
	            response.append(line);
	            response.append('\r');
	        }
	        rd.close();
	        System.out.println(new JSONObject(response.toString()).toString(4));
	        return response.toString();
	    }

}
