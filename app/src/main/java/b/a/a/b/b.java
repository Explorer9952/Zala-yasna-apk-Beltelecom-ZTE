package b.a.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: SafeIterableMap.java */
/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    c<K, V> f1785a;

    /* renamed from: b, reason: collision with root package name */
    private c<K, V> f1786b;

    /* renamed from: c, reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f1787c = new WeakHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private int f1788d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // b.a.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f1792d;
        }

        @Override // b.a.a.b.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f1791c;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: b.a.a.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0055b<K, V> extends e<K, V> {
        C0055b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // b.a.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f1791c;
        }

        @Override // b.a.a.b.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f1792d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final K f1789a;

        /* renamed from: b, reason: collision with root package name */
        final V f1790b;

        /* renamed from: c, reason: collision with root package name */
        c<K, V> f1791c;

        /* renamed from: d, reason: collision with root package name */
        c<K, V> f1792d;

        c(K k, V v) {
            this.f1789a = k;
            this.f1790b = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f1789a.equals(cVar.f1789a) && this.f1790b.equals(cVar.f1790b);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f1789a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f1790b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f1789a.hashCode() ^ this.f1790b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f1789a + "=" + this.f1790b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private c<K, V> f1793a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f1794b = true;

        d() {
        }

        @Override // b.a.a.b.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f1793a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f1792d;
                this.f1793a = cVar3;
                this.f1794b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f1794b) {
                return b.this.f1785a != null;
            }
            c<K, V> cVar = this.f1793a;
            return (cVar == null || cVar.f1791c == null) ? false : true;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.f1794b) {
                this.f1794b = false;
                this.f1793a = b.this.f1785a;
            } else {
                c<K, V> cVar = this.f1793a;
                this.f1793a = cVar != null ? cVar.f1791c : null;
            }
            return this.f1793a;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a, reason: collision with root package name */
        c<K, V> f1796a;

        /* renamed from: b, reason: collision with root package name */
        c<K, V> f1797b;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f1796a = cVar2;
            this.f1797b = cVar;
        }

        @Override // b.a.a.b.b.f
        public void a(c<K, V> cVar) {
            if (this.f1796a == cVar && cVar == this.f1797b) {
                this.f1797b = null;
                this.f1796a = null;
            }
            c<K, V> cVar2 = this.f1796a;
            if (cVar2 == cVar) {
                this.f1796a = b(cVar2);
            }
            if (this.f1797b == cVar) {
                this.f1797b = a();
            }
        }

        abstract c<K, V> b(c<K, V> cVar);

        abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1797b != null;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f1797b;
            this.f1797b = a();
            return cVar;
        }

        private c<K, V> a() {
            c<K, V> cVar = this.f1797b;
            c<K, V> cVar2 = this.f1796a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    protected c<K, V> a(K k) {
        c<K, V> cVar = this.f1785a;
        while (cVar != null && !cVar.f1789a.equals(k)) {
            cVar = cVar.f1791c;
        }
        return cVar;
    }

    public V b(K k, V v) {
        c<K, V> a2 = a(k);
        if (a2 != null) {
            return a2.f1790b;
        }
        a(k, v);
        return null;
    }

    public b<K, V>.d c() {
        b<K, V>.d dVar = new d();
        this.f1787c.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> d() {
        return this.f1786b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it2 = iterator();
        Iterator<Map.Entry<K, V>> it3 = bVar.iterator();
        while (it2.hasNext() && it3.hasNext()) {
            Map.Entry<K, V> next = it2.next();
            Map.Entry<K, V> next2 = it3.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it2.hasNext() || it3.hasNext()) ? false : true;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it2 = iterator();
        int i = 0;
        while (it2.hasNext()) {
            i += it2.next().hashCode();
        }
        return i;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f1785a, this.f1786b);
        this.f1787c.put(aVar, false);
        return aVar;
    }

    public V remove(K k) {
        c<K, V> a2 = a(k);
        if (a2 == null) {
            return null;
        }
        this.f1788d--;
        if (!this.f1787c.isEmpty()) {
            Iterator<f<K, V>> it2 = this.f1787c.keySet().iterator();
            while (it2.hasNext()) {
                it2.next().a(a2);
            }
        }
        c<K, V> cVar = a2.f1792d;
        if (cVar != null) {
            cVar.f1791c = a2.f1791c;
        } else {
            this.f1785a = a2.f1791c;
        }
        c<K, V> cVar2 = a2.f1791c;
        if (cVar2 != null) {
            cVar2.f1792d = a2.f1792d;
        } else {
            this.f1786b = a2.f1792d;
        }
        a2.f1791c = null;
        a2.f1792d = null;
        return a2.f1790b;
    }

    public int size() {
        return this.f1788d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it2 = iterator();
        while (it2.hasNext()) {
            sb.append(it2.next().toString());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c<K, V> a(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.f1788d++;
        c<K, V> cVar2 = this.f1786b;
        if (cVar2 == null) {
            this.f1785a = cVar;
            this.f1786b = cVar;
            return cVar;
        }
        cVar2.f1791c = cVar;
        cVar.f1792d = cVar2;
        this.f1786b = cVar;
        return cVar;
    }

    public Map.Entry<K, V> b() {
        return this.f1785a;
    }

    public Iterator<Map.Entry<K, V>> a() {
        C0055b c0055b = new C0055b(this.f1786b, this.f1785a);
        this.f1787c.put(c0055b, false);
        return c0055b;
    }
}
