package com.bumptech.glide.q;

/* compiled from: ThumbnailRequestCoordinator.java */
/* loaded from: classes.dex */
public class h implements d, c {

    /* renamed from: a, reason: collision with root package name */
    private c f2302a;

    /* renamed from: b, reason: collision with root package name */
    private c f2303b;

    /* renamed from: c, reason: collision with root package name */
    private d f2304c;

    public h(d dVar) {
        this.f2304c = dVar;
    }

    private boolean f() {
        d dVar = this.f2304c;
        return dVar == null || dVar.a(this);
    }

    private boolean g() {
        d dVar = this.f2304c;
        return dVar == null || dVar.b(this);
    }

    private boolean h() {
        d dVar = this.f2304c;
        return dVar != null && dVar.b();
    }

    public void a(c cVar, c cVar2) {
        this.f2302a = cVar;
        this.f2303b = cVar2;
    }

    @Override // com.bumptech.glide.q.d
    public boolean b(c cVar) {
        return g() && (cVar.equals(this.f2302a) || !this.f2302a.c());
    }

    @Override // com.bumptech.glide.q.d
    public void c(c cVar) {
        if (cVar.equals(this.f2303b)) {
            return;
        }
        d dVar = this.f2304c;
        if (dVar != null) {
            dVar.c(this);
        }
        if (this.f2303b.e()) {
            return;
        }
        this.f2303b.clear();
    }

    @Override // com.bumptech.glide.q.c
    public void clear() {
        this.f2303b.clear();
        this.f2302a.clear();
    }

    @Override // com.bumptech.glide.q.c
    public void d() {
        if (!this.f2303b.isRunning()) {
            this.f2303b.d();
        }
        if (this.f2302a.isRunning()) {
            return;
        }
        this.f2302a.d();
    }

    @Override // com.bumptech.glide.q.c
    public boolean e() {
        return this.f2302a.e() || this.f2303b.e();
    }

    @Override // com.bumptech.glide.q.c
    public boolean isCancelled() {
        return this.f2302a.isCancelled();
    }

    @Override // com.bumptech.glide.q.c
    public boolean isRunning() {
        return this.f2302a.isRunning();
    }

    @Override // com.bumptech.glide.q.c
    public void pause() {
        this.f2302a.pause();
        this.f2303b.pause();
    }

    @Override // com.bumptech.glide.q.d
    public boolean b() {
        return h() || c();
    }

    @Override // com.bumptech.glide.q.d
    public boolean a(c cVar) {
        return f() && cVar.equals(this.f2302a) && !b();
    }

    @Override // com.bumptech.glide.q.c
    public void a() {
        this.f2302a.a();
        this.f2303b.a();
    }

    @Override // com.bumptech.glide.q.c
    public boolean c() {
        return this.f2302a.c() || this.f2303b.c();
    }
}
