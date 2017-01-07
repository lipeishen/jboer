package com.dcits.jb.core.error;
/** 
  * @author  xingyxa 
  * @date 创建时间：2016年3月19日 下午2:59:10 
  * @version 1.0 
  * @since  1.8 
*/
public class ExaminationErrorCodeInfo {
	public final static String EXAMINATION_RECORDQUERY_SUCCESS_CODE = "009001";
	public final static String EXAMINATION_RECORDQUERY_SUCCESS_DESC = "查询成功";
	
	public final static String EXAMINATION_RECORDQUERY_ERROR_CODE = "009002";
	public final static String EXAMINATION_RECORDQUERY_ERROR_DESC = "查询失败";
	
	public final static String EXAMINATION_RECORDQUERY_FAIL_CODE = "009003";
	public final static String EXAMINATION_RECORDQUERY_FAIL_DESC = "查询条件不能为空";
	
	public final static String EXAMINATION_RECORDPARAM_ERROR_CODE = "009004";
	public final static String EXAMINATION_RECORDPARAM_ERROR_DESC = "查询参数有误";
	
	public final static String EXAMINATION_PAGEPARAM_ERROR_CODE = "009005";
	public final static String EXAMINATION_PAGEPARAM_ERROR_DESC = "分页条件有误";
	
	public final static String EXAMINATION_STATUSPARAM_ERROR_CODE = "009006";
	public final static String EXAMINATION_STATUSPARAM_ERROR_DESC = "体检状态不可为空";
	
	public final static String EXAMINATION_USERPARAM_ERROR_CODE = "009007";
	public final static String EXAMINATION_USERPARAM_ERROR_DESC = "证件类型和证件号码不可为空";
	
	public final static String EXAMINATION_RECORDQUERY_NULL_CODE = "009008";
	public final static String EXAMINATION_RECORDQUERY_NULL_DESC = "未查询到数据";
	
	public final static String EXAMINATION_CARDINFO_INVALID_CODE = "009009";
	public final static String EXAMINATION_CARDINFO_INVALID_DESC = "该卡已过失效日期，无法使用";
	
	public final static String EXAMINATION_NULLCAPACITY_ERROR_CODE = "009011";
	public final static String EXAMINATION_NULLCAPACITY_ERROR_DESC = "已约满，请选择其他时间或体检中心";

	public final static String EXAMINATION_GETCENTER_ERROR_CODE = "009012";
	public final static String EXAMINATION_GETCENTER_ERROR_DESC = "获取体检中心信息失败";
	
	public final static String EXAMINATION_GETDURATION_ERROR_CODE = "009013";
	public final static String EXAMINATION_GETDURATION_ERROR_DESC = "获取体检时段记录信息失败";
	
	public final static String EXAMINATION_CARDINFO_ERROR_CODE = "009014";
	public final static String EXAMINATION_CARDINFO_ERROR_DESC = "该卡绑定失败";
	
	public final static String EXAMINATION_CARDINFO_VALIDE_CODE = "009015";
	public final static String EXAMINATION_CARDINFO_VALIDE_DESC = "输入验证信息不正确";
	
	public final static String EXAMINATION_EXAMINATIONDATE_ERROR_CODE = "009016";
	public final static String EXAMINATION_EXAMINATIONDATE_ERROR_DESC = "请预约今天以后的日期";

	public final static String EXAMINATION_GETEXAMORDER_ERROR_CODE = "009017";
	public final static String EXAMINATION_GETEXAMORDER_ERROR_DESC = "获取体检预约权益信息失败";

	public final static String EXAMINATION_EXAMORDERSTATUS_ERROR_CODE = "009018";
	public final static String EXAMINATION_EXAMORDERSTATUS_ERROR_DESC = "该体检预约权益不是可预约状态";
	
	public final static String EXAMINATION_OUTEXAMORDERDATE_ERROR_CODE = "009019";
	public final static String EXAMINATION_OUTEXAMORDERDATE_ERROR_DESC = "该体检预约权益已过有效期";
	
	public final static String EXAMINATION_ORDERPARAM_DURATIONID_NULL_CODE = "009021";
	public final static String EXAMINATION_ORDERPARAM_DURATIONID_NULL_DESC = "时间段信息不可为空";

	public final static String EXAMINATION_ORDERPARAM_AREAID_NULL_CODE = "009022";
	public final static String EXAMINATION_ORDERPARAM_AREAID_NULL_DESC = "地区信息不可为空";

	public final static String EXAMINATION_ORDERPARAM_CENTERID_NULL_CODE = "009023";
	public final static String EXAMINATION_ORDERPARAM_CENTERID_NULL_DESC = "体检中心信息不可为空";

	public final static String EXAMINATION_ORDERPARAM_EXAMINATIONDATE_NULL_CODE = "009024";
	public final static String EXAMINATION_ORDERPARAM_EXAMINATIONDATE_NULL_DESC = "体检日期不可为空";

	public final static String EXAMINATION_ORDERPARAM_DURATIONRECORDID_NULL_CODE = "009025";
	public final static String EXAMINATION_ORDERPARAM_DURATIONRECORDID_NULL_DESC = "排班信息不可为空";

	public final static String EXAMINATION_ORDERPARAM_EXAMINATIONDATE_FORMAT_CODE = "009026";
	public final static String EXAMINATION_ORDERPARAM_EXAMINATIONDATE_FORMAT_DESC = "体检日期格式不对";
	
	public final static String EXAMINATION_ORDERPARAM_ITEMTYPEID_NULL_CODE = "009027";
	public final static String EXAMINATION_ORDERPARAM_ITEMTYPEID_NULL_DESC = "体检项目类型不能为空";

	public final static String EXAMINATION_ORDERRECORD_ERROR_CODE = "009029";
	public final static String EXAMINATION_ORDERRECORD_ERROR_DESC = "体检预约失败";
	
	public final static String EXAMINATION_CARDPARAM_CODE_NULL_CODE = "009031";
	public final static String EXAMINATION_CARDPARAM_CODE_NULL_DESC = "卡号不可为空";

	public final static String EXAMINATION_CARDPARAM_TIME_NULL_CODE = "009032";
	public final static String EXAMINATION_CARDPARAM_TIME_NULL_DESC = "体检卡验证信息不可为空";
	
	public final static String EXAMINATION_CARDPARAM_USERID_NULL_CODE = "009033";
	public final static String EXAMINATION_CARDPARAM_USERID_NULL_DESC = "用户ID不可为空";
	
	public final static String EXAMINATION_CARDPARAM_ITEMID_NULL_CODE = "009034";
	public final static String EXAMINATION_CARDPARAM_ITEMID_NULL_DESC = "体检项信息不可为空";
	
	public final static String EXAMINATION_GETCAPACITY_ERROR_CODE = "009035";
	public final static String EXAMINATION_GETCAPACITY_ERROR_DESC = "当前可承载人数为空";

	public final static String EXAMINATION_GETSTATUS_ERROR_CODE = "009036";
	public final static String EXAMINATION_GETSTATUS_ERROR_DESC = "该体检记录未启用";
	
	public final static String EXAMINATION_CARDBIND_ISEXIST_CODE = "009037";
	public final static String EXAMINATION_CARDBIND_ISEXIST_DESC = "不存在此卡号";
	
	public final static String EXAMINATION_INTERFACE_AUTHIDERROR_CODE= "009038";
	public final static String EXAMINATION_INTERFACE_AUTHIDERROR_DESC = "authId不正确";
	
	public final static String EXAMINATION_INTERFACE_SYSERROR_CODE= "009039";
	public final static String EXAMINATION_INTERFACE_SYSERROR_DESC = "系统错误，可能是参数格式不正确，请联系管理员处理";
	
	public final static String EXAMINATION_ORDER_RECORD_CODE= "009040";
	public final static String EXAMINATION_ORDER_RECORD_DESC = "recordId不正确";
	
	public final static String EXAMINATION_ORDER_RECORDCANCEL_CODE= "009041";
	public final static String EXAMINATION_ORDER_RECORDCANCEL_DESC = "体检预约取消失败！";
		
	public final static String EXAMINATION_ORDERPARAM_ENTITLEID_NULL_CODE = "009042";
	public final static String EXAMINATION_ORDERPARAM_ENTITLEID_NULL_DESC = "权益信息不可为空";
	
	public final static String EXAMINATION_ORDERPARAM_EXAMUSERNAME_NULL_CODE = "009043";
	public final static String EXAMINATION_ORDERPARAM_EXAMUSERNAME_NULL_DESC = "预约人姓名不可为空";
	
	public final static String EXAMINATION_ORDERPARAM_MOBILEPHONE_NULL_CODE = "009044";
	public final static String EXAMINATION_ORDERPARAM_MOBILEPHONE_NULL_DESC = "手机号不可为空";
	
	public final static String EXAMINATION_ORDERPARAM_ENTITLECOUNT_NULL_CODE = "009045";
	public final static String EXAMINATION_ORDERPARAM_ENTITLECOUNT_NULL_DESC = "未查询到可用的权益";
	
	public final static String EXAMINATION_ORDER_RECORDCANCELDATE_CODE= "009046";
	public final static String EXAMINATION_ORDER_RECORDCANCELDATE_DESC = "体检日期在2天以内，无法取消！";
	
	public final static String EXAMINATION_ORDER_RECORDDATE_BEFORENOW_CODE= "009047";
	public final static String EXAMINATION_ORDER_RECORDDATE_BEFORENOW_DESC = "体检日期已过期，无法取消！";
	
	public final static String EXAMINATION_ORDER_SERVICEID_CODE= "009048";
	public final static String EXAMINATION_ORDER_SERVICEID_DESC = "服务内容不能为空";
	
	public final static String EXAMINATION_ORDER_SERVICEINFO_CODE= "009049";
	public final static String EXAMINATION_ORDER_SERVICEINFO_DESC = "未查询到该服务详细信息";
	
	public final static String EXAMINATION_ORDER_PROMOTOR_CODE= "009050";
	public final static String EXAMINATION_ORDER_PROMOTOR_DESC = "未查询到对应的服务专员！";
	
	public final static String EXAMINATION_SERVICE_RECORD_CODE= "009051";
	public final static String EXAMINATION_SERVICE_RECORD_DESC = "更新服务记录表失败！";
	
	public final static String EXAMINATION_GETUSER_ERROR_CODE = "009052";
	public final static String EXAMINATION_GETUSER_ERROR_DESC = "用户未登录";
	
	

	

}
