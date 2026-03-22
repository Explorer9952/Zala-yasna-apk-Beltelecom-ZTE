package b.a.a.b;

import b.a.a.b.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FastSafeIterableMap.java */
/* loaded from: classes.dex */
public class a<K, V> extends b<K, V> {
    private HashMap<K, b.c<K, V>> e = new HashMap<>();

    @Override // b.a.a.b.b
    protected b.c<K, V> a(K k) {
        return this.e.get(k);
    }

    @Override // b.a.a.b.b
    public V b(K k, V v) {
        b.c<K, V> a2 = a(k);
        if (a2 != null) {
            return a2.f1790b;
        }
        this.e.put(k, a(k, v));
        return null;
    }

    public boolean contains(K k) {
        return this.e.containsKey(k);
    }

    @Override // b.a.a.b.b
    public V remove(K k) {
        V v = (V) super.remove(k);
        this.e.remove(k);
        return v;
    }

    public Map.Entry<K, V> b(K k) {
        if (contains(k)) {
            return this.e.get(k).f1792d;
        }
        return null;
    }
}
