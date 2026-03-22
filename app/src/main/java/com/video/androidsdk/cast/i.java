package com.video.androidsdk.cast;

import com.video.androidsdk.cast.SDKCastMgr;
import java.util.Map;

/* compiled from: SDKCastMgr.java */
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f3065a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f3066b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, Map map) {
        this.f3066b = gVar;
        this.f3065a = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        SDKCastMgr.IDLNANotifyListener iDLNANotifyListener;
        iDLNANotifyListener = this.f3066b.f3062a.q;
        iDLNANotifyListener.onDLNANotify(1, this.f3065a);
    }
}
