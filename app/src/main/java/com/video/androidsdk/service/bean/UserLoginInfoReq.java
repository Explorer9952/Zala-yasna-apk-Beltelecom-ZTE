package com.video.androidsdk.service.bean;

/* loaded from: classes.dex */
public class UserLoginInfoReq {
    public String identifycode;
    public String ottuserid;
    public String terminalFlag;

    public UserLoginInfoReq(String str, String str2, String str3) {
        this.ottuserid = str;
        this.terminalFlag = str2;
        this.identifycode = str3;
    }

    public String getIdentifycode() {
        return this.identifycode;
    }

    public String getOttuserid() {
        return this.ottuserid;
    }

    public String getTerminalFlag() {
        return this.terminalFlag;
    }

    public void setIdentifycode(String str) {
        this.identifycode = str;
    }

    public void setOttuserid(String str) {
        this.ottuserid = str;
    }

    public void setTerminalFlag(String str) {
        this.terminalFlag = str;
    }
}
