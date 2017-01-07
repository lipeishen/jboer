package com.dcits.jb.core.error;

public class AuthErrorCodeInfo {
	public final static String ROUTER_EMPTYRETURN_CODE = "000001";
	public final static String ROUTER_EMPTYRETURN_DESC = "无返回数据";

	public final static String ROUTER_HTTPERRORCODE_CODE = "000002";
	public final static String ROUTER_HTTPERRORCODE_DESC = "错误代码是：";

	public final static String LOGIN_USERNAMEORPWD_CODE = "001001";
	public final static String LOGIN_USERNAMEORPWD_DESC = "用户名密码错误";

	public final static String LOGIN_EXCEPTION_CODE = "001002";
	public final static String LOGIN_EXCEPTION_DESC = "无法进行登录";

	public final static String LOGIN_INPUTPARAM_CODE = "001003";
	public final static String LOGIN_INPUTPARAM_DESC = "传入参数错误";

	public final static String LOGIN_VALIDATECODE_CODE = "001004";
	public final static String LOGIN_VALIDATECODE_DESC = "验证码错误";

	public final static String LOGIN_MAINACCOUNT_CODE = "001005";
	public final static String LOGIN_MAINACCOUNT_DESC = "无有效主账户";

	public final static String NOTICE_QUERYEXCEPTION_CODE = "001006";
	public final static String NOTICE_QUERYEXCEPTION_DESC = "查询通知信息异常";

	public final static String NOTICE_INSERTEXCEPTION_CODE = "001007";
	public final static String NOTICE_INSERTEXCEPTION_DESC = "插入查询通知异常";

	public final static String REGISTER_EXISTENCEEMAIL_CODE = "001008";
	public final static String REGISTER_EXISTENCEEMAIL_DESC = "此邮箱已被注册";

	public final static String REGISTER_EXCEPTION_CODE = "001009";
	public final static String REGISTER_EXCEPTION_DESC = "无法进行注册";

	public final static String REGISTER_EXISTENCEMOBILE_CODE = "001010";
	public final static String REGISTER_EXISTENCEMOBILE_DESC = "此手机号已被注册";

	public final static String REGISTER_EXISTENCEIDENTITY_CODE = "001011";
	public final static String REGISTER_EXISTENCEIDENTITY_DESC = "此证件已被注册";

	public final static String SERVICE_LISTERROR_CODE = "001012";
	public final static String SERVICE_LISTERROR_DESC = "获取服务列表异常";

	public final static String SERVICE_NOLISTINFO_CODE = "001013";
	public final static String SERVICE_NOLISTINFO_DESC = "服务列表为空";

	public final static String REGISTER_NOTNULL_CODE = "001014";
	public final static String REGISTER_NOTNULL_DESC = "必填字段不能为空";

	public final static String SERVMAINLIST_EXCPTION_CODE = "001015";
	public final static String SERVMAINLIST_EXCPTION_DESC = "获取服务列表异常";

	public final static String INITIALIZATION_EXCPTION_CODE = "001016";
	public final static String INITIALIZATION_EXCPTION_DESC = "初始化数据失败";

	public final static String CHECK_USERSERVICEALLOWEXP_CODE = "001017";
	public final static String CHECK_USERSERVICEALLOWEXP_DESC = "用户权限验证异常";

	public final static String CHECK_USERSERVICENOALLOW_CODE = "001018";
	public final static String CHECK_USERSERVICENOALLOW_DESC = "当前服务禁止访问";

	// 用户注册时，出现手机号和邮箱同时存在多个记录当中
	public final static String REGISTER_TOOMANYMAINUSER_CODE = "001019";
	public final static String REGISTER_TOOMANYMAINUSER_DESC = "该用户信息在系统中存在多条";

	public final static String REGISTER_UPDATEUSERFAIL_CODE = "001020";
	public final static String REGISTER_UPDATEUSERFAIL_DESC = "编辑用户信息失败";

	public final static String LOGIN_USERNOTLOGIN_CODE = "001021";
	public final static String LOGIN_USERNOTLOGIN_DESC = "当前用户没有登录";

	public final static String REGISTER_EXISTUSER_CODE = "001022";
	public final static String REGISTER_EXISTUSER_DESC = "此身份证号已关联登录账户，请联系管理员处理";

	public final static String REGISTER_UPLOADHEADPORTRAITERROR_CODE = "001023";
	public final static String REGISTER_UPLOADHEADPORTRAITERROR_DESC = "头像上传失败，请重新上传";

	public final static String REGISTER_WRONGIDCARD_CODE = "001024";
	public final static String REGISTER_WRONGIDCARD_DESC = "无效的身份证号";

	public final static String REGISTER_NOPROMOTER_CODE = "001025";
	public final static String REGISTER_NOPROMOTER_DESC = "未绑定服务专员";

	public final static String REGISTER_SYSNOEXISTPROMOTER_CODE = "001026";
	public final static String REGISTER_SYSNOEXISTPROMOTER_DESC = "系统中不存在服务专员信息，请联系管理员";

	public final static String LOGOUT_ERROR_CODE = "001027";
	public final static String LOGOUT_ERROR_DESC = "用户注销失败，请稍后重试！";

	public final static String FORGETPWD_NOEMAIL_CODE = "001028";
	public final static String FORGETPWD_NOEMAIL_DESC = "不存在此用户";

	public final static String FORGETPWD_CHECKEMAILFAIL_CODE = "001029";
	public final static String FORGETPWD_CHECKEMAILFAIL_DESC = "查询用户信息失败";

	public final static String FORGETPWD_SENDEMAILFAIL_CODE = "001030";
	public final static String FORGETPWD_SENDEMAILFAIL_DESC = "发送邮件失败";

	public final static String FORGETPWD_VERIFICATIONFAILURE_CODE = "001031";
	public final static String FORGETPWD_VERIFICATIONFAILURE_DESC = "页面已经失效";

	public final static String FORGETPWD_INVALIDURL_CODE = "001032";
	public final static String FORGETPWD_INVALIDURL_DESC = "无效的链接";

	public final static String FORGETPWD_PASSWORDWRONG_CODE = "001033";
	public final static String FORGETPWD_PASSWORDWRONG_DESC = "输入内容错误";

	public final static String FORGETPWD_RESETPASSWORDFAIL_CODE = "001034";
	public final static String FORGETPWD_RESETPASSWORDFAIL_DESC = "重置失败";

	public final static String FORGETPWD_INVALIDLOGINUSER_CODE = "001035";
	public final static String FORGETPWD_INVALIDLOGINUSER_DESC = "无效的账户";

	public final static String REGISTER_GENEMOBILEVALICODEFAIL_CODE = "001036";
	public final static String REGISTER_GENEMOBILEVALICODEFAIL_DESC = "生成手机验证码失败，请重试";

	public final static String REGISTER_MOBILEVALICODEMISS_CODE = "001037";
	public final static String REGISTER_MOBILEVALICODEMISS_DESC = "手机验证码已失效，请重新发送";

	public final static String REGISTER_MOBILEVALICODEWRONG_CODE = "001038";
	public final static String REGISTER_MOBILEVALICODEWRONG_DESC = "手机验证码错误，请重新输入";

	public final static String PERSONALCENTER_CHANGEPWDFAIL_CODE = "001039";
	public final static String PERSONALCENTER_CHANGEPWDFAIL_DESC = "修改密码失败";

	public final static String PERSONALCENTER_NOUSERFIND_CODE = "001040";
	public final static String PERSONALCENTER_NOUSERFIND_DESC = "修改密码失败";

	public final static String PERSONALCENTER_GETPERSONINFOFAIL_CODE = "001041";
	public final static String PERSONALCENTER_GETPERSONINFOFAIL_DESC = "获取个人信息失败";

	public final static String PERSONALCENTER_UPDATEPERSONINFOFAIL_CODE = "001042";
	public final static String PERSONALCENTER_UPDATEPERSONINFOFAIL_DESC = "编辑个人信息失败";

	public final static String LOGIN_USERNORELATION_CODE = "001043";
	public final static String LOGIN_USERNORELATION_DESC = "用户未授权登录系统";

	public final static String REGISTER_INSERTLOGINUSERERROR_CODE = "001044";
	public final static String REGISTER_INSERTLOGINUSERERROR_DESC = "用户授权登录失败，请稍后重试";

	public final static String LOGIN_EBZERROR_CODE = "001045";
	public final static String LOGIN_EBZERROR_DESC = "对接医保账接口发生错误";

	public final static String PERSONALCENTER_NOMOBLIE_CODE = "001046";
	public final static String PERSONALCENTER_NOMOBLIE_DESC = "未绑定手机号";

	public final static String PERSONALCENTER_GETMOBILEFAIL_CODE = "001047";
	public final static String PERSONALCENTER_GETMOBILEFAIL_DESC = "查询数据失败";

	public final static String PERSONALCENTER_NOEMAIL_CODE = "001048";
	public final static String PERSONALCENTER_NOEMAIL_DESC = "未绑定邮箱";

	public final static String PERSONALCENTER_SETUPMOBILEFAIL_CODE = "001049";
	public final static String PERSONALCENTER_SETUPMOBILEFAIL_DESC = "解绑用户手机失败，请刷新重试";

	public final static String PROMOTER_GETPROMOTERUSERFAIL_CODE = "001050";
	public final static String PROMOTER_GETPROMOTERUSERFAIL_DESC = "查询数据失败";

	public final static String PROMOER_NOUSER_CODE = "001051";
	public final static String PROMOER_NOUSER_DESC = "此用户未被注册为服务专员";

	public final static String FORGET_NOMOBILEANDEMAIL_CODE = "001052";
	public final static String FORGET_NOMOBILEANDEMAIL_DESC = "此账户未绑定手机或邮箱";

	public final static String FORGET_NOACCOUNT_CODE = "001053";
	public final static String FORGET_NOACCOUNT_DESC = "此账号未注册";

	public final static String FORGET_SENDMESSAGEFAIL_CODE = "001054";
	public final static String FORGET_SENDMESSAGEFAIL_DESC = "短信发送失败，请重新发送";

	public final static String FORGET_VALIDATECODEFAIL_CODE = "001055";
	public final static String FORGET_VALIDATECODEFAIL_DESC = "验证失败";

	public final static String FORGET_VALIDATECODEWRONG_CODE = "001056";
	public final static String FORGET_VALIDATECODEWRONG_DESC = "验证码错误，请重新输入";

	public final static String FORGET_VALIDATECODEINVALID_CODE = "001057";
	public final static String FORGET_VALIDATECODEINVALID_DESC = "验证码已失效，请重新获取";

	public final static String AUTHENTICATION_DIFFERENTPHONE_CODE = "001058";
	public final static String AUTHENTICATION_DIFFERENTPHONE_DESC = "此手机号与注册手机号不同";

	public final static String AUTH_NULLNAME_CODE = "001059";
	public final static String AUTH_NULLNAME_DESC = "用户名不可为空";

	public final static String AUTH_NULLIDENTTYPE_CODE = "001060";
	public final static String AUTH_NULLIDENTTYPE_DESC = "证件类型不可为空";

	public final static String AUTH_NULLIDENTNUMS_CODE = "001061";
	public final static String AUTH_NULLIDENTNUMS_DESC = "证件号码不可为空";

	public final static String AUTH_NULLMOBILEPHONE_CODE = "001062";
	public final static String AUTH_NULLMOBILEPHONE_DESC = "手机号不可为空";

	public final static String AUTH_SAVEUSERFAIL_CODE = "001063";
	public final static String AUTH_SAVEUSERFAIL_DESC = "保存用户失败";

	public final static String AUTH_SAVEUSERERROR_CODE = "001064";
	public final static String AUTH_SAVEUSERERROR_DESC = "系统异常，上传失败";

	public final static String AUTH_NULLSERVIDS_CODE = "001065";
	public final static String AUTH_NULLSERVIDS_DESC = "用户服务id不可为空";

	public final static String FORGET_VALIDATECODEOFTEN_CODE = "001066";
	public final static String FORGET_VALIDATECODEOFTEN_DESC = "发送验证码太过频繁，请稍后再进行操作.";

	public final static String REGISTER_AUTHED_CODE = "001067";
	public final static String REGISTER_AUTHED_DESC = "此用户系统中已存在";

	public final static String REQUEST_YZLREQERROE_CODE = "001070";
	public final static String REQUEST_YZLREQERROE_DESC = "请求IMG异常！";

	public final static String REQUEST_YZLREQINFOERROE_CODE = "001071";
	public final static String REQUEST_YZLREQINFOERROE_DESC = "请求IMG发生错误！";

	public final static String SERV_USER_ACCREDIT_CODE = "001072";
	public final static String SERV_USER_ACCREDIT_DESC = "用户授权失败！";
	
	public final static String SERV_USER_ACCREDIT_SERVICEID__CODE = "001073";
	public final static String SERV_USER_ACCREDIT_SERVICEID_DESC = "服务ID为空！";
	
	public final static String SERV_USER_ACCREDIT_SERVICE_CODE = "001074";
	public final static String SERV_USER_ACCREDIT_SERVICE_DESC = "没有查到服务！";
	
}
