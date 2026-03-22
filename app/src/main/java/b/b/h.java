package b.b;

/* compiled from: SparseArrayCompat.java */
/* loaded from: classes.dex */
public class h<E> implements Cloneable {
    private static final Object e = new Object();

    /* renamed from: a, reason: collision with root package name */
    private boolean f1833a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f1834b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f1835c;

    /* renamed from: d, reason: collision with root package name */
    private int f1836d;

    public h() {
        this(10);
    }

    private void c() {
        int i = this.f1836d;
        int[] iArr = this.f1834b;
        Object[] objArr = this.f1835c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != e) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1833a = false;
        this.f1836d = i2;
    }

    public E a(int i) {
        return b(i, null);
    }

    public E b(int i, E e2) {
        int a2 = c.a(this.f1834b, this.f1836d, i);
        if (a2 >= 0) {
            Object[] objArr = this.f1835c;
            if (objArr[a2] != e) {
                return (E) objArr[a2];
            }
        }
        return e2;
    }

    public void d(int i) {
        Object[] objArr = this.f1835c;
        Object obj = objArr[i];
        Object obj2 = e;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f1833a = true;
        }
    }

    public E e(int i) {
        if (this.f1833a) {
            c();
        }
        return (E) this.f1835c[i];
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1836d * 28);
        sb.append('{');
        for (int i = 0; i < this.f1836d; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(c(i));
            sb.append('=');
            E e2 = e(i);
            if (e2 != this) {
                sb.append(e2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public h(int i) {
        this.f1833a = false;
        if (i == 0) {
            this.f1834b = c.f1804a;
            this.f1835c = c.f1806c;
        } else {
            int b2 = c.b(i);
            this.f1834b = new int[b2];
            this.f1835c = new Object[b2];
        }
    }

    public void a() {
        int i = this.f1836d;
        Object[] objArr = this.f1835c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1836d = 0;
        this.f1833a = false;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public h<E> m2clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f1834b = (int[]) this.f1834b.clone();
            hVar.f1835c = (Object[]) this.f1835c.clone();
            return hVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public int b() {
        if (this.f1833a) {
            c();
        }
        return this.f1836d;
    }

    public void a(int i, E e2) {
        int i2 = this.f1836d;
        if (i2 != 0 && i <= this.f1834b[i2 - 1]) {
            c(i, e2);
            return;
        }
        if (this.f1833a && this.f1836d >= this.f1834b.length) {
            c();
        }
        int i3 = this.f1836d;
        if (i3 >= this.f1834b.length) {
            int b2 = c.b(i3 + 1);
            int[] iArr = new int[b2];
            Object[] objArr = new Object[b2];
            int[] iArr2 = this.f1834b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f1835c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f1834b = iArr;
            this.f1835c = objArr;
        }
        this.f1834b[i3] = i;
        this.f1835c[i3] = e2;
        this.f1836d = i3 + 1;
    }

    public int b(int i) {
        if (this.f1833a) {
            c();
        }
        return c.a(this.f1834b, this.f1836d, i);
    }

    public void c(int i, E e2) {
        int a2 = c.a(this.f1834b, this.f1836d, i);
        if (a2 >= 0) {
            this.f1835c[a2] = e2;
            return;
        }
        int i2 = a2 ^ (-1);
        if (i2 < this.f1836d) {
            Object[] objArr = this.f1835c;
            if (objArr[i2] == e) {
                this.f1834b[i2] = i;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f1833a && this.f1836d >= this.f1834b.length) {
            c();
            i2 = c.a(this.f1834b, this.f1836d, i) ^ (-1);
        }
        int i3 = this.f1836d;
        if (i3 >= this.f1834b.length) {
            int b2 = c.b(i3 + 1);
            int[] iArr = new int[b2];
            Object[] objArr2 = new Object[b2];
            int[] iArr2 = this.f1834b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f1835c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1834b = iArr;
            this.f1835c = objArr2;
        }
        int i4 = this.f1836d;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.f1834b;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.f1835c;
            System.arraycopy(objArr4, i2, objArr4, i5, this.f1836d - i2);
        }
        this.f1834b[i2] = i;
        this.f1835c[i2] = e2;
        this.f1836d++;
    }

    public int c(int i) {
        if (this.f1833a) {
            c();
        }
        return this.f1834b[i];
    }
}
