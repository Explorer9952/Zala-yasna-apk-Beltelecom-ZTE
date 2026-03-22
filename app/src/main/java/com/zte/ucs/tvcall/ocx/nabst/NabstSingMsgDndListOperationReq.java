package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstSingMsgDndListOperationReq {
    private String sessionID = "";
    private String accountid = "";
    private byte operationType = 0;
    private NabstSingMsgDndSettingInfo tUserSingMsgDndSettingInfo = new NabstSingMsgDndSettingInfo();

    public String getAccountid() {
        return this.accountid;
    }

    public byte getOperationType() {
        return this.operationType;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public NabstSingMsgDndSettingInfo getSinleMsgDndSettingInfo() {
        return this.tUserSingMsgDndSettingInfo;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setOperationType(byte b2) {
        this.operationType = b2;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void setSinleMsgDndSettingInfo(NabstSingMsgDndSettingInfo nabstSingMsgDndSettingInfo) {
        this.tUserSingMsgDndSettingInfo = nabstSingMsgDndSettingInfo;
    }
}
