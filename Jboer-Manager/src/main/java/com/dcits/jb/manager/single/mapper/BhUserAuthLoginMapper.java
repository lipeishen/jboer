package com.dcits.jb.manager.single.mapper;

import org.apache.ibatis.annotations.Param;
import com.dcits.jb.manager.single.model.BhAuthUserLogin;

/**
 * @author jiaomy
 */
public interface BhUserAuthLoginMapper
{

    /**
     *
     * @param loginName
     * @return
     */
    BhAuthUserLogin selectByLoginName(@Param("loginName") String loginName);

    /**
     *
     * @param bhAuthUserLogin
     * @return
     */
    int insertBhAuthUserLogin(@Param("bhAuthUserLogin") BhAuthUserLogin bhAuthUserLogin);

}
