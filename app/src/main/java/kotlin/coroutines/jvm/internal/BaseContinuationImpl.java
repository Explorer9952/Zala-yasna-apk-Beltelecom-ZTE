package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Result;
import kotlin.h;
import kotlin.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes2.dex */
public abstract class BaseContinuationImpl implements kotlin.coroutines.a<Object>, b, Serializable {

    @Nullable
    private final kotlin.coroutines.a<Object> completion;

    public BaseContinuationImpl(@Nullable kotlin.coroutines.a<Object> aVar) {
        this.completion = aVar;
    }

    @NotNull
    public kotlin.coroutines.a<l> create(@NotNull kotlin.coroutines.a<?> aVar) {
        kotlin.jvm.internal.f.b(aVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Nullable
    public b getCallerFrame() {
        kotlin.coroutines.a<Object> aVar = this.completion;
        if (!(aVar instanceof b)) {
            aVar = null;
        }
        return (b) aVar;
    }

    @Nullable
    public final kotlin.coroutines.a<Object> getCompletion() {
        return this.completion;
    }

    @Nullable
    public StackTraceElement getStackTraceElement() {
        return d.c(this);
    }

    @Nullable
    protected abstract Object invokeSuspend(@NotNull Object obj);

    protected void releaseIntercepted() {
    }

    @Override // kotlin.coroutines.a
    public final void resumeWith(@NotNull Object obj) {
        Object invokeSuspend;
        Object a2;
        BaseContinuationImpl baseContinuationImpl = this;
        while (true) {
            e.a(baseContinuationImpl);
            kotlin.coroutines.a<Object> aVar = baseContinuationImpl.completion;
            if (aVar != null) {
                try {
                    invokeSuspend = baseContinuationImpl.invokeSuspend(obj);
                    a2 = kotlin.coroutines.intrinsics.c.a();
                } catch (Throwable th) {
                    Result.a aVar2 = Result.Companion;
                    obj = Result.m19constructorimpl(h.a(th));
                }
                if (invokeSuspend == a2) {
                    return;
                }
                Result.a aVar3 = Result.Companion;
                obj = Result.m19constructorimpl(invokeSuspend);
                baseContinuationImpl.releaseIntercepted();
                if (aVar instanceof BaseContinuationImpl) {
                    baseContinuationImpl = (BaseContinuationImpl) aVar;
                } else {
                    aVar.resumeWith(obj);
                    return;
                }
            } else {
                kotlin.jvm.internal.f.a();
                throw null;
            }
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    @NotNull
    public kotlin.coroutines.a<l> create(@Nullable Object obj, @NotNull kotlin.coroutines.a<?> aVar) {
        kotlin.jvm.internal.f.b(aVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
