package com.zte.iptvclient.android.common.b;

import org.json.JSONObject;

/* compiled from: AuthcodePresenter.java */
/* loaded from: classes.dex */
public class d implements Object {

    /* renamed from: a, reason: collision with root package name */
    b f4094a;

    /* renamed from: b, reason: collision with root package name */
    c f4095b;

    public d(c cVar, b bVar) {
        this.f4095b = cVar;
        this.f4094a = bVar;
    }

    public void a(String str, String str2, int i, String str3, String str4) {
        this.f4094a.a(str, str2, i, str3, this, str4);
    }

    public void b(String str, String str2, int i, String str3, String str4) {
        this.f4094a.a(str, str2, i, str3, str4, this);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(JSONObject jSONObject) {
        this.f4095b.a(jSONObject);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(JSONObject jSONObject) {
        this.f4095b.b(jSONObject);
    }

    public void a(String str) {
        this.f4095b.d(str);
    }

    public void b(String str) {
        this.f4095b.f(str);
    }
}
