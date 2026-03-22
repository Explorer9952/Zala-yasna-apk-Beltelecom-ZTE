package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstLoadContactReq {
    private byte changedType;
    private byte isInnerOper;
    private String accountid = "";
    private String sessionID = "";
    private String contactid = "";

    public String getAccountid() {
        return this.accountid;
    }

    public byte getChangedType() {
        return this.changedType;
    }

    public String getContactid() {
        return this.contactid;
    }

    public byte getIsInnerOper() {
        return this.isInnerOper;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setChangedType(byte b2) {
        this.changedType = b2;
    }

    public void setContactid(String str) {
        this.contactid = str;
    }

    public void setIsInnerOper(byte b2) {
        this.isInnerOper = b2;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }
}
