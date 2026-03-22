package com.video.androidsdk.player;

/* compiled from: FvPlayer.java */
/* loaded from: classes.dex */
class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f3410a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.f3410a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.f3410a.f3394a.x;
        if (z) {
            this.f3410a.f3394a.d();
        }
    }
}
