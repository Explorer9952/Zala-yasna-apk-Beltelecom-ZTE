package com.tencent.stat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f2923a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ t f2924b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(t tVar, g gVar) {
        this.f2924b = tVar;
        this.f2923a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2924b.b(this.f2923a);
    }
}
