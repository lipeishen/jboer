package com.dcits.jb.manager.single.model;

public class BhSysServRouterMain {
    private String routerId;

    private String serviceName;

    private String serviceIp;

    private String servicePort;

    private String serviceContext;

    public String getRouterId() {
        return routerId;
    }

    public void setRouterId(String routerId) {
        this.routerId = routerId == null ? null : routerId.trim();
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public String getServiceIp() {
        return serviceIp;
    }

    public void setServiceIp(String serviceIp) {
        this.serviceIp = serviceIp == null ? null : serviceIp.trim();
    }

    public String getServicePort() {
        return servicePort;
    }

    public void setServicePort(String servicePort) {
        this.servicePort = servicePort == null ? null : servicePort.trim();
    }

    public String getServiceContext() {
        return serviceContext;
    }

    public void setServiceContext(String serviceContext) {
        this.serviceContext = serviceContext == null ? null : serviceContext.trim();
    }
}