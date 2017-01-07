package com.dcits.jb.manager.single.model;

public class BhAuthNoticeTemplate {
    private String noticeTempCode;

    private String noticeTempContent;

    public String getNoticeTempCode() {
        return noticeTempCode;
    }

    public void setNoticeTempCode(String noticeTempCode) {
        this.noticeTempCode = noticeTempCode == null ? null : noticeTempCode.trim();
    }

    public String getNoticeTempContent() {
        return noticeTempContent;
    }

    public void setNoticeTempContent(String noticeTempContent) {
        this.noticeTempContent = noticeTempContent == null ? null : noticeTempContent.trim();
    }
}