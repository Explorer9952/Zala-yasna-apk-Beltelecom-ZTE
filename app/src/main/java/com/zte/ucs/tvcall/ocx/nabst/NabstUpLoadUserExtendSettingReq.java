package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstUpLoadUserExtendSettingReq {
    private String accountid = "";
    private String sessionID = "";
    private NabstExtendSettingInfo tUserExtendSettingInfo = new NabstExtendSettingInfo();

    public String getAccountid() {
        return this.accountid;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public NabstExtendSettingInfo gettUserExtendSettingInfo() {
        return this.tUserExtendSettingInfo;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void settUserExtendSettingInfo(NabstExtendSettingInfo nabstExtendSettingInfo) {
        this.tUserExtendSettingInfo = nabstExtendSettingInfo;
    }
}
