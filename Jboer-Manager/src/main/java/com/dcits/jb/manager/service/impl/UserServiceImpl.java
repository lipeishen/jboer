package com.dcits.jb.manager.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.jb.core.util.MD5Util;
import com.dcits.jb.core.util.StringUtil;
import com.dcits.jb.manager.service.UserService;
import com.dcits.jb.manager.single.mapper.BhSysUserLoginInfoMapper;
import com.dcits.jb.manager.single.mapper.BhSysUserModularInfoMapper;
import com.dcits.jb.manager.single.mapper.BhSysUserOrgInfoMapper;
import com.dcits.jb.manager.single.mapper.BhSysUserOrgRelMapper;
import com.dcits.jb.manager.single.mapper.BhSysUserPostInfoMapper;
import com.dcits.jb.manager.single.mapper.BhSysUserPostRoleMapper;
import com.dcits.jb.manager.single.mapper.BhSysUserRoleInfoMapper;
import com.dcits.jb.manager.single.mapper.BhSysUserRoleModularMapper;
import com.dcits.jb.manager.single.model.BhSysUserLoginInfo;
import com.dcits.jb.manager.single.model.BhSysUserLoginInfoExample;
import com.dcits.jb.manager.single.model.BhSysUserModularInfo;
import com.dcits.jb.manager.single.model.BhSysUserOrgInfo;
import com.dcits.jb.manager.single.model.BhSysUserOrgInfoExample;
import com.dcits.jb.manager.single.model.BhSysUserOrgRel;
import com.dcits.jb.manager.single.model.BhSysUserOrgRelExample;
import com.dcits.jb.manager.single.model.BhSysUserPostInfo;
import com.dcits.jb.manager.single.model.BhSysUserPostRole;
import com.dcits.jb.manager.single.model.BhSysUserPostRoleExample;
import com.dcits.jb.manager.single.model.BhSysUserRoleInfo;
import com.dcits.jb.manager.single.model.BhSysUserRoleModular;
import com.dcits.jb.manager.single.model.BhSysUserRoleModularExample;
import com.dcits.jb.manager.util.TreeNodeBean;
import com.dcits.jb.manager.util.TreeNodeUtil;

@Service("userService")
public class UserServiceImpl implements UserService{
	private Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private BhSysUserLoginInfoMapper bhSysUserLoginInfoMapper;
	
	@Autowired
	private BhSysUserOrgRelMapper bhSysUserOrgRelMapper;
	
	@Autowired
	private BhSysUserOrgInfoMapper bhSysUserOrgInfoMapper;
	
	@Autowired
	private BhSysUserPostRoleMapper bhSysUserPostRoleMapper;
	
	@Autowired
	private BhSysUserRoleModularMapper bhSysUserRoleModularrMapper;
	
	@Autowired
	private BhSysUserModularInfoMapper bhSysUserModularInfoMapper;
	
	@Autowired
	private BhSysUserPostInfoMapper bhSysUserPostInfoMapper;
	
	@Autowired
	private BhSysUserRoleInfoMapper bhSysUserRoleInfoMapper;
	
	@Override
	public BhSysUserLoginInfo checkUserLogin(String loginName,String password) {
		try{
			String passwordMd5 = MD5Util.getMD5(password);
			BhSysUserLoginInfoExample bhSysUserLoginInfoExample = new BhSysUserLoginInfoExample();
			bhSysUserLoginInfoExample.createCriteria().andLoginNameEqualTo(loginName).andPasswordEqualTo(passwordMd5);
			List<BhSysUserLoginInfo> recordList = bhSysUserLoginInfoMapper.selectByExample(bhSysUserLoginInfoExample);
			if(recordList == null || recordList.size() < 1){
				return null;
			}
			BhSysUserLoginInfo bhSysUserLoginInfo = recordList.get(0);
			return bhSysUserLoginInfo;
		}catch(Exception e){
			logger.error(e);
			return null;
		}
	}

	@Override
	public List<Map<String, String>> getModulerList(BhSysUserLoginInfo bhSysUserLoginInfo) {
		try{
			String userId = bhSysUserLoginInfo.getUserId();
			if(userId == null || "".equals(userId)){
				return null;
			}
			BhSysUserOrgRelExample bhSysUserOrgRelExample = new BhSysUserOrgRelExample();
			bhSysUserOrgRelExample.createCriteria().andUserIdEqualTo(userId);
			List<BhSysUserOrgRel> bhSysUserOrgRelList = bhSysUserOrgRelMapper.selectByExample(bhSysUserOrgRelExample);
			if(bhSysUserOrgRelList == null || bhSysUserOrgRelList.size() < 1){
				return null;
			}
			List<Map<String, String>> modularAllList = new ArrayList<Map<String,String>>();
			for(int i = 0;i < bhSysUserOrgRelList.size();i++){
				BhSysUserOrgRel bhSysUserOrgRel = bhSysUserOrgRelList.get(i);
				String orgId = bhSysUserOrgRel.getOrgId();
				String postId = bhSysUserOrgRel.getPostId();
				//查询各级机构信息
				String orgAll = this.getLevel3OrgList(orgId);
				BhSysUserPostRoleExample bhSysUserPostRoleExample = new BhSysUserPostRoleExample();
				bhSysUserPostRoleExample.createCriteria().andPostIdEqualTo(postId);
				List<BhSysUserPostRole> bhSysUserPostRoleList = bhSysUserPostRoleMapper.selectByExample(bhSysUserPostRoleExample);
				if(bhSysUserPostRoleList == null || bhSysUserPostRoleList.size() < 1){
					continue;
				}
				List<Map<String, String>> modularList = new ArrayList<Map<String,String>>();
				for(int j = 0;j < bhSysUserPostRoleList.size();j++){
					BhSysUserPostRole bhSysUserPostRole = bhSysUserPostRoleList.get(j); 
					String roleId = bhSysUserPostRole.getRoleId();
					String dataLevel = bhSysUserPostRole.getDateLevel();
					this.setModularList(modularList, roleId, orgId, orgAll, dataLevel);
				}
				this.setSonRoleToAllRole(modularAllList, modularList);
			}
			return modularAllList;
		}catch(Exception e){
			logger.equals(e);
			return null;
		}
	}
	
	@Override
	public BhSysUserModularInfo getModulerInfoById(String modularId) {
		BhSysUserModularInfo bhSysUserModularInfo = bhSysUserModularInfoMapper.selectByPrimaryKey(modularId);
		return bhSysUserModularInfo;
	}

	@Override
	public BhSysUserOrgInfo getOrgInfoById(String orgId) {
		BhSysUserOrgInfo bhSysUserOrgInfo = bhSysUserOrgInfoMapper.selectByPrimaryKey(orgId);
		return bhSysUserOrgInfo;
	}

	@Override
	public BhSysUserPostInfo getPostInfoById(String postId) {
		BhSysUserPostInfo bhSysUserPostInfo = bhSysUserPostInfoMapper.selectByPrimaryKey(postId);
		return bhSysUserPostInfo;
	}

	@Override
	public BhSysUserRoleInfo getRoleInfoById(String roleId) {
		BhSysUserRoleInfo bhSysUserRoleInfo = bhSysUserRoleInfoMapper.selectByPrimaryKey(roleId);
		return bhSysUserRoleInfo;
	}
	
	@Override
	public String getOrgListByOrgIds(String orgIds) {
		if(orgIds == null || orgIds.equals("")){
			return "[]";
		}
		String[] orgIdArr = orgIds.split(",");
		List<String> orgIdList = Arrays.asList(orgIdArr);
		BhSysUserOrgInfoExample bhSysUserOrgInfoExample = new BhSysUserOrgInfoExample();
		bhSysUserOrgInfoExample.createCriteria().andOrgIdIn(orgIdList);
		bhSysUserOrgInfoExample.setOrderByClause("org_code");
		List<BhSysUserOrgInfo> bhSysUserOrgInfoList = bhSysUserOrgInfoMapper.selectByExample(bhSysUserOrgInfoExample);
		List<TreeNodeBean> treeNodeBeanList = new ArrayList<TreeNodeBean>();
		for(int i = 0;i < bhSysUserOrgInfoList.size();i++){
			BhSysUserOrgInfo bhSysUserOrgInfo = bhSysUserOrgInfoList.get(i);
			TreeNodeBean tnb = new TreeNodeBean(bhSysUserOrgInfo.getOrgId(),bhSysUserOrgInfo.getOrgName(),bhSysUserOrgInfo.getOrgParentId(),bhSysUserOrgInfo.getOrgCode());
			treeNodeBeanList.add(tnb);
		}
		TreeNodeUtil tnu = new TreeNodeUtil();
		tnu.setTreeNodeBeanAllList(treeNodeBeanList);
		treeNodeBeanList = tnu.exeCreateTreeNode();
		
		return treeNodeBeanList.toString();
	}
	
	
	/**
	 * 以下为自有方法区
	 * 
	 */
	private String getLevel3OrgList(String orgId){
		List<String> orgIdList = new ArrayList<String>();
		this.getOrgList(orgId, orgIdList);
		if(orgIdList == null || orgIdList.size() < 1){
			return orgId;
		}
		StringBuffer orgsb = new StringBuffer(orgId);
		for(int i = 0;i <  orgIdList.size();i++){
			orgsb.append(","+orgIdList.get(i));
		}
		return orgsb.toString();
		
	}
	
	private void getOrgList(String orgId,List<String> orgIdList){
		BhSysUserOrgInfoExample bhSysUserOrgInfoExample = new BhSysUserOrgInfoExample();
		bhSysUserOrgInfoExample.createCriteria().andOrgParentIdEqualTo(orgId);
		List<BhSysUserOrgInfo> bhSysUserOrgInfoList = bhSysUserOrgInfoMapper.selectByExample(bhSysUserOrgInfoExample);
		if(bhSysUserOrgInfoList == null || bhSysUserOrgInfoList.size() < 1){
			return;
		}
		for(int i = 0;i < bhSysUserOrgInfoList.size();i++){
			BhSysUserOrgInfo bhSysUserOrgInfo = bhSysUserOrgInfoList.get(i);
			orgIdList.add(bhSysUserOrgInfo.getOrgId());
			this.getOrgList(bhSysUserOrgInfo.getOrgId(), orgIdList);
		}
	}
	
	private void setModularList(List<Map<String, String>> modularList,String roleId,String orgId,String orgAll,String dataLevel){
		BhSysUserRoleModularExample bhSysUserRoleModularExample = new BhSysUserRoleModularExample();
		bhSysUserRoleModularExample.createCriteria().andRoleIdEqualTo(roleId);
		List<BhSysUserRoleModular> bhSysUserRoleModularList = bhSysUserRoleModularrMapper.selectByExample(bhSysUserRoleModularExample);
		if(bhSysUserRoleModularList == null || bhSysUserRoleModularList.size() < 1){
			return;
		}
		for(int i = 0;i < bhSysUserRoleModularList.size();i++){
			BhSysUserRoleModular bhSysUserRoleModular = bhSysUserRoleModularList.get(i);
			String modularId = bhSysUserRoleModular.getModularId();
			this.updateModularList(modularList, modularId, orgId, orgAll, dataLevel);
		}
	}
	
	private void updateModularList(List<Map<String, String>> modularList,String modularId,String orgId,String orgAll,String dataLevel){
		BhSysUserModularInfo bhSysUserModularInfo = this.getModulerInfoById(modularId);
		boolean isCz = true;
		for(int i = 0;i < modularList.size();i++){
			Map<String,String> modularMap1 = modularList.get(i);
			String modularId1 = modularMap1.get("modularId");
			if(modularId.equals(modularId1)){
				String dataLevel1 = modularMap1.get("dataLevel");
				if(dataLevel1.equals("1") && dataLevel.equals("2")){
					modularMap1.put("dataLevel", dataLevel);
					modularMap1.put("orgIds", orgId);
				}else if(dataLevel1.equals("1") && dataLevel.equals("3")){
					modularMap1.put("dataLevel", dataLevel);
					modularMap1.put("orgIds", orgAll);
				}else if(dataLevel1.equals("2") && dataLevel.equals("3")){
					modularMap1.put("dataLevel", dataLevel);
					modularMap1.put("orgIds", orgAll);
				}
				isCz = false;
				continue;
			}
		}
		if(isCz){
			Map<String,String> modularMap = new HashMap<String,String>();
			modularMap.put("modularId", modularId);
			modularMap.put("modularName", bhSysUserModularInfo.getModularName());
			modularMap.put("modularUrl", bhSysUserModularInfo.getModularUrl());
			modularMap.put("modularParentId", bhSysUserModularInfo.getModularParentId());
			modularMap.put("modularCode", bhSysUserModularInfo.getModularCode());
			modularMap.put("dataLevel", dataLevel);
			if(dataLevel.equals("2")){
				modularMap.put("orgIds", orgId);
			}else if(dataLevel.equals("3")){
				modularMap.put("orgIds", orgAll);
			}else{
				modularMap.put("orgIds", "");
			}
			modularList.add(modularMap);
		}
	}
	
	private void setSonRoleToAllRole(List<Map<String, String>> modularAllList,List<Map<String, String>> modularList){
		for(int i = 0;i < modularList.size();i++){
			Map<String, String> modularMap = modularList.get(i);
			boolean isCz = true;
			for(int j = 0;j < modularAllList.size();j++){
				Map<String, String> modularAllMap = modularAllList.get(j);
				String modularAllId = modularAllMap.get("modularId");
				String modularId = modularMap.get("modularId");
				if(modularId.equals(modularAllId)){
					String orgIds = modularMap.get("orgIds");
					String orgAllIds = modularAllMap.get("orgIds");
					String orgIds2 = StringUtil.unionTwoStringArray(orgIds, orgAllIds);
					modularAllMap.put("orgIds",orgIds2);
					isCz = false;
				}
			}
			if(isCz){
				Map<String, String> modularAllMap = new HashMap<String, String>();
				modularAllMap.put("modularId", modularMap.get("modularId"));
				modularAllMap.put("modularName", modularMap.get("modularName"));
				modularAllMap.put("modularUrl", modularMap.get("modularUrl"));
				modularAllMap.put("modularParentId", modularMap.get("modularParentId"));
				modularAllMap.put("modularCode", modularMap.get("modularCode"));
				modularAllMap.put("orgIds", modularMap.get("orgIds"));
				modularAllList.add(modularAllMap);
			}
			
		}
	}
 //修改用户登录信息
	@Override
	public int updateUserinfo(BhSysUserLoginInfo bhsysuserlogininfo) {
		
		return bhSysUserLoginInfoMapper.updateByPrimaryKeySelective(bhsysuserlogininfo);
	}

}
