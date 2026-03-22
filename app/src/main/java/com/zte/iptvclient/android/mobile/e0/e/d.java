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
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.vod.SDKVodMgr;
import com.video.androidsdk.sns.Constants;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.a.a.d.c;
import com.zte.iptvclient.android.common.customview.a.a.e.b;
import com.zte.iptvclient.android.common.f.b.a;
import com.zte.iptvclient.android.common.f.b.b;
import com.zte.iptvclient.android.common.f.b.k;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import com.zte.iptvclient.android.common.javabean.models.MovieDetailBundleBean;
import com.zte.iptvclient.android.common.javabean.models.MultiDefinitionURLBean;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.common.player.d;
import com.zte.iptvclient.android.common.player.k.a;
import com.zte.iptvclient.android.common.player.k.b;
import com.zte.iptvclient.android.common.player.k.c;
import com.zte.iptvclient.android.mobile.e0.e.a;
import com.zte.iptvclient.android.mobile.e0.e.f;
import com.zte.iptvclient.android.mobile.ivi.DefinitionBean;
import com.zte.iptvclient.android.mobile.ivi.a;
import com.zte.iptvclient.android.mobile.login.activity.LoginActivity;
import com.zte.iptvclient.android.mobile.vod.entity.GetUserStarRatingEntity;
import com.zte.iptvclient.android.mobile.vod.entity.GetVodDetailWithUrlEntity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.video.ContentType;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DetailMovieFragment.java */
/* loaded from: classes.dex */
public class d extends com.zte.fragmentlib.b implements a.i, c.o0, b.x, b.a0, a.h, c.e, f.x, c.n0, b.v {
    private int A;
    private int B;
    private ImageView C;
    protected com.zte.iptvclient.android.common.player.k.c E;
    private FragmentManager F;
    private com.zte.iptvclient.android.common.customview.a.a.d.c G;
    private String J;
    private String K;
    private ImageView L;
    private com.zte.iptvclient.android.common.f.b.a P;
    public TextView Q;
    private List<com.zte.iptvclient.android.common.player.j.g> U;
    private VideoDetailBean V;
    private VideoDetailBean W;
    private com.zte.iptvclient.android.mobile.e0.e.f Y;
    private View b0;
    private FrameLayout c0;
    private String d0;
    private VideoDetailBean f0;
    private boolean i0;
    private Timer j0;
    private z k0;
    private SDKVodMgr l0;
    private WebView n0;
    private RelativeLayout p;
    private ImageView q;
    private ArrayList<DefinitionBean> q0;
    private TextView r;
    private DefinitionBean r0;
    private TextView s;
    private ArrayList<DefinitionBean> s0;
    protected String t;
    private DefinitionBean t0;
    protected String u;
    protected String v;
    protected String w;
    private RelativeLayout x;
    private String x0;
    private RelativeLayout y;
    private String y0;
    private RelativeLayout z;
    private com.zte.iptvclient.android.common.player.f D = null;
    protected ArrayList<String> M = new ArrayList<>();
    public boolean N = false;
    public boolean O = false;
    private ArrayList<VideoDetailBean> R = new ArrayList<>();
    private ArrayList<VideoDetailBean> S = new ArrayList<>();
    private ArrayList<VideoDetailBean> T = new ArrayList<>();
    private String X = "";
    private boolean Z = false;
    private boolean a0 = false;
    private boolean e0 = false;
    private boolean g0 = false;
    private int h0 = 1;
    private boolean m0 = true;
    private boolean o0 = false;
    private String p0 = "";
    private String u0 = "";
    private String v0 = "";
    private String w0 = "";
    private String z0 = "";
    private String A0 = "";
    private String B0 = "";
    private String C0 = "";
    private String D0 = "";
    private String E0 = "";
    private String F0 = "";
    private String G0 = "";
    private String H0 = "";
    private String I0 = "";
    private String J0 = "";
    private String K0 = "";
    private String L0 = "";
    private String M0 = "";
    private String N0 = "";
    private String O0 = "";
    private String P0 = "";
    private String Q0 = "";
    private String R0 = "";
    private String S0 = "";
    private String T0 = "";
    private String U0 = "";
    private String V0 = "";
    private String W0 = "";
    private String X0 = "";
    private String Y0 = "";
    private String Z0 = "";
    private String a1 = "";
    private String b1 = "";
    private String c1 = "";
    private String d1 = "";
    private String e1 = "";
    private String f1 = "";
    private String g1 = "";
    private String h1 = "";
    private String i1 = "";
    private String j1 = "";
    private String k1 = "";
    private String l1 = "";
    private String m1 = "";
    private String n1 = "";
    private String o1 = "";
    private String p1 = "";
    private String q1 = "";
    private String r1 = "";
    private boolean s1 = false;
    private y t1 = new y(this);
    View.OnClickListener u1 = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    public class a implements SDKVodMgr.OnVodDetailWithUrlReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodDetailWithUrlReturnListener
        public void onVodDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d("DetailMovieFragment", "onVodDetailWithUrlReturn " + str3);
            Message obtain = Message.obtain();
            obtain.what = 45060;
            if (TextUtils.equals(str, "0")) {
                try {
                    if (str3.contains("},]}")) {
                        str3 = str3.replace("},]}", "}]}");
                    }
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    GetVodDetailWithUrlEntity getVodDetailWithUrlEntity = new GetVodDetailWithUrlEntity();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        VideoDetailBean videoDetailBeanFromJSon = VideoDetailBean.getVideoDetailBeanFromJSon(jSONArray.getJSONObject(i));
                        if (videoDetailBeanFromJSon != null) {
                            getVodDetailWithUrlEntity.downLoadURL.put(videoDetailBeanFromJSon.getDefinition(), videoDetailBeanFromJSon.getPlayurl());
                            getVodDetailWithUrlEntity.videoDetailList.add(videoDetailBeanFromJSon);
                        }
                    }
                    obtain.obj = getVodDetailWithUrlEntity;
                } catch (Exception e) {
                    LogEx.e("DetailMovieFragment", e.getMessage());
                }
            }
            d.this.t1.sendMessage(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    public class b implements b.c {

        /* compiled from: DetailMovieFragment.java */
        /* loaded from: classes2.dex */
        class a implements com.zte.iptvclient.android.mobile.order.helper.c {
            a() {
            }

            @Override // com.zte.iptvclient.android.mobile.order.helper.c
            public void a(int i, String str) {
                LogEx.d("DetailMovieFragment", "AuthManager payCallback returnCode=" + i + ",returnMsg=" + str);
                d.this.d(i);
            }
        }

        b() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.b.c
        public void a(MultiDefinitionURLBean multiDefinitionURLBean) {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.b.c
        public void a(VideoDetailBean videoDetailBean) {
            if (d.this.s1) {
                d.this.K();
                d.this.g0 = false;
            }
            d.this.V = videoDetailBean;
            if (!d.this.V.getAuth_returncode().equals("0")) {
                VideoDetailBean videoDetailBean2 = d.this.V;
                com.zte.iptvclient.android.common.javabean.b bVar = new com.zte.iptvclient.android.common.javabean.b();
                bVar.a(videoDetailBean2.getColumncode());
                bVar.e(videoDetailBean2.getProgramname());
                bVar.d(videoDetailBean2.getProgramcode());
                bVar.g(videoDetailBean2.getTelecomcode());
                bVar.b(videoDetailBean2.getProgramtype());
                bVar.c(videoDetailBean2.getDefinition());
                bVar.f(d.this.w);
                d.this.P = new com.zte.iptvclient.android.common.f.b.a(((com.zte.fragmentlib.b) d.this).h, bVar, new a(), null);
                d.this.P.a(d.this.C);
                d.this.P.a();
                return;
            }
            LogEx.d("DetailMovieFragment", "startPlay mingvewPlay startPlay()");
            d.this.g0 = false;
            d.this.R();
        }
    }

    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    class c implements a.g {
        c() {
        }

        @Override // com.zte.iptvclient.android.mobile.ivi.a.g
        public void a(String str) {
            if ("0".equals(str)) {
                d.this.c(true);
            }
        }
    }

    /* compiled from: DetailMovieFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.e0.e.d$d, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0227d implements b.c {
        C0227d() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.b.c
        public void a(MultiDefinitionURLBean multiDefinitionURLBean) {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.b.c
        public void a(VideoDetailBean videoDetailBean) {
            d.this.W = videoDetailBean;
            if (d.this.W == null) {
                return;
            }
            LogEx.d("DetailMovieFragment", "videoCpCode is " + d.this.W.getCpcode());
            d.this.j0();
        }
    }

    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_login /* 2131296460 */:
                    d.this.h0();
                    return;
                case R.id.img_close /* 2131296935 */:
                case R.id.tv_img_close /* 2131298248 */:
                    d.this.G();
                    d.this.Z = false;
                    if (d.this.p != null) {
                        d.this.Q.setVisibility(8);
                        d.this.p.setVisibility(8);
                        d.this.e0();
                    }
                    com.zte.iptvclient.android.common.player.k.c cVar = d.this.E;
                    if (cVar != null) {
                        cVar.H1();
                        return;
                    }
                    return;
                case R.id.imgvew_play /* 2131297057 */:
                    if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                        d dVar = d.this;
                        com.zte.iptvclient.android.common.player.k.c cVar2 = dVar.E;
                        if (cVar2 == null) {
                            dVar.X();
                        } else {
                            cVar2.l(true);
                        }
                        if (d.this.C != null) {
                            d.this.C.setVisibility(8);
                        }
                        if (d.this.z != null) {
                            d.this.z.setVisibility(8);
                        }
                        d dVar2 = d.this;
                        if (dVar2.E != null) {
                            dVar2.e0 = true;
                            LogEx.d("DetailMovieFragment", "###showLoginToPlayView()");
                            d.this.E.N2();
                            return;
                        }
                    }
                    d.this.Y();
                    return;
                case R.id.video_back /* 2131298584 */:
                    d.this.D();
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    class f implements a.h {
        f() {
        }

        @Override // com.zte.iptvclient.android.mobile.e0.e.a.h
        public void a() {
            d.this.c0.removeAllViews();
            d.this.c0.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    public class g implements d.e {
        g() {
        }

        @Override // com.zte.iptvclient.android.common.player.d.e
        public void a(String str, String str2, List<com.zte.iptvclient.android.common.player.j.g> list) {
            LogEx.d("DetailMovieFragment", "trailer url is  " + str2);
            d.this.U = list;
            ((VideoDetailBean) d.this.T.get(0)).setTrailerurl(str2);
            d.this.Y.s(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    public class h implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f5859a;

        h(boolean z) {
            this.f5859a = z;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("DetailMovieFragment", "api12 onDataReturn s = " + str);
            try {
                d.this.x0 = new JSONObject(str).getString("result");
                if (this.f5859a) {
                    d.this.W();
                } else {
                    d.this.T();
                }
            } catch (JSONException e) {
                e.printStackTrace();
                com.zte.iptvclient.android.common.player.k.c cVar = d.this.E;
                if (cVar != null) {
                    cVar.Q2();
                }
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("DetailMovieFragment", "api12 onFailReturn s = " + str + "  i=" + i);
            com.zte.iptvclient.android.common.player.k.c cVar = d.this.E;
            if (cVar != null) {
                cVar.Q2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    public class i extends WebChromeClient {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5861a;

        /* compiled from: DetailMovieFragment.java */
        /* loaded from: classes2.dex */
        class a implements ValueCallback<String> {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: DetailMovieFragment.java */
            /* renamed from: com.zte.iptvclient.android.mobile.e0.e.d$i$a$a, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C0228a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
                C0228a() {
                }

                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Failed to find 'out' block for switch in B:18:0x02e2. Please report as an issue. */
                /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0099. Please report as an issue. */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:19:0x02e5  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x02ed  */
                /* JADX WARN: Removed duplicated region for block: B:31:0x0c7b  */
                /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:35:0x031b A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:36:0x0346 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:37:0x0373 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:38:0x039f A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:39:0x03cb A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:40:0x03f7 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:41:0x0423 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:42:0x0451 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:43:0x047f A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:44:0x04ad A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:45:0x04db A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:46:0x0509 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:47:0x0537 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:48:0x0565 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:49:0x0593 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:50:0x05bf A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:51:0x05ed A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:52:0x061b A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:53:0x0647 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:54:0x0673 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:55:0x069f A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:58:0x06cb A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:59:0x06f9 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:60:0x0726 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:61:0x0753 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:62:0x0782 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:64:0x07ae A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:66:0x07de A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:68:0x080c A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:70:0x083a A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:72:0x0868 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:74:0x0896 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:76:0x08c4 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:78:0x08f2 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:80:0x0920 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:82:0x094e A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:84:0x097c A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:86:0x09aa A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:88:0x09d8 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:90:0x0a06 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:92:0x0a34 A[Catch: JSONException -> 0x0a9f, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Removed duplicated region for block: B:94:0x0a61 A[Catch: JSONException -> 0x0a9f, TRY_LEAVE, TryCatch #4 {JSONException -> 0x0a9f, blocks: (B:24:0x02ef, B:35:0x031b, B:36:0x0346, B:37:0x0373, B:38:0x039f, B:39:0x03cb, B:40:0x03f7, B:41:0x0423, B:42:0x0451, B:43:0x047f, B:44:0x04ad, B:45:0x04db, B:46:0x0509, B:47:0x0537, B:48:0x0565, B:49:0x0593, B:50:0x05bf, B:51:0x05ed, B:52:0x061b, B:53:0x0647, B:54:0x0673, B:55:0x069f, B:58:0x06cb, B:59:0x06f9, B:60:0x0726, B:61:0x0753, B:62:0x0782, B:64:0x07ae, B:66:0x07de, B:68:0x080c, B:70:0x083a, B:72:0x0868, B:74:0x0896, B:76:0x08c4, B:78:0x08f2, B:80:0x0920, B:82:0x094e, B:84:0x097c, B:86:0x09aa, B:88:0x09d8, B:90:0x0a06, B:92:0x0a34, B:94:0x0a61, B:245:0x0ad1, B:248:0x0ae6, B:251:0x0b01), top: B:23:0x02ef }] */
                /* JADX WARN: Type inference failed for: r3v100 */
                /* JADX WARN: Type inference failed for: r3v101 */
                /* JADX WARN: Type inference failed for: r3v102 */
                /* JADX WARN: Type inference failed for: r3v103 */
                /* JADX WARN: Type inference failed for: r3v104 */
                /* JADX WARN: Type inference failed for: r3v105 */
                /* JADX WARN: Type inference failed for: r3v106 */
                /* JADX WARN: Type inference failed for: r3v107 */
                /* JADX WARN: Type inference failed for: r3v108 */
                /* JADX WARN: Type inference failed for: r3v109 */
                /* JADX WARN: Type inference failed for: r3v110 */
                /* JADX WARN: Type inference failed for: r3v111 */
                /* JADX WARN: Type inference failed for: r3v112 */
                /* JADX WARN: Type inference failed for: r3v113 */
                /* JADX WARN: Type inference failed for: r3v114 */
                /* JADX WARN: Type inference failed for: r3v115 */
                /* JADX WARN: Type inference failed for: r3v120 */
                /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.String] */
                /* JADX WARN: Type inference failed for: r3v174 */
                /* JADX WARN: Type inference failed for: r3v175, types: [int] */
                /* JADX WARN: Type inference failed for: r3v176 */
                /* JADX WARN: Type inference failed for: r3v206 */
                /* JADX WARN: Type inference failed for: r3v207 */
                /* JADX WARN: Type inference failed for: r3v208 */
                /* JADX WARN: Type inference failed for: r3v209 */
                /* JADX WARN: Type inference failed for: r3v210 */
                /* JADX WARN: Type inference failed for: r3v99 */
                @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onDataReturn(java.lang.String r26) {
                    /*
                        Method dump skipped, instructions count: 3464
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.e0.e.d.i.a.C0228a.onDataReturn(java.lang.String):void");
                }

                @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
                public void onFailReturn(int i, String str) {
                    LogEx.d("DetailMovieFragment", "API_13_3 onFailReturn s = " + str);
                    com.zte.iptvclient.android.common.player.k.c cVar = d.this.E;
                    if (cVar != null) {
                        cVar.Q2();
                    }
                }
            }

            a() {
            }

            @Override // android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
                String str2 = d.this.q1 + "/light/?app_version=" + d.this.r1 + "&ts=" + d.this.x0 + "&sign=" + str.replaceAll("\"", "");
                SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
                sDKNetHTTPRequest.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                sDKNetHTTPRequest.setBody(d.this.y0);
                sDKNetHTTPRequest.startRequest(str2, HttpRequest.METHOD_POST, new C0228a());
            }
        }

        i(String str) {
            this.f5861a = str;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i >= 100) {
                d.this.n0.evaluateJavascript("jsMethod(" + this.f5861a + ")", new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    public class j extends WebChromeClient {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5865a;

        /* compiled from: DetailMovieFragment.java */
        /* loaded from: classes2.dex */
        class a implements ValueCallback<String> {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: DetailMovieFragment.java */
            /* renamed from: com.zte.iptvclient.android.mobile.e0.e.d$j$a$a, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C0229a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
                C0229a() {
                }

                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Failed to find 'out' block for switch in B:17:0x02f8. Please report as an issue. */
                /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0096. Please report as an issue. */
                /* JADX WARN: Removed duplicated region for block: B:18:0x02fb  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x0303  */
                /* JADX WARN: Removed duplicated region for block: B:29:0x0aee  */
                /* JADX WARN: Removed duplicated region for block: B:34:0x0331 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:35:0x035c A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:36:0x0389 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:37:0x03b5 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:38:0x03e1 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:39:0x040d A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:40:0x0439 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:41:0x0467 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:42:0x0495 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:43:0x04c3 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:44:0x04f1 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:45:0x051f A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:46:0x054d A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:47:0x057b A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:48:0x05a9 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:49:0x05d5 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:50:0x0603 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:51:0x0631 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:52:0x065d A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:53:0x0689 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:54:0x06b5 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:57:0x06e1 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:58:0x070f A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:59:0x073c A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:60:0x0769 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:61:0x0798 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:63:0x07c4 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:65:0x07f2 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:67:0x0820 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:69:0x084e A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:71:0x087c A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:73:0x08aa A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:75:0x08d8 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:77:0x0906 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:79:0x0934 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:81:0x0962 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:83:0x0990 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:85:0x09be A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:87:0x09ec A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:89:0x0a1a A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:91:0x0a47 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                /* JADX WARN: Removed duplicated region for block: B:93:0x0a76 A[Catch: JSONException -> 0x0adf, TryCatch #2 {JSONException -> 0x0adf, blocks: (B:20:0x0ab3, B:23:0x0305, B:34:0x0331, B:35:0x035c, B:36:0x0389, B:37:0x03b5, B:38:0x03e1, B:39:0x040d, B:40:0x0439, B:41:0x0467, B:42:0x0495, B:43:0x04c3, B:44:0x04f1, B:45:0x051f, B:46:0x054d, B:47:0x057b, B:48:0x05a9, B:49:0x05d5, B:50:0x0603, B:51:0x0631, B:52:0x065d, B:53:0x0689, B:54:0x06b5, B:57:0x06e1, B:58:0x070f, B:59:0x073c, B:60:0x0769, B:61:0x0798, B:63:0x07c4, B:65:0x07f2, B:67:0x0820, B:69:0x084e, B:71:0x087c, B:73:0x08aa, B:75:0x08d8, B:77:0x0906, B:79:0x0934, B:81:0x0962, B:83:0x0990, B:85:0x09be, B:87:0x09ec, B:89:0x0a1a, B:91:0x0a47, B:93:0x0a76, B:238:0x0ab8, B:240:0x0ac9, B:242:0x0ad3), top: B:22:0x0305 }] */
                @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onDataReturn(java.lang.String r27) {
                    /*
                        Method dump skipped, instructions count: 3078
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.e0.e.d.j.a.C0229a.onDataReturn(java.lang.String):void");
                }

                @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
                public void onFailReturn(int i, String str) {
                    LogEx.d("DetailMovieFragment", "API_13-2 onFailReturn s = " + str);
                    com.zte.iptvclient.android.common.player.k.c cVar = d.this.E;
                    if (cVar != null) {
                        cVar.Q2();
                    }
                }
            }

            a() {
            }

            @Override // android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
                String str2 = d.this.q1 + "/light/?app_version=" + d.this.r1 + "&ts=" + d.this.x0 + "&sign=" + str.replaceAll("\"", "");
                SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
                sDKNetHTTPRequest.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                sDKNetHTTPRequest.setBody(d.this.y0);
                sDKNetHTTPRequest.startRequest(str2, HttpRequest.METHOD_POST, new C0229a());
            }
        }

        j(String str) {
            this.f5865a = str;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i >= 100) {
                d.this.n0.evaluateJavascript("jsMethod(" + this.f5865a + ")", new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    public class k implements ViewTreeObserver.OnGlobalLayoutListener {
        k() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            d.this.y.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            int i = BaseApp.j;
            if (i != 0) {
                d.this.A = i;
                d.this.B = BaseApp.k;
            } else {
                d dVar = d.this;
                dVar.B = dVar.y.getWidth();
                d dVar2 = d.this;
                dVar2.A = dVar2.y.getHeight();
                LogEx.d("DetailMovieFragment", "miPlayerDefaultWidth" + d.this.B + " mPlayerDefaultHeight " + d.this.A);
                BaseApp.j = d.this.A;
                BaseApp.k = d.this.B;
            }
            int i2 = d.this.B;
            double d2 = d.this.B;
            double d3 = BaseApp.f() ? 8.0d : 9.0d;
            Double.isNaN(d2);
            d.this.y.setLayoutParams(new LinearLayout.LayoutParams(i2, (int) ((d2 * d3) / 16.0d)));
            LogEx.d("DetailMovieFragment", "miPlayerDefaultWidth" + d.this.B + " mPlayerDefaultHeight " + ((d.this.B * 9) / 16));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    public class l extends WebChromeClient {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5870a;

        /* compiled from: DetailMovieFragment.java */
        /* loaded from: classes2.dex */
        class a implements ValueCallback<String> {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: DetailMovieFragment.java */
            /* renamed from: com.zte.iptvclient.android.mobile.e0.e.d$l$a$a, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C0230a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
                C0230a(a aVar) {
                }

                @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
                public void onDataReturn(String str) {
                    LogEx.d("DetailMovieFragment", "API_14 onDataReturn s = " + str);
                }

                @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
                public void onFailReturn(int i, String str) {
                    LogEx.d("DetailMovieFragment", "API_14 onFailReturn s = " + str);
                }
            }

            a() {
            }

            @Override // android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
                String str2 = d.this.q1 + "/light/?app_version=" + d.this.r1 + "&ts=" + d.this.x0 + "&sign=" + str.replaceAll("\"", "");
                SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
                sDKNetHTTPRequest.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                sDKNetHTTPRequest.setBody(d.this.y0);
                sDKNetHTTPRequest.startRequest(str2, HttpRequest.METHOD_POST, new C0230a(this));
            }
        }

        l(String str) {
            this.f5870a = str;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i >= 100) {
                d.this.n0.evaluateJavascript("jsMethod(" + this.f5870a + ")", new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    public class m implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        m(d dVar) {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("DetailMovieFragment", "API_14_2 onDataReturn s = " + str);
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("DetailMovieFragment", "API_14_2 onFailReturn s = " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    public class n implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        n() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("sdk_getareaauth", str);
            try {
                if (new JSONObject(str).getString("returncode").equals("0")) {
                    d.this.m0 = true;
                } else {
                    d.this.m0 = false;
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
    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    public class o implements b.c {

        /* compiled from: DetailMovieFragment.java */
        /* loaded from: classes2.dex */
        class a implements com.zte.iptvclient.android.mobile.order.helper.c {
            a() {
            }

            @Override // com.zte.iptvclient.android.mobile.order.helper.c
            public void a(int i, String str) {
                LogEx.d("DetailMovieFragment", "AuthManager payCallback returnCode=" + i + ",returnMsg=" + str);
                d.this.d(i);
            }
        }

        o() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.b.c
        public void a(MultiDefinitionURLBean multiDefinitionURLBean) {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.b.c
        public void a(VideoDetailBean videoDetailBean) {
            if (d.this.s1) {
                d.this.K();
                d.this.g0 = false;
            }
            d.this.V = videoDetailBean;
            if (!d.this.V.getAuth_returncode().equals("0")) {
                VideoDetailBean videoDetailBean2 = d.this.V;
                com.zte.iptvclient.android.common.javabean.b bVar = new com.zte.iptvclient.android.common.javabean.b();
                bVar.a(videoDetailBean2.getColumncode());
                bVar.e(videoDetailBean2.getProgramname());
                bVar.d(videoDetailBean2.getProgramcode());
                bVar.g(videoDetailBean2.getTelecomcode());
                bVar.b(videoDetailBean2.getProgramtype());
                bVar.c(videoDetailBean2.getDefinition());
                bVar.f(d.this.w);
                d.this.P = new com.zte.iptvclient.android.common.f.b.a(((com.zte.fragmentlib.b) d.this).h, bVar, new a(), null);
                d.this.P.a(d.this.C);
                d.this.P.a();
                return;
            }
            LogEx.d("DetailMovieFragment", "startPlay mingvewPlay startPlay()");
            d.this.g0 = false;
            d.this.R();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    public class p implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        p() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("DetailMovieFragment", "SdkGetUserStarRatingThread return: " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!"0".equals(jSONObject.getString("returncode"))) {
                    d.this.t1.sendEmptyMessage(45062);
                } else {
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    if (jSONArray.length() <= 0) {
                        d.this.t1.sendEmptyMessage(45062);
                    } else {
                        GetUserStarRatingEntity a2 = GetUserStarRatingEntity.a(jSONArray.getJSONObject(0));
                        Message obtain = Message.obtain();
                        obtain.what = 45061;
                        obtain.obj = a2;
                        d.this.t1.sendMessage(obtain);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
                d.this.t1.sendEmptyMessage(45062);
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("DetailMovieFragment", "SdkGetUserStarRatingThread failed: " + str);
            d.this.t1.sendEmptyMessage(45062);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    public class q implements SDKVodMgr.OnVodListReturnListener {
        q() {
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodListReturnListener
        public void onVodListReturn(String str, String str2, String str3) {
            LogEx.d("DetailMovieFragment", "getVodList data : " + str3);
            if (TextUtils.equals(str, "0")) {
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        CommonVideoBean a2 = CommonVideoBean.a(jSONArray.getJSONObject(i));
                        if (a2 != null && (d.this.R.size() <= 0 || !TextUtils.equals(((VideoDetailBean) d.this.R.get(0)).getProgramcode(), a2.d()))) {
                            arrayList.add(a2);
                            if (arrayList.size() >= 6) {
                                break;
                            }
                        }
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 45057;
                    obtain.obj = arrayList;
                    d.this.t1.sendMessage(obtain);
                } catch (Exception e) {
                    LogEx.e("DetailMovieFragment", e.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    public class r implements k.c {
        r() {
        }

        @Override // com.zte.iptvclient.android.common.f.b.k.c
        public void a(ArrayList<CommonVideoBean> arrayList) {
            if (arrayList != null) {
                d.this.Y.a(2, arrayList);
                if (arrayList.size() > 0) {
                    d.this.M.set(2, arrayList.get(0).d());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    public class s implements SDKVodMgr.OnVodDetailWithUrlReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f5879a;

        s(long j) {
            this.f5879a = j;
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodDetailWithUrlReturnListener
        public void onVodDetailWithUrlReturn(String str, String str2, String str3) {
            if (!str.equals("0")) {
                d.this.E.Q2();
                return;
            }
            LogEx.d("DetailMovieFragment", " getVodDetailWithUrl 耗时: " + (SystemClock.currentThreadTimeMillis() - this.f5879a));
            LogEx.d("DetailMovieFragment", "Test the starting speed :  query vod VodDetailWithUrl back");
            LogEx.d("DetailMovieFragment", "getVodDetailWithUrl returncode : " + str + ", errormsg : " + str2 + ",data : " + str3);
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            com.zte.iptvclient.android.common.k.h.a().a(new x(d.this, str, str3));
            StringBuilder sb = new StringBuilder();
            sb.append(" onVodDetailWithUrlReturn 耗时: ");
            sb.append(SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis);
            LogEx.d("DetailMovieFragment", sb.toString());
            d.this.C.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    public class t implements a.g {
        t() {
        }

        @Override // com.zte.iptvclient.android.mobile.ivi.a.g
        public void a(String str) {
            if ("0".equals(str)) {
                d.this.c(false);
                return;
            }
            com.zte.iptvclient.android.common.player.k.c cVar = d.this.E;
            if (cVar != null) {
                cVar.Q2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    public class u implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.player.j.l f5882a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bundle f5883b;

        /* compiled from: DetailMovieFragment.java */
        /* loaded from: classes2.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f5885a;

            a(String str) {
                this.f5885a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.E.d3();
                d.this.E.a2();
                d.this.E.K(this.f5885a);
                d.this.E.E();
                d.this.E.D2();
            }
        }

        /* compiled from: DetailMovieFragment.java */
        /* loaded from: classes2.dex */
        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f5887a;

            b(String str) {
                this.f5887a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.E.d3();
                d.this.E.I(this.f5887a);
                d.this.E.E();
                d.this.E.D2();
            }
        }

        /* compiled from: DetailMovieFragment.java */
        /* loaded from: classes2.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LogEx.d("DetailMovieFragment", "Test the starting speed : queryVodBlackout back continue Play");
                d.this.E.d3();
                com.zte.iptvclient.android.common.f.b.b.j().h();
                d.this.E.Z1();
                com.zte.iptvclient.android.common.player.f fVar = d.this.D;
                u uVar = u.this;
                fVar.a(uVar.f5882a, uVar.f5883b, ((com.zte.fragmentlib.b) d.this).h, d.this.F, d.this.E);
            }
        }

        /* compiled from: DetailMovieFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.e0.e.d$u$d, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0231d implements Runnable {
            RunnableC0231d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.E.d3();
                d.this.E.H2();
                d.this.E.a2();
                d.this.E.E();
                d.this.E.D2();
            }
        }

        u(com.zte.iptvclient.android.common.player.j.l lVar, Bundle bundle) {
            this.f5882a = lVar;
            this.f5883b = bundle;
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void j() {
            LogEx.d("DetailMovieFragment", "vod blackout无策略，正常播放");
            ((com.zte.fragmentlib.b) d.this).h.runOnUiThread(new c());
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void k(String str) {
            LogEx.d("DetailMovieFragment", "vod blackout查询展示black照片:" + str);
            ((com.zte.fragmentlib.b) d.this).h.runOnUiThread(new a(str));
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void l() {
            LogEx.d("DetailMovieFragment", "get Detail BlackoutInfo is null （pic url or play url is null）");
            ((com.zte.fragmentlib.b) d.this).h.runOnUiThread(new RunnableC0231d());
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void r(String str) {
            LogEx.d("DetailMovieFragment", "vod blackout查询播放black片源" + str);
            ((com.zte.fragmentlib.b) d.this).h.runOnUiThread(new b(str));
        }
    }

    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    class v implements com.zte.iptvclient.android.mobile.order.helper.c {
        v() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.helper.c
        public void a(int i, String str) {
            LogEx.d("DetailMovieFragment", "AuthManager payCallback returnCode=" + i + ",returnMsg=" + str);
            d.this.d(i);
        }
    }

    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    class w implements com.zte.iptvclient.android.mobile.order.helper.c {
        w() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.helper.c
        public void a(int i, String str) {
            LogEx.d("DetailMovieFragment", "AuthManager payCallback returnCode=" + i + ",returnMsg=" + str);
            d.this.d(i);
        }
    }

    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    private static final class x implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<d> f5893a;

        /* renamed from: b, reason: collision with root package name */
        private String f5894b;

        /* renamed from: c, reason: collision with root package name */
        private String f5895c;

        public x(d dVar, String str, String str2) {
            this.f5893a = new WeakReference<>(dVar);
            this.f5894b = str;
            this.f5895c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            d dVar = this.f5893a.get();
            if (dVar == null) {
                return;
            }
            if ("18503004".equals(this.f5894b)) {
                dVar.t1.sendEmptyMessage(45063);
                return;
            }
            if (TextUtils.equals(this.f5894b, "0")) {
                try {
                    if (this.f5895c.contains("},]}")) {
                        this.f5895c = this.f5895c.replace("},]}", "}]}");
                    }
                    JSONArray jSONArray = new JSONObject(this.f5895c).getJSONArray("data");
                    GetVodDetailWithUrlEntity getVodDetailWithUrlEntity = new GetVodDetailWithUrlEntity();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        VideoDetailBean videoDetailBeanFromJSon = VideoDetailBean.getVideoDetailBeanFromJSon(jSONObject);
                        if (videoDetailBeanFromJSon != null) {
                            getVodDetailWithUrlEntity.downLoadURL.put(videoDetailBeanFromJSon.getDefinition(), videoDetailBeanFromJSon.getPlayurl());
                            videoDetailBeanFromJSon.setProductVIP("0");
                            LogEx.d("DetailMovieFragment", "Definition =" + videoDetailBeanFromJSon.getDefinition() + " : playURl=" + videoDetailBeanFromJSon.getPlayurl());
                            if (jSONObject.has("productlist")) {
                                JSONArray jSONArray2 = jSONObject.getJSONArray("productlist");
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= jSONArray2.length()) {
                                        break;
                                    }
                                    String optString = jSONArray2.getJSONObject(i2).optString("productname");
                                    if (optString != null && optString.contains("VIP")) {
                                        videoDetailBeanFromJSon.setProductVIP("1");
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            getVodDetailWithUrlEntity.videoDetailList.add(videoDetailBeanFromJSon);
                        }
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 45058;
                    obtain.obj = getVodDetailWithUrlEntity;
                    dVar.t1.sendMessage(obtain);
                } catch (Exception e) {
                    LogEx.e("DetailMovieFragment", e.getMessage());
                }
            }
            LogEx.d("DetailMovieFragment", " DealVodDetailResultRunnable.run 耗时: " + (SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
        }
    }

    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    private static final class y extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<d> f5896a;

        public y(d dVar) {
            this.f5896a = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            d dVar = this.f5896a.get();
            if (dVar == null) {
                return;
            }
            int i = 0;
            VideoDetailBean videoDetailBean = null;
            switch (message.what) {
                case 45057:
                    ArrayList<CommonVideoBean> arrayList = (ArrayList) message.obj;
                    if (dVar.Y != null) {
                        dVar.Y.a(2, arrayList);
                        return;
                    }
                    return;
                case 45058:
                    dVar.R.addAll(((GetVodDetailWithUrlEntity) message.obj).videoDetailList);
                    dVar.S.clear();
                    dVar.T.clear();
                    if (dVar.R.size() > 0) {
                        while (i < dVar.R.size()) {
                            if (((VideoDetailBean) dVar.R.get(i)).getVideotype().equals("28")) {
                                dVar.S.add(dVar.R.get(i));
                            } else if (((VideoDetailBean) dVar.R.get(i)).getVideotype().equals("20")) {
                                dVar.T.add(dVar.R.get(i));
                            }
                            videoDetailBean = (VideoDetailBean) dVar.R.get(i);
                            i++;
                        }
                        if (dVar.i0) {
                            if (dVar.Y != null) {
                                dVar.Y.b(videoDetailBean);
                            }
                            Fragment parentFragment = dVar.getParentFragment();
                            if ((parentFragment instanceof com.zte.iptvclient.android.mobile.e0.e.e) && videoDetailBean != null) {
                                ((com.zte.iptvclient.android.mobile.e0.e.e) parentFragment).a(videoDetailBean);
                            }
                            dVar.a(videoDetailBean);
                        } else if (videoDetailBean != null) {
                            dVar.e(videoDetailBean);
                            dVar.a(videoDetailBean);
                        }
                        if (videoDetailBean == null) {
                            return;
                        }
                        if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
                            LogEx.d("DetailMovieFragment", "update blackout info");
                            com.zte.iptvclient.android.common.k.e.b(videoDetailBean.getContentcode(), videoDetailBean.getColumncode());
                        }
                        dVar.O();
                        if (TextUtils.equals(videoDetailBean.getCpcode(), "Megogo")) {
                            dVar.f0();
                            return;
                        } else {
                            dVar.Y.s(videoDetailBean.getTrailerurl());
                            return;
                        }
                    }
                    return;
                case 45059:
                    if (dVar.R.size() < 1) {
                        return;
                    }
                    if (dVar.R.size() > 0) {
                        dVar.a((VideoDetailBean) dVar.R.get(0));
                    }
                    ((VideoDetailBean) dVar.R.get(0)).setAuth_returncode((String) message.obj);
                    return;
                case 45060:
                    dVar.R.clear();
                    GetVodDetailWithUrlEntity getVodDetailWithUrlEntity = (GetVodDetailWithUrlEntity) message.obj;
                    if (getVodDetailWithUrlEntity != null) {
                        dVar.R.addAll(getVodDetailWithUrlEntity.videoDetailList);
                        dVar.S.clear();
                        if (dVar.R.size() > 0) {
                            while (i < dVar.R.size()) {
                                if (((VideoDetailBean) dVar.R.get(i)).getVideotype().equals("28")) {
                                    dVar.S.add(dVar.R.get(i));
                                }
                                i++;
                            }
                        }
                    }
                    dVar.b0();
                    return;
                case 45061:
                    GetUserStarRatingEntity getUserStarRatingEntity = (GetUserStarRatingEntity) message.obj;
                    dVar.b(getUserStarRatingEntity.f7631a, getUserStarRatingEntity.f7632b, getUserStarRatingEntity.f7634d, getUserStarRatingEntity.f7633c);
                    return;
                case 45062:
                    dVar.b(null, null, null, null);
                    return;
                case 45063:
                    if (dVar.h0 < 3) {
                        dVar.d0();
                        return;
                    } else {
                        dVar.h0 = 1;
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* compiled from: DetailMovieFragment.java */
    /* loaded from: classes2.dex */
    private class z extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<d> f5897a;

        /* renamed from: b, reason: collision with root package name */
        private String f5898b;

        /* renamed from: c, reason: collision with root package name */
        private String f5899c;

        /* renamed from: d, reason: collision with root package name */
        private String f5900d;

        /* compiled from: DetailMovieFragment.java */
        /* loaded from: classes2.dex */
        class a implements SDKVodMgr.OnVodDetailWithUrlReturnListener {
            a() {
            }

            @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodDetailWithUrlReturnListener
            public void onVodDetailWithUrlReturn(String str, String str2, String str3) {
                LogEx.d("DetailMovieFragment", "---5min一次请求更新auth_returncode---" + str);
                if (TextUtils.equals(str, "0")) {
                    try {
                        if (str3.contains("},]}")) {
                            str3 = str3.replace("},]}", "}]}");
                        }
                        JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                        if (jSONArray.length() > 0) {
                            String optString = jSONArray.getJSONObject(0).optString(ParamConst.VOD_MULTIPLE_URL_RSP_AUTH_RETURNCODE);
                            Message obtain = Message.obtain();
                            obtain.what = 45059;
                            obtain.obj = optString;
                            d.this.t1.sendMessage(obtain);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public z(d dVar, String str, String str2, String str3) {
            this.f5897a = new WeakReference<>(dVar);
            this.f5898b = str;
            this.f5899c = str2;
            this.f5900d = str3;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (this.f5897a.get() != null) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("programcode", this.f5898b);
                hashMap.put("recommendtype", this.f5899c);
                hashMap.put("isquerybookmark", this.f5900d);
                new SDKVodMgr().getVodDetailWithUrl(hashMap, new a());
            }
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        LogEx.d("DetailMovieFragment", "mIsFromFloatWindow " + this.a0);
        if (this.E == null) {
            X();
        }
        this.v = com.zte.iptvclient.android.common.k.o.j().f();
        LogEx.d("DetailMovieFragment", "推荐服务器: " + this.v);
        this.M.add("");
        this.M.add("");
        this.M.add("");
        d0();
        s(this.u);
        this.j0 = new Timer();
        z zVar = new z(this, this.t, this.w, "1");
        this.k0 = zVar;
        this.j0.schedule(zVar, 300000L, 300000L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        LogEx.i("DetailMovieFragment", "onActivityResult requestCode" + i2 + " data=" + intent.getAction());
        if (i2 != 20) {
            return;
        }
        LogEx.i("DetailMovieFragment", "skip to loginFragment");
        h0();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        LogEx.d("DetailMovieFragment", "detailmovie onConfigurationChanged");
        super.onConfigurationChanged(configuration);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogEx.d("DetailMovieFragment", " onCreate  ");
        try {
            ((InputMethodManager) this.h.getSystemService("input_method")).hideSoftInputFromWindow(this.h.getWindow().getDecorView().getWindowToken(), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        EventBus.getDefault().register(this);
        this.F = getChildFragmentManager();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.u = arguments.getString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE);
            this.t = arguments.getString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE);
            this.w = arguments.getString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_RECOMMENDTYPE, "0");
            this.N = arguments.getBoolean("isOnLine");
            this.O = arguments.getBoolean("isSubscribe");
            this.a0 = arguments.getBoolean("isFromFloatWindow", false);
        }
        com.zte.iptvclient.android.mobile.e0.e.f fVar = new com.zte.iptvclient.android.mobile.e0.e.f();
        this.Y = fVar;
        fVar.a(this);
        this.Y.a((f.x) this);
        b(R.id.video_detail_main_ifo_page, this.Y);
        this.q1 = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_Server_URL1");
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_App_Version_Android");
        this.r1 = propertiesInfo;
        if (TextUtils.isEmpty(propertiesInfo)) {
            this.r1 = SDKLoginMgr.getInstance().getPropertiesInfo("Ivi_App_Version");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b0 = layoutInflater.inflate(R.layout.video_detail_mainlayout, viewGroup, false);
        this.i0 = BaseApp.a(this.h);
        d(this.b0);
        if (!this.i0) {
            com.gyf.barlibrary.e c2 = com.gyf.barlibrary.e.c(getActivity());
            c2.a(false);
            c2.f();
            this.b0.findViewById(R.id.ll_detail_movie).setBackgroundResource(com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a() ? R.drawable.bg_child : R.drawable.bg_phone);
        }
        return this.b0;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.Z) {
            this.Q.setVisibility(8);
        }
        com.gyf.barlibrary.e c2 = com.gyf.barlibrary.e.c(getActivity());
        c2.a(true);
        c2.f();
        super.onDestroy();
        z zVar = this.k0;
        if (zVar != null) {
            zVar.cancel();
            this.k0 = null;
        }
        Timer timer = this.j0;
        if (timer != null) {
            timer.cancel();
            this.j0 = null;
        }
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.s.b());
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.i.a());
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.j.b bVar) {
        LogEx.d("DetailMovieFragment", "UnLockMovieDetailEvent event");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LogEx.d("DetailMovieFragment", "onResume");
        if (this.Z || !(y() instanceof com.zte.iptvclient.android.mobile.a0.b.b)) {
            return;
        }
        LogEx.d("DetailMovieFragment", "onResume mIsFullScreenState is False and LiveTVFragment is include");
        G();
    }

    private VideoDetailBean V() {
        if (this.R.size() > 0) {
            Iterator<VideoDetailBean> it2 = this.R.iterator();
            while (it2.hasNext()) {
                VideoDetailBean next = it2.next();
                if (TextUtils.equals(next.getVideotype(), "20")) {
                    LogEx.d("DetailMovieFragment", "This is the entity of  a trailer.");
                    return next;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        ArrayList<com.zte.iptvclient.android.mobile.ivi.c.a> a2 = com.zte.iptvclient.android.common.j.d.d().a();
        this.q0 = new ArrayList<>();
        if (a2.size() == 0) {
            return;
        }
        String b2 = b(a2.get(0), com.zte.iptvclient.android.common.j.d.d().b(), this.x0);
        this.n0.loadUrl("file:///android_asset/iviordersign.html");
        this.n0.setWebChromeClient(new i(b2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        LogEx.d("DetailMovieFragment", "initPlayer");
        this.D = new com.zte.iptvclient.android.common.player.f();
        com.zte.iptvclient.android.common.player.k.c cVar = new com.zte.iptvclient.android.common.player.k.c();
        this.E = cVar;
        cVar.a((c.n0) this);
        this.E.a((a.i) this);
        this.E.a((c.o0) this);
        this.E.a((b.a0) this);
        this.E.a((b.x) this);
        this.E.a((b.v) this);
        this.E.setTargetFragment(this, 20);
        if (this.a0) {
            c0();
            this.E.setArguments(getArguments());
        }
        if (this.x != null && getActivity() != null) {
            androidx.fragment.app.r b2 = this.F.b();
            b2.a(R.id.video_detail_miniplaye_container, this.E, "PlayerFragment");
            b2.b();
        } else {
            LogEx.e("DetailMovieFragment", "mLlayoutPlayContainer is null or context is null!");
            D();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        this.s1 = false;
        LogEx.d("DetailMovieFragment", "guest use to login for LoginReturnEvent success for re startPlay");
        if (!this.m0) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.h.getResources().getString(R.string.area_limits));
            return;
        }
        if (!this.S.get(0).getCpcode().equals("ivi") && !this.S.get(0).getCpcode().equals("Megogo")) {
            com.zte.iptvclient.android.common.customview.a.a.e.b bVar = new com.zte.iptvclient.android.common.customview.a.a.e.b(this.h, R.style.dialog_order, this.S, null);
            bVar.a(new o());
            bVar.show();
        } else {
            this.g0 = false;
            R();
        }
    }

    private void Z() {
        com.zte.iptvclient.android.common.player.k.c cVar;
        com.zte.iptvclient.android.common.player.k.c cVar2;
        String playurl;
        String auth_returncode;
        Iterator<VideoDetailBean> it2;
        if (this.R.size() <= 0) {
            return;
        }
        com.zte.iptvclient.android.mobile.download.helper.a.n().a((Boolean) true);
        Bundle bundle = new Bundle();
        VideoDetailBean videoDetailBean = null;
        if (!this.R.get(0).getCpcode().equals("ivi") && !this.R.get(0).getCpcode().equals("Megogo")) {
            videoDetailBean = this.V;
        } else {
            for (int i2 = 0; i2 < this.R.size(); i2++) {
                if (this.R.get(i2).getVideotype().equals("28")) {
                    videoDetailBean = this.R.get(i2);
                }
            }
        }
        if (videoDetailBean == null) {
            return;
        }
        if (!"Megogo".equalsIgnoreCase(videoDetailBean.getCpcode())) {
            if (this.R.size() == 1 && com.zte.iptvclient.android.common.player.f.c(this.R.get(0).getDefinition())) {
                LogEx.d("DetailMovieFragment", "Definition =" + this.R.get(0).getDefinition());
                com.zte.iptvclient.android.common.player.k.c cVar3 = this.E;
                if (cVar3 != null) {
                    cVar3.j(0);
                    return;
                }
            }
            if ("ivi".equalsIgnoreCase(videoDetailBean.getCpcode())) {
                bundle.putParcelableArrayList("ividefinitionList", this.q0);
            }
            ArrayList arrayList = new ArrayList();
            Iterator<VideoDetailBean> it3 = this.R.iterator();
            while (it3.hasNext()) {
                VideoDetailBean next = it3.next();
                LogEx.d("DetailMovieFragment", "Definition =" + next.getDefinition());
                arrayList.add(next);
                if ("ivi".equalsIgnoreCase(videoDetailBean.getCpcode())) {
                    playurl = this.p0;
                    auth_returncode = next.getAuth_returncode();
                } else {
                    playurl = next.getPlayurl();
                    auth_returncode = next.getAuth_returncode();
                }
                if (TextUtils.equals(next.getDefinition(), "1")) {
                    bundle.putString("url_sd", TextUtils.isEmpty(playurl) ? "" : playurl);
                    bundle.putString("physicalcontentid_url_sd", next.getPhysicalcontentid());
                    if (TextUtils.isEmpty(auth_returncode)) {
                        auth_returncode = "";
                    }
                    bundle.putString("auth_sd", auth_returncode);
                    it2 = it3;
                } else {
                    it2 = it3;
                    if (TextUtils.equals(next.getDefinition(), "2")) {
                        bundle.putString("url_sd_h", TextUtils.isEmpty(playurl) ? "" : playurl);
                        bundle.putString("physicalcontentid_url_sd_h", next.getPhysicalcontentid());
                        if (TextUtils.isEmpty(auth_returncode)) {
                            auth_returncode = "";
                        }
                        bundle.putString("auth_sd_h", auth_returncode);
                    } else if (TextUtils.equals(next.getDefinition(), "4")) {
                        bundle.putString("url_hd", TextUtils.isEmpty(playurl) ? "" : playurl);
                        bundle.putString("physicalcontentid_url_hd", next.getPhysicalcontentid());
                        if (TextUtils.isEmpty(auth_returncode)) {
                            auth_returncode = "";
                        }
                        bundle.putString("auth_hd", auth_returncode);
                    } else if (TextUtils.equals(next.getDefinition(), "8")) {
                        bundle.putString("url_480p", TextUtils.isEmpty(playurl) ? "" : playurl);
                        bundle.putString("physicalcontentid_url_480p", next.getPhysicalcontentid());
                        if (TextUtils.isEmpty(auth_returncode)) {
                            auth_returncode = "";
                        }
                        bundle.putString("auth_480p", auth_returncode);
                    } else if (TextUtils.equals(next.getDefinition(), GlobalConst.WINPHONE_CLIENT)) {
                        bundle.putString("url_720p", TextUtils.isEmpty(playurl) ? "" : playurl);
                        bundle.putString("physicalcontentid_url_720p", next.getPhysicalcontentid());
                        if (TextUtils.isEmpty(auth_returncode)) {
                            auth_returncode = "";
                        }
                        bundle.putString("auth_720p", auth_returncode);
                    } else if (TextUtils.equals(next.getDefinition(), GlobalConst.ANDRIODSTB_CLIENT)) {
                        bundle.putString("url_1280p", TextUtils.isEmpty(playurl) ? "" : playurl);
                        bundle.putString("physicalcontentid_url_1280p", next.getPhysicalcontentid());
                        if (TextUtils.isEmpty(auth_returncode)) {
                            auth_returncode = "";
                        }
                        bundle.putString("auth_1280p", auth_returncode);
                    } else {
                        bundle.putString("url_sd", "");
                    }
                }
                bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, playurl);
                LogEx.d("DetailMovieFragment", "playURL=" + videoDetailBean.getPlayurl());
                if ("ivi".equalsIgnoreCase(videoDetailBean.getCpcode())) {
                    bundle.putString("definition", "MP4-hi");
                } else {
                    bundle.putString("definition", videoDetailBean.getDefinition());
                }
                if (com.zte.iptvclient.android.common.player.f.c(videoDetailBean.getDefinition())) {
                    LogEx.d("DetailMovieFragment", "Definition =" + videoDetailBean.getDefinition());
                    com.zte.iptvclient.android.common.player.k.c cVar4 = this.E;
                    if (cVar4 != null) {
                        cVar4.j(0);
                        return;
                    }
                }
                it3 = it2;
            }
            if (arrayList.size() == 0 && this.R.size() > arrayList.size() && (cVar2 = this.E) != null) {
                cVar2.j(0);
                return;
            }
        }
        if (!this.D.a(videoDetailBean.getAllownettype()) && (cVar = this.E) != null) {
            cVar.j(1);
            return;
        }
        com.zte.iptvclient.android.common.player.k.c cVar5 = this.E;
        if (cVar5 == null || cVar5.p0() >= 0) {
            if (!TextUtils.isEmpty(this.J)) {
                bundle.putString("url_nav", this.J);
            } else if (!TextUtils.isEmpty(this.K)) {
                bundle.putString("url_hc", this.K);
            }
            bundle.putString("genrelock", videoDetailBean.getGenrelock());
            bundle.putString("taskID", videoDetailBean.getProgramcode());
            bundle.putString("productVIP", videoDetailBean.getProductVIP());
            bundle.putString("cmsid", videoDetailBean.getCmsid());
            bundle.putString("physicalcontentid", videoDetailBean.getPhysicalcontentid());
            int intValue = TextUtils.isEmpty(videoDetailBean.getAuth_returncode()) ? -1 : Integer.valueOf(videoDetailBean.getAuth_returncode()).intValue();
            LogEx.d("UseeTv", "auth code is：" + intValue);
            bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, intValue);
            bundle.putString("isprotection", videoDetailBean.getIsprotection());
            bundle.putString("programname", videoDetailBean.getProgramname());
            bundle.putString("contentcode", videoDetailBean.getContentcode());
            if (!"Megogo".equalsIgnoreCase(videoDetailBean.getCpcode())) {
                bundle.putString(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTELECOMCODE, videoDetailBean.getTelecomcode());
            } else {
                bundle.putString(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTELECOMCODE, videoDetailBean.getVideotelecomcode());
            }
            bundle.putString("cpcode", videoDetailBean.getCpcode());
            bundle.putString(ParamConst.VOD_DETAIL_QUERY_RSP_ENCRYPTTYPE, videoDetailBean.getEncrypttype());
            bundle.putString("price", videoDetailBean.getPrice());
            bundle.putString("ratingid", videoDetailBean.getRatingid());
            bundle.putString("programcode", videoDetailBean.getProgramcode());
            if (!TextUtils.isEmpty(videoDetailBean.getPosterfilelist())) {
                String a2 = com.zte.iptvclient.android.common.k.g.a(this.i0 ? 9 : 3, videoDetailBean.getPosterfilelist());
                bundle.putString("posterUrl", a2);
                LogEx.d("DetailMovieFragment", "POSTERURL=" + a2);
            }
            bundle.putString("posterfilelist", videoDetailBean.getPosterfilelist());
            bundle.putString("columncode", videoDetailBean.getColumncode());
            bundle.putString("Id", videoDetailBean.getProgramcode());
            if (!TextUtils.isEmpty(videoDetailBean.getVrflag())) {
                bundle.putBoolean("IsVRVideo", !videoDetailBean.getVrflag().equals("0"));
            }
            bundle.putString("systemlimitenable", videoDetailBean.getSystemlimitenable());
            String advertisecontent = videoDetailBean.getAdvertisecontent();
            LogEx.d("DetailMovieFragment", "advertisecontent " + advertisecontent);
            if (!TextUtils.isEmpty(advertisecontent) && Integer.parseInt(advertisecontent) > 0 && TextUtils.equals("1", ConfigMgr.readPropertie("isSupportQueryAds"))) {
                this.D.a(true);
            } else {
                this.D.a(false);
            }
            if (this.g0) {
                this.D.b("0");
                LogEx.d("DetailMovieFragment", "PALYBOOKMARK repLay forcuse 0");
            } else if (!TextUtils.isEmpty(this.X)) {
                this.D.b(this.X);
                LogEx.d("DetailMovieFragment", "PALYBOOKMARK " + this.X);
            } else {
                this.D.b(videoDetailBean.getBreakpoint());
                LogEx.d("DetailMovieFragment", "PALYBOOKMARK " + videoDetailBean.getBreakpoint());
            }
            String b2 = com.zte.iptvclient.android.mobile.h.a.b.b(videoDetailBean.getColumncode(), videoDetailBean.getProgramcode(), videoDetailBean.getProgramtype(), videoDetailBean.getContentcode(), videoDetailBean.getProgramname(), videoDetailBean.getTelecomcode());
            this.d0 = b2;
            bundle.putString("playuri4dlna", b2);
            bundle.putString("telecomcode", videoDetailBean.getTelecomcode());
            bundle.putString("directorprogramcode", this.M.get(0));
            bundle.putString("actorprogramcode", this.M.get(1));
            bundle.putString("recomendprogramcode", this.M.get(2));
            if (!TextUtils.isEmpty(videoDetailBean.getPosterfilelist())) {
                bundle.putString("shareImage", com.zte.iptvclient.android.common.k.g.a(this.i0 ? 9 : 3, videoDetailBean.getPosterfilelist()));
            }
            com.zte.iptvclient.android.common.player.j.l lVar = new com.zte.iptvclient.android.common.player.j.l();
            lVar.a(videoDetailBean.getColumncode());
            lVar.b(videoDetailBean.getContentcode());
            bundle.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_NORMAL_VOD.getIntValue()));
            if (this.a0) {
                return;
            }
            if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
                LogEx.d("DetailMovieFragment", "Test the starting speed : start queryVodBlackout");
                com.zte.iptvclient.android.common.f.b.b.j().a(videoDetailBean.getContentcode(), videoDetailBean.getColumncode(), new u(lVar, bundle));
                return;
            }
            com.zte.iptvclient.android.common.player.k.c cVar6 = this.E;
            if (cVar6 != null) {
                cVar6.Z1();
                this.D.a(lVar, bundle, this.h, this.F, this.E);
            }
        }
    }

    private void a0() {
        ArrayList<com.zte.iptvclient.android.mobile.ivi.c.a> a2 = com.zte.iptvclient.android.common.j.d.d().a();
        if (a2.size() == 0) {
            return;
        }
        String b2 = com.zte.iptvclient.android.common.j.d.d().b();
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        sDKNetHTTPRequest.setBody("seconds=2&fromstart=2&app_version=" + this.r1 + "&history_type=watch&uid=" + a2.get(0).a() + "&iviuid=" + a2.get(0).a() + "&contentid=" + this.v0 + "&watchid=" + this.u0 + "&session=" + b2);
        sDKNetHTTPRequest.startRequest("http://l.ivi.ru/logger/content/time/", HttpRequest.METHOD_POST, new m(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        if (this.R.size() <= 0) {
            d(-1);
            return;
        }
        com.zte.iptvclient.android.common.customview.a.a.e.b bVar = new com.zte.iptvclient.android.common.customview.a.a.e.b(this.h, R.style.dialog_order, this.S, null);
        bVar.a(new b());
        bVar.show();
    }

    private void c0() {
        this.E.a((a.i) this);
        this.E.a((c.o0) this);
        this.E.a((b.a0) this);
        this.E.setTargetFragment(this, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        this.R.clear();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("programcode", this.t);
        hashMap.put("recommendtype", this.w);
        hashMap.put("isquerybookmark", "1");
        hashMap.put("isquerytrailer", "1");
        SDKVodMgr sDKVodMgr = this.l0;
        if (sDKVodMgr != null) {
            sDKVodMgr.cancelRequest();
            this.l0 = null;
        }
        this.l0 = new SDKVodMgr();
        LogEx.d("DetailMovieFragment", "Test the starting speed : satrt query vod VodDetailWithUrl ");
        this.l0.getVodDetailWithUrl(hashMap, new s(SystemClock.currentThreadTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        if (this.i0) {
            this.L.setVisibility(4);
        } else {
            this.L.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        VideoDetailBean V = V();
        if (V != null) {
            new com.zte.iptvclient.android.common.player.d(this.h).a(V.getPrice(), V.getVideotelecomcode(), new g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        if (this.R.isEmpty()) {
            com.zte.iptvclient.android.common.player.k.c cVar = this.E;
            if (cVar != null) {
                cVar.Q2();
                return;
            }
            return;
        }
        Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        this.h.startActivity(new Intent(this.h, (Class<?>) LoginActivity.class));
    }

    private void i0() {
        ArrayList<com.zte.iptvclient.android.mobile.ivi.c.a> a2 = com.zte.iptvclient.android.common.j.d.d().a();
        if (a2.size() == 0) {
            return;
        }
        String c2 = c(a2.get(0), com.zte.iptvclient.android.common.j.d.d().b(), this.x0);
        this.n0.loadUrl("file:///android_asset/iviordersign.html");
        this.n0.setWebChromeClient(new l(c2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        String str;
        if (this.W.getTrailerurl().contains("%20")) {
            try {
                str = URLDecoder.decode(this.W.getTrailerurl(), "UTF-8");
            } catch (Exception e2) {
                LogEx.d("DetailMovieFragment", "strTrailerUrl getException=" + e2.toString());
                str = "";
            }
        } else {
            str = this.W.getTrailerurl();
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.E == null) {
                X();
            }
            RelativeLayout relativeLayout = this.z;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            com.zte.iptvclient.android.mobile.e0.e.f fVar = this.Y;
            if (fVar != null) {
                fVar.b(false);
            }
            this.E.w2();
            com.zte.iptvclient.android.mobile.download.helper.a.n().a((Boolean) true);
            Bundle bundle = new Bundle();
            if (this.S.get(0).getCpcode().equals("Megogo")) {
                ArrayList<DefinitionBean> arrayList = new ArrayList<>();
                this.s0 = arrayList;
                arrayList.clear();
                for (int i2 = 0; i2 < this.U.size(); i2++) {
                    this.t0 = new DefinitionBean();
                    if (TextUtils.equals(this.U.get(i2).a(), "240")) {
                        this.t0.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_low));
                    } else if (TextUtils.equals(this.U.get(i2).a(), "320")) {
                        this.t0.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_medium));
                    } else if (TextUtils.equals(this.U.get(i2).a(), "360")) {
                        this.t0.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_common));
                    } else if (TextUtils.equals(this.U.get(i2).a(), "480")) {
                        this.t0.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_good));
                    } else if (TextUtils.equals(this.U.get(i2).a(), "720")) {
                        this.t0.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_high));
                    } else if (TextUtils.equals(this.U.get(i2).a(), "1080")) {
                        this.t0.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_best));
                    } else if (TextUtils.equals(this.U.get(i2).a(), "2160")) {
                        this.t0.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_4k));
                    }
                    this.t0.b(this.U.get(i2).b());
                    this.s0.add(this.t0);
                }
                bundle.putParcelableArrayList("megogodefinitionList", this.s0);
            } else {
                for (int i3 = 0; i3 < this.T.size(); i3++) {
                    VideoDetailBean videoDetailBean = this.T.get(i3);
                    String trailerurl = videoDetailBean.getTrailerurl();
                    if (TextUtils.equals(videoDetailBean.getDefinition(), "1")) {
                        if (TextUtils.isEmpty(trailerurl)) {
                            trailerurl = "";
                        }
                        bundle.putString("url_sd", trailerurl);
                        bundle.putString("physicalcontentid_url_sd", videoDetailBean.getPhysicalcontentid());
                    } else if (TextUtils.equals(videoDetailBean.getDefinition(), "2")) {
                        if (TextUtils.isEmpty(trailerurl)) {
                            trailerurl = "";
                        }
                        bundle.putString("url_sd_h", trailerurl);
                        bundle.putString("physicalcontentid_url_sd_h", videoDetailBean.getPhysicalcontentid());
                    } else if (TextUtils.equals(videoDetailBean.getDefinition(), "4")) {
                        if (TextUtils.isEmpty(trailerurl)) {
                            trailerurl = "";
                        }
                        bundle.putString("url_hd", trailerurl);
                        bundle.putString("physicalcontentid_url_hd", videoDetailBean.getPhysicalcontentid());
                    } else if (TextUtils.equals(videoDetailBean.getDefinition(), "8")) {
                        if (TextUtils.isEmpty(trailerurl)) {
                            trailerurl = "";
                        }
                        bundle.putString("url_480p", trailerurl);
                        bundle.putString("physicalcontentid_url_480p", videoDetailBean.getPhysicalcontentid());
                    } else if (TextUtils.equals(videoDetailBean.getDefinition(), GlobalConst.WINPHONE_CLIENT)) {
                        if (TextUtils.isEmpty(trailerurl)) {
                            trailerurl = "";
                        }
                        bundle.putString("url_720p", trailerurl);
                        bundle.putString("physicalcontentid_url_720p", videoDetailBean.getPhysicalcontentid());
                    } else if (TextUtils.equals(videoDetailBean.getDefinition(), GlobalConst.ANDRIODSTB_CLIENT)) {
                        if (TextUtils.isEmpty(trailerurl)) {
                            trailerurl = "";
                        }
                        bundle.putString("url_1280p", trailerurl);
                        bundle.putString("physicalcontentid_url_1280p", videoDetailBean.getPhysicalcontentid());
                    } else {
                        bundle.putString("url_sd", "");
                    }
                }
            }
            bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, str);
            LogEx.d("DetailMovieFragment", "strTrailerUrl = " + str);
            bundle.putString("definition", this.W.getDefinition());
            bundle.putString("ratingid", this.W.getRatingid());
            bundle.putBoolean("isTrailer", true);
            bundle.putString("programname", this.W.getProgramname());
            bundle.putString("cpcode", this.W.getCpcode());
            bundle.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_SENIOR_TRAILER.getIntValue()));
            String a2 = com.zte.iptvclient.android.mobile.h.a.b.a(this.W.getColumncode(), this.W.getProgramcode(), this.W.getProgramtype(), this.W.getTelecomcode());
            this.d0 = a2;
            bundle.putString("playuri4dlna", a2);
            com.zte.iptvclient.android.common.player.j.k kVar = new com.zte.iptvclient.android.common.player.j.k();
            kVar.a(this.W.getColumncode());
            kVar.b(this.W.getContentcode());
            this.D.a(false);
            this.D.a(kVar, bundle, getActivity(), this.F, this.x.getId(), this.E);
            return;
        }
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.no_trailer_available));
    }

    private void k0() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("programcode", this.t);
        hashMap.put("recommendtype", this.w);
        hashMap.put("isquerybookmark", "1");
        new SDKVodMgr().getVodDetailWithUrl(hashMap, new a());
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.b0.a aVar) {
        LogEx.d("DetailMovieFragment", "DefinitionChangeEvent event");
        String b2 = aVar.b();
        this.X = String.valueOf(aVar.a());
        for (int i2 = 0; i2 < this.S.size(); i2++) {
            if (this.S.get(i2).getDefinition().equals(b2)) {
                this.V = this.S.get(i2);
            }
        }
        if (this.V.getAuth_returncode().equals("0")) {
            LogEx.d("DetailMovieFragment", "startPlay mingvewPlay startPlay()");
            this.g0 = false;
            R();
            return;
        }
        if (this.R.size() <= 0) {
            return;
        }
        VideoDetailBean videoDetailBean = this.V;
        com.zte.iptvclient.android.common.javabean.b bVar = new com.zte.iptvclient.android.common.javabean.b();
        bVar.a(videoDetailBean.getColumncode());
        bVar.e(videoDetailBean.getProgramname());
        bVar.d(videoDetailBean.getProgramcode());
        bVar.g(videoDetailBean.getTelecomcode());
        bVar.b(videoDetailBean.getProgramtype());
        bVar.c(videoDetailBean.getDefinition());
        bVar.f(this.w);
        com.zte.iptvclient.android.common.f.b.a aVar2 = new com.zte.iptvclient.android.common.f.b.a(this.h, bVar, new v(), null);
        this.P = aVar2;
        aVar2.a(this.C);
        this.P.a();
    }

    private void S() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        ArrayList<com.zte.iptvclient.android.mobile.ivi.c.a> a2 = com.zte.iptvclient.android.common.j.d.d().a();
        this.q0 = new ArrayList<>();
        if (a2.size() == 0) {
            return;
        }
        String a3 = a(a2.get(0), com.zte.iptvclient.android.common.j.d.d().b(), this.x0);
        this.n0.loadUrl("file:///android_asset/iviordersign.html");
        this.n0.setWebChromeClient(new j(a3));
    }

    private String U() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("method", "da.timestamp.get");
        jsonObject.add(NativeProtocol.WEB_DIALOG_PARAMS, new JsonArray());
        LogEx.d("DetailMovieFragment", "getTimesTampJsonParams : " + jsonObject.toString());
        return jsonObject.toString();
    }

    private void f(VideoDetailBean videoDetailBean) {
        if (TextUtils.equals(videoDetailBean.getIsfavourite(), "1")) {
            Q();
        } else {
            P();
        }
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.f());
        if (this.Z) {
            G();
            this.Z = false;
            if (this.p != null) {
                this.Q.setVisibility(8);
                this.p.setVisibility(8);
            }
            e0();
            com.zte.iptvclient.android.common.player.k.c cVar = this.E;
            if (cVar != null) {
                cVar.H1();
            }
            return true;
        }
        com.zte.iptvclient.android.common.player.k.c cVar2 = this.E;
        if (cVar2 != null && cVar2.v2()) {
            return true;
        }
        S();
        return true;
    }

    public void I() {
        if (this.h != null) {
            this.G = new com.zte.iptvclient.android.common.customview.a.a.d.c(this.h);
            this.G.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.stb_choose_ott_pop));
            this.G.a(this);
        }
    }

    public com.zte.iptvclient.android.common.player.k.c J() {
        return this.E;
    }

    public void K() {
        com.zte.iptvclient.android.common.player.k.c cVar = this.E;
        if (cVar != null) {
            cVar.U1();
            this.E.f2();
        }
    }

    public void L() {
        if (this.R.size() < 1) {
            return;
        }
        Bundle bundle = new Bundle();
        com.zte.iptvclient.android.mobile.e0.e.a aVar = new com.zte.iptvclient.android.mobile.e0.e.a();
        aVar.a(new f());
        bundle.putString("contentCode", this.R.get(0).getContentcode());
        aVar.setArguments(bundle);
        b(R.id.parent_movie, aVar);
        this.c0.setVisibility(0);
    }

    public void M() {
        VideoDetailBean videoDetailBean;
        if (this.E != null) {
            if (TextUtils.isEmpty(this.d0) && (videoDetailBean = this.f0) != null) {
                this.d0 = com.zte.iptvclient.android.mobile.h.a.b.b(videoDetailBean.getColumncode(), this.f0.getProgramcode(), this.f0.getProgramtype(), this.f0.getContentcode(), this.f0.getProgramname(), this.f0.getTelecomcode());
            }
            if (this.f0 != null) {
                RelativeLayout relativeLayout = this.z;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                com.zte.iptvclient.android.common.e.r.g gVar = new com.zte.iptvclient.android.common.e.r.g();
                gVar.d("1");
                gVar.a(this.f0.getContentcode());
                gVar.c(this.d0);
                LogEx.d("DetailMovieFragment", "mStrPushURL " + this.d0);
                this.E.a(gVar);
            }
        }
    }

    public void N() {
        if (!this.m0) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.h.getResources().getString(R.string.area_limits));
            return;
        }
        if ("Megogo".equalsIgnoreCase(this.T.get(0).getCpcode())) {
            VideoDetailBean videoDetailBean = this.T.get(0);
            this.W = videoDetailBean;
            if (videoDetailBean == null) {
                return;
            }
            LogEx.d("DetailMovieFragment", "videoCpCode is " + this.W.getCpcode());
            if (!new com.zte.iptvclient.android.common.j.h(this.h).w()) {
                com.zte.iptvclient.android.common.player.k.c cVar = this.E;
                if (cVar != null) {
                    cVar.Q2();
                    return;
                }
                return;
            }
            LogEx.d("DetailMovieFragment", "videoCpCode is " + this.W.getEncrypttype());
            if (!TextUtils.equals(this.W.getEncrypttype(), "0")) {
                com.zte.iptvclient.android.common.player.k.c cVar2 = this.E;
                if (cVar2 != null) {
                    cVar2.Q2();
                    return;
                }
                return;
            }
            j0();
            return;
        }
        if ("ivi".equalsIgnoreCase(this.T.get(0).getCpcode())) {
            VideoDetailBean videoDetailBean2 = this.T.get(0);
            this.W = videoDetailBean2;
            if (videoDetailBean2 == null) {
                return;
            }
            LogEx.d("DetailMovieFragment", "videoCpCode is " + this.W.getCpcode());
            this.w0 = this.W.getVideotelecomcode();
            if (!b(this.W)) {
                com.zte.iptvclient.android.common.player.k.c cVar3 = this.E;
                if (cVar3 != null) {
                    cVar3.Q2();
                    return;
                }
                return;
            }
            com.zte.iptvclient.android.mobile.ivi.a.a(this.v0, new c());
            return;
        }
        com.zte.iptvclient.android.common.customview.a.a.e.b bVar = new com.zte.iptvclient.android.common.customview.a.a.e.b(this.h, R.style.dialog_order, this.T, null);
        bVar.a(new C0227d());
        bVar.show();
    }

    public void O() {
        String replace = "http://{ipadd:port}/iptvepg/{frame}/sdk_getuserstarrating.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f());
        LogEx.d("DetailMovieFragment", "sdkQueryUserStarRating url: " + replace);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.setCharset("gbk");
        sDKNetHTTPRequest.setParam("columncode", this.u);
        sDKNetHTTPRequest.setParam("programcode", this.t);
        sDKNetHTTPRequest.setParam("mediaservice", "2");
        sDKNetHTTPRequest.setParam("isfilterratingid", "0");
        sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_GET, new p());
    }

    protected void P() {
        com.zte.iptvclient.android.mobile.e0.e.f fVar = this.Y;
        if (fVar != null) {
            fVar.L();
        }
    }

    protected void Q() {
        com.zte.iptvclient.android.mobile.e0.e.f fVar = this.Y;
        if (fVar != null) {
            fVar.M();
        }
    }

    public void R() {
        com.zte.iptvclient.android.common.player.k.c cVar = this.E;
        if (cVar == null) {
            X();
        } else {
            cVar.l(true);
        }
        ImageView imageView = this.C;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.z;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        if (!com.zte.iptvclient.android.mobile.n.c.b.t() && this.E != null) {
            this.e0 = true;
            LogEx.d("DetailMovieFragment", "###showLoginToPlayView()");
            this.E.N2();
            return;
        }
        if (this.R.size() <= 0) {
            LogEx.e("DetailMovieFragment", "video detail bean list is empty");
            com.zte.iptvclient.android.common.player.k.c cVar2 = this.E;
            if (cVar2 != null) {
                cVar2.Q2();
                return;
            }
            return;
        }
        if (this.R.get(0).getCpcode().equals("ivi") || this.R.get(0).getCpcode().equals("Megogo")) {
            for (int i2 = 0; i2 < this.R.size(); i2++) {
                if (this.R.get(i2).getVideotype().equals("28")) {
                    this.V = this.R.get(i2);
                }
            }
        }
        VideoDetailBean videoDetailBean = this.V;
        if (videoDetailBean == null) {
            com.zte.iptvclient.android.common.player.k.c cVar3 = this.E;
            if (cVar3 != null) {
                cVar3.Q2();
                return;
            }
            return;
        }
        if ("Megogo".equalsIgnoreCase(videoDetailBean.getCpcode())) {
            LogEx.d("DetailMovieFragment", "videoCpCode is " + this.V.getCpcode());
            if (!new com.zte.iptvclient.android.common.j.h(this.h).w()) {
                com.zte.iptvclient.android.common.player.k.c cVar4 = this.E;
                if (cVar4 != null) {
                    cVar4.Q2();
                    return;
                }
                return;
            }
            LogEx.d("DetailMovieFragment", "videoCpCode is " + this.V.getEncrypttype());
            if (!TextUtils.equals(this.V.getEncrypttype(), "0")) {
                com.zte.iptvclient.android.common.player.k.c cVar5 = this.E;
                if (cVar5 != null) {
                    cVar5.Q2();
                    return;
                }
                return;
            }
        } else if ("ivi".equalsIgnoreCase(this.V.getCpcode())) {
            com.zte.iptvclient.android.common.player.k.c cVar6 = this.E;
            if (cVar6 != null) {
                cVar6.L(this.V.getCpcode());
            }
            if (!b(this.V)) {
                com.zte.iptvclient.android.common.player.k.c cVar7 = this.E;
                if (cVar7 != null) {
                    cVar7.Q2();
                    return;
                }
                return;
            }
        }
        com.zte.iptvclient.android.common.f.b.g.a(this.V);
        com.zte.iptvclient.android.common.player.k.c cVar8 = this.E;
        if (cVar8 != null) {
            cVar8.U1();
            this.E.f2();
        }
        if ("ivi".equalsIgnoreCase(this.V.getCpcode())) {
            String videotelecomcode = this.V.getVideotelecomcode();
            this.v0 = videotelecomcode;
            com.zte.iptvclient.android.mobile.ivi.a.a(videotelecomcode, new t());
            return;
        }
        g0();
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public int i() {
        return this.A;
    }

    @Override // com.zte.iptvclient.android.common.player.k.b.x
    public void p() {
        this.s1 = true;
        Y();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b.a0
    public void q(String str) {
        if (this.R.size() <= 0) {
            return;
        }
        VideoDetailBean videoDetailBean = this.V;
        com.zte.iptvclient.android.common.javabean.b bVar = new com.zte.iptvclient.android.common.javabean.b();
        bVar.a(videoDetailBean.getColumncode());
        bVar.e(videoDetailBean.getProgramname());
        bVar.d(videoDetailBean.getProgramcode());
        bVar.g(videoDetailBean.getTelecomcode());
        bVar.b(videoDetailBean.getProgramtype());
        bVar.c(videoDetailBean.getDefinition());
        bVar.f(this.w);
        com.zte.iptvclient.android.common.f.b.a aVar = new com.zte.iptvclient.android.common.f.b.a(this.h, bVar, new w(), this);
        this.P = aVar;
        aVar.a(this.C);
        this.P.a();
    }

    public void s(String str) {
        String str2 = "http://{ipadd:port}/iptvepg/{frame}/sdk_getareaauth.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f()) + "?columncode=" + str;
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.setCharset("gbk");
        sDKNetHTTPRequest.startRequest(str2, HttpRequest.METHOD_GET, new n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VideoDetailBean videoDetailBean) {
        if (TextUtils.isEmpty(this.v)) {
            c(videoDetailBean);
        } else {
            d(videoDetailBean);
        }
    }

    private void d(View view) {
        this.c0 = (FrameLayout) view.findViewById(R.id.parent_movie);
        this.Q = (TextView) view.findViewById(R.id.top);
        int a2 = com.zte.iptvclient.android.common.k.v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        this.Q.setHeight(a2);
        this.Q.setVisibility(8);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_multiscreen_head);
        this.p = relativeLayout;
        this.q = (ImageView) relativeLayout.findViewById(R.id.img_close);
        this.r = (TextView) this.p.findViewById(R.id.tv_img_close);
        this.s = (TextView) this.p.findViewById(R.id.txt_head_title);
        this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.multi_back));
        this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.multiscreen_watch));
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        this.p.setVisibility(8);
        this.p.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.tv_multiplayer_headtitle_bg));
        this.h.a(this.p, "background", R.color.tv_multiplayer_headtitle_bg);
        this.s.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_multiplayer_headtitle_textcolor));
        this.h.a(this.s, "textColor", R.color.tv_multiplayer_headtitle_textcolor);
        this.x = (RelativeLayout) view.findViewById(R.id.video_detail_miniplaye_container);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.video_detail_miniplay);
        this.y = relativeLayout2;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout2);
        this.y.getViewTreeObserver().addOnGlobalLayoutListener(new k());
        this.z = (RelativeLayout) view.findViewById(R.id.imgvew_play_bg);
        this.L = (ImageView) view.findViewById(R.id.video_back);
        e0();
        this.L.setLayoutDirection(0);
        ImageView imageView = (ImageView) view.findViewById(R.id.imgvew_play);
        this.C = imageView;
        imageView.setEnabled(false);
        com.zte.iptvclient.common.uiframe.f.a(this.L);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        I();
        this.L.setOnClickListener(this.u1);
        this.C.setOnClickListener(this.u1);
        this.q.setOnClickListener(this.u1);
        this.r.setOnClickListener(this.u1);
        WebView webView = (WebView) view.findViewById(R.id.webview);
        this.n0 = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3, String str4) {
        LogEx.d("DetailMovieFragment", "doScoreAndMark ratingsum: " + str + ", ratingnum: " + str2 + ", imdb: " + str3 + ", kinopoisk: " + str4 + ", mDetailMoveInfoFragment: " + this.Y);
        com.zte.iptvclient.android.mobile.e0.e.f fVar = this.Y;
        if (fVar != null) {
            fVar.b(str, str2, str3, str4);
        }
    }

    private void c(VideoDetailBean videoDetailBean) {
        SDKVodMgr sDKVodMgr = new SDKVodMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("columncode", videoDetailBean.getColumncode());
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", "10");
        hashMap.put("ordertype", "0");
        hashMap.put("seriestype", "1,3");
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            hashMap.put("ratingid", com.zte.iptvclient.android.common.k.p.a(new com.zte.iptvclient.android.common.j.h(getContext()).t()));
            LogEx.d("DetailMovieFragment", " Child Mode getVodSearchList param ratingid");
        }
        sDKVodMgr.getVodList(hashMap, new q());
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public int e() {
        int[] iArr = new int[2];
        this.x.getLocationInWindow(iArr);
        return iArr[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, String str2) {
        DefinitionBean definitionBean = new DefinitionBean();
        this.r0 = definitionBean;
        definitionBean.a(str);
        this.r0.b(str2);
        this.q0.add(this.r0);
    }

    public void b(boolean z2) {
        this.O = z2;
    }

    private boolean b(VideoDetailBean videoDetailBean) {
        if (com.zte.iptvclient.android.common.j.d.d().c()) {
            this.o0 = true;
        } else {
            this.o0 = false;
        }
        LogEx.d("DetailMovieFragment", "videoCpCode is " + videoDetailBean.getCpcode());
        return this.o0 && TextUtils.equals(videoDetailBean.getEncrypttype(), "0");
    }

    public void a(GetUserStarRatingEntity getUserStarRatingEntity) {
        Message obtain = Message.obtain();
        obtain.what = 45061;
        obtain.obj = getUserStarRatingEntity;
        this.t1.sendMessage(obtain);
    }

    protected void a(VideoDetailBean videoDetailBean) {
        if (videoDetailBean != null) {
            this.f0 = videoDetailBean;
            com.zte.iptvclient.android.mobile.e0.e.f fVar = this.Y;
            if (fVar != null) {
                fVar.a(videoDetailBean);
            }
            f(videoDetailBean);
        }
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
        jsonArray.add(this.w0);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("app_version", this.r1);
        jsonObject2.addProperty("session", str);
        jsonArray.add(jsonObject2);
        jsonObject.add(NativeProtocol.WEB_DIALOG_PARAMS, jsonArray);
        jsonObject.addProperty("method", "da.content.get_additional_data");
        this.y0 = jsonObject.toString();
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("data", str2 + this.y0);
        jsonObject3.addProperty("k", propertiesInfo);
        jsonObject3.addProperty("k1", propertiesInfo2);
        jsonObject3.addProperty("k2", propertiesInfo3);
        return jsonObject3.toString();
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public void a(int i2) {
        Window window = this.h.getWindow();
        if (window != null) {
            window.addFlags(512);
            this.h.setRequestedOrientation(i2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.flags |= Util.BYTE_OF_KB;
                window.setAttributes(attributes);
            }
        }
        this.y.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.L.setVisibility(4);
        if (this.Z) {
            this.Q.setVisibility(8);
            this.p.setVisibility(8);
        }
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.b0.b());
    }

    @Override // com.zte.iptvclient.android.common.customview.a.a.d.c.e
    public void c() {
        StringBuilder sb = new StringBuilder();
        sb.append("pushtype=1");
        sb.append("&programid=");
        sb.append("&columnid=");
        String sb2 = sb.toString();
        LogEx.i("DetailMovieFragment", "pushUrl = " + sb2);
        if (TextUtils.isEmpty("") || TextUtils.isEmpty("")) {
            return;
        }
        com.zte.iptvclient.android.mobile.h.a.a.g().c(sb2);
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.a aVar) {
        LogEx.d("DetailMovieFragment", "BackTrailerFristPlayVodEvent event");
        this.g0 = false;
        R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z2) {
        String str = this.q1 + "/light/";
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json; charset=UTF-8");
        sDKNetHTTPRequest.setBody(U());
        sDKNetHTTPRequest.startRequest(str, HttpRequest.METHOD_POST, new h(z2));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.mobile.ivi.b.b bVar) {
        i0();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.mobile.ivi.b.a aVar) {
        a0();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.j jVar) {
        com.zte.iptvclient.android.mobile.e0.e.f fVar = this.Y;
        if (fVar != null) {
            fVar.b(jVar.a());
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.a.i
    public void a(boolean z2) {
        if (this.i0) {
            this.h.setRequestedOrientation(0);
        } else {
            this.h.setRequestedOrientation(1);
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
        e0();
        this.y.setLayoutParams(new LinearLayout.LayoutParams(this.B, this.A));
        if (this.Z) {
            this.Q.setVisibility(0);
            this.p.setVisibility(0);
        }
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.b0.d());
    }

    public String c(com.zte.iptvclient.android.mobile.ivi.c.a aVar, String str, String str2) {
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
        jsonArray.add(this.v0);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty(Constants.SINA_WEIBO_UID, aVar.a());
        jsonObject2.addProperty("app_version", this.r1);
        jsonObject2.addProperty("session", str);
        jsonObject2.addProperty("watchid", this.u0);
        jsonArray.add(jsonObject2);
        jsonObject.add(NativeProtocol.WEB_DIALOG_PARAMS, jsonArray);
        jsonObject.addProperty("method", "da.content.watched");
        this.y0 = jsonObject.toString();
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("data", str2 + this.y0);
        jsonObject3.addProperty("k", propertiesInfo);
        jsonObject3.addProperty("k1", propertiesInfo2);
        jsonObject3.addProperty("k2", propertiesInfo3);
        return jsonObject3.toString();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        if (cVar.a().equals("0")) {
            d0();
            s(this.u);
            if (this.e0) {
                Y();
            }
            com.zte.iptvclient.android.mobile.e0.e.f fVar = this.Y;
            if (fVar != null) {
                fVar.K();
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.t.a aVar) {
        LogEx.d("DetailMovieFragment", "recharge state is " + aVar.a());
        if (aVar.a()) {
            d0();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.javabean.h hVar) {
        hVar.a();
        throw null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.u uVar) {
        if (isHidden()) {
            return;
        }
        d0();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.eventbus.multi.c cVar) {
        LogEx.d("DetailMovieFragment", "MultiPlayerExitEvent");
        if (cVar == null || !cVar.a()) {
            this.Z = false;
            if (this.p != null) {
                this.Q.setVisibility(8);
                this.p.setVisibility(8);
                e0();
            }
            com.zte.iptvclient.android.common.player.k.c cVar2 = this.E;
            if (cVar2 != null) {
                cVar2.H1();
            }
        }
    }

    @Override // com.zte.iptvclient.android.mobile.e0.e.f.x
    public void a() {
        if (this.p != null) {
            this.Q.setVisibility(0);
            this.p.setVisibility(0);
            this.Z = true;
        }
        com.zte.iptvclient.android.common.player.k.c cVar = this.E;
        if (cVar != null) {
            cVar.X1();
        }
        this.L.setVisibility(4);
    }

    private void d(VideoDetailBean videoDetailBean) {
        new com.zte.iptvclient.android.common.f.b.k(this.h, this.v, videoDetailBean, new r()).a(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        if (i2 == 0) {
            if (this.R.get(0).getCpcode().equals("ivi")) {
                g0();
            } else {
                k0();
            }
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.c.o0
    public void a(com.zte.iptvclient.android.common.e.b bVar) {
        this.E.setTargetFragment(null, -1);
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
        jsonArray.add(this.v0);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty(Constants.SINA_WEIBO_UID, aVar.a());
        jsonObject2.addProperty("app_version", this.r1);
        jsonObject2.addProperty("session", str);
        jsonArray.add(jsonObject2);
        jsonObject.add(NativeProtocol.WEB_DIALOG_PARAMS, jsonArray);
        jsonObject.addProperty("method", "da.content.get");
        this.y0 = jsonObject.toString();
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("data", str2 + this.y0);
        jsonObject3.addProperty("k", propertiesInfo);
        jsonObject3.addProperty("k1", propertiesInfo2);
        jsonObject3.addProperty("k2", propertiesInfo3);
        return jsonObject3.toString();
    }
}
