package com.bumptech.glide.load.engine.l;

import com.bumptech.glide.load.engine.l.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GroupedLinkedMap.java */
/* loaded from: classes.dex */
class e<K extends h, V> {

    /* renamed from: a, reason: collision with root package name */
    private final a<K, V> f2020a = new a<>();

    /* renamed from: b, reason: collision with root package name */
    private final Map<K, a<K, V>> f2021b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GroupedLinkedMap.java */
    /* loaded from: classes.dex */
    public static class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private final K f2022a;

        /* renamed from: b, reason: collision with root package name */
        private List<V> f2023b;

        /* renamed from: c, reason: collision with root package name */
        a<K, V> f2024c;

        /* renamed from: d, reason: collision with root package name */
        a<K, V> f2025d;

        public a() {
            this(null);
        }

        public int b() {
            List<V> list = this.f2023b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public a(K k) {
            this.f2025d = this;
            this.f2024c = this;
            this.f2022a = k;
        }

        public V a() {
            int b2 = b();
            if (b2 > 0) {
                return this.f2023b.remove(b2 - 1);
            }
            return null;
        }

        public void a(V v) {
            if (this.f2023b == null) {
                this.f2023b = new ArrayList();
            }
            this.f2023b.add(v);
        }
    }

    private void b(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.f2020a;
        aVar.f2025d = aVar2.f2025d;
        aVar.f2024c = aVar2;
        d(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f2025d;
        aVar2.f2024c = aVar.f2024c;
        aVar.f2024c.f2025d = aVar2;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.f2024c.f2025d = aVar;
        aVar.f2025d.f2024c = aVar;
    }

    public void a(K k, V v) {
        a<K, V> aVar = this.f2021b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            b(aVar);
            this.f2021b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a((a<K, V>) v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.f2020a.f2024c; !aVar.equals(this.f2020a); aVar = aVar.f2024c) {
            z = true;
            sb.append('{');
            sb.append(aVar.f2022a);
            sb.append(':');
            sb.append(aVar.b());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    public V a(K k) {
        a<K, V> aVar = this.f2021b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.f2021b.put(k, aVar);
        } else {
            k.a();
        }
        a(aVar);
        return aVar.a();
    }

    public V a() {
        for (a aVar = this.f2020a.f2025d; !aVar.equals(this.f2020a); aVar = aVar.f2025d) {
            V v = (V) aVar.a();
            if (v != null) {
                return v;
            }
            c(aVar);
            this.f2021b.remove(aVar.f2022a);
            ((h) aVar.f2022a).a();
        }
        return null;
    }

    private void a(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.f2020a;
        aVar.f2025d = aVar2;
        aVar.f2024c = aVar2.f2024c;
        d(aVar);
    }
}
