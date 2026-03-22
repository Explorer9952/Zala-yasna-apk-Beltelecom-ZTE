package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstUpLoadUserCallingSettingReq {
    private String accountid = "";
    private String sessionID = "";
    private NabstCallingSettingInfo tUserCallingSettingInfo = new NabstCallingSettingInfo();

    public String getAccountid() {
        return this.accountid;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public NabstCallingSettingInfo gettUserCallingSettingInfo() {
        return this.tUserCallingSettingInfo;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void settUserCallingSettingInfo(NabstCallingSettingInfo nabstCallingSettingInfo) {
        this.tUserCallingSettingInfo = nabstCallingSettingInfo;
    }
}
