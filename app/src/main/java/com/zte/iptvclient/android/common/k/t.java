package com.zte.iptvclient.android.common.k;

import android.content.Context;
import com.zte.iptvclient.android.common.customview.a.a.e.f;
import com.zte.iptvclient.android.zala.R;

/* compiled from: ShowDialog.java */
/* loaded from: classes.dex */
public class t {

    /* compiled from: ShowDialog.java */
    /* loaded from: classes.dex */
    static class a implements f.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f4829a;

        a(e eVar) {
            this.f4829a = eVar;
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void a() {
            e eVar = this.f4829a;
            if (eVar != null) {
                eVar.b();
            }
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void b() {
            e eVar = this.f4829a;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    /* compiled from: ShowDialog.java */
    /* loaded from: classes.dex */
    static class b implements f.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f4830a;

        b(e eVar) {
            this.f4830a = eVar;
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void a() {
            e eVar = this.f4830a;
            if (eVar != null) {
                eVar.b();
            }
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void b() {
            e eVar = this.f4830a;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    /* compiled from: ShowDialog.java */
    /* loaded from: classes.dex */
    static class c implements f.c {
        c() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void a() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void b() {
        }
    }

    /* compiled from: ShowDialog.java */
    /* loaded from: classes.dex */
    public interface d {
        void onDismiss();
    }

    /* compiled from: ShowDialog.java */
    /* loaded from: classes.dex */
    public interface e {
        void a();

        void b();
    }

    public static boolean a(Context context, boolean z) {
        new com.zte.iptvclient.android.common.customview.a.a.c.a(context, R.style.dialog_order).show();
        return z;
    }

    public static void a(Context context, d dVar) {
        new com.zte.iptvclient.android.common.customview.a.a.c.a(context, R.style.dialog_order, dVar).show();
    }

    public static void a(Context context, String str, e eVar) {
        com.zte.iptvclient.android.common.customview.a.a.e.f fVar = new com.zte.iptvclient.android.common.customview.a.a.e.f(context, R.drawable.custom_dialog_outlogin_img, 0, R.drawable.lock_dialog_rightbg, R.string.common_ok, 0, R.drawable.lock_dialog_leftbg, R.string.common_cancel, 0, new a(eVar));
        fVar.a(str);
        fVar.a();
        fVar.setCanceledOnTouchOutside(false);
    }

    public static void a(Context context, String str, int i, int i2, e eVar) {
        com.zte.iptvclient.android.common.customview.a.a.e.f fVar = new com.zte.iptvclient.android.common.customview.a.a.e.f(context, R.drawable.custom_dialog_title_img, 0, R.drawable.login_btn_bg, i, 0, R.drawable.login_btn_bg, i2, 0, new b(eVar));
        fVar.a(str);
        fVar.a();
        fVar.setCanceledOnTouchOutside(false);
    }

    public static void a(Context context) {
        com.zte.iptvclient.android.common.customview.a.a.e.f fVar = new com.zte.iptvclient.android.common.customview.a.a.e.f(context, R.drawable.custom_dialog_title_img, 0, R.drawable.login_btn_bg, R.string.common_ok, 0, 0, 0, 0, new c());
        fVar.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.in_construction));
        fVar.a();
        fVar.setCanceledOnTouchOutside(false);
    }
}
