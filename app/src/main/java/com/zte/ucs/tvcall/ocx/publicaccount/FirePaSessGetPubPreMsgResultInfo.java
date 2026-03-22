package com.zte.ucs.tvcall.ocx.publicaccount;

/* loaded from: classes2.dex */
public class FirePaSessGetPubPreMsgResultInfo {
    private int msgnum;
    private PaMsgContent[] paMsgContentArry;
    private String pauuid;
    private String result;
    private String sessionid;

    public int getMsgnum() {
        return this.msgnum;
    }

    public PaMsgContent[] getPaMsgContentArry() {
        return this.paMsgContentArry;
    }

    public String getPauuid() {
        return this.pauuid;
    }

    public String getResult() {
        return this.result;
    }

    public String getSessionid() {
        return this.sessionid;
    }

    public void setMsgnum(int i) {
        this.msgnum = i;
    }

    public void setPaMsgContentArry(PaMsgContent[] paMsgContentArr) {
        if (paMsgContentArr != null) {
            this.paMsgContentArry = (PaMsgContent[]) paMsgContentArr.clone();
        }
    }

    public void setPauuid(String str) {
        this.pauuid = str;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public void setSessionid(String str) {
        this.sessionid = str;
    }
}
