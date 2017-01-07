package com.dcits.jb.manager.single.model;

import java.util.Date;

public class BhMachineMainInfo {
    private String machineId;

    private String machineType;

    private String machineName;

    private String machineCode;

    private String machinePicUrl;

    private Long machinePrice;

    private Long machineStockTotal;

    private Long machineStockRemain;

    private Date machineCreateTime;

    private String machineIssale;

    private String machineIsvalid;

    private String machineMac;

    private String machineHasvoice;

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId == null ? null : machineId.trim();
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType == null ? null : machineType.trim();
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName == null ? null : machineName.trim();
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode == null ? null : machineCode.trim();
    }

    public String getMachinePicUrl() {
        return machinePicUrl;
    }

    public void setMachinePicUrl(String machinePicUrl) {
        this.machinePicUrl = machinePicUrl == null ? null : machinePicUrl.trim();
    }

    public Long getMachinePrice() {
        return machinePrice;
    }

    public void setMachinePrice(Long machinePrice) {
        this.machinePrice = machinePrice;
    }

    public Long getMachineStockTotal() {
        return machineStockTotal;
    }

    public void setMachineStockTotal(Long machineStockTotal) {
        this.machineStockTotal = machineStockTotal;
    }

    public Long getMachineStockRemain() {
        return machineStockRemain;
    }

    public void setMachineStockRemain(Long machineStockRemain) {
        this.machineStockRemain = machineStockRemain;
    }

    public Date getMachineCreateTime() {
        return machineCreateTime;
    }

    public void setMachineCreateTime(Date machineCreateTime) {
        this.machineCreateTime = machineCreateTime;
    }

    public String getMachineIssale() {
        return machineIssale;
    }

    public void setMachineIssale(String machineIssale) {
        this.machineIssale = machineIssale == null ? null : machineIssale.trim();
    }

    public String getMachineIsvalid() {
        return machineIsvalid;
    }

    public void setMachineIsvalid(String machineIsvalid) {
        this.machineIsvalid = machineIsvalid == null ? null : machineIsvalid.trim();
    }

    public String getMachineMac() {
        return machineMac;
    }

    public void setMachineMac(String machineMac) {
        this.machineMac = machineMac == null ? null : machineMac.trim();
    }

    public String getMachineHasvoice() {
        return machineHasvoice;
    }

    public void setMachineHasvoice(String machineHasvoice) {
        this.machineHasvoice = machineHasvoice == null ? null : machineHasvoice.trim();
    }
}