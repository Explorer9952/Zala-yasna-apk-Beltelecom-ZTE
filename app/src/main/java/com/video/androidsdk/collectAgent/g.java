package com.video.androidsdk.collectAgent;

import com.video.androidsdk.collectAgent.u;
import org.json.JSONObject;

/* compiled from: CollectAgent.java */
/* loaded from: classes.dex */
class g implements u.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ u f3082a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ JSONObject f3083b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ f f3084c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, u uVar, JSONObject jSONObject) {
        this.f3084c = fVar;
        this.f3082a = uVar;
        this.f3083b = jSONObject;
    }

    @Override // com.video.androidsdk.collectAgent.u.a
    public void a(int i, String str) {
        if (i != 0) {
            CollectAgent.b("E_LOGIN", this.f3082a, this.f3083b);
        }
    }
}
