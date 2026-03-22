package b.b;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: ArrayMap.java */
/* loaded from: classes.dex */
public class a<K, V> extends g<K, V> implements Map<K, V> {
    f<K, V> h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArrayMap.java */
    /* renamed from: b.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0056a extends f<K, V> {
        C0056a() {
        }

        @Override // b.b.f
        protected Object a(int i, int i2) {
            return a.this.f1831b[(i << 1) + i2];
        }

        @Override // b.b.f
        protected int b(Object obj) {
            return a.this.b(obj);
        }

        @Override // b.b.f
        protected int c() {
            return a.this.f1832c;
        }

        @Override // b.b.f
        protected int a(Object obj) {
            return a.this.a(obj);
        }

        @Override // b.b.f
        protected Map<K, V> b() {
            return a.this;
        }

        @Override // b.b.f
        protected void a(K k, V v) {
            a.this.put(k, v);
        }

        @Override // b.b.f
        protected V a(int i, V v) {
            return a.this.a(i, (int) v);
        }

        @Override // b.b.f
        protected void a(int i) {
            a.this.c(i);
        }

        @Override // b.b.f
        protected void a() {
            a.this.clear();
        }
    }

    public a() {
    }

    private f<K, V> b() {
        if (this.h == null) {
            this.h = new C0056a();
        }
        return this.h;
    }

    public boolean a(Collection<?> collection) {
        return f.c(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return b().d();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return b().e();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        a(this.f1832c + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return b().f();
    }

    public a(int i) {
        super(i);
    }
}
