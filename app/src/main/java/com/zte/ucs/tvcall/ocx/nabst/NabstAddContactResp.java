package com.zte.ucs.tvcall.ocx.nabst;

import com.zte.ucs.tvcall.ocx.ResultInfo;

/* loaded from: classes2.dex */
public class NabstAddContactResp {
    private String sessionID = "";
    private String accountid = "";
    private String contactid = "";
    private ResultInfo tResultInfo = new ResultInfo();

    public String getAccountid() {
        return this.accountid;
    }

    public String getContactid() {
        return this.contactid;
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

    public void setContactid(String str) {
        this.contactid = str;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void settResultInfo(ResultInfo resultInfo) {
        this.tResultInfo = resultInfo;
    }
}
