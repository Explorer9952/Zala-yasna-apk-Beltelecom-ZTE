package com.zte.iptvclient.android.common.j;

import com.video.androidsdk.service.cache.SDKCacheMgr;
import com.zte.iptvclient.android.common.javabean.models.Feature;
import java.util.ArrayList;

/* compiled from: FeatureStorage.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<Feature> f4668a;

    /* renamed from: b, reason: collision with root package name */
    private String f4669b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<Feature> f4670c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<Feature> f4671d;

    /* compiled from: FeatureStorage.java */
    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f4672a = new c();
    }

    public static final c e() {
        return a.f4672a;
    }

    public void a(String str) {
        this.f4669b = str;
        SDKCacheMgr.put("definitionNchannellist", str);
    }

    public void b(ArrayList<Feature> arrayList) {
        SDKCacheMgr.put("featurellist", arrayList);
    }

    public ArrayList<Feature> c() {
        if (this.f4668a == null) {
            this.f4668a = (ArrayList) SDKCacheMgr.getAsObject("playmaxdeviceList");
        }
        return this.f4668a;
    }

    public ArrayList<Feature> d() {
        if (this.f4670c == null) {
            this.f4670c = (ArrayList) SDKCacheMgr.getAsObject("remotefeatureList");
        }
        if (this.f4670c == null) {
            this.f4670c = new ArrayList<>();
        }
        return this.f4670c;
    }

    public void f(ArrayList<Feature> arrayList) {
        SDKCacheMgr.put("mixdevicechannellist", arrayList);
    }

    public void g(ArrayList<Feature> arrayList) {
        SDKCacheMgr.put("mixonlinechannellist", arrayList);
    }

    public void h(ArrayList<Feature> arrayList) {
        this.f4670c = arrayList;
        SDKCacheMgr.put("remotefeatureList", arrayList);
    }

    public String b() {
        if (this.f4669b == null) {
            this.f4669b = (String) SDKCacheMgr.getAsObject("definitionNchannellist");
        }
        return this.f4669b;
    }

    public void e(ArrayList<Feature> arrayList) {
        SDKCacheMgr.put("megogofeaturelist", arrayList);
    }

    public ArrayList<Feature> a() {
        if (this.f4671d == null) {
            this.f4671d = (ArrayList) SDKCacheMgr.getAsObject("childrenframeList");
        }
        return this.f4671d;
    }

    public void c(ArrayList<Feature> arrayList) {
        SDKCacheMgr.put("ivifeaturelist", arrayList);
    }

    public void a(ArrayList<Feature> arrayList) {
        this.f4671d = arrayList;
        SDKCacheMgr.put("childrenframeList", arrayList);
    }

    public void d(ArrayList<Feature> arrayList) {
        this.f4668a = arrayList;
        SDKCacheMgr.put("playmaxdeviceList", arrayList);
    }
}
