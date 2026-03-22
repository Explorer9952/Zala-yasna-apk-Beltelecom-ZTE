package com.zte.ucs.tvcall.ocx.message;

/* loaded from: classes2.dex */
public class SingleSendTypingInfo {
    public String magid;
    public String receiverUri;
    public int refresh;
    public int state;

    public String getMagid() {
        return this.magid;
    }

    public String getReceiverUri() {
        return this.receiverUri;
    }

    public int getRefresh() {
        return this.refresh;
    }

    public int getState() {
        return this.state;
    }

    public void setMagid(String str) {
        this.magid = str;
    }

    public void setReceiverUri(String str) {
        this.receiverUri = str;
    }

    public void setRefresh(int i) {
        this.refresh = i;
    }

    public void setState(int i) {
        this.state = i;
    }
}
