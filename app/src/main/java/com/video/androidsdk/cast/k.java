package com.video.androidsdk.cast;

import com.video.androidsdk.cast.SDKCastMgr;
import java.util.Map;

/* compiled from: SDKCastMgr.java */
/* loaded from: classes.dex */
class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f3069a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f3070b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar, Map map) {
        this.f3070b = gVar;
        this.f3069a = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        SDKCastMgr.IDLNANotifyListener iDLNANotifyListener;
        iDLNANotifyListener = this.f3070b.f3062a.q;
        iDLNANotifyListener.onDLNANotify(0, this.f3069a);
    }
}
