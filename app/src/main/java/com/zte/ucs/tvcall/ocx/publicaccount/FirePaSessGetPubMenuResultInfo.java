package com.zte.ucs.tvcall.ocx.publicaccount;

/* loaded from: classes2.dex */
public class FirePaSessGetPubMenuResultInfo {
    private String dwSessId;
    private int menuNum;
    private PaMainMenuInfo[] paMainMenuInfoArry;
    private String paUuid;
    private int reasonCode;
    private String result;
    private String userId;

    public String getDwSessId() {
        return this.dwSessId;
    }

    public int getMenuNum() {
        return this.menuNum;
    }

    public PaMainMenuInfo[] getPaMainMenuInfoArry() {
        return this.paMainMenuInfoArry;
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

    public void setMenuNum(int i) {
        this.menuNum = i;
    }

    public void setPaMainMenuInfoArry(PaMainMenuInfo[] paMainMenuInfoArr) {
        if (paMainMenuInfoArr != null) {
            this.paMainMenuInfoArry = (PaMainMenuInfo[]) paMainMenuInfoArr.clone();
        }
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
