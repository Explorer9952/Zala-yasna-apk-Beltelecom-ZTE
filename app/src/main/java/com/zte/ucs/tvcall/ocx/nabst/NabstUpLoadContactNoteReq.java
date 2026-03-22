package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstUpLoadContactNoteReq {
    private String accountid = "";
    private String sessionID = "";
    private String contactid = "";
    private String note = "";

    public String getAccountid() {
        return this.accountid;
    }

    public String getContactid() {
        return this.contactid;
    }

    public String getNote() {
        return this.note;
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

    public void setNote(String str) {
        this.note = str;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }
}
