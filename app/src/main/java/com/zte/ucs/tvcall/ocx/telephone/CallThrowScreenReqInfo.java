package com.zte.ucs.tvcall.ocx.telephone;

/* loaded from: classes2.dex */
public class CallThrowScreenReqInfo {
    private int currentCallType;
    private String szPeerNumber;
    private String szThrowScreenDstNumber;

    public int getCurrentCallType() {
        return this.currentCallType;
    }

    public String getSzPeerNumber() {
        return this.szPeerNumber;
    }

    public String getSzThrowScreenDstNumber() {
        return this.szThrowScreenDstNumber;
    }

    public void setCurrentCallType(int i) {
        this.currentCallType = i;
    }

    public void setSzPeerNumber(String str) {
        this.szPeerNumber = str;
    }

    public void setSzThrowScreenDstNumber(String str) {
        this.szThrowScreenDstNumber = str;
    }
}
