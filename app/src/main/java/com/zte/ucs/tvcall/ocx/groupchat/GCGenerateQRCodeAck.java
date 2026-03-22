package com.zte.ucs.tvcall.ocx.groupchat;

/* loaded from: classes2.dex */
public class GCGenerateQRCodeAck {
    private String QRCodeUuid;
    private String chatId = "";
    private String qrCodePicPath = "";
    private String expiresDate = "";

    public String getChatId() {
        return this.chatId;
    }

    public String getExpiresDate() {
        return this.expiresDate;
    }

    public String getQRCodeUuid() {
        return this.QRCodeUuid;
    }

    public String getQrCodePicPath() {
        return this.qrCodePicPath;
    }

    public void setChatId(String str) {
        this.chatId = str;
    }

    public void setExpiresDate(String str) {
        this.expiresDate = str;
    }

    public void setQRCodeUuid(String str) {
        this.QRCodeUuid = str;
    }

    public void setQrCodePicPath(String str) {
        this.qrCodePicPath = str;
    }
}
