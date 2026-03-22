package com.zte.ucs.tvcall.ocx.nab;

/* loaded from: classes2.dex */
public class ContactAddressResp {
    public String localAddr = "";
    public String friendAddr = "";
    public String eTag = "";

    public String getFriendAddr() {
        return this.friendAddr;
    }

    public String getLocalAddr() {
        return this.localAddr;
    }

    public String geteTag() {
        return this.eTag;
    }

    public void setFriendAddr(String str) {
        this.friendAddr = str;
    }

    public void setLocalAddr(String str) {
        this.localAddr = str;
    }

    public void seteTag(String str) {
        this.eTag = str;
    }
}
