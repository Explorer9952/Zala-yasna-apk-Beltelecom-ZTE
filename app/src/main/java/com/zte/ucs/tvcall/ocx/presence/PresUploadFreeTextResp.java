package com.zte.ucs.tvcall.ocx.presence;

import com.zte.ucs.tvcall.ocx.ResultInfo;

/* loaded from: classes2.dex */
public class PresUploadFreeTextResp {
    private int actionMode;
    private ResultInfo resultInfo;
    private String sessionID = "";
    private String accountid = "";

    public String getAccountid() {
        return this.accountid;
    }

    public int getActionMode() {
        return this.actionMode;
    }

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setActionMode(int i) {
        this.actionMode = i;
    }

    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }
}
