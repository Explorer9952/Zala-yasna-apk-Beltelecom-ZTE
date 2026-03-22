package com.zte.ucs.tvcall.ocx.message;

/* loaded from: classes2.dex */
public class GrpMsgRevoke {
    private String messageId = "";
    private String oldMessageId = "";
    private String receiverUri = "";

    public String getMessageId() {
        return this.messageId;
    }

    public String getOldMessageId() {
        return this.oldMessageId;
    }

    public String getReceiverUri() {
        return this.receiverUri;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setOldMessageId(String str) {
        this.oldMessageId = str;
    }

    public void setReceiverUri(String str) {
        this.receiverUri = str;
    }
}
