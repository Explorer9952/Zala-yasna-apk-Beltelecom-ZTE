package com.zte.iptvclient.android.common.player.k;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.internal.ServerProtocol;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.logging.nano.Vr;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.cast.bean.Device;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.player.IBasePlayer;
import com.video.androidsdk.player.common.AssetStatus;
import com.video.androidsdk.player.common.AssetType;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.viewhistory.AddViewHistoryReq;
import com.video.androidsdk.service.viewhistory.SDKViewHistoryMgr;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.a.a.e.f;
import com.zte.iptvclient.android.common.customview.a.a.e.l;
import com.zte.iptvclient.android.common.customview.view.VerticalSeekBarNew;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.SlideRelativeLayout;
import com.zte.iptvclient.android.common.eventbus.multi.EventBusPlayerMessage;
import com.zte.iptvclient.android.common.eventbus.multi.MultiPlayWindowEvent;
import com.zte.iptvclient.android.common.f.b.b;
import com.zte.iptvclient.android.common.function.service.PlayBackService;
import com.zte.iptvclient.android.common.h.a;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.Feature;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.player.activity.VOPlayerActivity;
import com.zte.iptvclient.android.common.player.b;
import com.zte.iptvclient.android.common.player.d;
import com.zte.iptvclient.android.common.player.h;
import com.zte.iptvclient.android.common.player.k.a;
import com.zte.iptvclient.android.common.player.k.b;
import com.zte.iptvclient.android.common.player.multiplay.c;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import pl.droidsonroids.gif.GifImageView;

/* compiled from: PlayerFragment.java */
/* loaded from: classes.dex */
public class c extends com.zte.iptvclient.android.common.player.k.b implements com.zte.iptvclient.android.common.player.c, View.OnClickListener, c.o, b.d, b.e, a.b {
    private ConstraintLayout A6;
    private ImageView A7;
    private View A8;
    private ImageView B6;
    private LinearLayout B7;
    private TextView B8;
    private ImageView C6;
    private TextView C7;
    private LinearLayout C8;
    private TextView D6;
    private TextView D7;
    private LinearLayout D8;
    private String E6;
    private ImageView E7;
    private TextView E8;
    private TextView F6;
    private p0 F7;
    private TextView F8;
    private TextView G6;
    private int G7;
    private ImageView G8;
    private TextView H6;
    private ImageView H7;
    private String H8;
    private LinearLayout I6;
    private com.zte.iptvclient.android.mobile.x.b.c.a I8;
    private RelativeLayout J6;
    public o0 J8;
    private VerticalSeekBarNew K6;
    private ImageView L6;
    private ImageView M6;
    private ImageView N6;
    private TextView O6;
    private TextView P6;
    private ImageView Q6;
    private ViewStub Q7;
    private RelativeLayout R6;
    private com.zte.iptvclient.android.common.player.multiplay.c R7;
    private TextView S6;
    private RelativeLayout S7;
    private RelativeLayout S8;
    private RelativeLayout T6;
    private TextView T8;
    private ImageView U6;
    private TextView U8;
    private ProgressBar V5;
    private ImageView V6;
    private TextView V8;
    private ImageView W6;
    private ImageView X5;
    private Button X6;
    private RelativeLayout X7;
    private com.zte.iptvclient.android.common.player.f X8;
    protected RelativeLayout Y5;
    private ImageView Y6;
    private ImageView Y7;
    private m0 Y8;
    private RelativeLayout Z5;
    private LinearLayout Z6;
    private TextView a6;
    private TextView a7;
    private TextView a8;
    private TextView b6;
    private TextView b7;
    private ImageView b8;
    private LinearLayout c6;
    private ImageView c7;
    private TextView c8;
    private ImageView d6;
    private ImageView d7;
    private TextView d8;
    private ImageView e6;
    private ImageView e7;
    private RelativeLayout e8;
    private ListView f6;
    private ImageView f7;
    private RelativeLayout f8;
    private com.zte.iptvclient.android.mobile.a0.a.e.b g6;
    private RelativeLayout g7;
    private RelativeLayout g8;
    private LinearLayout h6;
    private RelativeLayout h7;
    private RelativeLayout h8;
    private TextView i6;
    private TextView i7;
    private ViewPager i8;
    private TextView j6;
    private ImageView j7;
    private LinearLayout k6;
    private com.zte.iptvclient.android.common.j.h k7;
    public OrientationEventListener k8;
    private TextView l6;
    private ImageView l8;
    private RelativeLayout m6;
    private GifImageView m7;
    private ImageView m8;
    private TextView n6;
    private RelativeLayout n7;
    private com.zte.iptvclient.android.common.customview.a.a.b.d n8;
    private LinearLayout o6;
    private VerticalSeekBarNew o7;
    private com.zte.iptvclient.android.common.customview.a.a.b.b o8;
    private TextView p6;
    private ImageView p7;
    private com.zte.iptvclient.android.common.customview.a.a.b.c p8;
    private ImageView q6;
    protected ImageView q7;
    private com.zte.iptvclient.android.common.customview.a.a.b.a q8;
    private SlideRelativeLayout r6;
    private ImageView r7;
    private ImageView r8;
    private RelativeLayout s6;
    private ImageView s7;
    private ImageView s8;
    private ImageView t6;
    private com.zte.iptvclient.android.common.customview.a.a.e.l t7;
    private TextView u6;
    private ImageView u7;
    private TextView v6;
    private ImageView v7;
    private com.zte.iptvclient.android.mobile.a0.b.b v8;
    private TextView w6;
    private Button w7;
    private com.zte.iptvclient.android.mobile.v.b.a w8;
    private TextView x6;
    private RelativeLayout x7;
    private LinearLayout x8;
    private RelativeLayout y6;
    private TextView y7;
    private RelativeLayout z6;
    private TextView z7;
    private TextView z8;
    public boolean W5 = false;
    private boolean l7 = false;
    private boolean I7 = true;
    private boolean J7 = false;
    private boolean K7 = false;
    private int L7 = 0;
    private long M7 = 0;
    private int N7 = 10000;
    private int O7 = 15;
    private int P7 = 0;
    private String T7 = "0";
    private String U7 = "1";
    private String V7 = "2";
    private int W7 = 0;
    private boolean Z7 = false;
    private int j8 = 1;
    private int t8 = 0;
    private int u8 = 0;
    private boolean y8 = false;
    private String K8 = "";
    private String L8 = "";
    private String M8 = "";
    private String N8 = "";
    private boolean O8 = false;
    public boolean P8 = false;
    public long Q8 = -1;
    private int R8 = 0;
    private int W8 = 8000;
    private Handler Z8 = new k();
    private Runnable a9 = new a();
    private Handler b9 = new u();

    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.zte.iptvclient.android.common.k.f.a(c.this.X4)) {
                return;
            }
            int r3 = c.this.r3();
            c.this.i8.a((c.this.i8.c() + 1) % c.this.X4.size(), false);
            c.this.Z8.postDelayed(c.this.a9, r3 * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class a0 implements DialogInterface.OnClickListener {
        a0() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            c.this.j0();
        }
    }

    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    class b extends androidx.viewpager.widget.a {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f5015c;

        b(c cVar, List list) {
            this.f5015c = list;
        }

        @Override // androidx.viewpager.widget.a
        public int a() {
            return this.f5015c.size();
        }

        @Override // androidx.viewpager.widget.a
        public boolean a(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // androidx.viewpager.widget.a
        public Object a(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) this.f5015c.get(i));
            return this.f5015c.get(i);
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }

    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    class b0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5016a;

        b0(String str) {
            this.f5016a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            if (cVar.C || cVar.G || !com.zte.iptvclient.android.common.f.b.b.j().e()) {
                return;
            }
            c.this.d3();
            LogEx.d("PlayerFragment", "###hideLoading()");
            c.this.a2();
            c.this.E();
            c.this.K(this.f5016a);
            c.this.D2();
            c.this.u();
        }
    }

    /* compiled from: PlayerFragment.java */
    /* renamed from: com.zte.iptvclient.android.common.player.k.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewOnTouchListenerC0151c implements View.OnTouchListener {
        ViewOnTouchListenerC0151c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            c cVar = c.this;
            if (!cVar.y || cVar.e0) {
                return false;
            }
            cVar.j3();
            return false;
        }
    }

    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    class c0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5019a;

        c0(String str) {
            this.f5019a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            if (cVar.C || cVar.G || !com.zte.iptvclient.android.common.f.b.b.j().e()) {
                return;
            }
            LogEx.d("PlayerFragment", "###hideLoading()");
            c.this.a2();
            if (c.this.R1()) {
                LogEx.d("PlayerFragment", " Current Play BLACKOUT no need restarPlay BlackOutPlay");
                return;
            }
            if (c.this.Q1()) {
                c.this.Z1();
            }
            c.this.d3();
            c.this.u();
            c.this.L2();
            c.this.I(this.f5019a);
            c.this.D2();
        }
    }

    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    class d implements ViewPager.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f5021a;

        /* compiled from: PlayerFragment.java */
        /* loaded from: classes.dex */
        class a implements com.bumptech.glide.q.f<String, com.bumptech.glide.load.i.e.b> {
            a(d dVar) {
            }

            @Override // com.bumptech.glide.q.f
            public boolean a(com.bumptech.glide.load.i.e.b bVar, String str, com.bumptech.glide.q.j.j<com.bumptech.glide.load.i.e.b> jVar, boolean z, boolean z2) {
                return false;
            }

            @Override // com.bumptech.glide.q.f
            public boolean a(Exception exc, String str, com.bumptech.glide.q.j.j<com.bumptech.glide.load.i.e.b> jVar, boolean z) {
                return false;
            }
        }

        d(List list) {
            this.f5021a = list;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i, float f, int i2) {
            if (!com.zte.iptvclient.android.mobile.e0.f.b.a() || BaseApp.f()) {
                LogEx.d("PlayerFragment", "mAdPausePicUrls = " + c.this.X4.get(i) + "&timestamp=" + System.currentTimeMillis());
                com.bumptech.glide.d<String> a2 = com.bumptech.glide.i.a(c.this.f4977b).a(c.this.X4.get(i) + "&timestamp=" + System.currentTimeMillis());
                a2.a((com.bumptech.glide.q.f<? super String, com.bumptech.glide.load.i.e.b>) new a(this));
                a2.a((ImageView) this.f5021a.get(i));
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void b(int i) {
        }
    }

    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    class d0 implements Runnable {
        d0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            if (cVar.C || cVar.G || !com.zte.iptvclient.android.common.f.b.b.j().f()) {
                return;
            }
            if (c.this.Q1()) {
                c.this.Z1();
            }
            if (c.this.R1()) {
                c.this.d3();
            }
            if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
                com.zte.iptvclient.android.common.f.b.b.j().a(false);
            }
            LogEx.d("PlayerFragment", "showMediaController!!!");
            c.this.f0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class e implements l.h {
        e() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.l.h
        public void c() {
            Device b2 = com.zte.iptvclient.android.mobile.h.a.a.g().b();
            if (b2 != null) {
                c.this.H6.setText(b2.getSTBName());
            }
            if (c.this.J7) {
                c.this.C2();
                c.this.J7 = false;
                c.this.t7.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class e0 implements AdapterView.OnItemClickListener {
        e0() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (c.this.g6.a() == i) {
                return;
            }
            c.this.B0();
            c.this.g6.a(i);
            c.this.g6.notifyDataSetChanged();
            c.this.e6.setVisibility(8);
            if (i >= c.this.i1.size()) {
                return;
            }
            c cVar = c.this;
            if (cVar.f4977b instanceof MainActivity) {
                com.zte.iptvclient.android.common.e.x.e eVar = new com.zte.iptvclient.android.common.e.x.e(cVar.i1.get(i).getChannelcode(), "");
                eVar.a(true);
                EventBus.getDefault().post(eVar);
                return;
            }
            if (cVar.B && cVar.A) {
                cVar.k(true);
                c.this.i0();
            }
            c cVar2 = c.this;
            cVar2.y(cVar2.i1.get(i).getChannelcode());
            c.this.i1();
        }
    }

    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    class f implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.player.j.i f5026a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bundle f5027b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f5028c;

        /* compiled from: PlayerFragment.java */
        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f5030a;

            a(String str) {
                this.f5030a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.d3();
                LogEx.d("PlayerFragment", "###hideLoading()");
                c.this.a2();
                c.this.K(this.f5030a);
                c.this.E();
                c.this.D2();
            }
        }

        /* compiled from: PlayerFragment.java */
        /* loaded from: classes.dex */
        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f5032a;

            b(String str) {
                this.f5032a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.d3();
                c.this.I(this.f5032a);
                c.this.E();
                c.this.D2();
            }
        }

        /* compiled from: PlayerFragment.java */
        /* renamed from: com.zte.iptvclient.android.common.player.k.c$f$c, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0152c implements Runnable {
            RunnableC0152c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.d3();
                c.this.Z1();
                c.this.f0();
                LogEx.d("PlayerFragment", "定桩起播 now beginPlayTVInSmallScreen");
                com.zte.iptvclient.android.common.player.f fVar = c.this.X8;
                f fVar2 = f.this;
                fVar.a(fVar2.f5026a, fVar2.f5027b, c.this.f4977b, fVar2.f5028c);
            }
        }

        /* compiled from: PlayerFragment.java */
        /* loaded from: classes.dex */
        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.d3();
                LogEx.d("PlayerFragment", "###hideLoading()");
                c.this.a2();
                c.this.H2();
                c.this.E();
                c.this.D2();
            }
        }

        f(com.zte.iptvclient.android.common.player.j.i iVar, Bundle bundle, c cVar) {
            this.f5026a = iVar;
            this.f5027b = bundle;
            this.f5028c = cVar;
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void j() {
            c.this.s0 = true;
            LogEx.d("PlayerFragment", "定桩起播 no Blackoutinfo for onBlackoutExitReturn to beginPlayTVInSmallScreen");
            c.this.f4977b.runOnUiThread(new RunnableC0152c());
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void k(String str) {
            LogEx.d("PlayerFragment", "tv blackout查询展示onImageBlackoutReturn:" + str);
            c.this.f4977b.runOnUiThread(new a(str));
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void l() {
            LogEx.d("PlayerFragment", "get Detail BlackoutInfo is null （pic url or play url is null）");
            c.this.f4977b.runOnUiThread(new d());
        }

        @Override // com.zte.iptvclient.android.common.f.b.b.d
        public void r(String str) {
            LogEx.d("PlayerFragment", "tv blackout查询播放black片源" + str);
            c.this.f4977b.runOnUiThread(new b(str));
        }
    }

    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    class f0 implements Runnable {
        f0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            if (cVar.C || cVar.G || !com.zte.iptvclient.android.common.f.b.b.j().e()) {
                return;
            }
            c.this.d3();
            LogEx.d("PlayerFragment", "###hideLoading()");
            c.this.a2();
            c.this.H2();
            c.this.D2();
            c.this.u();
        }
    }

    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.customview.view.imageview.a f5037a;

        /* compiled from: PlayerFragment.java */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.zte.iptvclient.android.common.customview.view.imageview.a aVar = g.this.f5037a;
                if (aVar != null) {
                    aVar.setVisibility(4);
                }
            }
        }

        g(com.zte.iptvclient.android.common.customview.view.imageview.a aVar) {
            this.f5037a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activity;
            if (this.f5037a == null || (activity = c.this.f4977b) == null || activity.isFinishing()) {
                return;
            }
            LogEx.d("PlayerFragment", "Advertisiment showing CornerAdImg " + this.f5037a.j());
            com.bumptech.glide.i.a(c.this.f4977b).a(this.f5037a.j()).a((ImageView) this.f5037a);
            int i = this.f5037a.i();
            if (i != 0) {
                if (i != 1) {
                    if (i != 3) {
                        if (i == 4 && c.this.h8 != null) {
                            c.this.h8.removeAllViews();
                            c.this.h8.addView(this.f5037a);
                        }
                    } else if (c.this.g8 != null) {
                        c.this.g8.removeAllViews();
                        c.this.g8.addView(this.f5037a);
                    }
                } else if (c.this.f8 != null) {
                    c.this.f8.removeAllViews();
                    c.this.f8.addView(this.f5037a);
                }
            } else if (c.this.e8 != null) {
                c.this.e8.removeAllViews();
                c.this.e8.addView(this.f5037a);
            }
            c.this.Z8.postDelayed(new a(), this.f5037a.g() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class g0 implements AbsListView.OnScrollListener {
        g0() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            c.this.b2 = (i + i2) - 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                c.this.Z8.removeMessages(3);
                return;
            }
            c cVar = c.this;
            int i2 = cVar.b2 / cVar.a2;
            cVar.X1 = i2;
            int[] iArr = cVar.W1;
            if (i2 >= iArr.length) {
                return;
            }
            if (iArr[i2] == 0) {
                cVar.y0();
            }
            c.this.Z8.sendEmptyMessageDelayed(3, c.this.N7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.J6.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class h0 extends OrientationEventListener {
        h0(Context context) {
            super(context);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            int i2;
            try {
                i2 = Settings.System.getInt(c.this.f4977b.getContentResolver(), "accelerometer_rotation");
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
                i2 = 1;
            }
            if (i2 == 0 || i == -1 || Math.abs(c.this.P7 - i) < c.this.O7 || Math.abs(c.this.P7 - i) > 360 - c.this.O7) {
                return;
            }
            c cVar = c.this;
            if (cVar.O5) {
                return;
            }
            cVar.j8 = cVar.l(i);
            c.this.P7 = i;
            LogEx.d("PlayerFragment", "onOrientationChanged Currrent mOrientation " + c.this.j8 + " name " + c.this.f4977b.getClass());
            c cVar2 = c.this;
            if (cVar2.s5) {
                LogEx.d("PlayerFragment", "onOrientationChanged Currrent Screen Locked=" + c.this.s5);
                return;
            }
            Activity activity = cVar2.f4977b;
            if (!(activity instanceof VOPlayerActivity) && (!(activity instanceof MainActivity) || ((MainActivity) activity).r())) {
                c cVar3 = c.this;
                if (!(cVar3.f4977b instanceof HostActivity) || !cVar3.isHidden()) {
                    c cVar4 = c.this;
                    if ((!cVar4.e0 && !cVar4.W5) || BaseApp.a(c.this.f4977b)) {
                        if (c.this.j8 != 8 && c.this.j8 != 0) {
                            if (c.this.j8 == 1) {
                                c cVar5 = c.this;
                                if (cVar5.B) {
                                    if (!BaseApp.a(cVar5.f4977b)) {
                                        LogEx.d("PlayerFragment", "onOrientationChanged  skipToSmallScreen " + c.this.j8);
                                        c.this.i0();
                                        return;
                                    }
                                    LogEx.d("PlayerFragment", " onOrientationChanged current is pad, orientation is not need switch portrait");
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        if (!BaseApp.a(c.this.f4977b)) {
                            LogEx.d("PlayerFragment", "onOrientationChanged  skipToFullScreen " + c.this.j8);
                            c cVar6 = c.this;
                            cVar6.m(cVar6.j8);
                            return;
                        }
                        c cVar7 = c.this;
                        if (!cVar7.A || cVar7.L7 == c.this.j8) {
                            return;
                        }
                        LogEx.d("PlayerFragment", "onOrientationChanged  skipToFullScreen " + c.this.j8);
                        c cVar8 = c.this;
                        cVar8.m(cVar8.j8);
                        c cVar9 = c.this;
                        cVar9.L7 = cVar9.j8;
                        return;
                    }
                    LogEx.d("PlayerFragment", "onOrientationChanged  skipTosmallScreen return ");
                    c.this.f4977b.setRequestedOrientation(1);
                    return;
                }
            }
            LogEx.d("PlayerFragment", "onOrientationChanged current centext is not support swicthOrientaion return");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f4();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class i0 implements CompoundButton.OnCheckedChangeListener {
        i0() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            LogEx.d("PlayerFragment", "mSensorCheckBox   --  1 " + z);
            if (z) {
                c cVar = c.this;
                cVar.s5 = true;
                cVar.s0 = false;
                cVar.E();
                return;
            }
            c cVar2 = c.this;
            cVar2.s5 = false;
            cVar2.s0 = true;
            LogEx.d("PlayerFragment", "showMediaController!!!");
            c.this.f0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class j implements b.d {
        j() {
        }

        @Override // com.zte.iptvclient.android.common.player.b.d
        public void a(int i, String str) {
            c.this.R8 = i;
            c.this.T(str);
            c.this.b5.dismiss();
            LogEx.d("PlayerFragment", "Multitrack changeSubtitle +++" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class j0 implements View.OnTouchListener {
        j0(c cVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class k extends Handler {
        k() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    c.this.F3();
                    return;
                case 1:
                    if (c.this.o8 == null || !c.this.o8.isShowing()) {
                        return;
                    }
                    c.this.o8.dismiss();
                    return;
                case 2:
                    if (c.this.n8 == null || !c.this.n8.isShowing()) {
                        return;
                    }
                    c.this.n8.dismiss();
                    return;
                case 3:
                    c.this.B0();
                    return;
                case 4:
                    if (c.this.q8 == null || !c.this.q8.isShowing()) {
                        return;
                    }
                    c.this.q8.dismiss();
                    return;
                case 5:
                    if (c.this.p8 == null || !c.this.p8.isShowing()) {
                        return;
                    }
                    c.this.p8.dismiss();
                    return;
                case 6:
                    c.this.X5.setVisibility(8);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class k0 implements View.OnTouchListener {
        k0(c cVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class l implements b.c {
        l() {
        }

        @Override // com.zte.iptvclient.android.common.player.b.c
        public void a(String str) {
            c.this.S(str);
            c.this.a5.dismiss();
            LogEx.d("PlayerFragment", "MultitrackchangeAudio +++" + str);
        }
    }

    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    class l0 implements Runnable {
        l0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.v4();
            c.this.w4();
        }
    }

    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    class m implements d.e {
        m() {
        }

        @Override // com.zte.iptvclient.android.common.player.d.e
        public void a(String str, String str2, List<com.zte.iptvclient.android.common.player.j.g> list) {
            if (!TextUtils.isEmpty(str2)) {
                LogEx.d("PlayerFragment", "megogo playurl = " + c.this.f2);
                c cVar = c.this;
                cVar.f2 = str2;
                cVar.A2();
                return;
            }
            c.this.Q2();
        }
    }

    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public interface m0 {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class n implements h.b {
        n() {
        }

        @Override // com.zte.iptvclient.android.common.player.h.b
        public void a(String str) {
            c.this.c5.dismiss();
            c.this.H(str);
        }
    }

    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public interface n0 {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class o implements t.d {
        o(c cVar) {
        }

        @Override // com.zte.iptvclient.android.common.k.t.d
        public void onDismiss() {
        }
    }

    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public interface o0 {
        void a(com.zte.iptvclient.android.common.e.b bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class p implements Runnable {
        p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.R7.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class p0 extends BroadcastReceiver {
        private p0() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction())) {
                int streamVolume = c.this.S3.getStreamVolume(3);
                LogEx.d("PlayerFragment", "iVolume:" + streamVolume);
                c.this.K6.b(streamVolume);
                c.this.o7.b(streamVolume);
                if (streamVolume != 0) {
                    c.this.r7.setImageDrawable(c.this.getResources().getDrawable(R.drawable.player_sound_normal));
                    c.this.M6.setImageDrawable(c.this.getResources().getDrawable(R.drawable.player_sound_normal));
                    c.this.I7 = true;
                }
            }
        }

        /* synthetic */ p0(c cVar, k kVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class q implements c.p {
        q(c cVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class r implements Runnable {
        r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.s0 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class s implements f.c {
        s() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void a() {
            c.this.w5();
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void b() {
            c.this.X0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class t implements f.c {
        t() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void a() {
            com.zte.iptvclient.android.mobile.h.a.a g = com.zte.iptvclient.android.mobile.h.a.a.g();
            String str = c.this.M8;
            String str2 = c.this.K8;
            c cVar = c.this;
            g.a(str, str2, cVar.f2, cVar.x3, cVar.N8, c.this.a1);
            if ("1".equals(ConfigMgr.readPropertie("IsSupportCastScreen", "0"))) {
                if (c.this.t7 != null && c.this.t7.isShowing()) {
                    c.this.t7.dismiss();
                }
                c.this.n5();
            }
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void b() {
            c.this.X0();
        }
    }

    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    class u extends Handler {
        u() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                c.this.w4();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class v implements View.OnTouchListener {
        v() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return c.this.a(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class w implements SDKViewHistoryMgr.OnAddViewHistoryReturnListener {
        w(c cVar) {
        }

        @Override // com.video.androidsdk.service.viewhistory.SDKViewHistoryMgr.OnAddViewHistoryReturnListener
        public void onAddViewHistoryReturn(String str, String str2) {
            LogEx.d("PlayerFragment", "onAddViewHistoryReturn returncode" + str + " errormsg " + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    public class x implements Runnable {
        x() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.Z1();
        }
    }

    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    class y implements Runnable {
        y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.C3();
            c.this.s0();
        }
    }

    /* compiled from: PlayerFragment.java */
    /* loaded from: classes.dex */
    class z implements Runnable {
        z() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.n2();
        }
    }

    private void A3() {
        TextView textView = this.F6;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void A4() {
        LogEx.d("PlayerFragment", "text Play setOrderAndMultiRatesParametersWhenAuthThroughSucceed");
        b2();
        Z3();
        d2();
        this.h0 = false;
        k(false);
        Q4();
        T3();
        this.X6.setEnabled(true);
        this.X6.setTextColor(this.f4977b.getResources().getColor(R.color.white));
        this.w7.setEnabled(true);
        this.w7.setTextColor(this.f4977b.getResources().getColor(R.color.white));
        w4();
    }

    private void A5() {
        if ("1".equals(this.T) || "10".equals(this.T) || "14".equals(this.T)) {
            W0();
            if (this.B && this.A) {
                i0();
            }
            U0();
        }
        b.a0 a0Var = this.L3;
        if (a0Var != null) {
            a0Var.q("1");
        }
    }

    private void B3() {
        LinearLayout linearLayout = this.k6;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        } else {
            LogEx.e("PlayerFragment", "unable hideCommonPlayerTipView");
        }
    }

    private void B4() {
        com.zte.iptvclient.android.common.customview.a.a.e.l lVar = this.t7;
        if (lVar != null && lVar.isShowing()) {
            this.t7.dismiss();
            return;
        }
        com.zte.iptvclient.android.common.customview.a.a.e.l lVar2 = this.t7;
        if (lVar2 != null) {
            lVar2.show();
            this.t7.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C3() {
        ImageView imageView = this.G8;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void C4() {
        com.zte.iptvclient.android.common.customview.a.a.e.l lVar = this.t7;
        if (lVar != null && lVar.isShowing()) {
            this.t7.dismiss();
            return;
        }
        com.zte.iptvclient.android.common.customview.a.a.e.l lVar2 = this.t7;
        if (lVar2 != null) {
            lVar2.show();
            this.t7.a();
        }
    }

    private void D3() {
        this.A6.setVisibility(8);
        this.n7.setVisibility(8);
        if (this.f4977b instanceof VOPlayerActivity) {
            this.t5.setVisibility(8);
        }
        d4();
        if (this.O8 && !this.V0.getBoolean("isProjection", false)) {
            c4();
        }
        H3();
    }

    private void D4() {
        if (this.L == null || this.f4977b == null) {
            return;
        }
        p2();
        ArrayList<String> arrayList = new ArrayList<>();
        this.L.getSubtitleInfoArray(arrayList);
        arrayList.add(this.f4977b.getResources().getString(R.string.text_disable));
        LogEx.d("PlayerFragment", "Multitrack getMulitSubtitle = " + arrayList);
        if (arrayList.size() > 0) {
            if (TextUtils.equals(this.f4977b.getResources().getString(R.string.text_disable), arrayList.get(0))) {
                return;
            }
            this.R8 = c(arrayList);
            LogEx.d("PlayerFragment", "Multitrack  mSelectedSubtitleIndex = " + this.R8 + ";" + arrayList.size());
            if (this.R8 < arrayList.size()) {
                if (TextUtils.equals(this.f4977b.getResources().getString(R.string.text_disable), arrayList.get(this.R8))) {
                    this.L.enableSubtitle(false);
                } else {
                    this.L.enableSubtitle(true);
                    this.L.selectSubtitleByIndex(this.R8);
                }
                W2();
                return;
            }
            return;
        }
        LogEx.e("PlayerFragment", "Multitrack  getMulitSubtitle is null! ");
    }

    private void E3() {
        RelativeLayout relativeLayout = this.y6;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    private void E4() {
        com.zte.iptvclient.android.common.player.b bVar = this.b5;
        if (bVar != null && bVar.isShowing()) {
            this.b5.dismiss();
            return;
        }
        if (this.b5 == null) {
            com.zte.iptvclient.android.common.player.b bVar2 = new com.zte.iptvclient.android.common.player.b(this.f4977b.getApplicationContext(), this.L);
            this.b5 = bVar2;
            bVar2.a(new j());
        }
        int[] iArr = new int[2];
        this.U6.getLocationInWindow(iArr);
        int i2 = iArr[0];
        int a2 = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 22.0f);
        int a3 = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 8.0f);
        this.b5.a(this.R8);
        this.b5.a(this.f, 83, i2 - a2, this.A6.getHeight() + this.T6.getHeight() + a3, AssetType.Asset_Subtitle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F3() {
        RelativeLayout relativeLayout = this.s6;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    private void F4() {
        LogEx.d("PlayerFragment", "setViewVisibility" + this.B);
        if (!this.B) {
            K3();
            this.q6.setVisibility(8);
        }
        f0();
        q5();
        c4();
        d4();
        v1();
        x4();
        if ("10".equals(this.T)) {
            D1();
        }
        A(this.c1);
        LogEx.d("PlayerFragment", " mstrDefinitonType  is " + this.c1);
        if (this.O5) {
            s4();
        }
    }

    private void G3() {
        GifImageView gifImageView = this.m7;
        if (gifImageView != null) {
            gifImageView.setImageDrawable(null);
            this.m7.setVisibility(8);
        }
    }

    private void G4() {
        this.c7.setOnClickListener(this);
        this.d7.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.o6.setOnClickListener(this);
        this.q6.setOnClickListener(this);
        this.L6.setOnClickListener(this);
        this.M6.setOnClickListener(this);
        this.I6.setOnClickListener(this);
        this.U6.setOnClickListener(this);
        this.V6.setOnClickListener(this);
        this.p7.setOnClickListener(this);
        this.F0.setOnClickListener(this);
        this.X6.setOnClickListener(this);
        this.Y6.setOnClickListener(this);
        this.q7.setOnClickListener(this);
        this.r7.setOnClickListener(this);
        this.s7.setOnClickListener(this);
        this.w7.setOnClickListener(this);
        this.b6.setOnClickListener(this);
        this.b7.setOnClickListener(this);
        this.D7.setOnClickListener(this);
        this.s6.setOnClickListener(this);
        this.m8.setOnClickListener(this);
        this.l8.setOnClickListener(this);
        this.d6.setOnClickListener(this);
        this.e6.setOnClickListener(this);
        this.H7.setOnClickListener(this);
        this.j7.setOnClickListener(this);
        this.e7.setOnClickListener(this);
        this.Y7.setOnClickListener(this);
        this.b8.setOnClickListener(this);
        this.v7.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.t0.setOnClickListener(this);
        this.d8.setOnClickListener(this);
        this.d8.setClickable(false);
        this.d8.setTextColor(androidx.core.content.a.a(this.f4977b, R.color.close_ad_bg));
        LogEx.d("PlayerFragment", "Advertisiment mTvTimer setClickable(false)");
        if (this.H3 == null) {
            K0();
        }
        this.B6.setOnClickListener(this.H3);
        this.W6.setOnClickListener(this.H3);
        this.C6.setOnClickListener(this.H3);
        this.N6.setOnClickListener(this.G3);
        this.w0.setOnSeekBarChangeListener(this.K3);
        this.K6.a(this.Q3);
        this.Q6.setOnClickListener(this.I3);
        this.A7.setOnClickListener(this.I3);
        this.R6.setOnClickListener(this.J3);
        this.u7.setOnClickListener(this.G3);
        this.v0.setOnSeekBarChangeListener(this.K3);
        this.o7.a(this.Q3);
        if (TextUtils.equals(ConfigMgr.readPropertie("isStartOver"), "1")) {
            this.h7.setOnClickListener(this);
        }
    }

    private void H3() {
        RelativeLayout relativeLayout = this.T6;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        com.zte.iptvclient.android.common.player.b bVar = this.a5;
        if (bVar != null && bVar.isShowing()) {
            this.a5.dismiss();
        }
        com.zte.iptvclient.android.common.player.b bVar2 = this.b5;
        if (bVar2 == null || !bVar2.isShowing()) {
            return;
        }
        this.b5.dismiss();
    }

    private void H4() {
        this.h.setOnTouchListener(new v());
        this.f6.setOnItemClickListener(new e0());
        this.f6.setOnScrollListener(new g0());
        this.k8 = new h0(this.f4977b.getApplicationContext());
        this.t5.setOnCheckedChangeListener(new i0());
        G4();
    }

    private void I3() {
        if (this.X6 == null || TextUtils.isEmpty(this.c1)) {
            return;
        }
        this.X6.setVisibility(4);
    }

    private void I4() {
        RelativeLayout relativeLayout = this.S7;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    private void J3() {
        Button button = this.w7;
        if (button != null) {
            button.setVisibility(8);
        }
    }

    private void J4() {
        ImageView imageView = this.B6;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    private void K3() {
        if (Build.VERSION.SDK_INT >= 14) {
            this.h.setSystemUiVisibility(3846);
        }
    }

    private void K4() {
        ImageView imageView = this.e6;
        if (imageView != null) {
            imageView.setVisibility(0);
            L4();
        }
    }

    private void L3() {
        LinearLayout linearLayout = this.h6;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
            e4();
        }
    }

    private void L4() {
        LinearLayout linearLayout = this.c6;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }

    private void M3() {
        ImageView imageView = this.Y6;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void M4() {
        ImageView imageView = this.d6;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    private void N3() {
        ImageView imageView = this.N6;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void N4() {
        TextView textView = this.F6;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    private void O3() {
        ImageView imageView = this.u7;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void O4() {
        LinearLayout linearLayout = this.k6;
        if (linearLayout != null && !this.r) {
            linearLayout.setVisibility(0);
        } else {
            LogEx.e("PlayerFragment", "unable showCommonPlayerTipView");
        }
    }

    private String P(String str) {
        ArrayList<Channel> b2 = com.zte.iptvclient.android.common.j.i.d().b();
        if (b2 != null) {
            Iterator<Channel> it2 = b2.iterator();
            while (it2.hasNext()) {
                Channel next = it2.next();
                if (TextUtils.equals(next.getChannelcode(), str)) {
                    return next.getRatingid();
                }
            }
        }
        return "";
    }

    private void P3() {
        RelativeLayout relativeLayout = this.f;
        if (relativeLayout == null || this.t5 == null || this.Y5 == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        LogEx.d("PlayerFragment", " mRlayoutFullScreenControl.setVisibility(View.INVISIBLE)!!!");
        this.f.setVisibility(4);
        this.Y5.setVisibility(4);
        this.t5.setVisibility(8);
        this.f.requestLayout();
    }

    private void P4() {
        ImageView imageView = this.G8;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    private String Q(String str) {
        return "1".equals(str) ? "url_sd" : "2".equals(str) ? "url_sd_h" : "4".equals(str) ? "url_hd" : "8".equals(str) ? "url_480p" : GlobalConst.WINPHONE_CLIENT.equals(str) ? "url_720p" : GlobalConst.ANDRIODSTB_CLIENT.equals(str) ? "url_1280p" : "";
    }

    private void Q3() {
        RelativeLayout relativeLayout = this.g;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        LogEx.d("PlayerFragment", " mRlayoutSmallScreenControl.setVisibility(View.INVISIBLE)!!!");
        this.g.setVisibility(4);
        this.g.requestLayout();
    }

    private void Q4() {
        this.A6.setVisibility(0);
        this.n7.setVisibility(0);
        if (this.f4977b instanceof VOPlayerActivity) {
            this.t5.setVisibility(8);
        }
        d4();
    }

    private void R(String str) {
        k5();
        String a2 = com.zte.iptvclient.android.common.i.a.a.a("1".equals(str) ? R.string.vod_order_hint_above_bar : R.string.tv_order_hint_above_bar);
        if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
            a2 = a2.replace(com.zte.iptvclient.android.common.i.a.a.a(R.string.order_pay), this.f4977b.getString(R.string.order_pay_login));
        }
        this.a7.setText(a2);
        this.C7.setText(a2);
    }

    private void R3() {
        TextView textView = this.y7;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void R4() {
        RelativeLayout relativeLayout = this.s6;
        if (relativeLayout != null) {
            this.Q5 = true;
            relativeLayout.setVisibility(0);
            this.f4977b.getSharedPreferences("gesture_help", 0).edit().putBoolean("first_in", this.Q5).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(String str) {
        if (this.k7 == null) {
            this.k7 = new com.zte.iptvclient.android.common.j.h(this.f4977b);
        }
        if (TextUtils.equals("2", this.T)) {
            com.zte.iptvclient.android.common.j.f.a().a(this.k7.V(), this.u, str);
        } else {
            com.zte.iptvclient.android.common.j.f.a().c(this.k7.V(), str);
        }
    }

    private void S3() {
        LinearLayout linearLayout = this.x8;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
            e4();
        }
    }

    private void S4() {
        GifImageView gifImageView = this.m7;
        if (gifImageView != null) {
            gifImageView.setImageResource(R.drawable.redio);
            this.m7.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(String str) {
        if (this.k7 == null) {
            this.k7 = new com.zte.iptvclient.android.common.j.h(this.f4977b);
        }
        if (TextUtils.equals("2", this.T)) {
            com.zte.iptvclient.android.common.j.f.a().b(this.k7.V(), this.u, str);
        } else {
            com.zte.iptvclient.android.common.j.f.a().d(this.k7.V(), str);
        }
    }

    private void T3() {
        LinearLayout linearLayout = this.Z6;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.B7;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    private void T4() {
        com.zte.iptvclient.android.common.customview.a.a.e.f fVar = new com.zte.iptvclient.android.common.customview.a.a.e.f(this.f4977b, R.drawable.custom_dialog_title_img, R.string.send_play_hint, R.drawable.order_dialog_btn_bg, R.string.common_ok, 0, R.drawable.order_dialog_btn_bg, R.string.common_cancel, 0, new t());
        fVar.a();
        fVar.setCanceledOnTouchOutside(false);
    }

    private void U3() {
        TextView textView = this.G6;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void U4() {
        com.zte.iptvclient.android.common.customview.a.a.e.f fVar = new com.zte.iptvclient.android.common.customview.a.a.e.f(this.f4977b, R.drawable.custom_dialog_login_img, R.string.login_the_system_first, R.drawable.login_btn_bg, R.string.login_btnlogin, 0, R.drawable.login_btn_bg, R.string.common_cancel, 0, new s());
        fVar.a();
        fVar.setCanceledOnTouchOutside(false);
    }

    private void V3() {
        ProgressBar progressBar = this.V5;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    private void V4() {
        RelativeLayout relativeLayout = this.T6;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    private void W3() {
        ImageView imageView = this.Q6;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void W4() {
        u3();
        if (this.A) {
            com.zte.iptvclient.android.common.player.multiplay.a.c().a().clear();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((this.t8 * 3) / 5, -1);
            layoutParams.addRule(11, -1);
            this.r5.setLayoutParams(layoutParams);
            FragmentManager childFragmentManager = getChildFragmentManager();
            androidx.fragment.app.r b2 = childFragmentManager.b();
            if (childFragmentManager.c(com.zte.iptvclient.android.mobile.a0.b.b.class.getSimpleName()) != null && this.v8 != null) {
                com.zte.iptvclient.android.common.javabean.f fVar = new com.zte.iptvclient.android.common.javabean.f();
                if (TextUtils.equals(this.T, "2")) {
                    fVar.d("0");
                    fVar.e(this.u);
                    fVar.f(this.C1);
                } else if (TextUtils.equals(this.T, "4")) {
                    fVar.d("1");
                    fVar.e(this.p1);
                    fVar.f(this.f1);
                } else if (TextUtils.equals(this.T, "1")) {
                    fVar.d("2");
                    fVar.e(this.q1);
                    fVar.f(this.f1);
                } else {
                    fVar.d("2");
                    fVar.e(this.q1);
                    String valueOf = String.valueOf(this.U1);
                    if (valueOf.length() < 2) {
                        valueOf = "0" + valueOf;
                    }
                    fVar.f((valueOf + " ") + this.f1);
                    fVar.j(this.g1);
                }
                com.zte.iptvclient.android.common.player.multiplay.a.c().a().add(0, fVar);
                this.v8.x0.notifyDataSetChanged();
                b2.e(this.v8);
            } else {
                com.zte.iptvclient.android.common.javabean.f fVar2 = new com.zte.iptvclient.android.common.javabean.f();
                if (TextUtils.equals(this.T, "2")) {
                    fVar2.d("0");
                    fVar2.e(this.u);
                    fVar2.f(this.C1);
                } else if (TextUtils.equals(this.T, "4")) {
                    fVar2.d("1");
                    fVar2.e(this.p1);
                    fVar2.f(this.f1);
                } else if (TextUtils.equals(this.T, "1")) {
                    fVar2.d("2");
                    fVar2.e(this.q1);
                    fVar2.f(this.f1);
                } else {
                    fVar2.d("2");
                    fVar2.e(this.q1);
                    String valueOf2 = String.valueOf(this.U1);
                    if (valueOf2.length() < 2) {
                        valueOf2 = "0" + valueOf2;
                    }
                    fVar2.f((valueOf2 + " ") + this.f1);
                    fVar2.j(this.g1);
                }
                if (TextUtils.isEmpty(fVar2.c()) || TextUtils.isEmpty(fVar2.d())) {
                    return;
                }
                if (!com.zte.iptvclient.android.common.player.multiplay.a.c().a(fVar2)) {
                    com.zte.iptvclient.android.common.player.multiplay.a.c().a().add(0, fVar2);
                }
                if (com.zte.iptvclient.android.common.player.multiplay.a.c().a().size() > 4) {
                    com.zte.iptvclient.android.common.player.multiplay.a.c().a().remove(4);
                }
                this.v8 = new com.zte.iptvclient.android.mobile.a0.b.b();
                Bundle bundle = new Bundle();
                bundle.putBoolean("isMultiScreenMode", true);
                bundle.putInt("themetype", 1);
                this.v8.setArguments(bundle);
                b2.a(R.id.fl_multi_play_manager, this.v8, com.zte.iptvclient.android.mobile.a0.b.b.class.getSimpleName());
                b2.a((String) null);
            }
            Fragment c2 = childFragmentManager.c(com.zte.iptvclient.android.mobile.v.b.a.class.getSimpleName());
            if (c2 != null && (c2 instanceof com.zte.iptvclient.android.mobile.v.b.a)) {
                b2.c(c2);
            }
            b2.b();
            this.r5.setVisibility(0);
        }
        E();
    }

    private void X3() {
        ImageView imageView = this.A7;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void X4() {
        if (this.X6 != null) {
            if (!TextUtils.isEmpty(this.c1) && !this.s && !TextUtils.equals(this.T, "4")) {
                this.X6.setVisibility(0);
            } else {
                this.X6.setVisibility(4);
            }
        }
    }

    private void Y3() {
        RelativeLayout relativeLayout = this.g7;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    private void Y4() {
        Button button = this.w7;
        if (button != null) {
            button.setVisibility(8);
        }
    }

    private void Z3() {
        RelativeLayout relativeLayout = this.Z5;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    private void Z4() {
        if (Build.VERSION.SDK_INT >= 14) {
            if (this.A) {
                this.h.setSystemUiVisibility(3846);
            } else {
                this.h.setSystemUiVisibility(0);
            }
        }
    }

    private void a4() {
        TextView textView = this.P6;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void a5() {
        LinearLayout linearLayout = this.h6;
        if (linearLayout == null || this.r) {
            return;
        }
        linearLayout.setVisibility(0);
        if (q3()) {
            return;
        }
        u5();
    }

    private void b4() {
        TextView textView = this.z7;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void b5() {
        ImageView imageView = this.Y6;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    private void c4() {
        ImageView imageView = this.m8;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void c5() {
        TextView textView = this.b6;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.a6;
        if (textView2 != null && textView2.getVisibility() != 0) {
            this.a6.setMaxLines(3);
            this.a6.setSingleLine(false);
            this.a6.setVisibility(0);
        }
        r5();
        if (q3()) {
            return;
        }
        u5();
    }

    private void d4() {
        ImageView imageView = this.l8;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void d5() {
        ImageView imageView = this.N6;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (this.s) {
            M4();
            L4();
        }
    }

    private void e4() {
        ImageView imageView = this.C6;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void e5() {
        ImageView imageView = this.u7;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    private void f3() {
        SDKViewHistoryMgr sDKViewHistoryMgr = new SDKViewHistoryMgr();
        AddViewHistoryReq addViewHistoryReq = new AddViewHistoryReq();
        addViewHistoryReq.columncode = this.n1;
        addViewHistoryReq.contentcode = this.k1;
        addViewHistoryReq.contentname = this.f1;
        LogEx.d("PlayerFragment", "addViewHistory req columncode " + addViewHistoryReq.columncode + " contentcode " + addViewHistoryReq.contentcode + " contentname " + addViewHistoryReq.contentname);
        sDKViewHistoryMgr.doAddViewHistory(addViewHistoryReq.toHashMap(), new w(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f4() {
        RelativeLayout relativeLayout = this.x7;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    private void f5() {
        LinearLayout linearLayout = this.C8;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            u5();
        }
    }

    private void g3() {
        LogEx.d("PlayerFragment", "mSoundEnabled:" + this.I7);
        if (this.I7) {
            this.r7.setImageDrawable(getResources().getDrawable(R.drawable.player_sound_normal));
            this.M6.setImageDrawable(getResources().getDrawable(R.drawable.player_sound_normal));
            this.K6.b(this.G7);
            this.o7.b(this.G7);
            this.S3.setStreamVolume(3, this.G7, 0);
            return;
        }
        this.r7.setImageDrawable(getResources().getDrawable(R.drawable.player_sound_mute));
        this.M6.setImageDrawable(getResources().getDrawable(R.drawable.player_sound_mute));
        this.G7 = this.S3.getStreamVolume(3);
        LogEx.d("PlayerFragment", "mVolume:" + this.G7);
        this.K6.b(0);
        this.o7.b(0);
        this.S3.setStreamVolume(3, 0, 0);
    }

    private void g4() {
        com.zte.iptvclient.android.common.customview.a.a.e.l lVar = new com.zte.iptvclient.android.common.customview.a.a.e.l(this.f4977b, false);
        this.t7 = lVar;
        lVar.a(new e());
        this.g6 = new com.zte.iptvclient.android.mobile.a0.a.e.b(this.f4977b.getApplicationContext(), this.i1);
        u4();
        this.f6.setAdapter((ListAdapter) this.g6);
    }

    private void g5() {
        LinearLayout linearLayout;
        if (q3() && this.t5 != null && this.f != null && this.Y5 != null && (linearLayout = this.c0) != null && linearLayout.getVisibility() != 0) {
            LogEx.d("PlayerFragment", " mRlayoutFullScreenControl.setVisibility(View.VISIBLE)!!!");
            this.f.setVisibility(0);
            this.Y5.setVisibility(0);
            this.t5.setVisibility(0);
            this.f.requestLayout();
        }
        if (q3()) {
            e4();
        }
    }

    private void h3() {
        int a2;
        int a3;
        int a4;
        int a5;
        if (BaseApp.f()) {
            if (this.A) {
                if (com.zte.iptvclient.android.common.k.g.d()) {
                    a4 = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 540.0f);
                    a5 = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 304.0f);
                } else {
                    a4 = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 740.0f);
                    a5 = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 418.0f);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a4, a5);
                layoutParams.addRule(13);
                this.t0.setLayoutParams(layoutParams);
                this.X7.setLayoutParams(layoutParams);
                return;
            }
            if (com.zte.iptvclient.android.common.k.g.d()) {
                a2 = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 270.0f);
                a3 = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 152.0f);
            } else {
                a2 = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 370.0f);
                a3 = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 209.0f);
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a2, a3);
            layoutParams2.addRule(13);
            this.t0.setLayoutParams(layoutParams2);
            this.X7.setLayoutParams(layoutParams2);
            return;
        }
        if (this.A) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.zte.iptvclient.android.common.k.g.a(this.f4977b, 443.0f), com.zte.iptvclient.android.common.k.g.a(this.f4977b, 250.0f));
            layoutParams3.addRule(13);
            this.t0.setLayoutParams(layoutParams3);
            this.X7.setLayoutParams(layoutParams3);
            return;
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.zte.iptvclient.android.common.k.g.a(this.f4977b, 248.0f), com.zte.iptvclient.android.common.k.g.a(this.f4977b, 140.0f));
        layoutParams4.addRule(13);
        this.t0.setLayoutParams(layoutParams4);
        this.X7.setLayoutParams(layoutParams4);
    }

    private boolean h4() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.M7 <= DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS) {
            LogEx.w("UseeTv", "Operate limit,less than 5000(ms)!");
            return true;
        }
        this.M7 = currentTimeMillis;
        return false;
    }

    private void h5() {
        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        if (!q3() || (relativeLayout = this.g) == null || relativeLayout.getVisibility() == 0 || (linearLayout = this.c0) == null || linearLayout.getVisibility() == 0) {
            return;
        }
        LogEx.d("PlayerFragment", " mRlayoutSmallScreenControl.setVisibility(View.VISIBLE)!!!");
        this.g.setVisibility(0);
        this.g.requestLayout();
    }

    private void i3() {
        k(true);
        W0();
        if (this.B && this.A) {
            i0();
        }
        U0();
        b.a0 a0Var = this.L3;
        if (a0Var != null) {
            a0Var.q("2");
        }
    }

    private void i4() {
        Bundle bundle = this.V0;
        LogEx.d("PlayerFragment", "contentcode:" + bundle.getString("contentcode", "") + ", ratingid:" + bundle.getString("ratingid", ""));
        if (h4()) {
            return;
        }
        i3();
    }

    private void i5() {
        TextView textView = this.y7;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3() {
        LogEx.d("PlayerFragment", "controlMediaSurface!!!");
        if (this.A) {
            RelativeLayout relativeLayout = this.f;
            if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                LogEx.d("PlayerFragment", "showMediaController!!!");
                f0();
            } else {
                E();
            }
            FrameLayout frameLayout = this.r5;
            if (frameLayout == null || frameLayout.getVisibility() != 0) {
                return;
            }
            this.r5.setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout2 = this.g;
        if (relativeLayout2 != null && relativeLayout2.getVisibility() != 0) {
            LogEx.d("PlayerFragment", "showMediaController!!!");
            f0();
        } else {
            E();
        }
    }

    private void j4() {
        Bundle bundle = this.V0;
        LogEx.d("PlayerFragment", "contentcode:" + bundle.getString("contentcode", "") + ", ratingid:" + bundle.getString("ratingid", ""));
        if (h4()) {
            return;
        }
        y5();
    }

    private void j5() {
        if (this.x8 == null || this.r) {
            return;
        }
        LogEx.d("PlayerFragment", "###showPlayerErrorLayout");
        this.x8.setVisibility(0);
        if (q3()) {
            return;
        }
        u5();
    }

    private void k3() {
        int[] iArr = new int[2];
        this.s7.getLocationInWindow(iArr);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.J6.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = iArr[0];
        }
        if (this.J6.getVisibility() == 4) {
            this.J6.setVisibility(0);
            if (this.V3 == null) {
                this.V3 = new h();
            }
            this.a4.postDelayed(this.V3, 2000L);
            if (this.I7) {
                return;
            }
            this.I7 = true;
            g3();
            return;
        }
        this.I7 = !this.I7;
        g3();
    }

    private void k4() {
        Bundle bundle = this.V0;
        LogEx.d("PlayerFragment", "orderVod bundle=" + bundle.toString());
        if (h4()) {
            return;
        }
        LogEx.d("PlayerFragment", "ratingid:" + bundle.getString("ratingid", ""));
        A5();
    }

    private void k5() {
        LinearLayout linearLayout = this.Z6;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        LinearLayout linearLayout2 = this.B7;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
    }

    private void l3() {
        if (this.x7.getVisibility() == 4) {
            v5();
            if (this.W3 == null) {
                this.W3 = new i();
            }
            this.a4.postDelayed(this.W3, 2000L);
            if (this.I7) {
                return;
            }
            this.I7 = true;
            g3();
            return;
        }
        this.I7 = !this.I7;
        g3();
    }

    private void l4() {
        d3();
        t("");
        g0();
    }

    private void l5() {
        TextView textView = this.G6;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    private void m3() {
        com.zte.iptvclient.android.common.customview.a.a.b.b bVar = this.o8;
        if (bVar != null) {
            bVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.c cVar = this.p8;
        if (cVar != null) {
            cVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.d dVar = this.n8;
        if (dVar != null) {
            dVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.a aVar = this.q8;
        if (aVar != null) {
            aVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.e.l lVar = this.t7;
        if (lVar != null) {
            lVar.dismiss();
        }
    }

    private void m4() {
        LogEx.d("PlayerFragment", "###showLoading()");
        L2();
        Q();
    }

    private void m5() {
        ProgressBar progressBar = this.V5;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    private void n3() {
        i2();
        j2();
        LinearLayout linearLayout = this.I6;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        TextView textView = this.H6;
        if (textView != null) {
            textView.setVisibility(8);
        }
        o2();
    }

    private void n4() {
        this.F7 = new p0(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        this.f4977b.registerReceiver(this.F7, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n5() {
        this.p = true;
        W0();
        if (this.R7 == null) {
            this.R7 = new com.zte.iptvclient.android.common.player.multiplay.c(this.f4977b, this.Q7, this.T, this.A && !this.B, this, this.q1);
        } else {
            this.Q7.setVisibility(0);
            this.R7.b();
            new Handler().postDelayed(new p(), 10000L);
        }
        this.R7.a(new q(this));
        this.i0 = false;
        V1();
        this.s0 = false;
        com.zte.iptvclient.android.common.player.multiplay.c cVar = this.R7;
        if (cVar != null) {
            cVar.a(this.A);
        }
    }

    private void o3() {
        A();
        a.h hVar = this.j0;
        if (hVar != null) {
            hVar.a();
        }
        LogEx.d("PlayerFragment", "###hideLoading()");
        a2();
        if (!this.k7.b0().booleanValue()) {
            LogEx.d("PlayerFragment", "need login");
            M2();
        } else {
            b2();
            a.h hVar2 = this.j0;
            if (hVar2 != null) {
                hVar2.a();
            }
            LogEx.d("PlayerFragment", "###hideLoading()");
            a2();
            X1();
            if ("1".equals(this.T) || "10".equals(this.T) || "14".equals(this.T)) {
                k(true);
                if (this.B && this.A) {
                    i0();
                }
            }
            D3();
            this.b6.setText(R.string.order);
            this.a6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.premium_tips));
            O2();
            this.h0 = true;
        }
        i(0);
    }

    private void o4() {
        TextView textView = this.B8;
        if (textView != null) {
            textView.setText("");
        }
    }

    private void o5() {
        ImageView imageView = this.Q6;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    private void p3() {
        d2();
        this.h0 = false;
        Q4();
        if (!this.A) {
            J2();
        }
        if (!this.k7.b0().booleanValue()) {
            this.b7.setText(R.string.play_activity_login);
            this.D7.setText(R.string.play_activity_login);
        } else {
            this.b7.setText(R.string.order);
            this.D7.setText(R.string.order);
        }
        if ("1".equals(this.T)) {
            R("1");
            return;
        }
        if (!"10".equals(this.T) && !"14".equals(this.T)) {
            if ("2".equals(this.T) || "4".equals(this.T)) {
                R("2");
                return;
            }
            return;
        }
        int i2 = this.U1;
        int i3 = this.E3;
        if (i2 <= i3) {
            R("1");
        } else {
            i(i3);
        }
    }

    private void p4() {
        ArrayList<String> arrayList = this.b1;
        if (arrayList != null && arrayList.size() > 1) {
            com.zte.iptvclient.android.common.player.h hVar = new com.zte.iptvclient.android.common.player.h(this.f4977b.getApplicationContext(), this.b1, this.n0);
            this.c5 = hVar;
            hVar.a(new n());
        }
        com.zte.iptvclient.android.common.player.h hVar2 = this.c5;
        if (hVar2 == null) {
            return;
        }
        if (hVar2.isShowing()) {
            this.c5.dismiss();
            return;
        }
        int[] iArr = new int[2];
        this.X6.getLocationInWindow(iArr);
        this.c5.a(this.b1, this.n0, this.c1, this.f, 83, iArr[0] - com.zte.iptvclient.android.common.k.g.a(this.f4977b, 22.0f), this.A6.getHeight() + this.X6.getHeight() + com.zte.iptvclient.android.common.k.g.a(this.f4977b, 8.0f));
    }

    private void p5() {
        ImageView imageView = this.A7;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    private boolean q3() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        RelativeLayout relativeLayout;
        LinearLayout linearLayout4;
        RelativeLayout relativeLayout2;
        ImageView imageView;
        LinearLayout linearLayout5 = this.c0;
        boolean z2 = (linearLayout5 == null || linearLayout5.getVisibility() != 0) && ((linearLayout = this.x8) == null || linearLayout.getVisibility() != 0) && (((linearLayout2 = this.h6) == null || linearLayout2.getVisibility() != 0) && (((linearLayout3 = this.k6) == null || linearLayout3.getVisibility() != 0) && (((relativeLayout = this.F0) == null || relativeLayout.getVisibility() != 0) && (((linearLayout4 = this.C8) == null || linearLayout4.getVisibility() != 0) && (((relativeLayout2 = this.Z5) == null || relativeLayout2.getVisibility() != 0) && ((imageView = this.G8) == null || imageView.getVisibility() != 0))))));
        LogEx.d("PlayerFragment", "enableShowPlayContralView " + z2);
        return z2;
    }

    private void q4() {
        com.zte.iptvclient.android.common.player.h hVar = this.c5;
        if (hVar == null) {
            return;
        }
        if (hVar.isShowing()) {
            this.c5.dismiss();
            return;
        }
        int[] iArr = new int[2];
        this.w7.getLocationInWindow(iArr);
        int i2 = iArr[0];
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f4977b.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        a.i iVar = this.N;
        if (iVar != null) {
            this.c5.a(this.b1, this.n0, this.c1, this.g, 83, i2, (displayMetrics.heightPixels - (iVar.e() + this.N.i())) + this.n7.getHeight());
        }
    }

    private void q5() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Support_Multitrack");
        LogEx.d("PlayerFragment", "Support_Multitrack=" + c2);
        p2();
        S1();
        I3();
        if ("1".equals(c2)) {
            X4();
            ArrayList<String> arrayList = new ArrayList<>();
            this.L.getSubtitleInfoArray(arrayList);
            LogEx.d("PlayerFragment", "Multitrack getMulitSubtitle = " + arrayList);
            if (arrayList.size() <= 0) {
                p2();
            } else if (TextUtils.isEmpty(arrayList.get(0))) {
                p2();
            } else {
                W2();
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            this.L.getAudioInfoArray(arrayList2);
            LogEx.d("PlayerFragment", "Multitrack  getMulitAudioTrunk = " + arrayList2);
            if (arrayList2.size() == 0) {
                S1();
                V4();
            } else if (arrayList2.size() > 0 && TextUtils.isEmpty(arrayList2.get(0))) {
                S1();
                V4();
            } else {
                E2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int r3() {
        try {
            return Integer.parseInt(SDKLoginMgr.getInstance().getPropertiesInfo(PortalConst.PAUSE_AD_LOOP_INTERVAL));
        } catch (Exception unused) {
            return 3;
        }
    }

    private void r4() {
        com.zte.iptvclient.android.common.player.b bVar = this.a5;
        if (bVar != null && bVar.isShowing()) {
            this.a5.dismiss();
            return;
        }
        if (this.a5 == null) {
            com.zte.iptvclient.android.common.player.b bVar2 = new com.zte.iptvclient.android.common.player.b(this.f4977b.getApplicationContext(), this.L);
            this.a5 = bVar2;
            bVar2.a(new l());
        }
        int[] iArr = new int[2];
        this.V6.getLocationInWindow(iArr);
        this.a5.a(this.f, 83, iArr[0] - com.zte.iptvclient.android.common.k.g.a(this.f4977b, 22.0f), this.A6.getHeight() + this.T6.getHeight() + com.zte.iptvclient.android.common.k.g.a(this.f4977b, 8.0f), AssetType.Asset_Audio);
    }

    private void r5() {
        RelativeLayout relativeLayout = this.Z5;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    private Intent s3() {
        Intent intent = new Intent();
        if ("1".equals(this.T)) {
            intent.putExtra("breakpoint", String.valueOf(((int) this.x3) / 1000));
        } else if ("10".equals(this.T) || "15".equals(this.T)) {
            intent.putExtra("curepisode", this.U1);
            intent.putExtra("breakpoint", String.valueOf(((int) this.x3) / 1000));
        }
        if (!this.B) {
            intent.putExtra("needLogin", true);
            intent.setClass(this.f4977b, MainActivity.class);
        }
        return intent;
    }

    private void s4() {
        i2();
        j2();
        c4();
        d4();
        Y1();
    }

    private void s5() {
        TextView textView = this.P6;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    private void t3() {
        Device b2 = com.zte.iptvclient.android.mobile.h.a.a.g().b();
        if (b2 == null) {
            this.H6.setText(R.string.toast_nostb);
            return;
        }
        SharedPreferences sharedPreferences = this.f4977b.getSharedPreferences("stbcachefile", 0);
        String friendlyName = b2.getFriendlyName();
        if (friendlyName == null) {
            friendlyName = b2.getMacAddress();
        }
        if (friendlyName == null) {
            friendlyName = "";
        }
        this.H6.setText(sharedPreferences.getString(b2.getUDN(), friendlyName));
    }

    private void t4() {
        if (this.L != null) {
            S1();
            ArrayList<String> arrayList = new ArrayList<>();
            this.L.getAudioInfoArray(arrayList);
            LogEx.d("PlayerFragment", "Multitrack  getMulitAudioTrunk = " + arrayList);
            if (arrayList.size() > 0) {
                if (TextUtils.isEmpty(arrayList.get(0))) {
                    return;
                }
                int b2 = b(arrayList);
                LogEx.d("PlayerFragment", "Multitrack  mSelectedAudioIndex = " + b2);
                if (b2 < arrayList.size()) {
                    E2();
                    this.L.selectAudioByIndex(b2);
                    return;
                }
                return;
            }
            LogEx.e("PlayerFragment", "Multitrack  getMulitAudioTrunk is null! ");
        }
    }

    private void t5() {
        TextView textView = this.z7;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    private void u3() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f4977b.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.t8 = displayMetrics.widthPixels;
        this.u8 = displayMetrics.heightPixels;
        LogEx.d("PlayerFragment", "mScreenWidth : " + this.t8 + " , mScreenHeight : " + this.u8);
    }

    private void u4() {
        if (this.i1 != null) {
            if (TextUtils.isEmpty(this.E0)) {
                for (int i2 = 0; i2 < this.i1.size(); i2++) {
                    if (this.p5.size() > 0 && this.p5.get(0) != null && TextUtils.equals(this.p5.get(0).d(), this.i1.get(i2).getChannelcode())) {
                        this.g6.a(i2);
                        return;
                    }
                }
                return;
            }
            for (int i3 = 0; i3 < this.i1.size(); i3++) {
                if (TextUtils.equals(this.E0, this.i1.get(i3).getChannelcode())) {
                    this.g6.a(i3);
                    return;
                }
            }
        }
    }

    private void u5() {
        if (this.A) {
            if (this.C6 == null) {
                return;
            }
            if (this.f.getVisibility() != 0) {
                this.C6.setVisibility(0);
                LogEx.d("PlayerFragment", "skipToFullScreen mImgUncommonBack.setVisibility(View.VISIBLE)!!!");
            } else {
                LogEx.d("PlayerFragment", "unable show showUncommonBack ");
            }
        } else {
            e4();
        }
        com.zte.iptvclient.android.common.player.b bVar = this.a5;
        if (bVar != null && bVar.isShowing()) {
            this.a5.dismiss();
        }
        com.zte.iptvclient.android.common.player.b bVar2 = this.b5;
        if (bVar2 == null || !bVar2.isShowing()) {
            return;
        }
        this.b5.dismiss();
    }

    private void v3() {
        RelativeLayout relativeLayout = this.S7;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v4() {
        LogEx.d("PlayerFragment", "setFullChannelListViewBtn=" + this.T);
        if (!"2".equals(this.T)) {
            z3();
        } else {
            M4();
        }
    }

    private void v5() {
        RelativeLayout relativeLayout = this.x7;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    private void w3() {
        ImageView imageView = this.B6;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w4() {
        if (this.R5 && !this.r && !"ivi".equals(this.n0) && !"Megogo".equals(this.n0)) {
            ArrayList<Feature> d2 = com.zte.iptvclient.android.common.j.c.e().d();
            LogEx.d("PlayerFragment", "STR_INTERACTIVE_WITH_STB " + com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_INTERACTIVE_WITH_STB) + " " + d2.size());
            if ("1".equals(com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_INTERACTIVE_WITH_STB)) && d2.size() > 0 && !com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.j(true));
                LogEx.d("PlayerFragment", "showPushStbFull");
                S2();
                this.L6.setImageDrawable(this.f4977b.getResources().getDrawable(R.drawable.play_push_new));
                this.L6.setEnabled(true);
                this.q7.setImageDrawable(this.f4977b.getResources().getDrawable(R.drawable.play_push_new));
                this.q7.setEnabled(true);
                this.I6.setEnabled(true);
                this.s7.setEnabled(true);
                this.s7.setImageDrawable(this.f4977b.getResources().getDrawable(R.drawable.player_small_stb_select));
                return;
            }
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.j(false));
            i2();
            j2();
            o2();
            return;
        }
        LogEx.d("PlayerFragment", "current playbundles seted not support push");
        i2();
        j2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w5() {
        if (this.B) {
            if (C() != null) {
                C().onActivityResult(20, 0, s3());
            }
        } else if (TextUtils.equals("MultiPlayActivity", this.v5)) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.b("1"));
        }
        if (this.f4977b instanceof MainActivity) {
            W0();
            U0();
        }
    }

    private void x3() {
        if (this.e6 != null) {
            this.c6.setVisibility(8);
            this.e6.setVisibility(8);
        }
    }

    private void x4() {
        N4();
        l5();
        K2();
        T2();
        U2();
        R2();
        s5();
        i5();
        t5();
        d5();
        W3();
        e5();
        X3();
        if (this.F1) {
            if (this.T1 != 0) {
                this.w0.setEnabled(false);
                LogEx.d("PlayerFragment", "mSeekBarProgressSmall.setEnabled(false)");
                this.v0.setEnabled(false);
                this.N6.setEnabled(false);
                this.u7.setEnabled(false);
            } else {
                this.w0.setEnabled(this.K);
                LogEx.d("PlayerFragment", "mSeekBarProgressSmall.setEnabled()" + this.K);
                this.v0.setEnabled(this.K);
                this.N6.setEnabled(this.K);
                this.u7.setEnabled(this.K);
            }
            if (!this.m && !this.l) {
                d5();
                W3();
                e5();
                X3();
                R3();
                h2();
            } else {
                d5();
                o5();
                R2();
                i5();
                e5();
                p5();
            }
            if (this.n) {
                R2();
                i5();
            }
        } else {
            if (this.s) {
                this.N6.setEnabled(false);
                this.u7.setEnabled(false);
                this.w0.setEnabled(false);
                LogEx.d("PlayerFragment", "mSeekBarProgressSmall.setEnabled(false)");
                this.v0.setEnabled(false);
            } else {
                this.N6.setEnabled(this.K);
                this.u7.setEnabled(this.K);
                this.w0.setEnabled(this.K);
                LogEx.d("PlayerFragment", "mSeekBarProgressSmall.setEnabled()" + this.K);
                this.v0.setEnabled(this.K);
            }
            h2();
            R3();
        }
        if (this.O5) {
            s4();
        }
    }

    private void x5() {
        LogEx.d("PlayerFragment", "subscribeHintView");
        if (this.A) {
            i0();
        }
        if (!this.k7.b0().booleanValue()) {
            w5();
            return;
        }
        if (!"1".equals(this.T) && !"10".equals(this.T) && !"14".equals(this.T)) {
            if ("2".equals(this.T)) {
                i4();
                return;
            } else {
                if ("4".equals(this.T)) {
                    j4();
                    return;
                }
                return;
            }
        }
        k4();
    }

    private void y3() {
        LinearLayout linearLayout = this.c6;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    private void y4() {
        LogEx.d("PlayerFragment", "setMainPanelNoLive");
        U2();
        R2();
        s5();
        d5();
        LogEx.d("PlayerFragment", "IvPauseFull.setEnabled(true)");
        this.N6.setEnabled(true);
        this.w0.setEnabled(true);
        this.v0.setEnabled(true);
        T2();
        K2();
        U2();
        i5();
        t5();
        e5();
        this.u7.setEnabled(true);
        if (this.O5) {
            s4();
        }
    }

    private void y5() {
        k(true);
        W0();
        if (this.B && this.A) {
            i0();
        }
        U0();
        b.a0 a0Var = this.L3;
        if (a0Var != null) {
            a0Var.q("4");
        }
    }

    private void z3() {
        if (this.d6 != null) {
            this.c6.setVisibility(8);
            this.d6.setVisibility(8);
        }
    }

    private void z4() {
        LogEx.d("PlayerFragment", "text Play setOrderAndMultiRatesParametersWhenAuthThroughFailed");
        if (!DownloadConstant.REPORT_MSGTYPE_ADD.equals(this.c1) && !DownloadConstant.REPORT_MSGTYPE_URL_NULL.equals(this.c1)) {
            if (this.E3 > 0) {
                LogEx.d("PlayerFragment", "text Play doSomeWorkWhenSupportPreviewWatch");
                p3();
            } else {
                LogEx.d("PlayerFragment", "text Play doSomeWorkWhenNotSupportPreviewWatch");
                o3();
            }
        } else {
            d2();
            this.h0 = false;
            Q4();
            if (!this.A) {
                J2();
            }
            T3();
            Z3();
        }
        n3();
    }

    private void z5() {
        Activity activity;
        if (!q3() || this.Q5 || this.T1 != 0 || (activity = this.f4977b) == null) {
            return;
        }
        this.Q5 = activity.getSharedPreferences("gesture_help", 0).getBoolean("first_in", false);
        LogEx.d("PlayerFragment", "updateFistPlayRecored ");
        R4();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void A0() {
        this.Z8.sendEmptyMessageDelayed(4, 500L);
    }

    public void A2() {
        this.T1 = 0;
        this.J1 = true;
        v1();
        LogEx.d("PlayerFragment", "###showLoading()");
        n1();
        this.N6.setEnabled(true);
        this.u7.setEnabled(true);
        this.w0.setEnabled(true);
        this.v0.setEnabled(true);
        LogEx.d("PlayerFragment", "mSeekBarProgressSmall.setEnabled(true)");
        if (this.E3 > 0) {
            if (!"10".equals(this.T) && !"14".equals(this.T)) {
                X0();
                return;
            }
            if (this.J) {
                h0();
                H();
                z1();
                return;
            } else if (DownloadConstant.REPORT_MSGTYPE_ADD.equals(this.d1) && !DownloadConstant.REPORT_MSGTYPE_ADD.equals(this.c1) && N0()) {
                j(true);
                this.L1 = true;
                return;
            } else {
                Q();
                return;
            }
        }
        if (this.J) {
            if ("10".equals(this.T) || "14".equals(this.T)) {
                D1();
            }
            h0();
            H();
            z1();
            return;
        }
        if ("2".equals(this.T)) {
            j0();
        } else {
            z1();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    public void B0() {
        if (this.s) {
            this.f6.setVisibility(8);
            this.K7 = false;
            if (this.A) {
                if (this.i0) {
                    L4();
                    M4();
                }
            } else {
                y3();
                z3();
            }
            if ("2".equals(this.T)) {
                return;
            }
            z3();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03df  */
    @Override // com.zte.iptvclient.android.common.player.k.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void B1() {
        /*
            Method dump skipped, instructions count: 1032
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.player.k.c.B1():void");
    }

    public void B2() {
        if (this.e0) {
            a((MainActivity) this.f4977b);
            Z2();
            c3();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void C0() {
        super.C0();
        LinearLayout linearLayout = this.x8;
        if (linearLayout == null || linearLayout.getVisibility() != 0) {
            return;
        }
        S3();
        LinearLayout linearLayout2 = this.h6;
        if (linearLayout2 == null || linearLayout2.getVisibility() == 0) {
            return;
        }
        s0();
    }

    protected void C2() {
        this.l0 = true;
        if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            com.zte.iptvclient.android.common.k.t.a((Context) this.f4977b, false);
            return;
        }
        if (TextUtils.isEmpty(this.Z0)) {
            this.Z0 = this.L8;
        }
        if (com.zte.iptvclient.android.mobile.h.a.a.g().b() == null) {
            if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                if (this.A) {
                    i0();
                }
                com.zte.iptvclient.android.common.k.t.a(this.f4977b, new o(this));
                return;
            }
            this.J7 = true;
            if (this.A) {
                B4();
                return;
            } else {
                C4();
                return;
            }
        }
        String str = this.Z0;
        if (str.endsWith("breakpoint=")) {
            if (this.x3 < 0) {
                this.x3 = 0L;
            }
            if (this.m) {
                str = this.Z0 + ((this.y3 - this.x3) / 1000);
            } else if (!this.s) {
                str = this.Z0 + (this.x3 / 1000);
            }
        }
        LogEx.d("PlayerFragment", "sendPlay VOD_PLAY_URI_4_DLNA = " + str);
        if ("".equals(this.k7.J())) {
            com.zte.iptvclient.android.mobile.h.a.a.g().c(str);
            IBasePlayer iBasePlayer = this.M;
            if (iBasePlayer != null) {
                iBasePlayer.stop();
            }
            if ("1".equals(ConfigMgr.readPropertie("IsSupportCastScreen", "0"))) {
                com.zte.iptvclient.android.common.customview.a.a.e.l lVar = this.t7;
                if (lVar != null && lVar.isShowing()) {
                    this.t7.dismiss();
                }
                n5();
                return;
            }
            return;
        }
        W0();
        T4();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    public void D0() {
        f2();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void D1() {
        M3();
        if ((this.T1 == 0 || this.E3 > 0) && this.U1 < this.V1) {
            b5();
        }
    }

    public void D2() {
        if (!this.A) {
            k(true);
        } else {
            k(false);
        }
        this.s0 = false;
        O3();
        R3();
        b4();
        t2();
        o2();
        X1();
        J3();
        G0();
        N3();
        H3();
        s2();
        i2();
        j2();
        I3();
        h2();
        a4();
        A3();
        U3();
        c4();
        d4();
        c2();
        Y3();
        W1();
        d2();
        Z3();
        b2();
        k2();
        l2();
        g2();
        B3();
        S3();
        r2();
        C0();
        e2();
        u5();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void E0() {
        this.Z8.sendEmptyMessageDelayed(1, 500L);
    }

    public void E1() {
        this.s0 = true;
    }

    protected void E2() {
        V4();
        ImageView imageView = this.V6;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void F0() {
        this.Z8.sendEmptyMessageDelayed(5, 500L);
    }

    public void F1() {
        if (this.e0) {
            E3();
            this.e0 = false;
            d3();
            Activity activity = this.f4977b;
            if (activity instanceof MainActivity) {
                ((MainActivity) activity).b(0);
                ((MainActivity) this.f4977b).v();
            }
        }
    }

    public void F2() {
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void G0() {
        RelativeLayout relativeLayout = this.h7;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    public void G1() {
        com.zte.iptvclient.android.common.player.multiplay.c cVar = this.R7;
        if (cVar == null || !this.l0) {
            return;
        }
        cVar.c();
    }

    public void G2() {
        D0();
        Z1();
        F();
        e2();
        b2();
        r2();
        if (this.m6 != null) {
            LogEx.d("PlayerFragment", "showBackToVideoLayout");
            this.r = true;
            this.m6.setVisibility(0);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void H0() {
        this.Z8.sendEmptyMessageDelayed(2, 500L);
    }

    public void H1() {
        Activity activity = this.f4977b;
        if (activity instanceof MainActivity) {
            ((MainActivity) activity).b(0);
        }
        J2();
    }

    public void H2() {
        if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
            com.bumptech.glide.d<Integer> a2 = com.bumptech.glide.i.b(BaseApp.e().getApplicationContext()).a(Integer.valueOf(R.drawable.default_blackout));
            a2.b(R.drawable.default_blackout);
            a2.a(R.drawable.default_blackout);
            a2.a(this.D0);
            this.F0.setVisibility(0);
            com.zte.iptvclient.android.common.f.b.b.j().a(true);
        }
    }

    public String I1() {
        return this.u;
    }

    protected void I2() {
        ImageView imageView = this.j7;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public String J1() {
        return this.D1;
    }

    public void J2() {
        ImageView imageView;
        if ("0".equals(ConfigMgr.readPropertie("ShowFloatingPlayBtn"))) {
            X1();
            return;
        }
        int i2 = this.U;
        if (i2 == this.W || i2 == this.X || i2 == this.Y || (imageView = this.H7) == null) {
            return;
        }
        imageView.setVisibility(0);
    }

    public String K1() {
        return this.p1;
    }

    protected void K2() {
        ImageView imageView = this.p7;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public String L1() {
        return this.q1;
    }

    public void L2() {
        if (!com.zte.iptvclient.android.mobile.n.c.b.t() && !this.r && !this.P5) {
            LogEx.d("PlayerFragment", "###showLoading return");
            N2();
            return;
        }
        F();
        B3();
        d2();
        L3();
        E();
        v3();
        G3();
        Z1();
        if (this.c0 == null || this.r) {
            return;
        }
        LogEx.d("PlayerFragment", "###showLoading");
        this.c0.setVisibility(0);
    }

    public String M1() {
        return this.g1;
    }

    protected void M2() {
        if (this.b6 != null && this.a6 != null) {
            LogEx.d("PlayerFragment", "###showLoginHint()");
            this.a6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.premium_login_tips));
            this.b6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.mine_login_or_register));
        }
        r5();
        if (q3()) {
            return;
        }
        u5();
    }

    public String N1() {
        return this.T;
    }

    public void N2() {
        if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
            b2();
            return;
        }
        LogEx.d("PlayerFragment", "stopVideo showLoginToPlayView");
        m0();
        E();
        C0();
        B3();
        D0();
        F();
        e2();
        Z1();
        LogEx.d("PlayerFragment", "hideBackToVideoLayout");
        U1();
        LogEx.d("PlayerFragment", "###hideLoading()");
        a2();
        M2();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    public boolean O0() {
        com.zte.iptvclient.android.common.customview.a.a.e.l lVar = this.t7;
        return lVar != null && lVar.isShowing();
    }

    public long O1() {
        return this.x3;
    }

    protected void O2() {
        TextView textView = this.a6;
        if (textView != null && textView.getVisibility() != 0) {
            this.a6.setLines(1);
            this.a6.setSingleLine();
            this.a6.setVisibility(0);
        }
        TextView textView2 = this.b6;
        if (textView2 != null && textView2.getVisibility() != 0) {
            this.b6.setVisibility(0);
        }
        r5();
        if (q3()) {
            return;
        }
        u5();
    }

    public long P1() {
        return this.C0;
    }

    public void P2() {
        TextView textView = this.l6;
        if (textView != null && !this.r) {
            textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.play_concurrency_max));
        }
        O4();
        if (q3()) {
            return;
        }
        u5();
    }

    public boolean Q1() {
        return this.F0.getVisibility() == 0;
    }

    public void Q2() {
        o4();
        g0();
    }

    public boolean R1() {
        return this.U == this.Z;
    }

    protected void R2() {
        TextView textView = this.O6;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    protected void S1() {
        ImageView imageView = this.V6;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    protected void S2() {
        ImageView imageView = this.L6;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    public void T0() {
        super.T0();
        this.f4977b.runOnUiThread(new l0());
    }

    public void T1() {
    }

    protected void T2() {
        if (this.v0 != null) {
            LogEx.d("PlayerFragment", "showSeekBarProgressSmall");
            this.v0.setVisibility(0);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void U0() {
        this.Z8.removeCallbacks(this.a9);
        RelativeLayout relativeLayout = this.X7;
        if (relativeLayout != null) {
            relativeLayout.removeView(this.i8);
            this.X7.setVisibility(8);
            LogEx.d("onAdImageHide", "onAdImageHide");
        }
    }

    public void U1() {
        if (this.m6 != null) {
            LogEx.d("PlayerFragment", "hideBackToVideoLayout");
            this.r = false;
            this.m6.setVisibility(8);
        }
    }

    protected void U2() {
        SeekBar seekBar = this.w0;
        if (seekBar != null) {
            seekBar.setVisibility(0);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void V0() {
        this.G0 = true;
        P3();
        Q3();
        if (!TextUtils.isEmpty(this.Y4)) {
            this.u0 = true;
            h3();
            this.t0.setVisibility(0);
            this.a8.setVisibility(4);
            this.Z7 = false;
            this.Y7.setImageDrawable(getResources().getDrawable(R.drawable.icon_open_voice));
            a((View) this.i, false);
            this.v0.setEnabled(false);
            this.w0.setEnabled(false);
            this.s0 = false;
            this.T6.setVisibility(8);
            this.t0.bringToFront();
            b3();
            return;
        }
        if (com.zte.iptvclient.android.common.k.f.a(this.X4)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.X4.size(); i2++) {
            ImageView imageView = new ImageView(this.f4977b);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            arrayList.add(imageView);
        }
        if (this.i8 == null) {
            this.i8 = new ViewPager(this.f4977b);
        }
        this.i8.a(new b(this, arrayList));
        this.i8.setOnTouchListener(new ViewOnTouchListenerC0151c());
        this.i8.d(new d(arrayList));
        this.i8.d(0);
        if (arrayList.size() > 1) {
            this.Z8.postDelayed(this.a9, r3() * 1000);
        }
        this.X7.removeAllViews();
        this.X7.setVisibility(0);
        h3();
        this.X7.addView(this.i8);
    }

    protected void V1() {
        if (this.K7 || this.c6 == null) {
            return;
        }
        y3();
        z3();
    }

    public void V2() {
        this.S8.setVisibility(0);
    }

    protected void W1() {
        ImageView imageView = this.j7;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    protected void W2() {
        V4();
        ImageView imageView = this.U6;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void X1() {
        ImageView imageView = this.H7;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void X2() {
        com.zte.iptvclient.android.common.customview.a.a.a.a aVar = new com.zte.iptvclient.android.common.customview.a.a.a.a(getActivity());
        aVar.a(R.string.ts_feature_fail);
        aVar.setCancelable(false);
        aVar.b(R.string.common_ok, new a0());
        aVar.show();
    }

    protected void Y1() {
        ImageView imageView = this.p7;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    public void Y2() {
        TextView textView = this.l6;
        if (textView != null) {
            textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.please_unlock_tip));
        }
        O4();
        if (q3()) {
            return;
        }
        u5();
    }

    public void Z1() {
        RelativeLayout relativeLayout;
        if (!com.zte.iptvclient.android.common.f.b.b.j().e() || (relativeLayout = this.F0) == null) {
            return;
        }
        relativeLayout.setVisibility(8);
        this.F0.setBackgroundColor(Color.rgb(0, 0, 0));
    }

    public void Z2() {
        m(0);
    }

    public void a(n0 n0Var) {
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void a0() {
        String str;
        if ("1".equals(ConfigMgr.readPropertie("IsShowContentRank"))) {
            if (!TextUtils.isEmpty(this.B1) && TextUtils.equals(this.i4, "0")) {
                if ("1".equals(this.T) || "10".equals(this.T) || "15".equals(this.T)) {
                    int intValue = Integer.valueOf(this.B1).intValue();
                    if ((intValue & 16) > 0) {
                        n(5);
                    } else if ((intValue & 8) > 0) {
                        n(4);
                    } else if ((intValue & 4) > 0) {
                        n(3);
                    } else if ((intValue & 2) > 0) {
                        n(2);
                    } else if ((intValue & 1) > 0) {
                        n(1);
                    }
                    String c2 = com.zte.iptvclient.common.uiframe.a.c("Rank_Hint_Time");
                    if (TextUtils.isEmpty(c2)) {
                        str = "5000";
                    } else {
                        str = c2 + "000";
                    }
                    int parseInt = Integer.parseInt(str);
                    this.W8 = parseInt + Vr.VREvent.EventType.START_VR_LAUNCHER_COLD;
                    new Handler().postDelayed(new y(), parseInt);
                    super.a0();
                    return;
                }
                return;
            }
            C3();
        }
    }

    public void a2() {
        I4();
        if (this.c0 != null) {
            LogEx.d("PlayerFragment", "###hideLoading()");
            this.c0.setVisibility(8);
        } else {
            LogEx.d("PlayerFragment", "###hideLoading() is null");
        }
        e3();
    }

    protected void a3() {
        this.e0 = true;
        Bundle bundle = this.V0;
        bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, this.T1);
        bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, this.f2);
        bundle.putString("current_definition", this.c1);
        if (this.s) {
            if (this.m || this.l) {
                bundle.putBoolean("isTimeShifting", true);
                bundle.putLong("timeshifting_time", this.x3);
                bundle.putLong("timeshifting_duration", this.y3);
            }
        } else {
            bundle.putLong("playing_time", this.x3);
        }
        ArrayList<String> arrayList = this.l4;
        if (arrayList != null && arrayList.size() > 0) {
            bundle.putStringArrayList("middleAdsList", this.l4);
            bundle.putIntegerArrayList("middleAdsOffsetTimeList", this.H4);
            bundle.putIntegerArrayList("middleAdsTotalTimeList", this.E4);
            bundle.putIntegerArrayList("middleAdsSingleTimeList", this.r4);
            bundle.putIntegerArrayList("middleAdsPlayNumList", this.o4);
            bundle.putIntegerArrayList("middleAdsCloseTimeList", this.G4);
            bundle.putIntegerArrayList("middleAdsShowTimeList", this.J4);
        }
        ArrayList<String> arrayList2 = this.k4;
        if (arrayList2 != null && arrayList2.size() > 0) {
            bundle.putStringArrayList("afterAdsList", this.k4);
            bundle.putInt("afterAdsTotalTime", this.z4);
            bundle.putIntegerArrayList("afterAdsSingleTimeList", this.q4);
            bundle.putIntegerArrayList("afterAdsPlayNumList", this.n4);
            bundle.putInt("afterAdsCloseTime", this.F4);
            bundle.putString("afterAdsShowTime", this.I4);
        }
        PlayBackService.A0 = this;
        Intent intent = new Intent(this.f4977b.getApplicationContext(), (Class<?>) PlayBackService.class);
        intent.putExtras(bundle);
        this.f4977b.startService(intent);
        o0 o0Var = this.J8;
        if (o0Var != null) {
            o0Var.a(new com.zte.iptvclient.android.common.e.b());
        }
        if (this.f4977b instanceof MainActivity) {
            return;
        }
        R();
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void b0() {
        if (!TextUtils.equals(com.zte.iptvclient.common.uiframe.a.c("Support_Multitrack"), "0") && !"ivi".equals(this.n0) && !"Megogo".equals(this.n0)) {
            D4();
            t4();
        } else {
            p2();
            S1();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void b1() {
        List<com.zte.iptvclient.android.common.customview.view.imageview.a> list = this.L4;
        if (list != null) {
            list.clear();
        }
        RelativeLayout relativeLayout = this.X7;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        RelativeLayout relativeLayout2 = this.e8;
        if (relativeLayout2 != null) {
            relativeLayout2.removeAllViews();
        }
        RelativeLayout relativeLayout3 = this.f8;
        if (relativeLayout3 != null) {
            relativeLayout3.removeAllViews();
        }
        RelativeLayout relativeLayout4 = this.g8;
        if (relativeLayout4 != null) {
            relativeLayout4.removeAllViews();
        }
        RelativeLayout relativeLayout5 = this.h8;
        if (relativeLayout5 != null) {
            relativeLayout5.removeAllViews();
        }
        this.Y4 = "";
        q0();
    }

    protected void b2() {
        Z3();
    }

    protected void b3() {
        y();
        G();
        s(this.Y4);
        this.M0 = com.zte.iptvclient.android.common.k.s.b();
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void c0() {
        LogEx.d("PlayerFragment", "setMainPanel update");
        if (!this.s) {
            y4();
        } else {
            x4();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void c1() {
        super.c1();
        p2();
        S1();
    }

    protected void c2() {
        ImageView imageView = this.e7;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void c3() {
        IBasePlayer iBasePlayer = this.L;
        if (iBasePlayer == null || iBasePlayer.isPlaying()) {
            return;
        }
        this.L.start();
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void d0() {
        super.d0();
        if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
            com.zte.iptvclient.android.common.f.b.b.j().a(this);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void d1() {
        this.g6.notifyDataSetChanged();
    }

    protected void d2() {
        Z3();
        e4();
    }

    public void d3() {
        Activity activity;
        if (this.T.equals("10")) {
            u();
        }
        if (!this.y || this.f4977b == null || this.L == null) {
            return;
        }
        LogEx.d("PlayerFragment", "STOP PLAYER");
        if (com.zte.iptvclient.android.common.f.b.b.j().e() && (activity = this.f4977b) != null) {
            activity.runOnUiThread(new x());
        }
        m0();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b, com.zte.iptvclient.android.common.player.k.a
    protected void e0() {
        LogEx.d("PlayerFragment", "setPlayerContralViewVisible");
        Y4();
        N4();
        l5();
        m2();
        J2();
        if (this.A) {
            J4();
        }
        Y3();
        this.d8.setVisibility(4);
        this.c8.setVisibility(4);
        F4();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void e1() {
        super.e1();
        if (this.Y8 != null) {
            a((m0) null);
        }
        if (this.J8 != null) {
            this.J8 = null;
        }
    }

    public void e2() {
        TextView textView = this.l6;
        if (textView != null) {
            textView.setText("");
        }
        B3();
    }

    protected void e3() {
        if (this.O5) {
            S4();
        } else {
            G3();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    public void f0() {
        CheckBox checkBox;
        LogEx.d("PlayerFragment", "showMediaController!!!");
        if (this.G0) {
            this.G0 = false;
            return;
        }
        if (this.s5 && (checkBox = this.t5) != null) {
            if (checkBox.getVisibility() != 0) {
                LogEx.d("PlayerFragment", " mRlayoutFullScreenControl.setVisibility(View.VISIBLE)!!!");
                RelativeLayout relativeLayout = this.f;
                if (relativeLayout == null || this.Y5 == null) {
                    return;
                }
                relativeLayout.setVisibility(0);
                this.Y5.setVisibility(4);
                this.t5.setVisibility(0);
                this.f.requestLayout();
                return;
            }
            this.t5.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.t5;
        if (checkBox2 != null) {
            checkBox2.setChecked(this.s5);
        }
        Z4();
        if (this.A) {
            if (!"10".equals(this.T) || this.U1 >= this.V1 || this.U != this.V) {
                M3();
            }
            J4();
            g5();
            Q3();
            if (this.s) {
                M4();
                L4();
            }
        } else {
            V1();
            w3();
            h5();
            P3();
        }
        if (this.O5) {
            s4();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void f1() {
        this.d8.setClickable(false);
        LogEx.d("PlayerFragment", "Advertisiment mTvTimer setClickable(false)");
        this.d8.setTextColor(androidx.core.content.a.a(this.f4977b, R.color.close_ad_bg));
    }

    public void f2() {
        LinearLayout linearLayout = this.C8;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
            e4();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void g0() {
        super.g0();
        C1();
        E();
        V3();
        LogEx.d("PlayerFragment", "###hideLoading()");
        a2();
        B3();
        Z1();
        TextView textView = this.B8;
        if (textView != null && !textView.getText().toString().contains(com.zte.iptvclient.android.common.i.a.a.a(R.string.episode_txt))) {
            this.B8.setText(com.zte.iptvclient.android.common.k.o.j().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.load_failed)));
        }
        j5();
        this.s5 = false;
    }

    public void g2() {
        F();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void h(boolean z2) {
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void h0() {
        if (this.J1) {
            LogEx.d("PlayerFragment", "showWaitDialog");
            m5();
        }
    }

    protected void h2() {
        TextView textView = this.O6;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    public void i0() {
        if (!this.A) {
            LogEx.e("PlayerFragment", "skipToSmallScreen return current is smallscreen return");
            return;
        }
        if (this.N == null) {
            LogEx.e("PlayerFragment", "skipToSmallScreen mPlayerUICallBack for null return");
            return;
        }
        m3();
        u0();
        e4();
        B0();
        E();
        this.A = false;
        LogEx.d("PlayerFragment", "skipToSmallScreen showMediaController!!!");
        f0();
        this.r5.setVisibility(8);
        y1();
        Activity activity = this.f4977b;
        if (activity instanceof MainActivity) {
            ((MainActivity) activity).c(false);
        }
        com.zte.iptvclient.android.common.player.multiplay.c cVar = this.R7;
        if (cVar != null) {
            cVar.a(this.A);
        }
        if (this.N != null) {
            this.A8.setFitsSystemWindows(false);
            this.N.a(this.y8);
        }
        if (this.s) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.l());
        }
        if (this.W4) {
            h3();
        }
        if (this.F0.getVisibility() == 0) {
            this.e6.setVisibility(8);
        }
    }

    protected void i2() {
        ImageView imageView = this.L6;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    protected void j2() {
        ImageView imageView = this.q7;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void k1() {
        LogEx.d("PlayerFragment", "setPlayerContralViewInVisible");
        O3();
        R3();
        b4();
        j2();
        t2();
        o2();
        J3();
        k2();
        N3();
        p2();
        S1();
        i2();
        I3();
        l2();
        h2();
        a4();
        A3();
        U3();
        Y3();
        X1();
        M3();
        H3();
    }

    protected void k2() {
        if (this.v0 != null) {
            LogEx.d("PlayerFragment", "hideSeekBarProgressSmall");
            this.v0.setVisibility(8);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void l1() {
        Activity activity = this.f4977b;
        if (activity == null) {
            return;
        }
        AudioManager audioManager = (AudioManager) activity.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.S3 = audioManager;
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        this.T3 = streamMaxVolume;
        this.K6.a(streamMaxVolume);
        this.o7.a(this.T3);
        int streamVolume = this.S3.getStreamVolume(3);
        this.U3 = streamVolume;
        this.K6.b(streamVolume);
        this.o7.b(this.U3);
    }

    protected void l2() {
        SeekBar seekBar = this.w0;
        if (seekBar != null) {
            seekBar.setVisibility(8);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    public void m0() {
        super.m0();
        C1();
        if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
            com.zte.iptvclient.android.common.f.b.b.j().b(2);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void m1() {
        this.Z8.removeMessages(4);
        com.zte.iptvclient.android.common.customview.a.a.b.b bVar = this.o8;
        if (bVar != null) {
            bVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.c cVar = this.p8;
        if (cVar != null) {
            cVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.d dVar = this.n8;
        if (dVar != null) {
            dVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.a aVar = this.q8;
        if (aVar != null) {
            if (this.A) {
                com.zte.iptvclient.android.common.k.j.a(aVar, this, false);
            } else {
                com.zte.iptvclient.android.common.k.j.a(aVar, this, true);
            }
            this.q8.show();
        }
    }

    protected void m2() {
        RelativeLayout relativeLayout;
        if (!com.zte.iptvclient.android.common.f.b.b.j().e() || (relativeLayout = this.R6) == null) {
            return;
        }
        relativeLayout.setVisibility(8);
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void n1() {
        LogEx.d("PlayerFragment", "###showLoading()");
        L2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n2() {
        this.T8.setVisibility(8);
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void o0() {
        super.o0();
        LogEx.d("PlayerFragment", "upDatePlayerInerUrl");
        if ("1".equals(this.T) || "10".equals(this.T)) {
            f3();
        }
        this.b9.sendEmptyMessage(1);
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void o1() {
        super.o1();
        V3();
        TextView textView = this.B8;
        if (textView != null) {
            textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.multi_net_off_hint01));
        }
        j5();
        W0();
    }

    protected void o2() {
        ImageView imageView = this.s7;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        LogEx.i("PlayerFragment", "onActivityCreated");
        a(this.V0, this.O8);
        g4();
        F4();
        BaseApp.e().c();
        if (this.T1 != 0 && this.E3 <= 0) {
            this.J1 = false;
        } else if (!this.M1) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.l.a());
            h0();
            H();
            if (getArguments() == null) {
                return;
            } else {
                z1();
            }
        } else {
            H();
            if (this.N1) {
                Z2();
            }
        }
        if (!TextUtils.equals("1", ConfigMgr.readPropertie("isShowAppShareItem"))) {
            this.O8 = true;
        } else {
            this.O8 = false;
        }
        this.Q5 = this.f4977b.getSharedPreferences("gesture_help", 0).getBoolean("first_in", false);
        if (this.V0.getBoolean("isProjection", false)) {
            c2();
            c4();
            z3();
            i2();
            d4();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IBasePlayer iBasePlayer;
        switch (view.getId()) {
            case R.id.Rl_back_to_video /* 2131296275 */:
                b.x xVar = this.M3;
                if (xVar != null) {
                    xVar.p();
                    return;
                }
                return;
            case R.id.btn_full_more_screen /* 2131296435 */:
                W4();
                return;
            case R.id.btn_full_screen_audio /* 2131296436 */:
                r4();
                return;
            case R.id.btn_full_screen_float /* 2131296438 */:
            case R.id.btn_small_screen_float /* 2131296480 */:
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                a3();
                return;
            case R.id.btn_full_screen_order_hint /* 2131296440 */:
            case R.id.btn_preview_order_hint /* 2131296474 */:
            case R.id.btn_small_screen_order_hint /* 2131296482 */:
                Activity activity = this.f4977b;
                if ((activity instanceof MainActivity) && this.e0 && !((MainActivity) activity).s()) {
                    return;
                }
                x5();
                return;
            case R.id.btn_full_screen_play_push /* 2131296442 */:
                C2();
                return;
            case R.id.btn_full_screen_subtitle /* 2131296443 */:
                E4();
                return;
            case R.id.btn_full_screen_tvshare /* 2131296445 */:
            case R.id.btn_small_screen_share /* 2131296485 */:
                if ("1".equals(ConfigMgr.readPropertie("isShowInConstructionTip"))) {
                    com.zte.iptvclient.android.common.k.t.a(this.f4977b);
                    return;
                } else {
                    t(view);
                    return;
                }
            case R.id.btn_full_screen_video_new /* 2131296448 */:
                p4();
                return;
            case R.id.btn_full_screen_volume /* 2131296449 */:
                k3();
                return;
            case R.id.btn_fullscreen /* 2131296450 */:
                LogEx.d("PlayerFragment", "btn_fullscreen");
                Z2();
                return;
            case R.id.btn_login /* 2131296460 */:
                w5();
                n0();
                return;
            case R.id.btn_next_episode /* 2131296465 */:
                if (h4()) {
                    return;
                }
                Y0();
                return;
            case R.id.btn_skip /* 2131296478 */:
                com.zte.iptvclient.android.common.f.b.g.j();
                if (com.zte.iptvclient.android.common.f.b.g.h()) {
                    this.V8.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_close));
                    return;
                } else {
                    this.V8.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_open));
                    n2();
                    return;
                }
            case R.id.btn_small_screen_play_push /* 2131296484 */:
                C2();
                return;
            case R.id.btn_small_screen_stb_select /* 2131296486 */:
                if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                    if (com.zte.iptvclient.android.common.k.c.a()) {
                        return;
                    }
                    U4();
                    return;
                }
                C4();
                return;
            case R.id.btn_small_screen_video /* 2131296488 */:
                q4();
                return;
            case R.id.btn_small_screen_volume /* 2131296489 */:
                l3();
                return;
            case R.id.btn_stb_select_arrow /* 2131296492 */:
                if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                    if (com.zte.iptvclient.android.common.k.c.a()) {
                        return;
                    }
                    U4();
                    return;
                }
                B4();
                return;
            case R.id.btn_zoom_out /* 2131296499 */:
                i0();
                return;
            case R.id.close /* 2131296547 */:
                k0();
                return;
            case R.id.gesture_help /* 2131296858 */:
                F3();
                return;
            case R.id.img_full_screen_channel /* 2131296957 */:
            case R.id.screen_channel /* 2131297940 */:
                this.e6.setVisibility(8);
                if (this.f6.getVisibility() == 8) {
                    if (this.s) {
                        this.f6.setVisibility(0);
                        this.g6.notifyDataSetChanged();
                        u4();
                        this.f6.setSelectionFromTop(this.g6.a(), this.d6.getTop());
                        this.K7 = true;
                        this.Z8.removeMessages(3);
                        this.Z8.sendEmptyMessageDelayed(3, this.N7);
                        if (this.W1 != null) {
                            int i2 = 0;
                            while (true) {
                                int[] iArr = this.W1;
                                if (i2 < iArr.length) {
                                    iArr[i2] = 0;
                                    i2++;
                                }
                            }
                        }
                        this.X1 = this.f6.getLastVisiblePosition() / this.a2;
                        y0();
                    }
                } else {
                    B0();
                }
                E();
                return;
            case R.id.llayout_continue_play /* 2131297360 */:
                BaseApp.e().a(true);
                this.o5 = BaseApp.e().b();
                L3();
                this.F = true;
                s0();
                return;
            case R.id.llayout_continue_play_end /* 2131297361 */:
                this.i4 = "0";
                if (this.r) {
                    G2();
                }
                z1();
                f2();
                return;
            case R.id.rl_blackout /* 2131297732 */:
                if (this.A) {
                    if (this.s) {
                        if (this.e6.getVisibility() == 0) {
                            x3();
                            e4();
                            B0();
                            return;
                        } else {
                            K4();
                            u5();
                            return;
                        }
                    }
                    if (this.C6.getVisibility() == 0) {
                        e4();
                        return;
                    } else {
                        u5();
                        return;
                    }
                }
                return;
            case R.id.rl_pauseView /* 2131297825 */:
            case R.id.rlayout_player /* 2131297910 */:
                if (this.y && !this.e0) {
                    j3();
                    return;
                }
                if (this.e0 && (iBasePlayer = this.L) != null && ((MainActivity) this.f4977b).R) {
                    if (iBasePlayer.isPlaying()) {
                        this.L.pause();
                        return;
                    } else {
                        this.L.start();
                        return;
                    }
                }
                return;
            case R.id.rl_rewind /* 2131297851 */:
                if (com.zte.iptvclient.android.common.f.b.b.j().e() && com.zte.iptvclient.android.common.f.b.b.j().c() == 0) {
                    Date z0 = z0();
                    this.e2 = true;
                    this.P = Math.round(((float) z0.getTime()) - ((float) System.currentTimeMillis()));
                    A1();
                    return;
                }
                return;
            case R.id.rl_switch_setting /* 2131297872 */:
                ArrayList<String> arrayList = new ArrayList<>();
                this.L.getSubtitleInfoArray(arrayList);
                arrayList.add(this.f4977b.getResources().getString(R.string.text_disable));
                arrayList.removeAll(Collections.singleton(null));
                LogEx.d("PlayerFragment", "Multitrack getMulitSubtitle = " + arrayList);
                int assetIndex = this.L.getAssetIndex(AssetType.Asset_Subtitle, AssetStatus.Asset_Playing);
                int i3 = this.R8;
                int i4 = i3 != assetIndex ? i3 : assetIndex;
                ArrayList<String> arrayList2 = new ArrayList<>();
                this.L.getAudioInfoArray(arrayList2);
                arrayList2.removeAll(Collections.singleton(null));
                LogEx.d("PlayerFragment", "Multitrack  getMulitAudioTrunk = " + arrayList2);
                new com.zte.iptvclient.android.common.player.g(this.f4977b, arrayList, arrayList2, this.b1, this.n0, this.c1, i4, this.L.getAssetIndex(AssetType.Asset_Audio, AssetStatus.Asset_Playing)).a(view);
                return;
            case R.id.txtView_timer /* 2131298310 */:
                r0();
                return;
            case R.id.txt_error /* 2131298373 */:
                F();
                if (this.h6.getVisibility() != 0) {
                    if (this.x0) {
                        if (this.t) {
                            if (this.y0 > 60) {
                                LogEx.d("PlayerFragment", "startChannelPlay");
                                j0();
                                return;
                            } else {
                                LogEx.d("PlayerFragment", "startTsChannelPlay");
                                A1();
                                return;
                            }
                        }
                        LogEx.d("PlayerFragment", "reLoadPlayUrl");
                        m4();
                        return;
                    }
                    if (this.L != null) {
                        z1();
                        return;
                    }
                    return;
                }
                return;
            case R.id.voice /* 2131298622 */:
                if (this.Z7) {
                    this.M.unmute();
                    this.Z7 = false;
                    this.Y7.setImageDrawable(getResources().getDrawable(R.drawable.icon_open_voice));
                    return;
                } else {
                    this.M.mute();
                    this.Z7 = true;
                    this.Y7.setImageDrawable(getResources().getDrawable(R.drawable.icon_closeo_voice));
                    return;
                }
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        LogEx.d("PlayerFragment", "onConfigurationChanged");
        if (this.N != null) {
            int i2 = configuration.orientation;
            if (i2 == 2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.s8.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 390.0f);
                    layoutParams.height = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 70.0f);
                    this.s8.setLayoutParams(layoutParams);
                }
                c(com.zte.iptvclient.android.common.k.g.a(this.f4977b, 180.0f), com.zte.iptvclient.android.common.k.g.a(this.f4977b, 120.0f));
            } else if (i2 == 1) {
                com.zte.iptvclient.android.mobile.x.b.c.a aVar = this.I8;
                if (aVar != null && aVar.isShowing()) {
                    this.I8.dismiss();
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.s8.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 360.0f);
                    layoutParams2.height = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 60.0f);
                    this.s8.setLayoutParams(layoutParams2);
                }
                com.zte.iptvclient.common.uiframe.f.a(this.s8);
                c(com.zte.iptvclient.android.common.k.g.a(this.f4977b, 100.0f), com.zte.iptvclient.android.common.k.g.a(this.f4977b, 70.0f));
            }
        }
        super.onConfigurationChanged(configuration);
        m0 m0Var = this.Y8;
        if (m0Var != null) {
            m0Var.a();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b, com.zte.iptvclient.android.common.player.k.a, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogEx.d("PlayerFragment", "onCreate");
        EventBus.getDefault().register(this);
        this.k7 = new com.zte.iptvclient.android.common.j.h(this.f4977b.getApplicationContext());
        this.o5 = BaseApp.e().b();
        this.V0 = getArguments();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LogEx.d("PlayerFragment", "onCreateView");
        View inflate = layoutInflater.inflate(R.layout.play_fragment_layout_new, viewGroup, false);
        this.A8 = inflate;
        SlideRelativeLayout slideRelativeLayout = (SlideRelativeLayout) inflate.findViewById(R.id.rl_Layout_PlayerFragment);
        this.r6 = slideRelativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(slideRelativeLayout);
        this.r6.setLayoutDirection(0);
        this.h = (RelativeLayout) this.A8.findViewById(R.id.rlayout_player);
        this.i = (RelativeLayout) this.A8.findViewById(R.id.pausePlayLayout);
        this.X5 = (ImageView) this.A8.findViewById(R.id.ivi_megogo_pic);
        this.m7 = (GifImageView) this.A8.findViewById(R.id.radio_player_bg);
        ProgressBar progressBar = (ProgressBar) this.A8.findViewById(R.id.bar_loading);
        this.V5 = progressBar;
        com.zte.iptvclient.common.uiframe.f.a(progressBar);
        RelativeLayout relativeLayout = (RelativeLayout) this.A8.findViewById(R.id.rl_contral_container);
        this.j = relativeLayout;
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.A8.findViewById(R.id.llayput_control);
        this.y6 = relativeLayout2;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout2);
        RelativeLayout relativeLayout3 = (RelativeLayout) this.A8.findViewById(R.id.rl_ad_container);
        this.S7 = relativeLayout3;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout3);
        a(this.A8);
        K0();
        l1();
        H4();
        I0();
        l(false);
        return this.A8;
    }

    @Override // com.zte.iptvclient.android.common.player.k.b, com.zte.iptvclient.android.common.player.k.a, androidx.fragment.app.Fragment
    public void onDestroy() {
        m3();
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.l.a aVar) {
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.i iVar) {
        if (this.L != null) {
            LogEx.i("PlayerHelper", "switch series report inner ad");
            if (this.K0 != -1) {
                long currentPosition = this.L.getCurrentPosition();
                this.L0 = currentPosition;
                com.zte.iptvclient.android.common.player.f.a(this.K0 / 1000, currentPosition / 1000);
                this.K0 = -1L;
                return;
            }
            LogEx.d("PlayerHelper", "dont real play dont report inner ad");
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.a, androidx.fragment.app.Fragment
    public void onPause() {
        LogEx.i("PlayerFragment", "onPause");
        super.onPause();
        this.f4977b.unregisterReceiver(this.F7);
        if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
            com.zte.iptvclient.android.common.f.b.b.j().a(false);
        }
        if (TextUtils.isEmpty(this.Y4)) {
            return;
        }
        l0();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b, com.zte.iptvclient.android.common.player.k.a, androidx.fragment.app.Fragment
    public void onResume() {
        LogEx.i("PlayerFragment", "onResume");
        super.onResume();
        n4();
        m0 m0Var = this.Y8;
        if (m0Var != null) {
            m0Var.a();
        }
        this.t0.bringToFront();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    public void p1() {
        if (TextUtils.equals(this.T, "2")) {
            return;
        }
        LogEx.d("PlayerFragment", "###hideLoading()");
        C1();
        a2();
        F();
        V3();
        E();
        f5();
    }

    protected void p2() {
        ImageView imageView = this.U6;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void q1() {
        this.Z8.removeMessages(1);
        com.zte.iptvclient.android.common.customview.a.a.b.d dVar = this.n8;
        if (dVar != null) {
            dVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.a aVar = this.q8;
        if (aVar != null) {
            aVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.c cVar = this.p8;
        if (cVar != null) {
            cVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.b bVar = this.o8;
        if (bVar != null) {
            if (this.A) {
                com.zte.iptvclient.android.common.k.j.a(bVar, this, false);
            } else {
                com.zte.iptvclient.android.common.k.j.a(bVar, this, true);
            }
            this.o8.show();
        }
    }

    public void q2() {
        TextView textView = this.F6;
        if (textView != null) {
            textView.setText("");
        }
        TextView textView2 = this.G6;
        if (textView2 != null) {
            textView2.setText("");
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void r1() {
        com.zte.iptvclient.android.common.customview.a.a.b.d dVar = this.n8;
        if (dVar != null) {
            dVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.a aVar = this.q8;
        if (aVar != null) {
            aVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.c cVar = this.p8;
        if (cVar != null) {
            if (cVar.a()) {
                this.Z8.removeMessages(5);
                com.zte.iptvclient.android.common.customview.a.a.b.b bVar = this.o8;
                if (bVar != null) {
                    bVar.dismiss();
                }
                if (this.A) {
                    com.zte.iptvclient.android.common.k.j.a(this.p8, this, false);
                } else {
                    com.zte.iptvclient.android.common.k.j.a(this.p8, this, true);
                }
                this.p8.show();
                return;
            }
            q1();
        }
    }

    public void r2() {
        B3();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void s1() {
        RelativeLayout relativeLayout = this.h7;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    protected void s2() {
        ImageView imageView = this.M6;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void t1() {
        this.T8.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_begin));
        this.V8.setText(com.zte.iptvclient.android.common.f.b.g.h() ? com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_close) : com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_open));
        this.T8.setVisibility(0);
        new Handler().postDelayed(new z(), this.W8);
    }

    protected void t2() {
        ImageView imageView = this.r7;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void u1() {
        super.u1();
        G2();
        LogEx.d("PlayerFragment", "###hideLoading()");
        a2();
    }

    public boolean u2() {
        return this.k6.getVisibility() == 0;
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    public void v0() {
        com.zte.iptvclient.android.common.customview.a.a.e.l lVar = this.t7;
        if (lVar == null || !lVar.isShowing()) {
            return;
        }
        this.t7.dismiss();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void v1() {
        if (this.V0 == null) {
            LogEx.e("PlayerFragment", "Current Player Bundle is null for return");
            return;
        }
        LogEx.d("PlayerFragment", "text Play miAuthId" + this.T1);
        if (this.T1 != 0) {
            z4();
        } else {
            A4();
        }
    }

    public boolean v2() {
        LogEx.i("PlayerFragment", "keyBack");
        B0();
        return w0();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void w1() {
        this.Z8.removeMessages(2);
        com.zte.iptvclient.android.common.customview.a.a.b.b bVar = this.o8;
        if (bVar != null) {
            bVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.c cVar = this.p8;
        if (cVar != null) {
            cVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.a aVar = this.q8;
        if (aVar != null) {
            aVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.d dVar = this.n8;
        if (dVar != null) {
            if (this.A) {
                com.zte.iptvclient.android.common.k.j.a(dVar, this, false);
            } else {
                com.zte.iptvclient.android.common.k.j.a(dVar, this, true);
            }
            this.n8.show();
        }
    }

    public void w2() {
        this.H8 = this.O;
        LogEx.d("PlayerFragment", "recordPlayUrl" + this.H8);
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected boolean x0() {
        return com.zte.iptvclient.android.mobile.n.c.b.t();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void x1() {
        this.T8.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_end));
        this.V8.setText(com.zte.iptvclient.android.common.f.b.g.h() ? com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_close) : com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_open));
        this.T8.setVisibility(0);
    }

    public void x2() {
        Window window;
        WindowManager.LayoutParams attributes;
        Activity activity = this.f4977b;
        if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        attributes.screenBrightness = -1.0f;
        window.setAttributes(attributes);
    }

    public void y2() {
        this.e0 = false;
        E3();
        F2();
    }

    public void z2() {
        this.x3 = 0L;
        this.y3 = 0L;
        b((int) 0, (int) 0);
        w(h(this.x3 / 1000));
        x(h(this.y3 / 1000));
    }

    private String M(String str) {
        if (TextUtils.equals(str, "1")) {
            return this.o3;
        }
        if (TextUtils.equals(str, "2")) {
            return this.p3;
        }
        if (TextUtils.equals(str, "4")) {
            return this.q3;
        }
        if (TextUtils.equals(str, "8")) {
            return this.r3;
        }
        if (TextUtils.equals(str, GlobalConst.WINPHONE_CLIENT)) {
            return this.s3;
        }
        return TextUtils.equals(str, GlobalConst.ANDRIODSTB_CLIENT) ? this.t3 : WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
    }

    private String N(String str) {
        if ("1".equals(str)) {
            return this.f4977b.getResources().getString(R.string.SD);
        }
        if ("2".equals(str)) {
            return this.f4977b.getResources().getString(R.string.play_vedio_type_sd_h);
        }
        if ("4".equals(str)) {
            return this.f4977b.getResources().getString(R.string.HD);
        }
        return "8".equals(str) ? "480P" : GlobalConst.WINPHONE_CLIENT.equals(str) ? "720P" : GlobalConst.ANDRIODSTB_CLIENT.equals(str) ? "1280P" : "";
    }

    private String O(String str) {
        if ("MP4-lo".equals(str)) {
            return this.f4977b.getResources().getString(R.string.low);
        }
        if ("MP4-hi".equals(str)) {
            return this.f4977b.getResources().getString(R.string.high);
        }
        if ("MP4-mobile".equals(str)) {
            return this.f4977b.getResources().getString(R.string.low);
        }
        if ("MP4-low-mobile".equals(str)) {
            return this.f4977b.getResources().getString(R.string.low);
        }
        if ("MP4-SHQ".equals(str)) {
            return this.f4977b.getResources().getString(R.string.excellent);
        }
        if ("MP4-HD720".equals(str)) {
            return this.f4977b.getResources().getString(R.string.hd_720);
        }
        if ("MP4-HD1080".equals(str)) {
            return this.f4977b.getResources().getString(R.string.hd_1080);
        }
        if ("MP4-TAB-HD720".equals(str)) {
            return this.f4977b.getResources().getString(R.string.hd_720);
        }
        if ("MP4-TAB-HD1080".equals(str)) {
            return this.f4977b.getResources().getString(R.string.hd_1080);
        }
        if ("MP4-4KHDR".equals(str)) {
            return this.f4977b.getResources().getString(R.string.hdr_4k);
        }
        if ("MP4-4KDV".equals(str) || "MP4-UHD".equals(str) || "MP4-UHD12".equals(str) || "MP4-UHD20".equals(str)) {
            return "4K";
        }
        if ("MP4-4KHDR12".equals(str)) {
            return this.f4977b.getResources().getString(R.string.hdr_4k);
        }
        if ("MP4-4KHDR20".equals(str)) {
            return this.f4977b.getResources().getString(R.string.hdr_4k);
        }
        if ("MP4-SHQ-TP".equals(str)) {
            return this.f4977b.getResources().getString(R.string.excellent);
        }
        if ("MP4-HD1080-TP".equals(str)) {
            return this.f4977b.getResources().getString(R.string.hd_1080);
        }
        if ("MP4-TAB-HD1080-TP".equals(str)) {
            return this.f4977b.getResources().getString(R.string.hd_1080);
        }
        if ("MP4-HD1080-L2".equals(str)) {
            return this.f4977b.getResources().getString(R.string.hd_1080);
        }
        if ("MP4-TAB-HD1080-L2".equals(str)) {
            return this.f4977b.getResources().getString(R.string.hd_1080);
        }
        if ("MP4-SHQ-L2".equals(str)) {
            return this.f4977b.getResources().getString(R.string.excellent);
        }
        if ("MP4-SHQ-L4".equals(str)) {
            return this.f4977b.getResources().getString(R.string.excellent);
        }
        if ("MP4-TAB-HD720-TP".equals(str)) {
            return this.f4977b.getResources().getString(R.string.hd_720);
        }
        if ("MP4-TAB-HD720-L2".equals(str)) {
            return this.f4977b.getResources().getString(R.string.hd_720);
        }
        if ("MP4irwma-lo".equals(str)) {
            return this.f4977b.getResources().getString(R.string.low);
        }
        if ("MP4irwma-hi".equals(str)) {
            return this.f4977b.getResources().getString(R.string.high);
        }
        if ("MP4irwma-SHQ".equals(str)) {
            return this.f4977b.getResources().getString(R.string.excellent);
        }
        if ("MP4irwma-HD720".equals(str)) {
            return this.f4977b.getResources().getString(R.string.hd_720);
        }
        if ("MP4irwma-HD1080".equals(str)) {
            return this.f4977b.getResources().getString(R.string.hd_1080);
        }
        if ("MP4irwma-UHD12".equals(str)) {
            return this.f4977b.getResources().getString(R.string.uhd_4k);
        }
        if ("MP4irwma-UHD20".equals(str)) {
            return this.f4977b.getResources().getString(R.string.uhd_4k);
        }
        if ("MP4irwma-4KHDR12".equals(str)) {
            return this.f4977b.getResources().getString(R.string.uhd_hdr_4k);
        }
        if ("MP4irwma-4KHDR20".equals(str)) {
            return this.f4977b.getResources().getString(R.string.uhd_hdr_4k);
        }
        if ("MP4irwmb-lo".equals(str)) {
            return this.f4977b.getResources().getString(R.string.low);
        }
        if ("MP4irwmb-hi".equals(str)) {
            return this.f4977b.getResources().getString(R.string.high);
        }
        if ("MP4irwmb-SHQ".equals(str)) {
            return this.f4977b.getResources().getString(R.string.excellent);
        }
        if ("MP4irwmb-HD720".equals(str)) {
            return this.f4977b.getResources().getString(R.string.hd_720);
        }
        if ("MP4irwmb-HD1080".equals(str)) {
            return this.f4977b.getResources().getString(R.string.hd_1080);
        }
        if ("MP4irwmb-UHD12".equals(str)) {
            return this.f4977b.getResources().getString(R.string.uhd_4k);
        }
        if ("MP4irwmb-UHD20".equals(str)) {
            return this.f4977b.getResources().getString(R.string.uhd_4k);
        }
        if ("MP4irwmb-4KHDR12".equals(str)) {
            return this.f4977b.getResources().getString(R.string.uhd_hdr_4k);
        }
        return "MP4irwmb-4KHDR20".equals(str) ? this.f4977b.getResources().getString(R.string.uhd_hdr_4k) : "";
    }

    private void g(View view) {
        com.zte.iptvclient.android.common.customview.a.a.b.d dVar = new com.zte.iptvclient.android.common.customview.a.a.b.d(this.f4977b);
        this.n8 = dVar;
        dVar.setCancelable(false);
        this.n8.setCanceledOnTouchOutside(true);
        com.zte.iptvclient.android.common.customview.a.a.b.b bVar = new com.zte.iptvclient.android.common.customview.a.a.b.b(this.f4977b);
        this.o8 = bVar;
        bVar.setCancelable(false);
        this.o8.setCanceledOnTouchOutside(true);
        com.zte.iptvclient.android.common.customview.a.a.b.c cVar = new com.zte.iptvclient.android.common.customview.a.a.b.c(this.f4977b);
        this.p8 = cVar;
        cVar.setCancelable(false);
        this.p8.setCanceledOnTouchOutside(true);
        com.zte.iptvclient.android.common.customview.a.a.b.a aVar = new com.zte.iptvclient.android.common.customview.a.a.b.a(this.f4977b);
        this.q8 = aVar;
        aVar.setCancelable(false);
        this.q8.setCanceledOnTouchOutside(true);
    }

    private void h(View view) {
        this.s6 = (RelativeLayout) view.findViewById(R.id.gesture_help);
        this.t6 = (ImageView) view.findViewById(R.id.imv_vod_tips);
        TextView textView = (TextView) view.findViewById(R.id.help_3);
        this.u6 = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.play_help_1));
        TextView textView2 = (TextView) view.findViewById(R.id.help_6);
        this.v6 = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.play_help_2));
        TextView textView3 = (TextView) view.findViewById(R.id.help_9);
        this.w6 = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.play_help_3));
        TextView textView4 = (TextView) view.findViewById(R.id.help_12);
        this.x6 = textView4;
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.play_help_4));
        com.zte.iptvclient.common.uiframe.f.a(this.s6);
        com.zte.iptvclient.common.uiframe.f.a(this.t6);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.help_1));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.help_2));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.help_3));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.help_4));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.help_5));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.help_6));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.help_7));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.help_8));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.help_9));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.help_10));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.help_11));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.help_12));
    }

    private void i(View view) {
        this.h6 = (LinearLayout) view.findViewById(R.id.llayout_net_hint);
        TextView textView = (TextView) view.findViewById(R.id.txtvew_net_hint);
        this.i6 = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.network_hint));
        TextView textView2 = (TextView) view.findViewById(R.id.txtvew_net_hint2);
        this.j6 = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.network_hint2));
        com.zte.iptvclient.common.uiframe.f.a(this.h6);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txtvew_net_hint));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txtvew_net_hint2));
    }

    private void j(View view) {
        this.k6 = (LinearLayout) view.findViewById(R.id.llayout_net_limit_hint);
        TextView textView = (TextView) view.findViewById(R.id.txtvew_net_limit_hint);
        this.l6 = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.play_net_ip_limit_tip));
        com.zte.iptvclient.common.uiframe.f.a(this.k6);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txtvew_net_limit_hint));
    }

    private void k(View view) {
        this.C8 = (LinearLayout) view.findViewById(R.id.llayout_end_hint);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.llayout_continue_play_end);
        this.D8 = linearLayout;
        linearLayout.setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(R.id.txtvew_end_hint);
        this.E8 = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.play_end_hint));
        TextView textView2 = (TextView) view.findViewById(R.id.txtvew_continue_play_end);
        this.F8 = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.replay));
        com.zte.iptvclient.common.uiframe.f.a(this.C8);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.llayout_end_hint));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txtvew_end_hint));
        com.zte.iptvclient.common.uiframe.f.a(this.D8);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txtvew_continue_play_end));
    }

    private void l(View view) {
        this.x8 = (LinearLayout) view.findViewById(R.id.llayout_error_hint);
        TextView textView = (TextView) view.findViewById(R.id.txt_error);
        this.z8 = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.retry));
        TextView textView2 = (TextView) view.findViewById(R.id.txtvew_error_hint);
        this.B8 = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.multi_net_off_hint01));
        this.z8.setOnClickListener(this);
        com.zte.iptvclient.common.uiframe.f.a(this.x8);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.iv_error_services));
        com.zte.iptvclient.common.uiframe.f.a(this.B8);
        com.zte.iptvclient.common.uiframe.f.a(this.z8);
    }

    private void m(View view) {
        this.Q7 = (ViewStub) view.findViewById(R.id.vewstub_screen_interacton);
    }

    private void n(View view) {
        this.h7 = (RelativeLayout) view.findViewById(R.id.rl_rewind);
        TextView textView = (TextView) view.findViewById(R.id.txt_start_over);
        this.i7 = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.startOver));
        com.zte.iptvclient.common.uiframe.f.a(this.h7);
        com.zte.iptvclient.common.uiframe.f.a(this.i7);
    }

    private void o(View view) {
        this.g7 = (RelativeLayout) view.findViewById(R.id.rlayout_stb);
    }

    private void p(View view) {
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.sensor_lock_full_screen);
        this.t5 = checkBox;
        if (this.B) {
            return;
        }
        checkBox.setVisibility(8);
    }

    private void q(View view) {
        this.Z5 = (RelativeLayout) view.findViewById(R.id.llayout_preview_order_hint);
        this.a6 = (TextView) view.findViewById(R.id.txtvew_preview_order_hint);
        TextView textView = (TextView) view.findViewById(R.id.btn_preview_order_hint);
        this.b6 = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.order));
        com.zte.iptvclient.common.uiframe.f.a(this.Z5);
        com.zte.iptvclient.common.uiframe.f.a(this.a6);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_preview_order_hint_frist));
        com.zte.iptvclient.common.uiframe.f.a(this.b6);
    }

    private void r(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rlayout_full_screen_title);
        this.z6 = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.rlayout_full_screen_main_panel);
        this.A6 = constraintLayout;
        constraintLayout.setOnTouchListener(new j0(this));
        this.f = (RelativeLayout) view.findViewById(R.id.rlayout_full_screen_control_surface);
        this.Y5 = (RelativeLayout) view.findViewById(R.id.rlayout_full_screen_main_view);
        this.B6 = (ImageView) view.findViewById(R.id.btn_full_screen_exit);
        this.C6 = (ImageView) view.findViewById(R.id.btn_full_screen_uncommon_exit);
        this.D6 = (TextView) view.findViewById(R.id.full_screen_program_name);
        this.F6 = (TextView) view.findViewById(R.id.txtview_full_screen_channel_name);
        this.G6 = (TextView) view.findViewById(R.id.txtview_full_screen_program_time);
        this.H6 = (TextView) view.findViewById(R.id.txtview_stb_name);
        com.zte.iptvclient.common.uiframe.f.a(this.B6);
        com.zte.iptvclient.common.uiframe.f.a(this.C6);
        this.I6 = (LinearLayout) view.findViewById(R.id.btn_stb_select_arrow);
        this.J6 = (RelativeLayout) view.findViewById(R.id.rlayout_full_screen_volume_adjustment);
        this.K6 = (VerticalSeekBarNew) view.findViewById(R.id.bar_full_screen_volume_adjustment);
        this.q6 = (ImageView) view.findViewById(R.id.btn_zoom_out);
        this.L6 = (ImageView) view.findViewById(R.id.btn_full_screen_play_push);
        this.M6 = (ImageView) view.findViewById(R.id.btn_full_screen_volume);
        this.N6 = (ImageView) view.findViewById(R.id.btn_full_screen_play_pause);
        this.w0 = (SeekBar) view.findViewById(R.id.bar_full_screen_play_progress);
        this.O6 = (TextView) view.findViewById(R.id.txtview_full_screen_play_time);
        this.P6 = (TextView) view.findViewById(R.id.txtview_full_screen_total_time);
        this.Q6 = (ImageView) view.findViewById(R.id.btn_full_screen_tvresume);
        this.X6 = (Button) view.findViewById(R.id.btn_full_screen_video_new);
        com.zte.iptvclient.common.uiframe.f.a(this.L6);
        ImageView imageView = (ImageView) view.findViewById(R.id.btn_next_episode);
        this.Y6 = imageView;
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.llayout_full_screen_order_hint);
        this.Z6 = linearLayout;
        com.zte.iptvclient.common.uiframe.f.a(linearLayout);
        TextView textView = (TextView) view.findViewById(R.id.btn_full_screen_order_hint);
        this.b7 = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.order));
        com.zte.iptvclient.common.uiframe.f.a(this.b7);
        TextView textView2 = (TextView) view.findViewById(R.id.txtvew_full_screen_order_hint);
        this.a7 = textView2;
        com.zte.iptvclient.common.uiframe.f.a(textView2);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.rl_multi_audio_subtitle);
        this.T6 = relativeLayout2;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout2);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.btn_full_screen_subtitle);
        this.U6 = imageView2;
        com.zte.iptvclient.common.uiframe.f.a(imageView2);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.btn_full_screen_audio);
        this.V6 = imageView3;
        com.zte.iptvclient.common.uiframe.f.a(imageView3);
        ImageView imageView4 = (ImageView) view.findViewById(R.id.btn_small_screen);
        this.W6 = imageView4;
        com.zte.iptvclient.common.uiframe.f.a(imageView4);
        ImageView imageView5 = (ImageView) view.findViewById(R.id.btn_full_screen_tvshare);
        this.m8 = imageView5;
        com.zte.iptvclient.common.uiframe.f.a(imageView5);
        ImageView imageView6 = (ImageView) view.findViewById(R.id.btn_vr_glasses);
        this.c7 = imageView6;
        com.zte.iptvclient.common.uiframe.f.a(imageView6);
        ImageView imageView7 = (ImageView) view.findViewById(R.id.btn_vr_360video);
        this.d7 = imageView7;
        com.zte.iptvclient.common.uiframe.f.a(imageView7);
        this.e7 = (ImageView) view.findViewById(R.id.btn_full_more_screen);
        this.r5 = (FrameLayout) view.findViewById(R.id.fl_multi_play_manager);
        if (TextUtils.equals("0", ConfigMgr.readPropertie("SupportMultiWindowPlay"))) {
            this.r5.setVisibility(8);
            this.e7.setVisibility(8);
        } else {
            this.r5.setVisibility(0);
            this.e7.setVisibility(0);
        }
        com.zte.iptvclient.common.uiframe.f.a(this.e7);
        com.zte.iptvclient.common.uiframe.f.a(this.r5);
        this.r5.setVisibility(8);
        this.d7.setVisibility(8);
        ImageView imageView8 = (ImageView) view.findViewById(R.id.btn_full_screen_hc100);
        this.f7 = imageView8;
        com.zte.iptvclient.common.uiframe.f.a(imageView8);
        ImageView imageView9 = (ImageView) view.findViewById(R.id.btn_full_screen_float);
        this.j7 = imageView9;
        com.zte.iptvclient.common.uiframe.f.a(imageView9);
        if ("1".equals(ConfigMgr.readPropertie("ShowFloatingPlayBtn"))) {
            I2();
        } else {
            W1();
        }
    }

    private void s(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rlayout_small_screen_main_panel);
        this.n7 = relativeLayout;
        relativeLayout.setOnTouchListener(new k0(this));
        this.g = (RelativeLayout) view.findViewById(R.id.rlayout_small_screen_control_surface);
        this.o7 = (VerticalSeekBarNew) view.findViewById(R.id.bar_small_screen_volume_adjustment);
        this.p7 = (ImageView) view.findViewById(R.id.btn_fullscreen);
        this.x7 = (RelativeLayout) view.findViewById(R.id.rlayout_small_screen_volume_adjustment);
        this.q7 = (ImageView) view.findViewById(R.id.btn_small_screen_play_push);
        this.r7 = (ImageView) view.findViewById(R.id.btn_small_screen_volume);
        this.s7 = (ImageView) view.findViewById(R.id.btn_small_screen_stb_select);
        this.u7 = (ImageView) view.findViewById(R.id.btn_small_screen_play_pause);
        this.v7 = (ImageView) view.findViewById(R.id.img_switch_setting);
        this.k = (RelativeLayout) view.findViewById(R.id.rl_switch_setting);
        this.v0 = (SeekBar) view.findViewById(R.id.bar_small_screen_play_progress);
        this.y7 = (TextView) view.findViewById(R.id.txtview_small_screen_play_time);
        this.z7 = (TextView) view.findViewById(R.id.txtview_small_screen_total_time);
        this.A7 = (ImageView) view.findViewById(R.id.btn_small_screen_tvresume);
        this.w7 = (Button) view.findViewById(R.id.btn_small_screen_video);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.llayout_small_screen_order_hint);
        this.B7 = linearLayout;
        com.zte.iptvclient.common.uiframe.f.a(linearLayout);
        TextView textView = (TextView) view.findViewById(R.id.btn_small_screen_order_hint);
        this.D7 = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.order));
        com.zte.iptvclient.common.uiframe.f.a(this.D7);
        TextView textView2 = (TextView) view.findViewById(R.id.txtvew_small_screen_order_hint);
        this.C7 = textView2;
        com.zte.iptvclient.common.uiframe.f.a(textView2);
        ImageView imageView = (ImageView) view.findViewById(R.id.btn_small_screen_share);
        this.l8 = imageView;
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.btn_small_screen_hc100);
        this.E7 = imageView2;
        com.zte.iptvclient.common.uiframe.f.a(imageView2);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.btn_small_screen_float);
        this.H7 = imageView3;
        com.zte.iptvclient.common.uiframe.f.a(imageView3);
        if ("1".equals(ConfigMgr.readPropertie("ShowFloatingPlayBtn"))) {
            J2();
        } else {
            X1();
        }
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.rl_loading);
        this.c0 = linearLayout2;
        com.zte.iptvclient.common.uiframe.f.a(linearLayout2);
        ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_player_loading);
        this.r8 = imageView4;
        com.zte.iptvclient.common.uiframe.f.a(imageView4);
        this.s8 = (ImageView) view.findViewById(R.id.iv_player_loading_up);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.iv_player_loading_up));
        Activity activity = this.f4977b;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        com.bumptech.glide.h<Integer> h2 = com.bumptech.glide.i.a(this.f4977b).a(Integer.valueOf(R.drawable.bg_palybegin_poater)).h();
        h2.a(DiskCacheStrategy.SOURCE);
        h2.a(this.r8);
    }

    private void t(View view) {
        LogEx.d("PlayerFragment", "showShare mstrContentType=" + this.T);
        if (ConfigMgr.readPropertie("IsCommingSoon") != null && ConfigMgr.readPropertie("IsCommingSoon").equals("1")) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.vod_txt_empty2);
            return;
        }
        if ("2".equals(this.T)) {
            u(view);
            return;
        }
        if ("4".equals(this.T)) {
            v(view);
        } else if ("1".equals(this.T) || "14".equals(this.T) || "10".equals(this.T)) {
            w(view);
        }
    }

    private void v(View view) {
        if (this.C1 == null) {
            return;
        }
        LogEx.d("PlayerFragment", "eas_dns=" + com.zte.iptvclient.common.uiframe.a.c("EAS_Domain"));
        String str = com.zte.iptvclient.common.uiframe.a.c("Share_Link_Address") + "?videoid=" + this.p1 + "&videotype=4";
        String str2 = this.C1;
        if (!TextUtils.isEmpty(this.E6)) {
            str2 = this.E6;
        }
        String str3 = str2;
        com.zte.iptvclient.android.mobile.x.b.c.a aVar = new com.zte.iptvclient.android.mobile.x.b.c.a(this.f4977b, com.zte.iptvclient.android.common.i.a.a.a(R.string.let_us_watch) + " " + str3 + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.on_app_click_link_below), str, this.y1, str3, null, null);
        this.I8 = aVar;
        aVar.a(this.A8);
    }

    private void x(View view) {
        this.S8 = (RelativeLayout) view.findViewById(R.id.rl_skip_duration);
        this.T8 = (TextView) view.findViewById(R.id.tv_hint);
        TextView textView = (TextView) view.findViewById(R.id.tv_skip);
        this.U8 = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_duration));
        TextView textView2 = (TextView) view.findViewById(R.id.btn_skip);
        this.V8 = textView2;
        textView2.setText(com.zte.iptvclient.android.common.f.b.g.h() ? com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_close) : com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_open));
        this.V8.setOnClickListener(this);
        com.zte.iptvclient.common.uiframe.f.a(this.S8);
        com.zte.iptvclient.common.uiframe.f.a(this.T8);
        com.zte.iptvclient.common.uiframe.f.a(this.U8);
        com.zte.iptvclient.common.uiframe.f.a(this.V8);
        this.S8.setVisibility(com.zte.iptvclient.android.common.f.b.g.a() ? 0 : 8);
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void A(String str) {
        String N;
        if (TextUtils.equals(this.n0, "Megogo")) {
            N = str;
        } else if (TextUtils.equals(this.n0, "ivi")) {
            N = O(str);
        } else {
            N = N(str);
        }
        J(str);
        LogEx.d("PlayerFragment", "strDefinitionTitle = " + N);
        if (this.u1.equals(str)) {
            this.X6.setText(R.string.play_vedio_type_local);
            this.w7.setText(R.string.play_vedio_type_local);
        } else if (this.v1.equals(str)) {
            this.X6.setText(R.string.play_vedio_type_hc);
            this.w7.setText(R.string.play_vedio_type_hc);
        } else {
            this.X6.setText(N);
            this.w7.setText(N);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void B(String str) {
        this.F6.setText(str);
        LogEx.d("PlayerFragment", "strChannelName:" + str);
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void C(String str) {
        if (this.i1 == null || this.g6 == null) {
            return;
        }
        for (int i2 = 0; i2 < this.i1.size(); i2++) {
            if (TextUtils.equals(str, this.i1.get(i2).getChannelcode())) {
                this.g6.a(i2);
                return;
            }
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    public void D(String str) {
        this.D6.setText(str);
        LogEx.d("PlayerFragment", "setPlayTitle " + str);
        this.E6 = str;
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void E(String str) {
        if (StringUtil.isEmptyString(str)) {
            return;
        }
        this.G6.setText("(" + str + ")");
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void F() {
        super.F();
        LinearLayout linearLayout = this.x8;
        if (linearLayout == null || linearLayout.getVisibility() != 0) {
            return;
        }
        S3();
    }

    public void G(String str) {
        this.E0 = str;
    }

    public void H(String str) {
        if (!M(str).equals("0") && !TextUtils.equals(this.n0, "Megogo") && !TextUtils.equals(this.n0, "ivi")) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.b0.a(str, this.h4));
            i0();
            return;
        }
        A(str);
        this.d1 = this.c1;
        this.c1 = str;
        com.zte.iptvclient.android.common.customview.a.a.b.c cVar = this.p8;
        if (cVar != null) {
            cVar.a(str);
        }
        if (DownloadConstant.REPORT_MSGTYPE_ADD.equals(this.d1) && N0()) {
            j(true);
            this.K1 = true;
        } else {
            F(this.c1);
        }
    }

    public void I(String str) {
        this.D5 = str;
        LogEx.d("PlayerFragment", "onBlackOutPlay start!");
        S0();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00d0 -> B:15:0x00d1). Please report as a decompilation issue!!! */
    protected void J(String str) {
        Bundle bundle;
        int i2;
        LogEx.d("PlayerFragment", "current strDefinitionis  ===========  " + str);
        if (str == null || (bundle = this.V0) == null) {
            return;
        }
        String string = bundle.getString(Q(str) + ParamConst.CHANNEL_INFO_RSP_TSAVAILABLE, "");
        LogEx.d("PlayerFragment", "@TS strTsavailable is  ===========  " + string + " minuts");
        try {
        } catch (NumberFormatException e2) {
            LogEx.e("PlayerFragment", "@TS strTsavailable can not be parsed to int" + e2.getMessage());
        }
        if (!TextUtils.isEmpty(string)) {
            i2 = Integer.valueOf(string).intValue();
            String a2 = com.zte.iptvclient.android.common.j.i.d().a(this.V0.getString("mixno"));
            LogEx.d("PlayerFragment", "@TS Tsavailable ChannelTstvList for Mixno " + this.V0.getString("mixno") + " strTsEnableDuration=" + a2 + " seconds");
            if (!TextUtils.isEmpty(a2) && i2 > 0) {
                int intValue = Integer.valueOf(a2).intValue() * 1000;
                if (intValue > 0) {
                    this.C0 = intValue;
                } else {
                    this.C0 = i2 * 60 * 1000;
                }
                if (!"1".equals(this.V0.getString("supportTimeShift")) && i2 > 0) {
                    this.F1 = true;
                    if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
                        com.zte.iptvclient.android.common.f.b.b.j().a(this.u, (int) this.C0);
                    }
                } else {
                    this.F1 = false;
                }
                LogEx.d("PlayerFragment", "@TS mTsAvailble is " + this.F1 + " miTsEnableDuration :" + this.C0);
            }
        }
        i2 = 0;
        if (!"1".equals(this.V0.getString("supportTimeShift"))) {
        }
        this.F1 = false;
        LogEx.d("PlayerFragment", "@TS mTsAvailble is " + this.F1 + " miTsEnableDuration :" + this.C0);
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void K() {
        super.K();
        LogEx.d("PlayerFragment", "###hideLoading()");
        q5();
        A();
        a2();
        g2();
        z5();
    }

    public void L(String str) {
        this.X5.setVisibility(0);
        this.Z8.sendEmptyMessageDelayed(6, 2000L);
        LogEx.d("PlayerFragment", "###showIviPic()");
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void u(String str) {
        super.u(str);
        if (TextUtils.isEmpty(this.A1)) {
            this.A1 = null;
            this.z1 = null;
            return;
        }
        try {
            String str2 = com.zte.iptvclient.android.common.f.b.i.g() + this.A1.substring(this.A1.indexOf("/image", 0));
            try {
                if (this.f4977b != null && !this.f4977b.isFinishing()) {
                    com.bumptech.glide.b<String> f2 = com.bumptech.glide.i.a(this.f4977b).a(str2).f();
                    f2.c();
                    this.z1 = f2.a(100, 100).get();
                }
            } catch (Exception e2) {
                LogEx.e("PlayerFragment", "Exception" + e2.toString());
            }
        } catch (Exception e3) {
            LogEx.e("PlayerFragment", "Exception" + e3.toString());
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void w(String str) {
        this.O6.setText(str);
        this.y7.setText(str);
        this.A5 = str;
        LogEx.d("PlayerFragment", "onPlayTimeChanged " + this.A5 + " strTotalTime=" + this.B5);
    }

    private void c(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.Rl_back_to_video);
        this.m6 = relativeLayout;
        relativeLayout.setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(R.id.txt_back_to_video);
        this.n6 = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.back_to_video));
        com.zte.iptvclient.common.uiframe.f.a(this.m6);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_back_to_video));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_back_to_video));
    }

    private void d(View view) {
        this.D0 = (ImageView) view.findViewById(R.id.iv_blackout);
        this.F0 = (RelativeLayout) view.findViewById(R.id.rl_blackout);
        com.zte.iptvclient.common.uiframe.f.a(this.D0);
        com.zte.iptvclient.common.uiframe.f.a(this.F0);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_skip_blackout);
        this.R6 = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
        TextView textView = (TextView) view.findViewById(R.id.txt_skip_blackout);
        this.S6 = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_blackout));
        com.zte.iptvclient.common.uiframe.f.a(this.S6);
    }

    private void e(View view) {
        this.c6 = (LinearLayout) view.findViewById(R.id.channel_list_layout);
        this.d6 = (ImageView) view.findViewById(R.id.img_full_screen_channel);
        this.e6 = (ImageView) view.findViewById(R.id.screen_channel);
        this.f6 = (ListView) view.findViewById(R.id.channel_list);
        com.zte.iptvclient.common.uiframe.f.a(this.c6);
        com.zte.iptvclient.common.uiframe.f.a(this.d6);
        com.zte.iptvclient.common.uiframe.f.a(this.f6);
    }

    private void f(View view) {
        this.o6 = (LinearLayout) view.findViewById(R.id.llayout_continue_play);
        TextView textView = (TextView) view.findViewById(R.id.txtvew_continue_play);
        this.p6 = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.continue_play));
        com.zte.iptvclient.common.uiframe.f.a(this.o6);
        com.zte.iptvclient.common.uiframe.f.a(this.p6);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_content_rank);
        this.G8 = imageView;
        com.zte.iptvclient.common.uiframe.f.a(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i2) {
        if (!BaseApp.a(this.f4977b) && this.A) {
            LogEx.e("PlayerFragment", "skipToFullScreen return for fullscreen");
            return;
        }
        if (this.O5) {
            LogEx.d("PlayerFragment", "current RadioChannel skipToFullScreen return");
            return;
        }
        this.e0 = false;
        this.A = true;
        E3();
        y1();
        E();
        m3();
        u0();
        LogEx.d("PlayerFragment", "skipToFullScreen showMediaController!!!");
        f0();
        if (this.N != null) {
            this.A8.setFitsSystemWindows(true);
            this.N.a(i2);
            t3();
        }
        if (this.W4) {
            h3();
        }
        Activity activity = this.f4977b;
        if (activity instanceof MainActivity) {
            ((MainActivity) activity).c(true);
        }
        T1();
        if (!q3()) {
            u5();
        }
        v4();
        com.zte.iptvclient.android.common.player.multiplay.c cVar = this.R7;
        if (cVar != null) {
            cVar.a(this.A);
        }
        if (TextUtils.isEmpty(this.Y4)) {
            new Handler().postDelayed(new r(), 500L);
        }
        if (this.F0.getVisibility() == 0 && this.s) {
            this.e6.setVisibility(0);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    public void E() {
        LogEx.d("PlayerFragment", "hideMediaController!!!");
        V1();
        w3();
        if (this.A) {
            K3();
            P3();
        } else {
            Q3();
        }
    }

    private void b(View view) {
        int a2;
        int a3;
        this.e8 = (RelativeLayout) view.findViewById(R.id.CornerAdPic0Layout);
        this.f8 = (RelativeLayout) view.findViewById(R.id.CornerAdPic1Layout);
        this.g8 = (RelativeLayout) view.findViewById(R.id.CornerAdPic3Layout);
        this.h8 = (RelativeLayout) view.findViewById(R.id.CornerAdPic4Layout);
        if (getResources().getConfiguration().orientation == 2) {
            a2 = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 180.0f);
            a3 = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 120.0f);
        } else {
            a2 = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 100.0f);
            a3 = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 70.0f);
        }
        c(a2, a3);
        TextView textView = (TextView) view.findViewById(R.id.txt_ad);
        this.c8 = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.ad));
        this.d8 = (TextView) view.findViewById(R.id.txtView_timer);
        this.X7 = (RelativeLayout) view.findViewById(R.id.pauseAdLayout);
        this.t0 = (RelativeLayout) view.findViewById(R.id.rl_pauseView);
        this.Y7 = (ImageView) view.findViewById(R.id.voice);
        this.a8 = (TextView) view.findViewById(R.id.count_down);
        this.b8 = (ImageView) view.findViewById(R.id.close);
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    public void L() {
        super.L();
        if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
            com.zte.iptvclient.android.common.f.b.b.j().b(1);
        }
    }

    protected void a(View view) {
        this.u5 = false;
        r(view);
        s(view);
        o(view);
        q(view);
        i(view);
        j(view);
        c(view);
        f(view);
        h(view);
        g(view);
        x(view);
        e(view);
        p(view);
        b(view);
        l(view);
        k(view);
        d(view);
        if (TextUtils.equals(ConfigMgr.readPropertie("isStartOver"), "1")) {
            n(view);
        }
        if ("1".equals(ConfigMgr.readPropertie("IsSupportCastScreen", "0"))) {
            m(view);
        }
    }

    private void w(View view) {
        LogEx.d("PlayerFragment", "eas_dns=" + com.zte.iptvclient.common.uiframe.a.c("EAS_Domain"));
        String str = com.zte.iptvclient.common.uiframe.a.c("Share_Link_Address") + "?videoid=" + this.q1 + "&videotype=" + this.T;
        String str2 = this.f1;
        if (!TextUtils.isEmpty(this.E6)) {
            str2 = this.E6;
        }
        String str3 = str2;
        com.zte.iptvclient.android.mobile.x.b.c.a aVar = new com.zte.iptvclient.android.mobile.x.b.c.a(this.f4977b, com.zte.iptvclient.android.common.i.a.a.a(R.string.let_us_watch) + " " + str3 + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.on_app_click_link_below), str, this.A1, str3, null, null);
        this.I8 = aVar;
        aVar.a(view);
    }

    private void n(int i2) {
        String str;
        String str2;
        Activity activity;
        P4();
        this.L.pause();
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Frame_Resource");
        String c3 = com.zte.iptvclient.common.uiframe.a.c("Rank_Hint_Img");
        str = "";
        if (TextUtils.isEmpty(c3)) {
            str2 = "";
        } else {
            String[] split = c3.split(",");
            str = split.length > i2 ? split[i2] : "";
            str2 = com.zte.iptvclient.android.common.f.b.i.a() + c2 + "/img/" + str;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (activity = this.f4977b) == null || activity.isFinishing()) {
            if (i2 == 1) {
                this.G8.setBackgroundResource(R.drawable.rank_hint_g);
                return;
            }
            if (i2 == 2) {
                this.G8.setBackgroundResource(R.drawable.rank_hint_pg);
                return;
            }
            if (i2 == 3) {
                this.G8.setBackgroundResource(R.drawable.rank_hint_pg13);
                return;
            } else if (i2 == 4) {
                this.G8.setBackgroundResource(R.drawable.rank_hint_r);
                return;
            } else {
                if (i2 != 5) {
                    return;
                }
                this.G8.setBackgroundResource(R.drawable.rank_hint_nc17);
                return;
            }
        }
        if (i2 == 1) {
            com.bumptech.glide.d<String> a2 = com.bumptech.glide.i.a(this.f4977b).a(str2);
            a2.a((com.bumptech.glide.load.b) new com.bumptech.glide.r.c("0"));
            a2.d();
            a2.a(R.drawable.rank_hint_g);
            a2.a(this.G8);
            return;
        }
        if (i2 == 2) {
            com.bumptech.glide.d<String> a3 = com.bumptech.glide.i.a(this.f4977b).a(str2);
            a3.a((com.bumptech.glide.load.b) new com.bumptech.glide.r.c("0"));
            a3.d();
            a3.a(R.drawable.rank_hint_pg);
            a3.a(this.G8);
            return;
        }
        if (i2 == 3) {
            com.bumptech.glide.d<String> a4 = com.bumptech.glide.i.a(this.f4977b).a(str2);
            a4.a((com.bumptech.glide.load.b) new com.bumptech.glide.r.c("0"));
            a4.d();
            a4.a(R.drawable.rank_hint_pg13);
            a4.a(this.G8);
            return;
        }
        if (i2 == 4) {
            com.bumptech.glide.d<String> a5 = com.bumptech.glide.i.a(this.f4977b).a(str2);
            a5.a((com.bumptech.glide.load.b) new com.bumptech.glide.r.c("0"));
            a5.d();
            a5.a(R.drawable.rank_hint_r);
            a5.a(this.G8);
            return;
        }
        if (i2 != 5) {
            return;
        }
        com.bumptech.glide.d<String> a6 = com.bumptech.glide.i.a(this.f4977b).a(str2);
        a6.a((com.bumptech.glide.load.b) new com.bumptech.glide.r.c("0"));
        a6.d();
        a6.a(R.drawable.rank_hint_nc17);
        a6.a(this.G8);
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void Q() {
        super.Q();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void j(boolean z2) {
        if (BaseApp.e().b()) {
            this.F = false;
            z2 = false;
        }
        if (z2) {
            LogEx.d("PlayerFragment", "###hideLoading()");
            a2();
            a5();
            a.h hVar = this.j0;
            if (hVar != null) {
                hVar.a();
                return;
            }
            return;
        }
        L3();
        if (this.f0) {
            return;
        }
        LogEx.d("PlayerFragment", "###showLoading()");
        L2();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.j jVar) {
        T();
    }

    public void K(String str) {
        if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
            if (this.D0 != null) {
                LogEx.d("PlayerFragment", " showImageBlackout:" + str);
                k0();
                if (TextUtils.isEmpty(str)) {
                    H2();
                } else {
                    com.bumptech.glide.d<String> a2 = com.bumptech.glide.i.b(BaseApp.e().getApplicationContext()).a(str);
                    a2.b(R.drawable.default_blackout);
                    a2.a(R.drawable.default_blackout);
                    a2.a(this.D0);
                }
                if (com.zte.iptvclient.android.common.f.b.b.j().d() == null) {
                    d0();
                }
                com.zte.iptvclient.android.common.f.b.b.j().b(1);
                this.F0.setVisibility(0);
            }
            com.zte.iptvclient.android.common.f.b.b.j().a(true);
            this.f0 = true;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.g gVar) {
        LogEx.d("PlayerFragment", "recv PushPlayEvent");
        if (gVar != null) {
            this.K8 = gVar.a();
            this.L8 = gVar.c();
            this.M8 = gVar.d();
            this.N8 = gVar.b();
        }
        C2();
    }

    private int c(ArrayList<String> arrayList) {
        String c2;
        if (this.k7 == null) {
            this.k7 = new com.zte.iptvclient.android.common.j.h(this.f4977b);
        }
        if (TextUtils.equals("2", this.T)) {
            c2 = com.zte.iptvclient.android.common.j.f.a().b(this.k7.V(), this.u);
        } else {
            c2 = com.zte.iptvclient.android.common.j.f.a().c(this.k7.V());
        }
        if (!TextUtils.isEmpty(c2) && arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (TextUtils.equals(c2, arrayList.get(i2))) {
                    return i2;
                }
            }
            return 0;
        }
        LogEx.d("PlayerFragment", "Multitrack getLocal getMulitSubtitle is null! ");
        return 0;
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    public void R() {
        super.R();
        com.zte.iptvclient.android.common.customview.a.a.b.c cVar = this.p8;
        if (cVar != null) {
            cVar.c();
        }
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.i.c(this.q1, this.x3));
    }

    @Override // com.zte.iptvclient.android.common.player.k.b, com.zte.iptvclient.android.common.player.k.a
    protected void S() {
        super.S();
        if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
            com.zte.iptvclient.android.common.f.b.b.j().i();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void e(int i2) {
        LogEx.d("PlayerFragment", "Advertisiment onAdTimeChanged strTime = " + i2 + " miCloseTime " + this.F4);
        StringBuilder sb = new StringBuilder();
        sb.append("misPlayingInsertStreamAD = ");
        sb.append(this.x4);
        LogEx.d("PlayerFragment", sb.toString());
        if (i2 > 0 && !this.x4) {
            String valueOf = String.valueOf(i2);
            this.c8.setVisibility(0);
            this.d8.setVisibility(0);
            int i3 = this.U;
            if (i3 == this.W) {
                if (this.F4 == -1) {
                    this.d8.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.ad_seconds), valueOf));
                } else if (!TextUtils.equals(this.I4, this.T7) && !TextUtils.equals(this.I4, this.V7)) {
                    this.d8.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_ad), valueOf));
                } else {
                    this.d8.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_ad_with_no_second));
                }
                int i4 = this.F4;
                if (i4 == this.W7) {
                    this.d8.setClickable(true);
                    LogEx.d("PlayerFragment", "Advertisiment mTvTimer setClickable(true)");
                    this.d8.setTextColor(-1);
                    return;
                } else {
                    if (i4 > 0) {
                        a(this.y4, valueOf);
                        return;
                    }
                    return;
                }
            }
            if (i3 == this.X) {
                if (this.F4 == -1) {
                    this.d8.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.ad_seconds), valueOf));
                    return;
                }
                if (!TextUtils.equals(this.I4, this.T7) && !TextUtils.equals(this.I4, this.U7)) {
                    this.d8.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_ad), valueOf));
                } else {
                    this.d8.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_ad_with_no_second));
                }
                int i5 = this.F4;
                if (i5 == this.W7) {
                    this.d8.setClickable(true);
                    LogEx.d("PlayerFragment", "Advertisiment mTvTimer setClickable(true)");
                    this.d8.setTextColor(-1);
                    return;
                } else {
                    if (i5 > 0) {
                        a(this.z4, valueOf);
                        return;
                    }
                    return;
                }
            }
            if (i3 == this.Y) {
                if (this.F4 == -1) {
                    this.d8.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.ad_seconds), valueOf));
                    return;
                }
                if (TextUtils.equals(this.I4, this.T7)) {
                    this.d8.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_ad_with_no_second));
                } else {
                    this.d8.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_ad), valueOf));
                }
                int i6 = this.F4;
                if (i6 == this.W7) {
                    this.d8.setClickable(true);
                    LogEx.d("PlayerFragment", "Advertisiment mTvTimer setClickable(true)");
                    this.d8.setTextColor(-1);
                } else if (i6 > 0) {
                    a(this.A4, valueOf);
                }
                if ("0".equals(valueOf)) {
                    this.d8.setVisibility(4);
                    this.c8.setVisibility(4);
                    return;
                }
                return;
            }
            if (i3 == this.V) {
                if ((this.w4 == 1 || this.v4 == 1) && this.F4 == -1) {
                    LogEx.d("PlayerFragment", "Advertisiment InserAD for POSITIVE strTime = " + i2);
                    this.d8.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.ad_seconds), valueOf));
                    return;
                }
                LogEx.d("PlayerFragment", "Advertisiment  for current POSITIVE  INVISIBLE for strTime = " + i2);
                this.d8.setVisibility(4);
                this.c8.setVisibility(4);
                return;
            }
            return;
        }
        this.c8.setVisibility(4);
        this.d8.setVisibility(4);
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void f(int i2) {
        this.a8.setVisibility(4);
        this.a8.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.ad_seconds), Integer.valueOf(i2)));
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void i(int i2) {
        String a2;
        LogEx.d("PlayerFragment", "showPlayNextOrderHint " + i2);
        if (this.e0) {
            a((MainActivity) this.f4977b);
            i0();
        }
        this.J1 = false;
        LogEx.d("PlayerFragment", "IvPauseFull.setEnabled(false)");
        this.N6.setEnabled(false);
        this.u7.setEnabled(false);
        this.w0.setEnabled(false);
        LogEx.d("PlayerFragment", "IvPauseFull.mSeekBarProgressFull(false)");
        this.v0.setEnabled(false);
        this.X6.setEnabled(false);
        this.w7.setEnabled(false);
        if (i2 <= 0) {
            LogEx.w("PlayerFragment", "can not support preview");
            return;
        }
        T3();
        if (!this.k7.b0().booleanValue()) {
            LogEx.d("PlayerFragment", "need login");
            M2();
        } else {
            b2();
            if (!"10".equals(this.T) && !"14".equals(this.T)) {
                if ("1".equals(this.T)) {
                    a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.vod_order_hint);
                } else {
                    a2 = ("2".equals(this.T) || "4".equals(this.T)) ? com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_order_hint) : "";
                }
            } else {
                a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.series_order_hint);
            }
            LogEx.d("PlayerFragment", "###hideLoading()");
            a2();
            X1();
            if ("1".equals(this.T) || "10".equals(this.T) || "14".equals(this.T)) {
                k(true);
                if (this.B && this.A) {
                    i0();
                }
            }
            D3();
            String format = String.format(a2, Integer.valueOf(i2));
            this.b6.setText(R.string.order);
            this.a6.setText(format);
            O2();
            this.h0 = true;
        }
        a.h hVar = this.j0;
        if (hVar != null) {
            hVar.a();
        }
        LogEx.d("PlayerFragment", "###hideLoading()");
        a2();
    }

    @Override // com.zte.iptvclient.android.common.player.multiplay.c.o
    public void q() {
        this.Q7.setVisibility(8);
        h0();
        this.p = false;
        if (this.s) {
            j0();
        } else {
            X0();
        }
        this.s0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l(int i2) {
        int i3 = this.j8;
        if ((i2 >= 0 && i2 <= 30) || i2 > 330) {
            i3 = 1;
        } else if (i2 > 60 && i2 <= 120) {
            i3 = 8;
        } else if (i2 > 150 && i2 <= 210) {
            i3 = 9;
        } else if (i2 > 240 && i2 <= 300) {
            i3 = 0;
        }
        LogEx.d("PlayerFragment", "convert2Orientation " + i3);
        return i3;
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void d(int i2) {
        if (i2 == 1) {
            this.N6.setImageResource(R.drawable.player_play_icon);
            this.u7.setImageResource(R.drawable.player_play_icon);
        } else {
            if (i2 != 2) {
                return;
            }
            this.N6.setImageResource(R.drawable.player_pause_icon);
            this.u7.setImageResource(R.drawable.player_pause_icon);
        }
    }

    private void u(View view) {
        if (this.C1 == null) {
            return;
        }
        LogEx.d("PlayerFragment", "eas_dns=" + com.zte.iptvclient.common.uiframe.a.c("EAS_Domain"));
        String str = com.zte.iptvclient.common.uiframe.a.c("Share_Link_Address") + "?videoid=" + this.u + "&videotype=2";
        String str2 = this.C1;
        if (!TextUtils.isEmpty(this.E6)) {
            str2 = this.E6;
        }
        String str3 = str2;
        String str4 = com.zte.iptvclient.android.common.i.a.a.a(R.string.let_us_watch) + " " + str3 + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.on_app_click_link_below);
        String str5 = this.y1;
        this.l5 = null;
        com.zte.iptvclient.android.mobile.x.b.c.a aVar = new com.zte.iptvclient.android.mobile.x.b.c.a(this.f4977b, str4, str, str5, str3, this.l5, null);
        this.I8 = aVar;
        aVar.a(view);
    }

    public void f(Bundle bundle) {
        this.W5 = false;
        LogEx.d("PlayerFragment", "videoCpCode is " + this.n0);
        if ("megogo".equalsIgnoreCase(this.n0)) {
            com.zte.iptvclient.android.common.player.d dVar = new com.zte.iptvclient.android.common.player.d(this.f4977b);
            dVar.a(true);
            dVar.a(this.m1, this.l1, new m());
            return;
        }
        this.f2 = bundle.getString(ParamConst.UPDATE_VERSION_RSP_URL);
        LogEx.d("PlayerFragment", "resert In pickParams mPath = " + this.f2);
        this.i2 = bundle.getString("TSURL");
        c(bundle);
        A2();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void g(int i2) {
        com.zte.iptvclient.android.common.customview.a.a.b.a aVar = this.q8;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    public void k(boolean z2) {
        this.W5 = z2;
    }

    public void l(boolean z2) {
        if (z2) {
            if (this.k8 != null) {
                LogEx.d("PlayerFragment", "OrientationListener enable");
                this.k8.enable();
                return;
            }
            return;
        }
        if (this.k8 != null) {
            LogEx.d("PlayerFragment", "OrientationListener disable");
            this.k8.disable();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.c
    public void t() {
        this.e0 = false;
    }

    public void k(int i2) {
        E();
        V3();
        LogEx.d("PlayerFragment", "###hideLoading()");
        a2();
        B3();
        Z1();
        t("");
        TextView textView = this.B8;
        if (textView != null) {
            textView.setText(com.zte.iptvclient.android.common.k.o.j().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.load_failed)) + " (" + com.zte.iptvclient.android.common.i.a.a.a(R.string.episode_txt) + " " + i2 + ")");
        }
        j5();
        this.s5 = false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.h hVar) {
        if (hVar == null) {
            return;
        }
        if (hVar.f4483a) {
            j3();
            return;
        }
        this.y8 = true;
        i0();
        this.y8 = false;
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void v() {
        F1();
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void A() {
        V3();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void d(Bundle bundle) {
        if (bundle != null) {
            if (!TextUtils.isEmpty(com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_THUMBNAILS_SERVER)) && !TextUtils.isEmpty(bundle.getString("physicalcontentid", "")) && !TextUtils.isEmpty(bundle.getString("cmsid", "")) && (!"4".equals(bundle.getString("auth_contenttype")) || (!TextUtils.isEmpty(bundle.getString("prevuebegintime", "")) && !TextUtils.isEmpty(bundle.getString("prevueendtime", ""))))) {
                this.M5 = true;
                if (this.p8 == null || this.f4977b.isDestroyed()) {
                    return;
                }
                this.p8.a(bundle, this.c1);
                return;
            }
            LogEx.e("PlayerFragment", "isSuportThumbViewShow false");
            this.M5 = false;
            return;
        }
        this.M5 = false;
    }

    public void g(Bundle bundle) {
        this.e0 = false;
        h0();
        g(true);
        Z3();
        e(bundle);
        v1();
        if (this.N1) {
            Z2();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void x(String str) {
        this.P6.setText(str);
        this.z7.setText(str);
        this.B5 = str;
        LogEx.d("PlayerFragment", "onTotalTimeChanged " + str + " mTvTotalTimeSmall=" + str);
    }

    public void j(int i2) {
        LogEx.d("PlayerFragment", "showLimitPlayHitViewByType");
        TextView textView = this.l6;
        if (textView == null) {
            return;
        }
        if (i2 == 0) {
            textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.limit_4k_definition_tip));
        } else if (i2 == 1) {
            textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.limit_net_type_tip));
        } else if (i2 == 3) {
            textView.setText("");
        }
        d3();
        LogEx.d("PlayerFragment", "###hideLoading()");
        a2();
        E();
        O4();
        if (q3()) {
            return;
        }
        u5();
    }

    @Override // com.zte.iptvclient.android.common.f.b.b.d
    public void l() {
        LogEx.d("PlayerFragment", "BlackoutMgr onDefaultReturn");
        this.f4977b.runOnUiThread(new f0());
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.m mVar) {
        this.n0 = mVar.a();
        if (mVar.d() == 1) {
            H(mVar.c());
            return;
        }
        if (mVar.d() == 2) {
            this.L.selectAudioByIndex(mVar.b());
            S(mVar.c());
            LogEx.d("PlayerFragment", "MultitrackchangeAudio +++" + mVar.c());
            return;
        }
        if (mVar.d() == 3) {
            T(mVar.c());
            this.R8 = mVar.b();
            if (TextUtils.equals(mVar.c(), getResources().getString(R.string.text_disable))) {
                this.L.enableSubtitle(false);
                LogEx.d("PlayerFragment", ">>>enableSubtitle(false)");
            } else {
                this.L.enableSubtitle(true);
                LogEx.d("PlayerFragment", ">>>enableSubtitle(true)");
                this.L.selectVideoByIndex(this.R8);
            }
            LogEx.d("PlayerFragment", "MultitrackchangeSubtitle +++" + mVar.c());
        }
    }

    private void c(int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
        layoutParams.addRule(9);
        layoutParams.addRule(12);
        this.e8.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i3);
        layoutParams2.addRule(11);
        layoutParams2.addRule(12);
        this.f8.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i2, i3);
        layoutParams3.addRule(9);
        layoutParams3.addRule(10);
        this.g8.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(i2, i3);
        layoutParams4.addRule(11);
        layoutParams4.addRule(10);
        this.h8.setLayoutParams(layoutParams4);
    }

    private int b(ArrayList<String> arrayList) {
        String b2;
        if (this.k7 == null) {
            this.k7 = new com.zte.iptvclient.android.common.j.h(this.f4977b);
        }
        if (TextUtils.equals("2", this.T)) {
            b2 = com.zte.iptvclient.android.common.j.f.a().a(this.k7.V(), this.u);
        } else {
            b2 = com.zte.iptvclient.android.common.j.f.a().b(this.k7.V());
        }
        if (!TextUtils.isEmpty(b2) && arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (TextUtils.equals(b2, arrayList.get(i2))) {
                    return i2;
                }
            }
            return 0;
        }
        LogEx.d("PlayerFragment", "Multitrack getLocal getMulitAudio is null! ");
        return 0;
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void f(boolean z2) {
        this.w0.setEnabled(z2);
        LogEx.d("PlayerFragment", "IvPauseFull.mSeekBarProgressFull()" + z2);
        this.v0.setEnabled(z2);
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void h(int i2) {
        com.zte.iptvclient.android.common.customview.a.a.b.d dVar = this.n8;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void a(com.zte.iptvclient.android.common.e.r.g gVar) {
        LogEx.d("PlayerFragment", "recv PushPlayEvent");
        if (gVar != null) {
            this.K8 = gVar.a();
            this.L8 = gVar.c();
            this.M8 = gVar.d();
            this.N8 = gVar.b();
        }
        C2();
    }

    public void h(Bundle bundle) {
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.l.a());
        if (this.L == null) {
            x();
            H();
        }
        d3();
        e(bundle);
        if (!"2".equals(this.T) && !"4".equals(this.T)) {
            F2();
        } else {
            T1();
        }
        v1();
    }

    @Override // com.zte.iptvclient.android.common.f.b.b.d
    public void j() {
        LogEx.d("PlayerFragment", "BlackoutMgr onBlackoutExitReturn");
        this.f4977b.runOnUiThread(new d0());
    }

    @Override // com.zte.iptvclient.android.common.f.b.b.d
    public void k(String str) {
        LogEx.d("PlayerFragment", "BlackoutMgr onImageBlackoutReturn" + str);
        this.f4977b.runOnUiThread(new b0(str));
    }

    @Override // com.zte.iptvclient.android.common.h.a.b
    public void k() {
        X2();
    }

    public void a(o0 o0Var) {
        if (o0Var != null) {
            this.J8 = o0Var;
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void a(int i2, String str, int i3, int i4) {
        LogEx.d("PlayerFragment", "Advertisiment showCornerAd postion " + i2 + " url " + str + " Duration " + i3 + " showoffset " + i4);
        com.zte.iptvclient.android.common.customview.view.imageview.a aVar = new com.zte.iptvclient.android.common.customview.view.imageview.a(this.f4977b);
        aVar.a(str);
        aVar.c(i2);
        aVar.a(i3);
        aVar.b(i4);
        this.L4.add(aVar);
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void b(Date date) {
        super.b(date);
        R2();
        i5();
    }

    public void m(boolean z2) {
        this.l7 = z2;
        LogEx.d("PlayerFragment", "setTVRemind " + this.l7);
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void b(int i2, int i3) {
        this.w0.setMax(i3);
        this.v0.setMax(i3);
        this.w0.setProgress(i2);
        this.v0.setProgress(i2);
        LogEx.d("PlayerFragment", "setPlayProgress currentProgress =" + i2 + " MAx=" + i3);
    }

    @Override // com.zte.iptvclient.android.common.f.b.b.e
    public void c(long j2) {
        LogEx.d("PlayerFragment", "BlackoutMgr onTvodSeekReturn" + j2);
        this.P = j2;
        Y();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.n.e eVar) {
        if ("LiveTvChannels".equalsIgnoreCase(eVar.a()) && eVar.c()) {
            J0();
            this.g6.notifyDataSetChanged();
        }
    }

    private void a(int i2, String str) {
        try {
            int i3 = this.F4;
            if (i2 - Integer.valueOf(str).intValue() > i3) {
                LogEx.d("PlayerFragment", "iCloseTime = " + i3);
                this.d8.setClickable(true);
                LogEx.d("PlayerFragment", "Advertisiment mTvTimer setClickable(true)");
                this.d8.setTextColor(-1);
            } else {
                f1();
            }
        } catch (Exception e2) {
            LogEx.d("PlayerFragment", "updateCloseAdBtnState exception: " + e2.getMessage());
            f1();
        }
    }

    @Subscribe
    public void onEventMainThread(EventBusPlayerMessage eventBusPlayerMessage) {
        EventBusPlayerMessage.TypeOfMessage typeOfMessage = eventBusPlayerMessage.f4520a;
        if (typeOfMessage == EventBusPlayerMessage.TypeOfMessage.RELEASEPLAYER) {
            LogEx.d("PlayerFragment", "releasePlayer");
            R();
        } else {
            if (typeOfMessage != EventBusPlayerMessage.TypeOfMessage.RESUMEPLAYWHENCLOSEFLOAT) {
                if (typeOfMessage == EventBusPlayerMessage.TypeOfMessage.CLOSENETHINTCONTINUEPLAY) {
                    BaseApp.e().a(true);
                    this.o5 = BaseApp.e().b();
                    L3();
                    this.F = true;
                    s0();
                    return;
                }
                return;
            }
            eventBusPlayerMessage.a();
            throw null;
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void a(List<com.zte.iptvclient.android.common.customview.view.imageview.a> list) {
        super.a(list);
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.zte.iptvclient.android.common.customview.view.imageview.a aVar = list.get(i2);
            this.Z8.postDelayed(new g(aVar), aVar.h() * 1000);
            LogEx.d("PlayerFragment", "Advertisiment showCornerAdImg at " + aVar.h() + " Duration " + aVar.g());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.l lVar) {
        TextView textView;
        if (!"2".equals(this.T) || (textView = this.a6) == null) {
            return;
        }
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.null_product_hint));
        c5();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.t.a aVar) {
        LogEx.d("PlayerFragment", "recharge state is " + aVar.a());
        if (aVar.a()) {
            A2();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.multiplay.c.o
    public void a(long j2, String str) {
        this.l0 = false;
        LogEx.d("PlayerFragment", "exitPlayFromStb breakPoint = " + j2 + " telecomcode = " + str + " mstrTelecomcode = " + this.a1);
        A();
        if ("2".equals(this.T)) {
            if (this.P8) {
                g1();
                this.P8 = false;
            }
            if (com.zte.iptvclient.android.mobile.u.a.a.a0) {
                com.zte.iptvclient.android.mobile.u.a.a.a0 = false;
            }
            j0();
        } else {
            String J = this.k7.J();
            if ("".equals(J) || TextUtils.equals(com.zte.iptvclient.common.uiframe.a.c("BSTV_CP_Code"), J)) {
                if (j2 > 0 && !TextUtils.isEmpty(str) && str.equals(this.a1)) {
                    if (!this.L.isPlaying()) {
                        if (this.P8) {
                            g1();
                            this.P8 = false;
                        }
                        if (com.zte.iptvclient.android.mobile.u.a.a.a0) {
                            com.zte.iptvclient.android.mobile.u.a.a.a0 = false;
                        }
                        this.L.seek(j2);
                        b((int) j2, (int) this.y3);
                        X0();
                    }
                } else if (!this.L.isPlaying()) {
                    if (this.P8) {
                        g1();
                        this.P8 = false;
                    }
                    if (com.zte.iptvclient.android.mobile.u.a.a.a0) {
                        com.zte.iptvclient.android.mobile.u.a.a.a0 = false;
                    }
                    X0();
                }
            } else if (j2 <= 0) {
                if (!this.L.isPlaying()) {
                    if (this.P8) {
                        g1();
                        this.P8 = false;
                    }
                    if (com.zte.iptvclient.android.mobile.u.a.a.a0) {
                        com.zte.iptvclient.android.mobile.u.a.a.a0 = false;
                    }
                    X0();
                }
            } else if (!this.L.isPlaying()) {
                if (this.P8) {
                    g1();
                    this.P8 = false;
                }
                if (com.zte.iptvclient.android.mobile.u.a.a.a0) {
                    com.zte.iptvclient.android.mobile.u.a.a.a0 = false;
                }
                this.L.seek(j2);
                b((int) j2, (int) this.y3);
                X0();
            }
        }
        this.i0 = true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.eventbus.multi.a aVar) {
        this.r5.setVisibility(8);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.v.a aVar) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        androidx.fragment.app.r b2 = childFragmentManager.b();
        if (childFragmentManager.c(com.zte.iptvclient.android.mobile.v.b.a.class.getSimpleName()) != null) {
            b2.e(this.w8);
        } else {
            this.w8 = new com.zte.iptvclient.android.mobile.v.b.a();
            Bundle bundle = new Bundle();
            bundle.putBoolean("MulitScreenEdit", true);
            bundle.putBoolean("DarkTheme", true);
            this.w8.setArguments(bundle);
            b2.a(R.id.fl_multi_play_manager, this.w8, com.zte.iptvclient.android.mobile.v.b.a.class.getSimpleName());
            b2.a((String) null);
        }
        com.zte.iptvclient.android.mobile.a0.b.b bVar = this.v8;
        if (bVar != null) {
            b2.c(bVar);
        }
        b2.b();
    }

    @Override // com.zte.iptvclient.android.common.f.b.b.d
    public void r(String str) {
        LogEx.d("PlayerFragment", "BlackoutMgr onVideoBlackoutReturn= " + str);
        this.f4977b.runOnUiThread(new c0(str));
    }

    public void e(Bundle bundle) {
        LogEx.d("PlayerFragment", "###reInitPlayBundle");
        this.V0 = bundle;
        R0();
        b(bundle);
        this.w5 = this.O8;
        this.v8 = null;
        z2();
        com.zte.iptvclient.android.mobile.a0.a.e.b bVar = this.g6;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
        X3();
        W3();
        g4();
        g(true);
        l(true);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        this.m0 = true;
        if ("0".equals(cVar.a())) {
            w();
            if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
                b2();
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.u.a aVar) {
        if (this.k8 == null || !this.B || this.e0) {
            return;
        }
        Activity activity = this.f4977b;
        if (activity instanceof MainActivity) {
            ((MainActivity) activity).u().setVisibility(0);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.eventbus.multi.e eVar) {
        s0();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.eventbus.multi.f fVar) {
        if (com.zte.iptvclient.android.mobile.u.a.a.a0) {
            com.zte.iptvclient.android.mobile.u.a.a.a0 = false;
        }
        if (this.P8) {
            g1();
            this.P8 = false;
        }
        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(fVar.a())) {
            g1();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void e(boolean z2) {
        if (!z2) {
            LogEx.d("PlayerFragment", "showLimitPlayHitViewByType");
            j(0);
            return;
        }
        if (this.X8 == null) {
            this.X8 = new com.zte.iptvclient.android.common.player.f();
        }
        if (com.zte.iptvclient.android.common.player.f.c(this.c1)) {
            LogEx.d("PlayerFragment", "showLimitPlayHitViewByType");
            j(0);
        } else {
            B3();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.i.c cVar) {
        if (cVar == null || this.z || this.L == null) {
            return;
        }
        if (("1".equals(this.T) || "10".equals(this.T) || "15".equals(this.T)) && TextUtils.equals(cVar.b(), this.q1) && this.U == this.V) {
            this.L.seek(cVar.a());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.d dVar) {
        if (dVar == null) {
            return;
        }
        if (dVar.a() == 2) {
            if (this.i0) {
                s0();
                return;
            } else {
                W0();
                return;
            }
        }
        if (dVar.a() == 1) {
            W0();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MultiPlayWindowEvent multiPlayWindowEvent) {
        if (2 == multiPlayWindowEvent.a()) {
            this.t5.setVisibility(0);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void a(int i2, String str, long j2) {
        if (!this.M5) {
            LogEx.d("PlayerFragment", "current is not support update ThumbNailDialogProgress ");
            return;
        }
        com.zte.iptvclient.android.common.customview.a.a.b.c cVar = this.p8;
        if (cVar != null) {
            cVar.a(i2, str, j2);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.w.d dVar) {
        dVar.a();
        throw null;
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void a(int i2, String str, String str2, boolean z2) {
        com.zte.iptvclient.android.common.customview.a.a.b.b bVar = this.o8;
        if (bVar != null) {
            bVar.a(i2, str, str2, z2);
        }
    }

    @Override // com.zte.iptvclient.android.common.f.b.b.e
    public void a(long j2) {
        LogEx.d("PlayerFragment", "BlackoutMgr onTsSeekReturn" + j2);
        long time = j2 - com.zte.iptvclient.android.common.k.s.b().getTime();
        int duration = (int) this.L.getDuration();
        int duration2 = (int) (this.L.getDuration() + time);
        this.G1 = true;
        this.v0.setMax(duration);
        this.w0.setMax(duration);
        this.v0.setProgress(duration2);
        this.w0.setProgress(duration2);
        if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
            com.zte.iptvclient.android.common.f.b.b.j().b(j2);
            m2();
            if (Q1()) {
                Z1();
            }
        }
    }

    public void a(m0 m0Var) {
        this.Y8 = m0Var;
        this.A = true;
        this.B = false;
    }
}
