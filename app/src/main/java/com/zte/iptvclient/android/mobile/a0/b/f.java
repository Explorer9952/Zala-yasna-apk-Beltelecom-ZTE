package com.zte.iptvclient.android.mobile.a0.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
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
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.k.s;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.common.player.k.a;
import com.zte.iptvclient.android.common.player.k.b;
import com.zte.iptvclient.android.common.player.k.c;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.a0.b.a;
import com.zte.iptvclient.android.mobile.home.tab.helper.TabHostManager;
import com.zte.iptvclient.android.mobile.login.activity.LoginActivity;
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

/* compiled from: TvMainChildFragment.java */
/* loaded from: classes.dex */
public class f extends com.zte.fragmentlib.b implements a.f, b.a0, a.i, c.o0, a.h, c.n0 {
    private com.zte.iptvclient.android.common.j.h A;
    private com.zte.iptvclient.android.common.f.b.a J;
    private PrevueBean K;
    private com.zte.iptvclient.android.common.player.k.c q;
    private RelativeLayout r;
    private RelativeLayout s;
    private int v;
    private View y;
    private String p = "TvMainChildFragment";
    private int t = 0;
    private int u = 0;
    private com.zte.iptvclient.android.common.player.f w = null;
    private com.zte.iptvclient.android.mobile.a0.b.a x = null;
    private View z = null;
    private ArrayList<com.zte.iptvclient.android.common.javabean.models.d> B = new ArrayList<>();
    private ArrayList<com.zte.iptvclient.android.common.javabean.models.c> C = new ArrayList<>();
    public boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private long G = 0;
    private String L = "";
    private String M = "";
    private Handler N = new g();
    Runnable O = new i();
    Runnable P = new e();
    Runnable Q = new RunnableC0183f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvMainChildFragment.java */
    /* loaded from: classes2.dex */
    public class a implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.player.j.j f5453a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bundle f5454b;

        /* compiled from: TvMainChildFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.a0.b.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0182a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f5456a;

            RunnableC0182a(String str) {
                this.f5456a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.q.d3();
                f.this.q.a2();
                f.this.q.K(this.f5456a);
                f.this.q.E();
                f.this.q.D2();
            }
        }

        /* compiled from: TvMainChildFragment.java */
        /* loaded from: classes2.dex */
        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f5458a;

            b(String str) {
                this.f5458a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.q.d3();
                f.this.q.I(this.f5458a);
                f.this.q.E();
                f.this.q.D2();
            }
        }

        /* compiled from: TvMainChildFragment.java */
        /* loaded from: classes2.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LogEx.d(f.this.p, "Test the starting speed : querytvodBlackout back coutinue play");
                f.this.q.d3();
                com.zte.iptvclient.android.common.f.b.b.j().h();
                f.this.q.Z1();
                com.zte.iptvclient.android.common.h.b.a().a(f.this.q);
                com.zte.iptvclient.android.common.player.f fVar = f.this.w;
                a aVar = a.this;
                fVar.a(aVar.f5453a, aVar.f5454b, (Context) ((com.zte.fragmentlib.b) f.this).h, f.this.getChildFragmentManager(), f.this.s.getId(), f.this.q);
            }
        }

        /* compiled from: TvMainChildFragment.java */
        /* loaded from: classes2.dex */
        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.q.d3();
                f.this.q.H2();
                f.this.q.a2();
                f.this.q.E();
                f.this.q.D2();
            }
        }

        a(com.zte.iptvclient.android.common.player.j.j jVar, Bundle bundle) {
            this.f5453a = jVar;
            this.f5454b = bundle;
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void j() {
            LogEx.d(f.this.p, "tvod blackout无策略，正常播放");
            ((com.zte.fragmentlib.b) f.this).h.runOnUiThread(new c());
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void k(String str) {
            LogEx.d(f.this.p, "tvod blackout查询展示black照片:" + str);
            ((com.zte.fragmentlib.b) f.this).h.runOnUiThread(new RunnableC0182a(str));
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void l() {
            LogEx.d(f.this.p, "get Detail BlackoutInfo is null （pic url or play url is null）");
            ((com.zte.fragmentlib.b) f.this).h.runOnUiThread(new d());
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void r(String str) {
            LogEx.d(f.this.p, "tvod blackout查询播放black片源" + str);
            ((com.zte.fragmentlib.b) f.this).h.runOnUiThread(new b(str));
        }
    }

    /* compiled from: TvMainChildFragment.java */
    /* loaded from: classes2.dex */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            f.this.r.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            f fVar = f.this;
            fVar.t = fVar.r.getHeight();
            f fVar2 = f.this;
            fVar2.u = fVar2.r.getWidth();
            if (((com.zte.fragmentlib.b) f.this).h != null) {
                ((MainActivity) ((com.zte.fragmentlib.b) f.this).h).c(f.this.u, f.this.t);
                ((MainActivity) ((com.zte.fragmentlib.b) f.this).h).b(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvMainChildFragment.java */
    /* loaded from: classes2.dex */
    public class c implements com.zte.iptvclient.android.mobile.order.helper.c {
        c() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.helper.c
        public void a(int i, String str) {
            f.this.a("4", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvMainChildFragment.java */
    /* loaded from: classes2.dex */
    public class d implements com.zte.iptvclient.android.mobile.order.helper.c {
        d() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.helper.c
        public void a(int i, String str) {
            LogEx.d(f.this.p, "payCallback");
            f.this.a("2", i);
        }
    }

    /* compiled from: TvMainChildFragment.java */
    /* loaded from: classes2.dex */
    class e implements Runnable {

        /* compiled from: TvMainChildFragment.java */
        /* loaded from: classes2.dex */
        class a implements SDKChannelMgr.OnChannelDetailWithUrlReturnListener {
            a() {
            }

            @Override // com.video.androidsdk.service.channel.SDKChannelMgr.OnChannelDetailWithUrlReturnListener
            public void onChannelDetailWithUrlReturn(String str, String str2, String str3) {
                LogEx.d(f.this.p, " onChannelDetailWithUrlReturn " + str3);
                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("returncode", str);
                bundle.putString("errmsg", str2);
                bundle.putString("msg", str3);
                message.what = 2;
                message.setData(bundle);
                f.this.N.sendMessage(message);
            }
        }

        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SDKChannelMgr sDKChannelMgr = new SDKChannelMgr();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("channelcode", f.this.L);
            String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Radio_Column");
            if (propertiesInfo == null) {
                propertiesInfo = "";
            }
            if (f.this.M.startsWith(propertiesInfo)) {
                hashMap.put("columncode", f.this.M);
            }
            sDKChannelMgr.getChannelDetailWithURl(hashMap, new a());
        }
    }

    /* compiled from: TvMainChildFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.a0.b.f$f, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class RunnableC0183f implements Runnable {

        /* compiled from: TvMainChildFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.a0.b.f$f$a */
        /* loaded from: classes2.dex */
        class a implements SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener {
            a() {
            }

            @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener
            public void onPrevueDetailWithUrlReturn(String str, String str2, String str3) {
                LogEx.d(f.this.p, " onPrevueDetailWithUrlReturn " + str3);
                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("returncode", str);
                bundle.putString("errormsg", str2);
                bundle.putString("msg", str3);
                message.what = 3;
                message.setData(bundle);
                f.this.N.sendMessage(message);
            }
        }

        RunnableC0183f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.B.size() > 0) {
                f.this.B.clear();
            }
            SDKPrevueMgr sDKPrevueMgr = new SDKPrevueMgr();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("prevuecode", f.this.K.getPrevuecode());
            hashMap.put("recommendtype", "0");
            sDKPrevueMgr.getPrevueDetailWithUrl(hashMap, new a());
        }
    }

    /* compiled from: TvMainChildFragment.java */
    /* loaded from: classes2.dex */
    class g extends Handler {
        g() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            JSONArray jSONArray;
            String str2 = "productList";
            super.handleMessage(message);
            if (message.what == 1) {
                Bundle data = message.getData();
                LogEx.d(f.this.p, "getChannelDetailWithURl returncode= " + data.getString("returncode") + "  errmsg " + data.getString("errmsg") + "  msg " + message);
                if (f.this.C != null) {
                    f.this.C.clear();
                } else {
                    f.this.C = new ArrayList();
                }
                if ("0".equals(data.getString("returncode"))) {
                    try {
                        JSONArray jSONArray2 = new JSONObject(data.getString("msg")).getJSONArray("data");
                        int i = 0;
                        while (i < jSONArray2.length()) {
                            JSONObject jSONObject = jSONArray2.getJSONObject(i);
                            com.zte.iptvclient.android.common.javabean.models.c a2 = com.zte.iptvclient.android.common.javabean.models.c.a(jSONObject);
                            if (a2 == null) {
                                str = str2;
                                jSONArray = jSONArray2;
                            } else {
                                a2.r("0");
                                if (jSONObject.has(str2)) {
                                    JSONArray jSONArray3 = jSONObject.getJSONArray(str2);
                                    str = str2;
                                    int i2 = 0;
                                    while (i2 < jSONArray3.length()) {
                                        jSONArray = jSONArray2;
                                        String optString = jSONArray3.getJSONObject(i2).optString("productname");
                                        if (optString != null && optString.contains("VIP")) {
                                            a2.r("1");
                                            break;
                                        } else {
                                            i2++;
                                            jSONArray2 = jSONArray;
                                        }
                                    }
                                } else {
                                    str = str2;
                                }
                                jSONArray = jSONArray2;
                                f.this.C.add(a2);
                            }
                            i++;
                            str2 = str;
                            jSONArray2 = jSONArray;
                        }
                    } catch (Exception e) {
                        LogEx.e(f.this.p, e.getMessage());
                    }
                }
                f.this.Q();
            }
            if (message.what == 2) {
                Bundle data2 = message.getData();
                LogEx.d(f.this.p, "getChannelDetailWithURl returncode= " + data2.getString("returncode") + "  errmsg " + data2.getString("errmsg") + "  msg " + message);
                if (f.this.C != null) {
                    f.this.C.clear();
                } else {
                    f.this.C = new ArrayList();
                }
                if ("0".equals(data2.getString("returncode"))) {
                    try {
                        JSONArray jSONArray4 = new JSONObject(data2.getString("msg")).getJSONArray("data");
                        for (int i3 = 0; i3 < jSONArray4.length(); i3++) {
                            com.zte.iptvclient.android.common.javabean.models.c a3 = com.zte.iptvclient.android.common.javabean.models.c.a(jSONArray4.getJSONObject(i3));
                            if (a3 != null) {
                                f.this.C.add(a3);
                            }
                        }
                    } catch (Exception e2) {
                        LogEx.e(f.this.p, e2.getMessage());
                    }
                }
                if (f.this.C.size() > 0) {
                    f.this.N();
                } else {
                    f.this.a("2", -1);
                }
            }
            if (message.what == 3) {
                Bundle data3 = message.getData();
                LogEx.d(f.this.p, "sdkQueryTvodById:  onDataReturn,arg0= " + message);
                if (TextUtils.equals(data3.getString("returncode"), "0")) {
                    try {
                        JSONArray jSONArray5 = new JSONObject(data3.getString("msg")).getJSONArray("data");
                        for (int i4 = 0; i4 < jSONArray5.length(); i4++) {
                            com.zte.iptvclient.android.common.javabean.models.d a4 = com.zte.iptvclient.android.common.javabean.models.d.a(jSONArray5.getJSONObject(i4));
                            if (a4 != null && !TextUtils.isEmpty(a4.k())) {
                                f.this.B.add(a4);
                            }
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        LogEx.e(f.this.p, e3.getMessage());
                    }
                }
                if (f.this.B.size() > 0) {
                    f.this.O();
                } else {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.query_tvod_info_fail);
                    f.this.a("4", -1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvMainChildFragment.java */
    /* loaded from: classes2.dex */
    public class h implements ViewTreeObserver.OnGlobalLayoutListener {
        h() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            f.this.r.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            f fVar = f.this;
            fVar.t = fVar.r.getHeight();
            f fVar2 = f.this;
            fVar2.u = fVar2.r.getWidth();
            if (((com.zte.fragmentlib.b) f.this).h != null) {
                ((MainActivity) ((com.zte.fragmentlib.b) f.this).h).c(f.this.u, f.this.t);
                ((MainActivity) ((com.zte.fragmentlib.b) f.this).h).b(0);
            }
        }
    }

    /* compiled from: TvMainChildFragment.java */
    /* loaded from: classes2.dex */
    class i implements Runnable {

        /* compiled from: TvMainChildFragment.java */
        /* loaded from: classes2.dex */
        class a implements SDKChannelMgr.OnChannelDetailWithUrlReturnListener {
            a() {
            }

            @Override // com.video.androidsdk.service.channel.SDKChannelMgr.OnChannelDetailWithUrlReturnListener
            public void onChannelDetailWithUrlReturn(String str, String str2, String str3) {
                LogEx.d(f.this.p, "Test the starting speed: query ChannelDetailWithUR back");
                LogEx.d(f.this.p, " onChannelDetailWithUrlReturn " + str3);
                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("returncode", str);
                bundle.putString("errmsg", str2);
                bundle.putString("msg", str3);
                message.what = 1;
                message.setData(bundle);
                f.this.N.sendMessage(message);
            }
        }

        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogEx.d(f.this.p, "Test the starting speed: start query ChannelDetailWithUR ");
            SDKChannelMgr sDKChannelMgr = new SDKChannelMgr();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("channelcode", f.this.L);
            String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Radio_Column");
            if (propertiesInfo == null) {
                propertiesInfo = "";
            }
            if (f.this.M.startsWith(propertiesInfo)) {
                hashMap.put("columncode", f.this.M);
            }
            sDKChannelMgr.getChannelDetailWithURl(hashMap, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvMainChildFragment.java */
    /* loaded from: classes2.dex */
    public class j implements a.h {
        j() {
        }

        @Override // com.zte.iptvclient.android.common.player.k.a.h
        public void a() {
            if (f.this.s.getVisibility() != 0) {
                f.this.q.W0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvMainChildFragment.java */
    /* loaded from: classes2.dex */
    public class k implements b.y {
        k() {
        }

        @Override // com.zte.iptvclient.android.common.player.k.b.y
        public void a(String str, String str2, String str3, boolean z) {
            f.this.a(str, str2, str3, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvMainChildFragment.java */
    /* loaded from: classes2.dex */
    public class l implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f5475a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.player.j.i f5476b;

        /* compiled from: TvMainChildFragment.java */
        /* loaded from: classes2.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f5478a;

            a(String str) {
                this.f5478a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.q.d3();
                f.this.q.a2();
                f.this.q.K(this.f5478a);
                f.this.q.E();
                f.this.q.D2();
            }
        }

        /* compiled from: TvMainChildFragment.java */
        /* loaded from: classes2.dex */
        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f5480a;

            b(String str) {
                this.f5480a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.q.d3();
                f.this.q.I(this.f5480a);
                f.this.q.E();
                f.this.q.D2();
            }
        }

        /* compiled from: TvMainChildFragment.java */
        /* loaded from: classes2.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.q.d3();
                f.this.q.Z1();
                f.this.q.f0();
                LogEx.d(f.this.p, "定桩起播 now beginPlayTVInSmallScreen");
                LogEx.d(f.this.p, "getTvInfo:" + l.this.f5475a.toString());
                LogEx.d(f.this.p, "Test the starting speed : queryTvBlackout back coutinue play");
                com.zte.iptvclient.android.common.player.f fVar = f.this.w;
                l lVar = l.this;
                fVar.a(lVar.f5476b, lVar.f5475a, ((com.zte.fragmentlib.b) f.this).h, f.this.getChildFragmentManager(), f.this.s.getId(), f.this.q);
            }
        }

        /* compiled from: TvMainChildFragment.java */
        /* loaded from: classes2.dex */
        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.q.d3();
                f.this.q.a2();
                f.this.q.H2();
                f.this.q.E();
                f.this.q.D2();
            }
        }

        l(Bundle bundle, com.zte.iptvclient.android.common.player.j.i iVar) {
            this.f5475a = bundle;
            this.f5476b = iVar;
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void j() {
            LogEx.d(f.this.p, "定桩起播 no Blackoutinfo for onBlackoutExitReturn to beginPlayTVInSmallScreen");
            ((com.zte.fragmentlib.b) f.this).h.runOnUiThread(new c());
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void k(String str) {
            LogEx.d(f.this.p, "定桩起播onImageBlackoutReturn");
            LogEx.d(f.this.p, "enter blackout");
            LogEx.d(f.this.p, "tv blackout查询展示black照片:" + str);
            ((com.zte.fragmentlib.b) f.this).h.runOnUiThread(new a(str));
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void l() {
            LogEx.d(f.this.p, "定桩起播 onDefaultReturn");
            LogEx.d(f.this.p, "enter blackout");
            LogEx.d(f.this.p, "get Detail BlackoutInfo is null （pic url or play url is null）");
            ((com.zte.fragmentlib.b) f.this).h.runOnUiThread(new d());
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void r(String str) {
            LogEx.d(f.this.p, "定桩起播onVideoBlackoutReturn");
            LogEx.d(f.this.p, "enter blackout");
            LogEx.d(f.this.p, "tv blackout查询播放black片源" + str);
            ((com.zte.fragmentlib.b) f.this).h.runOnUiThread(new b(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvMainChildFragment.java */
    /* loaded from: classes2.dex */
    public class m implements SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener {
        m() {
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener
        public void onPrevueDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d(f.this.p, "Test the starting speed :back querytvodDetail for playurl");
            LogEx.d(f.this.p, "sdkQueryTvodById:  onDataReturn,arg0= " + str3);
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
                            f.this.B.add(a2);
                        }
                    }
                    f.this.R();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    LogEx.e(f.this.p, e.getMessage());
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.query_tvod_info_fail);
                    f.this.L();
                    return;
                }
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.query_tvod_info_fail);
            f.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvMainChildFragment.java */
    /* loaded from: classes2.dex */
    public class n implements a.h {
        n() {
        }

        @Override // com.zte.iptvclient.android.common.player.k.a.h
        public void a() {
            if (f.this.s.getVisibility() != 0) {
                f.this.q.W0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvMainChildFragment.java */
    /* loaded from: classes2.dex */
    public class o implements b.y {
        o() {
        }

        @Override // com.zte.iptvclient.android.common.player.k.b.y
        public void a(String str, String str2, String str3, boolean z) {
            f.this.a(str, str2, str3, z);
        }
    }

    private void I() {
        com.zte.iptvclient.android.common.javabean.b bVar = new com.zte.iptvclient.android.common.javabean.b();
        ArrayList<com.zte.iptvclient.android.common.javabean.models.c> arrayList = this.C;
        if (arrayList != null && arrayList.size() > 0) {
            bVar.a(this.C.get(0).f());
            bVar.d(this.C.get(0).d());
            bVar.b("2");
            bVar.g(this.C.get(0).p());
            bVar.e(this.C.get(0).e());
            bVar.f("0");
            com.zte.iptvclient.android.common.f.b.a aVar = new com.zte.iptvclient.android.common.f.b.a(this.h, bVar, new d(), this);
            this.J = aVar;
            aVar.a(this.r);
            this.J.a();
            return;
        }
        a("2", -1);
    }

    private void J() {
        com.zte.iptvclient.android.common.javabean.b bVar = new com.zte.iptvclient.android.common.javabean.b();
        ArrayList<com.zte.iptvclient.android.common.javabean.models.d> arrayList = this.B;
        if (arrayList != null && arrayList.isEmpty()) {
            if (this.K == null) {
                this.K = new PrevueBean();
            }
            this.K.setPrevuecode(this.B.get(0).l());
            bVar.e(String.valueOf(this.B.get(0).m()));
            bVar.g(this.B.get(0).p());
            bVar.b("4");
            bVar.a(this.B.get(0).e());
            bVar.d(this.B.get(0).l());
            com.zte.iptvclient.android.common.f.b.a aVar = new com.zte.iptvclient.android.common.f.b.a(this.h, bVar, new c(), this);
            this.J = aVar;
            aVar.a(this.r);
            this.J.a();
            return;
        }
        a("2", -1);
    }

    private void K() {
        SupportActivity supportActivity;
        if (isHidden() || (supportActivity = this.h) == null) {
            return;
        }
        ((MainActivity) supportActivity).x();
        if (this.q == null) {
            M();
        }
        if (this.q != null) {
            LogEx.d(this.p, "###showLoading");
            this.q.D0();
            this.q.g2();
            this.q.L2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (isHidden() || this.h == null) {
            return;
        }
        if (this.q == null) {
            M();
        }
        if (this.q != null) {
            LogEx.d(this.p, "###hideLoading");
            this.q.d3();
            this.q.t("");
            this.q.Q2();
        }
    }

    private void M() {
        SupportActivity supportActivity = this.h;
        if (supportActivity == null) {
            return;
        }
        com.zte.iptvclient.android.common.player.k.c t = ((MainActivity) supportActivity).t();
        this.q = t;
        if (t == null) {
            return;
        }
        if (this.w == null) {
            this.w = new com.zte.iptvclient.android.common.player.f();
        }
        this.q.F1();
        this.q.a((c.o0) this);
        this.q.a((a.i) this);
        this.q.a((c.n0) this);
        this.q.a((b.a0) this);
        this.q.setTargetFragment(this, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        com.zte.iptvclient.android.common.player.k.c cVar;
        com.zte.iptvclient.android.common.player.k.c cVar2;
        com.zte.iptvclient.android.common.player.k.c cVar3;
        Bundle bundle = new Bundle();
        com.zte.iptvclient.android.common.javabean.models.c cVar4 = this.C.get(0);
        bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, !TextUtils.isEmpty(cVar4.c()) ? Integer.valueOf(cVar4.c()).intValue() : -1);
        bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, cVar4.j());
        LogEx.d(this.p, "play tv contentcode is " + cVar4.d());
        if (this.C.size() == 1 && com.zte.iptvclient.android.common.player.f.c(this.C.get(0).g())) {
            LogEx.d(this.p, "Definition =" + this.C.get(0).g());
            com.zte.iptvclient.android.common.player.k.c cVar5 = this.q;
            if (cVar5 != null) {
                cVar5.j(0);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<com.zte.iptvclient.android.common.javabean.models.c> it2 = this.C.iterator();
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
                arrayList.add(next);
            }
        }
        if (arrayList.size() == 0 && this.C.size() > arrayList.size() && (cVar3 = this.q) != null) {
            cVar3.j(0);
            return;
        }
        if (!this.w.a(this.C.get(0).b()) && (cVar2 = this.q) != null) {
            cVar2.j(1);
            return;
        }
        com.zte.iptvclient.android.common.player.k.c cVar6 = this.q;
        if ((cVar6 == null || cVar6.p0() >= 0) && (cVar = this.q) != null) {
            cVar.f(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        com.zte.iptvclient.android.common.player.k.c cVar;
        com.zte.iptvclient.android.common.player.k.c cVar2;
        com.zte.iptvclient.android.common.player.k.c cVar3;
        Bundle bundle = new Bundle();
        if (this.B.size() == 1 && com.zte.iptvclient.android.common.player.f.c(this.B.get(0).f())) {
            LogEx.d(this.p, "Definition =" + this.B.get(0).f());
            com.zte.iptvclient.android.common.player.k.c cVar4 = this.q;
            if (cVar4 != null) {
                cVar4.j(0);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, this.B.get(0).k());
        Iterator<com.zte.iptvclient.android.common.javabean.models.d> it2 = this.B.iterator();
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
        if (arrayList.size() == 0 && this.B.size() > arrayList.size() && (cVar3 = this.q) != null) {
            cVar3.j(0);
            return;
        }
        if (!this.w.a(s(this.B.get(0).c())) && (cVar2 = this.q) != null) {
            cVar2.j(1);
            return;
        }
        com.zte.iptvclient.android.common.player.k.c cVar5 = this.q;
        if ((cVar5 == null || cVar5.p0() >= 0) && (cVar = this.q) != null) {
            cVar.f(bundle);
        }
    }

    private void P() {
        this.h.startActivity(new Intent(this.h, (Class<?>) LoginActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        com.zte.iptvclient.android.common.player.k.c cVar;
        com.zte.iptvclient.android.common.player.k.c cVar2;
        ArrayList<com.zte.iptvclient.android.common.javabean.models.c> arrayList = this.C;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (isHidden() && !this.q.A) {
                LogEx.e(this.p, "view is hidden");
                return;
            }
            if (this.w == null) {
                this.w = new com.zte.iptvclient.android.common.player.f();
            }
            Bundle bundle = new Bundle();
            com.zte.iptvclient.android.common.javabean.models.c cVar3 = this.C.get(0);
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
            bundle.putString("systemlimitenable", cVar3.o());
            LogEx.d(this.p, "ratingid is :" + cVar3.n());
            bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, cVar3.j());
            bundle.putString("productVIP", cVar3.m());
            bundle.putString("channelcode", cVar3.d());
            LogEx.d(this.p, "play tv Channelcode is " + cVar3.d());
            if (channel != null) {
                bundle.putString("usermixno", channel.getUsermixno());
            }
            bundle.putString("mixno", cVar3.i());
            LogEx.d(this.p, "playChannelBean.getMixno= " + cVar3.i());
            if (this.C.size() == 1 && com.zte.iptvclient.android.common.player.f.c(this.C.get(0).g())) {
                LogEx.d(this.p, "Definition =" + this.C.get(0).g());
                com.zte.iptvclient.android.common.player.k.c cVar4 = this.q;
                if (cVar4 != null) {
                    cVar4.j(0);
                    return;
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.zte.iptvclient.android.common.javabean.models.c> it2 = this.C.iterator();
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
            if (arrayList2.size() == 0 && this.C.size() > arrayList2.size() && (cVar2 = this.q) != null) {
                cVar2.j(0);
                return;
            }
            if (!this.w.a(this.C.get(0).b()) && (cVar = this.q) != null) {
                cVar.j(1);
                return;
            }
            com.zte.iptvclient.android.common.player.k.c cVar5 = this.q;
            if (cVar5 == null || cVar5.p0() >= 0) {
                com.zte.iptvclient.android.common.player.j.i iVar = new com.zte.iptvclient.android.common.player.j.i();
                iVar.b(cVar3.d());
                iVar.a(cVar3.f());
                bundle.putString("columncode", cVar3.f());
                LogEx.d(this.p, "play tv COLUMNCODE is " + cVar3.f());
                if (!TextUtils.isEmpty(cVar3.a())) {
                    try {
                        if (Integer.valueOf(cVar3.a()).intValue() > 0 && TextUtils.equals("1", ConfigMgr.readPropertie("isSupportQueryAds"))) {
                            this.w.a(true);
                        } else {
                            this.w.a(false);
                        }
                    } catch (Exception unused) {
                        this.w.a(false);
                    }
                }
                LogEx.d(this.p, "beginPlayTVInSmallScreen");
                com.zte.iptvclient.android.common.player.k.c cVar6 = this.q;
                if (cVar6 == null) {
                    return;
                }
                cVar6.a(new j());
                this.q.a(new k());
                bundle.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_TV.getIntValue()));
                bundle.putString("channelcode", cVar3.d());
                if (this.x == null) {
                    return;
                }
                if (this.D || isHidden()) {
                    bundle.putString("isNotNeedToSwitch", "2");
                }
                if (isHidden()) {
                    LogEx.e(this.p, "Current view is hide for return Play");
                    return;
                }
                if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
                    LogEx.d(this.p, "定桩起播queryTvBlackout");
                    LogEx.d(this.p, "Test the starting speed : start queryTvBlackout");
                    com.zte.iptvclient.android.common.f.b.b.j().a(cVar3.d(), new l(bundle, iVar));
                    return;
                } else {
                    this.q.Z1();
                    this.q.d3();
                    this.w.a(iVar, bundle, this.h, getChildFragmentManager(), this.s.getId(), this.q);
                    return;
                }
            }
            return;
        }
        LogEx.e(this.p, "channel detail playurl is null");
        L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        boolean z;
        com.zte.iptvclient.android.common.player.k.c cVar;
        com.zte.iptvclient.android.common.player.k.c cVar2;
        ArrayList<com.zte.iptvclient.android.common.javabean.models.d> arrayList = this.B;
        if (arrayList != null && !arrayList.isEmpty()) {
            com.zte.iptvclient.android.common.javabean.models.d dVar = this.B.get(0);
            String a2 = dVar.a();
            LogEx.d(this.p, "onDataReturn: channelAuthId=" + a2);
            if (this.w == null) {
                this.w = new com.zte.iptvclient.android.common.player.f();
            }
            Bundle bundle = new Bundle();
            if (this.B.size() == 1 && com.zte.iptvclient.android.common.player.f.c(this.B.get(0).f())) {
                LogEx.d(this.p, "Definition =" + this.B.get(0).f());
                com.zte.iptvclient.android.common.player.k.c cVar3 = this.q;
                if (cVar3 != null) {
                    cVar3.j(0);
                    return;
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.zte.iptvclient.android.common.javabean.models.d> it2 = this.B.iterator();
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
            if (arrayList2.size() == 0 && this.B.size() > arrayList2.size() && (cVar2 = this.q) != null) {
                cVar2.j(0);
                return;
            }
            if (!this.w.a(s(this.B.get(0).c())) && (cVar = this.q) != null) {
                cVar.j(1);
                return;
            }
            com.zte.iptvclient.android.common.player.k.c cVar4 = this.q;
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
                    bundle.putString("ratingid", channel.getRatingid());
                    LogEx.d(this.p, "ratingid is :" + channel.getRatingid());
                    bundle.putString("systemlimitenable", channel.getSystemlimitenable());
                    LogEx.d(this.p, "curChannel.systemlimitenable= " + channel.getSystemlimitenable());
                    bundle.putString("channelcode", channel.getChannelcode());
                    bundle.putString("poster_image", channel.getPosterimage());
                    bundle.putString("supportTimeShift", channel.getSupporttimeshift());
                    bundle.putString("tv_name", channel.getChannelname());
                    bundle.putString("usermixno", channel.getUsermixno());
                    bundle.putString("mixno", channel.getMixno());
                    LogEx.d(this.p, "curChannel.getMixno= " + channel.getMixno());
                    if (TextUtils.isEmpty(channel.getMixno())) {
                        bundle.putString("mixno", dVar.i());
                        LogEx.d(this.p, "prevueDetail.getMixno= " + dVar.i());
                    }
                    bundle.putString("columncode", channel.getColumncode());
                }
                bundle.putString("prevue_name", dVar.m());
                bundle.putString("tv_id", dVar.c());
                bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, dVar.k());
                bundle.putString("isprotection", dVar.h());
                bundle.putString("prevuecode", dVar.l());
                bundle.putString("prevueratingid", dVar.o());
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
                String p = dVar.p();
                bundle.putString("playuri4dlna", com.zte.iptvclient.android.mobile.h.a.b.a(dVar.l(), c2, p, x.c(b3, "yyyy.MM.dd HH:mm:ss", "yyyyMMddHHmmss", 1), x.c(g2, "yyyy.MM.dd HH:mm:ss", "yyyyMMddHHmmss", 1)));
                bundle.putString("telecomcode", p);
                bundle.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_TVOD));
                com.zte.iptvclient.android.common.player.j.j jVar = new com.zte.iptvclient.android.common.player.j.j();
                jVar.b(dVar.c());
                jVar.a(dVar.e());
                jVar.c("1");
                if (channel != null && !TextUtils.isEmpty(channel.getAdvertisecontent())) {
                    try {
                        this.w.a(Integer.valueOf(channel.getAdvertisecontent()).intValue() > 0 && TextUtils.equals("1", ConfigMgr.readPropertie("isSupportQueryAds")));
                    } catch (Exception unused) {
                        this.w.a(false);
                    }
                }
                if (TextUtils.equals("1", ConfigMgr.readPropertie("SuportTvoDAddBookMark", "0"))) {
                    this.w.b(true);
                    z = false;
                } else {
                    z = false;
                    this.w.b(false);
                }
                if (this.q == null) {
                    return;
                }
                bundle.putBoolean("IsUesMutliWindowToPlay", z);
                LogEx.d(this.p, "beginPlayTVInSmallScreen");
                this.q.a(new n());
                bundle.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_TVOD.getIntValue()));
                if (channel != null) {
                    bundle.putString("channelcode", channel.getChannelcode());
                    bundle.putString("ratingid", channel.getRatingid());
                    bundle.putString("columncode", channel.getColumncode());
                    if (this.D) {
                        bundle.putString("isNotNeedToSwitch", "2");
                    }
                }
                this.q.a(new o());
                if (TextUtils.equals("1", ConfigMgr.readPropertie("SuportTvoDAddBookMark", "0"))) {
                    this.w.b(true);
                } else {
                    this.w.b(false);
                }
                if (isHidden()) {
                    LogEx.e(this.p, "Current view is hide for return Play");
                    return;
                }
                if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
                    com.zte.iptvclient.android.common.f.b.b.j().a(dVar.c());
                    LogEx.d(this.p, "Test the starting speed : start querytvodBlackout");
                    com.zte.iptvclient.android.common.f.b.b.j().a(c2, s.b(), new a(jVar, bundle));
                    return;
                } else {
                    this.q.Z1();
                    this.q.d3();
                    com.zte.iptvclient.android.common.h.b.a().a(this.q);
                    this.w.a(jVar, bundle, (Context) this.h, getChildFragmentManager(), this.s.getId(), this.q);
                    return;
                }
            }
            return;
        }
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.no_program_available);
        L();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        LogEx.d(this.p, "￥% onActivityCreated start");
        SupportActivity supportActivity = this.h;
        if (supportActivity != null) {
            supportActivity.getSupportFragmentManager();
            this.s = ((MainActivity) this.h).u();
            ((MainActivity) this.h).x();
            if (this.q == null) {
                M();
            }
            if (this.q != null) {
                LogEx.d(this.p, "###showLoading");
                this.q.L2();
            }
        }
        LogEx.d(this.p, "￥% onActivityCreated finish");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (intent != null && 20 == i2) {
            LogEx.i(this.p, " skip to LoginFragment");
            P();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        LogEx.d(this.p, "onConfigurationChanged");
        super.onConfigurationChanged(configuration);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogEx.d(this.p, " ￥% onCreate ");
        this.A = new com.zte.iptvclient.android.common.j.h(this.h);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        LogEx.d(this.p, "￥% onCreateView ");
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        if (this.y == null) {
            View inflate = layoutInflater.inflate(R.layout.tv_fragment_child_new, viewGroup, false);
            this.y = inflate;
            d(inflate);
        }
        if (!BaseApp.a(getContext())) {
            com.gyf.barlibrary.e c2 = com.gyf.barlibrary.e.c(getActivity());
            c2.a(false);
            c2.f();
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(48);
        }
        com.zte.iptvclient.android.mobile.a0.b.a aVar = new com.zte.iptvclient.android.mobile.a0.b.a();
        this.x = aVar;
        aVar.a((a.f) this);
        b(R.id.fl_channel, this.x);
        LogEx.d(this.p, "￥% onCreateView finish");
        return this.y;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        SupportActivity supportActivity = this.h;
        if (supportActivity != null) {
            Window window = supportActivity.getWindow();
            if (window != null) {
                window.setSoftInputMode(32);
            }
            ((MainActivity) this.h).b(0);
        }
        com.zte.iptvclient.android.common.player.k.c cVar = this.q;
        if (cVar != null && cVar.e0) {
            cVar.y2();
        }
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
    public void onEventMainThread(com.zte.iptvclient.android.common.e.n.a aVar) {
        if (TabHostManager.TabName.TV.equals(aVar.a())) {
            this.F = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        RelativeLayout relativeLayout;
        if (z) {
            com.zte.iptvclient.android.common.player.k.c cVar = this.q;
            if (cVar != null) {
                cVar.x2();
                this.q.g(false);
                this.q.d3();
            }
            ((MainActivity) this.h).v();
            this.F = false;
            com.gyf.barlibrary.e c2 = com.gyf.barlibrary.e.c(getActivity());
            c2.a(true);
            c2.f();
        } else {
            if (!BaseApp.a(getContext())) {
                com.gyf.barlibrary.e c3 = com.gyf.barlibrary.e.c(getActivity());
                c3.a(false);
                c3.f();
            }
            LogEx.d(this.p, "text Play showPlayerFragmentLayout");
            this.s.setVisibility(0);
            SupportActivity supportActivity = this.h;
            if (supportActivity != null) {
                ((MainActivity) supportActivity).x();
                if (this.q == null) {
                    M();
                }
            }
            if (this.t == 0 && this.u == 0 && (relativeLayout = this.r) != null) {
                relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new b());
            }
            if (!com.zte.iptvclient.android.mobile.n.c.b.t() && this.q != null) {
                LogEx.d(this.p, "###showLoginToPlayView return ");
                this.q.N2();
                return;
            }
            if (!this.F && this.x != null) {
                LogEx.d(this.p, "###startPlay");
                this.x.L();
            }
            com.zte.iptvclient.android.mobile.a0.b.a aVar = this.x;
            if (aVar != null) {
                aVar.M();
            }
        }
        super.onHiddenChanged(z);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LogEx.d(this.p, "￥% onResume");
    }

    private void d(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.tv_detail_miniplaye_container);
        this.r = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
        this.r.setVisibility(0);
        View findViewById = view.findViewById(R.id.blank_view);
        this.z = findViewById;
        com.zte.iptvclient.common.uiframe.f.a(findViewById);
        if (this.t == 0 && this.u == 0) {
            this.r.getViewTreeObserver().addOnGlobalLayoutListener(new h());
        }
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

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        com.zte.iptvclient.android.common.player.k.c cVar;
        if (!this.D || (cVar = this.q) == null) {
            return false;
        }
        if (cVar.s5) {
            return true;
        }
        cVar.i0();
        return true;
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public int e() {
        int[] iArr = new int[2];
        this.r.getLocationInWindow(iArr);
        return iArr[1];
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public int i() {
        return this.t;
    }

    @Override // com.zte.iptvclient.android.common.player.k.b.a0
    public void q(String str) {
        if (TextUtils.equals(str, "2")) {
            I();
        } else {
            J();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(q qVar) {
        qVar.a();
        throw null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        if (TextUtils.equals(cVar.a(), "0")) {
            if (!isHidden() && !com.zte.iptvclient.android.mobile.n.c.b.t()) {
                LogEx.d(this.p, "LoginReturnEvent success for re startPlay");
                if (this.x != null) {
                    LogEx.d(this.p, "### mLiveTVFragment.startPlay()");
                    this.x.L();
                    return;
                }
                return;
            }
            LogEx.d(this.p, "LoginReturnEvent success isHidden  no need re startPlay");
        }
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
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.b bVar) {
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            com.zte.iptvclient.android.common.h.b.a().a(this.q);
            PrevueBean a2 = bVar.a();
            this.K = a2;
            if (TextUtils.isEmpty(a2.getPrevuecode())) {
                return;
            }
            if (!com.zte.iptvclient.android.mobile.n.c.b.t() && this.q != null) {
                LogEx.i(this.p, "showLoginToPlayView return ");
                this.q.N2();
            } else {
                K();
                this.G = this.K.getPrevuebreakpoint();
                a(this.K.getPrevuecode(), false);
                this.K.getChannelcode();
            }
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public void a(boolean z) {
        LogEx.d(this.p, "onConfigurationChanged onSkipToSmallScreenCallBack");
        this.q.T1();
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
        if (!this.E) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.f(false));
        } else {
            SupportActivity supportActivity2 = this.h;
            if (supportActivity2 != null) {
                ((MainActivity) supportActivity2).b(this.v);
            }
        }
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.e(false));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.g gVar) {
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            LogEx.d(this.p, this.A.C() + "," + com.zte.iptvclient.android.mobile.f.b.a.c(gVar.b()) + "," + gVar.b());
            this.L = gVar.b();
            this.M = gVar.d();
            if (TextUtils.isEmpty(this.L)) {
                return;
            }
            if (!com.zte.iptvclient.android.mobile.n.c.b.t() && this.q != null) {
                LogEx.i(this.p, "showLoginToPlayView return ");
                this.q.N2();
                return;
            }
            LogEx.d(this.p, "￥%PlayLiveTVQueryEvent");
            K();
            new Thread(this.O).start();
            gVar.b();
            LogEx.i(this.p, "event " + this.L);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.h hVar) {
        com.zte.iptvclient.android.common.player.k.c cVar = this.q;
        if (cVar != null) {
            cVar.m(true);
        }
        if (TextUtils.isEmpty(hVar.a())) {
            return;
        }
        if (this.h instanceof MainActivity) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.e(hVar.a(), ""));
        } else {
            this.L = hVar.a();
            new Thread(this.O).start();
        }
        com.zte.iptvclient.android.common.player.k.c cVar2 = this.q;
        if (cVar2 != null) {
            cVar2.i0();
        }
        hVar.a();
        LogEx.i(this.p, "event " + hVar.a());
    }

    private void a(String str, boolean z) {
        LogEx.d(this.p, "Test the starting speed :start querytvodDetail for playurl");
        if (this.B.size() > 0) {
            this.B.clear();
        }
        SDKPrevueMgr sDKPrevueMgr = new SDKPrevueMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("prevuecode", str);
        hashMap.put("mediaservices", "2");
        hashMap.put("recommendtype", z ? "1" : "0");
        sDKPrevueMgr.getPrevueDetailWithUrl(hashMap, new m());
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.f fVar) {
        if (this.q != null && !isHidden()) {
            if ("play".equals(fVar.b())) {
                if (this.s != null) {
                    LogEx.d(this.p, "text Play showPlayerFragmentLayout");
                    this.s.setVisibility(0);
                }
                if (!fVar.a()) {
                    this.q.X0();
                    return;
                }
                com.zte.iptvclient.android.mobile.a0.b.a aVar = this.x;
                if (aVar != null) {
                    aVar.L();
                    return;
                }
                return;
            }
            if ("pause".equals(fVar.b())) {
                if (this.s != null) {
                    LogEx.d(this.p, "text Play hidPlayerFragmentLayout");
                    this.s.setVisibility(8);
                }
                this.q.W0();
                com.zte.iptvclient.android.common.player.k.c cVar = this.q;
                if (cVar.e0 || cVar.P8) {
                    return;
                }
                cVar.x2();
                return;
            }
            return;
        }
        LogEx.d(this.p, "text Play  isHidden return");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, boolean z) {
        com.zte.iptvclient.android.mobile.a0.b.a aVar = this.x;
        if (aVar != null) {
            aVar.a(str, str2, str3, z);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.c.o0
    public void a(com.zte.iptvclient.android.common.e.b bVar) {
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.a(TabHostManager.TabName.HOME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2) {
        if (i2 == 0) {
            if (TextUtils.equals(str, "2")) {
                new Thread(this.P).start();
            } else {
                new Thread(this.Q).start();
            }
        }
    }
}
