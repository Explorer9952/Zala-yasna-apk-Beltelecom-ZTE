package com.video.androidsdk.login;

import android.text.TextUtils;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.b;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IPTVLogin.java */
/* loaded from: classes.dex */
public class i implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.video.androidsdk.login.impl.a f3179a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f3180b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, com.video.androidsdk.login.impl.a aVar2) {
        this.f3180b = aVar;
        this.f3179a = aVar2;
    }

    @Override // com.video.androidsdk.login.impl.b.a
    public void a(String str, String str2, HashMap<String, String> hashMap) {
        String str3;
        str3 = a.f3141a;
        LogEx.d(str3, "Login80 return code is: " + str + " ,errmsg is: " + str2);
        if (hashMap != null && "0".equals(str)) {
            m.a().putAll(hashMap);
            this.f3180b.e(this.f3179a);
        } else if (!TextUtils.isEmpty(str) && str.startsWith("172")) {
            this.f3179a.b(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 4, Integer.parseInt(str) % 1000)), str2);
        } else {
            this.f3179a.b(str, str2);
        }
    }
}
