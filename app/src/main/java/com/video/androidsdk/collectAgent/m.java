package com.video.androidsdk.collectAgent;

import com.video.androidsdk.collectAgent.u;
import org.json.JSONObject;

/* compiled from: CollectAgent.java */
/* loaded from: classes.dex */
class m implements u.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ u f3094a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ JSONObject f3095b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ l f3096c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, u uVar, JSONObject jSONObject) {
        this.f3096c = lVar;
        this.f3094a = uVar;
        this.f3095b = jSONObject;
    }

    @Override // com.video.androidsdk.collectAgent.u.a
    public void a(int i, String str) {
        if (i != 0) {
            CollectAgent.b("E_LOGIN", this.f3094a, this.f3095b);
        }
    }
}
