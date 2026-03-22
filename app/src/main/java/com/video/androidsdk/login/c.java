package com.video.androidsdk.login;

import android.text.TextUtils;
import com.video.androidsdk.common.util.security.Base16;
import com.video.androidsdk.common.util.security.DES;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.IIPTVLogin;
import com.video.androidsdk.login.impl.b;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IPTVLogin.java */
/* loaded from: classes.dex */
public class c implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.video.androidsdk.login.impl.a f3167a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f3168b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ a f3169c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, com.video.androidsdk.login.impl.a aVar2, String str) {
        this.f3169c = aVar;
        this.f3167a = aVar2;
        this.f3168b = str;
    }

    @Override // com.video.androidsdk.login.impl.b.a
    public void a(String str, String str2, HashMap<String, String> hashMap) {
        String str3;
        if (hashMap == null || !"0".equals(str)) {
            str3 = a.f3141a;
            LogEx.d(str3, "start 60 request failed");
            this.f3167a.b(str, str2);
            return;
        }
        m.a().putAll(hashMap);
        String str4 = hashMap.get("RealPassword");
        if (!TextUtils.isEmpty(str4)) {
            m.a().put("RealPassword", new String(DES.decrypt(this.f3168b.getBytes(), Base16.decode(str4), DES.ALGORITHM_TRIPLE)));
        }
        if ("1".equals(hashMap.get("iemg"))) {
            this.f3169c.d(this.f3167a);
        } else {
            this.f3169c.a(IIPTVLogin.LOGIN_PARAM_ACTIONLOGIN, this.f3167a);
        }
    }
}
