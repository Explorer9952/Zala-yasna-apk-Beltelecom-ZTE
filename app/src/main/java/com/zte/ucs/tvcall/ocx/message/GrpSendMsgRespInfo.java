package com.zte.ucs.tvcall.ocx.message;

/* loaded from: classes2.dex */
public class GrpSendMsgRespInfo {
    private int errorCode;
    private String errorReason;
    private String messageId = "";
    private int result;
    private String sessionId;

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorReason() {
        return this.errorReason;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getResult() {
        return this.result;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setErrorReason(String str) {
        this.errorReason = str;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }
}
