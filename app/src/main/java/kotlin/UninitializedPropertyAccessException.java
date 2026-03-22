package kotlin;

import org.jetbrains.annotations.Nullable;

/* compiled from: UninitializedPropertyAccessException.kt */
/* loaded from: classes2.dex */
public final class UninitializedPropertyAccessException extends RuntimeException {
    public UninitializedPropertyAccessException() {
    }

    public UninitializedPropertyAccessException(@Nullable String str) {
        super(str);
    }

    public UninitializedPropertyAccessException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public UninitializedPropertyAccessException(@Nullable Throwable th) {
        super(th);
    }
}
