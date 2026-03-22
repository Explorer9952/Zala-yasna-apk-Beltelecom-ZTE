package com.video.androidsdk.collectAgent;

import com.video.androidsdk.collectAgent.u;
import org.json.JSONObject;

/* compiled from: CollectAgent.java */
/* loaded from: classes.dex */
class q implements u.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ u f3101a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ JSONObject f3102b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ p f3103c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, u uVar, JSONObject jSONObject) {
        this.f3103c = pVar;
        this.f3101a = uVar;
        this.f3102b = jSONObject;
    }

    @Override // com.video.androidsdk.collectAgent.u.a
    public void a(int i, String str) {
        if (i != 0) {
            CollectAgent.b("E_LOGIN", this.f3101a, this.f3102b);
        }
    }
}
