package com.zte.ucs.tvcall.ocx.nabst;

import com.zte.ucs.tvcall.ocx.ResultInfo;

/* loaded from: classes2.dex */
public class NabstSingMsgDndListOperationResp {
    private String sessionID = "";
    private String accountid = "";
    private byte operationType = 0;
    private ResultInfo tResultInfo = new ResultInfo();

    public String getAccountid() {
        return this.accountid;
    }

    public byte getOperationType() {
        return this.operationType;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public ResultInfo gettResultInfo() {
        return this.tResultInfo;
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

    public void settResultInfo(ResultInfo resultInfo) {
        this.tResultInfo = resultInfo;
    }
}
