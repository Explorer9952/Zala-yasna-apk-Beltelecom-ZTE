package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes2.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final kotlin.coroutines.c _context;
    private transient kotlin.coroutines.a<Object> intercepted;

    public ContinuationImpl(@Nullable kotlin.coroutines.a<Object> aVar, @Nullable kotlin.coroutines.c cVar) {
        super(aVar);
        this._context = cVar;
    }

    @Override // kotlin.coroutines.a
    @NotNull
    public kotlin.coroutines.c getContext() {
        kotlin.coroutines.c cVar = this._context;
        if (cVar != null) {
            return cVar;
        }
        kotlin.jvm.internal.f.a();
        throw null;
    }

    @NotNull
    public final kotlin.coroutines.a<Object> intercepted() {
        kotlin.coroutines.a<Object> aVar = this.intercepted;
        if (aVar == null) {
            kotlin.coroutines.b bVar = (kotlin.coroutines.b) getContext().get(kotlin.coroutines.b.I);
            if (bVar == null || (aVar = bVar.b(this)) == null) {
                aVar = this;
            }
            this.intercepted = aVar;
        }
        return aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    protected void releaseIntercepted() {
        kotlin.coroutines.a<?> aVar = this.intercepted;
        if (aVar != null && aVar != this) {
            c.b bVar = getContext().get(kotlin.coroutines.b.I);
            if (bVar == null) {
                kotlin.jvm.internal.f.a();
                throw null;
            }
            ((kotlin.coroutines.b) bVar).a(aVar);
        }
        this.intercepted = a.f8165a;
    }

    public ContinuationImpl(@Nullable kotlin.coroutines.a<Object> aVar) {
        this(aVar, aVar != null ? aVar.getContext() : null);
    }
}
