package com.zte.ucs.tvcall.ocx.telephone;

import com.zte.ucs.tvcall.ocx.ResultInfo;

/* loaded from: classes2.dex */
public class CallThrowScreenRspInfo {
    private int currentCallType;
    private ResultInfo resultInfo;
    private String szSessionId = "";
    private String szPeerNumber = "";
    private String szThrowScreenDstNumber = "";

    public int getCurrentCallType() {
        return this.currentCallType;
    }

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public String getSzPeerNumber() {
        return this.szPeerNumber;
    }

    public String getSzSessionId() {
        return this.szSessionId;
    }

    public String getSzThrowScreenDstNumber() {
        return this.szThrowScreenDstNumber;
    }

    public void setCurrentCallType(int i) {
        this.currentCallType = i;
    }

    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

    public void setSzPeerNumber(String str) {
        this.szPeerNumber = str;
    }

    public void setSzSessionId(String str) {
        this.szSessionId = str;
    }

    public void setSzThrowScreenDstNumber(String str) {
        this.szThrowScreenDstNumber = str;
    }
}
