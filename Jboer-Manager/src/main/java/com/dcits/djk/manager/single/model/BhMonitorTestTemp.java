package com.dcits.djk.manager.single.model;

import java.util.Date;

public class BhMonitorTestTemp {
    private String serviceNodeId;

    private String serviceUrl;

    private String serviceName;

    private Date updateTime;

    public String getServiceNodeId() {
        return serviceNodeId;
    }

    public void setServiceNodeId(String serviceNodeId) {
        this.serviceNodeId = serviceNodeId == null ? null : serviceNodeId.trim();
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl == null ? null : serviceUrl.trim();
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}