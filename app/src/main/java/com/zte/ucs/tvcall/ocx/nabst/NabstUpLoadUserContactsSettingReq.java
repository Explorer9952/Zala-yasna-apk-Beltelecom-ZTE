package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstUpLoadUserContactsSettingReq {
    private String accountid = "";
    private String sessionID = "";
    private NabstContactsSettingInfo tUserContactsSettingInfo = new NabstContactsSettingInfo();

    public String getAccountid() {
        return this.accountid;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public NabstContactsSettingInfo gettUserContactsSettingInfo() {
        return this.tUserContactsSettingInfo;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void settUserContactsSettingInfo(NabstContactsSettingInfo nabstContactsSettingInfo) {
        this.tUserContactsSettingInfo = nabstContactsSettingInfo;
    }
}
