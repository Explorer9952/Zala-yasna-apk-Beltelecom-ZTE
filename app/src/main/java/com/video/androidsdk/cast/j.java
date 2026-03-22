package com.video.androidsdk.cast;

import com.video.androidsdk.cast.SDKCastMgr;
import java.util.Map;

/* compiled from: SDKCastMgr.java */
/* loaded from: classes.dex */
class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f3067a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f3068b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, Map map) {
        this.f3068b = gVar;
        this.f3067a = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        SDKCastMgr.IDLNANotifyListener iDLNANotifyListener;
        iDLNANotifyListener = this.f3068b.f3062a.q;
        iDLNANotifyListener.onDLNANotify(16, this.f3067a);
    }
}
