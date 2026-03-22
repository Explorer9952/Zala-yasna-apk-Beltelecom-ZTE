package com.video.androidsdk.sns;

/* loaded from: classes.dex */
public interface ISNSAuthListener {
    void onCancel();

    void onComplete();

    void onError(int i, String str);

    void onException(Exception exc);
}
