package com.dcits.jb.manager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dcits.jb.manager.single.model.BhSysUserLoginInfo;
import com.dcits.jb.manager.single.model.BhSysUserModularInfo;
import com.dcits.jb.manager.single.model.BhSysUserOrgInfo;
import com.dcits.jb.manager.single.model.BhSysUserOrgRel;
import com.dcits.jb.manager.single.model.BhSysUserPostInfo;
import com.dcits.jb.manager.single.model.BhSysUserPostRole;
import com.dcits.jb.manager.single.model.BhSysUserRoleInfo;
import com.dcits.jb.manager.vo.PostRoleDataLevel;

public interface UserSystemService {
	public List<HashMap<String,String>> getUserListByCaseOnPage(String name,String loginName,String staffNum,String orgIds,int rows,int page);
	
	public int getCountUserListByCaseOnPage(String name,String loginName,String staffNum,String orgIds);

	/**
	 * 带条件分页查询角色列表信息
	 * @author caoxiaoa
	 * @param roleName
	 * @param rows
	 * @param page
	 * @return
	 */
	public List<BhSysUserRoleInfo> getRoleListByCaseOnPage(String roleName, int rows, int page);

	/**
	 * 查询角色总记录数
	 * @author caoxiaoa
	 * @param roleName
	 * @return
	 */
	public int getCountRoleListByCaseOnPage(String roleName);
	
	/**
	 * 模块树加载
	 * @author cuiwt
	 * 
	 */
	public String modularTreeLoad();
	
	/**
	 * 角色模块树
	 * @author caoxiaoa
	 * @return
	 */
	public String roleModularTreeLoad();
	
	/**
	 * 保存新增模块
	 * @author cuiwt
	 * @param BhSysUserModularInfo
	 */
	public int insertModular(BhSysUserModularInfo bhSysUserModularInfo);
	/**
	 * 更新模块
	 * @author cuiwt
	 * @param BhSysUserModularInfo
	 */
	public int updateModular(BhSysUserModularInfo bhSysUserModularInfo);
	/**
	 * 删除模块
	 * @author cuiwt
	 * @param modularId
	 */
	public String deleteModular(String modularId);
	/**
	 * 查询模块列表
	 * @author cuiwt
	 * @param modularId
	 * @param modularCode
	 * @param named
	 * @param rows
	 * @param page
	 */
	public List<BhSysUserModularInfo> getModularListByCaseOnPage(String modularId,String name,String modularCode,int rows,int page);
	/**
	 * 根据ID查询模块
	 * @author cuiwt
	 * @param modularId
	 */
	public BhSysUserModularInfo getModularById(String modularId);
	/**
	 * 根据条件查询总记录数
	 * @author cuiwt
	 * @param modularId
	 * @param modularCode
	 * @param name
	 */
	public int getCountModularListByCaseOnPage(String modularId,String name,String modularCode);
	/**
	 * 新增用户
	 * @author xingyxa
	 * @param bhSysUserLoginInfo 用户基本信息
	 * @param postRows 用户机构岗位信息
	 */
	public String insertUser(BhSysUserLoginInfo bhSysUserLoginInfo,String postRows);
	/**
	 * 修改用户
	 * @author xingyxa
	 * @param bhSysUserLoginInfo
	 * @param postRows 用户的机构岗位信息
	 */
	public String updateUser(BhSysUserLoginInfo bhSysUserLoginInfo,String postRows);
	/**
	 * 新增用户机构岗位信息
	 * @author xingyxa
	 * @param record
	 */
	public void insertBhSysUserOrgRel(BhSysUserOrgRel record);
	/**
	 * 新增用户基本信息
	 * @author xingyxa
	 * @param record
	 */
	public void insertBhSysUserLoginInfo(BhSysUserLoginInfo record);
	/**
	 * 根据主键ID查询用户信息
	 * @author xingyxa
	 * @param userId 主键ID
	 * @return 用户信息
	 */
	public BhSysUserLoginInfo getByPrimaryKey(String userId);
	/**
	 * 重置密码为pass123
	 * @author xingyxa
	 * @param record
	 * @return 重置成功记录数
	 */
	public int updateUserPass(BhSysUserLoginInfo record);
	/**
	 * 删除用户信息
	 * @author xingyxa
	 * @param userId
	 * @return
	 */
	public void deleteUser(String userId);
	/**
	 * 根据用户主键删除用户基本信息
	 * @author xingyxa
	 * @param userId 用户主键
	 * @return
	 */
	public int deleteUserLoginInfoByPrimaryKey(String userId);
	/**
	 * 根据用户主键删除用户机构岗位关联信息
	 * @author xingyxa
	 * @param userId
	 * @return
	 */
	public int deleteUserOrgRelByUserId(String userId);

	/**
	 * 查询岗位列表
	 * @author xingyxa
	 * @return String
	 */
	public String getPosts(String isadmin);
	/**
	 * 根据登录名称查询用户数量
	 * @author  xingyxa 
	 * @param loginName
	 * @return int 用户数量
	 */
	public int getUserByLoginName(BhSysUserLoginInfo bhSysUserLoginInfo);
	
	/**
	 * 查询当前用户已选择的岗位信息
	 * @author  xingyxa 
	 * @return
	 */
	public String getPostsByWhere(String userId);

	/**
	 * 查询当前用户未选择的岗位信息
	 * @author  xingyxa 
	 * @return
	 */
	public String getPostsByNotIn(String userId);
	
	/**
	 * 查询当前用户已选择的机构信息
	 * @author  xingyxa 
	 * @return
	 */
	public String getOrgsByWhere(String userId);
	/**
	 * 获取机构列表信息
	 * @author xingyxa
	 * @return String
	 */
	public String getOrgs(String orgIds);
	
	public List<BhSysUserOrgInfo> getOrgInfoListByOrgids(String orgIds);
	/**
	 * 获取指定用户的机构岗位权限
	 * @author  xingyxa 
	 * @return
	 */
	public List<HashMap<String, String>> getUserRels(String userId);
	/**
	 * 新增角色
	 * @author caoxiaoa
	 * @param roleName
	 * @param comments
	 * @param idsArray
	 * @return
	 */
	public String insertRoleInfo(String roleName, String comments, String[] idsArray);

	/**
	 * 删除角色
	 * @author caoxiaoa
	 * @param id
	 * @return
	 */
	public String deleteRoleInfo(String id);

	/**
	 * 根据角色id查询角色信息
	 * @param id
	 * @return
	 */
	public BhSysUserRoleInfo getRoleByRoleId(String id);

	/**
	 * 编辑更新角色信息
	 * @param roleId
	 * @param roleName
	 * @param comments
	 * @param idsArray
	 * @return
	 */
	public String updateRoleInfo(String roleId, String roleName, String comments, String[] idsArray);
	/**
	 * 根据组织机构id查询 本机构信息
	 * @author lijufa
	 * @param orgId
	 * @return
	 */
	public BhSysUserOrgInfo  getBhSysUserOrgInfoOne(String orgId);
	/**
	 * 根据组织机构id查询子机构
	 * @author lijufa
	 * @param orgId
	 * @return
	 */
	public List<BhSysUserOrgInfo>  getBhSysUserOrgInfo(String orgId);
	/**
	 * 保存新增机构
	 * @author lijufa
	 * @param bhsysuserorginfo
	 */
	public int insertOrgInfo(BhSysUserOrgInfo bhsysuserorginfo);
	/**
	 * 更新机构
	 * @author lijufa
	 * @param bhsysuserorginfo
	 */
	public int updateOrgInfo(BhSysUserOrgInfo bhsysuserorginfo);
	/**
	 * 删除机构
	 * @author lijufa
	 * @param orgId
	 */
	public String deleteOrgInfo(String orgId);
	/**
	 * 查询orgCode 判断orgCode唯一
	 * @author lijufa
	 * @param bhsysuserorginfo
	 */
	public BhSysUserOrgInfo getOrgInfoByOrgCode(String orgCode);
	/**
	 * 根据ID查询机构
	 * @author lijufa
	 * @param orgId
	 */
	public BhSysUserOrgInfo getOrgInfoById(String orgId);
	/**
	 * 带条件分页查询机构列表信息
	 * @author lijufa
	 * @param orgName
	 * @param rows
	 * @param page
	 * @return
	 */
	public List<BhSysUserOrgInfo> getOrgListByCaseOnPage(String serch_name,String serch_orgCode,String orgParentId,String orgIds, int rows, int page);

	/**
	 * 查询机构总记录数
	 * @author lijufa
	 * @param orgName
	 * @return
	 */
	public int getCountOrgListByCaseOnPage(String serch_name,String serch_orgCode,String orgParentId,String orgIds);
	/**
	 * 根据条件查询统计记录条数
	 * @author lips
	 * @param postname
	 * @return
	 */
	public int getCountPostListByCaseOnPage(String postname);
	/**
	 * 带条件分页查询岗位列表信息
	 * @author lips
	 * @param postName
	 * @param rows
	 * @param page
	 * @return
	 */
	public List<BhSysUserPostInfo> getPostListByCaseOnPage(String postName, int rows, int page);
	
	/**
	 * 新增岗位信息
	 * @author lips
	 * @param bhSysUserPostInfo
	 */
	public int insertPost(BhSysUserPostInfo bhSysUserPostInfo,List<BhSysUserPostRole> list);
		
	/**
	 * 删除岗位信息
	 * @author lips
	 * @param postId
	 * @return
	 */
	public Map<String, String> deletePost(String postId);
	/**
	 * 根据id查询岗位信息
	 * @author lips
	 * @param postId
	 * @return
	 */
	public BhSysUserPostInfo getPostByPrimarykey(String postId);
	/**
	 * 更新岗位信息
	 * @author lips
	 * @param bhSysUserPostInfo
	 * @return
	 */
	public int updatePostByPrimaryKey(BhSysUserPostInfo bhSysUserPostInfo);

	/**
	 * 根据角色id查询角色拥有的资源id集合
	 * @author caoxiaoa
	 * @param roleId
	 * @return
	 */
	public List<String> getHaveModulars(String roleId);
	/**
	 * 查询角色列表
	 * @author lips
	 * @return String
	 */
	public String getRoles();
	/**
	 * 根据岗位id查询对应的岗位角色
	 * @author lips
	 */
	public List<PostRoleDataLevel> getPostRoleByPostId(String postid);
	/**
	 * 编辑修改岗位信息
	 * @param postId
	 * @param postName
	 * @param comments
	 * @param rowid
	 * @param datalev
	 * @return
	 */
	public String updatePostInfo(String postId, String postName, String comments, String[] rowid, String[] datalev);
	
	
	
	
}
