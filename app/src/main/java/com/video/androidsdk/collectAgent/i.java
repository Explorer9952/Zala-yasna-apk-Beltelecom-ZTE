package com.video.androidsdk.collectAgent;

import com.video.androidsdk.collectAgent.u;
import org.json.JSONObject;

/* compiled from: CollectAgent.java */
/* loaded from: classes.dex */
class i implements u.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ u f3086a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ JSONObject f3087b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ h f3088c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, u uVar, JSONObject jSONObject) {
        this.f3088c = hVar;
        this.f3086a = uVar;
        this.f3087b = jSONObject;
    }

    @Override // com.video.androidsdk.collectAgent.u.a
    public void a(int i, String str) {
        if (i != 0) {
            CollectAgent.b("E_LOGIN", this.f3086a, this.f3087b);
        }
    }
}
