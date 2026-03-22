package com.video.androidsdk.login;

import android.text.TextUtils;
import com.video.androidsdk.common.AES;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.IIPTVLogin;
import com.video.androidsdk.login.impl.b;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IPTVLogin.java */
/* loaded from: classes.dex */
public class b implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.video.androidsdk.login.impl.a f3164a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f3165b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ a f3166c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, com.video.androidsdk.login.impl.a aVar2, String str) {
        this.f3166c = aVar;
        this.f3164a = aVar2;
        this.f3165b = str;
    }

    @Override // com.video.androidsdk.login.impl.b.a
    public void a(String str, String str2, HashMap<String, String> hashMap) {
        String str3;
        String str4;
        if (hashMap == null || !"0".equals(str)) {
            str3 = a.f3141a;
            LogEx.d(str3, "start 57 request failed");
            this.f3164a.b(str, str2);
            return;
        }
        m.a().putAll(hashMap);
        String str5 = hashMap.get("userid");
        if (!TextUtils.isEmpty(str5)) {
            m.a().put("UserID", str5);
        }
        String str6 = hashMap.get("userpwd");
        str4 = a.f3141a;
        LogEx.d(str4, "start 57, encrypted  password  is  " + str6);
        if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(this.f3165b)) {
            try {
                str6 = AES.aesDecryptByBase64(str6, this.f3165b.getBytes());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        m.a().put("userpwd", str6);
        m.a().put("Password", str6);
        this.f3166c.a(IIPTVLogin.LOGIN_PARAM_ACTIONLOGIN, this.f3164a);
    }
}
