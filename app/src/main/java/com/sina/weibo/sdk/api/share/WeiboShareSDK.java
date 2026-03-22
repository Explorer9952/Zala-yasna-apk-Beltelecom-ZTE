package com.sina.weibo.sdk.api.share;

import android.content.Context;

/* loaded from: classes.dex */
public class WeiboShareSDK {
    public static IWeiboShareAPI createWeiboAPI(Context context, String str, boolean z) {
        return new WeiboShareAPIImpl(context, str, z);
    }

    public static IWeiboShareAPI createWeiboAPI(Context context, String str) {
        return createWeiboAPI(context, str, true);
    }
}
