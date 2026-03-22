package com.zte.iptvclient.android.common.i.c;

import android.content.Context;
import android.content.SharedPreferences;
import com.video.androidsdk.log.LogEx;

/* compiled from: SharedPreferencesUtils.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static final String f4652b = "b";

    /* renamed from: c, reason: collision with root package name */
    private static b f4653c;

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f4654a = null;

    private b() {
    }

    public static b b() {
        if (f4653c == null) {
            f4653c = new b();
        }
        return f4653c;
    }

    public void a(Context context) {
        this.f4654a = context.getSharedPreferences("resourceInfo", 0);
    }

    public void a(String str) {
        LogEx.d(f4652b, "strValue=" + str);
        SharedPreferences sharedPreferences = this.f4654a;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("VERSION_CODE", str);
            edit.commit();
        }
    }

    public String a() {
        SharedPreferences sharedPreferences = this.f4654a;
        return sharedPreferences == null ? "" : sharedPreferences.getString("VERSION_CODE", "");
    }
}
