package com.video.androidsdk.login;

import android.text.TextUtils;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ServerDate;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.b;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IPTVLogin.java */
/* loaded from: classes.dex */
public class e implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.video.androidsdk.login.impl.a f3173a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f3174b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, com.video.androidsdk.login.impl.a aVar2) {
        this.f3174b = aVar;
        this.f3173a = aVar2;
    }

    @Override // com.video.androidsdk.login.impl.b.a
    public void a(String str, String str2, HashMap<String, String> hashMap) {
        String str3;
        int i;
        int i2;
        long j;
        str3 = a.f3141a;
        LogEx.d(str3, "Login63 return code is: " + str + " ,errmsg is: " + str2);
        if (hashMap != null && "0".equals(str)) {
            m.a().putAll(hashMap);
            i = this.f3174b.f3142b;
            if (2 != i) {
                i2 = this.f3174b.f3142b;
                if (1 == i2) {
                    this.f3174b.f(this.f3173a);
                    return;
                } else {
                    this.f3174b.e(this.f3173a);
                    return;
                }
            }
            com.video.androidsdk.login.impl.a aVar = this.f3173a;
            if (aVar != null) {
                aVar.a();
            }
            String str4 = m.a().get("UserTokenExpiredTime");
            Date epgTime = ServerDate.getEpgTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            if (TextUtils.isEmpty(str4) || epgTime == null) {
                return;
            }
            try {
                j = simpleDateFormat.parse(str4).getTime() - epgTime.getTime();
            } catch (ParseException e) {
                e.printStackTrace();
                j = 0;
            }
            if (j > 0) {
                SDKLoginMgr.getInstance().updateUserToken(j);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str) && str.startsWith("172")) {
            this.f3173a.b(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 2, Integer.parseInt(str) % 1000)), str2);
        } else {
            this.f3173a.b(str, str2);
        }
    }
}
