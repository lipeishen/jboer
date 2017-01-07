package com.dcits.jb.manager.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.jb.core.util.UuidUtil;
import com.dcits.jb.manager.service.UserSystemService;
import com.dcits.jb.manager.single.mapper.BhSysUserLoginInfoMapper;
import com.dcits.jb.manager.single.mapper.BhSysUserModularInfoMapper;
import com.dcits.jb.manager.single.mapper.BhSysUserOrgInfoMapper;
import com.dcits.jb.manager.single.mapper.BhSysUserOrgRelMapper;
import com.dcits.jb.manager.single.mapper.BhSysUserPostInfoMapper;
import com.dcits.jb.manager.single.mapper.BhSysUserPostRoleMapper;
import com.dcits.jb.manager.single.mapper.BhSysUserRoleInfoMapper;
import com.dcits.jb.manager.single.mapper.BhSysUserRoleModularMapper;
import com.dcits.jb.manager.single.model.BhSysUserLoginInfo;
import com.dcits.jb.manager.single.model.BhSysUserModularInfo;
import com.dcits.jb.manager.single.model.BhSysUserOrgInfo;
import com.dcits.jb.manager.single.model.BhSysUserOrgInfoExample;
import com.dcits.jb.manager.single.model.BhSysUserOrgRel;
import com.dcits.jb.manager.single.model.BhSysUserOrgRelExample;
import com.dcits.jb.manager.single.model.BhSysUserOrgRelExample.Criteria;
import com.dcits.jb.manager.single.model.BhSysUserPostInfo;
import com.dcits.jb.manager.single.model.BhSysUserPostRole;
import com.dcits.jb.manager.single.model.BhSysUserRoleInfo;
import com.dcits.jb.manager.single.model.BhSysUserRoleModular;
import com.dcits.jb.manager.union.mapper.UserSystemMapper;
import com.dcits.jb.manager.vo.PostRoleDataLevel;
import com.dcits.jb.manager.vo.TreeVo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service("userSystemService")
public class UserSystemServiceImpl implements UserSystemService{
	private Logger logger = Logger.getLogger(UserSystemServiceImpl.class);
	@Autowired
	private UserSystemMapper userSystemMapper;
	
	@Autowired
	private BhSysUserModularInfoMapper bhSysUserModularInfoMapper;
	@Autowired
    private BhSysUserLoginInfoMapper bhSysUserLoginInfoMapper;
	@Autowired
	private BhSysUserOrgRelMapper bhSysUserOrgRelMapper;
	@Autowired
	private BhSysUserRoleInfoMapper bhSysUserRoleInfoMapper;
	@Autowired
	private BhSysUserRoleModularMapper bhSysUserRoleModularMapper;
	@Autowired
	private BhSysUserOrgInfoMapper bhSysUserOrgInfoMapper;
	@Autowired
	private BhSysUserPostInfoMapper bhSysUserPostInfoMapper;
	@Autowired
	private BhSysUserPostRoleMapper bhSysUserPostRoleMapper;
	
	@Override
	public List<HashMap<String,String>> getUserListByCaseOnPage(String name, String loginName, String staffNum, String orgIds, int rows,int page) {
		if(orgIds == null || orgIds.equals("")){
			return null;
		}
		String[] orgIdss = orgIds.split(",");
		if(name != null && !name.equals("")){
			name = "%"+name+"%";
		}
		if(loginName != null && !loginName.equals("")){
			loginName = "%"+loginName+"%";
		}
		if(staffNum != null && !staffNum.equals("")){
			staffNum = "%"+staffNum+"%";
		}
		page = (page-1)*rows;
		logger.debug("==============================================serviceinside lsitsql start");
		List<HashMap<String,String>> recordList = userSystemMapper.getUserListByCaseOnPage(name, loginName, staffNum, orgIdss, rows, page);
		logger.debug("==============================================serviceinside lsitsql end");
		return recordList;
	}

	@Override
	public int getCountUserListByCaseOnPage(String name, String loginName, String staffNum, String orgIds) {
		if(orgIds == null || orgIds.equals("")){
			return 0;
		}
		String[] orgIdss = orgIds.split(",");
		if(name != null && !name.equals("")){
			name = "%"+name+"%";
		}
		if(loginName != null && !loginName.equals("")){
			loginName = "%"+loginName+"%";
		}
		if(staffNum != null && !staffNum.equals("")){
			staffNum = "%"+staffNum+"%";
		}
		logger.debug("==============================================serviceinside countsql start");
		int allrows = userSystemMapper.getCountUserListByCaseOnPage(name, loginName, staffNum, orgIdss);
		logger.debug("==============================================serviceinside countsql end");
		return allrows;
	}

	@Override
	public List<BhSysUserRoleInfo> getRoleListByCaseOnPage(String roleName, int rows, int page) {
		if(roleName != null && !"".equals(roleName)){
			roleName = "%"+roleName+"%";
		}
		//rows 每页显示的记录数， page 当前页数 
		//1 0 (1-1)*rows
		page = (page-1)*rows;
		List<BhSysUserRoleInfo> roleList = userSystemMapper.getRoleListByCaseOnPage(roleName, rows, page);
		return roleList;
	}

	@Override
	public int getCountRoleListByCaseOnPage(String roleName) {
		if(roleName != null && !"".equals(roleName)){
			roleName = "%"+roleName+"%";
		}
		int allrows = userSystemMapper.getCountRoleListByCaseOnPage(roleName);
		return allrows;
	}
	@Override
	public int getCountPostListByCaseOnPage(String postname){
		if(postname != null && !"".equals(postname)){
			postname = "%"+postname+"%";
		}
		int allrows = userSystemMapper.getCountPostListByCaseOnPage(postname);
		return allrows;
		
	}
	@Override
	public List<BhSysUserPostInfo> getPostListByCaseOnPage(String postName, int rows, int page){
		if(postName != null && !"".equals(postName)){
			postName = "%"+postName+"%";
		}
		page = (page-1)*rows;
		List<BhSysUserPostInfo> postList = userSystemMapper.getPostListByCaseOnPage(postName, rows, page);
		return postList;
		
	}
	/**
	 * 模块树加载
	 * @author cuiwt
	 * @date 2016年2月23日19:05:06
	 */
	@Override
	public String modularTreeLoad() {
		//查询列表
		List<BhSysUserModularInfo> modularList = userSystemMapper.selectAll();
		//保存一级菜单集合
		List<TreeVo> list_all= new ArrayList<TreeVo>();
		TreeVo treeVo = new TreeVo();
		treeVo.setId("00000000000000000000000000000000");
		treeVo.setText("资源树");
		List<TreeVo> list= new ArrayList<TreeVo>();
		for (int i = 0; i < modularList.size(); i++) {
			BhSysUserModularInfo info = modularList.get(i);
			String pid = info.getModularParentId();
			//循环所有的菜单项，找出一级菜单
			if("00000000000000000000000000000000".equals(pid)){
				TreeVo treeVo1 = new TreeVo();
				String id = info.getModularId();
				String name = info.getModularName();
				treeVo1.setId(id);
				treeVo1.setText(name);
				//treeVo1.setState("closed");
				//一级菜单对应的二级菜单
				List<TreeVo> list1= new ArrayList<TreeVo>();
				for(int j = 0;j<modularList.size(); j++){
					if(id.equals(modularList.get(j).getModularParentId())){
						TreeVo treeVo2 = new TreeVo();
						treeVo2.setId(modularList.get(j).getModularId());
						treeVo2.setText(modularList.get(j).getModularName());
						//treeVo2.setState("closed");
						List<TreeVo> list2= new ArrayList<TreeVo>();
						for(int k = 0;k<modularList.size(); k++){
							if(modularList.get(j).getModularId().equals(modularList.get(k).getModularParentId())){
								TreeVo treeVo3 = new TreeVo();
								treeVo3.setId(modularList.get(k).getModularId());
								treeVo3.setText(modularList.get(k).getModularName());
								list2.add(treeVo3);
							}
						}
						treeVo2.setChildren(list2);
						list1.add(treeVo2);
						treeVo1.setChildren(list1);
					}
				}
				list.add(treeVo1);
			}
		}
		treeVo.setChildren(list);
		list_all.add(treeVo);
		JSONArray fromObject = JSONArray.fromObject(list_all);
		String data=fromObject.toString();
		return data;
	}
	
	@Override
	public String roleModularTreeLoad() {
		//查询列表
		List<BhSysUserModularInfo> modularList = userSystemMapper.selectAll();
		//保存一级菜单集合
		List<TreeVo> list= new ArrayList<TreeVo>();
		for (int i = 0; i < modularList.size(); i++) {
			BhSysUserModularInfo info = modularList.get(i);
			String pid = info.getModularParentId();
			//循环所有的菜单项，找出一级菜单
			if("00000000000000000000000000000000".equals(pid)){
				TreeVo treeVo1 = new TreeVo();
				String id = info.getModularId();
				String name = info.getModularName();
				treeVo1.setId(id);
				treeVo1.setText(name);
				//一级菜单对应的二级菜单
				List<TreeVo> list1= new ArrayList<TreeVo>();
				for(int j = 0;j<modularList.size(); j++){
					if(id.equals(modularList.get(j).getModularParentId())){
						TreeVo treeVo2 = new TreeVo();
						treeVo2.setId(modularList.get(j).getModularId());
						treeVo2.setText(modularList.get(j).getModularName());
						List<TreeVo> list2= new ArrayList<TreeVo>();
						for(int k = 0;k<modularList.size(); k++){
							if(modularList.get(j).getModularId().equals(modularList.get(k).getModularParentId())){
								TreeVo treeVo3 = new TreeVo();
								treeVo3.setId(modularList.get(k).getModularId());
								treeVo3.setText(modularList.get(k).getModularName());
								list2.add(treeVo3);
							}
						}
						treeVo2.setChildren(list2);
						list1.add(treeVo2);
						treeVo1.setChildren(list1);
					}
				}
				list.add(treeVo1);
			}
		}
		JSONArray fromObject = JSONArray.fromObject(list);
		String data=fromObject.toString();
		return data;
	}
	/**
	 * 保存新增模块
	 * @author cuiwt
	 * @param BhSysUserModularInfo
	 */
	@Override
	public int insertModular(BhSysUserModularInfo bhSysUserModularInfo){
		int selective = bhSysUserModularInfoMapper.insertSelective(bhSysUserModularInfo);
		return selective;
	};
	/**
	 * 更新模块
	 * @author cuiwt
	 * @param BhSysUserModularInfo
	 */
	@Override
	public int updateModular(BhSysUserModularInfo bhSysUserModularInfo){
		int updateByPrimaryKey = bhSysUserModularInfoMapper.updateByPrimaryKeySelective(bhSysUserModularInfo);
		return updateByPrimaryKey;
	};
	/**
	 * 删除模块
	 * @author cuiwt
	 * @param modularId
	 */
	@Override
	public String deleteModular(String modularId){
		//先根据id查询是否有子节点或者是否有角色不允许删除
		int i = userSystemMapper.getModularByParentId(modularId);
		if(i>0){
			//该模块下有子节点，不允许删除
			return "该模块下有子节点，不允许删除";
		}else{
			int j = userSystemMapper.getRoleModularById(modularId);
			if(j>0){
				//该模块有相应的角色
				return "模块有相应的角色,不允许删除";
			}else{
				//可以删除
				bhSysUserModularInfoMapper.deleteByPrimaryKey(modularId);
				return "success";
			}
		}
	};
	@Override
	public String insertUser(BhSysUserLoginInfo bhSysUserLoginInfo,String postRows) {
		Map<String, Object> result = new HashMap<String, Object>();
		//验证登录名称是否唯一
		String loginName = bhSysUserLoginInfo.getLoginName();
		String userId = bhSysUserLoginInfo.getUserId();
		if (!loginName.equals("")) {
			boolean flag = checkLoginName(loginName,userId);
			if (!flag) {
				result.put("success", false);
				result.put("errorMsg", "登录名称重复！");
				JSONObject jo = JSONObject.fromObject(result);
				return jo.toString(); 
			}
		}else{
			result.put("success", false);
			result.put("errorMsg", "登录名称不能为空！");
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		}
		//新增用户信息
		this.insertBhSysUserLoginInfo(bhSysUserLoginInfo);
		//新增用户的机构岗位关联信息
		boolean flag = insertBhSysUserOrgRel(postRows,userId);
		result.put("success", flag);
		JSONObject jo = JSONObject.fromObject(result);
		return jo.toString();
	}

	@Override
	public void insertBhSysUserOrgRel(BhSysUserOrgRel record) {
		int insertnum = bhSysUserOrgRelMapper.insert(record);
	}

	@Override
	public void insertBhSysUserLoginInfo(BhSysUserLoginInfo record) {
		int insertnum = bhSysUserLoginInfoMapper.insert(record);
	}

	@Override
	public BhSysUserLoginInfo getByPrimaryKey(String userId) {
		return bhSysUserLoginInfoMapper.selectByPrimaryKey(userId);
	}

	@Override
	public int updateUserPass(BhSysUserLoginInfo record) {
		return bhSysUserLoginInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteUserLoginInfoByPrimaryKey(String userId) {
		return bhSysUserLoginInfoMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public int deleteUserOrgRelByUserId(String userId) {
		return userSystemMapper.deleteUserOrgRelByUserId(userId);
	}

	@Override
	public void deleteUser(String userId) {
		userSystemMapper.deleteUserOrgRelByUserId(userId);
		bhSysUserLoginInfoMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public String updateUser(BhSysUserLoginInfo bhSysUserLoginInfo,String postRows) {
		//1.修改用户基本信息；
		Map<String, Object> result = new HashMap<String, Object>();
		//验证登录名称是否唯一
		String loginName = bhSysUserLoginInfo.getLoginName();
		String userId = bhSysUserLoginInfo.getUserId();
		if (!loginName.equals("")) {
			boolean flag = checkLoginName(loginName,userId);
			if (!flag) {
				result.put("success", false);
				result.put("errorMsg", "登录名称重复！");
				JSONObject jo = JSONObject.fromObject(result);
				return jo.toString(); 
			}
		}else{
			result.put("success", false);
			result.put("errorMsg", "登录名称不能为空！");
			JSONObject jo = JSONObject.fromObject(result);
			return jo.toString();
		}
		bhSysUserLoginInfoMapper.updateByPrimaryKeySelective(bhSysUserLoginInfo);
		//2.删除关联数据；
		userSystemMapper.deleteUserOrgRelByUserId(userId);
		//3.新增关联数据；
		//新增用户的机构岗位关联信息
		boolean flag = insertBhSysUserOrgRel(postRows,userId);
		result.put("success", flag);
		JSONObject jo = JSONObject.fromObject(result);
		return jo.toString();
		
	}
	/**
	 * 验证用户名是否重复
	 * @author  xingyxa 
	 * @param loginName
	 * @param userId
	 * @return boolean
	 */
	private boolean checkLoginName(String loginName,String userId){
		BhSysUserLoginInfo newBhSysUserLoginInfo = new BhSysUserLoginInfo();
		newBhSysUserLoginInfo.setLoginName(loginName);
		newBhSysUserLoginInfo.setName("");
		newBhSysUserLoginInfo.setStaffNum("");
		newBhSysUserLoginInfo.setUserId(userId);
		int reRows = this.getUserByLoginName(newBhSysUserLoginInfo);
		if (reRows>0) {
			return false;
		}else {
			return true;
		}
	}
	/**
	 * 新增用户的机构岗位关联信息
	 * @author  xingyxa 
	 * @param postRows
	 * @param userId
	 * @return boolean
	 */
	private boolean insertBhSysUserOrgRel(String postRows,String userId){
		JSONArray object = JSONArray.fromObject(postRows);
		for (int i = 0; i < object.size(); i++) {
			JSONObject obj = JSONObject.fromObject(object.toArray()[i]);
			String orgid = (String) obj.get("org_id");
			String post_id = (String) obj.get("post_id");
			BhSysUserOrgRel bhSysUserOrgRel = new BhSysUserOrgRel();
			bhSysUserOrgRel.setUserId(userId);
			bhSysUserOrgRel.setUserOrgId(UuidUtil.get32Uuid());
			bhSysUserOrgRel.setOrgId(orgid);
			bhSysUserOrgRel.setPostId(post_id);
			bhSysUserOrgRelMapper.insert(bhSysUserOrgRel);
		}
		return true;
	}
	@Override
	public String getPosts(String isadmin) {
		List<HashMap<String, String>> postInfos = userSystemMapper.getPosts(isadmin);
		try {
			JSONArray json = JSONArray.fromObject(postInfos);
			String result = json.toString();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public String getPostsByWhere(String userId) {
		try {
			List<HashMap<String, String>> postInfos = userSystemMapper.getPostsByWhere(userId);
			JSONArray json = JSONArray.fromObject(postInfos);
			String result = json.toString();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	@Override
	public String getPostsByNotIn(String userId) {
		try {
			List<HashMap<String, String>> postInfos = userSystemMapper.getPostsByNotIn(userId);
			JSONArray json = JSONArray.fromObject(postInfos);
			String result = json.toString();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	@Override
	public String getOrgsByWhere(String userId) {
		try {
			List<HashMap<String, String>> orgInfos = userSystemMapper.getOrgsByWhere(userId);
			JSONArray json = JSONArray.fromObject(orgInfos);
			String result = json.toString();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	@Override
	public String getOrgs(String orgIds) {
		try {
			if(orgIds == null || orgIds.equals("")){
				return "[]";
			}
			String[] orgIdArr = orgIds.split(",");
			List<String> orgIdList = Arrays.asList(orgIdArr);
			BhSysUserOrgInfoExample bhSysUserOrgInfoExample = new BhSysUserOrgInfoExample();
			bhSysUserOrgInfoExample.createCriteria().andOrgIdIn(orgIdList);
			bhSysUserOrgInfoExample.setOrderByClause("org_code");
			
			List<HashMap<String, String>> orgInfos = userSystemMapper.getOrgs(bhSysUserOrgInfoExample);
			JSONArray json = JSONArray.fromObject(orgInfos);
			String result = json.toString();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	@Override
	public int getUserByLoginName(BhSysUserLoginInfo bhSysUserLoginInfo) {
		int reRows = 0;
		try {
			reRows = userSystemMapper.getCountUser(bhSysUserLoginInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reRows;
	}

	@Override
	public List<HashMap<String, String>> getUserRels(String userId) {
		return userSystemMapper.getUserRels(userId);
	}
	/**
	 * 查询模块列表
	 * @author cuiwt
	 * @param BhSysUserModularInfo
	 */
	@Override
	public List<BhSysUserModularInfo> getModularListByCaseOnPage(String modularId,String name,String modularCode,int rows,int page){
		if(name != null && !name.equals("")){
			name = "%"+name+"%";
		}
		if(modularCode != null && !modularCode.equals("")){
			modularCode = modularCode+"%";
		}
		page=(page-1)*rows;
		List<BhSysUserModularInfo> modularList = userSystemMapper.getModularListByCaseOnPage(name,modularId, modularCode,rows, page);
		return modularList;
	};
	/**
	 * 根据条件查询总记录数
	 * @author cuiwt
	 * @param modularId
	 * @param modularCode
	 * @param name
	 */
	@Override
	public int getCountModularListByCaseOnPage(String modularId,String name,String modularCode){
		if(name != null && !name.equals("")){
			name = "%"+name+"%";
		}
		if(modularCode != null && !modularCode.equals("")){
			modularCode = modularCode+"%";
		}
		int allrows = userSystemMapper.getCountModularListByCaseOnPage(name,modularId,modularCode);
		return allrows;
	};
	/**
	 * 根据ID查询模块
	 * @author cuiwt
	 * @param modularId
	 */
	@Override
	public BhSysUserModularInfo getModularById(String modularId){
		BhSysUserModularInfo bhSysUserModularInfo = bhSysUserModularInfoMapper.selectByPrimaryKey(modularId);
		return bhSysUserModularInfo;
	};
	@Override
	public String insertRoleInfo(String roleName, String comments, String[] idsArray) {
		String rid = UuidUtil.get32Uuid();
		BhSysUserRoleInfo role = new BhSysUserRoleInfo();
		role.setComments(comments);
		role.setRoleName(roleName);
		role.setRoleId(rid);
		int insert = bhSysUserRoleInfoMapper.insert(role);
		if(insert == 1){
			//判断角色资源关系是否为空
			if(idsArray != null && idsArray.length > 0){
				Set<String> set = new HashSet<String>();
				for (String id : idsArray) {
					//根据id查询资源
					BhSysUserModularInfo modularInfo = bhSysUserModularInfoMapper.selectByPrimaryKey(id);
					if(modularInfo != null && !"00000000000000000000000000000000".equals(modularInfo.getModularParentId())){
						set.add(modularInfo.getModularId());
						set.add(modularInfo.getModularParentId());
						BhSysUserModularInfo modularInfo1 = bhSysUserModularInfoMapper.selectByPrimaryKey(modularInfo.getModularParentId());
						if(modularInfo1 != null && !"00000000000000000000000000000000".equals(modularInfo1.getModularParentId())){
							set.add(modularInfo1.getModularParentId());
						}
					}
				}
				if(set != null && set.size() > 0){
					for (String mid : set) {
						String uuid = UuidUtil.get32Uuid();
						BhSysUserRoleModular roleModular = new BhSysUserRoleModular();
						roleModular.setModularId(mid);
						roleModular.setRoleId(role.getRoleId());
						roleModular.setRoleModularId(uuid);
						bhSysUserRoleModularMapper.insert(roleModular);
					}
				}else{
					//保存角色资源关系失败
					return "error1";
				}
			}
		}else{
			//保存角色失败
			return "error2";
		}
		return "success";
	}

	@Override
	public String deleteRoleInfo(String id) {
		//根据id查询角色
		BhSysUserRoleInfo roleInfo = bhSysUserRoleInfoMapper.selectByPrimaryKey(id);
		if(roleInfo != null){
			//查询是否有岗位关联
			int rec = userSystemMapper.getCountPostRole(id);
			if(rec == 0){
				//1.删除角色资源关联信息
				userSystemMapper.deleteByRoleId(id);
				//2.删除角色
				bhSysUserRoleInfoMapper.deleteByPrimaryKey(id);
				return "success";
			}else{
				return "error1";
			}
		}else{
			//此角色不存在
			return "error2";
		}
	}

	@Override
	public BhSysUserRoleInfo getRoleByRoleId(String id) {
		return bhSysUserRoleInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public String updateRoleInfo(String roleId, String roleName, String comments, String[] idsArray) {
		//根据roleid查询roelinfo
		BhSysUserRoleInfo role = bhSysUserRoleInfoMapper.selectByPrimaryKey(roleId);
		if(role != null){
			role.setComments(comments);
			role.setRoleName(roleName);
			int update = bhSysUserRoleInfoMapper.updateByPrimaryKey(role);
			if(update == 1){
				//1.删除角色资源关联信息
				userSystemMapper.deleteByRoleId(roleId);
				//判断角色资源关系是否为空
				if(idsArray != null && idsArray.length > 0){
					Set<String> set = new HashSet<String>();
					for (String id : idsArray) {
						//根据id查询资源
						BhSysUserModularInfo modularInfo = bhSysUserModularInfoMapper.selectByPrimaryKey(id);
						if(modularInfo != null && !"00000000000000000000000000000000".equals(modularInfo.getModularParentId())){
							set.add(modularInfo.getModularId());
							set.add(modularInfo.getModularParentId());
							BhSysUserModularInfo modularInfo1 = bhSysUserModularInfoMapper.selectByPrimaryKey(modularInfo.getModularParentId());
							if(modularInfo1 != null && !"00000000000000000000000000000000".equals(modularInfo1.getModularParentId())){
								set.add(modularInfo1.getModularParentId());
							}
						}
					}
					if(set != null && set.size() > 0){
						for (String mid : set) {
							String uuid = UuidUtil.get32Uuid();
							BhSysUserRoleModular roleModular = new BhSysUserRoleModular();
							roleModular.setModularId(mid);
							roleModular.setRoleId(role.getRoleId());
							roleModular.setRoleModularId(uuid);
							bhSysUserRoleModularMapper.insert(roleModular);
						}
					}
				}
			}else{
				return "error1";
			}
		}else{
			return "error2";
		}
		return "success";
	}
	

	@Override
	public List<BhSysUserOrgInfo>  getBhSysUserOrgInfo(String orgId){
		List<BhSysUserOrgInfo> bhsysuserorginfoList = userSystemMapper.selectByOrgParentId(orgId);
		return bhsysuserorginfoList;
	}
	@Override
	public BhSysUserOrgInfo  getBhSysUserOrgInfoOne(String orgId){
		BhSysUserOrgInfo bhsysuserorginfo = bhSysUserOrgInfoMapper.selectByPrimaryKey(orgId);
		return bhsysuserorginfo;
	}
	@Override
	public List<BhSysUserOrgInfo> getOrgListByCaseOnPage(String serch_name,String serch_orgCode,String orgParentId,String orgIds, int rows, int page) {
		// TODO Auto-generated method stub
		if(serch_name != null && !"".equals(serch_name)){
			serch_name = "%"+serch_name+"%";
		}
		if(serch_orgCode != null && !"".equals(serch_orgCode)){
			serch_orgCode = "%"+serch_orgCode+"%";
		}
		//List<String> orgIdList=new ArrayList<String>();
		String[] orgIdArr =null;
		if(orgIds != null && !"".equals(orgIds)){
			 orgIdArr = orgIds.split(",");
			 //orgIdList = Arrays.asList(orgIdArr);
		}
		//orgIds="'00000000000000000000000000000001','04c96bfa4dd547eebdff5b937d6d1d7e','0645b835605543dd88a4110e75fa00a4'";
		page=(page-1)*rows;
		List<BhSysUserOrgInfo> orgList = userSystemMapper.getOrgListByCaseOnPage(serch_name,serch_orgCode,orgParentId,orgIdArr,rows, page);
		return orgList;
	}
	@Override
	public int getCountOrgListByCaseOnPage(String serch_name,String serch_orgCode,String orgParentId,String orgIds) {
		// TODO Auto-generated method stub
		if(serch_name != null && !"".equals(serch_name)){
			serch_name = "%"+serch_name+"%";
		}
		if(serch_orgCode != null && !"".equals(serch_orgCode)){
			serch_orgCode = "%"+serch_orgCode+"%";
		}
		String[] orgIdArr =null;
		if(orgIds != null && !"".equals(orgIds)){
			 orgIdArr = orgIds.split(",");
			 //orgIdList = Arrays.asList(orgIdArr);
		}
		//orgIds="'00000000000000000000000000000001','04c96bfa4dd547eebdff5b937d6d1d7e','0645b835605543dd88a4110e75fa00a4'";
		int allrows = userSystemMapper.getCountOrgListByCaseOnPage(serch_name,serch_orgCode,orgParentId,orgIdArr);
		return allrows;
	}
	@Override
	public int insertPost(BhSysUserPostInfo bhSysUserPostInfo,List<BhSysUserPostRole> list){
		int insertnum = bhSysUserPostInfoMapper.insertSelective(bhSysUserPostInfo);
		int sum=0;
		for (BhSysUserPostRole bhSysUserPostRole : list) {
			int code=bhSysUserPostRoleMapper.insert(bhSysUserPostRole);
			sum+=code;
		}
		if (insertnum==1&&sum==list.size()) {
			return 1;
		}
		return 0;
	}
	@Override
	public Map<String, String> deletePost(String postId){
		Map<String, String> map=new HashMap<String,String>();
		BhSysUserOrgRelExample example=new BhSysUserOrgRelExample();
		Criteria criteria = example.createCriteria();
		if (postId!=null&&!"".equals(postId)) {
			criteria.andPostIdEqualTo(postId);
		}
		List<BhSysUserOrgRel> list = bhSysUserOrgRelMapper.selectByExample(example);
		if(list ==null || list.size() < 1){
			bhSysUserPostInfoMapper.deleteByPrimaryKey(postId);
			userSystemMapper.deletePostRoleByPostId(postId);
			map.put("code", "01");
			map.put("msg", "删除成功");
		}else{
			map.put("code", "02");
			map.put("msg", "删除失败，和用户机构表关联");
		}
		
		return map;
	}
	@Override
	public BhSysUserPostInfo getPostByPrimarykey(String postId){
		return bhSysUserPostInfoMapper.selectByPrimaryKey(postId);
	}
	@Override
	public int updatePostByPrimaryKey(BhSysUserPostInfo bhSysUserPostInfo){
		return bhSysUserPostInfoMapper.updateByPrimaryKeySelective(bhSysUserPostInfo);
	}

	@Override
	public int insertOrgInfo(BhSysUserOrgInfo bhsysuserorginfo) {
		// TODO Auto-generated method stub
		int selective = bhSysUserOrgInfoMapper.insertSelective(bhsysuserorginfo);
		return selective;
	}

	@Override
	public int updateOrgInfo(BhSysUserOrgInfo bhsysuserorginfo) {
		// TODO Auto-generated method stub
		int updateByPrimaryKey =  bhSysUserOrgInfoMapper.updateByPrimaryKeySelective(bhsysuserorginfo);
		return updateByPrimaryKey;
	}

	@Override
	public BhSysUserOrgInfo getOrgInfoById(String orgId) {
		// TODO Auto-generated method stub
		BhSysUserOrgInfo bhsysuserorginfo= bhSysUserOrgInfoMapper.selectByPrimaryKey(orgId);
		return bhsysuserorginfo;
	}
	@Override
	public List<String> getHaveModulars(String roleId) {
		return userSystemMapper.getHaveModulars(roleId);
	}
	@Override
	public String deleteOrgInfo(String orgId){
		// TODO Auto-generated method stub
		//先根据id查询是否有子节点或者是否有子机构不允许删除
		List<BhSysUserOrgInfo> bhsysuserorginfoList = userSystemMapper.selectByOrgParentId(orgId);
		if(bhsysuserorginfoList.size()>0){
			//该模块下有子节点，不允许删除
			return "该模块下有子节点，不允许删除";
		}else{
			BhSysUserOrgRelExample example=new BhSysUserOrgRelExample();
			example.createCriteria().andOrgIdEqualTo(orgId);
			List<BhSysUserOrgRel> sysUserOrgRellist =bhSysUserOrgRelMapper.selectByExample(example);
			if(sysUserOrgRellist.size()>0){
				//该模块下有子节点，不允许删除
				return "该模块下有用户，不允许删除";
			}else{//可以删除
				bhSysUserOrgInfoMapper.deleteByPrimaryKey(orgId);
				return "success";
			}
		}
	}

	@Override
	public BhSysUserOrgInfo getOrgInfoByOrgCode(String orgCode) {
		// TODO Auto-generated method stub
		BhSysUserOrgInfo bhsysuserorginfo = userSystemMapper.selectByorgCode(orgCode);
		return bhsysuserorginfo;
	}

	@Override
	public String getRoles() {
		List<HashMap<String, String>> roleInfos = userSystemMapper.getRoles();
		try {
			JSONArray json = JSONArray.fromObject(roleInfos);
			String result = json.toString();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	/**
	 * 根据岗位id查询对应的岗位角色
	 * @author lips
	 */
	public List<PostRoleDataLevel> getPostRoleByPostId(String postid){
		List<PostRoleDataLevel> list =userSystemMapper.getPostRoleByPostId(postid);
		return list;
	}
	/**
	 * 编辑修改岗位信息
	 * @param postId
	 * @param postName
	 * @param comments
	 * @param rowid
	 * @param datalev
	 * @return
	 */
	public String updatePostInfo(String postId, String postName, String comments, String[] rowid, String[] datalev){
		//根据岗位ID查询出岗位实体
		BhSysUserPostInfo postInfo=bhSysUserPostInfoMapper.selectByPrimaryKey(postId);
		if (postInfo!=null) {
			postInfo.setPostName(postName);
			postInfo.setComments(comments);
			int num=bhSysUserPostInfoMapper.updateByPrimaryKey(postInfo);
			int len=rowid.length;
			int sum=0;
			if (num==1) {
				//岗位信息更新成功
				//更新对应的角色信息
				//1.根据岗位id删除对应的记录
				userSystemMapper.deletePostRoleByPostId(postId);
				for(int i=0;i<len;i++){
						//新增一条记录
						BhSysUserPostRole postrole2=new BhSysUserPostRole();
						postrole2.setPostId(postId);
						postrole2.setDateLevel(datalev[i]);
						postrole2.setRoleId(rowid[i]);
						postrole2.setPostRoleId(UuidUtil.get32Uuid());
					  int num1=	bhSysUserPostRoleMapper.insert(postrole2);
					 
					sum+=num1;
				}
				 if(sum!=len){
					  return "error0";
				  }
			}else{
				return "error1";
			}
			
			
		}else{
			return "error2";
		}
		return "success";
		
	}

	@Override
	public List<BhSysUserOrgInfo> getOrgInfoListByOrgids(String orgIds) {
		if(orgIds == null || orgIds.equals("")){
			return null;
		}
		String[] orgIdArr = orgIds.split(",");
		List<String> orgIdList = Arrays.asList(orgIdArr);
		BhSysUserOrgInfoExample bhSysUserOrgInfoExample = new BhSysUserOrgInfoExample();
		bhSysUserOrgInfoExample.createCriteria().andOrgIdIn(orgIdList);
		bhSysUserOrgInfoExample.setOrderByClause("org_code");
		List<BhSysUserOrgInfo> recordList = bhSysUserOrgInfoMapper.selectByExample(bhSysUserOrgInfoExample);
		return recordList;
	}
	
}
