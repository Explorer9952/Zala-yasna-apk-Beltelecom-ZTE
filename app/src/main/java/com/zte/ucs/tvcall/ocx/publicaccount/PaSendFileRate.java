package com.zte.ucs.tvcall.ocx.publicaccount;

/* loaded from: classes2.dex */
public class PaSendFileRate {
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

    public void setTranRate(int i) {
        this.tranRate = i;
    }
}
