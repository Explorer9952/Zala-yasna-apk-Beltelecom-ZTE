package com.zte.ucs.tvcall.ocx.nabst;

import com.zte.ucs.tvcall.ocx.ResultInfo;

/* loaded from: classes2.dex */
public class NabstLoadUserPrefResp {
    private byte changedType;
    private byte isInnerOper;
    private String sessionID = "";
    private String accountid = "";
    private ResultInfo tResultInfo = new ResultInfo();
    private NabstPersonalUserSettingInfo tUserSettingInfo = new NabstPersonalUserSettingInfo();

    public String getAccountid() {
        return this.accountid;
    }

    public byte getChangedType() {
        return this.changedType;
    }

    public byte getIsInnerOper() {
        return this.isInnerOper;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public ResultInfo gettResultInfo() {
        return this.tResultInfo;
    }

    public NabstPersonalUserSettingInfo gettUserSettingInfo() {
        return this.tUserSettingInfo;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setChangedType(byte b2) {
        this.changedType = b2;
    }

    public void setIsInnerOper(byte b2) {
        this.isInnerOper = b2;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void settResultInfo(ResultInfo resultInfo) {
        this.tResultInfo = resultInfo;
    }

    public void settUserSettingInfo(NabstPersonalUserSettingInfo nabstPersonalUserSettingInfo) {
        this.tUserSettingInfo = nabstPersonalUserSettingInfo;
    }
}
