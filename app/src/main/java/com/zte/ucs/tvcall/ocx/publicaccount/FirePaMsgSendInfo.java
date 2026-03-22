package com.zte.ucs.tvcall.ocx.publicaccount;

/* loaded from: classes2.dex */
public class FirePaMsgSendInfo {
    private int length;
    private String paUuid = "";
    private String receiverUri = "";
    private String messageId = "";
    private String text = "";

    public int getLength() {
        return this.length;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getPaUuid() {
        return this.paUuid;
    }

    public String getReceiverUri() {
        return this.receiverUri;
    }

    public String getText() {
        return this.text;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setPaUuid(String str) {
        this.paUuid = str;
    }

    public void setReceiverUri(String str) {
        this.receiverUri = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
