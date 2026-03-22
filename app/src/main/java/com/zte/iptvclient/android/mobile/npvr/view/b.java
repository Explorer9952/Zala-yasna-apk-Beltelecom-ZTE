package com.zte.iptvclient.android.mobile.npvr.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.tencent.mm.sdk.platformtools.Util;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.common.http.HttpConstant;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.impl.IIPTVLogin;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.k.o;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.common.player.activity.VOPlayerActivity;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.LeftSlideDeleteRecyclerview;
import com.zte.iptvclient.android.mobile.npvr.entity.GetNpvrPlayUrlEntity;
import com.zte.iptvclient.android.mobile.npvr.model.bean.AddNpvrResultBean;
import com.zte.iptvclient.android.mobile.npvr.model.bean.DeleteNpvrResultBean;
import com.zte.iptvclient.android.mobile.npvr.model.bean.NpvrBean;
import com.zte.iptvclient.android.mobile.npvr.model.bean.NpvrListBean;
import com.zte.iptvclient.android.mobile.npvr.view.a;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.video.ContentType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NpvrRecordingsFragment.java */
/* loaded from: classes.dex */
public class b extends com.zte.fragmentlib.b implements com.zte.iptvclient.android.mobile.p.c {
    private static final String b0 = b.class.getName();
    com.zte.iptvclient.android.mobile.npvr.view.a A;
    int B;
    int C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    private m O;
    private e P;
    private i Q;
    private h R;
    private j S;
    private com.zte.iptvclient.android.mobile.p.e.a T;
    private SmartRefreshLayout W;
    private RelativeLayout X;
    private TextView Y;
    private String Z;
    TextView q;
    Button r;
    TextView s;
    TextView t;
    ConstraintLayout u;
    ImageView v;
    TextView w;
    LeftSlideDeleteRecyclerview x;
    Spinner y;
    ArrayList<Integer> p = new ArrayList<>();
    ArrayList<NpvrBean> z = new ArrayList<>();
    private boolean U = true;
    private int V = 0;
    private f a0 = new f(this);

    /* compiled from: NpvrRecordingsFragment.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.D();
        }
    }

    /* compiled from: NpvrRecordingsFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.npvr.view.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewOnClickListenerC0321b implements View.OnClickListener {
        ViewOnClickListenerC0321b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogEx.d(b.b0, "Delete");
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            b.this.K();
        }
    }

    /* compiled from: NpvrRecordingsFragment.java */
    /* loaded from: classes.dex */
    class c implements com.scwang.smartrefresh.layout.d.c {
        c() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            b bVar = b.this;
            bVar.f(bVar.V);
        }
    }

    /* compiled from: NpvrRecordingsFragment.java */
    /* loaded from: classes.dex */
    public class e implements m {

        /* compiled from: NpvrRecordingsFragment.java */
        /* loaded from: classes.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b bVar = b.this;
                bVar.O = bVar.Q;
                b.this.O.a();
            }
        }

        public e() {
        }

        @Override // com.zte.iptvclient.android.mobile.npvr.view.b.m
        public void a() {
            b bVar = b.this;
            bVar.t.setTextColor(((com.zte.fragmentlib.b) bVar).h.getResources().getColor(R.color.recording_exit_text_color));
            b bVar2 = b.this;
            bVar2.s.setTextColor(((com.zte.fragmentlib.b) bVar2).h.getResources().getColor(R.color.recording_exit_text_color));
            b bVar3 = b.this;
            bVar3.t.setText(bVar3.G);
            b.this.t.setVisibility(0);
            b.this.t.setOnClickListener(new a());
            b.this.s.setVisibility(0);
            b.this.r.setVisibility(8);
            b.this.u.setVisibility(0);
            b.this.X.setVisibility(8);
            b.this.b(true);
            b.this.p.clear();
            b bVar4 = b.this;
            bVar4.s.setText(bVar4.D);
            b.this.y.setClickable(false);
            b.this.y.setFocusable(false);
            b.this.y.setEnabled(false);
            b.this.W.d(false);
            b.this.N();
        }
    }

    /* compiled from: NpvrRecordingsFragment.java */
    /* loaded from: classes.dex */
    private static final class f extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<b> f6905a;

        public f(b bVar) {
            this.f6905a = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            b bVar = this.f6905a.get();
            if (bVar == null) {
                return;
            }
            int i = message.what;
            if (i != 4097) {
                if (i != 4098) {
                    return;
                }
                ((com.zte.fragmentlib.b) bVar).h.d();
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(o.j().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.load_failed)));
                return;
            }
            GetNpvrPlayUrlEntity getNpvrPlayUrlEntity = (GetNpvrPlayUrlEntity) message.obj;
            String str = getNpvrPlayUrlEntity.f6885a;
            String str2 = getNpvrPlayUrlEntity.f6886b;
            int i2 = getNpvrPlayUrlEntity.f6887c;
            if (SDKLoginMgr.getInstance().getEPGHome().startsWith(HttpConstant.PROTOCOL_HTTPS)) {
                if (!TextUtils.isEmpty(str2)) {
                    NpvrBean npvrBean = bVar.z.get(i2);
                    npvrBean.setPlayUrl(str2);
                    bVar.a(npvrBean);
                } else {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(o.j().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.load_failed)));
                }
            } else if (!TextUtils.isEmpty(str)) {
                NpvrBean npvrBean2 = bVar.z.get(i2);
                npvrBean2.setPlayUrl(str);
                bVar.a(npvrBean2);
            } else {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(o.j().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.load_failed)));
            }
            ((com.zte.fragmentlib.b) bVar).h.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NpvrRecordingsFragment.java */
    /* loaded from: classes.dex */
    public class g extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private String f6906a;

        /* renamed from: b, reason: collision with root package name */
        private String f6907b;

        /* renamed from: c, reason: collision with root package name */
        private String f6908c;

        /* renamed from: d, reason: collision with root package name */
        private String f6909d;
        private String e;
        private String f;
        private String g;
        private String h;
        private int i;

        /* compiled from: NpvrRecordingsFragment.java */
        /* loaded from: classes.dex */
        class a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
            a() {
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                LogEx.d(b.b0, "queryNPVRPlayURL  onDataReturn, resultJson= " + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!jSONObject.getString("returncode").equals("0")) {
                        b.this.a0.sendEmptyMessage(4098);
                    } else {
                        GetNpvrPlayUrlEntity getNpvrPlayUrlEntity = new GetNpvrPlayUrlEntity();
                        String string = jSONObject.getString("playurl");
                        String string2 = jSONObject.getString("httpsplayurl");
                        getNpvrPlayUrlEntity.f6885a = string;
                        getNpvrPlayUrlEntity.f6886b = string2;
                        getNpvrPlayUrlEntity.f6887c = g.this.i;
                        LogEx.d(b.b0, "playurl = " + string);
                        LogEx.d(b.b0, "httpsplayurl = " + string2);
                        Message obtain = Message.obtain();
                        obtain.what = 4097;
                        obtain.obj = getNpvrPlayUrlEntity;
                        b.this.a0.sendMessage(obtain);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    b.this.a0.sendEmptyMessage(4098);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.d(b.b0, "queryNPVRPlayURL  onFailReturn,arg0= " + str + " ,arg1=" + i);
                b.this.a0.sendEmptyMessage(4098);
            }
        }

        public g(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
            this.f6906a = str;
            this.f6907b = str2;
            this.f6908c = str3;
            this.f6909d = str4;
            this.e = str5;
            this.f = str6;
            this.g = str7;
            this.h = str8;
            this.i = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
            sDKNetHTTPRequest.setHeader("Cookie", this.f6907b);
            sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, this.f6908c);
            sDKNetHTTPRequest.setParam("prevuecode", this.f6909d);
            sDKNetHTTPRequest.setParam("channelcode", this.e);
            sDKNetHTTPRequest.setParam("definition", this.f);
            sDKNetHTTPRequest.setParam("mediaservices", this.g);
            sDKNetHTTPRequest.setParam("npvrcode", this.h);
            LogEx.d(b.b0, "queryNPVRPlayURL  ");
            sDKNetHTTPRequest.startRequest(this.f6906a, HttpRequest.METHOD_GET, new a());
        }
    }

    /* compiled from: NpvrRecordingsFragment.java */
    /* loaded from: classes.dex */
    public class h implements m {
        public h() {
        }

        @Override // com.zte.iptvclient.android.mobile.npvr.view.b.m
        public void a() {
            b bVar = b.this;
            bVar.t.setTextColor(((com.zte.fragmentlib.b) bVar).h.getResources().getColor(R.color.recording_text));
            b bVar2 = b.this;
            bVar2.s.setTextColor(((com.zte.fragmentlib.b) bVar2).h.getResources().getColor(R.color.recording_exit_text_color));
            b.this.t.setVisibility(4);
            b.this.y.setClickable(false);
            b.this.y.setFocusable(false);
            b.this.y.setEnabled(false);
            b.this.X.setVisibility(0);
            b.this.s.setVisibility(8);
            b.this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_my_recording));
            b.this.r.setVisibility(0);
            b.this.u.setVisibility(8);
            b.this.b(false);
            b.this.p.clear();
            b.this.W.d(true);
        }
    }

    /* compiled from: NpvrRecordingsFragment.java */
    /* loaded from: classes.dex */
    public class i implements m {

        /* compiled from: NpvrRecordingsFragment.java */
        /* loaded from: classes.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b bVar = b.this;
                bVar.O = bVar.P;
                b.this.O.a();
            }
        }

        public i() {
        }

        @Override // com.zte.iptvclient.android.mobile.npvr.view.b.m
        public void a() {
            b bVar = b.this;
            bVar.t.setTextColor(((com.zte.fragmentlib.b) bVar).h.getResources().getColor(R.color.recording_text));
            b bVar2 = b.this;
            bVar2.s.setTextColor(((com.zte.fragmentlib.b) bVar2).h.getResources().getColor(R.color.recording_exit_text_color));
            b bVar3 = b.this;
            bVar3.t.setText(bVar3.F);
            b.this.t.setVisibility(0);
            b.this.t.setOnClickListener(new a());
            b.this.X.setVisibility(8);
            b.this.s.setVisibility(8);
            b.this.r.setVisibility(0);
            b.this.u.setVisibility(8);
            b.this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_my_recording));
            b.this.b(false);
            b.this.p.clear();
            b bVar4 = b.this;
            bVar4.s.setText(bVar4.D);
            b.this.y.setClickable(true);
            b.this.y.setFocusable(true);
            b.this.y.setEnabled(true);
            b.this.W.d(true);
        }
    }

    /* compiled from: NpvrRecordingsFragment.java */
    /* loaded from: classes.dex */
    public class j implements m {
        public j() {
        }

        @Override // com.zte.iptvclient.android.mobile.npvr.view.b.m
        public void a() {
            b bVar = b.this;
            bVar.t.setTextColor(((com.zte.fragmentlib.b) bVar).h.getResources().getColor(R.color.recording_text));
            b bVar2 = b.this;
            bVar2.s.setTextColor(((com.zte.fragmentlib.b) bVar2).h.getResources().getColor(R.color.recording_exit_text_color));
            b.this.t.setVisibility(4);
            b.this.y.setClickable(false);
            b.this.y.setFocusable(false);
            b.this.y.setEnabled(false);
            b.this.X.setVisibility(4);
            b.this.s.setVisibility(8);
            b.this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_my_recording));
            b.this.r.setVisibility(0);
            b.this.u.setVisibility(8);
            b.this.b(false);
            b.this.p.clear();
            b.this.W.d(true);
        }
    }

    /* compiled from: NpvrRecordingsFragment.java */
    /* loaded from: classes.dex */
    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogEx.d(b.b0, "Select All");
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            if (b.this.p.size() < b.this.z.size()) {
                b.this.L();
                return;
            }
            b.this.M();
            ArrayList<Integer> arrayList = b.this.p;
            if (arrayList != null) {
                arrayList.clear();
            }
        }
    }

    /* compiled from: NpvrRecordingsFragment.java */
    /* loaded from: classes.dex */
    class l implements AdapterView.OnItemSelectedListener {
        l() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            LogEx.d(b.b0, "mSortSpinner");
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            b.this.V = i;
            if (b.this.U) {
                b.this.U = false;
            } else {
                b bVar = b.this;
                bVar.f(bVar.V);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: NpvrRecordingsFragment.java */
    /* loaded from: classes.dex */
    public interface m {
        void a();
    }

    private void J() {
        if (this.z.size() > 0) {
            i iVar = this.Q;
            this.O = iVar;
            iVar.a();
        } else {
            h hVar = this.R;
            this.O = hVar;
            hVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        ArrayList<Integer> arrayList = this.p;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<Integer> it2 = this.p.iterator();
        while (it2.hasNext()) {
            Integer next = it2.next();
            LogEx.d(b0, "delete position = " + next);
            String prevuecode = this.z.get(next.intValue()).getPrevuecode();
            LogEx.d(b0, "delete prevuecode = " + prevuecode);
            this.T.c(prevuecode, "2");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        int size = this.z.size();
        this.p.clear();
        for (int i2 = 0; i2 < size; i2++) {
            this.p.add(Integer.valueOf(i2));
        }
        this.A.a(0, size, MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
        this.s.setText(this.E);
        N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        int size = this.z.size();
        this.p.clear();
        this.A.a(0, size, MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
        this.s.setText(this.D);
        N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        int size = this.p.size();
        this.q.setText(String.format(size > 1 ? this.M : this.N, Integer.valueOf(size)));
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        if (getActivity() instanceof MainActivity) {
            F();
            return false;
        }
        if (!(getActivity() instanceof HostActivity)) {
            return false;
        }
        getActivity().finish();
        return false;
    }

    @Override // com.zte.iptvclient.android.mobile.p.c
    public void a(AddNpvrResultBean addNpvrResultBean) {
    }

    @Override // com.zte.iptvclient.android.mobile.p.c
    public void b(String str, String str2) {
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.x.a(this.A);
        this.A.a(new d());
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Z = com.zte.iptvclient.android.common.i.a.a.a(R.string.login_set_language);
        this.D = com.zte.iptvclient.android.common.i.a.a.a(R.string.bottom_btn_selectall);
        this.E = com.zte.iptvclient.android.common.i.a.a.a(R.string.bottom_btn_cancelselect);
        this.F = com.zte.iptvclient.android.common.i.a.a.a(R.string.common_edit);
        this.G = com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel);
        this.J = com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_sort_by_time);
        this.K = com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_sort_by_title);
        this.L = com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_sort_by_channel);
        this.M = com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_nums);
        this.N = com.zte.iptvclient.android.common.i.a.a.a(R.string.bookmark_select_num);
        this.T = new com.zte.iptvclient.android.mobile.p.e.a(this, new com.zte.iptvclient.android.mobile.p.d.a());
        this.B = androidx.core.content.a.a(this.h, R.color.line_pagerindicator_light);
        this.C = androidx.core.content.a.a(this.h, R.color.recording_sort_text_unselect);
        if (getArguments() == null) {
            return;
        }
        this.A = new com.zte.iptvclient.android.mobile.npvr.view.a(this.h, false, this.z, this.p);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_npvr_recordings_layout, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.fragment_recording_shedules_top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        SupportActivity supportActivity = this.h;
        if (supportActivity != null && !BaseApp.a(supportActivity)) {
            com.zte.iptvclient.android.common.k.g.e(this.h);
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.fragment_recording_schedules_title_txt);
        this.q = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_my_recording));
        Button button = (Button) inflate.findViewById(R.id.fragment_recording_schedules_btn_back);
        this.r = button;
        button.setOnClickListener(new a());
        TextView textView3 = (TextView) inflate.findViewById(R.id.fragment_recording_schedules_selectall_txt);
        this.s = textView3;
        textView3.setOnClickListener(new k());
        this.t = (TextView) inflate.findViewById(R.id.fragment_recording_schedules_edit_txt);
        this.u = (ConstraintLayout) inflate.findViewById(R.id.fragment_recording_schedules_bottom_delete_cl);
        this.v = (ImageView) inflate.findViewById(R.id.delete_img);
        TextView textView4 = (TextView) inflate.findViewById(R.id.delete_txt);
        this.w = textView4;
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.delete));
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.fragment_recording_shedules_header_rl));
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        this.u.setOnClickListener(new ViewOnClickListenerC0321b());
        LeftSlideDeleteRecyclerview leftSlideDeleteRecyclerview = (LeftSlideDeleteRecyclerview) inflate.findViewById(R.id.fragment_recording_schedules_recyclerview);
        this.x = leftSlideDeleteRecyclerview;
        com.zte.iptvclient.common.uiframe.f.a(leftSlideDeleteRecyclerview);
        this.x.a(new CustomCatchExceptionLayoutManager(this.h, 1, false));
        this.y = (Spinner) inflate.findViewById(R.id.fragment_recording_schedules_sort_spinner);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.J);
        arrayList.add(this.K);
        arrayList.add(this.L);
        this.y.setAdapter((SpinnerAdapter) new com.zte.iptvclient.android.mobile.npvr.view.c(this.h, this.y, arrayList, this.B, this.C));
        this.y.setOnItemSelectedListener(new l());
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) inflate.findViewById(R.id.fragment_npvr_recording_refreshlayout);
        this.W = smartRefreshLayout;
        com.zte.iptvclient.common.uiframe.f.a(smartRefreshLayout);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rl_empty);
        this.X = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
        this.X.setVisibility(8);
        TextView textView5 = (TextView) inflate.findViewById(R.id.txt_pullrefresh);
        this.Y = textView5;
        com.zte.iptvclient.common.uiframe.f.a(textView5);
        this.Y.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_no_recording_data));
        if (this.h != null) {
            this.W.a(new DefaultRefreshHeader(this.h));
            this.W.a(new DefaultRefreshFooter(this.h));
            this.W.d(true);
            this.W.b(false);
            this.W.c(false);
            SmartRefreshLayout smartRefreshLayout2 = this.W;
            SupportActivity supportActivity2 = this.h;
            smartRefreshLayout2.e(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_footer_height)));
            SmartRefreshLayout smartRefreshLayout3 = this.W;
            SupportActivity supportActivity3 = this.h;
            smartRefreshLayout3.f(com.zte.iptvclient.android.common.k.g.a(supportActivity3, supportActivity3.getResources().getDimension(R.dimen.refresh_header_height)));
            this.W.a(new c());
        }
        this.S = new j();
        this.Q = new i();
        this.P = new e();
        this.R = new h();
        j jVar = this.S;
        this.O = jVar;
        jVar.a();
        f(0);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
        this.T.c(this.z.get(i2).getPrevuecode(), this.z.get(i2).getMediaservice());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i2) {
        if (i2 == 0) {
            g(4);
        } else if (i2 == 1) {
            g(2);
        } else {
            if (i2 != 2) {
                return;
            }
            g(1);
        }
    }

    private void g(int i2) {
        this.T.a("1", "500", "3", i2 + "", null, this.Z, null);
    }

    private void h(int i2) {
        ArrayList<Channel> b2 = com.zte.iptvclient.android.common.j.i.d().b();
        if (b2 == null || i2 >= this.z.size()) {
            return;
        }
        Iterator<Channel> it2 = b2.iterator();
        while (it2.hasNext()) {
            Channel next = it2.next();
            if (TextUtils.equals(next.getChannelcode(), this.z.get(i2).getChannelcode())) {
                this.z.get(i2).setAllowNetType(next.getAllownettype());
                this.z.get(i2).setRatingid(next.getRatingid());
                this.z.get(i2).setSystemlimitenable(next.getSystemlimitenable());
                this.z.get(i2).setMixno(next.getUsermixno());
                return;
            }
        }
    }

    @Override // com.zte.iptvclient.android.mobile.p.c
    public void l(String str) {
        LogEx.d(b0, "query schedule list failed, errormsg = " + str);
        J();
        this.W.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        if (i2 >= this.z.size()) {
            return;
        }
        if (!TextUtils.equals(this.z.get(i2).getMediaservice(), "2")) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.h.getResources().getString(R.string.npvr_error_msg));
            return;
        }
        if (TextUtils.equals(this.z.get(i2).getStatus(), WeiboAuthException.DEFAULT_AUTH_ERROR_CODE)) {
            return;
        }
        h(i2);
        this.h.q();
        String prevuecode = this.z.get(i2).getPrevuecode();
        String channelcode = this.z.get(i2).getChannelcode();
        String npvrcode = this.z.get(i2).getNpvrcode();
        String mediaservice = this.z.get(i2).getMediaservice();
        new g("http://{epgdomain}/iptvepg/{frame}/sdk_getnpvrplayurl.jsp".replace("http://{epgdomain}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f()), com.zte.iptvclient.android.common.f.b.i.h(), "gbk", prevuecode, channelcode, this.z.get(i2).getDefinition(), mediaservice, npvrcode, i2).start();
    }

    /* compiled from: NpvrRecordingsFragment.java */
    /* loaded from: classes.dex */
    class d implements a.f {
        d() {
        }

        @Override // com.zte.iptvclient.android.mobile.npvr.view.a.f
        public void a(int i) {
            LogEx.d(b.b0, "onItemDelete");
            b.this.p.clear();
            b.this.p.add(Integer.valueOf(i));
            b.this.e(i);
        }

        @Override // com.zte.iptvclient.android.mobile.npvr.view.a.f
        public void b(int i) {
            LogEx.d(b.b0, "onItemClick");
            b.this.d(i);
        }

        @Override // com.zte.iptvclient.android.mobile.npvr.view.a.f
        public void a(int i, boolean z) {
            LogEx.d(b.b0, "onItemSelect");
            b.this.a(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        com.zte.iptvclient.android.mobile.npvr.view.a aVar = this.A;
        if (aVar == null || aVar.e() == z) {
            return;
        }
        this.A.b(z);
        this.A.a(0, this.z.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NpvrBean npvrBean) {
        Bundle bundle = new Bundle();
        try {
            String playUrl = npvrBean.getPlayUrl();
            String definition = npvrBean.getDefinition();
            bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, npvrBean.getPlayUrl());
            bundle.putString("contentcode", npvrBean.getPrevuecode());
            String begintime = npvrBean.getBegintime();
            bundle.putString("prevuebegintime", begintime);
            String endtime = npvrBean.getEndtime();
            bundle.putString("prevueendtime", endtime);
            bundle.putString(ParamConst.NPVR_QUERY_RSP_DURATION, x.c(begintime, "yyyy.MM.dd HH:mm:ss", "HH:mm", 1) + "-" + x.c(endtime, "yyyy.MM.dd HH:mm:ss", "HH:mm", 1));
            bundle.putString("channelcode", npvrBean.getChannelcode());
            bundle.putString("prevue_name", npvrBean.getPrevuename());
            bundle.putString("tv_name", npvrBean.getChannelname());
            bundle.putString("usermixno", npvrBean.getMixno());
            bundle.putString("tv_id", npvrBean.getChannelcode());
            LogEx.d(b0, "allownettype=" + npvrBean.getAllowNetType());
            bundle.putString("definition", npvrBean.getDefinition());
            bundle.putString("allownettype", npvrBean.getAllowNetType());
            if ("1".equals(definition)) {
                bundle.putString("url_sd", playUrl);
            } else if ("2".equals(definition)) {
                bundle.putString("url_sd_h", playUrl);
            } else if ("4".equals(definition)) {
                bundle.putString("url_hd", playUrl);
            } else if ("8".equals(definition)) {
                bundle.putString("url_480p", playUrl);
            } else if (GlobalConst.WINPHONE_CLIENT.equals(definition)) {
                bundle.putString("url_720p", playUrl);
            } else if (GlobalConst.ANDRIODSTB_CLIENT.equals(definition)) {
                bundle.putString("url_1280p", playUrl);
            } else {
                bundle.putString("url_sd", playUrl);
            }
            bundle.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_TVOD.getIntValue()));
            bundle.putBoolean("support_share", false);
            bundle.putBoolean("support_push", false);
            bundle.putBoolean("PlayHelperCheck", true);
            bundle.putString("ratingid", npvrBean.getRatingid());
            bundle.putString("prevueratingid", npvrBean.getPrevueRating());
            bundle.putString("systemlimitenable", npvrBean.getSystemlimitenable());
            Intent intent = new Intent();
            intent.putExtras(bundle);
            intent.setClass(this.h, VOPlayerActivity.class);
            intent.addFlags(268435456);
            this.h.startActivity(intent);
            this.h.d();
        } catch (Exception e2) {
            LogEx.e(b0, e2.getMessage());
        }
    }

    @Override // com.zte.iptvclient.android.mobile.p.c
    public void d(String str, String str2) {
        LogEx.d(b0, "showDeleteNpvrFailed errorMsg = " + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, boolean z) {
        if (z) {
            LogEx.d(b0, "isSelected == true: position = " + i2);
            Iterator<Integer> it2 = this.p.iterator();
            while (it2.hasNext()) {
                if (it2.next().intValue() == i2) {
                    return;
                }
            }
            this.p.add(Integer.valueOf(i2));
            if (this.p.size() == this.z.size()) {
                this.s.setText(this.E);
            }
            Collections.sort(this.p);
            N();
            return;
        }
        LogEx.d(b0, "isSelected == false: position = " + i2);
        Iterator<Integer> it3 = this.p.iterator();
        while (it3.hasNext()) {
            Integer next = it3.next();
            if (next.intValue() == i2) {
                this.p.remove(next);
                this.s.setText(this.D);
                N();
                return;
            }
        }
    }

    @Override // com.zte.iptvclient.android.mobile.p.c
    public void a(NpvrListBean npvrListBean) {
        if (BaseApp.a(this.h)) {
            com.zte.iptvclient.common.uiframe.f.a(Util.BYTE_OF_KB, 768);
        } else {
            com.zte.iptvclient.common.uiframe.f.a(480, 800);
        }
        com.zte.iptvclient.common.uiframe.f.a(this.h);
        this.z.clear();
        this.z.addAll(npvrListBean.getDataList());
        this.A.d();
        J();
        this.W.a();
    }

    @Override // com.zte.iptvclient.android.mobile.p.c
    public void a(DeleteNpvrResultBean deleteNpvrResultBean) {
        if (this.p.size() > 0) {
            this.s.setText(this.D);
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.z.size()) {
                break;
            }
            if (deleteNpvrResultBean.getPrevuecode().equals(this.z.get(i2).getPrevuecode())) {
                this.z.remove(i2);
                this.A.d(i2);
                this.A.a(0, this.z.size());
                break;
            }
            i2++;
        }
        this.p.clear();
        if (this.z.size() <= 0) {
            h hVar = this.R;
            this.O = hVar;
            hVar.a();
        } else if (this.u.getVisibility() == 0) {
            N();
        }
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.k());
    }
}
