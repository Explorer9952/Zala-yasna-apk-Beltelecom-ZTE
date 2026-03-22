package com.zte.iptvclient.android.mobile.n.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import com.video.androidsdk.SDKMgr;
import com.video.androidsdk.common.AndroidUniqueCode;
import com.video.androidsdk.common.ClientNetworkInfo;
import com.video.androidsdk.common.GlobalDataMgr;
import com.video.androidsdk.common.ParamConst;
import com.video.androidsdk.common.PreferenceHelper;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.CrashFileUpLoadReq;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.log.SDKLogMgr;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.impl.IIPTVLogin;
import com.video.androidsdk.mes.SDKPushMsgMgr;
import com.video.androidsdk.player.common.UrlUtils;
import com.video.androidsdk.service.SDKUserMgr;
import com.video.androidsdk.service.SDKUserMgr4CELLC;
import com.video.androidsdk.service.auth.FeatureAuthAndOrderListReq;
import com.video.androidsdk.service.auth.SDKAuthMgr;
import com.video.androidsdk.service.auth.SDKSubscribeMgr;
import com.video.androidsdk.service.channel.SDKChannelMgr;
import com.video.androidsdk.service.column.SDKColumnMgr;
import com.video.androidsdk.service.comm.SDKCommonTool;
import com.video.androidsdk.service.userdata.GetUserDataReq;
import com.video.androidsdk.service.userdata.SDKUserDataMgr;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.function.service.PushMessageService;
import com.zte.iptvclient.android.common.function.service.UpdateUsertokenService;
import com.zte.iptvclient.android.common.j.k;
import com.zte.iptvclient.android.common.javabean.column.ColumnBean;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.ChannelTvodTsTimeBean;
import com.zte.iptvclient.android.common.javabean.models.Feature;
import com.zte.iptvclient.android.common.reminder.TvReminderManager;
import com.zte.iptvclient.android.common.reminder.VodReminderManager;
import com.zte.iptvclient.android.mobile.c0.d.a;
import com.zte.iptvclient.android.mobile.order.bean.OrderRecordBean;
import com.zte.iptvclient.android.zala.R;
import com.zte.sdk.enumclass.CapablityEnum;
import com.zte.servicesdk.util.PortalConst;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LoginImp.java */
/* loaded from: classes.dex */
public class b implements SDKLoginMgr.ISDKLoginReturnListener {
    private static b T = new b();
    private static int U = 0;
    private static boolean V = false;
    private File B;
    private String F;
    private String G;
    private ExecutorService J;
    private Timer P;
    private SDKPushMsgMgr Q;
    private ArrayList<String> h;
    private com.zte.iptvclient.android.common.j.h i;
    private SDKUserMgr n;
    private boolean v;
    private String z;

    /* renamed from: a, reason: collision with root package name */
    private int f6861a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f6862b = 1;

    /* renamed from: c, reason: collision with root package name */
    private int f6863c = 5;

    /* renamed from: d, reason: collision with root package name */
    private int f6864d = 6;
    private String e = "";
    private String f = "";
    private String g = "";
    private SDKLoginMgr j = null;
    private String k = "";
    private String l = "";
    private String m = "";
    private ClientNetworkInfo o = null;
    private Context p = null;
    boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private int w = com.zte.iptvclient.android.common.c.e.a.f4112a;
    private String x = "";
    private String y = "";
    private String A = "";
    private BroadcastReceiver C = null;
    private String D = "";
    private String E = "";
    private int H = 0;
    private Timer I = null;
    ArrayList<Channel> K = new ArrayList<>();
    private boolean L = false;
    private ArrayList<Channel> M = new ArrayList<>();
    private ArrayList<Channel> N = new ArrayList<>();
    private ArrayList<Channel> O = new ArrayList<>();
    private Handler R = new a();
    Runnable S = new i();

    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    class a extends Handler {

        /* compiled from: LoginImp.java */
        /* renamed from: com.zte.iptvclient.android.mobile.n.c.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0317a extends TimerTask {
            C0317a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                com.zte.iptvclient.android.common.e.o.c cVar = new com.zte.iptvclient.android.common.e.o.c();
                if (!b.this.L) {
                    b.this.L = true;
                }
                cVar.a(b.this.z);
                if (!b.this.q) {
                    cVar.b("account");
                } else {
                    cVar.b("guest");
                }
                EventBus.getDefault().post(cVar);
            }
        }

        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == b.this.f6861a) {
                if (b.this.r) {
                    b.this.w();
                }
                if (b.this.r && b.this.s) {
                    b.this.r = false;
                    b.this.s = false;
                    new Timer().schedule(new C0317a(), 1000L);
                }
            } else if (message.what == b.this.f6862b && b.this.t && b.this.u) {
                b.this.u = false;
                b.this.t = false;
                ArrayList<Channel> b2 = com.zte.iptvclient.android.common.j.i.d().b();
                ArrayList<ColumnBean> a2 = com.zte.iptvclient.android.common.j.j.e().a();
                if (b2 == null || b2.size() <= 0 || a2 == null || a2.size() <= 1) {
                    if (b.this.H < 3) {
                        if (b2 == null || b2.size() <= 0) {
                            b.this.d();
                        }
                        if (a2 == null || a2.size() <= 1) {
                            b.this.B();
                        }
                        b.E(b.this);
                    }
                } else {
                    b.this.H = 0;
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.r());
                }
            }
            if (message.what == b.this.f6863c) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.a0.b());
            }
            if (message.what == b.this.f6864d) {
                LogEx.d("LoginImp", "sdkFeatureAuthAndorderList");
                b.this.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginImp.java */
    /* renamed from: com.zte.iptvclient.android.mobile.n.c.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0318b implements SDKUserMgr.OnSetUserMediaServicesReturnListener {
        C0318b() {
        }

        @Override // com.video.androidsdk.service.SDKUserMgr.OnSetUserMediaServicesReturnListener
        public void onUserMediaServicesReturn(String str, String str2) {
            b.this.s = true;
            LogEx.d("LoginImp", " onUserMediaServicesReturn : arg0 = " + str + ",arg1 = " + str2);
            b.this.R.sendEmptyMessage(b.this.f6861a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    public class c extends TimerTask {
        c(b bVar) {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            LogEx.d("LoginImp", "initChannelList");
            com.zte.iptvclient.android.common.k.e.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    public class d implements SDKSubscribeMgr.OnGetSubscribeChannelReturnListener {
        d() {
        }

        @Override // com.video.androidsdk.service.auth.SDKSubscribeMgr.OnGetSubscribeChannelReturnListener
        public void onGetSubscribeChannelReturn(String str, String str2, String str3) {
            if (str3 == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str3);
                if ("0".equals(jSONObject.optString("returncode"))) {
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        b.this.K.add(Channel.getChannelFromJSon(jSONArray.getJSONObject(i)));
                    }
                    LogEx.d("LoginImp", "listSubscribedChannel=" + b.this.K.size());
                    com.zte.iptvclient.android.common.j.i.d().d(b.this.K);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            b.this.v = true;
            b.this.R.sendEmptyMessage(b.this.f6862b);
            b.this.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    public class e implements SDKChannelMgr.OnChannelListReturnListener {
        e() {
        }

        @Override // com.video.androidsdk.service.channel.SDKChannelMgr.OnChannelListReturnListener
        public void onChannelListReturn(String str, String str2, String str3) {
            LogEx.d("LoginImp", "sdkQueryRadioList query request channel:  onDataReturn,s2= " + str3);
            try {
                if ("0".equals(str)) {
                    if (b.this.O != null) {
                        b.this.O.clear();
                    } else {
                        b.this.O = new ArrayList();
                    }
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    if (b.this.O != null) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            b.this.O.add(Channel.getChannelFromJSon(jSONArray.getJSONObject(i)));
                        }
                    }
                    com.zte.iptvclient.android.common.j.i.d().c(b.this.O);
                    return;
                }
                LogEx.e("LoginImp", str2);
            } catch (Exception e) {
                LogEx.d("LoginImp", "sdkQueryRequestChannel:" + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    public class f implements SDKColumnMgr.OnColumnListReturnListener {
        f() {
        }

        @Override // com.video.androidsdk.service.column.SDKColumnMgr.OnColumnListReturnListener
        public void onColumnListReturn(String str, String str2, String str3) {
            LogEx.d("LoginImp", "onColumnListReturn " + str3);
            if ("0".equals(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    if (TextUtils.equals("0", jSONObject.optString("returncode"))) {
                        int optInt = jSONObject.optInt("totalcount");
                        JSONArray optJSONArray = jSONObject.optJSONArray("data");
                        ArrayList<ColumnBean> arrayList = new ArrayList<>();
                        if ("1".equals(ConfigMgr.readPropertie("isShowSub"))) {
                            ColumnBean columnBean = new ColumnBean();
                            columnBean.setColumnCode("");
                            columnBean.setColumnName(com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_subscribed));
                            arrayList.add(columnBean);
                        }
                        ColumnBean columnBean2 = new ColumnBean();
                        columnBean2.setColumnCode("");
                        columnBean2.setColumnName(com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_favorite));
                        arrayList.add(columnBean2);
                        if ("1".equals(ConfigMgr.readPropertie("isShowSub"))) {
                            ColumnBean columnBean3 = new ColumnBean();
                            columnBean3.setColumnCode("");
                            columnBean3.setColumnName(com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_unsubscribed));
                            arrayList.add(columnBean3);
                        }
                        for (int i = 0; i < optInt; i++) {
                            arrayList.add(ColumnBean.getColumnBeanFromJSon(optJSONArray.getJSONObject(i)));
                        }
                        ColumnBean columnBean4 = new ColumnBean();
                        columnBean4.setColumnCode("radio");
                        columnBean4.setColumnName(com.zte.iptvclient.android.common.i.a.a.a(R.string.detail_movie_radio));
                        arrayList.add(columnBean4);
                        com.zte.iptvclient.android.common.j.j.e().a(arrayList);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("LoginImp", "get getcolumn error");
                }
            }
            b.this.u = true;
            b.this.R.sendEmptyMessage(b.this.f6862b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    public class g implements SDKChannelMgr.OnChannelListReturnListener {
        g() {
        }

        @Override // com.video.androidsdk.service.channel.SDKChannelMgr.OnChannelListReturnListener
        public void onChannelListReturn(String str, String str2, String str3) {
            LogEx.i("LoginImp", "onChannelListReturn query request channel:  onDataReturn,s2= " + str3);
            if (b.this.M != null) {
                b.this.M.clear();
            }
            if (b.this.N != null) {
                b.this.N.clear();
            }
            try {
                if ("0".equals(str)) {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    int i = 0;
                    if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
                        if (b.this.N != null) {
                            while (i < jSONArray.length()) {
                                Channel channelFromJSon = Channel.getChannelFromJSon(jSONArray.getJSONObject(i));
                                if (channelFromJSon != null && channelFromJSon.getUsermixno().length() <= 3) {
                                    b.this.N.add(channelFromJSon);
                                }
                                i++;
                            }
                        }
                        b.this.A();
                    } else {
                        if (b.this.M != null) {
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                Channel channelFromJSon2 = Channel.getChannelFromJSon(jSONArray.getJSONObject(i2));
                                if (channelFromJSon2 != null && channelFromJSon2.getUsermixno().length() <= 3) {
                                    b.this.M.add(channelFromJSon2);
                                }
                            }
                        }
                        com.zte.iptvclient.android.common.j.i.d().e(b.this.M);
                        if (b.this.M != null && b.this.M.size() != 0) {
                            while (i < b.this.M.size()) {
                                if (((Channel) b.this.M.get(i)).getColumncode().equals(b.this.D)) {
                                    b.this.N.add(b.this.M.get(i));
                                }
                                i++;
                            }
                            com.zte.iptvclient.android.common.j.i.d().f(b.this.N);
                            if (b.t()) {
                                b.this.A();
                            }
                        }
                    }
                    b.this.t = true;
                    b.this.R.sendEmptyMessage(b.this.f6862b);
                }
            } catch (Exception e) {
                LogEx.d("LoginImp", "sdkQueryRequestChannel:" + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    public class h implements SDKUserDataMgr.OnGetUserDataReturnListener {

        /* compiled from: LoginImp.java */
        /* loaded from: classes.dex */
        class a implements Comparator<com.zte.iptvclient.android.common.javabean.models.b> {
            a(h hVar) {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(com.zte.iptvclient.android.common.javabean.models.b bVar, com.zte.iptvclient.android.common.javabean.models.b bVar2) {
                try {
                    int parseInt = Integer.parseInt(bVar.a());
                    int parseInt2 = Integer.parseInt(bVar2.a());
                    if (parseInt > parseInt2) {
                        return 1;
                    }
                    return parseInt == parseInt2 ? 0 : -1;
                } catch (NumberFormatException e) {
                    LogEx.d("NumberFormatException", e.toString());
                    return -1;
                }
            }
        }

        /* compiled from: LoginImp.java */
        /* renamed from: com.zte.iptvclient.android.mobile.n.c.b$h$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0319b extends TimerTask {
            C0319b(h hVar) {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.o.a());
            }
        }

        h() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.video.androidsdk.service.userdata.SDKUserDataMgr.OnGetUserDataReturnListener
        public void onGetUserDataReturn(String str, String str2, String str3) {
            LogEx.i("LoginImp", "sdkGetUserDateForChannelListNews  onDataReturn returncode=" + str + " errormsg " + str2 + " json= " + str3);
            if ("0".equals(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    String str4 = (String) jSONObject.get("returncode");
                    String str5 = (String) jSONObject.opt("datavalue");
                    if ("0".equals(str4) && !TextUtils.isEmpty(str5)) {
                        String decode = Uri.decode(Uri.decode(Uri.decode(str5)));
                        ArrayList arrayList = new ArrayList();
                        JSONObject jSONObject2 = new JSONObject(decode);
                        LogEx.d("LoginImp", "sdkGetUserDateForChannelListNews datavalue " + decode);
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            arrayList.add(com.zte.iptvclient.android.common.javabean.models.b.a(next, jSONObject2.getString(next)));
                        }
                        Collections.sort(arrayList, new a(this));
                        ArrayList arrayList2 = new ArrayList();
                        if (arrayList.size() >= b.this.N.size()) {
                            if (arrayList.size() >= b.this.N.size()) {
                                for (int i = 0; i < arrayList.size(); i++) {
                                    for (int i2 = 0; i2 < b.this.N.size(); i2++) {
                                        if (((com.zte.iptvclient.android.common.javabean.models.b) arrayList.get(i)).b().equals(((Channel) b.this.N.get(i2)).getMixno())) {
                                            ((Channel) b.this.N.get(i2)).setCustomsort(((com.zte.iptvclient.android.common.javabean.models.b) arrayList.get(i)).a());
                                            arrayList2.add(b.this.N.get(i2));
                                        }
                                    }
                                }
                                com.zte.iptvclient.android.common.j.i.d().f(arrayList2);
                                b.this.c((ArrayList<Channel>) arrayList2);
                                ArrayList arrayList3 = new ArrayList();
                                if (b.this.N != null) {
                                    for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                                        for (int i4 = 0; i4 < b.this.N.size(); i4++) {
                                            if (((Channel) arrayList2.get(i3)).getChannelcode().equals(((Channel) b.this.N.get(i4)).getChannelcode())) {
                                                arrayList3.add(b.this.N.get(i4));
                                            }
                                        }
                                    }
                                    if (arrayList3.size() != 0 && arrayList3.size() == b.this.N.size()) {
                                        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
                                            b.this.a((ArrayList<Channel>) arrayList3);
                                        } else {
                                            com.zte.iptvclient.android.common.j.i.d().f(arrayList3);
                                            b.this.c((ArrayList<Channel>) arrayList3);
                                        }
                                    } else if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
                                        b.this.a((ArrayList<Channel>) b.this.N);
                                    } else {
                                        com.zte.iptvclient.android.common.j.i.d().f(b.this.N);
                                        b.this.c((ArrayList<Channel>) b.this.N);
                                    }
                                }
                            }
                        } else {
                            com.zte.iptvclient.android.common.j.i.d().f(b.this.N);
                            b.this.c((ArrayList<Channel>) b.this.N);
                        }
                    } else if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
                        b.this.a((ArrayList<Channel>) b.this.N);
                    } else {
                        com.zte.iptvclient.android.common.j.i.d().f(b.this.N);
                        b.this.c((ArrayList<Channel>) b.this.N);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
                        b bVar = b.this;
                        bVar.a((ArrayList<Channel>) bVar.N);
                    } else {
                        com.zte.iptvclient.android.common.j.i.d().f(b.this.N);
                        b bVar2 = b.this;
                        bVar2.c((ArrayList<Channel>) bVar2.N);
                    }
                }
            } else if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
                b bVar3 = b.this;
                bVar3.a((ArrayList<Channel>) bVar3.N);
            } else {
                com.zte.iptvclient.android.common.j.i.d().f(b.this.N);
                b bVar4 = b.this;
                bVar4.c((ArrayList<Channel>) bVar4.N);
            }
            new Timer().schedule(new C0319b(this), 1500L);
        }
    }

    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.L();
            b.this.j();
            b.this.K();
            b.this.f();
            com.zte.iptvclient.android.common.j.a.d().a(b.this.p);
            if (b.t()) {
                b.this.x();
            }
            com.zte.iptvclient.android.common.i.a.b.a(SDKMgr.getApplicationContext());
            b.this.H();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    public class j implements SDKSubscribeMgr.OnUserOrderListReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f6874a;

        j(ArrayList arrayList) {
            this.f6874a = arrayList;
        }

        @Override // com.video.androidsdk.service.auth.SDKSubscribeMgr.OnUserOrderListReturnListener
        public void onUserOrderListReturn(String str, String str2, String str3) {
            LogEx.d("LoginImp", "queryOrderList data : " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.f6874a.add(OrderRecordBean.getOrderRecordBeanFromJSon(jSONArray.getJSONObject(i)));
                    }
                } catch (Exception e) {
                    LogEx.e("LoginImp", e.getMessage());
                }
            }
            com.zte.iptvclient.android.common.j.g.a().a(this.f6874a);
            if (b.this.R != null) {
                b.this.R.sendEmptyMessage(b.this.f6863c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    public class k implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        k() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("LoginImp", "query mobile info onDataReturn = " + str);
            try {
                b.this.a(str);
            } catch (Exception e) {
                com.zte.iptvclient.android.common.f.b.h.a().a("", "the Exception is" + e.getMessage());
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("LoginImp", "query mobile info returncode = " + i + ", errormsg = " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    public class l implements SDKLogMgr.OnCrashFileUploadReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f6877a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f6878b;

        l(File file, String str) {
            this.f6877a = file;
            this.f6878b = str;
        }

        @Override // com.video.androidsdk.log.SDKLogMgr.OnCrashFileUploadReturnListener
        public void onCrashFileUploadReturn(String str, String str2) {
            if (str.equals("0")) {
                if (b.this.B != null) {
                    LogEx.d("LoginImp", "deleteRetainCrash=" + b.this.B.getName());
                    com.zte.iptvclient.android.common.k.g.b(b.this.B.getAbsolutePath(), "delete");
                    b.this.B.delete();
                }
                this.f6877a.renameTo(new File(this.f6878b.replace("Crash_", "latestRetain_")));
                LogEx.d("LoginImp", "upload file,rename filename=" + this.f6877a.getName());
                LogEx.d("LoginImp", "rename latest Crash Log success!and upload latset Crash Log!");
                return;
            }
            LogEx.d("LoginImp", "onCrashFileUploadReturn error! arg0 = " + str + ",arg1 = " + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    public class m implements SDKLogMgr.OnCrashFileUploadReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f6880a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f6881b;

        m(b bVar, File file, String str) {
            this.f6880a = file;
            this.f6881b = str;
        }

        @Override // com.video.androidsdk.log.SDKLogMgr.OnCrashFileUploadReturnListener
        public void onCrashFileUploadReturn(String str, String str2) {
            LogEx.d("LoginImp", "onCrashFileUploadReturn arg0=" + str + "  arg1=" + str2);
            this.f6880a.renameTo(new File(this.f6881b.replace("Crash_", "delete_")));
            StringBuilder sb = new StringBuilder();
            sb.append("upload file,rename filename=");
            sb.append(this.f6880a.getName());
            LogEx.d("LoginImp", sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    public class n implements SDKAuthMgr.OnFeatureAuthAndOrderListReturnListener {
        n(b bVar) {
        }

        @Override // com.video.androidsdk.service.auth.SDKAuthMgr.OnFeatureAuthAndOrderListReturnListener
        public void onFeatureAuthAndOrderListReturn(String str, String str2, String str3) {
            LogEx.d("LoginImp", "onFeatureAuthAndOrderListReturn" + str + str2 + str3);
            if (TextUtils.equals("0", str)) {
                try {
                    JSONObject optJSONObject = new JSONObject(str3).optJSONObject("data");
                    optJSONObject.optJSONArray("productlist");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("orderproductlist");
                    ArrayList<Feature> arrayList = new ArrayList<>();
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(Feature.getChannelFromJSon(optJSONArray.getJSONObject(i)));
                        }
                    }
                    ArrayList<Feature> arrayList2 = new ArrayList<>();
                    ArrayList<Feature> arrayList3 = new ArrayList<>();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList<Feature> arrayList5 = new ArrayList<>();
                    ArrayList<Feature> arrayList6 = new ArrayList<>();
                    ArrayList<Feature> arrayList7 = new ArrayList<>();
                    ArrayList<Feature> arrayList8 = new ArrayList<>();
                    ArrayList<Feature> arrayList9 = new ArrayList<>();
                    String str4 = "";
                    if (arrayList.size() != 0) {
                        com.zte.iptvclient.android.common.j.c.e().b(arrayList);
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            if (arrayList.get(i2).getFeaturecode().equals("mixdevice")) {
                                arrayList2.add(arrayList.get(i2));
                            } else if (arrayList.get(i2).getFeaturecode().equals("mixonlinedevice")) {
                                arrayList3.add(arrayList.get(i2));
                            } else if (arrayList.get(i2).getFeaturecode().contains("definition")) {
                                arrayList4.add(arrayList.get(i2));
                            } else if (arrayList.get(i2).getFeaturecode().equals("remote")) {
                                arrayList5.add(arrayList.get(i2));
                            } else if (arrayList.get(i2).getFeaturecode().equals("mixplayback")) {
                                arrayList6.add(arrayList.get(i2));
                            } else if (arrayList.get(i2).getFeaturecode().equals("childrenframe")) {
                                arrayList7.add(arrayList.get(i2));
                            } else if (arrayList.get(i2).getFeaturecode().equals("megogoFeature")) {
                                arrayList8.add(arrayList.get(i2));
                            } else if (arrayList.get(i2).getFeaturecode().equals("iviFeature")) {
                                arrayList9.add(arrayList.get(i2));
                            }
                        }
                        ArrayList arrayList10 = new ArrayList();
                        if (arrayList4.size() > 0) {
                            for (int i3 = 0; i3 < arrayList4.size(); i3++) {
                                if (i3 == 0) {
                                    arrayList10.add(arrayList4.get(0));
                                    str4 = ((Feature) arrayList4.get(0)).getFeaturevalue();
                                }
                                try {
                                    String featurevalue = ((Feature) arrayList4.get(i3)).getFeaturevalue();
                                    if (!TextUtils.isEmpty(featurevalue) && !TextUtils.isEmpty(str4) && Long.parseLong(featurevalue) > Long.parseLong(str4)) {
                                        arrayList10.clear();
                                        arrayList10.add(arrayList4.get(i3));
                                    }
                                } catch (NumberFormatException e) {
                                    LogEx.e("LoginImp", "getgetFeaturevalue getException" + e.getMessage());
                                }
                            }
                        }
                        com.zte.iptvclient.android.common.j.c.e().f(arrayList2);
                        com.zte.iptvclient.android.common.j.c.e().g(arrayList3);
                        if (arrayList10.size() > 0) {
                            com.zte.iptvclient.android.common.j.c.e().a(((Feature) arrayList10.get(0)).getFeaturevalue());
                        }
                        com.zte.iptvclient.android.common.j.c.e().h(arrayList5);
                        com.zte.iptvclient.android.common.j.c.e().a(arrayList7);
                        com.zte.iptvclient.android.common.j.c.e().d(arrayList6);
                        com.zte.iptvclient.android.common.j.c.e().e(arrayList8);
                        com.zte.iptvclient.android.common.j.c.e().c(arrayList9);
                        return;
                    }
                    com.zte.iptvclient.android.common.j.c.e().b(arrayList);
                    com.zte.iptvclient.android.common.j.c.e().f(arrayList2);
                    com.zte.iptvclient.android.common.j.c.e().g(arrayList3);
                    com.zte.iptvclient.android.common.j.c.e().a("");
                    com.zte.iptvclient.android.common.j.c.e().h(arrayList5);
                    com.zte.iptvclient.android.common.j.c.e().a(arrayList7);
                    com.zte.iptvclient.android.common.j.c.e().d(arrayList6);
                    com.zte.iptvclient.android.common.j.c.e().e(arrayList8);
                    com.zte.iptvclient.android.common.j.c.e().c(arrayList9);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    public class o implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        o(b bVar) {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("LoginImp", "queryTvodTsTime " + str);
            ArrayList<ChannelTvodTsTimeBean> arrayList = new ArrayList<>();
            ArrayList<ChannelTvodTsTimeBean> arrayList2 = new ArrayList<>();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("returncode").equals("0")) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.getString("data"));
                    JSONArray jSONArray = jSONObject2.getJSONArray("tvodchannellist");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(ChannelTvodTsTimeBean.getPlayChannelBeanFromJSon(jSONArray.getJSONObject(i)));
                    }
                    com.zte.iptvclient.android.common.j.i.d().b(arrayList);
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("tstvchannellist");
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        arrayList2.add(ChannelTvodTsTimeBean.getPlayChannelBeanFromJSon(jSONArray2.getJSONObject(i2)));
                    }
                    com.zte.iptvclient.android.common.j.i.d().a(arrayList2);
                    return;
                }
                if (jSONObject.getString("returncode").equals("50119220")) {
                    LogEx.d("LoginImp", "queryTvodTsTime current on emergency state!");
                    ChannelTvodTsTimeBean channelTvodTsTimeBean = new ChannelTvodTsTimeBean();
                    channelTvodTsTimeBean.setChannelcode("50119220");
                    arrayList.add(channelTvodTsTimeBean);
                    ChannelTvodTsTimeBean channelTvodTsTimeBean2 = new ChannelTvodTsTimeBean();
                    channelTvodTsTimeBean2.setChannelcode("50119220");
                    arrayList2.add(channelTvodTsTimeBean2);
                    com.zte.iptvclient.android.common.j.i.d().b(arrayList);
                    com.zte.iptvclient.android.common.j.i.d().a(arrayList2);
                    return;
                }
                com.zte.iptvclient.android.common.j.i.d().b((ArrayList<ChannelTvodTsTimeBean>) null);
                com.zte.iptvclient.android.common.j.i.d().a((ArrayList<ChannelTvodTsTimeBean>) null);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("LoginImp", "queryTvodTsTime onFailReturn returncode=" + i + " errormsg " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    public class p extends BroadcastReceiver {
        p() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null) {
                return;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && NetworkInfo.State.CONNECTED.equals(activeNetworkInfo.getState())) {
                LogEx.d("LoginImp", "@@@@@@@@@current login status : " + com.zte.iptvclient.common.uiframe.b.c().a());
                if (2 == com.zte.iptvclient.common.uiframe.b.c().a() || 5 == com.zte.iptvclient.common.uiframe.b.c().a() || 1 == com.zte.iptvclient.common.uiframe.b.c().a()) {
                    return;
                }
                if (b.this.b(context) == 0) {
                    if (!b.this.L) {
                        if (!b.this.p()) {
                            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.network_exception_please_try_later);
                            LogEx.w("LoginImp", "initLogin failed");
                            return;
                        }
                    } else if (!b.this.q()) {
                        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.network_exception_please_try_later);
                        LogEx.w("LoginImp", "initLogin failed");
                        return;
                    }
                    if (com.zte.iptvclient.common.uiframe.b.c().a() == 0) {
                        b.this.G();
                        return;
                    }
                    return;
                }
                LogEx.e("LoginImp", "getNetInfo failed");
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.server_connect_fail);
                return;
            }
            LogEx.d("LoginImp", "@@@@@@@@@ netInfo is null or state is disconnect ");
        }
    }

    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    class q implements SDKUserMgr.OnSetUserLanguageReturnListener {
        q(b bVar) {
        }

        @Override // com.video.androidsdk.service.SDKUserMgr.OnSetUserLanguageReturnListener
        public void onUserLanguageReturn(String str, String str2) {
            LogEx.d("LoginImp", " onUserLanguageReturn : arg0 = " + str + ",arg1 = " + str2);
        }
    }

    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    class r implements SDKUserMgr.OnSetUserMediaServicesReturnListener {
        r(b bVar) {
        }

        @Override // com.video.androidsdk.service.SDKUserMgr.OnSetUserMediaServicesReturnListener
        public void onUserMediaServicesReturn(String str, String str2) {
            LogEx.d("LoginImp", " onUserMediaServicesReturn : arg0 = " + str + ",arg1 = " + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    public class s implements SDKUserMgr4CELLC.OnBindTerminalDeviceReturnListener {
        s(b bVar) {
        }

        @Override // com.video.androidsdk.service.SDKUserMgr4CELLC.OnBindTerminalDeviceReturnListener
        public void onBindTerminalDeviceReturn(String str, String str2) {
        }
    }

    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    class t implements a.b {
        t(b bVar) {
        }

        @Override // com.zte.iptvclient.android.mobile.c0.d.a.b
        public void a(String str) {
            LogEx.d("LoginImp", "onBalanceReturn=" + str);
        }

        @Override // com.zte.iptvclient.android.mobile.c0.d.a.b
        public void a() {
            LogEx.d("LoginImp", "onBalanceonFailReturn");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    public class u implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        u(b bVar) {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("LoginImp", "setUserInfo info onDataReturn = " + str);
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("LoginImp", "setUserInfo info returncode = " + i + ", errormsg = " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    public class v implements SDKCommonTool.OnGetEPGTimeReturnListener {
        v(b bVar) {
        }

        @Override // com.video.androidsdk.service.comm.SDKCommonTool.OnGetEPGTimeReturnListener
        public void onGetEPGTimeReturn(String str, String str2) {
            com.zte.iptvclient.android.common.k.s.a(str, str2);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                LogEx.e("LoginImp", "getEPGTime is error!");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    public class w implements SDKUserMgr.OnSetUserLanguageReturnListener {
        w() {
        }

        @Override // com.video.androidsdk.service.SDKUserMgr.OnSetUserLanguageReturnListener
        public void onUserLanguageReturn(String str, String str2) {
            LogEx.d("LoginImp", " onUserLanguageReturn : arg0 = " + str + ",arg1 = " + str2);
            if (!TextUtils.equals(str, "0")) {
                LogEx.e("LoginImp", " UserLanguageSetted Faild! for" + str + "error msg " + str2);
            }
            b.this.r = true;
            b.this.R.sendEmptyMessage(b.this.f6861a);
        }
    }

    /* compiled from: LoginImp.java */
    /* loaded from: classes.dex */
    class x extends TimerTask {
        x() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = b.this.f6864d;
            b.this.R.sendMessage(message);
        }
    }

    private b() {
    }

    static /* synthetic */ int E(b bVar) {
        int i2 = bVar.H;
        bVar.H = i2 + 1;
        return i2;
    }

    private void F() {
        this.r = false;
        this.n.setUserLanguage(com.zte.iptvclient.android.common.i.a.a.a(R.string.login_set_language), new w());
        this.s = false;
        this.n.setUserMediaservice("2", new C0318b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.p.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return;
        }
        LogEx.d("LoginImp", "The network is available.");
        if (this.i.r() && !StringUtil.isEmptyString(this.i.V()) && !StringUtil.isEmptyString(this.i.D()) && !this.i.V().equals(this.F)) {
            a(this.i.V(), this.i.D());
        } else {
            a(this.F, this.G);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        String str = ConfigMgr.getApplicationExceptionFilePath() + "ZALAMobile/";
        File file = new File(str);
        LogEx.d("LoginImp", "strFilePath=" + str);
        ArrayList<File> arrayList = new ArrayList<>();
        if (!file.exists()) {
            file.mkdirs();
            return;
        }
        String d2 = com.zte.iptvclient.android.common.k.o.j().d();
        this.A = d2;
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        synchronized (this) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (!file2.isDirectory()) {
                        String absolutePath = file2.getAbsolutePath();
                        LogEx.d("LoginImp", "ready mDelete file,filename=" + absolutePath);
                        if (absolutePath.trim().toLowerCase().contains("delete_")) {
                            com.zte.iptvclient.android.common.k.g.b(file2.getAbsolutePath(), "delete");
                            file2.delete();
                        } else if (absolutePath.trim().toLowerCase().contains("crash_")) {
                            arrayList.add(file2);
                        } else if (absolutePath.trim().toLowerCase().contains("latestretain_")) {
                            this.B = file2;
                        } else {
                            LogEx.d("LoginImp", "unexpect file,filename=" + absolutePath);
                        }
                    }
                }
            }
            b(arrayList);
        }
    }

    private void I() {
        try {
            SDKUserMgr4CELLC sDKUserMgr4CELLC = new SDKUserMgr4CELLC();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("terminaltype", l());
            hashMap.put("devicecode", this.m);
            hashMap.put("stbmac", this.l);
            hashMap.put("deviceinfo", URLEncoder.encode(Build.MODEL + CapablityEnum.SPLIT_CODE + "Android" + Build.VERSION.RELEASE, "UTF-8"));
            Log.d("bindTerminalDevice", hashMap.toString());
            sDKUserMgr4CELLC.bindTerminalDevice(hashMap, new s(this));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }

    private void J() {
        new SDKCommonTool().getEPGTime(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        this.i.h(com.zte.iptvclient.android.common.f.b.i.b());
        this.i.E(com.zte.iptvclient.android.common.f.b.i.h());
        this.i.i(com.zte.iptvclient.android.common.f.b.i.d());
        this.i.j(com.zte.iptvclient.android.common.f.b.i.e());
        this.i.z(SDKLoginMgr.getInstance().getPropertiesInfo("Recommend_Server"));
        this.i.l(SDKLoginMgr.getInstance().getPropertiesInfo("IMP_Server"));
        if (!StringUtil.isEmptyString(com.zte.iptvclient.common.uiframe.a.c("Android_Upgrade_Page"))) {
            LogEx.d("LoginImp", "PortalProperty Android_Upgrade_Page=" + com.zte.iptvclient.common.uiframe.a.c("Android_Upgrade_Page"));
            if (!this.i.S().equalsIgnoreCase(com.zte.iptvclient.common.uiframe.a.c("Android_Upgrade_Page"))) {
                this.i.I(com.zte.iptvclient.common.uiframe.a.c("Android_Upgrade_Page"));
            }
        } else {
            LogEx.w("LoginImp", "get PortalProperty Android_Upgrade_Page is faild!");
        }
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Resource_Upgrade_Server");
        if (!StringUtil.isEmptyString(c2)) {
            LogEx.d("LoginImp", "PortalProperty Resource_Upgrade_Server=" + c2);
            if (!this.i.R().equalsIgnoreCase(c2)) {
                this.i.H(c2);
            }
        } else {
            LogEx.w("LoginImp", "get PortalProperty Resource_Upgrade_Server is faild!");
        }
        String hTTPSessionID = SDKLoginMgr.getInstance().getHTTPSessionID();
        String ePGHost = SDKLoginMgr.getInstance().getEPGHost();
        String d2 = com.zte.iptvclient.common.uiframe.a.d("StypeUrl");
        com.zte.iptvclient.android.common.c.b.d("JSESSIONID=" + hTTPSessionID);
        com.zte.iptvclient.android.common.c.b.b(d2);
        com.zte.iptvclient.android.common.c.b.a(ePGHost);
        com.zte.iptvclient.android.common.c.b.c(com.zte.iptvclient.common.uiframe.a.d("iemg"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (this.i == null) {
            this.i = new com.zte.iptvclient.android.common.j.h(this.p);
        }
        this.i.a(com.zte.iptvclient.common.uiframe.a.c("APP_Market_Access_Token"));
        this.i.c(com.zte.iptvclient.common.uiframe.a.c("Android_APPID"));
        this.i.g(com.zte.iptvclient.common.uiframe.a.c("APP_Market_Channel_Uid"));
        this.i.r(com.zte.iptvclient.common.uiframe.a.c("APP_Market_URL"));
    }

    @Override // com.video.androidsdk.login.SDKLoginMgr.ISDKLoginReturnListener
    public void onHeartbeatReturn(String str, String str2) {
        LogEx.d("LoginImp", "onHeartbeatReturn returncode=" + str + "  msg=" + str2);
        if ("0".equals(str)) {
            SDKUserMgr sDKUserMgr = this.n;
            if (sDKUserMgr == null) {
                return;
            }
            sDKUserMgr.setUserLanguage(com.zte.iptvclient.android.common.i.a.a.a(R.string.login_set_language), new q(this));
            this.n.setUserMediaservice("2", new r(this));
            return;
        }
        com.zte.iptvclient.common.uiframe.b.c().a(0);
    }

    @Override // com.video.androidsdk.login.SDKLoginMgr.ISDKLoginReturnListener
    public void onLoginReturn(String str, String str2) {
        this.z = str;
        LogEx.d("LoginImp", "onLoginReturn arg0 : " + str + " , arg1 : " + str2);
        V = true;
        if ("0".equals(str)) {
            if (!this.q) {
                this.P = new Timer(true);
                this.P.schedule(new x(), 0L, 300000L);
            }
            com.zte.iptvclient.android.mobile.c0.d.a.a(new t(this), this.p);
            if (this.n != null) {
                F();
            }
            UrlUtils.clearCaches();
            J();
            I();
            this.i.o("0");
            v();
            if (this.w == com.zte.iptvclient.android.common.c.e.a.f4113b) {
                LogEx.d("LoginImp", "username is : " + com.zte.iptvclient.common.uiframe.a.d("UserID"));
                this.i.K(com.zte.iptvclient.common.uiframe.a.d("UserID"));
                this.i.x(com.zte.iptvclient.common.uiframe.a.d(ParamConst.LOGIN_BMS_TRANSACTIONTOKEN));
            } else {
                this.i.K(this.e);
                this.i.x(this.f);
            }
            com.zte.iptvclient.android.mobile.download.helper.c.c.a(this.i.V(), this.p.getApplicationContext());
            if (this.q) {
                com.zte.iptvclient.common.uiframe.b.c().a(5);
                this.i.J(ConfigMgr.readPropertie("GuestName"));
            } else {
                E();
                a();
                com.zte.iptvclient.common.uiframe.b.c().a(2);
                b(this.e);
                this.i.v(this.e);
                this.i.p(SDKLoginMgr.getInstance().getUserInfo(com.video.androidsdk.service.comm.ParamConst.LOGIN_PORTALAUTH_RSP_LIMITPWD));
                LogEx.d("LoginImp", "megogoAuth");
                u();
            }
            D();
            s();
            this.H = 0;
            com.zte.iptvclient.android.mobile.ivi.a.i();
            return;
        }
        if (!this.z.equals("17101004") && !this.z.equals("17101001")) {
            com.zte.iptvclient.common.uiframe.b.c().a(0);
            this.i.o("1");
            this.i.m("");
            com.zte.iptvclient.android.common.e.o.c cVar = new com.zte.iptvclient.android.common.e.o.c();
            if (!this.L) {
                this.L = true;
            }
            cVar.a(this.z);
            EventBus.getDefault().post(cVar);
            s();
            com.zte.iptvclient.android.common.f.b.h.a().a(str, com.zte.iptvclient.android.common.c.a.getString(this.p.getResources().getString(R.string.login_failed), Integer.parseInt(str)));
            return;
        }
        com.zte.iptvclient.android.common.e.o.c cVar2 = new com.zte.iptvclient.android.common.e.o.c();
        if (!this.L) {
            this.L = true;
        }
        cVar2.a(this.z);
        EventBus.getDefault().post(cVar2);
    }

    @Override // com.video.androidsdk.login.SDKLoginMgr.ISDKLoginReturnListener
    public void onLogoutReturn(String str, String str2) {
        LogEx.d("UseeTv", "===onLogoutReturn=");
        Timer timer = this.P;
        if (timer != null) {
            timer.cancel();
            this.P.purge();
            this.P = null;
        }
        ArrayList<Feature> arrayList = new ArrayList<>();
        ArrayList<Feature> arrayList2 = new ArrayList<>();
        ArrayList<Feature> arrayList3 = new ArrayList<>();
        ArrayList<Feature> arrayList4 = new ArrayList<>();
        ArrayList<Feature> arrayList5 = new ArrayList<>();
        ArrayList<Feature> arrayList6 = new ArrayList<>();
        ArrayList<Feature> arrayList7 = new ArrayList<>();
        ArrayList<Feature> arrayList8 = new ArrayList<>();
        com.zte.iptvclient.android.common.j.c.e().b(arrayList6);
        com.zte.iptvclient.android.common.j.c.e().f(arrayList);
        com.zte.iptvclient.android.common.j.c.e().g(arrayList2);
        com.zte.iptvclient.android.common.j.c.e().a("");
        com.zte.iptvclient.android.common.j.c.e().h(arrayList3);
        com.zte.iptvclient.android.common.j.c.e().a(arrayList4);
        com.zte.iptvclient.android.common.j.c.e().d(arrayList5);
        com.zte.iptvclient.android.common.j.c.e().e(arrayList7);
        com.zte.iptvclient.android.common.j.c.e().c(arrayList8);
        a(ConfigMgr.readPropertie("GuestName"), ConfigMgr.readPropertie("GuestPassword"));
    }

    @Override // com.video.androidsdk.login.SDKLoginMgr.ISDKLoginReturnListener
    public void onOtherRecvReturn(int i2, String str, String str2) {
    }

    @Override // com.video.androidsdk.login.SDKLoginMgr.ISDKLoginReturnListener
    public void onRefreshUserTokeReturn(int i2, String str, String str2) {
        LogEx.d("LoginImp", "errorCode : " + i2 + " , errorMsg :" + str + ", userTokenExpiredTime:" + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        LogEx.d("LoginImp", "sdkGetUserDateForChannelListNews");
        SDKUserDataMgr sDKUserDataMgr = new SDKUserDataMgr();
        GetUserDataReq getUserDataReq = new GetUserDataReq();
        getUserDataReq.datatype = "8";
        sDKUserDataMgr.getUserData(getUserDataReq, new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        this.u = false;
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("TV_Column");
        this.E = propertiesInfo;
        if (com.zte.iptvclient.android.common.j.j.e().a() != null) {
            com.zte.iptvclient.android.common.j.j.e().a().clear();
        }
        SDKColumnMgr sDKColumnMgr = new SDKColumnMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("columncode", propertiesInfo);
        hashMap.put("ordertype", DownloadConstant.REPORT_MSGTYPE_ADD);
        sDKColumnMgr.getColumnList(hashMap, new f());
    }

    private void C() {
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Radio_Column");
        if (StringUtil.isEmptyString(propertiesInfo)) {
            com.zte.iptvclient.android.common.f.b.h.a().a("", "sdkQueryRadioList, the rootColumn is null");
            propertiesInfo = "";
        }
        if (com.zte.iptvclient.android.common.j.i.d().a() != null) {
            com.zte.iptvclient.android.common.j.i.d().a().clear();
        }
        SDKChannelMgr sDKChannelMgr = new SDKChannelMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("columncode", propertiesInfo);
        hashMap.put("ordertype", "4");
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", "500");
        sDKChannelMgr.getChannelList(hashMap, new e());
    }

    private void D() {
        this.u = false;
        ArrayList<Channel> arrayList = this.K;
        if (arrayList != null) {
            arrayList.clear();
        }
        new SDKSubscribeMgr().getSubscribeChannel(new d());
    }

    private void E() {
        String replace = "http://{ipadd:port}/iptvepg/{frame}/sdk_setuserinfo.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f());
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("profilecode", com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a() ? "1" : "0");
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_GET, new u(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        String b2 = this.i.b();
        this.g = b2;
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        String[] split = this.g.split(",");
        if (split.length > 0) {
            this.h.clear();
            for (String str : split) {
                this.h.add(str);
            }
            LogEx.d("LoginImp", "mAccountHistoryListget=" + this.h.size());
        }
    }

    public static b k() {
        return T;
    }

    private String l() {
        return BaseApp.a(this.p) ? "8" : "2";
    }

    private void m() {
        com.zte.iptvclient.android.mobile.f.b.a.b(this.p);
        com.zte.iptvclient.android.mobile.f.b.a.a(this.p).b();
        com.zte.iptvclient.android.mobile.f.b.a.a(this.p).a();
        com.zte.iptvclient.android.mobile.f.b.a.a(this.p).e();
        com.zte.iptvclient.android.mobile.f.b.a.a(this.p).d();
        com.zte.iptvclient.android.mobile.f.b.a.a(this.p).c();
    }

    private String n() {
        try {
            return this.p.getPackageManager().getPackageInfo(this.p.getPackageName(), 0).versionName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean o() {
        return V;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        if (this.j == null) {
            SDKLoginMgr sDKLoginMgr = SDKLoginMgr.getInstance();
            this.j = sDKLoginMgr;
            sDKLoginMgr.setLoginReturnListener(this);
            this.j.setHomePage(com.zte.iptvclient.common.uiframe.h.readPropertie(IIPTVLogin.LOGIN_HOMEPAGE, null));
            String readPropertie = ConfigMgr.readPropertie("IsDividePlat");
            if (!TextUtils.isEmpty(readPropertie) && readPropertie.equals("1")) {
                this.j.setLoginType(4);
            } else {
                this.j.setLoginType(0);
            }
        }
        LogEx.d("LoginImp", "initLogin ");
        String l2 = l();
        SDKLoginMgr sDKLoginMgr2 = this.j;
        String str = this.k;
        String str2 = this.l;
        String str3 = this.m;
        int initLogin = sDKLoginMgr2.initLogin(l2, str, str2, str3, str3);
        if (initLogin == 0) {
            return true;
        }
        LogEx.w("LoginImp", "initLogin returnCode : " + initLogin);
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.login_failed);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        SDKLoginMgr sDKLoginMgr = SDKLoginMgr.getInstance();
        this.j = sDKLoginMgr;
        sDKLoginMgr.setLoginReturnListener(this);
        this.j.setHomePage(com.zte.iptvclient.common.uiframe.h.readPropertie("HomePageBak", null));
        String readPropertie = ConfigMgr.readPropertie("IsDividePlat");
        if (!TextUtils.isEmpty(readPropertie) && readPropertie.equals("1")) {
            this.j.setLoginType(4);
        } else {
            this.j.setLoginType(0);
        }
        String l2 = l();
        SDKLoginMgr sDKLoginMgr2 = this.j;
        String str = this.k;
        String str2 = this.l;
        String str3 = this.m;
        int initLogin = sDKLoginMgr2.initLogin(l2, str, str2, str3, str3);
        LogEx.d("LoginImp", "initLoginBck ");
        if (initLogin == 0) {
            return true;
        }
        LogEx.w("LoginImp", "initLogin returnCode : " + initLogin);
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.login_failed);
        return false;
    }

    private void r() {
        this.C = new p();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.setPriority(1000);
        this.p.registerReceiver(this.C, intentFilter);
    }

    private void s() {
        com.zte.iptvclient.android.common.f.b.h.a().a(this.p);
    }

    public static boolean t() {
        return 2 == com.zte.iptvclient.common.uiframe.b.c().a();
    }

    private void u() {
        new com.zte.iptvclient.android.common.player.d(this.p).a("2", "");
    }

    private void v() {
        this.J.submit(this.S);
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        m();
        com.zte.iptvclient.android.common.j.k.i().a((k.e) null);
        if (TextUtils.equals("1", ConfigMgr.readPropertie("IsSupportVODPCT", "0"))) {
            com.zte.iptvclient.android.common.j.k.i().a((k.f) null);
        } else {
            com.zte.iptvclient.android.common.j.k.i().f();
        }
        if (com.zte.iptvclient.android.mobile.e0.f.c.a()) {
            com.zte.iptvclient.android.common.j.k.i().e();
        }
        g();
        b();
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.i.P("");
        this.i.Q("");
        String str = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=" + com.zte.iptvclient.common.uiframe.a.d("UserID");
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.startRequest(str, HttpRequest.METHOD_GET, new k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        String replace = "http://{ipadd:port}/iptvepg/{frame}/sdk_querytvodtstime.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f());
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        LogEx.d("LoginImp", "queryTvodTsTime " + replace);
        sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_GET, new o(this));
    }

    private void z() {
        Intent intent = new Intent();
        intent.setPackage(this.p.getPackageName());
        intent.setAction(UpdateUsertokenService.class.getName());
        this.p.stopService(intent);
        this.p.startService(intent);
        Intent intent2 = new Intent();
        intent2.setPackage(this.p.getPackageName());
        intent2.setAction(PushMessageService.class.getName());
        this.p.stopService(intent2);
        this.p.startService(intent2);
        Intent intent3 = new Intent();
        intent3.setPackage(this.p.getPackageName());
        intent3.setAction(TvReminderManager.class.getName());
        this.p.stopService(intent3);
        this.p.startService(intent3);
        Intent intent4 = new Intent();
        intent4.setPackage(this.p.getPackageName());
        intent4.setAction(VodReminderManager.class.getName());
        this.p.stopService(intent4);
        this.p.startService(intent4);
    }

    public void g() {
        B();
        d();
        C();
    }

    public void h() {
        LogEx.d("UseeTv", "===post LogoutReturnEvent=");
        com.zte.iptvclient.android.common.j.h hVar = this.i;
        hVar.K(hVar.V());
        this.i.x("");
        com.zte.iptvclient.common.uiframe.b.c().a(0);
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.o.d());
        this.i.d("");
        SDKPushMsgMgr sDKPushMsgMgr = SDKPushMsgMgr.getInstance();
        this.Q = sDKPushMsgMgr;
        sDKPushMsgMgr.uninitMesClient();
        Timer timer = this.I;
        if (timer != null) {
            timer.cancel();
        }
        this.i.l(false);
        this.i.m("");
        this.i.u("");
        this.i.J("");
        this.i.y("");
        com.zte.iptvclient.common.uiframe.b.c().a(3);
        LogEx.d("LoginImp", "mSdkLoginMgr.startLogout");
        this.j.startLogout();
        Intent intent = new Intent();
        intent.setAction("FloatWindowClose");
        this.p.getApplicationContext().sendBroadcast(intent);
    }

    public void i() {
        Context context;
        BroadcastReceiver broadcastReceiver = this.C;
        if (broadcastReceiver == null || (context = this.p) == null) {
            return;
        }
        context.unregisterReceiver(broadcastReceiver);
        this.C = null;
    }

    public void d() {
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            this.E = SDKLoginMgr.getInstance().getPropertiesInfo("ChildMode_TV_Column");
            this.i.n(true);
        } else {
            this.E = SDKLoginMgr.getInstance().getPropertiesInfo("TV_Column");
            com.zte.iptvclient.android.mobile.f.b.a.a(this.p).e();
        }
        this.D = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL);
        LogEx.d("LoginImp", "sdkQueryAllChannelList");
        this.t = false;
        String str = this.E;
        if (StringUtil.isEmptyString(str)) {
            com.zte.iptvclient.android.common.f.b.h.a().a("", "sdkQueryAllChannelList, the rootColumn is null");
            str = "";
        }
        if (com.zte.iptvclient.android.common.j.i.d().b() != null) {
            com.zte.iptvclient.android.common.j.i.d().b().clear();
        }
        SDKChannelMgr sDKChannelMgr = new SDKChannelMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("columncode", str);
        hashMap.put("ordertype", "4");
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", "500");
        sDKChannelMgr.getChannelList(hashMap, new g());
    }

    public void e() {
        if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
            LogEx.d("LoginImp", "enter blackout");
            PreferenceHelper c2 = com.zte.iptvclient.android.common.k.e.c();
            if (c2 != null) {
                c2.putString("timestamp", "0");
            }
            c cVar = new c(this);
            Timer timer = new Timer();
            this.I = timer;
            timer.schedule(cVar, 0L, 300000L);
        }
    }

    public void f() {
        String readPropertie = com.zte.iptvclient.common.uiframe.h.readPropertie("Sort_control", null);
        LogEx.d("LoginImp", "mIsSortFromServer  =  " + readPropertie);
        if (TextUtils.isEmpty(readPropertie) || !readPropertie.equalsIgnoreCase("1")) {
            return;
        }
        com.zte.iptvclient.android.common.f.b.l.b();
        com.zte.iptvclient.android.common.f.b.e.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(Context context) {
        ClientNetworkInfo clientNetworkInfo = new ClientNetworkInfo();
        this.o = clientNetworkInfo;
        try {
            this.k = clientNetworkInfo.getLocalIPAddress();
        } catch (SocketException e2) {
            e2.printStackTrace();
        }
        LogEx.d("LoginImp", "client ip=" + this.k);
        this.m = AndroidUniqueCode.getAndroidId(context);
        LogEx.d("LoginImp", "mStrAndroidId=" + this.m);
        this.l = AndroidUniqueCode.getDeviceMacAddress(context);
        LogEx.d("LoginImp", "client mac=" + this.l);
        if (!TextUtils.isEmpty(this.k) && !TextUtils.isEmpty(this.m) && !TextUtils.isEmpty(this.l)) {
            if (TextUtils.isEmpty(this.m)) {
                return 0;
            }
            GlobalDataMgr.getInstance().putData("AndroidId", this.m);
            return 0;
        }
        LogEx.e("LoginImp", "client's IpAddr or AndroidId or MacAddr is null");
        return -1;
    }

    private String c(Context context) {
        try {
            try {
                byte[] digest = MessageDigest.getInstance("SHA1").digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b2 : digest) {
                    String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.US);
                    if (upperCase.length() == 1) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(upperCase);
                    stringBuffer.append(":");
                }
                String stringBuffer2 = stringBuffer.toString();
                return stringBuffer2.substring(0, stringBuffer2.length() - 1);
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                return null;
            }
        } catch (PackageManager.NameNotFoundException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public int a(Context context) {
        this.p = context;
        this.F = ConfigMgr.readPropertie("GuestName");
        this.G = ConfigMgr.readPropertie("GuestPassword");
        this.i = new com.zte.iptvclient.android.common.j.h(context);
        this.J = Executors.newCachedThreadPool();
        this.h = new ArrayList<>();
        this.n = new SDKUserMgr();
        if (this.C != null) {
            return 0;
        }
        r();
        return 0;
    }

    public void a(boolean z) {
        this.q = z;
    }

    public void b() {
        ArrayList arrayList = new ArrayList();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pageno", "1");
        hashMap.put("numperpage", "100");
        hashMap.put("producttype", "");
        new SDKSubscribeMgr().getUserOrderList(hashMap, new j(arrayList));
    }

    public void a(String str, String str2) {
        LogEx.d("LoginImp", "sha1 = " + c(this.p));
        if (1 == com.zte.iptvclient.common.uiframe.b.c().a()) {
            LogEx.d("LoginImp", " requestLogin current STATUS_LOGIN_LOGINING for return");
            return;
        }
        if (TextUtils.isEmpty(this.F)) {
            this.F = "guestphone";
        }
        if (TextUtils.isEmpty(this.G)) {
            this.G = "1";
        }
        if (!StringUtil.isEmptyString(str) && !str.equals(this.F)) {
            a(false);
        } else {
            a(true);
        }
        this.e = str;
        this.f = str2;
        if (this.j == null && !p()) {
            LogEx.e("LoginImp", "mSdkLoginMgr is null or initLogin faild!");
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.login_failed);
        }
        LogEx.d("LoginImp", "selfAddValue : " + U);
        Bundle bundle = new Bundle();
        bundle.putString("transactionID", com.zte.iptvclient.common.uiframe.g.a().a(U));
        bundle.putString(IIPTVLogin.LOGIN_PARAM_TERMINALOSTYPE, "4");
        int i2 = this.w;
        if (i2 == com.zte.iptvclient.android.common.c.e.a.f4113b) {
            bundle.putBoolean(IIPTVLogin.LOGIN_PARAM_ISMSMMODE, true);
            bundle.putString(IIPTVLogin.LOGIN_PARAM_AUTHCODE, this.x);
            bundle.putString(IIPTVLogin.LOGIN_PARAM_ENCRYPTTOKEN, this.y);
        } else if (i2 == com.zte.iptvclient.android.common.c.e.a.f4114c) {
            this.j.setLoginType(6);
            bundle.putString(IIPTVLogin.LOGIN_PARAM_THIRDSYSTYPE, DownloadConstant.REPORT_MSGTYPE_ADD);
            bundle.putString(IIPTVLogin.LOGIN_PARAM_AUTHCODE, this.x);
        } else {
            String readPropertie = ConfigMgr.readPropertie("IsDividePlat");
            if (!TextUtils.isEmpty(readPropertie) && readPropertie.equals("1")) {
                this.j.setLoginType(4);
            } else {
                this.j.setLoginType(0);
            }
        }
        bundle.putString("terminaltype", l());
        this.j.setExtraParams(bundle);
        LogEx.d("LoginImp", "requestLogin:username=" + str + ",mIsGuestLogin= " + this.q + " authcode : " + this.x);
        V = false;
        this.j.startLogin(str, str2);
        Intent intent = new Intent();
        intent.setAction("FloatWindowClose");
        this.p.getApplicationContext().sendBroadcast(intent);
    }

    public void c() {
        SDKAuthMgr sDKAuthMgr = new SDKAuthMgr();
        FeatureAuthAndOrderListReq featureAuthAndOrderListReq = new FeatureAuthAndOrderListReq();
        featureAuthAndOrderListReq.authandorderlist = "2";
        sDKAuthMgr.doFeatureAuthAndOrderList(featureAuthAndOrderListReq, new n(this));
    }

    private void b(ArrayList<File> arrayList) {
        try {
            int size = arrayList.size();
            if (size >= 1) {
                Long valueOf = Long.valueOf(Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(arrayList.get(0).lastModified()))));
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    Long valueOf2 = Long.valueOf(Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(arrayList.get(i3).lastModified()))));
                    if (valueOf2.longValue() > valueOf.longValue()) {
                        i2 = i3;
                        valueOf = valueOf2;
                    }
                }
                a(arrayList.get(i2));
                arrayList.remove(i2);
                d(arrayList);
                return;
            }
            LogEx.d("LoginImp", "crashFileList is Null");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ArrayList<Channel> arrayList) {
        ArrayList<Channel> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            for (int i3 = 0; i3 < this.M.size(); i3++) {
                if (this.M.get(i3).getChannelcode().equals(arrayList.get(i2).getChannelcode())) {
                    arrayList2.add(this.M.get(i3));
                }
            }
        }
        com.zte.iptvclient.android.common.j.i.d().e(arrayList2);
    }

    private void d(ArrayList<File> arrayList) {
        File file;
        if (TextUtils.isEmpty(this.A) || arrayList.size() == 0 || TextUtils.isEmpty(this.A)) {
            return;
        }
        LogEx.d("LoginImp", "LogServerAddress = " + this.A);
        SDKLogMgr createInstance = SDKLogMgr.createInstance();
        createInstance.setSeverDomain(this.A);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.size() != 0 && (file = arrayList.get(i2)) != null) {
                if ((file.length() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) + 1 > PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
                    LogEx.d("LoginImp", "crashFileLength > 1024");
                } else {
                    String absolutePath = file.getAbsolutePath();
                    CrashFileUpLoadReq crashFileUpLoadReq = new CrashFileUpLoadReq();
                    crashFileUpLoadReq.setTerminalType(ParamConst.LOG_TERMINAL_TYPE_APHONE);
                    crashFileUpLoadReq.setAppName(com.zte.iptvclient.android.common.i.a.a.a(R.string.app_name));
                    crashFileUpLoadReq.setAppVersion(n());
                    crashFileUpLoadReq.setUserName(this.i.V());
                    crashFileUpLoadReq.setCreateTime(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(file.lastModified())));
                    crashFileUpLoadReq.setFilePath(absolutePath);
                    createInstance.uploadCrashFile(crashFileUpLoadReq, new m(this, file, absolutePath));
                }
            }
        }
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = 0;
        if (this.h.size() < 10) {
            if (!this.h.contains(str)) {
                LogEx.d("LoginImp", "updateStorageAccountsmaccountLoginedList=" + this.h.toString());
                if (!StringUtil.isEmptyString(this.g)) {
                    this.g = str + "," + this.g;
                } else {
                    this.g = str;
                }
            } else {
                LogEx.d("LoginImp", "removebefAccountmaccountLoginedList=" + this.h.toString());
                this.h.remove(str);
                LogEx.d("LoginImp", "removeStrAccountmaccountLoginedList=" + this.h.toString());
                this.g = "";
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str + ",");
                while (i2 < this.h.size()) {
                    stringBuffer.append(this.h.get(i2));
                    if (i2 != this.h.size() - 1) {
                        stringBuffer.append(",");
                    }
                    i2++;
                }
                this.g = stringBuffer.toString();
                LogEx.d("LoginImp", "SavemmcontainsStrAccountHistory=" + this.g);
            }
        } else if (!this.h.contains(str)) {
            this.h.remove(r0.size() - 1);
            this.g = "";
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(str + ",");
            while (i2 < this.h.size()) {
                stringBuffer2.append(this.h.get(i2));
                if (i2 != this.h.size() - 1) {
                    stringBuffer2.append(",");
                }
                i2++;
            }
            LogEx.d("LoginImp", "updateStorageAccountsmaccountLoginedList=" + this.h.toString());
            this.g = stringBuffer2.toString();
            LogEx.d("LoginImp", "SavemmcontainsStrAccountHistory=" + this.g);
        } else {
            LogEx.d("LoginImp", "removebefAccountmaccountLoginedList=" + this.h.toString());
            this.h.remove(str);
            LogEx.d("LoginImp", "removeStrAccountmaccountLoginedList=" + this.h.toString());
            this.g = "";
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(str + ",");
            while (i2 < this.h.size()) {
                stringBuffer3.append(this.h.get(i2));
                if (i2 != this.h.size() - 1) {
                    stringBuffer3.append(",");
                }
                i2++;
            }
            this.g = stringBuffer3.toString();
            LogEx.d("LoginImp", "SavemmcontainsStrAccountHistory=" + this.g);
        }
        LogEx.d("LoginImp", "SavemmStrAccountHistory=" + this.g);
        this.i.b(this.g);
    }

    public void a() {
        com.zte.iptvclient.android.mobile.h.a.a.g().b(this.p);
        LogEx.d("LoginImp", "setDeviceID=" + this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (str.contains("catName:")) {
            int indexOf = str.indexOf("catName:") + 8;
            this.i.P(str.substring(indexOf, str.indexOf(",", indexOf)).replace("'", ""));
        }
        if (str.contains("province:")) {
            int indexOf2 = str.indexOf("province:") + 9;
            this.i.Q(str.substring(indexOf2, str.indexOf(",", indexOf2)).replace("'", ""));
        }
    }

    private void a(File file) {
        if (TextUtils.isEmpty(this.A)) {
            return;
        }
        LogEx.d("LoginImp", "LogServerAddress = " + this.A);
        SDKLogMgr createInstance = SDKLogMgr.createInstance();
        createInstance.setSeverDomain(this.A);
        CrashFileUpLoadReq crashFileUpLoadReq = new CrashFileUpLoadReq();
        crashFileUpLoadReq.setTerminalType(ParamConst.LOG_TERMINAL_TYPE_APHONE);
        crashFileUpLoadReq.setAppName(com.zte.iptvclient.android.common.i.a.a.a(R.string.app_name));
        crashFileUpLoadReq.setAppVersion(n());
        crashFileUpLoadReq.setUserName(this.i.V());
        Date date = new Date(file.lastModified());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String absolutePath = file.getAbsolutePath();
        String format = simpleDateFormat.format(date);
        crashFileUpLoadReq.setCreateTime(format);
        crashFileUpLoadReq.setFilePath(absolutePath);
        LogEx.d("LoginImp", "Appname=" + com.zte.iptvclient.android.common.i.a.a.a(R.string.app_name) + ",AppVersion=" + n() + ",CreateTime=" + format + ",Username=" + this.i.V() + ",Filepath=" + file.getAbsolutePath());
        createInstance.uploadCrashFile(crashFileUpLoadReq, new l(file, absolutePath));
    }

    public void a(int i2) {
        this.w = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<Channel> arrayList) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList.get(i2).setIsChannelLock("0");
            arrayList.get(i2).setAfterChannelLock("0");
        }
        HashMap<String, String> a2 = com.zte.iptvclient.android.common.j.e.b().a();
        if (a2 != null && a2.size() != 0) {
            for (String str : a2.keySet()) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    if (TextUtils.equals(str, arrayList.get(i3).getChannelcode())) {
                        arrayList.get(i3).setIsChannelLock("1");
                        arrayList.get(i3).setAfterChannelLock("1");
                    }
                }
            }
        }
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            if (com.zte.iptvclient.android.mobile.f.b.a.b(arrayList.get(i4).getRatingid(), this.p)) {
                arrayList.get(i4).setIsChannelLock("1");
                arrayList.get(i4).setAfterChannelLock("1");
            }
        }
        int i5 = 0;
        while (i5 < arrayList.size()) {
            if ("1".equals(arrayList.get(i5).getIsChannelLock()) || "1".equals(arrayList.get(i5).getSystemlimitenable())) {
                arrayList.remove(i5);
                i5 = -1;
            }
            i5++;
        }
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            arrayList.get(i6).setColumncode(this.D);
        }
        LogEx.i("LoginImp", "Channels size = " + arrayList.size());
        com.zte.iptvclient.android.common.j.i.d().e(arrayList);
        com.zte.iptvclient.android.common.j.i.d().f(arrayList);
    }
}
