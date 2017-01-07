package com.dcits.jb.core.error;

public class FamilyDoctErrorCodeInfo {
	
	public final static String FAMILYDOCT_USERNAMEORPWD_CODE = "006001";
	public final static String FAMILYDOCT_USERNAMEORPWD_DESC = "用户名密码错误";
	
	public final static String FAMILYDOCT_EXCEPTION_CODE = "006002";
	public final static String FAMILYDOCT_EXCEPTION_DESC = "无法进行登录";
	
	public final static String FAMILYDOCT_INPUTPARAM_CODE = "006003";
	public final static String FAMILYDOCT_INPUTPARAM_DESC = "传人参数错误";
	
	public final static String FAMILYDOCT_VALIDATECODE_CODE = "006004";
	public final static String FAMILYDOCT_VALIDATECODE_DESC = "验证码错误";
	
	public final static String FAMILYDOCT_MAINACCOUNT_CODE = "006005";
	public final static String FAMILYDOCT_MAINACCOUNT_DESC = "参数为空";
	
	public final static String FAMILYDOCT_SYSTEM_CODE = "006006";
	public final static String FAMILYDOCT_SYSTEM_DESC = "系统错误";
	
	public final static String FAMILYDOCT_USERID_CODE = "006007";
	public final static String FAMILYDOCT_USERID_DESC = "用户名id为空";
	
	public final static String FAMILYDOCT_STATION_CODE = "006008";
	public final static String FAMILYDOCT_STATION_DESC = "医生站点为空";
	
	public final static String FAMILYDOCT_TYPEVALUE_CODE = "006009";
	public final static String FAMILYDOCT_TYPEVALUE_DESC = "指标类型值为空";
	//预签约  0 预签约成功1 已签约，不需要重复签约。2 已有预签约记录，请携带身份证及社保卡到家庭医生诊所正式签约。9 系统异常
	public final static String FAMILYDOCT_REQY_CODE = "003010";
	public final static String FAMILYDOCT_REQY_DESC = "已签约，不需要重复签约。";
	
	public final static String FAMILYDOCT_YYJL_CODE = "003011";
	public final static String FAMILYDOCT_YYJL_DESC = "已有预签约记录，请携带身份证及社保卡到家庭医生诊所正式签约。";
	//续签约 0 续签成功 1 此人不是家庭代表或者未签约，不能续签2 协议未到期，无需续签。 3 协议已过期，无法续签。
	public final static String FAMILYDOCT_XQY_CODE = "003013";
	public final static String FAMILYDOCT_XQY_DESC = "此人不是家庭代表或者未签约，不能续签";
	public final static String FAMILYDOCT_XYQY_CODE = "003014";
	public final static String FAMILYDOCT_XYQY_DESC = " 协议未到期，无需续签。";
	public final static String FAMILYDOCT_GQQY_CODE = "003015";
	public final static String FAMILYDOCT_GQQY_DESC = "协议已过期，无法续签。";
	//服务预约
	public final static String FAMILYDOCT_QY_CODE = "003016";
	public final static String FAMILYDOCT_QY_DESC = "此人未签约，不能预约服务";
	//服务有效期
	public final static String FAMILYDOCT_YXQ_CODE = "003017";
	public final static String FAMILYDOCT_YXQ_DESC = "服务有效期为空";
	//自定义
	public final static String FAMILYDOCT_ZDY_CODE = "003018";
	public final static String FAMILYDOCT_ZDY_DESC = "";
}
