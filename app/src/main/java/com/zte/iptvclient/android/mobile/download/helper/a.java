package com.zte.iptvclient.android.mobile.download.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.mobile.download.helper.c.b;

/* compiled from: DownloadSettingVo.java */
/* loaded from: classes.dex */
public class a {
    private static a p = new a();

    /* renamed from: a, reason: collision with root package name */
    private Context f5753a;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences f5754b;
    private String j;
    private String l;

    /* renamed from: c, reason: collision with root package name */
    private int f5755c = 1;

    /* renamed from: d, reason: collision with root package name */
    private int f5756d = 1;
    private int e = 1;
    private int f = 1;
    private int g = 0;
    private String h = "";
    private String i = "";
    private int k = 0;
    private int m = 0;
    private Boolean n = false;
    private Boolean o = false;

    private a() {
    }

    public static a n() {
        return p;
    }

    public void a(int i) {
        if (i == 2) {
            LogEx.d("DownloadModule", "get Drm Port from iptvclientsys.ini");
            try {
                this.k = Integer.parseInt(ConfigMgr.readPropertie("DrmServerPort", "80"));
            } catch (Exception unused) {
                this.k = 80;
            }
        } else {
            LogEx.d("DownloadModule", "get Drm Port from portal.properties");
            this.k = i;
        }
        a("mDrmPort", this.k);
    }

    public void b(int i) {
        this.f = i;
        a("mPremitAuto", i);
    }

    public void c(int i) {
        this.f5755c = i;
        a("mPremitNet", i);
    }

    public void d(int i) {
        this.f5756d = i;
        a("mPremitWifi", i);
    }

    public void e(int i) {
        this.g = i;
        a("mStorePath", i);
        c(b.a(this.f5753a, i));
    }

    public int f() {
        return this.f;
    }

    public int g() {
        return this.f5755c;
    }

    public int h() {
        return this.f5756d;
    }

    public int i() {
        return this.e;
    }

    public String j() {
        return this.h;
    }

    public int k() {
        return this.g;
    }

    public Boolean l() {
        return this.n;
    }

    public Boolean m() {
        return this.o;
    }

    private void c(String str) {
        this.h = str;
        if (this.g != 3) {
            b.a(str);
            DownloadTaskMgr.d().a(str);
        }
    }

    public String b() {
        return this.j;
    }

    public String d() {
        return this.i;
    }

    public void b(String str) {
        if (TextUtils.equals(str, "")) {
            LogEx.d("DownloadModule", "get Drm IP from iptvclientsys.ini");
            this.j = ConfigMgr.readPropertie("DrmServerIP", "");
        } else {
            LogEx.d("DownloadModule", "get Drm IP from portal.properties");
            this.j = str;
        }
        a("mDrmIP", this.j);
    }

    public int e() {
        return this.m;
    }

    public String a() {
        return this.l;
    }

    public int c() {
        return this.k;
    }

    public void a(String str) {
        if (TextUtils.equals(str, "")) {
            LogEx.d("DownloadModule", "get Drm Company from iptvclientsys.ini");
            this.l = ConfigMgr.readPropertie("DrmCompany", "");
        } else {
            LogEx.d("DownloadModule", "get Drm Company from portal.properties");
            this.l = str;
        }
        a("mDrmCompany", this.l);
    }

    public void a(Boolean bool) {
        LogEx.d("DownloadModule", "set playing is " + bool);
        this.o = bool;
    }

    private void a(String str, int i) {
        LogEx.d("DownloadModule", "keySwitchPath=" + str + ",value=" + i);
        this.f5754b.edit().putInt(str, i).commit();
    }

    private void a(String str, String str2) {
        this.f5754b.edit().putString(str, str2).commit();
    }
}
