package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstUpLoadUserMsgNotifySettingReq {
    private String accountid = "";
    private String sessionID = "";
    private byte archive = 0;

    public String getAccountid() {
        return this.accountid;
    }

    public byte getArchive() {
        return this.archive;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setArchive(byte b2) {
        this.archive = b2;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }
}
