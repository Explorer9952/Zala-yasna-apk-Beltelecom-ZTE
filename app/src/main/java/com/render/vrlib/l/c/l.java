package com.render.vrlib.l.c;

import android.content.res.Resources;
import com.render.vrlib.l.c.g;
import java.util.Iterator;

/* compiled from: MotionWithTouchStrategy.java */
/* loaded from: classes.dex */
public class l extends i {
    private static final float j = Resources.getSystem().getDisplayMetrics().density;

    public l(g.a aVar) {
        super(aVar);
    }

    @Override // com.render.vrlib.l.c.i, com.render.vrlib.l.c.f
    public boolean a(float f, float f2, float f3) {
        Iterator<com.render.vrlib.a> it2 = d().iterator();
        while (it2.hasNext()) {
            com.render.vrlib.a next = it2.next();
            next.a(next.f() - ((f / j) * 0.2f));
            next.b(next.g() - ((f2 / j) * 0.2f));
        }
        com.render.vrlib.j.c e = e();
        if (!(e instanceof com.render.vrlib.j.g)) {
            return false;
        }
        ((com.render.vrlib.j.g) e).d();
        return false;
    }
}
