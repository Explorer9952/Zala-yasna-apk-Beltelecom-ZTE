package com.zte.ucs.tvcall.ocx.message;

/* loaded from: classes2.dex */
public class GrpSendMsgMultInfo {
    private String receiverUri = "";
    private String messageId = "";
    private String file = "";
    private String smallPic = "";
    private int timeLen = 0;
    private int messageType = 0;
    private int receipt = 0;
    private int needResend = 0;
    private String filetranId = "";
    private int position = 0;

    public String getFile() {
        return this.file;
    }

    public String getFiletranId() {
        return this.filetranId;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public int getNeedResend() {
        return this.needResend;
    }

    public int getPosition() {
        return this.position;
    }

    public int getReceipt() {
        return this.receipt;
    }

    public String getReceiverUri() {
        return this.receiverUri;
    }

    public String getSmallPic() {
        return this.smallPic;
    }

    public int getTimeLen() {
        return this.timeLen;
    }

    public void setFile(String str) {
        this.file = str;
    }

    public void setFiletranId(String str) {
        this.filetranId = str;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMessageType(int i) {
        this.messageType = i;
    }

    public void setNeedResend(int i) {
        this.needResend = i;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void setReceipt(int i) {
        this.receipt = i;
    }

    public void setReceiverUri(String str) {
        this.receiverUri = str;
    }

    public void setSmallPic(String str) {
        this.smallPic = str;
    }

    public void setTimeLen(int i) {
        this.timeLen = i;
    }
}
