package com.video.androidsdk.sns.a;

/* compiled from: SinaWeibo.java */
/* loaded from: classes.dex */
class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Exception f3854a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ j f3855b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar, Exception exc) {
        this.f3855b = jVar;
        this.f3854a = exc;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3855b.f3848c.onException(this.f3854a);
    }
}
