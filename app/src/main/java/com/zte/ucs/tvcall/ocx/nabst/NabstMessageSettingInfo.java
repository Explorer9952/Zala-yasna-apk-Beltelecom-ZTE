package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstMessageSettingInfo {
    private int groupMsgDndCount;
    private int singMsgDndCount;
    private byte archive = 0;
    private byte teleReceiver = 0;
    private NabstMsgDndSettingInfo tMsgDnd = new NabstMsgDndSettingInfo();
    private NabstMsgReminderSettingInfo tMsgReminder = new NabstMsgReminderSettingInfo();
    private NabstGroupMsgDndSettingInfo[] groupMsgDndArray = new NabstGroupMsgDndSettingInfo[0];
    private NabstSingMsgDndSettingInfo[] singMsgDndArray = new NabstSingMsgDndSettingInfo[0];

    public byte getArchive() {
        return this.archive;
    }

    public NabstGroupMsgDndSettingInfo[] getGroupMsgDndArray() {
        return this.groupMsgDndArray;
    }

    public int getGroupMsgDndCount() {
        return this.groupMsgDndCount;
    }

    public NabstMsgDndSettingInfo getMsgDndSettingInfo() {
        return this.tMsgDnd;
    }

    public NabstMsgReminderSettingInfo getMsgReminderSettingInfo() {
        return this.tMsgReminder;
    }

    public int getSingMsgDndCount() {
        return this.singMsgDndCount;
    }

    public NabstSingMsgDndSettingInfo[] getSingleMsgDndArray() {
        return this.singMsgDndArray;
    }

    public byte getTeleReceiver() {
        return this.teleReceiver;
    }

    public void setArchive(byte b2) {
        this.archive = b2;
    }

    public void setGroupMsgDndArray(NabstGroupMsgDndSettingInfo[] nabstGroupMsgDndSettingInfoArr) {
        if (nabstGroupMsgDndSettingInfoArr != null) {
            this.groupMsgDndArray = (NabstGroupMsgDndSettingInfo[]) nabstGroupMsgDndSettingInfoArr.clone();
        }
    }

    public void setGroupMsgDndCount(int i) {
        this.groupMsgDndCount = i;
    }

    public void setMsgDndSettingInfo(NabstMsgDndSettingInfo nabstMsgDndSettingInfo) {
        this.tMsgDnd = nabstMsgDndSettingInfo;
    }

    public void setMsgReminderSettingInfo(NabstMsgReminderSettingInfo nabstMsgReminderSettingInfo) {
        this.tMsgReminder = nabstMsgReminderSettingInfo;
    }

    public void setSingMsgDndCount(int i) {
        this.singMsgDndCount = i;
    }

    public void setSingleMsgDndArray(NabstSingMsgDndSettingInfo[] nabstSingMsgDndSettingInfoArr) {
        if (this.singMsgDndArray != null) {
            this.singMsgDndArray = (NabstSingMsgDndSettingInfo[]) nabstSingMsgDndSettingInfoArr.clone();
        }
    }

    public void setTeleReceiver(byte b2) {
        this.teleReceiver = b2;
    }
}
