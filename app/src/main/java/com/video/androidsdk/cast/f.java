package com.video.androidsdk.cast;

import com.video.androidsdk.cast.SDKCastMgr;
import com.video.androidsdk.cast.bean.Device;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SDKCastMgr.java */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3059a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SDKCastMgr.IDLNAActionCallback f3060b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SDKCastMgr f3061c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SDKCastMgr sDKCastMgr, String str, SDKCastMgr.IDLNAActionCallback iDLNAActionCallback) {
        this.f3061c = sDKCastMgr;
        this.f3059a = str;
        this.f3060b = iDLNAActionCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Device device;
        SDKCastMgr.l(this.f3061c);
        i = this.f3061c.r;
        if (i <= 0) {
            device = this.f3061c.n;
            if (device == null) {
                return;
            }
            this.f3061c.a(this.f3059a, this.f3060b);
        }
    }
}
