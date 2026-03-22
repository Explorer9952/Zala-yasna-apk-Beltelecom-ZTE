package com.zte.ucs.tvcall.ocx.groupchat;

/* loaded from: classes2.dex */
public class GroupMsgRevokeRpt {
    private String messageId = "";
    private String oldMessageId = "";
    private String chatId = "";

    public String getChatId() {
        return this.chatId;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getOldMessageId() {
        return this.oldMessageId;
    }

    public void setChatId(String str) {
        this.chatId = str;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setOldMessageId(String str) {
        this.oldMessageId = str;
    }
}
