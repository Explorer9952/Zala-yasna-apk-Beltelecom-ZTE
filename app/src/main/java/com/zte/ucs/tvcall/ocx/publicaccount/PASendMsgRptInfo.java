package com.zte.ucs.tvcall.ocx.publicaccount;

/* loaded from: classes2.dex */
public class PASendMsgRptInfo {
    private String oldMsgId = "";
    private String messageId = "";
    private String receiverUri = "";
    private String msgSendTime = "";
    private int receiptType = 0;

    public String getMessageId() {
        return this.messageId;
    }

    public String getMsgSendTime() {
        return this.msgSendTime;
    }

    public String getOldMsgId() {
        return this.oldMsgId;
    }

    public int getReceiptType() {
        return this.receiptType;
    }

    public String getReceiverUri() {
        return this.receiverUri;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMsgSendTime(String str) {
        this.msgSendTime = str;
    }

    public void setOldMsgId(String str) {
        this.oldMsgId = str;
    }

    public void setReceiptType(int i) {
        this.receiptType = i;
    }

    public void setReceiverUri(String str) {
        this.receiverUri = str;
    }
}
