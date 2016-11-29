package com.dcits.djk.manager.single.model;

import java.util.Date;

public class BhProductionOrderInfo {
    private String proOrderId;

    private String proOrderType;

    private String proOrderNum;

    private Date proOrderCreateTime;

    private String productionId;

    private Long proOrderQuantity;

    private String userId;

    private Long proOrderAmount;

    private String proOrderStatus;

    public String getProOrderId() {
        return proOrderId;
    }

    public void setProOrderId(String proOrderId) {
        this.proOrderId = proOrderId == null ? null : proOrderId.trim();
    }

    public String getProOrderType() {
        return proOrderType;
    }

    public void setProOrderType(String proOrderType) {
        this.proOrderType = proOrderType == null ? null : proOrderType.trim();
    }

    public String getProOrderNum() {
        return proOrderNum;
    }

    public void setProOrderNum(String proOrderNum) {
        this.proOrderNum = proOrderNum == null ? null : proOrderNum.trim();
    }

    public Date getProOrderCreateTime() {
        return proOrderCreateTime;
    }

    public void setProOrderCreateTime(Date proOrderCreateTime) {
        this.proOrderCreateTime = proOrderCreateTime;
    }

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId == null ? null : productionId.trim();
    }

    public Long getProOrderQuantity() {
        return proOrderQuantity;
    }

    public void setProOrderQuantity(Long proOrderQuantity) {
        this.proOrderQuantity = proOrderQuantity;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Long getProOrderAmount() {
        return proOrderAmount;
    }

    public void setProOrderAmount(Long proOrderAmount) {
        this.proOrderAmount = proOrderAmount;
    }

    public String getProOrderStatus() {
        return proOrderStatus;
    }

    public void setProOrderStatus(String proOrderStatus) {
        this.proOrderStatus = proOrderStatus == null ? null : proOrderStatus.trim();
    }
}