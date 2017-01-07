package com.dcits.jb.manager.single.model;

import java.util.Date;

public class BhSysFeedbackInfo {
    private String feedbackId;

    private String userId;

    private String userName;

    private String servUserId;

    private String servUserName;

    private String feedbackUserContent;

    private String feedbackServContent;

    private Date createTime;

    private Date feedbackTime;

    private String feedbackStatus;

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId == null ? null : feedbackId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getServUserId() {
        return servUserId;
    }

    public void setServUserId(String servUserId) {
        this.servUserId = servUserId == null ? null : servUserId.trim();
    }

    public String getServUserName() {
        return servUserName;
    }

    public void setServUserName(String servUserName) {
        this.servUserName = servUserName == null ? null : servUserName.trim();
    }

    public String getFeedbackUserContent() {
        return feedbackUserContent;
    }

    public void setFeedbackUserContent(String feedbackUserContent) {
        this.feedbackUserContent = feedbackUserContent == null ? null : feedbackUserContent.trim();
    }

    public String getFeedbackServContent() {
        return feedbackServContent;
    }

    public void setFeedbackServContent(String feedbackServContent) {
        this.feedbackServContent = feedbackServContent == null ? null : feedbackServContent.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public String getFeedbackStatus() {
        return feedbackStatus;
    }

    public void setFeedbackStatus(String feedbackStatus) {
        this.feedbackStatus = feedbackStatus == null ? null : feedbackStatus.trim();
    }
}