package com.video.androidsdk.login.bean;

/* loaded from: classes.dex */
public class EPGHeartBeatRsp {
    String errormsg;
    String expiretime;
    String newusertoken;
    String returncode;

    public String getErrormsg() {
        return this.errormsg;
    }

    public String getExpiretime() {
        return this.expiretime;
    }

    public String getNewusertoken() {
        return this.newusertoken;
    }

    public String getReturncode() {
        return this.returncode;
    }

    public void setErrormsg(String str) {
        this.errormsg = str;
    }

    public void setExpiretime(String str) {
        this.expiretime = str;
    }

    public void setNewusertoken(String str) {
        this.newusertoken = str;
    }

    public void setReturncode(String str) {
        this.returncode = str;
    }
}
