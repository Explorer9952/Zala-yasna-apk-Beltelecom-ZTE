package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstCompareDirectoryReq {
    private byte actionMode;
    public String accountid = "";
    private String sessionID = "";
    private int localNabEtag = 0;

    public String getAccountid() {
        return this.accountid;
    }

    public byte getActionMode() {
        return this.actionMode;
    }

    public int getLocalNabEtag() {
        return this.localNabEtag;
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

    public void setLocalNabEtag(int i) {
        this.localNabEtag = i;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }
}
