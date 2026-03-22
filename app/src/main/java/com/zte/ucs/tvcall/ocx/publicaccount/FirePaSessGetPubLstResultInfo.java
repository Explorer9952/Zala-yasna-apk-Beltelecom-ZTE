package com.zte.ucs.tvcall.ocx.publicaccount;

/* loaded from: classes2.dex */
public class FirePaSessGetPubLstResultInfo {
    public String dwSessId;
    public PaInfo[] paInfosArry;
    public int panum;
    public String userId;

    public String getDwSessId() {
        return this.dwSessId;
    }

    public PaInfo[] getPaInfosArry() {
        return this.paInfosArry;
    }

    public int getPanum() {
        return this.panum;
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

    public void setUserId(String str) {
        this.userId = str;
    }
}
