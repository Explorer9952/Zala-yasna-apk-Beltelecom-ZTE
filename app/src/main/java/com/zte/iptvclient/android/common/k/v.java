package com.zte.iptvclient.android.common.k;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import com.facebook.appevents.codeless.internal.Constants;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;

/* compiled from: StatusBarCompat.java */
/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4832a = "v";

    static {
        Color.parseColor("#3192f6");
        Color.parseColor("#7898b9");
        Color.parseColor("#7898b9");
    }

    public static int a(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", Constants.PLATFORM);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static void a(Activity activity) {
        Window window;
        WindowManager.LayoutParams attributes;
        Window window2;
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            if (i >= 21) {
                if (activity != null && (window2 = activity.getWindow()) != null) {
                    window2.getDecorView().setSystemUiVisibility(1280);
                    window2.addFlags(Integer.MIN_VALUE);
                    window2.setStatusBarColor(0);
                }
            } else if (activity != null && (window = activity.getWindow()) != null && (attributes = window.getAttributes()) != null) {
                attributes.flags = 67108864 | attributes.flags;
                window.setAttributes(attributes);
            }
        }
        if (activity != null) {
            com.gyf.barlibrary.e c2 = com.gyf.barlibrary.e.c(activity);
            c2.a(false);
            c2.f();
        }
    }

    public static int a() {
        int i;
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            i = BaseApp.e().getApplicationContext().getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }
        LogEx.e(f4832a, "状态栏-方法2:" + i);
        return i;
    }
}
