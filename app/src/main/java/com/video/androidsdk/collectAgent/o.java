package com.video.androidsdk.collectAgent;

import com.video.androidsdk.collectAgent.u;
import org.json.JSONObject;

/* compiled from: CollectAgent.java */
/* loaded from: classes.dex */
class o implements u.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ u f3098a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ JSONObject f3099b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ n f3100c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, u uVar, JSONObject jSONObject) {
        this.f3100c = nVar;
        this.f3098a = uVar;
        this.f3099b = jSONObject;
    }

    @Override // com.video.androidsdk.collectAgent.u.a
    public void a(int i, String str) {
        if (i != 0) {
            CollectAgent.b("E_LOGIN", this.f3098a, this.f3099b);
        }
    }
}
