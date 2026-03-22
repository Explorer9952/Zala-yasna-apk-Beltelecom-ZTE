package com.zte.iptvclient.android.common.i.a;

import android.content.Context;
import com.zte.iptvclient.android.common.i.b.c;

/* compiled from: ResourceHelper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Context f4634a;

    public static void a(Context context) {
        f4634a = context;
        c.d().a(context);
    }

    public static void b(String str) {
        c.d().a(str);
    }

    public static String a(String str) {
        return com.zte.iptvclient.android.common.i.c.c.a(f4634a, str);
    }

    public static String a(int i) {
        Context context = f4634a;
        return context == null ? "" : com.zte.iptvclient.android.common.i.c.c.a(context, context.getResources().getResourceEntryName(i));
    }
}
