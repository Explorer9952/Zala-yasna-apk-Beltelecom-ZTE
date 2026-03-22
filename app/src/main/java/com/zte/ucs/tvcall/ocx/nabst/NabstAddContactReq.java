package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstAddContactReq {
    private String accountid = "";
    private String sessionID = "";
    private NabstContactInfo tContactInfo;

    public String getAccountid() {
        return this.accountid;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public NabstContactInfo gettContactInfo() {
        return this.tContactInfo;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void settContactInfo(NabstContactInfo nabstContactInfo) {
        this.tContactInfo = nabstContactInfo;
    }
}
