package kotlin.io;

import java.io.Closeable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Closeable.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final void a(@Nullable Closeable closeable, @Nullable Throwable th) {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            kotlin.b.a(th, th2);
        }
    }
}
