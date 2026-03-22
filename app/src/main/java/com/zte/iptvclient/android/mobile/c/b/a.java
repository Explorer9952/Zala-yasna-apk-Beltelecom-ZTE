package com.zte.iptvclient.android.mobile.c.b;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.share.internal.ShareConstants;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.e.x.p;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.common.reminder.AlarmVideoBean;
import com.zte.iptvclient.android.common.reminder.EPGServerTvReminderBean;
import com.zte.iptvclient.android.common.reminder.TvReminderManager;
import com.zte.iptvclient.android.common.reminder.VodReminderManager;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.booking.ui.ItemRemoveRecyclerView;
import com.zte.iptvclient.android.zala.R;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: BookingFragment.java */
/* loaded from: classes.dex */
public class a extends com.zte.fragmentlib.b {
    private TextView A;
    private TextView B;
    private TextView C;
    private ImageView D;
    private ImageView E;
    private ImageView F;
    private ItemRemoveRecyclerView G;
    private ItemRemoveRecyclerView J;
    private ItemRemoveRecyclerView K;
    private LinkedHashMap<Integer, String> L;
    private LinkedHashMap<Integer, String> M;
    private com.zte.iptvclient.android.mobile.booking.ui.a N;
    private com.zte.iptvclient.android.mobile.booking.ui.a O;
    private Activity P;
    private List<EPGServerTvReminderBean> Q;
    private List<PrevueBean> R;
    private List<AlarmVideoBean> S;
    private ArrayList<com.zte.iptvclient.android.common.reminder.a> T;
    private RelativeLayout U;
    private TextView V;
    private int W = 0;
    private ProgressDialog X;
    private SmartRefreshLayout Y;
    private com.zte.iptvclient.android.mobile.c.a.c p;
    private com.zte.iptvclient.android.mobile.c.a.a q;
    private com.zte.iptvclient.android.mobile.c.a.d r;
    private com.zte.iptvclient.android.mobile.c.a.b s;
    private Button t;
    private RelativeLayout u;
    private RelativeLayout v;
    private RelativeLayout w;
    private RelativeLayout x;
    private RelativeLayout y;
    private TextView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BookingFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.c.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0191a implements View.OnClickListener {
        ViewOnClickListenerC0191a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.getActivity() instanceof MainActivity) {
                a.this.F();
            } else if (a.this.getActivity() instanceof HostActivity) {
                a.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BookingFragment.java */
    /* loaded from: classes.dex */
    public class b implements com.scwang.smartrefresh.layout.d.c {
        b() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            if (a.this.W == 0) {
                a.this.R();
            } else if (a.this.W == 1) {
                a.this.S();
            } else if (a.this.W == 2) {
                a.this.T();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BookingFragment.java */
    /* loaded from: classes.dex */
    public class c implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        c() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("BookingFragment", "sdkDoEPGServerTvReminder data return : " + str);
            try {
                if (new JSONObject(str).getString("returncode").equals("0")) {
                    a.this.P();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("BookingFragment", "returncode is " + i + " , errormsg is " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BookingFragment.java */
    /* loaded from: classes.dex */
    public class d implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        d() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("BookingFragment", "sdkDoEPGServerSeriesReminder data return : " + str);
            try {
                if (new JSONObject(str).getString("returncode").equals("0")) {
                    a.this.Q();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("BookingFragment", "returncode is " + i + " , errormsg is " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BookingFragment.java */
    /* loaded from: classes.dex */
    public class e implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        e() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("BookingFragment", "sdkQueryEPGServerTvReminderList data return : " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                ArrayList arrayList = new ArrayList();
                if (!jSONObject.getString("returncode").equals("0")) {
                    a.this.J();
                    a.this.Y.a();
                    return;
                }
                JSONArray jSONArray = jSONObject.getJSONArray("reminders");
                for (int i = 0; i < jSONArray.length(); i++) {
                    com.zte.iptvclient.android.common.reminder.c cVar = new com.zte.iptvclient.android.common.reminder.c();
                    cVar.b(jSONArray.getJSONObject(i).getString("contentcode"));
                    cVar.a(jSONArray.getJSONObject(i).getString("channelcode"));
                    arrayList.add(cVar);
                }
                a.this.b((ArrayList<com.zte.iptvclient.android.common.reminder.c>) arrayList);
            } catch (Exception e) {
                e.printStackTrace();
                a.this.J();
                a.this.J.setVisibility(8);
                a.this.U.setVisibility(0);
                a.this.Y.a();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("BookingFragment", "sdkQueryEPGServerTvReminderList onFailReturn ,returncode : " + i + " , errormsg : " + str);
            a.this.J();
            a.this.J.setVisibility(8);
            a.this.U.setVisibility(0);
            a.this.Y.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BookingFragment.java */
    /* loaded from: classes.dex */
    public class f implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* compiled from: BookingFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.c.b.a$f$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0192a implements com.zte.iptvclient.android.mobile.c.c.a {
            C0192a() {
            }

            @Override // com.zte.iptvclient.android.mobile.c.c.a
            public void a(int i) {
                a aVar = a.this;
                aVar.b((EPGServerTvReminderBean) aVar.Q.get(i), false);
            }

            @Override // com.zte.iptvclient.android.mobile.c.c.a
            public void a(View view, int i) {
            }
        }

        f() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            f fVar = this;
            StringBuilder sb = new StringBuilder();
            String str2 = "posterimage";
            sb.append(" sdkQueryTvReminderList onDataReturn : ");
            sb.append(str);
            LogEx.d("BookingFragment", sb.toString());
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("returncode").equals("0")) {
                    if (a.this.Q != null) {
                        a.this.Q.clear();
                    } else {
                        a.this.Q = new ArrayList();
                    }
                    JSONArray jSONArray = jSONObject.getJSONArray(ParamConst.BATCH_PREVUE_LIST_RSP_ITEM);
                    int i = 0;
                    while (i < jSONArray.length()) {
                        EPGServerTvReminderBean ePGServerTvReminderBean = new EPGServerTvReminderBean();
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            JSONArray jSONArray2 = jSONArray;
                            if (jSONObject2.has("prevuecode")) {
                                ePGServerTvReminderBean.setPrevuecode(jSONObject2.getString("prevuecode"));
                            }
                            if (jSONObject2.has("prevuename")) {
                                ePGServerTvReminderBean.setPrevuename(jSONObject2.getString("prevuename"));
                            }
                            if (jSONObject2.has("telecomcode")) {
                                ePGServerTvReminderBean.setTelecomcode(jSONObject2.getString("telecomcode"));
                            }
                            if (jSONObject2.has("isprotection")) {
                                ePGServerTvReminderBean.setIsprotection(jSONObject2.getString("isprotection"));
                            }
                            if (jSONObject2.has("channelcode")) {
                                ePGServerTvReminderBean.setChannelcode(jSONObject2.getString("channelcode"));
                            }
                            if (jSONObject2.has("channelname")) {
                                ePGServerTvReminderBean.setChannelname(jSONObject2.getString("channelname"));
                            }
                            if (jSONObject2.has("columncode")) {
                                ePGServerTvReminderBean.setColumncode(jSONObject2.getString("columncode"));
                            }
                            if (jSONObject2.has("mixno")) {
                                ePGServerTvReminderBean.setMixno(jSONObject2.getString("mixno"));
                            }
                            if (jSONObject2.has("definition")) {
                                ePGServerTvReminderBean.setDefinition(jSONObject2.getString("definition"));
                            }
                            if (jSONObject2.has("start_time")) {
                                ePGServerTvReminderBean.setStart_time(jSONObject2.getString("start_time"));
                            }
                            if (jSONObject2.has("end_time")) {
                                ePGServerTvReminderBean.setEnd_time(jSONObject2.getString("end_time"));
                            }
                            if (jSONObject2.has("file_status")) {
                                ePGServerTvReminderBean.setFile_status(jSONObject2.getString("file_status"));
                            }
                            String str3 = str2;
                            if (jSONObject2.has(str3)) {
                                ePGServerTvReminderBean.setPosterimage(jSONObject2.getString(str3));
                            }
                            fVar = this;
                            str2 = str3;
                            a.this.Q.add(ePGServerTvReminderBean);
                            i++;
                            jSONArray = jSONArray2;
                        } catch (Exception e) {
                            e = e;
                            fVar = this;
                            e.printStackTrace();
                            a.this.J();
                            a.this.J.setVisibility(8);
                            a.this.U.setVisibility(0);
                            a.this.Y.a();
                        }
                    }
                    a.this.M();
                    if (a.this.N != null) {
                        a.this.J.b(a.this.N);
                    }
                    a.this.N = new com.zte.iptvclient.android.mobile.booking.ui.a(a.this.P, a.this.L);
                    a.this.J.a(a.this.N);
                    if (a.this.p == null) {
                        a.this.q = new com.zte.iptvclient.android.mobile.c.a.a(a.this.P, a.this.Q);
                        a.this.J.a(new LinearLayoutManager(a.this.P));
                        a.this.J.a(a.this.q);
                        a.this.J.a(2, new C0192a());
                    }
                }
                a.this.J();
                if (a.this.Q.size() == 0) {
                    a.this.J.setVisibility(8);
                    a.this.U.setVisibility(0);
                } else {
                    a.this.J.setVisibility(0);
                    a.this.U.setVisibility(8);
                }
            } catch (Exception e2) {
                e = e2;
            }
            a.this.Y.a();
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("BookingFragment", " sdkQueryTvReminderList onFailReturn , returncode : " + i + " ,  errormsg : " + str);
            a.this.J();
            a.this.J.setVisibility(8);
            a.this.U.setVisibility(0);
            a.this.Y.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BookingFragment.java */
    /* loaded from: classes.dex */
    public class g implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        g() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("BookingFragment", "sdkQueryEPGServerVodReminderList data return : " + str);
            if (a.this.T != null) {
                a.this.T.clear();
            } else {
                a.this.T = new ArrayList();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("returncode").equals("0")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("binge-watchings");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        com.zte.iptvclient.android.common.reminder.a aVar = new com.zte.iptvclient.android.common.reminder.a();
                        if (jSONObject2.has("type")) {
                            aVar.f(jSONObject2.getString("type"));
                        }
                        if (jSONObject2.has("contentcode")) {
                            aVar.b(jSONObject2.getString("contentcode"));
                        }
                        if (jSONObject2.has("columncode")) {
                            aVar.a(jSONObject2.getString("columncode"));
                        }
                        if (jSONObject2.has("updatetime")) {
                            aVar.g(jSONObject2.getString("updatetime"));
                        }
                        if (jSONObject2.has("description")) {
                            aVar.d(jSONObject2.getString("description"));
                        }
                        a.this.T.add(aVar);
                    }
                    a.this.c((ArrayList<com.zte.iptvclient.android.common.reminder.a>) a.this.T);
                }
            } catch (Exception e) {
                e.printStackTrace();
                a.this.J();
                a.this.G.setVisibility(8);
                a.this.U.setVisibility(0);
                a.this.Y.a();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("BookingFragment", "sdkQueryEPGServerVodReminderList onFailReturn, returncode :" + i + " , errormsg : " + str);
            a.this.J();
            a.this.G.setVisibility(8);
            a.this.U.setVisibility(0);
            a.this.Y.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BookingFragment.java */
    /* loaded from: classes.dex */
    public class h implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f5607a;

        /* compiled from: BookingFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.c.b.a$h$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0193a implements com.zte.iptvclient.android.mobile.c.c.a {
            C0193a() {
            }

            @Override // com.zte.iptvclient.android.mobile.c.c.a
            public void a(int i) {
                a aVar = a.this;
                aVar.b((com.zte.iptvclient.android.common.reminder.a) aVar.T.get(i), false);
            }

            @Override // com.zte.iptvclient.android.mobile.c.c.a
            public void a(View view, int i) {
            }
        }

        h(ArrayList arrayList) {
            this.f5607a = arrayList;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("BookingFragment", " sdkQueryVodReminderList onDataReturn : " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("returncode").equals("0")) {
                    JSONArray jSONArray = jSONObject.getJSONArray(ParamConst.BATCH_PREVUE_LIST_RSP_ITEM);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2.has("telecomcode")) {
                            ((com.zte.iptvclient.android.common.reminder.a) this.f5607a.get(i)).c(jSONObject2.getString("telecomcode"));
                        }
                        if (jSONObject2.has("telecomcode")) {
                            ((com.zte.iptvclient.android.common.reminder.a) this.f5607a.get(i)).c(jSONObject2.getString("telecomcode"));
                        }
                        if (jSONObject2.has("programname")) {
                            ((com.zte.iptvclient.android.common.reminder.a) this.f5607a.get(i)).e(jSONObject2.getString("programname"));
                        }
                        if (jSONObject2.has("columnname")) {
                            ((com.zte.iptvclient.android.common.reminder.a) this.f5607a.get(i)).e(jSONObject2.getString("columnname"));
                        }
                        if (jSONObject2.has("columncode")) {
                            ((com.zte.iptvclient.android.common.reminder.a) this.f5607a.get(i)).a(jSONObject2.getString("columncode"));
                        }
                        if (jSONObject2.has("columncode")) {
                            ((com.zte.iptvclient.android.common.reminder.a) this.f5607a.get(i)).a(jSONObject2.getString("columncode"));
                        }
                    }
                    if (a.this.s == null) {
                        a.this.s = new com.zte.iptvclient.android.mobile.c.a.b(a.this.P, this.f5607a);
                        a.this.G.a(new LinearLayoutManager(a.this.P));
                        a.this.G.a(a.this.s);
                        a.this.G.a(3, new C0193a());
                    }
                    a.this.J();
                    if (this.f5607a == null || this.f5607a.size() <= 0) {
                        a.this.G.setVisibility(8);
                        a.this.U.setVisibility(0);
                    } else {
                        a.this.G.setVisibility(0);
                        a.this.U.setVisibility(8);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                a.this.J();
                a.this.G.setVisibility(8);
                a.this.U.setVisibility(0);
            }
            a.this.Y.a();
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("BookingFragment", " sdkQueryVodReminderList onFailReturn , returncode : " + i + " ,  errormsg : " + str);
            a.this.J();
            a.this.G.setVisibility(8);
            a.this.U.setVisibility(0);
            a.this.Y.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BookingFragment.java */
    /* loaded from: classes.dex */
    public class i implements com.zte.iptvclient.android.mobile.c.c.a {
        i() {
        }

        @Override // com.zte.iptvclient.android.mobile.c.c.a
        public void a(int i) {
            a.this.p.e(i);
            a.this.N();
            if (a.this.N != null) {
                a.this.J.b(a.this.N);
            }
            a.this.N = new com.zte.iptvclient.android.mobile.booking.ui.a(a.this.P, a.this.L);
            a.this.J.a(a.this.N);
            if (a.this.R == null || a.this.R.size() == 0) {
                a.this.J.setVisibility(8);
                a.this.U.setVisibility(0);
            }
        }

        @Override // com.zte.iptvclient.android.mobile.c.c.a
        public void a(View view, int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BookingFragment.java */
    /* loaded from: classes.dex */
    public class j implements com.zte.iptvclient.android.mobile.c.c.a {
        j() {
        }

        @Override // com.zte.iptvclient.android.mobile.c.c.a
        public void a(int i) {
            a.this.r.e(i);
            a.this.O();
            if (a.this.O != null) {
                a.this.K.b(a.this.O);
            }
            a.this.O = new com.zte.iptvclient.android.mobile.booking.ui.a(a.this.P, a.this.M);
            a.this.K.a(a.this.O);
        }

        @Override // com.zte.iptvclient.android.mobile.c.c.a
        public void a(View view, int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BookingFragment.java */
    /* loaded from: classes.dex */
    public class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.T();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BookingFragment.java */
    /* loaded from: classes.dex */
    public class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.S();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BookingFragment.java */
    /* loaded from: classes.dex */
    public class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.R();
        }
    }

    private String I() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("usertoken", com.zte.iptvclient.common.uiframe.a.d("UserToken"));
            jSONObject.put("usercode", com.zte.iptvclient.common.uiframe.a.d("UserID"));
            jSONObject.put("sorttype", 1);
            jSONObject.put("authinfo", com.zte.iptvclient.android.common.k.g.a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        LogEx.d("BookingFragment", "convertToQueryJsonParams : " + jSONObject.toString());
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.X.dismiss();
    }

    private void K() {
        this.L = new LinkedHashMap<>();
        this.M = new LinkedHashMap<>();
        this.T = new ArrayList<>();
    }

    private void L() {
        List<AlarmVideoBean> list = this.S;
        if (list == null) {
            this.S = new ArrayList();
        } else {
            list.clear();
        }
        List<AlarmVideoBean> b2 = VodReminderManager.b();
        for (int i2 = 0; i2 < b2.size(); i2++) {
            AlarmVideoBean alarmVideoBean = b2.get(i2);
            if (!TextUtils.isEmpty(alarmVideoBean.getId()) && !b(alarmVideoBean)) {
                this.S.add(alarmVideoBean);
            }
        }
        O();
        com.zte.iptvclient.android.mobile.booking.ui.a aVar = this.O;
        if (aVar != null) {
            this.K.b(aVar);
        }
        com.zte.iptvclient.android.mobile.booking.ui.a aVar2 = new com.zte.iptvclient.android.mobile.booking.ui.a(this.P, this.M);
        this.O = aVar2;
        this.K.a(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        this.L.clear();
        if (this.Q.size() == 0) {
            return;
        }
        a(0, a(this.Q.get(0)));
        for (int i2 = 1; i2 < this.Q.size(); i2++) {
            String a2 = a(this.Q.get(i2 - 1));
            String a3 = a(this.Q.get(i2));
            if (a2 != null && a3 != null && !a2.equalsIgnoreCase(a3)) {
                a(i2, a3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.L.clear();
        List<PrevueBean> list = this.R;
        if (list == null || list.size() == 0) {
            return;
        }
        a(0, a(this.R.get(0)));
        for (int i2 = 1; i2 < this.R.size(); i2++) {
            if (!a(this.R.get(i2 - 1)).equalsIgnoreCase(a(this.R.get(i2)))) {
                a(i2, a(this.R.get(i2)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        this.M.clear();
        if (this.S.size() == 0) {
            return;
        }
        b(0, a(this.S.get(0)));
        for (int i2 = 1; i2 < this.S.size(); i2++) {
            String a2 = a(this.S.get(i2 - 1));
            String a3 = a(this.S.get(i2));
            if (a2 != null && a3 != null && !a2.equalsIgnoreCase(a3)) {
                b(i2, a3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        String replace = "http://{epgdomain}/iptvepg/serviceapi?servicetype=reminderquery".replace("http://{epgdomain}", com.zte.iptvclient.android.common.f.b.i.b());
        LogEx.d("BookingFragment", "sdkQueryEPGServerTvReminderList url is : " + replace);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json; charset=GBK");
        sDKNetHTTPRequest.setBody(I());
        sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_POST, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        String replace = "http://{epgdomain}/iptvepg/serviceapi?servicetype=binge-watchingquery".replace("http://{epgdomain}", com.zte.iptvclient.android.common.f.b.i.b());
        LogEx.d("BookingFragment", "sdkQueryEPGServerVodReminderList url is : " + replace);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json; charset=GBK");
        sDKNetHTTPRequest.setBody(I());
        sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_POST, new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        this.A.setTextColor(c.a.a.a.d.b.d().b(R.color.mine_bookingtitle_textcolor_focus));
        this.h.a(this.A, "textColor", R.color.mine_bookingtitle_textcolor_focus);
        this.D.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.mine_bookingtitle_bottomline_focus));
        this.h.a(this.D, "background", R.color.mine_bookingtitle_bottomline_focus);
        this.B.setTextColor(c.a.a.a.d.b.d().b(R.color.mine_booking_title_textcolor));
        this.h.a(this.B, "textColor", R.color.mine_booking_title_textcolor);
        this.E.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.mine_bookingtitle_bottomline_normal));
        this.h.a(this.E, "background", R.color.mine_bookingtitle_bottomline_normal);
        this.C.setTextColor(c.a.a.a.d.b.d().b(R.color.mine_booking_title_textcolor));
        this.h.a(this.C, "textColor", R.color.mine_booking_title_textcolor);
        this.F.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.mine_bookingtitle_bottomline_normal));
        this.h.a(this.C, "background", R.color.mine_bookingtitle_bottomline_normal);
        this.G.setVisibility(8);
        this.J.setVisibility(8);
        this.K.setVisibility(8);
        this.U.setVisibility(8);
        this.W = 0;
        String readPropertie = ConfigMgr.readPropertie("SupportOrderReminderType");
        if (TextUtils.isEmpty(readPropertie) || (Integer.valueOf(readPropertie).intValue() & 8) <= 0) {
            return;
        }
        V();
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        this.A.setTextColor(c.a.a.a.d.b.d().b(R.color.mine_booking_title_textcolor));
        this.h.a(this.A, "textColor", R.color.mine_booking_title_textcolor);
        this.D.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.mine_bookingtitle_bottomline_normal));
        this.h.a(this.D, "background", R.color.mine_bookingtitle_bottomline_normal);
        this.B.setTextColor(c.a.a.a.d.b.d().b(R.color.mine_bookingtitle_textcolor_focus));
        this.h.a(this.B, "textColor", R.color.mine_bookingtitle_textcolor_focus);
        this.E.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.mine_bookingtitle_bottomline_focus));
        this.h.a(this.E, "background", R.color.mine_bookingtitle_bottomline_focus);
        this.C.setTextColor(c.a.a.a.d.b.d().b(R.color.mine_booking_title_textcolor));
        this.h.a(this.C, "textColor", R.color.mine_booking_title_textcolor);
        this.F.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.mine_bookingtitle_bottomline_normal));
        this.h.a(this.C, "background", R.color.mine_bookingtitle_bottomline_normal);
        this.G.setVisibility(8);
        this.J.setVisibility(8);
        this.K.setVisibility(8);
        this.U.setVisibility(8);
        this.W = 1;
        String readPropertie = ConfigMgr.readPropertie("SupportOrderReminderType");
        if (TextUtils.isEmpty(readPropertie)) {
            return;
        }
        int intValue = Integer.valueOf(readPropertie).intValue();
        if ((intValue & 1) <= 0) {
            if ((intValue & 4) > 0) {
                V();
                P();
                return;
            }
            return;
        }
        V();
        this.R = TvReminderManager.d();
        N();
        com.zte.iptvclient.android.mobile.booking.ui.a aVar = this.N;
        if (aVar != null) {
            this.J.b(aVar);
        }
        com.zte.iptvclient.android.mobile.booking.ui.a aVar2 = new com.zte.iptvclient.android.mobile.booking.ui.a(this.P, this.L);
        this.N = aVar2;
        this.J.a(aVar2);
        if (this.p == null) {
            this.p = new com.zte.iptvclient.android.mobile.c.a.c(this.P, this.R);
            this.J.a(new LinearLayoutManager(this.P));
            this.J.a(this.p);
            this.J.a(0, new i());
        }
        J();
        List<PrevueBean> list = this.R;
        if (list != null && list.size() != 0) {
            this.J.setVisibility(0);
            this.U.setVisibility(8);
        } else {
            this.J.setVisibility(8);
            this.U.setVisibility(0);
        }
        this.Y.c(2000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        V();
        this.A.setTextColor(c.a.a.a.d.b.d().b(R.color.mine_booking_title_textcolor));
        this.h.a(this.A, "textColor", R.color.mine_booking_title_textcolor);
        this.D.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.mine_bookingtitle_bottomline_normal));
        this.h.a(this.D, "background", R.color.mine_bookingtitle_bottomline_normal);
        this.B.setTextColor(c.a.a.a.d.b.d().b(R.color.mine_booking_title_textcolor));
        this.h.a(this.B, "textColor", R.color.mine_booking_title_textcolor);
        this.E.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.mine_bookingtitle_bottomline_normal));
        this.h.a(this.E, "background", R.color.mine_bookingtitle_bottomline_normal);
        this.C.setTextColor(c.a.a.a.d.b.d().b(R.color.mine_bookingtitle_textcolor_focus));
        this.h.a(this.C, "textColor", R.color.mine_bookingtitle_textcolor_focus);
        this.F.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.mine_bookingtitle_bottomline_focus));
        this.h.a(this.C, "background", R.color.mine_bookingtitle_bottomline_focus);
        this.G.setVisibility(8);
        this.J.setVisibility(8);
        this.K.setVisibility(8);
        this.U.setVisibility(8);
        this.W = 2;
        L();
        if (this.r == null) {
            this.r = new com.zte.iptvclient.android.mobile.c.a.d(this.P, this.S);
            this.K.a(new LinearLayoutManager(this.P));
            this.K.a(this.r);
            this.K.a(1, new j());
        }
        J();
        if (this.S.size() == 0) {
            this.K.setVisibility(8);
            this.U.setVisibility(0);
        } else {
            this.K.setVisibility(0);
            this.U.setVisibility(8);
        }
        this.Y.c(2000);
    }

    private void U() {
        this.w.setOnClickListener(new k());
        this.v.setOnClickListener(new l());
        this.u.setOnClickListener(new m());
        this.t.setOnClickListener(new ViewOnClickListenerC0191a());
        this.Y.a(new b());
    }

    private void V() {
        this.X = ProgressDialog.show(this.h, "", com.zte.iptvclient.android.common.i.a.a.a(R.string.play_activity_play_load_data));
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        K();
        U();
        String readPropertie = ConfigMgr.readPropertie("SupportOrderReminderType");
        if (TextUtils.isEmpty(readPropertie)) {
            return;
        }
        int intValue = Integer.valueOf(readPropertie).intValue();
        if ((intValue & 8) > 0) {
            if (intValue == 8) {
                this.u.setVisibility(8);
                this.y.setVisibility(8);
            } else {
                this.u.setVisibility(0);
                this.y.setVisibility(0);
            }
            if ((intValue & 1) > 0 || (intValue & 4) > 0) {
                this.v.setVisibility(0);
                this.y.setVisibility(0);
            }
            if ((intValue & 2) > 0) {
                this.w.setVisibility(0);
                this.y.setVisibility(0);
            }
            R();
            return;
        }
        if ((intValue & 1) > 0 || (intValue & 4) > 0) {
            if (intValue != 1 && intValue != 4) {
                this.v.setVisibility(0);
                this.y.setVisibility(0);
            } else {
                this.v.setVisibility(8);
                this.y.setVisibility(8);
            }
            if ((intValue & 2) > 0) {
                this.w.setVisibility(0);
                this.y.setVisibility(0);
            }
            S();
            return;
        }
        if ((intValue & 2) > 0) {
            if (intValue == 2) {
                this.w.setVisibility(8);
                this.y.setVisibility(8);
            } else {
                this.w.setVisibility(0);
                this.y.setVisibility(0);
            }
            T();
            return;
        }
        this.y.setVisibility(8);
        this.u.setVisibility(8);
        this.v.setVisibility(8);
        this.w.setVisibility(8);
        this.U.setVisibility(0);
        this.W = 3;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.P = activity;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.booking_fragment, (ViewGroup) null);
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe
    public void onEventMainThread(p pVar) {
        this.p.d();
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.x = (RelativeLayout) view.findViewById(R.id.title_rlayout);
        this.t = (Button) view.findViewById(R.id.btn_back);
        TextView textView2 = (TextView) view.findViewById(R.id.title_txt);
        this.z = textView2;
        textView2.setText(R.string.my_subscribe);
        this.y = (RelativeLayout) view.findViewById(R.id.rl_tag);
        this.u = (RelativeLayout) view.findViewById(R.id.rl_order);
        TextView textView3 = (TextView) view.findViewById(R.id.txt_order);
        this.A = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.manager_subscribe));
        this.D = (ImageView) view.findViewById(R.id.order_bottom_line);
        this.v = (RelativeLayout) view.findViewById(R.id.rl_tv_reminder);
        TextView textView4 = (TextView) view.findViewById(R.id.txt_tv_reminder);
        this.B = textView4;
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_reminder));
        this.E = (ImageView) view.findViewById(R.id.tv_reminder_bottom_line);
        this.w = (RelativeLayout) view.findViewById(R.id.rl_vod_reminder);
        TextView textView5 = (TextView) view.findViewById(R.id.txt_vod_reminder);
        this.C = textView5;
        textView5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.vod_reminder));
        this.F = (ImageView) view.findViewById(R.id.vod_reminder_bottom_line);
        this.Y = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        this.G = (ItemRemoveRecyclerView) view.findViewById(R.id.order_recyclerview);
        this.J = (ItemRemoveRecyclerView) view.findViewById(R.id.tv_reminder_recyclerview);
        this.K = (ItemRemoveRecyclerView) view.findViewById(R.id.vod_reminder_recyclerview);
        ImageView imageView = (ImageView) view.findViewById(R.id.header_bottom_line);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.D);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        com.zte.iptvclient.common.uiframe.f.a(this.E);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        com.zte.iptvclient.common.uiframe.f.a(this.F);
        com.zte.iptvclient.common.uiframe.f.a(imageView);
        if (this.o) {
            this.t.setVisibility(0);
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.U = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.U.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.U.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.U.findViewById(R.id.refresh_image));
        this.U.setVisibility(8);
        TextView textView6 = (TextView) this.U.findViewById(R.id.txt_pullrefresh);
        this.V = textView6;
        textView6.setText(this.h.getString(R.string.no_reservations_have_been_made_yet));
        this.Y.a(new DefaultRefreshHeader(this.h));
        this.Y.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.Y;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.Y;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.Y.a(true);
        this.Y.b(false);
        if (BaseApp.a(this.h)) {
            com.zte.iptvclient.android.common.k.g.a(imageView, this.h);
        }
    }

    public static String s(String str) {
        Date t = t(str);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd");
        if (t != null) {
            return simpleDateFormat.format(t);
        }
        return null;
    }

    public static Date t(String str) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str, new ParsePosition(0));
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.b0.e eVar) {
        L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ArrayList<com.zte.iptvclient.android.common.reminder.a> arrayList) {
        String str = "http://{epgdomain}/iptvepg/{frame}/get_binge_watching_info.jsp".replace("http://{epgdomain}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f()) + "?types=";
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            stringBuffer.append(arrayList.get(i2).f());
            if (i2 != arrayList.size() - 1) {
                stringBuffer.append(",");
            }
        }
        String str2 = (str + stringBuffer.toString()) + "&contentcodes=";
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            stringBuffer2.append(arrayList.get(i3).b());
            if (i3 != arrayList.size() - 1) {
                stringBuffer2.append(",");
            }
        }
        String str3 = (str2 + stringBuffer2.toString()) + "&columncodes=";
        StringBuffer stringBuffer3 = new StringBuffer();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            stringBuffer3.append(arrayList.get(i4).a());
            if (i4 != arrayList.size() - 1) {
                stringBuffer3.append(",");
            }
        }
        String str4 = str3 + stringBuffer3.toString();
        LogEx.d("BookingFragment", "sdkQueryVodReminderList url is : " + str4);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.startRequest(str4, HttpRequest.METHOD_GET, new h(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<com.zte.iptvclient.android.common.reminder.c> arrayList) {
        String str = "http://{epgdomain}/iptvepg/{frame}/get_prevueinfo.jsp".replace("http://{epgdomain}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f()) + "?prevuecodes=";
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            stringBuffer.append(arrayList.get(i2).b());
            if (i2 != arrayList.size() - 1) {
                stringBuffer.append(",");
            }
        }
        String str2 = str + stringBuffer.toString();
        LogEx.d("BookingFragment", "sdkQueryTvReminderList url is : " + str2);
        List<EPGServerTvReminderBean> list = this.Q;
        if (list == null) {
            this.Q = new ArrayList();
        } else {
            list.clear();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.startRequest(str2, HttpRequest.METHOD_GET, new f());
    }

    private void a(int i2, String str) {
        this.L.put(Integer.valueOf(i2), str);
    }

    private String a(EPGServerTvReminderBean ePGServerTvReminderBean) {
        return (ePGServerTvReminderBean == null || TextUtils.isEmpty(ePGServerTvReminderBean.getStart_time())) ? "" : s(ePGServerTvReminderBean.getStart_time().trim());
    }

    private String a(PrevueBean prevueBean) {
        if (prevueBean == null || TextUtils.isEmpty(prevueBean.getBegintime())) {
            return "";
        }
        String trim = prevueBean.getBegintime().trim();
        return trim.substring(0, trim.indexOf(" "));
    }

    private String a(AlarmVideoBean alarmVideoBean) {
        return (alarmVideoBean == null || TextUtils.isEmpty(alarmVideoBean.getOnLineTime())) ? "" : s(alarmVideoBean.getOnLineTime().trim());
    }

    private boolean b(AlarmVideoBean alarmVideoBean) {
        Iterator<AlarmVideoBean> it2 = this.S.iterator();
        while (it2.hasNext()) {
            if (it2.next().getId().equals(alarmVideoBean.getId())) {
                return true;
            }
        }
        return false;
    }

    private void b(int i2, String str) {
        this.M.put(Integer.valueOf(i2), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EPGServerTvReminderBean ePGServerTvReminderBean, boolean z) {
        String replace = "http://{epgdomain}/iptvepg/serviceapi?servicetype=reminderset".replace("http://{epgdomain}", com.zte.iptvclient.android.common.f.b.i.b());
        LogEx.d("BookingFragment", "sdkDoEPGServerTvReminder url is : " + replace);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json; charset=GBK");
        sDKNetHTTPRequest.setBody(a(ePGServerTvReminderBean, z));
        sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_POST, new c());
    }

    private String a(EPGServerTvReminderBean ePGServerTvReminderBean, boolean z) {
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
            jSONObject.put("contentcode", ePGServerTvReminderBean.getPrevuecode());
            jSONObject.put("channelcode", ePGServerTvReminderBean.getChannelcode());
            String str = "";
            ArrayList<Channel> b2 = com.zte.iptvclient.android.common.j.i.d().b();
            if (b2 != null && b2.size() != 0) {
                Iterator<Channel> it2 = b2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Channel next = it2.next();
                    if (next.getChannelcode().equals(ePGServerTvReminderBean.getChannelcode())) {
                        str = next.getTelecomcode();
                        break;
                    }
                }
            }
            jSONObject.put("channelmediacode", str);
            jSONObject.put("contentmediacode", ePGServerTvReminderBean.getTelecomcode());
            jSONObject.put("contentname", ePGServerTvReminderBean.getPrevuename());
            jSONObject.put("begintime", TimeUtil.format(x.a(ePGServerTvReminderBean.getStart_time(), "yyyy-MM-dd HH:mm:ss"), "yyyyMMddHHmmss"));
            jSONObject.put("authinfo", com.zte.iptvclient.android.common.k.g.a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        LogEx.d("BookingFragment", "json : " + jSONObject.toString());
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.zte.iptvclient.android.common.reminder.a aVar, boolean z) {
        String replace = "http://{epgdomain}/iptvepg/serviceapi?servicetype=binge-watchingset".replace("http://{epgdomain}", com.zte.iptvclient.android.common.f.b.i.b());
        LogEx.d("BookingFragment", "sdkDoEPGServerSeriesReminder url is : " + replace);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json; charset=GBK");
        sDKNetHTTPRequest.setBody(a(aVar, z));
        sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_POST, new d());
    }

    private String a(com.zte.iptvclient.android.common.reminder.a aVar, boolean z) {
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
            jSONObject.put("type", Integer.valueOf(aVar.f()));
            jSONObject.put("contentcode", aVar.b());
            jSONObject.put("columncode", aVar.a());
            jSONObject.put("contentname", aVar.e());
            jSONObject.put("contentmediacode", aVar.c());
            jSONObject.put("columnmediacode", aVar.c());
            jSONObject.put("authinfo", com.zte.iptvclient.android.common.k.g.a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        LogEx.d("BookingFragment", "json : " + jSONObject.toString());
        return jSONObject.toString();
    }
}
