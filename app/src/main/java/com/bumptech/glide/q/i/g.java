package com.bumptech.glide.q.i;

import com.bumptech.glide.q.i.f;

/* compiled from: ViewAnimationFactory.java */
/* loaded from: classes.dex */
public class g<R> implements d<R> {

    /* renamed from: a, reason: collision with root package name */
    private final f.a f2315a;

    /* renamed from: b, reason: collision with root package name */
    private c<R> f2316b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f.a aVar) {
        this.f2315a = aVar;
    }

    @Override // com.bumptech.glide.q.i.d
    public c<R> a(boolean z, boolean z2) {
        if (!z && z2) {
            if (this.f2316b == null) {
                this.f2316b = new f(this.f2315a);
            }
            return this.f2316b;
        }
        return e.b();
    }
}
