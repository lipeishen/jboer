package com.dcits.jb.manager.single.model;

public class BhSysUserRoleModular {
    private String roleModularId;

    private String roleId;

    private String modularId;

    public String getRoleModularId() {
        return roleModularId;
    }

    public void setRoleModularId(String roleModularId) {
        this.roleModularId = roleModularId == null ? null : roleModularId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getModularId() {
        return modularId;
    }

    public void setModularId(String modularId) {
        this.modularId = modularId == null ? null : modularId.trim();
    }
}