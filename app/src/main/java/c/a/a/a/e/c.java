package c.a.a.a.e;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: PreferencesUtils.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f1870a = "cn_feng_skin_pref";

    public static String a(Context context, String str, String str2) {
        return context.getSharedPreferences(f1870a, 0).getString(str, str2);
    }

    public static boolean b(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(f1870a, 0).edit();
        edit.putString(str, str2);
        return edit.commit();
    }
}
