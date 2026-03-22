package com.tencent.stat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f2844a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ t f2845b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(t tVar, int i) {
        this.f2845b = tVar;
        this.f2844a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int a2 = c.a();
        int i = this.f2844a;
        if (i == -1) {
            i = this.f2845b.f2912c;
        }
        int i2 = i / a2;
        int i3 = i % a2;
        for (int i4 = 0; i4 < i2 + 1; i4++) {
            this.f2845b.b(a2);
        }
        if (i3 > 0) {
            this.f2845b.b(i3);
        }
    }
}
