package com.bumptech.glide.s;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public class e<T, Y> {

    /* renamed from: b, reason: collision with root package name */
    private int f2345b;

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<T, Y> f2344a = new LinkedHashMap<>(100, 0.75f, true);

    /* renamed from: c, reason: collision with root package name */
    private int f2346c = 0;

    public e(int i) {
        this.f2345b = i;
    }

    public Y a(T t) {
        return this.f2344a.get(t);
    }

    protected void a(T t, Y y) {
    }

    public int b() {
        return this.f2346c;
    }

    protected int b(Y y) {
        return 1;
    }

    public Y c(T t) {
        Y remove = this.f2344a.remove(t);
        if (remove != null) {
            this.f2346c -= b((e<T, Y>) remove);
        }
        return remove;
    }

    public void a() {
        b(0);
    }

    public Y b(T t, Y y) {
        if (b((e<T, Y>) y) >= this.f2345b) {
            a(t, y);
            return null;
        }
        Y put = this.f2344a.put(t, y);
        if (y != null) {
            this.f2346c += b((e<T, Y>) y);
        }
        if (put != null) {
            this.f2346c -= b((e<T, Y>) put);
        }
        c();
        return put;
    }

    private void c() {
        b(this.f2345b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i) {
        while (this.f2346c > i) {
            Map.Entry<T, Y> next = this.f2344a.entrySet().iterator().next();
            Y value = next.getValue();
            this.f2346c -= b((e<T, Y>) value);
            T key = next.getKey();
            this.f2344a.remove(key);
            a(key, value);
        }
    }
}
