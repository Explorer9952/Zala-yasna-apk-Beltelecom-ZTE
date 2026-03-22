package net.lucode.hackware.magicindicator;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

/* compiled from: NavigatorHelper.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private SparseBooleanArray f8232a = new SparseBooleanArray();

    /* renamed from: b, reason: collision with root package name */
    private SparseArray<Float> f8233b = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    private int f8234c;

    /* renamed from: d, reason: collision with root package name */
    private int f8235d;
    private int e;
    private float f;
    private int g;
    private boolean h;
    private a i;

    /* compiled from: NavigatorHelper.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, int i2);

        void a(int i, int i2, float f, boolean z);

        void b(int i, int i2);

        void b(int i, int i2, float f, boolean z);
    }

    private void b(int i, float f, boolean z, boolean z2) {
        if (!this.h && i != this.e && this.g != 1) {
            int i2 = this.f8235d;
            if (((i != i2 - 1 && i != i2 + 1) || this.f8233b.get(i, Float.valueOf(0.0f)).floatValue() == 1.0f) && !z2) {
                return;
            }
        }
        a aVar = this.i;
        if (aVar != null) {
            aVar.b(i, this.f8234c, f, z);
        }
        this.f8233b.put(i, Float.valueOf(f));
    }

    private void d(int i) {
        a aVar = this.i;
        if (aVar != null) {
            aVar.a(i, this.f8234c);
        }
        this.f8232a.put(i, true);
    }

    private void e(int i) {
        a aVar = this.i;
        if (aVar != null) {
            aVar.b(i, this.f8234c);
        }
        this.f8232a.put(i, false);
    }

    public void a(int i, float f, int i2) {
        boolean z;
        float f2 = i + f;
        boolean z2 = this.f <= f2;
        if (this.g != 0) {
            if (f2 == this.f) {
                return;
            }
            int i3 = i + 1;
            if (f == 0.0f && z2) {
                i3 = i - 1;
                z = false;
            } else {
                z = true;
            }
            for (int i4 = 0; i4 < this.f8234c; i4++) {
                if (i4 != i && i4 != i3 && this.f8233b.get(i4, Float.valueOf(0.0f)).floatValue() != 1.0f) {
                    b(i4, 1.0f, z2, true);
                }
            }
            if (!z) {
                float f3 = 1.0f - f;
                b(i3, f3, true, false);
                a(i, f3, true, false);
            } else if (z2) {
                b(i, f, true, false);
                a(i3, f, true, false);
            } else {
                float f4 = 1.0f - f;
                b(i3, f4, false, false);
                a(i, f4, false, false);
            }
        } else {
            for (int i5 = 0; i5 < this.f8234c; i5++) {
                if (i5 != this.f8235d) {
                    if (!this.f8232a.get(i5)) {
                        d(i5);
                    }
                    if (this.f8233b.get(i5, Float.valueOf(0.0f)).floatValue() != 1.0f) {
                        b(i5, 1.0f, false, true);
                    }
                }
            }
            a(this.f8235d, 1.0f, false, true);
            e(this.f8235d);
        }
        this.f = f2;
    }

    public int c() {
        return this.f8234c;
    }

    public void c(int i) {
        this.f8234c = i;
        this.f8232a.clear();
        this.f8233b.clear();
    }

    public void b(int i) {
        this.e = this.f8235d;
        this.f8235d = i;
        e(i);
        for (int i2 = 0; i2 < this.f8234c; i2++) {
            if (i2 != this.f8235d && !this.f8232a.get(i2)) {
                d(i2);
            }
        }
    }

    public int b() {
        return this.g;
    }

    private void a(int i, float f, boolean z, boolean z2) {
        if (this.h || i == this.f8235d || this.g == 1 || z2) {
            a aVar = this.i;
            if (aVar != null) {
                aVar.a(i, this.f8234c, f, z);
            }
            this.f8233b.put(i, Float.valueOf(1.0f - f));
        }
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(a aVar) {
        this.i = aVar;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public int a() {
        return this.f8235d;
    }
}
