package com.video.androidsdk.collectAgent;

import com.video.androidsdk.collectAgent.u;
import org.json.JSONObject;

/* compiled from: CollectAgent.java */
/* loaded from: classes.dex */
final class e implements u.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ u f3079a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ JSONObject f3080b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(u uVar, JSONObject jSONObject) {
        this.f3079a = uVar;
        this.f3080b = jSONObject;
    }

    @Override // com.video.androidsdk.collectAgent.u.a
    public void a(int i, String str) {
        if (i != 0) {
            CollectAgent.b("E_LOGIN", this.f3079a, this.f3080b);
        }
    }
}
