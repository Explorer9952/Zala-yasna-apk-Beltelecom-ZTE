package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstUpLoadUserMsgPlayModSettingReq {
    private String accountid = "";
    private String sessionID = "";
    private byte teleReceiver = 0;

    public String getAccountid() {
        return this.accountid;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public byte getTeleReceiver() {
        return this.teleReceiver;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void setTeleReceiver(byte b2) {
        this.teleReceiver = b2;
    }
}
