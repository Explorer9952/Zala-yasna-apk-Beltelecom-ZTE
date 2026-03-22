package com.video.androidsdk.login.bean;

/* loaded from: classes.dex */
public class LoadBalanceReq extends BaseReq {
    private String UserID = "";
    private String UserIP = "";
    private String AccountType = "";
    private String TerminalFlag = "";
    private String TerminalOsType = "";
    private String domain = "";

    public String getAccountType() {
        return this.AccountType;
    }

    public String getDomain() {
        return this.domain;
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

    public String getUserIP() {
        return this.UserIP;
    }

    public void setAccountType(String str) {
        this.AccountType = str;
    }

    public void setDomain(String str) {
        this.domain = str;
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

    public void setUserIP(String str) {
        this.UserIP = str;
    }
}
