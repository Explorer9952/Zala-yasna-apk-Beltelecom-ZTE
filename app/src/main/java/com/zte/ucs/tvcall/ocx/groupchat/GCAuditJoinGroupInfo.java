package com.zte.ucs.tvcall.ocx.groupchat;

/* loaded from: classes2.dex */
public class GCAuditJoinGroupInfo {
    private String auditedType;
    private String chatId;
    private String proposerURL;
    private String token;

    public String getAuditedType() {
        return this.auditedType;
    }

    public String getChatId() {
        return this.chatId;
    }

    public String getProposerURL() {
        return this.proposerURL;
    }

    public String getToken() {
        return this.token;
    }

    public void setAuditedType(String str) {
        this.auditedType = str;
    }

    public void setChatId(String str) {
        this.chatId = str;
    }

    public void setProposerURL(String str) {
        this.proposerURL = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
