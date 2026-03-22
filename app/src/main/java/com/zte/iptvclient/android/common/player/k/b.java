package com.zte.iptvclient.android.common.player.k;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.tencent.mm.sdk.platformtools.Util;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.download.Linstener.DownloadListReturnListener;
import com.video.androidsdk.download.SDKDownloadMgr;
import com.video.androidsdk.download.bean.DownloadTask;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.mes.SDKPushMsgMgr;
import com.video.androidsdk.player.IBasePlayer;
import com.video.androidsdk.player.common.CommonFunc;
import com.video.androidsdk.player.common.SourceType;
import com.video.androidsdk.service.bookmark.SDKBookMarkMgr;
import com.video.androidsdk.service.cache.SDKCacheMgr;
import com.video.androidsdk.service.channel.SDKChannelMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.prevue.SDKPrevueMgr;
import com.zte.iptvclient.android.common.customview.a.a.e.f;
import com.zte.iptvclient.android.common.customview.view.VerticalSeekBarNew;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.javabean.models.VoDBean;
import com.zte.iptvclient.android.common.netstate.NetWorkUtil;
import com.zte.iptvclient.android.common.netstate.NetworkStateReceiver;
import com.zte.iptvclient.android.common.player.activity.VOPlayerActivity;
import com.zte.iptvclient.android.common.player.k.a;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.a0.c.a;
import com.zte.iptvclient.android.mobile.ivi.DefinitionBean;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.VerticalSeekBar;
import com.zte.iptvclient.common.video.ContentType;
import com.zte.servicesdk.util.PortalConst;
import com.zte.servicesdk.util.TimeShowUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ControlPlayerFragment.java */
/* loaded from: classes.dex */
public abstract class b extends com.zte.iptvclient.android.common.player.k.a {
    public String A1;
    private String A2;
    private long A3;
    protected int A4;
    protected String A5;
    private String B2;
    protected float B3;
    protected int B4;
    protected String B5;
    private String C2;
    protected long C3;
    protected int C4;
    private com.zte.iptvclient.android.common.j.h C5;
    private String D2;
    private String D3;
    protected int D4;
    public String D5;
    private String E2;
    private String F2;
    private String G2;
    protected View.OnClickListener G3;
    public Date G5;
    private String H2;
    protected View.OnClickListener H3;
    public Date H5;
    private String I2;
    protected View.OnClickListener I3;
    protected String I4;
    public Date I5;
    private String J2;
    protected View.OnClickListener J3;
    public Date J5;
    private String K2;
    protected SeekBar.OnSeekBarChangeListener K3;
    private String L2;
    protected a0 L3;
    protected boolean M1;
    private String M2;
    protected x M3;
    private ArrayList<String> M4;
    protected boolean N1;
    private String N2;
    private w N3;
    private ArrayList<String> N4;
    private String O2;
    private y O3;
    private ArrayList<String> O4;
    private String P2;
    protected com.zte.iptvclient.android.common.netstate.a P3;
    private ArrayList<String> P4;
    private String Q2;
    protected VerticalSeekBarNew.a Q3;
    protected int R1;
    private String R2;
    protected VerticalSeekBar.a R3;
    protected int S1;
    private String S2;
    protected AudioManager S3;
    private String T2;
    protected int T3;
    private String T4;
    private com.zte.iptvclient.android.common.customview.a.a.e.f T5;
    protected int U1;
    private String U2;
    protected int U3;
    public int U4;
    private String U5;
    protected Bundle V0;
    protected int V1;
    private String V2;
    protected Runnable V3;
    public int V4;
    protected int[] W1;
    private String W2;
    protected Runnable W3;
    private String X2;
    protected VerticalSeekBarNew.a X3;
    protected List<String> X4;
    private SeekBar Y0;
    private String Y2;
    protected VerticalSeekBar.a Y3;
    protected String Y4;
    protected String Z0;
    private String Z2;
    protected int Z4;
    protected String a1;
    private String a3;
    protected Handler a4;
    protected com.zte.iptvclient.android.common.player.b a5;
    private String b3;
    protected Timer b4;
    protected com.zte.iptvclient.android.common.player.b b5;
    protected String c1;
    private int c2;
    private String c3;
    protected TimerTask c4;
    protected com.zte.iptvclient.android.common.player.h c5;
    protected String d1;
    private double d2;
    private String d3;
    private int d5;
    private ArrayList<PrevueBean> e1;
    private String e3;
    private int e5;
    protected String f1;
    protected String f2;
    private String f3;
    protected String g1;
    protected String g2;
    private String g3;
    private int g5;
    protected Thread h1;
    protected String h2;
    private String h3;
    protected ArrayList<Channel> i1;
    protected String i2;
    private String i3;
    private com.zte.iptvclient.android.mobile.a0.c.a j1;
    private String j2;
    private String j3;
    protected String k1;
    private String k2;
    private String k3;
    protected String l1;
    private String l2;
    private String l3;
    protected String m1;
    private String m2;
    private String m3;
    protected String n1;
    private String n2;
    private String n3;
    protected String o1;
    private String o2;
    protected String o3;
    protected String p1;
    private String p2;
    protected String p3;
    protected String q1;
    private String q2;
    protected String q3;
    protected String r1;
    private String r2;
    protected String r3;
    protected FrameLayout r5;
    protected String s1;
    private String s2;
    protected String s3;
    protected String t1;
    private String t2;
    protected String t3;
    protected CheckBox t5;
    private String u2;
    private String v2;
    private Date v3;
    private DownloadTask w1;
    private String w2;
    protected String w3;
    public boolean w5;
    private String x1;
    private String x2;
    protected long x3;
    protected String x5;
    public String y1;
    private String y2;
    protected long y3;
    protected int y4;
    protected String y5;
    private String z2;
    protected int z4;
    protected String z5;
    private SimpleDateFormat W0 = new SimpleDateFormat(TimeShowUtil.STR_VOD_DURATION_TIME_FORMATE, Locale.ENGLISH);
    public boolean X0 = false;
    protected ArrayList<String> b1 = new ArrayList<>();
    protected String u1 = DownloadConstant.REPORT_MSGTYPE_ADD;
    protected String v1 = DownloadConstant.REPORT_MSGTYPE_URL_NULL;
    public Bitmap z1 = null;
    protected String B1 = "";
    protected String C1 = "";
    protected String D1 = "";
    private boolean E1 = false;
    protected boolean F1 = false;
    protected boolean G1 = false;
    protected boolean H1 = false;
    private boolean I1 = false;
    protected boolean J1 = true;
    protected boolean K1 = false;
    protected boolean L1 = false;
    public int O1 = 1;
    public int P1 = 2;
    private int Q1 = 0;
    protected int T1 = 0;
    protected int X1 = 0;
    protected int Y1 = -1;
    private int Z1 = 1;
    protected int a2 = 20;
    protected int b2 = 0;
    protected boolean e2 = false;
    private boolean u3 = false;
    private long z3 = 0;
    protected int E3 = 0;
    protected String F3 = "0";
    protected int Z3 = 0;
    private boolean d4 = false;
    private String e4 = "";
    protected String f4 = "";
    private String g4 = "1";
    protected int h4 = 0;
    protected String i4 = "0";
    private ArrayList<String> j4 = new ArrayList<>();
    protected ArrayList<String> k4 = new ArrayList<>();
    protected ArrayList<String> l4 = new ArrayList<>();
    private ArrayList<Integer> m4 = new ArrayList<>();
    protected ArrayList<Integer> n4 = new ArrayList<>();
    protected ArrayList<Integer> o4 = new ArrayList<>();
    private ArrayList<Integer> p4 = new ArrayList<>();
    protected ArrayList<Integer> q4 = new ArrayList<>();
    protected ArrayList<Integer> r4 = new ArrayList<>();
    private ArrayList<Integer> s4 = new ArrayList<>();
    private ArrayList<Integer> t4 = new ArrayList<>();
    private ArrayList<Integer> u4 = new ArrayList<>();
    protected int v4 = 0;
    protected int w4 = 0;
    protected boolean x4 = false;
    protected ArrayList<Integer> E4 = new ArrayList<>();
    protected int F4 = -1;
    protected ArrayList<Integer> G4 = new ArrayList<>();
    protected ArrayList<Integer> H4 = new ArrayList<>();
    protected ArrayList<Integer> J4 = new ArrayList<>();
    protected boolean K4 = false;
    protected List<com.zte.iptvclient.android.common.customview.view.imageview.a> L4 = new ArrayList();
    private int Q4 = 0;
    private int R4 = 0;
    private int S4 = 0;
    protected boolean W4 = false;
    private boolean f5 = true;
    private int h5 = 1;
    private int i5 = 2;
    private int j5 = 3;
    private GestureDetector k5 = null;
    protected Bitmap l5 = null;
    private String m5 = "";
    private ArrayList<String> n5 = new ArrayList<>();
    public boolean o5 = false;
    protected ArrayList<com.zte.iptvclient.android.common.javabean.models.c> p5 = new ArrayList<>();
    protected boolean q5 = true;
    public boolean s5 = false;
    protected boolean u5 = false;
    protected String v5 = "";
    public long E5 = -1;
    public long F5 = -1;
    private SimpleDateFormat K5 = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
    private SimpleDateFormat L5 = new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH);
    public boolean M5 = false;
    private boolean N5 = false;
    protected boolean O5 = false;
    protected boolean P5 = false;
    protected boolean Q5 = false;
    protected boolean R5 = true;
    protected int S5 = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public class a extends TimerTask {

        /* compiled from: ControlPlayerFragment.java */
        /* renamed from: com.zte.iptvclient.android.common.player.k.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0149a implements Runnable {
            RunnableC0149a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                if (bVar.f4977b == null || bVar.L == null) {
                    return;
                }
                if (bVar.s) {
                    bVar.B2();
                }
                b.this.U1();
            }
        }

        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            b.this.a4.post(new RunnableC0149a());
        }
    }

    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public interface a0 {
        void q(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControlPlayerFragment.java */
    /* renamed from: com.zte.iptvclient.android.common.player.k.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0150b implements View.OnClickListener {
        ViewOnClickListenerC0150b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            b.this.B0();
            b.this.w0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public class b0 extends Thread {

        /* compiled from: ControlPlayerFragment.java */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.l1();
            }
        }

        public b0() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            b bVar = b.this;
            if (bVar.y && !bVar.L.isPlaying()) {
                return;
            }
            while (true) {
                Thread thread = b.this.h1;
                if (thread == null || thread.isInterrupted()) {
                    return;
                }
                b.this.a4.post(new a());
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.c1();
            b.this.j0();
            b.this.T();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        d(b bVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
                com.zte.iptvclient.android.common.f.b.b.j().g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public class e implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private int f4993a;

        e() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            long j;
            b bVar;
            LogEx.d("ControlPlayerFragment", "OnSeekBarChangeListener onProgressChanged. " + i);
            b.this.Y0 = seekBar;
            b bVar2 = b.this;
            bVar2.A0 = (float) bVar2.Y0.getProgress();
            b.this.B0 = r2.Y0.getMax();
            LogEx.d("ControlPlayerFragment", "OnSeekBarChangeListener onStopTrackingTouch == Current  " + b.this.A0 + " max " + b.this.B0);
            b bVar3 = b.this;
            if (bVar3.G1 && bVar3.L != null) {
                if (bVar3.F1 && "2".equals(bVar3.T)) {
                    b bVar4 = b.this;
                    bVar4.n = true;
                    bVar4.j(seekBar.getMax() - i);
                    LogEx.d("ControlPlayerFragment", "OnSeekBarChangeListener onProgressChanged setTstvTime  " + (seekBar.getMax() - i));
                    return;
                }
                b bVar5 = b.this;
                int i2 = i / 1000;
                long j2 = i2;
                bVar5.w(bVar5.h(j2));
                b bVar6 = b.this;
                bVar6.x3 = i;
                if (!bVar6.L.isPlaying()) {
                    b bVar7 = b.this;
                    if (!bVar7.s && bVar7.T1 != 0 && ("1".equals(bVar7.T) || "4".equals(b.this.T))) {
                        b bVar8 = b.this;
                        j = j2;
                        if (bVar8.x3 >= bVar8.E3 * 1000 && !DownloadConstant.REPORT_MSGTYPE_ADD.equals(bVar8.c1)) {
                            b.this.A();
                            b.this.k2();
                        }
                        bVar = b.this;
                        if ((bVar.A || !("1".equals(bVar.T) || "14".equals(b.this.T) || "10".equals(b.this.T))) && !"4".equals(b.this.T)) {
                            return;
                        }
                        LogEx.d("ControlPlayerFragment", "setPlayThumbNaiProgress Programess=" + i);
                        b bVar9 = b.this;
                        bVar9.a(i2, bVar9.h(j), b.this.y3 / 1000);
                        if (z) {
                            int progress = seekBar.getProgress();
                            boolean z2 = progress >= this.f4993a;
                            this.f4993a = progress;
                            b.this.a((seekBar.getProgress() * 100) / seekBar.getMax(), 100, z2);
                            return;
                        }
                        return;
                    }
                }
                j = j2;
                bVar = b.this;
                if (bVar.A) {
                }
                return;
            }
            LogEx.d("ControlPlayerFragment", "SeekBar enable not touching. ");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            LogEx.d("ControlPlayerFragment", "OnSeekBarChangeListener onStartTrackingTouch");
            b.this.Q1 = 0;
            b.this.E1 = true;
            b bVar = b.this;
            bVar.G1 = true;
            if ((bVar.A && ("1".equals(bVar.T) || "14".equals(b.this.T) || "10".equals(b.this.T))) || "4".equals(b.this.T)) {
                b bVar2 = b.this;
                if (bVar2.M5) {
                    bVar2.r1();
                    b.this.a(seekBar.getProgress() / 1000, b.this.h(seekBar.getProgress() / 1000), b.this.y3 / 1000);
                }
                int progress = seekBar.getProgress();
                boolean z = progress >= this.f4993a;
                this.f4993a = progress;
                if (seekBar.getMax() != 0) {
                    b.this.a((seekBar.getProgress() * 100) / seekBar.getMax(), 100, z);
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            b bVar = b.this;
            if (bVar.s && bVar.F1) {
                if (!bVar.m && !bVar.l) {
                    bVar.o = false;
                    bVar.P = (int) bVar.A0;
                    StringBuilder sb = new StringBuilder();
                    sb.append("@TS mseek c/m percent =");
                    b bVar2 = b.this;
                    sb.append(((float) bVar2.P) / bVar2.B0);
                    LogEx.d("ControlPlayerFragment", sb.toString());
                    LogEx.d("ControlPlayerFragment", "@TS onStopTrackingTouch mSeekWhenPrepared == Current  =" + b.this.A0 + " max=" + b.this.B0 + " toStartTsChannelPlay");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("@TS 当前mSeekWhenPrepared=");
                    sb2.append(b.this.P);
                    sb2.append(" seekBarmax=");
                    sb2.append(b.this.B0);
                    LogEx.d("ControlPlayerFragment", sb2.toString());
                    b.this.E2();
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("TS ing mPlayer.guesture seek at ");
                    b bVar3 = b.this;
                    sb3.append(bVar3.A0 - bVar3.B0);
                    sb3.append(" continue play ");
                    LogEx.d("ControlPlayerFragment", sb3.toString());
                    b.this.d(r0.A0 - r0.B0);
                }
            } else {
                b bVar4 = b.this;
                float f = bVar4.A0;
                long j = f >= bVar4.B0 ? bVar4.y3 - 2000 : f;
                long l = b.this.l(j);
                if (l > 0) {
                    LogEx.d("ControlPlayerFragment", "Advertisiment onPlayTimeChangedend having skip insert ad need reSeekValue=" + l);
                    j = l;
                }
                b.this.L.seek(j);
                LogEx.d("ControlPlayerFragment", "onPlayTimeChangedend SeekValue=" + j);
                b.this.C = true;
            }
            b.this.Q1 = 0;
            b.this.E1 = false;
            b bVar5 = b.this;
            bVar5.G1 = false;
            bVar5.n = false;
            bVar5.b(seekBar.getProgress(), seekBar.getMax());
            b.this.F0();
            b.this.E0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public class f implements VerticalSeekBar.a {
        f() {
        }

        @Override // com.zte.iptvclient.common.uiframe.VerticalSeekBar.a
        public void a(VerticalSeekBar verticalSeekBar) {
            b.this.Q1 = 0;
            b.this.E1 = false;
            b bVar = b.this;
            bVar.a4.postDelayed(bVar.V3, 2000L);
            b bVar2 = b.this;
            bVar2.a4.postDelayed(bVar2.W3, 2000L);
        }

        @Override // com.zte.iptvclient.common.uiframe.VerticalSeekBar.a
        public void b(VerticalSeekBar verticalSeekBar) {
            LogEx.d("ControlPlayerFragment", "OnSeekBarChangeListener onStartTrackingTouch");
            b.this.Q1 = 0;
            b.this.E1 = true;
            b bVar = b.this;
            bVar.a4.removeCallbacks(bVar.V3);
            b bVar2 = b.this;
            bVar2.a4.removeCallbacks(bVar2.W3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public class i implements VerticalSeekBar.a {
        i() {
        }

        @Override // com.zte.iptvclient.common.uiframe.VerticalSeekBar.a
        public void a(VerticalSeekBar verticalSeekBar) {
            b.this.Q1 = 0;
            b.this.E1 = false;
        }

        @Override // com.zte.iptvclient.common.uiframe.VerticalSeekBar.a
        public void b(VerticalSeekBar verticalSeekBar) {
            b.this.Q1 = 0;
            b.this.E1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public class j implements f.c {
        j(b bVar) {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void a() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void b() {
        }
    }

    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    class k implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        k(b bVar) {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("ControlPlayerFragment", "reportPlayInfo onDataReturn = " + str);
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("ControlPlayerFragment", "reportPlayInfo onFailReturn = " + str);
        }
    }

    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    class l implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        l(b bVar) {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("ControlPlayerFragment", "reportPlayInfo onDataReturn = " + str);
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("ControlPlayerFragment", "reportPlayInfo onFailReturn = " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!b.this.I1) {
                    b.this.e0();
                } else {
                    b.this.k1();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public class o implements Runnable {
        o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            bVar.D(bVar.f1);
            b bVar2 = b.this;
            bVar2.E(bVar2.D3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public class p implements SDKPrevueMgr.OnPrevueListReturnListener {
        p() {
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnPrevueListReturnListener
        public void onPrevueListReturn(String str, String str2, String str3) {
            LogEx.d("ControlPlayerFragment", "onPrevueListReturn returncode= " + str + "  errmsg " + str2 + "  jsp " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        PrevueBean prevueBeanFromJSon = PrevueBean.getPrevueBeanFromJSon(jSONArray.getJSONObject(i));
                        if (prevueBeanFromJSon != null) {
                            if (!TextUtils.isEmpty(prevueBeanFromJSon.getEndtime())) {
                                prevueBeanFromJSon.setDuration(TimeUtil.format(com.zte.iptvclient.android.common.k.x.d(prevueBeanFromJSon.getBegintime()), "HH:mm") + " - " + TimeUtil.format(com.zte.iptvclient.android.common.k.x.d(prevueBeanFromJSon.getEndtime()), "HH:mm"));
                            }
                            prevueBeanFromJSon.setChannelname(b.this.p5.get(0).e());
                            prevueBeanFromJSon.setChannelTelcomcode(b.this.p5.get(0).p());
                            b.this.e1.add(prevueBeanFromJSon);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (TextUtils.equals("1", ConfigMgr.readPropertie("isTsTvEnable"))) {
                    com.zte.iptvclient.android.mobile.a0.c.b b2 = com.zte.iptvclient.android.mobile.a0.c.b.b();
                    b bVar = b.this;
                    b2.a(bVar.u, bVar.e1);
                }
                b.this.P1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public class q implements SDKChannelMgr.OnChannelDetailWithUrlReturnListener {
        q() {
        }

        @Override // com.video.androidsdk.service.channel.SDKChannelMgr.OnChannelDetailWithUrlReturnListener
        public void onChannelDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d("ControlPlayerFragment", " onChannelDetailWithUrlReturnreturncode= " + str + "  errmsg " + str2 + "  msg " + str3);
            if ("0".equals(str)) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        b.this.p5.add(com.zte.iptvclient.android.common.javabean.models.c.a(jSONArray.getJSONObject(i)));
                    }
                } catch (Exception e) {
                    LogEx.e("ControlPlayerFragment", e.getMessage());
                }
            }
            b.this.B1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public class r implements a.b {
        r() {
        }

        @Override // com.zte.iptvclient.android.mobile.a0.c.a.b
        public void a(int i, String str, List<PrevueBean> list) {
            LogEx.d("ControlPlayerFragment", "onPrevueInfoReturn" + i);
            if (list != null && list.size() != 0) {
                LogEx.d("ControlPlayerFragment", "onPrevueInfoReturn" + i + " List=" + list.size());
                for (int i2 = 0; i2 < list.size(); i2++) {
                    b bVar = b.this;
                    int i3 = (bVar.X1 * bVar.a2) + i2;
                    if (bVar.i1.size() > i3) {
                        if (!TextUtils.isEmpty(list.get(i2).getPrevuename())) {
                            b.this.i1.get(i3).setPrevuename(list.get(i2).getPrevuename());
                        }
                        if (!TextUtils.isEmpty(list.get(i2).getBegintime())) {
                            b.this.i1.get(i3).setbegintime(list.get(i2).getBegintime());
                        }
                    }
                }
                b bVar2 = b.this;
                int[] iArr = bVar2.W1;
                if (iArr != null) {
                    iArr[bVar2.X1] = 1;
                }
                b.this.d1();
                return;
            }
            LogEx.w("ControlPlayerFragment", "prevueInfoList is null or 0");
            b.this.d1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public class s implements SDKBookMarkMgr.OnAddBookMarkReturnListener {
        s() {
        }

        @Override // com.video.androidsdk.service.bookmark.SDKBookMarkMgr.OnAddBookMarkReturnListener
        public void onAddBookMarkReturn(String str, String str2) {
            if (TextUtils.equals("0", str)) {
                if (b.this.x3 == 0) {
                    LogEx.d("ControlPlayerFragment", "PLAYBOOKMARK\u3000del bookMark " + b.this.f1 + " miCurrentPosition" + b.this.x3 + " for" + b.this.e4);
                    b bVar = b.this;
                    bVar.f(bVar.e4, b.this.f4);
                } else {
                    LogEx.d("ControlPlayerFragment", "PLAYBOOKMARK\u3000Add bookMark " + b.this.f1 + " miCurrentPosition=" + b.this.x3 + " for" + b.this.e4);
                    b bVar2 = b.this;
                    bVar2.g(bVar2.e4, b.this.f4);
                }
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.s.b());
                return;
            }
            LogEx.e("ControlPlayerFragment", "PLAYBOOKMARK onAddBookMarkReturn faild returncode=" + str + " errormsg=" + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public class t implements View.OnClickListener {
        t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.L.isPlaying()) {
                b.this.a1();
            } else {
                b.this.P();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public class u implements DownloadListReturnListener {

        /* renamed from: a, reason: collision with root package name */
        private String f5007a;

        public u(String str) {
            this.f5007a = str;
        }

        @Override // com.video.androidsdk.download.Linstener.DownloadListReturnListener
        public void returnDownloadTaskList(String str, int i, String str2, ArrayList<DownloadTask> arrayList) {
            LogEx.d("ControlPlayerFragment", "status = " + str + ", errorCode = " + i + ", errorMsg = " + str2 + ", arraylist = " + arrayList);
            b bVar = b.this;
            bVar.w1 = bVar.a(this.f5007a, arrayList);
            if (b.this.w1 != null) {
                b bVar2 = b.this;
                bVar2.i4 = bVar2.w1.videoInfo.get("bookMarkPoint");
            }
        }
    }

    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public interface v {
    }

    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public interface w {
        void g();
    }

    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public interface x {
        void p();
    }

    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public interface y {
        void a(String str, String str2, String str3, boolean z);
    }

    private void A2() {
        int i2;
        int i3 = ((int) this.x3) / 1000;
        LogEx.d("ControlPlayerFragment", "Advertisiment  playPosition " + i3);
        int R1 = R1();
        LogEx.d("ControlPlayerFragment", "Advertisiment iStartMADIndex " + R1);
        if (i3 >= 0 && i3 <= (i2 = this.y4) && this.w4 == 1) {
            this.U4 = i2 - i3;
            this.V4 = this.B4 - i3;
            this.x4 = true;
            LogEx.d("ControlPlayerFragment", "Advertisiment miVideoTypeInsert = ADB  mLeftTime = " + this.U4 + " >miTotalShowContentLengthB = " + this.y4 + " mCurrentAdPlayLeftTime=" + this.V4 + " CurrentPosition=" + (((int) this.x3) / 1000));
            return;
        }
        long j2 = this.y3;
        if (((int) ((j2 / 1000) - this.z4)) <= i3 && i3 <= ((int) (j2 / 1000)) && this.w4 == 1) {
            this.U4 = ((int) (j2 - this.x3)) / 1000;
            this.V4 = ((((int) j2) / 1000) - this.C4) - i3;
            this.x4 = true;
            LogEx.d("ControlPlayerFragment", "Advertisiment miVideoTypeInsert = ADE  mLeftTime = " + this.U4 + " >miTotalShowContentLengthE = " + this.z4 + " mCurrentAdPlayLeftTime=" + this.V4 + " CurrentPosition=" + (((int) this.x3) / 1000));
            return;
        }
        if (R1 >= 0 && R1 <= i3) {
            int i4 = this.A4;
            if (i3 <= R1 + i4 && this.v4 == 1) {
                this.U4 = (i4 + R1) - i3;
                this.V4 = (this.D4 + R1) - i3;
                this.x4 = true;
                LogEx.d("ControlPlayerFragment", "Advertisiment miVideoTypeInsert = ADM  mLeftTime = " + this.U4 + " >miTotalCurrentShowContentLengthM = " + this.A4 + " mCurrentAdPlayLeftTime=" + this.V4 + " CurrentPosition=" + (((int) this.x3) / 1000));
                return;
            }
        }
        this.U4 = 0;
        if (this.x4) {
            this.x4 = false;
            e0();
        }
        LogEx.d("ControlPlayerFragment", "Advertisiment miVideoType mLeftTime stop update > Normal Positive");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B2() {
        ArrayList<PrevueBean> arrayList;
        P1();
        if (!TextUtils.isEmpty(this.f1) || (arrayList = this.e1) == null || arrayList.size() <= 0) {
            return;
        }
        i1();
    }

    private void C2() {
        LogEx.d("ControlPlayerFragment", "updateTvUI");
        r2();
        if (!this.G1 && !this.C) {
            if (!this.m && !this.l) {
                long j2 = this.C0;
                b((int) j2, (int) j2);
                Date b2 = com.zte.iptvclient.android.common.k.s.b();
                w(h(TimeUtil.calcOffset(b2, com.zte.iptvclient.android.common.k.x.a(b2)) / 1000));
            } else if (this.m && !this.C && !this.G) {
                long j3 = this.y3;
                if (j3 > 0) {
                    if (j3 < this.C0) {
                        this.C0 = (int) j3;
                        LogEx.d("ControlPlayerFragment", "@TS getNew miTsEnableDuration:" + this.C0);
                    } else {
                        LogEx.d("ControlPlayerFragment", "@TS current miTsEnableDuration:" + this.C0);
                    }
                    this.z3 = this.L.getUTCPosition();
                    com.zte.iptvclient.android.common.k.s.b().getTime();
                    this.C3 = this.Y0.getProgress();
                    LogEx.d("ControlPlayerFragment", "@TS getUTCPosition:   " + this.z3 + " mTSUTCTimefor " + this.W0.format(new Date(this.z3)) + " / EPG " + com.zte.iptvclient.android.common.k.s.b().getTime() + " EPG time for = " + this.W0.format(com.zte.iptvclient.android.common.k.s.b()));
                    if (j(this.z3) < 0) {
                        LogEx.d("ControlPlayerFragment", "@TS ts check Enable is false ");
                        return;
                    }
                    long time = com.zte.iptvclient.android.common.k.s.b().getTime() - this.z3;
                    LogEx.d("ControlPlayerFragment", "@TS iCurrentPosition:   " + time);
                    this.x3 = this.C0 - time;
                    LogEx.d("ControlPlayerFragment", "@TS setPlayProgress current is :   " + this.x3 + " Max " + this.C0);
                    long j4 = this.x3;
                    if (((int) j4) <= 0) {
                        Date date = new Date(com.zte.iptvclient.android.common.k.s.b().getTime() - this.C0);
                        LogEx.d("ControlPlayerFragment", "can seek date = " + date);
                        b(date);
                    } else {
                        b((int) j4, (int) this.C0);
                        j((int) time);
                    }
                }
            }
            if (this.T1 != 0) {
                A();
                j2();
                return;
            }
            return;
        }
        LogEx.d("ControlPlayerFragment", "connot need updateTvUI");
    }

    private void D2() {
        if (this.G1) {
            LogEx.d("ControlPlayerFragment", "#current player is not need for doUpdateUI Return ");
            return;
        }
        if (!this.C) {
            b((int) this.x3, (int) this.y3);
            LogEx.d("ControlPlayerFragment", "setPlayProgress iPlayingTime=" + this.x3 + " iContentDuration=" + ((int) this.y3));
            w(h(this.x3 / 1000));
        }
        x(h(this.y3 / 1000));
        if (this.T1 != 0 && (("1".equals(this.T) || "4".equals(this.T)) && this.x3 >= this.E3 * 1000 && !DownloadConstant.REPORT_MSGTYPE_ADD.equals(this.c1))) {
            A();
            k2();
        }
        G1();
        long j2 = this.y3;
        if (j2 == 0 || (this.x3 + 1000) / 1000 < j2 / 1000) {
            return;
        }
        if (this.U4 < 0) {
            this.U4 = 0;
        }
        LogEx.d("ControlPlayerFragment", "playNext");
        O();
    }

    private void E1() {
        LogEx.d("ControlPlayerFragment", "PLAYBOOKMARK\u3000Add bookMark params : mstrBookMarkContentcode" + this.e4 + " miCurrentPosition=" + this.x3 + " mstrBookMarkType=" + this.g4);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("contentcode", this.e4);
        this.h4 = ((int) this.x3) / 1000;
        this.P = Long.parseLong(this.i4) * 1000;
        hashMap.put("breakpoint", String.valueOf(this.h4));
        LogEx.d("ControlPlayerFragment", "addBookMark BREAKPOINT = " + this.h4);
        hashMap.put("columncode", this.f4);
        hashMap.put("bookmarktype", this.g4);
        if (d.e.a.a.a.c()) {
            hashMap.put("isshared", "1");
        } else {
            hashMap.put("isshared", "0");
        }
        hashMap.put("limitaction", d.e.a.a.a.a());
        new SDKBookMarkMgr().doAddBookMark(hashMap, new s());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E2() {
        if (TextUtils.equals("1", ConfigMgr.readPropertie("isTsTvEnable")) && !com.zte.iptvclient.android.mobile.a0.c.b.b().a(this.v3, this.u)) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.unsupport_tstv_tip));
            j0();
        } else {
            A1();
        }
    }

    private boolean F1() {
        return this.R4 < this.k4.size() && this.R4 < this.t4.size() && this.R4 < this.n4.size();
    }

    private int G(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String[] split = str.split(":");
        int length = split.length;
        int i2 = 0;
        for (int i3 = 0; i3 < split.length; i3++) {
            i2 += Integer.parseInt(split[i3]) * ((int) Math.pow(60.0d, (length - 1) - i3));
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b8, code lost:
    
        com.video.androidsdk.log.LogEx.d("ControlPlayerFragment", "Advertisiment miCurrentPosition =" + r11.x3 + " had into Time duration for need start PlayMAD witch index " + r11.S4);
        r11.S4 = r0;
        w2();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void G1() {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.player.k.b.G1():void");
    }

    private void H(String str) {
        ArrayList<Channel> b2 = com.zte.iptvclient.android.common.j.i.d().b();
        for (int i2 = 0; i2 < b2.size(); i2++) {
            if (TextUtils.equals(str, b2.get(i2).getChannelcode())) {
                u(b2.get(i2).getSmallLogo1());
                return;
            }
        }
    }

    private boolean H1() {
        return this.Q4 < this.j4.size() && this.Q4 < this.s4.size() && this.Q4 < this.m4.size();
    }

    private boolean I1() {
        return this.S4 < this.l4.size() && this.S4 < this.u4.size() && this.S4 < this.o4.size() && this.S4 < this.E4.size() && this.S4 < this.G4.size() && this.S4 < this.J4.size();
    }

    private void J1() {
        try {
            if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a() && !this.x4 && this.U == this.V) {
                if (this.H5 != null && this.G5 != null) {
                    if (com.zte.iptvclient.android.common.k.s.b().before(com.zte.iptvclient.android.common.k.x.a(this.L5.format(com.zte.iptvclient.android.common.k.s.b()) + " 12:00:00", "yyyy.MM.dd HH:mm:ss"))) {
                        if (com.zte.iptvclient.android.common.k.s.b().before(this.G5) || this.H5.before(com.zte.iptvclient.android.common.k.s.b())) {
                            LogEx.d("ControlPlayerFragment", "checkPlayTimeDurationLimit stopVideo");
                            this.S5 = -1;
                            C1();
                            m0();
                            k(1);
                        }
                        LogEx.d("ControlPlayerFragment", "checkPlayTimeDurationLimit mEnbalePlayAMStartTime = " + this.G5 + " mEnbalePlayAMEndTime=" + this.H5 + " now " + com.zte.iptvclient.android.common.k.s.b());
                    }
                }
                if (this.J5 == null || this.I5 == null) {
                    return;
                }
                if (com.zte.iptvclient.android.common.k.s.b().after(com.zte.iptvclient.android.common.k.x.a(this.L5.format(com.zte.iptvclient.android.common.k.s.b()) + " 12:00:00", "yyyy.MM.dd HH:mm:ss"))) {
                    if (com.zte.iptvclient.android.common.k.s.b().before(this.I5) || this.J5.before(com.zte.iptvclient.android.common.k.s.b())) {
                        LogEx.d("ControlPlayerFragment", "checkPlayTimeDurationLimit stopVideo");
                        this.S5 = -1;
                        C1();
                        m0();
                        k(1);
                    }
                    LogEx.d("ControlPlayerFragment", "checkPlayTimeDurationLimit mEnbalePlayPMStartTime = " + this.I5 + " mEnbalePlayPMEndTime=" + this.J5 + " now " + com.zte.iptvclient.android.common.k.s.b());
                }
            }
        } catch (Exception unused) {
        }
    }

    private void K1() {
        if (!com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a() || this.F5 <= -1 || this.x4 || this.U != this.V) {
            return;
        }
        LogEx.d("ControlPlayerFragment", "checkPlayedTimeReachedLimit:   ");
        try {
            if (com.zte.iptvclient.android.common.k.s.b().after(com.zte.iptvclient.android.common.k.x.a(this.L5.format(com.zte.iptvclient.android.common.k.s.b()) + " 00:00:00", "yyyy.MM.dd HH:mm:ss"))) {
                if (com.zte.iptvclient.android.common.k.s.b().before(com.zte.iptvclient.android.common.k.x.a(this.L5.format(com.zte.iptvclient.android.common.k.s.b()) + " 00:00:03", "yyyy.MM.dd HH:mm:ss"))) {
                    com.zte.iptvclient.android.mobile.home.tab.helper.a.n().j();
                    if (!TextUtils.isEmpty(com.zte.iptvclient.android.mobile.home.tab.helper.a.n().e())) {
                        this.E5 = Long.parseLong(com.zte.iptvclient.android.mobile.home.tab.helper.a.n().e()) * 60;
                    }
                }
            }
        } catch (Exception e2) {
            LogEx.e("ControlPlayerFragment", "Time check getException " + e2.getMessage());
        }
        long j2 = this.E5;
        if (j2 < 0) {
            LogEx.d("ControlPlayerFragment", "checkPlayedTimeReachedLimit stopVideo");
            this.S5 = -1;
            m0();
            k(0);
        } else {
            this.E5 = j2 - 1;
        }
        LogEx.d("ControlPlayerFragment", "checkPlayedTimeReachedLimit lEnablePlayRemainDuration = " + this.E5 + " lEnbalePlayAllDuration=" + this.F5);
    }

    private void L1() {
        long j2;
        this.E1 = false;
        if (this.L == null) {
            return;
        }
        if (this.G1) {
            if (this.F1 && "2".equals(this.T)) {
                if (this.m || this.l) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("TS ing mPlayer.guesture seek at ");
                    sb.append((this.B3 - 1.0f) * ((float) this.y3));
                    sb.append(" continue play ");
                    LogEx.d("ControlPlayerFragment", sb.toString());
                    this.C = true;
                    d((this.B3 - 1.0f) * ((float) this.C0));
                } else if (this.d2 > 1000.0d) {
                    this.P = this.c2;
                    this.o = false;
                    LogEx.d("ControlPlayerFragment", "@TS  mSeekWhenPrepared=" + this.P);
                    E2();
                }
            } else {
                float f2 = this.B3;
                if (f2 >= 1.0f) {
                    j2 = this.y3 - 2000;
                } else {
                    j2 = f2 * ((float) this.y3);
                }
                long l2 = l(j2);
                if (l2 > 0) {
                    o2();
                    o2();
                    LogEx.d("ControlPlayerFragment", "onPlayTimeChangedend has skip ad need reSeekValue=" + l2);
                    j2 = l2;
                }
                this.L.seek(j2);
                LogEx.d("ControlPlayerFragment", "onPlayTimeChangedend SeekValue=" + j2);
                this.C = true;
            }
            this.G1 = false;
        }
        this.n = false;
        H0();
        E0();
        A0();
        F0();
        this.g5 = 0;
    }

    private void M1() {
        LogEx.d("ControlPlayerFragment", "Advertisiment releasePlayer is called!");
        q0();
        m0();
        this.U = this.V;
        p1();
        this.W4 = false;
        m(this.V0);
        this.U4 = 0;
        this.V4 = 0;
        e(0);
        f1();
        LogEx.d("ControlPlayerFragment", "Advertisiment mTvTimer resetCloseAdBtnState(false)");
    }

    private void N1() {
        this.j4.clear();
        this.U4 = 0;
        this.B4 = 0;
        e(0);
        p2();
        if ("2".equals(this.T)) {
            LogEx.d("ControlPlayerFragment", "Advertisiment start channel play");
            j0();
        } else {
            LogEx.d("ControlPlayerFragment", "Advertisiment onPlayPositive is called!");
            x2();
        }
    }

    private String O1() {
        Date date;
        Date b2 = com.zte.iptvclient.android.common.k.s.b();
        if (this.m && (date = this.v3) != null) {
            b2 = date;
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(b2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P1() {
        ArrayList<PrevueBean> arrayList = this.e1;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        String str = "";
        String str2 = "";
        String str3 = str2;
        for (int i2 = 0; i2 < size; i2++) {
            PrevueBean prevueBean = this.e1.get(i2);
            String begintime = prevueBean.getBegintime();
            String endtime = prevueBean.getEndtime();
            try {
                Date a2 = com.zte.iptvclient.android.common.k.x.a(begintime, "yyyy.MM.dd HH:mm:ss");
                Date a3 = com.zte.iptvclient.android.common.k.x.a(endtime, "yyyy.MM.dd HH:mm:ss");
                Date b2 = com.zte.iptvclient.android.common.k.s.b();
                if (this.m && this.v3 != null) {
                    b2 = this.v3;
                }
                if (a2 != null && a3 != null && a2.before(b2) && a3.after(b2)) {
                    str2 = prevueBean.getPrevuename();
                    str3 = prevueBean.getDuration();
                    str = prevueBean.getRatingid();
                    break;
                }
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
        if (TextUtils.equals(str2, this.f1)) {
            return;
        }
        this.f1 = str2;
        this.D3 = str3;
        LogEx.d("ControlPlayerFragment", "strProgramRatingId:" + str + ",,,mstrProgramName:" + this.f1 + ",,,mstrProgramDuration:" + this.D3);
        this.H0.post(new o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q1() {
        if (this.V0 != null) {
            if (TextUtils.equals(this.n0, "Megogo")) {
                this.c1 = com.zte.iptvclient.android.common.i.a.a.a(R.string.auto);
            } else {
                this.c1 = this.h2;
            }
        }
    }

    private int R1() {
        ArrayList<Integer> arrayList = this.H4;
        if (arrayList == null || this.S4 >= arrayList.size()) {
            return -1;
        }
        return this.H4.get(this.S4).intValue();
    }

    private com.zte.iptvclient.android.common.player.k.c S1() {
        if (getActivity() instanceof MainActivity) {
            return ((MainActivity) getActivity()).t();
        }
        if (getActivity() instanceof VOPlayerActivity) {
            return ((VOPlayerActivity) getActivity()).r();
        }
        return ((HostActivity) getActivity()).r();
    }

    private void T1() {
        String c2;
        if ("2".equals(this.T)) {
            String c3 = com.zte.iptvclient.common.uiframe.a.c("TV_Preview_Duration");
            LogEx.d("ControlPlayerFragment", "Property strPreDuration is  ===========  " + c3);
            try {
                this.E3 = Integer.parseInt(TextUtils.isEmpty(c3) ? "0" : c3);
                LogEx.d("ControlPlayerFragment", "mPreviewTimeOrSitComNO is  ===========  " + this.E3);
                return;
            } catch (Exception unused) {
                LogEx.e("ControlPlayerFragment", "strPreDuration can not be parsed to int");
                this.E3 = 0;
                return;
            }
        }
        if (!"1".equals(this.T) && !"10".equals(this.T) && !"15".equals(this.T)) {
            if ("4".equals(this.T)) {
                String c4 = com.zte.iptvclient.common.uiframe.a.c("TV_Preview_Duration");
                LogEx.d("ControlPlayerFragment", "strPreDuration is  ===========  " + c4);
                try {
                    this.E3 = Integer.parseInt(TextUtils.isEmpty(c4) ? "0" : c4);
                    LogEx.d("ControlPlayerFragment", "mPreviewTimeOrSitComNO is  ===========  " + this.E3);
                    return;
                } catch (Exception unused2) {
                    LogEx.e("ControlPlayerFragment", "strPreDuration can not be parsed to int");
                    this.E3 = 0;
                    return;
                }
            }
            return;
        }
        if (this.T.equals("1")) {
            if (com.zte.iptvclient.android.common.f.b.g.a()) {
                LogEx.d("ControlPlayerFragment", "mstrPreDuration is  ===========  " + this.z5);
                String str = this.z5;
                if (str == null) {
                    str = "0";
                }
                this.z5 = str;
                c2 = str.equals("0") ? com.zte.iptvclient.common.uiframe.a.c("VOD_Preview_Duration") : this.z5;
            } else {
                c2 = com.zte.iptvclient.common.uiframe.a.c("VOD_Preview_Duration");
            }
            try {
                this.E3 = Integer.parseInt(TextUtils.isEmpty(c2) ? "0" : c2);
                LogEx.d("ControlPlayerFragment", "mPreviewTimeOrSitComNO is  ===========  " + this.E3);
                return;
            } catch (Exception unused3) {
                LogEx.e("ControlPlayerFragment", "strPreDuration can not be parsed to int");
                this.E3 = 0;
                return;
            }
        }
        String c5 = com.zte.iptvclient.common.uiframe.a.c("Series_Preview_Nums");
        LogEx.d("ControlPlayerFragment", "strPreEpisodes is  ===========  " + c5);
        try {
            this.E3 = Integer.parseInt(TextUtils.isEmpty(c5) ? "0" : c5);
            LogEx.d("ControlPlayerFragment", "mPreviewTimeOrSitComNO is  ===========  " + this.E3);
        } catch (Exception unused4) {
            LogEx.e("ControlPlayerFragment", "strPreDuration can not be parsed to int");
            this.E3 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U1() {
        RelativeLayout relativeLayout;
        if (this.z) {
            return;
        }
        RelativeLayout relativeLayout2 = this.f;
        if ((relativeLayout2 != null && relativeLayout2.getVisibility() == 0) || ((relativeLayout = this.g) != null && relativeLayout.getVisibility() == 0)) {
            if (this.Q1 > 5 && !f2()) {
                E();
                this.Q1 = 0;
                return;
            } else {
                if (this.E1) {
                    return;
                }
                this.Q1++;
                return;
            }
        }
        if (this.s5) {
            CheckBox checkBox = this.t5;
            if (checkBox == null || checkBox.getVisibility() != 0) {
                return;
            }
            if (this.Q1 > 5 && !f2()) {
                E();
                this.Q1 = 0;
                return;
            } else {
                if (this.E1) {
                    return;
                }
                this.Q1++;
                return;
            }
        }
        this.Q1 = 0;
    }

    private void V1() {
    }

    private void W1() {
        this.H3 = new ViewOnClickListenerC0150b();
    }

    private void X1() {
        this.I3 = new c();
    }

    private void Y1() {
        this.G3 = new t();
    }

    private void Z1() {
        this.Y3 = new i();
        LogEx.d("ControlPlayerFragment", "initSeekbarVolumeListnerTwo " + this.Y3);
    }

    private void a2() {
        this.X3 = new h();
        LogEx.d("ControlPlayerFragment", "initSeekbarVolumeListnerTwo " + this.X3);
    }

    private void b2() {
        this.K3 = new e();
    }

    private void c2() {
        this.R3 = new f();
        LogEx.d("ControlPlayerFragment", "OnSeekBarChangeListenerinit. " + this.R3);
    }

    private void d2() {
        this.Q3 = new g();
        LogEx.d("ControlPlayerFragment", "initSeekbarVolumeListnerTwo " + this.Q3);
    }

    private void e2() {
        this.J3 = new d(this);
    }

    private boolean f2() {
        com.zte.iptvclient.android.common.player.b bVar = this.a5;
        if (bVar != null && bVar.isShowing()) {
            return true;
        }
        com.zte.iptvclient.android.common.player.b bVar2 = this.b5;
        if (bVar2 != null && bVar2.isShowing()) {
            return true;
        }
        com.zte.iptvclient.android.common.player.h hVar = this.c5;
        return (hVar != null && hVar.isShowing()) || O0();
    }

    private void g2() {
        if (this.O0 != null) {
            Date b2 = com.zte.iptvclient.android.common.k.s.b();
            this.R0 = b2;
            com.zte.iptvclient.android.common.player.f.b(this.O0, this.R0, b2.getTime() - this.O0.getTime());
            LogEx.d("PlayerHelper", "onADBPlay report!");
            this.O0 = null;
        }
        LogEx.d("ControlPlayerFragment", "Advertisiment onADBPlay start!");
        if (this.Q4 >= this.p4.size()) {
            N1();
            return;
        }
        int intValue = this.p4.get(this.Q4).intValue();
        this.B4 = intValue;
        this.y4 -= intValue;
        LogEx.d("ControlPlayerFragment", "Advertisiment miTotalShowContentLengthB :" + this.y4 + " mlistForwardAds.size " + this.j4.size());
        if (this.m4.get(this.Q4).intValue() > 0) {
            this.T4 = this.j4.get(this.Q4);
            LogEx.d("ControlPlayerFragment", "Advertisiment start play adB for ad index (mIAdBCurrentIndex)= " + this.Q4 + " Can playnum " + this.m4.get(this.Q4));
            this.w4 = this.s4.get(this.Q4).intValue();
            LogEx.d("ControlPlayerFragment", "Advertisiment mAdURL=" + this.T4 + " miStreamTypeAD " + this.w4);
            ArrayList<Integer> arrayList = this.m4;
            int i2 = this.Q4;
            arrayList.set(i2, Integer.valueOf(arrayList.get(i2).intValue() + (-1)));
            LogEx.d("ControlPlayerFragment", "Advertisiment start play adB for ad index (mIAdBCurrentIndex) =" + this.Q4 + " update left playnum " + this.m4.get(this.Q4));
            if (!TextUtils.isEmpty(this.T4)) {
                t(this.T4);
                this.T4 = null;
                N();
                return;
            } else if ("2".equals(this.T)) {
                LogEx.d("ControlPlayerFragment", "start channel play");
                j0();
                return;
            } else {
                LogEx.d("ControlPlayerFragment", "onPlayPositive is called!");
                x2();
                return;
            }
        }
        if (this.Q4 < this.j4.size()) {
            this.Q4++;
            if (!H1()) {
                N1();
                return;
            }
            this.B4 = this.p4.get(this.Q4).intValue();
            this.T4 = this.j4.get(this.Q4);
            this.w4 = this.s4.get(this.Q4).intValue();
            LogEx.d("ControlPlayerFragment", "Advertisiment mAdURL-----" + this.T4 + " miStreamTypeAD " + this.w4);
            LogEx.d("ControlPlayerFragment", "Advertisiment start play adB for ad index (mIAdBCurrentIndex)=" + this.Q4 + " can playnum " + this.m4.get(this.Q4));
            ArrayList<Integer> arrayList2 = this.m4;
            int i3 = this.Q4;
            arrayList2.set(i3, Integer.valueOf(arrayList2.get(i3).intValue() + (-1)));
            LogEx.d("ControlPlayerFragment", "Advertisiment start play adB for ad index (mIAdBCurrentIndex) =" + this.Q4 + " left playnum " + this.m4.get(this.Q4));
            if (!TextUtils.isEmpty(this.T4)) {
                LogEx.d("ControlPlayerFragment", "Advertisiment start play adB");
                t(this.T4);
                this.T4 = null;
                N();
                return;
            }
            this.j4.clear();
            if ("2".equals(this.T)) {
                LogEx.d("ControlPlayerFragment", "Advertisiment start channel play");
                j0();
                return;
            } else {
                LogEx.d("ControlPlayerFragment", "Advertisiment onPlayPositive is called!");
                x2();
                return;
            }
        }
        N1();
    }

    private void h2() {
        if (this.Q0 != null) {
            Date b2 = com.zte.iptvclient.android.common.k.s.b();
            this.T0 = b2;
            com.zte.iptvclient.android.common.player.f.a(this.Q0, this.T0, b2.getTime() - this.Q0.getTime());
            this.Q0 = null;
        }
        LogEx.d("PlayerHelper", "onADEPlay report!");
        LogEx.d("ControlPlayerFragment", "Advertisiment onADEPlay start!");
        if (this.R4 >= this.q4.size()) {
            M1();
            return;
        }
        int intValue = this.q4.get(this.R4).intValue();
        this.C4 = intValue;
        this.z4 -= intValue;
        LogEx.d("ControlPlayerFragment", "Advertisiment  miTotalShowContentLengthE :" + this.z4 + " mlistAfterAds.size() " + this.k4.size());
        if (this.n4.get(this.R4).intValue() > 0) {
            LogEx.d("ControlPlayerFragment", "Advertisiment Current mIAdECurrentIndex is： " + this.R4);
            this.T4 = this.k4.get(this.R4);
            this.w4 = this.t4.get(this.R4).intValue();
            LogEx.d("ControlPlayerFragment", "Advertisiment mAdURL-----" + this.T4 + " miStreamTypeAD " + this.w4);
            ArrayList<Integer> arrayList = this.n4;
            int i2 = this.R4;
            arrayList.set(i2, Integer.valueOf(arrayList.get(i2).intValue() + (-1)));
            if (!TextUtils.isEmpty(this.T4)) {
                LogEx.d("ControlPlayerFragment", "Advertisiment start play adEfor ad index=" + this.R4 + " left playnum " + this.n4.get(this.R4));
                t(this.T4);
                this.T4 = null;
                N();
                return;
            }
            M1();
            return;
        }
        if (this.R4 < this.k4.size()) {
            this.R4++;
            if (!F1()) {
                M1();
                return;
            }
            this.C4 = this.q4.get(this.R4).intValue();
            this.T4 = this.k4.get(this.R4);
            this.w4 = this.t4.get(this.R4).intValue();
            LogEx.d("ControlPlayerFragment", "Advertisiment mAdURL-----" + this.T4 + " miStreamTypeAD " + this.w4);
            LogEx.d("ControlPlayerFragment", "Advertisiment start play adE for ad index=" + this.R4 + " can playnum " + this.n4.get(this.R4));
            ArrayList<Integer> arrayList2 = this.n4;
            int i3 = this.R4;
            arrayList2.set(i3, Integer.valueOf(arrayList2.get(i3).intValue() + (-1)));
            LogEx.d("ControlPlayerFragment", "Advertisiment Current mIAdECurrentIndex is： " + this.R4);
            if (!TextUtils.isEmpty(this.T4)) {
                LogEx.d("ControlPlayerFragment", "Advertisiment start play adE for ad index=" + this.R4 + " left playnum " + this.n4.get(this.R4));
                t(this.T4);
                this.T4 = null;
                N();
                return;
            }
            M1();
            return;
        }
        M1();
    }

    private void i2() {
        if (this.P0 != null) {
            Date b2 = com.zte.iptvclient.android.common.k.s.b();
            this.S0 = b2;
            com.zte.iptvclient.android.common.player.f.c(this.P0, this.S0, b2.getTime() - this.P0.getTime());
            this.P0 = null;
        }
        LogEx.d("PlayerHelper", "onADMPlay report!");
        LogEx.d("ControlPlayerFragment", "Advertisiment onADMPlay start!");
        if (this.S4 >= this.o4.size()) {
            LogEx.e("ControlPlayerFragment", "Advertisiment onADMPlay encourted exception!");
            return;
        }
        this.Z4--;
        if (this.S4 < this.l4.size() && this.S4 < this.u4.size()) {
            this.D4 = this.r4.get(this.S4).intValue();
            this.o4.set(this.S4, Integer.valueOf(this.Z4));
            this.F4 = this.G4.get(this.S4).intValue();
            this.I4 = String.valueOf(this.J4.get(this.S4));
            LogEx.d("ControlPlayerFragment", "Advertisiment mIAdMCurrentIndex is：" + this.S4 + " leftPlayNum=" + this.Z4);
            StringBuilder sb = new StringBuilder();
            sb.append("Advertisiment mlistMiddleAds.size() is：");
            sb.append(this.l4.size());
            LogEx.d("ControlPlayerFragment", sb.toString());
            if (this.Z4 > 0) {
                this.T4 = this.l4.get(this.S4);
                this.v4 = this.u4.get(this.S4).intValue();
                LogEx.d("ControlPlayerFragment", "Advertisiment onADMPlay mAdURL = " + this.T4);
                if (!TextUtils.isEmpty(this.T4)) {
                    LogEx.d("ControlPlayerFragment", "Advertisiment start play adM");
                    t(this.T4);
                    N();
                    this.T4 = null;
                } else {
                    LogEx.d("ControlPlayerFragment", "Advertisiment onPlayPositive is called!");
                    x2();
                }
                LogEx.d("ControlPlayerFragment", "Advertisiment onMPlay ");
                return;
            }
            LogEx.d("ControlPlayerFragment", "Advertisiment onPlayPositive is called!");
            this.U4 = 0;
            this.V4 = 0;
            e(0);
            q2();
            x2();
            return;
        }
        LogEx.d("ControlPlayerFragment", "Advertisiment onPlayPositive is called!");
        this.U4 = 0;
        this.V4 = 0;
        e(0);
        q2();
        x2();
    }

    private void j2() {
        this.J1 = false;
        W0();
        i(this.E3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k2() {
        this.J1 = false;
        W0();
        if (this.B && this.A) {
            i0();
        }
        i(this.E3);
    }

    private void l2() {
        if (TextUtils.equals("1", ConfigMgr.readPropertie("isTsTvEnable"))) {
            if (a(this.v3)) {
                Date a2 = com.zte.iptvclient.android.mobile.a0.c.b.b().a();
                if (a2 != null) {
                    if (a2.before(com.zte.iptvclient.android.common.k.s.b())) {
                        this.v3 = a2;
                        int c2 = c(a2);
                        if (c2 > 0 && c2 > 1000) {
                            j(c2);
                            this.P = this.C0 - c2;
                            LogEx.d("ControlPlayerFragment", "时移 getenablebew Time mSeekWhenPrepared" + this.P);
                            b((int) this.P, (int) this.C0);
                        } else {
                            LogEx.d("ControlPlayerFragment", "时移enable false to exit! for   Offset < 1s");
                            j0();
                            return;
                        }
                    } else {
                        LogEx.d("ControlPlayerFragment", "时移enable false to exit!   ");
                        j0();
                        return;
                    }
                }
            } else {
                LogEx.d("ControlPlayerFragment", "时移enable false to exit!   ");
                j0();
                return;
            }
        }
        A1();
    }

    private void m2() {
        LogEx.d("ControlPlayerFragment", "###processPlayer");
        if (this.T1 != 0 && this.E3 <= 0) {
            m0();
            return;
        }
        if ("2".equals(this.T)) {
            this.J1 = true;
            ArrayList<String> arrayList = this.j4;
            if (arrayList != null && arrayList.size() > 0) {
                this.O0 = com.zte.iptvclient.android.common.k.s.b();
                v2();
                return;
            }
            boolean z2 = this.V0.getBoolean("isFromLastPrevue");
            this.u3 = z2;
            if (z2 && this.F1) {
                A1();
                return;
            } else {
                j0();
                LogEx.d("ControlPlayerFragment", "start channel play");
                return;
            }
        }
        this.l = false;
        this.m = false;
        z1();
        G0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n2() {
        try {
            if (Build.VERSION.SDK_INT <= 23) {
                this.S3.setRingerMode(2);
                return;
            }
            NotificationManager notificationManager = (NotificationManager) getActivity().getApplication().getSystemService("notification");
            if (this.S3.getRingerMode() == 0) {
                if (notificationManager.isNotificationPolicyAccessGranted()) {
                    this.S3.setRingerMode(2);
                    return;
                } else {
                    getActivity().getApplication().startActivity(new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS"));
                    return;
                }
            }
            this.S3.setRingerMode(2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void o2() {
        Bundle bundle = this.V0;
        if (bundle != null) {
            try {
                this.z4 = Integer.parseInt(b(bundle, "Total_ContentLengthE"));
                this.F4 = Integer.parseInt(b(bundle, "CloseTime"));
            } catch (Exception unused) {
                this.F4 = -1;
                q0();
                LogEx.w("ControlPlayerFragment", "ad length is null!");
            }
            this.R4 = 0;
            this.I4 = b(bundle, ParamConst.SEARCH_REQ_SHOWTIME);
            this.k4 = c(bundle, "VodListE");
            this.q4 = a(bundle, "ContentLengthE");
            this.n4 = a(bundle, "PlayNumE");
            ArrayList<Integer> a2 = a(bundle, "StreamContentTypeE");
            this.t4 = a2;
            if (this.R4 < a2.size()) {
                this.w4 = this.t4.get(this.R4).intValue();
            }
        } else {
            q0();
        }
        this.x4 = false;
    }

    private void p2() {
        Bundle bundle = this.V0;
        if (bundle != null) {
            try {
                this.y4 = Integer.parseInt(b(bundle, "Total_ContentLengthB"));
                this.F4 = Integer.parseInt(b(bundle, "CloseTime"));
            } catch (Exception unused) {
                this.F4 = -1;
                q0();
                LogEx.w("ControlPlayerFragment", "ad length is null!");
            }
            this.I4 = b(bundle, ParamConst.SEARCH_REQ_SHOWTIME);
            this.Q4 = 0;
            this.j4 = c(bundle, "VodListB");
            this.p4 = a(bundle, "ContentLengthB");
            this.m4 = a(bundle, "PlayNumB");
            ArrayList<Integer> a2 = a(bundle, "StreamContentTypeB");
            this.s4 = a2;
            if (this.Q4 < a2.size()) {
                this.w4 = this.s4.get(this.Q4).intValue();
            }
        } else {
            q0();
        }
        this.x4 = false;
    }

    private void q2() {
        Bundle bundle = this.V0;
        if (bundle != null) {
            this.S4 = 0;
            this.l4 = c(bundle, "VodListM");
            this.r4 = a(bundle, "ContentLengthM");
            this.o4 = a(bundle, "PlayNumM");
            this.E4 = a(bundle, "Total_ContentLengthM");
            this.G4 = a(bundle, "CloseMiddleTime");
            this.H4 = a(bundle, "OffsetMiddleTime");
            this.J4 = a(bundle, "ShowMiddleTime");
            ArrayList<Integer> a2 = a(bundle, "StreamContentTypeM");
            this.u4 = a2;
            if (this.S4 < a2.size()) {
                this.v4 = this.u4.get(this.S4).intValue();
                return;
            }
            return;
        }
        q0();
    }

    private void r2() {
        Date b2 = com.zte.iptvclient.android.common.k.s.b();
        x(h(TimeUtil.calcOffset(b2, com.zte.iptvclient.android.common.k.x.a(b2)) / 1000));
    }

    private void s2() {
        if (this.P <= 0 || this.l4.size() <= 0 || this.u4.size() <= 0) {
            return;
        }
        int intValue = this.u4.get(0).intValue();
        this.v4 = intValue;
        if (intValue == 1) {
            k(this.P);
        }
    }

    private void t2() {
        try {
            if (com.zte.iptvclient.android.common.f.b.g.d() != -1) {
                int parseInt = Integer.parseInt(this.i4);
                int parseInt2 = Integer.parseInt(this.x5);
                ((MainActivity) this.f4977b).t().V2();
                if (x0() && parseInt != 0) {
                    this.P = parseInt * 1000;
                    this.D = false;
                } else if (com.zte.iptvclient.android.common.f.b.g.h()) {
                    this.D = true;
                    this.P = parseInt2 * 1000;
                } else {
                    this.P = 0L;
                    this.D = false;
                }
            } else {
                this.P = Long.parseLong(this.i4) * 1000;
                LogEx.d("ControlPlayerFragment", "@TS PLAYBOOKMARK  mSeekWhenPrepared=" + this.P);
            }
        } catch (Exception unused) {
            LogEx.e("ControlPlayerFragment", "PLAYBOOKMARK mstrBreakPoint can not be parsed to int mSeekWhenPrepared = 0");
            this.P = 0L;
        }
    }

    private void u2() {
        this.R4 = 0;
        if (!F1()) {
            M1();
            LogEx.e("ControlPlayerFragment", "Advertisiment startPlayBackUpAd encourter Exception !!!");
            return;
        }
        o2();
        this.C4 = this.q4.get(this.R4).intValue();
        this.T4 = this.k4.get(this.R4);
        this.w4 = this.t4.get(this.R4).intValue();
        LogEx.d("ControlPlayerFragment", "Advertisiment miStreamTypeAD " + this.w4);
        LogEx.d("ControlPlayerFragment", "Advertisiment start play adE index = 0,allPlayNum=" + this.n4.get(this.R4));
        ArrayList<Integer> arrayList = this.n4;
        int i2 = this.R4;
        arrayList.set(i2, Integer.valueOf(arrayList.get(i2).intValue() - 1));
        if (!TextUtils.isEmpty(this.T4)) {
            E1();
            f1();
            LogEx.d("ControlPlayerFragment", "Advertisiment mTvTimer resetCloseAdBtnState(false)");
            this.U = this.X;
            k1();
            LogEx.d("ControlPlayerFragment", "Advertisiment start play adE");
            t(this.T4);
            this.T4 = null;
            N();
            this.Q0 = com.zte.iptvclient.android.common.k.s.b();
            return;
        }
        if (this.w4 == 1) {
            this.Y1 = this.Z1;
            if ("4".equals(this.T) && !this.u5 && this.B) {
                R();
            } else {
                M1();
                LogEx.d("ControlPlayerFragment", "Advertisiment mTvTimer resetCloseAdBtnState(false)");
            }
        }
    }

    private void v2() {
        this.Q4 = 0;
        if (!H1()) {
            if ("2".equals(this.T)) {
                LogEx.d("ControlPlayerFragment", "start channel play");
                j0();
            } else {
                LogEx.d("ControlPlayerFragment", "onPlayPositive is called!");
                x2();
            }
            LogEx.e("ControlPlayerFragment", "startPlayFrontAd enourted Exception!!!");
            return;
        }
        p2();
        this.B4 = this.p4.get(this.Q4).intValue();
        this.T4 = this.j4.get(this.Q4);
        this.w4 = this.s4.get(this.Q4).intValue();
        LogEx.d("ControlPlayerFragment", "Advertisiment mAdURL-----" + this.T4 + " miStreamTypeAD " + this.w4);
        LogEx.d("ControlPlayerFragment", "Advertisiment startPlayFrontAd index (mIAdBCurrentIndex)= " + this.Q4 + " can PaluNum : " + this.m4.get(this.Q4));
        if (!TextUtils.isEmpty(this.T4)) {
            ArrayList<Integer> arrayList = this.m4;
            int i2 = this.Q4;
            arrayList.set(i2, Integer.valueOf(arrayList.get(i2).intValue() - 1));
            LogEx.d("ControlPlayerFragment", "Advertisiment mlistFrontAdsNeedPlayedNum. updated index (mIAdBCurrentCount) " + this.Q4 + " lefted playNum=" + this.m4.get(this.Q4));
            this.U = this.W;
            LogEx.d("ControlPlayerFragment", "Advertisiment start play adB");
            k1();
            f1();
            LogEx.d("ControlPlayerFragment", "Advertisiment mTvTimer resetCloseAdBtnState(false)");
            t(this.T4);
            Q();
            this.T4 = null;
            this.O0 = com.zte.iptvclient.android.common.k.s.b();
            return;
        }
        if (this.w4 == 1) {
            k1();
        }
        if ("2".equals(this.T)) {
            LogEx.d("ControlPlayerFragment", "start channel play");
            j0();
        } else {
            LogEx.d("ControlPlayerFragment", "onPlayPositive is called!");
            x2();
        }
    }

    private void w2() {
        if (!I1()) {
            LogEx.e("ControlPlayerFragment", "Advertisiment startPlayMiddleAd :encouterException");
            return;
        }
        this.T4 = this.l4.get(this.S4);
        this.v4 = this.u4.get(this.S4).intValue();
        this.Z4 = this.o4.get(this.S4).intValue();
        LogEx.d("ControlPlayerFragment", "Advertisiment startPlayMiddleAd current index " + this.S4 + " All PaluNum : " + this.Z4);
        StringBuilder sb = new StringBuilder();
        sb.append("Advertisiment mMiddleAdURL : ");
        sb.append(this.T4);
        LogEx.d("ControlPlayerFragment", sb.toString());
        this.A4 = this.E4.get(this.S4).intValue();
        this.D4 = this.r4.get(this.S4).intValue();
        this.F4 = this.G4.get(this.S4).intValue();
        this.I4 = String.valueOf(this.J4.get(this.S4));
        LogEx.d("ControlPlayerFragment", "Advertisiment miTotalCurrentShowContentLengthM : " + this.A4);
        this.o4.set(this.S4, Integer.valueOf(this.Z4 + (-1)));
        LogEx.d("ControlPlayerFragment", "Advertisiment mlistMiddleAdsNeedPlayedNum.getindex= " + this.S4 + " leftPlayNum=" + this.o4.get(this.S4));
        if (!TextUtils.isEmpty(this.T4)) {
            E1();
            this.i4 = String.valueOf((this.x3 + 1000) / 1000);
            this.U = this.Y;
            k1();
            f1();
            LogEx.d("ControlPlayerFragment", "Advertisiment mTvTimer resetCloseAdBtnState(false)");
            t(this.T4);
            N();
            this.T4 = null;
            LogEx.d("ControlPlayerFragment", "Advertisiment start play adM");
            this.P0 = com.zte.iptvclient.android.common.k.s.b();
            return;
        }
        LogEx.d("ControlPlayerFragment", "Advertisiment mMiddleAdURL is null");
    }

    private void x2() {
        LogEx.d("ControlPlayerFragment", "mPath-----miVideoType VIDEO_TYPE_POSITIVE");
        this.N5 = false;
        this.Y1 = -1;
        this.a4.post(new n());
        LogEx.d("ControlPlayerFragment", "mPath-----" + this.f2);
        if (!TextUtils.isEmpty(this.f2)) {
            LogEx.d("ControlPlayerFragment", "play is called!");
            t2();
            s2();
            LogEx.d("ControlPlayerFragment", "Advertisiment end PlayPosizive  mSeekWhenPrepared= " + this.P);
            if (this.J) {
                t(this.f2);
                Q();
            } else {
                t(this.f2);
                N();
            }
        } else {
            m0();
            g0();
        }
        this.U = this.V;
    }

    private void y2() {
        int i2 = this.U;
        if (i2 == this.W) {
            int i3 = this.y4;
            long j2 = this.x3;
            this.U4 = i3 - (((int) j2) / 1000);
            this.V4 = this.B4 - (((int) j2) / 1000);
            LogEx.d("ControlPlayerFragment", "Advertisiment miVideoType = ADB  mLeftTime = " + this.U4 + " >miTotalShowContentLengthB = " + this.y4 + " mCurrentAdPlayLeftTime=" + this.V4 + " CurrentPosition=" + (((int) this.x3) / 1000));
        } else if (i2 == this.X) {
            int i4 = this.z4;
            long j3 = this.x3;
            this.U4 = i4 - (((int) j3) / 1000);
            this.V4 = this.C4 - (((int) j3) / 1000);
            LogEx.d("ControlPlayerFragment", "Advertisiment miVideoType = ADE  mLeftTime = " + this.U4 + " >miTotalShowContentLengthE = " + this.z4 + " mCurrentAdPlayLeftTime=" + this.V4 + " CurrentPosition=" + (((int) this.x3) / 1000));
        } else if (i2 == this.Y) {
            if (!this.N5) {
                long j4 = this.x3;
                if (j4 / 1000 > 1) {
                    this.U4 = this.A4;
                    this.V4 = this.D4;
                } else {
                    this.U4 = this.A4 - (((int) j4) / 1000);
                    this.V4 = this.D4 - (((int) j4) / 1000);
                    this.N5 = true;
                }
            } else {
                if (this.x3 / 1000 <= 1 && this.S4 < this.r4.size()) {
                    this.A4 = this.r4.get(this.S4).intValue() * this.Z4;
                }
                int i5 = this.A4;
                long j5 = this.x3;
                this.U4 = i5 - (((int) j5) / 1000);
                this.V4 = this.D4 - (((int) j5) / 1000);
            }
            LogEx.d("ControlPlayerFragment", "Advertisiment miVideoType = ADM  mLeftTime = " + this.U4 + " >miTotalCurrentShowContentLengthM = " + this.A4 + " miCurrentPlayContentLengthM=" + this.D4 + " CurrentPosition=" + (((int) this.x3) / 1000));
        } else if (i2 == this.V) {
            A2();
            if (this.x4) {
                k1();
            }
        }
        e(this.U4);
        if (this.V4 >= 1 || this.x4 || this.U == this.V) {
            return;
        }
        O();
    }

    private void z2() {
        if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
            com.zte.iptvclient.android.common.f.b.b.j().b(1);
            if ("2".equals(this.T)) {
                if (this.m) {
                    com.zte.iptvclient.android.common.f.b.b.j().c(2);
                    return;
                } else {
                    com.zte.iptvclient.android.common.f.b.b.j().c(0);
                    return;
                }
            }
            if ("4".equals(this.T)) {
                com.zte.iptvclient.android.common.f.b.b.j().c(1);
            } else {
                com.zte.iptvclient.android.common.f.b.b.j().c(-1);
            }
        }
    }

    protected void A(String str) {
    }

    protected void A0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A1() {
        this.t = true;
        if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
            com.zte.iptvclient.android.common.f.b.b.j().d((int) this.C0);
        }
        if (TextUtils.equals("1", ConfigMgr.readPropertie("isFeatureAuth"))) {
            com.zte.iptvclient.android.common.h.a.a().a(S1());
        }
        c1();
        G0();
        h0();
        m0();
        f(false);
        this.K = false;
        this.l = true;
        this.m = false;
        c0();
        if (!this.M1) {
            this.i2 = v(this.f2);
        } else {
            this.i2 = this.f2;
        }
        if (this.i2 != null) {
            if (com.zte.iptvclient.android.common.k.i.c()) {
                this.L.setSourceType(SourceType.STE_SOURCE_TYPE_MPD);
            }
            t(this.i2);
        }
        Q();
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void B() {
        IBasePlayer iBasePlayer = this.M;
        if (iBasePlayer == null) {
            return;
        }
        double duration = iBasePlayer.getDuration();
        Double.isNaN(duration);
        this.r0 = (int) Math.ceil(duration / 1000.0d);
    }

    protected void B(String str) {
    }

    protected void B0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B1() {
    }

    protected void C(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C0() {
    }

    public void C1() {
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            try {
                if (TextUtils.isEmpty(com.zte.iptvclient.android.mobile.home.tab.helper.a.n().e())) {
                    return;
                }
                LogEx.d("ControlPlayerFragment", "now current  lEnablePlayRemainDuration " + this.E5);
                if (this.F5 < 0) {
                    Q0();
                }
                if (this.E5 != 0) {
                    LogEx.d("ControlPlayerFragment", "stop Play now current store local lEnablePlayRemainDuration " + this.E5);
                    com.zte.iptvclient.android.mobile.home.tab.helper.a.n().d(String.valueOf(this.E5));
                    return;
                }
                LogEx.d("ControlPlayerFragment", "stop Play now current store local lEnablePlayRemainDuration 0");
                com.zte.iptvclient.android.mobile.home.tab.helper.a.n().d("0");
            } catch (Exception e2) {
                LogEx.e("ControlPlayerFragment", "updatePlayedRemainTime " + e2.getMessage());
            }
        }
    }

    public void D(String str) {
    }

    protected void D0() {
    }

    protected void D1() {
    }

    protected void E(String str) {
    }

    protected void E0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(String str) {
        SeekBar seekBar;
        this.C = false;
        v1();
        if (!TextUtils.equals(this.n0, "Megogo") && !TextUtils.equals(this.n0, "ivi")) {
            e(true);
            if (com.zte.iptvclient.android.common.player.f.c(str)) {
                return;
            }
        }
        z(str);
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.i());
        if (this.s) {
            if (!this.m && !this.l) {
                LogEx.d("ControlPlayerFragment", "startChannelPlay");
                j0();
                return;
            }
            if (this.Y0 != null) {
                this.P = r4.getProgress();
            }
            LogEx.d("ControlPlayerFragment", "@TSmSeekWhenPrepared=" + this.P);
            A1();
            return;
        }
        if (!this.J && (seekBar = this.Y0) != null) {
            this.P = seekBar.getProgress();
        }
        h0();
        m0();
        t(this.f2);
        Q();
    }

    protected void F0() {
    }

    protected void G0() {
    }

    protected void H0() {
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void I() {
        LogEx.d("ControlPlayerFragment", "liveSeekTo mSeekWhenPrepared --- " + this.P);
        if (this.u3) {
            this.u3 = false;
            try {
                Date parse = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").parse(this.V0.getString("liveBeginTime"));
                LogEx.d("date.getTime() = " + parse.getTime(), "mPlayer.getAvailabilityStartTime()=" + this.L.getAvailabilityStartTime());
                LogEx.d("date.getTime() = ", String.valueOf(parse.getTime() - this.L.getAvailabilityStartTime()));
                this.L.seek(parse.getTime() - this.L.getAvailabilityStartTime());
                this.C = true;
                return;
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
        if (this.e2) {
            this.L.seek(this.P);
            this.C = true;
            return;
        }
        if (this.P < 0) {
            return;
        }
        LogEx.d("ControlPlayerFragment", "@TS 准备开始 @TS  mSeekWhenPrepared= " + this.P + " miTsEnableDuration " + this.C0);
        if (this.s) {
            this.G1 = false;
            if (!this.o) {
                this.L.seek(this.P - this.C0, com.zte.iptvclient.android.common.k.s.b().getTime());
            } else if (this.L.getCurrentTimeMs() >= this.L.getLeftTimeMs()) {
                IBasePlayer iBasePlayer = this.L;
                iBasePlayer.seek(iBasePlayer.getCurrentTimeMs());
                LogEx.d("ControlPlayerFragment", "@TS openPlayer to mPlayer.seek  =" + this.L.getCurrentTimeMs());
            } else {
                IBasePlayer iBasePlayer2 = this.L;
                iBasePlayer2.seek(iBasePlayer2.getLeftTimeMs());
                LogEx.d("ControlPlayerFragment", "@TS openPlayer to mPlayer.seek  =" + this.L.getLeftTimeMs());
            }
        }
        this.C = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I0() {
        V1();
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void J() {
        IBasePlayer iBasePlayer;
        if ((this.f0 || !this.u5) && (iBasePlayer = this.L) != null) {
            LogEx.d("ControlPlayerFragment", "The player playing status is " + iBasePlayer.getPlayerState());
            if (this.F1 && this.s && !this.l) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeShowUtil.STR_VOD_DURATION_TIME_FORMATE);
                try {
                    this.Q = simpleDateFormat.parse(this.A5).getTime();
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
                LogEx.d("ControlPlayerFragment", "@TS startPause mSeekWhenPreparedTime=" + this.Q + "EpgTime=" + simpleDateFormat.format(com.zte.iptvclient.android.common.k.s.b()));
            }
            d(this.O1);
            f0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J0() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL);
        ArrayList<Channel> a2 = com.zte.iptvclient.android.common.j.b.e().a();
        ArrayList<Channel> arrayList = this.i1;
        if (arrayList == null) {
            this.i1 = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        if (a2 != null) {
            Iterator<Channel> it2 = a2.iterator();
            while (it2.hasNext()) {
                Channel next = it2.next();
                if (TextUtils.equals(c2, next.getColumncode())) {
                    this.i1.add(next);
                }
            }
            return;
        }
        LogEx.w("ControlPlayerFragment", "channel list is null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K0() {
        this.a4 = new Handler();
        Y1();
        W1();
        X1();
        e2();
        b2();
        c2();
        d2();
        Z1();
        a2();
    }

    public void L0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M0() {
        if (this.k5 == null) {
            this.k5 = new GestureDetector(this.f4977b.getApplicationContext(), new z(this, null));
        }
        this.T = String.valueOf(ContentType.TYPE_CONTENT_NORMAL_VOD.getIntValue());
        this.s0 = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean N0() {
        NetworkInfo networkInfo = ((ConnectivityManager) this.f4977b.getSystemService("connectivity")).getNetworkInfo(0);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void O() {
        LogEx.d("ControlPlayerFragment", "playNext miVideoType=" + this.U);
        int i2 = this.W;
        int i3 = this.U;
        if (i2 == i3) {
            LogEx.d("ControlPlayerFragment", "Advertisiment playNext onfrontAD Play");
            g2();
            return;
        }
        if (this.Z == i3) {
            LogEx.d("ControlPlayerFragment", "playNext VIDEO_TYPE_BLACKOUT Play");
            D0();
            L();
            return;
        }
        if (this.X == i3) {
            LogEx.d("ControlPlayerFragment", "Advertisiment playNext onBackupAD Play");
            h2();
            return;
        }
        if (this.Y == i3) {
            LogEx.d("ControlPlayerFragment", "Advertisiment playNext onInterAD Play");
            i2();
            return;
        }
        if (this.V == i3) {
            if (("10".equals(this.T) || "15".equals(this.T)) && this.U1 < this.V1 && ((N0() || P0()) && !this.M1)) {
                LogEx.d("ControlPlayerFragment", "Advertisiment playNext POSITIVE  playNextEpisode ");
                Y0();
                return;
            }
            if ("4".equals(this.T) && !this.u5 && this.B) {
                LogEx.d("ControlPlayerFragment", "Advertisiment playNext POSITIVE  playNextTvod ");
                Z0();
                return;
            }
            ArrayList<String> arrayList = this.k4;
            if (arrayList != null && arrayList.size() > 0) {
                u2();
                return;
            }
            LogEx.i("ControlPlayerFragment", "playNext PLAYCOMPLETE showPlayEndHint!");
            this.Y1 = this.Z1;
            u();
            p1();
            f1();
        }
    }

    public abstract boolean O0();

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void P() {
        X0();
        if (com.zte.iptvclient.android.common.f.b.b.j().e() && com.zte.iptvclient.android.common.f.b.b.j().b() == 0) {
            com.zte.iptvclient.android.common.f.b.b.j().b(1);
        }
    }

    protected boolean P0() {
        NetworkInfo networkInfo = ((ConnectivityManager) this.f4977b.getSystemService("connectivity")).getNetworkInfo(1);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }

    protected void Q0() {
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            try {
                this.F5 = -1L;
                this.E5 = -1L;
                if (!TextUtils.isEmpty(com.zte.iptvclient.android.mobile.home.tab.helper.a.n().d())) {
                    this.F5 = Long.parseLong(com.zte.iptvclient.android.mobile.home.tab.helper.a.n().d());
                }
                if (!TextUtils.isEmpty(com.zte.iptvclient.android.mobile.home.tab.helper.a.n().e())) {
                    this.E5 = Long.parseLong(com.zte.iptvclient.android.mobile.home.tab.helper.a.n().e());
                }
                String c2 = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().c();
                if (!TextUtils.isEmpty(c2)) {
                    Date b2 = com.zte.iptvclient.android.common.k.s.b();
                    this.G5 = b2;
                    b2.setHours(this.K5.parse(c2).getHours());
                    this.G5.setMinutes(this.K5.parse(c2).getMinutes());
                }
                String b3 = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().b();
                if (!TextUtils.isEmpty(b3)) {
                    Date b4 = com.zte.iptvclient.android.common.k.s.b();
                    this.H5 = b4;
                    b4.setHours(this.K5.parse(b3).getHours());
                    this.H5.setMinutes(this.K5.parse(b3).getMinutes());
                }
                String h2 = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().h();
                if (!TextUtils.isEmpty(h2)) {
                    Date b5 = com.zte.iptvclient.android.common.k.s.b();
                    this.I5 = b5;
                    b5.setHours(this.K5.parse(h2).getHours());
                    this.I5.setMinutes(this.K5.parse(h2).getMinutes());
                }
                String g2 = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().g();
                if (!TextUtils.isEmpty(g2)) {
                    Date b6 = com.zte.iptvclient.android.common.k.s.b();
                    this.J5 = b6;
                    b6.setHours(this.K5.parse(g2).getHours());
                    this.J5.setMinutes(this.K5.parse(g2).getMinutes());
                }
            } catch (Exception e2) {
                LogEx.e("ControlPlayerFragment", "loadChildModePlayEnableTimeData getException " + e2.getMessage());
            }
            LogEx.d("ControlPlayerFragment", "ChildModeManager lEnbalePlayAllDuration= " + this.F5 + " lEnablePlayRemainDuration " + this.E5 + " mEnbalePlayAMStartTime " + this.G5 + " mEnbalePlayAMEndTime " + this.H5 + " mEnbalePlayPMStartTime " + this.I5 + " mEnbalePlayPMEndTime " + this.J5 + " CurrentEpgTime " + com.zte.iptvclient.android.common.k.s.b());
        }
    }

    public void R0() {
        m mVar = new m();
        this.P3 = mVar;
        NetworkStateReceiver.a(mVar);
        if (NetWorkUtil.netType.wifi.equals(NetWorkUtil.a(this.f4977b)) || this.o5) {
            return;
        }
        NetworkStateReceiver.a(this.f4977b.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.iptvclient.android.common.player.k.a
    public void S() {
        U0();
        u0();
    }

    public void S0() {
        LogEx.d("ControlPlayerFragment", "onBlackOutPlay start!");
        if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
            if (TextUtils.isEmpty(this.D5)) {
                return;
            }
            LogEx.d("ControlPlayerFragment", "start play blackout");
            t(this.D5);
            LogEx.d("ControlPlayerFragment", "onBlackOutPlay mBlackOutUrl = " + this.D5);
            Q();
            this.U = this.Z;
            this.s = false;
            com.zte.iptvclient.android.common.f.b.b.j().a(true);
            return;
        }
        LogEx.e("ControlPlayerFragment", "contral not supportBlackOut");
    }

    public void T0() {
        LogEx.d("ControlPlayerFragment", "onBlackoutExitPlay");
        if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
            String str = this.f2;
            if (str == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.U = this.V;
            t(this.f2.endsWith("&playseek=beginning-") ? this.f2 : v(this.f2));
            Q();
            if (com.zte.iptvclient.android.common.f.b.b.j().c() == 2) {
                long a2 = (int) com.zte.iptvclient.android.common.f.b.b.j().a();
                this.P = a2;
                this.L.seek(a2);
            }
            if ("2".equals(this.T)) {
                this.s = true;
            }
            if ("1".equals(this.T) || "10".equals(this.T) || "14".equals(this.T)) {
                LogEx.d("ControlPlayerFragment", "onBlackoutExitPlay getBookMark= " + this.h4);
                this.i4 = String.valueOf(this.h4);
                t2();
            }
            com.zte.iptvclient.android.common.f.b.b.j().a(false);
            return;
        }
        LogEx.e("ControlPlayerFragment", "contral not supportBlackOut");
    }

    protected void U0() {
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void V() {
        this.U5 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.ENGLISH).format(com.zte.iptvclient.android.common.k.s.b());
        String str = "http://{ipadd:port}/iptvepg/{frame}/sdk_reportplayinfo.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f()) + "?action=start&columnid=" + this.n1 + "&begintime=" + this.U5 + "&cdnchannelcode=" + this.q1 + "&authid=0&contenttype=1";
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        LogEx.d("ControlPlayerFragment", "reportPlayInfo " + str);
        sDKNetHTTPRequest.startRequest(str, HttpRequest.METHOD_GET, new k(this));
    }

    protected void V0() {
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void W() {
        String str = "http://{ipadd:port}/iptvepg/{frame}/sdk_reportplayinfo.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f()) + "?action=end&columnid=" + this.n1 + "&begintime=" + this.U5 + "&cdnchannelcode=" + this.q1 + "&authid=0&contenttype=1";
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        LogEx.d("ControlPlayerFragment", "reportPlayInfo " + str);
        sDKNetHTTPRequest.startRequest(str, HttpRequest.METHOD_GET, new l(this));
    }

    public void W0() {
        IBasePlayer iBasePlayer;
        if ((this.f0 || !this.u5) && (iBasePlayer = this.L) != null) {
            LogEx.d("ControlPlayerFragment", "The player playing status is " + iBasePlayer.getPlayerState());
            if (this.W4 && this.V == this.U && NetworkStateReceiver.b().booleanValue() && !this.h0 && !this.p) {
                V0();
            }
            if (this.F1 && this.s && !this.l) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeShowUtil.STR_VOD_DURATION_TIME_FORMATE);
                try {
                    this.Q = simpleDateFormat.parse(this.A5).getTime();
                    this.R = com.zte.iptvclient.android.common.k.s.b();
                    if (!this.t) {
                        b(com.zte.iptvclient.android.common.k.s.b());
                    }
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
                LogEx.d("ControlPlayerFragment", "@TS startPause mSeekWhenPreparedTime=" + this.Q + "TVPauseTime=" + simpleDateFormat.format(this.R));
            }
            d(this.O1);
            this.L.pause();
            f0();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void X0() {
        /*
            Method dump skipped, instructions count: 576
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.player.k.b.X0():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.iptvclient.android.common.player.k.a
    public void Y() {
        int i2;
        Q0();
        if (this.s || (i2 = this.U) == this.X || i2 == this.W || i2 == this.Y) {
            if (this.P <= 0) {
                this.C = false;
                return;
            }
            return;
        }
        LogEx.d("ControlPlayerFragment", "seekTo mSeekWhenPrepared --- " + this.P);
        this.y3 = this.L.getDuration();
        LogEx.d("ControlPlayerFragment", "miDuration:   " + this.y3);
        if (this.x0) {
            this.L.seek(this.x3);
        } else {
            this.L.seek(this.P);
            this.K0 = this.P;
            LogEx.i("PlayerHelper", "begin play time:   " + this.K0);
        }
        w(h(this.P / 1000));
        b((int) this.P, (int) this.y3);
        LogEx.d("ControlPlayerFragment", "@TS setPlayProgress iPlayingTime=" + this.P + " iContentDuration=" + ((int) this.y3));
        if (this.D) {
            t1();
            this.D = false;
        }
        this.C = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y0() {
        if (this.e0) {
            v();
        }
        LogEx.i("ControlPlayerFragment", "playNextEpisode");
        h0();
        E();
        m0();
        u();
        if (this.N3 != null) {
            this.U1++;
            LogEx.d("ControlPlayerFragment", "mCurEpisodeNm = " + this.U1);
            D1();
            this.N3.g();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void Z() {
        String str = "1";
        if (!"1".equals(ConfigMgr.readPropertie("IsSupportConcurrencyControl"))) {
            LogEx.d("ControlPlayerFragment", "ConcurrencyControl is not supported");
            return;
        }
        if ("12".equals(this.T)) {
            LogEx.d("ControlPlayerFragment", "ConcurrencyControl is not supported");
            return;
        }
        LogEx.d("ControlPlayerFragment", "mstrContentType is ::" + this.T);
        SDKPushMsgMgr sDKPushMsgMgr = SDKPushMsgMgr.getInstance();
        if (!TextUtils.equals(this.T, "1") && !TextUtils.equals(this.T, "14") && !TextUtils.equals(this.T, "10")) {
            if (TextUtils.equals(this.T, "2")) {
                str = "3";
            } else {
                str = TextUtils.equals(this.T, "4") ? "4" : "0";
            }
        }
        LogEx.d("ControlPlayerFragment", "mstrContentCode is ::" + this.k1 + "playstatus::::" + str);
        sDKPushMsgMgr.reportPlayStatus(str, this.k1);
    }

    protected void Z0() {
        if ("4".equals(this.T)) {
            a(0, h(0L), h(this.y3 / 1000), false);
            b(0, (int) this.y3);
            w(h(0L));
        }
        LogEx.d("ControlPlayerFragment", "onPlayNextTvod PrevueCode " + this.p1 + " forChannelCode= " + this.u + " channelmixno= " + this.o1);
        this.O3.a(this.p1, this.u, this.o1, this.A);
    }

    protected void a(int i2, String str, int i3, int i4) {
    }

    protected void a(int i2, String str, long j2) {
    }

    protected void a(int i2, String str, String str2, boolean z2) {
    }

    public void a(v vVar) {
    }

    protected void a1() {
        W0();
        if (com.zte.iptvclient.android.common.f.b.b.j().e() && com.zte.iptvclient.android.common.f.b.b.j().b() == 1) {
            com.zte.iptvclient.android.common.f.b.b.j().b(0);
        }
    }

    protected void b(int i2, int i3) {
    }

    protected void b1() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c1() {
    }

    protected void d(Bundle bundle) {
    }

    protected void d1() {
    }

    protected void e(int i2) {
    }

    protected void e(boolean z2) {
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void e0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e1() {
        if (this.N3 != null) {
            a((w) null);
        }
        if (this.M3 != null) {
            a((x) null);
        }
        if (this.L3 != null) {
            a((a0) null);
        }
        if (this.O3 != null) {
            a((y) null);
        }
    }

    protected void f(int i2) {
    }

    protected void f(boolean z2) {
    }

    protected void f1() {
    }

    protected void g(int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g1() {
        LogEx.i("ControlPlayerFragment", "mcPlayer.resume(msvMain)");
        if (this.F || !this.J1) {
            return;
        }
        this.x = false;
        this.L.resume4bg();
    }

    protected void h(int i2) {
    }

    protected void h(boolean z2) {
    }

    protected void h1() {
        LogEx.d("ControlPlayerFragment", "resumePlay");
        G0();
        if (!TextUtils.isEmpty(this.w3)) {
            this.P = Integer.parseInt(this.w3);
            LogEx.d("ControlPlayerFragment", "@TS @mSeekWhenPrepared=" + this.P);
            A1();
            return;
        }
        if (this.s) {
            LogEx.d("ControlPlayerFragment", "startChannelPlay");
            j0();
            return;
        }
        try {
            this.P = Long.parseLong(this.i4) * 1000;
        } catch (Exception unused) {
            LogEx.e("ControlPlayerFragment", "mstrBreakPoint can not be parsed to int");
            this.P = 0L;
        }
        e0();
        t(this.f2);
        Q();
    }

    protected void i(int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i1() {
        ArrayList<com.zte.iptvclient.android.common.javabean.models.c> arrayList = this.p5;
        if (arrayList == null || arrayList.size() == 0 || TextUtils.isEmpty(this.p5.get(0).d())) {
            return;
        }
        String O1 = O1();
        ArrayList<PrevueBean> arrayList2 = this.e1;
        if (arrayList2 == null) {
            this.e1 = new ArrayList<>();
        } else {
            arrayList2.clear();
        }
        String replace = O1.replace("-", ".");
        String str = replace + " 00:00:00";
        String str2 = replace + " 23:59:59";
        LogEx.d("ControlPlayerFragment", "startTime is " + str + "   endTime is " + str2);
        SDKPrevueMgr sDKPrevueMgr = new SDKPrevueMgr();
        com.zte.iptvclient.android.common.javabean.models.c cVar = this.p5.get(0);
        com.zte.iptvclient.android.common.f.b.m.a(cVar.d(), new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH).format(com.zte.iptvclient.android.common.k.s.b()), this.C1, this.y1);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("channelcode", cVar.d());
        hashMap.put("begintime", str);
        hashMap.put("endtime", str2);
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", "500");
        LogEx.d("ControlPlayerFragment", "sdkQueryTvTodaySchedule Channelcode= " + cVar.d() + " > " + this.u);
        sDKPrevueMgr.getPrevueList(hashMap, new p());
    }

    protected void j(boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.iptvclient.android.common.player.k.a
    public void j0() {
        this.t = false;
        this.o = true;
        ArrayList<String> arrayList = this.n5;
        if (arrayList != null) {
            arrayList.clear();
        }
        s1();
        if (!TextUtils.isEmpty(this.u) && com.zte.iptvclient.android.common.f.b.b.j().e()) {
            com.zte.iptvclient.android.common.f.b.b.j().a(this.u, (int) this.y3);
        }
        LogEx.i("ControlPlayerFragment", "startChannelPlay");
        this.C = false;
        this.J1 = true;
        h0();
        m0();
        this.l = false;
        this.m = false;
        c0();
        long j2 = this.C0;
        b((int) j2, (int) j2);
        j(0);
        r2();
        t(this.f2);
        Q();
        this.U = this.V;
    }

    protected void j1() {
        String str;
        String c2 = com.zte.iptvclient.common.uiframe.a.c("DRM_Server_IP");
        String c3 = com.zte.iptvclient.common.uiframe.a.c("DRM_Server_Port");
        if (c2 == null || c3 == null || c2.length() <= 0 || c3.length() <= 0) {
            str = null;
        } else {
            str = c2 + ":" + c3;
        }
        if (str == null || this.L == null) {
            return;
        }
        LogEx.d("ControlPlayerFragment", "setDRM" + str);
        this.L.setDRMInfo(str, CommonFunc.getUserPath(this.f4977b.getApplicationContext()));
    }

    protected void k1() {
    }

    protected void l1() {
    }

    protected void m1() {
    }

    protected void n1() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o1() {
    }

    @Override // com.zte.iptvclient.android.common.player.k.a, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.zte.iptvclient.android.common.player.k.a, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.zte.iptvclient.android.common.player.k.a, androidx.fragment.app.Fragment
    public void onDestroy() {
        Window window;
        WindowManager.LayoutParams attributes;
        if (!this.e0) {
            com.zte.iptvclient.android.common.netstate.a aVar = this.P3;
            if (aVar != null) {
                NetworkStateReceiver.b(aVar);
                this.P3 = null;
            }
            Activity activity = this.f4977b;
            if (activity != null && (window = activity.getWindow()) != null && (attributes = window.getAttributes()) != null) {
                attributes.screenBrightness = -1.0f;
                window.setAttributes(attributes);
            }
        }
        LogEx.d("ControlPlayerFragment", "onDestroy called");
        this.a4.removeCallbacksAndMessages(null);
        e1();
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.a aVar) {
        B0();
        w0();
    }

    @Override // com.zte.iptvclient.android.common.player.k.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        b0 b0Var = new b0();
        this.h1 = b0Var;
        b0Var.start();
        this.b4 = new Timer();
        a aVar = new a();
        this.c4 = aVar;
        this.b4.scheduleAtFixedRate(aVar, 0L, 1000L);
        g(true);
    }

    @Override // com.zte.iptvclient.android.common.player.k.a, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.e0) {
            return;
        }
        g(false);
        Thread thread = this.h1;
        if (thread != null) {
            thread.interrupt();
            this.h1 = null;
        }
        if (this.b4 != null) {
            this.c4.cancel();
            this.b4.cancel();
            this.b4.purge();
            this.b4 = null;
            this.c4 = null;
        }
    }

    public int p0() {
        LogEx.d("ControlPlayerFragment", "childModePlayLimitCheck ");
        this.S5 = 0;
        Q0();
        J1();
        K1();
        return this.S5;
    }

    protected void p1() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q0() {
        LogEx.d("ControlPlayerFragment", "Advertisiment clearAdInfo ");
        this.y4 = 0;
        this.z4 = 0;
        this.A4 = 0;
        this.B4 = 0;
        this.C4 = 0;
        this.D4 = 0;
        this.Q4 = 0;
        this.S4 = 0;
        this.R4 = 0;
        this.F4 = 0;
        this.I4 = "0";
        this.j4.clear();
        this.p4.clear();
        this.m4.clear();
        this.k4.clear();
        this.q4.clear();
        this.n4.clear();
        this.l4.clear();
        this.r4.clear();
        this.o4.clear();
        this.E4.clear();
        this.G4.clear();
        this.H4.clear();
        this.J4.clear();
        this.Z4 = 0;
        ArrayList<String> arrayList = this.M4;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<String> arrayList2 = this.N4;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        ArrayList<String> arrayList3 = this.O4;
        if (arrayList3 != null) {
            arrayList3.clear();
        }
        ArrayList<String> arrayList4 = this.P4;
        if (arrayList4 != null) {
            arrayList4.clear();
        }
        this.W4 = false;
        List<String> list = this.X4;
        if (list != null) {
            list.clear();
        }
        this.x4 = false;
    }

    protected void q1() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r0() {
        T();
        LogEx.d("ControlPlayerFragment", "Advertisiment closeAd Play !");
        int i2 = this.U;
        if (i2 == this.W || i2 == this.Y) {
            if ("2".equals(this.T)) {
                LogEx.d("ControlPlayerFragment", "start channel play");
                j0();
            } else {
                LogEx.d("ControlPlayerFragment", "onPlayPositive is called!");
                x2();
            }
        }
        if (this.U == this.X) {
            m0();
            p1();
            f1();
            LogEx.d("ControlPlayerFragment", "Advertisiment mTvTimer resetCloseAdBtnState(false)");
        }
    }

    protected void r1() {
    }

    public void s0() {
        if (this.f0 || !this.u5) {
            this.F = false;
            if (this.J1 && !this.e0) {
                if (this.x0) {
                    if (this.O != null) {
                        LogEx.i("ControlPlayerFragment", "playerStart()");
                        Q();
                        return;
                    }
                    return;
                }
                if (!this.y) {
                    if (this.O != null) {
                        LogEx.i("ControlPlayerFragment", "playerStart()");
                        Q();
                        return;
                    }
                    return;
                }
                if (DownloadConstant.REPORT_MSGTYPE_ADD.equals(this.d1) && !DownloadConstant.REPORT_MSGTYPE_ADD.equals(this.c1)) {
                    this.d1 = this.c1;
                    if (this.K1) {
                        LogEx.i("ControlPlayerFragment", "switch video track");
                        this.K1 = false;
                        F(this.c1);
                        return;
                    } else {
                        if (this.L1) {
                            LogEx.i("ControlPlayerFragment", "switch episode");
                            this.L1 = false;
                            Q();
                            return;
                        }
                        return;
                    }
                }
                if (this.y && this.x) {
                    LogEx.i("ControlPlayerFragment", "resume()");
                    if (!this.w5 || this.V0.getBoolean("isProjection", false)) {
                        return;
                    }
                    g1();
                    return;
                }
                if (this.w || this.m || this.l) {
                    return;
                }
                LogEx.d("ControlPlayerFragment", "play()");
                if (this.F) {
                    LogEx.d("ControlPlayerFragment", "mNetHintShowing");
                    return;
                }
                if (this.W4 && this.V == this.U) {
                    U0();
                }
                d(this.P1);
                LogEx.d("ControlPlayerFragment", "mPlayer.resume()");
                this.L.resume();
                return;
            }
            LogEx.i("ControlPlayerFragment", "this program has been previewed completely, so can not play ");
        }
    }

    protected void s1() {
    }

    public void t0() {
        this.F = false;
        if (this.J1 && !this.e0) {
            if (!this.y) {
                LogEx.i("ControlPlayerFragment", "playerStart()");
                Q();
                return;
            }
            if (DownloadConstant.REPORT_MSGTYPE_ADD.equals(this.d1) && !DownloadConstant.REPORT_MSGTYPE_ADD.equals(this.c1)) {
                this.d1 = this.c1;
                if (this.K1) {
                    LogEx.i("ControlPlayerFragment", "switch video track");
                    this.K1 = false;
                    F(this.c1);
                    return;
                } else {
                    if (this.L1) {
                        LogEx.i("ControlPlayerFragment", "switch episode");
                        this.L1 = false;
                        Q();
                        return;
                    }
                    return;
                }
            }
            if (this.y && this.x) {
                LogEx.i("ControlPlayerFragment", "resume()");
                g1();
                return;
            } else {
                if (this.w || this.m || this.l) {
                    return;
                }
                LogEx.d("ControlPlayerFragment", "play()");
                X0();
                return;
            }
        }
        LogEx.i("ControlPlayerFragment", "this program has been previewed completely, so can not play ");
    }

    protected void t1() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u0() {
        com.zte.iptvclient.android.common.player.b bVar = this.a5;
        if (bVar != null && bVar.isShowing()) {
            this.a5.dismiss();
        }
        com.zte.iptvclient.android.common.player.b bVar2 = this.b5;
        if (bVar2 != null && bVar2.isShowing()) {
            this.b5.dismiss();
        }
        com.zte.iptvclient.android.common.player.h hVar = this.c5;
        if (hVar != null && hVar.isShowing()) {
            this.c5.dismiss();
        }
        v0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u1() {
    }

    public abstract void v0();

    protected void v1() {
    }

    protected void w(String str) {
    }

    public boolean w0() {
        if (this.s5) {
            LogEx.d("ControlPlayerFragment", "mbScreenLocked is ture for return exitPlay");
            return true;
        }
        FrameLayout frameLayout = this.r5;
        if (frameLayout != null && frameLayout.getVisibility() == 0) {
            this.r5.setVisibility(8);
            LogEx.d("ControlPlayerFragment", "flMultiPlayManager current is Visibile  return");
            return true;
        }
        if (this.B && this.A) {
            LogEx.d("ControlPlayerFragment", "skipToSmallScreen");
            if (this.r5 != null) {
                i0();
            }
            return true;
        }
        LogEx.d("ControlPlayerFragment", "releasePlayer is called!");
        if (this.K0 != -1) {
            long currentPosition = this.L.getCurrentPosition();
            this.L0 = currentPosition;
            com.zte.iptvclient.android.common.player.f.a(this.K0 / 1000, currentPosition / 1000);
            this.K0 = -1L;
        } else {
            LogEx.e("ControlPlayerFragment", "dont real play dont report inner ad");
        }
        R();
        if (!(getActivity() instanceof VOPlayerActivity)) {
            return false;
        }
        getActivity().finish();
        return false;
    }

    protected void w1() {
    }

    protected void x(String str) {
    }

    protected boolean x0() {
        return true;
    }

    protected void x1() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(String str) {
        A();
        m0();
        if (TextUtils.isEmpty(str)) {
            LogEx.w("ControlPlayerFragment", "channel Code is null");
            m0();
            F();
            return;
        }
        ArrayList<com.zte.iptvclient.android.common.javabean.models.c> arrayList = this.p5;
        if (arrayList != null) {
            arrayList.clear();
        }
        SDKChannelMgr sDKChannelMgr = new SDKChannelMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("channelcode", str);
        sDKChannelMgr.getChannelDetailWithURl(hashMap, new q());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y0() {
        ArrayList<Channel> arrayList = this.i1;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        com.zte.iptvclient.android.mobile.a0.c.a aVar = this.j1;
        if (aVar != null) {
            aVar.a();
        }
        int i2 = this.X1;
        int i3 = this.a2;
        int i4 = i2 * i3;
        int i5 = i3 + i4;
        if (i5 > this.i1.size()) {
            i5 = this.i1.size();
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (i4 < i5) {
            if (i4 < this.i1.size()) {
                if (i4 == i5 - 1) {
                    stringBuffer.append(this.i1.get(i4).getChannelcode());
                } else {
                    stringBuffer.append(this.i1.get(i4).getChannelcode());
                    stringBuffer.append(",");
                }
            }
            i4++;
        }
        if (stringBuffer.toString().length() < 2) {
            return;
        }
        com.zte.iptvclient.android.mobile.a0.c.a aVar2 = new com.zte.iptvclient.android.mobile.a0.c.a(stringBuffer.toString(), new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.ENGLISH).format(com.zte.iptvclient.android.common.k.s.b()));
        this.j1 = aVar2;
        aVar2.a(new r());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y1() {
        this.E1 = false;
        this.g5 = 0;
        if (this.G1) {
            this.G1 = false;
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void z() {
        if (TextUtils.equals(this.T, "12")) {
            LogEx.d("ControlPlayerFragment", "ConcurrencyControl is not supported");
        } else if ("1".equals(ConfigMgr.readPropertie("IsSupportConcurrencyControl"))) {
            LogEx.d("ControlPlayerFragment", "DestoryMessage");
            SDKPushMsgMgr.getInstance().reportPlayStatus("0", this.k1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Date z0() {
        Date b2 = com.zte.iptvclient.android.common.k.s.b();
        Iterator<PrevueBean> it2 = this.e1.iterator();
        while (it2.hasNext()) {
            PrevueBean next = it2.next();
            if (TextUtils.equals(next.getPrevuename(), this.f1)) {
                try {
                    b2 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.ENGLISH).parse(next.getBegintime());
                } catch (ParseException e2) {
                    Date b3 = com.zte.iptvclient.android.common.k.s.b();
                    e2.printStackTrace();
                    b2 = b3;
                }
            }
        }
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z1() {
        this.J1 = true;
        this.K4 = false;
        ArrayList<String> arrayList = this.j4;
        if (arrayList != null && arrayList.size() > 0) {
            v2();
        } else {
            LogEx.d("ControlPlayerFragment", "onPlayPositive is called!");
            x2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public class z extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a, reason: collision with root package name */
        private double f5009a;

        /* renamed from: b, reason: collision with root package name */
        private double f5010b;

        /* renamed from: c, reason: collision with root package name */
        private DateFormat f5011c;

        /* renamed from: d, reason: collision with root package name */
        private double f5012d;
        private double e;
        private double f;
        private double g;

        private z() {
            this.f5011c = new SimpleDateFormat(TimeShowUtil.STR_VOD_DURATION_TIME_FORMATE, Locale.ENGLISH);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            WindowManager.LayoutParams attributes;
            LogEx.d("ControlPlayerFragment", "onDown");
            View view = b.this.getView();
            b.this.d5 = view.getWidth();
            b.this.e5 = view.getHeight();
            int i = b.this.e5;
            b bVar = b.this;
            a.i iVar = bVar.N;
            if (iVar == null) {
                i = bVar.e5;
            } else {
                if (iVar.i() > 0) {
                    i = b.this.N.i();
                }
                b bVar2 = b.this;
                if (bVar2.A) {
                    i = bVar2.e5;
                }
            }
            float f = i;
            LogEx.d("ControlPlayerFragment", "windowHeight=" + b.this.e5 + "");
            b.this.B0();
            if (motionEvent.getY() > (3.0f * f) / 4.0f || motionEvent.getY() < f / 4.0f) {
                return false;
            }
            b.this.f5 = true;
            double streamVolume = b.this.S3.getStreamVolume(3);
            this.e = streamVolume;
            Double.isNaN(streamVolume);
            b bVar3 = b.this;
            double d2 = bVar3.T3;
            Double.isNaN(d2);
            this.f5012d = (streamVolume * 100.0d) / d2;
            Activity activity = bVar3.f4977b;
            if (activity != null) {
                Window window = activity.getWindow();
                if (window != null && (attributes = window.getAttributes()) != null) {
                    this.g = attributes.screenBrightness;
                }
                if (this.g < 0.0d) {
                    this.g = Settings.System.getInt(b.this.f4977b.getContentResolver(), "screen_brightness", 255) / 255.0f;
                }
            }
            this.f = (this.g * 100.0d) / 1.0d;
            LogEx.d("ControlPlayerFragment", "mlastBrightValue ======== " + this.g);
            LogEx.d("ControlPlayerFragment", "mlastBrightProgress ======== " + this.f);
            b bVar4 = b.this;
            if (bVar4.f4977b == null || bVar4.L == null) {
                return true;
            }
            if (bVar4.F1 && "2".equals(bVar4.T)) {
                b bVar5 = b.this;
                bVar5.z3 = bVar5.L.getUTCPosition();
                b.this.A3 = com.zte.iptvclient.android.common.k.s.b().getTime();
                double d3 = -(com.zte.iptvclient.android.common.k.s.b().getTime() - b.this.z3);
                this.f5010b = d3;
                this.f5009a = d3;
            } else {
                this.f5010b = b.this.L.getCurrentPosition();
                this.f5009a = b.this.L.getCurrentPosition();
            }
            com.zte.iptvclient.android.common.k.s.b();
            b.this.d2 = 0.0d;
            b bVar6 = b.this;
            if (bVar6.A) {
                bVar6.h(true);
            } else {
                bVar6.h(false);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:177:0x056f  */
        /* JADX WARN: Removed duplicated region for block: B:185:0x0571  */
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onScroll(android.view.MotionEvent r23, android.view.MotionEvent r24, float r25, float r26) {
            /*
                Method dump skipped, instructions count: 1441
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.player.k.b.z.onScroll(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
        }

        /* synthetic */ z(b bVar, a aVar) {
            this();
        }
    }

    private void j(Bundle bundle) {
        LogEx.d("ControlPlayerFragment", "getTvInfo:" + bundle.toString());
        int size = this.i1.size();
        int i2 = this.a2;
        int i3 = ((size + i2) - 1) / i2;
        if (i3 > 0) {
            this.W1 = new int[i3];
        }
        com.zte.iptvclient.android.common.javabean.models.c cVar = new com.zte.iptvclient.android.common.javabean.models.c();
        String string = bundle.getString("channelcode", "");
        cVar.f(string);
        this.u = string;
        cVar.u(bundle.getString("telecomcode", ""));
        String string2 = bundle.getString("columncode", "");
        this.n1 = string2;
        cVar.h(string2);
        String string3 = bundle.getString("tv_name", "");
        String string4 = bundle.getString("programname", "");
        this.O5 = e(bundle);
        this.o1 = bundle.getString("mixno", "");
        LogEx.d("ControlPlayerFragment", "mIsRadioChannelPrograme:" + this.O5 + " MixNo " + this.o1);
        if (!TextUtils.isEmpty(string3)) {
            B(string3);
            cVar.g(string3);
            this.C1 = string3;
        } else {
            LogEx.w("ControlPlayerFragment", "m_txtvewPlayTitle is null!");
        }
        if (!TextUtils.isEmpty(string4)) {
            cVar.q(string4);
            D(string4);
            LogEx.d("ControlPlayerFragment", "strPrevueName:" + string4);
        } else {
            LogEx.w("ControlPlayerFragment", "strPrevueName is null!");
        }
        this.w3 = bundle.getString("timeshifting_time", "");
        a(bundle);
        this.k1 = bundle.getString("contentcode", "");
        String string5 = bundle.getString("poster_image", "");
        if (string5 != null) {
            u(string5);
        }
        ArrayList<com.zte.iptvclient.android.common.javabean.models.c> arrayList = this.p5;
        if (arrayList != null && arrayList.size() < 1) {
            this.p5.add(cVar);
        } else {
            ArrayList<com.zte.iptvclient.android.common.javabean.models.c> arrayList2 = this.p5;
            if (arrayList2 != null) {
                arrayList2.set(0, cVar);
            }
        }
        i1();
        C(cVar.d());
    }

    private void k(Bundle bundle) {
        LogEx.d("ControlPlayerFragment", "out bundle param *****: " + bundle.toString());
        n(bundle);
        o(bundle);
        String string = bundle.getString("tv_name");
        d(bundle);
        if (!TextUtils.isEmpty(string)) {
            B(string);
            LogEx.d("ControlPlayerFragment", "strChannelName:" + string);
        } else {
            LogEx.w("ControlPlayerFragment", "strChannelName is null!");
        }
        String string2 = bundle.getString("prevue_name");
        this.f1 = string2;
        this.l1 = bundle.getString("telecomcode");
        if (!TextUtils.isEmpty(string2)) {
            D(string2);
            LogEx.d("ControlPlayerFragment", "strPrevueName:" + string2);
        } else {
            LogEx.w("ControlPlayerFragment", "strPrevueName is null!");
        }
        this.D1 = bundle.getString("prevuebegintime");
        LogEx.d("ControlPlayerFragment", "mstrPrevueBeginTime:" + this.D1);
        String string3 = bundle.getString(ParamConst.NPVR_QUERY_RSP_DURATION);
        if (!TextUtils.isEmpty(string3)) {
            E(string3);
            LogEx.d("ControlPlayerFragment", "strDuration:" + string3);
        } else {
            LogEx.w("ControlPlayerFragment", "strDuration is null!");
        }
        this.n1 = bundle.getString("columncode");
        this.p1 = bundle.getString("prevuecode");
        this.o1 = bundle.getString("mixno", "");
        LogEx.d("ControlPlayerFragment", "mstrProgramName:" + this.f1 + " MixNo " + this.o1);
        StringBuilder sb = new StringBuilder();
        sb.append("mstrPrevueCode:");
        sb.append(this.p1);
        LogEx.d("ControlPlayerFragment", sb.toString());
        if (bundle.getString("channelcode") != null) {
            this.u = bundle.getString("channelcode");
        }
        LogEx.d("ControlPlayerFragment", "mstrChannelCode:" + this.p1);
        String string4 = bundle.getString("poster_image");
        if (!TextUtils.isEmpty(string4)) {
            int indexOf = string4.indexOf("/image", 1);
            if (indexOf > -1) {
                string4 = com.zte.iptvclient.android.common.f.b.i.g() + string4.substring(indexOf);
            }
            u(string4);
            return;
        }
        if (TextUtils.isEmpty(this.u)) {
            return;
        }
        H(this.u);
    }

    private void l(Bundle bundle) {
        LogEx.d("ControlPlayerFragment", "getVodInfo=" + bundle.toString());
        this.H1 = bundle.getBoolean("isfromdownloaded", false);
        LogEx.d("ControlPlayerFragment", "mIsFromDownloaded = " + this.H1);
        String string = bundle.getString("programname");
        if (!TextUtils.isEmpty(string)) {
            D(string);
            LogEx.d("ControlPlayerFragment", "m_txtvewPlayTitle:" + string);
        } else {
            LogEx.w("ControlPlayerFragment", "m_txtvewPlayTitle is null!");
        }
        this.m5 = bundle.getString("posterUrl");
        this.k1 = bundle.getString("contentcode");
        if (!TextUtils.isEmpty(bundle.getString("columncode"))) {
            this.n1 = bundle.getString("columncode");
        }
        if (!TextUtils.isEmpty(bundle.getString("shareImage"))) {
            this.A1 = bundle.getString("shareImage");
            LogEx.d("ControlPlayerFragment", "VOD_DETAIL_SHARE_PHOTO is： " + this.A1);
        }
        if (!TextUtils.isEmpty(bundle.getString("ratingid"))) {
            this.B1 = bundle.getString("ratingid");
            LogEx.d("ControlPlayerFragment", "VOD_DETAIL_RATINGID is： " + this.B1);
        }
        this.x5 = com.zte.iptvclient.android.common.f.b.g.b();
        this.y5 = com.zte.iptvclient.android.common.f.b.g.e();
        this.z5 = com.zte.iptvclient.android.common.f.b.g.f();
        LogEx.d("ControlPlayerFragment", "mstrPreDuration is： " + this.z5);
        this.q1 = bundle.getString("programcode");
        LogEx.d("ControlPlayerFragment", "mStrProgramCode is： " + this.q1);
        this.r1 = bundle.getString("directorprogramcode", "");
        LogEx.d("ControlPlayerFragment", "mstrProgramCodeFromDirector is： " + this.r1);
        this.s1 = bundle.getString("actorprogramcode", "");
        LogEx.d("ControlPlayerFragment", "mstrProgramCodeFromActor is： " + this.s1);
        this.t1 = bundle.getString("recomendprogramcode", "");
        LogEx.d("ControlPlayerFragment", "mstrProgramCodeFromRecommend is： " + this.t1);
        String string2 = bundle.getString("programname");
        if (!TextUtils.isEmpty(string2)) {
            this.f1 = string2;
        }
        this.g1 = bundle.getString("seriesprogramcode", "");
        String string3 = bundle.getString(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTELECOMCODE);
        if (!TextUtils.isEmpty(string3)) {
            this.l1 = string3;
        }
        this.m1 = bundle.getString("price");
        LogEx.d("ControlPlayerFragment", "mstrPrice is： " + this.m1 + " ,mstrCpcode is：" + this.n0);
        this.U1 = bundle.getInt("curepisode");
        this.V1 = bundle.getInt("allepisodes");
        LogEx.d("ControlPlayerFragment", "miCurEpisode is： " + this.U1 + " ,miAllEpisodes is： " + this.V1);
        d(bundle);
        h(bundle);
        n(bundle);
        o(bundle);
        LogEx.d("ControlPlayerFragment", "STR_VR_COLUMN=" + com.zte.iptvclient.common.uiframe.a.c("VR_Column"));
        this.I1 = bundle.getBoolean("AD");
    }

    private int m(Bundle bundle) {
        b1();
        if (bundle == null) {
            LogEx.w("ControlPlayerFragment", "bundle is null!");
            q0();
            return 1;
        }
        try {
            this.y4 = Integer.parseInt(b(bundle, "Total_ContentLengthB"));
            this.z4 = Integer.parseInt(b(bundle, "Total_ContentLengthE"));
            this.F4 = Integer.parseInt(b(bundle, "CloseTime"));
            this.I4 = b(bundle, ParamConst.SEARCH_REQ_SHOWTIME);
            this.j4 = c(bundle, "VodListB");
            this.p4 = a(bundle, "ContentLengthB");
            this.m4 = a(bundle, "PlayNumB");
            this.s4 = a(bundle, "StreamContentTypeB");
            this.k4 = c(bundle, "VodListE");
            this.q4 = a(bundle, "ContentLengthE");
            this.n4 = a(bundle, "PlayNumE");
            this.t4 = a(bundle, "StreamContentTypeE");
            this.l4 = c(bundle, "VodListM");
            this.r4 = a(bundle, "ContentLengthM");
            this.o4 = a(bundle, "PlayNumM");
            this.E4 = a(bundle, "Total_ContentLengthM");
            this.G4 = a(bundle, "CloseMiddleTime");
            this.H4 = a(bundle, "OffsetMiddleTime");
            this.J4 = a(bundle, "ShowMiddleTime");
            this.u4 = a(bundle, "StreamContentTypeM");
            this.M4 = c(bundle, "CornerPicURL");
            this.N4 = c(bundle, "CornerPicPosition");
            this.O4 = c(bundle, "CornerPicDuration");
            this.P4 = c(bundle, "CornerPicOffset");
            if (this.M4 != null && this.N4.size() == this.M4.size() && this.O4.size() == this.M4.size() && this.P4.size() == this.M4.size()) {
                LogEx.d("ControlPlayerFragment", "Advertisiment mlistCornerAdUrls " + this.M4.size());
                for (int i2 = 0; i2 < this.M4.size(); i2++) {
                    try {
                        a(!TextUtils.isEmpty(this.N4.get(i2)) ? Integer.parseInt(this.N4.get(i2)) : 0, this.M4.get(i2), !TextUtils.isEmpty(this.O4.get(i2)) ? Integer.parseInt(this.O4.get(i2)) : 0, !TextUtils.isEmpty(this.P4.get(i2)) ? Integer.parseInt(this.P4.get(i2)) : 0);
                    } catch (Exception unused) {
                        LogEx.w("ControlPlayerFragment", "Advertisiment Get Corner Ad Params Error");
                    }
                }
            }
            ArrayList<String> c2 = c(bundle, "BigPicURL");
            ArrayList<String> c3 = c(bundle, "MidPicURL");
            String string = bundle.getString("AdPauseVodUrl");
            ArrayList<String> c4 = c(bundle, "SmallPicURL");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.f4977b.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.R1 = displayMetrics.widthPixels;
            this.S1 = displayMetrics.heightPixels;
            LogEx.d("ControlPlayerFragment", "height : " + this.S1);
            LogEx.d("ControlPlayerFragment", "width : " + this.R1);
            if (!TextUtils.isEmpty(string)) {
                this.W4 = true;
                this.Y4 = string;
            }
            int i3 = this.R1;
            int i4 = this.S1;
            if (i3 * i4 >= 384000 && i3 * i4 < 921600) {
                if (!com.zte.iptvclient.android.common.k.f.a(c3)) {
                    this.W4 = true;
                    this.X4 = c3;
                }
            } else {
                int i5 = this.R1;
                int i6 = this.S1;
                if (i5 * i6 < 384000) {
                    if (!com.zte.iptvclient.android.common.k.f.a(c4)) {
                        this.W4 = true;
                        this.X4 = c4;
                    }
                } else if (i5 * i6 >= 921600 && !com.zte.iptvclient.android.common.k.f.a(c2)) {
                    this.W4 = true;
                    this.X4 = c2;
                }
            }
            if (this.W4) {
                LogEx.d("ControlPlayerFragment", "Advertisiment hasPauseAd AdPausePicUrls" + this.X4);
            }
            if (this.s4.size() > 0) {
                this.w4 = this.s4.get(0).intValue();
            }
            if (this.t4.size() > 0) {
                this.w4 = this.t4.get(0).intValue();
            }
            if (this.u4.size() > 0) {
                this.v4 = this.u4.get(0).intValue();
            }
            return 0;
        } catch (Exception unused2) {
            q0();
            LogEx.w("ControlPlayerFragment", "Advertisiment length is null!");
            return 0;
        }
    }

    private int n(Bundle bundle) {
        this.d4 = false;
        if (bundle == null) {
            LogEx.w("ControlPlayerFragment", "bundle is null!");
            return 1;
        }
        String string = bundle.getString("bookmarktype");
        this.g4 = string;
        if (TextUtils.isEmpty(string)) {
            LogEx.w("ControlPlayerFragment", "bookmarktype is null!");
            return 2;
        }
        LogEx.d("ControlPlayerFragment", "bookmarktype:" + this.g4);
        String string2 = bundle.getString("contentcode");
        this.e4 = string2;
        if (TextUtils.isEmpty(string2)) {
            LogEx.w("ControlPlayerFragment", "contentcode is null!");
            return 3;
        }
        LogEx.d("ControlPlayerFragment", "contentcode:" + this.e4);
        String string3 = bundle.getString("columncode");
        this.f4 = string3;
        if (TextUtils.isEmpty(string3)) {
            LogEx.w("ControlPlayerFragment", "columncode is null!");
            return 4;
        }
        LogEx.d("ControlPlayerFragment", "columncode:" + this.f4);
        this.d4 = true;
        return 0;
    }

    private int o(Bundle bundle) {
        this.d4 = false;
        if (bundle == null) {
            LogEx.w("ControlPlayerFragment", "bundle is null!");
            return 1;
        }
        if (TextUtils.isEmpty(this.g4)) {
            LogEx.w("ControlPlayerFragment", "bookmarktype is null!");
            return 2;
        }
        LogEx.d("ControlPlayerFragment", "bookmarktype:" + this.g4);
        if (TextUtils.isEmpty(this.e4)) {
            LogEx.w("ControlPlayerFragment", "contentcode is null!");
            return 3;
        }
        LogEx.d("ControlPlayerFragment", "contentcode:" + this.e4);
        if (TextUtils.isEmpty(this.f4)) {
            LogEx.w("ControlPlayerFragment", "columncode is null!");
            return 4;
        }
        LogEx.d("ControlPlayerFragment", "columncode:" + this.f4);
        this.d4 = true;
        return 0;
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void g(long j2) {
        if (com.zte.iptvclient.android.common.f.b.g.d() != 1 || this.s || com.zte.iptvclient.android.common.f.b.g.g() || this.T1 != 0 || this.y3 == 0 || TextUtils.isEmpty(this.y5) || "0".equals(this.y5)) {
            return;
        }
        long parseLong = this.y3 - (Long.parseLong(this.y5) * 1000);
        long j3 = parseLong / 1000;
        long j4 = (2 + j3) * 1000;
        long j5 = (j3 - 1) * 1000;
        if (j2 < j4 && j2 > j5) {
            x1();
        }
        if (j2 <= parseLong || j2 >= j4) {
            return;
        }
        Activity activity = this.f4977b;
        if (activity instanceof MainActivity) {
            ((MainActivity) activity).t().n2();
        }
        W0();
        this.P = ((int) this.L.getDuration()) - 1000;
        Y();
        s0();
        com.zte.iptvclient.android.common.f.b.g.i();
    }

    public String h(long j2) {
        StringBuilder sb;
        StringBuilder sb2;
        String str;
        long j3 = j2 / 60;
        long j4 = (j3 / 60) % 60;
        long j5 = j3 % 60;
        long j6 = j2 % 60;
        if (j4 < 10) {
            sb = new StringBuilder();
            sb.append("0");
        } else {
            sb = new StringBuilder();
            sb.append("");
        }
        sb.append(j4);
        String sb3 = sb.toString();
        if (j5 < 10) {
            sb2 = new StringBuilder();
            sb2.append("0");
        } else {
            sb2 = new StringBuilder();
            sb2.append("");
        }
        sb2.append(j5);
        String sb4 = sb2.toString();
        if (j6 < 10) {
            str = "0" + j6;
        } else {
            str = "" + j6;
        }
        return sb3 + ":" + sb4 + ":" + str;
    }

    protected boolean i(long j2) {
        return com.zte.iptvclient.android.mobile.a0.c.b.b().b(new Date(j2), this.u);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.iptvclient.android.common.player.k.a
    public int u() {
        DownloadTask downloadTask;
        LogEx.d("ControlPlayerFragment", "PLAYBOOKMARK PLAY STOP to addBookMark mstrContentType" + this.T);
        long j2 = this.y3;
        long j3 = this.x3;
        if (j2 == j3 || j2 - 1500 < j3) {
            this.x3 = 0L;
        }
        ArrayList<String> arrayList = this.b1;
        if (arrayList != null && arrayList.size() > 0 && this.b1.contains(DownloadConstant.REPORT_MSGTYPE_ADD) && (downloadTask = this.w1) != null) {
            downloadTask.videoInfo.put("bookMarkPoint", String.valueOf(((int) this.x3) / 1000));
            SDKDownloadMgr.getInstance().updateTask(1, this.w1);
        }
        if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
            LogEx.d("ControlPlayerFragment", "PLAY guest login state not add bookmark ");
            return 2;
        }
        if (!this.d4) {
            LogEx.w("ControlPlayerFragment", "PLAY BookMark add  req is invalid!");
            return 1;
        }
        if (this.V != this.U) {
            LogEx.w("ControlPlayerFragment", "Current PLAY ContentType is not Positive add  no need to add bookmark");
            return 3;
        }
        if (!"1".equals(this.T) && !"10".equals(this.T) && !"14".equals(this.T) && (!"4".equals(this.T) || !TextUtils.equals("1", ConfigMgr.readPropertie("SuportTvoDAddBookMark", "0")))) {
            return 0;
        }
        if (this.T1 != 0 && "1".equals(this.T)) {
            LogEx.d("ControlPlayerFragment", "mPreviewTimeOrSitComNO:" + (this.E3 * 1000) + ",mContentDuration:" + this.y3);
            long j4 = this.x3;
            int i2 = this.E3;
            if (j4 > i2 * 1000) {
                this.x3 = i2 * 1000;
                LogEx.d("ControlPlayerFragment", "PLAY  CurrentPosition  > mPreviewTimeOrSitComNO so set position =mPreviewTimeOrSitComNO");
            }
        }
        LogEx.d("ControlPlayerFragment", "mPlayingTime:" + this.x3 + ",mContentDuration:" + this.y3 + " mCurrentPlayState " + this.Y1);
        if (this.Y1 == this.Z1) {
            LogEx.d("ControlPlayerFragment", "PLAY COMPLETE addBookMark set miCurrentPosition 0");
            this.x3 = 0L;
        } else {
            LogEx.d("ControlPlayerFragment", "PLAY STOP to addBookMark position" + this.x3);
        }
        E1();
        return 0;
    }

    protected String v(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return (TextUtils.isEmpty(str) ? "" : str.replace("live_hls", "tstv_hls")) + "&playseek=beginning-";
    }

    private boolean e(Bundle bundle) {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Radio_Column");
        if (bundle == null || TextUtils.isEmpty(c2)) {
            return false;
        }
        try {
            LogEx.d("ControlPlayerFragment", "Property 》AudioProgrames columncode is  = " + c2);
            String string = bundle.getString("columncode");
            LogEx.d("ControlPlayerFragment", "strCurrentcolumncode  is  = " + string);
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            return string.startsWith(c2);
        } catch (Exception e2) {
            LogEx.e("ControlPlayerFragment", "getMixNo is Exception = " + e2.getMessage());
            return false;
        }
    }

    private void f(Bundle bundle) {
        this.i4 = bundle.getString("bookmark_breakpoint", "0");
        LogEx.d("ControlPlayerFragment", "PLAYBOOKMARK mstrBreakPoint is： " + this.i4);
        if (TextUtils.equals("1", this.T) || TextUtils.equals("10", this.T) || TextUtils.equals("14", this.T)) {
            h(bundle);
        }
    }

    private void i(Bundle bundle) {
        this.b1.clear();
        this.b1.add(com.zte.iptvclient.android.common.i.a.a.a(R.string.auto));
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("megogodefinitionList");
        if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
            this.b1.add(((DefinitionBean) parcelableArrayList.get(i2)).a());
            b((DefinitionBean) parcelableArrayList.get(i2));
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void d(long j2) {
        if (TextUtils.equals("1", ConfigMgr.readPropertie("isTsTvEnable"))) {
            this.z3 = this.L.getUTCPosition();
            com.zte.iptvclient.android.common.k.s.b().getTime();
            if (!com.zte.iptvclient.android.mobile.a0.c.b.b().a(this.v3, this.u) || this.z3 == 0) {
                long time = com.zte.iptvclient.android.common.k.s.b().getTime() - this.z3;
                LogEx.d("ControlPlayerFragment", "@TS ReSeek 时移iCurrentPosition:   " + time + " miTsEnableDuration  " + this.C0);
                this.x3 = this.C0 - time;
                StringBuilder sb = new StringBuilder();
                sb.append("@TS ReSeek progress is :   ");
                sb.append(this.x3);
                LogEx.d("ControlPlayerFragment", sb.toString());
                b((int) this.x3, (int) this.C0);
                j((int) time);
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.unsupport_tstv_tip));
                this.L.seek(this.C3 - this.y3, com.zte.iptvclient.android.common.k.s.b().getTime());
                return;
            }
        }
        this.L.seek(j2, com.zte.iptvclient.android.common.k.s.b().getTime());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public class g implements VerticalSeekBarNew.a {
        g() {
        }

        @Override // com.zte.iptvclient.android.common.customview.view.VerticalSeekBarNew.a
        public void a(VerticalSeekBarNew verticalSeekBarNew, int i, boolean z) {
            LogEx.d("ControlPlayerFragment", "OnSeekBarChangeListener Seekbar Change. " + i);
            if (b.this.E1) {
                b.this.n2();
                b.this.S3.setStreamVolume(3, i, 0);
            }
        }

        @Override // com.zte.iptvclient.android.common.customview.view.VerticalSeekBarNew.a
        public void b(VerticalSeekBarNew verticalSeekBarNew) {
            b.this.Q1 = 0;
            b.this.E1 = false;
            b bVar = b.this;
            bVar.a4.postDelayed(bVar.V3, 2000L);
            b bVar2 = b.this;
            bVar2.a4.postDelayed(bVar2.W3, 2000L);
        }

        @Override // com.zte.iptvclient.android.common.customview.view.VerticalSeekBarNew.a
        public void a(VerticalSeekBarNew verticalSeekBarNew) {
            LogEx.d("ControlPlayerFragment", "OnSeekBarChangeListener onStartTrackingTouch");
            b.this.Q1 = 0;
            b.this.E1 = true;
            b bVar = b.this;
            bVar.a4.removeCallbacks(bVar.V3);
            b bVar2 = b.this;
            bVar2.a4.removeCallbacks(bVar2.W3);
        }
    }

    private ArrayList<String> c(Bundle bundle, String str) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList(str);
        if (stringArrayList != null) {
            return new ArrayList<>(stringArrayList);
        }
        return new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b(Bundle bundle) {
        if (bundle != null && this.f4977b != null) {
            this.n0 = bundle.getString("cpcode");
            this.r = bundle.getBoolean("isTrailer", false);
            LogEx.d("ControlPlayerFragment", "mIsTrailerVideo is" + this.r);
            if (this.r) {
                u1();
            }
            this.F3 = bundle.getString("recommendtype", "0");
            this.P5 = bundle.getBoolean("ToLoginTip", false);
            this.Q5 = this.f4977b.getSharedPreferences("gesture_help", 0).getBoolean("first_in", false);
            this.R5 = bundle.getBoolean("support_push", true);
            this.f2 = bundle.getString(ParamConst.UPDATE_VERSION_RSP_URL);
            this.g2 = bundle.getString(ParamConst.UPDATE_VERSION_RSP_URL);
            LogEx.d("ControlPlayerFragment", "In pickParams mPath = " + this.f2);
            this.h2 = bundle.getString("definition");
            LogEx.d("ControlPlayerFragment", "In pickParams mDefinition = " + this.h2);
            this.i2 = bundle.getString("TSURL");
            c(bundle);
            this.N1 = bundle.getBoolean("switchToFullScreen");
            boolean z2 = bundle.getBoolean("isFromFloatWindow");
            this.M1 = z2;
            if (z2) {
                this.c1 = bundle.getString("current_definition");
            } else if (!bundle.getBoolean("isTrailer", false)) {
                Q1();
                z(this.c1);
            } else {
                Q1();
            }
            this.T1 = bundle.getInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID);
            LogEx.d("ControlPlayerFragment", "miAuthId is： " + this.T1);
            this.T = bundle.getString("auth_contenttype");
            this.Z0 = bundle.getString("playuri4dlna");
            this.a1 = bundle.getString("telecomcode");
            LogEx.d("ControlPlayerFragment", "VOD_PLAY_URI_4_DLNA = " + this.Z0);
            LogEx.d("ControlPlayerFragment", "ContentType:" + this.T);
            this.v5 = bundle.getString("fromActivityName", "");
            if ("1".equals(bundle.getString("isNotNeedToSwitch"))) {
                this.A = true;
                this.B = false;
            }
            LogEx.d("ControlPlayerFragment", "in pickParams: mIsFullScreen is" + this.A + " mIsNeedSwitch " + this.B);
            f(bundle);
            if (m(bundle) != 0) {
                LogEx.e("ControlPlayerFragment", "pickAdsParams is failed:");
            }
            T1();
            this.E3 = -1;
            this.O5 = false;
            if ("2".equals(this.T)) {
                J0();
                this.s = true;
                j(bundle);
            } else if (!"1".equals(this.T) && !"10".equals(this.T) && !"15".equals(this.T)) {
                if ("4".equals(this.T)) {
                    this.s = false;
                    J0();
                    k(bundle);
                } else {
                    String string = bundle.getString("programname");
                    if (!TextUtils.isEmpty(string)) {
                        D(string);
                        LogEx.d("ControlPlayerFragment", "m_txtvewPlayTitle:" + string);
                    } else {
                        LogEx.w("ControlPlayerFragment", "m_txtvewPlayTitle is null!");
                    }
                }
            } else {
                this.s = false;
                l(bundle);
            }
            if (!this.s && !TextUtils.equals(this.T, "4")) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(4);
            }
            LogEx.d("ControlPlayerFragment", "###showLoading()");
            n1();
            LogEx.d("ControlPlayerFragment", "Test the starting speed : switch update  play parms end  ");
            if (this.M1) {
                h1();
            } else {
                m2();
            }
            return 0;
        }
        LogEx.w("ControlPlayerFragment", "bundle is null!");
        return 7;
    }

    private int c(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeShowUtil.STR_VOD_DURATION_TIME_FORMATE, Locale.ENGLISH);
        if (date == null) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(14, 0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(com.zte.iptvclient.android.common.k.s.b());
        calendar2.add(14, 0);
        int timeInMillis = (int) (calendar2.getTimeInMillis() - calendar.getTimeInMillis());
        LogEx.d("ControlPlayerFragment", "@TS getTsTVOffsetTime " + timeInMillis);
        LogEx.d("ControlPlayerFragment", "@TS ceshiBeginDate " + simpleDateFormat.format(TimeUtil.addOffset(com.zte.iptvclient.android.common.k.s.b(), 14, -timeInMillis)));
        return timeInMillis;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x029e, code lost:
    
        if (r5.equals("MP4-lo") != false) goto L166;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void z(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 1422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.player.k.b.z(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public class h implements VerticalSeekBarNew.a {
        h() {
        }

        @Override // com.zte.iptvclient.android.common.customview.view.VerticalSeekBarNew.a
        public void a(VerticalSeekBarNew verticalSeekBarNew, int i, boolean z) {
            Window window;
            WindowManager.LayoutParams attributes;
            b.this.Z3 = i;
            LogEx.d("ControlPlayerFragment", "OnSeekBarChangeListener Seekbar onProgressChanged " + b.this.Z3);
            Activity activity = b.this.f4977b;
            if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
                return;
            }
            attributes.screenBrightness = (i + 30) / 255.0f;
            LogEx.d("ControlPlayerFragment", "OnSeekBarChangeListener onStopTrackingTouch " + attributes.screenBrightness);
            window.setAttributes(attributes);
        }

        @Override // com.zte.iptvclient.android.common.customview.view.VerticalSeekBarNew.a
        public void b(VerticalSeekBarNew verticalSeekBarNew) {
            b.this.Q1 = 0;
            b.this.E1 = false;
        }

        @Override // com.zte.iptvclient.android.common.customview.view.VerticalSeekBarNew.a
        public void a(VerticalSeekBarNew verticalSeekBarNew) {
            b.this.Q1 = 0;
            b.this.E1 = true;
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void f(long j2) {
        int i2;
        if (this.f4977b == null || this.L == null) {
            return;
        }
        LogEx.d("ControlPlayerFragment", "#doUpdateUI  " + this.L.getCurrentPosition());
        if (!this.z && this.q5) {
            if (!this.L.isPlaying()) {
                if (this.s) {
                    r2();
                    if (!this.t) {
                        if (this.R == null) {
                            return;
                        }
                        long time = this.C0 - (com.zte.iptvclient.android.common.k.s.b().getTime() - this.R.getTime());
                        long j3 = time > 0 ? time : 0L;
                        b((int) j3, (int) this.C0);
                        LogEx.d("ControlPlayerFragment", " differTime = " + j3 + " miTsEnableDuration=" + this.C0);
                    } else {
                        C2();
                    }
                }
                LogEx.d("ControlPlayerFragment", "#current player is not Playing for doUpdateUI Return ");
                return;
            }
            LogEx.d("ControlPlayerFragment", "isPlaying:   ");
            J1();
            K1();
            if (!this.K4) {
                LogEx.d("ControlPlayerFragment", "Advertisiment showHideCornerAdImg showCornerAdImg");
                this.K4 = true;
                a(this.L4);
            }
            if (this.W4 && this.V == this.U) {
                U0();
            }
            z2();
            if (com.zte.iptvclient.android.common.f.b.b.j().e() && (i2 = this.U) != this.W && i2 != this.X && i2 != this.Y && !this.C) {
                com.zte.iptvclient.android.common.f.b.b j4 = com.zte.iptvclient.android.common.f.b.b.j();
                if (com.zte.iptvclient.android.common.f.b.b.j().c() != 1) {
                    j2 = this.L.getUTCPosition();
                }
                j4.a(j2);
            }
            d(this.P1);
            this.x3 = this.L.getCurrentPosition();
            this.y3 = this.L.getDuration();
            y2();
            LogEx.d("ControlPlayerFragment", " doUpdateUI miDuration = " + this.y3 + " miCurrentPosition=" + this.x3);
            try {
                if (this.s) {
                    if (!TextUtils.equals(this.e, "2")) {
                        C2();
                    } else if (this.x3 > 1537200000000L) {
                        C2();
                    }
                    if (this.U == this.W && this.y3 != 0 && (this.x3 + 1000) / 1000 >= this.y3 / 1000) {
                        LogEx.d("ControlPlayerFragment", "playNext");
                        O();
                    }
                } else {
                    D2();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.U != this.V || this.x4) {
                return;
            }
            c0();
            return;
        }
        LogEx.d("ControlPlayerFragment", "#current player is stop or not need update for doUpdateUI Return ");
    }

    private void h(Bundle bundle) {
        ArrayList<String> arrayList = this.b1;
        if (arrayList == null || arrayList.size() <= 0 || !this.b1.contains(DownloadConstant.REPORT_MSGTYPE_ADD)) {
            return;
        }
        String string = bundle.getString("taskID", "");
        String string2 = bundle.getString("headId", "");
        this.x1 = string2;
        if (TextUtils.isEmpty(string2)) {
            SDKDownloadMgr.getInstance().getDownloadList("0", 1, new u(string));
        } else {
            SDKDownloadMgr.getInstance().getDownloadList("0", 1, this.x1, new u(string));
        }
    }

    public void i(boolean z2) {
        this.q5 = z2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Bundle bundle, boolean z2) {
        this.V0 = bundle;
        this.w5 = z2;
        L0();
        if (this.C5 == null) {
            this.C5 = new com.zte.iptvclient.android.common.j.h(this.f4977b.getApplicationContext());
        }
        Q0();
        if (bundle != null) {
            b(bundle);
        } else {
            this.T = String.valueOf(ContentType.TYPE_CONTENT_NORMAL_VOD.getIntValue());
        }
        this.k5 = new GestureDetector(this.f4977b.getApplicationContext(), new z(this, null));
        this.s0 = true;
        ArrayList<String> arrayList = this.b1;
        if (arrayList != null && arrayList.size() == 1 && this.b1.contains(DownloadConstant.REPORT_MSGTYPE_ADD)) {
            return;
        }
        R0();
        u(this.A1);
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    protected void e(long j2) {
        IBasePlayer iBasePlayer = this.M;
        if (iBasePlayer == null) {
            return;
        }
        double currentPosition = iBasePlayer.getCurrentPosition();
        Double.isNaN(currentPosition);
        f(this.r0 - ((int) Math.ceil(currentPosition / 1000.0d)));
    }

    public static String e(String str, String str2) {
        if ("ivi".equals(str2)) {
            return "";
        }
        String c2 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_DEFAULT_RATE_RANGE);
        LogEx.d("ControlPlayerFragment", "strDefaultRateRange is " + c2);
        if (TextUtils.isEmpty(c2)) {
            return "";
        }
        String[] split = c2.split("-");
        if (split.length != 2) {
            return "";
        }
        String str3 = split[0];
        String str4 = split[1];
        String b2 = com.zte.iptvclient.android.common.j.c.e().b();
        LogEx.d("ControlPlayerFragment", "FeatureStorage DefinitionNis " + b2);
        if (!TextUtils.isEmpty(b2)) {
            try {
                if (Long.valueOf(Long.parseLong(b2)).longValue() > 0) {
                    str4 = b2;
                }
            } catch (NumberFormatException e2) {
                LogEx.e("ControlPlayerFragment", "getFeatureStorage Definition ocu exception=" + e2.getMessage());
            }
        }
        String str5 = "&RateLow=" + str3 + "&RateHigh=" + str4;
        LogEx.d("ControlPlayerFragment", "definition is " + str + " rateRange is " + str5);
        return str5;
    }

    private void g(Bundle bundle) {
        this.b1.clear();
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("ividefinitionList");
        if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
            this.b1.add(((DefinitionBean) parcelableArrayList.get(i2)).a());
            a((DefinitionBean) parcelableArrayList.get(i2));
        }
    }

    public void c(Bundle bundle) {
        String string = bundle.getString("url_sd");
        LogEx.d("ControlPlayerFragment", "STR_VIDEO_URL_TYPE_SD:   " + string);
        String string2 = bundle.getString("auth_sd");
        LogEx.d("ControlPlayerFragment", "STR_AUTHID_TYPE_SD:   " + string2);
        String string3 = bundle.getString("url_sd_h");
        LogEx.d("ControlPlayerFragment", "STR_VIDEO_URL_TYPE_SD_H:   " + string3);
        String string4 = bundle.getString("auth_sd_h");
        LogEx.d("ControlPlayerFragment", "STR_AUTHID_TYPE_SD_H:   " + string4);
        String string5 = bundle.getString("url_hd");
        LogEx.d("ControlPlayerFragment", "STR_VIDEO_URL_TYPE_HD:   " + string5);
        String string6 = bundle.getString("auth_hd");
        LogEx.d("ControlPlayerFragment", "STR_AUTHID_TYPE_HD:   " + string6);
        String string7 = bundle.getString("url_nav");
        LogEx.d("ControlPlayerFragment", "STR_VIDEO_URL_TYPE_NAV:   " + string7);
        String string8 = bundle.getString("url_hc");
        LogEx.d("ControlPlayerFragment", "STR_VIDEO_URL_TYPE_HC100:   " + string8);
        String string9 = bundle.getString("url_480p");
        LogEx.d("ControlPlayerFragment", "STR_VIDEO_URL_TYPE_480P:   " + string9);
        String string10 = bundle.getString("auth_480p");
        LogEx.d("ControlPlayerFragment", "STR_AUTHID_TYPE_480P:   " + string10);
        String string11 = bundle.getString("url_720p");
        LogEx.d("ControlPlayerFragment", "STR_VIDEO_URL_TYPE_720P:   " + string11);
        String string12 = bundle.getString("auth_720p");
        LogEx.d("ControlPlayerFragment", "STR_AUTHID_TYPE_720P:   " + string12);
        String string13 = bundle.getString("url_1280p");
        LogEx.d("ControlPlayerFragment", "STR_VIDEO_URL_TYPE_1280P:   " + string13);
        String string14 = bundle.getString("auth_1280p");
        LogEx.d("ControlPlayerFragment", "STR_AUTHID_TYPE_1280P:   " + string14);
        String string15 = bundle.getString("cpcode");
        LogEx.d("ControlPlayerFragment", "videoCpCode:   " + string15);
        if (TextUtils.equals(string15, "Megogo")) {
            i(bundle);
        } else if (TextUtils.equals(string15, "ivi")) {
            g(bundle);
        } else {
            a(string, string3, string5, string7, string8, string9, string11, string13, string15, string2, string4, string6, string10, string12, string14);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, String str2) {
        if (this.C5 != null) {
            ArrayList arrayList = (ArrayList) SDKCacheMgr.getAsObject(com.zte.iptvclient.android.common.c.c.e + this.C5.V());
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size() && TextUtils.equals(((VoDBean) arrayList.get(i2)).d(), str) && TextUtils.equals(((VoDBean) arrayList.get(i2)).c(), str2); i2++) {
                    arrayList.remove(i2);
                }
                VoDBean voDBean = new VoDBean();
                voDBean.e(String.valueOf(((int) this.x3) / 1000));
                voDBean.n(String.valueOf(this.U1));
                voDBean.f(this.f4);
                voDBean.d(this.g4);
                voDBean.B(this.q1);
                voDBean.g(str);
                voDBean.C(this.f1);
                voDBean.D(this.g4);
                voDBean.K(this.g1);
                voDBean.E(this.B1);
                voDBean.y(this.m5);
                arrayList.add(voDBean);
                LogEx.d("ControlPlayerFragment", "PLAYBOOKMARK\u3000Add bookMark Cache" + voDBean.i() + " miCurrentPosition=" + voDBean.b() + " for" + voDBean.d());
                StringBuilder sb = new StringBuilder();
                sb.append(com.zte.iptvclient.android.common.c.c.e);
                sb.append(this.C5.V());
                SDKCacheMgr.put(sb.toString(), arrayList);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v5, types: [boolean] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x009c -> B:11:0x009d). Please report as a decompilation issue!!! */
    protected void a(Bundle bundle) {
        Bundle bundle2;
        int i2;
        Bundle bundle3;
        String string = bundle.getString(ParamConst.CHANNEL_INFO_RSP_TSAVAILABLE, "0");
        LogEx.d("ControlPlayerFragment", "@TS strTsavailable is  ===========  " + string + " minuts");
        try {
            bundle2 = bundle;
        } catch (NumberFormatException e2) {
            LogEx.e("ControlPlayerFragment", "@TS strTsavailable can not be parsed to int" + e2.getMessage());
            bundle2 = bundle;
        }
        if (!TextUtils.isEmpty(string)) {
            i2 = Integer.valueOf(string).intValue();
            String a2 = com.zte.iptvclient.android.common.j.i.d().a(this.o1);
            LogEx.d("ControlPlayerFragment", "@TS Tsavailable ChannelTstvList for Mixno " + this.o1 + " strTsEnableDuration=" + a2 + " seconds");
            bundle2 = bundle;
            bundle2 = bundle;
            if (!TextUtils.isEmpty(a2) && i2 > 0) {
                long parseLong = Long.parseLong(a2) * 1000;
                if (parseLong > 0) {
                    this.C0 = parseLong;
                    bundle3 = bundle;
                } else {
                    this.C0 = i2 * 60 * 1000;
                    bundle3 = bundle;
                }
                bundle = "1".equals(bundle3.getString("supportTimeShift"));
                if (bundle == 0 && i2 > 0) {
                    this.F1 = true;
                    if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
                        com.zte.iptvclient.android.common.f.b.b.j().a(this.u, (int) this.C0);
                    }
                } else {
                    this.F1 = false;
                }
                LogEx.d("ControlPlayerFragment", "@TS mTsAvailble is " + this.F1 + " miTsEnableDuration :" + this.C0);
            }
        }
        i2 = 0;
        bundle3 = bundle2;
        bundle = "1".equals(bundle3.getString("supportTimeShift"));
        if (bundle == 0) {
        }
        this.F1 = false;
        LogEx.d("ControlPlayerFragment", "@TS mTsAvailble is " + this.F1 + " miTsEnableDuration :" + this.C0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControlPlayerFragment.java */
    /* loaded from: classes.dex */
    public class m extends com.zte.iptvclient.android.common.netstate.a {
        m() {
        }

        @Override // com.zte.iptvclient.android.common.netstate.a
        public void a(NetWorkUtil.netType nettype) {
            super.a(nettype);
            b bVar = b.this;
            if (bVar.u1.equals(bVar.c1)) {
                return;
            }
            if (NetWorkUtil.netType.wifi.equals(nettype)) {
                b.this.j(false);
                b.this.F = false;
                LogEx.d("ControlPlayerFragment", "netType.wifi");
                b bVar2 = b.this;
                if (bVar2.J) {
                    bVar2.Q1();
                    b bVar3 = b.this;
                    bVar3.z(bVar3.c1);
                }
                b.this.s0();
                b.this.C0();
                return;
            }
            if (!NetWorkUtil.netType.CMNET.equals(nettype) && !NetWorkUtil.netType.CMWAP.equals(nettype)) {
                if (NetWorkUtil.netType.noneNet.equals(nettype)) {
                    LogEx.d("ControlPlayerFragment", "netType noneNet !");
                    b.this.o1();
                    a.h hVar = b.this.j0;
                    if (hVar != null) {
                        hVar.a();
                    }
                    b.this.c0.setVisibility(8);
                    return;
                }
                return;
            }
            LogEx.d("ControlPlayerFragment", "netType CMNET or CMWAP !");
            b bVar4 = b.this;
            if (bVar4.M != null) {
                bVar4.k0();
            }
            a.h hVar2 = b.this.j0;
            if (hVar2 != null) {
                hVar2.a();
            }
            b bVar5 = b.this;
            bVar5.F = true;
            bVar5.j(true);
            IBasePlayer iBasePlayer = b.this.L;
            if (iBasePlayer != null && iBasePlayer.isPlaying()) {
                b bVar6 = b.this;
                if (!bVar6.o5) {
                    bVar6.W0();
                }
            }
            b.this.C0();
        }

        @Override // com.zte.iptvclient.android.common.netstate.a
        public void a() {
            LogEx.d("ControlPlayerFragment", "onDisConnect !");
            b.this.o1();
            a.h hVar = b.this.j0;
            if (hVar != null) {
                hVar.a();
            }
            b.this.c0.setVisibility(8);
            super.a();
        }
    }

    private int j(long j2) {
        LogEx.d("ControlPlayerFragment", "@TS checkTsForEnablePlayByUpdateTime");
        if (TextUtils.equals("1", ConfigMgr.readPropertie("isTsTvEnable"))) {
            if (i(j2)) {
                Date a2 = com.zte.iptvclient.android.mobile.a0.c.b.b().a();
                if (a2 != null) {
                    if (a2.before(com.zte.iptvclient.android.common.k.s.b())) {
                        LogEx.d("ControlPlayerFragment", "@TS enable new time   " + a2);
                        int c2 = c(a2);
                        if (c2 > 0 && c2 > 1000) {
                            this.P = this.C0 - c2;
                            LogEx.d("ControlPlayerFragment", "@TS get enable NewTime resertSeekValue " + this.P);
                            this.L.seek(this.P - this.C0, com.zte.iptvclient.android.common.k.s.b().getTime());
                            b((int) this.P, (int) this.C0);
                            j(c2);
                        } else {
                            LogEx.d("ControlPlayerFragment", "@TS enable false to exit!  for  Offset < 1s");
                            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.unsupport_tstv_tip));
                            j0();
                            return -1;
                        }
                    } else {
                        LogEx.d("ControlPlayerFragment", "@TS enable false to exit!   ");
                        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.unsupport_tstv_tip));
                        j0();
                        return -1;
                    }
                }
            } else {
                LogEx.d("ControlPlayerFragment", "@TS enable false to exit!   ");
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.unsupport_tstv_tip));
                j0();
                return -1;
            }
        }
        return 0;
    }

    private void k(long j2) {
        for (int i2 = 0; i2 < this.H4.size(); i2++) {
            try {
                if (i2 < this.E4.size()) {
                    long intValue = this.H4.get(i2).intValue() * 1000;
                    LogEx.d("ControlPlayerFragment", "Advertisiment lPlayMiddleAdsOffsetTime=" + intValue);
                    long intValue2 = ((long) this.E4.get(i2).intValue()) * 1000;
                    if (j2 > intValue && j2 < intValue + 1000 + intValue2) {
                        this.S4 = i2;
                        this.A4 = this.E4.get(i2).intValue();
                        LogEx.d("ControlPlayerFragment", "Advertisiment getCurrentMiddleAdStateIndex=" + this.S4);
                        return;
                    }
                }
            } catch (Exception e2) {
                LogEx.d("ControlPlayerFragment", "Advertisiment lPlayMiddleAdsTime exception");
                e2.printStackTrace();
                return;
            }
        }
    }

    private ArrayList<Integer> a(Bundle bundle, String str) {
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(str);
        if (integerArrayList != null) {
            return new ArrayList<>(integerArrayList);
        }
        return new ArrayList<>();
    }

    protected boolean a(Date date) {
        return com.zte.iptvclient.android.mobile.a0.c.b.b().b(date, this.u);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void a(DefinitionBean definitionBean) {
        char c2;
        String a2 = definitionBean.a();
        switch (a2.hashCode()) {
            case -2015045283:
                if (a2.equals("MP4-hi")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -2015045153:
                if (a2.equals("MP4-lo")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1870063963:
                if (a2.equals("MP4irwmb-4KHDR12")) {
                    c2 = ')';
                    break;
                }
                c2 = 65535;
                break;
            case -1870063934:
                if (a2.equals("MP4irwmb-4KHDR20")) {
                    c2 = '*';
                    break;
                }
                c2 = 65535;
                break;
            case -1784535545:
                if (a2.equals("MP4-TAB-HD1080")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case -1695430946:
                if (a2.equals("MP4irwmb-HD720")) {
                    c2 = '%';
                    break;
                }
                c2 = 65535;
                break;
            case -1683293545:
                if (a2.equals("MP4irwmb-UHD12")) {
                    c2 = '\'';
                    break;
                }
                c2 = 65535;
                break;
            case -1683293516:
                if (a2.equals("MP4irwmb-UHD20")) {
                    c2 = '(';
                    break;
                }
                c2 = 65535;
                break;
            case -1268684113:
                if (a2.equals("MP4-HD1080")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -1073324498:
                if (a2.equals("MP4-TAB-HD720-L2")) {
                    c2 = 24;
                    break;
                }
                c2 = 65535;
                break;
            case -1073324220:
                if (a2.equals("MP4-TAB-HD720-TP")) {
                    c2 = 23;
                    break;
                }
                c2 = 65535;
                break;
            case -1022440348:
                if (a2.equals("MP4-4KHDR12")) {
                    c2 = 14;
                    break;
                }
                c2 = 65535;
                break;
            case -1022440319:
                if (a2.equals("MP4-4KHDR20")) {
                    c2 = 15;
                    break;
                }
                c2 = 65535;
                break;
            case -1018932146:
                if (a2.equals("MP4irwmb-HD1080")) {
                    c2 = '&';
                    break;
                }
                c2 = 65535;
                break;
            case -949118317:
                if (a2.equals("MP4-SHQ-L2")) {
                    c2 = 21;
                    break;
                }
                c2 = 65535;
                break;
            case -949118315:
                if (a2.equals("MP4-SHQ-L4")) {
                    c2 = 22;
                    break;
                }
                c2 = 65535;
                break;
            case -949118039:
                if (a2.equals("MP4-SHQ-TP")) {
                    c2 = 16;
                    break;
                }
                c2 = 65535;
                break;
            case -543458560:
                if (a2.equals("MP4irwma-SHQ")) {
                    c2 = 27;
                    break;
                }
                c2 = 65535;
                break;
            case -542535039:
                if (a2.equals("MP4irwmb-SHQ")) {
                    c2 = '$';
                    break;
                }
                c2 = 65535;
                break;
            case -469278313:
                if (a2.equals("MP4-low-mobile")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -168177922:
                if (a2.equals("MP4-mobile")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -62609500:
                if (a2.equals("MP4irwma-4KHDR12")) {
                    c2 = ' ';
                    break;
                }
                c2 = 65535;
                break;
            case -62609471:
                if (a2.equals("MP4irwma-4KHDR20")) {
                    c2 = '!';
                    break;
                }
                c2 = 65535;
                break;
            case 6814444:
                if (a2.equals("MP4-TAB-HD1080-L2")) {
                    c2 = 20;
                    break;
                }
                c2 = 65535;
                break;
            case 6814722:
                if (a2.equals("MP4-TAB-HD1080-TP")) {
                    c2 = 18;
                    break;
                }
                c2 = 65535;
                break;
            case 343840068:
                if (a2.equals("MP4-HD1080-L2")) {
                    c2 = 19;
                    break;
                }
                c2 = 65535;
                break;
            case 343840346:
                if (a2.equals("MP4-HD1080-TP")) {
                    c2 = 17;
                    break;
                }
                c2 = 65535;
                break;
            case 495024899:
                if (a2.equals("MP4-4KHDR")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 513269853:
                if (a2.equals("MP4-HD720")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 525407254:
                if (a2.equals("MP4-UHD12")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case 525407283:
                if (a2.equals("MP4-UHD20")) {
                    c2 = '\r';
                    break;
                }
                c2 = 65535;
                break;
            case 570157765:
                if (a2.equals("MP4-4KDV")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 952301085:
                if (a2.equals("MP4irwma-hi")) {
                    c2 = 26;
                    break;
                }
                c2 = 65535;
                break;
            case 952301215:
                if (a2.equals("MP4irwma-lo")) {
                    c2 = 25;
                    break;
                }
                c2 = 65535;
                break;
            case 952330876:
                if (a2.equals("MP4irwmb-hi")) {
                    c2 = '#';
                    break;
                }
                c2 = 65535;
                break;
            case 952331006:
                if (a2.equals("MP4irwmb-lo")) {
                    c2 = '\"';
                    break;
                }
                c2 = 65535;
                break;
            case 1327913477:
                if (a2.equals("MP4-TAB-HD720")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 1533224815:
                if (a2.equals("MP4irwma-HD1080")) {
                    c2 = 29;
                    break;
                }
                c2 = 65535;
                break;
            case 1712032669:
                if (a2.equals("MP4irwma-HD720")) {
                    c2 = 28;
                    break;
                }
                c2 = 65535;
                break;
            case 1724170070:
                if (a2.equals("MP4irwma-UHD12")) {
                    c2 = 30;
                    break;
                }
                c2 = 65535;
                break;
            case 1724170099:
                if (a2.equals("MP4irwma-UHD20")) {
                    c2 = 31;
                    break;
                }
                c2 = 65535;
                break;
            case 1958084544:
                if (a2.equals("MP4-SHQ")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1958086453:
                if (a2.equals("MP4-UHD")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                this.x2 = definitionBean.b();
                return;
            case 1:
                this.y2 = definitionBean.b();
                return;
            case 2:
                this.z2 = definitionBean.b();
                return;
            case 3:
                this.A2 = definitionBean.b();
                return;
            case 4:
                this.B2 = definitionBean.b();
                return;
            case 5:
                this.C2 = definitionBean.b();
                return;
            case 6:
                this.D2 = definitionBean.b();
                return;
            case 7:
                this.E2 = definitionBean.b();
                return;
            case '\b':
                this.F2 = definitionBean.b();
                return;
            case '\t':
                this.G2 = definitionBean.b();
                return;
            case '\n':
                this.H2 = definitionBean.b();
                return;
            case 11:
                this.I2 = definitionBean.b();
                return;
            case '\f':
                this.J2 = definitionBean.b();
                return;
            case '\r':
                this.K2 = definitionBean.b();
                return;
            case 14:
                this.L2 = definitionBean.b();
                return;
            case 15:
                this.M2 = definitionBean.b();
                return;
            case 16:
                this.N2 = definitionBean.b();
                return;
            case 17:
                this.O2 = definitionBean.b();
                return;
            case 18:
                this.P2 = definitionBean.b();
                return;
            case 19:
                this.Q2 = definitionBean.b();
                return;
            case 20:
                this.R2 = definitionBean.b();
                return;
            case 21:
                this.S2 = definitionBean.b();
                return;
            case 22:
                this.T2 = definitionBean.b();
                return;
            case 23:
                this.U2 = definitionBean.b();
                return;
            case 24:
                this.V2 = definitionBean.b();
                return;
            case 25:
                this.W2 = definitionBean.b();
                return;
            case 26:
                this.X2 = definitionBean.b();
                return;
            case 27:
                this.Y2 = definitionBean.b();
                return;
            case 28:
                this.Z2 = definitionBean.b();
                return;
            case 29:
                this.a3 = definitionBean.b();
                return;
            case 30:
                this.b3 = definitionBean.b();
                return;
            case 31:
                this.c3 = definitionBean.b();
                return;
            case ' ':
                this.d3 = definitionBean.b();
                return;
            case '!':
                this.e3 = definitionBean.b();
                return;
            case '\"':
                this.f3 = definitionBean.b();
                return;
            case '#':
                this.g3 = definitionBean.b();
                return;
            case '$':
                this.h3 = definitionBean.b();
                return;
            case '%':
                this.i3 = definitionBean.b();
                return;
            case '&':
                this.j3 = definitionBean.b();
                return;
            case '\'':
                this.k3 = definitionBean.b();
                return;
            case '(':
                this.l3 = definitionBean.b();
                return;
            case ')':
                this.m3 = definitionBean.b();
                return;
            case '*':
                this.n3 = definitionBean.b();
                return;
            default:
                return;
        }
    }

    public void g(boolean z2) {
        if (Build.VERSION.SDK_INT < 8) {
            LogEx.d("ControlPlayerFragment", "Android 2.1 and below can not stop music");
            return;
        }
        AudioManager audioManager = this.S3;
        if (audioManager == null) {
            return;
        }
        if (z2) {
            audioManager.requestAudioFocus(null, 3, 2);
        } else {
            audioManager.abandonAudioFocus(null);
        }
        LogEx.d("ControlPlayerFragment", "pauseMusic bMute=" + z2);
    }

    private void k(int i2) {
        LogEx.d("ControlPlayerFragment", "showPlayedTimeLimitTipDialog " + i2);
        String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.watch_time_limit_tip);
        if (i2 == 1) {
            a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.chile_limit_view_tip);
        }
        if (this.T5 == null) {
            com.zte.iptvclient.android.common.customview.a.a.e.f fVar = new com.zte.iptvclient.android.common.customview.a.a.e.f(this.f4977b, R.drawable.login_btn_bg, 0, R.drawable.lock_btn_buttom_bg, R.string.common_ok, 0, 0, 0, 0, new j(this));
            this.T5 = fVar;
            fVar.setCanceledOnTouchOutside(false);
        }
        if (this.T5.isShowing()) {
            this.T5.dismiss();
        }
        LogEx.d("ControlPlayerFragment", "showPlayedTimeLimitTipDialog " + i2);
        this.T5.a(a2);
        this.T5.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long l(long j2) {
        long j3;
        ArrayList<String> arrayList;
        IBasePlayer iBasePlayer = this.L;
        if (iBasePlayer == null) {
            return -1L;
        }
        long currentPosition = iBasePlayer.getCurrentPosition();
        ArrayList<String> arrayList2 = this.l4;
        if (arrayList2 != null && arrayList2.size() > 0) {
            LogEx.d("ControlPlayerFragment", "hadSkipADsWithGuesterSeekChannge  miCurrentPlayPosition = " + currentPosition);
            for (int i2 = 0; i2 < this.H4.size(); i2++) {
                j3 = this.H4.get(i2).intValue() * 1000;
                if (currentPosition < j2 && currentPosition < j3 && j3 < j2) {
                    LogEx.d("ControlPlayerFragment", "hadSkipADsWithGuesterSeekChannge = " + j3);
                    break;
                }
            }
        }
        j3 = -1;
        if (j3 == -1 && (arrayList = this.k4) != null && arrayList.size() > 0 && this.t4.size() > 0 && this.t4.get(0).intValue() == 1) {
            long j4 = this.y3;
            int i3 = this.z4;
            if (j4 - (i3 * 1000) < j2) {
                return (j4 - (i3 * 1000)) - 2000;
            }
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, String str2) {
        if (this.C5 == null) {
            this.C5 = new com.zte.iptvclient.android.common.j.h(this.f4977b.getApplicationContext());
        }
        ArrayList arrayList = (ArrayList) SDKCacheMgr.getAsObject(com.zte.iptvclient.android.common.c.c.e + this.C5.V());
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size() && TextUtils.equals(((VoDBean) arrayList.get(i2)).d(), str) && TextUtils.equals(((VoDBean) arrayList.get(i2)).c(), str2); i2++) {
                arrayList.remove(i2);
            }
        }
        SDKCacheMgr.put(com.zte.iptvclient.android.common.c.c.e + this.C5.V(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i2) {
        if (this.L == null) {
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeShowUtil.STR_VOD_DURATION_TIME_FORMATE, Locale.ENGLISH);
        long uTCPosition = this.L.getUTCPosition();
        if (this.m && !this.G1 && uTCPosition > 0 && i2 != 0) {
            LogEx.d("ControlPlayerFragment", "@TSing not need refresh setTstvTime=" + i2 + " current=" + this.Y0.getProgress());
            Date date = new Date(uTCPosition);
            w(simpleDateFormat.format(date));
            LogEx.d("ControlPlayerFragment", "@TS playing onPlayTimeChanged=" + simpleDateFormat.format(date));
            return;
        }
        LogEx.d("ControlPlayerFragment", "@TS setTstvTime=" + i2 + " current=" + this.Y0.getProgress());
        Date b2 = com.zte.iptvclient.android.common.k.s.b();
        this.v3 = TimeUtil.addOffset(b2, 14, -i2);
        long calcOffset = TimeUtil.calcOffset(this.v3, com.zte.iptvclient.android.common.k.x.a(b2));
        if (calcOffset < 0) {
            calcOffset += Util.MILLSECONDS_OF_DAY;
            if (TextUtils.equals("1", ConfigMgr.readPropertie("isTsTvEnable"))) {
                com.zte.iptvclient.android.mobile.a0.c.b.b().b(this.u);
            }
        }
        long j2 = calcOffset / 1000;
        w(h(j2));
        LogEx.d("ControlPlayerFragment", "@TS onPlayTimeChanged=" + h(j2));
    }

    private String b(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string != null ? new String(string) : "0";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Date date) {
        w(h(TimeUtil.calcOffset(date, com.zte.iptvclient.android.common.k.x.a(date)) / 1000));
    }

    private void b(DefinitionBean definitionBean) {
        String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_low);
        String a3 = com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_medium);
        String a4 = com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_common);
        String a5 = com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_good);
        String a6 = com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_high);
        String a7 = com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_best);
        String a8 = com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_4k);
        if (definitionBean.a().equals(a2)) {
            this.r2 = definitionBean.b();
            return;
        }
        if (definitionBean.a().equals(a3)) {
            this.s2 = definitionBean.b();
            return;
        }
        if (definitionBean.a().equals(a4)) {
            this.t2 = definitionBean.b();
            return;
        }
        if (definitionBean.a().equals(a5)) {
            this.u2 = definitionBean.b();
            return;
        }
        if (definitionBean.a().equals(a6)) {
            this.v2 = definitionBean.b();
        } else if (definitionBean.a().equals(a7)) {
            this.w2 = definitionBean.b();
        } else if (definitionBean.a().equals(a8)) {
            definitionBean.b();
        }
    }

    private void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        this.b1.clear();
        if (!TextUtils.isEmpty(str8)) {
            String e2 = e(GlobalConst.ANDRIODSTB_CLIENT, str9);
            if (!TextUtils.isEmpty(e2)) {
                this.q2 = str8 + e2;
            } else {
                this.q2 = str8;
            }
            LogEx.d("ControlPlayerFragment", "mstrUrl1280P = " + this.q2);
        }
        if (!TextUtils.isEmpty(str15)) {
            this.t3 = str15;
        }
        if (!TextUtils.isEmpty(str7)) {
            this.b1.add(GlobalConst.WINPHONE_CLIENT);
            String e3 = e(GlobalConst.WINPHONE_CLIENT, str9);
            if (!TextUtils.isEmpty(e3)) {
                this.p2 = str7 + e3;
            } else {
                this.p2 = str7;
            }
            LogEx.d("ControlPlayerFragment", "mstrUrl720P = " + this.p2);
        }
        if (!TextUtils.isEmpty(str14)) {
            this.s3 = str14;
        }
        if (!TextUtils.isEmpty(str6)) {
            this.b1.add("8");
            String e4 = e("8", str9);
            if (!TextUtils.isEmpty(e4)) {
                this.o2 = str6 + e4;
            } else {
                this.o2 = str6;
            }
            LogEx.d("ControlPlayerFragment", "mstrUrl480P = " + this.o2);
        }
        if (!TextUtils.isEmpty(str13)) {
            this.r3 = str13;
        }
        if (!TextUtils.isEmpty(str3)) {
            this.b1.add("4");
            String e5 = e("4", str9);
            if (!TextUtils.isEmpty(e5)) {
                this.l2 = str3 + e5;
            } else {
                this.l2 = str3;
            }
            LogEx.d("ControlPlayerFragment", "mstrUrlHd = " + this.l2);
        }
        if (!TextUtils.isEmpty(str12)) {
            this.q3 = str12;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.b1.add("2");
            String e6 = e("2", str9);
            if (!TextUtils.isEmpty(e6)) {
                this.k2 = str2 + e6;
            } else {
                this.k2 = str2;
            }
            LogEx.d("ControlPlayerFragment", "mstrUrlSdH = " + this.k2);
        }
        if (!TextUtils.isEmpty(str11)) {
            this.p3 = str11;
        }
        if (!TextUtils.isEmpty(str)) {
            this.b1.add("1");
            String e7 = e("1", str9);
            if (!TextUtils.isEmpty(e7)) {
                this.j2 = str + e7;
            } else {
                this.j2 = str;
            }
            LogEx.d("ControlPlayerFragment", "mstrUrlSd = " + this.j2);
        }
        if (!TextUtils.isEmpty(str10)) {
            this.o3 = str10;
        }
        if (!TextUtils.isEmpty(str5)) {
            this.b1.add(this.v1);
            String e8 = e(this.v1, str9);
            if (!TextUtils.isEmpty(e8)) {
                this.n2 = str5 + e8;
            } else {
                this.n2 = str5;
            }
            LogEx.d("ControlPlayerFragment", "mstrUrlHC = " + this.n2);
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        this.b1.add(this.u1);
        this.m2 = str4;
        LogEx.d("ControlPlayerFragment", "mstrUrlLocal = " + this.m2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTask a(String str, ArrayList<DownloadTask> arrayList) {
        if (arrayList != null && !TextUtils.isEmpty(str)) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2).videoInfo.get("taskID").startsWith(str)) {
                    return arrayList.get(i2);
                }
            }
        }
        return null;
    }

    public boolean a(MotionEvent motionEvent) {
        a.g gVar;
        LogEx.d("ControlPlayerFragment", "TouchEvent: " + motionEvent.getAction());
        if (motionEvent.getAction() == 0) {
            this.X0 = true;
        } else if (motionEvent.getAction() == 1) {
            this.X0 = false;
        }
        if (!this.e0 && ((gVar = this.o0) == null || gVar.a())) {
            GestureDetector gestureDetector = this.k5;
            if (gestureDetector != null) {
                gestureDetector.onTouchEvent(motionEvent);
            }
            if ((motionEvent.getAction() & 255) == 1) {
                L1();
            }
            return false;
        }
        LogEx.d("ControlPlayerFragment", "playing in floatwindow ");
        return false;
    }

    public void a(w wVar) {
        this.N3 = wVar;
    }

    public void a(y yVar) {
        this.O3 = yVar;
    }

    public void a(a0 a0Var) {
        this.L3 = a0Var;
    }

    public void a(x xVar) {
        this.M3 = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, boolean z2) {
        a(i2, h(((this.y3 * i2) / i3) / 1000), h(this.y3 / 1000), z2);
    }
}
