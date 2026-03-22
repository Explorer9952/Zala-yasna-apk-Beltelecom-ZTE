package com.zte.iptvclient.android.mobile.u.b.b;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.vod.SDKVodMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.SeriesHeadBean;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.dlna.bean.BackplayPositionInfoBean;
import com.zte.iptvclient.android.mobile.h.a.a;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.TimeShowUtil;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RemotePlayControlLayout.java */
/* loaded from: classes2.dex */
public class b extends RelativeLayout {
    private LinearLayout A;
    private TextView B;
    private TextView C;
    private int[] D;
    private boolean E;
    com.zte.iptvclient.android.common.j.h F;
    private Handler G;

    /* renamed from: a, reason: collision with root package name */
    private Context f7375a;

    /* renamed from: b, reason: collision with root package name */
    private com.zte.iptvclient.android.mobile.u.a.a f7376b;

    /* renamed from: c, reason: collision with root package name */
    private String f7377c;

    /* renamed from: d, reason: collision with root package name */
    private int f7378d;
    private int e;
    private RelativeLayout f;
    private Button g;
    private TextView h;
    private ImageView i;
    private ImageView j;
    private LinearLayout k;
    private LinearLayout l;
    private SeekBar m;
    private ImageView n;
    private ImageView o;
    private ImageView p;
    private ImageView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private ImageView u;
    private ImageView v;
    private ImageView w;
    n x;
    private PopupWindow y;
    private TextView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemotePlayControlLayout.java */
    /* loaded from: classes2.dex */
    public class a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("RemotePlayControlLayout", "queryBackPlayInfoFromFrame return data= " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (TextUtils.equals(jSONObject.optString("returncode"), "0")) {
                    if ("0".equals(b.this.x.f7392a)) {
                        b.this.x.f7395d = jSONObject.optString("channelname");
                    } else if (DownloadConstant.REPORT_MSGTYPE_ADD.equals(b.this.x.f7392a)) {
                        b.this.x.f7395d = jSONObject.optString("prevuename");
                    } else {
                        b.this.x.f7395d = jSONObject.optString("programname");
                    }
                    b.this.x.e = jSONObject.optString("seriesnum");
                    if ("1".equals(b.this.x.f7392a)) {
                        b.this.x.g = jSONObject.optString("posterfileList");
                    } else if ("0".equals(b.this.x.f7392a)) {
                        b.this.x.g = jSONObject.optString("filename");
                    } else if (DownloadConstant.REPORT_MSGTYPE_ADD.equals(b.this.x.f7392a)) {
                        String optString = jSONObject.optString("channelcode");
                        Iterator<Channel> it2 = com.zte.iptvclient.android.common.j.i.d().b().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Channel next = it2.next();
                            if (TextUtils.equals(next.getChannelcode(), optString)) {
                                b.this.x.g = next.getPosterimage();
                                break;
                            }
                        }
                    } else if ("2".equals(b.this.x.f7392a)) {
                        b.this.c(jSONObject.optString("seriesprogramcode"));
                    }
                    LogEx.d("RemotePlayControlLayout", "mRemotePlayInfo =   pushtype = " + b.this.x.f7392a + "  title = " + b.this.x.f7395d + "  realtime = " + b.this.x.f7393b + "  duration = " + b.this.x.f7394c + "  number = " + b.this.x.e + "  poster = " + b.this.x.g + "  state = " + b.this.x.f);
                    b.this.l();
                    if (b.this.G.hasMessages(2)) {
                        return;
                    }
                    b.this.G.sendEmptyMessageDelayed(2, 2000L);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("RemotePlayControlLayout", "sdkQueryOttDetail failed, errorCode=" + i + ", errorMsg=" + str);
            b.this.G.sendEmptyMessage(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemotePlayControlLayout.java */
    /* renamed from: com.zte.iptvclient.android.mobile.u.b.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0362b implements Runnable {
        RunnableC0362b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.m.getLocationOnScreen(b.this.D);
        }
    }

    /* compiled from: RemotePlayControlLayout.java */
    /* loaded from: classes2.dex */
    class c extends Handler {
        c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 2) {
                b.this.a();
                b.this.G.sendEmptyMessageDelayed(2, 2000L);
                return;
            }
            if (i != 3) {
                return;
            }
            if (b.this.l.getVisibility() == 0) {
                b.this.l.setVisibility(8);
            }
            if (b.this.f.getVisibility() == 8) {
                b.this.f.setVisibility(0);
            }
            b.this.f7376b.a(false, "");
            b.this.a(true);
            b.this.b(false);
            if (b.this.G.hasMessages(2)) {
                b.this.G.removeMessages(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemotePlayControlLayout.java */
    /* loaded from: classes2.dex */
    public class d implements SDKVodMgr.OnSeriesHeadInfoReturnListener {
        d() {
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnSeriesHeadInfoReturnListener
        public void onSeriesHeadInfoReturn(String str, String str2, String str3) {
            SeriesHeadBean seriesHeadBeanFromJSon;
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    if (jSONArray.length() <= 0 || (seriesHeadBeanFromJSon = SeriesHeadBean.getSeriesHeadBeanFromJSon(jSONArray.getJSONObject(0))) == null) {
                        return;
                    }
                    String a2 = com.zte.iptvclient.android.common.k.g.a(BaseApp.a(b.this.f7375a) ? 9 : 3, seriesHeadBeanFromJSon.getPosterfilelist());
                    if (TextUtils.isEmpty(a2)) {
                        return;
                    }
                    String str4 = com.zte.iptvclient.android.common.f.b.i.g() + a2.substring(a2.indexOf("/image", 0));
                    if (!"2".equals(b.this.f7377c) || b.this.f7375a == null) {
                        return;
                    }
                    com.bumptech.glide.d<String> a3 = com.bumptech.glide.i.b(b.this.f7375a).a(str4);
                    a3.a(R.drawable.default_poster_thumb);
                    a3.c(300);
                    a3.a(b.this.n);
                } catch (Exception e) {
                    LogEx.e("RemotePlayControlLayout", e.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemotePlayControlLayout.java */
    /* loaded from: classes2.dex */
    public class e implements SeekBar.OnSeekBarChangeListener {
        e() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            b.this.y.update((int) (b.this.m.getX() + ((int) b.this.a(seekBar))), (b.this.f7376b.I() + b.this.k.getTop()) - b.this.m.getHeight(), -1, -1);
            long j = i;
            b.this.z.setText(b.this.a(j));
            b.this.s.setText(b.this.a(j));
            LogEx.d("RemotePlayControlLayout", "progress = " + b.this.a(j));
            LogEx.d("RemotePlayControlLayout", "mRemoteControlFragment.getTitleHeight() = " + b.this.f7376b.I() + " mLlSeekbar.getTop() = " + b.this.k.getTop() + " mSeekBar.getTop() = " + b.this.m.getTop() + " mSeelbar.Height = " + b.this.m.getHeight());
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            LogEx.d("RemotePlayControlLayout", "onStartTrackingTouch");
            b.this.n();
            b.this.E = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            b.this.h();
            b.this.E = false;
            if (com.zte.iptvclient.android.mobile.h.a.a.g().b() != null) {
                com.zte.iptvclient.android.mobile.h.a.a.g().a(b.this.a(r1.e), b.this.a(seekBar.getProgress()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemotePlayControlLayout.java */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.a(false);
            if (b.this.f7376b.J()) {
                b.this.f7376b.M();
            } else if (com.zte.iptvclient.android.mobile.h.a.a.g().b() == null) {
                b.this.f7376b.N();
            } else {
                b.this.b(true);
                b.this.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemotePlayControlLayout.java */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogEx.i("RemotePlayControlLayout", "sendKeycode");
            com.zte.iptvclient.android.mobile.h.a.a.g().a(4100);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemotePlayControlLayout.java */
    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogEx.i("RemotePlayControlLayout", "sendKeycode");
            com.zte.iptvclient.android.mobile.h.a.a.g().a(4106);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemotePlayControlLayout.java */
    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogEx.i("RemotePlayControlLayout", "sendKeycode");
            com.zte.iptvclient.android.mobile.h.a.a.g().a(4107);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemotePlayControlLayout.java */
    /* loaded from: classes2.dex */
    public class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogEx.i("RemotePlayControlLayout", "sendKeycode");
            com.zte.iptvclient.android.mobile.h.a.a.g().a(4108);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemotePlayControlLayout.java */
    /* loaded from: classes2.dex */
    public class k implements View.OnTouchListener {
        k() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            LogEx.i("RemotePlayControlLayout", "sendKeycode");
            b.this.getParent().requestDisallowInterceptTouchEvent(true);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemotePlayControlLayout.java */
    /* loaded from: classes2.dex */
    public class l implements a.r {
        l() {
        }

        @Override // com.zte.iptvclient.android.mobile.h.a.a.r
        public void a(String str, String str2, String str3) {
            LogEx.d("RemotePlayControlLayout", "queryTransportInfo: returncode=" + str);
            LogEx.d("RemotePlayControlLayout", "queryTransportInfo: currentTransportState=" + str2);
            LogEx.d("RemotePlayControlLayout", "queryTransportInfo: currentTransportStatus=" + str3);
            b.this.F.J();
            e eVar = null;
            if (!TextUtils.equals("", "") && !"".equals(com.zte.iptvclient.common.uiframe.a.c("BSTV_CP_Code"))) {
                if (str.equals("0") && !str2.equals("NO_MEDIA_PRESENT") && !str3.equals("ERROR_OCCURRED")) {
                    b.this.x = new n(eVar);
                    b.this.k();
                    b.this.x.f = str2;
                    return;
                }
                LogEx.w("RemotePlayControlLayout", "queryTransportInfo: STB status is wrong.");
                b.this.G.sendEmptyMessage(3);
                return;
            }
            if (str.equals("0") && !str2.equals("NO_MEDIA_PRESENT") && str3.equals("OK")) {
                LogEx.d("RemotePlayControlLayout", "queryTransportInfo: STB state is OK!");
                b.this.x = new n(eVar);
                b.this.k();
                b.this.x.f = str2;
                return;
            }
            LogEx.w("RemotePlayControlLayout", "queryTransportInfo: STB status is wrong.");
            b.this.G.sendEmptyMessage(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemotePlayControlLayout.java */
    /* loaded from: classes2.dex */
    public class m implements a.q {
        m() {
        }

        @Override // com.zte.iptvclient.android.mobile.h.a.a.q
        public void a(BackplayPositionInfoBean backplayPositionInfoBean) {
            LogEx.d("RemotePlayControlLayout", "postionBean:" + backplayPositionInfoBean.toString());
            b.this.F.J();
            if (TextUtils.isEmpty(backplayPositionInfoBean.getPushtype())) {
                LogEx.w("RemotePlayControlLayout", "queryPositionInfo: BackplayPostionInfoBean is null.");
                b.this.G.sendEmptyMessage(3);
                return;
            }
            b.this.x.f7392a = backplayPositionInfoBean.getPushtype();
            b.this.f7377c = backplayPositionInfoBean.getPushtype();
            if (!TextUtils.equals("", "") && !TextUtils.equals("", com.zte.iptvclient.common.uiframe.a.c("BSTV_CP_Code"))) {
                b bVar = b.this;
                bVar.x.f7393b = bVar.a(Long.parseLong(backplayPositionInfoBean.getRelTime()));
                b bVar2 = b.this;
                bVar2.x.f7394c = bVar2.a(Long.parseLong(backplayPositionInfoBean.getTrackDuration()));
            } else {
                b.this.x.f7393b = backplayPositionInfoBean.getRelTime();
                b.this.x.f7394c = backplayPositionInfoBean.getTrackDuration();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("pushtype=");
            sb.append(backplayPositionInfoBean.getPushtype());
            sb.append("&telecomcode=");
            sb.append(backplayPositionInfoBean.getTelecomcode());
            sb.append("&begintime=");
            sb.append(TextUtils.isEmpty(backplayPositionInfoBean.getBegintime()) ? "" : b.this.d(backplayPositionInfoBean.getBegintime()));
            sb.append("&endtime=");
            sb.append(TextUtils.isEmpty(backplayPositionInfoBean.getEndtime()) ? "" : b.this.d(backplayPositionInfoBean.getEndtime()));
            if ("0".equals(backplayPositionInfoBean.getPushtype())) {
                if (!TextUtils.equals("", "") && !"".equals(com.zte.iptvclient.common.uiframe.a.c("BSTV_CP_Code"))) {
                    sb.append("&mixno=");
                    sb.append(backplayPositionInfoBean.getUrlfromstb().substring(backplayPositionInfoBean.getUrlfromstb().length() - 3, backplayPositionInfoBean.getUrlfromstb().length()));
                } else {
                    sb.append("&mixno=");
                    sb.append(backplayPositionInfoBean.getMixno());
                }
            }
            String sb2 = sb.toString();
            LogEx.d("RemotePlayControlLayout", "playUrlFromSTB=" + sb2);
            b.this.b(sb2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RemotePlayControlLayout.java */
    /* loaded from: classes2.dex */
    public static class n {

        /* renamed from: a, reason: collision with root package name */
        String f7392a;

        /* renamed from: b, reason: collision with root package name */
        String f7393b;

        /* renamed from: c, reason: collision with root package name */
        String f7394c;

        /* renamed from: d, reason: collision with root package name */
        String f7395d;
        String e;
        String f;
        String g;

        private n() {
        }

        /* synthetic */ n(e eVar) {
            this();
        }
    }

    public b(Context context, com.zte.iptvclient.android.mobile.u.a.a aVar) {
        super(context);
        this.D = new int[2];
        this.G = new c();
        this.f7376b = aVar;
        a(context);
    }

    private void g() {
        this.m.setOnSeekBarChangeListener(new e());
        this.i.setOnClickListener(new f());
        this.q.setOnClickListener(new g());
        this.u.setOnClickListener(new h());
        this.v.setOnClickListener(new i());
        this.w.setOnClickListener(new j());
        this.k.setOnTouchListener(new k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.y.isShowing()) {
            this.y.dismiss();
        }
    }

    private void i() {
        View inflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.play_control_popup_time, (ViewGroup) null);
        this.A = (LinearLayout) inflate.findViewById(R.id.ll_text);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
        this.z = textView;
        textView.setText("00:00:00");
        this.y = new PopupWindow(inflate, -2, -2, false);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        this.y.setAnimationStyle(R.style.remnote_play_time_animation);
    }

    private boolean j() {
        return this.f7375a.getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        LogEx.d("RemotePlayControlLayout", "querySTBPlayPosition result=" + com.zte.iptvclient.android.mobile.h.a.a.g().a(new m()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.l.getVisibility() == 8) {
            this.l.setVisibility(0);
            post(new RunnableC0362b());
        }
        if (this.f.getVisibility() == 0) {
            this.f.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.x.f7395d)) {
            this.f7376b.a(b(), this.x.f7395d);
        }
        if (!TextUtils.isEmpty(this.f7377c)) {
            if ("2".equals(this.f7377c)) {
                if (!TextUtils.isEmpty(this.x.e)) {
                    this.r.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.breakpoint_series_child), Integer.valueOf(Integer.parseInt(this.x.e))));
                }
            } else {
                this.r.setText("");
            }
        }
        if (!TextUtils.isEmpty(this.x.f7392a)) {
            String g2 = com.zte.iptvclient.android.common.f.b.i.g();
            n nVar = this.x;
            String str = nVar.g;
            if (!"0".equals(nVar.f7392a) && !DownloadConstant.REPORT_MSGTYPE_ADD.equals(this.x.f7392a)) {
                if ("1".equals(this.x.f7392a)) {
                    String a2 = com.zte.iptvclient.android.common.k.g.a(BaseApp.a(this.f7375a) ? 9 : 3, this.x.g);
                    LogEx.d("RemotePlayControlLayout", "AdapterVideo show url = " + a2);
                    Context context = this.f7375a;
                    if (context != null && !((Activity) context).isFinishing()) {
                        com.bumptech.glide.d<String> a3 = com.bumptech.glide.i.b(this.f7375a).a(a2);
                        a3.a(R.drawable.default_poster_thumb);
                        a3.c(300);
                        a3.a(this.n);
                    }
                }
            } else {
                if (!TextUtils.isEmpty(str) && str.contains("/image")) {
                    str = g2 + str.substring(str.indexOf("/image", 1));
                }
                Context context2 = this.f7375a;
                if (context2 != null && !((Activity) context2).isFinishing()) {
                    com.bumptech.glide.d<String> a4 = com.bumptech.glide.i.b(this.f7375a).a(str);
                    a4.a(R.drawable.default_poster_thumb);
                    a4.c(300);
                    a4.a(this.n);
                }
            }
        }
        if (!TextUtils.isEmpty(this.x.f)) {
            if ("PLAYGING".equals(this.x.f)) {
                if (this.f7375a != null) {
                    this.q.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.remote_btn_play));
                    ((SupportActivity) this.f7375a).a(this.q, "src", R.drawable.remote_btn_play);
                }
            } else if (this.f7375a != null) {
                this.q.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.remote_btn_pause));
                ((SupportActivity) this.f7375a).a(this.q, "src", R.drawable.remote_btn_pause);
            }
        }
        n nVar2 = this.x;
        String str2 = nVar2.f7393b;
        String str3 = nVar2.f7394c;
        if (!TextUtils.isEmpty(str3)) {
            this.e = a(str3);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f7378d = a(str2);
        }
        m();
    }

    private void m() {
        if (TextUtils.isEmpty(this.f7377c)) {
            return;
        }
        if ("0".equals(this.f7377c)) {
            this.m.setEnabled(false);
            this.m.setMax(100);
            this.m.setProgress(100);
            String format = new SimpleDateFormat(TimeShowUtil.STR_VOD_DURATION_TIME_FORMATE).format(Long.valueOf(System.currentTimeMillis()));
            this.t.setText(format);
            this.s.setText(format);
            return;
        }
        if ("1".equals(com.zte.iptvclient.common.uiframe.a.c("Is_Support_Seek"))) {
            this.m.setEnabled(true);
        } else {
            this.m.setEnabled(false);
        }
        this.m.setMax(this.e);
        if (!this.E) {
            this.m.setProgress(this.f7378d);
        }
        if (!TextUtils.isEmpty(this.x.f7394c)) {
            this.t.setText(this.x.f7394c);
        }
        this.s.setText(a(this.f7378d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        PopupWindow popupWindow = this.y;
        SeekBar seekBar = this.m;
        popupWindow.showAtLocation(seekBar, 51, (int) (seekBar.getX() + ((int) a(this.m))), (this.f7376b.I() + this.k.getTop()) - this.m.getHeight());
    }

    public void e() {
        if (TextUtils.equals("1", ConfigMgr.readPropertie("isShow"))) {
            this.B.setTextColor(-1);
            this.C.setTextColor(-1);
            this.j.setBackgroundResource(R.drawable.remote_playctl_hand_night);
        }
        this.g.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_play_back_night));
        ((SupportActivity) this.f7375a).a(this.g, "background", R.drawable.remote_btn_play_back_night);
        this.u.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_play_volumn_plus_night));
        ((SupportActivity) this.f7375a).a(this.u, "background", R.drawable.remote_play_volumn_plus_night);
        this.v.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_play_volumn_down_night));
        ((SupportActivity) this.f7375a).a(this.v, "background", R.drawable.remote_play_volumn_down_night);
        this.w.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_mute_night));
        ((SupportActivity) this.f7375a).a(this.w, "background", R.drawable.remote_btn_mute_night);
        n nVar = this.x;
        if (nVar != null && "PLAYGING".equals(nVar.f)) {
            this.q.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.remote_btn_play_night));
            ((SupportActivity) this.f7375a).a(this.q, "src", R.drawable.remote_btn_play_night);
        } else {
            this.q.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.remote_btn_pause_night));
            ((SupportActivity) this.f7375a).a(this.q, "src", R.drawable.remote_btn_pause_night);
        }
    }

    public void f() {
        this.B.setTextColor(getResources().getColor(R.color.remote_hinttext_textcolor));
        this.C.setTextColor(getResources().getColor(R.color.remote_hinttext_textcolor));
        if (TextUtils.equals("1", ConfigMgr.readPropertie("isShow"))) {
            this.j.setBackgroundResource(R.drawable.remote_playctl_hand);
        }
        this.g.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_play));
        ((SupportActivity) this.f7375a).a(this.g, "background", R.drawable.remote_btn_play);
        this.u.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_play_volumn_plus));
        ((SupportActivity) this.f7375a).a(this.u, "background", R.drawable.remote_play_volumn_plus);
        this.v.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_play_volumn_down));
        ((SupportActivity) this.f7375a).a(this.v, "background", R.drawable.remote_play_volumn_down);
        this.w.setBackground(c.a.a.a.d.b.d().d(R.drawable.remote_btn_mute));
        ((SupportActivity) this.f7375a).a(this.w, "background", R.drawable.remote_btn_mute);
        n nVar = this.x;
        if (nVar != null && "PLAYGING".equals(nVar.f)) {
            this.q.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.remote_btn_play));
            ((SupportActivity) this.f7375a).a(this.q, "src", R.drawable.remote_btn_play);
        } else {
            this.q.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.remote_btn_pause));
            ((SupportActivity) this.f7375a).a(this.q, "src", R.drawable.remote_btn_pause);
        }
    }

    public void b(boolean z) {
        if (this.f7375a != null) {
            if (j()) {
                if (z) {
                    this.i.setEnabled(false);
                    if (((Activity) this.f7375a).isFinishing()) {
                        return;
                    }
                    com.bumptech.glide.h<Integer> h2 = com.bumptech.glide.i.b(this.f7375a).a(Integer.valueOf(R.drawable.remote_ctrl_play_tv)).h();
                    h2.a(DiskCacheStrategy.SOURCE);
                    h2.a(this.i);
                    return;
                }
                this.i.setEnabled(true);
                if (((Activity) this.f7375a).isFinishing()) {
                    return;
                }
                com.bumptech.glide.i.b(this.f7375a).a(Integer.valueOf(R.drawable.remote_play_tv)).a(this.i);
                return;
            }
            if (z) {
                this.i.setEnabled(false);
                Context context = this.f7375a;
                if (context == null || ((Activity) context).isFinishing()) {
                    return;
                }
                com.bumptech.glide.h<Integer> h3 = com.bumptech.glide.i.b(this.f7375a).a(Integer.valueOf(R.drawable.remote_ctrl_play_tv_en)).h();
                h3.a(DiskCacheStrategy.SOURCE);
                h3.a(this.i);
                return;
            }
            this.i.setEnabled(true);
            Context context2 = this.f7375a;
            if (context2 == null || ((Activity) context2).isFinishing()) {
                return;
            }
            com.bumptech.glide.i.b(this.f7375a).a(Integer.valueOf(R.drawable.remote_play_tv_en)).a(this.i);
        }
    }

    public void c() {
        if (this.G.hasMessages(2)) {
            this.G.removeMessages(2);
        }
    }

    public void d() {
        c();
        this.G.sendEmptyMessage(2);
    }

    private void a(Context context) {
        this.f7375a = context;
        a(LayoutInflater.from(context).inflate(R.layout.remote_play_control_layout, this));
        i();
        g();
        this.F = new com.zte.iptvclient.android.common.j.h(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("programcode", str);
        new SDKVodMgr().getSeriesHeadInfo(hashMap, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str) {
        return x.c(str, "yyyyMMddHHmmss", "yyyy.MM.dd HH:mm:ss", 0);
    }

    private void a(View view) {
        this.f = (RelativeLayout) view.findViewById(R.id.ll_tv);
        this.l = (LinearLayout) view.findViewById(R.id.ll_play_control);
        this.k = (LinearLayout) view.findViewById(R.id.ll_seekbar);
        this.h = (TextView) view.findViewById(R.id.tv_play_failed);
        this.i = (ImageView) view.findViewById(R.id.img_tv);
        this.m = (SeekBar) view.findViewById(R.id.sb_progress);
        this.n = (ImageView) view.findViewById(R.id.img_poster);
        this.o = (ImageView) view.findViewById(R.id.img_play_pre);
        this.p = (ImageView) view.findViewById(R.id.img_play_next);
        this.q = (ImageView) view.findViewById(R.id.img_play_pause);
        this.r = (TextView) view.findViewById(R.id.tv_number);
        this.s = (TextView) view.findViewById(R.id.tv_current_time);
        this.t = (TextView) view.findViewById(R.id.tv_total_time);
        this.u = (ImageView) view.findViewById(R.id.img_volumn_plus);
        this.v = (ImageView) view.findViewById(R.id.img_volumn_down);
        this.w = (ImageView) view.findViewById(R.id.img_volumn_mute);
        this.g = (Button) view.findViewById(R.id.tv_return_phone);
        this.B = (TextView) view.findViewById(R.id.textView1);
        this.C = (TextView) view.findViewById(R.id.textView2);
        this.j = (ImageView) view.findViewById(R.id.img_finger);
        com.zte.iptvclient.common.uiframe.f.a(this.f);
        com.zte.iptvclient.common.uiframe.f.a(this.l);
        com.zte.iptvclient.common.uiframe.f.a(this.m);
        com.zte.iptvclient.common.uiframe.f.a(this.n);
        com.zte.iptvclient.common.uiframe.f.a(this.o);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.k);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.h);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_voice));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_play_control));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_tv));
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_btn));
        com.zte.iptvclient.common.uiframe.f.a(this.g);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_finger));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_tv));
        this.B.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.finger_point));
        this.C.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.play_control));
        this.h.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.mobile_control_video_play_failed));
        this.g.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.mobile_control_video_play));
        if (j()) {
            this.i.setBackgroundResource(R.drawable.remote_play_tv);
        } else {
            this.i.setBackgroundResource(R.drawable.remote_play_tv_en);
        }
    }

    public boolean b() {
        return this.l.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        String str2 = "http://{epgdomain}:{port}/iptvepg/{frame}/getbackplaybestv.jsp".replace("http://{epgdomain}:{port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f()) + "?" + str;
        LogEx.d("RemotePlayControlLayout", "sdkQueryGetPlayBackJSP totalUrl = " + str2);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.startRequest(str2, "GET", new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float a(SeekBar seekBar) {
        return (((seekBar.getProgress() * (seekBar.getWidth() - (seekBar.getThumbOffset() * 2))) / seekBar.getMax()) + seekBar.getThumbOffset()) - (this.z.getWidth() / 2.0f);
    }

    public void a() {
        LogEx.d("RemotePlayControlLayout", "queryTransportInfo: result=" + com.zte.iptvclient.android.mobile.h.a.a.g().a(new l()));
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

    public void a(boolean z) {
        if (z) {
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(4);
        }
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
}
