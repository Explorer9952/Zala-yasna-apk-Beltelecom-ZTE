package com.video.androidsdk.login;

import android.os.Bundle;
import android.text.TextUtils;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.IIPTVLogin;
import com.video.androidsdk.login.impl.b;
import java.net.URL;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IPTVLogin.java */
/* loaded from: classes.dex */
public class d implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3170a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.video.androidsdk.login.impl.a f3171b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ a f3172c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, String str, com.video.androidsdk.login.impl.a aVar2) {
        this.f3172c = aVar;
        this.f3170a = str;
        this.f3171b = aVar2;
    }

    @Override // com.video.androidsdk.login.impl.b.a
    public void a(String str, String str2, HashMap<String, String> hashMap) {
        String str3;
        String str4;
        String str5;
        Bundle bundle;
        int i;
        URL url;
        String str6;
        String str7;
        Bundle bundle2;
        String str8;
        str3 = a.f3141a;
        LogEx.d(str3, "the login type is : " + this.f3170a);
        str4 = a.f3141a;
        LogEx.d(str4, "Login61 return code is: " + str + " ,errmsg is: " + str2);
        if (IIPTVLogin.LOGIN_PARAM_ACTIONLOGOUT.equalsIgnoreCase(this.f3170a)) {
            SDKLoginMgr.getInstance().stopRefreshUserToken();
            if (this.f3171b != null) {
                str8 = a.f3141a;
                LogEx.d(str8, "logout return");
                this.f3171b.a(str, str2);
                return;
            }
            return;
        }
        if (hashMap == null || !"0".equals(str)) {
            str5 = a.f3141a;
            LogEx.w(str5, "mapResult is null or returncode is not 0");
            if (!TextUtils.isEmpty(str) && str.startsWith("172")) {
                this.f3171b.b(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 1, Integer.parseInt(str) % 1000)), str2);
                return;
            } else {
                this.f3171b.b(str, str2);
                return;
            }
        }
        m.a().putAll(hashMap);
        bundle = this.f3172c.f3144d;
        if (TextUtils.equals("1", bundle.getString(IIPTVLogin.LOGIN_PARAM_ISCELLC))) {
            bundle2 = this.f3172c.f3144d;
            bundle2.putString("UserID", hashMap.get("UserCode"));
        }
        String str9 = hashMap.get("SerIpAddress");
        i = this.f3172c.f3142b;
        if (4 == i || StringUtil.isEmptyString(str9)) {
            url = this.f3172c.f;
            String host = url.getHost();
            m.a().put("SerIpAddress", host);
            str6 = a.f3141a;
            LogEx.w(str6, "EPG IP not found!Use main server ip " + host + " instead!");
        }
        str7 = a.f3141a;
        LogEx.d(str7, "startLogin63");
        this.f3172c.d(this.f3171b);
    }
}
