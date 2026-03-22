package com.zte.ucs.tvcall.ocx.precall;

/* loaded from: classes2.dex */
public class PrecallSendReportInfo {
    private int type;
    private String oldMsgId = "";
    private String messageId = "";
    private String contactId = "";
    private int receiptType = 0;

    public String getContactId() {
        return this.contactId;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getOldMsgId() {
        return this.oldMsgId;
    }

    public int getReceiptType() {
        return this.receiptType;
    }

    public int getType() {
        return this.type;
    }

    public void setContactId(String str) {
        this.contactId = str;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setOldMsgId(String str) {
        this.oldMsgId = str;
    }

    public void setReceiptType(int i) {
        this.receiptType = i;
    }

    public void setType(int i) {
        this.type = i;
    }
}
