package com.video.androidsdk.service.bean;

/* loaded from: classes.dex */
public class BindSTBReq {
    private static final String BIND = "1";
    private static final String UNBIND = "0";
    public String actiontype;
    public String checkword;
    public String iptvuserid;
    public String platformid;

    public BindSTBReq(String str, String str2) {
        this.iptvuserid = str;
        this.actiontype = str2;
    }

    public String getActiontype() {
        return this.actiontype;
    }

    public String getCheckword() {
        return this.checkword;
    }

    public String getIptvuserid() {
        return this.iptvuserid;
    }

    public String getPlatformid() {
        return this.platformid;
    }

    public void setActiontype(String str) {
        this.actiontype = str;
    }

    public void setCheckword(String str) {
        this.checkword = str;
    }

    public void setIptvuserid(String str) {
        this.iptvuserid = str;
    }

    public void setPlatformid(String str) {
        this.platformid = str;
    }
}
