package net.lucode.hackware.magicindicator;

import android.annotation.TargetApi;
import java.util.List;

/* compiled from: FragmentContainerHelper.java */
@TargetApi(11)
/* loaded from: classes2.dex */
public class a {
    public static net.lucode.hackware.magicindicator.e.c.d.a a(List<net.lucode.hackware.magicindicator.e.c.d.a> list, int i) {
        net.lucode.hackware.magicindicator.e.c.d.a aVar;
        if (i >= 0 && i <= list.size() - 1) {
            return list.get(i);
        }
        net.lucode.hackware.magicindicator.e.c.d.a aVar2 = new net.lucode.hackware.magicindicator.e.c.d.a();
        if (i < 0) {
            aVar = list.get(0);
        } else {
            i = (i - list.size()) + 1;
            aVar = list.get(list.size() - 1);
        }
        aVar2.f8247a = aVar.f8247a + (aVar.b() * i);
        aVar2.f8248b = aVar.f8248b;
        aVar2.f8249c = aVar.f8249c + (aVar.b() * i);
        aVar2.f8250d = aVar.f8250d;
        aVar2.e = aVar.e + (aVar.b() * i);
        aVar2.f = aVar.f;
        aVar2.g = aVar.g + (i * aVar.b());
        aVar2.h = aVar.h;
        return aVar2;
    }
}
