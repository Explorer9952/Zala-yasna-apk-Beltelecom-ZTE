package com.zte.ucs.tvcall.ocx.presence;

/* loaded from: classes2.dex */
public class PresUploadFreeTextReq {
    private int actionMode;
    private String sessionID = "";
    private String accountid = "";
    private String password = "";
    private String freeText = "";

    public String getAccountid() {
        return this.accountid;
    }

    public int getActionMode() {
        return this.actionMode;
    }

    public String getFreeText() {
        return this.freeText;
    }

    public String getPassword() {
        return this.password;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setActionMode(int i) {
        this.actionMode = i;
    }

    public void setFreeText(String str) {
        this.freeText = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }
}
