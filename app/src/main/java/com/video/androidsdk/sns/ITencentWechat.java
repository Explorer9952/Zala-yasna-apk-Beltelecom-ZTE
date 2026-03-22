package com.video.androidsdk.sns;

import android.content.Intent;

/* loaded from: classes.dex */
public interface ITencentWechat extends ISNSWrapper {
    public static final int TENCENT_WECHAT_SSO_REQUESTCODE = 1;

    void authCallBack(int i, int i2, Intent intent);

    int getScene();

    int isClientInstalled();

    int openClient();

    int registerApp();

    void setScene(int i);
}
