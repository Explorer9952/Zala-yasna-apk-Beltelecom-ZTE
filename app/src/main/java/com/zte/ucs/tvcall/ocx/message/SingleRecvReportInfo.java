package com.zte.ucs.tvcall.ocx.message;

/* loaded from: classes2.dex */
public class SingleRecvReportInfo {
    private String oldMsgId = "";
    private String sendUrl = "";
    private int receiptType = 0;

    public String getOldMsgId() {
        return this.oldMsgId;
    }

    public int getReceiptType() {
        return this.receiptType;
    }

    public String getSendUrl() {
        return this.sendUrl;
    }

    public void setOldMsgId(String str) {
        this.oldMsgId = str;
    }

    public void setReceiptType(int i) {
        this.receiptType = i;
    }

    public void setSendUrl(String str) {
        this.sendUrl = str;
    }
}
