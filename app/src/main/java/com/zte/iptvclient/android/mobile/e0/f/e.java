package com.zte.iptvclient.android.mobile.e0.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.k.r;
import com.zte.iptvclient.android.zala.R;

/* compiled from: ToastHelper.java */
/* loaded from: classes2.dex */
public class e {
    private static void a(String str, float f) {
        Context applicationContext = BaseApp.e().getApplicationContext();
        Toast makeText = Toast.makeText(applicationContext, str, 0);
        View inflate = LayoutInflater.from(applicationContext).inflate(R.layout.toast_star_opr_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.textview);
        a(applicationContext, textView, f);
        com.zte.iptvclient.common.uiframe.f.a(textView);
        textView.setText(str);
        makeText.setGravity(80, 0, 0);
        makeText.setView(inflate);
        makeText.show();
    }

    public static void b(String str) {
        if (BaseApp.f()) {
            a(str, 0.3125f);
        } else {
            a(str, 0.8333f);
        }
    }

    private static void a(Context context, TextView textView, float f) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        if (layoutParams != null) {
            int a2 = r.a(context);
            LogEx.d("ToastHelper", "deviceScreenWidth: " + a2);
            LogEx.d("ToastHelper", "firstly lp.width: " + layoutParams.width);
            layoutParams.width = (int) (((float) a2) * f);
            LogEx.d("ToastHelper", "later lp.width: " + layoutParams.width);
            textView.setLayoutParams(layoutParams);
        }
    }

    public static void a(String str) {
        Context applicationContext = BaseApp.e().getApplicationContext();
        Toast makeText = Toast.makeText(applicationContext, str, 0);
        View inflate = LayoutInflater.from(applicationContext).inflate(R.layout.toast_wrap_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.textview);
        com.zte.iptvclient.common.uiframe.f.a(textView);
        textView.setText(str);
        makeText.setGravity(80, 0, 0);
        makeText.setView(inflate);
        makeText.show();
    }
}
