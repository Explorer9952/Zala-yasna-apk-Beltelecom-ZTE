package com.render.vrlib.l.a;

/* compiled from: DisplayModeManager.java */
/* loaded from: classes.dex */
public class b extends com.render.vrlib.l.d<a> implements d {
    private boolean e;
    private com.render.vrlib.w.a f;

    public b(int i, com.render.vrlib.a.d dVar) {
        super(i, dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.render.vrlib.l.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a a(int i) {
        if (i != 102) {
            return new e();
        }
        return new c();
    }

    public boolean f() {
        return this.e;
    }

    public com.render.vrlib.w.a h() {
        return this.f;
    }

    @Override // com.render.vrlib.l.a.d
    public int a() {
        return e().a();
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void a(com.render.vrlib.w.a aVar) {
        this.f = aVar;
    }
}
