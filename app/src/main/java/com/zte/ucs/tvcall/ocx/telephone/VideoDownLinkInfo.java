package com.zte.ucs.tvcall.ocx.telephone;

/* loaded from: classes2.dex */
public class VideoDownLinkInfo {
    public static final int enumZIME_FEC = 0;
    public static final int enumZIME_NACK = 1;
    public static final int enumZIME_RED_MAX = 2;
    public int avgBitrate;
    public int curBitrate;
    public int curFractionLost;
    public int curJitter;
    public int curRTT;
    public int displayFrameRate;
    public int eRedundantType;
    public int iHeight;
    public int iSwitchReason;
    public int iWidth;
    public int recvESBitRate_Avg;
    public int recvESBitRate_Cur;
    public int recvFrameRate;
    public int recvRedundantBitRate_Avg;
    public int recvRedundantBitRate_Cur;
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

    public int getDisplayFrameRate() {
        return this.displayFrameRate;
    }

    public int getRecvESBitRate_Avg() {
        return this.recvESBitRate_Avg;
    }

    public int getRecvESBitRate_Cur() {
        return this.recvESBitRate_Cur;
    }

    public int getRecvFrameRate() {
        return this.recvFrameRate;
    }

    public int getRecvRedundantBitRate_Avg() {
        return this.recvRedundantBitRate_Avg;
    }

    public int getRecvRedundantBitRate_Cur() {
        return this.recvRedundantBitRate_Cur;
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

    public void setDisplayFrameRate(int i) {
        this.displayFrameRate = i;
    }

    public void setRecvESBitRate_Avg(int i) {
        this.recvESBitRate_Avg = i;
    }

    public void setRecvESBitRate_Cur(int i) {
        this.recvESBitRate_Cur = i;
    }

    public void setRecvFrameRate(int i) {
        this.recvFrameRate = i;
    }

    public void setRecvRedundantBitRate_Avg(int i) {
        this.recvRedundantBitRate_Avg = i;
    }

    public void setRecvRedundantBitRate_Cur(int i) {
        this.recvRedundantBitRate_Cur = i;
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
        return "VideoDownLinkInfo [curFractionLost=" + this.curFractionLost + ", totalFractionLost=" + this.totalFractionLost + ", curJitter=" + this.curJitter + ", curBitrate=" + this.curBitrate + ", avgBitrate=" + this.avgBitrate + ", curRTT=" + this.curRTT + ", recvFrameRate=" + this.recvFrameRate + ", displayFrameRate=" + this.displayFrameRate + ", recvESBitRate_Cur=" + this.recvESBitRate_Cur + ", recvESBitRate_Avg=" + this.recvESBitRate_Avg + ", recvRedundantBitRate_Cur=" + this.recvRedundantBitRate_Cur + ", recvRedundantBitRate_Avg=" + this.recvRedundantBitRate_Avg + ", eRedundantType=" + this.eRedundantType + ", iWidth=" + this.iWidth + ", iHeight=" + this.iHeight + ", iSwitchReason=" + this.iSwitchReason + "]";
    }
}
