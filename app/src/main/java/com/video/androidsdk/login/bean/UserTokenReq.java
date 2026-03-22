package com.video.androidsdk.login.bean;

/* loaded from: classes.dex */
public class UserTokenReq extends BaseReq {
    private String UserID = "";
    private String Authenticator = "";
    private String AuthStr = "";
    private String EmgInfo = "";
    private String TerminalFlag = "";
    private String TerminalOsType = "";
    private String domain = "";
    private String devicetype = "";
    private String devicesysver = "";
    private String loginaccount = "";

    public String getAuthStr() {
        return this.AuthStr;
    }

    public String getAuthenticator() {
        return this.Authenticator;
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

    public String getLoginaccount() {
        return this.loginaccount;
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

    public void setAuthString(String str) {
        this.AuthStr = str;
    }

    public void setAuthenticator(String str) {
        this.Authenticator = str;
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

    public void setLoginaccount(String str) {
        this.loginaccount = str;
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
}
