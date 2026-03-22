package com.bumptech.glide.load.h;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: GenericLoaderFactory.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    private static final l f2071d = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class, Map<Class, m>> f2072a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Class, Map<Class, l>> f2073b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Context f2074c;

    /* compiled from: GenericLoaderFactory.java */
    /* loaded from: classes.dex */
    static class a implements l {
        a() {
        }

        @Override // com.bumptech.glide.load.h.l
        public com.bumptech.glide.load.g.c a(Object obj, int i, int i2) {
            throw new NoSuchMethodError("This should never be called!");
        }

        public String toString() {
            return "NULL_MODEL_LOADER";
        }
    }

    public c(Context context) {
        this.f2074c = context.getApplicationContext();
    }

    private <T, Y> void b(Class<T> cls, Class<Y> cls2) {
        a(cls, cls2, f2071d);
    }

    private <T, Y> l<T, Y> c(Class<T> cls, Class<Y> cls2) {
        Map<Class, l> map = this.f2073b.get(cls);
        if (map != null) {
            return map.get(cls2);
        }
        return null;
    }

    private <T, Y> m<T, Y> d(Class<T> cls, Class<Y> cls2) {
        Map<Class, m> map;
        Map<Class, m> map2 = this.f2072a.get(cls);
        m mVar = map2 != null ? map2.get(cls2) : null;
        if (mVar == null) {
            for (Class cls3 : this.f2072a.keySet()) {
                if (cls3.isAssignableFrom(cls) && (map = this.f2072a.get(cls3)) != null && (mVar = map.get(cls2)) != null) {
                    break;
                }
            }
        }
        return mVar;
    }

    public synchronized <T, Y> m<T, Y> a(Class<T> cls, Class<Y> cls2, m<T, Y> mVar) {
        m<T, Y> put;
        this.f2073b.clear();
        Map<Class, m> map = this.f2072a.get(cls);
        if (map == null) {
            map = new HashMap<>();
            this.f2072a.put(cls, map);
        }
        put = map.put(cls2, mVar);
        if (put != null) {
            Iterator<Map<Class, m>> it2 = this.f2072a.values().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (it2.next().containsValue(put)) {
                    put = null;
                    break;
                }
            }
        }
        return put;
    }

    public synchronized <T, Y> l<T, Y> a(Class<T> cls, Class<Y> cls2) {
        l<T, Y> c2 = c(cls, cls2);
        if (c2 != null) {
            if (f2071d.equals(c2)) {
                return null;
            }
            return c2;
        }
        m<T, Y> d2 = d(cls, cls2);
        if (d2 != null) {
            c2 = d2.a(this.f2074c, this);
            a(cls, cls2, c2);
        } else {
            b(cls, cls2);
        }
        return c2;
    }

    private <T, Y> void a(Class<T> cls, Class<Y> cls2, l<T, Y> lVar) {
        Map<Class, l> map = this.f2073b.get(cls);
        if (map == null) {
            map = new HashMap<>();
            this.f2073b.put(cls, map);
        }
        map.put(cls2, lVar);
    }
}
