package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstAddUserPrefReq {
    private String accountid = "";
    private String sessionID = "";
    private byte isInnerOper = 0;
    private NabstPersonalUserSettingInfo tUserSettingInfo = new NabstPersonalUserSettingInfo();

    public String getAccountid() {
        return this.accountid;
    }

    public byte getIsInnerOper() {
        return this.isInnerOper;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public NabstPersonalUserSettingInfo getUserSettingInfo() {
        return this.tUserSettingInfo;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setIsInnerOper(byte b2) {
        this.isInnerOper = b2;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void setUserSettingInfo(NabstPersonalUserSettingInfo nabstPersonalUserSettingInfo) {
        this.tUserSettingInfo = nabstPersonalUserSettingInfo;
    }
}
