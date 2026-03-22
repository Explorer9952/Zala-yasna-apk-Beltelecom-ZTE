package kotlin.collections;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MutableCollections.kt */
/* loaded from: classes2.dex */
public class o extends n {
    public static <T> boolean a(@NotNull Iterable<? extends T> iterable, @NotNull kotlin.jvm.b.l<? super T, Boolean> lVar) {
        kotlin.jvm.internal.f.b(iterable, "$this$retainAll");
        kotlin.jvm.internal.f.b(lVar, "predicate");
        return a(iterable, lVar, false);
    }

    private static final <T> boolean a(@NotNull Iterable<? extends T> iterable, kotlin.jvm.b.l<? super T, Boolean> lVar, boolean z) {
        Iterator<? extends T> it2 = iterable.iterator();
        boolean z2 = false;
        while (it2.hasNext()) {
            if (lVar.invoke(it2.next()).booleanValue() == z) {
                it2.remove();
                z2 = true;
            }
        }
        return z2;
    }
}
