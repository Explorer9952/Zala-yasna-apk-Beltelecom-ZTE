package com.render.vrlib.l.c;

import android.content.Context;
import android.content.res.Resources;
import com.render.vrlib.l.c.g;
import java.util.Iterator;

/* compiled from: TouchStrategy.java */
/* loaded from: classes.dex */
public class m extends a {
    static {
        float f = Resources.getSystem().getDisplayMetrics().density;
    }

    public m(g.a aVar) {
        super(aVar);
    }

    @Override // com.render.vrlib.l.c.f
    public boolean a(float f, float f2, float f3) {
        Iterator<com.render.vrlib.a> it2 = d().iterator();
        while (it2.hasNext()) {
            com.render.vrlib.a next = it2.next();
            next.a(next.f() - f);
            next.b(next.g() - f2);
            next.c(f3);
        }
        com.render.vrlib.j.c e = e();
        if (!(e instanceof com.render.vrlib.j.g)) {
            return false;
        }
        ((com.render.vrlib.j.g) e).d();
        return false;
    }

    @Override // com.render.vrlib.l.c.f
    public void b(Context context) {
    }

    @Override // com.render.vrlib.l.b
    public void c(Context context) {
    }

    @Override // com.render.vrlib.l.b
    public void d(Context context) {
    }

    @Override // com.render.vrlib.l.b
    public void e(Context context) {
    }

    @Override // com.render.vrlib.l.c.f
    public void f() {
        Iterator<com.render.vrlib.a> it2 = d().iterator();
        while (it2.hasNext()) {
            it2.next().p();
        }
    }

    @Override // com.render.vrlib.l.b
    public boolean f(Context context) {
        return true;
    }

    @Override // com.render.vrlib.l.c.f
    public void a() {
        Iterator<com.render.vrlib.a> it2 = d().iterator();
        while (it2.hasNext()) {
            it2.next().q();
        }
    }

    @Override // com.render.vrlib.l.b
    public void a(Context context) {
        Iterator<com.render.vrlib.a> it2 = d().iterator();
        while (it2.hasNext()) {
            it2.next().n();
        }
    }
}
