package com.zte.iptvclient.android.common.javabean.models;

/* compiled from: TVHistoryBean.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private String f4785a;

    /* renamed from: b, reason: collision with root package name */
    private String f4786b;

    /* renamed from: c, reason: collision with root package name */
    private String f4787c;

    /* renamed from: d, reason: collision with root package name */
    private String f4788d;
    private String e;
    private String f;

    public i(String str, String str2, String str3, String str4) {
        this.f4788d = str;
        this.e = str2;
        this.f = str3;
        this.f4787c = str4;
    }

    public String a() {
        return this.f4788d;
    }

    public void b(String str) {
        this.f4785a = str;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.f4787c;
    }

    public String e() {
        return this.f4786b;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(i.class) && obj.hashCode() == hashCode()) {
            return ((i) obj).e.equals(this.e);
        }
        return false;
    }

    public String f() {
        return this.f4785a;
    }

    public int hashCode() {
        return this.f4788d.hashCode();
    }

    public void a(String str) {
        this.f4786b = str;
    }

    public String b() {
        return this.f;
    }
}
