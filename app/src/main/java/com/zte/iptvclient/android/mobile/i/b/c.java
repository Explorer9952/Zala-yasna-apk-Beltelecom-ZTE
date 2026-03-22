package com.zte.iptvclient.android.mobile.i.b;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.download.Linstener.OnSpaceReturnListener;
import com.video.androidsdk.download.Linstener.OnTaskOperReturnListener;
import com.video.androidsdk.download.Linstener.SDKDownloadReportListener;
import com.video.androidsdk.download.SDKDownloadMgr;
import com.video.androidsdk.download.bean.DownloadTask;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewpager.SlideViewPager;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.download.helper.b.a.a;
import com.zte.iptvclient.android.mobile.download.helper.c.c;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DownloadNewFragment.java */
/* loaded from: classes.dex */
public class c extends com.zte.fragmentlib.b implements SDKDownloadReportListener, c.f {
    private RelativeLayout A;
    private RelativeLayout B;
    private ImageView C;
    private ImageView D;
    private ImageView E;
    private SlideViewPager F;
    private FrameLayout G;
    private RelativeLayout J;
    private FrameLayout K;
    private FrameLayout L;
    private ProgressBar M;
    private ProgressBar N;
    private TextView O;
    private TextView P;
    private com.zte.iptvclient.android.mobile.download.helper.b.a.a Q;
    private ArrayList<Fragment> R;
    private ArrayList<DownloadTask> S;
    private com.zte.iptvclient.android.mobile.i.b.a T;
    private com.zte.iptvclient.android.mobile.i.b.e U;
    private com.zte.iptvclient.android.mobile.i.b.g V;
    private ProgressDialog a0;
    com.zte.iptvclient.android.common.j.h c0;
    private List<Map<String, String>> f0;
    private RelativeLayout p;
    private RelativeLayout q;
    private Button r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;
    public boolean W = false;
    private boolean X = false;
    private int Y = 0;
    private boolean Z = true;
    private String b0 = "";
    private long d0 = 0;
    private int e0 = 0;
    private Handler g0 = new j();
    private OnTaskOperReturnListener h0 = new i();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadNewFragment.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.X) {
                return;
            }
            c.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadNewFragment.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (System.currentTimeMillis() - c.this.d0 >= 200) {
                c.this.F.d(1);
                c.this.x.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_selected));
                ((com.zte.fragmentlib.b) c.this).h.a(c.this.x, "textColor", R.color.download_tag_title_selected);
                c.this.w.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_normal));
                ((com.zte.fragmentlib.b) c.this).h.a(c.this.w, "textColor", R.color.download_tag_title_normal);
                c.this.d0 = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadNewFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.i.b.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0278c implements View.OnClickListener {
        ViewOnClickListenerC0278c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (System.currentTimeMillis() - c.this.d0 >= 200) {
                c.this.F.d(0);
                c.this.w.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_selected));
                ((com.zte.fragmentlib.b) c.this).h.a(c.this.w, "textColor", R.color.download_tag_title_selected);
                c.this.x.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_normal));
                ((com.zte.fragmentlib.b) c.this).h.a(c.this.x, "textColor", R.color.download_tag_title_normal);
                c.this.d0 = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadNewFragment.java */
    /* loaded from: classes.dex */
    public class d implements a.d {
        d() {
        }

        @Override // com.zte.iptvclient.android.mobile.download.helper.b.a.a.d
        public void a() {
            c.this.Q.b();
            c.this.Z = true;
            c cVar = c.this;
            cVar.c(cVar.Z);
        }

        @Override // com.zte.iptvclient.android.mobile.download.helper.b.a.a.d
        public void b() {
            if (com.zte.iptvclient.android.mobile.h.a.a.g().b() == null) {
                c.this.P();
                return;
            }
            if (!com.zte.iptvclient.android.mobile.download.helper.c.c.b()) {
                c.this.R();
                return;
            }
            c.this.Q.a();
            c.this.Z = false;
            c cVar = c.this;
            cVar.c(cVar.Z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadNewFragment.java */
    /* loaded from: classes.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (((com.zte.fragmentlib.b) c.this).h instanceof MainActivity) {
                ((com.zte.fragmentlib.b) c.this).h.getSupportFragmentManager().F();
                ((MainActivity) ((com.zte.fragmentlib.b) c.this).h).y();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadNewFragment.java */
    /* loaded from: classes.dex */
    public class f implements DialogInterface.OnClickListener {
        f(c cVar) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadNewFragment.java */
    /* loaded from: classes.dex */
    public class g implements t.e {
        g() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void a() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void b() {
            c.this.X = true;
            c cVar = c.this;
            cVar.b((ArrayList<DownloadTask>) cVar.S);
            ((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(c.this.F.c())).d(false);
            c.this.b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadNewFragment.java */
    /* loaded from: classes.dex */
    public class h implements OnSpaceReturnListener {

        /* compiled from: DownloadNewFragment.java */
        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f6499a;

            a(String str) {
                this.f6499a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.O.setText(this.f6499a);
                c.this.P.setText(this.f6499a);
            }
        }

        h() {
        }

        @Override // com.video.androidsdk.download.Linstener.OnSpaceReturnListener
        public void onSpaceReturn(String str, String str2, HashMap<String, String> hashMap) {
            LogEx.d("DownloadNewFragment", "s = " + str + ", s1 = " + str2 + ", map = " + hashMap);
            try {
                String str3 = hashMap.get(DownloadConstant.GETSPACE_RESULT_MAP_KEY_TOTALSPACE);
                LogEx.d("DownloadNewFragment", "totalSize = " + str3 + ", freeSize = " + hashMap.get(DownloadConstant.GETSPACE_RESULT_MAP_KEY_FREESPACE));
                ((com.zte.fragmentlib.b) c.this).h.runOnUiThread(new a(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_filter_stb) + "：   " + com.zte.iptvclient.android.common.i.a.a.a(R.string.storge_space_total) + com.zte.iptvclient.android.mobile.download.helper.c.b.a((long) Integer.valueOf(str3).intValue()) + "/" + com.zte.iptvclient.android.common.i.a.a.a(R.string.storge_space_left) + com.zte.iptvclient.android.mobile.download.helper.c.b.a(Integer.valueOf(r6).intValue())));
            } catch (Exception e) {
                LogEx.e("DownloadNewFragment", "Get HC100 storage size error.");
                e.printStackTrace();
            }
        }
    }

    /* compiled from: DownloadNewFragment.java */
    /* loaded from: classes.dex */
    class i implements OnTaskOperReturnListener {
        i() {
        }

        @Override // com.video.androidsdk.download.Linstener.OnTaskOperReturnListener
        public void onTaskOperReturn(String str, String str2, String str3) {
            LogEx.d("DownloadNewFragment", " strErrorCode = " + str + " strErrorMsg = " + str2 + " strResposeInfo = " + str3);
            c.this.g0.sendEmptyMessage(12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadNewFragment.java */
    /* loaded from: classes.dex */
    public class j extends Handler {
        j() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 11) {
                ((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(0)).d(11);
                ((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(1)).d(11);
                return;
            }
            if (i == 12) {
                c.this.K();
                c.this.X = false;
                c.this.f(0);
                c cVar = c.this;
                cVar.d(cVar.Z);
                c.this.e(false);
                ((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(c.this.F.c())).d(12);
                return;
            }
            if (i == 16) {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(String.valueOf(message.obj));
                ((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(0)).d(11);
                ((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(1)).d(11);
            } else {
                if (i != 17) {
                    return;
                }
                Fragment fragment = (Fragment) c.this.R.get(1);
                if (fragment instanceof com.zte.iptvclient.android.mobile.i.b.g) {
                    ((com.zte.iptvclient.android.mobile.i.b.g) fragment).a(c.this.f0);
                }
            }
        }
    }

    /* compiled from: DownloadNewFragment.java */
    /* loaded from: classes.dex */
    class k implements com.zte.fragmentlib.helper.c {

        /* compiled from: DownloadNewFragment.java */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if ("1".equals(ConfigMgr.readPropertie("isShow"))) {
                    if (c.this.T != null) {
                        c.this.T.O();
                    }
                } else if (c.this.U != null) {
                    c.this.U.O();
                }
            }
        }

        k() {
        }

        @Override // com.zte.fragmentlib.helper.c
        public void a() {
            new Handler().postDelayed(new a(), 10L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadNewFragment.java */
    /* loaded from: classes.dex */
    public class l implements ViewTreeObserver.OnGlobalLayoutListener {
        l() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            c.this.A.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            c.this.E.setScaleX((c.this.A.getWidth() * 1.0f) / c.this.E.getWidth());
            c.this.E.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadNewFragment.java */
    /* loaded from: classes.dex */
    public class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.getActivity() instanceof MainActivity) {
                c.this.F();
            } else if (c.this.getActivity() instanceof HostActivity) {
                c.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadNewFragment.java */
    /* loaded from: classes.dex */
    public class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(c.this.F.c())).L() == null || ((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(c.this.F.c())).L().size() == 0) {
                return;
            }
            c.this.e(true);
            c.this.b(false);
            for (int i = 0; i < c.this.R.size(); i++) {
                ((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(i)).d(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadNewFragment.java */
    /* loaded from: classes.dex */
    public class o implements View.OnClickListener {
        o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(c.this.F.c())).L() == null || ((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(c.this.F.c())).L().size() == 0) {
                return;
            }
            c.this.e(true);
            c.this.b(false);
            for (int i = 0; i < c.this.R.size(); i++) {
                ((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(i)).d(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadNewFragment.java */
    /* loaded from: classes.dex */
    public class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.Q.a(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadNewFragment.java */
    /* loaded from: classes.dex */
    public class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.e(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadNewFragment.java */
    /* loaded from: classes.dex */
    public class r implements View.OnClickListener {
        r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(c.this.F.c())).L() == null || ((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(c.this.F.c())).L().size() == 0) {
                return;
            }
            if (((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(c.this.F.c())).J()) {
                c.this.b(false);
                ((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(c.this.F.c())).d(false);
                ((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(c.this.F.c())).I();
            } else {
                c.this.b(true);
                ((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(c.this.F.c())).d(true);
                ((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(c.this.F.c())).M();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DownloadNewFragment.java */
    /* loaded from: classes.dex */
    public static class s extends androidx.fragment.app.n {
        ArrayList<Fragment> h;

        /* synthetic */ s(FragmentManager fragmentManager, ArrayList arrayList, j jVar) {
            this(fragmentManager, arrayList);
        }

        @Override // androidx.viewpager.widget.a
        public int a() {
            return this.h.size();
        }

        @Override // androidx.fragment.app.n
        public Fragment c(int i) {
            return this.h.get(i);
        }

        private s(FragmentManager fragmentManager, ArrayList<Fragment> arrayList) {
            super(fragmentManager);
            this.h = arrayList;
        }

        @Override // androidx.fragment.app.n, androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i, Object obj) {
            super.a(viewGroup, i, obj);
        }

        @Override // androidx.fragment.app.n, androidx.viewpager.widget.a
        public Object a(ViewGroup viewGroup, int i) {
            return super.a(viewGroup, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DownloadNewFragment.java */
    /* loaded from: classes.dex */
    public class t implements ViewPager.i {
        private t() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i, float f, int i2) {
            float width = (c.this.A.getWidth() * i * (1.0f - f)) + (c.this.A.getWidth() * (i + 1) * f);
            c.this.E.setTranslationX(width);
            c.this.E.setScaleX((c.this.A.getWidth() * 1.0f) / c.this.E.getWidth());
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void b(int i) {
            c.this.e(i);
            if (i == 0) {
                c.this.w.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_selected));
                ((com.zte.fragmentlib.b) c.this).h.a(c.this.w, "textColor", R.color.download_tag_title_selected);
                c.this.x.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_normal));
                ((com.zte.fragmentlib.b) c.this).h.a(c.this.x, "textColor", R.color.download_tag_title_normal);
            } else {
                c.this.x.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_selected));
                ((com.zte.fragmentlib.b) c.this).h.a(c.this.x, "textColor", R.color.download_tag_title_selected);
                c.this.w.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_normal));
                ((com.zte.fragmentlib.b) c.this).h.a(c.this.w, "textColor", R.color.download_tag_title_normal);
            }
            c cVar = c.this;
            if (cVar.W) {
                ((com.zte.iptvclient.android.mobile.i.b.b) cVar.R.get(i)).N();
                if (((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(c.this.F.c())).J()) {
                    c.this.b(true);
                } else {
                    c.this.b(false);
                }
            }
            if (c.this.Z) {
                return;
            }
            if (com.zte.iptvclient.android.mobile.h.a.a.g().b() == null) {
                c.this.P();
            } else if (!com.zte.iptvclient.android.mobile.download.helper.c.c.b()) {
                c.this.R();
            } else {
                ((com.zte.iptvclient.android.mobile.i.b.b) c.this.R.get(i)).c(c.this.Z);
            }
        }

        /* synthetic */ t(c cVar, j jVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DownloadNewFragment.java */
    /* loaded from: classes.dex */
    public class u extends AsyncTask<String, String, String> {
        private u() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            return c.this.N();
        }

        /* synthetic */ u(c cVar, j jVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            if (((com.zte.fragmentlib.b) c.this).h == null) {
                return;
            }
            c.this.O.setText(str);
            c.this.P.setText(str);
            c.this.M.setProgress(c.this.e0);
            c.this.N.setProgress(c.this.e0);
            super.onPostExecute(str);
        }
    }

    private void L() {
        this.S = ((com.zte.iptvclient.android.mobile.i.b.b) this.R.get(this.F.c())).K();
    }

    private void M() {
        if (this.h == null) {
            this.e0 = 0;
            this.O.setText(this.b0);
            this.P.setText(this.b0);
            this.M.setProgress(this.e0);
            this.N.setProgress(this.e0);
            return;
        }
        SDKDownloadMgr.getInstance().getSpace(2, "", new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String N() {
        String d2;
        String f2;
        String h2;
        if (this.h == null) {
            return this.b0;
        }
        int k2 = com.zte.iptvclient.android.mobile.download.helper.a.n().k();
        if (k2 == 0) {
            d2 = com.zte.iptvclient.android.mobile.download.helper.c.b.d();
            f2 = com.zte.iptvclient.android.mobile.download.helper.c.b.f();
            h2 = com.zte.iptvclient.android.mobile.download.helper.c.b.h();
        } else if (k2 != 1) {
            d2 = com.zte.iptvclient.android.mobile.download.helper.c.b.l();
            f2 = com.zte.iptvclient.android.mobile.download.helper.c.b.m();
            h2 = com.zte.iptvclient.android.mobile.download.helper.c.b.n();
        } else {
            d2 = com.zte.iptvclient.android.mobile.download.helper.c.b.l();
            f2 = com.zte.iptvclient.android.mobile.download.helper.c.b.m();
            h2 = com.zte.iptvclient.android.mobile.download.helper.c.b.n();
        }
        if (this.h == null) {
            return this.b0;
        }
        if (!StringUtil.isEmptyString(f2) && !StringUtil.isEmptyString(d2)) {
            this.e0 = 100 - Math.round(((Float.valueOf(d2.substring(0, d2.length() - 2)).floatValue() * 1000.0f) * 100.0f) / (Float.valueOf(f2.substring(0, f2.length() - 2)).floatValue() * 1000.0f));
        }
        return com.zte.iptvclient.android.common.i.a.a.a(R.string.phone_storage) + h2 + ", " + com.zte.iptvclient.android.common.i.a.a.a(R.string.storge_space_left) + d2 + ", " + com.zte.iptvclient.android.common.i.a.a.a(R.string.storge_space_total) + f2;
    }

    private void O() {
        this.A.getViewTreeObserver().addOnGlobalLayoutListener(new l());
        j jVar = null;
        this.F.a(new s(getChildFragmentManager(), this.R, jVar));
        this.F.d(0);
        this.w.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_selected));
        this.h.a(this.w, "textColor", R.color.download_tag_title_selected);
        this.x.setTextColor(c.a.a.a.d.b.d().b(R.color.download_tag_title_normal));
        this.h.a(this.x, "textColor", R.color.download_tag_title_normal);
        this.F.a(new t(this, jVar));
        this.Q = new com.zte.iptvclient.android.mobile.download.helper.b.a.a(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        com.zte.iptvclient.android.common.customview.a.a.a.a aVar = new com.zte.iptvclient.android.common.customview.a.a.a.a(getActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setTitle(R.string.not_connected_stb);
        aVar.a(R.string.connect_hc100_stb_prompt);
        aVar.b(R.string.confirm, new e());
        aVar.a(R.string.common_cancel, null);
        aVar.show();
    }

    private void Q() {
        this.r.setOnClickListener(new m());
        this.s.setOnClickListener(new n());
        this.C.setOnClickListener(new o());
        this.D.setOnClickListener(new p());
        this.u.setOnClickListener(new q());
        this.t.setOnClickListener(new r());
        this.G.setOnClickListener(new a());
        this.A.setOnClickListener(new b());
        this.B.setOnClickListener(new ViewOnClickListenerC0278c());
        this.Q.a(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        com.zte.iptvclient.android.common.customview.a.a.a.a aVar = new com.zte.iptvclient.android.common.customview.a.a.a.a(getActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setTitle(R.string.stb_login_failed_title);
        aVar.a(R.string.stb_login_failed_info);
        aVar.b(R.string.confirm, new f(this));
        aVar.show();
    }

    private void S() {
        this.p.setVisibility(8);
        this.q.setVisibility(0);
        this.J.setVisibility(8);
        f(0);
        for (int i2 = 0; i2 < this.F.getChildCount(); i2++) {
            ((com.zte.iptvclient.android.mobile.i.b.b) this.R.get(i2)).e(true);
        }
    }

    private void T() {
        this.p.setVisibility(0);
        this.q.setVisibility(8);
        this.J.setVisibility(0);
        this.G.setVisibility(8);
        for (int i2 = 0; i2 < this.F.getChildCount(); i2++) {
            ((com.zte.iptvclient.android.mobile.i.b.b) this.R.get(i2)).e(false);
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        O();
        Q();
        a(new k());
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 3) {
            this.Z = false;
        } else {
            this.Z = true;
        }
        this.R = new ArrayList<>();
        if ("1".equals(ConfigMgr.readPropertie("isShow"))) {
            com.zte.iptvclient.android.mobile.i.b.a aVar = new com.zte.iptvclient.android.mobile.i.b.a();
            this.T = aVar;
            aVar.a(this);
            this.R.add(this.T);
        } else {
            com.zte.iptvclient.android.mobile.i.b.e eVar = new com.zte.iptvclient.android.mobile.i.b.e();
            this.U = eVar;
            eVar.a(this);
            this.R.add(this.U);
        }
        com.zte.iptvclient.android.mobile.i.b.g gVar = new com.zte.iptvclient.android.mobile.i.b.g();
        this.V = gVar;
        gVar.a(this);
        this.R.add(this.V);
        this.c0 = new com.zte.iptvclient.android.common.j.h(this.h);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.download_new_fragment_main, (ViewGroup) null);
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        SDKDownloadMgr.getInstance().setSDKDownloadReportListener(null);
        com.zte.iptvclient.android.mobile.download.helper.c.c.a((c.f) null);
        if (com.zte.iptvclient.android.mobile.download.helper.a.n().l().booleanValue()) {
            LogEx.d("DownloadNewFragment", "In offline mode, DownloadMainActivity destory");
            if (!com.zte.iptvclient.android.mobile.download.helper.a.n().m().booleanValue()) {
                LogEx.d("DownloadNewFragment", "Begin to destory proxy");
                SDKDownloadMgr.getInstance().uninit();
                com.zte.iptvclient.android.mobile.download.helper.c.c.d(this.h.getApplicationContext());
            } else {
                LogEx.d("DownloadNewFragment", "To play, not need to destory proxy");
            }
        } else {
            LogEx.d("DownloadNewFragment", "In online mode, DownloadMainActivity destory");
        }
        super.onDestroy();
    }

    @Override // com.video.androidsdk.download.Linstener.SDKDownloadReportListener
    public void onDownloadReport(String str, String str2, String str3, String str4, List<Map<String, String>> list) {
        LogEx.d("DownloadNewFragment", "onDownloadReport msgType = " + str + ", strErrorCode = " + str2 + ", strErrorMsg = " + str3 + ", downLoadType = " + str4 + ", list = " + list);
        int intValue = Integer.valueOf(str).intValue();
        if (intValue != 4) {
            if (intValue == 9) {
                this.f0 = list;
                this.g0.sendEmptyMessage(17);
                return;
            } else {
                this.g0.sendEmptyMessage(11);
                return;
            }
        }
        Message obtain = Message.obtain();
        obtain.what = 16;
        if ("600006001".equals(str2)) {
            obtain.obj = com.zte.iptvclient.android.common.i.a.a.a(R.string.storage_not_enough_prompt_msg);
            SDKDownloadMgr.getInstance().pauseALL(1, null);
        } else {
            obtain.obj = com.zte.iptvclient.android.common.i.a.a.a(R.string.download_fail_toast) + "(" + str2 + ")";
        }
        this.g0.sendMessage(obtain);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
        if ("1".equals(ConfigMgr.readPropertie("isShow"))) {
            com.zte.iptvclient.android.mobile.i.b.a aVar = this.T;
            if (aVar != null) {
                aVar.O();
                return;
            }
            return;
        }
        com.zte.iptvclient.android.mobile.i.b.e eVar = this.U;
        if (eVar != null) {
            eVar.O();
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.b0 = getString(R.string.download_setting_path_size_default);
        SDKDownloadMgr.getInstance().setSDKDownloadReportListener(this);
        com.zte.iptvclient.android.mobile.download.helper.c.c.a(this);
        d(this.Z);
        if (!com.zte.iptvclient.android.mobile.download.helper.a.n().l().booleanValue()) {
            if (this.c0.b0().booleanValue()) {
                LogEx.d("DownloadNewFragment", "Online Mode,Guese Login");
                J();
                return;
            } else {
                LogEx.d("DownloadNewFragment", "Online Mode,Begin to update order info");
                return;
            }
        }
        LogEx.d("DownloadNewFragment", "Offline Mode");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        ProgressDialog progressDialog = this.a0;
        if (progressDialog == null) {
            LogEx.d("DownloadNewFragment", "Waiting Dialog is null");
        } else if (progressDialog.isShowing()) {
            this.a0.cancel();
            LogEx.d("DownloadNewFragment", "Cancel Waiting Dialog");
        }
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        if (getActivity() instanceof MainActivity) {
            F();
            return true;
        }
        if (!(getActivity() instanceof HostActivity)) {
            return true;
        }
        getActivity().finish();
        return true;
    }

    protected void I() {
        String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_delete_items);
        L();
        int size = this.S.size();
        this.Y = size;
        if (size == 0) {
            return;
        }
        if (size == 1) {
            a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_delete_item);
        }
        com.zte.iptvclient.android.common.k.t.a(this.h, a2, new g());
    }

    public void J() {
        LogEx.d("DownloadNewFragment", "updateOrderInfo");
    }

    public void f(int i2) {
        this.v.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_select_num), Integer.valueOf(i2)));
        if (i2 > 0) {
            this.G.setVisibility(0);
            this.J.setVisibility(8);
            if (i2 > 1) {
                this.v.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_select_nums), Integer.valueOf(i2)));
                return;
            }
            return;
        }
        this.G.setVisibility(8);
        this.J.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        this.X = false;
        f(0);
        ((com.zte.iptvclient.android.mobile.i.b.b) this.R.get(this.F.c())).c(z);
        this.O.setText(this.b0);
        this.P.setText(this.b0);
        this.e0 = 0;
        this.M.setProgress(0);
        this.N.setProgress(this.e0);
        d(z);
        e(false);
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.p = (RelativeLayout) view.findViewById(R.id.title_rlayout);
        this.q = (RelativeLayout) view.findViewById(R.id.edit_rlayout);
        Button button = (Button) view.findViewById(R.id.btn_back);
        this.r = button;
        if (this.o) {
            button.setVisibility(0);
        }
        this.s = (TextView) view.findViewById(R.id.edit_txt);
        this.w = (TextView) view.findViewById(R.id.tag_title01);
        this.x = (TextView) view.findViewById(R.id.tag_title02);
        this.C = (ImageView) view.findViewById(R.id.edit_ivew);
        this.D = (ImageView) view.findViewById(R.id.filter_ivew);
        this.t = (TextView) view.findViewById(R.id.txt_selected_all);
        this.u = (TextView) view.findViewById(R.id.txt_cancel);
        this.v = (TextView) view.findViewById(R.id.txt_selected_num);
        this.A = (RelativeLayout) view.findViewById(R.id.rl_downloading);
        this.B = (RelativeLayout) view.findViewById(R.id.rl_downloaded);
        this.E = (ImageView) view.findViewById(R.id.cursor);
        this.F = (SlideViewPager) view.findViewById(R.id.viewpager);
        this.J = (RelativeLayout) view.findViewById(R.id.rl_download_storage_bar);
        this.K = (FrameLayout) view.findViewById(R.id.download_storage_bar_light);
        this.O = (TextView) view.findViewById(R.id.download_main_space_light);
        this.M = (ProgressBar) view.findViewById(R.id.download_local_storage_progressbar_light);
        this.L = (FrameLayout) view.findViewById(R.id.download_storage_bar_dark);
        this.P = (TextView) view.findViewById(R.id.download_main_space_dark);
        this.N = (ProgressBar) view.findViewById(R.id.download_local_storage_progressbar_dark);
        this.G = (FrameLayout) view.findViewById(R.id.fl_delete);
        ImageView imageView = (ImageView) view.findViewById(R.id.title_bottom_line);
        this.y = (TextView) view.findViewById(R.id.title_txt);
        this.z = (TextView) view.findViewById(R.id.txt_delete);
        this.y.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_cache));
        this.w.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_tag_downloaded));
        this.x.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_tag_downloading));
        this.P.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_size_default));
        this.z.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.delete));
        this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.edit));
        this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
        this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_select_num));
        this.u.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel));
        this.O.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_size_default));
        if ("1".equals(ConfigMgr.readPropertie("IsShowEditIconOrText", "0"))) {
            this.s.setVisibility(8);
            this.C.setVisibility(0);
        }
        if ("1".equals(ConfigMgr.readPropertie("SupportRemoteDownload", "0"))) {
            this.D.setVisibility(0);
        }
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        com.zte.iptvclient.common.uiframe.f.a(this.D);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        com.zte.iptvclient.common.uiframe.f.a(this.E);
        com.zte.iptvclient.common.uiframe.f.a(this.F);
        com.zte.iptvclient.common.uiframe.f.a(this.J);
        com.zte.iptvclient.common.uiframe.f.a(this.K);
        com.zte.iptvclient.common.uiframe.f.a(this.O);
        com.zte.iptvclient.common.uiframe.f.a(this.M);
        com.zte.iptvclient.common.uiframe.f.a(this.L);
        com.zte.iptvclient.common.uiframe.f.a(this.P);
        com.zte.iptvclient.common.uiframe.f.a(this.N);
        com.zte.iptvclient.common.uiframe.f.a(this.G);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_txt));
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.line_1));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_tag));
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.A.findViewById(R.id.bottom_line02));
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.B.findViewById(R.id.bottom_line01));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_delete));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_delete));
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        if (TextUtils.equals(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b, "white.skin")) {
            this.K.setVisibility(0);
            this.L.setVisibility(8);
        } else {
            this.K.setVisibility(8);
            this.L.setVisibility(0);
        }
        if (BaseApp.a(this.h)) {
            com.zte.iptvclient.android.common.k.g.a(imageView, this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z) {
        this.W = z;
        if (z) {
            S();
        } else {
            T();
        }
    }

    public void b(boolean z) {
        if (z) {
            this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_null));
        } else {
            this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<DownloadTask> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if ("10".equals(((DownloadTask) arrayList2.get(i2)).contentType)) {
                ((DownloadTask) arrayList2.get(i2)).videoId = "";
            }
        }
        if (this.Z) {
            SDKDownloadMgr.getInstance().removeTask(arrayList2, 1, this.h0);
        } else {
            SDKDownloadMgr.getInstance().removeTask(arrayList2, 2, this.h0);
        }
    }

    public void e(int i2) {
        if (i2 == 0) {
            if ("1".equals(ConfigMgr.readPropertie("isShow"))) {
                if (this.T.P()) {
                    this.s.setVisibility(8);
                    return;
                } else {
                    this.s.setVisibility(0);
                    return;
                }
            }
            if (this.U.P()) {
                this.s.setVisibility(8);
                return;
            } else {
                this.s.setVisibility(0);
                return;
            }
        }
        if (this.V.O()) {
            this.s.setVisibility(8);
        } else {
            this.s.setVisibility(0);
        }
    }

    @Override // com.zte.iptvclient.android.mobile.download.helper.c.c.f
    public void f() {
        this.g0.sendEmptyMessage(11);
    }

    public void d(int i2) {
        if (this.F.c() == i2) {
            e(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        LogEx.d("DownloadNewFragment", "refresh storage info");
        if (z) {
            new u(this, null).execute(new String[0]);
        } else {
            M();
        }
    }

    public void d(DownloadTask downloadTask) {
        com.zte.iptvclient.android.mobile.i.b.f fVar = new com.zte.iptvclient.android.mobile.i.b.f();
        Bundle bundle = new Bundle();
        bundle.putString("headId", downloadTask.seriesProgramCode);
        bundle.putString("headName", downloadTask.videoInfo.get("seriesHeadName"));
        bundle.putBoolean("isFilterLocal", this.Z);
        fVar.setArguments(bundle);
        if (BaseApp.a(this.h)) {
            a(fVar);
            return;
        }
        Intent intent = new Intent(getActivity(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "download_series");
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
