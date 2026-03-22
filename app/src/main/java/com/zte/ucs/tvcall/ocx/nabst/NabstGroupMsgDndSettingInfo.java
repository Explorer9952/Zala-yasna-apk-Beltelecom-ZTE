package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstGroupMsgDndSettingInfo {
    private byte flag;
    private String groupid = "";
    private String groupName = "";

    public byte getFlag() {
        return this.flag;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getGroupid() {
        return this.groupid;
    }

    public void setFlag(byte b2) {
        this.flag = b2;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setGroupid(String str) {
        this.groupid = str;
    }
}
