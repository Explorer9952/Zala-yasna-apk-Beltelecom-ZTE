package com.render.vrlib.l.c;

import android.content.res.Resources;
import com.render.vrlib.l.c.g;
import java.util.Iterator;

/* compiled from: CardboardMTStrategy.java */
/* loaded from: classes.dex */
public class b extends c {
    private static final float k = Resources.getSystem().getDisplayMetrics().density;

    public b(g.a aVar) {
        super(aVar);
    }

    @Override // com.render.vrlib.l.c.c, com.render.vrlib.l.c.f
    public boolean a(float f, float f2, float f3) {
        Iterator<com.render.vrlib.a> it2 = d().iterator();
        while (it2.hasNext()) {
            com.render.vrlib.a next = it2.next();
            next.a(next.f() - ((f / k) * 0.2f));
            next.b(next.g() - ((f2 / k) * 0.2f));
        }
        com.render.vrlib.j.c e = e();
        if (!(e instanceof com.render.vrlib.j.g)) {
            return false;
        }
        ((com.render.vrlib.j.g) e).d();
        return false;
    }
}
