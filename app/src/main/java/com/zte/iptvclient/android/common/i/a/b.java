package com.zte.iptvclient.android.common.i.a;

import android.content.Context;
import android.text.TextUtils;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.j.h;

/* compiled from: ResourceUpdateMgr.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4635a = "b";

    public static void a(Context context) {
        h hVar = new h(context);
        String R = hVar.R();
        if (TextUtils.isEmpty(R)) {
            R = ConfigMgr.readPropertie("UpgradeResourceServer");
            if (!TextUtils.isEmpty(R)) {
                hVar.H(R);
            }
        }
        LogEx.d(f4635a, "url is :" + R);
        a.b(R);
    }
}
