package kotlin;

import com.video.androidsdk.common.ErrMessage;
import kotlin.Result;
import org.jetbrains.annotations.NotNull;

/* compiled from: Result.kt */
/* loaded from: classes2.dex */
public final class h {
    @NotNull
    public static final Object a(@NotNull Throwable th) {
        kotlin.jvm.internal.f.b(th, ErrMessage.ERRCODE_EXCEPTION);
        return new Result.Failure(th);
    }

    public static final void a(@NotNull Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }
}
