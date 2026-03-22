package com.zte.iptvclient.android.common.k;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import com.video.androidsdk.log.LogEx;

/* compiled from: DialogUtils.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4812a = "com.zte.iptvclient.android.common.k.j";

    /* compiled from: DialogUtils.java */
    /* loaded from: classes.dex */
    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f4813a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f4814b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f4815c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Window f4816d;
        final /* synthetic */ WindowManager.LayoutParams e;

        a(View view, View view2, boolean z, Window window, WindowManager.LayoutParams layoutParams) {
            this.f4813a = view;
            this.f4814b = view2;
            this.f4815c = z;
            this.f4816d = window;
            this.e = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[2];
            this.f4813a.getLocationOnScreen(iArr);
            int measuredWidth = this.f4813a.getMeasuredWidth();
            int measuredHeight = this.f4813a.getMeasuredHeight();
            int measuredWidth2 = this.f4814b.getMeasuredWidth();
            int measuredHeight2 = this.f4814b.getMeasuredHeight();
            int a2 = this.f4815c ? v.a() : 0;
            this.f4816d.setGravity(8388659);
            WindowManager.LayoutParams layoutParams = this.e;
            layoutParams.x = (iArr[0] + (measuredWidth / 2)) - (measuredWidth2 / 2);
            layoutParams.y = ((iArr[1] + (measuredHeight / 2)) - (measuredHeight2 / 2)) - a2;
            this.f4816d.setAttributes(layoutParams);
            this.f4814b.setVisibility(0);
            LogEx.d(j.f4812a, "x = " + iArr[0] + " y = " + iArr[1] + " width = " + measuredWidth + " height = " + measuredHeight);
            String str = j.f4812a;
            StringBuilder sb = new StringBuilder();
            sb.append("lp.x = ");
            sb.append(this.e.x);
            sb.append(" lp.y = ");
            sb.append(this.e.y);
            LogEx.d(str, sb.toString());
            LogEx.d(j.f4812a, "dialogWith = " + measuredWidth2 + " dialogHeight = " + measuredHeight2);
        }
    }

    public static void a(Dialog dialog, Fragment fragment, boolean z) {
        Window window = dialog.getWindow();
        if (window != null) {
            window.setFlags(8, 8);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                View view = fragment.getView();
                View decorView = window.getDecorView();
                decorView.setVisibility(4);
                decorView.post(new a(view, decorView, z, window, attributes));
            }
        }
    }
}
