package com.zte.iptvclient.android.common.player.j;

import org.json.JSONObject;

/* compiled from: MegogoBean.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private String f4968a;

    /* renamed from: b, reason: collision with root package name */
    private String f4969b;

    public String a() {
        return this.f4968a;
    }

    public String b() {
        return this.f4969b;
    }

    public void b(String str) {
    }

    public void c(String str) {
        this.f4969b = str;
    }

    public void a(String str) {
        this.f4968a = str;
    }

    public static g a(JSONObject jSONObject, int i) {
        String str;
        if (jSONObject == null) {
            return null;
        }
        g gVar = new g();
        try {
            gVar.a(jSONObject.optString("bitrate"));
            gVar.b(jSONObject.optString("name"));
            String optString = jSONObject.optString("src");
            if (optString.contains("/a/0")) {
                str = optString.replace("/a/0", "/a/" + i);
            } else {
                int lastIndexOf = optString.lastIndexOf("/", optString.lastIndexOf("/"));
                str = optString.substring(0, lastIndexOf) + "/a/" + i + optString.substring(lastIndexOf);
            }
            gVar.c(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gVar;
    }
}
