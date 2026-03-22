package com.zte.ucs.tvcall.ocx.nabst;

import com.zte.ucs.tvcall.ocx.ResultInfo;

/* loaded from: classes2.dex */
public class NabstGroupMsgDndListOperationResp {
    private byte changedType;
    private byte operationType;
    private String sessionID = "";
    private String accountid = "";
    private NabstContactInfo tContactInfo = new NabstContactInfo();
    private ResultInfo tResultInfo = new ResultInfo();

    public String getAccountid() {
        return this.accountid;
    }

    public byte getChangedType() {
        return this.changedType;
    }

    public byte getOperationType() {
        return this.operationType;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public NabstContactInfo gettContactInfo() {
        return this.tContactInfo;
    }

    public ResultInfo gettResultInfo() {
        return this.tResultInfo;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setChangedType(byte b2) {
        this.changedType = b2;
    }

    public void setOperationType(byte b2) {
        this.operationType = b2;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void settContactInfo(NabstContactInfo nabstContactInfo) {
        this.tContactInfo = nabstContactInfo;
    }

    public void settResultInfo(ResultInfo resultInfo) {
        this.tResultInfo = resultInfo;
    }
}
