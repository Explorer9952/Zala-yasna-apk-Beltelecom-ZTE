package com.zte.ucs.tvcall.ocx.telephone;

import com.zte.ucs.tvcall.ocx.ResultInfo;

/* loaded from: classes2.dex */
public class CallTransferRspInfo {
    private int iTransferType;
    private ResultInfo resultInfo;
    private String szSessionId = "";
    private String szPeerNumber = "";
    private String szTransferDstNumber = "";

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public String getSzPeerNumber() {
        return this.szPeerNumber;
    }

    public String getSzSessionId() {
        return this.szSessionId;
    }

    public String getSzTransferDstNumber() {
        return this.szTransferDstNumber;
    }

    public int getiTransferType() {
        return this.iTransferType;
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

    public void setSzTransferDstNumber(String str) {
        this.szTransferDstNumber = str;
    }

    public void setiTransferType(int i) {
        this.iTransferType = i;
    }
}
