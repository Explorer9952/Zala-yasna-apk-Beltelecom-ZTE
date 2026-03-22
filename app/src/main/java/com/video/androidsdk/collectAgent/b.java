package com.video.androidsdk.collectAgent;

import com.video.androidsdk.collectAgent.u;

/* compiled from: CollectAgent.java */
/* loaded from: classes.dex */
final class b implements u.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean[] f3075a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(boolean[] zArr) {
        this.f3075a = zArr;
    }

    @Override // com.video.androidsdk.collectAgent.u.a
    public void a(int i, String str) {
        if (i == 0) {
            this.f3075a[0] = true;
        }
    }
}
