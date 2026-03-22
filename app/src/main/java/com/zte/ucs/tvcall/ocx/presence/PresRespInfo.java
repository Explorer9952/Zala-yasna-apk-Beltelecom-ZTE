package com.zte.ucs.tvcall.ocx.presence;

import com.zte.ucs.tvcall.ocx.ResultInfo;

/* loaded from: classes2.dex */
public class PresRespInfo {
    private PresUniversalResp presUniversalResp;
    private ResultInfo resultInfo;
    private String sessionID = "";

    public PresUniversalResp getPresUniversalResp() {
        return this.presUniversalResp;
    }

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public void setPresUniversalResp(PresUniversalResp presUniversalResp) {
        this.presUniversalResp = presUniversalResp;
    }

    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }
}
