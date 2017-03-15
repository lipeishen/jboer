/**
 * 
 */
package com.dcits.jb.manager.single.model;

import java.util.Date;

/**
 * @author jiaomy
 *
 */
public class BhMachineUserRel {
	
    private String id;

    private String userId;

    private String machine_id;

    private String machine_mac;

    private Date bind_date;

    public String getId() {
        return id;
    }

    public void setSurname(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getMachineId() {
        return machine_id;
    }

    public void setMachineId(String machine_id) {
        this.machine_id = machine_id == null ? null : machine_id.trim();
    }

    public String getMachineMac() {
        return machine_mac;
    }

    public void setMachineMac(String machine_mac) {
        this.machine_mac = machine_mac == null ? null : machine_mac.trim();
    }

    public Date getBindDate() {
        return bind_date;
    }

    public void setBindDate(Date bind_date) {
        this.bind_date = bind_date;
    }


}
