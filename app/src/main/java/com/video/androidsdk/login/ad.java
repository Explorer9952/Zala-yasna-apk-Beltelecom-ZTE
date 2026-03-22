package com.video.androidsdk.login;

import com.video.androidsdk.login.impl.b;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThirdAppAuthIPTVLogin.java */
/* loaded from: classes.dex */
public class ad implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.video.androidsdk.login.impl.a f3156a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ab f3157b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, com.video.androidsdk.login.impl.a aVar) {
        this.f3157b = abVar;
        this.f3156a = aVar;
    }

    @Override // com.video.androidsdk.login.impl.b.a
    public void a(String str, String str2, HashMap<String, String> hashMap) {
        boolean z;
        if (hashMap != null && "0".equals(str)) {
            m.a().putAll(hashMap);
            this.f3157b.d(this.f3156a);
            z = this.f3157b.i;
            if (z) {
                this.f3157b.c();
                return;
            }
            return;
        }
        com.video.androidsdk.login.impl.a aVar = this.f3156a;
        if (aVar != null) {
            aVar.b(str, str2);
        }
    }
}
