package com.zte.ucs.tvcall.ocx.telephone;

/* loaded from: classes2.dex */
public class VideoUpLinkInfo {
    public static final int enumZIME_FEC = 0;
    public static final int enumZIME_NACK = 1;
    public static final int enumZIME_RED_MAX = 2;
    public int avgBitrate;
    public int curBitrate;
    public int curFractionLost;
    public int curJitter;
    public int curRTT;
    int eRedundantType;
    public int expectedESBitRate;
    public int expectedFrameRate;
    public int iHeight;
    public int iSwitchReason;
    public int iWidth;
    public int realCapFrameRate;
    public int realESBitRate_Avg;
    public int realESBitRate_Cur;
    public int realFrameRate;
    public int redundantBitRate_Avg;
    public int redundantBitRate_Cur;
    public int totalFractionLost;

    public int getAvgBitrate() {
        return this.avgBitrate;
    }

    public int getCurBitrate() {
        return this.curBitrate;
    }

    public int getCurFractionLost() {
        return this.curFractionLost;
    }

    public int getCurJitter() {
        return this.curJitter;
    }

    public int getCurRTT() {
        return this.curRTT;
    }

    public int getExpectedESBitRate() {
        return this.expectedESBitRate;
    }

    public int getExpectedFrameRate() {
        return this.expectedFrameRate;
    }

    public int getRealCapFrameRate() {
        return this.realCapFrameRate;
    }

    public int getRealESBitRate_Avg() {
        return this.realESBitRate_Avg;
    }

    public int getRealESBitRate_Cur() {
        return this.realESBitRate_Cur;
    }

    public int getRealFrameRate() {
        return this.realFrameRate;
    }

    public int getRedundantBitRate_Avg() {
        return this.redundantBitRate_Avg;
    }

    public int getRedundantBitRate_Cur() {
        return this.redundantBitRate_Cur;
    }

    public int getTotalFractionLost() {
        return this.totalFractionLost;
    }

    public int geteRedundantType() {
        return this.eRedundantType;
    }

    public int getiHeight() {
        return this.iHeight;
    }

    public int getiSwitchReason() {
        return this.iSwitchReason;
    }

    public int getiWidth() {
        return this.iWidth;
    }

    public void setAvgBitrate(int i) {
        this.avgBitrate = i;
    }

    public void setCurBitrate(int i) {
        this.curBitrate = i;
    }

    public void setCurFractionLost(int i) {
        this.curFractionLost = i;
    }

    public void setCurJitter(int i) {
        this.curJitter = i;
    }

    public void setCurRTT(int i) {
        this.curRTT = i;
    }

    public void setExpectedESBitRate(int i) {
        this.expectedESBitRate = i;
    }

    public void setExpectedFrameRate(int i) {
        this.expectedFrameRate = i;
    }

    public void setRealCapFrameRate(int i) {
        this.realCapFrameRate = i;
    }

    public void setRealESBitRate_Avg(int i) {
        this.realESBitRate_Avg = i;
    }

    public void setRealESBitRate_Cur(int i) {
        this.realESBitRate_Cur = i;
    }

    public void setRealFrameRate(int i) {
        this.realFrameRate = i;
    }

    public void setRedundantBitRate_Avg(int i) {
        this.redundantBitRate_Avg = i;
    }

    public void setRedundantBitRate_Cur(int i) {
        this.redundantBitRate_Cur = i;
    }

    public void setTotalFractionLost(int i) {
        this.totalFractionLost = i;
    }

    public void seteRedundantType(int i) {
        this.eRedundantType = i;
    }

    public void setiHeight(int i) {
        this.iHeight = i;
    }

    public void setiSwitchReason(int i) {
        this.iSwitchReason = i;
    }

    public void setiWidth(int i) {
        this.iWidth = i;
    }

    public String toString() {
        return "VideoUpLinkInfo [curFractionLost=" + this.curFractionLost + ", totalFractionLost=" + this.totalFractionLost + ", curJitter=" + this.curJitter + ", curBitrate=" + this.curBitrate + ", avgBitrate=" + this.avgBitrate + ", curRTT=" + this.curRTT + ", expectedFrameRate=" + this.expectedFrameRate + ", realFrameRate=" + this.realFrameRate + ", realCapFrameRate=" + this.realCapFrameRate + ", expectedESBitRate=" + this.expectedESBitRate + ", realESBitRate_Cur=" + this.realESBitRate_Cur + ", realESBitRate_Avg=" + this.realESBitRate_Avg + ", redundantBitRate_Cur=" + this.redundantBitRate_Cur + ", redundantBitRate_Avg=" + this.redundantBitRate_Avg + ", eRedundantType=" + this.eRedundantType + ", iWidth=" + this.iWidth + ", iHeight=" + this.iHeight + ", iSwitchReason=" + this.iSwitchReason + "]";
    }
}
