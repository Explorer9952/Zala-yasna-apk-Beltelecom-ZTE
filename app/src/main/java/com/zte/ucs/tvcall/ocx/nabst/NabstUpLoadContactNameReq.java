package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstUpLoadContactNameReq {
    private String accountid = "";
    private String sessionID = "";
    private String contactid = "";
    private NabstPersonNameInfo tName = new NabstPersonNameInfo();

    public String getAccountid() {
        return this.accountid;
    }

    public String getContactid() {
        return this.contactid;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public NabstPersonNameInfo gettName() {
        return this.tName;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setContactid(String str) {
        this.contactid = str;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void settName(NabstPersonNameInfo nabstPersonNameInfo) {
        this.tName = nabstPersonNameInfo;
    }
}
