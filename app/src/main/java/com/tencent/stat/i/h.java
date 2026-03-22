package com.tencent.stat.i;

import android.content.Context;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    static long f2880a = -1;

    static long a(Context context, String str) {
        return q.a(context, str, f2880a);
    }

    static void a(Context context, String str, long j) {
        q.b(context, str, j);
    }

    public static synchronized boolean a(Context context) {
        boolean z;
        synchronized (h.class) {
            long a2 = a(context, "1.6.2_begin_protection");
            long a3 = a(context, "1.6.2_end__protection");
            if (a2 <= 0 || a3 != f2880a) {
                if (a2 == f2880a) {
                    a(context, "1.6.2_begin_protection", System.currentTimeMillis());
                }
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public static synchronized void b(Context context) {
        synchronized (h.class) {
            if (a(context, "1.6.2_end__protection") == f2880a) {
                a(context, "1.6.2_end__protection", System.currentTimeMillis());
            }
        }
    }
}
