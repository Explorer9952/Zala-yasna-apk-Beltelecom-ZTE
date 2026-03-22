package com.zte.ucs.tvcall.ocx.telephone;

/* loaded from: classes2.dex */
public class CallTransferReqInfo {
    private int iTransferType;
    private String szSessionId = "";
    private String szPeerNumber = "";
    private String szTransferDstNumber = "";

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
