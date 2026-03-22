package kotlin.sequences;

import kotlin.jvm.b.l;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sequences.kt */
/* loaded from: classes2.dex */
public class f extends e {
    @NotNull
    public static <T> b<T> a(@NotNull kotlin.jvm.b.a<? extends T> aVar, @NotNull l<? super T, ? extends T> lVar) {
        kotlin.jvm.internal.f.b(aVar, "seedFunction");
        kotlin.jvm.internal.f.b(lVar, "nextFunction");
        return new a(aVar, lVar);
    }
}
