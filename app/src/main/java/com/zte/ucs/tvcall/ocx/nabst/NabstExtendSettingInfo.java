package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstExtendSettingInfo {
    private int blackCount;
    private byte disturbingblock = 0;
    private String[] blackArray = new String[0];

    public String[] getBlackArray() {
        return this.blackArray;
    }

    public int getBlackCount() {
        return this.blackCount;
    }

    public byte getDisturbingblock() {
        return this.disturbingblock;
    }

    public void setBlackArray(String[] strArr) {
        if (strArr != null) {
            this.blackArray = (String[]) strArr.clone();
        }
    }

    public void setBlackCount(int i) {
        this.blackCount = i;
    }

    public void setDisturbingblock(byte b2) {
        this.disturbingblock = b2;
    }
}
