package com.zte.ucs.tvcall.ocx.publicaccount;

/* loaded from: classes2.dex */
public class FirePaSessGetPubLstRecmdInfo {
    private String dwSessId;
    private PaInfo[] paInfosArry;
    private int panum;
    private int reason;
    private int result;
    private String userId;

    public String getDwSessId() {
        return this.dwSessId;
    }

    public PaInfo[] getPaInfosArry() {
        return this.paInfosArry;
    }

    public int getPanum() {
        return this.panum;
    }

    public int getReason() {
        return this.reason;
    }

    public int getResult() {
        return this.result;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setDwSessId(String str) {
        this.dwSessId = str;
    }

    public void setPaInfosArry(PaInfo[] paInfoArr) {
        if (paInfoArr != null) {
            this.paInfosArry = (PaInfo[]) paInfoArr.clone();
        }
    }

    public void setPanum(int i) {
        this.panum = i;
    }

    public void setReason(int i) {
        this.reason = i;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
