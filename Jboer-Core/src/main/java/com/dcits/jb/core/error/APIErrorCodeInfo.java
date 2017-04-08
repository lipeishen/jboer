package com.dcits.jb.core.error;

/**
 *
 * @author jiaomy <jiaomy , jiaomy@chaizhao.org>
 */
public class APIErrorCodeInfo {

    public final static String RESULT_OK_CODE = "0";
    public final static String RESULT_OK_DESC = "ok";

    public final static String RESULT_ERR_CODE = "00001";
    public final static String RESULT_ERR_DESC = "服务器异常，注册失败";

    public final static String RESULT_EXISTENCEMOBILE_CODE = "00002";
    public final static String RESULT_EXISTENCEMOBILE_DESC = "手机号已被注册";

    public final static String RESULT_EXISTENCENAME_CODE = "00003";
    public final static String RESULT_EXISTENCENAME_DESC = "用户名已被注册";

    public final static String RESULT_PASSERR_CODE = "00004";
    public final static String RESULT_PASSERR_DESC = "密码错误";

    public final static String RESULT_NULLUSER_CODE = "00005";
    public final static String RESULT_NULLUSER_DESC = "用户信息不存在";

    public final static String RESULT_NULLHARDWARE_CODE = "00006";
    public final static String RESULT_NULLHARDWARE_DESC = "硬件不存在";

    public final static String RESULT_NULLUSERID_CODE = "00007";
    public final static String RESULT_NULLUSERID_DESC = "用户id不为空";

    public final static String RESULT_NULLUSERMAIN_CODE = "00008";
    public final static String RESULT_NULLUSERMAIN_DESC = "硬件不存在";
}
