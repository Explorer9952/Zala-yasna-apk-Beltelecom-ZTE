package kotlin.coroutines;

import java.io.Serializable;
import kotlin.coroutines.c;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes2.dex */
public final class EmptyCoroutineContext implements c, Serializable {
    public static final EmptyCoroutineContext INSTANCE = new EmptyCoroutineContext();
    private static final long serialVersionUID = 0;

    private EmptyCoroutineContext() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // kotlin.coroutines.c
    public <R> R fold(R r, @NotNull p<? super R, ? super c.b, ? extends R> pVar) {
        f.b(pVar, "operation");
        return r;
    }

    @Override // kotlin.coroutines.c
    @Nullable
    public <E extends c.b> E get(@NotNull c.InterfaceC0419c<E> interfaceC0419c) {
        f.b(interfaceC0419c, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // kotlin.coroutines.c
    @NotNull
    public c minusKey(@NotNull c.InterfaceC0419c<?> interfaceC0419c) {
        f.b(interfaceC0419c, "key");
        return this;
    }

    @Override // kotlin.coroutines.c
    @NotNull
    public c plus(@NotNull c cVar) {
        f.b(cVar, "context");
        return cVar;
    }

    @NotNull
    public String toString() {
        return "EmptyCoroutineContext";
    }
}
