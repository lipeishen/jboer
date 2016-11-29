package com.dcits.djk.manager.single.model;

public class BhSysUserModularInfo {
    private String modularId;

    private String modularName;

    private String modularParentId;

    private String modularCode;

    private String modularUrl;

    private String comments;

    public String getModularId() {
        return modularId;
    }

    public void setModularId(String modularId) {
        this.modularId = modularId == null ? null : modularId.trim();
    }

    public String getModularName() {
        return modularName;
    }

    public void setModularName(String modularName) {
        this.modularName = modularName == null ? null : modularName.trim();
    }

    public String getModularParentId() {
        return modularParentId;
    }

    public void setModularParentId(String modularParentId) {
        this.modularParentId = modularParentId == null ? null : modularParentId.trim();
    }

    public String getModularCode() {
        return modularCode;
    }

    public void setModularCode(String modularCode) {
        this.modularCode = modularCode == null ? null : modularCode.trim();
    }

    public String getModularUrl() {
        return modularUrl;
    }

    public void setModularUrl(String modularUrl) {
        this.modularUrl = modularUrl == null ? null : modularUrl.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }
}