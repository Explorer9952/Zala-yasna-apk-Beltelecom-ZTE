package com.video.androidsdk.login.impl;

import com.video.androidsdk.common.AES;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PublicLoginMethod.java */
/* loaded from: classes.dex */
public class c implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3185a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b.a f3186b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f3187c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ b f3188d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str, b.a aVar, int i) {
        this.f3188d = bVar;
        this.f3185a = str;
        this.f3186b = aVar;
        this.f3187c = i;
    }

    @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
    public void onDataReturn(String str) {
        boolean z;
        String str2;
        boolean b2;
        String str3;
        String str4;
        z = this.f3188d.j;
        if (z) {
            b2 = this.f3188d.b(str);
            if (!b2) {
                byte[] bytes = com.video.androidsdk.license.a.a(this.f3188d.c()).getBytes();
                try {
                    str4 = this.f3188d.h;
                    str = AES.aesDecryptByBase64(str, bytes, str4);
                } catch (Exception unused) {
                    str3 = b.f3181a;
                    LogEx.d(str3, "AES decrypt failed");
                    b.a aVar = this.f3186b;
                    if (aVar != null) {
                        aVar.a(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 6)), ErrMessage.ERRCODE_EXCEPTION, null);
                        return;
                    }
                    return;
                }
            }
        }
        str2 = b.f3181a;
        LogEx.d(str2, "request return   " + str);
        this.f3188d.a(str, this.f3187c, this.f3186b);
    }

    @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
    public void onFailReturn(int i, String str) {
        String str2;
        String str3;
        str2 = b.f3181a;
        LogEx.w(str2, this.f3185a + "  failed");
        str3 = b.f3181a;
        LogEx.w(str3, "result code is " + i + " , errormsg is " + str);
        b.a aVar = this.f3186b;
        if (aVar != null) {
            aVar.a(String.valueOf(i), str, null);
        }
    }
}
