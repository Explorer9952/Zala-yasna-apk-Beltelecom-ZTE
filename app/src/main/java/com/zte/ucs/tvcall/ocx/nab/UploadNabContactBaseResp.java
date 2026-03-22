package com.zte.ucs.tvcall.ocx.nab;

/* loaded from: classes2.dex */
public class UploadNabContactBaseResp {
    private String accountid;
    private String etag;
    private int opertype;
    private int result;
    private String sessionid;

    public String getAccountid() {
        return this.accountid;
    }

    public String getEtag() {
        return this.etag;
    }

    public int getOpertype() {
        return this.opertype;
    }

    public int getResult() {
        return this.result;
    }

    public String getSessionid() {
        return this.sessionid;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public void setOpertype(int i) {
        this.opertype = i;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public void setSessionid(String str) {
        this.sessionid = str;
    }
}
