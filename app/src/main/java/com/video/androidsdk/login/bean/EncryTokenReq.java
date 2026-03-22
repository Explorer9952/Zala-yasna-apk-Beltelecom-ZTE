package com.video.androidsdk.login.bean;

/* loaded from: classes.dex */
public class EncryTokenReq extends BaseReq {
    private String UserID = "";
    private String Action = "";
    private String TerminalFlag = "";
    private String TerminalOsType = "";
    private String domain = "";
    private String accountcode = "";
    private String accounttype = "";
    private int LoginType = 0;

    public String getAccountcode() {
        return this.accountcode;
    }

    public String getAccounttype() {
        return this.accounttype;
    }

    public String getAction() {
        return this.Action;
    }

    public String getDomain() {
        return this.domain;
    }

    public int getLoginType() {
        return this.LoginType;
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

    public void setAccountcode(String str) {
        this.accountcode = str;
    }

    public void setAccounttype(String str) {
        this.accounttype = str;
    }

    public void setAction(String str) {
        this.Action = str;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setLoginType(int i) {
        this.LoginType = i;
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
