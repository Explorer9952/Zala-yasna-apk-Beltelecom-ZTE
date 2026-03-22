package com.zte.ucs.tvcall.ocx.message;

/* loaded from: classes2.dex */
public class GrpSendLargeMsgRateInfo {
    private String sessionId = "";
    private String filetranId = "";
    private int tranRate = 0;
    private int finishSize = 0;
    private String messageId = "";

    public String getFiletranId() {
        return this.filetranId;
    }

    public int getFinishSize() {
        return this.finishSize;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public int getTranRate() {
        return this.tranRate;
    }

    public void setFiletranId(String str) {
        this.filetranId = str;
    }

    public void setFinishSize(int i) {
        this.finishSize = i;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setTranRate(int i) {
        this.tranRate = i;
    }
}
