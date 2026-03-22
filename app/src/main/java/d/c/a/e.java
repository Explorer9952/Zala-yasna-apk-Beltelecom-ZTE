package d.c.a;

import android.view.animation.Interpolator;
import d.c.a.g;
import java.util.ArrayList;

/* compiled from: FloatKeyframeSet.java */
/* loaded from: classes.dex */
class e extends h {
    private float g;
    private float h;
    private float i;
    private boolean j;

    public e(g.a... aVarArr) {
        super(aVarArr);
        this.j = true;
    }

    @Override // d.c.a.h
    public Object a(float f) {
        return Float.valueOf(b(f));
    }

    public float b(float f) {
        int i = this.f7983a;
        if (i == 2) {
            if (this.j) {
                this.j = false;
                this.g = ((g.a) this.e.get(0)).e();
                float e = ((g.a) this.e.get(1)).e();
                this.h = e;
                this.i = e - this.g;
            }
            Interpolator interpolator = this.f7986d;
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            l lVar = this.f;
            if (lVar == null) {
                return this.g + (f * this.i);
            }
            return ((Number) lVar.evaluate(f, Float.valueOf(this.g), Float.valueOf(this.h))).floatValue();
        }
        if (f <= 0.0f) {
            g.a aVar = (g.a) this.e.get(0);
            g.a aVar2 = (g.a) this.e.get(1);
            float e2 = aVar.e();
            float e3 = aVar2.e();
            float a2 = aVar.a();
            float a3 = aVar2.a();
            Interpolator b2 = aVar2.b();
            if (b2 != null) {
                f = b2.getInterpolation(f);
            }
            float f2 = (f - a2) / (a3 - a2);
            l lVar2 = this.f;
            return lVar2 == null ? e2 + (f2 * (e3 - e2)) : ((Number) lVar2.evaluate(f2, Float.valueOf(e2), Float.valueOf(e3))).floatValue();
        }
        if (f >= 1.0f) {
            g.a aVar3 = (g.a) this.e.get(i - 2);
            g.a aVar4 = (g.a) this.e.get(this.f7983a - 1);
            float e4 = aVar3.e();
            float e5 = aVar4.e();
            float a4 = aVar3.a();
            float a5 = aVar4.a();
            Interpolator b3 = aVar4.b();
            if (b3 != null) {
                f = b3.getInterpolation(f);
            }
            float f3 = (f - a4) / (a5 - a4);
            l lVar3 = this.f;
            return lVar3 == null ? e4 + (f3 * (e5 - e4)) : ((Number) lVar3.evaluate(f3, Float.valueOf(e4), Float.valueOf(e5))).floatValue();
        }
        g.a aVar5 = (g.a) this.e.get(0);
        int i2 = 1;
        while (true) {
            int i3 = this.f7983a;
            if (i2 >= i3) {
                return ((Number) this.e.get(i3 - 1).c()).floatValue();
            }
            g.a aVar6 = (g.a) this.e.get(i2);
            if (f < aVar6.a()) {
                Interpolator b4 = aVar6.b();
                if (b4 != null) {
                    f = b4.getInterpolation(f);
                }
                float a6 = (f - aVar5.a()) / (aVar6.a() - aVar5.a());
                float e6 = aVar5.e();
                float e7 = aVar6.e();
                l lVar4 = this.f;
                return lVar4 == null ? e6 + (a6 * (e7 - e6)) : ((Number) lVar4.evaluate(a6, Float.valueOf(e6), Float.valueOf(e7))).floatValue();
            }
            i2++;
            aVar5 = aVar6;
        }
    }

    @Override // d.c.a.h
    /* renamed from: clone */
    public e m15clone() {
        ArrayList<g> arrayList = this.e;
        int size = arrayList.size();
        g.a[] aVarArr = new g.a[size];
        for (int i = 0; i < size; i++) {
            aVarArr[i] = (g.a) arrayList.get(i).m14clone();
        }
        return new e(aVarArr);
    }
}
