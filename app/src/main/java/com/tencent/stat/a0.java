package com.tencent.stat;

import java.util.List;

/* loaded from: classes.dex */
class a0 implements h {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f2837a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f2838b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ t f2839c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0(t tVar, List list, int i) {
        this.f2839c = tVar;
        this.f2837a = list;
        this.f2838b = i;
    }

    @Override // com.tencent.stat.h
    public void a() {
        this.f2839c.a(this.f2837a);
    }

    @Override // com.tencent.stat.h
    public void b() {
        this.f2839c.a(this.f2837a, 1);
        this.f2839c.f2912c += this.f2838b;
    }
}
