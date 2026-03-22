package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstMsgDndSettingInfo {
    private byte messageDndFlag = 0;
    private String messageDndTime = "";

    public byte getMessageDndFlag() {
        return this.messageDndFlag;
    }

    public String getMessageDndTime() {
        return this.messageDndTime;
    }

    public void setMessageDndFlag(byte b2) {
        this.messageDndFlag = b2;
    }

    public void setMessageDndTime(String str) {
        this.messageDndTime = str;
    }
}
