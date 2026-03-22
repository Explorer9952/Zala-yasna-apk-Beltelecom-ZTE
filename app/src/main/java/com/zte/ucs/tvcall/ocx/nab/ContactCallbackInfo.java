package com.zte.ucs.tvcall.ocx.nab;

/* loaded from: classes2.dex */
public class ContactCallbackInfo {
    private ContactAddressInfo contactAddressInfo;
    private String sessionID = "";
    private int lResult = 0;
    private int opertype = 0;

    public ContactAddressInfo getContactAddressInfo() {
        return this.contactAddressInfo;
    }

    public int getOpertype() {
        return this.opertype;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public int getlResult() {
        return this.lResult;
    }

    public void setContactAddressInfo(ContactAddressInfo contactAddressInfo) {
        this.contactAddressInfo = contactAddressInfo;
    }

    public void setOpertype(int i) {
        this.opertype = i;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void setlResult(int i) {
        this.lResult = i;
    }
}
