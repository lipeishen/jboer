package com.dcits.jb.manager.service;

import com.dcits.jb.manager.single.model.BhAuthUserLogin;
import com.dcits.jb.manager.single.model.BhAuthUserMain;
import com.dcits.jb.manager.single.model.BhMachineUserRel;

/**
 * 客户信息服务层接口层
 * 
 * @author jiaomy
 */
public interface ApiService {
	
	/**
	 * 根据用户登录名判断是否存在该用户
	 * @param loginName
	 * @return
	 */
	public BhAuthUserLogin getBhAuthUserLoginByLoginName(String loginName);
	
	/**
	 * 保存用户登录信息
	 * @param bhAuthUserLogin
	 * @return
	 */
	public boolean saveBhAuthUserLogin(BhAuthUserLogin bhAuthUserLogin);
	
        /**
         * 根据用户id查询用户详细信息
         * @param userId
         * @return 
         */
        public BhAuthUserMain getBhAuthUserMainByUserId(String userId);
	/**
	 * 保存用户详细信息
	 * @param bhAuthUserMain
	 * @return
	 */
	public boolean SaveBhAuthUserMain(BhAuthUserMain bhAuthUserMain);
	/**
	 * 根据用户查询是否存在绑定信息
	 * @param userid
	 * @return
	 */
	public BhMachineUserRel getBhMachineUserRelByUserId(String userid);
	/**
	 * 根据硬件ID查询是否存在绑定信息
	 * @param machineId
	 * @return
	 */
	public BhMachineUserRel getBhMachineUserRelByMachineId(String machineId);
	/**
	 * 根据用户和硬件查询是否存在绑定信息
	 * @param userId
	 * @param machineId
	 * @return
	 */
	public BhMachineUserRel getBhMachineUserRelByUserOrMachine(String userId,String machineId);
	/**
	 * 保存用户绑定硬件信息
	 * @param bhMachineUserRel
	 * @return
	 */
	public boolean SaveBhMachineUserRel(BhMachineUserRel bhMachineUserRel);

}
