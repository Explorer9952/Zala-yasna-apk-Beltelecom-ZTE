package com.nineoldandroids.util;

/* compiled from: Property.java */
/* loaded from: classes.dex */
public abstract class c<T, V> {

    /* renamed from: a, reason: collision with root package name */
    private final String f2388a;

    public c(Class<V> cls, String str) {
        this.f2388a = str;
    }

    public abstract V a(T t);

    public void a(T t, V v) {
        throw new UnsupportedOperationException("Property " + a() + " is read-only");
    }

    public String a() {
        return this.f2388a;
    }
}
