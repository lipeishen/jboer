package com.dcits.djk.manager.single.model;

import java.util.Date;

public class BhMachineOrderInfo {
    private String machineOrderId;

    private String machineOrderType;

    private String machineOrderNum;

    private String machineId;

    private String userId;

    private Date machineOrderCreateTime;

    private Long machineOrderQuantity;

    private Long machineOrderAmount;

    private String machineOrderStatus;

    public String getMachineOrderId() {
        return machineOrderId;
    }

    public void setMachineOrderId(String machineOrderId) {
        this.machineOrderId = machineOrderId == null ? null : machineOrderId.trim();
    }

    public String getMachineOrderType() {
        return machineOrderType;
    }

    public void setMachineOrderType(String machineOrderType) {
        this.machineOrderType = machineOrderType == null ? null : machineOrderType.trim();
    }

    public String getMachineOrderNum() {
        return machineOrderNum;
    }

    public void setMachineOrderNum(String machineOrderNum) {
        this.machineOrderNum = machineOrderNum == null ? null : machineOrderNum.trim();
    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId == null ? null : machineId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getMachineOrderCreateTime() {
        return machineOrderCreateTime;
    }

    public void setMachineOrderCreateTime(Date machineOrderCreateTime) {
        this.machineOrderCreateTime = machineOrderCreateTime;
    }

    public Long getMachineOrderQuantity() {
        return machineOrderQuantity;
    }

    public void setMachineOrderQuantity(Long machineOrderQuantity) {
        this.machineOrderQuantity = machineOrderQuantity;
    }

    public Long getMachineOrderAmount() {
        return machineOrderAmount;
    }

    public void setMachineOrderAmount(Long machineOrderAmount) {
        this.machineOrderAmount = machineOrderAmount;
    }

    public String getMachineOrderStatus() {
        return machineOrderStatus;
    }

    public void setMachineOrderStatus(String machineOrderStatus) {
        this.machineOrderStatus = machineOrderStatus == null ? null : machineOrderStatus.trim();
    }
}