package com.dcits.jb.manager.single.model;

import java.util.Date;

public class BhAuthNoticeInfo {
    private String noticeId;

    private String userId;

    private String noticeType;

    private String noticeSource;

    private String noticeTarget;

    private String noticeContent;

    private String noticeStatus;

    private Date createTime;

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId == null ? null : noticeId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType == null ? null : noticeType.trim();
    }

    public String getNoticeSource() {
        return noticeSource;
    }

    public void setNoticeSource(String noticeSource) {
        this.noticeSource = noticeSource == null ? null : noticeSource.trim();
    }

    public String getNoticeTarget() {
        return noticeTarget;
    }

    public void setNoticeTarget(String noticeTarget) {
        this.noticeTarget = noticeTarget == null ? null : noticeTarget.trim();
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    public String getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(String noticeStatus) {
        this.noticeStatus = noticeStatus == null ? null : noticeStatus.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}