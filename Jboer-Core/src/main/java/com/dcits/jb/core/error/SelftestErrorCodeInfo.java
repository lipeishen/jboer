package com.dcits.jb.core.error;
/** 
  * 疾病自查错误代码及信息
  * @author  xingyxa 
  * @date 创建时间：2016年3月14日 下午3:20:08 
  * @version 1.0 
  * @since  1.8 
*/
public class SelftestErrorCodeInfo {
	public final static String SELFTEST_DISEASEQUERY_SUCCESS_CODE = "007001";
	public final static String SELFTEST_DISEASEQUERY_SUCCESS_DESC = "查询成功";
	
	public final static String SELFTEST_DISEASEQUERY_ERROR_CODE = "007002";
	public final static String SELFTEST_DISEASEQUERY_ERROR_DESC = "查询失败";
	
	public final static String SELFTEST_DISEASEQUERY_FAIL_CODE = "007003";
	public final static String SELFTEST_DISEASEQUERY_FAIL_DESC = "查询条件不能为空";
	
	public final static String SELFTEST_DISEASEQUERY_NULL_CODE = "007004";
	public final static String SELFTEST_DISEASEQUERY_NULL_DESC = "暂时未查询到数据";
	
	public final static String SELFTEST_DISEASEQUERYID_NULL_CODE = "007005";
	public final static String SELFTEST_DISEASEQUERYID_NULL_DESC = "用户唯一标识不能为空";
	
	public final static String SELFTEST_DISEASEQUERYSTATUS_NULL_CODE = "007006";
	public final static String SELFTEST_DISEASEQUERYSTATUS_NULL_DESC = "问题类型不能为空";
	
	public final static String SELFTEST_DISEASEQUERYTYPE_ERROR_CODE = "007007";
	public final static String SELFTEST_DISEASEQUERYTYPE_ERROR_DESC = "请完成上级的全部测试";
	
	public final static String SELFTEST_DISEASEQUERYQUESTION_NULL_CODE = "007009";
	public final static String SELFTEST_DISEASEQUERYQUESTION_NULL_DESC = "测试问题项不能为空";
	
	public final static String SELFTEST_GETUSER_ERROR_CODE = "007010";
	public final static String SELFTEST_GETUSER_ERROR_DESC = "用户未登录";
	
	public final static String SELFTEST_GETITEM_ERROR_CODE = "007011";
	public final static String SELFTEST_GETITEM_ERROR_DESC = "未查询到该自测题目";
	
	public final static String SELFTEST_QUERY_ERROR_CODE = "007012";
	public final static String SELFTEST_QUERY_ERROR_DESC = "查询条件不正确";
}
