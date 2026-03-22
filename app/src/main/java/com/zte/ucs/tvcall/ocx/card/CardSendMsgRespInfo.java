package com.zte.ucs.tvcall.ocx.card;

/* loaded from: classes2.dex */
public class CardSendMsgRespInfo {
    private int sendType;
    private String msgid = "";
    private String chatid = "";

    public String getChatid() {
        return this.chatid;
    }

    public String getMsgid() {
        return this.msgid;
    }

    public int getSendType() {
        return this.sendType;
    }

    public void setChatid(String str) {
        this.chatid = str;
    }

    public void setMsgid(String str) {
        this.msgid = str;
    }

    public void setSendType(int i) {
        this.sendType = i;
    }
}
