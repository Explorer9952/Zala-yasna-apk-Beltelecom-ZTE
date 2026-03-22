package d.c.a;

import android.view.animation.Interpolator;
import d.c.a.g;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KeyframeSet.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    int f7983a;

    /* renamed from: b, reason: collision with root package name */
    g f7984b;

    /* renamed from: c, reason: collision with root package name */
    g f7985c;

    /* renamed from: d, reason: collision with root package name */
    Interpolator f7986d;
    ArrayList<g> e;
    l f;

    public h(g... gVarArr) {
        this.f7983a = gVarArr.length;
        ArrayList<g> arrayList = new ArrayList<>();
        this.e = arrayList;
        arrayList.addAll(Arrays.asList(gVarArr));
        this.f7984b = this.e.get(0);
        g gVar = this.e.get(this.f7983a - 1);
        this.f7985c = gVar;
        this.f7986d = gVar.b();
    }

    public static h a(float... fArr) {
        int length = fArr.length;
        g.a[] aVarArr = new g.a[Math.max(length, 2)];
        if (length == 1) {
            aVarArr[0] = (g.a) g.a(0.0f);
            aVarArr[1] = (g.a) g.a(1.0f, fArr[0]);
        } else {
            aVarArr[0] = (g.a) g.a(0.0f, fArr[0]);
            for (int i = 1; i < length; i++) {
                aVarArr[i] = (g.a) g.a(i / (length - 1), fArr[i]);
            }
        }
        return new e(aVarArr);
    }

    public String toString() {
        String str = " ";
        for (int i = 0; i < this.f7983a; i++) {
            str = String.valueOf(str) + this.e.get(i).c() + "  ";
        }
        return str;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public h m15clone() {
        ArrayList<g> arrayList = this.e;
        int size = arrayList.size();
        g[] gVarArr = new g[size];
        for (int i = 0; i < size; i++) {
            gVarArr[i] = arrayList.get(i).m14clone();
        }
        return new h(gVarArr);
    }

    public static h a(Object... objArr) {
        int length = objArr.length;
        g.b[] bVarArr = new g.b[Math.max(length, 2)];
        if (length == 1) {
            bVarArr[0] = (g.b) g.b(0.0f);
            bVarArr[1] = (g.b) g.a(1.0f, objArr[0]);
        } else {
            bVarArr[0] = (g.b) g.a(0.0f, objArr[0]);
            for (int i = 1; i < length; i++) {
                bVarArr[i] = (g.b) g.a(i / (length - 1), objArr[i]);
            }
        }
        return new h(bVarArr);
    }

    public void a(l lVar) {
        this.f = lVar;
    }

    public Object a(float f) {
        int i = this.f7983a;
        if (i == 2) {
            Interpolator interpolator = this.f7986d;
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            return this.f.evaluate(f, this.f7984b.c(), this.f7985c.c());
        }
        int i2 = 1;
        if (f <= 0.0f) {
            g gVar = this.e.get(1);
            Interpolator b2 = gVar.b();
            if (b2 != null) {
                f = b2.getInterpolation(f);
            }
            float a2 = this.f7984b.a();
            return this.f.evaluate((f - a2) / (gVar.a() - a2), this.f7984b.c(), gVar.c());
        }
        if (f >= 1.0f) {
            g gVar2 = this.e.get(i - 2);
            Interpolator b3 = this.f7985c.b();
            if (b3 != null) {
                f = b3.getInterpolation(f);
            }
            float a3 = gVar2.a();
            return this.f.evaluate((f - a3) / (this.f7985c.a() - a3), gVar2.c(), this.f7985c.c());
        }
        g gVar3 = this.f7984b;
        while (i2 < this.f7983a) {
            g gVar4 = this.e.get(i2);
            if (f < gVar4.a()) {
                Interpolator b4 = gVar4.b();
                if (b4 != null) {
                    f = b4.getInterpolation(f);
                }
                float a4 = gVar3.a();
                return this.f.evaluate((f - a4) / (gVar4.a() - a4), gVar3.c(), gVar4.c());
            }
            i2++;
            gVar3 = gVar4;
        }
        return this.f7985c.c();
    }
}
