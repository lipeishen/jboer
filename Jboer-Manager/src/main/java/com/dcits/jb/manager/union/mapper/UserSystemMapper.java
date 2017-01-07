package com.dcits.jb.manager.union.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dcits.jb.manager.single.model.BhSysUserLoginInfo;
import com.dcits.jb.manager.single.model.BhSysUserModularInfo;
import com.dcits.jb.manager.single.model.BhSysUserOrgInfo;
import com.dcits.jb.manager.single.model.BhSysUserOrgInfoExample;
import com.dcits.jb.manager.single.model.BhSysUserPostInfo;
import com.dcits.jb.manager.single.model.BhSysUserPostRole;
import com.dcits.jb.manager.single.model.BhSysUserRoleInfo;
import com.dcits.jb.manager.vo.PostRoleDataLevel;

public interface UserSystemMapper {
	public int getCountUserListByCaseOnPage(@Param("name") String name, @Param("loginName") String loginName,
			@Param("staffNum") String staffNum, @Param("orgIds") String[] orgIds);

	public List<HashMap<String, String>> getUserListByCaseOnPage(@Param("name") String name,
			@Param("loginName") String loginName, @Param("staffNum") String staffNum, @Param("orgIds") String[] orgIds,
			@Param("rows") int rows, @Param("page") int page);

	public int getCountRoleListByCaseOnPage(@Param("roleName") String roleName);

	public List<BhSysUserRoleInfo> getRoleListByCaseOnPage(@Param("roleName") String roleName, @Param("rows") int rows,
			@Param("page") int page);

	/**
	 * 根据角色id查询多少岗位关联此角色
	 * 
	 * @author caoxiaoa
	 * @param id
	 * @return
	 */
	public int getCountPostRole(@Param("id") String id);

	public int getCountPostListByCaseOnPage(@Param("postName") String postName);

	public List<String> getHaveModulars(@Param("roleId")String roleId);
	
	public void deleteByRoleId(@Param("id")String id);
	
	public int getCountOrgListByCaseOnPage(@Param("serch_name")String serch_name,@Param("serch_orgCode")String serch_orgCode,@Param("parentOrgId")String parentOrgId,@Param("orgIds") String[] orgIds);
	public List<BhSysUserPostInfo> getPostListByCaseOnPage(@Param("postName") String postName, @Param("rows") int rows,
			@Param("page") int page);

	public List<BhSysUserOrgInfo> getOrgListByCaseOnPage(@Param("serch_name") String serch_name,
			@Param("serch_orgCode") String serch_orgCode, @Param("parentOrgId") String parentOrgId,@Param("orgIds") String[] orgIds,
			@Param("rows") int rows, @Param("page") int page);

	/**
	 * 根据orgCode查询机构
	 * 
	 * @author lijufa
	 * @param orgCode
	 * @return
	 */
	BhSysUserOrgInfo selectByorgCode(String orgCode);

	/**
	 * 根据组织机构id查询子机构
	 * 
	 * @author lijufa
	 * @param orgId
	 * @return
	 */
	List<BhSysUserOrgInfo> selectByOrgParentId(String orgId);


	/**
	 * 查询当前用户已选择的岗位信息
	 * @author  xingyxa 
	 * @return 岗位列表
	 */
	List<HashMap<String, String>> getPostsByWhere(String userId);
	/**
	 * 查询当前用户未选择的岗位信息
	 * @author  xingyxa 
	 * @return 岗位列表
	 */
	List<HashMap<String, String>> getPostsByNotIn(String userId);
	/**
	 * 查询当前用户已选择的机构信息
	 * @author  xingyxa 
	 * @return 机构列表
	 */
	List<HashMap<String, String>> getOrgsByWhere(String userId);
	/**
	 * 查询当前用户数量
	 * @author  xingyxa 
	 * @param record
	 * @return
	 */
	int getCountUser(BhSysUserLoginInfo record);
    /**
     * 获取机构列表信息
     * @author  xingyxa 
     * @return 机构列表信息
     */
    List<HashMap<String, String>> getOrgs(BhSysUserOrgInfoExample bhSysUserOrgInfoExample);
    /**
     * 根据用户主键id，删除关联的用户机构岗位信息
     * @author xingyxa
     * @param userId
     * @return 删除成功的记录数
     */
    int deleteUserOrgRelByUserId(String userId);
    /**
     * 获取岗位列表信息
     * @author  xingyxa 
     * @return 岗位列表
     */
	List<HashMap<String, String>> getPosts(@Param("isadmin")String isadmin);
	/**
	 * 获取指定用户的机构岗位权限
	 * @author  xingyxa 
	 * @return
	 */
	List<HashMap<String, String>> getUserRels(String userId);
	/**
	 * 查询所有模块列表
	 * @return
	 */
	public List<BhSysUserModularInfo> selectAll();
	/**
	 * 根据父节点查询模块
	 * @param modularParentId
	 * @return
	 */
	public int getModularByParentId(@Param("modularParentId")String modularParentId);
	/**
	 * 根据模块ID查询角色权限
	 * @param id
	 * @return
	 */
	public int getRoleModularById(@Param("id")String id);
	/**
	 * 查询模块列表
	 * @param name
	 * @param modularId
	 * @param modularCode
	 * @param rows
	 * @param page
	 * @return
	 */
	public List<BhSysUserModularInfo> getModularListByCaseOnPage(@Param("name")String name, @Param("modularId")String modularId,@Param("modularCode")String modularCode,@Param("rows") int rows, @Param("page") int page);
	/**
	 * 获取模块数量
	 * @param name
	 * @param modularId
	 * @param modularCode
	 * @return
	 */
	public int getCountModularListByCaseOnPage(@Param("name")String name, @Param("modularId")String modularId,@Param("modularCode")String modularCode);
	
	public List<HashMap<String, String>> getRoles();
	
	/**
	 * 栏目管理获取登录用户所属机构
	 */
	public List<BhSysUserOrgInfo> getOrgInfoColumn(@Param("userId")String userId);
	
   public List<PostRoleDataLevel> getPostRoleByPostId(@Param("postid")String postid);
   
   public int  updateByPostId(@Param("postId")String postId, @Param("roleid")String roleid,@Param("datalev")String datalev);
	
   public BhSysUserPostRole getPostRoleByCon(@Param("postId")String postId,@Param("roleid")String roleid);
   
   public int  deletePostRoleByPostId(@Param("postId")String postId);
		
	

	
}
