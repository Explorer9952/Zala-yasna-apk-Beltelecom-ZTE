package com.zte.iptvclient.android.mobile.e0.e;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.internal.NativeProtocol;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.bookmark.GetBookMarkReq;
import com.video.androidsdk.service.bookmark.SDKBookMarkMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.play.SDKPlayMgr;
import com.video.androidsdk.service.vod.SDKVodMgr;
import com.video.androidsdk.sns.Constants;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.a.a.e.b;
import com.zte.iptvclient.android.common.f.b.a;
import com.zte.iptvclient.android.common.f.b.b;
import com.zte.iptvclient.android.common.f.b.k;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import com.zte.iptvclient.android.common.javabean.models.MovieDetailBundleBean;
import com.zte.iptvclient.android.common.javabean.models.MultiDefinitionURLBean;
import com.zte.iptvclient.android.common.javabean.models.SeriesEpisodeBean;
import com.zte.iptvclient.android.common.javabean.models.SeriesHeadBean;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.common.player.k.a;
import com.zte.iptvclient.android.common.player.k.b;
import com.zte.iptvclient.android.common.player.k.c;
import com.zte.iptvclient.android.mobile.e0.e.a;
import com.zte.iptvclient.android.mobile.e0.e.k;
import com.zte.iptvclient.android.mobile.i.b.h;
import com.zte.iptvclient.android.mobile.ivi.DefinitionBean;
import com.zte.iptvclient.android.mobile.ivi.a;
import com.zte.iptvclient.android.mobile.login.activity.LoginActivity;
import com.zte.iptvclient.android.mobile.vod.bean.SeriesEpisodeNavBean;
import com.zte.iptvclient.android.mobile.vod.entity.GetUserStarRatingEntity;
import com.zte.iptvclient.android.mobile.vod.ui.columnview.SeriesEposideExpandView;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.video.ContentType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DetailSeriesFragment.java */
/* loaded from: classes.dex */
public class i extends com.zte.fragmentlib.b implements a.i, c.o0, b.x, b.w, b.a0, b.v, a.h, h.InterfaceC0281h, k.d0, k.e0, c.n0 {
    private static final String j2 = i.class.getSimpleName();
    private RelativeLayout B;
    private ImageView C;
    protected ArrayList<String> D;
    private Bundle D0;
    private SeriesHeadBean E0;
    private SeriesHeadBean G0;
    private String K;
    private com.zte.iptvclient.android.mobile.e0.e.k K0;
    public TextView L0;
    private ArrayList<String> N;
    FrameLayout N0;
    private ArrayList<String> O;
    private FrameLayout O0;
    private ArrayList<String> P;
    private int Q;
    private String R0;
    protected com.zte.iptvclient.android.common.player.k.c S;
    private SDKVodMgr T0;
    private int U;
    private SDKVodMgr U0;
    private String V;
    private SDKNetHTTPRequest V0;
    private String W;
    private com.zte.iptvclient.android.common.f.b.k W0;
    private String X;
    private SDKVodMgr X0;
    private String Y;
    private SDKPlayMgr Y0;
    private String Z;
    private boolean Z0;
    private String a0;
    private String b0;
    private WebView b1;
    private String c0;
    private String d0;
    private String e0;
    private String e1;
    private String f0;
    private String g0;
    private ArrayList<DefinitionBean> g1;
    private String h0;
    private DefinitionBean h1;
    private String i0;
    private String k1;
    private RelativeLayout p;
    private ImageView q;
    private TextView r;
    private ImageView s;
    private String s0;
    private TextView t;
    private FragmentManager u;
    protected ArrayList<CommonVideoBean> v0;
    private RelativeLayout w;
    private RelativeLayout x;
    private boolean x0;
    private int y;
    private boolean y0;
    private int z;
    private boolean v = false;
    private boolean A = false;
    private int E = 0;
    private int F = 1;
    private int G = 0;
    private SeriesEpisodeBean J = null;
    private int L = 30;
    private ArrayList<Integer> M = new ArrayList<>();
    private com.zte.iptvclient.android.common.player.f R = null;
    private long T = 0;
    private String j0 = "";
    private String k0 = "";
    private String l0 = "";
    private String m0 = "";
    private String n0 = "";
    private String o0 = "";
    private String p0 = "";
    private String q0 = "";
    private String r0 = "";
    private ArrayList<SeriesEpisodeBean> t0 = new ArrayList<>();
    protected boolean u0 = false;
    private List<Integer> w0 = new ArrayList();
    private String z0 = "";
    private String A0 = "";
    private String B0 = "0";
    private String C0 = "0";
    private boolean F0 = true;
    private List<com.zte.iptvclient.android.common.player.j.g> H0 = new ArrayList();
    public boolean I0 = false;
    public boolean J0 = false;
    private boolean M0 = false;
    private boolean P0 = false;
    private boolean Q0 = false;
    private int S0 = 1;
    private boolean a1 = true;
    private boolean c1 = false;
    private String d1 = "";
    private String f1 = "";
    private String i1 = "";
    private String j1 = "";
    private String l1 = "";
    private String m1 = "";
    private String n1 = "";
    private String o1 = "";
    private String p1 = "";
    private String q1 = "";
    private String r1 = "";
    private String s1 = "";
    private String t1 = "";
    private String u1 = "";
    private String v1 = "";
    private String w1 = "";
    private String x1 = "";
    private String y1 = "";
    private String z1 = "";
    private String A1 = "";
    private String B1 = "";
    private String C1 = "";
    private String D1 = "";
    private String E1 = "";
    private String F1 = "";
    private String G1 = "";
    private String H1 = "";
    private String I1 = "";
    private String J1 = "";
    private String K1 = "";
    private String L1 = "";
    private String M1 = "";
    private String N1 = "";
    private String O1 = "";
    private String P1 = "";
    private String Q1 = "";
    private String R1 = "";
    private String S1 = "";
    private String T1 = "";
    private String U1 = "";
    private String V1 = "";
    private String W1 = "";
    private String X1 = "";
    private String Y1 = "";
    private String Z1 = "";
    private String a2 = "";
    private String b2 = "";
    private String c2 = "";
    private String d2 = "";
    private String e2 = "";
    private String f2 = "";
    private ArrayList<MultiDefinitionURLBean> g2 = new ArrayList<>();
    private s h2 = new s(this);
    View.OnClickListener i2 = new l();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesFragment.java */
    /* loaded from: classes2.dex */
    public class a implements SDKVodMgr.OnVodListReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodListReturnListener
        public void onVodListReturn(String str, String str2, String str3) {
            LogEx.d(i.j2, "sdkQueryRecommendByEpg:" + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    i.this.a(new JSONObject(str3));
                } catch (Exception e) {
                    LogEx.d(i.j2, "sdkQueryRecommendByEpg  exception = " + e.getMessage());
                }
            }
        }
    }

    /* compiled from: DetailSeriesFragment.java */
    /* loaded from: classes2.dex */
    class b implements com.zte.iptvclient.android.mobile.order.helper.c {
        b() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.helper.c
        public void a(int i, String str) {
            LogEx.d(i.j2, "payCallback returnCode " + i + " returnMsg " + str);
            i.this.f(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesFragment.java */
    /* loaded from: classes2.dex */
    public class c implements a.g {
        c() {
        }

        @Override // com.zte.iptvclient.android.mobile.ivi.a.g
        public void a(String str) {
            if ("0".equals(str)) {
                i.this.b0();
                return;
            }
            com.zte.iptvclient.android.common.player.k.c cVar = i.this.S;
            if (cVar != null) {
                cVar.Q2();
            }
        }
    }

    /* compiled from: DetailSeriesFragment.java */
    /* loaded from: classes2.dex */
    class d implements a.h {
        d() {
        }

        @Override // com.zte.iptvclient.android.mobile.e0.e.a.h
        public void a() {
            i.this.O0.removeAllViews();
            i.this.O0.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesFragment.java */
    /* loaded from: classes2.dex */
    public class e implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        e() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d(i.j2, "api12 onDataReturn s = " + str);
            try {
                i.this.e1 = new JSONObject(str).getString("result");
                i.this.Z();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d(i.j2, "api12 onFailReturn s = " + str + "  i=" + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesFragment.java */
    /* loaded from: classes2.dex */
    public class f extends WebChromeClient {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5970a;

        /* compiled from: DetailSeriesFragment.java */
        /* loaded from: classes2.dex */
        class a implements ValueCallback<String> {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: DetailSeriesFragment.java */
            /* renamed from: com.zte.iptvclient.android.mobile.e0.e.i$f$a$a, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C0234a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
                C0234a() {
                }

                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Failed to find 'out' block for switch in B:17:0x02fa. Please report as an issue. */
                /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0098. Please report as an issue. */
                /* JADX WARN: Removed duplicated region for block: B:18:0x02fd  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x0305  */
                /* JADX WARN: Removed duplicated region for block: B:31:0x0ad6  */
                /* JADX WARN: Removed duplicated region for block: B:37:0x0ae4  */
                /* JADX WARN: Removed duplicated region for block: B:39:0x0333 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:40:0x035e A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:41:0x038b A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:42:0x03b7 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:43:0x03e3 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:44:0x040f A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:45:0x043b A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:46:0x0469 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:47:0x0497 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:48:0x04c5 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:49:0x04f3 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:50:0x0521 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:51:0x054f A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:52:0x057d A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:53:0x05ab A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:54:0x05d7 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:55:0x0605 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:56:0x0633 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:57:0x065f A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:58:0x068b A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:59:0x06b7 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:62:0x06e3 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:63:0x0711 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:64:0x073e A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:65:0x076b A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:66:0x079a A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:68:0x07c6 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:70:0x07f4 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:72:0x0822 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:74:0x0850 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:76:0x087e A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:78:0x08ac A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:80:0x08da A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:82:0x0908 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:84:0x0936 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:86:0x0964 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:88:0x0992 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:90:0x09c0 A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:92:0x09ee A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:94:0x0a1c A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:96:0x0a4a A[Catch: JSONException -> 0x0ab7, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                /* JADX WARN: Removed duplicated region for block: B:98:0x0a79 A[Catch: JSONException -> 0x0ab7, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0ab7, blocks: (B:23:0x0307, B:39:0x0333, B:40:0x035e, B:41:0x038b, B:42:0x03b7, B:43:0x03e3, B:44:0x040f, B:45:0x043b, B:46:0x0469, B:47:0x0497, B:48:0x04c5, B:49:0x04f3, B:50:0x0521, B:51:0x054f, B:52:0x057d, B:53:0x05ab, B:54:0x05d7, B:55:0x0605, B:56:0x0633, B:57:0x065f, B:58:0x068b, B:59:0x06b7, B:62:0x06e3, B:63:0x0711, B:64:0x073e, B:65:0x076b, B:66:0x079a, B:68:0x07c6, B:70:0x07f4, B:72:0x0822, B:74:0x0850, B:76:0x087e, B:78:0x08ac, B:80:0x08da, B:82:0x0908, B:84:0x0936, B:86:0x0964, B:88:0x0992, B:90:0x09c0, B:92:0x09ee, B:94:0x0a1c, B:96:0x0a4a, B:98:0x0a79), top: B:22:0x0307 }] */
                @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onDataReturn(java.lang.String r27) {
                    /*
                        Method dump skipped, instructions count: 3062
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.e0.e.i.f.a.C0234a.onDataReturn(java.lang.String):void");
                }

                @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
                public void onFailReturn(int i, String str) {
                    LogEx.d(i.j2, "API_13-2 onFailReturn s = " + str);
                }
            }

            a() {
            }

            @Override // android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
                String str2 = i.this.c2 + "/light/?app_version=" + i.this.d2 + "&ts=" + i.this.e1 + "&sign=" + str.replaceAll("\"", "");
                SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
                sDKNetHTTPRequest.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                sDKNetHTTPRequest.setBody(i.this.k1);
                sDKNetHTTPRequest.startRequest(str2, HttpRequest.METHOD_POST, new C0234a());
            }
        }

        f(String str) {
            this.f5970a = str;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i >= 100) {
                i.this.b1.evaluateJavascript("jsMethod(" + this.f5970a + ")", new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesFragment.java */
    /* loaded from: classes2.dex */
    public class g extends WebChromeClient {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5974a;

        /* compiled from: DetailSeriesFragment.java */
        /* loaded from: classes2.dex */
        class a implements ValueCallback<String> {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: DetailSeriesFragment.java */
            /* renamed from: com.zte.iptvclient.android.mobile.e0.e.i$g$a$a, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C0235a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
                C0235a(a aVar) {
                }

                @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
                public void onDataReturn(String str) {
                    LogEx.d(i.j2, "API_14 onDataReturn s = " + str);
                }

                @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
                public void onFailReturn(int i, String str) {
                    LogEx.d(i.j2, "API_14 onFailReturn s = " + str);
                }
            }

            a() {
            }

            @Override // android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
                String str2 = i.this.c2 + "/light/?app_version=" + i.this.d2 + "&ts=" + i.this.e1 + "&sign=" + str.replaceAll("\"", "");
                SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
                sDKNetHTTPRequest.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                sDKNetHTTPRequest.setBody(i.this.k1);
                sDKNetHTTPRequest.startRequest(str2, HttpRequest.METHOD_POST, new C0235a(this));
            }
        }

        g(String str) {
            this.f5974a = str;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i >= 100) {
                i.this.b1.evaluateJavascript("jsMethod(" + this.f5974a + ")", new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesFragment.java */
    /* loaded from: classes2.dex */
    public class h implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        h() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d(i.j2, "SdkGetUserStarRatingThread return: " + str);
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!"0".equals(jSONObject.getString("returncode"))) {
                    i.this.h2.sendEmptyMessage(40966);
                } else {
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    if (jSONArray.length() <= 0) {
                        i.this.h2.sendEmptyMessage(40966);
                    } else {
                        GetUserStarRatingEntity a2 = GetUserStarRatingEntity.a(jSONArray.getJSONObject(0));
                        Message obtain = Message.obtain();
                        obtain.what = 40961;
                        obtain.obj = a2;
                        i.this.h2.sendMessage(obtain);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
                i.this.h2.sendEmptyMessage(40966);
            }
            LogEx.d(i.j2, " IHTTPRequestReturnListener.onDataReturn 耗时: " + (SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d(i.j2, "SdkGetUserStarRatingThread failed: " + str);
            i.this.h2.sendEmptyMessage(40966);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.e0.e.i$i, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0236i implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        C0236i(i iVar) {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d(i.j2, "API_14_2 onDataReturn s = " + str);
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d(i.j2, "API_14_2 onFailReturn s = " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesFragment.java */
    /* loaded from: classes2.dex */
    public class j implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        j() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("sdk_getareaauth", str);
            try {
                if (new JSONObject(str).getString("returncode").equals("0")) {
                    i.this.a1 = true;
                } else {
                    i.this.a1 = false;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("sdk_getareaauth", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesFragment.java */
    /* loaded from: classes2.dex */
    public class k implements ViewTreeObserver.OnGlobalLayoutListener {
        k() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            i.this.x.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            int i = BaseApp.j;
            if (i != 0) {
                i.this.y = i;
                i.this.z = BaseApp.k;
            } else {
                i iVar = i.this;
                iVar.y = iVar.w.getHeight();
                i iVar2 = i.this;
                iVar2.z = iVar2.w.getWidth();
                BaseApp.j = i.this.y;
                BaseApp.k = i.this.z;
            }
            int i2 = i.this.z;
            double d2 = i.this.z;
            double d3 = BaseApp.f() ? 8.0d : 9.0d;
            Double.isNaN(d2);
            i.this.x.setLayoutParams(new LinearLayout.LayoutParams(i2, (int) ((d2 * d3) / 16.0d)));
            LogEx.d(i.j2, "miPlayerDefaultWidth" + i.this.z + " mPlayerDefaultHeight " + ((i.this.z * 9) / 16));
        }
    }

    /* compiled from: DetailSeriesFragment.java */
    /* loaded from: classes2.dex */
    class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_login /* 2131296460 */:
                    i.this.A0();
                    return;
                case R.id.detail_series_play_imgvew /* 2131296658 */:
                    i iVar = i.this;
                    if (!iVar.u0 || iVar.E0 == null) {
                        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(((com.zte.fragmentlib.b) i.this).h.getResources().getString(R.string.episode_has_not));
                        return;
                    }
                    i.this.Q0 = false;
                    i.this.O();
                    i.this.h0();
                    return;
                case R.id.img_close /* 2131296935 */:
                case R.id.tv_img_close /* 2131298248 */:
                    i.this.G();
                    i.this.M0 = false;
                    if (i.this.p != null) {
                        i.this.L0.setVisibility(8);
                        i.this.p.setVisibility(8);
                        i.this.y0();
                    }
                    com.zte.iptvclient.android.common.player.k.c cVar = i.this.S;
                    if (cVar != null) {
                        cVar.H1();
                        return;
                    }
                    return;
                case R.id.series_back /* 2131297991 */:
                    com.zte.iptvclient.android.common.player.k.c cVar2 = i.this.S;
                    if (cVar2 != null) {
                        cVar2.w0();
                    }
                    ((com.zte.fragmentlib.b) i.this).h.finish();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesFragment.java */
    /* loaded from: classes2.dex */
    public class m implements SDKVodMgr.OnSeriesHeadInfoReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f5981a;

        m(long j) {
            this.f5981a = j;
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnSeriesHeadInfoReturnListener
        public void onSeriesHeadInfoReturn(String str, String str2, String str3) {
            LogEx.d(i.j2, " getSeriesHeadInfo 耗时: " + (SystemClock.currentThreadTimeMillis() - this.f5981a));
            LogEx.d(i.j2, "onSeriesHeadInfoReturn query series head info ,returncode : " + str + " , errormsg : " + str2 + " , data : " + str3);
            com.zte.iptvclient.android.common.k.h.a().a(new u(i.this, str, str3));
            i.this.C.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesFragment.java */
    /* loaded from: classes2.dex */
    public class n implements SDKVodMgr.OnSeriesChildListReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5983a;

        n(int i) {
            this.f5983a = i;
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnSeriesChildListReturnListener
        public void onSeriesChildListReturn(String str, String str2, String str3) {
            com.zte.iptvclient.android.common.k.h.a().a(new t(i.this, str, str3, this.f5983a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesFragment.java */
    /* loaded from: classes2.dex */
    public class o implements SDKBookMarkMgr.OnBookMarkReturnListener {

        /* compiled from: DetailSeriesFragment.java */
        /* loaded from: classes2.dex */
        class a implements SDKPlayMgr.OnMultiDefinitionUrlReturnListener {

            /* compiled from: DetailSeriesFragment.java */
            /* renamed from: com.zte.iptvclient.android.mobile.e0.e.i$o$a$a, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            class C0237a implements b.c {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ JSONArray f5987a;

                /* compiled from: DetailSeriesFragment.java */
                /* renamed from: com.zte.iptvclient.android.mobile.e0.e.i$o$a$a$a, reason: collision with other inner class name */
                /* loaded from: classes2.dex */
                class C0238a implements com.zte.iptvclient.android.mobile.order.helper.c {
                    C0238a() {
                    }

                    @Override // com.zte.iptvclient.android.mobile.order.helper.c
                    public void a(int i, String str) {
                        LogEx.d(i.j2, "payCallback returnCode " + i + " returnMsg " + str);
                        i.this.f(i);
                    }
                }

                C0237a(JSONArray jSONArray) {
                    this.f5987a = jSONArray;
                }

                @Override // com.zte.iptvclient.android.common.customview.a.a.e.b.c
                public void a(MultiDefinitionURLBean multiDefinitionURLBean) {
                    com.zte.iptvclient.android.common.player.k.c cVar = i.this.S;
                    if (cVar == null) {
                        return;
                    }
                    cVar.L2();
                    LogEx.d(i.j2, "videoCpCode is " + i.this.E0.getCpcode());
                    com.zte.iptvclient.android.common.player.f unused = i.this.R;
                    if (!com.zte.iptvclient.android.common.player.f.c(multiDefinitionURLBean.f()) && (i.this.g2.size() != 0 || i.this.g2.size() >= this.f5987a.length())) {
                        i.this.V = multiDefinitionURLBean.i();
                        i.this.W = multiDefinitionURLBean.f();
                        if (TextUtils.isEmpty(multiDefinitionURLBean.a())) {
                            return;
                        }
                        i.this.U = Integer.valueOf(multiDefinitionURLBean.a()).intValue();
                        if (i.this.U != 0 || i.this.K0 == null) {
                            i.this.K0.M();
                            com.zte.iptvclient.android.common.javabean.b bVar = new com.zte.iptvclient.android.common.javabean.b();
                            bVar.d(i.this.E0.getProgramcode());
                            bVar.a(i.this.E0.getColumncode());
                            bVar.b(i.this.E0.getProgramtype());
                            bVar.g(i.this.E0.getTelecomcode());
                            bVar.e(i.this.E0.getProgramname());
                            bVar.f(i.this.B0);
                            bVar.c(i.this.W);
                            com.zte.iptvclient.android.common.f.b.a aVar = new com.zte.iptvclient.android.common.f.b.a(((com.zte.fragmentlib.b) i.this).h, bVar, new C0238a(), null);
                            aVar.a(i.this.C);
                            aVar.a();
                            return;
                        }
                        i.this.T();
                        i iVar = i.this;
                        iVar.a(iVar.V, 2);
                        return;
                    }
                    i.this.S.j(0);
                }

                @Override // com.zte.iptvclient.android.common.customview.a.a.e.b.c
                public void a(VideoDetailBean videoDetailBean) {
                }
            }

            a() {
            }

            @Override // com.video.androidsdk.service.play.SDKPlayMgr.OnMultiDefinitionUrlReturnListener
            public void onMultiDefinitionUrlReturn(String str, String str2, String str3) {
                LogEx.d(i.j2, "Test the starting speed : MultiDefinitionUrl back");
                if (TextUtils.equals(str, "0")) {
                    try {
                        LogEx.d(i.j2, "onMultiDefinitionUrlReturn=" + str3);
                        JSONObject jSONObject = new JSONObject(str3);
                        i.this.V = "";
                        i.this.X = "";
                        i.this.Y = "";
                        i.this.Z = "";
                        i.this.a0 = "";
                        i.this.b0 = "";
                        i.this.c0 = "";
                        i.this.j0 = "";
                        i.this.k0 = "";
                        i.this.l0 = "";
                        i.this.m0 = "";
                        i.this.n0 = "";
                        i.this.o0 = "";
                        i.this.p0 = "";
                        i.this.q0 = "";
                        i.this.r0 = "";
                        i.this.U = -1;
                        JSONArray jSONArray = jSONObject.getJSONArray("data");
                        if (i.this.R == null) {
                            i.this.R = new com.zte.iptvclient.android.common.player.f();
                        }
                        for (int i = 0; i < jSONArray.length(); i++) {
                            MultiDefinitionURLBean a2 = MultiDefinitionURLBean.a(jSONArray.getJSONObject(i));
                            LogEx.d(i.j2, "Definition =" + a2.f());
                            i.this.k0 = a2.k();
                            i.this.l0 = a2.g();
                            i.this.j0 = a2.c();
                            if ("ivi".equalsIgnoreCase(i.this.E0.getCpcode())) {
                                i.this.Z = i.this.f1;
                                i.this.o0 = a2.h();
                            } else if ("1".equals(a2.f())) {
                                i.this.Y = a2.i();
                                i.this.n0 = a2.h();
                                i.this.e0 = a2.a();
                            } else if ("2".equals(a2.f())) {
                                i.this.Z = a2.i();
                                i.this.o0 = a2.h();
                                i.this.f0 = a2.a();
                            } else if ("4".equals(a2.f())) {
                                i.this.X = a2.i();
                                i.this.m0 = a2.h();
                                i.this.d0 = a2.a();
                            } else if ("8".equals(a2.f())) {
                                i.this.a0 = a2.i();
                                i.this.p0 = a2.h();
                                i.this.g0 = a2.a();
                            } else if (GlobalConst.WINPHONE_CLIENT.equals(a2.f())) {
                                i.this.b0 = a2.i();
                                i.this.q0 = a2.h();
                                i.this.h0 = a2.a();
                            } else if (GlobalConst.ANDRIODSTB_CLIENT.equals(a2.f())) {
                                i.this.c0 = a2.i();
                                i.this.r0 = a2.h();
                                i.this.i0 = a2.a();
                            } else {
                                i.this.Z = a2.i();
                                i.this.o0 = a2.h();
                            }
                            i.this.g2.add(a2);
                        }
                        if ("Megogo".equalsIgnoreCase(i.this.E0.getCpcode())) {
                            if (i.this.S == null) {
                                return;
                            }
                            LogEx.d(i.j2, "videoCpCode is " + i.this.E0.getCpcode());
                            i.this.V = ((MultiDefinitionURLBean) i.this.g2.get(0)).i();
                            i.this.W = ((MultiDefinitionURLBean) i.this.g2.get(0)).f();
                            if (!TextUtils.isEmpty(((MultiDefinitionURLBean) i.this.g2.get(0)).a())) {
                                i.this.U = Integer.valueOf(((MultiDefinitionURLBean) i.this.g2.get(0)).a()).intValue();
                                if (i.this.U != 0 && i.this.K0 != null) {
                                    i.this.K0.M();
                                }
                            }
                            i.this.T();
                            i.this.a(i.this.V, 2);
                            return;
                        }
                        com.zte.iptvclient.android.common.customview.a.a.e.b bVar = new com.zte.iptvclient.android.common.customview.a.a.e.b(((com.zte.fragmentlib.b) i.this).h, R.style.dialog_order, null, i.this.g2);
                        bVar.a(new C0237a(jSONArray));
                        bVar.show();
                        return;
                    } catch (Exception e) {
                        LogEx.e(i.j2, e.getMessage());
                        return;
                    }
                }
                if ("Megogo".equalsIgnoreCase(i.this.E0.getCpcode())) {
                    if (i.this.S == null) {
                        return;
                    }
                    LogEx.d(i.j2, "videoCpCode is " + i.this.E0.getCpcode());
                    i.this.V = "";
                    i.this.W = "0";
                    if (!TextUtils.isEmpty(i.this.W)) {
                        i.this.U = 0;
                        if (i.this.U != 0 && i.this.K0 != null) {
                            i.this.K0.M();
                        }
                    }
                    i.this.T();
                    i iVar = i.this;
                    iVar.a(iVar.V, 2);
                    return;
                }
                com.zte.iptvclient.android.common.player.k.c cVar = i.this.S;
                if (cVar != null) {
                    cVar.Q2();
                }
            }
        }

        o() {
        }

        @Override // com.video.androidsdk.service.bookmark.SDKBookMarkMgr.OnBookMarkReturnListener
        public void onBookMarkReturn(String str, String str2, String str3) {
            LogEx.d(i.j2, "Test the starting speed : sdkQueryBookmark back");
            LogEx.i(i.j2, "PLAYBOOKMARK onBookMarkReturn == returncode" + str + " breakpoint " + str3);
            if (!"0".equals(str)) {
                i.this.K = "0";
            } else {
                try {
                    String optString = new JSONObject(str3).optString("breakpoint");
                    if (!TextUtils.isEmpty(optString)) {
                        i.this.K = optString;
                    } else {
                        i.this.K = "0";
                    }
                } catch (Exception unused) {
                    i.this.K = "0";
                }
            }
            if ("ivi".equalsIgnoreCase(i.this.E0.getCpcode())) {
                LogEx.d(i.j2, "videoCpCode is " + i.this.E0.getCpcode());
                i iVar = i.this;
                iVar.V = iVar.f1;
                i.this.T();
                i iVar2 = i.this;
                iVar2.a(iVar2.V, 2);
                return;
            }
            i.this.g2.clear();
            HashMap<String, String> hashMap = new HashMap<>();
            if (i.this.J == null) {
                LogEx.e(i.j2, "mCurEpisodeBean is null! return");
                return;
            }
            if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
                LogEx.d(i.j2, "update blackout info");
                com.zte.iptvclient.android.common.k.e.b(i.this.J.f(), i.this.J.e());
            }
            hashMap.put("programcode", i.this.J.j());
            hashMap.put("programtype", "10");
            hashMap.put("seriesprogramcode", i.this.E0.getProgramcode());
            hashMap.put("authtype", "0");
            hashMap.put("recommendtype", i.this.B0);
            hashMap.put("isquerybookmark", "1");
            hashMap.put("mediaservice", "2");
            SDKPlayMgr sDKPlayMgr = new SDKPlayMgr();
            LogEx.d(i.j2, "Test the starting speed : start MultiDefinitionUrl");
            sDKPlayMgr.getMultiDefinitionUrl(hashMap, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesFragment.java */
    /* loaded from: classes2.dex */
    public class p implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.player.j.l f5990a;

        /* compiled from: DetailSeriesFragment.java */
        /* loaded from: classes2.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f5992a;

            a(String str) {
                this.f5992a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                i.this.S.d3();
                i.this.S.a2();
                i.this.S.K(this.f5992a);
                i.this.S.E();
                i.this.S.D2();
            }
        }

        /* compiled from: DetailSeriesFragment.java */
        /* loaded from: classes2.dex */
        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f5994a;

            b(String str) {
                this.f5994a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                i.this.S.d3();
                i.this.S.I(this.f5994a);
                i.this.S.E();
                i.this.S.D2();
            }
        }

        /* compiled from: DetailSeriesFragment.java */
        /* loaded from: classes2.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LogEx.d(i.j2, "Test the starting speed : queryVodBlackout back continue play");
                i.this.S.d3();
                com.zte.iptvclient.android.common.f.b.b.j().h();
                i.this.S.f0();
                i.this.S.Z1();
                com.zte.iptvclient.android.common.player.f fVar = i.this.R;
                p pVar = p.this;
                fVar.a(pVar.f5990a, i.this.D0, ((com.zte.fragmentlib.b) i.this).h, i.this.u, i.this.S);
                i.this.S.q2();
            }
        }

        /* compiled from: DetailSeriesFragment.java */
        /* loaded from: classes2.dex */
        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i.this.S.d3();
                i.this.S.H2();
                i.this.S.a2();
                i.this.S.E();
                i.this.S.D2();
            }
        }

        p(com.zte.iptvclient.android.common.player.j.l lVar) {
            this.f5990a = lVar;
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void j() {
            LogEx.d(i.j2, "vod blackout无策略，正常播放");
            ((com.zte.fragmentlib.b) i.this).h.runOnUiThread(new c());
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void k(String str) {
            LogEx.d(i.j2, "vod blackout查询展示black照片:" + str);
            ((com.zte.fragmentlib.b) i.this).h.runOnUiThread(new a(str));
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void l() {
            LogEx.d(i.j2, "get Detail BlackoutInfo is null （pic url or play url is null）");
            ((com.zte.fragmentlib.b) i.this).h.runOnUiThread(new d());
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void r(String str) {
            LogEx.d(i.j2, "vod blackout查询播放black片源" + str);
            ((com.zte.fragmentlib.b) i.this).h.runOnUiThread(new b(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailSeriesFragment.java */
    /* loaded from: classes2.dex */
    public class q implements k.c {
        q() {
        }

        @Override // com.zte.iptvclient.android.common.f.b.k.c
        public void a(ArrayList<CommonVideoBean> arrayList) {
            if (arrayList != null) {
                LogEx.d(i.j2, "onRecommendVodListReturn:" + arrayList);
                if (i.this.K0 != null) {
                    i.this.K0.a(arrayList, 2);
                }
                if (arrayList.size() > 0) {
                    i.this.D.set(2, arrayList.get(0).d());
                    return;
                }
                return;
            }
            LogEx.d(i.j2, "onRecommendVodListReturn: null");
        }
    }

    /* compiled from: DetailSeriesFragment.java */
    /* loaded from: classes2.dex */
    private static class s extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<i> f6003a;

        public s(i iVar) {
            this.f6003a = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            i iVar = this.f6003a.get();
            if (iVar == null) {
                return;
            }
            switch (message.what) {
                case 40961:
                    GetUserStarRatingEntity getUserStarRatingEntity = (GetUserStarRatingEntity) message.obj;
                    iVar.b(getUserStarRatingEntity.f7631a, getUserStarRatingEntity.f7632b, getUserStarRatingEntity.f7634d, getUserStarRatingEntity.f7633c);
                    return;
                case 40962:
                    LogEx.d(i.j2, " handleMessage WHAT_GET_SERIES_HEAD_INFO_SUCCESS");
                    iVar.E0 = (SeriesHeadBean) message.obj;
                    if (iVar.F0) {
                        iVar.G0 = (SeriesHeadBean) message.obj;
                    }
                    iVar.F0 = false;
                    if (iVar.E0 != null) {
                        if ("3".equals(iVar.E0.getSeriestype())) {
                            if (iVar.Z0) {
                                iVar.i0();
                                return;
                            } else {
                                iVar.j0();
                                return;
                            }
                        }
                        iVar.z0();
                        iVar.e0();
                        iVar.M.clear();
                        iVar.E = 0;
                        int parseInt = (Integer.parseInt(iVar.E0.getSeriesnum()) / iVar.L) + 1;
                        for (int i = 0; i < parseInt; i++) {
                            i.l(iVar);
                            iVar.g(iVar.E);
                        }
                        if (!iVar.Z0) {
                            iVar.q0();
                        } else {
                            Fragment parentFragment = iVar.getParentFragment();
                            if (parentFragment instanceof com.zte.iptvclient.android.mobile.e0.e.j) {
                                ((com.zte.iptvclient.android.mobile.e0.e.j) parentFragment).a(iVar.G0);
                            }
                            if (iVar.K0 != null) {
                                iVar.K0.b(iVar.E0);
                            }
                        }
                    }
                    iVar.Q();
                    return;
                case 40963:
                    iVar.v = false;
                    return;
                case 40964:
                    if (iVar.S == null && iVar.A) {
                        iVar.f0();
                    }
                    ArrayList arrayList = (ArrayList) message.obj;
                    if (arrayList != null && arrayList.size() > 0) {
                        iVar.t0.addAll(arrayList);
                        for (int i2 = 0; i2 < iVar.t0.size(); i2++) {
                            String n = ((SeriesEpisodeBean) iVar.t0.get(i2)).n();
                            if (!iVar.N.contains(n)) {
                                if (!TextUtils.isEmpty(n)) {
                                    iVar.N.add(n);
                                } else {
                                    iVar.N.add("");
                                }
                            }
                        }
                        if (iVar.N.size() > 0) {
                            iVar.u0 = true;
                        } else {
                            iVar.u0 = false;
                        }
                        if ("0".equals(iVar.E0.getBreakpoint()) && iVar.N.size() > 0) {
                            com.zte.iptvclient.android.common.e.i.b bVar = new com.zte.iptvclient.android.common.e.i.b();
                            bVar.a((String) iVar.N.get(0));
                            EventBus.getDefault().post(bVar);
                        }
                        iVar.n0();
                        int i3 = message.arg1;
                        if (iVar.K0 != null) {
                            iVar.K0.b(iVar.N);
                        }
                        SeriesEposideExpandView I = iVar.I();
                        if (I != null) {
                            I.e(iVar.N);
                        }
                        iVar.w0.add(Integer.valueOf(i3));
                    }
                    iVar.v = false;
                    return;
                case 40965:
                default:
                    return;
                case 40966:
                    iVar.b(null, null, null, null);
                    return;
                case 40967:
                    if (iVar.S0 < 3) {
                        iVar.x0();
                        return;
                    } else {
                        iVar.S0 = 1;
                        return;
                    }
                case 40968:
                    SeriesEpisodeNavBean seriesEpisodeNavBean = (SeriesEpisodeNavBean) message.obj;
                    LogEx.d(i.j2, " 子集相关计算参数: " + seriesEpisodeNavBean.toString());
                    iVar.Q = seriesEpisodeNavBean.d();
                    iVar.G = seriesEpisodeNavBean.a();
                    iVar.O.clear();
                    iVar.O.addAll(seriesEpisodeNavBean.b());
                    iVar.E = seriesEpisodeNavBean.e();
                    iVar.P.clear();
                    iVar.P.addAll(seriesEpisodeNavBean.c());
                    iVar.F = iVar.G;
                    if (iVar.K0 != null) {
                        iVar.K0.a(iVar.O, iVar.P, iVar.E, iVar.F);
                        return;
                    }
                    return;
            }
        }
    }

    /* compiled from: DetailSeriesFragment.java */
    /* loaded from: classes2.dex */
    private static final class t implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<i> f6004a;

        /* renamed from: b, reason: collision with root package name */
        private String f6005b;

        /* renamed from: c, reason: collision with root package name */
        private String f6006c;

        /* renamed from: d, reason: collision with root package name */
        private int f6007d;

        public t(i iVar, String str, String str2, int i) {
            this.f6004a = new WeakReference<>(iVar);
            this.f6005b = str;
            this.f6006c = str2;
            this.f6007d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            Message obtain = Message.obtain();
            obtain.what = 40964;
            obtain.arg1 = this.f6007d;
            if (TextUtils.equals(this.f6005b, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(this.f6006c).getJSONArray("data");
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(SeriesEpisodeBean.a(jSONArray.getJSONObject(i)));
                    }
                    obtain.obj = arrayList;
                } catch (Exception e) {
                    LogEx.e(i.j2, e.getMessage());
                }
            }
            i iVar = this.f6004a.get();
            if (iVar != null) {
                iVar.h2.sendMessage(obtain);
            }
            LogEx.d(i.j2, "SeriesChildListReturnRunnable.run 耗时: " + (SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
        }
    }

    /* compiled from: DetailSeriesFragment.java */
    /* loaded from: classes2.dex */
    private static final class u implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<i> f6008a;

        /* renamed from: b, reason: collision with root package name */
        private String f6009b;

        /* renamed from: c, reason: collision with root package name */
        private String f6010c;

        public u(i iVar, String str, String str2) {
            this.f6008a = new WeakReference<>(iVar);
            this.f6009b = str;
            this.f6010c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            if ("18504004".equals(this.f6009b)) {
                i iVar = this.f6008a.get();
                if (iVar != null) {
                    iVar.h2.sendEmptyMessage(40967);
                    return;
                }
                return;
            }
            if (TextUtils.equals(this.f6009b, "0")) {
                try {
                    Message obtain = Message.obtain();
                    obtain.what = 40962;
                    JSONArray jSONArray = new JSONObject(this.f6010c).getJSONArray("data");
                    LogEx.d(i.j2, "query series head info ,data : " + this.f6010c);
                    if (jSONArray.length() > 0) {
                        obtain.obj = SeriesHeadBean.getSeriesHeadBeanFromJSon(jSONArray.getJSONObject(0));
                    }
                    i iVar2 = this.f6008a.get();
                    if (iVar2 != null) {
                        iVar2.h2.sendMessage(obtain);
                    }
                } catch (Exception e) {
                    LogEx.e(i.j2, e.getMessage());
                    i iVar3 = this.f6008a.get();
                    if (iVar3 != null) {
                        iVar3.h2.sendEmptyMessage(40963);
                    }
                }
            } else {
                i iVar4 = this.f6008a.get();
                if (iVar4 != null) {
                    iVar4.h2.sendEmptyMessage(40963);
                }
            }
            LogEx.d(i.j2, " SeriesHeadInfoReturnRunnable.run 耗时: " + (SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
        }
    }

    static /* synthetic */ int l(i iVar) {
        int i = iVar.E;
        iVar.E = i + 1;
        return i;
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.h.InterfaceC0281h
    public void c(String str, String str2) {
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.u = getChildFragmentManager();
        if (this.S == null) {
            f0();
        }
        d0();
        x0();
        s(this.C0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 20) {
            return;
        }
        LogEx.i(j2, " skip to LoginFragment");
        this.h.startActivity(new Intent(this.h, (Class<?>) LoginActivity.class));
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        LogEx.d(j2, "detail onConfigurationChanged");
        super.onConfigurationChanged(configuration);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogEx.d(j2, " onCreate ");
        try {
            ((InputMethodManager) this.h.getSystemService("input_method")).hideSoftInputFromWindow(this.h.getWindow().getDecorView().getWindowToken(), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("seriesprogramcode");
            this.z0 = string;
            if (TextUtils.isEmpty(string)) {
                this.z0 = arguments.getString("programcode");
            }
            this.A0 = arguments.getString("seriesnumber");
            this.B0 = arguments.getString("recommendtype", "0");
            this.C0 = arguments.getString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE);
            this.I0 = arguments.getBoolean("isOnLine");
            this.J0 = arguments.getBoolean("isSubscribe");
            this.A = arguments.getBoolean("isFromFloatWindow", false);
        }
        com.zte.iptvclient.android.mobile.e0.e.k kVar = new com.zte.iptvclient.android.mobile.e0.e.k();
        this.K0 = kVar;
        kVar.a((k.d0) this);
        this.K0.a(this);
        this.K0.a((k.e0) this);
        b(R.id.detail_series_vewpager, this.K0);
        EventBus.getDefault().register(this);
        this.c2 = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_Server_URL1");
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_App_Version_Android");
        this.d2 = propertiesInfo;
        if (TextUtils.isEmpty(propertiesInfo)) {
            this.d2 = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_App_Version");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.detail_series_fragment_llayout, viewGroup, false);
        this.Z0 = BaseApp.f();
        e(inflate);
        if (!this.Z0) {
            com.gyf.barlibrary.e c2 = com.gyf.barlibrary.e.c(getActivity());
            c2.a(false);
            c2.f();
            inflate.findViewById(R.id.ll_detail_series).setBackgroundResource(com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a() ? R.drawable.bg_child : R.drawable.bg_phone);
        }
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.M0) {
            this.L0.setVisibility(8);
        }
        T();
        if (!this.Z0) {
            com.gyf.barlibrary.e c2 = com.gyf.barlibrary.e.c(getActivity());
            c2.a(true);
            c2.f();
        }
        super.onDestroy();
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.s.b());
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.i.a());
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.a aVar) {
        LogEx.d(j2, "BackTrailerFristPlayVodEvent event");
        K();
        this.Q0 = false;
        O();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.M0 || !(y() instanceof com.zte.iptvclient.android.mobile.a0.b.b)) {
            return;
        }
        LogEx.d(j2, "onResume mIsFullScreenState is False and LiveTVFragment is include");
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        this.h.startActivity(new Intent(this.h, (Class<?>) LoginActivity.class));
    }

    private void B0() {
        ArrayList<com.zte.iptvclient.android.mobile.ivi.c.a> a2 = com.zte.iptvclient.android.common.j.d.d().a();
        if (a2.size() == 0) {
            return;
        }
        String b2 = b(a2.get(0), com.zte.iptvclient.android.common.j.d.d().b(), this.e1);
        this.b1.loadUrl("file:///android_asset/iviordersign.html");
        this.b1.setWebChromeClient(new g(b2));
    }

    private void C0() {
        boolean z;
        LogEx.d(j2, "mCurEpisodeNm = " + this.F);
        int i = this.F / this.L;
        if (i != this.E) {
            z = true;
            this.E = i;
        } else {
            z = false;
        }
        this.P = a(this.E, this.O, this.Q);
        SeriesEposideExpandView I = I();
        if (I != null) {
            if (z) {
                I.b(this.P);
            }
            I.a(this.F, this.E);
        }
        com.zte.iptvclient.android.mobile.e0.e.k kVar = this.K0;
        if (kVar != null) {
            SeriesEpisodeBean seriesEpisodeBean = this.J;
            if (seriesEpisodeBean != null) {
                kVar.a(seriesEpisodeBean, new Boolean[0]);
            }
            this.K0.b(this.F, this.E);
        }
        if (this.J != null) {
            if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
                LogEx.d(j2, "update blackout info");
                com.zte.iptvclient.android.common.k.e.b(this.J.f(), this.J.e());
            }
            O();
        }
        h0();
    }

    private void s0() {
        this.t0.clear();
        this.N.clear();
        this.A0 = null;
        P();
    }

    private void t0() {
        ArrayList<com.zte.iptvclient.android.mobile.ivi.c.a> a2 = com.zte.iptvclient.android.common.j.d.d().a();
        if (a2.size() == 0) {
            return;
        }
        String b2 = com.zte.iptvclient.android.common.j.d.d().b();
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        sDKNetHTTPRequest.setBody("seconds=2&fromstart=2&app_version=" + this.d2 + "&history_type=watch&uid=" + a2.get(0).a() + "&iviuid=" + a2.get(0).a() + "&contentid=" + this.i1 + "&watchid=" + this.j1 + "&session=" + b2);
        sDKNetHTTPRequest.startRequest("http://l.ivi.ru/logger/content/time/", HttpRequest.METHOD_POST, new C0236i(this));
    }

    private void u0() {
        com.zte.iptvclient.android.common.player.k.c cVar = this.S;
        if (cVar != null) {
            cVar.E();
            this.S.x2();
            this.S.g(false);
            this.S.d3();
            this.B.setVisibility(0);
        }
        com.zte.iptvclient.android.mobile.e0.e.k kVar = this.K0;
        if (kVar != null) {
            kVar.M();
        }
    }

    private void v0() {
        if (this.S == null) {
            f0();
        }
    }

    private void w0() {
        this.X0 = new SDKVodMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("columncode", this.E0.getColumncode());
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", "10");
        hashMap.put("ordertype", "0");
        hashMap.put("seriestype", "1,3");
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            hashMap.put("ratingid", com.zte.iptvclient.android.common.k.p.a(new com.zte.iptvclient.android.common.j.h(getContext()).t()));
            LogEx.d(j2, " Child Mode getVodSearchList param ratingid");
        }
        this.X0.getVodList(hashMap, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        this.v = true;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("programcode", this.z0);
        LogEx.d(j2, "getSeriesHeadInfo mProgramCode " + this.z0);
        SDKVodMgr sDKVodMgr = this.T0;
        if (sDKVodMgr != null) {
            sDKVodMgr.cancelRequest();
            this.T0 = null;
        }
        this.T0 = new SDKVodMgr();
        this.T0.getSeriesHeadInfo(hashMap, new m(SystemClock.currentThreadTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        if (this.Z0) {
            this.s.setVisibility(4);
        } else {
            this.s.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        com.zte.iptvclient.android.mobile.e0.e.k kVar = this.K0;
        if (kVar != null) {
            kVar.c(this.E0);
            SeriesHeadBean seriesHeadBean = this.E0;
            if (seriesHeadBean != null) {
                this.K0.s(seriesHeadBean.getTrailer());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        if (this.E0 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("contentcode", this.E0.getContentcode());
            hashMap.put("breakpoint", String.valueOf(this.F));
            hashMap.put("columncode", this.E0.getColumncode());
            hashMap.put("bookmarktype", "4");
            com.zte.iptvclient.android.common.f.b.c.c(hashMap);
        }
    }

    private int U() {
        int i;
        int indexOf = this.N.indexOf(String.valueOf(this.F));
        if (indexOf >= 0 || (i = this.F) >= this.Q) {
            return indexOf;
        }
        this.F = i + 1;
        return U();
    }

    private void V() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    private void W() {
        SDKVodMgr sDKVodMgr = this.T0;
        if (sDKVodMgr != null) {
            sDKVodMgr.cancelRequest();
        }
        SDKVodMgr sDKVodMgr2 = this.U0;
        if (sDKVodMgr2 != null) {
            sDKVodMgr2.cancelRequest();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = this.V0;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
        if (this.Z0) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment instanceof com.zte.iptvclient.android.mobile.e0.e.j) {
                ((com.zte.iptvclient.android.mobile.e0.e.j) parentFragment).I();
            }
        } else {
            com.zte.iptvclient.android.common.f.b.k kVar = this.W0;
            if (kVar != null) {
                kVar.a();
            }
            SDKVodMgr sDKVodMgr3 = this.X0;
            if (sDKVodMgr3 != null) {
                sDKVodMgr3.cancelRequest();
            }
        }
        SDKPlayMgr sDKPlayMgr = this.Y0;
        if (sDKPlayMgr != null) {
            sDKPlayMgr.cancelRequest();
        }
    }

    private String X() {
        ArrayList<SeriesHeadBean.a> vodInfoList = this.E0.getVodInfoList();
        if (vodInfoList != null && vodInfoList.size() > 0) {
            this.d1 = vodInfoList.get(0).a();
        }
        LogEx.d(j2, " strEncryptType  is " + this.d1);
        return this.d1;
    }

    private SeriesEpisodeBean Y() {
        int i;
        int i2 = this.E;
        int i3 = this.F;
        if (this.N.contains(String.valueOf(i3))) {
            this.E = i2;
            this.F = i3;
            i = this.N.indexOf(String.valueOf(i3));
            LogEx.d(j2, "index =" + i);
        } else {
            i = -1;
        }
        if (i <= -1 || this.t0.size() <= i) {
            return null;
        }
        return this.t0.get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        ArrayList<com.zte.iptvclient.android.mobile.ivi.c.a> a2 = com.zte.iptvclient.android.common.j.d.d().a();
        this.g1 = new ArrayList<>();
        if (a2.size() == 0) {
            return;
        }
        String a3 = a(a2.get(0), com.zte.iptvclient.android.common.j.d.d().b(), this.e1);
        this.b1.loadUrl("file:///android_asset/iviordersign.html");
        this.b1.setWebChromeClient(new f(a3));
    }

    private SeriesEpisodeBean a0() {
        int i = this.F;
        LogEx.d(j2, "getNextEpisodeInfo mCurNavPosition=" + this.E + " mCurEpisodeNm=" + this.F);
        int indexOf = this.N.contains(String.valueOf(i)) ? this.N.indexOf(String.valueOf(i)) : -1;
        if (indexOf <= -1 || indexOf >= this.t0.size()) {
            return null;
        }
        return this.t0.get(indexOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        String str = this.c2 + "/light/";
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json; charset=UTF-8");
        sDKNetHTTPRequest.setBody(c0());
        sDKNetHTTPRequest.startRequest(str, HttpRequest.METHOD_POST, new e());
    }

    private String c0() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("method", "da.timestamp.get");
        jsonObject.add(NativeProtocol.WEB_DIALOG_PARAMS, new JsonArray());
        LogEx.d(j2, "getTimesTampJsonParams : " + jsonObject.toString());
        return jsonObject.toString();
    }

    private void d0() {
        g0();
        if (this.Z0) {
            this.L = 40;
        }
        this.s0 = com.zte.iptvclient.android.common.k.o.j().f();
        ArrayList<String> arrayList = new ArrayList<>();
        this.D = arrayList;
        arrayList.add("");
        this.D.add("");
        this.D.add("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        com.zte.iptvclient.android.common.k.h.a().a(new r(this, this.E0, this.A0, this.L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        LogEx.d(j2, "initPlayer");
        this.R = new com.zte.iptvclient.android.common.player.f();
        com.zte.iptvclient.android.common.player.k.c cVar = new com.zte.iptvclient.android.common.player.k.c();
        this.S = cVar;
        cVar.a((a.i) this);
        this.S.a((c.n0) this);
        this.S.a((c.o0) this);
        this.S.a((b.w) this);
        this.S.a((b.v) this);
        this.S.a((b.a0) this);
        this.S.a((b.x) this);
        this.S.setTargetFragment(this, 20);
        if (this.A) {
            v0();
            this.S.setArguments(getArguments());
        }
        if (this.w != null && getActivity() != null) {
            androidx.fragment.app.r b2 = this.u.b();
            b2.a(R.id.rlayout_player_container, this.S, "PlayerFragment");
            b2.b();
        } else {
            LogEx.e(j2, "mLlayoutPlayContainer is null or context is null!");
            D();
        }
    }

    private void g0() {
        this.O = new ArrayList<>();
        this.P = new ArrayList<>();
        this.N = new ArrayList<>();
        this.v0 = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        LogEx.d(j2, "---judgeWhetherLoadNextPager---mCurNavPosition: " + this.E + " ,mCurEpisodeNm: " + this.F);
        com.zte.iptvclient.android.mobile.e0.e.k kVar = this.K0;
        if (kVar != null) {
            kVar.e(this.F);
        }
        int i = this.Q;
        int i2 = this.L;
        int i3 = i % i2;
        int i4 = i / i2;
        if (i3 != 0) {
            i4++;
        }
        int i5 = this.E;
        if (i5 != i4 - 1 && this.F % this.L == 0) {
            int i6 = i5 + 1 + 1;
            if (this.w0.contains(Integer.valueOf(i6))) {
                return;
            }
            g(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        LogEx.d(j2, "---notifyPadObtainAllSeason---");
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof com.zte.iptvclient.android.mobile.e0.e.j) {
            ((com.zte.iptvclient.android.mobile.e0.e.j) parentFragment).a(this.E0.getSeriestype(), this.E0.getSeriesprogramcode(), this.E0.getProgramcode(), this.E0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        LogEx.d(j2, "---notifyPhoneObtainAllSeason---");
        com.zte.iptvclient.android.mobile.e0.e.k kVar = this.K0;
        if (kVar != null) {
            kVar.a(this.E0);
        }
    }

    private boolean k0() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.T <= 500) {
            LogEx.w("UseeTv", "Operate limit,less than 500(ms)!");
            return true;
        }
        this.T = currentTimeMillis;
        return false;
    }

    private void l0() {
        SeriesEpisodeBean Y = Y();
        com.zte.iptvclient.android.mobile.e0.e.k kVar = this.K0;
        if (kVar != null) {
            kVar.b(false);
        }
        if (Y != null) {
            this.J = Y;
            C0();
        } else {
            if (this.x0) {
                LogEx.d(j2, "child list has been queried");
                return;
            }
            LogEx.w(j2, "no Episode can play");
            com.zte.iptvclient.android.common.player.k.c cVar = this.S;
            if (cVar != null) {
                cVar.d3();
                this.S.t("");
                this.S.Q2();
            }
        }
    }

    private void m0() {
        LogEx.d(j2, "playNextEpisode");
        SeriesEpisodeBean a0 = a0();
        com.zte.iptvclient.android.mobile.e0.e.k kVar = this.K0;
        if (kVar != null) {
            kVar.b(false);
        }
        if (a0 != null) {
            com.zte.iptvclient.android.common.f.b.g.a(a0);
            this.J = a0;
            C0();
        } else {
            if (this.y0) {
                LogEx.d(j2, "child list has been queried");
                return;
            }
            LogEx.w(j2, "no Episode can play");
            com.zte.iptvclient.android.common.player.k.c cVar = this.S;
            if (cVar != null) {
                cVar.d3();
                this.S.t("");
                this.S.k(this.F);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        LogEx.d(j2, "preparePlay mPlayLastEpisode=" + this.x0 + ",mPlayNextEpisode=" + this.y0 + " mListEpisode size:" + this.t0.size() + " mCurEpisodeNm:" + this.F);
        if (this.x0) {
            this.x0 = false;
            l0();
            return;
        }
        if (this.y0) {
            this.y0 = false;
            m0();
            return;
        }
        int indexOf = this.N.indexOf(String.valueOf(this.F));
        if ((indexOf >= 0 || (indexOf = U()) >= 0) && indexOf < this.t0.size()) {
            SeriesEpisodeBean seriesEpisodeBean = this.t0.get(indexOf);
            this.J = seriesEpisodeBean;
            com.zte.iptvclient.android.mobile.e0.e.k kVar = this.K0;
            if (kVar == null || seriesEpisodeBean == null) {
                return;
            }
            Boolean[] boolArr = new Boolean[1];
            boolArr[0] = Boolean.valueOf(this.F == this.G);
            kVar.a(seriesEpisodeBean, boolArr);
        }
    }

    private void o0() {
        com.zte.iptvclient.android.common.player.j.l lVar = new com.zte.iptvclient.android.common.player.j.l();
        lVar.a(this.J.e());
        lVar.b(this.J.f());
        if (this.A) {
            return;
        }
        if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
            LogEx.d(j2, "enter blackout");
            LogEx.d(j2, "Test the starting speed : start queryVodBlackout ");
            com.zte.iptvclient.android.common.f.b.b.j().a(this.J.f(), this.J.e(), new p(lVar));
        } else {
            this.S.Z1();
            this.R.a(lVar, this.D0, this.h, this.u, this.S);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        SDKBookMarkMgr sDKBookMarkMgr = new SDKBookMarkMgr();
        GetBookMarkReq getBookMarkReq = new GetBookMarkReq();
        getBookMarkReq.bookmarktype = "1";
        getBookMarkReq.columncode = this.C0;
        getBookMarkReq.contentcode = this.J.f();
        LogEx.d(j2, "Test the starting speed : start sdkQueryBookmark ");
        sDKBookMarkMgr.getBookMark(getBookMarkReq.toHashMap(), new o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        if (TextUtils.isEmpty(this.s0)) {
            w0();
        } else {
            r0();
        }
    }

    private void r0() {
        VideoDetailBean videoDetailBean = new VideoDetailBean();
        videoDetailBean.setProgramcode(this.G0.getProgramcode());
        videoDetailBean.setProgramtype(this.G0.getProgramtype());
        videoDetailBean.setCpcode(this.G0.getCpcode());
        videoDetailBean.setBocode(this.G0.getBocode());
        videoDetailBean.setMediaservices(this.G0.getMediaservices());
        videoDetailBean.setSeriestype(this.G0.getSeriestype());
        videoDetailBean.setContentcode(this.G0.getContentcode());
        videoDetailBean.setColumncode(this.G0.getColumncode());
        com.zte.iptvclient.android.common.f.b.k kVar = new com.zte.iptvclient.android.common.f.b.k(this.h, this.s0, videoDetailBean, new q());
        this.W0 = kVar;
        kVar.a(2);
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        if (this.M0) {
            G();
            this.M0 = false;
            if (this.p != null) {
                this.L0.setVisibility(8);
                this.p.setVisibility(8);
            }
            y0();
            com.zte.iptvclient.android.common.player.k.c cVar = this.S;
            if (cVar != null) {
                cVar.H1();
            }
            return true;
        }
        com.zte.iptvclient.android.common.player.k.c cVar2 = this.S;
        if (cVar2 != null && cVar2.v2()) {
            return true;
        }
        V();
        return false;
    }

    public SeriesEposideExpandView I() {
        View childAt = this.N0.getChildAt(r0.getChildCount() - 1);
        if (childAt instanceof SeriesEposideExpandView) {
            return (SeriesEposideExpandView) childAt;
        }
        return null;
    }

    public com.zte.iptvclient.android.common.player.k.c J() {
        return this.S;
    }

    public void K() {
        com.zte.iptvclient.android.common.player.k.c cVar = this.S;
        if (cVar != null) {
            cVar.U1();
            this.S.f2();
        }
    }

    public void L() {
        com.zte.iptvclient.android.mobile.e0.e.a aVar = new com.zte.iptvclient.android.mobile.e0.e.a();
        aVar.a(new d());
        Bundle bundle = new Bundle();
        bundle.putString("contentCode", this.E0.getContentcode());
        aVar.setArguments(bundle);
        b(R.id.parent_movie, aVar);
        this.O0.setVisibility(0);
    }

    public void M() {
        SeriesEpisodeBean seriesEpisodeBean;
        if (this.S != null) {
            com.zte.iptvclient.android.common.e.r.g gVar = new com.zte.iptvclient.android.common.e.r.g();
            if (TextUtils.isEmpty(this.R0) && (seriesEpisodeBean = this.J) != null) {
                this.R0 = com.zte.iptvclient.android.mobile.h.a.b.a(seriesEpisodeBean.e(), this.J.j(), this.J.l(), this.J.f(), this.J.k(), this.J.o());
            }
            if (this.E0 != null) {
                RelativeLayout relativeLayout = this.B;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                gVar.a(this.E0.getContentcode());
                gVar.d("1");
                gVar.c(this.R0);
                LogEx.d(j2, "mStrPushURL " + this.R0);
                this.S.a(gVar);
            }
        }
    }

    public void N() {
        this.N0.findViewById(R.id.detail_series_vewpager).setVisibility(0);
        this.N0.removeViewAt(r0.getChildCount() - 1);
    }

    public void O() {
        com.zte.iptvclient.android.common.player.k.c cVar = this.S;
        if (cVar != null) {
            cVar.g2();
        }
        if (!this.a1) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.h.getResources().getString(R.string.area_limits));
            return;
        }
        com.zte.iptvclient.android.common.player.k.c cVar2 = this.S;
        if (cVar2 == null) {
            LogEx.d(j2, "initPlayer");
            f0();
        } else {
            cVar2.l(true);
        }
        RelativeLayout relativeLayout = this.B;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        if (!com.zte.iptvclient.android.mobile.n.c.b.t() && this.S != null) {
            this.P0 = true;
            LogEx.d(j2, "###showLoginToPlayView()");
            this.S.N2();
            return;
        }
        LogEx.d(j2, "videoCpCode is " + this.E0.getCpcode());
        if ("megogo".equalsIgnoreCase(this.E0.getCpcode())) {
            if (!new com.zte.iptvclient.android.common.j.h(this.h).w()) {
                com.zte.iptvclient.android.common.player.k.c cVar3 = this.S;
                if (cVar3 != null) {
                    cVar3.Q2();
                    return;
                }
                return;
            }
            if (!TextUtils.equals(X(), "0")) {
                com.zte.iptvclient.android.common.player.k.c cVar4 = this.S;
                if (cVar4 != null) {
                    cVar4.Q2();
                    return;
                }
                return;
            }
        } else if ("ivi".equalsIgnoreCase(this.E0.getCpcode())) {
            com.zte.iptvclient.android.common.player.k.c cVar5 = this.S;
            if (cVar5 != null) {
                cVar5.L(this.E0.getCpcode());
            }
            if (!a(this.E0)) {
                com.zte.iptvclient.android.common.player.k.c cVar6 = this.S;
                if (cVar6 != null) {
                    cVar6.Q2();
                    return;
                }
                return;
            }
            if (!TextUtils.equals(X(), "0")) {
                com.zte.iptvclient.android.common.player.k.c cVar7 = this.S;
                if (cVar7 != null) {
                    cVar7.Q2();
                    return;
                }
                return;
            }
        }
        K();
        SeriesEposideExpandView I = I();
        if (I != null) {
            I.a(this.F, this.E);
        }
        com.zte.iptvclient.android.mobile.e0.e.k kVar = this.K0;
        if (kVar != null) {
            SeriesEpisodeBean seriesEpisodeBean = this.J;
            if (seriesEpisodeBean != null) {
                kVar.a(seriesEpisodeBean, new Boolean[0]);
            }
            this.K0.b(this.F, this.E);
        }
        if ("ivi".equalsIgnoreCase(this.E0.getCpcode())) {
            SeriesEpisodeBean seriesEpisodeBean2 = this.J;
            if (seriesEpisodeBean2 == null) {
                com.zte.iptvclient.android.common.player.k.c cVar8 = this.S;
                if (cVar8 != null) {
                    cVar8.Q2();
                    return;
                }
                return;
            }
            String o2 = seriesEpisodeBean2.o();
            this.i1 = o2;
            com.zte.iptvclient.android.mobile.ivi.a.a(o2, new c());
            return;
        }
        p0();
    }

    public void P() {
        this.J = null;
        this.E0 = null;
        this.w0.clear();
        this.N.clear();
        this.P.clear();
        this.O.clear();
        x0();
    }

    public void Q() {
        String replace = "http://{ipadd:port}/iptvepg/{frame}/sdk_getuserstarrating.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f());
        if (this.E0 != null) {
            LogEx.d(j2, "[method] sdkQueryUserStarRating" + replace);
            SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
            this.V0 = sDKNetHTTPRequest;
            sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
            this.V0.setCharset("gbk");
            this.V0.setParam("columncode", this.E0.getColumncode());
            this.V0.setParam("programcode", this.E0.getProgramcode());
            this.V0.setParam("mediaservice", "2");
            this.V0.setParam("isfilterratingid", "0");
            this.V0.startRequest(replace, HttpRequest.METHOD_GET, new h());
        }
    }

    public void R() {
        LogEx.d(j2, "start Trailer");
        if (!this.a1) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.h.getResources().getString(R.string.area_limits));
            return;
        }
        if (this.E0 == null) {
            return;
        }
        LogEx.d(j2, "videoCpCode is " + this.E0.getCpcode());
        if ("megogo".equalsIgnoreCase(this.E0.getCpcode())) {
            if (!new com.zte.iptvclient.android.common.j.h(this.h).w()) {
                com.zte.iptvclient.android.common.player.k.c cVar = this.S;
                if (cVar != null) {
                    cVar.Q2();
                    return;
                }
                return;
            }
            if (!TextUtils.equals(X(), "0")) {
                com.zte.iptvclient.android.common.player.k.c cVar2 = this.S;
                if (cVar2 != null) {
                    cVar2.Q2();
                    return;
                }
                return;
            }
        }
        String trailer = this.E0.getTrailer();
        if (TextUtils.isEmpty(trailer)) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(getString(R.string.no_trailer_available));
            return;
        }
        if (this.S == null) {
            f0();
        }
        RelativeLayout relativeLayout = this.B;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        b(trailer, 1);
    }

    @Override // com.zte.iptvclient.android.common.player.k.b.x
    public void p() {
        if (this.S == null) {
            f0();
        }
        K();
        if (this.u0 && this.E0 != null) {
            this.Q0 = false;
            O();
        } else {
            com.zte.iptvclient.android.common.player.k.c cVar = this.S;
            if (cVar != null) {
                cVar.Q2();
            }
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b.a0
    public void q(String str) {
        com.zte.iptvclient.android.common.javabean.b bVar = new com.zte.iptvclient.android.common.javabean.b();
        bVar.d(this.E0.getProgramcode());
        bVar.a(this.E0.getColumncode());
        bVar.b(this.E0.getProgramtype());
        bVar.g(this.E0.getTelecomcode());
        bVar.e(this.E0.getProgramname());
        bVar.f(this.B0);
        bVar.c(this.e2);
        com.zte.iptvclient.android.common.f.b.a aVar = new com.zte.iptvclient.android.common.f.b.a(this.h, bVar, new b(), this);
        aVar.a(this.C);
        aVar.a();
    }

    public void s(String str) {
        String str2 = "http://{ipadd:port}/iptvepg/{frame}/sdk_getareaauth.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f()) + "?columncode=" + str;
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.setCharset("gbk");
        sDKNetHTTPRequest.startRequest(str2, HttpRequest.METHOD_GET, new j());
    }

    public void t(String str) {
        com.zte.iptvclient.android.mobile.e0.e.k kVar = this.K0;
        if (kVar != null) {
            kVar.t(str);
        }
    }

    public void u(String str) {
        this.z0 = str;
        W();
        u0();
        s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i) {
        if (i == 0) {
            p0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i) {
        this.v = true;
        if (this.M.size() != 0) {
            for (int i2 = 0; i2 < this.M.size(); i2++) {
                if (i == this.M.get(i2).intValue()) {
                    return;
                }
            }
        }
        this.M.add(Integer.valueOf(i));
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pageno", String.valueOf(i));
        hashMap.put("numperpage", String.valueOf(this.L));
        hashMap.put("seriesprogramcode", this.E0.getProgramcode());
        LogEx.d(j2, "getSeriesChildlList mPageNo " + i);
        SDKVodMgr sDKVodMgr = new SDKVodMgr();
        this.U0 = sDKVodMgr;
        sDKVodMgr.getSeriesChildlList(hashMap, new n(i));
    }

    private void h(int i) {
        com.zte.iptvclient.android.mobile.e0.e.k kVar = this.K0;
        if (kVar != null) {
            kVar.b(false);
        }
        SeriesEpisodeBean seriesEpisodeBean = this.t0.get(i);
        this.J = seriesEpisodeBean;
        if (seriesEpisodeBean != null) {
            this.Q0 = false;
            O();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public int i() {
        return this.y;
    }

    private void e(View view) {
        this.N0 = (FrameLayout) view.findViewById(R.id.fl_series_episode_expand_container);
        this.O0 = (FrameLayout) view.findViewById(R.id.parent_movie);
        this.L0 = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        this.L0.setHeight(a2);
        this.L0.setVisibility(8);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_multiscreen_head);
        this.p = relativeLayout;
        this.q = (ImageView) relativeLayout.findViewById(R.id.img_close);
        this.r = (TextView) this.p.findViewById(R.id.tv_img_close);
        this.t = (TextView) this.p.findViewById(R.id.txt_head_title);
        this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.multi_back));
        this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.multiscreen_watch));
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        this.p.setVisibility(8);
        this.w = (RelativeLayout) view.findViewById(R.id.rlayout_player_container);
        this.x = (RelativeLayout) view.findViewById(R.id.detail_series_player_container_llayout);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        this.x.getViewTreeObserver().addOnGlobalLayoutListener(new k());
        this.s = (ImageView) view.findViewById(R.id.series_back);
        y0();
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        this.B = (RelativeLayout) view.findViewById(R.id.imgvew_play_bg);
        ImageView imageView = (ImageView) view.findViewById(R.id.detail_series_play_imgvew);
        this.C = imageView;
        imageView.setEnabled(false);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        this.s.setOnClickListener(this.i2);
        this.C.setOnClickListener(this.i2);
        this.q.setOnClickListener(this.i2);
        this.r.setOnClickListener(this.i2);
        WebView webView = (WebView) view.findViewById(R.id.webview);
        this.b1 = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.h.InterfaceC0281h
    public void c(int i) {
        if (this.w0.contains(Integer.valueOf(i)) || this.v) {
            return;
        }
        g(i);
    }

    public void d(View view) {
        this.N0.findViewById(R.id.detail_series_vewpager).setVisibility(8);
        this.N0.addView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.mobile.ivi.b.b bVar) {
        B0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3, String str4) {
        LogEx.d(j2, "doScoreAndMark ratingsum: " + str + ", ratingnum: " + str2 + ", imdb: " + str3 + ", kinopoisk: " + str4 + ", mDetailMoveInfoFragment: " + this.K0);
        com.zte.iptvclient.android.mobile.e0.e.k kVar = this.K0;
        if (kVar != null) {
            kVar.b(str, str2, str3, str4);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.mobile.ivi.b.a aVar) {
        t0();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.eventbus.multi.c cVar) {
        if (cVar == null || !cVar.a()) {
            this.M0 = false;
            if (this.p != null) {
                this.L0.setVisibility(8);
                this.p.setVisibility(8);
            }
            com.zte.iptvclient.android.common.player.k.c cVar2 = this.S;
            if (cVar2 != null) {
                cVar2.H1();
            }
            y0();
        }
    }

    public void d(int i) {
        this.E = i;
        if (!this.w0.contains(Integer.valueOf(i + 1))) {
            this.u0 = false;
            if (this.v) {
                return;
            }
            g(this.E + 1);
            return;
        }
        this.u0 = true;
    }

    private void b(String str, int i) {
        String str2;
        this.S.w2();
        com.zte.iptvclient.android.mobile.download.helper.a.n().a((Boolean) true);
        Bundle bundle = new Bundle();
        this.D0 = bundle;
        bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, str);
        this.D0.putString("posterUrl", this.E0.getPosterfilelist());
        this.D0.putString("posterfilelist", this.E0.getPosterfilelist());
        this.D0.putBoolean("IsVRVideo", false);
        this.D0.putString("cpcode", this.E0.getCpcode());
        this.D0.putString("cmsid", this.j0);
        if (this.E0.getCpcode().equals("Megogo")) {
            for (int i2 = 0; i2 < this.H0.size(); i2++) {
                if (TextUtils.equals(this.H0.get(i2).a(), "240")) {
                    this.D0.putString("url_240p", this.H0.get(i2).b());
                } else if (TextUtils.equals(this.H0.get(i2).a(), "320")) {
                    this.D0.putString("url_320p", this.H0.get(i2).b());
                } else if (TextUtils.equals(this.H0.get(i2).a(), "360")) {
                    this.D0.putString("url_360p", this.H0.get(i2).b());
                } else if (TextUtils.equals(this.H0.get(i2).a(), "480")) {
                    this.D0.putString("url_480p", this.H0.get(i2).b());
                } else if (TextUtils.equals(this.H0.get(i2).a(), "720")) {
                    this.D0.putString("url_720p", this.H0.get(i2).b());
                } else if (TextUtils.equals(this.H0.get(i2).a(), "1080")) {
                    this.D0.putString("url_1080p", this.H0.get(i2).b());
                } else if (TextUtils.equals(this.H0.get(i2).a(), "2160")) {
                    this.D0.putString("url_2160p", this.H0.get(i2).b());
                }
            }
        } else {
            if (!TextUtils.isEmpty(this.n0)) {
                str2 = this.n0;
            } else if (!TextUtils.isEmpty(this.o0)) {
                str2 = this.o0;
            } else if (!TextUtils.isEmpty(this.m0)) {
                str2 = this.m0;
            } else if (!TextUtils.isEmpty(this.p0)) {
                str2 = this.p0;
            } else if (!TextUtils.isEmpty(this.q0)) {
                str2 = this.q0;
            } else {
                str2 = !TextUtils.isEmpty(this.r0) ? this.r0 : "";
            }
            this.D0.putString("physicalcontentid", str2);
            this.D0.putString("physicalcontentid_url_sd", this.n0);
            this.D0.putString("physicalcontentid_url_sd_h", this.o0);
            this.D0.putString("physicalcontentid_url_hd", this.m0);
            this.D0.putString("physicalcontentid_url_480p", this.p0);
            this.D0.putString("physicalcontentid_url_720p", this.q0);
            this.D0.putString("physicalcontentid_url_1280p", this.r0);
        }
        this.D0.putString("seriesprogramcode", this.E0.getProgramcode());
        this.D0.putString("seriescontentcode", this.E0.getContentcode());
        this.D0.putString("seriescolumncode", this.E0.getColumncode());
        this.D0.putString("seriesprogramname", this.E0.getProgramname());
        if (this.R == null) {
            this.R = new com.zte.iptvclient.android.common.player.f();
        }
        this.R.a(false);
        if (1 == i) {
            com.zte.iptvclient.android.mobile.e0.e.k kVar = this.K0;
            if (kVar != null) {
                kVar.b(false);
            }
            this.D0.putString("programname", this.E0.getProgramname());
            this.D0.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_SENIOR_TRAILER.getIntValue()));
            this.D0.putString("programcode", this.E0.getProgramcode());
            String a2 = com.zte.iptvclient.android.mobile.h.a.b.a(this.E0.getColumncode(), this.E0.getProgramcode(), this.E0.getProgramtype(), this.E0.getTelecomcode());
            this.R0 = a2;
            this.D0.putString("playuri4dlna", a2);
            this.D0.putString(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTELECOMCODE, this.E0.getTelecomcode());
            this.D0.putBoolean("isTrailer", true);
            com.zte.iptvclient.android.common.player.j.k kVar2 = new com.zte.iptvclient.android.common.player.j.k();
            kVar2.a(this.E0.getColumncode());
            kVar2.b(this.E0.getContentcode());
            this.R.a(kVar2, this.D0, this.h, this.u, R.id.rlayout_player_container, this.S);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DetailSeriesFragment.java */
    /* loaded from: classes2.dex */
    public static final class r implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<i> f5999a;

        /* renamed from: b, reason: collision with root package name */
        private SeriesHeadBean f6000b;

        /* renamed from: c, reason: collision with root package name */
        private String f6001c;

        /* renamed from: d, reason: collision with root package name */
        private int f6002d;
        private int e = 0;

        public r(i iVar, SeriesHeadBean seriesHeadBean, String str, int i) {
            this.f5999a = new WeakReference<>(iVar);
            this.f6000b = seriesHeadBean;
            this.f6001c = str;
            this.f6002d = i;
        }

        private ArrayList<String> a(int i, ArrayList<String> arrayList) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            int i2 = this.e;
            int i3 = this.f6002d;
            int i4 = i % i3;
            int i5 = i3 * i2;
            int size = arrayList.size();
            if (size > 0) {
                if (i2 == size - 1) {
                    if (i4 == 0) {
                        int i6 = i5;
                        while (i6 < this.f6002d + i5) {
                            i6++;
                            arrayList2.add(String.valueOf(i6));
                        }
                    } else {
                        int i7 = i5;
                        while (i7 < i5 + i4) {
                            i7++;
                            arrayList2.add(String.valueOf(i7));
                        }
                    }
                } else if (size == 1) {
                    while (i2 < i) {
                        i2++;
                        arrayList2.add(String.valueOf(i2));
                    }
                } else {
                    int i8 = i5;
                    while (i8 < this.f6002d + i5) {
                        i8++;
                        arrayList2.add(String.valueOf(i8));
                    }
                }
            }
            return arrayList2;
        }

        private int b() {
            int intValue;
            try {
                String seriesnum = this.f6000b.getSeriesnum();
                String updatenum = this.f6000b.getUpdatenum();
                if (TextUtils.isEmpty(seriesnum)) {
                    intValue = !TextUtils.isEmpty(updatenum) ? Integer.valueOf(updatenum).intValue() : 0;
                } else {
                    intValue = Integer.valueOf(seriesnum).intValue();
                }
                if (intValue < 0) {
                    return 0;
                }
                return intValue;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            int b2 = b();
            int a2 = a();
            ArrayList<String> a3 = a(b2, a2);
            ArrayList<String> a4 = a(b2, a3);
            SeriesEpisodeNavBean seriesEpisodeNavBean = new SeriesEpisodeNavBean();
            seriesEpisodeNavBean.b(b2);
            seriesEpisodeNavBean.a(a2);
            seriesEpisodeNavBean.a(a3);
            seriesEpisodeNavBean.b(a4);
            seriesEpisodeNavBean.c(this.e);
            i iVar = this.f5999a.get();
            if (iVar != null) {
                Message obtainMessage = iVar.h2.obtainMessage();
                obtainMessage.what = 40968;
                obtainMessage.obj = seriesEpisodeNavBean;
                iVar.h2.sendMessage(obtainMessage);
            }
            LogEx.d(i.j2, " EpisodeParamRunnable.run 耗时: " + (SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
        }

        private ArrayList<String> a(int i, int i2) {
            ArrayList<String> arrayList = new ArrayList<>((i / this.f6002d) + 1);
            int i3 = this.f6002d;
            int i4 = 0;
            if (i <= i3) {
                arrayList.add("1-" + i);
                if (i2 >= 1 && i2 <= i) {
                    this.e = 0;
                }
            } else {
                int i5 = i / i3;
                while (i4 < i5) {
                    StringBuilder sb = new StringBuilder();
                    int i6 = this.f6002d;
                    int i7 = (i4 * i6) + 1;
                    int i8 = i4 + 1;
                    int i9 = i6 * i8;
                    sb.append(i7);
                    sb.append("-");
                    sb.append(i9);
                    arrayList.add(sb.toString());
                    if (i2 >= i7 && i2 <= i9) {
                        this.e = i4;
                    }
                    i4 = i8;
                }
                if (i % this.f6002d > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    int i10 = (this.f6002d * i5) + 1;
                    sb2.append(i10);
                    sb2.append("-");
                    sb2.append(i);
                    arrayList.add(sb2.toString());
                    if (i2 >= i10 && i2 <= i) {
                        this.e = i5;
                    }
                }
            }
            return arrayList;
        }

        private int a() {
            int intValue;
            String breakpoint = this.f6000b.getBreakpoint();
            try {
                if (!TextUtils.isEmpty(this.f6001c)) {
                    intValue = Integer.valueOf(this.f6001c).intValue();
                } else {
                    if (TextUtils.isEmpty(breakpoint)) {
                        return 0;
                    }
                    intValue = Integer.valueOf(breakpoint).intValue();
                }
                return intValue;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        String str2;
        if (this.R == null) {
            this.R = new com.zte.iptvclient.android.common.player.f();
        }
        if (!this.R.a(this.J.b())) {
            com.zte.iptvclient.android.common.player.k.c cVar = this.S;
            if (cVar != null) {
                cVar.j(1);
                return;
            }
            return;
        }
        com.zte.iptvclient.android.common.player.k.c cVar2 = this.S;
        if (cVar2 != null && cVar2.p0() >= 0) {
            this.S.w2();
            com.zte.iptvclient.android.mobile.download.helper.a.n().a((Boolean) true);
            this.D0 = new Bundle();
            LogEx.d(j2, "videoCpCode is " + this.E0.getCpcode());
            if (!"megogo".equalsIgnoreCase(this.E0.getCpcode())) {
                if ("ivi".equalsIgnoreCase(this.E0.getCpcode())) {
                    this.D0.putString(ParamConst.UPDATE_VERSION_RSP_URL, str);
                    this.D0.putString("definition", "MP4-hi");
                    this.D0.putParcelableArrayList("ividefinitionList", this.g1);
                } else {
                    this.D0.putString(ParamConst.UPDATE_VERSION_RSP_URL, str);
                    this.D0.putString("definition", this.W);
                    this.D0.putString("url_hd", this.X);
                    this.D0.putString("url_sd", this.Y);
                    this.D0.putString("url_sd_h", this.Z);
                    this.D0.putString("url_480p", this.a0);
                    this.D0.putString("url_720p", this.b0);
                    this.D0.putString("url_1280p", this.c0);
                    this.D0.putString("auth_sd", this.e0);
                    this.D0.putString("auth_sd_h", this.f0);
                    this.D0.putString("auth_hd", this.d0);
                    this.D0.putString("auth_480p", this.g0);
                    this.D0.putString("auth_720p", this.h0);
                    this.D0.putString("auth_1280p", this.i0);
                    this.D0.putString("cmsid", this.j0);
                    if (!TextUtils.isEmpty(this.n0)) {
                        str2 = this.n0;
                    } else if (!TextUtils.isEmpty(this.o0)) {
                        str2 = this.o0;
                    } else if (!TextUtils.isEmpty(this.m0)) {
                        str2 = this.m0;
                    } else if (!TextUtils.isEmpty(this.p0)) {
                        str2 = this.p0;
                    } else if (!TextUtils.isEmpty(this.q0)) {
                        str2 = this.q0;
                    } else {
                        str2 = !TextUtils.isEmpty(this.r0) ? this.r0 : "";
                    }
                    this.D0.putString("physicalcontentid", str2);
                    this.D0.putString("physicalcontentid_url_hd", this.m0);
                    this.D0.putString("physicalcontentid_url_sd", this.n0);
                    this.D0.putString("physicalcontentid_url_sd_h", this.o0);
                    this.D0.putString("physicalcontentid_url_480p", this.p0);
                    this.D0.putString("physicalcontentid_url_720p", this.q0);
                    this.D0.putString("physicalcontentid_url_1280p", this.r0);
                }
            }
            this.D0.putString("systemlimitenable", this.k0);
            this.D0.putString("genrelock", this.l0);
            this.D0.putString("posterUrl", this.E0.getPosterfilelist());
            this.D0.putString("posterfilelist", this.E0.getPosterfilelist());
            this.D0.putString("columncode", this.J.e());
            this.D0.putString("Id", this.J.j());
            this.D0.putString("contentcode", this.J.f());
            this.D0.putString("ratingid", this.J.m());
            this.D0.putBoolean("IsVRVideo", false);
            this.D0.putString(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTELECOMCODE, this.J.o());
            this.D0.putString("cpcode", this.E0.getCpcode());
            this.D0.putString(ParamConst.VOD_DETAIL_QUERY_RSP_ENCRYPTTYPE, X());
            this.D0.putString("price", this.E0.getPrice());
            this.D0.putString("seriesprogramcode", this.E0.getProgramcode());
            this.D0.putString("seriescontentcode", this.E0.getContentcode());
            this.D0.putString("seriescolumncode", this.E0.getColumncode());
            this.D0.putString("seriesprogramname", this.E0.getProgramname());
            if (Integer.parseInt(this.J.a()) > 0 && TextUtils.equals("1", ConfigMgr.readPropertie("isSupportQueryAds"))) {
                this.R.a(true);
            } else {
                this.R.a(false);
            }
            if (1 == i) {
                this.D0.putString("programname", this.E0.getProgramname());
                this.D0.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_SENIOR_TRAILER.getIntValue()));
                this.D0.putString("programcode", this.E0.getProgramcode());
                String a2 = com.zte.iptvclient.android.mobile.h.a.b.a(this.E0.getColumncode(), this.E0.getProgramcode(), this.E0.getProgramtype(), this.E0.getTelecomcode());
                this.R0 = a2;
                this.D0.putString("playuri4dlna", a2);
                this.D0.putString(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTELECOMCODE, this.E0.getTelecomcode());
                this.D0.putBoolean("isTrailer", true);
                com.zte.iptvclient.android.common.player.j.k kVar = new com.zte.iptvclient.android.common.player.j.k();
                kVar.a(this.E0.getColumncode());
                kVar.b(this.E0.getContentcode());
                com.zte.iptvclient.android.common.player.k.c cVar3 = this.S;
                if (cVar3 != null) {
                    cVar3.setTargetFragment(this, 20);
                    this.R.a(kVar, this.D0, this.h, this.u, R.id.rlayout_player_container, this.S);
                    return;
                }
                return;
            }
            if (this.Q0) {
                this.R.b("0");
                LogEx.d(j2, "PALYBOOKMARK repLay forcuse 0");
            } else {
                if (!TextUtils.isEmpty(this.f2)) {
                    this.R.b(this.f2);
                } else {
                    this.R.b(this.K);
                }
                LogEx.d(j2, "PALYBOOKMARK " + this.J.d());
            }
            this.D0.putString("programname", this.J.k());
            this.D0.putBoolean("isTrailer", false);
            this.D0.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, this.U);
            this.D0.putInt("curepisode", this.F);
            this.D0.putInt("allepisodes", this.Q);
            this.D0.putString("programcode", this.J.j());
            this.D0.putString("directorprogramcode", this.D.get(0));
            this.D0.putString("actorprogramcode", this.D.get(1));
            this.D0.putString("recomendprogramcode", this.D.get(2));
            this.D0.putString("shareImage", com.zte.iptvclient.android.common.k.g.a(this.Z0 ? 9 : 3, this.E0.getPosterfilelist()));
            this.D0.putString(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTELECOMCODE, this.J.o());
            this.D0.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_SERIES.getIntValue()));
            if (TextUtils.equals(ConfigMgr.readPropertie("IsSupportSeriesDLNAExtend"), "1")) {
                String a3 = com.zte.iptvclient.android.mobile.h.a.b.a(this.J.e(), this.J.j(), this.J.l(), this.J.f(), this.J.k(), this.J.o(), this.E0.getTelecomcode(), String.valueOf(this.F), this.E0.getSeriesprogramcode());
                this.R0 = a3;
                this.D0.putString("playuri4dlna", a3);
            } else {
                String a4 = com.zte.iptvclient.android.mobile.h.a.b.a(this.J.e(), this.J.j(), this.J.l(), this.J.f(), this.J.k(), this.J.o());
                this.R0 = a4;
                this.D0.putString("playuri4dlna", a4);
            }
            o0();
        }
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.b0.a aVar) {
        com.zte.iptvclient.android.mobile.e0.e.k kVar;
        LogEx.d(j2, "DefinitionChangeEvent event");
        this.e2 = aVar.b();
        this.f2 = String.valueOf(aVar.a());
        com.zte.iptvclient.android.common.player.k.c cVar = this.S;
        if (cVar == null) {
            LogEx.d(j2, "initPlayer");
            f0();
        } else {
            cVar.l(true);
        }
        for (int i = 0; i < this.g2.size(); i++) {
            if (this.g2.get(i).f().equals(this.e2)) {
                this.V = this.g2.get(i).i();
                this.W = this.g2.get(i).f();
                if (!TextUtils.isEmpty(this.g2.get(i).a())) {
                    int intValue = Integer.valueOf(this.g2.get(i).a()).intValue();
                    this.U = intValue;
                    if (intValue != 0 && (kVar = this.K0) != null) {
                        kVar.M();
                    }
                }
            }
        }
        T();
        a(this.V, 2);
    }

    @Override // com.zte.iptvclient.android.common.player.k.b.w
    public void g() {
        this.F++;
        LogEx.d(j2, "mCurEpisodeNm = " + this.F);
        if (this.F > this.Q) {
            LogEx.d(j2, "the last episode");
            com.zte.iptvclient.android.common.player.k.c cVar = this.S;
            if (cVar != null) {
                cVar.d3();
                this.S.p1();
                return;
            }
            return;
        }
        m0();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.u uVar) {
        if (isHidden()) {
            return;
        }
        x0();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        if (cVar.a().equals("0")) {
            s(this.C0);
            x0();
            if (this.P0) {
                this.Q0 = false;
                O();
            }
            com.zte.iptvclient.android.mobile.e0.e.k kVar = this.K0;
            if (kVar != null) {
                kVar.L();
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.t.a aVar) {
        LogEx.d(j2, "recharge state is " + aVar.a());
        if (aVar.a()) {
            P();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public int e() {
        int[] iArr = new int[2];
        this.w.getLocationInWindow(iArr);
        return iArr[1];
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.j jVar) {
        com.zte.iptvclient.android.mobile.e0.e.k kVar = this.K0;
        if (kVar != null) {
            kVar.b(jVar.a());
        }
    }

    public void e(int i) {
        if (this.w0.contains(Integer.valueOf(i)) || this.v) {
            return;
        }
        g(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, String str2) {
        DefinitionBean definitionBean = new DefinitionBean();
        this.h1 = definitionBean;
        definitionBean.a(str);
        this.h1.b(str2);
        this.g1.add(this.h1);
    }

    public void b(boolean z) {
        this.J0 = z;
    }

    public void b(int i, int i2) {
        this.A = false;
        String valueOf = String.valueOf((this.L * i) + i2 + 1);
        int indexOf = this.N.contains(valueOf) ? this.N.indexOf(valueOf) : -1;
        if (!k0() && this.u0 && this.E0 != null && indexOf >= 0 && this.t0.size() > indexOf) {
            this.E = i;
            this.F = (i * this.L) + i2 + 1;
            LogEx.d(j2, "mCurNavPosition = " + this.E);
            LogEx.d(j2, "mCurEpisodeNm = " + this.F);
            h(indexOf);
            h0();
            return;
        }
        LogEx.e(j2, "onEpsiodePlayByIndex getException !");
    }

    public String b(com.zte.iptvclient.android.mobile.ivi.c.a aVar, String str, String str2) {
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_Key_Android");
        if (TextUtils.isEmpty(propertiesInfo)) {
            propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_Light_Server_Key");
        }
        String propertiesInfo2 = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_K1_Android");
        if (TextUtils.isEmpty(propertiesInfo2)) {
            propertiesInfo2 = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_Light_Server_K1");
        }
        String propertiesInfo3 = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_K2_Android");
        if (TextUtils.isEmpty(propertiesInfo3)) {
            propertiesInfo3 = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_Light_Server_K2");
        }
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(this.i1);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty(Constants.SINA_WEIBO_UID, aVar.a());
        jsonObject2.addProperty("app_version", this.d2);
        jsonObject2.addProperty("session", str);
        jsonObject2.addProperty("watchid", this.j1);
        jsonArray.add(jsonObject2);
        jsonObject.add(NativeProtocol.WEB_DIALOG_PARAMS, jsonArray);
        jsonObject.addProperty("method", "da.content.watched");
        this.k1 = jsonObject.toString();
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("data", str2 + this.k1);
        jsonObject3.addProperty("k", propertiesInfo);
        jsonObject3.addProperty("k1", propertiesInfo2);
        jsonObject3.addProperty("k2", propertiesInfo3);
        return jsonObject3.toString();
    }

    protected void a(JSONObject jSONObject) {
        CommonVideoBean a2;
        this.v0.clear();
        try {
            LogEx.d("bindDataToView", jSONObject.toString());
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            for (int i = 0; i < jSONArray.length() && this.v0.size() != 6; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String optString = jSONObject2.optString("programcode");
                if ((TextUtils.isEmpty(optString) || !optString.equals(this.z0)) && (a2 = CommonVideoBean.a(jSONObject2)) != null) {
                    this.v0.add(a2);
                    if (i < 3) {
                        this.D.set(i, a2.d());
                    }
                }
            }
            if (this.K0 != null) {
                this.K0.a(this.v0, 2);
            }
        } catch (Exception e2) {
            LogEx.d("UseeTv", e2.getMessage());
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public void a(int i) {
        Window window = this.h.getWindow();
        if (window != null) {
            window.addFlags(512);
            this.h.setRequestedOrientation(i);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.flags |= Util.BYTE_OF_KB;
                window.setAttributes(attributes);
            }
        }
        this.x.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.s.setVisibility(4);
        if (this.M0) {
            this.L0.setVisibility(8);
            this.p.setVisibility(8);
        }
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.b0.b());
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public void a(boolean z) {
        SupportActivity supportActivity = this.h;
        if (supportActivity == null) {
            return;
        }
        if (this.Z0) {
            supportActivity.setRequestedOrientation(0);
        } else {
            supportActivity.setRequestedOrientation(1);
        }
        Window window = this.h.getWindow();
        if (window != null) {
            window.clearFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.flags &= -1025;
                window.setAttributes(attributes);
            }
        }
        y0();
        this.x.setLayoutParams(new LinearLayout.LayoutParams(this.z, this.y));
        if (this.M0) {
            this.L0.setVisibility(0);
            this.p.setVisibility(0);
        }
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.b0.d());
    }

    public ArrayList<String> a(int i, ArrayList<String> arrayList, int i2) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int i3 = this.L;
        int i4 = i2 % i3;
        int i5 = i3 * i;
        if (arrayList.size() > 0) {
            if (i == arrayList.size() - 1) {
                if (i4 == 0) {
                    int i6 = i5;
                    while (i6 < this.L + i5) {
                        StringBuilder sb = new StringBuilder();
                        i6++;
                        sb.append(i6);
                        sb.append("");
                        arrayList2.add(sb.toString());
                    }
                } else {
                    int i7 = i5;
                    while (i7 < i5 + i4) {
                        StringBuilder sb2 = new StringBuilder();
                        i7++;
                        sb2.append(i7);
                        sb2.append("");
                        arrayList2.add(sb2.toString());
                    }
                }
            } else if (arrayList.size() == 1) {
                while (i < i2) {
                    StringBuilder sb3 = new StringBuilder();
                    i++;
                    sb3.append(i);
                    sb3.append("");
                    arrayList2.add(sb3.toString());
                }
            } else {
                int i8 = i5;
                while (i8 < this.L + i5) {
                    StringBuilder sb4 = new StringBuilder();
                    i8++;
                    sb4.append(i8);
                    sb4.append("");
                    arrayList2.add(sb4.toString());
                }
            }
        } else {
            LogEx.w(j2, "There is no episode");
        }
        LogEx.d(j2, "gridShowList=" + arrayList2.toString());
        return arrayList2;
    }

    private boolean a(SeriesHeadBean seriesHeadBean) {
        if (com.zte.iptvclient.android.common.j.d.d().c()) {
            this.c1 = true;
        } else {
            this.c1 = false;
        }
        LogEx.d(j2, "videoCpCode is " + seriesHeadBean.getCpcode());
        return this.c1;
    }

    @Override // com.zte.iptvclient.android.mobile.e0.e.k.d0
    public void a(int i, int i2) {
        this.A = false;
        K();
        int i3 = i2 + 1;
        String valueOf = String.valueOf(i3);
        int indexOf = this.N.contains(valueOf) ? this.N.indexOf(valueOf) : -1;
        if (!k0() && this.u0 && this.E0 != null && indexOf >= 0) {
            this.E = i;
            this.F = i3;
            LogEx.d(j2, "mCurNavPosition = " + this.E);
            LogEx.d(j2, "mCurEpisodeNm = " + this.F);
            h(indexOf);
            this.S.d3();
            return;
        }
        LogEx.e(j2, "onEpsiodePlayByIndex getException !");
    }

    @Override // com.zte.iptvclient.android.mobile.e0.e.k.e0
    public void a() {
        if (this.p != null) {
            this.L0.setVisibility(0);
            this.p.setVisibility(0);
            this.M0 = true;
        }
        com.zte.iptvclient.android.common.player.k.c cVar = this.S;
        if (cVar != null) {
            cVar.X1();
        }
        this.s.setVisibility(4);
    }

    @Override // com.zte.iptvclient.android.common.player.k.c.o0
    public void a(com.zte.iptvclient.android.common.e.b bVar) {
        this.h.finish();
    }

    public String a(com.zte.iptvclient.android.mobile.ivi.c.a aVar, String str, String str2) {
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_Key_Android");
        if (TextUtils.isEmpty(propertiesInfo)) {
            propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_Light_Server_Key");
        }
        String propertiesInfo2 = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_K1_Android");
        if (TextUtils.isEmpty(propertiesInfo2)) {
            propertiesInfo2 = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_Light_Server_K1");
        }
        String propertiesInfo3 = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_K2_Android");
        if (TextUtils.isEmpty(propertiesInfo3)) {
            propertiesInfo3 = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_Light_Server_K2");
        }
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(this.i1);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty(Constants.SINA_WEIBO_UID, aVar.a());
        jsonObject2.addProperty("app_version", this.d2);
        jsonObject2.addProperty("session", str);
        jsonArray.add(jsonObject2);
        jsonObject.add(NativeProtocol.WEB_DIALOG_PARAMS, jsonArray);
        jsonObject.addProperty("method", "da.content.get");
        this.k1 = jsonObject.toString();
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("data", str2 + this.k1);
        jsonObject3.addProperty("k", propertiesInfo);
        jsonObject3.addProperty("k1", propertiesInfo2);
        jsonObject3.addProperty("k2", propertiesInfo3);
        return jsonObject3.toString();
    }
}
