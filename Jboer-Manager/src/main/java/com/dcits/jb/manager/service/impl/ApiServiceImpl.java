package com.dcits.jb.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.jb.manager.service.ApiService;
import com.dcits.jb.manager.single.mapper.BhAuthUserMainMapper;
import com.dcits.jb.manager.single.mapper.BhMachineUserRelMapper;
import com.dcits.jb.manager.single.mapper.BhUserAuthLoginMapper;
import com.dcits.jb.manager.single.model.BhAuthUserLogin;
import com.dcits.jb.manager.single.model.BhAuthUserMain;
import com.dcits.jb.manager.single.model.BhMachineUserRel;

/**
 * 客户信息服务层实现层
 *
 * @author jiaomy
 */
@Service("apiService")
public class ApiServiceImpl implements ApiService {

    @Autowired
    BhUserAuthLoginMapper bhAuthUserLoginMapper;
    @Autowired
    BhAuthUserMainMapper bhAuthUserMainMapper;
    @Autowired
    BhMachineUserRelMapper bhMachineUserRelMapper;

    @Override
    public BhAuthUserLogin getBhAuthUserLoginByLoginName(String loginName) {
        // TODO 自动生成的方法存根
        return bhAuthUserLoginMapper.selectByLoginName(loginName);
    }

    @Override
    public boolean saveBhAuthUserLogin(BhAuthUserLogin bhAuthUserLogin) {
        // TODO 自动生成的方法存根
        return bhAuthUserLoginMapper.insertBhAuthUserLogin(bhAuthUserLogin) > 1;
    }

    @Override
    public boolean SaveBhAuthUserMain(BhAuthUserMain bhAuthUserMain) {
        // TODO 自动生成的方法存根
        BhAuthUserMain bhUserMain = bhAuthUserMainMapper.selectByPrimaryKey(bhAuthUserMain.getUserId());
        if (bhUserMain == null) {
            return bhAuthUserMainMapper.insert(bhAuthUserMain)>1;
        } else {
            return bhAuthUserMainMapper.updateByPrimaryKey(bhAuthUserMain) > 1;
        }
    }

    @Override
    public boolean SaveBhMachineUserRel(BhMachineUserRel bhMachineUserRel) {
        // TODO 自动生成的方法存根
    	BhMachineUserRel bhMachineUser=bhMachineUserRelMapper.selectByUserId(bhMachineUserRel.getUserId());
    	if(bhMachineUser==null){
        return bhMachineUserRelMapper.insert(bhMachineUserRel)>1;
    	}else
    	{
    		return bhMachineUserRelMapper.updateByUserId(bhMachineUserRel)>1;
    	}
    }

    @Override
    public BhMachineUserRel getBhMachineUserRelByUserId(String userid) {
        // TODO 自动生成的方法存根
        return bhMachineUserRelMapper.selectByUserId(userid);
    }

    @Override
    public BhMachineUserRel getBhMachineUserRelByMachineId(String machineId) {
        // TODO 自动生成的方法存根
        return null;
    }

    @Override
    public BhMachineUserRel getBhMachineUserRelByUserOrMachine(String userId,
            String machineId) {
        // TODO 自动生成的方法存根
        return null;
    }

    @Override
    public BhAuthUserMain getBhAuthUserMainByUserId(String userId) {
        // TODO 自动生成的方法存根
        return bhAuthUserMainMapper.selectByPrimaryKey(userId);
    }

}
