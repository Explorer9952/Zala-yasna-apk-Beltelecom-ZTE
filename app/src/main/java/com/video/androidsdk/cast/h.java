package com.video.androidsdk.cast;

import com.video.androidsdk.cast.SDKCastMgr;
import com.video.androidsdk.cast.bean.DLNAEvent;

/* compiled from: SDKCastMgr.java */
/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DLNAEvent f3063a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f3064b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, DLNAEvent dLNAEvent) {
        this.f3064b = gVar;
        this.f3063a = dLNAEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        SDKCastMgr.IInitDLNAListener iInitDLNAListener;
        iInitDLNAListener = this.f3064b.f3062a.p;
        iInitDLNAListener.onInitDLNAReturn(this.f3063a.getArg0(), this.f3063a.getArg1());
        this.f3064b.f3062a.j = false;
    }
}
