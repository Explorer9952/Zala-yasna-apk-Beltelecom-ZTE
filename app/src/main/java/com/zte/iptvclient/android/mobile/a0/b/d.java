package com.zte.iptvclient.android.mobile.a0.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.channel.SDKChannelMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.prevue.SDKPrevueMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.e.x.q;
import com.zte.iptvclient.android.common.f.b.a;
import com.zte.iptvclient.android.common.f.b.b;
import com.zte.iptvclient.android.common.javabean.column.ColumnBean;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.k.s;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.common.player.k.a;
import com.zte.iptvclient.android.common.player.k.b;
import com.zte.iptvclient.android.common.player.k.c;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.home.tab.helper.TabHostManager;
import com.zte.iptvclient.android.mobile.login.activity.LoginActivity;
import com.zte.iptvclient.android.mobile.tv.ui.TVScheduleProgramesView;
import com.zte.iptvclient.android.mobile.tv.ui.b;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.video.ContentType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TvChildFragmentHD.java */
/* loaded from: classes.dex */
public class d extends com.zte.fragmentlib.b implements c.o0, a.i, b.e, b.a0, a.h, c.n0 {
    public static String X = "";
    private View B;
    private ArrayList<com.zte.iptvclient.android.common.javabean.models.d> D;
    private ArrayList<com.zte.iptvclient.android.common.javabean.models.c> E;
    private com.zte.iptvclient.android.common.f.b.b G;
    private Channel J;
    private ColumnBean K;
    private RelativeLayout N;
    private View O;
    private View P;
    private int Q;
    private com.zte.iptvclient.android.common.f.b.a S;
    private PrevueBean T;
    private ImageView W;
    public TextView q;
    private FrameLayout r;
    private FrameLayout s;
    private RelativeLayout t;
    private com.zte.iptvclient.android.common.player.k.c u;
    private TVScheduleProgramesView v;
    private com.zte.iptvclient.android.mobile.tv.ui.b w;
    private com.zte.iptvclient.android.mobile.e0.e.l x;
    private String p = "TvFragmentHD";
    private int y = 0;
    private int z = 0;
    private com.zte.iptvclient.android.common.player.f A = null;
    public boolean C = false;
    private long F = 0;
    private int L = 0;
    private int M = 0;
    private boolean R = false;
    private String U = "";
    private String V = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChildFragmentHD.java */
    /* loaded from: classes2.dex */
    public class a implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.player.j.i f5392a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bundle f5393b;

        /* compiled from: TvChildFragmentHD.java */
        /* renamed from: com.zte.iptvclient.android.mobile.a0.b.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0177a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f5395a;

            RunnableC0177a(String str) {
                this.f5395a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.u.d3();
                d.this.u.a2();
                d.this.u.K(this.f5395a);
                d.this.u.E();
                d.this.u.D2();
            }
        }

        /* compiled from: TvChildFragmentHD.java */
        /* loaded from: classes2.dex */
        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f5397a;

            b(String str) {
                this.f5397a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.u.d3();
                d.this.u.I(this.f5397a);
                d.this.u.E();
                d.this.u.D2();
            }
        }

        /* compiled from: TvChildFragmentHD.java */
        /* loaded from: classes2.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LogEx.d(d.this.p, "Test the starting speed : queryTvBlackout back");
                d.this.u.d3();
                d.this.u.Z1();
                d.this.u.f0();
                com.zte.iptvclient.android.common.player.f fVar = d.this.A;
                a aVar = a.this;
                fVar.a(aVar.f5392a, aVar.f5393b, ((com.zte.fragmentlib.b) d.this).h, d.this.getChildFragmentManager(), d.this.t.getId(), d.this.u);
            }
        }

        /* compiled from: TvChildFragmentHD.java */
        /* renamed from: com.zte.iptvclient.android.mobile.a0.b.d$a$d, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0178d implements Runnable {
            RunnableC0178d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.u.d3();
                d.this.u.a2();
                d.this.u.H2();
                d.this.u.E();
                d.this.u.D2();
            }
        }

        a(com.zte.iptvclient.android.common.player.j.i iVar, Bundle bundle) {
            this.f5392a = iVar;
            this.f5393b = bundle;
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void j() {
            ((com.zte.fragmentlib.b) d.this).h.runOnUiThread(new c());
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void k(String str) {
            LogEx.d(d.this.p, "tv blackout查询展示black照片:" + str);
            ((com.zte.fragmentlib.b) d.this).h.runOnUiThread(new RunnableC0177a(str));
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void l() {
            LogEx.d(d.this.p, "get Detail BlackoutInfo is null （pic url or play url is null）");
            ((com.zte.fragmentlib.b) d.this).h.runOnUiThread(new RunnableC0178d());
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void r(String str) {
            LogEx.d(d.this.p, "tv blackout查询播放black片源" + str);
            ((com.zte.fragmentlib.b) d.this).h.runOnUiThread(new b(str));
        }
    }

    /* compiled from: TvChildFragmentHD.java */
    /* loaded from: classes2.dex */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            d.this.r.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            d dVar = d.this;
            dVar.y = dVar.r.getHeight();
            d dVar2 = d.this;
            dVar2.z = dVar2.r.getWidth();
            LogEx.d(d.this.p, "mPlayerDefaultHeight=" + d.this.y + " mPlayerDefaultWidth=" + d.this.z);
            if (((com.zte.fragmentlib.b) d.this).h != null) {
                ((MainActivity) ((com.zte.fragmentlib.b) d.this).h).c(d.this.z, d.this.y);
                ((MainActivity) ((com.zte.fragmentlib.b) d.this).h).b(d.this.M, d.this.L);
            }
            LogEx.d(d.this.p, "movePlayer=" + d.this.L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChildFragmentHD.java */
    /* loaded from: classes2.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            d.this.r.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            d dVar = d.this;
            dVar.y = dVar.r.getHeight();
            d dVar2 = d.this;
            dVar2.z = dVar2.r.getWidth();
            LogEx.d(d.this.p, "mPlayerDefaultHeight=" + d.this.y + " mPlayerDefaultWidth=" + d.this.z);
            if (((com.zte.fragmentlib.b) d.this).h != null) {
                ((MainActivity) ((com.zte.fragmentlib.b) d.this).h).c(d.this.z, d.this.y);
                ((MainActivity) ((com.zte.fragmentlib.b) d.this).h).b(d.this.M, d.this.L);
                LogEx.d(d.this.p, "movePlayer=" + d.this.L);
                if (d.this.u == null) {
                    d.this.P();
                }
                if (d.this.u != null) {
                    d.this.u.L2();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChildFragmentHD.java */
    /* renamed from: com.zte.iptvclient.android.mobile.a0.b.d$d, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0179d implements com.zte.iptvclient.android.mobile.order.helper.c {
        C0179d() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.helper.c
        public void a(int i, String str) {
            d.this.a("4", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChildFragmentHD.java */
    /* loaded from: classes2.dex */
    public class e implements com.zte.iptvclient.android.mobile.order.helper.c {
        e() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.helper.c
        public void a(int i, String str) {
            LogEx.d(d.this.p, "payCallback");
            d.this.a("2", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChildFragmentHD.java */
    /* loaded from: classes2.dex */
    public class f implements SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener {
        f() {
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener
        public void onPrevueDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d(d.this.p, "sdkQueryTvodById:  onDataReturn,arg0= " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        com.zte.iptvclient.android.common.javabean.models.d a2 = com.zte.iptvclient.android.common.javabean.models.d.a(jSONArray.getJSONObject(i));
                        if (a2 != null && !TextUtils.isEmpty(a2.k())) {
                            d.this.D.add(a2);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    LogEx.e(d.this.p, e.getMessage());
                }
            }
            if (d.this.D.size() > 0) {
                d.this.R();
            } else {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.query_tvod_info_fail);
                d.this.a("4", -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChildFragmentHD.java */
    /* loaded from: classes2.dex */
    public class g implements SDKChannelMgr.OnChannelDetailWithUrlReturnListener {
        g() {
        }

        @Override // com.video.androidsdk.service.channel.SDKChannelMgr.OnChannelDetailWithUrlReturnListener
        public void onChannelDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d(d.this.p, "getChannelDetailWithURl returncode= " + str + "  errmsg " + str2 + "  msg " + str3);
            if ("0".equals(str)) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        com.zte.iptvclient.android.common.javabean.models.c a2 = com.zte.iptvclient.android.common.javabean.models.c.a(jSONArray.getJSONObject(i));
                        if (a2 != null) {
                            d.this.E.add(a2);
                        }
                    }
                } catch (Exception e) {
                    LogEx.e(d.this.p, "onChannelDetailWithUrlReturn" + e.getMessage());
                }
            }
            if (d.this.E.size() > 0) {
                d.this.Q();
            } else {
                d.this.a("2", -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChildFragmentHD.java */
    /* loaded from: classes2.dex */
    public class h implements ViewTreeObserver.OnGlobalLayoutListener {
        h() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            d.this.N.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            d dVar = d.this;
            dVar.L = dVar.N.getBottom();
            d dVar2 = d.this;
            dVar2.M = dVar2.O.getRight();
            LogEx.d(d.this.p, "onGlobalLayout=" + d.this.L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChildFragmentHD.java */
    /* loaded from: classes2.dex */
    public class i implements ViewTreeObserver.OnGlobalLayoutListener {
        i() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            d.this.r.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            d dVar = d.this;
            dVar.y = dVar.r.getHeight();
            d dVar2 = d.this;
            dVar2.z = dVar2.r.getWidth();
            LogEx.d(d.this.p, "mPlayerDefaultHeight=" + d.this.y + " mPlayerDefaultWidth=" + d.this.z);
            if (((com.zte.fragmentlib.b) d.this).h != null) {
                ((MainActivity) ((com.zte.fragmentlib.b) d.this).h).c(d.this.z, d.this.y);
                ((MainActivity) ((com.zte.fragmentlib.b) d.this).h).b(d.this.M, d.this.L);
            }
            LogEx.d(d.this.p, "movePlayer=" + d.this.L);
        }
    }

    /* compiled from: TvChildFragmentHD.java */
    /* loaded from: classes2.dex */
    class j implements t.d {
        j(d dVar) {
        }

        @Override // com.zte.iptvclient.android.common.k.t.d
        public void onDismiss() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChildFragmentHD.java */
    /* loaded from: classes2.dex */
    public class k implements SDKChannelMgr.OnChannelDetailWithUrlReturnListener {
        k() {
        }

        @Override // com.video.androidsdk.service.channel.SDKChannelMgr.OnChannelDetailWithUrlReturnListener
        public void onChannelDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d(d.this.p, "getChannelDetailWithURl returncode= " + str + "  errmsg " + str2 + "  msg " + str3);
            LogEx.d(d.this.p, "Test the starting speed : ChannelDetailWithURl back");
            if ("0".equals(str)) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        com.zte.iptvclient.android.common.javabean.models.c a2 = com.zte.iptvclient.android.common.javabean.models.c.a(jSONObject);
                        if (a2 != null) {
                            a2.r("0");
                            if (jSONObject.has("productList")) {
                                JSONArray jSONArray2 = jSONObject.getJSONArray("productList");
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= jSONArray2.length()) {
                                        break;
                                    }
                                    String optString = jSONArray2.getJSONObject(i2).optString("productname");
                                    if (optString != null && optString.contains("VIP")) {
                                        a2.r("1");
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            d.this.E.add(a2);
                        }
                    }
                } catch (Exception e) {
                    LogEx.e(d.this.p, "onChannelDetailWithUrlReturn" + e.getMessage());
                }
            }
            d.this.U();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChildFragmentHD.java */
    /* loaded from: classes2.dex */
    public class l implements SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener {
        l() {
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener
        public void onPrevueDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d(d.this.p, "sdkQueryTvodById:  onDataReturn,arg0= " + str3);
            LogEx.d(d.this.p, "Test the starting speed :queryTvodDetailWithUrl back");
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        com.zte.iptvclient.android.common.javabean.models.d a2 = com.zte.iptvclient.android.common.javabean.models.d.a(jSONObject);
                        if (a2 != null && !TextUtils.isEmpty(a2.k())) {
                            a2.u("0");
                            if (jSONObject.has("productList")) {
                                JSONArray jSONArray2 = jSONObject.getJSONArray("productList");
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= jSONArray2.length()) {
                                        break;
                                    }
                                    String optString = jSONArray2.getJSONObject(i2).optString("productname");
                                    if (optString != null && optString.contains("VIP")) {
                                        a2.u("1");
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            d.this.D.add(a2);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    LogEx.e(d.this.p, e.getMessage());
                }
            }
            d.this.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChildFragmentHD.java */
    /* loaded from: classes2.dex */
    public class m implements a.h {
        m() {
        }

        @Override // com.zte.iptvclient.android.common.player.k.a.h
        public void a() {
            if (d.this.t.getVisibility() != 0) {
                d.this.u.W0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChildFragmentHD.java */
    /* loaded from: classes2.dex */
    public class n implements b.y {
        n() {
        }

        @Override // com.zte.iptvclient.android.common.player.k.b.y
        public void a(String str, String str2, String str3, boolean z) {
            d.this.a(str, str2, str3, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChildFragmentHD.java */
    /* loaded from: classes2.dex */
    public class o implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.player.j.j f5413a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bundle f5414b;

        /* compiled from: TvChildFragmentHD.java */
        /* loaded from: classes2.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f5416a;

            a(String str) {
                this.f5416a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.u.d3();
                d.this.u.a2();
                d.this.u.K(this.f5416a);
                d.this.u.E();
                d.this.u.D2();
            }
        }

        /* compiled from: TvChildFragmentHD.java */
        /* loaded from: classes2.dex */
        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f5418a;

            b(String str) {
                this.f5418a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.u.d3();
                d.this.u.I(this.f5418a);
                d.this.u.E();
                d.this.u.D2();
            }
        }

        /* compiled from: TvChildFragmentHD.java */
        /* loaded from: classes2.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.u.d3();
                com.zte.iptvclient.android.common.f.b.b.j().h();
                d.this.u.Z1();
                com.zte.iptvclient.android.common.h.b.a().a(d.this.u);
                LogEx.d(d.this.p, "Test the starting speed : queryTvodBlackout back");
                com.zte.iptvclient.android.common.player.f fVar = d.this.A;
                o oVar = o.this;
                fVar.a(oVar.f5413a, oVar.f5414b, (Context) ((com.zte.fragmentlib.b) d.this).h, d.this.getChildFragmentManager(), d.this.t.getId(), d.this.u);
            }
        }

        /* compiled from: TvChildFragmentHD.java */
        /* renamed from: com.zte.iptvclient.android.mobile.a0.b.d$o$d, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0180d implements Runnable {
            RunnableC0180d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.u.d3();
                d.this.u.H2();
                d.this.u.a2();
                d.this.u.E();
                d.this.u.D2();
            }
        }

        o(com.zte.iptvclient.android.common.player.j.j jVar, Bundle bundle) {
            this.f5413a = jVar;
            this.f5414b = bundle;
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void j() {
            LogEx.d(d.this.p, "tvod blackout无策略，正常播放");
            ((com.zte.fragmentlib.b) d.this).h.runOnUiThread(new c());
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void k(String str) {
            LogEx.d(d.this.p, "tvod blackout查询展示black照片:" + str);
            ((com.zte.fragmentlib.b) d.this).h.runOnUiThread(new a(str));
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void l() {
            LogEx.d(d.this.p, "get Detail BlackoutInfo is null （pic url or play url is null）");
            ((com.zte.fragmentlib.b) d.this).h.runOnUiThread(new RunnableC0180d());
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void r(String str) {
            LogEx.d(d.this.p, "tvod blackout查询播放black片源" + str);
            ((com.zte.fragmentlib.b) d.this).h.runOnUiThread(new b(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvChildFragmentHD.java */
    /* loaded from: classes2.dex */
    public class p implements a.h {
        p() {
        }

        @Override // com.zte.iptvclient.android.common.player.k.a.h
        public void a() {
            if (d.this.t.getVisibility() != 0) {
                d.this.u.W0();
            }
        }
    }

    private void L() {
        if (this.h == null) {
            return;
        }
        new com.zte.iptvclient.android.common.j.h(this.h);
        "1".equals(ConfigMgr.readPropertie("IsShowChildLock"));
        this.D = new ArrayList<>();
        this.E = new ArrayList<>();
        this.G = com.zte.iptvclient.android.common.f.b.b.j();
    }

    private void M() {
        SupportActivity supportActivity = this.h;
        this.v = new TVScheduleProgramesView(supportActivity, supportActivity);
        SupportActivity supportActivity2 = this.h;
        com.zte.iptvclient.android.mobile.tv.ui.b bVar = new com.zte.iptvclient.android.mobile.tv.ui.b(supportActivity2, supportActivity2, this);
        this.w = bVar;
        this.s.addView(bVar);
    }

    private void N() {
        SupportActivity supportActivity;
        if (isHidden() || (supportActivity = this.h) == null) {
            return;
        }
        ((MainActivity) supportActivity).x();
        if (this.u == null) {
            P();
        }
        if (this.u != null) {
            LogEx.d(this.p, "###showLoading");
            this.u.D0();
            this.u.g2();
            this.u.L2();
        }
    }

    private void O() {
        if (isHidden() || this.h == null) {
            return;
        }
        if (this.u == null) {
            P();
        }
        if (this.u != null) {
            LogEx.d(this.p, "###hideLoading");
            this.u.d3();
            this.u.t("");
            this.u.Q2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        SupportActivity supportActivity = this.h;
        if (supportActivity == null) {
            return;
        }
        com.zte.iptvclient.android.common.player.k.c t = ((MainActivity) supportActivity).t();
        this.u = t;
        if (t == null) {
            return;
        }
        if (this.A == null) {
            this.A = new com.zte.iptvclient.android.common.player.f();
        }
        this.u.F1();
        this.u.a((c.o0) this);
        this.u.a((c.n0) this);
        this.u.a((b.a0) this);
        this.u.a((a.i) this);
        this.u.setTargetFragment(this, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        com.zte.iptvclient.android.common.player.k.c cVar;
        com.zte.iptvclient.android.common.player.k.c cVar2;
        com.zte.iptvclient.android.common.player.k.c cVar3;
        Bundle bundle = new Bundle();
        com.zte.iptvclient.android.common.javabean.models.c cVar4 = this.E.get(0);
        bundle.putString("playuri4dlna", com.zte.iptvclient.android.mobile.h.a.b.b(cVar4.i(), cVar4.p(), cVar4.d(), cVar4.f()));
        bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, !TextUtils.isEmpty(cVar4.c()) ? Integer.valueOf(cVar4.c()).intValue() : -1);
        bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, cVar4.j());
        LogEx.d(this.p, "play tv contentcode is " + cVar4.d());
        if (this.E.size() == 1 && com.zte.iptvclient.android.common.player.f.c(this.E.get(0).g())) {
            LogEx.d(this.p, "Definition =" + this.E.get(0).g());
            com.zte.iptvclient.android.common.player.k.c cVar5 = this.u;
            if (cVar5 != null) {
                cVar5.j(0);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<com.zte.iptvclient.android.common.javabean.models.c> it2 = this.E.iterator();
        while (it2.hasNext()) {
            com.zte.iptvclient.android.common.javabean.models.c next = it2.next();
            LogEx.d(this.p, "Definition =" + next.g());
            if (!com.zte.iptvclient.android.common.player.f.c(next.g())) {
                String j2 = next.j();
                if (TextUtils.equals(next.g(), "1")) {
                    if (TextUtils.isEmpty(j2)) {
                        j2 = "";
                    }
                    bundle.putString("url_sd", j2);
                } else if (TextUtils.equals(next.g(), "2")) {
                    if (TextUtils.isEmpty(j2)) {
                        j2 = "";
                    }
                    bundle.putString("url_sd_h", j2);
                } else if (TextUtils.equals(next.g(), "4")) {
                    if (TextUtils.isEmpty(j2)) {
                        j2 = "";
                    }
                    bundle.putString("url_hd", j2);
                } else if (TextUtils.equals(next.g(), "8")) {
                    if (TextUtils.isEmpty(j2)) {
                        j2 = "";
                    }
                    bundle.putString("url_480p", j2);
                } else if (TextUtils.equals(next.g(), GlobalConst.WINPHONE_CLIENT)) {
                    if (TextUtils.isEmpty(j2)) {
                        j2 = "";
                    }
                    bundle.putString("url_720p", j2);
                } else if (TextUtils.equals(next.g(), GlobalConst.ANDRIODSTB_CLIENT)) {
                    if (TextUtils.isEmpty(j2)) {
                        j2 = "";
                    }
                    bundle.putString("url_1280p", j2);
                } else {
                    bundle.putString("url_sd", "");
                }
                arrayList.add(next);
            }
        }
        if (arrayList.size() == 0 && this.E.size() > arrayList.size() && (cVar3 = this.u) != null) {
            cVar3.j(0);
            return;
        }
        if (!this.A.a(this.E.get(0).b()) && (cVar2 = this.u) != null) {
            cVar2.j(1);
            return;
        }
        com.zte.iptvclient.android.common.player.k.c cVar6 = this.u;
        if ((cVar6 == null || cVar6.p0() >= 0) && (cVar = this.u) != null) {
            cVar.f(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        com.zte.iptvclient.android.common.player.k.c cVar;
        com.zte.iptvclient.android.common.player.k.c cVar2;
        com.zte.iptvclient.android.common.player.k.c cVar3;
        Bundle bundle = new Bundle();
        if (this.D.size() == 1 && com.zte.iptvclient.android.common.player.f.c(this.D.get(0).f())) {
            LogEx.d(this.p, "Definition =" + this.D.get(0).f());
            com.zte.iptvclient.android.common.player.k.c cVar4 = this.u;
            if (cVar4 != null) {
                cVar4.j(0);
                return;
            }
        }
        bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, this.D.get(0).k());
        ArrayList arrayList = new ArrayList();
        Iterator<com.zte.iptvclient.android.common.javabean.models.d> it2 = this.D.iterator();
        while (it2.hasNext()) {
            com.zte.iptvclient.android.common.javabean.models.d next = it2.next();
            LogEx.d(this.p, "Definition =" + next.f());
            if (!com.zte.iptvclient.android.common.player.f.c(next.f())) {
                String k2 = next.k();
                if (TextUtils.equals(next.f(), "1")) {
                    if (TextUtils.isEmpty(k2)) {
                        k2 = "";
                    }
                    bundle.putString("url_sd", k2);
                    bundle.putString("physicalcontentid_url_sd", next.j());
                } else if (TextUtils.equals(next.f(), "2")) {
                    if (TextUtils.isEmpty(k2)) {
                        k2 = "";
                    }
                    bundle.putString("url_sd_h", k2);
                    bundle.putString("physicalcontentid_url_sd_h", next.j());
                } else if (TextUtils.equals(next.f(), "4")) {
                    if (TextUtils.isEmpty(k2)) {
                        k2 = "";
                    }
                    bundle.putString("url_hd", k2);
                    bundle.putString("physicalcontentid_url_hd", next.j());
                } else if (TextUtils.equals(next.f(), "8")) {
                    if (TextUtils.isEmpty(k2)) {
                        k2 = "";
                    }
                    bundle.putString("url_480p", k2);
                    bundle.putString("physicalcontentid_url_480p", next.j());
                } else if (TextUtils.equals(next.f(), GlobalConst.WINPHONE_CLIENT)) {
                    if (TextUtils.isEmpty(k2)) {
                        k2 = "";
                    }
                    bundle.putString("url_720p", k2);
                    bundle.putString("physicalcontentid_url_720p", next.j());
                } else if (TextUtils.equals(next.f(), GlobalConst.ANDRIODSTB_CLIENT)) {
                    if (TextUtils.isEmpty(k2)) {
                        k2 = "";
                    }
                    bundle.putString("url_1280p", k2);
                    bundle.putString("physicalcontentid_url_1280p", next.j());
                } else {
                    bundle.putString("url_sd", "");
                }
                arrayList.add(next);
            }
        }
        if (arrayList.size() == 0 && this.D.size() > arrayList.size() && (cVar3 = this.u) != null) {
            cVar3.j(0);
            return;
        }
        if (!this.A.a(s(this.D.get(0).c())) && (cVar2 = this.u) != null) {
            cVar2.j(1);
            return;
        }
        com.zte.iptvclient.android.common.player.k.c cVar5 = this.u;
        if ((cVar5 == null || cVar5.p0() >= 0) && (cVar = this.u) != null) {
            cVar.f(bundle);
        }
    }

    private void S() {
        FrameLayout frameLayout;
        if (isHidden()) {
            LogEx.e(this.p, "current  is Hidden unable Play !");
            return;
        }
        LogEx.d(this.p, "current is not Hidden text Play showPlayerFragment");
        SupportActivity supportActivity = this.h;
        if (supportActivity != null) {
            ((MainActivity) supportActivity).x();
            if (this.u == null) {
                P();
            }
        }
        if (this.y == 0 && this.z == 0 && (frameLayout = this.r) != null) {
            frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new c());
            return;
        }
        if (this.u == null) {
            P();
        }
        com.zte.iptvclient.android.common.player.k.c cVar = this.u;
        if (cVar != null) {
            cVar.L2();
        }
    }

    private void T() {
        this.h.startActivity(new Intent(getActivity(), (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        com.zte.iptvclient.android.common.player.k.c cVar;
        com.zte.iptvclient.android.common.player.k.c cVar2;
        ArrayList<com.zte.iptvclient.android.common.javabean.models.c> arrayList = this.E;
        if (arrayList != null && !arrayList.isEmpty() && this.u != null) {
            if (isHidden() && !this.u.A) {
                LogEx.e(this.p, "view is hidden");
                return;
            }
            if (this.A == null) {
                this.A = new com.zte.iptvclient.android.common.player.f();
            }
            Bundle bundle = new Bundle();
            com.zte.iptvclient.android.common.javabean.models.c cVar3 = this.E.get(0);
            if (cVar3 == null) {
                LogEx.e(this.p, "channel is null");
                O();
                return;
            }
            Channel channel = null;
            ArrayList<Channel> b2 = com.zte.iptvclient.android.common.j.i.d().b();
            if (b2 != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= b2.size()) {
                        break;
                    }
                    if (TextUtils.equals(b2.get(i2).getChannelcode(), cVar3.d())) {
                        channel = b2.get(i2);
                        break;
                    }
                    i2++;
                }
            }
            if (channel != null) {
                bundle.putString("tv_name", cVar3.e());
                bundle.putString("usermixno", channel.getUsermixno());
                LogEx.d(this.p, "current toPlay selectedChnnelcode=" + channel.getChannelcode());
            }
            bundle.putString("programname", cVar3.l());
            bundle.putString("isprotection", cVar3.h());
            bundle.putString("supportTimeShift", cVar3.q());
            bundle.putString(ParamConst.CHANNEL_INFO_RSP_TSAVAILABLE, cVar3.r());
            bundle.putString("playuri4dlna", com.zte.iptvclient.android.mobile.h.a.b.b(cVar3.i(), cVar3.p(), cVar3.d(), cVar3.f()));
            bundle.putString("telecomcode", cVar3.p());
            bundle.putString("poster_image", cVar3.k());
            bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, TextUtils.isEmpty(cVar3.c()) ? -1 : Integer.valueOf(cVar3.c()).intValue());
            bundle.putString("contentcode", cVar3.d());
            bundle.putString("ratingid", cVar3.n());
            LogEx.d(this.p, "ratingid is :" + cVar3.n());
            bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, cVar3.j());
            bundle.putString("productVIP", cVar3.m());
            bundle.putString("channelcode", cVar3.d());
            bundle.putString("mixno", cVar3.i());
            LogEx.d(this.p, "playChannelBean.getMixno= " + cVar3.i());
            LogEx.d(this.p, "play tv Channelcode is " + cVar3.d());
            bundle.putString("systemlimitenable", cVar3.o());
            bundle.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_TV.getIntValue()));
            bundle.putString("channelcode", cVar3.d());
            if (this.E.size() == 1 && com.zte.iptvclient.android.common.player.f.c(this.E.get(0).g())) {
                LogEx.d(this.p, "Definition =" + this.E.get(0).g());
                com.zte.iptvclient.android.common.player.k.c cVar4 = this.u;
                if (cVar4 != null) {
                    cVar4.j(0);
                    return;
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.zte.iptvclient.android.common.javabean.models.c> it2 = this.E.iterator();
            while (it2.hasNext()) {
                com.zte.iptvclient.android.common.javabean.models.c next = it2.next();
                LogEx.d(this.p, "Definition =" + next.g());
                if (!com.zte.iptvclient.android.common.player.f.c(next.g())) {
                    String j2 = next.j();
                    if (TextUtils.equals(next.g(), "1")) {
                        if (TextUtils.isEmpty(j2)) {
                            j2 = "";
                        }
                        bundle.putString("url_sd", j2);
                        bundle.putString("url_sdsupportTimeShift", next.q());
                        bundle.putString("url_sdtsavailable", next.r());
                    } else if (TextUtils.equals(next.g(), "2")) {
                        if (TextUtils.isEmpty(j2)) {
                            j2 = "";
                        }
                        bundle.putString("url_sd_h", j2);
                        bundle.putString("url_sd_hsupportTimeShift", next.q());
                        bundle.putString("url_sd_htsavailable", next.r());
                    } else if (TextUtils.equals(next.g(), "4")) {
                        if (TextUtils.isEmpty(j2)) {
                            j2 = "";
                        }
                        bundle.putString("url_hd", j2);
                        bundle.putString("url_hdsupportTimeShift", next.q());
                        bundle.putString("url_hdtsavailable", next.r());
                    } else if (TextUtils.equals(next.g(), "8")) {
                        if (TextUtils.isEmpty(j2)) {
                            j2 = "";
                        }
                        bundle.putString("url_480p", j2);
                        bundle.putString("url_480psupportTimeShift", next.q());
                        bundle.putString("url_480ptsavailable", next.r());
                    } else if (TextUtils.equals(next.g(), GlobalConst.WINPHONE_CLIENT)) {
                        if (TextUtils.isEmpty(j2)) {
                            j2 = "";
                        }
                        bundle.putString("url_720p", j2);
                        bundle.putString("url_720psupportTimeShift", next.q());
                        bundle.putString("url_720ptsavailable", next.r());
                    } else if (TextUtils.equals(next.g(), GlobalConst.ANDRIODSTB_CLIENT)) {
                        if (TextUtils.isEmpty(j2)) {
                            j2 = "";
                        }
                        bundle.putString("url_1280p", j2);
                        bundle.putString("url_1280psupportTimeShift", next.q());
                        bundle.putString("url_1280ptsavailable", next.r());
                    } else {
                        bundle.putString("url_sd", "");
                        bundle.putString("url_sdsupportTimeShift", next.q());
                        bundle.putString("url_sdtsavailable", next.r());
                    }
                    arrayList2.add(next);
                }
            }
            if (arrayList2.size() == 0 && this.E.size() > arrayList2.size() && (cVar2 = this.u) != null) {
                cVar2.j(0);
                return;
            }
            if (!this.A.a(this.E.get(0).b()) && (cVar = this.u) != null) {
                cVar.j(1);
                return;
            }
            com.zte.iptvclient.android.common.player.k.c cVar5 = this.u;
            if (cVar5 == null || cVar5.p0() >= 0) {
                com.zte.iptvclient.android.common.player.j.i iVar = new com.zte.iptvclient.android.common.player.j.i();
                iVar.b(cVar3.d());
                bundle.putString("columncode", cVar3.f());
                iVar.a(cVar3.f());
                LogEx.d(this.p, "COLUMNCODE= " + cVar3.f());
                if (!TextUtils.isEmpty(cVar3.a())) {
                    try {
                        if (Integer.valueOf(cVar3.a()).intValue() > 0 && TextUtils.equals("1", ConfigMgr.readPropertie("isSupportQueryAds"))) {
                            this.A.a(true);
                        } else {
                            this.A.a(false);
                        }
                    } catch (Exception unused) {
                        this.A.a(false);
                    }
                }
                this.u.a(new p());
                if (this.w == null) {
                    return;
                }
                if (this.C || isHidden()) {
                    bundle.putString("isNotNeedToSwitch", "2");
                }
                if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
                    LogEx.d(this.p, "enter blackout");
                    LogEx.d(this.p, "Test the starting speed : start queryTvBlackout");
                    this.G.a(cVar3.d(), new a(iVar, bundle));
                    return;
                } else {
                    this.u.Z1();
                    this.u.d3();
                    LogEx.d(this.p, "beginPlayTVInSmallScreen");
                    this.A.a(iVar, bundle, this.h, getChildFragmentManager(), this.t.getId(), this.u);
                    return;
                }
            }
            return;
        }
        LogEx.e(this.p, "channel is null");
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        com.zte.iptvclient.android.common.player.k.c cVar;
        com.zte.iptvclient.android.common.player.k.c cVar2;
        ArrayList<com.zte.iptvclient.android.common.javabean.models.d> arrayList = this.D;
        if (arrayList != null && !arrayList.isEmpty()) {
            com.zte.iptvclient.android.common.javabean.models.d dVar = this.D.get(0);
            String a2 = dVar.a();
            LogEx.d(this.p, "onDataReturn: channelAuthId=" + a2);
            if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
                this.G.a(dVar.c());
            }
            if (this.A == null) {
                this.A = new com.zte.iptvclient.android.common.player.f();
            }
            Bundle bundle = new Bundle();
            if (this.D.size() == 1 && com.zte.iptvclient.android.common.player.f.c(this.D.get(0).f())) {
                LogEx.d(this.p, "Definition =" + this.D.get(0).f());
                com.zte.iptvclient.android.common.player.k.c cVar3 = this.u;
                if (cVar3 != null) {
                    cVar3.j(0);
                    return;
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.zte.iptvclient.android.common.javabean.models.d> it2 = this.D.iterator();
            while (it2.hasNext()) {
                com.zte.iptvclient.android.common.javabean.models.d next = it2.next();
                LogEx.d(this.p, "Definition =" + next.f());
                if (!com.zte.iptvclient.android.common.player.f.c(next.f())) {
                    String k2 = next.k();
                    if (TextUtils.equals(next.f(), "1")) {
                        if (TextUtils.isEmpty(k2)) {
                            k2 = "";
                        }
                        bundle.putString("url_sd", k2);
                        bundle.putString("physicalcontentid_url_sd", next.j());
                    } else if (TextUtils.equals(next.f(), "2")) {
                        if (TextUtils.isEmpty(k2)) {
                            k2 = "";
                        }
                        bundle.putString("url_sd_h", k2);
                        bundle.putString("physicalcontentid_url_sd_h", next.j());
                    } else if (TextUtils.equals(next.f(), "4")) {
                        if (TextUtils.isEmpty(k2)) {
                            k2 = "";
                        }
                        bundle.putString("url_hd", k2);
                        bundle.putString("physicalcontentid_url_hd", next.j());
                    } else if (TextUtils.equals(next.f(), "8")) {
                        if (TextUtils.isEmpty(k2)) {
                            k2 = "";
                        }
                        bundle.putString("url_480p", k2);
                        bundle.putString("physicalcontentid_url_480p", next.j());
                    } else if (TextUtils.equals(next.f(), GlobalConst.WINPHONE_CLIENT)) {
                        if (TextUtils.isEmpty(k2)) {
                            k2 = "";
                        }
                        bundle.putString("url_720p", k2);
                        bundle.putString("physicalcontentid_url_720p", next.j());
                    } else if (TextUtils.equals(next.f(), GlobalConst.ANDRIODSTB_CLIENT)) {
                        if (TextUtils.isEmpty(k2)) {
                            k2 = "";
                        }
                        bundle.putString("url_1280p", k2);
                        bundle.putString("physicalcontentid_url_1280p", next.j());
                    } else {
                        bundle.putString("url_sd", "");
                    }
                    arrayList2.add(next);
                }
            }
            if (arrayList2.size() == 0 && this.D.size() > arrayList2.size() && (cVar2 = this.u) != null) {
                cVar2.j(0);
                return;
            }
            if (!this.A.a(s(this.D.get(0).c())) && (cVar = this.u) != null) {
                cVar.j(1);
                return;
            }
            com.zte.iptvclient.android.common.player.k.c cVar4 = this.u;
            if (cVar4 == null || cVar4.p0() >= 0) {
                bundle.putString("bookmark_breakpoint", String.valueOf(this.F));
                if (!TextUtils.isEmpty(a2)) {
                    bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, Integer.valueOf(a2).intValue());
                } else {
                    bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, -1);
                }
                String c2 = dVar.c();
                Channel channel = null;
                ArrayList<Channel> b2 = com.zte.iptvclient.android.common.j.i.d().b();
                if (b2 != null) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= b2.size()) {
                            break;
                        }
                        if (TextUtils.equals(b2.get(i2).getChannelcode(), c2)) {
                            channel = b2.get(i2);
                            break;
                        }
                        i2++;
                    }
                }
                if (channel != null) {
                    LogEx.d(this.p, "current toPlay selectedChnnelcode=" + channel.getChannelcode());
                    bundle.putString("poster_image", channel.getPosterimage());
                    bundle.putString("supportTimeShift", channel.getSupporttimeshift());
                    bundle.putString("tv_name", channel.getChannelname());
                    bundle.putString("mixno", channel.getMixno());
                    LogEx.d(this.p, "curChannel.getMixno= " + channel.getMixno());
                    bundle.putString("usermixno", channel.getUsermixno());
                    if (TextUtils.isEmpty(channel.getMixno())) {
                        bundle.putString("mixno", dVar.i());
                        LogEx.d(this.p, "prevueDetail.getMixno= " + dVar.i());
                    }
                    bundle.putString("channelcode", channel.getChannelcode());
                    bundle.putString("ratingid", channel.getRatingid());
                    bundle.putString("systemlimitenable", channel.getSystemlimitenable());
                    if (this.C) {
                        bundle.putString("isNotNeedToSwitch", "2");
                    }
                }
                bundle.putString("prevuecode", dVar.l());
                bundle.putBoolean("IsUesMutliWindowToPlay", false);
                bundle.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_TVOD.getIntValue()));
                bundle.putString("prevueratingid", dVar.o());
                LogEx.d(this.p, "prevueratingid is :" + dVar.o());
                bundle.putString("prevue_name", dVar.m());
                bundle.putString("tv_id", dVar.c());
                bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, dVar.k());
                bundle.putString("isprotection", dVar.h());
                bundle.putString("contentcode", dVar.l());
                bundle.putString("ratingid", dVar.o());
                bundle.putString("productVIP", dVar.n());
                LogEx.d(this.p, "play tvod contentcode is " + dVar.l());
                bundle.putString("cmsid", dVar.d());
                bundle.putString("physicalcontentid", dVar.j());
                String b3 = dVar.b();
                bundle.putString("prevuebegintime", b3);
                String g2 = dVar.g();
                bundle.putString("prevueendtime", g2);
                bundle.putString(ParamConst.NPVR_QUERY_RSP_DURATION, x.c(b3, "yyyy.MM.dd HH:mm:ss", "HH:mm", 1) + "-" + x.c(g2, "yyyy.MM.dd HH:mm:ss", "HH:mm", 1));
                bundle.putString("channelcode", c2);
                String p2 = dVar.p();
                bundle.putString("playuri4dlna", com.zte.iptvclient.android.mobile.h.a.b.a(dVar.l(), c2, p2, x.c(b3, "yyyy.MM.dd HH:mm:ss", "yyyyMMddHHmmss", 1), x.c(g2, "yyyy.MM.dd HH:mm:ss", "yyyyMMddHHmmss", 1)));
                bundle.putString("telecomcode", p2);
                bundle.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_TVOD));
                com.zte.iptvclient.android.common.player.j.j jVar = new com.zte.iptvclient.android.common.player.j.j();
                jVar.b(dVar.c());
                jVar.a(dVar.e());
                jVar.c("1");
                if (channel != null && !TextUtils.isEmpty(channel.getAdvertisecontent())) {
                    LogEx.d(this.p, " getAdvertisecontent " + channel.getAdvertisecontent());
                    try {
                        this.A.a(Integer.valueOf(channel.getAdvertisecontent()).intValue() > 0 && TextUtils.equals("1", ConfigMgr.readPropertie("isSupportQueryAds")));
                    } catch (Exception unused) {
                        this.A.a(false);
                    }
                }
                if (TextUtils.equals("1", ConfigMgr.readPropertie("SuportTvoDAddBookMark", "0"))) {
                    this.A.b(true);
                } else {
                    this.A.b(false);
                }
                if (this.u == null) {
                    return;
                }
                LogEx.d(this.p, "beginPlayTVInSmallScreen");
                this.u.a(new m());
                this.u.a(new n());
                if (TextUtils.equals("1", ConfigMgr.readPropertie("SuportTvoDAddBookMark", "0"))) {
                    this.A.b(true);
                } else {
                    this.A.b(false);
                }
                if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
                    LogEx.d(this.p, "Test the starting speed : start queryTvodBlackout");
                    com.zte.iptvclient.android.common.f.b.b.j().a(c2, s.b(), new o(jVar, bundle));
                    return;
                } else {
                    com.zte.iptvclient.android.common.h.b.a().a(this.u);
                    this.u.d3();
                    this.u.Z1();
                    this.A.a(jVar, bundle, (Context) this.h, getChildFragmentManager(), this.t.getId(), this.u);
                    return;
                }
            }
            return;
        }
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.no_program_available);
        O();
    }

    private void W() {
        Channel channel = this.J;
        if (channel != null) {
            e(channel.getChannelcode(), this.J.getRatingid());
        } else {
            LogEx.e(this.p, "mCurSelectedChannel is null!");
            O();
        }
        TVScheduleProgramesView tVScheduleProgramesView = this.v;
        if (tVScheduleProgramesView != null) {
            tVScheduleProgramesView.b();
        }
    }

    private void X() {
        LogEx.d(this.p, "updateChannelLivePlayUrl" + this.U);
        ArrayList<com.zte.iptvclient.android.common.javabean.models.c> arrayList = this.E;
        if (arrayList != null) {
            arrayList.clear();
        }
        SDKChannelMgr sDKChannelMgr = new SDKChannelMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("channelcode", this.U);
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Radio_Column");
        if (propertiesInfo == null) {
            propertiesInfo = "";
        }
        if (this.V.startsWith(propertiesInfo)) {
            hashMap.put("columncode", this.V);
        }
        sDKChannelMgr.getChannelDetailWithURl(hashMap, new g());
    }

    private void Y() {
        TVScheduleProgramesView tVScheduleProgramesView = this.v;
        if (tVScheduleProgramesView != null) {
            tVScheduleProgramesView.a(this.K, this.J);
        }
    }

    private void Z() {
        if (this.D.size() > 0) {
            this.D.clear();
        }
        SDKPrevueMgr sDKPrevueMgr = new SDKPrevueMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("prevuecode", this.T.getPrevuecode());
        hashMap.put("recommendtype", "0");
        LogEx.d(this.p, "updateChannelTvodPlayUrl" + this.T.getPrevuecode());
        sDKPrevueMgr.getPrevueDetailWithUrl(hashMap, new f());
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        L();
        this.t = ((MainActivity) this.h).u();
        ((MainActivity) this.h).x();
        if (this.u == null) {
            P();
        }
        com.zte.iptvclient.android.common.player.k.c cVar = this.u;
        if (cVar != null) {
            cVar.L2();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (intent != null && 20 == i2) {
            LogEx.i(this.p, " skip to LoginFragment");
            T();
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Window window;
        SupportActivity supportActivity = this.h;
        if (supportActivity != null && (window = supportActivity.getWindow()) != null) {
            window.setSoftInputMode(48);
        }
        super.onCreate(bundle);
        if (getArguments() != null) {
            getArguments().getString(ParamConst.SEARCH_RSP_ITEM_CHANNELCODE);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        if (this.B == null) {
            View inflate = layoutInflater.inflate(R.layout.tv_child_fragment_hd_layout, viewGroup, false);
            this.B = inflate;
            d(inflate);
            M();
        }
        return this.B;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }

    @Override // com.zte.fragmentlib.publicbaseclass.skinloader.a, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("mChildFragmentManager");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (NoSuchFieldException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(q qVar) {
        qVar.a();
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        com.zte.iptvclient.android.common.player.k.c cVar;
        if (z) {
            I();
            this.R = false;
        } else {
            S();
            if (this.y == 0 && this.z == 0) {
                this.r.getViewTreeObserver().addOnGlobalLayoutListener(new b());
            }
            if (!com.zte.iptvclient.android.mobile.n.c.b.t() && (cVar = this.u) != null) {
                cVar.N2();
                return;
            }
            if (isHidden()) {
                LogEx.e(this.p, "current  is Hidden unable Play !");
                return;
            }
            LogEx.d(this.p, "current is not Hidden text Play showPlayerFragment");
            if (!this.R) {
                W();
            }
            this.w.a();
            this.w.a(this.J);
        }
        super.onHiddenChanged(z);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (BaseApp.a(getContext())) {
            return;
        }
        com.gyf.barlibrary.e c2 = com.gyf.barlibrary.e.c(getActivity());
        c2.a(false);
        c2.f();
    }

    private void I() {
        ((MainActivity) this.h).v();
        com.zte.iptvclient.android.common.player.k.c cVar = this.u;
        if (cVar != null) {
            cVar.x2();
            this.u.g(false);
            this.u.d3();
        }
    }

    private void J() {
        com.zte.iptvclient.android.common.javabean.b bVar = new com.zte.iptvclient.android.common.javabean.b();
        ArrayList<com.zte.iptvclient.android.common.javabean.models.c> arrayList = this.E;
        if (arrayList != null && arrayList.size() > 0) {
            this.U = this.E.get(0).d();
            bVar.a(this.E.get(0).f());
            bVar.d(this.E.get(0).d());
            bVar.b("2");
            bVar.g(this.E.get(0).p());
            bVar.e(this.E.get(0).e());
            bVar.f("0");
            com.zte.iptvclient.android.common.f.b.a aVar = new com.zte.iptvclient.android.common.f.b.a(this.h, bVar, new e(), this);
            this.S = aVar;
            aVar.a(this.N);
            this.S.a();
            return;
        }
        a("2", -1);
    }

    private void K() {
        com.zte.iptvclient.android.common.javabean.b bVar = new com.zte.iptvclient.android.common.javabean.b();
        ArrayList<com.zte.iptvclient.android.common.javabean.models.d> arrayList = this.D;
        if (arrayList != null && arrayList.isEmpty()) {
            if (this.T == null) {
                this.T = new PrevueBean();
            }
            this.T.setPrevuecode(this.D.get(0).l());
            bVar.e(String.valueOf(this.D.get(0).m()));
            bVar.g(this.D.get(0).p());
            bVar.b("4");
            bVar.a(this.D.get(0).e());
            bVar.d(this.D.get(0).l());
            com.zte.iptvclient.android.common.f.b.a aVar = new com.zte.iptvclient.android.common.f.b.a(this.h, bVar, new C0179d(), this);
            this.S = aVar;
            aVar.a(this.N);
            this.S.a();
            return;
        }
        a("2", -1);
    }

    private void e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!com.zte.iptvclient.android.mobile.n.c.b.t() && this.u != null) {
            LogEx.i(this.p, "showLoginToPlayView return ");
            this.u.N2();
            return;
        }
        N();
        LogEx.d(this.p, "deailLiveChannelPlay " + str);
        t(str);
        X = str;
        LogEx.i(this.p, "event " + str);
    }

    private String s(String str) {
        ArrayList<Channel> b2 = com.zte.iptvclient.android.common.j.i.d().b();
        if (b2 != null) {
            Iterator<Channel> it2 = b2.iterator();
            while (it2.hasNext()) {
                Channel next = it2.next();
                if (TextUtils.equals(next.getChannelcode(), str)) {
                    return next.getAllownettype();
                }
            }
        }
        return "";
    }

    private void t(String str) {
        LogEx.d("Test the starting speed", "[PAD] startPlay for tv");
        ArrayList<com.zte.iptvclient.android.common.javabean.models.c> arrayList = this.E;
        if (arrayList != null) {
            arrayList.clear();
        }
        SDKChannelMgr sDKChannelMgr = new SDKChannelMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("channelcode", str);
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Radio_Column");
        if (propertiesInfo == null) {
            propertiesInfo = "";
        }
        if (this.V.startsWith(propertiesInfo)) {
            hashMap.put("columncode", this.V);
        }
        LogEx.d(this.p, "Test the starting speed : start ChannelDetailWithURl");
        sDKChannelMgr.getChannelDetailWithURl(hashMap, new k());
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public int i() {
        return this.y;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.n.a aVar) {
        if (TabHostManager.TabName.TV.equals(aVar.a())) {
            this.R = true;
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b.a0
    public void q(String str) {
        if (TextUtils.equals(str, "2")) {
            J();
        } else {
            K();
        }
    }

    private void d(View view) {
        com.zte.iptvclient.android.common.k.g.a(this.h, view, R.id.title_bottom_line);
        this.q = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        this.Q = a2;
        if (a2 <= 0) {
            this.Q = 60;
        }
        this.q.setHeight(this.Q);
        this.N = (RelativeLayout) view.findViewById(R.id.ll_nav_bar);
        this.O = view.findViewById(R.id.viewleft);
        this.P = view.findViewById(R.id.viewright);
        ImageView imageView = (ImageView) view.findViewById(R.id.title_bottom_line);
        this.W = imageView;
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        com.zte.iptvclient.common.uiframe.f.a(this.N);
        com.zte.iptvclient.common.uiframe.f.a(this.O);
        com.zte.iptvclient.common.uiframe.f.a(this.P);
        ((TextView) view.findViewById(R.id.top_navbar_title_txt)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_pad));
        this.N.getViewTreeObserver().addOnGlobalLayoutListener(new h());
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.tv_play_base_container);
        this.r = frameLayout;
        com.zte.iptvclient.common.uiframe.f.a(frameLayout);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        this.r.setVisibility(0);
        if (this.y == 0 && this.z == 0) {
            this.r.getViewTreeObserver().addOnGlobalLayoutListener(new i());
        }
        this.s = (FrameLayout) view.findViewById(R.id.tv_channel_list_container);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.m mVar) {
        if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            t.a(this.h, new j(this));
        } else {
            SupportActivity supportActivity = this.h;
            com.zte.iptvclient.android.mobile.e0.e.l lVar = new com.zte.iptvclient.android.mobile.e0.e.l(supportActivity, supportActivity, this.J.getChannelcode());
            this.x = lVar;
            this.s.addView(lVar);
        }
    }

    private void a(String str, boolean z) {
        LogEx.d("Test the starting speed", "[PAD]startPlay for TVOD");
        if (this.D.size() > 0) {
            this.D.clear();
        }
        SDKPrevueMgr sDKPrevueMgr = new SDKPrevueMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("prevuecode", str);
        hashMap.put("mediaservices", "2");
        hashMap.put("recommendtype", z ? "1" : "0");
        LogEx.d(this.p, "Test the starting speed : start queryTvodDetailWithUrl");
        sDKPrevueMgr.getPrevueDetailWithUrl(hashMap, new l());
    }

    @Override // com.zte.iptvclient.android.mobile.tv.ui.b.e
    public void s() {
        com.zte.iptvclient.android.common.player.k.c cVar = this.u;
        if (cVar != null) {
            cVar.j(3);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.b bVar) {
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            PrevueBean a2 = bVar.a();
            this.T = a2;
            if (TextUtils.isEmpty(a2.getPrevuecode())) {
                return;
            }
            if (!com.zte.iptvclient.android.mobile.n.c.b.t() && this.u != null) {
                LogEx.i(this.p, "showLoginToPlayView return ");
                this.u.N2();
                return;
            }
            N();
            this.F = this.T.getPrevuebreakpoint();
            a(this.T.getPrevuecode(), false);
            X = this.T.getChannelcode();
            LogEx.d(this.p, "current toPlay selectedChnnelcode=" + X);
            com.zte.iptvclient.android.common.javabean.e.f4731b = this.T;
            com.zte.iptvclient.android.common.javabean.e.f4730a = false;
            TVScheduleProgramesView tVScheduleProgramesView = this.v;
            if (tVScheduleProgramesView != null) {
                tVScheduleProgramesView.c();
                this.v.a(this.T.getBegintime());
            }
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public int e() {
        int[] iArr = new int[2];
        this.r.getLocationInWindow(iArr);
        return iArr[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, boolean z) {
        Channel channel;
        LogEx.d(this.p, "onPlayNextTvod PrevueCode " + str + " forChannelCode= " + str2);
        if (this.v == null || (channel = this.J) == null || !TextUtils.equals(channel.getChannelcode(), str2)) {
            return;
        }
        this.v.a(str, str2, str3, z);
    }

    @Override // com.zte.iptvclient.android.common.player.k.c.o0
    public void a(com.zte.iptvclient.android.common.e.b bVar) {
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.a(TabHostManager.TabName.HOME));
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public void a(int i2) {
        WindowManager.LayoutParams attributes;
        WindowManager.LayoutParams attributes2;
        SupportActivity supportActivity = this.h;
        if (supportActivity != null) {
            supportActivity.setRequestedOrientation(i2);
            Window window = this.h.getWindow();
            if (window != null && (attributes2 = window.getAttributes()) != null) {
                attributes2.flags |= 512;
                window.setAttributes(attributes2);
            }
        } else {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(i2);
                Window window2 = activity.getWindow();
                if (window2 != null && (attributes = window2.getAttributes()) != null) {
                    attributes.flags |= 512;
                    window2.setAttributes(attributes);
                }
            }
        }
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.e(true));
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.f(true));
        this.C = true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.g gVar) {
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            com.zte.iptvclient.android.common.player.k.c cVar = this.u;
            if (cVar != null) {
                cVar.D0();
            }
            this.U = gVar.b();
            this.V = gVar.d();
            if (!com.zte.iptvclient.android.mobile.n.c.b.t() && this.u != null) {
                LogEx.i(this.p, "showLoginToPlayView return ");
                this.u.N2();
                return;
            }
            LogEx.d(this.p, "current toPlay selectedChnnelcode = " + this.U);
            e(this.U, gVar.c());
            com.zte.iptvclient.android.common.javabean.e.f4731b = null;
            com.zte.iptvclient.android.common.javabean.e.f4730a = true;
            TVScheduleProgramesView tVScheduleProgramesView = this.v;
            if (tVScheduleProgramesView != null) {
                tVScheduleProgramesView.c();
            }
        }
    }

    @Override // com.zte.iptvclient.android.mobile.tv.ui.b.e
    public void d() {
        com.zte.iptvclient.android.common.player.k.c cVar;
        if (isHidden()) {
            LogEx.e(this.p, "current  is Hidden unable Play !");
            return;
        }
        LogEx.d(this.p, "current is not Hidden text Play showPlayerFragment");
        if (this.J != null) {
            S();
            if (!com.zte.iptvclient.android.mobile.n.c.b.t() && (cVar = this.u) != null) {
                cVar.N2();
                return;
            } else {
                this.V = this.J.getColumncode();
                e(this.J.getChannelcode(), this.J.getRatingid());
                return;
            }
        }
        LogEx.e(this.p, "mCurSelectedChannel is null!");
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public void a(boolean z) {
        this.u.T1();
        SupportActivity supportActivity = this.h;
        if (supportActivity != null) {
            Window window = supportActivity.getWindow();
            if (window != null) {
                window.clearFlags(512);
            }
            if (BaseApp.a(this.h)) {
                this.h.setRequestedOrientation(0);
            } else {
                this.h.setRequestedOrientation(1);
            }
        } else {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                Window window2 = activity.getWindow();
                if (window2 != null) {
                    window2.clearFlags(512);
                }
                if (BaseApp.a(activity)) {
                    activity.setRequestedOrientation(0);
                } else {
                    activity.setRequestedOrientation(1);
                }
            }
        }
        this.C = false;
        SupportActivity supportActivity2 = this.h;
        if (supportActivity2 != null) {
            ((MainActivity) supportActivity2).b(this.M, this.L);
        }
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.e(false));
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.f(false));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.h hVar) {
        com.zte.iptvclient.android.common.player.k.c cVar = this.u;
        if (cVar != null) {
            cVar.m(true);
        }
        if (TextUtils.isEmpty(hVar.a())) {
            return;
        }
        if (this.h instanceof MainActivity) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.e(hVar.a(), ""));
        } else {
            t(hVar.a());
        }
        com.zte.iptvclient.android.common.player.k.c cVar2 = this.u;
        if (cVar2 != null) {
            cVar2.i0();
        }
        X = hVar.a();
        LogEx.i(this.p, "event " + hVar.a());
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.f fVar) {
        if (this.u == null || this.t == null || isHidden()) {
            return;
        }
        if ("play".equals(fVar.b())) {
            this.t.setVisibility(0);
            if (fVar.a()) {
                this.u.X0();
                return;
            } else {
                U();
                return;
            }
        }
        if ("pause".equals(fVar.b())) {
            this.t.setVisibility(8);
            this.u.W0();
            com.zte.iptvclient.android.common.player.k.c cVar = this.u;
            if (cVar.e0 || cVar.P8) {
                return;
            }
            cVar.x2();
        }
    }

    @Override // com.zte.iptvclient.android.mobile.tv.ui.b.e
    public void a(ColumnBean columnBean, Channel channel) {
        this.J = channel;
        this.K = columnBean;
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2) {
        if (i2 == 0) {
            if (TextUtils.equals(str, "2")) {
                X();
            } else {
                Z();
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        if (!cVar.a().equals("0") || isHidden()) {
            return;
        }
        LogEx.d(this.p, "LoginReturnEvent success for re startPlay");
        d();
    }
}
