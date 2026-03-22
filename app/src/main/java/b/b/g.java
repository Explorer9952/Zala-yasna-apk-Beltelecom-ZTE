package b.b;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* compiled from: SimpleArrayMap.java */
/* loaded from: classes.dex */
public class g<K, V> {

    /* renamed from: d, reason: collision with root package name */
    static Object[] f1829d;
    static int e;
    static Object[] f;
    static int g;

    /* renamed from: a, reason: collision with root package name */
    int[] f1830a;

    /* renamed from: b, reason: collision with root package name */
    Object[] f1831b;

    /* renamed from: c, reason: collision with root package name */
    int f1832c;

    public g() {
        this.f1830a = c.f1804a;
        this.f1831b = c.f1806c;
        this.f1832c = 0;
    }

    private static int a(int[] iArr, int i, int i2) {
        try {
            return c.a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private void e(int i) {
        if (i == 8) {
            synchronized (g.class) {
                if (f != null) {
                    Object[] objArr = f;
                    this.f1831b = objArr;
                    f = (Object[]) objArr[0];
                    this.f1830a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    g--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (g.class) {
                if (f1829d != null) {
                    Object[] objArr2 = f1829d;
                    this.f1831b = objArr2;
                    f1829d = (Object[]) objArr2[0];
                    this.f1830a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    e--;
                    return;
                }
            }
        }
        this.f1830a = new int[i];
        this.f1831b = new Object[i << 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(Object obj) {
        int i = this.f1832c * 2;
        Object[] objArr = this.f1831b;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public V c(int i) {
        Object[] objArr = this.f1831b;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.f1832c;
        int i4 = 0;
        if (i3 <= 1) {
            a(this.f1830a, objArr, i3);
            this.f1830a = c.f1804a;
            this.f1831b = c.f1806c;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.f1830a;
            if (iArr.length > 8 && i3 < iArr.length / 3) {
                int i6 = i3 > 8 ? i3 + (i3 >> 1) : 8;
                int[] iArr2 = this.f1830a;
                Object[] objArr2 = this.f1831b;
                e(i6);
                if (i3 != this.f1832c) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr2, 0, this.f1830a, 0, i);
                    System.arraycopy(objArr2, 0, this.f1831b, 0, i2);
                }
                if (i < i5) {
                    int i7 = i + 1;
                    int i8 = i5 - i;
                    System.arraycopy(iArr2, i7, this.f1830a, i, i8);
                    System.arraycopy(objArr2, i7 << 1, this.f1831b, i2, i8 << 1);
                }
            } else {
                if (i < i5) {
                    int[] iArr3 = this.f1830a;
                    int i9 = i + 1;
                    int i10 = i5 - i;
                    System.arraycopy(iArr3, i9, iArr3, i, i10);
                    Object[] objArr3 = this.f1831b;
                    System.arraycopy(objArr3, i9 << 1, objArr3, i2, i10 << 1);
                }
                Object[] objArr4 = this.f1831b;
                int i11 = i5 << 1;
                objArr4[i11] = null;
                objArr4[i11 + 1] = null;
            }
            i4 = i5;
        }
        if (i3 == this.f1832c) {
            this.f1832c = i4;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public void clear() {
        int i = this.f1832c;
        if (i > 0) {
            int[] iArr = this.f1830a;
            Object[] objArr = this.f1831b;
            this.f1830a = c.f1804a;
            this.f1831b = c.f1806c;
            this.f1832c = 0;
            a(iArr, objArr, i);
        }
        if (this.f1832c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return b(obj) >= 0;
    }

    public V d(int i) {
        return (V) this.f1831b[(i << 1) + 1];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            for (int i = 0; i < this.f1832c; i++) {
                try {
                    K b2 = b(i);
                    V d2 = d(i);
                    Object obj2 = gVar.get(b2);
                    if (d2 == null) {
                        if (obj2 != null || !gVar.containsKey(b2)) {
                            return false;
                        }
                    } else if (!d2.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f1832c; i2++) {
                try {
                    K b3 = b(i2);
                    V d3 = d(i2);
                    Object obj3 = map.get(b3);
                    if (d3 == null) {
                        if (obj3 != null || !map.containsKey(b3)) {
                            return false;
                        }
                    } else if (!d3.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v) {
        int a2 = a(obj);
        return a2 >= 0 ? (V) this.f1831b[(a2 << 1) + 1] : v;
    }

    public int hashCode() {
        int[] iArr = this.f1830a;
        Object[] objArr = this.f1831b;
        int i = this.f1832c;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public boolean isEmpty() {
        return this.f1832c <= 0;
    }

    public V put(K k, V v) {
        int i;
        int a2;
        int i2 = this.f1832c;
        if (k == null) {
            a2 = a();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            a2 = a(k, hashCode);
        }
        if (a2 >= 0) {
            int i3 = (a2 << 1) + 1;
            Object[] objArr = this.f1831b;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = a2 ^ (-1);
        if (i2 >= this.f1830a.length) {
            int i5 = 4;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.f1830a;
            Object[] objArr2 = this.f1831b;
            e(i5);
            if (i2 == this.f1832c) {
                int[] iArr2 = this.f1830a;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.f1831b, 0, objArr2.length);
                }
                a(iArr, objArr2, i2);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i4 < i2) {
            int[] iArr3 = this.f1830a;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.f1831b;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.f1832c - i4) << 1);
        }
        int i7 = this.f1832c;
        if (i2 == i7) {
            int[] iArr4 = this.f1830a;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.f1831b;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.f1832c = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k, V v) {
        V v2 = get(k);
        return v2 == null ? put(k, v) : v2;
    }

    public V remove(Object obj) {
        int a2 = a(obj);
        if (a2 >= 0) {
            return c(a2);
        }
        return null;
    }

    public V replace(K k, V v) {
        int a2 = a(k);
        if (a2 >= 0) {
            return a(a2, (int) v);
        }
        return null;
    }

    public int size() {
        return this.f1832c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1832c * 28);
        sb.append('{');
        for (int i = 0; i < this.f1832c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K b2 = b(i);
            if (b2 != this) {
                sb.append(b2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V d2 = d(i);
            if (d2 != this) {
                sb.append(d2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    int a(Object obj, int i) {
        int i2 = this.f1832c;
        if (i2 == 0) {
            return -1;
        }
        int a2 = a(this.f1830a, i2, i);
        if (a2 < 0 || obj.equals(this.f1831b[a2 << 1])) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f1830a[i3] == i) {
            if (obj.equals(this.f1831b[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = a2 - 1; i4 >= 0 && this.f1830a[i4] == i; i4--) {
            if (obj.equals(this.f1831b[i4 << 1])) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    public boolean remove(Object obj, Object obj2) {
        int a2 = a(obj);
        if (a2 < 0) {
            return false;
        }
        V d2 = d(a2);
        if (obj2 != d2 && (obj2 == null || !obj2.equals(d2))) {
            return false;
        }
        c(a2);
        return true;
    }

    public boolean replace(K k, V v, V v2) {
        int a2 = a(k);
        if (a2 < 0) {
            return false;
        }
        V d2 = d(a2);
        if (d2 != v && (v == null || !v.equals(d2))) {
            return false;
        }
        a(a2, (int) v2);
        return true;
    }

    public g(int i) {
        if (i == 0) {
            this.f1830a = c.f1804a;
            this.f1831b = c.f1806c;
        } else {
            e(i);
        }
        this.f1832c = 0;
    }

    public K b(int i) {
        return (K) this.f1831b[i << 1];
    }

    int a() {
        int i = this.f1832c;
        if (i == 0) {
            return -1;
        }
        int a2 = a(this.f1830a, i, 0);
        if (a2 < 0 || this.f1831b[a2 << 1] == null) {
            return a2;
        }
        int i2 = a2 + 1;
        while (i2 < i && this.f1830a[i2] == 0) {
            if (this.f1831b[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = a2 - 1; i3 >= 0 && this.f1830a[i3] == 0; i3--) {
            if (this.f1831b[i3 << 1] == null) {
                return i3;
            }
        }
        return i2 ^ (-1);
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (g.class) {
                if (g < 10) {
                    objArr[0] = f;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f = objArr;
                    g++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (g.class) {
                if (e < 10) {
                    objArr[0] = f1829d;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1829d = objArr;
                    e++;
                }
            }
        }
    }

    public void a(int i) {
        int i2 = this.f1832c;
        int[] iArr = this.f1830a;
        if (iArr.length < i) {
            Object[] objArr = this.f1831b;
            e(i);
            if (this.f1832c > 0) {
                System.arraycopy(iArr, 0, this.f1830a, 0, i2);
                System.arraycopy(objArr, 0, this.f1831b, 0, i2 << 1);
            }
            a(iArr, objArr, i2);
        }
        if (this.f1832c != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    public V a(int i, V v) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.f1831b;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }
}
