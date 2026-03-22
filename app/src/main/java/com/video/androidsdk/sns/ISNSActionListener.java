package com.video.androidsdk.sns;

/* loaded from: classes.dex */
public interface ISNSActionListener {
    void onCancel();

    void onException(Exception exc);

    void onFail(int i, String str);

    void onRunning();

    void onSuccess();
}
