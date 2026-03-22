package com.video.androidsdk.collectAgent;

import com.video.androidsdk.collectAgent.u;

/* compiled from: CollectAgent.java */
/* loaded from: classes.dex */
final class c implements u.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean[] f3076a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean[] zArr) {
        this.f3076a = zArr;
    }

    @Override // com.video.androidsdk.collectAgent.u.a
    public void a(int i, String str) {
        if (i == 0) {
            this.f3076a[0] = true;
        }
    }
}
