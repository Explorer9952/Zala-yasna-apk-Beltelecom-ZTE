package com.zte.iptvclient.android.mobile.o.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.mes.bean.MsgInfo;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.view.listview.DelSlideListView;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.javabean.models.MovieDetailBundleBean;
import com.zte.iptvclient.android.common.javabean.models.TvShowItem;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.common.k.u;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.f0.a.a;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.EventBus;

/* compiled from: MessageCenterFragment.java */
/* loaded from: classes.dex */
public class a extends com.zte.fragmentlib.b implements a.b {
    private static String R = "1";
    private static String S = "14";
    private static String T = "2";
    private static String U = "4";
    private static long V;
    private TextView A;
    private LinearLayout B;
    private LinearLayout C;
    private DelSlideListView D;
    private k E;
    private List<MsgInfo> F;
    private List<MsgInfo> G;
    private com.zte.iptvclient.android.common.f.b.j J;
    private com.zte.iptvclient.android.common.j.h K;
    private SmartRefreshLayout L;
    private RelativeLayout M;
    private TextView N;
    private ImageView q;
    private Button r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private RelativeLayout w;
    private RelativeLayout x;
    private FrameLayout y;
    private TextView z;
    private String p = "MessageCenterFragment";
    private boolean O = false;
    private boolean P = false;
    private com.zte.iptvclient.android.common.g.b Q = new C0322a();

    /* compiled from: MessageCenterFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.o.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0322a implements com.zte.iptvclient.android.common.g.b {
        C0322a() {
        }

        @Override // com.zte.iptvclient.android.common.g.b
        public boolean a(int i) {
            return true;
        }

        @Override // com.zte.iptvclient.android.common.g.b
        public void b(int i) {
            if (a.this.F.size() != 0 && a.this.F.get(i) != null) {
                if (((MsgInfo) a.this.F.get(i)).msgid != null) {
                    a.this.J.b(((MsgInfo) a.this.F.get(i)).msgid);
                }
                a.this.F.remove(i);
            }
            a.this.D.a();
            a aVar = a.this;
            aVar.F = aVar.J.b();
            if (a.this.E != null) {
                a.this.E.notifyDataSetChanged();
            }
            a.this.O();
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.p.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessageCenterFragment.java */
    /* loaded from: classes.dex */
    public class b implements com.scwang.smartrefresh.layout.d.c {
        b() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            a.this.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessageCenterFragment.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.p.a());
            if (a.this.getActivity() instanceof MainActivity) {
                a.this.F();
            } else if (a.this.getActivity() instanceof HostActivity) {
                a.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessageCenterFragment.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.F == null || a.this.F.size() <= 0) {
                return;
            }
            a.this.O = true;
            a.this.P = false;
            a.this.K();
            a.this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessageCenterFragment.java */
    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.O = false;
            a.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessageCenterFragment.java */
    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.P = !r2.P;
            a.this.G.clear();
            if (a.this.P) {
                a.this.G.addAll(a.this.F);
                a.this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_null));
            } else {
                a.this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
            }
            if (a.this.E != null) {
                a.this.E.notifyDataSetChanged();
            }
            a.this.O();
            a.this.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessageCenterFragment.java */
    /* loaded from: classes.dex */
    public class g implements AdapterView.OnItemClickListener {
        g() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (!a.this.I() && i < a.this.F.size()) {
                if (a.this.O) {
                    if (a.this.G.contains(a.this.F.get(i))) {
                        a.this.G.remove(a.this.F.get(i));
                    } else {
                        a.this.G.add(a.this.F.get(i));
                    }
                    if (a.this.E != null) {
                        a.this.E.notifyDataSetChanged();
                    }
                    a.this.O();
                    a.this.N();
                    return;
                }
                a.this.d(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessageCenterFragment.java */
    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.E == null || a.this.G.size() == 0) {
                return;
            }
            a.this.S();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessageCenterFragment.java */
    /* loaded from: classes.dex */
    public class i implements com.scwang.smartrefresh.layout.d.c {
        i() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            if (a.this.O || a.this.P) {
                return;
            }
            a.this.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessageCenterFragment.java */
    /* loaded from: classes.dex */
    public class j implements t.e {
        j() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void a() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void b() {
            a.this.Q();
        }
    }

    /* compiled from: MessageCenterFragment.java */
    /* loaded from: classes.dex */
    public class k extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private LayoutInflater f6931a;

        /* renamed from: b, reason: collision with root package name */
        private com.zte.iptvclient.android.common.g.b f6932b;

        /* compiled from: MessageCenterFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.o.a.a$k$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class ViewOnClickListenerC0323a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f6934a;

            ViewOnClickListenerC0323a(int i) {
                this.f6934a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LogEx.d(a.this.p, "onClick");
                if (k.this.f6932b != null) {
                    k.this.f6932b.b(this.f6934a);
                }
            }
        }

        public k(Activity activity) {
            this.f6931a = null;
            this.f6931a = (LayoutInflater) activity.getSystemService("layout_inflater");
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return a.this.F.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (a.this.F != null && a.this.F.size() > i) {
                return a.this.F.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            l lVar;
            View view2;
            String[] split;
            if (view == null) {
                view2 = this.f6931a.inflate(R.layout.message_item, (ViewGroup) null);
                lVar = new l(null);
                lVar.f6936a = (RelativeLayout) view2.findViewById(R.id.rl_mes_icon);
                lVar.i = (ImageView) view2.findViewById(R.id.mes_mg_select_img);
                lVar.g = (ImageView) view2.findViewById(R.id.img_channel_icon);
                lVar.h = (ImageView) view2.findViewById(R.id.message_tip_icon);
                lVar.f6937b = (LinearLayout) view2.findViewById(R.id.text_ll);
                lVar.f6938c = (TextView) view2.findViewById(R.id.txt_message_type);
                lVar.f6939d = (TextView) view2.findViewById(R.id.txt_message_content);
                lVar.e = (TextView) view2.findViewById(R.id.txt_message_time);
                lVar.f = (ImageView) view2.findViewById(R.id.delete_action);
                com.zte.iptvclient.common.uiframe.f.a(view2.findViewById(R.id.ll_item_view_mes));
                com.zte.iptvclient.common.uiframe.f.a(lVar.f6936a);
                com.zte.iptvclient.common.uiframe.f.a(lVar.f6937b);
                com.zte.iptvclient.common.uiframe.f.a(lVar.i);
                com.zte.iptvclient.common.uiframe.f.a(lVar.g);
                com.zte.iptvclient.common.uiframe.f.a(lVar.h);
                com.zte.iptvclient.common.uiframe.f.a(lVar.f6938c);
                com.zte.iptvclient.common.uiframe.f.a(lVar.e);
                com.zte.iptvclient.common.uiframe.f.a(lVar.f6939d);
                com.zte.iptvclient.common.uiframe.f.a(lVar.f);
                view2.setTag(lVar);
            } else {
                lVar = (l) view.getTag();
                view2 = view;
            }
            if (a.this.O) {
                if (a.this.G.contains(a.this.F.get(i))) {
                    lVar.i.setSelected(true);
                } else {
                    lVar.i.setSelected(false);
                }
                lVar.i.setVisibility(0);
            } else {
                lVar.i.setVisibility(8);
            }
            lVar.g.setImageResource(R.drawable.icon_sms_default);
            String str = ((MsgInfo) a.this.F.get(i)).titleIconUrl;
            LogEx.d(a.this.p, "messageImg url = " + str);
            if (str != null && !StringUtil.isEmptyString(str) && (split = str.split(",")) != null) {
                String b2 = com.zte.iptvclient.android.common.f.b.i.b();
                LogEx.d(a.this.p, "mEpgDomain = " + b2);
                if (split.length > 1) {
                    String str2 = split[1];
                    LogEx.d(a.this.p, "Messageurl = " + str2);
                    com.bumptech.glide.i.a(a.this.getActivity()).a(str2).a(lVar.g);
                    if (((com.zte.fragmentlib.b) a.this).h != null && !((com.zte.fragmentlib.b) a.this).h.isFinishing()) {
                        com.bumptech.glide.d<String> a2 = com.bumptech.glide.i.a((FragmentActivity) ((com.zte.fragmentlib.b) a.this).h).a(str2);
                        a2.b(R.drawable.icon_sms_default);
                        a2.a(R.drawable.icon_sms_default);
                        a2.c(300);
                        a2.a(lVar.g);
                    }
                } else if (split.length == 1) {
                    String str3 = split[0];
                    LogEx.d(a.this.p, "Messageurl = " + str3);
                    if (((com.zte.fragmentlib.b) a.this).h != null && !((com.zte.fragmentlib.b) a.this).h.isFinishing()) {
                        com.bumptech.glide.d<String> a3 = com.bumptech.glide.i.a((FragmentActivity) ((com.zte.fragmentlib.b) a.this).h).a(str3);
                        a3.b(R.drawable.icon_sms_default);
                        a3.a(R.drawable.icon_sms_default);
                        a3.c(300);
                        a3.a(lVar.g);
                    }
                }
            }
            lVar.f6938c.setText(((MsgInfo) a.this.F.get(i)).msgTitle);
            lVar.f6939d.setText(((MsgInfo) a.this.F.get(i)).summary);
            LogEx.d(a.this.p, "MessageActivityMSGID=" + ((MsgInfo) a.this.F.get(i)).msgid + "utcTime=" + ((MsgInfo) a.this.F.get(i)).timestamp);
            LogEx.d(a.this.p, "MessageActivityMsgID=" + ((MsgInfo) a.this.F.get(i)).msgid + "MsgTitle=" + ((MsgInfo) a.this.F.get(i)).msgTitle + "Msg_state+" + ((MsgInfo) a.this.F.get(i)).isRead);
            if (!TextUtils.isEmpty(((MsgInfo) a.this.F.get(i)).timestamp)) {
                try {
                    String str4 = ((MsgInfo) a.this.F.get(i)).timestamp;
                    String b3 = x.b(str4, "yyyyMMddHHmmss", "yyyyMMddHHmmss");
                    String format = TimeUtil.format(TimeUtil.getNow(), "yyyyMMddHHmmss");
                    LogEx.d(a.this.p, "utcTime=" + str4);
                    LogEx.d(a.this.p, "localTime=" + b3);
                    LogEx.d(a.this.p, "sysTime=" + format);
                    long a4 = (long) x.a(b3, format, "yyyyMMddHHmmss", 1);
                    if (a4 > 1440) {
                        String format2 = TimeUtil.format(x.a(b3, "yyyyMMddHHmmss"), "MM/dd");
                        LogEx.d(a.this.p, "strYMDTime=" + format2);
                        if (!TextUtils.isEmpty(format2) && format2.contains("/") && ((com.zte.fragmentlib.b) a.this).h != null) {
                            format2 = format2.replace("/", com.zte.iptvclient.android.common.i.a.a.a(R.string.time_year)) + "" + com.zte.iptvclient.android.common.i.a.a.a(R.string.week_sunday);
                        }
                        lVar.e.setText(format2);
                    } else if (a4 > 720 && a4 < 1440) {
                        lVar.e.setText(R.string.yesterday);
                    } else if (a4 > 0 && a4 < 720) {
                        String format3 = TimeUtil.format(x.a(b3, "yyyyMMddHHmmss"), "HH:mm");
                        LogEx.d("USee", "strHMTime=" + format3);
                        lVar.e.setText(format3);
                    } else if (a4 < 0 || a4 == 0) {
                        String format4 = TimeUtil.format(x.a(b3, "yyyyMMddHHmmss"), "HH:mm");
                        LogEx.d(a.this.p, "strHMTime=" + format4);
                        lVar.e.setText(format4);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            LogEx.d(a.this.p, "AdapterMessage contenturl = " + ((MsgInfo) a.this.F.get(i)).msgFrom);
            lVar.f.setOnClickListener(new ViewOnClickListenerC0323a(i));
            if (((MsgInfo) a.this.F.get(i)).isRead.equals("1")) {
                lVar.h.setVisibility(8);
            } else {
                lVar.h.setVisibility(0);
            }
            return view2;
        }

        public void a(com.zte.iptvclient.android.common.g.b bVar) {
            this.f6932b = bVar;
        }
    }

    /* compiled from: MessageCenterFragment.java */
    /* loaded from: classes.dex */
    private static class l extends com.zte.iptvclient.common.uiframe.d {

        /* renamed from: a, reason: collision with root package name */
        RelativeLayout f6936a;

        /* renamed from: b, reason: collision with root package name */
        LinearLayout f6937b;

        /* renamed from: c, reason: collision with root package name */
        TextView f6938c;

        /* renamed from: d, reason: collision with root package name */
        TextView f6939d;
        TextView e;
        ImageView f;
        ImageView g;
        ImageView h;
        ImageView i;

        private l() {
        }

        /* synthetic */ l(b bVar) {
            this();
        }
    }

    private void P() {
        this.r.setOnClickListener(new c());
        this.B.setOnClickListener(new d());
        this.C.setOnClickListener(new e());
        this.t.setOnClickListener(new f());
        this.D.setOnItemClickListener(new g());
        this.y.setOnClickListener(new h());
        this.L.a(new i());
        this.D.a(this.Q);
        this.E.a(this.Q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        if (this.P && this.F.size() == this.G.size()) {
            this.J.a();
            J();
        } else {
            a(this.G);
        }
    }

    private void R() {
        this.F = new ArrayList();
        this.G = new ArrayList();
        com.zte.iptvclient.android.common.f.b.j jVar = this.J;
        if (jVar != null) {
            this.F = jVar.b();
        }
        List<MsgInfo> list = this.F;
        if (list == null) {
            this.F = new ArrayList();
        } else {
            Collections.reverse(list);
        }
        this.D.addFooterView(new ViewStub(this.h));
        k kVar = new k(this.h);
        this.E = kVar;
        this.D.setAdapter((ListAdapter) kVar);
        if (this.F.size() == 0) {
            this.M.setVisibility(0);
            this.D.setVisibility(8);
            this.s.setVisibility(8);
        } else {
            this.M.setVisibility(8);
            this.D.setVisibility(0);
            this.s.setVisibility(0);
        }
        M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        String a2;
        if (this.G.size() == 1) {
            a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_delete_item);
        } else {
            a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_delete_items);
        }
        t.a(this.h, a2, new j());
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.p.a());
        return super.D();
    }

    public boolean I() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - V <= 300) {
            LogEx.w(this.p, "Operate limit,less than 1000(ms)!");
            return true;
        }
        V = currentTimeMillis;
        return false;
    }

    public void J() {
        this.F.clear();
        this.G.clear();
        this.E.notifyDataSetChanged();
        this.O = false;
        this.P = false;
        List<MsgInfo> b2 = this.J.b();
        this.F = b2;
        if (b2 != null) {
            Collections.reverse(b2);
            this.E.notifyDataSetChanged();
            if (this.F.size() == 0) {
                this.M.setVisibility(0);
                this.D.setVisibility(8);
                this.s.setVisibility(8);
            } else {
                this.M.setVisibility(8);
                this.D.setVisibility(0);
                this.s.setVisibility(0);
            }
        }
        N();
        M();
        this.L.c(1000);
    }

    protected void K() {
        this.G.clear();
        N();
        if (this.O) {
            L();
        } else {
            M();
        }
    }

    protected void L() {
        DelSlideListView.m = true;
        this.L.d(false);
        this.w.setVisibility(8);
        this.x.setVisibility(0);
        O();
        k kVar = this.E;
        if (kVar != null) {
            kVar.notifyDataSetChanged();
        }
    }

    protected void M() {
        DelSlideListView.m = false;
        this.L.d(true);
        this.w.setVisibility(0);
        this.x.setVisibility(8);
        k kVar = this.E;
        if (kVar != null) {
            kVar.notifyDataSetChanged();
        }
    }

    public void N() {
        if (this.G.size() > 0) {
            this.y.setVisibility(0);
            int a2 = a(this.h, 10.0f);
            int a3 = a(this.h, 58.0f);
            if (this.y.getMeasuredHeight() > a2) {
                a3 = this.y.getMeasuredHeight();
            }
            a(a2, a2, a2, a3);
            return;
        }
        this.y.setVisibility(8);
        int a4 = a(this.h, 10.0f);
        a(a4, a4, a4, a4);
    }

    public void O() {
        int size = this.G.size();
        List<MsgInfo> list = this.F;
        if (list != null && size == list.size()) {
            this.v.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_nums), Integer.valueOf(size)));
            this.P = true;
            this.t.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_null));
        } else if (size <= 1) {
            this.v.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_num), Integer.valueOf(size)));
            this.P = false;
            this.t.setText(this.h.getResources().getString(R.string.favorite_select_all));
        } else {
            this.v.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_nums), Integer.valueOf(size)));
            this.P = false;
            this.t.setText(this.h.getResources().getString(R.string.favorite_select_all));
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        R();
        P();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.J = com.zte.iptvclient.android.common.f.b.j.e();
        this.K = new com.zte.iptvclient.android.common.j.h(this.h);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_fragment, (ViewGroup) null);
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        LogEx.d(this.p, "onHiddenChanged == " + z);
        if (z) {
            return;
        }
        J();
    }

    public Boolean s(String str) {
        if (str != null && !StringUtil.isEmptyString(str)) {
            boolean matches = Pattern.compile("^((https|http|ftp|rtsp|mms)?://)?(([0-9a-zA-Z_!~*'().&=+$%-]+: )?[0-9a-zA-Z_!~*'().&=+$%-]+@)?(([0-9]{1,3}\\.){3}[0-9]{1,3}|([0-9a-zA-Z_!~*'()-]+\\.)*([0-9a-zA-Z][0-9a-zA-Z-]{0,61})?[0-9a-zA-Z]\\.[a-zA-Z]{2,6})((/?)|(/[0-9a-zA-Z_!~*'().;?:@&=+$,%#-]+)+/?)$").matcher(str).matches();
            LogEx.d(this.p, "checkURL=" + str + "resourt=" + matches);
            return Boolean.valueOf(matches);
        }
        return false;
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.w = (RelativeLayout) view.findViewById(R.id.bookmark_title_rlayout);
        Button button = (Button) view.findViewById(R.id.btn_back);
        this.r = button;
        if (this.o) {
            button.setVisibility(0);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.bookmark_title_txtvew);
        this.A = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_bookmark));
        TextView textView3 = (TextView) view.findViewById(R.id.bookmark_edit_txtvew);
        this.s = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.edit));
        this.q = (ImageView) view.findViewById(R.id.bookmark_edit_ivew);
        this.B = (LinearLayout) view.findViewById(R.id.bookmark_edit_llayout);
        this.L = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        if ("1".equals(ConfigMgr.readPropertie("IsShowEditIconOrText", "0"))) {
            this.s.setVisibility(8);
            this.q.setVisibility(0);
        }
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        this.x = (RelativeLayout) view.findViewById(R.id.bookmark_edit_status_rlayout);
        TextView textView4 = (TextView) view.findViewById(R.id.selected_all_txtvew);
        this.t = textView4;
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_all));
        TextView textView5 = (TextView) view.findViewById(R.id.selected_num_txtvew);
        this.v = textView5;
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_num));
        TextView textView6 = (TextView) view.findViewById(R.id.cancel_edit_status_txtvew);
        this.u = textView6;
        textView6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel));
        this.C = (LinearLayout) view.findViewById(R.id.bookmark_cancel_edit_llayout);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        this.y = (FrameLayout) view.findViewById(R.id.bookmark_delete_flayout);
        TextView textView7 = (TextView) view.findViewById(R.id.bookmark_delete_txtvew);
        this.z = textView7;
        textView7.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.delete));
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        this.y.setVisibility(4);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.bookmark_delete_imgvew));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.bookmark_delete_txtvew));
        this.L = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        this.D = (DelSlideListView) view.findViewById(R.id.message_lv);
        this.M = (RelativeLayout) view.findViewById(R.id.rl_empty);
        com.zte.iptvclient.common.uiframe.f.a(this.D);
        com.zte.iptvclient.common.uiframe.f.a(this.M.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.M.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.M.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.M.findViewById(R.id.refresh_image));
        this.M.setVisibility(8);
        this.D.setVisibility(0);
        TextView textView8 = (TextView) this.M.findViewById(R.id.txt_pullrefresh);
        this.N = textView8;
        textView8.setText(this.h.getString(R.string.no_news_for_the_time_being));
        this.A.setText(getResources().getText(R.string.mes_msg_notice));
        this.u.setText(getResources().getText(R.string.titlebtn_edit_cancel));
        this.L.a(new DefaultRefreshHeader(this.h));
        this.L.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.L;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.L;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.L.a(true);
        this.L.c(false);
        this.L.b(false);
        this.L.a(new b());
    }

    private String e(String str, String str2) {
        int i2;
        String str3 = "";
        try {
            int indexOf = str.indexOf(str2);
            if (indexOf == -1) {
                return "";
            }
            String substring = str.substring(indexOf, str.length());
            int indexOf2 = substring.indexOf("&");
            if (indexOf2 == -1) {
                indexOf2 = substring.length();
            }
            int indexOf3 = substring.indexOf("=");
            if (indexOf3 == -1 || (i2 = indexOf3 + 1) > indexOf2) {
                return "";
            }
            str3 = substring.substring(i2, indexOf2).trim();
            LogEx.d(this.p, "outURL= " + str3);
            return str3;
        } catch (Exception e2) {
            LogEx.e(this.p, "getContentTypeFromUrl get Exception =" + e2.getMessage());
            com.zte.iptvclient.android.common.f.b.h.a().a(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "[msg_center_error]getContentTypeFromUrl:url=" + str + ",Exception=" + e2.getMessage());
            return str3;
        }
    }

    @Override // com.zte.iptvclient.android.mobile.f0.a.a.b
    public void o() {
        J();
    }

    private void a(List<MsgInfo> list) {
        if (list != null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (i2 != list.size() - 1) {
                    stringBuffer.append(list.get(i2).msgid + "or");
                } else {
                    stringBuffer.append(list.get(i2).msgid);
                }
            }
            this.J.b(stringBuffer.toString());
            J();
        }
    }

    private void a(int i2, int i3, int i4, int i5) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(i2, i3, i4, i5);
        DelSlideListView delSlideListView = this.D;
        if (delSlideListView != null) {
            delSlideListView.setLayoutParams(layoutParams);
        }
    }

    public int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void a(String str, MsgInfo msgInfo) {
        a(e(str, "contenttype="), e(str, "programcode="), e(str, "columncode="), msgInfo);
    }

    private void a(String str, String str2, String str3, MsgInfo msgInfo) {
        if (R.equals(str)) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            LogEx.d(this.p, "skiptoMovieDetilFragment");
            Bundle bundle = new Bundle();
            bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str2);
            bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, str3);
            Intent intent = new Intent(getActivity(), (Class<?>) HostActivity.class);
            bundle.putString("fragmenttype", "moviedetail");
            intent.putExtras(bundle);
            getActivity().startActivity(intent);
            return;
        }
        if (S.equals(str)) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            LogEx.d(this.p, "skiptoSeriesDetilFragment");
            Bundle bundle2 = new Bundle();
            bundle2.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str2);
            bundle2.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, str3);
            Intent intent2 = new Intent(getActivity(), (Class<?>) HostActivity.class);
            bundle2.putString("fragmenttype", "seriesdetail");
            intent2.putExtras(bundle2);
            getActivity().startActivity(intent2);
            return;
        }
        if (T.equals(str)) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.i(str2));
            return;
        }
        if (U.equals(str)) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            TvShowItem tvShowItem = new TvShowItem();
            tvShowItem.setId(str2);
            if (!this.K.b0().booleanValue()) {
                t.a((Context) this.h, false);
                return;
            } else {
                LogEx.d(this.p, "playTvod");
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.b0.c(tvShowItem.getId()));
                return;
            }
        }
        if (BaseApp.a(this.h)) {
            u.a(this.h, this, msgInfo.summary, msgInfo.msgTitle, msgInfo.timestamp, msgInfo.msgContent);
        } else {
            u.a(this.h, msgInfo.summary, msgInfo.msgTitle, msgInfo.timestamp, msgInfo.msgContent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        String str = this.F.get(i2).msgTitle;
        String str2 = this.F.get(i2).msgid;
        String str3 = this.F.get(i2).msgContent;
        if (!TextUtils.isEmpty(str2)) {
            this.J.c(str2);
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.p.a());
        }
        if (!TextUtils.isEmpty(str3)) {
            try {
                String[] split = str3.split(",");
                if (split.length > 1) {
                    String str4 = split[1];
                    if (s(str4).booleanValue()) {
                        if (BaseApp.a(this.h)) {
                            u.a(this.h, this, str, str4);
                        } else {
                            u.b(this.h, str, str4);
                        }
                    } else {
                        a(str4, this.F.get(i2));
                    }
                } else {
                    String str5 = split[0];
                    if (s(str5).booleanValue()) {
                        if (BaseApp.a(this.h)) {
                            u.a(this.h, this, str, str5);
                        } else {
                            u.b(this.h, str, str5);
                        }
                    } else {
                        a(str5, this.F.get(i2));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                LogEx.e(this.p, "Do MSG Content get Exception=" + e2.getMessage());
            }
        } else {
            LogEx.w(this.p, "MSG ContentUrl is null !!!");
        }
        o();
    }
}
