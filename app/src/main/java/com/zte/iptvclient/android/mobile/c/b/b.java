package com.zte.iptvclient.android.mobile.c.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.share.internal.ShareConstants;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.a.h;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.e.x.p;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.common.reminder.EPGServerTvReminderBean;
import com.zte.iptvclient.android.common.reminder.TvReminderManager;
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

/* compiled from: TvReminderFragment.java */
/* loaded from: classes.dex */
public class b extends com.zte.fragmentlib.b {
    private SmartRefreshLayout p;
    private RelativeLayout q;
    private ItemRemoveRecyclerView r;
    private com.zte.iptvclient.android.mobile.c.a.c s;
    private com.zte.iptvclient.android.mobile.c.a.a t;
    private List<PrevueBean> u;
    private com.zte.iptvclient.android.mobile.booking.ui.a v;
    private LinkedHashMap<Integer, String> w;
    private List<EPGServerTvReminderBean> x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvReminderFragment.java */
    /* loaded from: classes.dex */
    public class a implements com.scwang.smartrefresh.layout.d.c {
        a() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(h hVar) {
            b.this.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvReminderFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.c.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnTouchListenerC0194b implements View.OnTouchListener {
        ViewOnTouchListenerC0194b(b bVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvReminderFragment.java */
    /* loaded from: classes.dex */
    public class c implements com.zte.iptvclient.android.mobile.c.c.a {
        c() {
        }

        @Override // com.zte.iptvclient.android.mobile.c.c.a
        public void a(int i) {
            b.this.s.e(i);
            b.this.L();
            if (b.this.v != null) {
                b.this.r.b(b.this.v);
            }
            b.this.v = new com.zte.iptvclient.android.mobile.booking.ui.a(((com.zte.fragmentlib.b) b.this).h, b.this.w);
            b.this.r.a(b.this.v);
        }

        @Override // com.zte.iptvclient.android.mobile.c.c.a
        public void a(View view, int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvReminderFragment.java */
    /* loaded from: classes.dex */
    public class d implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        d() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("OnlineSubscribeFragment", "sdkQueryEPGServerTvReminderList data return : " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                ArrayList arrayList = new ArrayList();
                if (!jSONObject.getString("returncode").equals("0")) {
                    b.this.p.a();
                    return;
                }
                JSONArray jSONArray = jSONObject.getJSONArray("reminders");
                for (int i = 0; i < jSONArray.length(); i++) {
                    com.zte.iptvclient.android.common.reminder.c cVar = new com.zte.iptvclient.android.common.reminder.c();
                    cVar.b(jSONArray.getJSONObject(i).getString("contentcode"));
                    cVar.a(jSONArray.getJSONObject(i).getString("channelcode"));
                    arrayList.add(cVar);
                }
                b.this.b((ArrayList<com.zte.iptvclient.android.common.reminder.c>) arrayList);
            } catch (Exception e) {
                e.printStackTrace();
                b.this.r.setVisibility(8);
                b.this.q.setVisibility(0);
                b.this.p.a();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("OnlineSubscribeFragment", "sdkQueryEPGServerTvReminderList onFailReturn ,returncode : " + i + " , errormsg : " + str);
            b.this.r.setVisibility(8);
            b.this.q.setVisibility(0);
            b.this.p.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvReminderFragment.java */
    /* loaded from: classes.dex */
    public class e implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* compiled from: TvReminderFragment.java */
        /* loaded from: classes.dex */
        class a implements com.zte.iptvclient.android.mobile.c.c.a {
            a() {
            }

            @Override // com.zte.iptvclient.android.mobile.c.c.a
            public void a(int i) {
                b bVar = b.this;
                bVar.b((EPGServerTvReminderBean) bVar.x.get(i), false);
            }

            @Override // com.zte.iptvclient.android.mobile.c.c.a
            public void a(View view, int i) {
            }
        }

        e() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            e eVar = this;
            StringBuilder sb = new StringBuilder();
            String str2 = "posterimage";
            sb.append(" sdkQueryTvReminderList onDataReturn : ");
            sb.append(str);
            LogEx.d("OnlineSubscribeFragment", sb.toString());
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("returncode").equals("0")) {
                    if (b.this.x != null) {
                        b.this.x.clear();
                    } else {
                        b.this.x = new ArrayList();
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
                            eVar = this;
                            str2 = str3;
                            b.this.x.add(ePGServerTvReminderBean);
                            i++;
                            jSONArray = jSONArray2;
                        } catch (Exception e) {
                            e = e;
                            eVar = this;
                            e.printStackTrace();
                            b.this.r.setVisibility(8);
                            b.this.q.setVisibility(0);
                            b.this.p.a();
                        }
                    }
                    b.this.K();
                    if (b.this.v != null) {
                        b.this.r.b(b.this.v);
                    }
                    b.this.v = new com.zte.iptvclient.android.mobile.booking.ui.a(((com.zte.fragmentlib.b) b.this).h, b.this.w);
                    b.this.r.a(b.this.v);
                    if (b.this.s == null) {
                        b.this.t = new com.zte.iptvclient.android.mobile.c.a.a(((com.zte.fragmentlib.b) b.this).h, b.this.x);
                        b.this.r.a(new LinearLayoutManager(((com.zte.fragmentlib.b) b.this).h));
                        b.this.r.a(b.this.t);
                        b.this.r.a(2, new a());
                    }
                }
                if (b.this.x.size() == 0) {
                    b.this.r.setVisibility(8);
                    b.this.q.setVisibility(0);
                } else {
                    b.this.r.setVisibility(0);
                    b.this.q.setVisibility(8);
                }
            } catch (Exception e2) {
                e = e2;
            }
            b.this.p.a();
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("OnlineSubscribeFragment", " sdkQueryTvReminderList onFailReturn , returncode : " + i + " ,  errormsg : " + str);
            b.this.r.setVisibility(8);
            b.this.q.setVisibility(0);
            b.this.p.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TvReminderFragment.java */
    /* loaded from: classes.dex */
    public class f implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        f() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("OnlineSubscribeFragment", "sdkDoEPGServerTvReminder data return : " + str);
            try {
                if (new JSONObject(str).getString("returncode").equals("0")) {
                    b.this.M();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("OnlineSubscribeFragment", "returncode is " + i + " , errormsg is " + str);
        }
    }

    private String I() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("usertoken", com.zte.iptvclient.common.uiframe.a.d("UserToken"));
            jSONObject.put("usercode", com.zte.iptvclient.common.uiframe.a.d("UserID"));
            jSONObject.put("sorttype", 1);
            jSONObject.put("authinfo", g.a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        LogEx.d("OnlineSubscribeFragment", "convertToQueryJsonParams : " + jSONObject.toString());
        return jSONObject.toString();
    }

    private void J() {
        this.w = new LinkedHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        this.w.clear();
        if (this.x.size() == 0) {
            return;
        }
        a(0, a(this.x.get(0)));
        for (int i = 1; i < this.x.size(); i++) {
            if (!a(this.x.get(i - 1)).equalsIgnoreCase(a(this.x.get(i)))) {
                a(i, a(this.x.get(i)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        this.w.clear();
        if (this.u.size() == 0) {
            return;
        }
        a(0, a(this.u.get(0)));
        for (int i = 1; i < this.u.size(); i++) {
            if (!a(this.u.get(i - 1)).equalsIgnoreCase(a(this.u.get(i)))) {
                a(i, a(this.u.get(i)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        String replace = "http://{epgdomain}/iptvepg/serviceapi?servicetype=reminderquery".replace("http://{epgdomain}", i.b());
        LogEx.d("OnlineSubscribeFragment", "sdkQueryEPGServerTvReminderList url is : " + replace);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json; charset=GBK");
        sDKNetHTTPRequest.setBody(I());
        sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_POST, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        String readPropertie = ConfigMgr.readPropertie("SupportOrderReminderType");
        if (TextUtils.isEmpty(readPropertie)) {
            return;
        }
        int intValue = Integer.valueOf(readPropertie).intValue();
        if ((intValue & 1) <= 0) {
            if ((intValue & 4) > 0) {
                M();
                return;
            }
            return;
        }
        this.u = TvReminderManager.d();
        L();
        com.zte.iptvclient.android.mobile.booking.ui.a aVar = this.v;
        if (aVar != null) {
            this.r.b(aVar);
        }
        com.zte.iptvclient.android.mobile.booking.ui.a aVar2 = new com.zte.iptvclient.android.mobile.booking.ui.a(this.h, this.w);
        this.v = aVar2;
        this.r.a(aVar2);
        if (this.s == null) {
            this.s = new com.zte.iptvclient.android.mobile.c.a.c(this.h, this.u);
            this.r.a(new LinearLayoutManager(this.h));
            this.r.a(this.s);
            this.r.a(0, new c());
        }
        if (this.u.size() == 0) {
            this.r.setVisibility(8);
            this.q.setVisibility(0);
        } else {
            this.r.setVisibility(0);
            this.q.setVisibility(8);
        }
        this.p.c(2000);
    }

    private void O() {
        this.p.a(new a());
        this.r.setOnTouchListener(new ViewOnTouchListenerC0194b(this));
    }

    public static String s(String str) {
        Date t = t(str);
        return t == null ? "" : new SimpleDateFormat("MM/dd").format(t);
    }

    public static Date t(String str) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str, new ParsePosition(0));
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        O();
        N();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.tv_reminder_fragment_layout, viewGroup, false);
        d(inflate);
        J();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEventMainThread(p pVar) {
        this.s.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<com.zte.iptvclient.android.common.reminder.c> arrayList) {
        String str = "http://{epgdomain}/iptvepg/{frame}/get_prevueinfo.jsp".replace("http://{epgdomain}/iptvepg/{frame}/", i.f()) + "?prevuecodes=";
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayList.size(); i++) {
            stringBuffer.append(arrayList.get(i).b());
            if (i != arrayList.size() - 1) {
                stringBuffer.append(",");
            }
        }
        String str2 = str + stringBuffer.toString();
        LogEx.d("OnlineSubscribeFragment", "sdkQueryTvReminderList url is : " + str2);
        List<EPGServerTvReminderBean> list = this.x;
        if (list == null) {
            this.x = new ArrayList();
        } else {
            list.clear();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        sDKNetHTTPRequest.startRequest(str2, HttpRequest.METHOD_GET, new e());
    }

    private void d(View view) {
        this.r = (ItemRemoveRecyclerView) view.findViewById(R.id.tv_reminder_recyclerview);
        this.p = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_txt));
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.q = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.q.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.q.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.q.findViewById(R.id.refresh_image));
        this.q.setVisibility(8);
        this.p.a(new DefaultRefreshHeader(this.h));
        this.p.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.p;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.p;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.p.a(true);
        this.p.c(false);
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
            jSONObject.put("authinfo", g.a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        LogEx.d("OnlineSubscribeFragment", "json : " + jSONObject.toString());
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EPGServerTvReminderBean ePGServerTvReminderBean, boolean z) {
        String replace = "http://{epgdomain}/iptvepg/serviceapi?servicetype=reminderset".replace("http://{epgdomain}", i.b());
        LogEx.d("OnlineSubscribeFragment", "sdkDoEPGServerTvReminder url is : " + replace);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json; charset=GBK");
        sDKNetHTTPRequest.setBody(a(ePGServerTvReminderBean, z));
        sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_POST, new f());
    }

    private void a(int i, String str) {
        this.w.put(Integer.valueOf(i), str);
    }

    private String a(PrevueBean prevueBean) {
        if (prevueBean == null || TextUtils.isEmpty(prevueBean.getBegintime())) {
            return "";
        }
        String trim = prevueBean.getBegintime().trim();
        return trim.substring(0, trim.indexOf(" "));
    }

    private String a(EPGServerTvReminderBean ePGServerTvReminderBean) {
        return (ePGServerTvReminderBean == null || TextUtils.isEmpty(ePGServerTvReminderBean.getStart_time())) ? "" : s(ePGServerTvReminderBean.getStart_time().trim());
    }
}
