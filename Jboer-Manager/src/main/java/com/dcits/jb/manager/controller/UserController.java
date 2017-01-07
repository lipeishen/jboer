package com.dcits.jb.manager.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcits.jb.core.util.MD5Util;
import com.dcits.jb.core.util.StringUtil;
import com.dcits.jb.manager.service.UserService;
import com.dcits.jb.manager.service.UserSystemService;
import com.dcits.jb.manager.single.model.BhSysUserLoginInfo;
import com.dcits.jb.manager.util.KaptchaUtil;
import com.dcits.jb.manager.util.SessionUtil;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {
	private Logger logger = Logger.getLogger(UserController.class);
	
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="userSystemService")
	private UserSystemService userSystemService;
	
	@Autowired
	private Producer producer;
	
	@RequestMapping("/loginView")
	public String loginView(HttpServletResponse response) {
		response.setHeader("x-frame-options","DENY");
		return "login";
	}
	
	@RequestMapping("/filterNoAuthority")
	public String filterNoAuthority() {
		return "/error/filterNoAuthority";
	}
	
	@RequestMapping("/filterMiddlePage")
	public String filterMiddlePage() {
		return "/error/filterMiddlePage";
	}
	
	@RequestMapping(value = "/isLogin")
	public String isLogin(HttpServletRequest request,Model model,HttpServletResponse response){
		//判断是否登录
		response.setHeader("x-frame-options","DENY");
		try{
			BhSysUserLoginInfo bhSysUserLoginInfo = SessionUtil.getSessionUser(request);
			if(bhSysUserLoginInfo != null){
				return "index";
			}
		}catch(Exception e){
			logger.error(e);
		}
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest request,String loginName,String password,String validateCode,Model model){
		//判断是否登录
		try{
			BhSysUserLoginInfo bhSysUserLoginInfo = SessionUtil.getSessionUser(request);
			if(bhSysUserLoginInfo != null){
				return "ok";
			}
		}catch(Exception e){
			logger.error(e);
		}
		if(validateCode == null || validateCode.equals("")){
			return "validateCode";
		}
		boolean isVal = KaptchaUtil.validateKaptcha(request, validateCode);
		if (!isVal) {
			return "validateCode";
		}
		if(loginName == null || "".equals(loginName) || password == null || "".equals(password)){
			return "param";
		}
		//登录验证
		BhSysUserLoginInfo bhSysUserLoginInfo = userService.checkUserLogin(loginName, password);
		if(bhSysUserLoginInfo == null || bhSysUserLoginInfo.getUserId() == null || "".equals(bhSysUserLoginInfo.getUserId())){
			return "userpwd";
		}
		
		//获取权限信息
		List<Map<String,String>> modularList = userService.getModulerList(bhSysUserLoginInfo);
		if(modularList == null || modularList.size() < 1){
			return "allow";
		}
		//模块排序
		Collections.sort(modularList,new Comparator<Map<String,String>>() {//内部类
            public int compare(Map<String,String> arg0, Map<String,String> arg1) {
            	String modularCode0  = arg0.get("modularCode");
            	String modularCode1  = arg1.get("modularCode");
                return modularCode0.compareTo(modularCode1);
            }
		});
		//提取头模块
		List<Map<String,String>> modularHeadList = new ArrayList<Map<String,String>>();
		for(int i = 0;i < modularList.size();i++){
			Map<String,String> modularMap = modularList.get(i);
			if("00000000000000000000000000000000".equals(modularMap.get("modularParentId"))){
				modularHeadList.add(modularMap);
			}
		}
		
		//缓入session
		SessionUtil.setSessionUser(request, bhSysUserLoginInfo);
		SessionUtil.setSessionModularList(request, modularList);
		SessionUtil.setSessionModularHeadList(request, modularHeadList);
		return "ok";
	}
	
	@RequestMapping("/exitUser")
	public String exitUser(HttpServletRequest request) {
		SessionUtil.removeAll(request);
		return "login";
	}
	
	@RequestMapping("/getOrgIdTree")
	@ResponseBody
	public String getOrgIdTree(HttpServletRequest request,String modularId){
		List<Map<String,String>> modularList = SessionUtil.getSessionModularList(request);
		String orgIds = "";
		for(int i = 0;i < modularList.size();i++){
			Map<String,String> modular = modularList.get(i);
			String modularIds = modular.get("modularId");
			if(modularId.equals(modularIds)){
				orgIds = modular.get("orgIds");
				break;
			}
		}
		if(orgIds != null && !orgIds.equals("")){
			String jsonStr = userService.getOrgListByOrgIds(orgIds);
			return jsonStr;
		}else{
			return "";
		}
	}
	
	@RequestMapping("/addJgReflushOrgIdTree")
	@ResponseBody
	public String getJgOrgIdTree(HttpServletRequest request,String modularId){
		BhSysUserLoginInfo bhSysUserLoginInfo = SessionUtil.getSessionUser(request);
		List<Map<String,String>> modularList = userService.getModulerList(bhSysUserLoginInfo);
		SessionUtil.setSessionModularList(request, modularList);
		String orgIds = "";
		for(int i = 0;i < modularList.size();i++){
			Map<String,String> modular = modularList.get(i);
			String modularIds = modular.get("modularId");
			if(modularId.equals(modularIds)){
				orgIds = modular.get("orgIds");
				break;
			}
		}
		if(orgIds != null && !orgIds.equals("")){
			String jsonStr = userService.getOrgListByOrgIds(orgIds);
			return jsonStr;
		}else{
			return "";
		}
	}
	
	/**
	 * 验证密码
	 * @param request
	 * @return String
	 */
	@RequestMapping("/valiPass")
	@ResponseBody
	public String valiPass(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String loginName = SessionUtil.getSessionUser(request).getLoginName();
			String password = request.getParameter("password");
			BhSysUserLoginInfo bhSysUserLoginInfo = userService.checkUserLogin(loginName, password);
			if(bhSysUserLoginInfo == null || bhSysUserLoginInfo.getUserId() == null || "".equals(bhSysUserLoginInfo.getUserId())){
				result.put("success", false);
				result.put("errorMsg", "原密码错误！");
			}else {
				result.put("success", true);
			}
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		} catch (Exception e) {
			logger.error(e,e);
			result.put("errorMsg", "验证原密码失败！");
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		}
	}
	//lijufa
	/**
	 * 获取登录用户信息
	 * @author lijufa
	 * @date 2016年2月23日
	 * @param request
	 * @return
	 */
	@RequestMapping("/toUserInfo")
	public String toOrgInfoList(HttpServletRequest request,Model model) {
		//查询登录用户信息
		BhSysUserLoginInfo bhSysUserLoginInfo = SessionUtil.getSessionUser(request);
		if(bhSysUserLoginInfo == null){
			return "login";
		}else{
			request.setAttribute("sysuser", bhSysUserLoginInfo);
		}
		return "/userSystem/userInfo/selfuserEdit";
	}
	/**
	 * 修改登录用户信息
	 * 
	 * @author lijufa
	 * @date 2016年2月23日
	 * @param request
	 * @return
	 */
	@RequestMapping("/editSelfUserInfo")
	@ResponseBody
	public String editSelfUserInfo(HttpServletResponse res,HttpServletRequest request, String email, String phone, String mobilePhone,String comments)
			throws IOException {
		BhSysUserLoginInfo bhSysUserLoginInfo = SessionUtil.getSessionUser(request);
		bhSysUserLoginInfo.setEmail(email);
		bhSysUserLoginInfo.setPhone(phone);
		bhSysUserLoginInfo.setMobilePhone(mobilePhone);
		bhSysUserLoginInfo.setComments(comments);
		// 
		PrintWriter writer = res.getWriter();
		Map<String, String> map = new HashMap<String, String>();
				int i =userService.updateUserinfo(bhSysUserLoginInfo) ;
				if (i == 1) {
					//修改session信息
					SessionUtil.setSessionUser(request, bhSysUserLoginInfo);
					map.put("code", "01");
					map.put("msg", "修改成功");
				} else {
					map.put("code", "02");
					map.put("msg", "修改失败");
				}
			
		JSONObject jo = JSONObject.fromObject(map);
		writer.write(jo.toString());
		writer.flush();
		writer.close();
		return null;
	}
	
	@RequestMapping(value = "/kaptcha", method = RequestMethod.GET)
	public void kaptcha(HttpServletRequest req, HttpServletResponse rsp) throws Exception {
		HttpSession session = req.getSession();
		String sessionId = session.getId();
		rsp.setDateHeader("Expires", 0);
		rsp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		rsp.addHeader("Cache-Control", "post-check=0, pre-check=0");
		rsp.setHeader("Pragma", "no-cache");
		rsp.setContentType("image/jpeg");

		String capText = producer.createText();
		session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
		logger.debug("session_id:" + sessionId + ",validateCode:" + capText);
		BufferedImage image = producer.createImage(capText);
		ServletOutputStream out = rsp.getOutputStream();
		ImageIO.write(image, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
	}
	/**
	 * 重置用户密码为pass123
	 * @author xingyxa
	 * @param request
	 * @return 
	 */
	@RequestMapping("/repass")
	@ResponseBody
	public String repass(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		String id=request.getParameter("userId");
		String password = request.getParameter("password");
		try {
			BhSysUserLoginInfo sysuser = new BhSysUserLoginInfo();
			sysuser.setUserId(id);
			if (StringUtil.getNullStr(password).equals("") || password == "null") {
				sysuser.setPassword(MD5Util.getMD5("pass123"));
			}else{
				sysuser.setPassword(MD5Util.getMD5(password));
			}
			
			userSystemService.updateUserPass(sysuser);
			
			result.put("success", "true");
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		} catch (Exception e) {
			result.put("errorMsg", "重置密码失败！");
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		}
	}
	
}
