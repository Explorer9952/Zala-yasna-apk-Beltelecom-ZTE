package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstGroupList {
    private byte groupCount;
    private String[] groupNameArray = new String[0];

    public byte getGroupCount() {
        return this.groupCount;
    }

    public String[] getGroupNameArray() {
        return this.groupNameArray;
    }

    public void setGroupCount(byte b2) {
        this.groupCount = b2;
    }

    public void setGroupNameArray(String[] strArr) {
        if (strArr != null) {
            this.groupNameArray = (String[]) strArr.clone();
        }
    }
}
