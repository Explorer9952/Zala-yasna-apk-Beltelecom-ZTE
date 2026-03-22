package com.zte.iptvclient.android.common.f.b;

import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.k.q;
import com.zte.iptvclient.android.common.k.s;
import com.zte.iptvclient.android.common.k.x;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BlackoutMgr.java */
/* loaded from: classes.dex */
public class b {
    private static volatile b u;

    /* renamed from: b, reason: collision with root package name */
    private q.f f4545b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4546c;

    /* renamed from: d, reason: collision with root package name */
    private String f4547d;
    private com.zte.iptvclient.android.common.player.k.c e;
    private String f;
    private long g;
    private PrevueBean h;
    private Date l;
    private Date m;
    private com.zte.iptvclient.android.mobile.b.a n;
    private Date o;
    private d p;
    private e q;
    private d s;

    /* renamed from: a, reason: collision with root package name */
    private String f4544a = "BlackoutMgr";
    private int i = -2;
    private int j = -1;
    private int k = 0;
    private boolean r = false;
    private boolean t = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BlackoutMgr.java */
    /* loaded from: classes.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            b.this.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BlackoutMgr.java */
    /* renamed from: com.zte.iptvclient.android.common.f.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0130b implements q.f {
        C0130b() {
        }

        @Override // com.zte.iptvclient.android.common.k.q.f
        public void a(String str, String str2, String str3) {
            LogEx.d(b.this.f4544a, "onGetBlackOutExecuteInfoReturn returncode = " + str + "  eroor msg = " + str2 + "  VAR3=" + str3);
            if (TextUtils.equals("0", str) && !TextUtils.isEmpty(str3)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    String optString = jSONObject.optString("blackouttype");
                    String optString2 = jSONObject.optString("blackinfo");
                    if (TextUtils.equals("1", optString)) {
                        b.this.b(optString2);
                    } else if (TextUtils.equals("0", optString)) {
                        b.this.a(2, com.zte.iptvclient.android.common.k.e.a(optString2));
                        LogEx.d(b.this.f4544a, "blackout  pic");
                    } else {
                        b.this.a(-3, "blackouttype  error = " + optString);
                        LogEx.d(b.this.f4544a, "blackouttype  error = " + optString);
                    }
                    return;
                } catch (JSONException e) {
                    b.this.a(-4, "JSON ERROR = " + e.toString());
                    LogEx.e(b.this.f4544a, "JSON ERROR = " + e.toString());
                    return;
                }
            }
            b.this.a(str.equals("1") ? 0 : -5, "returncode= " + str);
            LogEx.d(b.this.f4544a, "returnCode = " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BlackoutMgr.java */
    /* loaded from: classes.dex */
    public class c implements q.e {
        c() {
        }

        @Override // com.zte.iptvclient.android.common.k.q.e
        public void onGetPlayUrlReturn(String str, String str2, String str3) {
            String str4;
            LogEx.d(b.this.f4544a, "onGetPlayUrlReturn var1 = " + str + "  var2 = " + str2 + "  VAR3=" + str3);
            if (TextUtils.equals(str, "0") && !TextUtils.isEmpty(str3)) {
                LogEx.i(b.this.f4544a, "query blackout video return code== 0");
                try {
                    str4 = new JSONObject(str3).getString("playurl");
                } catch (JSONException e) {
                    e.printStackTrace();
                    str4 = "";
                }
                b.this.a(TextUtils.isEmpty(str4) ? -2 : 1, str4);
                LogEx.d(b.this.f4544a, "url = " + str4);
                return;
            }
            b.this.a(-2, "blackout vod url= " + str);
            LogEx.i(b.this.f4544a, "blackout vod url= " + str);
        }
    }

    /* compiled from: BlackoutMgr.java */
    /* loaded from: classes.dex */
    public interface d {
        void j();

        void k(String str);

        void l();

        void r(String str);
    }

    /* compiled from: BlackoutMgr.java */
    /* loaded from: classes.dex */
    public interface e {
        void a(long j);

        void c(long j);
    }

    private b() {
        k();
    }

    private void c(Date date) {
        LogEx.d(this.f4544a, "onTimeCheckTvodBlackout :" + this.f4547d);
        String a2 = com.zte.iptvclient.android.common.k.e.a(date, this.f4547d);
        if (!TextUtils.equals(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, a2)) {
            LogEx.d(this.f4544a, "blackout:enter Tvod blackout");
            c(a2);
            return;
        }
        LogEx.d(this.f4544a, "blackout:exit Tvod blackout for blackoutId is null");
        if (f()) {
            a(0, "not in blackout time getBlackInfoById had Breack!");
            com.zte.iptvclient.android.common.player.k.c cVar = this.e;
            if (cVar != null) {
                cVar.T0();
            }
        }
    }

    public static synchronized b j() {
        b bVar;
        synchronized (b.class) {
            if (u == null) {
                u = new b();
            }
            bVar = u;
        }
        return bVar;
    }

    private void k() {
        if (this.f4545b != null) {
            return;
        }
        this.f4545b = new C0130b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        LogEx.d(this.f4544a, "onTimeCheckBlackout" + this.j);
        int i = this.i;
        if (i == -1) {
            LogEx.d(this.f4544a, "onTimeVOD");
            return;
        }
        if (i == 0) {
            LogEx.d(this.f4544a, "onTimeTV");
            b(s.b());
        } else if (i == 1) {
            LogEx.d(this.f4544a, "onTimeTVOD");
            c(s.b());
        } else {
            if (i != 2) {
                return;
            }
            LogEx.d(this.f4544a, "onTimeTS");
            a(s.b());
        }
    }

    public void a(ArrayList<com.zte.iptvclient.android.mobile.b.a> arrayList) {
    }

    public void d(int i) {
        this.i = 2;
        a(i);
        this.j = 1;
    }

    public boolean e() {
        this.r = true;
        return true;
    }

    public boolean f() {
        return this.f4546c;
    }

    public void g() {
        if (this.l == null || this.q == null || this.o == null) {
            return;
        }
        try {
            Date b2 = s.b();
            if (this.n != null) {
                this.o = this.n.b();
            }
            if (this.i == 2) {
                if (this.o.before(b2)) {
                    this.q.a(this.o.getTime());
                    return;
                } else {
                    LogEx.d(this.f4544a, "定桩起播clickViewToPlay");
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(this.f4547d));
                    return;
                }
            }
            if (this.i == 1) {
                if (this.o.before(this.m)) {
                    this.q.c(this.o.getTime() - this.l.getTime());
                    return;
                }
                if (this.h != null) {
                    Date d2 = x.d(this.h.getBegintime());
                    Date d3 = x.d(this.h.getEndtime());
                    if (b2.after(d2) && b2.before(d3)) {
                        LogEx.d(this.f4544a, "定桩起播clickViewToPlay");
                        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(this.h.getChannelcode()));
                    } else if (b2.after(d3)) {
                        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.r.b(this.h, true));
                    } else {
                        LogEx.d(this.f4544a, "Tvod should not have future prevue");
                    }
                }
            }
        } catch (Exception unused) {
            LogEx.d(this.f4544a, "定桩起播clickViewToPlay");
            LogEx.d(this.f4544a, "blackout skip err,back to tv live");
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.g(this.f4547d));
        }
    }

    public void h() {
        this.i = -1;
        this.j = 1;
    }

    public void i() {
        this.e = null;
        this.q = null;
        this.p = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOCODE, str);
        q.a((HashMap<String, String>) hashMap, new c());
    }

    public void a(com.zte.iptvclient.android.common.player.k.c cVar) {
        this.e = cVar;
        this.q = cVar;
        this.p = cVar;
        new Timer().schedule(new a(), 0L, 1000L);
    }

    public d d() {
        return this.p;
    }

    private void b(Date date) {
        if (this.e != null) {
            LogEx.d(this.f4544a, "ontime ChannelCode: " + this.f4547d);
            String a2 = com.zte.iptvclient.android.common.k.e.a(date, this.f4547d);
            if (!TextUtils.equals(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, a2)) {
                LogEx.d(this.f4544a, "blackout:enter Tvblackout");
                c(a2);
                return;
            }
            LogEx.d(this.f4544a, "blackout:exit TV blackout for blackoutId is null!");
            if (f()) {
                LogEx.d(this.f4544a, "定桩起播clickViewToPlay");
                a(0, "not in blackout time getBlackInfoById had Breack!");
                com.zte.iptvclient.android.common.player.k.c cVar = this.e;
                if (cVar != null) {
                    cVar.T0();
                }
                this.f4546c = false;
                return;
            }
            return;
        }
        LogEx.d(this.f4544a, "player null");
    }

    public void a(String str, String str2, d dVar) {
        this.i = -1;
        this.s = dVar;
        this.t = false;
        com.zte.iptvclient.android.common.javabean.c a2 = com.zte.iptvclient.android.common.k.e.a(s.b());
        if (a2 != null) {
            LogEx.d(this.f4544a, "blackout:enter blackout");
            if (a2.b() == 0) {
                a(2, com.zte.iptvclient.android.common.k.e.a(a2.a()));
                return;
            } else {
                b(a2.a());
                return;
            }
        }
        LogEx.d(this.f4544a, "blackout:exit blackout");
        a(0, "not in blackout time getBlackInfoById had Breack!");
    }

    private void c(String str) {
        if (TextUtils.equals(this.f, str) && f()) {
            return;
        }
        this.f = str;
        HashMap hashMap = new HashMap();
        hashMap.put("querycode", str);
        hashMap.put("querytype", "3");
        LogEx.d(this.f4544a, "onTimeQueryBlackoutType Blackoutid = " + str);
        q.a((HashMap<String, String>) hashMap, this.f4545b);
    }

    public void a(String str, d dVar) {
        this.s = dVar;
        this.f4547d = str;
        this.t = false;
        this.i = 0;
        LogEx.d(this.f4544a, "queryTvBlackout enter ");
        String a2 = com.zte.iptvclient.android.common.k.e.a(s.b(), str);
        LogEx.d(this.f4544a, "queryTvBlackout channelCode: " + str + " forblackoutId= " + a2);
        if (TextUtils.equals(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, a2)) {
            a(0, "not in blackout time getBlackInfoById had Breack!");
            LogEx.w(this.f4544a, "queryTvBlackout channelCode: " + str + " for blackoutId is null ");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("querycode", a2);
        hashMap.put("querytype", "3");
        LogEx.d(this.f4544a, "getBlackInfoById Blackoutid = " + a2);
        this.f = a2;
        q.a((HashMap<String, String>) hashMap, this.f4545b);
    }

    public void c(int i) {
        this.i = i;
    }

    public int b() {
        return this.j;
    }

    public int c() {
        return this.i;
    }

    public void b(int i) {
        this.j = i;
        LogEx.d(this.f4544a, " setCurrentFakePlayState=" + this.j);
    }

    public void b(long j) {
        this.g = j;
        LogEx.d(this.f4544a, "blackoutTimeStamp:  " + j);
    }

    public void a(String str, Date date, d dVar) {
        this.s = dVar;
        this.t = false;
        this.f4547d = str;
        this.i = 0;
        LogEx.d(this.f4544a, "queryTvodBlackout enter ");
        String a2 = com.zte.iptvclient.android.common.k.e.a(date, this.f4547d);
        if (TextUtils.equals(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, a2)) {
            a(0, "not in blackout time getBlackInfoById had Breack!");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("querycode", a2);
        hashMap.put("querytype", "3");
        LogEx.d(this.f4544a, "getBlackInfoById Blackoutid = " + a2);
        this.f = a2;
        q.a((HashMap<String, String>) hashMap, this.f4545b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        d dVar = this.s;
        if (dVar != null) {
            if (i == 0 || i == -5 || i == -3 || i == -1) {
                this.s.j();
                this.t = false;
                this.s = null;
                return;
            } else if (i == 2) {
                if (!this.t) {
                    dVar.k(str);
                }
                this.t = true;
                return;
            } else if (i == 1) {
                if (!this.t) {
                    dVar.r(str);
                }
                this.t = true;
                return;
            } else {
                if (i == -2 || i == -4) {
                    this.s.l();
                    return;
                }
                return;
            }
        }
        d dVar2 = this.p;
        if (dVar2 == null) {
            LogEx.e(this.f4544a, "tempBlackoutDeal returnListener is null! ");
            return;
        }
        if (i == 0 || i == -5 || i == -3 || i == -1) {
            this.p.j();
            this.t = false;
            return;
        }
        if (i == 2) {
            if (!this.t) {
                dVar2.k(str);
            }
            this.t = true;
        } else if (i == 1) {
            if (!this.t) {
                dVar2.r(str);
            }
            this.t = true;
        } else if (i == -2 || i == -4) {
            this.p.l();
        }
    }

    private void a(Date date) {
        LogEx.d(this.f4544a, "onTimeCheckTimeShiftBlackout " + this.f4547d);
        String a2 = com.zte.iptvclient.android.common.k.e.a(date, this.f4547d);
        if (!TextUtils.equals(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, a2)) {
            LogEx.d(this.f4544a, "blackout:enter tstv blackout");
            c(a2);
            return;
        }
        LogEx.d(this.f4544a, "blackout:exit tstv blackout for blackoutId is null");
        if (f()) {
            a(0, "not in blackout time getBlackInfoById had Breack!");
            com.zte.iptvclient.android.common.player.k.c cVar = this.e;
            if (cVar != null) {
                cVar.T0();
            }
            this.f4546c = false;
        }
    }

    public void a(String str, int i) {
        this.i = 0;
        this.j = 1;
        a(i);
        this.f4547d = str;
        b(s.b().getTime());
    }

    public void a(String str, Date date, Date date2, int i) {
        this.i = 1;
        this.f4547d = str;
        a(i);
        this.j = 1;
        this.l = date;
        this.m = date2;
        b(0L);
        LogEx.d(this.f4544a, "startTvodPlay updataeblackoutTimeStamp=" + this.g);
    }

    public void a(String str) {
        this.i = 1;
        this.j = 1;
        b(0L);
        LogEx.d(this.f4544a, "startTvodPlay updataeblackoutTimeStamp=" + this.g);
    }

    public void a(int i) {
        com.zte.iptvclient.android.common.player.k.c cVar = this.e;
        if (cVar == null) {
            this.k = i;
            return;
        }
        if (this.i == 0) {
            this.k = (int) cVar.P1();
        } else {
            this.k = i;
        }
        LogEx.d(this.f4544a, "duration changed:  " + this.k);
    }

    public void a(PrevueBean prevueBean) {
        this.h = prevueBean;
    }

    public void a(com.zte.iptvclient.android.mobile.b.a aVar) {
        this.n = aVar;
    }

    public void a(boolean z) {
        this.f4546c = z;
    }

    public void a(long j) {
        int i = this.i;
        if (i == -1) {
            return;
        }
        if (i == 0 && this.j == 1) {
            b(s.b().getTime());
            return;
        }
        if (this.j == 1) {
            if (this.f4546c) {
                long j2 = this.g + 1000;
                this.g = j2;
                b(j2);
                return;
            }
            b(j);
        }
    }

    public long a() {
        return this.g;
    }
}
