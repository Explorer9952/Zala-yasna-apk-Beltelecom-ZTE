package com.zte.ucs.tvcall.ocx.groupchat;

/* loaded from: classes2.dex */
public class GroupChatGetFileRate {
    private String chatId = "";
    private String messageId = "";
    private String filetranId = "";
    private int tranRate = 0;
    private int finishSize = 0;

    public String getChatId() {
        return this.chatId;
    }

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

    public void setChatId(String str) {
        this.chatId = str;
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
