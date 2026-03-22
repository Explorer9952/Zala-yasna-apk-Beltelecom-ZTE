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
public class f implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.video.androidsdk.login.impl.a f3175a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f3176b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, com.video.androidsdk.login.impl.a aVar2) {
        this.f3176b = aVar;
        this.f3175a = aVar2;
    }

    @Override // com.video.androidsdk.login.impl.b.a
    public void a(String str, String str2, HashMap<String, String> hashMap) {
        String str3;
        int i;
        String str4;
        long j;
        int i2;
        str3 = a.f3141a;
        LogEx.d(str3, "Login75 return code is: " + str + " ,errmsg is: " + str2);
        if (hashMap != null && "0".equals(str)) {
            m.a().putAll(hashMap);
            i = this.f3176b.f3142b;
            if (1 != i) {
                i2 = this.f3176b.f3142b;
                if (5 != i2) {
                    this.f3176b.g(this.f3175a);
                    this.f3176b.b();
                    str4 = m.a().get("UserTokenExpiredTime");
                    Date epgTime = ServerDate.getEpgTime();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
                    if (!TextUtils.isEmpty(str4) || epgTime == null) {
                        return;
                    }
                    try {
                        j = simpleDateFormat.parse(str4).getTime() - epgTime.getTime();
                    } catch (ParseException e) {
                        e.printStackTrace();
                        j = 0;
                    }
                    if (j > 600000) {
                        j -= 600000;
                    }
                    if (j > 0) {
                        SDKLoginMgr.getInstance().updateUserToken(j);
                        return;
                    }
                    return;
                }
            }
            com.video.androidsdk.login.impl.a aVar = this.f3175a;
            if (aVar != null) {
                aVar.a();
            }
            this.f3176b.b();
            str4 = m.a().get("UserTokenExpiredTime");
            Date epgTime2 = ServerDate.getEpgTime();
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            if (TextUtils.isEmpty(str4)) {
                return;
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(str) && str.startsWith("172")) {
            this.f3175a.b(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 3, Integer.parseInt(str) % 1000)), str2);
        } else {
            this.f3175a.b(str, str2);
        }
    }
}
