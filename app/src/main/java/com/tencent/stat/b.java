package com.tencent.stat;

import com.facebook.appevents.UserDataStore;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private long f2840a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f2841b = 0;

    /* renamed from: c, reason: collision with root package name */
    private String f2842c = "";

    /* renamed from: d, reason: collision with root package name */
    private int f2843d = 0;
    private String e = "";

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tm", this.f2840a);
            jSONObject.put(UserDataStore.STATE, this.f2841b);
            if (this.f2842c != null) {
                jSONObject.put("dm", this.f2842c);
            }
            jSONObject.put(LocaleUtil.PORTUGUESE, this.f2843d);
            if (this.e != null) {
                jSONObject.put("rip", this.e);
            }
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void a(int i) {
        this.f2843d = i;
    }

    public void a(long j) {
        this.f2840a = j;
    }

    public void a(String str) {
        this.f2842c = str;
    }

    public void b(int i) {
        this.f2841b = i;
    }

    public void b(String str) {
        this.e = str;
    }
}
