package com.video.androidsdk.collectAgent;

import com.video.androidsdk.collectAgent.u;
import org.json.JSONObject;

/* compiled from: CollectAgent.java */
/* loaded from: classes.dex */
final class d implements u.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ u f3077a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ JSONObject f3078b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(u uVar, JSONObject jSONObject) {
        this.f3077a = uVar;
        this.f3078b = jSONObject;
    }

    @Override // com.video.androidsdk.collectAgent.u.a
    public void a(int i, String str) {
        if (i == 0) {
            CollectAgent.uploodOntime();
        } else {
            CollectAgent.b("E_LOGIN", this.f3077a, this.f3078b);
        }
    }
}
