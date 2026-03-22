package com.video.androidsdk.login.bean;

/* loaded from: classes.dex */
public class LoginCheckReq extends BaseReq {
    private String UserID = "";
    private String Password = "";
    private String RealUserID = "";
    private String Devmac = "";
    private String DeviceID = "";
    private String TerminalFlag = "";
    private String TerminalOsType = "";
    private String mStr3DESKey = "";
    private String domain = "";

    public String get3DESKey() {
        return this.mStr3DESKey;
    }

    public String getDeviceID() {
        return this.DeviceID;
    }

    public String getDevmac() {
        return this.Devmac;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getPassword() {
        return this.Password;
    }

    public String getRealUserID() {
        return this.RealUserID;
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

    public void set3DESKey(String str) {
        this.mStr3DESKey = str;
    }

    public void setDeviceID(String str) {
        this.DeviceID = str;
    }

    public void setDevmac(String str) {
        this.Devmac = str;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setPassword(String str) {
        this.Password = str;
    }

    public void setRealUserID(String str) {
        this.RealUserID = str;
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
