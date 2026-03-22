package com.zte.iptvclient.android.mobile.e0.f;

import android.text.TextUtils;
import com.video.androidsdk.log.LogEx;

/* compiled from: CommentHelper.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f6134a = false;

    public static void a(boolean z) {
        f6134a = z;
    }

    public static boolean b() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Is_Show_Comments");
        LogEx.d("CommentHelper", "Is_Show_Comments: " + c2);
        return (TextUtils.isEmpty(c2) || "0".equals(c2)) ? false : true;
    }

    public static boolean a() {
        return f6134a;
    }
}
