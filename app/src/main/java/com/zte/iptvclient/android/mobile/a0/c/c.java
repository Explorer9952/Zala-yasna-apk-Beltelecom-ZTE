package com.zte.iptvclient.android.mobile.a0.c;

import android.os.Build;
import android.view.View;

/* compiled from: ViewUtil.java */
/* loaded from: classes2.dex */
public class c {
    public static float a(View view) {
        if (Build.VERSION.SDK_INT >= 11) {
            return view.getX();
        }
        return view.getLeft() + view.getTranslationX();
    }

    public static float b(View view) {
        if (Build.VERSION.SDK_INT >= 11) {
            return view.getY();
        }
        return view.getTop() + view.getTranslationY();
    }
}
