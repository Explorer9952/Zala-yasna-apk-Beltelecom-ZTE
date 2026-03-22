package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstContactsSettingInfo {
    private byte autoBackupFlag = 0;
    private byte autoBackupFreq = 0;
    private byte autoBackupOnlyWifi = 0;

    public byte getAutoBackupFlag() {
        return this.autoBackupFlag;
    }

    public byte getAutoBackupFreq() {
        return this.autoBackupFreq;
    }

    public byte getAutoBackupOnlyWifi() {
        return this.autoBackupOnlyWifi;
    }

    public void setAutoBackupFlag(byte b2) {
        this.autoBackupFlag = b2;
    }

    public void setAutoBackupFreq(byte b2) {
        this.autoBackupFreq = b2;
    }

    public void setAutoBackupOnlyWifi(byte b2) {
        this.autoBackupOnlyWifi = b2;
    }
}
