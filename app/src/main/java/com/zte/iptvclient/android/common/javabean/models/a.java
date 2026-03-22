package com.zte.iptvclient.android.common.javabean.models;

import android.text.TextUtils;
import com.video.androidsdk.service.comm.ParamConst;
import org.json.JSONObject;

/* compiled from: Banner.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f4761a;

    /* renamed from: b, reason: collision with root package name */
    private String f4762b;

    /* renamed from: c, reason: collision with root package name */
    private String f4763c;

    /* renamed from: d, reason: collision with root package name */
    private String f4764d;

    public String a() {
        return this.f4764d;
    }

    public void a(String str) {
    }

    public String b() {
        return this.f4763c;
    }

    public String c() {
        return this.f4761a;
    }

    public String d() {
        return this.f4762b;
    }

    public void d(String str) {
    }

    public void e(String str) {
        this.f4761a = str;
    }

    public void f(String str) {
        this.f4762b = str;
    }

    public void g(String str) {
    }

    public void h(String str) {
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        try {
            aVar.a(jSONObject.optString("bannername"));
            aVar.e(jSONObject.optString("phonebanner"));
            aVar.g(jSONObject.optString("tabletbanner"));
            aVar.f(jSONObject.optString("sortnum"));
            aVar.h(jSONObject.optString("vodtype"));
            aVar.d(jSONObject.optString(ParamConst.RECOMMEND_BANNER_REQ_LINKTYPE));
            aVar.c(jSONObject.optString("linksource"));
            aVar.b(jSONObject.optString("displaytime"));
            if (TextUtils.isEmpty(aVar.d())) {
                aVar.f("0");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aVar;
    }

    public void b(String str) {
        this.f4764d = str;
    }

    public void c(String str) {
        this.f4763c = str;
    }
}
