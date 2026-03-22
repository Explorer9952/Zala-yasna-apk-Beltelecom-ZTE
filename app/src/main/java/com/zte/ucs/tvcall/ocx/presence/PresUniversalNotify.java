package com.zte.ucs.tvcall.ocx.presence;

/* loaded from: classes2.dex */
public class PresUniversalNotify {
    String accountid = "";
    String contactid = "";
    String state = "";
    String reason = "";
    String eTag = "";

    public String getAccountid() {
        return this.accountid;
    }

    public String getContactid() {
        return this.contactid;
    }

    public String getReason() {
        return this.reason;
    }

    public String getState() {
        return this.state;
    }

    public String geteTag() {
        return this.eTag;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setContactid(String str) {
        this.contactid = str;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void seteTag(String str) {
        this.eTag = str;
    }

    public String toString() {
        return "accountid:" + this.accountid + "  contactid:" + this.contactid + "  state:" + this.state + " reason:" + this.reason;
    }
}
