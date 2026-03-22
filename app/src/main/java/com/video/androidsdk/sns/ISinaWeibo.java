package com.video.androidsdk.sns;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public interface ISinaWeibo extends ISNSWrapper {
    public static final int SINA_WEIBO_SSO_REQUERTCODE = 32973;

    void authCallBack(int i, int i2, Intent intent);

    int isClientInstalled();

    void logout();

    int registerApp();

    void weiboListener(Intent intent, Context context);
}
