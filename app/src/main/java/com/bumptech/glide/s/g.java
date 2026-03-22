package com.bumptech.glide.s;

/* compiled from: MultiClassKey.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private Class<?> f2348a;

    /* renamed from: b, reason: collision with root package name */
    private Class<?> f2349b;

    public g() {
    }

    public void a(Class<?> cls, Class<?> cls2) {
        this.f2348a = cls;
        this.f2349b = cls2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f2348a.equals(gVar.f2348a) && this.f2349b.equals(gVar.f2349b);
    }

    public int hashCode() {
        return (this.f2348a.hashCode() * 31) + this.f2349b.hashCode();
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f2348a + ", second=" + this.f2349b + '}';
    }

    public g(Class<?> cls, Class<?> cls2) {
        a(cls, cls2);
    }
}
