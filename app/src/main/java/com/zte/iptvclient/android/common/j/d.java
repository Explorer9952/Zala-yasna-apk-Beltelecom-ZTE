package com.zte.iptvclient.android.common.j;

import com.video.androidsdk.service.cache.SDKCacheMgr;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: IviStorage.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    private static boolean f4673c = false;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<com.zte.iptvclient.android.mobile.ivi.c.a> f4674a;

    /* renamed from: b, reason: collision with root package name */
    private String f4675b;

    /* compiled from: IviStorage.java */
    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final d f4676a = new d();
    }

    public static final d d() {
        return a.f4676a;
    }

    public ArrayList<com.zte.iptvclient.android.mobile.ivi.c.a> a() {
        if (this.f4674a == null) {
            this.f4674a = (ArrayList) SDKCacheMgr.getAsObject("iviauthlist");
        }
        return this.f4674a;
    }

    public String b() {
        if (this.f4675b == null) {
            this.f4675b = (String) SDKCacheMgr.getAsObject("iviauthlist");
        }
        return this.f4675b;
    }

    public boolean c() {
        return f4673c;
    }

    public void a(ArrayList<com.zte.iptvclient.android.mobile.ivi.c.a> arrayList) {
        this.f4674a = arrayList;
        SDKCacheMgr.put("iviauthlist", arrayList);
    }

    public void a(String str) {
        this.f4675b = str;
        SDKCacheMgr.put("iviauthlist", (Serializable) str);
    }

    public void a(boolean z) {
        f4673c = z;
        SDKCacheMgr.put("iviauthlist", Boolean.valueOf(z));
    }
}
