package com.video.androidsdk.login;

import com.video.androidsdk.login.impl.b;
import java.util.Properties;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IPTVLogin.java */
/* loaded from: classes.dex */
public class j implements b.InterfaceC0095b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.video.androidsdk.login.impl.a f3198a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f3199b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, com.video.androidsdk.login.impl.a aVar2) {
        this.f3199b = aVar;
        this.f3198a = aVar2;
    }

    @Override // com.video.androidsdk.login.impl.b.InterfaceC0095b
    public void a(String str, String str2, Properties properties) {
        if (!"0".equals(str)) {
            com.video.androidsdk.login.impl.a aVar = this.f3198a;
            if (aVar != null) {
                aVar.b(str, str2);
                return;
            }
            return;
        }
        m.a(properties);
        com.video.androidsdk.login.impl.a aVar2 = this.f3198a;
        if (aVar2 != null) {
            aVar2.a();
        }
    }
}
