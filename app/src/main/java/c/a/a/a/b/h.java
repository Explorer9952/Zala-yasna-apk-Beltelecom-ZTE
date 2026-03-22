package c.a.a.a.b;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: SkinItem.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public View f1861a;

    /* renamed from: b, reason: collision with root package name */
    public List<g> f1862b = new ArrayList();

    public void a() {
        if (c.a.a.a.e.b.a(this.f1862b)) {
            return;
        }
        Iterator<g> it2 = this.f1862b.iterator();
        while (it2.hasNext()) {
            it2.next().a(this.f1861a);
        }
    }

    public void b() {
        if (c.a.a.a.e.b.a(this.f1862b)) {
            return;
        }
        this.f1862b.clear();
        this.f1862b = null;
    }

    public String toString() {
        return "SkinItem [view=" + this.f1861a.getClass().getSimpleName() + ", attrs=" + this.f1862b + "]";
    }
}
