package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstGetDirectoryReq {
    private byte actionMode;
    public String accountid = "";
    private String sessionID = "";

    public String getAccountid() {
        return this.accountid;
    }

    public byte getActionMode() {
        return this.actionMode;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setActionMode(byte b2) {
        this.actionMode = b2;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }
}
