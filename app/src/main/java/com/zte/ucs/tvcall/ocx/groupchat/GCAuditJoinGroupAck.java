package com.zte.ucs.tvcall.ocx.groupchat;

/* loaded from: classes2.dex */
public class GCAuditJoinGroupAck {
    private String chatId = "";
    private String proposerURL;

    public String getChatId() {
        return this.chatId;
    }

    public String getProposerURL() {
        return this.proposerURL;
    }

    public void setChatId(String str) {
        this.chatId = str;
    }

    public void setProposerURL(String str) {
        this.proposerURL = str;
    }
}
