package com.zte.ucs.tvcall.ocx.publicaccount;

/* loaded from: classes2.dex */
public class FirePaSessSetAcptStatResultInfo {
    private String dwSessId;
    private String paUuid;
    private int reasonCode;
    private String result;
    private String userId;

    public String getDwSessId() {
        return this.dwSessId;
    }

    public String getPaUuid() {
        return this.paUuid;
    }

    public int getReasonCode() {
        return this.reasonCode;
    }

    public String getResult() {
        return this.result;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setDwSessId(String str) {
        this.dwSessId = str;
    }

    public void setPaUuid(String str) {
        this.paUuid = str;
    }

    public void setReasonCode(int i) {
        this.reasonCode = i;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
