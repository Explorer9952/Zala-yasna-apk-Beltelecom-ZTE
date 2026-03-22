package com.video.androidsdk.collectAgent;

import com.video.androidsdk.collectAgent.u;
import org.json.JSONObject;

/* compiled from: CollectAgent.java */
/* loaded from: classes.dex */
class k implements u.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ u f3090a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ JSONObject f3091b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ j f3092c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, u uVar, JSONObject jSONObject) {
        this.f3092c = jVar;
        this.f3090a = uVar;
        this.f3091b = jSONObject;
    }

    @Override // com.video.androidsdk.collectAgent.u.a
    public void a(int i, String str) {
        if (i != 0) {
            CollectAgent.b("E_LOGIN", this.f3090a, this.f3091b);
        }
    }
}
