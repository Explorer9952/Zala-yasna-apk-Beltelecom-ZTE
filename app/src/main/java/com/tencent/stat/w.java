package com.tencent.stat;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f2918a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ t f2919b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, List list) {
        this.f2919b = tVar;
        this.f2918a = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2919b.b((List<d0>) this.f2918a);
    }
}
