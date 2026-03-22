package com.tencent.stat;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f2915a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f2916b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ t f2917c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, List list, int i) {
        this.f2917c = tVar;
        this.f2915a = list;
        this.f2916b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2917c.b((List<d0>) this.f2915a, this.f2916b);
    }
}
