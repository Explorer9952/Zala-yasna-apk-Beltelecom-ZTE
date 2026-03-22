package com.zte.iptvclient.android.common.javabean.models;

/* compiled from: Mixno.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f4765a;

    /* renamed from: b, reason: collision with root package name */
    private String f4766b;

    public String a() {
        return this.f4766b;
    }

    public String b() {
        return this.f4765a;
    }

    public void a(String str) {
        this.f4766b = str;
    }

    public void b(String str) {
        this.f4765a = str;
    }

    public static b a(String str, String str2) {
        b bVar = new b();
        bVar.b(str);
        bVar.a(str2);
        return bVar;
    }
}
