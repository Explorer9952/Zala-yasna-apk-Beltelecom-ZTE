package com.tencent.stat.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static SharedPreferences f2893a;

    public static int a(Context context, String str, int i) {
        return a(context).getInt(m.b(context, "" + str), i);
    }

    public static long a(Context context, String str, long j) {
        return a(context).getLong(m.b(context, "" + str), j);
    }

    static synchronized SharedPreferences a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (q.class) {
            if (f2893a == null) {
                f2893a = PreferenceManager.getDefaultSharedPreferences(context);
            }
            sharedPreferences = f2893a;
        }
        return sharedPreferences;
    }

    public static String a(Context context, String str, String str2) {
        return a(context).getString(m.b(context, "" + str), str2);
    }

    public static void b(Context context, String str, int i) {
        String b2 = m.b(context, "" + str);
        SharedPreferences.Editor edit = a(context).edit();
        edit.putInt(b2, i);
        edit.commit();
    }

    public static void b(Context context, String str, long j) {
        String b2 = m.b(context, "" + str);
        SharedPreferences.Editor edit = a(context).edit();
        edit.putLong(b2, j);
        edit.commit();
    }

    public static void b(Context context, String str, String str2) {
        String b2 = m.b(context, "" + str);
        SharedPreferences.Editor edit = a(context).edit();
        edit.putString(b2, str2);
        edit.commit();
    }
}
