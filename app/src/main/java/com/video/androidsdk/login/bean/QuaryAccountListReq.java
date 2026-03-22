package com.video.androidsdk.login.bean;

/* loaded from: classes.dex */
public class QuaryAccountListReq extends BaseReq {
    private String stbsn = "";
    private String mobileno = "";
    private String loginpwd = "";
    private String logintype = "1";
    private String terminalflag = "";
    private String terminalostype = "";
    private String devicecode = "";
    private String authinfo = "";

    public String getAuthinfo() {
        return this.authinfo;
    }

    public String getDevicecode() {
        return this.devicecode;
    }

    public String getLoginpwd() {
        return this.loginpwd;
    }

    public String getLogintype() {
        return this.logintype;
    }

    public String getMobileno() {
        return this.mobileno;
    }

    public String getStbsn() {
        return this.stbsn;
    }

    public String getTerminalflag() {
        return this.terminalflag;
    }

    public String getTerminalostype() {
        return this.terminalostype;
    }

    public void setAuthinfo(String str) {
        this.authinfo = str;
    }

    public void setDevicecode(String str) {
        this.devicecode = str;
    }

    public void setLoginpwd(String str) {
        this.loginpwd = str;
    }

    public void setLogintype(String str) {
        this.logintype = str;
    }

    public void setMobileno(String str) {
        this.mobileno = str;
    }

    public void setStbsn(String str) {
        this.stbsn = str;
    }

    public void setTerminalflag(String str) {
        this.terminalflag = str;
    }

    public void setTerminalostype(String str) {
        this.terminalostype = str;
    }
}
