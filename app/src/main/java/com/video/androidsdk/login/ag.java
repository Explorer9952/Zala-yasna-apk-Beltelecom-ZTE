package com.video.androidsdk.login;

import com.video.androidsdk.login.impl.b;
import java.util.Properties;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThirdAppAuthIPTVLogin.java */
/* loaded from: classes.dex */
public class ag implements b.InterfaceC0095b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.video.androidsdk.login.impl.a f3160a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ab f3161b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ab abVar, com.video.androidsdk.login.impl.a aVar) {
        this.f3161b = abVar;
        this.f3160a = aVar;
    }

    @Override // com.video.androidsdk.login.impl.b.InterfaceC0095b
    public void a(String str, String str2, Properties properties) {
        if (!"0".equals(str)) {
            com.video.androidsdk.login.impl.a aVar = this.f3160a;
            if (aVar != null) {
                aVar.b(str, str2);
                return;
            }
            return;
        }
        m.a(properties);
        com.video.androidsdk.login.impl.a aVar2 = this.f3160a;
        if (aVar2 != null) {
            aVar2.a();
        }
    }
}
