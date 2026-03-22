package com.zte.ucs.tvcall.ocx.nab;

/* loaded from: classes2.dex */
public class ProfileResp {
    public String eContactBaseTag;
    public String strAddr = "";
    public String eTag = "";

    public String getStrAddr() {
        return this.strAddr;
    }

    public String geteContactBaseTag() {
        return this.eContactBaseTag;
    }

    public String geteTag() {
        return this.eTag;
    }

    public void setStrAddr(String str) {
        this.strAddr = str;
    }

    public void seteContactBaseTag(String str) {
        this.eContactBaseTag = str;
    }

    public void seteTag(String str) {
        this.eTag = str;
    }
}
