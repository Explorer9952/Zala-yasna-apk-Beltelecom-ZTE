package com.zte.iptvclient.android.mobile.a0.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.eventbus.multi.MultiPlayWindowEvent;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.k.s;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.common.reminder.TvReminderManager;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONObject;
import pl.droidsonroids.gif.GifImageView;

/* compiled from: AdapterRecycleTvPrevue.java */
/* loaded from: classes2.dex */
public class a extends RecyclerView.g<k> {
    private static final String o = "a";

    /* renamed from: c, reason: collision with root package name */
    private Activity f5284c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<PrevueBean> f5285d;
    private ArrayList<com.zte.iptvclient.android.common.reminder.c> e;
    private int f;
    private Channel h;
    private int j;
    private String k;
    private int l;
    l n;
    private boolean g = false;
    private int i = 0;
    private String m = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterRecycleTvPrevue.java */
    /* renamed from: com.zte.iptvclient.android.mobile.a0.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0167a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        C0167a() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d(a.o, "sdkQueryEPGServerTvReminderList data return : " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (a.this.e != null) {
                    a.this.e.clear();
                }
                if (jSONObject.getString("returncode").equals("0")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("reminders");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (a.this.e != null) {
                            com.zte.iptvclient.android.common.reminder.c cVar = new com.zte.iptvclient.android.common.reminder.c();
                            cVar.b(jSONArray.getJSONObject(i).getString("contentcode"));
                            cVar.a(jSONArray.getJSONObject(i).getString("channelcode"));
                            a.this.e.add(cVar);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            a.this.d();
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            if (a.this.e != null) {
                a.this.e.clear();
            }
            a.this.d();
            LogEx.d(a.o, "sdkQueryEPGServerTvReminderList onFailReturn ,returncode : " + i + " , errormsg : " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterRecycleTvPrevue.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PrevueBean f5287a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ k f5288b;

        b(PrevueBean prevueBean, k kVar) {
            this.f5287a = prevueBean;
            this.f5288b = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.f());
            if (!a.this.g) {
                if ((a.this.f5284c instanceof MainActivity) && ((MainActivity) a.this.f5284c).s()) {
                    return;
                }
                a.this.a(view, this.f5287a, this.f5288b);
                return;
            }
            a.this.a(this.f5287a, this.f5288b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterRecycleTvPrevue.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PrevueBean f5290a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ k f5291b;

        c(PrevueBean prevueBean, k kVar) {
            this.f5290a = prevueBean;
            this.f5291b = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.f());
            if (!a.this.g) {
                if ((a.this.f5284c instanceof MainActivity) && ((MainActivity) a.this.f5284c).s()) {
                    return;
                }
                a.this.a(view, this.f5290a, this.f5291b);
                return;
            }
            a.this.a(this.f5290a, this.f5291b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterRecycleTvPrevue.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PrevueBean f5293a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ k f5294b;

        d(PrevueBean prevueBean, k kVar) {
            this.f5293a = prevueBean;
            this.f5294b = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.eventbus.multi.f());
            if (!a.this.g) {
                if ((a.this.f5284c instanceof MainActivity) && ((MainActivity) a.this.f5284c).s()) {
                    return;
                }
                a.this.a(view, this.f5293a, this.f5294b);
                return;
            }
            a.this.a(this.f5293a, this.f5294b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterRecycleTvPrevue.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f5296a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PrevueBean f5297b;

        e(k kVar, PrevueBean prevueBean) {
            this.f5296a = kVar;
            this.f5297b = prevueBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f5296a.x.getVisibility() == 0) {
                this.f5296a.x.setVisibility(8);
                a.this.m = "";
            } else {
                this.f5296a.x.setVisibility(0);
                Date d2 = x.d(this.f5297b.getBegintime());
                Date d3 = x.d(this.f5297b.getEndtime());
                Date b2 = s.b();
                a.this.m = this.f5297b.getPrevuecode();
                if (this.f5296a.A.getVisibility() == 8 && (!b2.after(d2) || !b2.before(d3))) {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(a.this.f5284c.getResources().getString(R.string.tvod_error_msg).replace("xx", com.zte.iptvclient.android.common.j.i.d().b(a.this.h.getAllMixno())));
                }
            }
            a.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterRecycleTvPrevue.java */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f5299a;

        f(a aVar, k kVar) {
            this.f5299a = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f5299a.x.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterRecycleTvPrevue.java */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5300a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f5301b;

        /* compiled from: AdapterRecycleTvPrevue.java */
        /* renamed from: com.zte.iptvclient.android.mobile.a0.a.a$g$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0168a implements t.d {
            C0168a(g gVar) {
            }

            @Override // com.zte.iptvclient.android.common.k.t.d
            public void onDismiss() {
            }
        }

        /* compiled from: AdapterRecycleTvPrevue.java */
        /* loaded from: classes2.dex */
        class b implements DialogInterface.OnClickListener {
            b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                g gVar = g.this;
                a.this.n.b(gVar.f5301b);
            }
        }

        g(String str, int i) {
            this.f5300a = str;
            this.f5301b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                MultiPlayWindowEvent multiPlayWindowEvent = new MultiPlayWindowEvent(MultiPlayWindowEvent.MultiPlayWindowEventType.CONTROL_GRAVITY_INDUCTION_IS_OPEN);
                multiPlayWindowEvent.a(false);
                EventBus.getDefault().post(multiPlayWindowEvent);
                t.a(a.this.f5284c, new C0168a(this));
                return;
            }
            if (a.this.n != null) {
                if ("0".equals(this.f5300a)) {
                    a.this.n.a(this.f5301b);
                    return;
                }
                if ("1".equals(this.f5300a)) {
                    com.zte.iptvclient.android.common.customview.a.a.a.d dVar = new com.zte.iptvclient.android.common.customview.a.a.a.d(a.this.f5284c);
                    dVar.setCanceledOnTouchOutside(false);
                    dVar.setCancelable(false);
                    dVar.setTitle(R.string.common_delete_one_confirm);
                    dVar.b(R.string.order_confirm, new b());
                    dVar.a(R.string.common_cancel, null);
                    dVar.show();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterRecycleTvPrevue.java */
    /* loaded from: classes2.dex */
    public class h implements t.d {
        h(a aVar) {
        }

        @Override // com.zte.iptvclient.android.common.k.t.d
        public void onDismiss() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterRecycleTvPrevue.java */
    /* loaded from: classes2.dex */
    public class i implements t.d {
        i(a aVar) {
        }

        @Override // com.zte.iptvclient.android.common.k.t.d
        public void onDismiss() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterRecycleTvPrevue.java */
    /* loaded from: classes2.dex */
    public class j implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f5304a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PrevueBean f5305b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ImageView f5306c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f5307d;

        j(boolean z, PrevueBean prevueBean, ImageView imageView, TextView textView) {
            this.f5304a = z;
            this.f5305b = prevueBean;
            this.f5306c = imageView;
            this.f5307d = textView;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d(a.o, "sdkDoEPGServerTvReminder data return : " + str);
            try {
                if (new JSONObject(str).getString("returncode").equals("0")) {
                    a.this.a(this.f5304a, this.f5305b, this.f5306c, this.f5307d);
                    a.this.g();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d(a.o, "returncode is " + i + " , errormsg is " + str);
        }
    }

    /* compiled from: AdapterRecycleTvPrevue.java */
    /* loaded from: classes2.dex */
    public static class k extends RecyclerView.b0 {
        ImageView A;
        TextView B;
        RelativeLayout C;
        ProgressBar D;
        ProgressBar E;
        View F;
        LinearLayout G;
        TextView J;
        GifImageView K;
        RelativeLayout L;
        ImageView M;
        TextView N;
        RelativeLayout O;
        LinearLayout t;
        TextView u;
        TextView v;
        LinearLayout w;
        LinearLayout x;
        TextView y;
        RelativeLayout z;

        public k(View view) {
            super(view);
            this.t = (LinearLayout) view.findViewById(R.id.ll_schedule_item);
            this.O = (RelativeLayout) view.findViewById(R.id.rl_arrow);
            this.w = (LinearLayout) view.findViewById(R.id.ll_showdetail);
            this.x = (LinearLayout) view.findViewById(R.id.ll_description);
            this.y = (TextView) view.findViewById(R.id.tvt_description);
            this.u = (TextView) view.findViewById(R.id.txt_program_title);
            this.v = (TextView) view.findViewById(R.id.txt_program_duration);
            this.z = (RelativeLayout) view.findViewById(R.id.rl_play_state);
            this.A = (ImageView) view.findViewById(R.id.img_play);
            this.B = (TextView) view.findViewById(R.id.txt_play);
            this.C = (RelativeLayout) view.findViewById(R.id.rl_progressbar);
            this.D = (ProgressBar) view.findViewById(R.id.pb_playing_light);
            this.E = (ProgressBar) view.findViewById(R.id.pb_playing_dark);
            this.F = view.findViewById(R.id.divider_line);
            this.G = (LinearLayout) view.findViewById(R.id.ll_now_playing);
            this.J = (TextView) view.findViewById(R.id.txt_playing);
            this.K = (GifImageView) view.findViewById(R.id.img_playing);
            this.N = (TextView) view.findViewById(R.id.playnow);
            com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_schedule_item));
            com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.cl_program_item));
            com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_program_describ));
            com.zte.iptvclient.common.uiframe.f.a(this.u);
            com.zte.iptvclient.common.uiframe.f.a(this.v);
            com.zte.iptvclient.common.uiframe.f.a(this.z);
            com.zte.iptvclient.common.uiframe.f.a(this.A);
            com.zte.iptvclient.common.uiframe.f.a(this.B);
            com.zte.iptvclient.common.uiframe.f.a(this.C);
            com.zte.iptvclient.common.uiframe.f.a(this.D);
            com.zte.iptvclient.common.uiframe.f.a(this.E);
            com.zte.iptvclient.common.uiframe.f.a(this.F);
            com.zte.iptvclient.common.uiframe.f.a(this.w);
            com.zte.iptvclient.common.uiframe.f.a(this.x);
            com.zte.iptvclient.common.uiframe.f.a(this.y);
            com.zte.iptvclient.common.uiframe.f.a(this.N);
            com.zte.iptvclient.common.uiframe.f.a(this.G);
            com.zte.iptvclient.common.uiframe.f.a(this.J);
            com.zte.iptvclient.common.uiframe.f.a(this.K);
            this.L = (RelativeLayout) view.findViewById(R.id.rl_tv_channel_schedule_recording);
            this.M = (ImageView) view.findViewById(R.id.img_tv_channel_schedule_recording);
            com.zte.iptvclient.common.uiframe.f.a(this.L);
            com.zte.iptvclient.common.uiframe.f.a(this.M);
        }
    }

    /* compiled from: AdapterRecycleTvPrevue.java */
    /* loaded from: classes2.dex */
    public interface l {
        void a(int i);

        void b(int i);
    }

    public a(Activity activity, ArrayList<PrevueBean> arrayList, int i2, int i3) {
        this.f = 0;
        this.j = 0;
        this.k = "0";
        this.l = 0;
        this.f5284c = activity;
        this.f5285d = arrayList;
        this.j = i2;
        this.l = i3;
        String readPropertie = ConfigMgr.readPropertie("SupportOrderReminderType");
        this.k = readPropertie;
        if (TextUtils.isEmpty(readPropertie)) {
            return;
        }
        this.f = Integer.valueOf(this.k).intValue();
    }

    private void g(PrevueBean prevueBean, k kVar) {
        kVar.z.setVisibility(0);
        kVar.A.setVisibility(8);
        kVar.B.setVisibility(0);
        kVar.C.setVisibility(0);
        if (TextUtils.equals(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b, "black.skin")) {
            kVar.D.setVisibility(8);
            kVar.E.setVisibility(0);
            kVar.E.setProgress(this.i);
        } else {
            kVar.D.setVisibility(0);
            kVar.E.setVisibility(8);
            kVar.D.setProgress(this.i);
        }
        if (com.zte.iptvclient.android.common.javabean.e.f4730a) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.f(prevueBean, this.i, null));
            kVar.N.setVisibility(8);
            kVar.B.setText(this.f5284c.getResources().getString(R.string.tv_program_nowplaying));
            kVar.G.setVisibility(0);
            if (TextUtils.equals(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b, "black.skin")) {
                kVar.K.setImageResource(R.drawable.channellist_playing_red);
            } else {
                kVar.K.setImageResource(R.drawable.channellist_playing);
            }
            kVar.z.setVisibility(8);
            if (this.l == 0) {
                kVar.J.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_prevue_now_light));
                ((SupportActivity) this.f5284c).a(kVar.J, "textColor", R.color.multiplayer_prevue_now_light);
                kVar.v.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_prevue_now_light));
                ((SupportActivity) this.f5284c).a(kVar.v, "textColor", R.color.multiplayer_prevue_now_light);
                kVar.u.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_prevuename_now_light));
                ((SupportActivity) this.f5284c).a(kVar.u, "textColor", R.color.multiplayer_prevuename_now_light);
                kVar.J.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_prevue_now_light));
                ((SupportActivity) this.f5284c).a(kVar.J, "textColor", R.color.multiplayer_prevue_now_light);
                return;
            }
            kVar.v.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_prevue_now_dark));
            ((SupportActivity) this.f5284c).a(kVar.v, "textColor", R.color.multiplayer_prevue_now_dark);
            kVar.u.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_prevuename_now_dark));
            ((SupportActivity) this.f5284c).a(kVar.u, "textColor", R.color.multiplayer_prevuename_now_dark);
            kVar.J.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_prevue_now_dark));
            ((SupportActivity) this.f5284c).a(kVar.J, "textColor", R.color.multiplayer_prevue_now_dark);
            return;
        }
        kVar.N.setVisibility(0);
        kVar.A.setVisibility(0);
        kVar.G.setVisibility(8);
        kVar.B.setText(this.f5284c.getResources().getString(R.string.now));
        kVar.B.setVisibility(8);
        if (TextUtils.equals(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b, "black.skin")) {
            kVar.K.setImageResource(R.drawable.channellist_playing_red);
        } else {
            kVar.K.setImageResource(R.drawable.channellist_playing);
        }
        if (this.l == 0) {
            kVar.B.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_prevue_now_light));
            ((SupportActivity) this.f5284c).a(kVar.B, "textColor", R.color.multiplayer_prevue_now_light);
            kVar.J.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_prevue_now_light));
            ((SupportActivity) this.f5284c).a(kVar.J, "textColor", R.color.multiplayer_prevue_now_light);
            kVar.v.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_prevue_past_textcolor));
            ((SupportActivity) this.f5284c).a(kVar.v, "textColor", R.color.tv_prevue_past_textcolor);
            kVar.u.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_prevue_past_textcolor));
            ((SupportActivity) this.f5284c).a(kVar.u, "textColor", R.color.tv_prevue_past_textcolor);
            kVar.J.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_prevue_past_textcolor));
            ((SupportActivity) this.f5284c).a(kVar.J, "textColor", R.color.tv_prevue_past_textcolor);
            return;
        }
        kVar.v.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_prevue_past_textcolor));
        ((SupportActivity) this.f5284c).a(kVar.v, "textColor", R.color.tv_prevue_past_textcolor);
        kVar.u.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_prevue_past_textcolor));
        ((SupportActivity) this.f5284c).a(kVar.u, "textColor", R.color.tv_prevue_past_textcolor);
        kVar.J.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_prevue_past_textcolor));
        ((SupportActivity) this.f5284c).a(kVar.J, "textColor", R.color.tv_prevue_past_textcolor);
    }

    public void f(int i2) {
        this.l = i2;
        d();
    }

    private void c(PrevueBean prevueBean, k kVar) {
        kVar.N.setVisibility(8);
        kVar.z.setVisibility(0);
        kVar.B.setVisibility(8);
        kVar.A.setVisibility(0);
        kVar.C.setVisibility(4);
        kVar.G.setVisibility(8);
        if (com.zte.iptvclient.android.common.player.multiplay.a.c().a("1", prevueBean.getPrevuecode())) {
            kVar.A.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.multiscreen_delete_blue));
            ((SupportActivity) this.f5284c).a(kVar.A, "src", R.drawable.multiscreen_delete_blue);
        } else {
            kVar.A.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.multiscreen_add_blue));
            ((SupportActivity) this.f5284c).a(kVar.A, "src", R.drawable.multiscreen_add_blue);
        }
        if (this.l == 0) {
            kVar.v.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_prevue_past_textcolor));
            ((SupportActivity) this.f5284c).a(kVar.v, "textColor", R.color.tv_prevue_past_textcolor);
            kVar.u.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_prevue_past_textcolor));
            ((SupportActivity) this.f5284c).a(kVar.u, "textColor", R.color.tv_prevue_past_textcolor);
            return;
        }
        kVar.v.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_prevuename_future_dark));
        ((SupportActivity) this.f5284c).a(kVar.v, "textColor", R.color.multiplayer_prevuename_future_dark);
        kVar.u.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_prevuename_future_dark));
        ((SupportActivity) this.f5284c).a(kVar.u, "textColor", R.color.multiplayer_prevuename_future_dark);
    }

    private void d(PrevueBean prevueBean, k kVar) {
        kVar.z.setVisibility(0);
        kVar.B.setVisibility(8);
        kVar.A.setVisibility(0);
        kVar.C.setVisibility(0);
        kVar.G.setVisibility(8);
        if (TextUtils.equals(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b, "black.skin")) {
            kVar.D.setVisibility(8);
            kVar.E.setVisibility(0);
            kVar.E.setProgress(this.i);
        } else {
            kVar.D.setVisibility(0);
            kVar.E.setVisibility(8);
            kVar.D.setProgress(this.i);
        }
        if (com.zte.iptvclient.android.common.player.multiplay.a.c().a("0", this.h.getChannelcode())) {
            kVar.A.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.multiscreen_delete_blue));
            ((SupportActivity) this.f5284c).a(kVar.A, "src", R.drawable.multiscreen_delete_blue);
        } else {
            kVar.A.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.morescreen_icon_add_vod));
            ((SupportActivity) this.f5284c).a(kVar.A, "src", R.drawable.morescreen_icon_add_vod);
        }
        if (this.l == 0) {
            kVar.u.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_prevuename_now_light));
            ((SupportActivity) this.f5284c).a(kVar.u, "textColor", R.color.multiplayer_prevuename_now_light);
            kVar.v.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_prevue_now_light));
            ((SupportActivity) this.f5284c).a(kVar.v, "textColor", R.color.multiplayer_prevue_now_light);
            return;
        }
        kVar.u.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_prevuename_now_dark));
        ((SupportActivity) this.f5284c).a(kVar.u, "textColor", R.color.multiplayer_prevuename_now_dark);
        kVar.v.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_prevue_now_dark));
        ((SupportActivity) this.f5284c).a(kVar.v, "textColor", R.color.multiplayer_prevue_now_dark);
    }

    private void f(PrevueBean prevueBean, k kVar) {
        PrevueBean prevueBean2;
        kVar.N.setVisibility(8);
        kVar.z.setVisibility(0);
        kVar.B.setVisibility(8);
        kVar.A.setVisibility(0);
        kVar.C.setVisibility(4);
        kVar.F.setVisibility(0);
        if (!com.zte.iptvclient.android.common.javabean.e.f4730a && (prevueBean2 = com.zte.iptvclient.android.common.javabean.e.f4731b) != null && TextUtils.equals(prevueBean2.getPrevuecode(), prevueBean.getPrevuecode())) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.f(prevueBean, this.i, null));
            if (TextUtils.equals(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b, "black.skin")) {
                kVar.K.setImageResource(R.drawable.channellist_playing_red);
            } else {
                kVar.K.setImageResource(R.drawable.channellist_playing);
            }
            kVar.v.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_prevue_now_light));
            ((SupportActivity) this.f5284c).a(kVar.v, "textColor", R.color.multiplayer_prevue_now_light);
            kVar.u.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_prevuename_now_light));
            ((SupportActivity) this.f5284c).a(kVar.u, "textColor", R.color.multiplayer_prevuename_now_light);
            kVar.G.setVisibility(0);
            kVar.z.setVisibility(8);
            if (this.l == 0) {
                kVar.J.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_prevue_now_light));
                ((SupportActivity) this.f5284c).a(kVar.J, "textColor", R.color.multiplayer_prevue_now_light);
                return;
            } else {
                kVar.J.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_prevue_now_dark));
                ((SupportActivity) this.f5284c).a(kVar.J, "textColor", R.color.multiplayer_prevue_now_dark);
                return;
            }
        }
        kVar.G.setVisibility(8);
        if (TextUtils.equals("1", prevueBean.getStatus())) {
            kVar.v.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_prevue_past_textcolor));
            ((SupportActivity) this.f5284c).a(kVar.v, "textColor", R.color.tv_prevue_past_textcolor);
            kVar.u.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_prevue_past_textcolor));
            ((SupportActivity) this.f5284c).a(kVar.u, "textColor", R.color.tv_prevue_past_textcolor);
        } else {
            kVar.v.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_prevue_future_textcolor));
            ((SupportActivity) this.f5284c).a(kVar.v, "textColor", R.color.tv_prevue_future_textcolor);
            kVar.u.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_prevue_future_textcolor));
            ((SupportActivity) this.f5284c).a(kVar.u, "textColor", R.color.tv_prevue_future_textcolor);
        }
        if (prevueBean.isShowPlayBotton() && "1".equals(prevueBean.getSystemrecordenable()) && "1".equals(prevueBean.getStatus())) {
            kVar.A.setVisibility(0);
            kVar.A.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.tv_tvod_play_bg));
            ((SupportActivity) this.f5284c).a(kVar.u, "src", R.drawable.tv_tvod_play_bg);
            return;
        }
        kVar.A.setVisibility(8);
    }

    public void e(int i2) {
        this.i = i2;
        d();
    }

    public void b(boolean z) {
        this.g = z;
        d();
    }

    private void e(PrevueBean prevueBean, k kVar) {
        kVar.N.setVisibility(8);
        kVar.z.setVisibility(0);
        kVar.C.setVisibility(4);
        kVar.G.setVisibility(8);
        kVar.F.setVisibility(0);
        if (this.j == 0) {
            if (!TextUtils.isEmpty(this.k)) {
                int intValue = Integer.valueOf(this.k).intValue();
                this.f = intValue;
                if ((intValue & 1) > 0) {
                    kVar.A.setVisibility(0);
                    kVar.B.setVisibility(0);
                    if (TvReminderManager.a(prevueBean.getPrevuecode())) {
                        kVar.A.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.reminder_press));
                        ((SupportActivity) this.f5284c).a(kVar.A, "src", R.drawable.reminder_press);
                        kVar.B.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_reminder_booked));
                        ((SupportActivity) this.f5284c).a(kVar.B, "textColor", R.color.tv_reminder_booked);
                        kVar.B.setText(this.f5284c.getResources().getString(R.string.tv_reminder_booked));
                    } else {
                        kVar.A.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.reminder_normal));
                        ((SupportActivity) this.f5284c).a(kVar.A, "src", R.drawable.reminder_normal);
                        kVar.B.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_reminder_normal));
                        ((SupportActivity) this.f5284c).a(kVar.B, "textColor", R.color.tv_reminder_normal);
                        kVar.B.setText(this.f5284c.getResources().getString(R.string.tv_reminder_booking));
                    }
                } else if ((intValue & 4) > 0) {
                    kVar.A.setVisibility(0);
                    kVar.B.setVisibility(0);
                    com.zte.iptvclient.android.common.reminder.c cVar = new com.zte.iptvclient.android.common.reminder.c();
                    cVar.a(prevueBean.getChannelcode());
                    cVar.b(prevueBean.getPrevuecode());
                    if (a(cVar)) {
                        kVar.A.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.reminder_press));
                        ((SupportActivity) this.f5284c).a(kVar.A, "src", R.drawable.reminder_press);
                        kVar.B.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_reminder_booked));
                        ((SupportActivity) this.f5284c).a(kVar.B, "textColor", R.color.tv_reminder_booked);
                        kVar.B.setText(this.f5284c.getResources().getString(R.string.tv_reminder_booked));
                    } else {
                        kVar.A.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.reminder_normal));
                        ((SupportActivity) this.f5284c).a(kVar.A, "src", R.drawable.reminder_normal);
                        kVar.B.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_reminder_normal));
                        ((SupportActivity) this.f5284c).a(kVar.B, "textColor", R.color.tv_reminder_normal);
                        kVar.B.setText(this.f5284c.getResources().getString(R.string.tv_reminder_booking));
                    }
                } else {
                    kVar.z.setVisibility(8);
                }
            } else {
                kVar.z.setVisibility(8);
            }
        }
        kVar.v.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_prevue_future_textcolor));
        ((SupportActivity) this.f5284c).a(kVar.v, "textColor", R.color.tv_prevue_future_textcolor);
        kVar.u.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_prevue_future_textcolor));
        ((SupportActivity) this.f5284c).a(kVar.u, "textColor", R.color.tv_prevue_future_textcolor);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public /* bridge */ /* synthetic */ void a(k kVar, int i2, List list) {
        a2(kVar, i2, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public k b(ViewGroup viewGroup, int i2) {
        return new k(LayoutInflater.from(this.f5284c).inflate(R.layout.livetv_channel_schedule_item, viewGroup, false));
    }

    public void a(Channel channel) {
        this.h = channel;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0073, code lost:
    
        if ("1".equals(r0.getStatus()) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0088, code lost:
    
        if ("1".equals(r0.getPrivaterecordenable()) != false) goto L30;
     */
    /* renamed from: b, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b2(com.zte.iptvclient.android.mobile.a0.a.a.k r8, int r9) {
        /*
            Method dump skipped, instructions count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.a0.a.a.b2(com.zte.iptvclient.android.mobile.a0.a.a$k, int):void");
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(k kVar, int i2, List<Object> list) {
        if (list.isEmpty()) {
            b(kVar, i2);
        } else {
            b2(kVar, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(k kVar, int i2) {
        if (this.l == 0) {
            kVar.F.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_theme_dividerline_light));
            ((SupportActivity) this.f5284c).a(kVar.F, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.multiplayer_theme_dividerline_light);
        } else {
            kVar.F.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_theme_dividerline_dark));
            ((SupportActivity) this.f5284c).a(kVar.F, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.multiplayer_theme_dividerline_dark);
        }
        PrevueBean prevueBean = this.f5285d.get(i2);
        if (this.m.equals(prevueBean.getPrevuecode())) {
            kVar.x.setVisibility(0);
        } else {
            kVar.x.setVisibility(8);
        }
        kVar.y.setText(this.f5284c.getResources().getString(R.string.show_version_descrption) + " " + prevueBean.getDescription());
        if ("1".equals(ConfigMgr.readPropertie("IsShowBlockTitle"))) {
            if (!prevueBean.getChannelcode().equals(com.zte.iptvclient.android.mobile.a0.b.g.U) && (com.zte.iptvclient.android.mobile.f.b.a.b(prevueBean.getChannelcode()) || com.zte.iptvclient.android.mobile.f.b.a.a(prevueBean.getRatingid(), this.f5284c))) {
                kVar.u.setText(R.string.common_blocktitle);
            } else {
                kVar.u.setText(prevueBean.getPrevuename());
            }
        } else {
            kVar.u.setText(prevueBean.getPrevuename());
        }
        kVar.v.setText(prevueBean.getDuration());
        kVar.B.setOnClickListener(new b(prevueBean, kVar));
        kVar.A.setOnClickListener(new c(prevueBean, kVar));
        kVar.z.setOnClickListener(new d(prevueBean, kVar));
        kVar.t.setOnClickListener(new e(kVar, prevueBean));
        kVar.O.setOnClickListener(new f(this, kVar));
        Date d2 = x.d(prevueBean.getBegintime());
        Date d3 = x.d(prevueBean.getEndtime());
        Date b2 = s.b();
        if (b2.after(d3)) {
            if (this.g) {
                c(prevueBean, kVar);
            } else {
                f(prevueBean, kVar);
            }
        } else if (b2.before(d2)) {
            if (this.g) {
                b(prevueBean, kVar);
            } else {
                e(prevueBean, kVar);
            }
        } else if (this.g) {
            d(prevueBean, kVar);
        } else {
            g(prevueBean, kVar);
        }
        b2(kVar, i2);
    }

    public a(Activity activity, ArrayList<PrevueBean> arrayList, ArrayList<com.zte.iptvclient.android.common.reminder.c> arrayList2, int i2, int i3) {
        this.f = 0;
        this.j = 0;
        this.k = "0";
        this.l = 0;
        this.f5284c = activity;
        this.f5285d = arrayList;
        this.e = arrayList2;
        this.j = i2;
        this.l = i3;
        String readPropertie = ConfigMgr.readPropertie("SupportOrderReminderType");
        this.k = readPropertie;
        if (TextUtils.isEmpty(readPropertie)) {
            return;
        }
        this.f = Integer.valueOf(this.k).intValue();
    }

    private String f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("usertoken", com.zte.iptvclient.common.uiframe.a.d("UserToken"));
            jSONObject.put("usercode", com.zte.iptvclient.common.uiframe.a.d("UserID"));
            jSONObject.put("sorttype", 1);
            jSONObject.put("authinfo", com.zte.iptvclient.android.common.k.g.a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        LogEx.d(o, "convertToQueryJsonParams : " + jSONObject.toString());
        return jSONObject.toString();
    }

    private void b(PrevueBean prevueBean, k kVar) {
        kVar.N.setVisibility(8);
        kVar.C.setVisibility(4);
        kVar.z.setVisibility(8);
        kVar.G.setVisibility(8);
        kVar.v.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_prevue_future_textcolor));
        ((SupportActivity) this.f5284c).a(kVar.v, "textColor", R.color.tv_prevue_future_textcolor);
        kVar.u.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_prevue_future_textcolor));
        ((SupportActivity) this.f5284c).a(kVar.u, "textColor", R.color.tv_prevue_future_textcolor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, PrevueBean prevueBean, k kVar) {
        try {
            LogEx.d(o, "clickViewToPlay");
            Date d2 = x.d(prevueBean.getBegintime());
            Date d3 = x.d(prevueBean.getEndtime());
            Date b2 = s.b();
            if (b2.after(d2) && b2.before(d3)) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(true, prevueBean.getChannelcode(), prevueBean.getColumncode()));
            } else if (b2.after(d3)) {
                if (this.h != null && com.zte.iptvclient.android.common.j.i.d().a(d2, d3, this.h.getMixno())) {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.f5284c.getResources().getString(R.string.program_playbcak).replace("hour", com.zte.iptvclient.android.common.j.i.d().b(this.h.getMixno())));
                    return;
                } else if (TextUtils.equals("1", prevueBean.getStatus()) && TextUtils.equals("1", prevueBean.getTvod())) {
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.b(prevueBean, true));
                } else {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.tvod_schedul_unable_play_tip);
                }
            } else if (b2.before(d2)) {
                ImageView imageView = kVar.A;
                TextView textView = kVar.B;
                if (!view.equals(imageView) && !view.equals(textView)) {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.menu_file_no_exists);
                }
                if ((this.f & 1) > 0) {
                    a(prevueBean, imageView, textView);
                } else if ((this.f & 4) > 0) {
                    b(prevueBean, imageView, textView);
                }
            }
            if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
                com.zte.iptvclient.android.common.f.b.b.j().a(a(prevueBean));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void b(PrevueBean prevueBean, ImageView imageView, TextView textView) {
        if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
            MultiPlayWindowEvent multiPlayWindowEvent = new MultiPlayWindowEvent(MultiPlayWindowEvent.MultiPlayWindowEventType.CONTROL_GRAVITY_INDUCTION_IS_OPEN);
            multiPlayWindowEvent.a(false);
            EventBus.getDefault().post(multiPlayWindowEvent);
            t.a(this.f5284c, new i(this));
            return;
        }
        com.zte.iptvclient.android.common.reminder.c cVar = new com.zte.iptvclient.android.common.reminder.c();
        cVar.a(prevueBean.getChannelcode());
        cVar.b(prevueBean.getPrevuecode());
        if (a(cVar)) {
            LogEx.d(o, "TvReminderManager has reminder,channel_id is" + prevueBean.getPrevuecode());
            a(prevueBean, false, imageView, textView);
            return;
        }
        a(prevueBean, true, imageView, textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        String replace = "http://{epgdomain}/iptvepg/serviceapi?servicetype=reminderquery".replace("http://{epgdomain}", com.zte.iptvclient.android.common.f.b.i.b());
        LogEx.d(o, "sdkQueryEPGServerTvReminderList url is : " + replace);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json; charset=GBK");
        sDKNetHTTPRequest.setBody(f());
        sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_POST, new C0167a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PrevueBean prevueBean, k kVar) {
        try {
            Date d2 = x.d(prevueBean.getBegintime());
            Date d3 = x.d(prevueBean.getEndtime());
            Date b2 = s.b();
            int i2 = 0;
            if (b2.after(d2) && b2.before(d3)) {
                com.zte.iptvclient.android.common.javabean.f a2 = com.zte.iptvclient.android.common.player.multiplay.a.a(this.h);
                ArrayList<com.zte.iptvclient.android.common.javabean.f> a3 = com.zte.iptvclient.android.common.player.multiplay.a.c().a();
                if (com.zte.iptvclient.android.common.player.multiplay.a.c().a(a2)) {
                    while (true) {
                        if (i2 >= a3.size()) {
                            break;
                        }
                        com.zte.iptvclient.android.common.javabean.f fVar = a3.get(i2);
                        if (TextUtils.equals(fVar.c(), a2.c()) && TextUtils.equals(fVar.d(), a2.d())) {
                            a3.remove(i2);
                            kVar.A.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.multiscreen_add_blue));
                            ((SupportActivity) this.f5284c).a(kVar.A, "src", R.drawable.multiscreen_add_blue);
                            break;
                        }
                        i2++;
                    }
                } else if (!com.zte.iptvclient.android.common.player.multiplay.a.c().b()) {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.multiscreen_program_too_more);
                    return;
                } else {
                    a3.add(a2);
                    kVar.A.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.multiscreen_delete_blue));
                    ((SupportActivity) this.f5284c).a(kVar.A, "src", R.drawable.multiscreen_delete_blue);
                }
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.y.b());
                return;
            }
            if (b2.after(d3)) {
                com.zte.iptvclient.android.common.javabean.f a4 = com.zte.iptvclient.android.common.player.multiplay.a.a(prevueBean);
                ArrayList<com.zte.iptvclient.android.common.javabean.f> a5 = com.zte.iptvclient.android.common.player.multiplay.a.c().a();
                if (com.zte.iptvclient.android.common.player.multiplay.a.c().a(a4)) {
                    while (true) {
                        if (i2 >= a5.size()) {
                            break;
                        }
                        com.zte.iptvclient.android.common.javabean.f fVar2 = a5.get(i2);
                        if (TextUtils.equals(fVar2.c(), a4.c()) && TextUtils.equals(fVar2.d(), a4.d())) {
                            a5.remove(i2);
                            kVar.A.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.multiscreen_add_blue));
                            ((SupportActivity) this.f5284c).a(kVar.A, "src", R.drawable.multiscreen_add_blue);
                            break;
                        }
                        i2++;
                    }
                } else if (!com.zte.iptvclient.android.common.player.multiplay.a.c().b()) {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.multiscreen_program_too_more);
                    return;
                } else {
                    a5.add(a4);
                    kVar.A.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.multiscreen_delete_blue));
                    ((SupportActivity) this.f5284c).a(kVar.A, "src", R.drawable.multiscreen_delete_blue);
                }
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.y.b());
                return;
            }
            if (b2.before(d2)) {
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean a(com.zte.iptvclient.android.common.reminder.c cVar) {
        ArrayList<com.zte.iptvclient.android.common.reminder.c> arrayList = this.e;
        if (arrayList != null && arrayList.size() != 0) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                if (this.e.get(i2).a().equals(cVar.a()) && this.e.get(i2).b().equals(cVar.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(PrevueBean prevueBean, ImageView imageView, TextView textView) {
        if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
            MultiPlayWindowEvent multiPlayWindowEvent = new MultiPlayWindowEvent(MultiPlayWindowEvent.MultiPlayWindowEventType.CONTROL_GRAVITY_INDUCTION_IS_OPEN);
            multiPlayWindowEvent.a(false);
            EventBus.getDefault().post(multiPlayWindowEvent);
            t.a(this.f5284c, new h(this));
            return;
        }
        if (TvReminderManager.a(prevueBean.getPrevuecode())) {
            LogEx.d(o, "TvReminderManager has reminder,channel_id is" + prevueBean.getPrevuecode());
            a(false, prevueBean, imageView, textView);
            return;
        }
        if (TvReminderManager.c(prevueBean)) {
            LogEx.d(o, "TvReminderManager has reminder,channel_id is" + prevueBean.getPrevuecode());
            a(true, prevueBean, imageView, textView);
        }
    }

    private String a(PrevueBean prevueBean, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            String d2 = com.zte.iptvclient.common.uiframe.a.d("UserID");
            jSONObject.put("usertoken", com.zte.iptvclient.common.uiframe.a.d("UserToken"));
            jSONObject.put("usercode", d2);
            if (z) {
                jSONObject.put("action", 1);
            } else {
                jSONObject.put("action", 0);
            }
            jSONObject.put(ShareConstants.FEED_SOURCE_PARAM, 1);
            jSONObject.put("contentcode", prevueBean.getPrevuecode());
            jSONObject.put("channelcode", prevueBean.getChannelcode());
            jSONObject.put("contentmediacode", prevueBean.getTelecomcode());
            jSONObject.put("channelmediacode", prevueBean.getChannelTelcomcode());
            jSONObject.put("contentname", prevueBean.getPrevuename());
            jSONObject.put("begintime", TimeUtil.format(x.a(prevueBean.getBegintime(), "yyyy-MM-dd HH:mm:ss"), "yyyyMMddHHmmss"));
            jSONObject.put("authinfo", com.zte.iptvclient.android.common.k.g.a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        LogEx.d(o, "json : " + jSONObject.toString());
        return jSONObject.toString();
    }

    private void a(PrevueBean prevueBean, boolean z, ImageView imageView, TextView textView) {
        String replace = "http://{epgdomain}/iptvepg/serviceapi?servicetype=reminderset".replace("http://{epgdomain}", com.zte.iptvclient.android.common.f.b.i.b());
        LogEx.d(o, "sdkDoEPGServerTvReminder url is : " + replace);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json; charset=GBK");
        sDKNetHTTPRequest.setBody(a(prevueBean, z));
        sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_POST, new j(z, prevueBean, imageView, textView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PrevueBean prevueBean, ImageView imageView, TextView textView) {
        if (prevueBean == null) {
            return;
        }
        if (z) {
            Intent intent = new Intent("com.tv.remindReceive");
            if (imageView != null) {
                LogEx.d(o, "img is not null");
                imageView.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.reminder_press));
                ((SupportActivity) this.f5284c).a(imageView, "src", R.drawable.reminder_press);
                textView.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_reminder_booked));
                ((SupportActivity) this.f5284c).a(textView, "textColor", R.color.tv_reminder_booked);
                textView.setText(this.f5284c.getResources().getString(R.string.tv_reminder_booked));
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.booking_success);
            }
            intent.putExtra("reminder_operation_type", 1);
            Bundle bundle = new Bundle();
            bundle.putSerializable("tv_reminder", prevueBean);
            intent.putExtras(bundle);
            this.f5284c.sendBroadcast(intent);
            return;
        }
        Intent intent2 = new Intent("com.tv.remindReceive");
        if (imageView != null) {
            LogEx.d(o, "img is not null");
            imageView.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.reminder_normal));
            ((SupportActivity) this.f5284c).a(imageView, "src", R.drawable.reminder_normal);
            textView.setTextColor(c.a.a.a.d.b.d().b(R.color.tv_reminder_normal));
            ((SupportActivity) this.f5284c).a(textView, "textColor", R.color.tv_reminder_normal);
            textView.setText(this.f5284c.getResources().getString(R.string.tv_reminder_booking));
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.cancel_booking);
        }
        intent2.putExtra("reminder_operation_type", -1);
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("tv_reminder", prevueBean);
        intent2.putExtras(bundle2);
        this.f5284c.sendBroadcast(intent2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        ArrayList<PrevueBean> arrayList = this.f5285d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    private PrevueBean a(PrevueBean prevueBean) {
        int indexOf;
        ArrayList<PrevueBean> arrayList = this.f5285d;
        if (arrayList != null && (indexOf = arrayList.indexOf(prevueBean)) < this.f5285d.size() - 1) {
            return this.f5285d.get(indexOf + 1);
        }
        return null;
    }

    public void a(l lVar) {
        this.n = lVar;
    }
}
