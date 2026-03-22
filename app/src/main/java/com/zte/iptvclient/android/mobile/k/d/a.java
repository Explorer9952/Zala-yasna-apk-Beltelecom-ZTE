package com.zte.iptvclient.android.mobile.k.d;

import android.text.TextUtils;
import com.video.androidsdk.log.LogEx;

/* compiled from: ChildWatchHistoryHelper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6707a = "a";

    public static final String a() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("ChildMode_History_Profilecode");
        LogEx.d(f6707a, " profileCode: " + c2);
        return TextUtils.isEmpty(c2) ? "" : c2;
    }
}
