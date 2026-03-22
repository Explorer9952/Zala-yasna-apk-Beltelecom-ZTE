package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstUpLoadContactGroupInfoReq {
    private String accountid = "";
    private String sessionID = "";
    private String contactid = "";
    private NabstGroupList tGroup = new NabstGroupList();

    public String getAccountid() {
        return this.accountid;
    }

    public String getContactid() {
        return this.contactid;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public NabstGroupList gettGroup() {
        return this.tGroup;
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

    public void settGroup(NabstGroupList nabstGroupList) {
        this.tGroup = nabstGroupList;
    }
}
