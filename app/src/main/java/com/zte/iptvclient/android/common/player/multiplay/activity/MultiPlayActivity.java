package com.zte.iptvclient.android.common.player.multiplay.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.r;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Util;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.a.a.d.a;
import com.zte.iptvclient.android.common.customview.a.a.d.b;
import com.zte.iptvclient.android.common.f.b.a;
import com.zte.iptvclient.android.common.netstate.NetWorkUtil;
import com.zte.iptvclient.android.common.netstate.NetworkStateReceiver;
import com.zte.iptvclient.android.common.player.multiplay.VDHLayout;
import com.zte.iptvclient.android.common.player.multiplay.e.a;
import com.zte.iptvclient.android.common.player.multiplay.e.b;
import com.zte.iptvclient.android.mobile.order.phone.OrderDialogActivity;
import com.zte.iptvclient.android.mobile.v.b.a;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public class MultiPlayActivity extends SupportActivity implements a.s {
    private static final String W = MultiPlayActivity.class.getSimpleName();
    private ImageView A;
    private ImageView B;
    private ImageView C;
    private FrameLayout D;
    private com.zte.iptvclient.android.common.customview.a.a.d.b E;
    private com.zte.iptvclient.android.common.customview.a.a.d.a F;
    private com.zte.iptvclient.android.mobile.a0.b.b M;
    private com.zte.iptvclient.android.common.f.b.a O;
    private com.zte.iptvclient.android.common.netstate.a S;
    private VDHLayout w;
    private LinearLayout x;
    private ImageView y;
    private TextView z;
    private int v = 4;
    private boolean G = true;
    private int J = 0;
    private int K = 0;
    private boolean L = false;
    private com.zte.iptvclient.android.common.player.multiplay.b N = new com.zte.iptvclient.android.common.player.multiplay.b();
    private long P = 0;
    private boolean Q = false;
    private boolean R = false;
    private Handler T = new Handler();
    private Runnable U = new g();
    private View.OnClickListener V = new j();

    /* loaded from: classes.dex */
    class a implements com.zte.iptvclient.android.mobile.order.helper.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.player.k.d f5128a;

        a(com.zte.iptvclient.android.common.player.k.d dVar) {
            this.f5128a = dVar;
        }

        @Override // com.zte.iptvclient.android.mobile.order.helper.c
        public void a(int i, String str) {
            LogEx.d(MultiPlayActivity.W, "AuthManager payCallback returnCode=" + i + ",returnMsg=" + str);
            MultiPlayActivity.this.N.a(this.f5128a, i);
        }
    }

    /* loaded from: classes.dex */
    class b implements a.h {
        b() {
        }
    }

    /* loaded from: classes.dex */
    class c implements com.zte.iptvclient.android.mobile.order.phone.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.player.k.d f5131a;

        c(com.zte.iptvclient.android.common.player.k.d dVar) {
            this.f5131a = dVar;
        }

        @Override // com.zte.iptvclient.android.mobile.order.phone.f
        public void a(int i, String str) {
            MultiPlayActivity.this.N.a(this.f5131a, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements b.d {
        e() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.d.b.d
        public void a() {
            BaseApp.e().a(true);
            MultiPlayActivity.this.N.a(false);
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.d.b.d
        public void b() {
            MultiPlayActivity.this.N.f();
            MultiPlayActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements a.c {
        f() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.d.a.c
        public void a() {
            MultiPlayActivity.this.F.a();
            NetworkStateReceiver.a(MultiPlayActivity.this);
        }
    }

    /* loaded from: classes.dex */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MultiPlayActivity.this.x != null) {
                MultiPlayActivity.this.x.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements VDHLayout.b {
        h() {
        }

        @Override // com.zte.iptvclient.android.common.player.multiplay.VDHLayout.b
        public void a(com.zte.iptvclient.android.common.player.k.d dVar) {
            MultiPlayActivity.this.N.e(dVar);
            MultiPlayActivity.this.N.a(dVar);
        }

        @Override // com.zte.iptvclient.android.common.player.multiplay.VDHLayout.b
        public void b(com.zte.iptvclient.android.common.player.k.d dVar) {
            MultiPlayActivity.this.N.c(dVar);
        }

        @Override // com.zte.iptvclient.android.common.player.multiplay.VDHLayout.b
        public void c(com.zte.iptvclient.android.common.player.k.d dVar) {
            MultiPlayActivity.this.N.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements View.OnTouchListener {
        i() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1) {
                return false;
            }
            MultiPlayActivity.this.G();
            if (MultiPlayActivity.this.D.getVisibility() != 0) {
                return false;
            }
            MultiPlayActivity.this.D.setVisibility(8);
            return false;
        }
    }

    /* loaded from: classes.dex */
    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.close /* 2131296547 */:
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.f("play", true));
                    com.zte.iptvclient.android.common.player.multiplay.a.c().a().clear();
                    MultiPlayActivity.this.finish();
                    return;
                case R.id.rotate /* 2131297917 */:
                    MultiPlayActivity.this.x();
                    return;
                case R.id.select_mode /* 2131297985 */:
                    MultiPlayActivity.this.b(view);
                    return;
                case R.id.select_vod /* 2131297986 */:
                    if (MultiPlayActivity.this.D.getVisibility() == 0) {
                        MultiPlayActivity.this.D.setVisibility(8);
                        return;
                    } else {
                        MultiPlayActivity.this.F();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k implements a.e {
        k() {
        }

        @Override // com.zte.iptvclient.android.common.player.multiplay.e.a.e
        public void a(int i) {
            MultiPlayActivity.this.b(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l implements b.e {
        l() {
        }

        @Override // com.zte.iptvclient.android.common.player.multiplay.e.b.e
        public void a(int i) {
            MultiPlayActivity.this.b(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f5142a;

        m(View view) {
            this.f5142a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MultiPlayActivity.this.Q) {
                return;
            }
            MultiPlayActivity.this.c(this.f5142a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MultiPlayActivity.this.a(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o implements View.OnClickListener {
        o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MultiPlayActivity.this.a(view);
        }
    }

    private void A() {
        this.x = (LinearLayout) findViewById(R.id.multiplay_control);
        ImageView imageView = (ImageView) findViewById(R.id.close);
        this.y = imageView;
        imageView.setOnClickListener(this.V);
        TextView textView = (TextView) findViewById(R.id.txt_programname);
        this.z = textView;
        textView.setText("");
        ImageView imageView2 = (ImageView) findViewById(R.id.rotate);
        this.A = imageView2;
        imageView2.setOnClickListener(this.V);
        ImageView imageView3 = (ImageView) findViewById(R.id.select_mode);
        this.B = imageView3;
        imageView3.setOnClickListener(this.V);
        ImageView imageView4 = (ImageView) findViewById(R.id.select_vod);
        this.C = imageView4;
        imageView4.setOnClickListener(this.V);
        this.D = (FrameLayout) findViewById(R.id.fl_multi_play_manager);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        this.w.a(new h());
        this.w.setOnTouchListener(new i());
        if (com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a == 3) {
            E();
        }
        K();
    }

    private void B() {
        this.M = new com.zte.iptvclient.android.mobile.a0.b.b();
        Bundle bundle = new Bundle();
        bundle.putBoolean("isMultiScreenMode", true);
        bundle.putInt("themetype", 1);
        this.M.setArguments(bundle);
        a(R.id.fl_multi_play_manager, this.M);
    }

    private void C() {
        this.E = new com.zte.iptvclient.android.common.customview.a.a.d.b(this, new e());
        this.F = new com.zte.iptvclient.android.common.customview.a.a.d.a(this, new f());
    }

    private void D() {
        int size = com.zte.iptvclient.android.common.player.multiplay.a.c().a().size();
        this.v = size;
        if (size == 2) {
            if (this.L) {
                if (com.zte.iptvclient.android.common.player.multiplay.d.c.f5185b == 1) {
                    com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 3;
                } else {
                    com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 2;
                }
            } else {
                com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 1;
            }
            this.N.a(this, new int[]{R.id.multi_player_window_one, R.id.multi_player_window_two});
        } else if (size == 3) {
            if (this.L) {
                if (com.zte.iptvclient.android.common.player.multiplay.d.c.f5185b == 1) {
                    com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 6;
                } else {
                    com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 5;
                }
            } else {
                com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 4;
            }
            this.N.a(this, new int[]{R.id.multi_player_window_one, R.id.multi_player_window_two, R.id.multi_player_window_three});
        } else if (size == 4) {
            if (this.L) {
                if (com.zte.iptvclient.android.common.player.multiplay.d.c.f5185b == 1) {
                    com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 9;
                } else {
                    com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 8;
                }
            } else {
                com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 7;
            }
            this.N.a(this, new int[]{R.id.multi_player_window_one, R.id.multi_player_window_two, R.id.multi_player_window_three, R.id.multi_player_window_four});
        }
        int i2 = com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a;
        if (i2 != 1 && i2 != 4 && i2 != 7) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
        this.w.e();
    }

    private void E() {
        this.w.getChildAt(0).setClickable(true);
        this.w.getChildAt(1).setClickable(true);
        this.w.getChildAt(0).setOnClickListener(new n());
        this.w.getChildAt(1).setOnClickListener(new o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        z();
        if (v()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (this.K * 3) / 5);
            layoutParams.gravity = 80;
            this.D.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((this.J * 3) / 5, -1);
            layoutParams2.gravity = 5;
            this.D.setLayoutParams(layoutParams2);
        }
        this.w.b();
        int[] iArr = com.zte.iptvclient.android.common.player.multiplay.d.a.f5182a;
        ArrayList<View> a2 = this.w.a();
        ArrayList<com.zte.iptvclient.android.common.javabean.f> a3 = com.zte.iptvclient.android.common.player.multiplay.a.c().a();
        a3.clear();
        int i2 = 0;
        while (true) {
            if (i2 >= iArr.length) {
                break;
            }
            if (iArr[i2] == 0) {
                a3.add((com.zte.iptvclient.android.common.javabean.f) a2.get(i2).getTag(R.id.multi_player_tag1));
                break;
            }
            i2++;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= iArr.length) {
                break;
            }
            if (iArr[i3] == 1) {
                a3.add((com.zte.iptvclient.android.common.javabean.f) a2.get(i3).getTag(R.id.multi_player_tag1));
                break;
            }
            i3++;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= iArr.length) {
                break;
            }
            if (iArr[i4] == 2) {
                a3.add((com.zte.iptvclient.android.common.javabean.f) a2.get(i4).getTag(R.id.multi_player_tag1));
                break;
            }
            i4++;
        }
        int i5 = 0;
        while (true) {
            if (i5 >= iArr.length) {
                break;
            }
            if (iArr[i5] == 3) {
                a3.add((com.zte.iptvclient.android.common.javabean.f) a2.get(i5).getTag(R.id.multi_player_tag1));
                break;
            }
            i5++;
        }
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.y.b());
        this.D.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        if (this.R) {
            this.x.setVisibility(8);
            LogEx.d(W, "hidePlayerControlView");
            return;
        }
        LogEx.d(W, "showPlayerControlView");
        this.x.setVisibility(0);
        this.T.removeCallbacks(this.U);
        this.T.postDelayed(this.U, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        this.z.setText("");
    }

    private void H() {
        int i2 = this.v;
        if (i2 == 2) {
            if (com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a != 1) {
                x();
                this.w.getChildAt(0).setClickable(false);
                this.w.getChildAt(1).setClickable(false);
                VDHLayout vDHLayout = this.w;
                vDHLayout.b(vDHLayout.c());
                return;
            }
            return;
        }
        if (i2 == 3) {
            if (com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a != 4) {
                x();
            }
        } else {
            if (i2 != 4 || com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a == 7) {
                return;
            }
            x();
        }
    }

    private void I() {
        int i2;
        int i3 = this.v;
        if (i3 == 2) {
            int i4 = com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a;
            if (i4 != 3) {
                if (i4 == 1) {
                    x();
                }
                com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 3;
                if (this.w.getChildAt(0).equals(this.w.c())) {
                    this.w.getChildAt(1).bringToFront();
                } else {
                    this.w.getChildAt(0).bringToFront();
                }
                this.w.e();
                this.w.a(false);
                this.w.requestLayout();
                this.w.getChildAt(0).setBackgroundResource(R.drawable.black);
                this.w.getChildAt(1).setBackgroundResource(R.drawable.black);
                E();
            }
        } else if (i3 == 3) {
            int i5 = com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a;
            if (i5 != 6) {
                if (i5 == 4) {
                    x();
                }
                com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 6;
                this.w.e();
                this.w.a(false);
                this.w.requestLayout();
            }
        } else if (i3 == 4 && (i2 = com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a) != 9) {
            if (i2 == 7) {
                x();
            }
            com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 9;
            this.w.e();
            this.w.a(false);
            this.w.requestLayout();
        }
        com.zte.iptvclient.android.common.player.multiplay.d.c.f5185b = 1;
    }

    private void J() {
        int i2;
        int i3 = this.v;
        if (i3 == 2) {
            int i4 = com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a;
            if (i4 != 2) {
                if (i4 == 1) {
                    x();
                }
                com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 2;
                this.w.e();
                this.w.a(false);
                this.w.requestLayout();
                this.w.getChildAt(0).setClickable(false);
                this.w.getChildAt(1).setClickable(false);
                VDHLayout vDHLayout = this.w;
                vDHLayout.b(vDHLayout.c());
            }
        } else if (i3 == 3) {
            int i5 = com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a;
            if (i5 != 5) {
                if (i5 == 4) {
                    x();
                }
                com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 5;
                this.w.e();
                this.w.a(false);
                this.w.requestLayout();
            }
        } else if (i3 == 4 && (i2 = com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a) != 8) {
            if (i2 == 7) {
                x();
            }
            com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 8;
            this.w.e();
            this.w.a(false);
            this.w.requestLayout();
        }
        com.zte.iptvclient.android.common.player.multiplay.d.c.f5185b = 2;
    }

    private void K() {
        com.zte.iptvclient.android.common.javabean.f fVar;
        if (com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a == 3) {
            this.w.b();
            int[] iArr = com.zte.iptvclient.android.common.player.multiplay.d.a.f5182a;
            ArrayList<View> a2 = this.w.a();
            if (iArr.length != 2 || (fVar = (com.zte.iptvclient.android.common.javabean.f) a2.get(iArr[0]).getTag(R.id.multi_player_tag1)) == null) {
                return;
            }
            this.z.setText(fVar.e());
            return;
        }
        this.N.c();
        this.z.setText("");
    }

    private void z() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.J = displayMetrics.widthPixels;
        this.K = displayMetrics.heightPixels;
    }

    @Override // com.zte.fragmentlib.SupportActivity
    public void l() {
        if (this.N.a() == null || !(this.N.a() instanceof com.zte.iptvclient.android.common.player.k.d)) {
            return;
        }
        com.zte.iptvclient.android.common.player.k.d a2 = this.N.a();
        if (a2.A) {
            if (a2.k6) {
                return;
            }
            a2.i0();
        } else {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.f("play", true));
            super.l();
        }
    }

    @Override // com.zte.fragmentlib.SupportActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            this.w.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.SupportActivity, com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Window window = getWindow();
        if (window != null) {
            window.setFlags(Util.BYTE_OF_KB, Util.BYTE_OF_KB);
            window.setFlags(512, 512);
        }
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(R.layout.multisceen_player_fragment);
        Intent intent = getIntent();
        if (intent != null) {
            this.L = intent.getBooleanExtra("IsLandScape", false);
        }
        this.w = (VDHLayout) findViewById(R.id.multi_play_container);
        D();
        A();
        B();
        C();
        if (com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a != 3 && this.w.getChildCount() > 0) {
            VDHLayout vDHLayout = this.w;
            vDHLayout.b(vDHLayout.getChildAt(0));
            if (this.w.getChildAt(0).getTag(R.id.multi_player_tag2) != null) {
                this.N.d((com.zte.iptvclient.android.common.player.k.d) this.w.getChildAt(0).getTag(R.id.multi_player_tag2));
            }
        }
        w();
        EventBus.getDefault().register(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.SupportActivity, com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.zte.iptvclient.android.common.netstate.a aVar = this.S;
        if (aVar != null) {
            NetworkStateReceiver.b(aVar);
            this.S = null;
        }
        EventBus.getDefault().unregister(this);
        this.N.d();
        this.N = null;
        this.T.removeCallbacks(this.U);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.n nVar) {
        Window window = getWindow();
        if (v() && window != null) {
            window.addFlags(512);
            LogEx.d("MultiPlayActivity", "StatusBarCompat.fullScreen(this)");
        }
        LogEx.d("MultiPlayActivity", "SkipToSearchFragmentEvent");
        r b2 = getSupportFragmentManager().b();
        com.zte.iptvclient.android.mobile.v.b.a a2 = nVar.a();
        a2.a(this);
        if (this.N.a().A) {
            b2.a(R.id.fl_multi_play_manager_for_single, a2, "SearchFragmentEvent");
            if (this.M != null) {
                this.N.a().G1();
            }
        } else {
            b2.a(R.id.fl_main, a2, "SearchFragmentEvent");
        }
        b2.a((String) null);
        b2.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        t();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.zte.iptvclient.android.common.player.k.d a2 = this.N.a();
        if (a2 == null || !a2.A) {
            return true;
        }
        return this.N.a().a(motionEvent);
    }

    public com.zte.iptvclient.android.common.player.multiplay.b r() {
        return this.N;
    }

    public void reStartChildViewLayout(View view) {
        this.w.a(false);
        this.w.e();
    }

    public int s() {
        return this.v;
    }

    protected void t() {
        Window window;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 11 && i2 < 19) {
            Window window2 = getWindow();
            if (window2 != null) {
                window2.getDecorView().setSystemUiVisibility(8);
                return;
            }
            return;
        }
        if (Build.VERSION.SDK_INT < 19 || (window = getWindow()) == null) {
            return;
        }
        window.getDecorView().setSystemUiVisibility(4102);
    }

    public void u() {
        this.x.setVisibility(8);
    }

    public boolean v() {
        return getResources().getConfiguration().orientation == 1;
    }

    public void w() {
        d dVar = new d();
        this.S = dVar;
        NetworkStateReceiver.a(dVar);
        NetworkStateReceiver.a(this);
    }

    public void x() {
        if (v()) {
            LogEx.d(W, "current Screen State Portrait!");
            int i2 = this.v;
            if (i2 == 2) {
                if (com.zte.iptvclient.android.common.player.multiplay.d.c.f5185b == 1) {
                    com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 3;
                    if (this.w.getChildAt(0).equals(this.w.c())) {
                        this.w.getChildAt(1).bringToFront();
                    } else {
                        this.w.getChildAt(0).bringToFront();
                    }
                    E();
                    this.w.getChildAt(0).setBackgroundResource(R.drawable.black);
                    this.w.getChildAt(1).setBackgroundResource(R.drawable.black);
                } else {
                    com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 2;
                    this.w.getChildAt(0).setClickable(false);
                    this.w.getChildAt(1).setClickable(false);
                    VDHLayout vDHLayout = this.w;
                    vDHLayout.b(vDHLayout.c());
                }
            } else if (i2 == 3) {
                if (com.zte.iptvclient.android.common.player.multiplay.d.c.f5185b == 1) {
                    com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 6;
                } else {
                    com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 5;
                }
            } else if (i2 == 4) {
                if (com.zte.iptvclient.android.common.player.multiplay.d.c.f5185b == 1) {
                    com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 9;
                } else {
                    com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 8;
                }
            }
            this.w.e();
            setRequestedOrientation(0);
        } else {
            LogEx.d(W, "current Screen State LANDSCAPE!");
            int i3 = this.v;
            if (i3 == 2) {
                com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 1;
                this.w.getChildAt(0).setClickable(false);
                this.w.getChildAt(1).setClickable(false);
                VDHLayout vDHLayout2 = this.w;
                vDHLayout2.b(vDHLayout2.c());
            } else if (i3 == 3) {
                com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 4;
            } else if (i3 == 4) {
                com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 7;
            }
            this.w.e();
            setRequestedOrientation(1);
        }
        K();
        FrameLayout frameLayout = this.D;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        int i2 = com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a;
        if (i2 != 1 && i2 != 4 && i2 != 7) {
            new com.zte.iptvclient.android.common.player.multiplay.e.b(this, com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a, new l()).a(view);
        } else {
            new com.zte.iptvclient.android.common.player.multiplay.e.a(this, com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a, new k()).a(view);
        }
    }

    public void c(boolean z) {
        this.R = z;
        this.w.a(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        if (view.getParent() == null) {
            return;
        }
        this.N.e((com.zte.iptvclient.android.common.player.k.d) view.getTag(R.id.multi_player_tag2));
        this.w.c(view);
        if (((ViewGroup) view.getParent()).indexOfChild(view) == 1 && !this.R) {
            this.w.a(false);
            this.w.e();
            ((ViewGroup) view.getParent()).getChildAt(0).bringToFront();
        }
        if (((ViewGroup) view.getParent()).indexOfChild(view) == 0) {
            this.D.setVisibility(8);
        }
        G();
        com.zte.iptvclient.android.common.player.k.d dVar = (com.zte.iptvclient.android.common.player.k.d) view.getTag(R.id.multi_player_tag2);
        this.N.a(dVar);
        this.N.b(dVar);
        this.z.setText(dVar.E1().e());
    }

    public void a(View view, boolean z) {
        if (view != null) {
            if (z) {
                view.setBackgroundResource(R.drawable.black);
            } else if (view.equals(this.w.c()) && com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a != 3) {
                this.w.b(view);
            }
            this.w.bringChildToFront(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        if (i2 == 1) {
            H();
        } else if (i2 == 2) {
            J();
        } else {
            if (i2 != 3) {
                return;
            }
            I();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (System.currentTimeMillis() - this.P < 500) {
            this.Q = true;
        } else {
            this.P = System.currentTimeMillis();
            view.postDelayed(new m(view), 800L);
        }
    }

    @Override // com.zte.iptvclient.android.mobile.v.b.a.s
    public void b() {
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(LVBuffer.MAX_STRING_LENGTH);
            window.clearFlags(512);
            window.addFlags(Util.BYTE_OF_KB);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.eventbus.multi.i iVar) {
        this.D.setVisibility(8);
        if (this.N.a().A) {
            this.N.a().M1();
        }
        if (iVar == null || iVar.a() == null) {
            return;
        }
        ArrayList<com.zte.iptvclient.android.common.javabean.f> a2 = iVar.a();
        this.v = a2.size();
        boolean v = v();
        int i2 = this.v;
        if (i2 == 1) {
            this.B.setVisibility(8);
            com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 10;
        } else if (i2 == 2) {
            this.B.setVisibility(0);
            if (!v) {
                if (com.zte.iptvclient.android.common.player.multiplay.d.c.f5185b == 1) {
                    com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 3;
                } else {
                    com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 2;
                }
            } else {
                com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 1;
            }
        } else if (i2 == 3) {
            this.B.setVisibility(0);
            if (!v) {
                if (com.zte.iptvclient.android.common.player.multiplay.d.c.f5185b == 1) {
                    com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 6;
                } else {
                    com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 5;
                }
            } else {
                com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 4;
            }
        } else if (i2 == 4) {
            this.B.setVisibility(0);
            if (!v) {
                if (com.zte.iptvclient.android.common.player.multiplay.d.c.f5185b == 1) {
                    com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 9;
                } else {
                    com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 8;
                }
            } else {
                com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a = 7;
            }
        }
        int i3 = com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a;
        if (i3 != 1 && i3 != 4 && i3 != 7) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
        this.w.e();
        this.w.a(a2);
        for (int i4 = 0; i4 < a2.size(); i4++) {
            if (this.w.a(a2.get(i4))) {
                int[] iArr = {R.id.multi_player_window_one, R.id.multi_player_window_two, R.id.multi_player_window_three, R.id.multi_player_window_four};
                int i5 = 0;
                while (true) {
                    if (i5 >= 4) {
                        break;
                    }
                    if (!this.w.a(iArr[i5])) {
                        this.N.a(this, iArr[i5], a2.get(i4));
                        break;
                    }
                    i5++;
                }
            }
        }
        if (this.w.c() == null) {
            VDHLayout vDHLayout = this.w;
            vDHLayout.b(vDHLayout.getChildAt(0));
            this.N.e((com.zte.iptvclient.android.common.player.k.d) this.w.getChildAt(0).getTag(R.id.multi_player_tag2));
        }
        this.z.setText("");
        int i6 = com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a;
        if (i6 == 3) {
            if (this.w.getChildAt(0).equals(this.w.c())) {
                this.w.getChildAt(1).bringToFront();
            } else {
                this.w.getChildAt(0).bringToFront();
            }
            this.w.getChildAt(0).setBackgroundResource(R.drawable.black);
            this.w.getChildAt(1).setBackgroundResource(R.drawable.black);
            E();
        } else if (i6 == 10) {
            for (int i7 = 0; i7 < this.w.getChildCount(); i7++) {
                this.w.getChildAt(i7).setClickable(false);
            }
            VDHLayout vDHLayout2 = this.w;
            vDHLayout2.b(vDHLayout2.c());
            this.w.getChildAt(0).setBackgroundResource(R.drawable.black);
            this.N.a((com.zte.iptvclient.android.common.player.k.d) this.w.getChildAt(0).getTag());
        } else {
            for (int i8 = 0; i8 < this.w.getChildCount(); i8++) {
                this.w.getChildAt(i8).setClickable(false);
            }
            VDHLayout vDHLayout3 = this.w;
            vDHLayout3.b(vDHLayout3.c());
        }
        K();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends com.zte.iptvclient.android.common.netstate.a {
        d() {
        }

        @Override // com.zte.iptvclient.android.common.netstate.a
        public void a(NetWorkUtil.netType nettype) {
            super.a(nettype);
            if (nettype.equals(NetWorkUtil.netType.wifi)) {
                MultiPlayActivity.this.F.a();
                if (!MultiPlayActivity.this.G) {
                    MultiPlayActivity.this.E.a();
                    if (MultiPlayActivity.this.N != null) {
                        MultiPlayActivity.this.N.a(true);
                        return;
                    }
                    return;
                }
                MultiPlayActivity.this.G = false;
                return;
            }
            if (nettype.equals(NetWorkUtil.netType.CMNET) || nettype.equals(NetWorkUtil.netType.CMWAP)) {
                MultiPlayActivity.this.F.a();
                if (BaseApp.e().b() || MultiPlayActivity.this.N == null) {
                    return;
                }
                MultiPlayActivity.this.N.b(false);
                MultiPlayActivity.this.E.b();
                MultiPlayActivity.this.E.a(false);
                MultiPlayActivity.this.E.b(false);
                MultiPlayActivity.this.G = false;
                return;
            }
            if (nettype.equals(NetWorkUtil.netType.noneNet)) {
                MultiPlayActivity.this.F.b();
                MultiPlayActivity.this.E.a();
            }
        }

        @Override // com.zte.iptvclient.android.common.netstate.a
        public void a() {
            MultiPlayActivity.this.F.b();
            MultiPlayActivity.this.E.a();
            super.a();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.eventbus.multi.g gVar) {
        com.zte.iptvclient.android.common.player.k.d g2 = gVar.g();
        com.zte.iptvclient.android.common.javabean.b bVar = new com.zte.iptvclient.android.common.javabean.b();
        bVar.a(gVar.a());
        bVar.e(gVar.d());
        bVar.d(gVar.c());
        bVar.g(gVar.f());
        bVar.b(gVar.b());
        bVar.f(gVar.e());
        bVar.f("");
        this.O = new com.zte.iptvclient.android.common.f.b.a(" ", this, bVar, new a(g2), new b());
        OrderDialogActivity.u = new c(g2);
        this.O.a(this.y);
        this.O.a();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.a0.a aVar) {
        this.N.b(false);
        aVar.a();
        throw null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.eventbus.multi.b bVar) {
        if (TextUtils.equals("1", bVar.a())) {
            this.N.b(false);
        } else if (TextUtils.equals("2", bVar.a())) {
            finish();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.eventbus.multi.e eVar) {
        this.N.b(true);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.eventbus.multi.d dVar) {
        this.N.b(false);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.eventbus.multi.h hVar) {
        hVar.a();
        throw null;
    }
}
