package com.tencent.stat;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f2898a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f2899b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ j f2900c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, List list, h hVar) {
        this.f2900c = jVar;
        this.f2898a = list;
        this.f2899b = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.stat.i.b bVar;
        try {
            this.f2900c.a(this.f2898a, this.f2899b);
        } catch (Throwable th) {
            bVar = j.f2894c;
            bVar.c(th);
        }
    }
}
