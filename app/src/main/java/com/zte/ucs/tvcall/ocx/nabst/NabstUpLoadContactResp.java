package com.zte.ucs.tvcall.ocx.nabst;

import com.zte.ucs.tvcall.ocx.ResultInfo;

/* loaded from: classes2.dex */
public class NabstUpLoadContactResp {
    private String sessionID = "";
    private String accountid = "";
    private String oldcontactid = "";
    private String newcontactid = "";
    private ResultInfo tResultInfo = new ResultInfo();

    public String getAccountid() {
        return this.accountid;
    }

    public String getNewcontactid() {
        return this.newcontactid;
    }

    public String getOldcontactid() {
        return this.oldcontactid;
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

    public void setNewcontactid(String str) {
        this.newcontactid = str;
    }

    public void setOldcontactid(String str) {
        this.oldcontactid = str;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void settResultInfo(ResultInfo resultInfo) {
        this.tResultInfo = resultInfo;
    }
}
