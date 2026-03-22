package kotlin.coroutines.experimental.jvm.internal;

import kotlin.coroutines.d.b;
import kotlin.coroutines.d.c;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;

/* compiled from: CoroutineIntrinsics.kt */
/* loaded from: classes2.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> kotlin.coroutines.d.a<T> a(@NotNull c cVar, @NotNull kotlin.coroutines.d.a<? super T> aVar) {
        kotlin.coroutines.d.a<T> a2;
        f.b(cVar, "context");
        f.b(aVar, "continuation");
        b bVar = (b) cVar.a(b.f8163a);
        return (bVar == null || (a2 = bVar.a(aVar)) == null) ? aVar : a2;
    }
}
