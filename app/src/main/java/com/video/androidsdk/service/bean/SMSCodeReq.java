package com.video.androidsdk.service.bean;

/* loaded from: classes.dex */
public class SMSCodeReq {
    public String authinfo;
    public String ottuserid;
    public String password;
    public String terminalFlag;

    public SMSCodeReq(String str, String str2) {
        this.ottuserid = str;
        this.terminalFlag = str2;
    }

    public String getAuthinfo() {
        return this.authinfo;
    }

    public String getOttuserid() {
        return this.ottuserid;
    }

    public String getPassword() {
        return this.password;
    }

    public String getTerminalFlag() {
        return this.terminalFlag;
    }

    public void setAuthinfo(String str) {
        this.authinfo = str;
    }

    public void setOttuserid(String str) {
        this.ottuserid = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setTerminalFlag(String str) {
        this.terminalFlag = str;
    }
}
