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
import com.zte.iptvclient.android.common.k.r;
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
import com.zte.iptvclient.android.mobile.tv.ui.a;
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

/* compiled from: TvFragmentHD.java */
/* loaded from: classes.dex */
public class e extends com.zte.fragmentlib.b implements c.o0, a.i, a.m, b.a0, a.h, c.n0 {
    public static String Y = "";
    private View C;
    private ArrayList<com.zte.iptvclient.android.common.javabean.models.d> E;
    private ArrayList<com.zte.iptvclient.android.common.javabean.models.c> F;
    private com.zte.iptvclient.android.common.f.b.b J;
    private Channel K;
    private ColumnBean L;
    private RelativeLayout N;
    private FrameLayout O;
    private int P;
    private com.zte.iptvclient.android.common.f.b.a R;
    private PrevueBean S;
    public TextView q;
    private FrameLayout r;
    private FrameLayout s;
    private FrameLayout t;
    private RelativeLayout u;
    private com.zte.iptvclient.android.common.player.k.c v;
    private TVScheduleProgramesView w;
    private com.zte.iptvclient.android.mobile.tv.ui.a x;
    private com.zte.iptvclient.android.mobile.e0.e.l y;
    private String p = "TvFragmentHD";
    private int z = 0;
    private int A = 0;
    private com.zte.iptvclient.android.common.player.f B = null;
    public boolean D = false;
    private long G = 0;
    private int M = 0;
    private boolean Q = false;
    private boolean T = true;
    private String U = "";
    private String V = "";
    private String W = "";
    private boolean X = false;

    /* compiled from: TvFragmentHD.java */
    /* loaded from: classes2.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            e.this.r.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            e eVar = e.this;
            eVar.z = eVar.r.getHeight();
            e eVar2 = e.this;
            eVar2.A = eVar2.r.getWidth();
            LogEx.d(e.this.p, "mPlayerDefaultHeight=" + e.this.z + " mPlayerDefaultWidth=" + e.this.A);
            if (((com.zte.fragmentlib.b) e.this).h != null) {
                ((MainActivity) ((com.zte.fragmentlib.b) e.this).h).c(e.this.A, e.this.z);
                ((MainActivity) ((com.zte.fragmentlib.b) e.this).h).b(e.this.M);
            }
            LogEx.d(e.this.p, "movePlayer=" + e.this.M);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvFragmentHD.java */
    /* loaded from: classes2.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            e.this.r.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            e eVar = e.this;
            eVar.z = eVar.r.getHeight();
            e eVar2 = e.this;
            eVar2.A = eVar2.r.getWidth();
            LogEx.d(e.this.p, "mPlayerDefaultHeight=" + e.this.z + " mPlayerDefaultWidth=" + e.this.A);
            if (((com.zte.fragmentlib.b) e.this).h != null) {
                ((MainActivity) ((com.zte.fragmentlib.b) e.this).h).c(e.this.A, e.this.z);
                ((MainActivity) ((com.zte.fragmentlib.b) e.this).h).b(e.this.M);
                LogEx.d(e.this.p, "movePlayer=" + e.this.M);
                if (e.this.v == null) {
                    e.this.P();
                }
                if (e.this.v != null) {
                    e.this.v.L2();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvFragmentHD.java */
    /* loaded from: classes2.dex */
    public class c implements com.zte.iptvclient.android.mobile.order.helper.c {
        c() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.helper.c
        public void a(int i, String str) {
            e.this.a("4", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvFragmentHD.java */
    /* loaded from: classes2.dex */
    public class d implements com.zte.iptvclient.android.mobile.order.helper.c {
        d() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.helper.c
        public void a(int i, String str) {
            LogEx.d(e.this.p, "payCallback");
            e.this.a("2", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvFragmentHD.java */
    /* renamed from: com.zte.iptvclient.android.mobile.a0.b.e$e, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0181e implements SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener {
        C0181e() {
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener
        public void onPrevueDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d(e.this.p, "sdkQueryTvodById:  onDataReturn,arg0= " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        com.zte.iptvclient.android.common.javabean.models.d a2 = com.zte.iptvclient.android.common.javabean.models.d.a(jSONArray.getJSONObject(i));
                        if (a2 != null && !TextUtils.isEmpty(a2.k())) {
                            e.this.E.add(a2);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    LogEx.e(e.this.p, e.getMessage());
                }
            }
            if (e.this.E.size() > 0) {
                e.this.R();
            } else {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.query_tvod_info_fail);
                e.this.a("4", -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvFragmentHD.java */
    /* loaded from: classes2.dex */
    public class f implements SDKChannelMgr.OnChannelDetailWithUrlReturnListener {
        f() {
        }

        @Override // com.video.androidsdk.service.channel.SDKChannelMgr.OnChannelDetailWithUrlReturnListener
        public void onChannelDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d(e.this.p, "getChannelDetailWithURl returncode= " + str + "  errmsg " + str2 + "  msg " + str3);
            if ("0".equals(str)) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        com.zte.iptvclient.android.common.javabean.models.c a2 = com.zte.iptvclient.android.common.javabean.models.c.a(jSONArray.getJSONObject(i));
                        if (a2 != null) {
                            e.this.F.add(a2);
                        }
                    }
                } catch (Exception e) {
                    LogEx.e(e.this.p, "onChannelDetailWithUrlReturn" + e.getMessage());
                }
            }
            if (e.this.F.size() > 0) {
                e.this.Q();
            } else {
                e.this.a("2", -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvFragmentHD.java */
    /* loaded from: classes2.dex */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
        g() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            e.this.N.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            e eVar = e.this;
            eVar.M = eVar.N.getBottom();
            LogEx.d(e.this.p, "onGlobalLayout=" + e.this.M);
        }
    }

    /* compiled from: TvFragmentHD.java */
    /* loaded from: classes2.dex */
    class h implements t.d {
        h(e eVar) {
        }

        @Override // com.zte.iptvclient.android.common.k.t.d
        public void onDismiss() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvFragmentHD.java */
    /* loaded from: classes2.dex */
    public class i implements SDKChannelMgr.OnChannelDetailWithUrlReturnListener {
        i() {
        }

        @Override // com.video.androidsdk.service.channel.SDKChannelMgr.OnChannelDetailWithUrlReturnListener
        public void onChannelDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d(e.this.p, "getChannelDetailWithURl returncode= " + str + "  errmsg " + str2 + "  msg " + str3);
            LogEx.d(e.this.p, "Test the starting speed : ChannelDetailWithURl back");
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
                            e.this.F.add(a2);
                        }
                    }
                    e.this.K.setAuthid(((com.zte.iptvclient.android.common.javabean.models.c) e.this.F.get(0)).c());
                } catch (Exception e) {
                    LogEx.e(e.this.p, "onChannelDetailWithUrlReturn" + e.getMessage());
                }
            }
            e.this.U();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvFragmentHD.java */
    /* loaded from: classes2.dex */
    public class j implements SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener {
        j() {
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener
        public void onPrevueDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d(e.this.p, "sdkQueryTvodById:  onDataReturn,arg0= " + str3);
            LogEx.d(e.this.p, "Test the starting speed :queryTvodDetailWithUrl back");
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
                            e.this.E.add(a2);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    LogEx.e(e.this.p, e.getMessage());
                }
            }
            e.this.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvFragmentHD.java */
    /* loaded from: classes2.dex */
    public class k implements a.h {
        k() {
        }

        @Override // com.zte.iptvclient.android.common.player.k.a.h
        public void a() {
            if (e.this.u.getVisibility() != 0) {
                e.this.v.W0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvFragmentHD.java */
    /* loaded from: classes2.dex */
    public class l implements b.y {
        l() {
        }

        @Override // com.zte.iptvclient.android.common.player.k.b.y
        public void a(String str, String str2, String str3, boolean z) {
            e.this.a(str, str2, str3, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvFragmentHD.java */
    /* loaded from: classes2.dex */
    public class m implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.player.j.j f5434a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bundle f5435b;

        /* compiled from: TvFragmentHD.java */
        /* loaded from: classes2.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f5437a;

            a(String str) {
                this.f5437a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.v.d3();
                e.this.v.a2();
                e.this.v.K(this.f5437a);
                e.this.v.E();
                e.this.v.D2();
            }
        }

        /* compiled from: TvFragmentHD.java */
        /* loaded from: classes2.dex */
        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f5439a;

            b(String str) {
                this.f5439a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.v.d3();
                e.this.v.I(this.f5439a);
                e.this.v.E();
                e.this.v.D2();
            }
        }

        /* compiled from: TvFragmentHD.java */
        /* loaded from: classes2.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.v.d3();
                com.zte.iptvclient.android.common.f.b.b.j().h();
                e.this.v.Z1();
                com.zte.iptvclient.android.common.h.b.a().a(e.this.v);
                LogEx.d(e.this.p, "Test the starting speed : queryTvodBlackout back");
                com.zte.iptvclient.android.common.player.f fVar = e.this.B;
                m mVar = m.this;
                fVar.a(mVar.f5434a, mVar.f5435b, (Context) ((com.zte.fragmentlib.b) e.this).h, e.this.getChildFragmentManager(), e.this.u.getId(), e.this.v);
            }
        }

        /* compiled from: TvFragmentHD.java */
        /* loaded from: classes2.dex */
        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.v.d3();
                e.this.v.H2();
                e.this.v.a2();
                e.this.v.E();
                e.this.v.D2();
            }
        }

        m(com.zte.iptvclient.android.common.player.j.j jVar, Bundle bundle) {
            this.f5434a = jVar;
            this.f5435b = bundle;
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void j() {
            LogEx.d(e.this.p, "tvod blackout无策略，正常播放");
            ((com.zte.fragmentlib.b) e.this).h.runOnUiThread(new c());
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void k(String str) {
            LogEx.d(e.this.p, "tvod blackout查询展示black照片:" + str);
            ((com.zte.fragmentlib.b) e.this).h.runOnUiThread(new a(str));
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void l() {
            LogEx.d(e.this.p, "get Detail BlackoutInfo is null （pic url or play url is null）");
            ((com.zte.fragmentlib.b) e.this).h.runOnUiThread(new d());
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void r(String str) {
            LogEx.d(e.this.p, "tvod blackout查询播放black片源" + str);
            ((com.zte.fragmentlib.b) e.this).h.runOnUiThread(new b(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvFragmentHD.java */
    /* loaded from: classes2.dex */
    public class n implements a.h {
        n() {
        }

        @Override // com.zte.iptvclient.android.common.player.k.a.h
        public void a() {
            if (e.this.u.getVisibility() != 0) {
                e.this.v.W0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvFragmentHD.java */
    /* loaded from: classes2.dex */
    public class o implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.player.j.i f5444a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bundle f5445b;

        /* compiled from: TvFragmentHD.java */
        /* loaded from: classes2.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f5447a;

            a(String str) {
                this.f5447a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.v.d3();
                e.this.v.a2();
                e.this.v.K(this.f5447a);
                e.this.v.G(e.this.K.getChannelcode());
                e.this.v.E();
                e.this.v.D2();
            }
        }

        /* compiled from: TvFragmentHD.java */
        /* loaded from: classes2.dex */
        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f5449a;

            b(String str) {
                this.f5449a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.v.d3();
                e.this.v.I(this.f5449a);
                e.this.v.E();
                e.this.v.D2();
            }
        }

        /* compiled from: TvFragmentHD.java */
        /* loaded from: classes2.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LogEx.d(e.this.p, "Test the starting speed : queryTvBlackout back");
                e.this.v.d3();
                e.this.v.Z1();
                e.this.v.f0();
                com.zte.iptvclient.android.common.player.f fVar = e.this.B;
                o oVar = o.this;
                fVar.a(oVar.f5444a, oVar.f5445b, ((com.zte.fragmentlib.b) e.this).h, e.this.getChildFragmentManager(), e.this.u.getId(), e.this.v);
            }
        }

        /* compiled from: TvFragmentHD.java */
        /* loaded from: classes2.dex */
        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.v.d3();
                e.this.v.a2();
                e.this.v.H2();
                e.this.v.E();
                e.this.v.D2();
            }
        }

        o(com.zte.iptvclient.android.common.player.j.i iVar, Bundle bundle) {
            this.f5444a = iVar;
            this.f5445b = bundle;
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void j() {
            ((com.zte.fragmentlib.b) e.this).h.runOnUiThread(new c());
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void k(String str) {
            LogEx.d(e.this.p, "tv blackout查询展示black照片:" + str);
            ((com.zte.fragmentlib.b) e.this).h.runOnUiThread(new a(str));
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void l() {
            LogEx.d(e.this.p, "get Detail BlackoutInfo is null （pic url or play url is null）");
            ((com.zte.fragmentlib.b) e.this).h.runOnUiThread(new d());
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void r(String str) {
            LogEx.d(e.this.p, "tv blackout查询播放black片源" + str);
            ((com.zte.fragmentlib.b) e.this).h.runOnUiThread(new b(str));
        }
    }

    private void I() {
        ((MainActivity) this.h).v();
        com.zte.iptvclient.android.common.player.k.c cVar = this.v;
        if (cVar != null) {
            cVar.x2();
            this.v.g(false);
            this.v.d3();
        }
    }

    private void J() {
        com.zte.iptvclient.android.common.javabean.b bVar = new com.zte.iptvclient.android.common.javabean.b();
        ArrayList<com.zte.iptvclient.android.common.javabean.models.c> arrayList = this.F;
        if (arrayList != null && arrayList.size() > 0) {
            this.U = this.F.get(0).d();
            bVar.a(this.F.get(0).f());
            bVar.d(this.F.get(0).d());
            bVar.b("2");
            bVar.g(this.F.get(0).p());
            bVar.e(this.F.get(0).e());
            bVar.f("0");
            com.zte.iptvclient.android.common.f.b.a aVar = new com.zte.iptvclient.android.common.f.b.a(this.h, bVar, new d(), this);
            this.R = aVar;
            aVar.a(this.N);
            this.R.a();
            return;
        }
        a("2", -1);
    }

    private void K() {
        com.zte.iptvclient.android.common.javabean.b bVar = new com.zte.iptvclient.android.common.javabean.b();
        if (this.E != null) {
            if (this.S == null) {
                this.S = new PrevueBean();
            }
            this.S.setPrevuecode(this.E.get(0).l());
            bVar.e(String.valueOf(this.E.get(0).m()));
            bVar.g(this.E.get(0).p());
            bVar.b("4");
            bVar.a(this.E.get(0).e());
            bVar.d(this.E.get(0).l());
            com.zte.iptvclient.android.common.f.b.a aVar = new com.zte.iptvclient.android.common.f.b.a(this.h, bVar, new c(), this);
            this.R = aVar;
            aVar.a(this.N);
            this.R.a();
            return;
        }
        a("2", -1);
    }

    private void L() {
        if (this.h == null) {
            return;
        }
        new com.zte.iptvclient.android.common.j.h(this.h);
        "1".equals(ConfigMgr.readPropertie("IsShowChildLock"));
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.J = com.zte.iptvclient.android.common.f.b.b.j();
    }

    private void M() {
        SupportActivity supportActivity = this.h;
        this.w = new TVScheduleProgramesView(supportActivity, supportActivity);
        SupportActivity supportActivity2 = this.h;
        this.x = new com.zte.iptvclient.android.mobile.tv.ui.a(supportActivity2, supportActivity2, this);
        this.s.addView(this.w);
        this.t.addView(this.x);
    }

    private void N() {
        SupportActivity supportActivity;
        if (isHidden() || (supportActivity = this.h) == null) {
            return;
        }
        ((MainActivity) supportActivity).x();
        if (this.v == null) {
            P();
        }
        if (this.v != null) {
            LogEx.d(this.p, "###showLoading");
            this.v.D0();
            this.v.g2();
            this.v.L2();
        }
    }

    private void O() {
        if (isHidden() || this.h == null) {
            return;
        }
        if (this.v == null) {
            P();
        }
        if (this.v != null) {
            LogEx.d(this.p, "###hideLoading");
            this.v.d3();
            this.v.t("");
            this.v.Q2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        SupportActivity supportActivity = this.h;
        if (supportActivity == null) {
            return;
        }
        com.zte.iptvclient.android.common.player.k.c t = ((MainActivity) supportActivity).t();
        this.v = t;
        if (t == null) {
            return;
        }
        if (this.B == null) {
            this.B = new com.zte.iptvclient.android.common.player.f();
        }
        this.v.F1();
        this.v.a((c.o0) this);
        this.v.a((c.n0) this);
        this.v.a((b.a0) this);
        this.v.a((a.i) this);
        this.v.setTargetFragment(this, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        com.zte.iptvclient.android.common.player.k.c cVar;
        com.zte.iptvclient.android.common.player.k.c cVar2;
        com.zte.iptvclient.android.common.player.k.c cVar3;
        Bundle bundle = new Bundle();
        com.zte.iptvclient.android.common.javabean.models.c cVar4 = this.F.get(0);
        bundle.putString("playuri4dlna", com.zte.iptvclient.android.mobile.h.a.b.b(cVar4.i(), cVar4.p(), cVar4.d(), cVar4.f()));
        bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, !TextUtils.isEmpty(cVar4.c()) ? Integer.valueOf(cVar4.c()).intValue() : -1);
        bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, cVar4.j());
        LogEx.d(this.p, "play tv contentcode is " + cVar4.d());
        if (this.F.size() == 1 && com.zte.iptvclient.android.common.player.f.c(this.F.get(0).g())) {
            LogEx.d(this.p, "Definition =" + this.F.get(0).g());
            com.zte.iptvclient.android.common.player.k.c cVar5 = this.v;
            if (cVar5 != null) {
                cVar5.j(0);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<com.zte.iptvclient.android.common.javabean.models.c> it2 = this.F.iterator();
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
        if (arrayList.size() == 0 && this.F.size() > arrayList.size() && (cVar3 = this.v) != null) {
            cVar3.j(0);
            return;
        }
        if (!this.B.a(this.F.get(0).b()) && (cVar2 = this.v) != null) {
            cVar2.j(1);
            return;
        }
        com.zte.iptvclient.android.common.player.k.c cVar6 = this.v;
        if ((cVar6 == null || cVar6.p0() >= 0) && (cVar = this.v) != null) {
            cVar.f(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        com.zte.iptvclient.android.common.player.k.c cVar;
        com.zte.iptvclient.android.common.player.k.c cVar2;
        com.zte.iptvclient.android.common.player.k.c cVar3;
        Bundle bundle = new Bundle();
        if (this.E.size() == 1 && com.zte.iptvclient.android.common.player.f.c(this.E.get(0).f())) {
            LogEx.d(this.p, "Definition =" + this.E.get(0).f());
            com.zte.iptvclient.android.common.player.k.c cVar4 = this.v;
            if (cVar4 != null) {
                cVar4.j(0);
                return;
            }
        }
        bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, this.E.get(0).k());
        ArrayList arrayList = new ArrayList();
        Iterator<com.zte.iptvclient.android.common.javabean.models.d> it2 = this.E.iterator();
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
        if (arrayList.size() == 0 && this.E.size() > arrayList.size() && (cVar3 = this.v) != null) {
            cVar3.j(0);
            return;
        }
        if (!this.B.a(s(this.E.get(0).c())) && (cVar2 = this.v) != null) {
            cVar2.j(1);
            return;
        }
        com.zte.iptvclient.android.common.player.k.c cVar5 = this.v;
        if ((cVar5 == null || cVar5.p0() >= 0) && (cVar = this.v) != null) {
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
            if (this.v == null) {
                P();
            }
        }
        if (this.z == 0 && this.A == 0 && (frameLayout = this.r) != null) {
            frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new b());
            return;
        }
        if (this.v == null) {
            P();
        }
        com.zte.iptvclient.android.common.player.k.c cVar = this.v;
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
        com.zte.iptvclient.android.common.player.k.c cVar3;
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.j());
        ArrayList<com.zte.iptvclient.android.common.javabean.models.c> arrayList = this.F;
        if (arrayList != null && !arrayList.isEmpty() && (cVar = this.v) != null) {
            cVar.G("");
            if (isHidden() && !this.v.A) {
                LogEx.e(this.p, "view is hidden");
                return;
            }
            if (this.B == null) {
                this.B = new com.zte.iptvclient.android.common.player.f();
            }
            Bundle bundle = new Bundle();
            com.zte.iptvclient.android.common.javabean.models.c cVar4 = this.F.get(0);
            if (cVar4 == null) {
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
                    if (TextUtils.equals(b2.get(i2).getChannelcode(), cVar4.d())) {
                        channel = b2.get(i2);
                        break;
                    }
                    i2++;
                }
            }
            if (channel != null) {
                bundle.putString("tv_name", cVar4.e());
                bundle.putString("usermixno", channel.getUsermixno());
                LogEx.d(this.p, "current toPlay selectedChnnelcode=" + channel.getChannelcode());
            }
            bundle.putString("programname", cVar4.l());
            bundle.putString("isprotection", cVar4.h());
            bundle.putString("supportTimeShift", cVar4.q());
            bundle.putString(ParamConst.CHANNEL_INFO_RSP_TSAVAILABLE, cVar4.r());
            bundle.putString("playuri4dlna", com.zte.iptvclient.android.mobile.h.a.b.b(cVar4.i(), cVar4.p(), cVar4.d(), cVar4.f()));
            bundle.putString("telecomcode", cVar4.p());
            bundle.putString("poster_image", cVar4.k());
            bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, TextUtils.isEmpty(cVar4.c()) ? -1 : Integer.valueOf(cVar4.c()).intValue());
            bundle.putString("contentcode", cVar4.d());
            bundle.putString("ratingid", cVar4.n());
            LogEx.d(this.p, "ratingid is :" + cVar4.n());
            bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, cVar4.j());
            bundle.putBoolean("isClick", this.T);
            bundle.putString("productVIP", cVar4.m());
            bundle.putString("channelcode", cVar4.d());
            bundle.putString("mixno", cVar4.i());
            LogEx.d(this.p, "playChannelBean.getMixno= " + cVar4.i());
            LogEx.d(this.p, "play tv Channelcode is " + cVar4.d());
            bundle.putString("systemlimitenable", cVar4.o());
            bundle.putBoolean("isFromLastPrevue", this.X);
            String str = this.V;
            if (str != null) {
                bundle.putString("liveBeginTime", str);
            }
            bundle.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_TV.getIntValue()));
            bundle.putString("channelcode", cVar4.d());
            if (this.F.size() == 1 && com.zte.iptvclient.android.common.player.f.c(this.F.get(0).g())) {
                LogEx.d(this.p, "Definition =" + this.F.get(0).g());
                com.zte.iptvclient.android.common.player.k.c cVar5 = this.v;
                if (cVar5 != null) {
                    cVar5.j(0);
                    return;
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.zte.iptvclient.android.common.javabean.models.c> it2 = this.F.iterator();
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
            if (arrayList2.size() == 0 && this.F.size() > arrayList2.size() && (cVar3 = this.v) != null) {
                cVar3.j(0);
                return;
            }
            if (!this.B.a(this.F.get(0).b()) && (cVar2 = this.v) != null) {
                cVar2.j(1);
                return;
            }
            com.zte.iptvclient.android.common.player.k.c cVar6 = this.v;
            if (cVar6 == null || cVar6.p0() >= 0) {
                com.zte.iptvclient.android.common.player.j.i iVar = new com.zte.iptvclient.android.common.player.j.i();
                iVar.b(cVar4.d());
                bundle.putString("columncode", cVar4.f());
                iVar.a(cVar4.f());
                LogEx.d(this.p, "COLUMNCODE= " + cVar4.f());
                if (!TextUtils.isEmpty(cVar4.a())) {
                    try {
                        if (Integer.valueOf(cVar4.a()).intValue() > 0 && TextUtils.equals("1", ConfigMgr.readPropertie("isSupportQueryAds"))) {
                            this.B.a(true);
                        } else {
                            this.B.a(false);
                        }
                    } catch (Exception unused) {
                        this.B.a(false);
                    }
                }
                this.v.a(new n());
                if (this.x == null) {
                    return;
                }
                if (this.D || isHidden()) {
                    bundle.putString("isNotNeedToSwitch", "2");
                }
                if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
                    LogEx.d(this.p, "enter blackout");
                    LogEx.d(this.p, "Test the starting speed : start queryTvBlackout");
                    this.J.a(cVar4.d(), new o(iVar, bundle));
                    return;
                } else {
                    this.v.Z1();
                    this.v.d3();
                    LogEx.d(this.p, "beginPlayTVInSmallScreen");
                    this.B.a(iVar, bundle, this.h, getChildFragmentManager(), this.u.getId(), this.v);
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
        ArrayList<com.zte.iptvclient.android.common.javabean.models.d> arrayList = this.E;
        if (arrayList != null && !arrayList.isEmpty()) {
            com.zte.iptvclient.android.common.javabean.models.d dVar = this.E.get(0);
            String a2 = dVar.a();
            LogEx.d(this.p, "onDataReturn: channelAuthId=" + a2);
            if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
                this.J.a(dVar.c());
            }
            if (this.B == null) {
                this.B = new com.zte.iptvclient.android.common.player.f();
            }
            Bundle bundle = new Bundle();
            if (this.E.size() == 1 && com.zte.iptvclient.android.common.player.f.c(this.E.get(0).f())) {
                LogEx.d(this.p, "Definition =" + this.E.get(0).f());
                com.zte.iptvclient.android.common.player.k.c cVar3 = this.v;
                if (cVar3 != null) {
                    cVar3.j(0);
                    return;
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.zte.iptvclient.android.common.javabean.models.d> it2 = this.E.iterator();
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
            if (arrayList2.size() == 0 && this.E.size() > arrayList2.size() && (cVar2 = this.v) != null) {
                cVar2.j(0);
                return;
            }
            if (!this.B.a(s(this.E.get(0).c())) && (cVar = this.v) != null) {
                cVar.j(1);
                return;
            }
            com.zte.iptvclient.android.common.player.k.c cVar4 = this.v;
            if (cVar4 == null || cVar4.p0() >= 0) {
                bundle.putString("bookmark_breakpoint", String.valueOf(this.G));
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
                    if (this.D) {
                        bundle.putString("isNotNeedToSwitch", "2");
                    }
                }
                bundle.putString("prevuecode", dVar.l());
                bundle.putBoolean("IsUesMutliWindowToPlay", false);
                bundle.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_TVOD.getIntValue()));
                bundle.putString("prevue_name", dVar.m());
                bundle.putString("tv_id", dVar.c());
                bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, dVar.k());
                bundle.putBoolean("isClick", this.T);
                bundle.putString("isprotection", dVar.h());
                bundle.putString("contentcode", dVar.l());
                bundle.putString("productVIP", dVar.n());
                bundle.putString("prevueratingid", dVar.o());
                LogEx.d(this.p, "play tvod contentcode is " + dVar.l());
                bundle.putString("cmsid", dVar.d());
                bundle.putString("physicalcontentid", dVar.j());
                String b3 = dVar.b();
                bundle.putString("prevuebegintime", b3);
                String g2 = dVar.g();
                bundle.putString("prevueendtime", g2);
                bundle.putString(ParamConst.NPVR_QUERY_RSP_DURATION, x.c(b3, "yyyy.MM.dd HH:mm:ss", "HH:mm", 1) + "-" + x.c(g2, "yyyy.MM.dd HH:mm:ss", "HH:mm", 1));
                bundle.putString("channelcode", c2);
                String p = dVar.p();
                bundle.putString("playuri4dlna", com.zte.iptvclient.android.mobile.h.a.b.a(dVar.l(), c2, p, x.c(b3, "yyyy.MM.dd HH:mm:ss", "yyyyMMddHHmmss", 1), x.c(g2, "yyyy.MM.dd HH:mm:ss", "yyyyMMddHHmmss", 1)));
                bundle.putString("telecomcode", p);
                bundle.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_TVOD));
                com.zte.iptvclient.android.common.player.j.j jVar = new com.zte.iptvclient.android.common.player.j.j();
                jVar.b(dVar.c());
                jVar.a(dVar.e());
                jVar.c("1");
                if (channel != null && !TextUtils.isEmpty(channel.getAdvertisecontent())) {
                    LogEx.d(this.p, " getAdvertisecontent " + channel.getAdvertisecontent());
                    try {
                        this.B.a(Integer.valueOf(channel.getAdvertisecontent()).intValue() > 0 && TextUtils.equals("1", ConfigMgr.readPropertie("isSupportQueryAds")));
                    } catch (Exception unused) {
                        this.B.a(false);
                    }
                }
                if (TextUtils.equals("1", ConfigMgr.readPropertie("SuportTvoDAddBookMark", "0"))) {
                    this.B.b(true);
                } else {
                    this.B.b(false);
                }
                if (this.v == null) {
                    return;
                }
                LogEx.d(this.p, "beginPlayTVInSmallScreen");
                this.v.a(new k());
                this.v.a(new l());
                if (TextUtils.equals("1", ConfigMgr.readPropertie("SuportTvoDAddBookMark", "0"))) {
                    this.B.b(true);
                } else {
                    this.B.b(false);
                }
                if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
                    LogEx.d(this.p, "Test the starting speed : start queryTvodBlackout");
                    com.zte.iptvclient.android.common.f.b.b.j().a(c2, s.b(), new m(jVar, bundle));
                    return;
                } else {
                    com.zte.iptvclient.android.common.h.b.a().a(this.v);
                    this.v.d3();
                    this.v.Z1();
                    this.B.a(jVar, bundle, (Context) this.h, getChildFragmentManager(), this.u.getId(), this.v);
                    return;
                }
            }
            return;
        }
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.no_program_available);
        O();
    }

    private void W() {
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            return;
        }
        com.zte.iptvclient.android.common.player.k.c cVar = this.v;
        if (cVar != null) {
            cVar.D0();
        }
        Channel channel = this.K;
        if (channel == null) {
            return;
        }
        this.U = channel.getChannelcode();
        this.W = this.L.getColumnCode();
        if (!com.zte.iptvclient.android.mobile.n.c.b.t() && this.v != null) {
            LogEx.i(this.p, "showLoginToPlayView return ");
            this.v.N2();
            return;
        }
        LogEx.d(this.p, "current toPlay selectedChnnelcode = " + this.U);
        e(this.U, this.K.getRatingid());
        com.zte.iptvclient.android.common.javabean.e.f4731b = null;
        com.zte.iptvclient.android.common.javabean.e.f4730a = true;
        TVScheduleProgramesView tVScheduleProgramesView = this.w;
        if (tVScheduleProgramesView != null) {
            tVScheduleProgramesView.c();
        }
        this.x.a((PrevueBean) null);
    }

    private void X() {
        LogEx.d(this.p, "updateChannelLivePlayUrl" + this.U);
        ArrayList<com.zte.iptvclient.android.common.javabean.models.c> arrayList = this.F;
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
        if (this.W.startsWith(propertiesInfo)) {
            hashMap.put("columncode", this.W);
        }
        sDKChannelMgr.getChannelDetailWithURl(hashMap, new f());
    }

    private void Y() {
        TVScheduleProgramesView tVScheduleProgramesView = this.w;
        if (tVScheduleProgramesView != null) {
            tVScheduleProgramesView.a(this.L, this.K);
        }
    }

    private void Z() {
        if (this.E.size() > 0) {
            this.E.clear();
        }
        SDKPrevueMgr sDKPrevueMgr = new SDKPrevueMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("prevuecode", this.S.getPrevuecode());
        hashMap.put("recommendtype", "0");
        LogEx.d(this.p, "updateChannelTvodPlayUrl" + this.S.getPrevuecode());
        sDKPrevueMgr.getPrevueDetailWithUrl(hashMap, new C0181e());
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        L();
        this.u = ((MainActivity) this.h).u();
        ((MainActivity) this.h).x();
        if (this.v == null) {
            P();
        }
        com.zte.iptvclient.android.common.player.k.c cVar = this.v;
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
        if (getArguments() != null) {
            getArguments().getString(ParamConst.SEARCH_RSP_ITEM_CHANNELCODE);
        }
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        if (this.C == null) {
            this.C = layoutInflater.inflate(R.layout.tv_fragment_hd_layout, viewGroup, false);
            a(R.id.frame_top_navbar, (com.zte.fragmentlib.b) new com.zte.iptvclient.android.mobile.l.b.a(), false);
            if (BaseApp.a(this.h)) {
                FrameLayout frameLayout = (FrameLayout) this.C.findViewById(R.id.frame_top_navbar);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = r.a(getContext()) / 2;
                    frameLayout.setLayoutParams(layoutParams);
                }
            }
            d(this.C);
            M();
        }
        return this.C;
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
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e2) {
            throw new RuntimeException(e2);
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
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.j());
            I();
            this.Q = false;
        } else {
            S();
            if (this.z == 0 && this.A == 0) {
                this.r.getViewTreeObserver().addOnGlobalLayoutListener(new a());
            }
            if (!com.zte.iptvclient.android.mobile.n.c.b.t() && (cVar = this.v) != null) {
                cVar.N2();
                return;
            }
            if (isHidden()) {
                LogEx.e(this.p, "current  is Hidden unable Play !");
                return;
            }
            LogEx.d(this.p, "current is not Hidden text Play showPlayerFragment");
            if (!this.Q) {
                W();
            }
            this.x.a((PrevueBean) null);
            com.zte.iptvclient.android.common.javabean.e.f4731b = null;
            com.zte.iptvclient.android.common.javabean.e.f4730a = true;
            this.x.b();
            this.x.a(this.K);
            this.x.a();
        }
        super.onHiddenChanged(z);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }

    private void d(View view) {
        this.q = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        this.P = a2;
        if (a2 <= 0) {
            this.P = 60;
        }
        this.q.setHeight(this.P);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.ll_nav_bar);
        this.N = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
        ((TextView) view.findViewById(R.id.top_navbar_title_txt)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_pad));
        this.O = (FrameLayout) view.findViewById(R.id.frame_top_navbar);
        this.N.getViewTreeObserver().addOnGlobalLayoutListener(new g());
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.tv_play_base_container);
        this.r = frameLayout;
        com.zte.iptvclient.common.uiframe.f.a(frameLayout);
        this.r.setVisibility(0);
        this.s = (FrameLayout) view.findViewById(R.id.tv_schedule_programes_container);
        this.t = (FrameLayout) view.findViewById(R.id.tv_channel_list_container);
    }

    private void e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.S = null;
        if (!com.zte.iptvclient.android.mobile.n.c.b.t() && this.v != null) {
            LogEx.i(this.p, "showLoginToPlayView return ");
            this.v.N2();
            return;
        }
        N();
        LogEx.d(this.p, "deailLiveChannelPlay " + str);
        t(str);
        Y = str;
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
        ArrayList<com.zte.iptvclient.android.common.javabean.models.c> arrayList = this.F;
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
        if (this.W.startsWith(propertiesInfo)) {
            hashMap.put("columncode", this.W);
        }
        LogEx.d(this.p, "Test the starting speed : start ChannelDetailWithURl");
        sDKChannelMgr.getChannelDetailWithURl(hashMap, new i());
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public int i() {
        return this.z;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.n.a aVar) {
        if (TabHostManager.TabName.TV.equals(aVar.a())) {
            this.Q = true;
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.j jVar) {
        com.zte.iptvclient.android.mobile.tv.ui.a aVar = this.x;
        if (aVar != null) {
            aVar.a(jVar.a());
        }
    }

    private void a(String str, boolean z) {
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.j());
        LogEx.d("Test the starting speed", "[PAD]startPlay for TVOD");
        if (this.E.size() > 0) {
            this.E.clear();
        }
        SDKPrevueMgr sDKPrevueMgr = new SDKPrevueMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("prevuecode", str);
        hashMap.put("mediaservices", "2");
        hashMap.put("recommendtype", z ? "1" : "0");
        LogEx.d(this.p, "Test the starting speed : start queryTvodDetailWithUrl");
        sDKPrevueMgr.getPrevueDetailWithUrl(hashMap, new j());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.m mVar) {
        if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            t.a(this.h, new h(this));
        } else {
            if (this.S != null) {
                SupportActivity supportActivity = this.h;
                this.y = new com.zte.iptvclient.android.mobile.e0.e.l(supportActivity, supportActivity, this.S.getPrevuecode());
            } else {
                SupportActivity supportActivity2 = this.h;
                this.y = new com.zte.iptvclient.android.mobile.e0.e.l(supportActivity2, supportActivity2, this.K.getChannelcode());
            }
            this.t.addView(this.y);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public int e() {
        int[] iArr = new int[2];
        this.r.getLocationInWindow(iArr);
        return iArr[1];
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.b bVar) {
        this.S = bVar.a();
        this.T = bVar.b();
        if (TextUtils.isEmpty(this.S.getPrevuecode())) {
            return;
        }
        if (!com.zte.iptvclient.android.mobile.n.c.b.t() && this.v != null) {
            LogEx.i(this.p, "showLoginToPlayView return ");
            this.v.N2();
            return;
        }
        N();
        this.G = this.S.getPrevuebreakpoint();
        a(this.S.getPrevuecode(), false);
        Y = this.S.getChannelcode();
        LogEx.d(this.p, "current toPlay selectedChnnelcode=" + Y);
        com.zte.iptvclient.android.common.javabean.e.f4731b = this.S;
        com.zte.iptvclient.android.common.javabean.e.f4730a = false;
        TVScheduleProgramesView tVScheduleProgramesView = this.w;
        if (tVScheduleProgramesView != null) {
            tVScheduleProgramesView.c();
            this.w.a(this.S.getBegintime());
            this.w.a();
        }
        this.x.a(this.S);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, boolean z) {
        Channel channel;
        LogEx.d(this.p, "onPlayNextTvod PrevueCode " + str + " forChannelCode= " + str2);
        if (this.w == null || (channel = this.K) == null || !TextUtils.equals(channel.getChannelcode(), str2)) {
            return;
        }
        this.w.a(str, str2, str3, z);
    }

    @Override // com.zte.iptvclient.android.mobile.tv.ui.a.m
    public void d() {
        com.zte.iptvclient.android.common.player.k.c cVar;
        if (isHidden()) {
            LogEx.e(this.p, "current  is Hidden unable Play !");
            return;
        }
        LogEx.d(this.p, "current is not Hidden text Play showPlayerFragment");
        if (this.K != null) {
            S();
            if (!com.zte.iptvclient.android.mobile.n.c.b.t() && (cVar = this.v) != null) {
                cVar.N2();
                return;
            } else {
                this.W = this.K.getColumncode();
                e(this.K.getChannelcode(), this.K.getRatingid());
                return;
            }
        }
        LogEx.e(this.p, "mCurSelectedChannel is null!");
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
        this.D = true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.g gVar) {
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            return;
        }
        com.zte.iptvclient.android.common.player.k.c cVar = this.v;
        if (cVar != null) {
            cVar.D0();
        }
        this.X = gVar.f();
        this.U = gVar.b();
        this.W = gVar.d();
        this.V = gVar.a();
        this.T = gVar.e();
        if (!com.zte.iptvclient.android.mobile.n.c.b.t() && this.v != null) {
            LogEx.i(this.p, "showLoginToPlayView return ");
            this.v.N2();
            return;
        }
        LogEx.d(this.p, "current toPlay selectedChnnelcode = " + this.U);
        e(this.U, gVar.c());
        com.zte.iptvclient.android.common.javabean.e.f4731b = null;
        com.zte.iptvclient.android.common.javabean.e.f4730a = true;
        TVScheduleProgramesView tVScheduleProgramesView = this.w;
        if (tVScheduleProgramesView != null) {
            tVScheduleProgramesView.c();
        }
        this.x.a((PrevueBean) null);
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public void a(boolean z) {
        this.v.T1();
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
        this.D = false;
        SupportActivity supportActivity2 = this.h;
        if (supportActivity2 != null) {
            ((MainActivity) supportActivity2).b(this.M);
        }
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.e(false));
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.f(false));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.h hVar) {
        com.zte.iptvclient.android.common.player.k.c cVar = this.v;
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
        com.zte.iptvclient.android.common.player.k.c cVar2 = this.v;
        if (cVar2 != null) {
            cVar2.i0();
        }
        Y = hVar.a();
        LogEx.i(this.p, "event " + hVar.a());
    }

    @Override // com.zte.iptvclient.android.mobile.tv.ui.a.m
    public void a(ColumnBean columnBean, Channel channel) {
        this.K = channel;
        this.L = columnBean;
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

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.f fVar) {
        com.zte.iptvclient.android.common.player.k.c cVar;
        if (this.v == null || this.u == null || isHidden()) {
            return;
        }
        if ("play".equals(fVar.b())) {
            this.u.setVisibility(0);
            if (!com.zte.iptvclient.android.mobile.n.c.b.t() && (cVar = this.v) != null) {
                cVar.N2();
                return;
            } else if (fVar.a()) {
                this.v.X0();
                return;
            } else {
                U();
                return;
            }
        }
        if ("pause".equals(fVar.b())) {
            this.u.setVisibility(8);
            this.v.W0();
            com.zte.iptvclient.android.common.player.k.c cVar2 = this.v;
            if (cVar2.e0 || cVar2.P8) {
                return;
            }
            cVar2.x2();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        if (cVar.a().equals("0")) {
            this.v.m0();
            this.x.b();
            if (isHidden()) {
                return;
            }
            LogEx.d(this.p, "LoginReturnEvent success for re startPlay");
            d();
        }
    }
}
