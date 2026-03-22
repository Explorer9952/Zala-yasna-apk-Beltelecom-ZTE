package com.zte.ucs.tvcall.ocx.groupsm;

/* loaded from: classes2.dex */
public class SessGCSendTxtMsgInfo {
    private String chatId = "";
    private String messageId = "";
    private String text = "";
    private int length = 0;
    private String CPIMcc = "";

    public String getCPIMcc() {
        return this.CPIMcc;
    }

    public String getChatId() {
        return this.chatId;
    }

    public int getLength() {
        return this.length;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getText() {
        return this.text;
    }

    public void setCPIMcc(String str) {
        this.CPIMcc = str;
    }

    public void setChatId(String str) {
        this.chatId = str;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
