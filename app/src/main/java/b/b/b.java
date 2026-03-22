package b.b;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: ArraySet.java */
/* loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {
    private static final int[] e = new int[0];
    private static final Object[] f = new Object[0];
    private static Object[] g;
    private static int h;
    private static Object[] i;
    private static int j;

    /* renamed from: a, reason: collision with root package name */
    private int[] f1799a;

    /* renamed from: b, reason: collision with root package name */
    Object[] f1800b;

    /* renamed from: c, reason: collision with root package name */
    int f1801c;

    /* renamed from: d, reason: collision with root package name */
    private f<E, E> f1802d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArraySet.java */
    /* loaded from: classes.dex */
    public class a extends f<E, E> {
        a() {
        }

        @Override // b.b.f
        protected Object a(int i, int i2) {
            return b.this.f1800b[i];
        }

        @Override // b.b.f
        protected int b(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // b.b.f
        protected int c() {
            return b.this.f1801c;
        }

        @Override // b.b.f
        protected int a(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // b.b.f
        protected Map<E, E> b() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // b.b.f
        protected void a(E e, E e2) {
            b.this.add(e);
        }

        @Override // b.b.f
        protected E a(int i, E e) {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // b.b.f
        protected void a(int i) {
            b.this.b(i);
        }

        @Override // b.b.f
        protected void a() {
            b.this.clear();
        }
    }

    public b() {
        this(0);
    }

    private int a(Object obj, int i2) {
        int i3 = this.f1801c;
        if (i3 == 0) {
            return -1;
        }
        int a2 = c.a(this.f1799a, i3, i2);
        if (a2 < 0 || obj.equals(this.f1800b[a2])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.f1799a[i4] == i2) {
            if (obj.equals(this.f1800b[i4])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = a2 - 1; i5 >= 0 && this.f1799a[i5] == i2; i5--) {
            if (obj.equals(this.f1800b[i5])) {
                return i5;
            }
        }
        return i4 ^ (-1);
    }

    private int b() {
        int i2 = this.f1801c;
        if (i2 == 0) {
            return -1;
        }
        int a2 = c.a(this.f1799a, i2, 0);
        if (a2 < 0 || this.f1800b[a2] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f1799a[i3] == 0) {
            if (this.f1800b[i3] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = a2 - 1; i4 >= 0 && this.f1799a[i4] == 0; i4--) {
            if (this.f1800b[i4] == null) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    private void d(int i2) {
        if (i2 == 8) {
            synchronized (b.class) {
                if (i != null) {
                    Object[] objArr = i;
                    this.f1800b = objArr;
                    i = (Object[]) objArr[0];
                    this.f1799a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    j--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (b.class) {
                if (g != null) {
                    Object[] objArr2 = g;
                    this.f1800b = objArr2;
                    g = (Object[]) objArr2[0];
                    this.f1799a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    h--;
                    return;
                }
            }
        }
        this.f1799a = new int[i2];
        this.f1800b = new Object[i2];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        int i2;
        int a2;
        if (e2 == null) {
            a2 = b();
            i2 = 0;
        } else {
            int hashCode = e2.hashCode();
            i2 = hashCode;
            a2 = a(e2, hashCode);
        }
        if (a2 >= 0) {
            return false;
        }
        int i3 = a2 ^ (-1);
        int i4 = this.f1801c;
        if (i4 >= this.f1799a.length) {
            int i5 = 4;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.f1799a;
            Object[] objArr = this.f1800b;
            d(i5);
            int[] iArr2 = this.f1799a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f1800b, 0, objArr.length);
            }
            a(iArr, objArr, this.f1801c);
        }
        int i6 = this.f1801c;
        if (i3 < i6) {
            int[] iArr3 = this.f1799a;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.f1800b;
            System.arraycopy(objArr2, i3, objArr2, i7, this.f1801c - i3);
        }
        this.f1799a[i3] = i2;
        this.f1800b[i3] = e2;
        this.f1801c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        a(this.f1801c + collection.size());
        Iterator<? extends E> it2 = collection.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            z |= add(it2.next());
        }
        return z;
    }

    public E c(int i2) {
        return (E) this.f1800b[i2];
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2 = this.f1801c;
        if (i2 != 0) {
            a(this.f1799a, this.f1800b, i2);
            this.f1799a = e;
            this.f1800b = f;
            this.f1801c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it2 = collection.iterator();
        while (it2.hasNext()) {
            if (!contains(it2.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f1801c; i2++) {
                try {
                    if (!set.contains(c(i2))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f1799a;
        int i2 = this.f1801c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public int indexOf(Object obj) {
        return obj == null ? b() : a(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f1801c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return a().e().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        b(indexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it2 = collection.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            z |= remove(it2.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.f1801c - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.f1800b[i2])) {
                b(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f1801c;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i2 = this.f1801c;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f1800b, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1801c * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1801c; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            E c2 = c(i2);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public b(int i2) {
        if (i2 == 0) {
            this.f1799a = e;
            this.f1800b = f;
        } else {
            d(i2);
        }
        this.f1801c = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f1801c) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f1801c));
        }
        System.arraycopy(this.f1800b, 0, tArr, 0, this.f1801c);
        int length = tArr.length;
        int i2 = this.f1801c;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    private static void a(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (j < 10) {
                    objArr[0] = i;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    i = objArr;
                    j++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (b.class) {
                if (h < 10) {
                    objArr[0] = g;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    g = objArr;
                    h++;
                }
            }
        }
    }

    public E b(int i2) {
        Object[] objArr = this.f1800b;
        E e2 = (E) objArr[i2];
        int i3 = this.f1801c;
        if (i3 <= 1) {
            a(this.f1799a, objArr, i3);
            this.f1799a = e;
            this.f1800b = f;
            this.f1801c = 0;
        } else {
            int[] iArr = this.f1799a;
            if (iArr.length > 8 && i3 < iArr.length / 3) {
                int i4 = i3 > 8 ? i3 + (i3 >> 1) : 8;
                int[] iArr2 = this.f1799a;
                Object[] objArr2 = this.f1800b;
                d(i4);
                this.f1801c--;
                if (i2 > 0) {
                    System.arraycopy(iArr2, 0, this.f1799a, 0, i2);
                    System.arraycopy(objArr2, 0, this.f1800b, 0, i2);
                }
                int i5 = this.f1801c;
                if (i2 < i5) {
                    int i6 = i2 + 1;
                    System.arraycopy(iArr2, i6, this.f1799a, i2, i5 - i2);
                    System.arraycopy(objArr2, i6, this.f1800b, i2, this.f1801c - i2);
                }
            } else {
                int i7 = this.f1801c - 1;
                this.f1801c = i7;
                if (i2 < i7) {
                    int[] iArr3 = this.f1799a;
                    int i8 = i2 + 1;
                    System.arraycopy(iArr3, i8, iArr3, i2, i7 - i2);
                    Object[] objArr3 = this.f1800b;
                    System.arraycopy(objArr3, i8, objArr3, i2, this.f1801c - i2);
                }
                this.f1800b[this.f1801c] = null;
            }
        }
        return e2;
    }

    public void a(int i2) {
        int[] iArr = this.f1799a;
        if (iArr.length < i2) {
            Object[] objArr = this.f1800b;
            d(i2);
            int i3 = this.f1801c;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.f1799a, 0, i3);
                System.arraycopy(objArr, 0, this.f1800b, 0, this.f1801c);
            }
            a(iArr, objArr, this.f1801c);
        }
    }

    private f<E, E> a() {
        if (this.f1802d == null) {
            this.f1802d = new a();
        }
        return this.f1802d;
    }
}
