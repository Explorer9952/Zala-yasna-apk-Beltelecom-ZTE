package com.video.androidsdk.common.http;

/* loaded from: classes.dex */
public class DataAttribute {
    int concurrentNum;
    int mergeMode;
    String uniqueKey;

    public int getConcurrentNum() {
        return this.concurrentNum;
    }

    public int getMergeMode() {
        return this.mergeMode;
    }

    public String getUniqueKey() {
        return this.uniqueKey;
    }

    public void setConcurrentNum(int i) {
        this.concurrentNum = i;
    }

    public void setMergeMode(int i) {
        this.mergeMode = i;
    }

    public void setUniqueKey(String str) {
        this.uniqueKey = str;
    }
}
