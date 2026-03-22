package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstUpLoadContactOrgNameReq {
    private String accountid = "";
    private String sessionID = "";
    private String contactid = "";
    private String orgname = "";

    public String getAccountid() {
        return this.accountid;
    }

    public String getContactid() {
        return this.contactid;
    }

    public String getOrgname() {
        return this.orgname;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setContactid(String str) {
        this.contactid = str;
    }

    public void setOrgname(String str) {
        this.orgname = str;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }
}
