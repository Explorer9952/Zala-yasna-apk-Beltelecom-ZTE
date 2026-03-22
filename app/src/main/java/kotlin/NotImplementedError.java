package kotlin;

import org.jetbrains.annotations.NotNull;

/* compiled from: Standard.kt */
/* loaded from: classes2.dex */
public final class NotImplementedError extends Error {
    /* JADX WARN: Multi-variable type inference failed */
    public NotImplementedError() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotImplementedError(@NotNull String str) {
        super(str);
        kotlin.jvm.internal.f.b(str, "message");
    }

    public /* synthetic */ NotImplementedError(String str, int i, kotlin.jvm.internal.d dVar) {
        this((i & 1) != 0 ? "An operation is not implemented." : str);
    }
}
