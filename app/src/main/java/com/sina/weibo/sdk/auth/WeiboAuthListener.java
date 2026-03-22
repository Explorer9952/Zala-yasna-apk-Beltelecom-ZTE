package com.sina.weibo.sdk.auth;

import android.os.Bundle;
import com.sina.weibo.sdk.exception.WeiboException;

/* loaded from: classes.dex */
public interface WeiboAuthListener {
    void onCancel();

    void onComplete(Bundle bundle);

    void onWeiboException(WeiboException weiboException);
}
