package com.zte.ucs.tvcall.ocx.message;

/* loaded from: classes2.dex */
public class SingleSendMultMsgResp {
    private String sessionId = "";
    private String messageId = "";

    public String getMessageId() {
        return this.messageId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }
}
