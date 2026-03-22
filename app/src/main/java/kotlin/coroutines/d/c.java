package kotlin.coroutines.d;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes2.dex */
public interface c {

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes2.dex */
    public interface a extends c {
    }

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes2.dex */
    public interface b<E extends a> {
    }

    @Nullable
    <E extends a> E a(@NotNull b<E> bVar);
}
