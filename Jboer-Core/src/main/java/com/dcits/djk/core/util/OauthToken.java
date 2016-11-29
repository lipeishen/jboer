package com.dcits.djk.core.util;

import net.sf.json.JSONObject;

/** 
  * @author  xingyxa 
  * @date 创建时间：2016年7月28日 下午2:18:28 
  * @version 1.0 
  * @since  1.8 
*/
public class OauthToken {
	private String appId;
	private String appSecret;
	private String code;
	private String grant_type;
	private String refresh_token;
	private String uid;
	
	@Override
	public String toString() {
		if (grant_type.equals("authorization_code")) {
			return "appid=" + appId + "&secret=" + appSecret + "&code=" + code + "&grant_type=" + grant_type;
		}else if (grant_type.equals("refresh_token")) {
			return "appid=" + appId + "&secret=" + appSecret + "&code=" + code + "&grant_type=refresh_token&refresh_token="
					+ refresh_token;
		}else if (grant_type.equals("admin-token")) {
			return "{\"aid\":\"" + appId + "\", \"password\":\"" + appSecret+"\"}";
		}else if (grant_type.equals("admin-getInfo")) {
			return "{\"access_token\":\"" + refresh_token + "\", \"uid\":\"" + uid+"\"}";
		}else {
			return "";
		}
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getGrant_type() {
		return grant_type;
	}
	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
}
