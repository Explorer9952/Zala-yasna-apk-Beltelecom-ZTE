package com.bumptech.glide.load.engine;

import android.os.Looper;

/* compiled from: EngineResource.java */
/* loaded from: classes.dex */
class g<Z> implements j<Z> {

    /* renamed from: a, reason: collision with root package name */
    private final j<Z> f1998a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f1999b;

    /* renamed from: c, reason: collision with root package name */
    private a f2000c;

    /* renamed from: d, reason: collision with root package name */
    private com.bumptech.glide.load.b f2001d;
    private int e;
    private boolean f;

    /* compiled from: EngineResource.java */
    /* loaded from: classes.dex */
    interface a {
        void b(com.bumptech.glide.load.b bVar, g<?> gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(j<Z> jVar, boolean z) {
        if (jVar != null) {
            this.f1998a = jVar;
            this.f1999b = z;
            return;
        }
        throw new NullPointerException("Wrapped resource must not be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bumptech.glide.load.b bVar, a aVar) {
        this.f2001d = bVar;
        this.f2000c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (!this.f) {
            if (Looper.getMainLooper().equals(Looper.myLooper())) {
                this.e++;
                return;
            }
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
        throw new IllegalStateException("Cannot acquire a recycled resource");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f1999b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.e > 0) {
            if (Looper.getMainLooper().equals(Looper.myLooper())) {
                int i = this.e - 1;
                this.e = i;
                if (i == 0) {
                    this.f2000c.b(this.f2001d, this);
                    return;
                }
                return;
            }
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
        throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
    }

    @Override // com.bumptech.glide.load.engine.j
    public Z get() {
        return this.f1998a.get();
    }

    @Override // com.bumptech.glide.load.engine.j
    public int getSize() {
        return this.f1998a.getSize();
    }

    @Override // com.bumptech.glide.load.engine.j
    public void a() {
        if (this.e <= 0) {
            if (!this.f) {
                this.f = true;
                this.f1998a.a();
                return;
            }
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
    }
}
