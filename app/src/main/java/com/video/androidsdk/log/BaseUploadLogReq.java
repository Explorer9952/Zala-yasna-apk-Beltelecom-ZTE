package com.video.androidsdk.log;

/* loaded from: classes.dex */
public class BaseUploadLogReq {
    private String terminalType = "";
    private String appName = "";
    private String appVersion = "";
    private String userName = "";
    private String createTime = "";
    private String fileName = "";

    public String getAppName() {
        return this.appName;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getTerminalType() {
        return this.terminalType;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setTerminalType(String str) {
        this.terminalType = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }
}
