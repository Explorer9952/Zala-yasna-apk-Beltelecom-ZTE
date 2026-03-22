package com.zte.iptvclient.android.common.player.k;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import com.video.androidsdk.cast.bean.Device;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.player.IBasePlayer;
import com.video.androidsdk.player.common.CommonFunc;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.a.a.e.f;
import com.zte.iptvclient.android.common.customview.a.a.e.l;
import com.zte.iptvclient.android.common.eventbus.multi.EventBusPlayerMessage;
import com.zte.iptvclient.android.common.eventbus.multi.MultiPlayWindowEvent;
import com.zte.iptvclient.android.common.f.b.a;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.player.activity.VOPlayerActivity;
import com.zte.iptvclient.android.common.player.e;
import com.zte.iptvclient.android.common.player.h;
import com.zte.iptvclient.android.common.player.k.a;
import com.zte.iptvclient.android.common.player.k.b;
import com.zte.iptvclient.android.common.player.multiplay.VDHLayout;
import com.zte.iptvclient.android.common.player.multiplay.activity.MultiPlayActivity;
import com.zte.iptvclient.android.common.player.multiplay.c;
import com.zte.iptvclient.android.mobile.login.activity.LoginActivity;
import com.zte.iptvclient.android.mobile.order.phone.OrderDialogActivity;
import com.zte.iptvclient.android.mobile.x.b.c.b;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: SinglePlayerFragment.java */
/* loaded from: classes.dex */
public class d extends com.zte.iptvclient.android.common.player.k.b implements c.o, View.OnClickListener {
    private TextView A6;
    private ImageView A7;
    private ImageView B6;
    private ImageView B7;
    private ImageView C6;
    private ImageView D6;
    private Button E6;
    private ImageView F6;
    private RelativeLayout G6;
    private TextView H6;
    private TextView I6;
    private ImageView J6;
    private ImageView K6;
    private ImageView L6;
    private ImageView M6;
    private com.zte.iptvclient.android.common.j.h N6;
    private RelativeLayout O6;
    public com.zte.iptvclient.android.common.customview.a.a.e.l P6;
    private ImageView Q6;
    private SeekBar R6;
    private TextView S6;
    private TextView T6;
    private ImageView U6;
    private RelativeLayout V6;
    private TextView W6;
    private com.zte.iptvclient.android.mobile.a0.b.b X5;
    private j0 X6;
    private Bundle Y5;
    private RelativeLayout Z5;
    private TextView a6;
    private RelativeLayout a7;
    private TextView b6;
    private ImageView b7;
    private Button c6;
    private TextView c7;
    private LinearLayout d6;
    private TextView d7;
    private ListView e6;
    private TextView e7;
    private com.zte.iptvclient.android.mobile.a0.a.e.b f6;
    private TextView f7;
    private LinearLayout g6;
    private TextView h6;
    private ViewStub h7;
    private Button i6;
    private com.zte.iptvclient.android.common.player.multiplay.c i7;
    private RelativeLayout j6;
    private ViewPager k7;
    private RelativeLayout l6;
    private LinearLayout l7;
    private ConstraintLayout m6;
    private LinearLayout m7;
    private ImageView n6;
    private TextView n7;
    private TextView o6;
    private TextView o7;
    private String p6;
    private CheckBox p7;
    private TextView q6;
    private ImageView q7;
    private com.zte.iptvclient.android.common.customview.a.a.b.d r7;
    private TextView s6;
    private com.zte.iptvclient.android.common.customview.a.a.b.b s7;
    private TextView t6;
    private com.zte.iptvclient.android.common.customview.a.a.b.a t7;
    private TextView u6;
    private ImageView v6;
    private ImageView v7;
    private ImageView w6;
    private com.zte.iptvclient.android.common.f.b.a w7;
    private ImageView x6;
    private com.zte.iptvclient.android.common.javabean.f x7;
    private SeekBar y6;
    private View y7;
    private TextView z6;
    private int V5 = 0;
    private int W5 = 0;
    public boolean k6 = false;
    private long r6 = 0;
    private boolean Y6 = false;
    private boolean Z6 = false;
    private long g7 = 0;
    private List<com.zte.iptvclient.android.common.customview.view.imageview.a> j7 = new ArrayList();
    private boolean u7 = false;
    private boolean z7 = false;
    private String C7 = "";
    private String[] D7 = new String[0];
    private String E7 = "";
    private String[] F7 = new String[0];
    private Handler G7 = new k();
    private Runnable H7 = new v();
    com.zte.iptvclient.android.common.player.e I7 = new com.zte.iptvclient.android.common.player.e(new f());
    private boolean J7 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (d.this.f6.a() == i) {
                return;
            }
            d.this.B0();
            d.this.f6.a(i);
            d.this.f6.notifyDataSetChanged();
            d dVar = d.this;
            dVar.y(dVar.i1.get(i).getChannelcode());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class a0 implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f5062a;

        a0(View view) {
            this.f5062a = view;
        }

        @Override // com.zte.iptvclient.android.mobile.x.b.c.b.d
        public void a(int i) {
            String format;
            String str;
            d dVar = d.this;
            Bitmap bitmap = dVar.z1;
            if (bitmap == null) {
                bitmap = BitmapFactory.decodeResource(dVar.f4977b.getResources(), R.drawable.share_img);
            }
            Bitmap bitmap2 = bitmap;
            String c2 = com.zte.iptvclient.common.uiframe.a.c("Share_Video_Title");
            if (!TextUtils.isEmpty(d.this.p6) && !TextUtils.isEmpty(c2) && c2.contains("$CONTENTNAME$")) {
                format = String.format(c2.replace("$CONTENTNAME$", "%1$s"), d.this.p6);
            } else {
                d dVar2 = d.this;
                dVar2.p6 = (String) dVar2.q6.getText();
                d dVar3 = d.this;
                dVar3.p6 = (String) dVar3.o6.getText();
                format = String.format(d.this.getString(R.string.share_message), d.this.p6);
            }
            String str2 = format;
            long currentPosition = (CommonFunc.getPlayer() != null ? CommonFunc.getPlayer().getCurrentPosition() : 0L) / 1000;
            long j = i;
            int i2 = currentPosition < j ? 0 : (int) (currentPosition - j);
            String c3 = com.zte.iptvclient.common.uiframe.a.c("APP_Share_URL");
            if (TextUtils.isEmpty(c3)) {
                str = null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(c3);
                d dVar4 = d.this;
                sb.append(String.format("?pcode=%1$s,%2$s,%3$d,%4$d,%5$s,%6$s,%7$s&ptype=0", d.this.q1, "2", Integer.valueOf(i2), Integer.valueOf(i), dVar4.r1, dVar4.s1, dVar4.t1));
                str = sb.toString();
            }
            String str3 = str;
            String str4 = com.zte.iptvclient.android.common.i.a.a.a(R.string.share_content_title) + com.zte.iptvclient.android.common.i.a.a.a(R.string.app_name);
            LogEx.d("PlayerFragment", "shareURL=" + str3);
            new com.zte.iptvclient.android.mobile.x.b.c.c(d.this.f4977b, str2, str3, null, str4, bitmap2, null, "").a(this.f5062a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class b implements AbsListView.OnScrollListener {
        b() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            d.this.b2 = (i + i2) - 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                d.this.G7.removeMessages(3);
            } else {
                d dVar = d.this;
                int i2 = dVar.b2 / dVar.a2;
                dVar.X1 = i2;
                if (dVar.W1[i2] == 0) {
                    dVar.y0();
                }
                d.this.G7.sendEmptyMessageDelayed(3, 10000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class b0 implements f.c {
        b0() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void a() {
            d.this.Z2();
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void b() {
            d.this.X0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                d.this.k6 = true;
            } else {
                d.this.k6 = false;
            }
            d dVar = d.this;
            if (dVar.b0) {
                MultiPlayWindowEvent multiPlayWindowEvent = new MultiPlayWindowEvent(MultiPlayWindowEvent.MultiPlayWindowEventType.CONTROL_GRAVITY_INDUCTION_IS_OPEN);
                if (z) {
                    multiPlayWindowEvent.a(false);
                    d dVar2 = d.this;
                    dVar2.s0 = false;
                    dVar2.E();
                } else {
                    multiPlayWindowEvent.a(true);
                    d dVar3 = d.this;
                    dVar3.s0 = true;
                    dVar3.f0();
                }
                EventBus.getDefault().post(multiPlayWindowEvent);
            } else if (z) {
                dVar.s0 = false;
                dVar.E();
            } else {
                dVar.s0 = true;
                dVar.f0();
            }
            if (z) {
                d dVar4 = d.this;
                dVar4.s0 = false;
                if (dVar4.b0) {
                    MultiPlayWindowEvent multiPlayWindowEvent2 = new MultiPlayWindowEvent(MultiPlayWindowEvent.MultiPlayWindowEventType.CONTROL_GRAVITY_INDUCTION_IS_OPEN);
                    multiPlayWindowEvent2.a(false);
                    EventBus.getDefault().post(multiPlayWindowEvent2);
                }
                d.this.f0();
                return;
            }
            d dVar5 = d.this;
            dVar5.s0 = true;
            if (dVar5.b0) {
                MultiPlayWindowEvent multiPlayWindowEvent3 = new MultiPlayWindowEvent(MultiPlayWindowEvent.MultiPlayWindowEventType.CONTROL_GRAVITY_INDUCTION_IS_OPEN);
                multiPlayWindowEvent3.a(true);
                EventBus.getDefault().post(multiPlayWindowEvent3);
            }
            d.this.f0();
        }
    }

    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    class c0 extends androidx.viewpager.widget.a {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f5067c;

        c0(d dVar, List list) {
            this.f5067c = list;
        }

        @Override // androidx.viewpager.widget.a
        public int a() {
            return this.f5067c.size();
        }

        @Override // androidx.viewpager.widget.a
        public boolean a(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // androidx.viewpager.widget.a
        public Object a(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) this.f5067c.get(i));
            return this.f5067c.get(i);
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* renamed from: com.zte.iptvclient.android.common.player.k.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0153d implements View.OnClickListener {
        ViewOnClickListenerC0153d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArrayList<com.zte.iptvclient.android.common.javabean.f> a2 = com.zte.iptvclient.android.common.player.multiplay.a.c().a();
            if (com.zte.iptvclient.android.common.player.multiplay.a.c().a(d.this.E1())) {
                VDHLayout vDHLayout = (VDHLayout) d.this.y7.getParent().getParent();
                if (vDHLayout != null) {
                    vDHLayout.d().remove(d.this.y7.getParent());
                    if (vDHLayout.d() != null && vDHLayout.d().size() > 0) {
                        int i = 0;
                        View view2 = vDHLayout.d().get(0);
                        vDHLayout.b(view2);
                        while (true) {
                            if (i >= vDHLayout.getChildCount()) {
                                break;
                            }
                            if (!vDHLayout.getChildAt(i).equals(view2)) {
                                i++;
                            } else if (d.this.getActivity() != null && (d.this.getActivity() instanceof MultiPlayActivity)) {
                                ((MultiPlayActivity) d.this.getActivity()).r().a(i);
                            }
                        }
                    }
                }
                ((ViewGroup) d.this.y7.getParent().getParent()).removeView((View) d.this.y7.getParent());
                a2.remove(d.this.E1());
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a2);
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.i(arrayList));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class d0 implements l.h {
        d0() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.l.h
        public void c() {
            Device b2 = com.zte.iptvclient.android.mobile.h.a.a.g().b();
            if (b2 != null) {
                d.this.u6.setText(b2.getSTBName());
            }
            if (d.this.Y6) {
                d.this.P1();
                d.this.Y6 = false;
                d.this.P6.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArrayList<com.zte.iptvclient.android.common.javabean.f> a2 = com.zte.iptvclient.android.common.player.multiplay.a.c().a();
            if (com.zte.iptvclient.android.common.player.multiplay.a.c().a(d.this.E1())) {
                a2.remove(d.this.E1());
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a2);
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.i(arrayList));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class e0 implements h.b {
        e0() {
        }

        @Override // com.zte.iptvclient.android.common.player.h.b
        public void a(String str) {
            d.this.c5.dismiss();
            d.this.A(str);
            d dVar = d.this;
            String str2 = dVar.c1;
            dVar.d1 = str2;
            dVar.c1 = str;
            if (DownloadConstant.REPORT_MSGTYPE_ADD.equals(str2) && d.this.N0()) {
                d.this.j(true);
                d.this.K1 = true;
            } else {
                d dVar2 = d.this;
                dVar2.F(dVar2.c1);
            }
        }
    }

    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    class f implements e.a {
        f() {
        }

        @Override // com.zte.iptvclient.android.common.player.e.a
        public void a() {
            d.this.Y1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class f0 implements View.OnTouchListener {
        f0(d dVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class g implements com.zte.iptvclient.android.mobile.order.helper.c {
        g() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.helper.c
        public void a(int i, String str) {
            d.this.j(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class g0 implements View.OnTouchListener {
        g0(d dVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class h implements a.h {
        h(d dVar) {
        }
    }

    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    class h0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.customview.view.imageview.a f5074a;

        /* compiled from: SinglePlayerFragment.java */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h0.this.f5074a.setVisibility(4);
            }
        }

        h0(com.zte.iptvclient.android.common.customview.view.imageview.a aVar) {
            this.f5074a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bumptech.glide.i.a(d.this.getActivity()).a(this.f5074a.j()).a((ImageView) this.f5074a);
            this.f5074a.i();
            d.this.G7.postDelayed(new a(), this.f5074a.g() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class i implements com.zte.iptvclient.android.mobile.order.phone.f {
        i() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.phone.f
        public void a(int i, String str) {
            d.this.j(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class i0 implements View.OnTouchListener {
        i0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (d.this.A && motionEvent.getAction() == 0) {
                d.this.X1();
            }
            return d.this.a(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class j implements com.zte.iptvclient.android.mobile.order.helper.c {
        j() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.helper.c
        public void a(int i, String str) {
            LogEx.d("PlayerFragment", "payCallback");
            d.this.j(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class j0 extends BroadcastReceiver {
        private j0() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction())) {
                LogEx.d("Player", "iVolume:" + d.this.S3.getStreamVolume(3));
            }
        }

        /* synthetic */ j0(d dVar, k kVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class k extends Handler {
        k() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                if (d.this.s7 == null || !d.this.s7.isShowing()) {
                    return;
                }
                d.this.s7.dismiss();
                return;
            }
            if (i == 2) {
                if (d.this.r7 == null || !d.this.r7.isShowing()) {
                    return;
                }
                d.this.r7.dismiss();
                return;
            }
            if (i != 3) {
                if (i == 4 && d.this.t7 != null && d.this.t7.isShowing()) {
                    d.this.t7.dismiss();
                    return;
                }
                return;
            }
            d.this.B0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class l implements a.h {
        l(d dVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class m implements com.zte.iptvclient.android.mobile.order.phone.f {
        m() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.phone.f
        public void a(int i, String str) {
            d.this.j(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class n implements com.zte.iptvclient.android.mobile.order.helper.c {
        n() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.helper.c
        public void a(int i, String str) {
            d.this.j(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class o implements a.h {
        o(d dVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class p implements com.zte.iptvclient.android.mobile.order.phone.f {
        p() {
        }

        @Override // com.zte.iptvclient.android.mobile.order.phone.f
        public void a(int i, String str) {
            d.this.j(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class q implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EditText f5085a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f5086b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.b f5087c;

        q(EditText editText, Context context, com.zte.iptvclient.android.common.customview.a.a.a.b bVar) {
            this.f5085a = editText;
            this.f5086b = context;
            this.f5087c = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f5085a.getText().toString().equals(d.this.N6.B())) {
                d.this.a(this.f5085a, this.f5086b);
                this.f5087c.dismiss();
                if (d.this.T.equals("1") || d.this.T.equals("10") || d.this.T.equals("14")) {
                    d.this.W0();
                    d dVar = d.this;
                    if (dVar.B && dVar.A) {
                        dVar.i0();
                    }
                }
                b.a0 a0Var = d.this.L3;
                if (a0Var != null) {
                    a0Var.q("1");
                    return;
                }
                return;
            }
            if ("2".equals(com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_INNOVATIVE_SERVICE_FLAG))) {
                d.this.a(this.f5085a, this.f5086b);
                this.f5087c.dismiss();
            } else {
                this.f5085a.setText("");
                this.f5087c.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.limitpwd_is_wrong));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class r implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.b f5089a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EditText f5090b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f5091c;

        r(com.zte.iptvclient.android.common.customview.a.a.a.b bVar, EditText editText, Context context) {
            this.f5089a = bVar;
            this.f5090b = editText;
            this.f5091c = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5089a.dismiss();
            d.this.a(this.f5090b, this.f5091c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class s implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EditText f5093a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f5094b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.b f5095c;

        /* compiled from: SinglePlayerFragment.java */
        /* loaded from: classes.dex */
        class a implements com.zte.iptvclient.android.mobile.order.helper.c {
            a() {
            }

            @Override // com.zte.iptvclient.android.mobile.order.helper.c
            public void a(int i, String str) {
                LogEx.d("PlayerFragment", "payCallback");
                d.this.j(i);
            }
        }

        /* compiled from: SinglePlayerFragment.java */
        /* loaded from: classes.dex */
        class b implements a.h {
            b(s sVar) {
            }
        }

        /* compiled from: SinglePlayerFragment.java */
        /* loaded from: classes.dex */
        class c implements com.zte.iptvclient.android.mobile.order.phone.f {
            c() {
            }

            @Override // com.zte.iptvclient.android.mobile.order.phone.f
            public void a(int i, String str) {
                d.this.j(i);
            }
        }

        /* compiled from: SinglePlayerFragment.java */
        /* renamed from: com.zte.iptvclient.android.common.player.k.d$s$d, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0154d implements com.zte.iptvclient.android.mobile.order.helper.c {
            C0154d() {
            }

            @Override // com.zte.iptvclient.android.mobile.order.helper.c
            public void a(int i, String str) {
                LogEx.d("PlayerFragment", "payCallback");
                d.this.j(i);
            }
        }

        /* compiled from: SinglePlayerFragment.java */
        /* loaded from: classes.dex */
        class e implements a.h {
            e(s sVar) {
            }
        }

        /* compiled from: SinglePlayerFragment.java */
        /* loaded from: classes.dex */
        class f implements com.zte.iptvclient.android.mobile.order.phone.f {
            f() {
            }

            @Override // com.zte.iptvclient.android.mobile.order.phone.f
            public void a(int i, String str) {
                d.this.j(i);
            }
        }

        s(EditText editText, Context context, com.zte.iptvclient.android.common.customview.a.a.a.b bVar) {
            this.f5093a = editText;
            this.f5094b = context;
            this.f5095c = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f5093a.getText().toString().equals(d.this.N6.B())) {
                if ("0".equals(ConfigMgr.readPropertie("EuropeLogin"))) {
                    if (d.this.N6.P()) {
                        d.this.a(this.f5093a, this.f5094b);
                        this.f5095c.dismiss();
                        d.this.W0();
                        com.zte.iptvclient.android.common.javabean.b bVar = new com.zte.iptvclient.android.common.javabean.b();
                        bVar.a(d.this.p5.get(0).f());
                        bVar.d(d.this.p5.get(0).d());
                        bVar.b("2");
                        bVar.g(d.this.p5.get(0).p());
                        bVar.e(d.this.p5.get(0).e());
                        bVar.f(d.this.F3);
                        d.this.w7 = new com.zte.iptvclient.android.common.f.b.a(d.this.f4977b, bVar, new a(), new b(this));
                        OrderDialogActivity.u = new c();
                        d.this.w7.a(d.this.h);
                        d.this.w7.a();
                        return;
                    }
                    Toast.makeText(d.this.f4977b, "订购失败4", 0).show();
                    d.this.a(this.f5093a, this.f5094b);
                    this.f5095c.dismiss();
                    d.this.W0();
                    return;
                }
                d.this.a(this.f5093a, this.f5094b);
                this.f5095c.dismiss();
                d.this.W0();
                com.zte.iptvclient.android.common.javabean.b bVar2 = new com.zte.iptvclient.android.common.javabean.b();
                bVar2.a(d.this.p5.get(0).f());
                bVar2.d(d.this.p5.get(0).d());
                bVar2.b("2");
                bVar2.g(d.this.p5.get(0).p());
                bVar2.e(d.this.p5.get(0).e());
                bVar2.f(d.this.F3);
                d.this.w7 = new com.zte.iptvclient.android.common.f.b.a(d.this.f4977b, bVar2, new C0154d(), new e(this));
                OrderDialogActivity.u = new f();
                d.this.w7.a(d.this.h);
                d.this.w7.a();
                return;
            }
            if ("2".equals(com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_INNOVATIVE_SERVICE_FLAG))) {
                d.this.a(this.f5093a, this.f5094b);
                this.f5095c.dismiss();
            } else {
                this.f5093a.setText("");
                this.f5095c.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.limitpwd_is_wrong));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class t implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.b f5101a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EditText f5102b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f5103c;

        t(com.zte.iptvclient.android.common.customview.a.a.a.b bVar, EditText editText, Context context) {
            this.f5101a = bVar;
            this.f5102b = editText;
            this.f5103c = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5101a.dismiss();
            d.this.a(this.f5102b, this.f5103c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class u implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EditText f5105a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f5106b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.b f5107c;

        /* compiled from: SinglePlayerFragment.java */
        /* loaded from: classes.dex */
        class a implements com.zte.iptvclient.android.mobile.order.helper.c {
            a() {
            }

            @Override // com.zte.iptvclient.android.mobile.order.helper.c
            public void a(int i, String str) {
                d.this.j(i);
            }
        }

        /* compiled from: SinglePlayerFragment.java */
        /* loaded from: classes.dex */
        class b implements a.h {
            b(u uVar) {
            }
        }

        /* compiled from: SinglePlayerFragment.java */
        /* loaded from: classes.dex */
        class c implements com.zte.iptvclient.android.mobile.order.phone.f {
            c() {
            }

            @Override // com.zte.iptvclient.android.mobile.order.phone.f
            public void a(int i, String str) {
                d.this.j(i);
            }
        }

        /* compiled from: SinglePlayerFragment.java */
        /* renamed from: com.zte.iptvclient.android.common.player.k.d$u$d, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0155d implements com.zte.iptvclient.android.mobile.order.helper.c {
            C0155d() {
            }

            @Override // com.zte.iptvclient.android.mobile.order.helper.c
            public void a(int i, String str) {
                d.this.j(i);
            }
        }

        /* compiled from: SinglePlayerFragment.java */
        /* loaded from: classes.dex */
        class e implements a.h {
            e(u uVar) {
            }
        }

        /* compiled from: SinglePlayerFragment.java */
        /* loaded from: classes.dex */
        class f implements com.zte.iptvclient.android.mobile.order.phone.f {
            f() {
            }

            @Override // com.zte.iptvclient.android.mobile.order.phone.f
            public void a(int i, String str) {
                d.this.j(i);
            }
        }

        u(EditText editText, Context context, com.zte.iptvclient.android.common.customview.a.a.a.b bVar) {
            this.f5105a = editText;
            this.f5106b = context;
            this.f5107c = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f5105a.getText().toString().equals(d.this.N6.B())) {
                if ("0".equals(ConfigMgr.readPropertie("EuropeLogin"))) {
                    if (d.this.N6.P()) {
                        d.this.a(this.f5105a, this.f5106b);
                        this.f5107c.dismiss();
                        d.this.W0();
                        com.zte.iptvclient.android.common.javabean.b bVar = new com.zte.iptvclient.android.common.javabean.b();
                        bVar.e(String.valueOf(d.this.q6.getText()));
                        bVar.e(String.valueOf(d.this.o6.getText()));
                        bVar.g(d.this.l1);
                        bVar.b("4");
                        bVar.a(d.this.n1);
                        bVar.d(d.this.p1);
                        d.this.w7 = new com.zte.iptvclient.android.common.f.b.a(d.this.f4977b, bVar, new a(), new b(this));
                        OrderDialogActivity.u = new c();
                        d.this.w7.a(d.this.h);
                        d.this.w7.a();
                        return;
                    }
                    Toast.makeText(d.this.f4977b, "订购失败5", 0).show();
                    d.this.a(this.f5105a, this.f5106b);
                    this.f5107c.dismiss();
                    d.this.W0();
                    return;
                }
                d.this.a(this.f5105a, this.f5106b);
                this.f5107c.dismiss();
                d.this.W0();
                com.zte.iptvclient.android.common.javabean.b bVar2 = new com.zte.iptvclient.android.common.javabean.b();
                bVar2.e(String.valueOf(d.this.q6.getText()));
                bVar2.e(String.valueOf(d.this.o6.getText()));
                bVar2.g(d.this.l1);
                bVar2.b("4");
                bVar2.a(d.this.n1);
                bVar2.d(d.this.p1);
                d.this.w7 = new com.zte.iptvclient.android.common.f.b.a(d.this.f4977b, bVar2, new C0155d(), new e(this));
                OrderDialogActivity.u = new f();
                d.this.w7.a(d.this.h);
                d.this.w7.a();
                return;
            }
            if ("2".equals(com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_INNOVATIVE_SERVICE_FLAG))) {
                d.this.a(this.f5105a, this.f5106b);
                this.f5107c.dismiss();
            } else {
                this.f5105a.setText("");
                this.f5107c.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.limitpwd_is_wrong));
            }
        }
    }

    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    class v implements Runnable {
        v() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.zte.iptvclient.android.common.k.f.a(d.this.X4)) {
                return;
            }
            int f2 = d.this.f2();
            d.this.k7.a((d.this.k7.c() + 1) % d.this.X4.size(), false);
            d.this.G7.postDelayed(d.this.H7, f2 * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class w implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.b f5114a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EditText f5115b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f5116c;

        w(com.zte.iptvclient.android.common.customview.a.a.a.b bVar, EditText editText, Context context) {
            this.f5114a = bVar;
            this.f5115b = editText;
            this.f5116c = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5114a.dismiss();
            d.this.a(this.f5115b, this.f5116c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class x implements t.d {
        x(d dVar) {
        }

        @Override // com.zte.iptvclient.android.common.k.t.d
        public void onDismiss() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class y implements Runnable {
        y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.s0 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SinglePlayerFragment.java */
    /* loaded from: classes.dex */
    public class z implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f5119a;

        z(View view) {
            this.f5119a = view;
        }

        @Override // com.zte.iptvclient.android.mobile.x.b.c.b.d
        public void a(int i) {
            String format;
            Bitmap extractThumbnail;
            String str;
            String c2 = com.zte.iptvclient.common.uiframe.a.c("Share_Video_Title");
            if (!TextUtils.isEmpty(c2) && c2.contains("$CONTENTNAME$")) {
                format = String.format(c2.replace("$CONTENTNAME$", "%1$s"), d.this.f1);
            } else {
                format = String.format(d.this.getString(R.string.share_message), d.this.f1);
            }
            String str2 = format;
            LogEx.d("PlayerFragment", "shareMessage=" + str2);
            d dVar = d.this;
            Bitmap bitmap = dVar.l5;
            if (bitmap == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(dVar.f4977b.getResources(), R.drawable.share_img);
                extractThumbnail = decodeResource != null ? Bitmap.createBitmap(decodeResource) : null;
            } else {
                extractThumbnail = ThumbnailUtils.extractThumbnail(bitmap, 100, 100);
            }
            Bitmap bitmap2 = extractThumbnail;
            long currentPosition = (CommonFunc.getPlayer() != null ? CommonFunc.getPlayer().getCurrentPosition() : 0L) / 1000;
            long j = i;
            int i2 = currentPosition < j ? 0 : (int) (currentPosition - j);
            String c3 = com.zte.iptvclient.common.uiframe.a.c("APP_Share_URL");
            if (TextUtils.isEmpty(c3)) {
                str = null;
            } else {
                str = c3 + String.format("?pcode=%1$s,%2$s,%3$d,%4$d&ptype=0", d.this.p1, "3", Integer.valueOf(i2), Integer.valueOf(i));
            }
            new com.zte.iptvclient.android.mobile.x.b.c.c(d.this.f4977b, str2, str, null, com.zte.iptvclient.android.common.i.a.a.a(R.string.share_content_title) + com.zte.iptvclient.android.common.i.a.a.a(R.string.app_name), bitmap2, null, "").a(this.f5119a);
        }
    }

    private void A2() {
        this.y7.setOnTouchListener(this.I7);
    }

    private void B2() {
        this.s6.setVisibility(0);
        this.t6.setVisibility(0);
        S1();
        T1();
        R1();
        X2();
        T2();
        Y2();
        Q2();
        l2();
        R2();
        m2();
        if (this.F1) {
            if (this.T1 != 0) {
                this.y6.setEnabled(false);
                this.R6.setEnabled(false);
                this.x6.setEnabled(false);
                this.Q6.setEnabled(false);
            } else {
                this.y6.setEnabled(this.K);
                this.R6.setEnabled(this.K);
                this.x6.setEnabled(this.K);
                this.Q6.setEnabled(this.K);
            }
            LogEx.d("PlayerFragment", "setMainPanelLive mIsTimeShifing=" + this.m + " mIsTimeShifChanging=" + this.l);
            if (!this.m && !this.l) {
                Q2();
                l2();
                R2();
                m2();
                k2();
                I1();
                return;
            }
            Q2();
            V2();
            R1();
            T2();
            R2();
            W2();
            return;
        }
        I1();
        k2();
    }

    private void C2() {
        T1();
        this.y6.setEnabled(true);
        R1();
        X2();
        Q2();
        LogEx.d("PlayerFragment", "IvPauseFull.setEnabled(true)");
        this.x6.setEnabled(true);
        S1();
        this.R6.setEnabled(true);
        T2();
        Y2();
        R2();
        this.Q6.setEnabled(true);
    }

    private void D2() {
        this.n6.setVisibility(8);
        this.d6.setVisibility(8);
    }

    private void E2() {
        if (this.b0) {
            return;
        }
        this.p7.setVisibility(8);
        D2();
        this.c6.setVisibility(0);
        this.b6.setVisibility(8);
    }

    private void F2() {
        if (!DownloadConstant.REPORT_MSGTYPE_ADD.equals(this.c1) && !DownloadConstant.REPORT_MSGTYPE_URL_NULL.equals(this.c1)) {
            if (this.E3 > 0) {
                e2();
            } else {
                c2();
            }
        } else {
            this.Z5.setVisibility(8);
            k(0);
            this.G6.setVisibility(8);
            this.V6.setVisibility(8);
        }
        if ("1".equals(com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_INTERACTIVE_WITH_STB))) {
            d2();
        } else {
            b2();
        }
    }

    private String G(String str) {
        String c2 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RATE_DEFINITION_LEVEL);
        this.C7 = c2;
        if (!TextUtils.isEmpty(c2)) {
            this.D7 = this.C7.split(",");
        }
        String c3 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RATE_DEFINITION_TITLE);
        this.E7 = c3;
        if (!TextUtils.isEmpty(c3)) {
            this.F7 = this.E7.split(",");
        }
        int i2 = 0;
        String str2 = "";
        while (true) {
            String[] strArr = this.D7;
            if (i2 >= strArr.length) {
                return str2;
            }
            if (strArr[i2].equals(str)) {
                String[] strArr2 = this.F7;
                if (i2 < strArr2.length) {
                    str2 = strArr2[i2];
                }
            }
            i2++;
        }
    }

    private void G2() {
        this.g6.setVisibility(8);
        this.Z5.setVisibility(8);
        k(false);
        k(0);
        this.G6.setVisibility(8);
        this.V6.setVisibility(8);
        this.E6.setEnabled(true);
        this.E6.setTextColor(this.f4977b.getResources().getColor(R.color.white));
        String c2 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_IS_USE_PROTECTION);
        if (TextUtils.isEmpty(c2)) {
            c2 = "1";
        }
        if ("1".equals(com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_INTERACTIVE_WITH_STB))) {
            if (!"0".equals(c2) && !"1".equals(c2)) {
                this.v6.setImageDrawable(this.f4977b.getResources().getDrawable(R.drawable.play_push_gray_new));
                this.v6.setEnabled(false);
                return;
            } else {
                this.v6.setImageDrawable(this.f4977b.getResources().getDrawable(R.drawable.play_push_new));
                this.v6.setEnabled(true);
                return;
            }
        }
        this.v6.setVisibility(8);
    }

    private void H(String str) {
        String a2;
        this.G6.setVisibility(0);
        this.V6.setVisibility(0);
        if ("1".equals(str)) {
            a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.vod_order_hint_above_bar);
        } else {
            a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_order_hint_above_bar);
        }
        String format = String.format(a2, Integer.valueOf(this.E3 / 60));
        this.H6.setText(format);
        this.W6.setText(format);
    }

    private void H2() {
        this.E6.setEnabled(false);
        this.E6.setTextColor(getResources().getColor(R.color.text_grey_new3));
        this.v6.setVisibility(8);
    }

    private void I2() {
        com.zte.iptvclient.android.common.customview.a.a.e.l lVar = this.P6;
        if (lVar != null) {
            if (lVar.isShowing()) {
                this.P6.dismiss();
            } else {
                this.P6.show();
                this.P6.a();
            }
        }
    }

    private void J2() {
        com.zte.iptvclient.android.common.customview.a.a.e.l lVar = this.P6;
        if (lVar != null && lVar.isShowing()) {
            this.P6.dismiss();
            return;
        }
        com.zte.iptvclient.android.common.customview.a.a.e.l lVar2 = this.P6;
        if (lVar2 != null) {
            lVar2.show();
            this.P6.a();
        }
    }

    private void K2() {
        if (!this.B) {
            h2();
        }
        f0();
        this.C6.setVisibility(8);
        this.D6.setVisibility(8);
        v1();
        if (this.s) {
            this.y6.setProgress(100);
            this.R6.setProgress(100);
        }
        B2();
        if (this.T.equals("10")) {
            D1();
        }
        A(this.c1);
        LogEx.d("PlayerFragment", " mstrDefinitonType  is " + this.c1);
        if (getActivity() != null) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("gesture_help", 0);
            if (!sharedPreferences.getBoolean("first_in", false) && (this.T1 == 0 || this.E3 > 0)) {
                sharedPreferences.edit().putBoolean("first_in", true).commit();
            }
        }
        LogEx.d("PlayerFragment", " mbIsVRVideo  is " + this.q);
        E2();
    }

    private void L2() {
        this.v6.setOnClickListener(this);
        this.b6.setOnClickListener(this);
        this.c6.setOnClickListener(this);
        this.b7.setOnClickListener(this);
        this.I6.setOnClickListener(this);
        this.q7.setOnClickListener(this);
        this.i6.setOnClickListener(this);
        this.n6.setOnClickListener(this.H3);
        this.x6.setOnClickListener(this.G3);
        this.y6.setOnSeekBarChangeListener(this.K3);
        this.B6.setOnClickListener(this.I3);
        this.U6.setOnClickListener(this.I3);
        this.Q6.setOnClickListener(this.G3);
        this.R6.setOnSeekBarChangeListener(this.K3);
    }

    private void M2() {
        this.h.setOnTouchListener(new i0());
        this.e6.setOnItemClickListener(new a());
        this.e6.setOnScrollListener(new b());
        if (this.T.equals("1") || this.T.equals("10") || this.T.equals("14")) {
            this.p7.setOnCheckedChangeListener(new c());
        }
        L2();
        A2();
        this.A7.setOnClickListener(new ViewOnClickListenerC0153d());
        this.B7.setOnClickListener(new e());
    }

    private void N2() {
        com.zte.iptvclient.android.common.customview.a.a.e.f fVar = new com.zte.iptvclient.android.common.customview.a.a.e.f(this.f4977b, R.drawable.custom_dialog_login_img, R.string.login_the_system_first, R.drawable.custom_dialog_button_blue, R.string.login_btnlogin, 0, R.drawable.custom_dialog_button_blue, R.string.common_cancel, 0, new b0());
        fVar.a();
        fVar.setCanceledOnTouchOutside(false);
    }

    private void O2() {
        g2();
        if (this.A) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((this.V5 * 3) / 5, -1);
            layoutParams.addRule(11, -1);
            FrameLayout frameLayout = this.r5;
            if (frameLayout != null) {
                frameLayout.setLayoutParams(layoutParams);
            }
        } else {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, (this.W5 * 3) / 5);
            layoutParams2.addRule(12, -1);
            FrameLayout frameLayout2 = this.r5;
            if (frameLayout2 != null) {
                frameLayout2.setLayoutParams(layoutParams2);
            }
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        androidx.fragment.app.r b2 = childFragmentManager.b();
        if (childFragmentManager.c(com.zte.iptvclient.android.mobile.a0.b.b.class.getSimpleName()) != null) {
            b2.e(this.X5);
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.y.b());
        } else {
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
            if (TextUtils.isEmpty(fVar.c()) || TextUtils.isEmpty(fVar.d())) {
                return;
            }
            if (!com.zte.iptvclient.android.common.player.multiplay.a.c().a(fVar)) {
                com.zte.iptvclient.android.common.player.multiplay.a.c().a().add(0, fVar);
            }
            if (com.zte.iptvclient.android.common.player.multiplay.a.c().a().size() > 4) {
                com.zte.iptvclient.android.common.player.multiplay.a.c().a().remove(4);
            }
            this.X5 = new com.zte.iptvclient.android.mobile.a0.b.b();
            Bundle bundle = new Bundle();
            bundle.putBoolean("isMultiScreenMode", true);
            bundle.putInt("themetype", 1);
            this.X5.setArguments(bundle);
            b2.a(R.id.fl_multi_play_manager_for_single, this.X5, com.zte.iptvclient.android.mobile.a0.b.b.class.getSimpleName());
            b2.a((String) null);
        }
        Fragment c2 = childFragmentManager.c(com.zte.iptvclient.android.mobile.v.b.a.class.getSimpleName());
        if (c2 != null && (c2 instanceof com.zte.iptvclient.android.mobile.v.b.a)) {
            b2.c(c2);
        }
        b2.b();
        FrameLayout frameLayout3 = this.r5;
        if (frameLayout3 != null) {
            frameLayout3.setVisibility(0);
        }
        E();
    }

    private void P2() {
        if (Build.VERSION.SDK_INT >= 14) {
            if (this.A) {
                this.h.setSystemUiVisibility(3846);
            } else {
                this.h.setSystemUiVisibility(0);
            }
        }
    }

    private void Q2() {
        ImageView imageView = this.x6;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    private void R2() {
        ImageView imageView = this.Q6;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    private void S2() {
        if (this.l7 != null) {
            LogEx.d("PlayerFragment", "showPlayEndLayout");
            this.l7.setVisibility(0);
        }
    }

    private void T2() {
        TextView textView = this.S6;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    private void U2() {
        if (this.L.isPlaying()) {
            W0();
        }
        if (this.i7 == null) {
            this.i7 = new com.zte.iptvclient.android.common.player.multiplay.c(this.f4977b, this.h7, this.T, this.A && !this.B, this, this.q1);
        } else {
            this.h7.setVisibility(0);
            this.i7.b();
        }
        this.i0 = false;
        F1();
        this.s0 = false;
    }

    private void V2() {
        ImageView imageView = this.B6;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    private void W2() {
        ImageView imageView = this.U6;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X1() {
        if (this.A) {
            RelativeLayout relativeLayout = this.f;
            if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                f0();
            } else {
                E();
            }
            FrameLayout frameLayout = this.r5;
            if (frameLayout == null || frameLayout.getVisibility() != 0) {
                return;
            }
            this.r5.setVisibility(8);
        }
    }

    private void X2() {
        TextView textView = this.A6;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y1() {
        V1();
    }

    private void Y2() {
        TextView textView = this.T6;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    private void Z1() {
        com.zte.iptvclient.android.common.customview.a.a.b.b bVar = this.s7;
        if (bVar != null) {
            bVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.d dVar = this.r7;
        if (dVar != null) {
            dVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.a aVar = this.t7;
        if (aVar != null) {
            aVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.e.l lVar = this.P6;
        if (lVar != null) {
            lVar.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z2() {
        startActivity(new Intent(this.f4977b, (Class<?>) LoginActivity.class));
        this.f4977b.finish();
    }

    private void a2() {
        if ("1".equals(ConfigMgr.readPropertie("SupportRemoteDownload", "0"))) {
            if (("10".equals(this.T) || "14".equals(this.T) || "1".equals(this.T)) && !DownloadConstant.REPORT_MSGTYPE_ADD.equals(this.c1)) {
                DownloadConstant.REPORT_MSGTYPE_URL_NULL.equals(this.c1);
            }
        }
    }

    private void a3() {
        this.u7 = "1".equals(ConfigMgr.readPropertie("IsShowOrderLock"));
        if (!this.N6.b0().booleanValue()) {
            Z2();
            return;
        }
        if (!this.T.equals("1") && !this.T.equals("10") && !this.T.equals("14")) {
            if (this.T.equals("2")) {
                u2();
                return;
            } else {
                if (this.T.equals("4")) {
                    v2();
                    return;
                }
                return;
            }
        }
        w2();
    }

    private void b2() {
        this.v6.setVisibility(8);
    }

    private void b3() {
        if (this.T.equals("1") || this.T.equals("10") || this.T.equals("14")) {
            W0();
            if (this.B && this.A) {
                i0();
            }
        }
        if (this.A && !this.B) {
            com.zte.iptvclient.android.common.javabean.b bVar = new com.zte.iptvclient.android.common.javabean.b();
            bVar.a(this.n1);
            bVar.d(this.q1);
            bVar.e(this.f1);
            bVar.b(this.T);
            bVar.g(this.l1);
            bVar.f(this.F3);
            com.zte.iptvclient.android.common.f.b.a aVar = new com.zte.iptvclient.android.common.f.b.a(this.f4977b, bVar, new g(), new h(this));
            OrderDialogActivity.u = new i();
            aVar.a(this.h);
            aVar.a();
            return;
        }
        b.a0 a0Var = this.L3;
        if (a0Var != null) {
            a0Var.q("1");
        }
        com.zte.iptvclient.android.common.eventbus.multi.g gVar = new com.zte.iptvclient.android.common.eventbus.multi.g();
        gVar.a(this.n1);
        gVar.b(this.T);
        gVar.c(this.q1);
        gVar.d(this.f1);
        gVar.f(this.a1);
        gVar.e(this.F3);
        gVar.a(this);
        EventBus.getDefault().post(gVar);
    }

    private void c2() {
        A();
        i(0);
    }

    private void d2() {
        this.v6.setImageDrawable(this.f4977b.getResources().getDrawable(R.drawable.play_push_gray_new));
        this.v6.setEnabled(false);
    }

    private void e2() {
        this.Z5.setVisibility(8);
        k(0);
        ViewGroup.LayoutParams layoutParams = this.I6.getLayoutParams();
        if (!this.N6.b0().booleanValue()) {
            this.I6.setText(R.string.play_activity_login);
            if (layoutParams != null) {
                layoutParams.width = com.zte.iptvclient.common.uiframe.f.a(90);
            }
        } else {
            this.I6.setText(R.string.order_pay);
            if (layoutParams != null) {
                layoutParams.width = com.zte.iptvclient.common.uiframe.f.a(90);
            }
        }
        if (this.T.equals("1")) {
            H("1");
        } else if (this.T.equals("2") || this.T.equals("4")) {
            H("2");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f2() {
        try {
            return Integer.parseInt(SDKLoginMgr.getInstance().getPropertiesInfo(PortalConst.PAUSE_AD_LOOP_INTERVAL));
        } catch (Exception unused) {
            return 3;
        }
    }

    private void g2() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f4977b.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.V5 = displayMetrics.widthPixels;
        this.W5 = displayMetrics.heightPixels;
        LogEx.d("PlayerFragment", "nScreenWidth : " + this.V5 + " , nScreenHeight : " + this.W5);
    }

    private void h2() {
        if (Build.VERSION.SDK_INT >= 14) {
            this.h.setSystemUiVisibility(3846);
        }
    }

    private void i2() {
        ImageView imageView = this.x6;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void j2() {
        ImageView imageView = this.Q6;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void k2() {
        TextView textView = this.S6;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void l2() {
        ImageView imageView = this.B6;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void m2() {
        ImageView imageView = this.U6;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void n2() {
        TextView textView = this.A6;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void o2() {
        TextView textView = this.T6;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void p2() {
        IBasePlayer iBasePlayer = this.L;
        if (iBasePlayer != null) {
            iBasePlayer.init(this.h, 2, false);
        }
    }

    private void q2() {
        com.zte.iptvclient.android.common.customview.a.a.e.l lVar = new com.zte.iptvclient.android.common.customview.a.a.e.l(getActivity(), false);
        this.P6 = lVar;
        lVar.a(new d0());
        ArrayList<String> arrayList = this.b1;
        if (arrayList != null && arrayList.size() > 1) {
            com.zte.iptvclient.android.common.player.h hVar = new com.zte.iptvclient.android.common.player.h(this.f4977b.getApplicationContext(), null, null);
            this.c5 = hVar;
            hVar.a(new e0());
        }
        this.f6 = new com.zte.iptvclient.android.mobile.a0.a.e.b(this.f4977b.getApplicationContext(), this.i1);
        z2();
        this.e6.setAdapter((ListAdapter) this.f6);
    }

    private void r2() {
        W0();
        com.zte.iptvclient.android.common.javabean.b bVar = new com.zte.iptvclient.android.common.javabean.b();
        bVar.e(String.valueOf(this.o6.getText()));
        bVar.e(String.valueOf(this.q6.getText()));
        bVar.g(this.l1);
        bVar.b("4");
        bVar.a(this.n1);
        bVar.d(this.p1);
        bVar.f(this.F3);
        this.w7 = new com.zte.iptvclient.android.common.f.b.a(this.f4977b, bVar, new n(), new o(this));
        OrderDialogActivity.u = new p();
        this.w7.a(this.h);
        this.w7.a();
    }

    private void s2() {
        W0();
        com.zte.iptvclient.android.common.javabean.b bVar = new com.zte.iptvclient.android.common.javabean.b();
        bVar.a(this.p5.get(0).l());
        bVar.d(this.p5.get(0).d());
        bVar.b("2");
        bVar.g(this.p5.get(0).p());
        bVar.e(this.p5.get(0).e());
        bVar.f(this.F3);
        this.w7 = new com.zte.iptvclient.android.common.f.b.a(this.f4977b, bVar, new j(), new l(this));
        OrderDialogActivity.u = new m();
        this.w7.a(this.h);
        this.w7.a();
        com.zte.iptvclient.android.common.eventbus.multi.g gVar = new com.zte.iptvclient.android.common.eventbus.multi.g();
        gVar.a(this.p5.get(0).l());
        gVar.c(this.p5.get(0).d());
        gVar.b("2");
        gVar.f(this.p5.get(0).p());
        gVar.d(this.p5.get(0).e());
        gVar.e(this.F3);
        gVar.a(this);
        EventBus.getDefault().post(gVar);
    }

    private boolean t2() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.g7 <= DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS) {
            LogEx.w("UseeTv", "Operate limit,less than 5000(ms)!");
            return true;
        }
        this.g7 = currentTimeMillis;
        return false;
    }

    private void u2() {
        Bundle bundle = this.Y5;
        if (bundle == null) {
            return;
        }
        String string = bundle.getString("contentcode", "");
        LogEx.d("PlayerFragment", "contentcode:" + string + ", ratingid:" + bundle.getString("ratingid", ""));
        if (t2()) {
            return;
        }
        Log.d("99999", "4=====" + this.u7 + "," + this.N6.A());
        if (string != null && this.u7 && this.N6.A()) {
            a(this.f4977b);
        } else {
            s2();
        }
    }

    private void v2() {
        Bundle bundle = this.Y5;
        if (bundle == null) {
            return;
        }
        String string = bundle.getString("contentcode", "");
        LogEx.d("PlayerFragment", "contentcode:" + string + ", ratingid:" + bundle.getString("ratingid", ""));
        if (t2()) {
            return;
        }
        Log.d("99999", "5=====" + this.u7 + "," + this.N6.A());
        if (string != null && this.u7 && this.N6.A()) {
            b(this.f4977b);
        } else {
            r2();
        }
    }

    private void w2() {
        Bundle bundle = this.Y5;
        if (bundle == null) {
            return;
        }
        LogEx.d("PlayerFragment", bundle.toString());
        if (t2()) {
            return;
        }
        String string = this.T.equals("1") ? bundle.getString("Id", "") : "";
        if (this.T.equals("10") || this.T.equals("14")) {
            string = bundle.getString("contentcode", "");
        }
        LogEx.d("PlayerFragment", "ratingid:" + bundle.getString("ratingid", ""));
        Log.d("99999", "6=====" + this.u7 + "," + this.N6.A());
        if (string != null && this.u7 && this.N6.A()) {
            c(this.f4977b);
        } else {
            b3();
        }
    }

    private void x2() {
        this.X6 = new j0(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        this.f4977b.registerReceiver(this.X6, intentFilter);
    }

    private void y2() {
        ViewGroup.LayoutParams layoutParams = this.e6.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f4977b.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (layoutParams != null) {
            layoutParams.height = displayMetrics.heightPixels;
            this.e6.setLayoutParams(layoutParams);
        }
    }

    private void z2() {
        if (this.i1 != null) {
            for (int i2 = 0; i2 < this.i1.size(); i2++) {
                if (this.p5.size() > 0 && this.p5.get(0) != null && TextUtils.equals(this.p5.get(0).d(), this.i1.get(i2).getChannelcode())) {
                    this.f6.a(i2);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.iptvclient.android.common.player.k.a
    public void A() {
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void A(String str) {
        String G = G(str);
        LogEx.d("PlayerFragment", "strDefinitionTitle = " + G);
        if (this.u1.equals(str)) {
            this.E6.setText(R.string.play_vedio_type_local);
        } else if (this.v1.equals(str)) {
            this.E6.setText(R.string.play_vedio_type_hc);
        } else {
            this.E6.setText(G);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void A0() {
        this.G7.sendEmptyMessageDelayed(4, 500L);
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void B(String str) {
        this.s6.setText(str);
        LogEx.d("PlayerFragment", "strChannelName:" + str);
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    public void B0() {
        if (this.s) {
            this.e6.setVisibility(8);
            this.Z6 = false;
            if (this.f.getVisibility() != 0 && (!this.b0 || !this.A)) {
                this.d6.setVisibility(8);
            } else if (this.i0) {
                this.d6.setVisibility(0);
            }
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void C(String str) {
        if (this.i1 == null || this.f6 == null) {
            return;
        }
        for (int i2 = 0; i2 < this.i1.size(); i2++) {
            if (str != null && TextUtils.equals(str, this.i1.get(i2).getChannelcode())) {
                this.f6.a(i2);
                return;
            }
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    public void D(String str) {
        this.o6.setText(str);
        this.q6.setText(str);
        this.p6 = str;
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    public void D0() {
        H1();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void D1() {
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void E(String str) {
        if (StringUtil.isEmptyString(str)) {
            return;
        }
        this.t6.setText("(" + str + ")");
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void E0() {
        this.G7.sendEmptyMessageDelayed(1, 500L);
    }

    public com.zte.iptvclient.android.common.javabean.f E1() {
        return this.x7;
    }

    protected void F1() {
        LinearLayout linearLayout;
        if (this.Z6 || (linearLayout = this.d6) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    public void G1() {
        if (this.X5 != null) {
            androidx.fragment.app.r b2 = getChildFragmentManager().b();
            b2.c(this.X5);
            b2.b();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void H0() {
        this.G7.sendEmptyMessageDelayed(2, 500L);
    }

    public void H1() {
        if (this.l7 != null) {
            LogEx.d("PlayerFragment", "hidePlayEndLayout");
            this.l7.setVisibility(8);
        }
    }

    protected void I1() {
        TextView textView = this.z6;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    protected void J1() {
        SeekBar seekBar = this.R6;
        if (seekBar != null) {
            seekBar.setVisibility(8);
        }
    }

    protected void K1() {
        SeekBar seekBar = this.y6;
        if (seekBar != null) {
            seekBar.setVisibility(8);
        }
    }

    public void L1() {
        this.q6.setVisibility(4);
    }

    public void M1() {
        i0();
    }

    public void N1() {
        this.T1 = 0;
        this.J1 = true;
        v1();
        this.x6.setEnabled(true);
        this.Q6.setEnabled(true);
        this.y6.setEnabled(true);
        this.R6.setEnabled(true);
        if (this.E3 > 0) {
            if (!this.T.equals("10") && !this.T.equals("14")) {
                X0();
                return;
            }
            if (this.J) {
                h0();
                p2();
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
            if (this.T.equals("10") || this.T.equals("14")) {
                D1();
            }
            h0();
            p2();
            z1();
            return;
        }
        if ("2".equals(this.T)) {
            j0();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    public boolean O0() {
        com.zte.iptvclient.android.common.customview.a.a.e.l lVar = this.P6;
        return lVar != null && lVar.isShowing();
    }

    public void O1() {
        IBasePlayer iBasePlayer = this.L;
        if (iBasePlayer == null) {
            return;
        }
        iBasePlayer.resume4bg();
    }

    protected void P1() {
        String str = this.Z0;
        if (str != null && !TextUtils.equals(str, "")) {
            if (com.zte.iptvclient.android.mobile.h.a.a.g().b() == null) {
                if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                    if (this.A) {
                        i0();
                    }
                    com.zte.iptvclient.android.common.k.t.a(this.f4977b, new x(this));
                    return;
                } else {
                    this.Y6 = true;
                    if (this.A) {
                        I2();
                        return;
                    } else {
                        J2();
                        return;
                    }
                }
            }
            if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                N2();
                return;
            }
            String str2 = this.Z0;
            if (str2.endsWith("breakpoint=")) {
                if (this.x3 < 0) {
                    this.x3 = 0L;
                }
                str2 = this.Z0 + (this.x3 / 1000);
            }
            LogEx.d("PlayerFragment", "VOD_PLAY_UR_4_DLNA = " + str2);
            com.zte.iptvclient.android.mobile.h.a.a.g().c(str2);
            if ("1".equals(ConfigMgr.readPropertie("IsSupportCastScreen", "0"))) {
                com.zte.iptvclient.android.common.customview.a.a.e.l lVar = this.P6;
                if (lVar != null && lVar.isShowing()) {
                    this.P6.dismiss();
                }
                U2();
                return;
            }
            return;
        }
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.dlna_is_null);
    }

    protected void Q1() {
        LinearLayout linearLayout;
        if (((this.d6 == null || !this.s) && !this.b0) || (linearLayout = this.d6) == null || !this.i0) {
            return;
        }
        linearLayout.setVisibility(0);
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    public void R() {
        super.R();
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.i.c(this.q1, this.x3));
    }

    protected void R1() {
        TextView textView = this.z6;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    protected void S1() {
        SeekBar seekBar = this.R6;
        if (seekBar != null) {
            seekBar.setVisibility(0);
        }
    }

    protected void T1() {
        SeekBar seekBar = this.y6;
        if (seekBar != null) {
            seekBar.setVisibility(0);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void U0() {
        this.G7.removeCallbacks(this.H7);
        LogEx.d("onAdImageHide", "onAdImageHide");
    }

    public void U1() {
        TextView textView = this.q6;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void V0() {
        if (com.zte.iptvclient.android.common.k.f.a(this.X4)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.X4) {
            ImageView imageView = new ImageView(this.f4977b);
            com.bumptech.glide.i.a(getActivity()).a(str).a(imageView);
            arrayList.add(imageView);
        }
        if (this.k7 == null) {
            this.k7 = new ViewPager(this.f4977b);
        }
        this.k7.a(new c0(this, arrayList));
        this.k7.d(0);
        if (arrayList.size() > 1) {
            this.G7.postDelayed(this.H7, f2() * 1000);
        }
    }

    public void V1() {
        if (this.A) {
            return;
        }
        this.B7.setVisibility(8);
        y1();
        this.s0 = false;
        if (getActivity() != null && ((MultiPlayActivity) getActivity()).r() != null) {
            ((MultiPlayActivity) this.f4977b).r().g();
            ((MultiPlayActivity) this.f4977b).r().d(this);
        }
        LogEx.d("PlayerFragment", " scalePlayer()");
        l(true);
        E();
        Z1();
        u0();
        f0();
        this.L.resume4bg();
        new Handler().postDelayed(new y(), 500L);
        if (this.W4) {
            new RelativeLayout.LayoutParams(com.zte.iptvclient.android.common.k.g.a(this.f4977b, 320.0f), com.zte.iptvclient.android.common.k.g.a(this.f4977b, 240.0f)).addRule(13);
        }
    }

    public void W1() {
        IBasePlayer iBasePlayer = this.L;
        if (iBasePlayer != null && iBasePlayer.isPlaying()) {
            this.L.suspend4bg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.iptvclient.android.common.player.k.a
    public void c0() {
        if (!this.s) {
            C2();
        } else {
            B2();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void d1() {
        this.f6.notifyDataSetChanged();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b, com.zte.iptvclient.android.common.player.k.a
    protected void e0() {
        this.E6.setVisibility(8);
        this.s6.setVisibility(0);
        this.t6.setVisibility(0);
        K2();
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    public void f0() {
        LogEx.d("PlayerFragment", "showMediaController");
        if (com.zte.iptvclient.android.common.player.multiplay.a.c().a().size() == 1) {
            this.B7.setVisibility(8);
        }
        if (this.s5) {
            CheckBox checkBox = this.p7;
            if (checkBox != null && checkBox.getVisibility() != 0) {
                this.p7.setVisibility(0);
                return;
            }
            CheckBox checkBox2 = this.p7;
            if (checkBox2 != null) {
                checkBox2.setVisibility(8);
                return;
            }
            return;
        }
        P2();
        if (this.A) {
            if (this.s) {
                Q1();
            } else {
                F1();
            }
            if (this.f.getVisibility() != 0) {
                this.n6.setVisibility(0);
                this.f.setVisibility(0);
                this.p7.setVisibility(0);
                this.f.requestLayout();
                this.A7.setVisibility(8);
            }
            RelativeLayout relativeLayout = this.g;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
                this.g.requestLayout();
                return;
            }
            return;
        }
        F1();
        this.A7.setVisibility(8);
        if (this.g.getVisibility() != 0) {
            this.n6.setVisibility(8);
            this.g.setVisibility(0);
            this.g.requestLayout();
            if (com.zte.iptvclient.android.common.player.multiplay.a.c().a().size() > 1) {
                this.A7.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.iptvclient.android.common.player.k.a
    public void h0() {
        if (!this.J1) {
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void h1() {
        LogEx.d("PlayerFragment", "resumePlay");
        this.j6.setVisibility(0);
        if (!TextUtils.isEmpty(this.w3)) {
            this.P = Integer.parseInt(this.w3);
            A1();
        } else {
            if (this.s) {
                j0();
                return;
            }
            try {
                this.P = Integer.parseInt(this.i4) * 1000;
            } catch (Exception unused) {
                LogEx.e("PlayerFragment", "mstrBreakPoint can not be parsed to int");
                this.P = 0L;
            }
            h0();
            LogEx.d("PlayerFragment", "resumePlay setPlayerUrl");
            t(this.f2);
            Q();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    public void i0() {
        if (this.A) {
            this.B7.setVisibility(0);
            E();
            LogEx.d("PlayerFragment", " scalePlayer()");
            l(false);
            if (getActivity() != null && ((MultiPlayActivity) getActivity()).r() != null) {
                ((MultiPlayActivity) getActivity()).r().e();
            }
            f0();
            y1();
            FrameLayout frameLayout = this.r5;
            if (frameLayout != null && frameLayout.getVisibility() == 0) {
                this.r5.setVisibility(8);
            }
            this.p7.setVisibility(8);
            if (getActivity() == null || ((MultiPlayActivity) getActivity()).s() != 1) {
                return;
            }
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.f("play", true));
            getActivity().finish();
        }
    }

    public void k(boolean z2) {
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void k1() {
        this.O6.setVisibility(4);
        this.m6.setVisibility(4);
        k2();
        o2();
        n2();
        J1();
        K1();
        j2();
        i2();
        this.C6.setVisibility(4);
        this.D6.setVisibility(4);
        this.v6.setVisibility(4);
        this.w6.setVisibility(4);
        this.E6.setVisibility(4);
        I1();
        this.s6.setVisibility(4);
        this.t6.setVisibility(4);
        this.n6.setVisibility(4);
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void l1() {
        Activity activity = this.f4977b;
        if (activity == null) {
            return;
        }
        AudioManager audioManager = (AudioManager) activity.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.S3 = audioManager;
        this.T3 = audioManager.getStreamMaxVolume(3);
        this.U3 = this.S3.getStreamVolume(3);
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void m1() {
        this.G7.removeMessages(4);
        com.zte.iptvclient.android.common.customview.a.a.b.b bVar = this.s7;
        if (bVar != null) {
            bVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.d dVar = this.r7;
        if (dVar != null) {
            dVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.a aVar = this.t7;
        if (aVar != null) {
            aVar.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        LogEx.i("PlayerFragment", "onActivityCreated");
        I0();
        K0();
        M0();
        q2();
        K2();
        y2();
        M2();
        BaseApp.e().c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_full_more_screen /* 2131296435 */:
                O2();
                return;
            case R.id.btn_full_screen_exit /* 2131296437 */:
                i0();
                return;
            case R.id.btn_full_screen_order_hint /* 2131296440 */:
            case R.id.btn_preview_order_hint /* 2131296474 */:
                a3();
                return;
            case R.id.btn_full_screen_play_push /* 2131296442 */:
                P1();
                return;
            case R.id.btn_full_screen_tvshare /* 2131296445 */:
            case R.id.img_full_screen_channel /* 2131296957 */:
                if (System.currentTimeMillis() - this.r6 > 1000) {
                    if ("1".equals(ConfigMgr.readPropertie("isShowInConstructionTip"))) {
                        com.zte.iptvclient.android.common.k.t.a(this.f4977b);
                        return;
                    } else {
                        this.r6 = System.currentTimeMillis();
                        n(view);
                        return;
                    }
                }
                return;
            case R.id.btn_login /* 2131296460 */:
                Z2();
                return;
            case R.id.llayout_continue_play_end /* 2131297361 */:
                D0();
                L();
                return;
            case R.id.rlayout_player /* 2131297910 */:
                if (this.A) {
                    X1();
                    return;
                }
                return;
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
                E();
                this.A = true;
                f0();
                if (this.W4) {
                    new RelativeLayout.LayoutParams(com.zte.iptvclient.android.common.k.g.a(this.f4977b, 320.0f), com.zte.iptvclient.android.common.k.g.a(this.f4977b, 240.0f)).addRule(13);
                }
                c(com.zte.iptvclient.android.common.k.g.a(this.f4977b, 180.0f), com.zte.iptvclient.android.common.k.g.a(this.f4977b, 120.0f));
            } else if (i2 == 1) {
                E();
                this.A = false;
                f0();
                if (this.W4) {
                    new RelativeLayout.LayoutParams(com.zte.iptvclient.android.common.k.g.a(this.f4977b, 270.0f), com.zte.iptvclient.android.common.k.g.a(this.f4977b, 200.0f)).addRule(13);
                }
                c(com.zte.iptvclient.android.common.k.g.a(this.f4977b, 100.0f), com.zte.iptvclient.android.common.k.g.a(this.f4977b, 70.0f));
            }
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // com.zte.iptvclient.android.common.player.k.b, com.zte.iptvclient.android.common.player.k.a, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogEx.i("PlayerFragment", "onCreate");
        EventBus.getDefault().register(this);
        Intent intent = new Intent();
        intent.setAction("FloatWindowClose");
        this.f4977b.getApplicationContext().sendBroadcast(intent);
        this.N6 = new com.zte.iptvclient.android.common.j.h(this.f4977b.getApplicationContext());
        this.o5 = BaseApp.e().b();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LogEx.i("PlayerFragment", "onCreateView");
        View inflate = layoutInflater.inflate(R.layout.play_fragment_layout_more_screen, viewGroup, false);
        this.y7 = inflate;
        a(inflate);
        m(this.y7);
        l1();
        return this.y7;
    }

    @Override // com.zte.iptvclient.android.common.player.k.b, com.zte.iptvclient.android.common.player.k.a, androidx.fragment.app.Fragment
    public void onDestroy() {
        Intent intent = new Intent();
        intent.setAction("FloatWindowUpdate");
        Activity activity = this.f4977b;
        if (activity != null) {
            activity.getApplicationContext().sendBroadcast(intent);
        }
        Z1();
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.g gVar) {
        LogEx.d("PlayerFragment", "recv PushPlayEvent");
        P1();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.u.a aVar) {
    }

    @Override // com.zte.iptvclient.android.common.player.k.a, androidx.fragment.app.Fragment
    public void onPause() {
        LogEx.i("PlayerFragment", "onPause");
        super.onPause();
        this.f4977b.unregisterReceiver(this.X6);
    }

    @Override // com.zte.iptvclient.android.common.player.k.b, com.zte.iptvclient.android.common.player.k.a, androidx.fragment.app.Fragment
    public void onResume() {
        LogEx.i("PlayerFragment", "onResume");
        super.onResume();
        x2();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    public void p1() {
        S2();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void q1() {
        this.G7.removeMessages(1);
        com.zte.iptvclient.android.common.customview.a.a.b.d dVar = this.r7;
        if (dVar != null) {
            dVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.a aVar = this.t7;
        if (aVar != null) {
            aVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.b bVar = this.s7;
        if (bVar != null) {
            bVar.show();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    public void v0() {
        com.zte.iptvclient.android.common.customview.a.a.e.l lVar = this.P6;
        if (lVar == null || !lVar.isShowing()) {
            return;
        }
        this.P6.dismiss();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void v1() {
        a2();
        if (this.H1) {
            LogEx.i("PlayerFragment", "if from downloaded: yes.");
            H2();
        } else if (this.T1 != 0) {
            F2();
        } else {
            G2();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void w(String str) {
        LogEx.d("PlayerFragment", "onPlayTimeChanged=" + str);
        this.z6.setText(str);
        this.S6.setText(str);
        this.A5 = str;
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void w1() {
        this.G7.removeMessages(2);
        com.zte.iptvclient.android.common.customview.a.a.b.b bVar = this.s7;
        if (bVar != null) {
            bVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.a aVar = this.t7;
        if (aVar != null) {
            aVar.dismiss();
        }
        com.zte.iptvclient.android.common.customview.a.a.b.d dVar = this.r7;
        if (dVar != null) {
            dVar.show();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void x(String str) {
        this.A6.setText(str);
        this.T6.setText(str);
        this.B5 = str;
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected boolean x0() {
        return com.zte.iptvclient.android.mobile.n.c.b.t();
    }

    private void b(View view) {
        int a2;
        int a3;
        if (getResources().getConfiguration().orientation == 2) {
            a2 = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 180.0f);
            a3 = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 120.0f);
        } else {
            a2 = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 100.0f);
            a3 = com.zte.iptvclient.android.common.k.g.a(this.f4977b, 70.0f);
        }
        c(a2, a3);
    }

    private void c(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.channel_list_layout);
        this.d6 = linearLayout;
        com.zte.iptvclient.common.uiframe.f.a(linearLayout);
        ListView listView = (ListView) view.findViewById(R.id.channel_list);
        this.e6 = listView;
        com.zte.iptvclient.common.uiframe.f.a(listView);
    }

    private void d(View view) {
        com.zte.iptvclient.android.common.customview.a.a.b.d dVar = new com.zte.iptvclient.android.common.customview.a.a.b.d(this.f4977b);
        this.r7 = dVar;
        dVar.setCancelable(false);
        this.r7.setCanceledOnTouchOutside(true);
        com.zte.iptvclient.android.common.customview.a.a.b.b bVar = new com.zte.iptvclient.android.common.customview.a.a.b.b(this.f4977b);
        this.s7 = bVar;
        bVar.setCancelable(false);
        this.s7.setCanceledOnTouchOutside(true);
        com.zte.iptvclient.android.common.customview.a.a.b.a aVar = new com.zte.iptvclient.android.common.customview.a.a.b.a(this.f4977b);
        this.t7 = aVar;
        aVar.setCancelable(false);
        this.t7.setCanceledOnTouchOutside(true);
    }

    private void f(View view) {
        this.g6 = (LinearLayout) view.findViewById(R.id.llayout_login_hint);
        Button button = (Button) view.findViewById(R.id.btn_login);
        this.i6 = button;
        button.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.order_pay_login));
        this.h6 = (TextView) view.findViewById(R.id.txtvew_login_hint);
        com.zte.iptvclient.common.uiframe.f.a(this.i6);
        com.zte.iptvclient.common.uiframe.f.a(this.g6);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txtvew_login_hint));
    }

    private void g(View view) {
        this.l7 = (LinearLayout) view.findViewById(R.id.llayout_end_hint);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.llayout_continue_play_end);
        this.m7 = linearLayout;
        linearLayout.setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(R.id.txtvew_end_hint);
        this.n7 = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.play_end_hint));
        TextView textView2 = (TextView) view.findViewById(R.id.txtvew_continue_play_end);
        this.o7 = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.replay));
        com.zte.iptvclient.common.uiframe.f.a(this.l7);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.llayout_end_hint));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txtvew_end_hint));
        com.zte.iptvclient.common.uiframe.f.a(this.m7);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txtvew_continue_play_end));
    }

    private void h(View view) {
        this.h7 = (ViewStub) view.findViewById(R.id.vewstub_screen_interacton);
    }

    private void i(View view) {
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.sensor_lock_full_screen);
        this.p7 = checkBox;
        com.zte.iptvclient.common.uiframe.f.a(checkBox);
        if (this.f4977b instanceof VOPlayerActivity) {
            this.p7.setVisibility(8);
        }
    }

    private void j(View view) {
        this.Z5 = (RelativeLayout) view.findViewById(R.id.llayout_preview_order_hint);
        this.a6 = (TextView) view.findViewById(R.id.txtvew_preview_order_hint);
        this.b6 = (TextView) view.findViewById(R.id.btn_preview_order_hint);
        this.c6 = (Button) view.findViewById(R.id.btn_preview_order_hint_down);
        com.zte.iptvclient.common.uiframe.f.a(this.Z5);
        com.zte.iptvclient.common.uiframe.f.a(this.a6);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_preview_order_hint_frist));
        com.zte.iptvclient.common.uiframe.f.a(this.b6);
        com.zte.iptvclient.common.uiframe.f.a(this.c6);
    }

    private void k(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rlayout_full_screen_title);
        this.l6 = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.rlayout_full_screen_main_panel);
        this.m6 = constraintLayout;
        constraintLayout.setOnTouchListener(new f0(this));
        this.f = (RelativeLayout) view.findViewById(R.id.rlayout_full_screen_control_surface);
        this.n6 = (ImageView) view.findViewById(R.id.btn_full_screen_exit);
        this.o6 = (TextView) view.findViewById(R.id.full_screen_program_name);
        this.s6 = (TextView) view.findViewById(R.id.txtview_full_screen_channel_name);
        this.t6 = (TextView) view.findViewById(R.id.txtview_full_screen_program_time);
        this.u6 = (TextView) view.findViewById(R.id.txtview_stb_name);
        this.v6 = (ImageView) view.findViewById(R.id.btn_full_screen_play_push);
        this.w6 = (ImageView) view.findViewById(R.id.btn_full_screen_volume);
        this.x6 = (ImageView) view.findViewById(R.id.btn_full_screen_play_pause);
        this.y6 = (SeekBar) view.findViewById(R.id.bar_full_screen_play_progress);
        this.z6 = (TextView) view.findViewById(R.id.txtview_full_screen_play_time);
        this.A6 = (TextView) view.findViewById(R.id.txtview_full_screen_total_time);
        this.B6 = (ImageView) view.findViewById(R.id.btn_full_screen_tvresume);
        this.C6 = (ImageView) view.findViewById(R.id.btn_full_screen_subtitle);
        this.D6 = (ImageView) view.findViewById(R.id.btn_full_screen_audio);
        this.E6 = (Button) view.findViewById(R.id.btn_full_screen_video);
        ImageView imageView = (ImageView) view.findViewById(R.id.btn_next_episode);
        this.F6 = imageView;
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.llayout_full_screen_order_hint);
        this.G6 = relativeLayout2;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout2);
        TextView textView = (TextView) view.findViewById(R.id.btn_full_screen_order_hint);
        this.I6 = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.order_pay));
        com.zte.iptvclient.common.uiframe.f.a(this.I6);
        TextView textView2 = (TextView) view.findViewById(R.id.txtvew_full_screen_order_hint);
        this.H6 = textView2;
        com.zte.iptvclient.common.uiframe.f.a(textView2);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.btn_full_screen_tvshare);
        this.q7 = imageView2;
        com.zte.iptvclient.common.uiframe.f.a(imageView2);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.btn_vr_glasses);
        this.J6 = imageView3;
        com.zte.iptvclient.common.uiframe.f.a(imageView3);
        ImageView imageView4 = (ImageView) view.findViewById(R.id.btn_vr_360video);
        this.K6 = imageView4;
        com.zte.iptvclient.common.uiframe.f.a(imageView4);
        this.b7 = (ImageView) view.findViewById(R.id.btn_full_more_screen);
        this.r5 = (FrameLayout) view.findViewById(R.id.fl_multi_play_manager_for_single);
        com.zte.iptvclient.common.uiframe.f.a(this.b7);
        com.zte.iptvclient.common.uiframe.f.a(this.r5);
        FrameLayout frameLayout = this.r5;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Android_Player_Type");
        if (this.q && "2".equals(c2)) {
            this.K6.setVisibility(0);
        } else {
            this.K6.setVisibility(8);
        }
        ImageView imageView5 = (ImageView) view.findViewById(R.id.btn_full_screen_hc100);
        this.L6 = imageView5;
        com.zte.iptvclient.common.uiframe.f.a(imageView5);
        ImageView imageView6 = (ImageView) view.findViewById(R.id.btn_full_screen_float);
        this.M6 = imageView6;
        com.zte.iptvclient.common.uiframe.f.a(imageView6);
        if ("1".equals(ConfigMgr.readPropertie("ShowFloatingPlayBtn"))) {
            this.M6.setVisibility(0);
        }
    }

    private void l(View view) {
        c(true);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rlayout_small_screen_main_panel);
        this.O6 = relativeLayout;
        relativeLayout.setOnTouchListener(new g0(this));
        this.g = (RelativeLayout) view.findViewById(R.id.rlayout_small_screen_control_surface);
        this.A7 = (ImageView) view.findViewById(R.id.img_lose_play);
        this.B7 = (ImageView) view.findViewById(R.id.img_lose_loading);
        this.q6 = (TextView) view.findViewById(R.id.small_screen_program_name);
        this.Q6 = (ImageView) view.findViewById(R.id.btn_small_screen_play_pause);
        this.R6 = (SeekBar) view.findViewById(R.id.bar_small_screen_play_progress);
        this.S6 = (TextView) view.findViewById(R.id.txtview_small_screen_play_time);
        this.T6 = (TextView) view.findViewById(R.id.txtview_small_screen_total_time);
        this.U6 = (ImageView) view.findViewById(R.id.btn_small_screen_tvresume);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.llayout_small_screen_order_hint);
        this.V6 = relativeLayout2;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout2);
        TextView textView = (TextView) view.findViewById(R.id.txtvew_small_screen_order_hint);
        this.W6 = textView;
        com.zte.iptvclient.common.uiframe.f.a(textView);
        RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.rl_loadingd);
        this.d0 = relativeLayout3;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout3);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_player_loadingd);
        this.v7 = imageView;
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.iv_player_loading_up));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.iv_player_loading_down));
        Activity activity = this.f4977b;
        if (activity != null && !activity.isFinishing()) {
            com.bumptech.glide.h<Integer> h2 = com.bumptech.glide.i.a(this.f4977b).a(Integer.valueOf(R.drawable.bg_palybegin_poater)).h();
            h2.a(DiskCacheStrategy.SOURCE);
            h2.a(this.v7);
        }
        this.d0.setVisibility(0);
        this.B7.setVisibility(0);
    }

    private void m(View view) {
        this.a7 = (RelativeLayout) view.findViewById(R.id.rlayout_play_small_screen);
    }

    private void n(View view) {
        LogEx.d("PlayerFragment", "showShare mstrContentType=" + this.T);
        if (ConfigMgr.readPropertie("IsCommingSoon") != null && ConfigMgr.readPropertie("IsCommingSoon").equals("1")) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.vod_txt_empty2);
            return;
        }
        if (this.T.equals("2")) {
            o(view);
            return;
        }
        if (this.T.equals("4")) {
            p(view);
        } else if (this.T.equals("1") || this.T.equals("14") || this.T.equals("10")) {
            q(view);
        }
    }

    private void o(View view) {
        Bitmap extractThumbnail;
        String str;
        if (this.C1 == null) {
            return;
        }
        String format = String.format(getString(R.string.share_message_tv), this.C1);
        Bitmap bitmap = this.l5;
        if (bitmap == null) {
            Bitmap decodeResource = BitmapFactory.decodeResource(this.f4977b.getResources(), R.drawable.share_img);
            extractThumbnail = decodeResource != null ? Bitmap.createBitmap(decodeResource) : null;
        } else {
            extractThumbnail = ThumbnailUtils.extractThumbnail(bitmap, 100, 100);
        }
        Bitmap bitmap2 = extractThumbnail;
        if (bitmap2 != null) {
            String c2 = com.zte.iptvclient.common.uiframe.a.c("APP_Share_URL");
            if (TextUtils.isEmpty(c2) || this.p5.size() <= 0) {
                str = null;
            } else {
                str = c2 + String.format("?pcode=%1$s,%2$s,%3$s,%4$s&ptype=0", this.p5.get(0).d(), "1", "", "30");
            }
            new com.zte.iptvclient.android.mobile.x.b.c.c(this.f4977b, format, str, null, com.zte.iptvclient.android.common.i.a.a.a(R.string.share_content_title) + com.zte.iptvclient.android.common.i.a.a.a(R.string.app_name), bitmap2, null, "").a(view);
        }
    }

    private void p(View view) {
        if (this.C1 == null) {
            return;
        }
        new com.zte.iptvclient.android.mobile.x.b.c.b(this.f4977b, new z(view)).a(view);
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void e(int i2) {
        String valueOf = String.valueOf(i2);
        if (this.U == this.W && !TextUtils.equals(this.I4, "0") && !TextUtils.equals(this.I4, "2")) {
            String.format(getString(R.string.skip_ad), valueOf);
        }
        if (this.U == this.X && !TextUtils.equals(this.I4, "0") && !TextUtils.equals(this.I4, "1")) {
            String.format(getString(R.string.skip_ad), valueOf);
        }
        if ("0".equals(valueOf) || this.U == this.V) {
            LogEx.i("PlayerFragment", "onAdTimeChanged strTime:" + valueOf);
        }
        if (TextUtils.equals("0", valueOf)) {
            r0();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.multiplay.c.o
    public void q() {
        this.h7.setVisibility(8);
        h0();
        this.s0 = true;
    }

    @Override // com.zte.iptvclient.android.common.player.k.a
    public void E() {
        LogEx.d("PlayerFragment", "hideMediaController");
        if (com.zte.iptvclient.android.common.player.multiplay.a.c().a().size() == 1) {
            this.B7.setVisibility(8);
        }
        F1();
        this.n6.setVisibility(8);
        if (this.A) {
            h2();
            RelativeLayout relativeLayout = this.f;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
                this.p7.setVisibility(8);
                this.f.requestLayout();
                return;
            }
            return;
        }
        RelativeLayout relativeLayout2 = this.g;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(4);
            this.g.requestLayout();
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void h(boolean z2) {
        Window window;
        Window window2;
        Window window3;
        if (z2 && (window3 = this.r7.getWindow()) != null) {
            window3.setFlags(8, 8);
            WindowManager.LayoutParams attributes = window3.getAttributes();
            if (attributes != null) {
                window3.setGravity(17);
                int height = getActivity().getWindowManager().getDefaultDisplay().getHeight() / 4;
                attributes.height = height;
                attributes.width = (height * 3) / 2;
                attributes.x = 0;
                attributes.y = 0;
                window3.setAttributes(attributes);
            }
        }
        if (z2 && (window2 = this.t7.getWindow()) != null) {
            window2.setFlags(8, 8);
            WindowManager.LayoutParams attributes2 = window2.getAttributes();
            if (attributes2 != null) {
                window2.setGravity(17);
                int height2 = getActivity().getWindowManager().getDefaultDisplay().getHeight() / 4;
                attributes2.height = height2;
                attributes2.width = (height2 * 3) / 2;
                attributes2.x = 0;
                attributes2.y = 0;
                window2.setAttributes(attributes2);
            }
        }
        if (!z2 || (window = this.s7.getWindow()) == null) {
            return;
        }
        window.setFlags(8, 8);
        WindowManager.LayoutParams attributes3 = window.getAttributes();
        if (attributes3 != null) {
            window.setGravity(17);
            int height3 = getActivity().getWindowManager().getDefaultDisplay().getHeight() / 4;
            attributes3.height = height3;
            attributes3.width = (height3 * 3) / 2;
            attributes3.x = 0;
            attributes3.y = 0;
            window.setAttributes(attributes3);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.c cVar) {
        LogEx.d("PlayerFragment", "recv PlayTvSwitchChannelEvent");
        if (this.z7 && TextUtils.equals(this.T, "2")) {
            cVar.a();
            throw null;
        }
        this.z7 = false;
    }

    private void q(View view) {
        new com.zte.iptvclient.android.mobile.x.b.c.b(this.f4977b, new a0(view)).a(view);
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void a(int i2, String str, int i3, int i4) {
        com.zte.iptvclient.android.common.customview.view.imageview.a aVar = new com.zte.iptvclient.android.common.customview.view.imageview.a(this.f4977b);
        aVar.a(str);
        aVar.c(i2);
        aVar.a(i3);
        aVar.b(i4);
        this.j7.add(aVar);
    }

    protected void c(Context context) {
        com.zte.iptvclient.android.common.customview.a.a.a.b bVar = new com.zte.iptvclient.android.common.customview.a.a.a.b(context);
        bVar.setTitle(R.string.enter_orderpwd_check);
        EditText a2 = bVar.a();
        a2.setHint(R.string.enter_orderpwd_check);
        bVar.b(R.string.common_ok, new q(a2, context, bVar));
        bVar.a(R.string.common_cancel, new r(bVar, a2, context));
        bVar.setCancelable(true);
        bVar.setCanceledOnTouchOutside(false);
        bVar.show();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void i(int i2) {
        String a2;
        this.h.setVisibility(8);
        this.J1 = false;
        this.x6.setEnabled(false);
        this.Q6.setEnabled(false);
        this.y6.setEnabled(false);
        this.R6.setEnabled(false);
        this.E6.setEnabled(false);
        if (i2 <= 0) {
            LogEx.w("PlayerFragment", "can not support preview");
            return;
        }
        this.G6.setVisibility(8);
        this.V6.setVisibility(8);
        if (!this.T.equals("10") && !this.T.equals("14")) {
            if (this.T.equals("1")) {
                a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.vod_order_hint);
            } else {
                a2 = (this.T.equals("2") || this.T.equals("4")) ? com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_order_hint) : "";
            }
        } else {
            a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.series_order_hint);
        }
        String format = String.format(a2, Integer.valueOf(i2));
        if (!this.N6.b0().booleanValue()) {
            LogEx.d("PlayerFragment", "need login");
            this.g6.setVisibility(0);
            String replace = format.replace(this.f4977b.getString(R.string.order_pay), this.f4977b.getString(R.string.order_pay_login));
            this.b6.setText(R.string.order_pay_login);
            this.h6.setText(replace);
        } else {
            this.Z5.setVisibility(0);
            k(8);
            if (this.T.equals("1") || this.T.equals("10") || this.T.equals("14")) {
                k(true);
                if (this.B && this.A) {
                    i0();
                }
            }
            String format2 = String.format(format, Integer.valueOf(i2));
            this.b6.setText(R.string.order_pay);
            this.a6.setText(format2);
        }
        a.h hVar = this.j0;
        if (hVar != null) {
            hVar.a();
        }
        this.d0.setVisibility(8);
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

    protected void b(Context context) {
        com.zte.iptvclient.android.common.customview.a.a.a.b bVar = new com.zte.iptvclient.android.common.customview.a.a.a.b(context);
        bVar.setTitle(R.string.enter_orderpwd_check);
        EditText a2 = bVar.a();
        a2.setHint(R.string.enter_orderpwd_check);
        bVar.b(R.string.common_ok, new u(a2, context, bVar));
        bVar.a(R.string.common_cancel, new w(bVar, a2, context));
        bVar.setCancelable(true);
        bVar.setCanceledOnTouchOutside(false);
        bVar.show();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void f(boolean z2) {
        this.y6.setEnabled(z2);
        this.R6.setEnabled(z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.iptvclient.android.common.player.k.a
    public void d(int i2) {
        if (i2 == 1) {
            this.x6.setImageResource(R.drawable.player_btn_play);
            this.Q6.setImageResource(R.drawable.player_btn_play);
        } else {
            if (i2 != 2) {
                return;
            }
            this.x6.setImageResource(R.drawable.player_btn_pause);
            this.Q6.setImageResource(R.drawable.player_btn_pause);
        }
    }

    public void j(int i2) {
        if (this.T.equals("2")) {
            LogEx.d("PlayerFragment", "payCallback");
            if (i2 == 0) {
                N1();
                return;
            }
            LogEx.d("PlayerFragment", "subscribe fail");
            if (this.E3 > 0) {
                if (this.Z5.getVisibility() == 0) {
                    this.a7.setEnabled(false);
                    k(8);
                    if (8 != i2) {
                        this.Z5.setVisibility(8);
                        k(0);
                    }
                    LogEx.d("PlayerFragment", "stopVideo()");
                    m0();
                    return;
                }
                this.a7.setEnabled(true);
                LogEx.d("PlayerFragment", "play()");
                X0();
                return;
            }
            X0();
            return;
        }
        if (this.T.equals("4")) {
            if (i2 == 0) {
                N1();
            } else {
                X0();
            }
        }
    }

    protected void a(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.RelativeLayoutPlayerFragment);
        this.j6 = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
        this.h = (RelativeLayout) view.findViewById(R.id.rlayout_player);
        p2();
        this.u5 = true;
        k(view);
        l(view);
        j(view);
        f(view);
        e(view);
        d(view);
        c(view);
        i(view);
        b(view);
        g(view);
        if ("1".equals(ConfigMgr.readPropertie("IsSupportCastScreen", "0"))) {
            h(view);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void g(int i2) {
        com.zte.iptvclient.android.common.customview.a.a.b.a aVar = this.t7;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    private void c(int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
        layoutParams.addRule(9);
        layoutParams.addRule(12);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i3);
        layoutParams2.addRule(11);
        layoutParams2.addRule(12);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i2, i3);
        layoutParams3.addRule(9);
        layoutParams3.addRule(10);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(i2, i3);
        layoutParams4.addRule(11);
        layoutParams4.addRule(10);
    }

    private void e(View view) {
        TextView textView = (TextView) view.findViewById(R.id.help_3);
        this.c7 = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.play_help_1));
        TextView textView2 = (TextView) view.findViewById(R.id.help_6);
        this.d7 = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.play_help_2));
        TextView textView3 = (TextView) view.findViewById(R.id.help_9);
        this.e7 = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.play_help_3));
        TextView textView4 = (TextView) view.findViewById(R.id.help_12);
        this.f7 = textView4;
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.play_help_4));
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

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void b(int i2, int i3) {
        this.y6.setMax(i3);
        this.R6.setMax(i3);
        this.y6.setProgress(i2);
        this.R6.setProgress(i2);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MultiPlayWindowEvent multiPlayWindowEvent) {
        if (2 == multiPlayWindowEvent.a()) {
            this.p7.setVisibility(0);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.eventbus.multi.a aVar) {
        FrameLayout frameLayout = this.r5;
        if (frameLayout == null || frameLayout.getVisibility() != 0) {
            return;
        }
        this.r5.setVisibility(8);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.eventbus.multi.e eVar) {
        s0();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.c cVar) {
        if (TextUtils.equals("0", cVar.a()) && com.zte.iptvclient.android.mobile.n.c.b.t()) {
            v1();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.i.c cVar) {
        if (cVar == null) {
            return;
        }
        if ((this.T.equals("1") || this.T.equals("10") || this.T.equals("15") || this.T.equals("4")) && TextUtils.equals(cVar.b(), this.q1)) {
            this.L.seek(cVar.a());
        }
    }

    private void l(boolean z2) {
        LogEx.d("PlayerFragment", " scalePlayer()" + z2);
        if ((getActivity() != null || (getActivity() instanceof MultiPlayActivity)) && this.y7.getParent() != null) {
            ((MultiPlayActivity) getActivity()).u();
            if (z2) {
                ((MultiPlayActivity) getActivity()).a((View) this.y7.getParent(), true);
                getActivity().setRequestedOrientation(0);
                ((MultiPlayActivity) getActivity()).c(true);
                ((FrameLayout) this.y7.getParent()).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                this.y7.setClickable(true);
                this.A = true;
                this.J7 = ((MultiPlayActivity) getActivity()).v();
                return;
            }
            this.y7.setClickable(false);
            ((MultiPlayActivity) getActivity()).a((View) this.y7.getParent(), false);
            ((MultiPlayActivity) getActivity()).c(false);
            ((MultiPlayActivity) getActivity()).reStartChildViewLayout((ViewGroup) this.y7.getParent());
            if (this.J7) {
                ((MultiPlayActivity) getActivity()).x();
            }
            this.A = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.iptvclient.android.common.player.k.a
    public void a(List<com.zte.iptvclient.android.common.customview.view.imageview.a> list) {
        Iterator<com.zte.iptvclient.android.common.customview.view.imageview.a> it2 = list.iterator();
        while (it2.hasNext()) {
            this.G7.postDelayed(new h0(it2.next()), r0.h() * 1000);
        }
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void j(boolean z2) {
        if (BaseApp.e().b()) {
            this.F = false;
            z2 = false;
        }
        if (z2) {
            EventBus.getDefault().post(new MultiPlayWindowEvent(MultiPlayWindowEvent.MultiPlayWindowEventType.SHOW_NETWORK_HINT));
        } else {
            EventBus.getDefault().post(new MultiPlayWindowEvent(MultiPlayWindowEvent.MultiPlayWindowEventType.HIDE_NETWORK_HINT));
        }
    }

    protected void a(Context context) {
        com.zte.iptvclient.android.common.customview.a.a.a.b bVar = new com.zte.iptvclient.android.common.customview.a.a.a.b(context);
        bVar.setTitle(R.string.enter_orderpwd_check);
        EditText a2 = bVar.a();
        a2.setHint(R.string.enter_orderpwd_check);
        bVar.b(R.string.common_ok, new s(a2, context, bVar));
        bVar.a(R.string.common_cancel, new t(bVar, a2, context));
        bVar.setCancelable(true);
        bVar.setCanceledOnTouchOutside(false);
        bVar.show();
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void h(int i2) {
        com.zte.iptvclient.android.common.customview.a.a.b.d dVar = this.r7;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void e(Bundle bundle) {
        if (bundle != null) {
            this.Y5 = bundle;
        }
        this.U6.setVisibility(4);
        this.B6.setVisibility(4);
        b(bundle);
        v1();
        if (this.L.isPlaying()) {
            m0();
        }
        if (this.T1 != 0 && this.E3 <= 0) {
            this.J1 = false;
            return;
        }
        if ((this.T.equals("10") || this.T.equals("14")) && this.T1 != 0 && this.U1 > this.E3) {
            return;
        }
        this.J1 = true;
        if (this.T.equals("2") && !this.J) {
            q();
            j0();
        } else {
            z1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EditText editText, Context context) {
        context.getSystemService("input_method");
    }

    @Override // com.zte.iptvclient.android.common.player.multiplay.c.o
    public void a(long j2, String str) {
        LogEx.d("PlayerFragment", "exitPlayFromStb breakPoint = " + j2 + " telecomcode = " + str + " mstrTelecomcode = " + this.a1);
        A();
        if (this.T.equals("2")) {
            j0();
        } else if (j2 > 0 && !TextUtils.isEmpty(str) && str.equals(this.a1)) {
            if (!this.L.isPlaying()) {
                this.L.seek(j2);
                b((int) j2, (int) this.y3);
                X0();
            }
        } else if (!this.L.isPlaying()) {
            X0();
        }
        this.i0 = true;
    }

    private void k(int i2) {
        this.m6.setVisibility(i2);
        this.O6.setVisibility(i2);
        this.p7.setVisibility(i2);
        if (this.A) {
            return;
        }
        this.p7.setVisibility(8);
    }

    @Override // com.zte.iptvclient.android.common.player.k.b
    protected void a(int i2, String str, String str2, boolean z2) {
        com.zte.iptvclient.android.common.customview.a.a.b.b bVar = this.s7;
        if (bVar != null) {
            bVar.a(i2, str, str2, z2);
        }
    }

    public void a(com.zte.iptvclient.android.common.javabean.f fVar) {
        this.x7 = fVar;
    }
}
