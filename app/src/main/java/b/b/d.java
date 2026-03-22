package b.b;

/* compiled from: LongSparseArray.java */
/* loaded from: classes.dex */
public class d<E> implements Cloneable {
    private static final Object e = new Object();

    /* renamed from: a, reason: collision with root package name */
    private boolean f1807a;

    /* renamed from: b, reason: collision with root package name */
    private long[] f1808b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f1809c;

    /* renamed from: d, reason: collision with root package name */
    private int f1810d;

    public d() {
        this(10);
    }

    private void c() {
        int i = this.f1810d;
        long[] jArr = this.f1808b;
        Object[] objArr = this.f1809c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != e) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1807a = false;
        this.f1810d = i2;
    }

    public E a(long j) {
        return b(j, null);
    }

    public E b(long j, E e2) {
        int a2 = c.a(this.f1808b, this.f1810d, j);
        if (a2 >= 0) {
            Object[] objArr = this.f1809c;
            if (objArr[a2] != e) {
                return (E) objArr[a2];
            }
        }
        return e2;
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1810d * 28);
        sb.append('{');
        for (int i = 0; i < this.f1810d; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(a(i));
            sb.append('=');
            E c2 = c(i);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public d(int i) {
        this.f1807a = false;
        if (i == 0) {
            this.f1808b = c.f1805b;
            this.f1809c = c.f1806c;
        } else {
            int c2 = c.c(i);
            this.f1808b = new long[c2];
            this.f1809c = new Object[c2];
        }
    }

    public long a(int i) {
        if (this.f1807a) {
            c();
        }
        return this.f1808b[i];
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public d<E> m1clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.f1808b = (long[]) this.f1808b.clone();
            dVar.f1809c = (Object[]) this.f1809c.clone();
            return dVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public void b(long j) {
        int a2 = c.a(this.f1808b, this.f1810d, j);
        if (a2 >= 0) {
            Object[] objArr = this.f1809c;
            Object obj = objArr[a2];
            Object obj2 = e;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f1807a = true;
            }
        }
    }

    public void a() {
        int i = this.f1810d;
        Object[] objArr = this.f1809c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1810d = 0;
        this.f1807a = false;
    }

    public void b(int i) {
        Object[] objArr = this.f1809c;
        Object obj = objArr[i];
        Object obj2 = e;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f1807a = true;
        }
    }

    public void a(long j, E e2) {
        int i = this.f1810d;
        if (i != 0 && j <= this.f1808b[i - 1]) {
            c(j, e2);
            return;
        }
        if (this.f1807a && this.f1810d >= this.f1808b.length) {
            c();
        }
        int i2 = this.f1810d;
        if (i2 >= this.f1808b.length) {
            int c2 = c.c(i2 + 1);
            long[] jArr = new long[c2];
            Object[] objArr = new Object[c2];
            long[] jArr2 = this.f1808b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f1809c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f1808b = jArr;
            this.f1809c = objArr;
        }
        this.f1808b[i2] = j;
        this.f1809c[i2] = e2;
        this.f1810d = i2 + 1;
    }

    public int b() {
        if (this.f1807a) {
            c();
        }
        return this.f1810d;
    }

    public void c(long j, E e2) {
        int a2 = c.a(this.f1808b, this.f1810d, j);
        if (a2 >= 0) {
            this.f1809c[a2] = e2;
            return;
        }
        int i = a2 ^ (-1);
        if (i < this.f1810d) {
            Object[] objArr = this.f1809c;
            if (objArr[i] == e) {
                this.f1808b[i] = j;
                objArr[i] = e2;
                return;
            }
        }
        if (this.f1807a && this.f1810d >= this.f1808b.length) {
            c();
            i = c.a(this.f1808b, this.f1810d, j) ^ (-1);
        }
        int i2 = this.f1810d;
        if (i2 >= this.f1808b.length) {
            int c2 = c.c(i2 + 1);
            long[] jArr = new long[c2];
            Object[] objArr2 = new Object[c2];
            long[] jArr2 = this.f1808b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f1809c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1808b = jArr;
            this.f1809c = objArr2;
        }
        int i3 = this.f1810d;
        if (i3 - i != 0) {
            long[] jArr3 = this.f1808b;
            int i4 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i4, i3 - i);
            Object[] objArr4 = this.f1809c;
            System.arraycopy(objArr4, i, objArr4, i4, this.f1810d - i);
        }
        this.f1808b[i] = j;
        this.f1809c[i] = e2;
        this.f1810d++;
    }

    public E c(int i) {
        if (this.f1807a) {
            c();
        }
        return (E) this.f1809c[i];
    }
}
