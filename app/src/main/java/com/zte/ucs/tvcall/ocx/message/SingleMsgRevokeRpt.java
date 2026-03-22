package com.zte.ucs.tvcall.ocx.message;

/* loaded from: classes2.dex */
public class SingleMsgRevokeRpt {
    private String messageId = "";
    private String oldMessageId = "";
    private String sendUri = "";

    public String getMessageId() {
        return this.messageId;
    }

    public String getOldMessageId() {
        return this.oldMessageId;
    }

    public String getSendUri() {
        return this.sendUri;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setOldMessageId(String str) {
        this.oldMessageId = str;
    }

    public void setSendUri(String str) {
        this.sendUri = str;
    }
}
