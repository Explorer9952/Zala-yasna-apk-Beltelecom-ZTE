package com.zte.iptvclient.android.common.j;

import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.cache.SDKCacheMgr;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.ChannelTvodTsTimeBean;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.k.s;
import com.zte.servicesdk.util.PortalConst;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

/* compiled from: TvChannelListStorage.java */
/* loaded from: classes.dex */
public class i {
    private static String h = "channellist";
    private static String i = "radioList";
    private static String j = "suchannellist";
    private static String k = "allchannellist";
    private static String l = "tvcolumnalllist";
    private static String m = "ChannelTvodTime";
    private static String n = "ChannelTstvTime";

    /* renamed from: a, reason: collision with root package name */
    private String f4687a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<Channel> f4688b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<Channel> f4689c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<Channel> f4690d;
    private ArrayList<ChannelTvodTsTimeBean> e;
    private ArrayList<ChannelTvodTsTimeBean> f;
    private String g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TvChannelListStorage.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final i f4691a = new i();
    }

    public static final i d() {
        return b.f4691a;
    }

    public ArrayList<Channel> a() {
        if (this.f4689c == null) {
            this.f4689c = (ArrayList) SDKCacheMgr.getAsObject(i);
        }
        if (this.f4689c == null) {
            this.f4689c = new ArrayList<>();
        }
        return this.f4689c;
    }

    public ArrayList<Channel> b() {
        if (this.f4688b == null) {
            this.f4688b = (ArrayList) SDKCacheMgr.getAsObject(h);
        }
        if (this.f4688b == null) {
            this.f4688b = new ArrayList<>();
        }
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        LogEx.i(this.f4687a, "getTVChannelList size = " + this.f4688b.size());
        return this.f4688b;
    }

    public void c(ArrayList<Channel> arrayList) {
        this.f4689c = arrayList;
        SDKCacheMgr.put(i, arrayList);
    }

    public void e(ArrayList<Channel> arrayList) {
        this.f4688b = arrayList;
        LogEx.i(this.f4687a, "mChannelList size = " + this.f4688b.size());
        SDKCacheMgr.put(h, arrayList);
    }

    public void f(ArrayList<Channel> arrayList) {
        this.f4690d = arrayList;
        SDKCacheMgr.put(k, arrayList);
    }

    private i() {
        this.f4687a = "TvChannelListStorage";
    }

    public void d(ArrayList<Channel> arrayList) {
        SDKCacheMgr.put(j, arrayList);
    }

    public ArrayList<Channel> c() {
        if (this.f4690d == null) {
            this.f4690d = (ArrayList) SDKCacheMgr.getAsObject(l);
        }
        if (this.f4690d == null) {
            this.f4690d = new ArrayList<>();
        }
        return this.f4690d;
    }

    public String a(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        this.g = str;
        if (this.f == null) {
            this.f = (ArrayList) SDKCacheMgr.getAsObject(n);
        }
        if (this.f != null) {
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                if (TextUtils.equals(this.f.get(i2).getMixno(), this.g)) {
                    str2 = this.f.get(i2).getShifttime();
                    LogEx.d(this.f4687a, "Current state unEmergence getChannelTstvList is " + str2);
                } else if (TextUtils.equals("50119220", this.f.get(i2).getChannelcode())) {
                    LogEx.d(this.f4687a, "Current state in Emergence getChannelTstvList is -1");
                    str2 = WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
                }
            }
        } else {
            LogEx.d(this.f4687a, "Current state unEmergence getChannelTstvList is null");
        }
        return str2;
    }

    private String c(String str) {
        this.g = str;
        if (this.e == null) {
            this.e = (ArrayList) SDKCacheMgr.getAsObject(m);
        }
        if (this.e == null) {
            return "0";
        }
        String str2 = "";
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            if (TextUtils.equals(this.e.get(i2).getMixno(), this.g)) {
                str2 = this.e.get(i2).getTvodtime();
            } else if (TextUtils.equals(this.e.get(i2).getChannelcode(), "50119220")) {
                String c2 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_PREVIEW_DAYOFTV);
                if (TextUtils.isEmpty(c2)) {
                    c2 = DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT;
                }
                LogEx.d(this.f4687a, "getChannelTvodList current emgerince! for " + c2);
                str2 = String.valueOf(Integer.parseInt(c2) * 24 * 60 * 60);
            }
        }
        return str2;
    }

    public String b(String str) {
        String str2;
        this.g = str;
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        if (this.e == null) {
            this.e = (ArrayList) SDKCacheMgr.getAsObject(m);
        }
        if (this.e != null) {
            str2 = "";
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                if (TextUtils.equals(this.e.get(i2).getMixno(), this.g)) {
                    str2 = decimalFormat.format(Integer.parseInt(this.e.get(i2).getTvodtime()) / 3600);
                } else if (TextUtils.equals(this.e.get(i2).getChannelcode(), "50119220")) {
                    String c2 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_PREVIEW_DAYOFTV);
                    if (TextUtils.isEmpty(c2)) {
                        c2 = DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT;
                    }
                    LogEx.d(this.f4687a, "getChannelTvodList current emgerince! for " + c2);
                    str2 = String.valueOf(Integer.parseInt(c2) * 24);
                }
            }
        } else {
            str2 = "0.0";
        }
        return TextUtils.isEmpty(str2) ? "0.0" : str2;
    }

    public void a(ArrayList<ChannelTvodTsTimeBean> arrayList) {
        this.f = arrayList;
        SDKCacheMgr.put(n, arrayList);
    }

    public boolean a(Date date, Date date2, String str) {
        String c2 = c(str);
        if (!TextUtils.isEmpty(c2)) {
            LogEx.d(this.f4687a, "current channel mix=" + str + " tsTime=" + c2);
            return Long.valueOf(c2).longValue() < (s.b().getTime() - date.getTime()) / 1000;
        }
        LogEx.d(this.f4687a, "getChannelTvodList is null!");
        return false;
    }

    public void b(ArrayList<ChannelTvodTsTimeBean> arrayList) {
        this.e = arrayList;
        SDKCacheMgr.put(m, arrayList);
    }

    public void a(PrevueBean prevueBean, Date date, String str) {
        String c2 = c(str);
        if (!TextUtils.isEmpty(c2)) {
            LogEx.d(this.f4687a, "current channel mix=" + str + " tsTime=" + c2);
            if (Long.valueOf(c2).longValue() < (s.b().getTime() - date.getTime()) / 1000) {
                prevueBean.setShowPlayBotton(false);
                return;
            } else {
                prevueBean.setShowPlayBotton(true);
                return;
            }
        }
        LogEx.d(this.f4687a, "getChannelTvodList is null!");
        prevueBean.setShowPlayBotton(false);
    }

    public boolean a(long j2, String str) {
        String c2 = c(str);
        if (!TextUtils.isEmpty(c2)) {
            LogEx.d(this.f4687a, "current channel mix=" + str + " tsTime=" + c2);
            return Long.valueOf(c2).longValue() < j2 / 1000;
        }
        LogEx.d(this.f4687a, "getChannelTvodList is null!");
        return false;
    }
}
