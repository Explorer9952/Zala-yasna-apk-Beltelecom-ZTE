package d.c.a;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ObjectAnimator.java */
/* loaded from: classes.dex */
public final class i extends m {
    private static final Map<String, com.nineoldandroids.util.c> D;
    private Object A;
    private String B;
    private com.nineoldandroids.util.c C;

    static {
        HashMap hashMap = new HashMap();
        D = hashMap;
        hashMap.put("alpha", j.f7987a);
        D.put("pivotX", j.f7988b);
        D.put("pivotY", j.f7989c);
        D.put("translationX", j.f7990d);
        D.put("translationY", j.e);
        D.put("rotation", j.f);
        D.put("rotationX", j.g);
        D.put("rotationY", j.h);
        D.put("scaleX", j.i);
        D.put("scaleY", j.j);
        D.put("scrollX", j.k);
        D.put("scrollY", j.l);
        D.put("x", j.m);
        D.put("y", j.n);
    }

    public i() {
    }

    @Override // d.c.a.m, d.c.a.a
    public /* bridge */ /* synthetic */ m a(long j) {
        a(j);
        return this;
    }

    @Override // d.c.a.m, d.c.a.a
    public void b() {
        super.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d.c.a.m
    public void d() {
        if (this.j) {
            return;
        }
        if (this.C == null && d.c.b.a.a.q && (this.A instanceof View) && D.containsKey(this.B)) {
            a(D.get(this.B));
        }
        int length = this.q.length;
        for (int i = 0; i < length; i++) {
            this.q[i].b(this.A);
        }
        super.d();
    }

    @Override // d.c.a.m
    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.A;
        if (this.q != null) {
            for (int i = 0; i < this.q.length; i++) {
                str = String.valueOf(str) + "\n    " + this.q[i].toString();
            }
        }
        return str;
    }

    private i(Object obj, String str) {
        this.A = obj;
        a(str);
    }

    public void a(String str) {
        k[] kVarArr = this.q;
        if (kVarArr != null) {
            k kVar = kVarArr[0];
            String b2 = kVar.b();
            kVar.a(str);
            this.r.remove(b2);
            this.r.put(str, kVar);
        }
        this.B = str;
        this.j = false;
    }

    @Override // d.c.a.m, d.c.a.a
    /* renamed from: clone */
    public i m12clone() {
        return (i) super.m12clone();
    }

    private <T> i(T t, com.nineoldandroids.util.c<T, ?> cVar) {
        this.A = t;
        a(cVar);
    }

    public void a(com.nineoldandroids.util.c cVar) {
        k[] kVarArr = this.q;
        if (kVarArr != null) {
            k kVar = kVarArr[0];
            String b2 = kVar.b();
            kVar.a(cVar);
            this.r.remove(b2);
            this.r.put(this.B, kVar);
        }
        if (this.C != null) {
            this.B = cVar.a();
        }
        this.C = cVar;
        this.j = false;
    }

    public static i a(Object obj, String str, float... fArr) {
        i iVar = new i(obj, str);
        iVar.a(fArr);
        return iVar;
    }

    public static <T> i a(T t, com.nineoldandroids.util.c<T, Float> cVar, float... fArr) {
        i iVar = new i(t, cVar);
        iVar.a(fArr);
        return iVar;
    }

    public static i a(Object obj, String str, l lVar, Object... objArr) {
        i iVar = new i(obj, str);
        iVar.a(objArr);
        iVar.a(lVar);
        return iVar;
    }

    @Override // d.c.a.m
    public void a(float... fArr) {
        k[] kVarArr = this.q;
        if (kVarArr != null && kVarArr.length != 0) {
            super.a(fArr);
            return;
        }
        com.nineoldandroids.util.c cVar = this.C;
        if (cVar != null) {
            a(k.a((com.nineoldandroids.util.c<?, Float>) cVar, fArr));
        } else {
            a(k.a(this.B, fArr));
        }
    }

    @Override // d.c.a.m
    public void a(Object... objArr) {
        k[] kVarArr = this.q;
        if (kVarArr != null && kVarArr.length != 0) {
            super.a(objArr);
            return;
        }
        com.nineoldandroids.util.c cVar = this.C;
        if (cVar != null) {
            a(k.a(cVar, (l) null, objArr));
        } else {
            a(k.a(this.B, (l) null, objArr));
        }
    }

    @Override // d.c.a.m, d.c.a.a
    public i a(long j) {
        super.a(j);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d.c.a.m
    public void a(float f) {
        super.a(f);
        int length = this.q.length;
        for (int i = 0; i < length; i++) {
            this.q[i].a(this.A);
        }
    }
}
