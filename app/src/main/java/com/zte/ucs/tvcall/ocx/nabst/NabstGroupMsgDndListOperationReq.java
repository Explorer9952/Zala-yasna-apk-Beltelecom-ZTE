package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstGroupMsgDndListOperationReq {
    private String sessionID = "";
    private String accountid = "";
    private byte operationType = 0;
    private NabstGroupMsgDndSettingInfo tUserGroupMsgDndSettingInfo = new NabstGroupMsgDndSettingInfo();

    public String getAccountid() {
        return this.accountid;
    }

    public NabstGroupMsgDndSettingInfo getGroupMsgDndSettingInfo() {
        return this.tUserGroupMsgDndSettingInfo;
    }

    public byte getOperationType() {
        return this.operationType;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setGroupMsgDndSettingInfo(NabstGroupMsgDndSettingInfo nabstGroupMsgDndSettingInfo) {
        this.tUserGroupMsgDndSettingInfo = nabstGroupMsgDndSettingInfo;
    }

    public void setOperationType(byte b2) {
        this.operationType = b2;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }
}
