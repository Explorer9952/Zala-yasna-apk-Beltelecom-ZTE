package kotlin.coroutines.jvm.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes2.dex */
public final class a implements kotlin.coroutines.a<Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f8165a = new a();

    private a() {
    }

    @Override // kotlin.coroutines.a
    @NotNull
    public kotlin.coroutines.c getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // kotlin.coroutines.a
    public void resumeWith(@NotNull Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @NotNull
    public String toString() {
        return "This continuation is already complete";
    }
}
