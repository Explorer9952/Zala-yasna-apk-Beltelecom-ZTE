package com.video.androidsdk.log;

/* loaded from: classes.dex */
public class DebugLogReq extends BaseUploadLogReq {
    private String filePath = "";
    private String description = "";

    public String getDescription() {
        return this.description;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }
}
