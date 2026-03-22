package kotlin.coroutines;

import org.jetbrains.annotations.NotNull;

/* compiled from: Continuation.kt */
/* loaded from: classes2.dex */
public interface a<T> {
    @NotNull
    c getContext();

    void resumeWith(@NotNull Object obj);
}
