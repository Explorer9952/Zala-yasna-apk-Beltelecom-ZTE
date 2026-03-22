package com.video.androidsdk.mes;

/* loaded from: classes.dex */
public class Summary {
    String msgid;
    String msgurl;
    String summary;
    String timestamp;

    public Summary(String str, String str2, String str3, String str4) {
        this.timestamp = str;
        this.msgid = str2;
        this.msgurl = str3;
        this.summary = str4;
    }

    public String getMsgid() {
        return this.msgid;
    }

    public String getMsgurl() {
        return this.msgurl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setMsgid(String str) {
        this.msgid = str;
    }

    public void setMsgurl(String str) {
        this.msgurl = str;
    }

    public void setSummary(String str) {
        this.summary = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }
}
