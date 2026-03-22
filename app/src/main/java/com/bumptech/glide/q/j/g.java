package com.bumptech.glide.q.j;

/* compiled from: SimpleTarget.java */
/* loaded from: classes.dex */
public abstract class g<Z> extends a<Z> {

    /* renamed from: b, reason: collision with root package name */
    private final int f2318b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2319c;

    public g() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.q.j.j
    public final void a(h hVar) {
        if (com.bumptech.glide.s.h.a(this.f2318b, this.f2319c)) {
            hVar.a(this.f2318b, this.f2319c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f2318b + " and height: " + this.f2319c + ", either provide dimensions in the constructor or call override()");
    }

    public g(int i, int i2) {
        this.f2318b = i;
        this.f2319c = i2;
    }
}
