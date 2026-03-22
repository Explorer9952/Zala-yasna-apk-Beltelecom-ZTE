package kotlin;

import com.video.androidsdk.common.ErrMessage;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Exceptions.kt */
/* loaded from: classes2.dex */
public class b {
    public static void a(@NotNull Throwable th, @NotNull Throwable th2) {
        kotlin.jvm.internal.f.b(th, "$this$addSuppressed");
        kotlin.jvm.internal.f.b(th2, ErrMessage.ERRCODE_EXCEPTION);
        kotlin.internal.b.f8176a.a(th, th2);
    }
}
