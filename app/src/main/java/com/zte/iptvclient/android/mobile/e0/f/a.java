package com.zte.iptvclient.android.mobile.e0.f;

import android.app.Activity;
import android.view.View;
import com.zte.iptvclient.android.common.k.t;
import org.greenrobot.eventbus.EventBus;

/* compiled from: BarOperatorHelper.java */
/* loaded from: classes2.dex */
public class a {

    /* compiled from: BarOperatorHelper.java */
    /* renamed from: com.zte.iptvclient.android.mobile.e0.f.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0243a implements t.d {
        C0243a() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.d
        public void onDismiss() {
            EventBus.getDefault().post(new com.zte.iptvclient.android.mobile.e0.a(true));
        }
    }

    public static boolean a(Activity activity, View view) {
        if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
            return false;
        }
        t.a(activity, new C0243a());
        return true;
    }
}
