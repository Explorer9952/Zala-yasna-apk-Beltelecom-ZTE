package com.video.androidsdk.download.bean;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class BaseTask {
    public String videoId;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return (obj instanceof BaseTask) && TextUtils.equals(((BaseTask) obj).videoId, this.videoId);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
