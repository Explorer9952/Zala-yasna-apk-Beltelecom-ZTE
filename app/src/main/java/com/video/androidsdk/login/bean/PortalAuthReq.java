package com.video.androidsdk.login.bean;

/* loaded from: classes.dex */
public class PortalAuthReq extends BaseReq {
    private String UserID = "";
    private String UserToken = "";
    private String STBID = "";
    private String TerminalFlag = "";
    private String TerminalOsType = "";
    private String domain = "";
    private String devicetype = "";
    private String devicesysver = "";
    private String AuthStr = "";
    private String EmgInfo = "";

    public String getAuthStr() {
        return this.AuthStr;
    }

    public String getDevicesysver() {
        return this.devicesysver;
    }

    public String getDevicetype() {
        return this.devicetype;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getEmgInfo() {
        return this.EmgInfo;
    }

    public String getSTBID() {
        return this.STBID;
    }

    public String getTerminalFlag() {
        return this.TerminalFlag;
    }

    public String getTerminalOsType() {
        return this.TerminalOsType;
    }

    public String getUserID() {
        return this.UserID;
    }

    public String getUserToken() {
        return this.UserToken;
    }

    public void setAuthStr(String str) {
        this.AuthStr = str;
    }

    public void setDevicesysver(String str) {
        this.devicesysver = str;
    }

    public void setDevicetype(String str) {
        this.devicetype = str;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setEmgInfo(String str) {
        this.EmgInfo = str;
    }

    public void setSTBID(String str) {
        this.STBID = str;
    }

    public void setTerminalFlag(String str) {
        this.TerminalFlag = str;
    }

    public void setTerminalOsType(String str) {
        this.TerminalOsType = str;
    }

    public void setUserID(String str) {
        this.UserID = str;
    }

    public void setUserToken(String str) {
        this.UserToken = str;
    }
}
