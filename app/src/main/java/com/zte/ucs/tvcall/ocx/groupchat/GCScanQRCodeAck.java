package com.zte.ucs.tvcall.ocx.groupchat;

/* loaded from: classes2.dex */
public class GCScanQRCodeAck {
    private int groupVersion;
    private int identityTpye;
    private int memberCount;
    private String chatId = "";
    private String subject = "";
    private String referByUrl = "";
    private String qrCodeUuid = "";

    public String getChatId() {
        return this.chatId;
    }

    public int getGroupVersion() {
        return this.groupVersion;
    }

    public int getIdentityTpye() {
        return this.identityTpye;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public String getQrCodeUuid() {
        return this.qrCodeUuid;
    }

    public String getReferByUrl() {
        return this.referByUrl;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setChatId(String str) {
        this.chatId = str;
    }

    public void setGroupVersion(int i) {
        this.groupVersion = i;
    }

    public void setIdentityTpye(int i) {
        this.identityTpye = i;
    }

    public void setMemberCount(int i) {
        this.memberCount = i;
    }

    public void setQrCodeUuid(String str) {
        this.qrCodeUuid = str;
    }

    public void setReferByUrl(String str) {
        this.referByUrl = str;
    }

    public void setSubject(String str) {
        this.subject = str;
    }
}
