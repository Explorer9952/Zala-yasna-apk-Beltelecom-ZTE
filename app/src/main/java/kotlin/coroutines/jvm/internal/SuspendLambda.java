package kotlin.coroutines.jvm.internal;

import kotlin.jvm.internal.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes2.dex */
public abstract class SuspendLambda extends ContinuationImpl implements kotlin.jvm.internal.e<Object> {
    private final int arity;

    public SuspendLambda(int i, @Nullable kotlin.coroutines.a<Object> aVar) {
        super(aVar);
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.e
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public String toString() {
        if (getCompletion() == null) {
            String a2 = h.a(this);
            kotlin.jvm.internal.f.a((Object) a2, "Reflection.renderLambdaToString(this)");
            return a2;
        }
        return super.toString();
    }

    public SuspendLambda(int i) {
        this(i, null);
    }
}
