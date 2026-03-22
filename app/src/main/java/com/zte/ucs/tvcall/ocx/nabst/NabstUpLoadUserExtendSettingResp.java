package com.zte.ucs.tvcall.ocx.nabst;

import com.zte.ucs.tvcall.ocx.ResultInfo;

/* loaded from: classes2.dex */
public class NabstUpLoadUserExtendSettingResp {
    private int changedType;
    private int operationType;
    private NabstContactInfo tContactInfo;
    private ResultInfo tResultInfo;
    private String sessionID = "";
    private String accountid = "";

    public String getAccountid() {
        return this.accountid;
    }

    public int getChangedType() {
        return this.changedType;
    }

    public int getOperationType() {
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

    public void setChangedType(int i) {
        this.changedType = i;
    }

    public void setOperationType(int i) {
        this.operationType = i;
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
