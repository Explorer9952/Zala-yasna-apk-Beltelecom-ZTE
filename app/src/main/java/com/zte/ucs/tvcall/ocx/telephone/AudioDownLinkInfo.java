package com.zte.ucs.tvcall.ocx.telephone;

/* loaded from: classes2.dex */
public class AudioDownLinkInfo {
    public int avgBitrate;
    public int curBitrate;
    public int curFractionLost;
    public int curJitter;
    public int curRTT;
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

    public int getTotalFractionLost() {
        return this.totalFractionLost;
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

    public void setTotalFractionLost(int i) {
        this.totalFractionLost = i;
    }

    public String toString() {
        return "AudioDownLinkInfo [curFractionLost=" + this.curFractionLost + ", totalFractionLost=" + this.totalFractionLost + ", curJitter=" + this.curJitter + ", curBitrate=" + this.curBitrate + ", avgBitrate=" + this.avgBitrate + ", curRTT=" + this.curRTT + "]";
    }
}
