package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstPersonTelInfo {
    private byte rcsUser;
    private String telStr = "";
    private byte telType;

    public byte getRcsUser() {
        return this.rcsUser;
    }

    public String getTelStr() {
        return this.telStr;
    }

    public byte getTelType() {
        return this.telType;
    }

    public void setRcsUser(byte b2) {
        this.rcsUser = b2;
    }

    public void setTelStr(String str) {
        this.telStr = str;
    }

    public void setTelType(byte b2) {
        this.telType = b2;
    }
}
