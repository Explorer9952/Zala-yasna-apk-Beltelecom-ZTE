package com.video.androidsdk.download.bean;

import java.util.HashMap;

/* loaded from: classes.dex */
public class DownloadTask extends BaseTask {
    public HashMap<String, String> videoInfo;
    public String contentType = "";
    public String seriesProgramCode = "";
    public String seriesCount = "";
    public String finCount = "";
    public String videoSize = "";
    public String downloadSize = "";
    public String progress = "";
    public String status = "";

    @Override // com.video.androidsdk.download.bean.BaseTask
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.video.androidsdk.download.bean.BaseTask
    public int hashCode() {
        return super.hashCode();
    }
}
