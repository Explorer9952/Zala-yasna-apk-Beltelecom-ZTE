package com.video.androidsdk;

import android.text.TextUtils;
import com.video.androidsdk.SDKMgr;
import com.video.androidsdk.license.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SDKMgr.java */
/* loaded from: classes.dex */
public final class a implements a.InterfaceC0094a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SDKMgr.OnSDKInitReturnListener f3022a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SDKMgr.OnSDKInitReturnListener onSDKInitReturnListener) {
        this.f3022a = onSDKInitReturnListener;
    }

    @Override // com.video.androidsdk.license.a.InterfaceC0094a
    public void a(String str, String str2) {
        if (this.f3022a != null) {
            if (TextUtils.equals(str, "0")) {
                boolean unused = SDKMgr.h = true;
            }
            this.f3022a.onSDKInitReturn(str, str2);
        }
    }
}
