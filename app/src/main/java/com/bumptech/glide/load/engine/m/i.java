package com.bumptech.glide.load.engine.m;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.mm.sdk.platformtools.Util;

/* compiled from: MemorySizeCalculator.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private final int f2052a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2053b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f2054c;

    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: classes.dex */
    private static class a implements b {

        /* renamed from: a, reason: collision with root package name */
        private final DisplayMetrics f2055a;

        public a(DisplayMetrics displayMetrics) {
            this.f2055a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.m.i.b
        public int a() {
            return this.f2055a.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.m.i.b
        public int b() {
            return this.f2055a.widthPixels;
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: classes.dex */
    interface b {
        int a();

        int b();
    }

    public i(Context context) {
        this(context, (ActivityManager) context.getSystemService("activity"), new a(context.getResources().getDisplayMetrics()));
    }

    public int a() {
        return this.f2052a;
    }

    public int b() {
        return this.f2053b;
    }

    i(Context context, ActivityManager activityManager, b bVar) {
        this.f2054c = context;
        int a2 = a(activityManager);
        int b2 = bVar.b() * bVar.a() * 4;
        int i = b2 * 4;
        int i2 = b2 * 2;
        int i3 = i2 + i;
        if (i3 <= a2) {
            this.f2053b = i2;
            this.f2052a = i;
        } else {
            int round = Math.round(a2 / 6.0f);
            this.f2053b = round * 2;
            this.f2052a = round * 4;
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculated memory cache size: ");
            sb.append(a(this.f2053b));
            sb.append(" pool size: ");
            sb.append(a(this.f2052a));
            sb.append(" memory class limited? ");
            sb.append(i3 > a2);
            sb.append(" max size: ");
            sb.append(a(a2));
            sb.append(" memoryClass: ");
            sb.append(activityManager.getMemoryClass());
            sb.append(" isLowMemoryDevice: ");
            sb.append(b(activityManager));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    private static int a(ActivityManager activityManager) {
        return Math.round(activityManager.getMemoryClass() * Util.BYTE_OF_KB * Util.BYTE_OF_KB * (b(activityManager) ? 0.33f : 0.4f));
    }

    @TargetApi(19)
    private static boolean b(ActivityManager activityManager) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return activityManager.isLowRamDevice();
        }
        return i < 11;
    }

    private String a(int i) {
        return Formatter.formatFileSize(this.f2054c, i);
    }
}
