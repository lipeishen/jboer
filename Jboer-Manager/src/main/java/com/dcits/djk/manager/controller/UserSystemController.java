package com.dcits.djk.manager.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcits.djk.core.util.MD5Util;
import com.dcits.djk.core.util.StringUtil;
import com.dcits.djk.core.util.UuidUtil;
import com.dcits.djk.core.util.VilidateUtil;
import com.dcits.djk.manager.service.UserService;
import com.dcits.djk.manager.service.UserSystemService;
import com.dcits.djk.manager.single.model.BhSysUserLoginInfo;
import com.dcits.djk.manager.single.model.BhSysUserModularInfo;
import com.dcits.djk.manager.single.model.BhSysUserOrgInfo;
import com.dcits.djk.manager.single.model.BhSysUserPostInfo;
import com.dcits.djk.manager.single.model.BhSysUserPostRole;
import com.dcits.djk.manager.single.model.BhSysUserRoleInfo;
import com.dcits.djk.manager.util.SessionUtil;
import com.dcits.djk.manager.vo.PostRoleDataLevel;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/userSystem")
public class UserSystemController {
	private Logger logger = Logger.getLogger(UserSystemController.class);
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="userSystemService")
	private UserSystemService userSystemService;
	
	@RequestMapping("/userInfo/toUserList")
	public String toUserList(HttpServletRequest request,String modularId,Model model) {
		String modularIdChecked = StringUtil.getNullStr(modularId);
		logger.debug(modularIdChecked);
		model.addAttribute("modularId", modularIdChecked);
		return "/userSystem/userInfo/userList";
	}
	
	@RequestMapping("/userInfo/getListInUserList")
	@ResponseBody
	public String getListInUserList(HttpServletRequest request,String modularId,String name,String loginName,String staffNum,String orgIds,int rows,int page){
		logger.debug("==============================================controller start");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Map<String,String>> modularList = SessionUtil.getSessionModularList(request);
		if(orgIds == null || orgIds.equals("")){
			for(int i = 0;i < modularList.size();i++){
				Map<String,String> modular = modularList.get(i);
				String modularIds = modular.get("modularId");
				if(modularId.equals(modularIds)){
					orgIds = modular.get("orgIds");
					break;
				}
			}
		}
		logger.debug("==============================================serviceoutside count start");
		int allRows = userSystemService.getCountUserListByCaseOnPage(name, loginName, staffNum, orgIds);
		logger.debug("==============================================serviceoutside count end");
		logger.debug("==============================================serviceoutside list start");
		List<HashMap<String, String>> recordList = userSystemService.getUserListByCaseOnPage(name, loginName, staffNum, orgIds, rows, page);
		logger.debug("==============================================serviceoutside list end");
		if(recordList == null ){
			recordList = new ArrayList<HashMap<String, String>>();
		}
		
		returnMap.put("total", allRows);
		returnMap.put("rows", recordList);
		JSONObject jo = JSONObject.fromObject(returnMap);
		//logger.debug(jo.toString());
		logger.debug("==============================================controller end");
		return jo.toString();
	}
	/**
	 * 组织机构管理
	 * @author lijufa
	 * @date 2016年2月23日
	 * @param request
	 * @return
	 */
	@RequestMapping("/orgInfo/toOrgInfoList")
	public String toOrgInfoList(HttpServletRequest request,Model model) {
		String modularId=request.getParameter("modularId");
		logger.debug(modularId);
		model.addAttribute("modularId", modularId);
		return "/userSystem/orgInfo/orgInfoList";
	}
	/**
	 * 组织机构管理 左侧树
	 * @author lijufa
	 * @date 2016年2月23日
	 * @param request
	 * @return
	 */
	@RequestMapping("/orgInfo/getOrgIdTree")
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
	/**
	 * 组织机构管理  查询机构列表
	 * @author lijufa
	 * @date 2016年2月23日
	 * @param request
	 * @return
	 */
	@RequestMapping("/orgInfo/getOrgList")
	@ResponseBody
	public String getOrgList(HttpServletRequest request,String serch_name,String serch_orgCode,String orgParentId,int rows,int page){
		String modularId=request.getParameter("modularId");
		List<Map<String,String>> modularList = SessionUtil.getSessionModularList(request);
		String orgIds = "";
		for(int i = 0;i < modularList.size();i++){
			Map<String,String> modular = modularList.get(i);
			String modularIds = modular.get("modularId");
			if(modularId.equals(modularIds)){
				orgIds = modular.get("orgIds")+"";
				break;
			}
		}
		Map<String, Object> returnMap = new HashMap<String, Object>();
		int allRows = userSystemService.getCountOrgListByCaseOnPage(serch_name,serch_orgCode,orgParentId,orgIds);
		List<BhSysUserOrgInfo> orgList =userSystemService.getOrgListByCaseOnPage(serch_name,serch_orgCode,orgParentId,orgIds,rows,page);
		if(orgList == null ){
			orgList = new ArrayList<BhSysUserOrgInfo>();
		}
		returnMap.put("total", allRows);
		returnMap.put("rows", orgList);
		JSONObject jo = JSONObject.fromObject(returnMap);
		System.out.println(jo.toString());
		return jo.toString();
	}
	   /**
		 * 组织机构管理  添加机构
		 * @author lijufa
		 * @date 2016年2月23日
		 * @param request
		 * @return
	 * @throws UnsupportedEncodingException 
		 */
		@RequestMapping(value="/orgInfo/saveOrgInfo",produces = "application/json;charset=utf-8")
		@ResponseBody
		public String saveOrgInfo(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			Map<String, Object> result = new HashMap<String, Object>();
			try {
				String orgId = request.getParameter("orgId");//本身节点
				String orgParentId = request.getParameter("orgParentId");//父节点
				String orgName = request.getParameter("orgName");
				String orgCode = request.getParameter("orgCode");
				String comments = request.getParameter("comments");
				BhSysUserOrgInfo bhsysuserorginfo=new BhSysUserOrgInfo();
				bhsysuserorginfo.setOrgName(orgName);
				bhsysuserorginfo.setOrgParentId(orgParentId);
				bhsysuserorginfo.setOrgCode(orgCode);
				bhsysuserorginfo.setComments(comments);
				//判断orgCode唯一
				 BhSysUserOrgInfo  bhsysuserorg=userSystemService.getOrgInfoByOrgCode(orgCode);
						int i = 0;
						if (orgId.equals("") || orgId=="null") {//新增
							if(bhsysuserorg!=null){//不唯一
								 result.put("errorMsg", "机构编码已存在！");
								 //result.put("errorMsg", "操作失败");
							 }else{
							   orgId = UuidUtil.get32Uuid();
							   bhsysuserorginfo.setOrgId(orgId);
							  //返回受影响的行数
							   i = userSystemService.insertOrgInfo(bhsysuserorginfo);
								if(i>0){
									//插入成功
								    result.put("success", "true");
									result.put("data", bhsysuserorginfo);
								}else{
									result.put("errorMsg", "操作失败");
								}
							 }
						}else{//修改
							BhSysUserOrgInfo  sysuserorg=userSystemService.getOrgInfoById(orgId);
							if(sysuserorg.getOrgCode().equals(orgCode)){
								bhsysuserorginfo.setOrgId(orgId);
								i = userSystemService.updateOrgInfo(bhsysuserorginfo);
								if(i>0){
									//插入成功
								    result.put("success", "true");
									result.put("data", bhsysuserorginfo);
								}else{
									result.put("errorMsg", "操作失败");
								}
							}else{
								if(bhsysuserorg!=null){//不唯一
									 result.put("errorMsg", "机构编码已存在！");
									 //result.put("errorMsg", "操作失败");
								 }else{
									 bhsysuserorginfo.setOrgId(orgId);
									 i = userSystemService.updateOrgInfo(bhsysuserorginfo);
									if(i>0){
											//插入成功
										    result.put("success", "true");
											result.put("data", bhsysuserorginfo);
									}else{
											result.put("errorMsg", "操作失败");
									}
								 }
							}
							
						}
			} catch (Exception e) {
				logger.error(e,e);
				result.put("errorMsg", "操作失败");
			}
			JSONObject obj = JSONObject.fromObject(result);
			System.out.println(obj.toString());
			return obj.toString();
		}
		/**
		 *  组织机构管理  编辑机构
		 * @author lijufa
		 */
		@RequestMapping(value="/orgInfo/getOrgById",produces = "application/json;charset=utf-8")
		@ResponseBody
		public String getOrgById(HttpServletRequest request) {
			Map<String, Object> result = new HashMap<String, Object>();
			String orgId=request.getParameter("selforgId");
			try {
				BhSysUserOrgInfo bhsysuserorginfo= userSystemService.getOrgInfoById(orgId);
				result.put("success", "true");
				result.put("data", bhsysuserorginfo);
				JSONObject jo = JSONObject.fromObject(result);
				return jo.toString();
			} catch (Exception e) {
				result.put("errorMsg", "操作失败！");
				JSONObject jo = JSONObject.fromObject(result);
				return jo.toString();
			}
		}	
		/**
		 * 组织机构管理   删除机构
		 * @author lijufa
		 */
		@RequestMapping(value="/orgInfo/deleteOrgInfo",produces = "application/json;charset=utf-8")
		@ResponseBody
		public String deleteOrgInfo(HttpServletRequest request) {
			Map<String, Object> result = new HashMap<String, Object>();
			String orgId=request.getParameter("orgId");
			try {
				String msg = userSystemService.deleteOrgInfo(orgId);
				if("success".equals(msg)){
					result.put("success", "true");
				}else{
					result.put("errorMsg", msg);
				}
				JSONObject jo = JSONObject.fromObject(result);
				return jo.toString();
			} catch (Exception e) {
				result.put("errorMsg", "操作失败！");
				JSONObject jo = JSONObject.fromObject(result);
				return jo.toString();
			}
		}
	 //组织机构end
	/**
	 * 模块管理
	 * @author cuiwt
	 * @date 2016年2月23日13:42:44
	 * @param request
	 * @return
	 */
	@RequestMapping("/modularInfo/toModularList")
	public String toModularList(HttpServletRequest request) {
		/*logger.debug(modularId);
		model.addAttribute("modularId", modularId);*/
		return "/userSystem/modularInfo/modularList";
	}
	/**
	 * 查询模块
	 * @author cuiwt
	 * @date 2016年2月24日14:53:15
	 * @param request
	 * @return
	 */
	@RequestMapping("/modularInfo/getModularList")
	@ResponseBody
	public String getModularList(HttpServletRequest request,String modularId,String name,String modularCode,int rows,int page) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		int allRows = userSystemService.getCountModularListByCaseOnPage(modularId,name,modularCode);
		List<BhSysUserModularInfo> modularList = userSystemService.getModularListByCaseOnPage(modularId,name,modularCode, rows, page);
		if(modularList == null ){
			modularList = new ArrayList<BhSysUserModularInfo>();
		}
		
		returnMap.put("total", allRows);
		returnMap.put("rows", modularList);
		JSONObject jo = JSONObject.fromObject(returnMap);
		return jo.toString();
	}
	/**
	 * 编辑模块
	 * @author cuiwt
	 */
	@RequestMapping("/modularInfo/getModularById")
	@ResponseBody
	public String getModularById(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		String modularId=request.getParameter("modularId");
		try {
			BhSysUserModularInfo bhSysUserModularInfo = userSystemService.getModularById(modularId);
			result.put("success", "true");
			result.put("data", bhSysUserModularInfo);
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		} catch (Exception e) {
			result.put("errorMsg", "操作失败！");
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		}
	}
	/**
	 * 模块树加载
	 * @author cuiwt
	 * @date 2016年2月24日13:51:18
	 * @param request
	 * @return
	 */
	@RequestMapping("/modularInfo/treeLoad")
	@ResponseBody
	public String treeLoad(HttpServletRequest request) {
		/*logger.debug(modularId);
		model.addAttribute("modularId", modularId);*/
		List<Map<String,String>> modularList = SessionUtil.getSessionModularList(request);
		System.out.println(modularList);
		return userSystemService.modularTreeLoad();
	}
	/**
	 * 保存模块
	 * @author cuiwt
	 * @date 2016年2月24日13:51:18
	 * @param request
	 * @return
	 */
	@RequestMapping("/modularInfo/saveModular")
	@ResponseBody
	public String saveModular(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String modularId = request.getParameter("modularId");
			String modularParentId = request.getParameter("modularParentId");
			String modularName = request.getParameter("modularName");
			String modularCode = request.getParameter("modularCode");
			String modularUrl = request.getParameter("modularUrl");
			String comments = request.getParameter("comments");
			BhSysUserModularInfo modularInfo = new BhSysUserModularInfo();
			modularInfo.setModularCode(modularCode);
			modularInfo.setComments(comments);
			modularInfo.setModularName(modularName);
			modularInfo.setModularParentId(modularParentId);
			modularInfo.setModularUrl(modularUrl);
			int i = 0;
			if (modularId.equals("") || modularId=="null") {
				//新增
				modularId = UuidUtil.get32Uuid();
				modularInfo.setModularId(modularId);
				//返回受影响的行数
				i = userSystemService.insertModular(modularInfo);
			}else{
				modularInfo.setModularId(modularId);
				i = userSystemService.updateModular(modularInfo);
			}
			if(i>0){
				//插入成功
				result.put("success", "true");
				result.put("data", modularInfo);
			}else{
				result.put("errorMsg", "操作失败");
			}
		} catch (Exception e) {
			logger.error(e,e);
			result.put("errorMsg", "操作失败");
		}
		JSONObject obj = JSONObject.fromObject(result);
		System.out.println(obj.toString());
		return obj.toString();
	}
	/**
	 * 删除模块
	 * @author cuiwt
	 */
	@RequestMapping("/modularInfo/deleteModular")
	@ResponseBody
	public String deleteModular(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		String modularId=request.getParameter("modularId");
		try {
			String msg = userSystemService.deleteModular(modularId);
			if("success".equals(msg)){
				result.put("success", "true");
			}else{
				result.put("errorMsg", msg);
			}
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		} catch (Exception e) {
			result.put("errorMsg", "操作失败！");
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		}
	}
	/**
	 * 跳转到用户编辑界面
	 * @author xingyxa
	 * @param request
	 * @return
	 */
	@RequestMapping("/userInfo/toUserAddOrEdit")
	public String toUserAddOrEdit(HttpServletRequest request) {
		String id=request.getParameter("userId");
		String modularId = request.getParameter("modularId");
		request.setAttribute("modularId", modularId);
		try {
			if (!StringUtil.getNullStr(id).equals("")) {
				BhSysUserLoginInfo sysuser = userSystemService.getByPrimaryKey(id);
				request.setAttribute("sysuser", sysuser);
			}
		} catch (Exception e) {
			logger.error(e,e);
		}
		return "/userSystem/userInfo/userEdit";
	}
	/**
	 * 查询用户详细信息
	 * @author xingyxa
	 * @param request
	 * @return 用户详细信息
	 */
	@RequestMapping("/userInfo/getUser")
	@ResponseBody
	public String getUser(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		String id=request.getParameter("userId");
		try {
			BhSysUserLoginInfo sysuser = userSystemService.getByPrimaryKey(id);
			result.put("success", "true");
			result.put("data", sysuser);
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		} catch (Exception e) {
			result.put("errorMsg", "操作失败！");
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		}
	}
	/**
	 * 保存新增用户信息
	 * @author xingyxa
	 * @param request
	 * @return String
	 */
	@RequestMapping("/userInfo/userSave")
	@ResponseBody
	public String userSave(HttpServletRequest request){
		String reString = "";
		try {
			String postRows = request.getParameter("postRows"); 
			postRows = postRows.replace("&quot;", "'");
			String userId = request.getParameter("userId"); 
			String name = request.getParameter("name");   
			String loginName = request.getParameter("loginName");   
			String staffNum = request.getParameter("staffNum");  
			String phone = request.getParameter("phone");  
			String mobilePhone = request.getParameter("mobilePhone");  
			String email = request.getParameter("email");  
			String comments = request.getParameter("comments"); 
			
			BhSysUserLoginInfo sysuser = new BhSysUserLoginInfo();
			sysuser.setUserId(userId);
			sysuser.setName(name);
			sysuser.setLoginName(loginName);
			sysuser.setStaffNum(staffNum);
			sysuser.setPhone(phone);
			sysuser.setMobilePhone(mobilePhone);
			sysuser.setEmail(email);
			sysuser.setComments(comments);
			String msg = vilidate(sysuser);
			if (!msg.equals("")) {
				Map<String, Object> result2 = new HashMap<String, Object>();
				result2.put("success", false);
				result2.put("errorMsg", msg);
				JSONObject jo = JSONObject.fromObject(result2);
				return jo.toString();
			}
			if (StringUtil.getNullStr(postRows).equals("")) {
				Map<String, Object> result2 = new HashMap<String, Object>();
				result2.put("success", false);
				result2.put("errorMsg", "请维护用户的机构岗位信息！");
				JSONObject jo = JSONObject.fromObject(result2);
				return jo.toString();
			}
			if (StringUtil.getNullStr(userId).equals("") || userId=="null") {
				userId = UuidUtil.get32Uuid();
			    String pass = MD5Util.getMD5("pass123");
				sysuser.setUserId(userId);
				sysuser.setPassword(pass);
				reString = userSystemService.insertUser(sysuser, postRows);
			}else{
				reString = userSystemService.updateUser(sysuser, postRows);
			}
			
			return reString;
		} catch (Exception e) {
			logger.error(e,e);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("success", false);
			result.put("errorMsg", "操作失败！");
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		}
	}
	private String vilidate(BhSysUserLoginInfo sysuser){
		String mesg = "";
		String name = sysuser.getName();   
		String loginName = sysuser.getLoginName();   
		String staffNum = sysuser.getStaffNum();  
		String phone = sysuser.getPhone();  
		String mobilePhone = sysuser.getMobilePhone();  
		String email = sysuser.getEmail();  
		String comments = sysuser.getComments(); 
		if (name.length()>25) {
			mesg = "用户名称输入过长！";
			return mesg;
		}

		if ((loginName.length() < 6) || (loginName.length() > 20)) {
			mesg = "登录名称的长度必须在6-20之间！";
			return mesg;
		}
		if (staffNum.length()>10) {
			mesg = "员工编号输入过长！";
			return mesg;
		}
		if (!StringUtil.getNullStr(email).equals("")){
			if(email.length()>50) {
				mesg = "邮箱输入过长！";
				return mesg;
			}else if (!VilidateUtil.isEmail(email)) {
				mesg = "请输入正确格式的电子邮件!";
				return mesg;
			}
		}
		if (!StringUtil.getNullStr(phone).equals("")){
			if (phone.length()>13) {
				mesg = "固定电话输入过长！";
				return mesg;
			}else if (!VilidateUtil.isPhone(phone)) {
				mesg = "请输入正确格式的固定电话,如010-88886666!";
				return mesg;
			}
		}
		if (!StringUtil.getNullStr(mobilePhone).equals("")){
			if (!VilidateUtil.isMobileNO(mobilePhone)) {
				mesg = "请输入正确格式的手机号,如18816679898!";
				return mesg;
			}
		}
		if (!StringUtil.getNullStr(comments).equals("")){
			 if (comments.length()>100) {
				mesg = "描述输入过长！";
				return mesg;
			 }
		}
		return mesg;
	}
	
	/**
	 * 删除用户
	 * @author xingyxa
	 * @param request
	 * @return 
	 */
	@RequestMapping("/userInfo/deleteUser")
	@ResponseBody
	public String deleteUser(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		String userId=request.getParameter("userId");
		try {
			userSystemService.deleteUser(userId);
			
			result.put("success", "true");
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		} catch (Exception e) {
			result.put("errorMsg", "删除用户失败！");
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		}
	}
	/**
	 * 查询登录名称是否唯一
	 * @author  xingyxa 
	 * @param request
	 * @return boolean
	 */
	@RequestMapping("/userInfo/checkLoginName")
	@ResponseBody
	public String checkLoginName(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		String loginName=request.getParameter("loginName");
		String userId=request.getParameter("userId");
		try {
			BhSysUserLoginInfo bhSysUserLoginInfo = new BhSysUserLoginInfo();
			bhSysUserLoginInfo.setLoginName(loginName);
			bhSysUserLoginInfo.setName("");
			bhSysUserLoginInfo.setStaffNum("");
			bhSysUserLoginInfo.setUserId(userId);
			int reRows = userSystemService.getUserByLoginName(bhSysUserLoginInfo);
			if (reRows>0) {
				result.put("success", false);
			}else{
				result.put("success", true);
			}
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		} catch (Exception e) {
			result.put("errorMsg", "查询登录名称是否唯一失败！");
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		}
	}
	/**
	 * 查询用户编号是否唯一
	 * @author  xingyxa 
	 * @param request
	 * @return boolean
	 */
	@RequestMapping("/userInfo/checkStaffNum")
	@ResponseBody
	public String checkStaffNum(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		String staffNum=request.getParameter("staffNum");
		String userId=request.getParameter("userId");
		try {
			BhSysUserLoginInfo bhSysUserLoginInfo = new BhSysUserLoginInfo();
			bhSysUserLoginInfo.setLoginName("");
			bhSysUserLoginInfo.setName("");
			bhSysUserLoginInfo.setStaffNum(staffNum);
			bhSysUserLoginInfo.setUserId(userId);
			int reRows = userSystemService.getUserByLoginName(bhSysUserLoginInfo);
			if (reRows>0) {
				result.put("success", false);
			}else{
				result.put("success", true);
			}
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		} catch (Exception e) {
			result.put("errorMsg", "查询用户编号是否唯一失败！");
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		}
	}

	/**
	 * 查询岗位列表信息
	 * @author xingyxa
	 * @param request
	 * @return 岗位信息
	 */
	@RequestMapping("/userInfo/getPosts")
	@ResponseBody
	public String getPosts(HttpServletRequest request,String modularId){
		try {
			//判断当前登录用户的数据权限
			String orgIds = "";
			List<Map<String,String>> modularList = SessionUtil.getSessionModularList(request);
			if(orgIds == null || orgIds.equals("")){
				for(int i = 0;i < modularList.size();i++){
					Map<String,String> modular = modularList.get(i);
					String modularIds = modular.get("modularId");
					if(modularId.equals(modularIds)){
						orgIds = modular.get("orgIds");
						break;
					}
				}
			}
			String isadmin="0";
			if (orgIds.contains("00000000000000000000000000000001"))
			{
				isadmin="1";
			}
			String jo = userSystemService.getPosts(isadmin);
			return jo;
		} catch (Exception e) {
			return "";
		}
	}
	/**
	 * 查询当前用户已选择的岗位信息
	 * @author xingyxa
	 * @param request
	 * @return 岗位信息
	 */
	@RequestMapping("/getPostsByUser")
	@ResponseBody
	public String getPostsByUser(HttpServletRequest request){
		try {
			String userId = request.getParameter("userId");
			String jo = userSystemService.getPostsByWhere(userId);
			return jo;
		} catch (Exception e) {
			return "";
		}
	}
	/**
	 * 查询当前用户未选择的岗位信息
	 * @author xingyxa
	 * @param request
	 * @return 岗位信息
	 */
	@RequestMapping("/getPostsByNotIn")
	@ResponseBody
	public String getPostsByNotIn(HttpServletRequest request){
		try {
			String userId = request.getParameter("userId");
			String jo = userSystemService.getPostsByNotIn(userId);
			return jo;
		} catch (Exception e) {
			return "";
		}
	}
	/**
	 * 查询当前用户已选择的机构信息
	 * @author xingyxa
	 * @param request
	 * @return 机构信息
	 */
	@RequestMapping("/getOrgsByWhere")
	@ResponseBody
	public String getOrgsByWhere(HttpServletRequest request){
		try {
			String userId = request.getParameter("userId");
			String jo = userSystemService.getOrgsByWhere(userId);
			return jo;
		} catch (Exception e) {
			return "";
		}
	}
	/**
	 * 查询机构列表信息
	 * @author xingyxa
	 * @param request
	 * @return 机构信息
	 */
	@RequestMapping("/common/getOrgs")
	@ResponseBody
	public String getOrgs(HttpServletRequest request){
		try {
			String modularId = request.getParameter("modularId");
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
				String jo = userSystemService.getOrgs(orgIds);
				return jo;
			}else{
				return "";
			}
		} catch (Exception e) {
			logger.error(e,e);
			return "";
		}
	}
	/**
	 * 获取指定用户的机构岗位权限
	 * @author xingyxa
	 * @param request
	 * @return 机构岗位权限信息
	 */
	@RequestMapping("/userInfo/getUserRels")
	@ResponseBody
	public String getUserRels(HttpServletRequest request){
		try {
			String userId = request.getParameter("userId");
			
			List<HashMap<String, String>> recordList = userSystemService.getUserRels(userId);
			if(recordList == null ){
				recordList = new ArrayList<HashMap<String, String>>();
			}
			
			JSONArray json = JSONArray.fromObject(recordList);
			String result = json.toString();
			return result;
		} catch (Exception e) {
			logger.error(e,e);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("errorMsg", "获取用户的机构岗位列表失败！");
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		}
	}
	/**
	 * 跳转角色管理页面
	 * @author caoxiaoa
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/roleInfo/toRoleList")
	public String toRoleList(HttpServletRequest request,Model model) {
		return "/userSystem/roleInfo/roleList";
	}
	
	/**
	 * 查询角色列表
	 * @author caoxiaoa
	 * @param request
	 * @param roleName
	 * @param rows
	 * @param page
	 * @return
	 */
	@RequestMapping("/roleInfo/getListInRoleList")
	@ResponseBody
	public String getListInRoleList(HttpServletRequest request,String roleName,int rows,int page){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		int allRows = userSystemService.getCountRoleListByCaseOnPage(roleName);
		List<BhSysUserRoleInfo> roleList = userSystemService.getRoleListByCaseOnPage(roleName, rows, page);
		if(roleList == null ){
			roleList = new ArrayList<BhSysUserRoleInfo>();
		}
		
		returnMap.put("total", allRows);
		returnMap.put("rows", roleList);
		JSONObject jo = JSONObject.fromObject(returnMap);
		return jo.toString();
	}
	
	/**
	 * 角色管理加载模块树
	 * @author caoxiaoa
	 * @return
	 */
	@RequestMapping("/roleInfo/easyUitree")
	@ResponseBody
	public String easyUitree(){
		return userSystemService.roleModularTreeLoad();
	}
	
	/**
	 * 跳转角色新增修改页面
	 * @author caoxiaoa
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/roleInfo/toRoleAddOrEdit")
	public String toRoleAddOrEdit(HttpServletRequest request, String id) {
		if(id != null){
			BhSysUserRoleInfo role = userSystemService.getRoleByRoleId(id);
			request.setAttribute("role", role);
		}
		return "/userSystem/roleInfo/roleEdit";
	}
	
	
	/**
	 * 添加角色
	 * @author caoxiaoa
	 * @param request
	 * @param roleName
	 * @param rows
	 * @param pagee
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/roleInfo/saveRoleInfo")
	@ResponseBody
	public String saveRoleInfo(HttpServletResponse res, String roleName,String comments, @RequestParam(value = "idsArray[]")String[] idsArray) throws IOException{
		String recordCode = userSystemService.insertRoleInfo(roleName,comments,idsArray);
		PrintWriter writer = res.getWriter();
		Map<String,String> map = new HashMap<String,String>();
		if("success".equals(recordCode)){
			map.put("code", "01");
			map.put("msg", "新增角色成功");
		}else{
			map.put("code", "02");
			map.put("msg", "保存角色失败");
		}
		JSONObject jo = JSONObject.fromObject(map);
		writer.write(jo.toString());
		writer.flush();
		writer.close();
		return null;
	}
	
	/**
	 * 编辑修改角色
	 * @author caoxiaoa
	 * @param request
	 * @param roleName
	 * @param rows
	 * @param pagee
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/roleInfo/editRoleInfo")
	@ResponseBody
	public String editRoleInfo(HttpServletResponse res,String roleId, String roleName,String comments, @RequestParam(value = "idsArray[]")String[] idsArray) throws IOException{
		String recordCode = userSystemService.updateRoleInfo(roleId, roleName,comments,idsArray);
		PrintWriter writer = res.getWriter();
		Map<String,String> map = new HashMap<String,String>();
		if("success".equals(recordCode)){
			map.put("code", "01");
			map.put("msg", "新增角色成功");
		}else{
			map.put("code", "02");
			map.put("msg", "保存角色失败");
		}
		JSONObject jo = JSONObject.fromObject(map);
		writer.write(jo.toString());
		writer.flush();
		writer.close();
		return null;
	}
	
	/**
	 * 获得角色已有资源id集合
	 * @author caoxiaoa
	 * @param res
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/roleInfo/getHaveModulars")
	@ResponseBody
	public String getHaveModulars(HttpServletResponse res,String roleId) throws IOException{
		List<String> mList = userSystemService.getHaveModulars(roleId);
		JSONArray ja = JSONArray.fromObject(mList);
		PrintWriter writer = res.getWriter();
		writer.write(ja.toString());
		writer.flush();
		writer.close();
		return null;
	}
	
	/**
	 * 删除角色
	 * @author caoxiaoa
	 * @param request
	 * @param roleName
	 * @param rows
	 * @param pagee
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/roleInfo/deleteRoleInfo")
	@ResponseBody
	public String deleteRoleInfo(HttpServletResponse res, String id) throws IOException{
		PrintWriter writer = res.getWriter();
		Map<String,String> map = new HashMap<String,String>();
		String rec = userSystemService.deleteRoleInfo(id);
		if("success".equals(rec)){
			//成功
			map.put("code", "01");
			map.put("msg", "角色删除成功");
		}else if("error1".equals(rec)){
			//存在岗位关联，不允许删除
			map.put("code", "02");
			map.put("msg", "存在岗位关联，不允许删除");
		}else{
			//存在岗位关联，不允许删除
			map.put("code", "03");
			map.put("msg", "此角色已被删除，请刷新列表");
		}
		JSONObject jo = JSONObject.fromObject(map);
		writer.write(jo.toString());
		writer.flush();
		writer.close();
		return null;
	}
	
	/**
	 * @author lips
	 * 跳转岗位管理页面
	 * @param request
	 * @param model
	 * @return
	 */
		@RequestMapping("/postInfo/toPostList")
		public String toPostList(HttpServletRequest request,Model model) {
		
			return "/userSystem/postInfo/postList";
		}
		/**
		 * @author lips
		 * 查询岗位管理信息
		 * @param request
		 * @param postname
		 * @param rows
		 * @param page
		 * @return
		 */
		@RequestMapping("/postInfo/getListInPostList")
		@ResponseBody
		public String getListInPostList(HttpServletRequest request,String postName,int rows,int page){
			Map<String, Object> returnMap = new HashMap<String, Object>();
			/*String orgIds = "";
			List<Map<String,String>> modularList = SessionUtil.getSessionModularList(request);
			if(orgIds == null || orgIds.equals("")){
				for(int i = 0;i < modularList.size();i++){
					Map<String,String> modular = modularList.get(i);
					String modularIds = modular.get("modularId");
					if(modularId.equals(modularIds)){
						orgIds = modular.get("orgIds");
						break;
					}
				}
			}*/
			int allRows = userSystemService.getCountPostListByCaseOnPage(postName);
			List<BhSysUserPostInfo> postList = userSystemService.getPostListByCaseOnPage(postName, rows, page);
			if(postList == null ){
				postList = new ArrayList<BhSysUserPostInfo>();
			}
			returnMap.put("total", allRows);
			returnMap.put("rows", postList);
			JSONObject jo = JSONObject.fromObject(returnMap);
			return jo.toString();
		}
		
		/**
		 * @author lips
		 * 新增或者修改岗位管理信息
		 * @param request
		 * @return
		 * @throws IOException 
		 */
		@RequestMapping("/postInfo/postSave")
		@ResponseBody
		public String postSave(HttpServletRequest request,@RequestParam(value = "rowid[]")String[] rowid,
				@RequestParam(value = "datalev[]")String[] datalev,HttpServletResponse res) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();	
		List<BhSysUserPostRole> listpostRole=new ArrayList<BhSysUserPostRole>();
		//新增之前，先获取用户的信息
		String postname=request.getParameter("postName");
		String comments=request.getParameter("comments");
		int len1=rowid.length;
		int len2=datalev.length;
		BhSysUserPostInfo postInfo=new BhSysUserPostInfo();//postId不存在，新建对象;
		String postId = UuidUtil.get32Uuid();
		postInfo.setPostId(postId);
		if (!("".equals(postname)||"null".equals(postname)||postname==null)) {
			postInfo.setPostName(postname);
		}
		if (!("".equals(comments)||"null".equals(comments)||comments==null)) {
			postInfo.setComments(comments);
		}

		if(len1==len2&&len1>0){
			for(int i=0;i<len1;i++){
				BhSysUserPostRole postRole=new BhSysUserPostRole();;
				postRole.setPostRoleId(UuidUtil.get32Uuid());
				postRole.setPostId(postId);
				postRole.setRoleId(rowid[i]);
				postRole.setDateLevel(datalev[i]);
				listpostRole.add(postRole);
				
			}
			
		}	
		int num1=userSystemService.insertPost(postInfo,listpostRole);
		if(num1==1){
			map.put("code", "01");
			map.put("msg", "新增岗位成功");
		}else{
			map.put("code", "02");
			map.put("msg", "保存岗位失败");
		}
		JSONObject jo = JSONObject.fromObject(map);
	    return jo.toString();
		}
	
	/**
	 * 删除岗位
	 * @param request
	 * @return 
	 */
	@RequestMapping("/postInfo/deletePost")
	@ResponseBody
	public String deletePost(HttpServletRequest request){
		Map<String, String> result = new HashMap<String, String>();
		String postId=request.getParameter("postId");
		try {
			result=userSystemService.deletePost(postId);
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		} catch (Exception e) {
			result.put("msg", "删除失败！");
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		}
	}
	/**
	 * 根据id查询岗位信息
	 * @author lips
	 * @param request
	 * @return
	 */
	@RequestMapping("/postInfo/getPost")
	@ResponseBody
	public String getPost(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		String id=request.getParameter("postId");
		try {
			BhSysUserPostInfo syspost = userSystemService.getPostByPrimarykey(id);
			result.put("success", "true");
			result.put("data", syspost);
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		} catch (Exception e) {
			result.put("errorMsg", "查询失败");
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		}
	}
	/**
	 * 查询角色列表信息
	 * @author lips
	 * @param request
	 * @return 角色信息
	 */
	@RequestMapping("/postInfo/getRoles")
	@ResponseBody
	public String getRoles(HttpServletRequest request){
		try {
			String jo = userSystemService.getRoles();
			return jo;
		} catch (Exception e) {
			return "";
		}
	}
	/**
	 * 跳转岗位新增修改页面
	 * @author lips
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/postInfo/toPostAddOrEdit")
	public String toPostAddOrEdit(Model model, String id) {
		if(id != null){
			BhSysUserPostInfo post=userSystemService.getPostByPrimarykey(id);
			if(post==null){
				post = new BhSysUserPostInfo();
			}
			List<PostRoleDataLevel> postrolelist=userSystemService.getPostRoleByPostId(id);
			if(postrolelist==null){
				postrolelist = new ArrayList<PostRoleDataLevel>();
			}
			model.addAttribute("post", post);
			model.addAttribute("roleList",postrolelist);
		}
		return "/userSystem/postInfo/postEdit";
	}
	/**
	 * 获得岗位已有的角色数据对象
	 * @author lips
	 * @param res
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/postInfo/getHaveRoles")
	@ResponseBody
	public String getHaveRoles(HttpServletResponse res,String postId) throws IOException{
		List<PostRoleDataLevel> postrolelist=userSystemService.getPostRoleByPostId(postId);
		JSONArray ja = JSONArray.fromObject(postrolelist);
		return ja.toString();
	}
	
	/**
	 * 编辑修改岗位
	 * @author lips
	 * @param request
	 * @param postName
	 * @param rows
	 * @param datalev
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/postInfo/editPostInfo")
	@ResponseBody
	public String editPostInfo(String postId, String postName,String comments, @RequestParam(value = "rowid[]")String[] rowid,
			@RequestParam(value = "datalev[]")String[] datalev) throws IOException{
		String recordCode = userSystemService.updatePostInfo(postId, postName, comments, rowid, datalev);
		Map<String,String> map = new HashMap<String,String>();
		if("success".equals(recordCode)){
			map.put("code", "01");
			map.put("msg", "编辑岗位成功");
		}else{
			map.put("code", "02");
			map.put("msg", "保存岗位失败");
		}
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}
}
