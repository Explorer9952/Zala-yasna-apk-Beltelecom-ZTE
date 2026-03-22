package com.zte.ucs.tvcall.ocx.message;

/* loaded from: classes2.dex */
public class SingleRecvTypingInfo {
    public int refresh;
    public String sendTime;
    public String senderUri;
    public int state;

    public int getRefresh() {
        return this.refresh;
    }

    public String getSendTime() {
        return this.sendTime;
    }

    public String getSenderUri() {
        return this.senderUri;
    }

    public int getState() {
        return this.state;
    }

    public void setRefresh(int i) {
        this.refresh = i;
    }

    public void setSendTime(String str) {
        this.sendTime = str;
    }

    public void setSenderUri(String str) {
        this.senderUri = str;
    }

    public void setState(int i) {
        this.state = i;
    }
}
