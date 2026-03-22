package com.zte.iptvclient.android.common.c;

import android.text.TextUtils;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;

/* compiled from: InBaseWeChatKeys.java */
/* loaded from: classes.dex */
public class d {
    public static String a() {
        String readPropertie = ConfigMgr.readPropertie("WeChatAppKey");
        if (TextUtils.isEmpty(readPropertie)) {
            return "";
        }
        LogEx.i("InBaseWeChatKeys", "WeChatAppKey:" + readPropertie);
        return readPropertie;
    }
}
