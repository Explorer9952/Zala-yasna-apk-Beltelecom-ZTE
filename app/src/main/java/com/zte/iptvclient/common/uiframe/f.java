package com.zte.iptvclient.common.uiframe;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.video.androidsdk.log.LogEx;

/* compiled from: DisplayManager.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static int f7909a = 1024;

    /* renamed from: b, reason: collision with root package name */
    private static int f7910b = 768;

    /* renamed from: c, reason: collision with root package name */
    private static float f7911c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    private static float f7912d = 1.0f;
    private static int e = 1280;
    private static int f = 752;
    private static float g = 1.0f;
    private static float h = 1.0f;
    private static int i = -1;
    private static float j = 1.0f;
    private static double k = 1.0d;
    private static double l = 1.0d;
    private static boolean m = false;
    private static int n;

    public static void a(int i2, int i3) {
        LogEx.i("DisplayManager", "iMaxWidth=" + i2 + ",iMaxHeight=" + i3);
        f7909a = i2;
        f7910b = i3;
    }

    public static double b() {
        return k;
    }

    public static void b(View view) {
        a(view, j);
    }

    public static int a() {
        return e;
    }

    public static int a(int i2) {
        int i3 = f7909a;
        if (i3 > 0) {
            return (i2 * e) / i3;
        }
        LogEx.w("DisplayManager", "Invalid miReferencedMaxWidth=" + f7909a);
        return 0;
    }

    public static void a(Activity activity) {
        if (activity != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            i = activity.getResources().getConfiguration().orientation;
            LogEx.i("DisplayManager", "miScreenOrientation=" + i);
            a(displayMetrics);
        }
    }

    private static void a(DisplayMetrics displayMetrics) {
        e = displayMetrics.widthPixels;
        f = displayMetrics.heightPixels;
        LogEx.i("DisplayManager", "miDisplayWidth=" + e + ",miDisplayHeight=" + f);
        h = displayMetrics.scaledDensity;
        StringBuilder sb = new StringBuilder();
        sb.append("mfFontDensity=");
        sb.append(h);
        LogEx.i("DisplayManager", sb.toString());
        g = displayMetrics.density;
        LogEx.i("DisplayManager", "mfScreenDensity=" + g);
        LogEx.i("DisplayManager", "densityDpi=" + displayMetrics.densityDpi);
        m = false;
        if (e != f7909a || f != f7910b || Math.abs(g - f7911c) >= 0.001d || Math.abs(h - f7912d) >= 0.001d) {
            m = true;
        }
        k = 1.0d;
        int i2 = f7909a;
        if (i2 > 0) {
            double d2 = e;
            Double.isNaN(d2);
            double d3 = (i2 * g) / f7911c;
            Double.isNaN(d3);
            k = (d2 * 1.0d) / d3;
            LogEx.i("DisplayManager", "mfWidthScaleRate=" + k);
        }
        l = 1.0d;
        int i3 = f7910b;
        if (i3 > 0) {
            double d4 = f;
            Double.isNaN(d4);
            double d5 = (i3 * g) / f7911c;
            Double.isNaN(d5);
            l = (d4 * 1.0d) / d5;
            LogEx.i("DisplayManager", "mfHeightScaleRate=" + l);
        }
        double d6 = k;
        double d7 = l;
        if (d6 >= d7) {
            d6 = d7;
        }
        j = (float) d6;
        LogEx.i("DisplayManager", "mfDeviceScaleRate=" + j);
        double d8 = (double) j;
        Double.isNaN(d8);
        if (Math.abs(d8 - 1.0d) <= 0.001d) {
            m = false;
        }
        LogEx.i("DisplayManager", "mbNeedScaleView=" + m);
    }

    public static void a(View view) {
        if (view != null) {
            a(view, (float) k);
        } else {
            LogEx.w("DisplayManager", "scaleView : view is null");
        }
    }

    public static void a(View view, float f2) {
        if (!m || view == null || f2 <= 0.001d) {
            return;
        }
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            float textSize = (textView.getTextSize() * f2) / h;
            if (n == 1) {
                textSize = ((textView.getTextSize() * f2) * g) / h;
            }
            textView.setTextSize(textSize);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            int i2 = layoutParams.width;
            if (i2 != -2 && i2 != -1) {
                layoutParams.width = (int) ((i2 * f2) + 0.5f);
            }
            int i3 = layoutParams.height;
            if (i3 != -2 && i3 != -1) {
                layoutParams.height = (int) ((i3 * f2) + 0.5f);
            }
            view.setPadding((int) ((view.getPaddingLeft() * f2) + 0.5f), (int) ((view.getPaddingTop() * f2) + 0.5f), (int) ((view.getPaddingRight() * f2) + 0.5f), (int) ((view.getPaddingBottom() * f2) + 0.5f));
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.setMarginStart((int) (marginLayoutParams.getMarginStart() * f2));
            marginLayoutParams.setMarginEnd((int) (marginLayoutParams.getMarginEnd() * f2));
            marginLayoutParams.leftMargin = (int) (marginLayoutParams.leftMargin * f2);
            marginLayoutParams.rightMargin = (int) (marginLayoutParams.rightMargin * f2);
            marginLayoutParams.topMargin = (int) (marginLayoutParams.topMargin * f2);
            marginLayoutParams.bottomMargin = (int) (marginLayoutParams.bottomMargin * f2);
        }
    }
}
