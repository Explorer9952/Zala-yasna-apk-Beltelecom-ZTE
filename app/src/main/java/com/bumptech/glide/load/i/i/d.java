package com.bumptech.glide.load.i.i;

import com.bumptech.glide.s.g;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TranscoderRegistry.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private static final g f2175b = new g();

    /* renamed from: a, reason: collision with root package name */
    private final Map<g, c<?, ?>> f2176a = new HashMap();

    public <Z, R> void a(Class<Z> cls, Class<R> cls2, c<Z, R> cVar) {
        this.f2176a.put(new g(cls, cls2), cVar);
    }

    public <Z, R> c<Z, R> a(Class<Z> cls, Class<R> cls2) {
        c<Z, R> cVar;
        if (cls.equals(cls2)) {
            return e.b();
        }
        synchronized (f2175b) {
            f2175b.a(cls, cls2);
            cVar = (c) this.f2176a.get(f2175b);
        }
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalArgumentException("No transcoder registered for " + cls + " and " + cls2);
    }
}
