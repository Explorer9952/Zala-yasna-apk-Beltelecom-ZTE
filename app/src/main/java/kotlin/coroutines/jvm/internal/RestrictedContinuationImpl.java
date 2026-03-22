package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.EmptyCoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes2.dex */
public abstract class RestrictedContinuationImpl extends BaseContinuationImpl {
    public RestrictedContinuationImpl(@Nullable kotlin.coroutines.a<Object> aVar) {
        super(aVar);
        if (aVar != null) {
            if (!(aVar.getContext() == EmptyCoroutineContext.INSTANCE)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // kotlin.coroutines.a
    @NotNull
    public kotlin.coroutines.c getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
