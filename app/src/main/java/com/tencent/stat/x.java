package com.tencent.stat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.stat.a.b f2920a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f2921b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ t f2922c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar, com.tencent.stat.a.b bVar, h hVar) {
        this.f2922c = tVar;
        this.f2920a = bVar;
        this.f2921b = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2922c.b(this.f2920a, this.f2921b);
    }
}
