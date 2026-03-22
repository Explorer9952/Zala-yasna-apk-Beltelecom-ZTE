package kotlin.coroutines.d;

import org.jetbrains.annotations.NotNull;

/* compiled from: Coroutines.kt */
/* loaded from: classes2.dex */
public interface a<T> {
    @NotNull
    c getContext();

    void resume(T t);

    void resumeWithException(@NotNull Throwable th);
}
