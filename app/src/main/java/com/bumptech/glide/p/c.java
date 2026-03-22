package com.bumptech.glide.p;

import com.bumptech.glide.s.g;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DataLoadProviderRegistry.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static final g f2284b = new g();

    /* renamed from: a, reason: collision with root package name */
    private final Map<g, b<?, ?>> f2285a = new HashMap();

    public <T, Z> void a(Class<T> cls, Class<Z> cls2, b<T, Z> bVar) {
        this.f2285a.put(new g(cls, cls2), bVar);
    }

    public <T, Z> b<T, Z> a(Class<T> cls, Class<Z> cls2) {
        b<T, Z> bVar;
        synchronized (f2284b) {
            f2284b.a(cls, cls2);
            bVar = (b) this.f2285a.get(f2284b);
        }
        return bVar == null ? d.g() : bVar;
    }
}
