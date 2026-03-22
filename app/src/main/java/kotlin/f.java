package kotlin;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJVM.kt */
/* loaded from: classes2.dex */
public class f {
    @NotNull
    public static <T> d<T> a(@NotNull kotlin.jvm.b.a<? extends T> aVar) {
        kotlin.jvm.internal.f.b(aVar, "initializer");
        kotlin.jvm.internal.d dVar = null;
        return new i(aVar, dVar, 2, dVar);
    }
}
