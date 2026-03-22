package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstUpLoadUserMsgDndSettingReq {
    private String accountid = "";
    private String sessionID = "";
    private NabstMsgDndSettingInfo tMsgDnd = new NabstMsgDndSettingInfo();

    public String getAccountid() {
        return this.accountid;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public NabstMsgDndSettingInfo gettMsgDnd() {
        return this.tMsgDnd;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void settMsgDnd(NabstMsgDndSettingInfo nabstMsgDndSettingInfo) {
        this.tMsgDnd = nabstMsgDndSettingInfo;
    }
}
