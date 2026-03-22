package com.bumptech.glide.load.h;

import java.util.Queue;

/* compiled from: ModelCache.java */
/* loaded from: classes.dex */
public class k<A, B> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.s.e<b<A>, B> f2096a;

    /* compiled from: ModelCache.java */
    /* loaded from: classes.dex */
    class a extends com.bumptech.glide.s.e<b<A>, B> {
        a(k kVar, int i) {
            super(i);
        }

        @Override // com.bumptech.glide.s.e
        protected /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            a((b) obj, (b<A>) obj2);
        }

        protected void a(b<A> bVar, B b2) {
            bVar.a();
        }
    }

    public k(int i) {
        this.f2096a = new a(this, i);
    }

    public B a(A a2, int i, int i2) {
        b<A> a3 = b.a(a2, i, i2);
        B a4 = this.f2096a.a(a3);
        a3.a();
        return a4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ModelCache.java */
    /* loaded from: classes.dex */
    public static final class b<A> {

        /* renamed from: d, reason: collision with root package name */
        private static final Queue<b<?>> f2097d = com.bumptech.glide.s.h.a(0);

        /* renamed from: a, reason: collision with root package name */
        private int f2098a;

        /* renamed from: b, reason: collision with root package name */
        private int f2099b;

        /* renamed from: c, reason: collision with root package name */
        private A f2100c;

        private b() {
        }

        static <A> b<A> a(A a2, int i, int i2) {
            b<A> bVar = (b) f2097d.poll();
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a2, i, i2);
            return bVar;
        }

        private void b(A a2, int i, int i2) {
            this.f2100c = a2;
            this.f2099b = i;
            this.f2098a = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f2099b == bVar.f2099b && this.f2098a == bVar.f2098a && this.f2100c.equals(bVar.f2100c);
        }

        public int hashCode() {
            return (((this.f2098a * 31) + this.f2099b) * 31) + this.f2100c.hashCode();
        }

        public void a() {
            f2097d.offer(this);
        }
    }

    public void a(A a2, int i, int i2, B b2) {
        this.f2096a.b(b.a(a2, i, i2), b2);
    }
}
