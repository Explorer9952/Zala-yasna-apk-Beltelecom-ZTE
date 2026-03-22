package com.gyf.barlibrary;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import com.facebook.appevents.codeless.internal.Constants;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BarConfig.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f2361a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2362b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f2363c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2364d;
    private final int e;
    private final boolean f;
    private final float g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Activity activity) {
        this.f = activity.getResources().getConfiguration().orientation == 1;
        this.g = a(activity);
        this.f2361a = a(activity, "status_bar_height");
        this.f2362b = a((Context) activity);
        this.f2364d = b((Context) activity);
        this.e = c(activity);
        this.f2363c = this.f2364d > 0;
        f.c(activity);
    }

    @TargetApi(14)
    private int a(Context context) {
        if (Build.VERSION.SDK_INT < 14) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
        return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
    }

    @TargetApi(14)
    private int b(Context context) {
        if (Build.VERSION.SDK_INT < 14 || !b((Activity) context)) {
            return 0;
        }
        return a(context, this.f ? "navigation_bar_height" : "navigation_bar_height_landscape");
    }

    @TargetApi(14)
    private int c(Context context) {
        if (Build.VERSION.SDK_INT < 14 || !b((Activity) context)) {
            return 0;
        }
        return a(context, "navigation_bar_width");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f2361a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f2363c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.g >= 600.0f || this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.e;
    }

    private int a(Context context, String str) {
        try {
            int identifier = Resources.getSystem().getIdentifier(str, "dimen", Constants.PLATFORM);
            if (identifier > 0) {
                return Math.max(context.getResources().getDimensionPixelSize(identifier), Resources.getSystem().getDimensionPixelSize(identifier));
            }
            return 0;
        } catch (Resources.NotFoundException unused) {
            return 0;
        }
    }

    @TargetApi(14)
    private boolean b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && Settings.Global.getInt(activity.getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
            return false;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        }
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i2 - displayMetrics2.widthPixels > 0 || i - displayMetrics2.heightPixels > 0;
    }

    @SuppressLint({"NewApi"})
    private float a(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 16) {
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        float f = displayMetrics.widthPixels;
        float f2 = displayMetrics.density;
        return Math.min(f / f2, displayMetrics.heightPixels / f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f2362b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f2364d;
    }
}
