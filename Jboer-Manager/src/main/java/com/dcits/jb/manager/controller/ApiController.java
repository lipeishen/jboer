package com.dcits.jb.manager.controller;

import com.dcits.jb.core.error.APIErrorCodeInfo;
import com.dcits.jb.core.util.MD5Util;
import com.dcits.jb.core.util.StringUtil;
import com.dcits.jb.core.util.UuidUtil;
import com.dcits.jb.core.util.VilidateUtil;
import com.dcits.jb.manager.service.ApiService;
import com.dcits.jb.manager.single.model.BhAuthUserLogin;
import com.dcits.jb.manager.single.model.BhAuthUserMain;
import com.dcits.jb.manager.single.model.BhMachineUserRel;
import com.dcits.jb.manager.single.model.BhSysUserLoginInfo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jiaomy
 */
@Controller
@RequestMapping("/api/v1/user")
public class ApiController {

    private Logger logger = Logger.getLogger(UserController.class);
    private Map<String, Object> ResponseMap;
    private JSONObject result;
    @Autowired
    ApiService apiService;

    /**
     * 手机号码注册
     *
     * @param request
     * @param phoneNum	：手机号
     * @param loginPwd	：密码
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    @ResponseBody
    public String customerRegister(
            HttpServletRequest request) throws Exception {
    	String phoneNum = "1337171773075";
    	String loginPwd = "1111111";
        //如有验证逻辑，如需要验证短信验证码等，则按业务逻辑进行验证
        //判断客户名（手机号）是否存在
        BhAuthUserLogin bhAuthUserLogin = this.apiService.getBhAuthUserLoginByLoginName(phoneNum);
        ResponseMap = new HashMap<String, Object>();
        if (bhAuthUserLogin == null) {
            //用户名未被注册
            bhAuthUserLogin = new BhAuthUserLogin();
            bhAuthUserLogin.setUserId(UUID.randomUUID().toString());
            bhAuthUserLogin.setLoginId(bhAuthUserLogin.getUserId());
            bhAuthUserLogin.setLoginName(phoneNum);
            bhAuthUserLogin.setLoginPwd(loginPwd);
            bhAuthUserLogin.setLoginWay("2");
            bhAuthUserLogin.setCreateDate(new Date().toString());
            bhAuthUserLogin.setModifyDate(bhAuthUserLogin.getCreateDate());

            if (this.apiService.saveBhAuthUserLogin(bhAuthUserLogin)) {
                ResponseMap.put("resultCode", APIErrorCodeInfo.RESULT_OK_CODE);
                ResponseMap.put("resultMsg", APIErrorCodeInfo.RESULT_OK_DESC);
                result = JSONObject.fromObject(ResponseMap);
                logger.info(result);
                return result.toString();
            } else {
                ResponseMap.put("resultCode", APIErrorCodeInfo.RESULT_ERR_CODE);
                ResponseMap.put("resultMsg", APIErrorCodeInfo.RESULT_ERR_DESC);
                result = JSONObject.fromObject(ResponseMap);
                logger.info(result);
                return result.toString();
            }
        } else {
            //用户名已被注册
            ResponseMap.put("resultCode", APIErrorCodeInfo.RESULT_EXISTENCEMOBILE_CODE);
            ResponseMap.put("resultMsg", APIErrorCodeInfo.RESULT_EXISTENCEMOBILE_DESC);
            result = JSONObject.fromObject(ResponseMap);
            logger.info(result);
            return result.toString();
        }
    }

    /**
     * 客户登录（用户名，密码）
     *
     * @param request
     * @param phoneNum	：客户登录号
     * @param loginPwd	：登录密码
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    @ResponseBody
    public String customerLogin(
            HttpServletRequest request, String phoneNum, String loginPwd
    ) throws Exception {
        ResponseMap = new HashMap<String, Object>();
        BhAuthUserLogin bhAuthUserLogin = this.apiService.getBhAuthUserLoginByLoginName(phoneNum);
        if (bhAuthUserLogin == null) {
            //客户信息不存
            ResponseMap.put("resultCode", APIErrorCodeInfo.RESULT_NULLUSER_CODE);
            ResponseMap.put("resultMsg", APIErrorCodeInfo.RESULT_NULLUSER_DESC);
            result = JSONObject.fromObject(ResponseMap);
            return result.toString();
        } else //客户信息存
        {
            if (loginPwd.equals(bhAuthUserLogin.getLoginPwd())) {
                ResponseMap.put("resultCode", APIErrorCodeInfo.RESULT_OK_CODE);
                ResponseMap.put("resultMsg", APIErrorCodeInfo.RESULT_OK_DESC);
                HashMap rhmap = new HashMap<String, Object>();
                rhmap.put("userid", bhAuthUserLogin.getUserId());
                ResponseMap.put("resultData", JSONObject.fromObject(rhmap));
                result = JSONObject.fromObject(ResponseMap);
                return result.toString();
            } else {
                ResponseMap.put("resultCode", APIErrorCodeInfo.RESULT_PASSERR_CODE);
                ResponseMap.put("resultMsg", APIErrorCodeInfo.RESULT_PASSERR_DESC);
                result = JSONObject.fromObject(ResponseMap);
                return result.toString();
            }
        }
    }

    /**
     *
     * @param request
     * @param userId ：用户唯一ID
     * @param hardwareID ：智能硬件唯一ID
     * @param hardwareMac ：智能硬件唯一Mac
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/Bind", method = RequestMethod.GET)
    @ResponseBody
    public String customerBind(HttpServletRequest request, String userId, String hardwareID, String hardwareMac) throws Exception {
        ResponseMap = new HashMap<String, Object>();
        BhMachineUserRel bhMachineUserRel = this.apiService.getBhMachineUserRelByUserId(userId);

        if (bhMachineUserRel == null) {
            //用户未绑定
            bhMachineUserRel = new BhMachineUserRel();
            bhMachineUserRel.setSurname(UUID.randomUUID().toString());
            bhMachineUserRel.setUserId(userId);
            bhMachineUserRel.setMachineId(hardwareID);
            bhMachineUserRel.setMachineMac(hardwareMac);
            bhMachineUserRel.setBindDate(new Date());
            if (this.apiService.SaveBhMachineUserRel(bhMachineUserRel)) {
                ResponseMap.put("resultCode", APIErrorCodeInfo.RESULT_OK_CODE);
                ResponseMap.put("resultMsg", APIErrorCodeInfo.RESULT_OK_DESC);
                result = JSONObject.fromObject(ResponseMap);
                logger.info(result);
                return result.toString();
            } else {
                ResponseMap.put("resultCode", APIErrorCodeInfo.RESULT_ERR_CODE);
                ResponseMap.put("resultMsg", APIErrorCodeInfo.RESULT_ERR_DESC);
                result = JSONObject.fromObject(ResponseMap);
                logger.info(result);
                return result.toString();
            }
        } else {
            //用户已绑定
            ResponseMap.put("resultCode", APIErrorCodeInfo.RESULT_EXISTENCEMOBILE_CODE);
            ResponseMap.put("resultMsg", APIErrorCodeInfo.RESULT_EXISTENCEMOBILE_DESC);
            result = JSONObject.fromObject(ResponseMap);
            logger.info(result);
            return result.toString();
        }

    }

    //保存个人详细信息
    /**
     *
     * @param request
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/UserInfo", method = RequestMethod.GET)
    @ResponseBody
    public String customerUserMainInfo(HttpServletRequest request, String userId) throws Exception {
        ResponseMap = new HashMap<String, Object>();
        BhAuthUserMain userMain = new BhAuthUserMain();
        userMain.setUserId(request.getParameter("userId"));
        userMain.setUserId(request.getParameter("userId"));
        userMain.setUserId(request.getParameter("userId"));
        userMain.setUserId(request.getParameter("userId"));
        userMain.setUserId(request.getParameter("userId"));
        String msg = vilidate(userMain);
        if (!msg.equals("")) {
            ResponseMap.put("resultCode", APIErrorCodeInfo.RESULT_ERR_CODE);
            ResponseMap.put("resultMsg", msg);
            result = JSONObject.fromObject(ResponseMap);
            logger.info(result);
            return result.toString();
        }

            if (this.apiService.SaveBhAuthUserMain(userMain)) {
                ResponseMap.put("resultCode", APIErrorCodeInfo.RESULT_OK_CODE);
                ResponseMap.put("resultMsg", APIErrorCodeInfo.RESULT_OK_DESC);
                result = JSONObject.fromObject(ResponseMap);
                return result.toString();

            } else {
                ResponseMap.put("resultCode", APIErrorCodeInfo.RESULT_ERR_CODE);
                ResponseMap.put("resultMsg", APIErrorCodeInfo.RESULT_ERR_DESC);
                result = JSONObject.fromObject(ResponseMap);
                logger.info(result);
                return result.toString();
            }
    }

    @RequestMapping(value = "/GetUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public String GetUserInfo(HttpServletRequest request, String userId) throws Exception {
        ResponseMap = new HashMap<String, Object>();
        if (userId == null) {
            ResponseMap.put("resultCode", APIErrorCodeInfo.RESULT_NULLUSERID_CODE);
            ResponseMap.put("resultMsg", APIErrorCodeInfo.RESULT_NULLUSERID_DESC);
            result = JSONObject.fromObject(ResponseMap);
            return result.toString();
        }
        BhAuthUserMain bhAuthUserMain = this.apiService.getBhAuthUserMainByUserId(userId);
        if (bhAuthUserMain == null) {
            ResponseMap.put("resultCode", APIErrorCodeInfo.RESULT_NULLUSERMAIN_CODE);
            ResponseMap.put("resultMsg", APIErrorCodeInfo.RESULT_NULLUSERMAIN_DESC);
            result = JSONObject.fromObject(ResponseMap);
            return result.toString();
        } else {
            ResponseMap.put("resultCode", APIErrorCodeInfo.RESULT_OK_CODE);
            ResponseMap.put("resultMsg", APIErrorCodeInfo.RESULT_OK_DESC);
            ResponseMap.put("resultData", bhAuthUserMain);
            result = JSONObject.fromObject(ResponseMap);
            return result.toString();
        }
    }


    private String vilidate(BhAuthUserMain authUser) {
        String mesg = "";
        String name = authUser.getName();
        String mobilePhone = authUser.getMobilePhone();
        String email = authUser.getEmail();
        if (name.length() > 25) {
            mesg = "用户名称输入过长！";
            return mesg;
        }

        if (!StringUtil.getNullStr(email).equals("")) {
            if (email.length() > 50) {
                mesg = "邮箱输入过长！";
                return mesg;
            } else if (!VilidateUtil.isEmail(email)) {
                mesg = "请输入正确格式的电子邮件!";
                return mesg;
            }
        }
        if (!StringUtil.getNullStr(mobilePhone).equals("")) {
            if (!VilidateUtil.isMobileNO(mobilePhone)) {
                mesg = "请输入正确格式的手机号,如13399998888!";
                return mesg;
            }
        }
        return mesg;
    }

}
