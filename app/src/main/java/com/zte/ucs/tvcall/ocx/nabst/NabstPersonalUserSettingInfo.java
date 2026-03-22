package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstPersonalUserSettingInfo {
    private NabstCallingSettingInfo tCallingSetting = new NabstCallingSettingInfo();
    private NabstContactsSettingInfo tContactsSetting = new NabstContactsSettingInfo();
    private NabstExtendSettingInfo tExtendSetting = new NabstExtendSettingInfo();
    private NabstMessageSettingInfo tMessageSetting = new NabstMessageSettingInfo();
    private byte iosdispmsg = 0;

    public NabstCallingSettingInfo getCallSettingInfo() {
        return this.tCallingSetting;
    }

    public NabstContactsSettingInfo getContactsSettingInfo() {
        return this.tContactsSetting;
    }

    public NabstExtendSettingInfo getExtendSettingInfo() {
        return this.tExtendSetting;
    }

    public byte getIosdispmsg() {
        return this.iosdispmsg;
    }

    public NabstMessageSettingInfo getMessageSettingInfo() {
        return this.tMessageSetting;
    }

    public void setCallSettingInfo(NabstCallingSettingInfo nabstCallingSettingInfo) {
        this.tCallingSetting = nabstCallingSettingInfo;
    }

    public void setContactsSettingInfo(NabstContactsSettingInfo nabstContactsSettingInfo) {
        this.tContactsSetting = nabstContactsSettingInfo;
    }

    public void setExtendSettingInfo(NabstExtendSettingInfo nabstExtendSettingInfo) {
        this.tExtendSetting = nabstExtendSettingInfo;
    }

    public void setIosdispmsg(byte b2) {
        this.iosdispmsg = b2;
    }

    public void setMessageSettingInfo(NabstMessageSettingInfo nabstMessageSettingInfo) {
        this.tMessageSetting = nabstMessageSettingInfo;
    }
}
