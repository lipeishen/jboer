package com.dcits.djk.manager.service;

import java.util.List;
import java.util.Map;

import com.dcits.djk.manager.single.model.BhSysUserLoginInfo;
import com.dcits.djk.manager.single.model.BhSysUserModularInfo;
import com.dcits.djk.manager.single.model.BhSysUserOrgInfo;
import com.dcits.djk.manager.single.model.BhSysUserPostInfo;
import com.dcits.djk.manager.single.model.BhSysUserRoleInfo;

public interface UserService {
	public BhSysUserLoginInfo checkUserLogin(String loginName,String password);
	
	public List<Map<String,String>> getModulerList(BhSysUserLoginInfo bhSysUserLoginInfo);
	
	public BhSysUserModularInfo getModulerInfoById(String modularId);
	
	public BhSysUserOrgInfo getOrgInfoById(String orgId);
	
	public BhSysUserPostInfo getPostInfoById(String postId);
	
	public BhSysUserRoleInfo getRoleInfoById(String roleId);
	
	public String getOrgListByOrgIds(String orgIds);
	/**
	 * 修改登录用户信息
	 * 
	 * @author lijufa
	 * @date 2016年2月23日
	 * @param request
	 * @return
	 */
	public int updateUserinfo(BhSysUserLoginInfo bhsysuserlogininfo);
}
