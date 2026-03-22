package com.zte.iptvclient.android.mobile.a0.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.common.ServerDate;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.prevue.SDKPrevueMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.a.a.e.f;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.e.x.t;
import com.zte.iptvclient.android.common.javabean.column.ColumnBean;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.k.s;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.a0.a.a;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.DeleteSchduleResultBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.RecordFileDetailBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.RecordFileListBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.ScheduleBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.ScheduleListBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.ScheduleResultBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.UserVolumeBean;
import com.zte.iptvclient.android.mobile.npvr.model.bean.AddNpvrResultBean;
import com.zte.iptvclient.android.mobile.npvr.model.bean.DeleteNpvrResultBean;
import com.zte.iptvclient.android.mobile.npvr.model.bean.NpvrBean;
import com.zte.iptvclient.android.mobile.npvr.model.bean.NpvrListBean;
import com.zte.iptvclient.android.zala.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TvProgramListView.java */
/* loaded from: classes.dex */
public class h extends RelativeLayout implements com.zte.iptvclient.android.mobile.g.a.c, com.zte.iptvclient.android.mobile.p.c {
    private static String F = h.class.getSimpleName();
    private int A;
    private com.zte.iptvclient.android.mobile.p.e.a B;
    private String C;
    private com.zte.iptvclient.android.common.customview.a.a.e.f D;
    private Handler E;

    /* renamed from: a, reason: collision with root package name */
    private ColumnBean f5522a;

    /* renamed from: b, reason: collision with root package name */
    private Channel f5523b;

    /* renamed from: c, reason: collision with root package name */
    private String f5524c;

    /* renamed from: d, reason: collision with root package name */
    private SupportActivity f5525d;
    private RecyclerView e;
    private LinearLayout f;
    private TextView g;
    private ImageView h;
    private ArrayList<PrevueBean> i;
    private boolean j;
    private int k;
    private String l;
    private com.zte.iptvclient.android.mobile.a0.a.a m;
    private ArrayList<com.zte.iptvclient.android.common.reminder.c> n;
    private PrevueBean o;
    private Timer p;
    private int q;
    private SmartRefreshLayout r;
    private DefaultRefreshHeader s;
    private RelativeLayout t;
    private LinearLayout u;
    private View v;
    private boolean w;
    private int x;
    private LinearLayoutManager y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvProgramListView.java */
    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 1;
            h.this.E.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvProgramListView.java */
    /* loaded from: classes2.dex */
    public class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 1;
            h.this.E.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvProgramListView.java */
    /* loaded from: classes2.dex */
    public class c implements f.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PrevueBean f5528a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f5529b;

        c(PrevueBean prevueBean, boolean z) {
            this.f5528a = prevueBean;
            this.f5529b = z;
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void a() {
            LogEx.d(h.F, "curent to play tvod duration" + this.f5528a.getDuration());
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.b(this.f5528a, false));
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void b() {
            if (this.f5529b) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.a());
            }
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(false, this.f5528a.getChannelcode(), this.f5528a.getColumncode()));
            h.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvProgramListView.java */
    /* loaded from: classes2.dex */
    public class d implements f.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PrevueBean f5531a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f5532b;

        d(PrevueBean prevueBean, boolean z) {
            this.f5531a = prevueBean;
            this.f5532b = z;
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void a() {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(false, this.f5531a.getChannelcode(), this.f5531a.getColumncode()));
            h.this.c();
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void b() {
            if (this.f5532b) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.a());
            }
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(false, this.f5531a.getChannelcode(), this.f5531a.getColumncode()));
            h.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvProgramListView.java */
    /* loaded from: classes2.dex */
    public class e implements f.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PrevueBean f5534a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f5535b;

        e(PrevueBean prevueBean, boolean z) {
            this.f5534a = prevueBean;
            this.f5535b = z;
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void a() {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(false, this.f5534a.getChannelcode(), this.f5534a.getColumncode(), true, this.f5534a.getBegintime()));
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void b() {
            if (this.f5535b) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.a());
            }
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(false, this.f5534a.getChannelcode(), this.f5534a.getColumncode()));
        }
    }

    /* compiled from: TvProgramListView.java */
    /* loaded from: classes2.dex */
    class f extends Handler {
        f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                h.this.y();
            }
            if (message.what == 2) {
                h.this.i.clear();
                Bundle data = message.getData();
                h.this.f5525d.d();
                if (TextUtils.equals(data.getString("returncode"), "0")) {
                    try {
                        JSONObject jSONObject = new JSONObject(data.getString("jsp"));
                        JSONArray jSONArray = jSONObject.getJSONArray("data");
                        h.this.l = jSONObject.optString("totalcount");
                        LogEx.d(h.F, "prevuelist totalcount = " + h.this.l);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            PrevueBean prevueBeanFromJSon = PrevueBean.getPrevueBeanFromJSon(jSONArray.getJSONObject(i));
                            if (prevueBeanFromJSon != null) {
                                if (!TextUtils.isEmpty(prevueBeanFromJSon.getEndtime())) {
                                    prevueBeanFromJSon.setDuration(TimeUtil.format(x.d(prevueBeanFromJSon.getBegintime()), "HH:mm") + " - " + TimeUtil.format(x.d(prevueBeanFromJSon.getEndtime()), "HH:mm"));
                                }
                                prevueBeanFromJSon.setChannelname(h.this.f5523b.getChannelname());
                                prevueBeanFromJSon.setChannelTelcomcode(h.this.f5523b.getTelecomcode());
                                if (TextUtils.isEmpty(prevueBeanFromJSon.getColumncode())) {
                                    prevueBeanFromJSon.setColumncode(h.this.f5523b.getColumncode());
                                }
                                prevueBeanFromJSon.setMixno(h.this.f5523b.getAllMixno());
                                h.this.i.add(prevueBeanFromJSon);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (TextUtils.isEmpty(h.this.l) || Integer.parseInt(h.this.l) <= 500) {
                    if (h.this.i.size() > 0) {
                        for (int i2 = 0; i2 < h.this.i.size(); i2++) {
                            Date date = new Date();
                            try {
                                date = x.a(((PrevueBean) h.this.i.get(i2)).getBegintime(), new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"));
                            } catch (Exception e2) {
                                LogEx.d(h.F, e2.toString());
                            }
                            com.zte.iptvclient.android.common.j.i.d().a((PrevueBean) h.this.i.get(i2), date, ((PrevueBean) h.this.i.get(i2)).getMixno());
                        }
                        h.this.n();
                    } else if (h.this.f5523b != null) {
                        if (TextUtils.isEmpty(h.this.f5523b.getChannelname())) {
                            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.f(null, 0, null));
                        } else {
                            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.f(null, 0, h.this.f5523b));
                        }
                    }
                    h.this.c();
                    h.this.v();
                    return;
                }
                h.this.o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvProgramListView.java */
    /* loaded from: classes2.dex */
    public class g implements a.l {
        g() {
        }

        @Override // com.zte.iptvclient.android.mobile.a0.a.a.l
        public void a(int i) {
            PrevueBean prevueBean = (PrevueBean) h.this.i.get(i);
            if (h.this.f5523b == null || prevueBean == null) {
                return;
            }
            if (!TextUtils.equals(h.this.f5523b.getAuthid(), "0")) {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(h.this.f5525d.getResources().getString(R.string.npvr_not_available));
            } else {
                h.this.B.a(prevueBean.getPrevuecode(), "2", prevueBean.getChannelcode(), null, null, null);
            }
        }

        @Override // com.zte.iptvclient.android.mobile.a0.a.a.l
        public void b(int i) {
            PrevueBean prevueBean = (PrevueBean) h.this.i.get(i);
            if (h.this.f5523b == null || prevueBean == null) {
                return;
            }
            h.this.B.c(prevueBean.getPrevuecode(), h.this.f5523b.getMediaservices());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvProgramListView.java */
    /* renamed from: com.zte.iptvclient.android.mobile.a0.b.h$h, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0186h implements com.scwang.smartrefresh.layout.d.c {
        C0186h() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            h.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvProgramListView.java */
    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            if (h.this.w) {
                h.this.l();
            } else {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(true, h.this.f5523b.getChannelcode(), h.this.f5523b.getColumncode()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvProgramListView.java */
    /* loaded from: classes2.dex */
    public class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvProgramListView.java */
    /* loaded from: classes2.dex */
    public class k implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        k() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d(h.F, "sdkQueryEPGServerTvReminderList data return : " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (TextUtils.equals(jSONObject.optString("returncode"), "0")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("reminders");
                    ArrayList arrayList = new ArrayList();
                    if (h.this.m != null) {
                        h.this.m.d();
                    }
                    for (int i = 0; i < jSONArray.length(); i++) {
                        com.zte.iptvclient.android.common.reminder.c cVar = new com.zte.iptvclient.android.common.reminder.c();
                        cVar.b(jSONArray.optJSONObject(i).optString("contentcode"));
                        cVar.a(jSONArray.optJSONObject(i).optString("channelcode"));
                        arrayList.add(cVar);
                    }
                    h.this.n = arrayList;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (h.this.m != null) {
                h.this.m.d();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            if (h.this.n != null) {
                h.this.n.clear();
            }
            if (h.this.m != null) {
                h.this.m.d();
            }
            LogEx.d(h.F, "sdkQueryEPGServerTvReminderList onFailReturn ,returncode : " + i + " , errormsg : " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvProgramListView.java */
    /* loaded from: classes2.dex */
    public class l implements SDKPrevueMgr.OnPrevueListReturnListener {
        l() {
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnPrevueListReturnListener
        public void onPrevueListReturn(String str, String str2, String str3) {
            LogEx.d(h.F, "returncode= " + str + "  errmsg " + str2 + "  jsp " + str3);
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("returncode", str);
            bundle.putString("errmsg", str2);
            bundle.putString("jsp", str3);
            message.what = 2;
            message.setData(bundle);
            h.this.E.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvProgramListView.java */
    /* loaded from: classes2.dex */
    public class m implements SDKPrevueMgr.OnPrevueListReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5544a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f5545b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f5546c;

        m(String str, String str2, boolean z) {
            this.f5544a = str;
            this.f5545b = str2;
            this.f5546c = z;
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnPrevueListReturnListener
        public void onPrevueListReturn(String str, String str2, String str3) {
            LogEx.d(h.F, "returncode= " + str + "  errmsg " + str2 + "  jsp " + str3);
            h.this.f5525d.d();
            if (h.this.m != null) {
                h.this.m.d();
            }
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    h.this.l = jSONObject.optString("totalcount");
                    LogEx.d(h.F, "prevuelist totalcount = " + h.this.l);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        PrevueBean prevueBeanFromJSon = PrevueBean.getPrevueBeanFromJSon(jSONArray.getJSONObject(i));
                        if (prevueBeanFromJSon != null) {
                            if (!TextUtils.isEmpty(prevueBeanFromJSon.getEndtime())) {
                                prevueBeanFromJSon.setDuration(TimeUtil.format(x.d(prevueBeanFromJSon.getBegintime()), "HH:mm") + " - " + TimeUtil.format(x.d(prevueBeanFromJSon.getEndtime()), "HH:mm"));
                            }
                            prevueBeanFromJSon.setChannelname(h.this.f5523b.getChannelname());
                            prevueBeanFromJSon.setChannelTelcomcode(h.this.f5523b.getTelecomcode());
                            if (TextUtils.isEmpty(prevueBeanFromJSon.getColumncode())) {
                                prevueBeanFromJSon.setColumncode(h.this.f5523b.getColumncode());
                            }
                            prevueBeanFromJSon.setMixno(h.this.f5523b.getAllMixno());
                            h.this.i.add(prevueBeanFromJSon);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(h.this.l) || Integer.parseInt(h.this.l) <= 500) {
                if (h.this.m != null) {
                    h.this.m.d();
                }
                if (h.this.i.size() > 0) {
                    for (int i2 = 0; i2 < h.this.i.size(); i2++) {
                        Date date = new Date();
                        try {
                            date = x.a(((PrevueBean) h.this.i.get(i2)).getBegintime(), new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"));
                        } catch (Exception e2) {
                            LogEx.d(h.F, e2.toString());
                        }
                        com.zte.iptvclient.android.common.j.i.d().a((PrevueBean) h.this.i.get(i2), date, ((PrevueBean) h.this.i.get(i2)).getMixno());
                    }
                    h.this.n();
                } else if (h.this.f5523b != null) {
                    if (TextUtils.isEmpty(h.this.f5523b.getChannelname())) {
                        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.f(null, 0, null));
                    } else {
                        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.f(null, 0, h.this.f5523b));
                    }
                }
                h.this.c();
                h.this.a(0, this.f5544a, this.f5545b, this.f5546c);
                return;
            }
            h.this.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvProgramListView.java */
    /* loaded from: classes2.dex */
    public class n implements SDKPrevueMgr.OnPrevueListReturnListener {
        n() {
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnPrevueListReturnListener
        public void onPrevueListReturn(String str, String str2, String str3) {
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        PrevueBean prevueBeanFromJSon = PrevueBean.getPrevueBeanFromJSon(jSONArray.getJSONObject(i));
                        if (prevueBeanFromJSon != null) {
                            if (!TextUtils.isEmpty(prevueBeanFromJSon.getEndtime())) {
                                prevueBeanFromJSon.setDuration(TimeUtil.format(x.d(prevueBeanFromJSon.getBegintime()), "HH:mm") + " - " + TimeUtil.format(x.d(prevueBeanFromJSon.getEndtime()), "HH:mm"));
                            }
                            prevueBeanFromJSon.setChannelname(h.this.f5523b.getChannelname());
                            prevueBeanFromJSon.setChannelTelcomcode(h.this.f5523b.getTelecomcode());
                            if (TextUtils.isEmpty(prevueBeanFromJSon.getColumncode())) {
                                prevueBeanFromJSon.setColumncode(h.this.f5523b.getColumncode());
                            }
                            prevueBeanFromJSon.setMixno(h.this.f5523b.getAllMixno());
                            h.this.i.add(prevueBeanFromJSon);
                        }
                    }
                    h.this.k = 1;
                    if (h.this.m != null) {
                        h.this.m.d();
                    }
                    if (h.this.i.size() > 0) {
                        for (int i2 = 0; i2 < h.this.i.size(); i2++) {
                            Date date = new Date();
                            try {
                                date = x.a(((PrevueBean) h.this.i.get(i2)).getBegintime(), new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"));
                            } catch (Exception e) {
                                LogEx.d(h.F, e.toString());
                            }
                            com.zte.iptvclient.android.common.j.i.d().a((PrevueBean) h.this.i.get(i2), date, ((PrevueBean) h.this.i.get(i2)).getMixno());
                        }
                        h.this.n();
                    } else if (h.this.f5523b != null) {
                        if (TextUtils.isEmpty(h.this.f5523b.getChannelname())) {
                            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.f(null, 0, null));
                        } else {
                            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.f(null, 0, h.this.f5523b));
                        }
                    }
                    h.this.c();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvProgramListView.java */
    /* loaded from: classes2.dex */
    public class o extends RecyclerView.s {
        o() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, int i, int i2) {
            super.a(recyclerView, i, i2);
            if (h.this.z) {
                h.this.z = false;
                int G = h.this.A - h.this.y.G();
                if (G < 0 || G >= h.this.e.getChildCount()) {
                    return;
                }
                h.this.e.scrollBy(0, h.this.e.getChildAt(G).getTop());
            }
        }
    }

    public h(SupportActivity supportActivity, String str, boolean z, int i2) {
        super(supportActivity);
        this.j = false;
        this.k = 1;
        this.o = null;
        this.p = null;
        this.q = 0;
        this.x = 0;
        this.z = false;
        this.A = 1;
        this.E = new f();
        LogEx.d(F, "￥%TvProgramListView onCreat start");
        if (this.v == null) {
            this.f5525d = supportActivity;
            this.f5524c = str;
            this.w = z;
            this.x = i2;
            k();
            h();
            j();
        }
        this.B = new com.zte.iptvclient.android.mobile.p.e.a(this, new com.zte.iptvclient.android.mobile.p.d.a());
        new com.zte.iptvclient.android.common.j.h(supportActivity);
        LogEx.d(F, "￥%TvProgramListView onCreat finish");
        this.C = com.zte.iptvclient.android.common.i.a.a.a(R.string.login_set_language);
    }

    private void s() {
        ColumnBean columnBean = this.f5522a;
        if (columnBean != null && TextUtils.equals(columnBean.getColumnName(), com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_favorite)) && this.f5523b == null) {
            LogEx.d(F, "showFavoriteColumnNoDataTipView");
            t();
            return;
        }
        this.r.d(true);
        this.u.setVisibility(8);
        if (this.j) {
            e();
        } else {
            r();
        }
    }

    private void t() {
        this.r.d(false);
        this.u.setVisibility(0);
        this.f.setVisibility(8);
        this.t.setVisibility(8);
        this.e.setVisibility(8);
    }

    private void u() {
        this.f.setVisibility(8);
        this.u.setVisibility(8);
        this.t.setVisibility(8);
        this.e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        LogEx.d(F, "showTodayProgramListView");
        int i2 = 0;
        this.A = 0;
        while (true) {
            if (i2 >= this.i.size()) {
                break;
            }
            PrevueBean prevueBean = this.i.get(i2);
            PrevueBean prevueBean2 = com.zte.iptvclient.android.common.javabean.e.f4731b;
            if (prevueBean2 != null) {
                if (!TextUtils.equals(prevueBean2.getPrevuecode(), prevueBean.getPrevuecode())) {
                    i2++;
                } else if (i2 != 0 && !BaseApp.f()) {
                    this.A = i2 - 1;
                } else {
                    this.A = i2;
                }
            } else {
                Date d2 = x.d(prevueBean.getBegintime());
                Date d3 = x.d(prevueBean.getEndtime());
                Date b2 = s.b();
                if (b2.after(d2) && b2.before(d3)) {
                    if (i2 != 0 && !BaseApp.f()) {
                        this.A = i2 - 1;
                    } else {
                        this.A = i2;
                    }
                }
                i2++;
            }
        }
        this.r.a();
        u();
        com.zte.iptvclient.android.mobile.a0.a.a aVar = this.m;
        if (aVar != null) {
            aVar.d();
        }
        int i3 = this.A;
        if (i3 >= 1) {
            this.A = i3 - 1;
        }
        b(this.A);
    }

    private void w() {
        LogEx.d(F, "showTodayProgramListView");
        int i2 = 0;
        this.A = 0;
        Timer timer = this.p;
        if (timer != null) {
            timer.cancel();
            this.p = null;
        }
        while (true) {
            if (i2 >= this.i.size()) {
                break;
            }
            PrevueBean prevueBean = this.i.get(i2);
            PrevueBean prevueBean2 = com.zte.iptvclient.android.common.javabean.e.f4731b;
            if (prevueBean2 != null) {
                if (TextUtils.equals(prevueBean2.getPrevuecode(), prevueBean.getPrevuecode())) {
                    if (i2 != 0 && !BaseApp.f()) {
                        this.A = i2 - 1;
                    } else {
                        this.A = i2;
                    }
                    Timer timer2 = new Timer();
                    this.p = timer2;
                    timer2.schedule(new a(), 30000L, 30000L);
                } else {
                    i2++;
                }
            } else {
                Date d2 = x.d(prevueBean.getBegintime());
                Date d3 = x.d(prevueBean.getEndtime());
                Date b2 = s.b();
                if (b2.after(d2) && b2.before(d3)) {
                    if (i2 != 0 && !BaseApp.f()) {
                        this.A = i2 - 1;
                    } else {
                        this.A = i2;
                    }
                    Timer timer3 = new Timer();
                    this.p = timer3;
                    timer3.schedule(new b(), 30000L, 30000L);
                }
                i2++;
            }
        }
        this.r.a();
        u();
        com.zte.iptvclient.android.mobile.a0.a.a aVar = this.m;
        if (aVar != null) {
            aVar.d();
        }
        int i3 = this.A;
        if (i3 >= 1) {
            this.A = i3 - 1;
        }
        b(this.A);
    }

    private void x() {
        LogEx.d(F, "showTvodProgramListView");
        this.r.a();
        if (this.i.size() == 0) {
            s();
        } else {
            u();
            com.zte.iptvclient.android.mobile.a0.a.a aVar = this.m;
            if (aVar != null) {
                aVar.d();
            }
            int i2 = 0;
            this.A = 0;
            while (true) {
                if (i2 >= this.i.size()) {
                    break;
                }
                if (com.zte.iptvclient.android.common.javabean.e.f4731b == null || this.i.get(i2) == null || !TextUtils.equals(com.zte.iptvclient.android.common.javabean.e.f4731b.getPrevuecode(), this.i.get(i2).getPrevuecode())) {
                    i2++;
                } else if (i2 != 0 && !BaseApp.f()) {
                    this.A = i2 - 1;
                } else {
                    this.A = i2;
                }
            }
        }
        int i3 = this.A;
        if (i3 > 1) {
            this.A = i3 - 1;
        }
        b(this.A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            PrevueBean prevueBean = this.i.get(i2);
            Date d2 = x.d(prevueBean.getBegintime());
            Date d3 = x.d(prevueBean.getEndtime());
            Date b2 = s.b();
            if (b2.after(d2) && b2.before(d3)) {
                this.o = this.i.get(i2);
            }
        }
        try {
            Date now = TimeUtil.getNow();
            Date b3 = x.b(this.o.getBegintime(), "yyyy.MM.dd HH:mm:ss");
            long time = x.b(this.o.getEndtime(), "yyyy.MM.dd HH:mm:ss").getTime() - b3.getTime();
            if (time <= 0) {
                LogEx.d(F, "program duration invalidate : " + time);
                return;
            }
            long time2 = now.getTime() - b3.getTime();
            float f2 = ((((float) time2) * 1.0f) / ((float) time)) * 100.0f;
            int i3 = (int) f2;
            if (i3 > 100) {
                i3 -= 100;
            }
            if (this.m != null) {
                this.m.e(i3);
            }
            LogEx.d(F, "program duration : " + time + ", diff : " + time2 + ",ratio = " + f2 + ", current process : " + i3);
            m();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(RecordFileDetailBean recordFileDetailBean) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(RecordFileListBean recordFileListBean) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(ScheduleResultBean scheduleResultBean) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(UserVolumeBean userVolumeBean) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(String str) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void b(String str) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void g(String str) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void h(String str) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void j(String str) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void m(String str) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void n(String str) {
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void o(String str) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Timer timer = this.p;
        if (timer != null) {
            timer.cancel();
            this.p.purge();
            this.p = null;
        }
        Handler handler = this.E;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(t tVar) {
        tVar.a();
        throw null;
    }

    private void h() {
        this.r.a(new C0186h());
        this.f.setOnClickListener(new i());
        this.h.setOnClickListener(new j());
        this.e.c(new o());
    }

    private String i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("usertoken", com.zte.iptvclient.common.uiframe.a.d("UserToken"));
            jSONObject.put("usercode", com.zte.iptvclient.common.uiframe.a.d("UserID"));
            jSONObject.put("sorttype", 1);
            jSONObject.put("authinfo", com.zte.iptvclient.android.common.k.g.a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        LogEx.d(F, "convertToQueryJsonParams : " + jSONObject.toString());
        return jSONObject.toString();
    }

    private void j() {
        this.n = new ArrayList<>();
        String readPropertie = ConfigMgr.readPropertie("SupportOrderReminderType");
        if (!TextUtils.isEmpty(readPropertie)) {
            this.q = Integer.valueOf(readPropertie).intValue();
        }
        this.i = new ArrayList<>();
        if ((this.q & 4) > 0) {
            p();
        }
        String format = TimeUtil.format(TimeUtil.getNow(), "yyyy-MM-dd");
        if (com.zte.iptvclient.android.common.k.g.a(this.f5524c, format) == 0) {
            this.j = true;
        } else {
            this.j = false;
        }
        LogEx.d(F, "current programesSchedule date is Today " + this.j);
        if (this.j) {
            if ((this.q & 4) > 0) {
                this.m = new com.zte.iptvclient.android.mobile.a0.a.a(this.f5525d, this.i, this.n, 0, this.x);
            } else {
                this.m = new com.zte.iptvclient.android.mobile.a0.a.a(this.f5525d, this.i, 0, this.x);
            }
        } else if (com.zte.iptvclient.android.common.k.g.a(this.f5524c, format) >= 0) {
            this.m = new com.zte.iptvclient.android.mobile.a0.a.a(this.f5525d, this.i, this.n, 0, this.x);
        } else {
            this.m = new com.zte.iptvclient.android.mobile.a0.a.a(this.f5525d, this.i, this.n, 1, this.x);
        }
        this.m.a(this.f5523b);
        this.m.b(this.w);
        this.m.a(new g());
        this.e.d(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f5525d);
        this.y = linearLayoutManager;
        this.e.a(linearLayoutManager);
        this.e.a(this.m);
    }

    private void k() {
        View inflate = View.inflate(this.f5525d, R.layout.tv_program_list_pageview, this);
        this.r = (SmartRefreshLayout) inflate.findViewById(R.id.refreshLayout);
        this.e = (RecyclerView) inflate.findViewById(R.id.program_list);
        this.f = (LinearLayout) inflate.findViewById(R.id.ll_today_empty);
        this.g = (TextView) inflate.findViewById(R.id.txt_program_name);
        this.h = (ImageView) inflate.findViewById(R.id.img_empty_add_multi_play);
        com.zte.iptvclient.common.uiframe.f.a(this.e);
        TextView textView = (TextView) this.f.findViewById(R.id.txt_nowplaying);
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.live_tv_playing));
        com.zte.iptvclient.common.uiframe.f.a(this.f);
        com.zte.iptvclient.common.uiframe.f.a(this.f.findViewById(R.id.ll_empty_text));
        com.zte.iptvclient.common.uiframe.f.a(this.f.findViewById(R.id.txt_program_name));
        com.zte.iptvclient.common.uiframe.f.a(textView);
        com.zte.iptvclient.common.uiframe.f.a(this.f.findViewById(R.id.img_empty_add_multi_play));
        com.zte.iptvclient.common.uiframe.f.a(this.f.findViewById(R.id.img_playing));
        com.zte.iptvclient.common.uiframe.f.a(this.f.findViewById(R.id.bottom_line));
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rl_empty);
        this.t = relativeLayout;
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.txt_pullrefresh);
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.there_is_no_collection));
        com.zte.iptvclient.common.uiframe.f.a(this.t.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.t.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(textView2);
        com.zte.iptvclient.common.uiframe.f.a(this.t.findViewById(R.id.refresh_image));
        this.t.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.favorite_column_empty_view);
        this.u = linearLayout;
        TextView textView3 = (TextView) linearLayout.findViewById(R.id.txt_empty_tophint);
        TextView textView4 = (TextView) this.u.findViewById(R.id.txt_empty_bottomhint);
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_favorite_empty_tophint));
        textView4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_favorite_empty_bottomhint));
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.u.findViewById(R.id.img_favorite_empty));
        com.zte.iptvclient.common.uiframe.f.a(this.u.findViewById(R.id.txt_empty_tophint));
        com.zte.iptvclient.common.uiframe.f.a(this.u.findViewById(R.id.txt_empty_bottomhint));
        DefaultRefreshHeader defaultRefreshHeader = new DefaultRefreshHeader(this.f5525d);
        this.s = defaultRefreshHeader;
        this.r.a(defaultRefreshHeader);
        this.r.a(new DefaultRefreshFooter(this.f5525d));
        SmartRefreshLayout smartRefreshLayout = this.r;
        SupportActivity supportActivity = this.f5525d;
        smartRefreshLayout.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.r;
        SupportActivity supportActivity2 = this.f5525d;
        smartRefreshLayout2.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.r.a(true);
        if (this.x == 0) {
            textView3.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_date_normal_light));
            this.f5525d.a(textView3, "textColor", R.color.multiplayer_date_normal_light);
            textView4.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_date_normal_light));
            this.f5525d.a(textView4, "textColor", R.color.multiplayer_date_normal_light);
        } else {
            this.s.c();
            textView3.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_date_normal_dark));
            this.f5525d.a(textView3, "textColor", R.color.multiplayer_date_normal_dark);
            textView4.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_date_normal_dark));
            this.f5525d.a(textView4, "textColor", R.color.multiplayer_date_normal_dark);
        }
        this.v = inflate;
    }

    private void m() {
        String format = new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH).format(x.a(this.f5524c, new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)));
        LogEx.d(F, "start time " + format);
        String str = format + " 00:00:00";
        LogEx.d(F, "start time " + str);
        String str2 = format + " 23:59:59";
        LogEx.d(F, "startTime is " + str + "   endTime is " + str2);
        SDKPrevueMgr sDKPrevueMgr = new SDKPrevueMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("channelcode", this.f5523b.getChannelcode());
        hashMap.put("begintime", str);
        hashMap.put("endtime", str2);
        hashMap.put("pageno", String.valueOf(this.k));
        hashMap.put("numperpage", "500");
        LogEx.d(F, "getPrevueList channelcodeis " + this.f5523b.getChannelcode());
        sDKPrevueMgr.getPrevueList(hashMap, new l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.B.a("1", "500", "3", "4", null, this.C, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.k++;
        String format = new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH).format(x.a(this.f5524c, new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)));
        LogEx.d(F, "start time " + format);
        String str = format + " 00:00:00";
        LogEx.d(F, "start time " + str);
        String str2 = format + " 23:59:59";
        LogEx.d(F, "startTime is " + str + "   endTime is " + str2);
        SDKPrevueMgr sDKPrevueMgr = new SDKPrevueMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("channelcode", this.f5523b.getChannelcode());
        hashMap.put("begintime", str);
        hashMap.put("endtime", str2);
        hashMap.put("pageno", String.valueOf(this.k));
        hashMap.put("numperpage", "500");
        LogEx.d(F, "getPrevueList channelcodeis " + this.f5523b.getChannelcode());
        sDKPrevueMgr.getPrevueList(hashMap, new n());
    }

    private void p() {
        String replace = "http://{epgdomain}/iptvepg/serviceapi?servicetype=reminderquery".replace("http://{epgdomain}", com.zte.iptvclient.android.common.f.b.i.b());
        LogEx.d(F, "sdkQueryEPGServerTvReminderList url is : " + replace);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json; charset=GBK");
        sDKNetHTTPRequest.setBody(i());
        sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_POST, new k());
    }

    private void q() {
        if (this.w) {
            this.h.setVisibility(0);
            com.zte.iptvclient.android.common.javabean.f a2 = com.zte.iptvclient.android.common.player.multiplay.a.a(this.f5523b);
            ArrayList<com.zte.iptvclient.android.common.javabean.f> a3 = com.zte.iptvclient.android.common.player.multiplay.a.c().a();
            if (!com.zte.iptvclient.android.common.player.multiplay.a.c().a(a2)) {
                for (int i2 = 0; i2 < a3.size(); i2++) {
                    com.zte.iptvclient.android.common.javabean.f fVar = a3.get(i2);
                    if (!TextUtils.equals(fVar.c(), a2.c()) || !TextUtils.equals(fVar.d(), a2.d())) {
                        this.h.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.multiscreen_add_blue));
                        this.f5525d.a(this.h, "src", R.drawable.multiscreen_add_blue);
                        break;
                    }
                }
            } else {
                this.h.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.multiscreen_delete_blue));
                this.f5525d.a(this.h, "src", R.drawable.multiscreen_delete_blue);
            }
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.y.b());
            return;
        }
        this.h.setVisibility(8);
    }

    private void r() {
        this.r.a();
        this.f.setVisibility(8);
        this.e.setVisibility(8);
        this.t.setVisibility(0);
    }

    public void b(boolean z) {
        if (this.i.size() == 0) {
            if (z) {
                a(true);
            } else {
                a(false);
            }
            s();
        }
        com.zte.iptvclient.android.mobile.a0.a.a aVar = this.m;
        if (aVar != null) {
            aVar.b(z);
        }
    }

    public void c() {
        LogEx.d(F, " showChannelTodayProgramScheduleListView");
        if (this.i.size() == 0) {
            s();
        } else {
            w();
        }
    }

    @Override // com.zte.iptvclient.android.mobile.p.c
    public void d(String str, String str2) {
        LogEx.d(F, "errorMsg = " + str2);
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(str2);
    }

    public void e() {
        LogEx.d(F, "showTodayEmptyScheduleView");
        this.r.a();
        Channel channel = this.f5523b;
        if (channel != null) {
            this.g.setText(channel.getChannelname());
            this.f.setVisibility(0);
            this.e.setVisibility(8);
            this.t.setVisibility(8);
            q();
            return;
        }
        r();
        LogEx.e(F, "current channel is null for today scheduledata!");
    }

    public void f() {
        if (this.i.size() == 0) {
            s();
        }
        com.zte.iptvclient.android.mobile.a0.a.a aVar = this.m;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.zte.iptvclient.android.mobile.p.c
    public void l(String str) {
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            this.i.get(i2).setRecordstate("0");
            this.m.a(i2, "clouddvr");
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.r.l lVar) {
        b();
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.k kVar) {
        n();
    }

    public void d() {
        LogEx.d(F, " showChannelTodayProgramScheduleListView");
        if (this.i.size() == 0) {
            s();
        } else {
            x();
        }
    }

    @Subscribe
    public void onEventMainThread(com.zte.iptvclient.android.common.e.j.a aVar) {
        com.zte.iptvclient.android.mobile.a0.a.a aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.d();
        }
        LogEx.d(F, "UnLockBlockTitleEvent event");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        com.zte.iptvclient.android.common.javabean.f a2 = com.zte.iptvclient.android.common.player.multiplay.a.a(this.f5523b);
        ArrayList<com.zte.iptvclient.android.common.javabean.f> a3 = com.zte.iptvclient.android.common.player.multiplay.a.c().a();
        if (com.zte.iptvclient.android.common.player.multiplay.a.c().a(a2)) {
            int i2 = 0;
            while (true) {
                if (i2 >= a3.size()) {
                    break;
                }
                com.zte.iptvclient.android.common.javabean.f fVar = a3.get(i2);
                if (TextUtils.equals(fVar.c(), a2.c()) && TextUtils.equals(fVar.d(), a2.d())) {
                    a3.remove(i2);
                    this.h.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.multiscreen_add_blue));
                    this.f5525d.a(this.h, "src", R.drawable.multiscreen_add_blue);
                    break;
                }
                i2++;
            }
        } else if (!com.zte.iptvclient.android.common.player.multiplay.a.c().b()) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.multiscreen_program_too_more);
            return;
        } else {
            a3.add(a2);
            this.h.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.multiscreen_delete_blue));
            this.f5525d.a(this.h, "src", R.drawable.multiscreen_delete_blue);
        }
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.y.b());
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void c(String str) {
        LogEx.d(F, "errorMsg = " + str);
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            this.i.get(i2).setRecordstate("0");
            this.m.a(i2, "clouddvr");
        }
    }

    public void a(Channel channel) {
        LogEx.d(F, "更新频道数据 @" + this.f5524c);
        this.f5523b = channel;
        if (channel == null) {
            s();
            return;
        }
        com.zte.iptvclient.android.mobile.a0.a.a aVar = this.m;
        if (aVar != null) {
            aVar.a(channel);
        }
        if (a()) {
            b(a());
        }
    }

    public void b(Channel channel) {
        LogEx.d(F, "更新频道数据并刷新 @" + this.f5524c);
        this.f5523b = channel;
        if (channel == null) {
            s();
            return;
        }
        com.zte.iptvclient.android.mobile.a0.a.a aVar = this.m;
        if (aVar != null) {
            aVar.a(channel);
        }
        if (a()) {
            b(a());
        }
        LogEx.d(F, "query channel program shcedule list ");
        b();
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void e(String str) {
        LogEx.d(F, "errorMsg = " + str);
    }

    @Override // com.zte.iptvclient.android.mobile.p.c
    public void a(NpvrListBean npvrListBean) {
        boolean z;
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            PrevueBean prevueBean = this.i.get(i2);
            LogEx.d(F, "节目单code = " + prevueBean.getPrevuecode());
            Iterator<NpvrBean> it2 = npvrListBean.getDataList().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    break;
                }
                NpvrBean next = it2.next();
                LogEx.d(F, "录制计划的节目单code = " + next.getPrevuecode());
                if (TextUtils.equals(next.getPrevuecode(), prevueBean.getPrevuecode())) {
                    z = true;
                    break;
                }
            }
            if (z) {
                prevueBean.setRecordstate("1");
            } else {
                prevueBean.setRecordstate("0");
            }
            this.m.a(i2, "clouddvr");
        }
    }

    private void b(int i2) {
        LogEx.d(F, "moveToPosition = " + i2);
        if (i2 == 0) {
            return;
        }
        int G = this.y.G();
        int H = this.y.H();
        if (i2 <= G) {
            this.e.j(i2);
        } else if (i2 <= H) {
            this.e.scrollBy(0, this.e.getChildAt(i2 - G).getTop());
        } else {
            this.e.j(i2);
            this.z = true;
        }
    }

    @Override // com.zte.iptvclient.android.mobile.p.c
    public void a(AddNpvrResultBean addNpvrResultBean) {
        LogEx.d(F, "showAddNpvrSuccess Result prevuecode = " + addNpvrResultBean.getPrevuecode());
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            PrevueBean prevueBean = this.i.get(i2);
            LogEx.d(F, "showAddNpvrSuccess 当前已有节目单的prevuecode = " + prevueBean.getPrevuecode());
            if (TextUtils.equals(prevueBean.getPrevuecode(), addNpvrResultBean.getPrevuecode())) {
                prevueBean.setRecordstate("1");
                LogEx.d(F, "showAddNpvrSuccess 设置好录制状态后: isRecording = " + prevueBean.isRecording());
                this.m.a(i2, "clouddvr");
                return;
            }
        }
    }

    @Override // com.zte.iptvclient.android.mobile.p.c
    public void b(String str, String str2) {
        if ("70112505".equals(str2)) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.f5525d.getResources().getString(R.string.insufficient_npvr));
        } else {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.f5525d.getResources().getString(R.string.recording_error));
        }
        LogEx.d(F, "添加预约NPVR失败，errorMsg = " + str);
    }

    @Override // com.zte.iptvclient.android.mobile.p.c
    public void a(DeleteNpvrResultBean deleteNpvrResultBean) {
        LogEx.d(F, "删除的录制计划的Prevuecode = " + deleteNpvrResultBean.getPrevuecode());
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            PrevueBean prevueBean = this.i.get(i2);
            LogEx.d(F, "已有节目单的Prevuecode = " + prevueBean.getPrevuecode());
            if (TextUtils.equals(prevueBean.getPrevuecode(), deleteNpvrResultBean.getPrevuecode())) {
                prevueBean.setRecordstate("0");
                this.m.a(i2, "clouddvr");
                return;
            }
        }
    }

    public void b() {
        LogEx.d(F, "queryChannelProgramScheduleList");
        if (this.f5523b != null && !TextUtils.isEmpty(this.f5524c)) {
            m();
        } else {
            s();
        }
    }

    public void a(int i2) {
        if (this.x == i2) {
            return;
        }
        this.x = i2;
        if (i2 == 1) {
            this.s.c();
        }
        com.zte.iptvclient.android.mobile.a0.a.a aVar = this.m;
        if (aVar != null) {
            aVar.f(i2);
        }
    }

    public void a(ColumnBean columnBean) {
        this.f5522a = columnBean;
    }

    private void a(String str, String str2, boolean z) {
        this.i.clear();
        String format = new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH).format(x.a(this.f5524c, new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)));
        LogEx.d(F, "start time " + format);
        String str3 = format + " 00:00:00";
        LogEx.d(F, "start time " + str3);
        String str4 = format + " 23:59:59";
        LogEx.d(F, "startTime is " + str3 + "   endTime is " + str4);
        SDKPrevueMgr sDKPrevueMgr = new SDKPrevueMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("channelcode", this.f5523b.getChannelcode());
        hashMap.put("begintime", str3);
        hashMap.put("endtime", str4);
        hashMap.put("pageno", String.valueOf(this.k));
        hashMap.put("numperpage", "500");
        LogEx.d(F, "getPrevueList channelcodeis " + this.f5523b.getChannelcode());
        sDKPrevueMgr.getPrevueList(hashMap, new m(str, str2, z));
    }

    public void a(String str, String str2, String str3, boolean z, boolean z2) {
        if (z2) {
            a(str, str3, z);
            return;
        }
        LogEx.d(F, "playNext PrevueCode=" + str);
        a(a(str, str2, str3) + 1, str, str3, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, String str2, boolean z) {
        LogEx.d(F, "mIsFullScreen = " + z);
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Is_Auto_Play");
        LogEx.d(F, "isAutoPlay = " + c2);
        com.zte.iptvclient.android.common.customview.a.a.e.f fVar = this.D;
        if (fVar == null || !fVar.isShowing()) {
            if (this.i.size() == 0) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(false, this.f5523b.getChannelcode(), this.f5523b.getColumncode()));
                return;
            }
            String format = new SimpleDateFormat("yyyy-MM-dd").format(ServerDate.getEpgTime());
            if (i2 < this.i.size()) {
                PrevueBean prevueBean = this.i.get(i2);
                if (prevueBean != null) {
                    LogEx.d(F, "playNext " + prevueBean.getBegintime() + " PrevueCode " + prevueBean.getPrevuecode());
                    if (!TextUtils.equals(str, prevueBean.getPrevuecode())) {
                        Date d2 = x.d(prevueBean.getBegintime());
                        Date d3 = x.d(prevueBean.getEndtime());
                        Date b2 = s.b();
                        if (b2.after(d3)) {
                            if (!com.zte.iptvclient.android.common.j.i.d().a(d2, d3, str2) && TextUtils.equals("1", prevueBean.getStatus()) && TextUtils.equals("1", prevueBean.getTvod())) {
                                if (TextUtils.equals(c2, "1")) {
                                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.play_next_tvod));
                                    LogEx.d(F, "curent to play tvod duration" + prevueBean.getDuration());
                                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.b(prevueBean, false));
                                    return;
                                }
                                com.zte.iptvclient.android.common.customview.a.a.e.f fVar2 = new com.zte.iptvclient.android.common.customview.a.a.e.f(this.f5525d, -1, R.string.go_to_program, R.drawable.lock_dialog_rightbg, R.string.confirm, 0, R.drawable.lock_dialog_leftbg, R.string.common_cancel, 0, new c(prevueBean, z));
                                this.D = fVar2;
                                fVar2.a();
                                this.D.setCanceledOnTouchOutside(false);
                                return;
                            }
                            LogEx.d(F, "curent to play tvod limit for duration" + prevueBean.getDuration());
                            a(i2 + 1, prevueBean.getPrevuecode(), str2, z);
                            return;
                        }
                        if (b2.after(d2) && b2.before(d3)) {
                            if (TextUtils.equals(c2, "1")) {
                                a(z, prevueBean);
                                return;
                            }
                            if (z) {
                                com.zte.iptvclient.android.common.customview.a.a.e.f fVar3 = new com.zte.iptvclient.android.common.customview.a.a.e.f(this.f5525d, -1, R.string.go_to_channel, R.drawable.lock_dialog_rightbg, R.string.confirm, 0, R.drawable.lock_dialog_leftbg, R.string.common_cancel, 0, new d(prevueBean, z));
                                this.D = fVar3;
                                fVar3.a();
                                this.D.setCanceledOnTouchOutside(false);
                                return;
                            }
                            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(false, prevueBean.getChannelcode(), prevueBean.getColumncode()));
                            c();
                            return;
                        }
                        return;
                    }
                    a(i2 + 1, prevueBean.getPrevuecode(), str2, z);
                    return;
                }
                return;
            }
            if (this.f5524c.equals(format)) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(false, this.f5523b.getChannelcode(), this.f5523b.getColumncode()));
            } else {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.h());
            }
        }
    }

    private void a(boolean z, PrevueBean prevueBean) {
        com.zte.iptvclient.android.common.customview.a.a.e.f fVar = new com.zte.iptvclient.android.common.customview.a.a.e.f(this.f5525d, -1, R.string.go_to_program, R.drawable.lock_dialog_rightbg, R.string.confirm, 0, R.drawable.lock_dialog_leftbg, R.string.common_cancel, 0, new e(prevueBean, z));
        this.D = fVar;
        fVar.a();
        this.D.setCanceledOnTouchOutside(false);
    }

    private int a(String str, String str2, String str3) {
        if (this.i != null) {
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                PrevueBean prevueBean = this.i.get(i2);
                if (TextUtils.equals(prevueBean.getPrevuecode(), str) && TextUtils.equals(prevueBean.getChannelcode(), str2)) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public boolean a() {
        return this.w;
    }

    public void a(boolean z) {
        this.w = z;
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(ScheduleListBean scheduleListBean) {
        boolean z;
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            PrevueBean prevueBean = this.i.get(i2);
            LogEx.d(F, "节目单code = " + prevueBean.getPrevueid());
            Iterator<ScheduleBean> it2 = scheduleListBean.getData().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    break;
                }
                ScheduleBean next = it2.next();
                LogEx.d(F, "录制计划的节目单code = " + next.getPrevueid());
                if (TextUtils.equals(next.getPrevueid(), prevueBean.getPrevueid())) {
                    prevueBean.setScheduleid(next.getScheduleid());
                    z = true;
                    break;
                }
            }
            if (z) {
                prevueBean.setRecordstate("1");
            } else {
                prevueBean.setRecordstate("0");
            }
            this.m.a(i2, "clouddvr");
        }
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.c
    public void a(DeleteSchduleResultBean deleteSchduleResultBean) {
        LogEx.d(F, "删除的录制计划的ScheduleId = " + deleteSchduleResultBean.getScheduleid());
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            PrevueBean prevueBean = this.i.get(i2);
            LogEx.d(F, "已有节目单的scheduleid = " + prevueBean.getScheduleid());
            if (TextUtils.equals(prevueBean.getScheduleid(), deleteSchduleResultBean.getScheduleid())) {
                prevueBean.setRecordstate("0");
                LogEx.d(F, "移除该节目单的录制计划状态 = " + prevueBean.isRecording());
                this.m.a(i2, "clouddvr");
                return;
            }
        }
    }
}
