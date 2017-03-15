package com.dcits.jb.manager.single.mapper;

import com.dcits.jb.manager.single.model.BhMachineUserRel;

/**
 *
 * @author jiaomy
 */
public interface BhMachineUserRelMapper {
    
    BhMachineUserRel selectByUserId(String userId);
    
    int insert(BhMachineUserRel bhMachineUserRel);
    
    int updateByUserId(BhMachineUserRel bhMachineUserRel);
}
