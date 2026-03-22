package com.zte.ucs.tvcall.ocx.presence;

/* loaded from: classes2.dex */
public class PresRespContactInfo {
    private String accountid;
    private PresContactNode[] presContactNodes;
    private String sessionID = "";

    public String getAccountid() {
        return this.accountid;
    }

    public PresContactNode[] getPresContactNodes() {
        return this.presContactNodes;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setPresContactNodes(PresContactNode[] presContactNodeArr) {
        if (presContactNodeArr != null) {
            this.presContactNodes = (PresContactNode[]) presContactNodeArr.clone();
        }
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }
}
