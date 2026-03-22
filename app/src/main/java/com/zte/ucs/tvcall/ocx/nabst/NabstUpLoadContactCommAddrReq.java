package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstUpLoadContactCommAddrReq {
    private String accountid = "";
    private String sessionID = "";
    private String contactid = "";
    private NabstCommAddrInfo tCommAddr = new NabstCommAddrInfo();

    public String getAccountid() {
        return this.accountid;
    }

    public String getContactid() {
        return this.contactid;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public NabstCommAddrInfo gettCommAddr() {
        return this.tCommAddr;
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

    public void settCommAddr(NabstCommAddrInfo nabstCommAddrInfo) {
        this.tCommAddr = nabstCommAddrInfo;
    }
}
