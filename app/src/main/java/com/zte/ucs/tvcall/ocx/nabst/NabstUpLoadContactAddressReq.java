package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstUpLoadContactAddressReq {
    private String accountid = "";
    private String sessionID = "";
    private String contactid = "";
    private NabstPersonAddressList tAddress = new NabstPersonAddressList();

    public String getAccountid() {
        return this.accountid;
    }

    public String getContactid() {
        return this.contactid;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public NabstPersonAddressList gettAddress() {
        return this.tAddress;
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

    public void settAddress(NabstPersonAddressList nabstPersonAddressList) {
        this.tAddress = nabstPersonAddressList;
    }
}
