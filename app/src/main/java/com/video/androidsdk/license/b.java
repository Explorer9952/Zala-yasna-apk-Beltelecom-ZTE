package com.video.androidsdk.license;

import android.text.TextUtils;
import com.video.androidsdk.license.a;
import com.video.androidsdk.log.LogEx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SDKLicenseMgr.java */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3133a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f3134b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, String str) {
        this.f3133a = i;
        this.f3134b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.InterfaceC0094a interfaceC0094a;
        a.InterfaceC0094a interfaceC0094a2;
        a.InterfaceC0094a interfaceC0094a3;
        a.InterfaceC0094a interfaceC0094a4;
        int i = this.f3133a;
        if (i != 0) {
            if (i != -3 && i != -24) {
                LogEx.d("SDKLicenseMgr", " onSDKInitReturn");
                interfaceC0094a3 = a.j;
                if (interfaceC0094a3 != null) {
                    interfaceC0094a4 = a.j;
                    interfaceC0094a4.a(String.valueOf(this.f3133a), "LicInit fail");
                    return;
                }
                return;
            }
            LogEx.d("SDKLicenseMgr", " callbackLicFailed");
            a.f(String.valueOf(this.f3133a));
            return;
        }
        if (!TextUtils.isEmpty(this.f3134b)) {
            a.e(this.f3134b);
            LogEx.d("SDKLicenseMgr", "basicModelOn:" + a.f3129a + ";updateModelOn:" + a.e + ";logModelOn:" + a.f3132d + ";downloadModelOn:" + a.g + ";dlnaModelOn:" + a.f3130b + ";pushMsgModelOn:" + a.f + ";adModelOn:" + a.f3131c);
        }
        interfaceC0094a = a.j;
        if (interfaceC0094a != null) {
            interfaceC0094a2 = a.j;
            interfaceC0094a2.a(String.valueOf(this.f3133a), "LicInit ok");
        }
    }
}
