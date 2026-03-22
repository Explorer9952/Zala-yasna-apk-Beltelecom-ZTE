package com.zte.iptvclient.android.common.player.multiplay;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.mobile.dlna.bean.BackplayPositionInfoBean;
import com.zte.iptvclient.android.mobile.h.a.a;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.TimeShowUtil;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: MultiScreenInteractionHelper.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private int f5166a;

    /* renamed from: b, reason: collision with root package name */
    private int f5167b;

    /* renamed from: c, reason: collision with root package name */
    private Context f5168c;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f5169d;
    private ImageView e;
    private TextView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private SeekBar j;
    private TextView k;
    private TextView l;
    private o m;
    private String n;
    private Timer o;
    private TimerTask p;
    private String r;
    String s;
    String t;
    String u;
    String v;
    private boolean w;
    private com.zte.iptvclient.android.common.j.h x;
    private boolean q = false;
    private Handler y = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiScreenInteractionHelper.java */
    /* loaded from: classes.dex */
    public class a implements a.q {
        a() {
        }

        @Override // com.zte.iptvclient.android.mobile.h.a.a.q
        public void a(BackplayPositionInfoBean backplayPositionInfoBean) {
            if (backplayPositionInfoBean == null) {
                LogEx.d("MultiScreenInteractionHelper", "querySTBPlayPosition bean is null");
                if (c.this.q) {
                    return;
                }
                c.this.q = true;
                c.this.a(-1L, "");
                return;
            }
            LogEx.d("querySTBPlayPosition ----bean-----------", backplayPositionInfoBean.toString());
            LogEx.d("querySTBPlayPosition -----programCode---", c.this.r);
            if (!backplayPositionInfoBean.getRelTime().contains(":")) {
                if (c.this.r.equals(backplayPositionInfoBean.getProgramid())) {
                    c.this.a(Long.parseLong(backplayPositionInfoBean.getRelTime()) * 1000, "");
                    return;
                } else {
                    c.this.a(-1L, "");
                    return;
                }
            }
            c.this.a(-1L, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiScreenInteractionHelper.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f5171a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f5172b;

        b(long j, String str) {
            this.f5171a = j;
            this.f5172b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.m.a(this.f5171a, this.f5172b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiScreenInteractionHelper.java */
    /* renamed from: com.zte.iptvclient.android.common.player.multiplay.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0158c implements a.r {
        C0158c() {
        }

        @Override // com.zte.iptvclient.android.mobile.h.a.a.r
        public void a(String str, String str2, String str3) {
            LogEx.d("MultiScreenInteractionHelper", "queryTransportInfo: returncode=" + str);
            LogEx.d("MultiScreenInteractionHelper", "queryTransportInfo: currentTransportState=" + str2);
            LogEx.d("MultiScreenInteractionHelper", "queryTransportInfo: currentTransportStatus=" + str3);
            c.this.x.J();
            if (!TextUtils.equals("", "") && !"".equals(com.zte.iptvclient.common.uiframe.a.c("BSTV_CP_Code"))) {
                if (TextUtils.equals("0", str) && !TextUtils.equals("NO_MEDIA_PRESENT", str3) && !TextUtils.equals("ERROR_OCCURRED", str3)) {
                    c.this.f();
                    c.this.u = str2;
                    return;
                } else {
                    LogEx.w("MultiScreenInteractionHelper", "queryTransportInfo: STB status is wrong.");
                    c.this.y.sendEmptyMessage(3);
                    return;
                }
            }
            if (TextUtils.equals(str, "0") && !TextUtils.equals("NO_MEDIA_PRESENT", str2) && "OK".equals(str3)) {
                LogEx.d("MultiScreenInteractionHelper", "queryTransportInfo: STB state is OK!");
                c.this.f();
                c.this.u = str2;
            } else {
                LogEx.w("MultiScreenInteractionHelper", "queryTransportInfo: STB status is wrong.");
                c.this.y.sendEmptyMessage(3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiScreenInteractionHelper.java */
    /* loaded from: classes.dex */
    public class d implements a.q {
        d() {
        }

        @Override // com.zte.iptvclient.android.mobile.h.a.a.q
        public void a(BackplayPositionInfoBean backplayPositionInfoBean) {
            LogEx.d("MultiScreenInteractionHelper", "stbPositionInfo-----bean-----" + backplayPositionInfoBean.toString());
            String J = c.this.x.J();
            if (TextUtils.isEmpty(backplayPositionInfoBean.getPushtype())) {
                LogEx.w("MultiScreenInteractionHelper", "queryPositionInfo: BackplayPostionInfoBean is null.");
                c.this.y.sendEmptyMessage(3);
                return;
            }
            c.this.v = backplayPositionInfoBean.getPushtype();
            if (!TextUtils.isEmpty(J) && !TextUtils.equals(J, com.zte.iptvclient.common.uiframe.a.c("BSTV_CP_Code"))) {
                LogEx.d("MultiScreenInteractionHelper", "querySTBPlayPosition result getRelTime=" + backplayPositionInfoBean.getRelTime() + " duration=" + backplayPositionInfoBean.getTrackDuration());
                c cVar = c.this;
                cVar.s = cVar.a(Long.parseLong(backplayPositionInfoBean.getRelTime()));
                c cVar2 = c.this;
                cVar2.t = cVar2.a(Long.parseLong(backplayPositionInfoBean.getTrackDuration()));
            } else {
                c.this.s = backplayPositionInfoBean.getRelTime();
                c.this.t = backplayPositionInfoBean.getTrackDuration();
                if (!c.this.t.contains(":")) {
                    c cVar3 = c.this;
                    cVar3.t = cVar3.a(Long.parseLong(cVar3.t));
                }
                LogEx.d("MultiScreenInteractionHelper", "querySTBPlayPosition result getRelTime=" + backplayPositionInfoBean.getRelTime() + " duration=" + backplayPositionInfoBean.getTrackDuration());
            }
            LogEx.d("MultiScreenInteractionHelper", "realTime=" + c.this.s + " duration=" + c.this.t);
            c.this.i();
            if (c.this.y.hasMessages(2)) {
                return;
            }
            c.this.y.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    /* compiled from: MultiScreenInteractionHelper.java */
    /* loaded from: classes.dex */
    class e extends Handler {
        e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 2) {
                c.this.a();
                c.this.y.sendEmptyMessageDelayed(2, 2000L);
                return;
            }
            if (i == 3) {
                if (c.this.y.hasMessages(2)) {
                    c.this.y.removeMessages(2);
                }
            } else {
                if (i != 4) {
                    return;
                }
                if (!TextUtils.isEmpty(c.this.u)) {
                    if ("PLAYGING".equals(c.this.u)) {
                        if (c.this.f5168c != null) {
                            c.this.i.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.remote_btn_play));
                            ((SupportActivity) c.this.f5168c).a(c.this.i, "src", R.drawable.remote_btn_play);
                        }
                    } else if (c.this.f5168c != null) {
                        c.this.i.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.remote_btn_pause));
                        ((SupportActivity) c.this.f5168c).a(c.this.i, "src", R.drawable.remote_btn_pause);
                    }
                }
                c.this.j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiScreenInteractionHelper.java */
    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        f(c cVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiScreenInteractionHelper.java */
    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.m.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiScreenInteractionHelper.java */
    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        h(c cVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zte.iptvclient.android.mobile.h.a.a.g().a(4106);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiScreenInteractionHelper.java */
    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {
        i(c cVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zte.iptvclient.android.mobile.h.a.a.g().a(4107);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiScreenInteractionHelper.java */
    /* loaded from: classes.dex */
    public class j implements View.OnClickListener {
        j(c cVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zte.iptvclient.android.mobile.h.a.a.g().a(4103);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiScreenInteractionHelper.java */
    /* loaded from: classes.dex */
    public class k implements SeekBar.OnSeekBarChangeListener {
        k() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (TextUtils.equals("0", c.this.v)) {
                c.this.j.setProgress(100);
                if (com.zte.iptvclient.android.common.k.c.a()) {
                    return;
                }
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(c.this.f5168c.getString(R.string.seek_hint));
                return;
            }
            c.this.k.setText(c.this.a(i));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            if (TextUtils.equals("0", c.this.v)) {
                return;
            }
            c.this.w = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (TextUtils.equals("0", c.this.v)) {
                return;
            }
            c.this.w = false;
            if (com.zte.iptvclient.android.mobile.h.a.a.g().b() != null) {
                com.zte.iptvclient.android.mobile.h.a.a.g().a(c.this.a(r1.f5167b), c.this.a(seekBar.getProgress()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiScreenInteractionHelper.java */
    /* loaded from: classes.dex */
    public class l extends TimerTask {
        l() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (c.this.q) {
                return;
            }
            c.this.q = true;
            c.this.a(-1L, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiScreenInteractionHelper.java */
    /* loaded from: classes.dex */
    public class m implements a.q {
        m() {
        }

        @Override // com.zte.iptvclient.android.mobile.h.a.a.q
        public void a(BackplayPositionInfoBean backplayPositionInfoBean) {
            if (backplayPositionInfoBean == null) {
                LogEx.d("MultiScreenInteractionHelper", "querySTBPlayPosition bean is null");
                if (c.this.q) {
                    return;
                }
                c.this.q = true;
                c.this.a(-1L, "");
                return;
            }
            LogEx.d("MultiScreenInteractionHelper", "querySTBPlayPosition bean = " + backplayPositionInfoBean.toString() + " mStrContentType = " + c.this.n);
            if (!TextUtils.isEmpty(backplayPositionInfoBean.getTrackURI())) {
                String[] split = backplayPositionInfoBean.getTrackURI().split("&");
                HashMap hashMap = new HashMap();
                for (String str : split) {
                    String[] split2 = str.split("=");
                    if (split2.length >= 2) {
                        hashMap.put(split2[0], split2[1]);
                    }
                }
                String str2 = (String) hashMap.get("telecomcode");
                long b2 = c.this.b(backplayPositionInfoBean.getRelTime());
                if (c.this.q) {
                    return;
                }
                c.this.q = true;
                c.this.a(b2, str2);
                return;
            }
            LogEx.d("MultiScreenInteractionHelper", "querySTBPlayPosition bean.getTrackURI() is null");
            if (c.this.q) {
                return;
            }
            c.this.q = true;
            c.this.a(-1L, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiScreenInteractionHelper.java */
    /* loaded from: classes.dex */
    public class n implements a.r {
        n() {
        }

        @Override // com.zte.iptvclient.android.mobile.h.a.a.r
        public void a(String str, String str2, String str3) {
            LogEx.d("MultiScreenInteractionHelper", "queryTransportInfo: returncode=" + str);
            LogEx.d("MultiScreenInteractionHelper", "queryTransportInfo: currentTransportState=" + str2);
            LogEx.d("MultiScreenInteractionHelper", "queryTransportInfo: currentTransportStatus=" + str3);
            if (!str.equals("0") || str2.equals("NO_MEDIA_PRESENT") || str3.equals("ERROR_OCCURRED")) {
                if (c.this.q) {
                    return;
                }
                c.this.q = true;
                c.this.a(-1L, "");
                return;
            }
            c.this.g();
        }
    }

    /* compiled from: MultiScreenInteractionHelper.java */
    /* loaded from: classes.dex */
    public interface o {
        void a(long j, String str);

        void q();
    }

    /* compiled from: MultiScreenInteractionHelper.java */
    /* loaded from: classes.dex */
    public interface p {
    }

    public c(Context context, ViewStub viewStub, String str, boolean z, o oVar, String str2) {
        this.f5168c = context;
        this.m = oVar;
        this.n = str;
        this.r = str2;
        this.x = new com.zte.iptvclient.android.common.j.h(this.f5168c);
        a(viewStub);
        d();
    }

    public void a(p pVar) {
    }

    private void d() {
        this.f.setOnClickListener(new g());
        this.g.setOnClickListener(new h(this));
        this.h.setOnClickListener(new i(this));
        this.i.setOnClickListener(new j(this));
        this.j.setOnSeekBarChangeListener(new k());
    }

    private void e() {
        LogEx.d("MultiScreenInteractionHelper", "querySTBPlayPosition");
        int a2 = com.zte.iptvclient.android.mobile.h.a.a.g().a(new m());
        LogEx.d("MultiScreenInteractionHelper", "querySTBPlayPosition result = " + a2);
        if (a2 == 0 || this.q) {
            return;
        }
        this.q = true;
        this.m.a(-1L, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        LogEx.d("MultiScreenInteractionHelper", "querySTBPlayPositionT");
        LogEx.d("MultiScreenInteractionHelper", "querySTBPlayPosition result=" + com.zte.iptvclient.android.mobile.h.a.a.g().a(new d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        LogEx.d("MultiScreenInteractionHelper", "querySTBPosition ");
        com.zte.iptvclient.android.mobile.h.a.a.g().a(new a());
    }

    private void h() {
        LogEx.d("MultiScreenInteractionHelper", "querySTBTransport");
        com.zte.iptvclient.android.mobile.h.a.a.g().a(new n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (!TextUtils.isEmpty(this.t)) {
            this.f5167b = a(this.t);
        }
        if (!TextUtils.isEmpty(this.s)) {
            this.f5166a = a(this.s);
        }
        LogEx.d("MultiScreenInteractionHelper", "setPlayInfo mMax=" + this.f5167b + " mProgress " + this.f5166a);
        this.y.sendEmptyMessage(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (TextUtils.isEmpty(this.v)) {
            return;
        }
        if ("0".equals(this.v)) {
            this.i.setVisibility(8);
            this.j.setMax(100);
            this.j.setProgress(100);
            String format = new SimpleDateFormat(TimeShowUtil.STR_VOD_DURATION_TIME_FORMATE).format(Long.valueOf(System.currentTimeMillis()));
            this.k.setText(format);
            this.l.setText(format);
            LogEx.d("MultiScreenInteractionHelper", "setSeekBarProgress mTxtRealTime=" + format + " mTxtDurationTime " + this.l);
        } else {
            this.i.setVisibility(0);
            if ("1".equals(com.zte.iptvclient.common.uiframe.a.c("Is_Support_Seek"))) {
                this.j.setEnabled(true);
            } else {
                this.j.setEnabled(false);
            }
            this.j.setMax(this.f5167b);
            if (!this.w) {
                this.j.setProgress(this.f5166a);
            }
            if (!TextUtils.isEmpty(this.t)) {
                this.l.setText(this.t);
                LogEx.d("MultiScreenInteractionHelper", "setSeekBarProgress mTxtRealTime=" + a(this.f5166a) + " mTxtDurationTime " + this.t);
            }
            this.k.setText(a(this.f5166a));
        }
        LogEx.d("MultiScreenInteractionHelper", "setSeekBarProgress mMax=" + this.f5167b + " mProgress " + this.f5166a);
    }

    private void k() {
        if (this.o == null) {
            this.o = new Timer();
        }
        TimerTask timerTask = this.p;
        if (timerTask != null) {
            timerTask.cancel();
            this.p = null;
        }
        l lVar = new l();
        this.p = lVar;
        this.o.schedule(lVar, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
    }

    public void c() {
        this.m.q();
        if (this.n.equals("2")) {
            this.m.a(-1L, "");
            return;
        }
        this.q = false;
        this.x.J();
        if (!TextUtils.equals("", "") && !"".equals(com.zte.iptvclient.common.uiframe.a.c("BSTV_CP_Code"))) {
            h();
        } else {
            k();
            e();
        }
    }

    public void b() {
        TimerTask timerTask = this.p;
        if (timerTask != null) {
            timerTask.cancel();
            this.p = null;
        }
    }

    private void a(ViewStub viewStub) {
        if (viewStub == null) {
            LogEx.d("MultiScreenInteractionHelper", "view is null");
            return;
        }
        View inflate = viewStub.inflate();
        this.f5169d = (LinearLayout) inflate.findViewById(R.id.ll_intercept);
        this.e = (ImageView) inflate.findViewById(R.id.img_push_show);
        this.f = (TextView) inflate.findViewById(R.id.txt_exit_stb);
        this.g = (ImageView) inflate.findViewById(R.id.img_vol_up);
        this.h = (ImageView) inflate.findViewById(R.id.img_vol_down);
        this.i = (ImageView) inflate.findViewById(R.id.img_play_pause);
        this.j = (SeekBar) inflate.findViewById(R.id.seek_bar_push_play);
        this.k = (TextView) inflate.findViewById(R.id.txt_real_time);
        this.l = (TextView) inflate.findViewById(R.id.txt_duration_time);
        TextView textView = (TextView) inflate.findViewById(R.id.txt_connect_to_top_box);
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.rl_intercept));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.rl_intercept_all));
        com.zte.iptvclient.common.uiframe.f.a(this.f5169d);
        com.zte.iptvclient.common.uiframe.f.a(this.e);
        com.zte.iptvclient.common.uiframe.f.a(textView);
        com.zte.iptvclient.common.uiframe.f.a(this.f);
        com.zte.iptvclient.common.uiframe.f.a(this.g);
        com.zte.iptvclient.common.uiframe.f.a(this.h);
        if (com.zte.iptvclient.android.common.i.a.a.a(R.string.connect_to_top_box) != null) {
            textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.connect_to_top_box));
        }
        if (com.zte.iptvclient.android.common.i.a.a.a(R.string.quit_top_box) != null) {
            this.f.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.exit_cast));
        }
        inflate.findViewById(R.id.rl_intercept).setOnClickListener(new f(this));
        this.j.setVisibility(8);
        this.i.setVisibility(8);
        this.k.setVisibility(8);
        this.l.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        String[] split = str.split(":");
        int[] iArr = {0, 0, 0};
        int length = split.length;
        while (length > 0) {
            length--;
            try {
                iArr[length] = Integer.parseInt(split[length]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return ((iArr[0] * 3600) + (iArr[1] * 60) + iArr[2]) * 1000;
    }

    public void a(boolean z) {
        ImageView imageView = this.e;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (z) {
                int a2 = com.zte.iptvclient.android.common.k.g.a(this.f5168c, 200.0f);
                layoutParams.height = a2;
                layoutParams.width = a2;
                this.e.setLayoutParams(layoutParams);
            } else {
                int a3 = com.zte.iptvclient.android.common.k.g.a(this.f5168c, 135.0f);
                layoutParams.height = a3;
                layoutParams.width = a3;
                this.e.setLayoutParams(layoutParams);
            }
            LogEx.d("MultiScreenInteractionHelper", "reDisplayManagerView h" + layoutParams.height + " reDisplayManagerView w " + layoutParams.width);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2, String str) {
        ((Activity) this.f5168c).runOnUiThread(new b(j2, str));
    }

    public void a() {
        LogEx.d("MultiScreenInteractionHelper", "backPlay");
        LogEx.d("MultiScreenInteractionHelper", "queryTransportInfo: result=" + com.zte.iptvclient.android.mobile.h.a.a.g().a(new C0158c()));
    }

    public String a(long j2) {
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

    private int a(String str) {
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
}
