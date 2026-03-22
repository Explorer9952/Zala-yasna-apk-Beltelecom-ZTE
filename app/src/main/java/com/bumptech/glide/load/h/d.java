package com.bumptech.glide.load.h;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/* compiled from: GlideUrl.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final URL f2075a;

    /* renamed from: b, reason: collision with root package name */
    private final e f2076b;

    /* renamed from: c, reason: collision with root package name */
    private final String f2077c;

    /* renamed from: d, reason: collision with root package name */
    private String f2078d;
    private URL e;

    public d(URL url) {
        this(url, e.f2079a);
    }

    private String d() {
        if (TextUtils.isEmpty(this.f2078d)) {
            String str = this.f2077c;
            if (TextUtils.isEmpty(str)) {
                str = this.f2075a.toString();
            }
            this.f2078d = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
        }
        return this.f2078d;
    }

    private URL e() throws MalformedURLException {
        if (this.e == null) {
            this.e = new URL(d());
        }
        return this.e;
    }

    public String a() {
        String str = this.f2077c;
        return str != null ? str : this.f2075a.toString();
    }

    public Map<String, String> b() {
        return this.f2076b.a();
    }

    public URL c() throws MalformedURLException {
        return e();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return a().equals(dVar.a()) && this.f2076b.equals(dVar.f2076b);
    }

    public int hashCode() {
        return (a().hashCode() * 31) + this.f2076b.hashCode();
    }

    public String toString() {
        return a() + '\n' + this.f2076b.toString();
    }

    public d(String str) {
        this(str, e.f2079a);
    }

    public d(URL url, e eVar) {
        if (url == null) {
            throw new IllegalArgumentException("URL must not be null!");
        }
        if (eVar != null) {
            this.f2075a = url;
            this.f2077c = null;
            this.f2076b = eVar;
            return;
        }
        throw new IllegalArgumentException("Headers must not be null");
    }

    public d(String str, e eVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("String url must not be empty or null: " + str);
        }
        if (eVar != null) {
            this.f2077c = str;
            this.f2075a = null;
            this.f2076b = eVar;
            return;
        }
        throw new IllegalArgumentException("Headers must not be null");
    }
}
