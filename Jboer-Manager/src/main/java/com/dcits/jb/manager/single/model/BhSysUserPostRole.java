package com.dcits.jb.manager.single.model;

public class BhSysUserPostRole {
    private String postRoleId;

    private String postId;

    private String roleId;

    private String dateLevel;

    public String getPostRoleId() {
        return postRoleId;
    }

    public void setPostRoleId(String postRoleId) {
        this.postRoleId = postRoleId == null ? null : postRoleId.trim();
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId == null ? null : postId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getDateLevel() {
        return dateLevel;
    }

    public void setDateLevel(String dateLevel) {
        this.dateLevel = dateLevel == null ? null : dateLevel.trim();
    }
}