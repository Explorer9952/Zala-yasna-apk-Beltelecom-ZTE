package kotlin.internal.d;

import com.video.androidsdk.common.ErrMessage;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;

/* compiled from: JDK7PlatformImplementations.kt */
/* loaded from: classes2.dex */
public class a extends kotlin.internal.a {
    @Override // kotlin.internal.a
    public void a(@NotNull Throwable th, @NotNull Throwable th2) {
        f.b(th, "cause");
        f.b(th2, ErrMessage.ERRCODE_EXCEPTION);
        th.addSuppressed(th2);
    }
}
