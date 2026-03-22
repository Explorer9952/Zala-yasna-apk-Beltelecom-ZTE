package io.reactivex.internal.queue;

import io.reactivex.l.b.d;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: SpscLinkedArrayQueue.java */
/* loaded from: classes2.dex */
public final class a<T> implements d<T> {
    static final int i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object j = new Object();

    /* renamed from: b, reason: collision with root package name */
    int f8140b;

    /* renamed from: c, reason: collision with root package name */
    long f8141c;

    /* renamed from: d, reason: collision with root package name */
    final int f8142d;
    AtomicReferenceArray<Object> e;
    final int f;
    AtomicReferenceArray<Object> g;

    /* renamed from: a, reason: collision with root package name */
    final AtomicLong f8139a = new AtomicLong();
    final AtomicLong h = new AtomicLong();

    public a(int i2) {
        int a2 = io.reactivex.internal.util.d.a(Math.max(8, i2));
        int i3 = a2 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a2 + 1);
        this.e = atomicReferenceArray;
        this.f8142d = i3;
        a(a2);
        this.g = atomicReferenceArray;
        this.f = i3;
        this.f8141c = i3 - 1;
        b(0L);
    }

    private static int b(int i2) {
        return i2;
    }

    private AtomicReferenceArray<Object> b(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        b(i2);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) a(atomicReferenceArray, i2);
        a(atomicReferenceArray, i2, (Object) null);
        return atomicReferenceArray2;
    }

    private long d() {
        return this.h.get();
    }

    private long e() {
        return this.f8139a.get();
    }

    private long f() {
        return this.h.get();
    }

    private long g() {
        return this.f8139a.get();
    }

    public boolean a(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.e;
            long e = e();
            int i2 = this.f8142d;
            int a2 = a(e, i2);
            if (e < this.f8141c) {
                return a(atomicReferenceArray, t, e, a2);
            }
            long j2 = this.f8140b + e;
            if (a(atomicReferenceArray, a(j2, i2)) == null) {
                this.f8141c = j2 - 1;
                return a(atomicReferenceArray, t, e, a2);
            }
            if (a(atomicReferenceArray, a(1 + e, i2)) == null) {
                return a(atomicReferenceArray, t, e, a2);
            }
            a(atomicReferenceArray, e, a2, t, i2);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public T c() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.g;
        long d2 = d();
        int i2 = this.f;
        int a2 = a(d2, i2);
        T t = (T) a(atomicReferenceArray, a2);
        boolean z = t == j;
        if (t == null || z) {
            if (z) {
                return a(b(atomicReferenceArray, i2 + 1), d2, i2);
            }
            return null;
        }
        a(atomicReferenceArray, a2, (Object) null);
        a(d2 + 1);
        return t;
    }

    public boolean b() {
        return g() == f();
    }

    private void b(long j2) {
        this.f8139a.lazySet(j2);
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i2) {
        a(atomicReferenceArray, i2, t);
        b(j2 + 1);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2, T t, long j3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.e = atomicReferenceArray2;
        this.f8141c = (j3 + j2) - 1;
        a(atomicReferenceArray2, i2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i2, j);
        b(j2 + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        int length = atomicReferenceArray.length() - 1;
        b(length);
        a(atomicReferenceArray, length, atomicReferenceArray2);
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.g = atomicReferenceArray;
        int a2 = a(j2, i2);
        T t = (T) a(atomicReferenceArray, a2);
        if (t != null) {
            a(atomicReferenceArray, a2, (Object) null);
            a(j2 + 1);
        }
        return t;
    }

    public void a() {
        while (true) {
            if (c() == null && b()) {
                return;
            }
        }
    }

    private void a(int i2) {
        this.f8140b = Math.min(i2 / 4, i);
    }

    private void a(long j2) {
        this.h.lazySet(j2);
    }

    private static int a(long j2, int i2) {
        int i3 = ((int) j2) & i2;
        b(i3);
        return i3;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    private static <E> Object a(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }
}
