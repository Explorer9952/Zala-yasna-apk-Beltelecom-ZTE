package com.zte.ucs.tvcall.ocx.nab;

/* loaded from: classes2.dex */
public class UserPrefsInfo {
    public String accountid = "";
    public String etag = "";
    private String userpassword;

    public String getAccountid() {
        return this.accountid;
    }

    public String getEtag() {
        return this.etag;
    }

    public String getUserpassword() {
        return this.userpassword;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public void setUserpassword(String str) {
        this.userpassword = str;
    }
}
