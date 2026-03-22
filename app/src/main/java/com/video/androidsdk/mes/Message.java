package com.video.androidsdk.mes;

/* loaded from: classes.dex */
public class Message {
    String msgid;
    String msginfo;
    String timestamp;

    public Message(String str, String str2, String str3) {
        this.timestamp = str;
        this.msgid = str2;
        this.msginfo = str3;
    }

    public String getMsgid() {
        return this.msgid;
    }

    public String getMsginfo() {
        return this.msginfo;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setMsgid(String str) {
        this.msgid = str;
    }

    public void setMsginfo(String str) {
        this.msginfo = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }
}
