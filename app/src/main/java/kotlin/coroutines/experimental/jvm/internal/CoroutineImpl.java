package kotlin.coroutines.experimental.jvm.internal;

import com.video.androidsdk.common.ErrMessage;
import kotlin.TypeCastException;
import kotlin.coroutines.d.c;
import kotlin.coroutines.d.d.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineImpl.kt */
/* loaded from: classes2.dex */
public abstract class CoroutineImpl extends Lambda<Object> implements kotlin.coroutines.d.a<Object> {
    private final c _context;
    private kotlin.coroutines.d.a<Object> _facade;

    @Nullable
    protected kotlin.coroutines.d.a<Object> completion;
    protected int label;

    public CoroutineImpl(int i, @Nullable kotlin.coroutines.d.a<Object> aVar) {
        super(i);
        this.completion = aVar;
        this.label = aVar != null ? 0 : -1;
        kotlin.coroutines.d.a<Object> aVar2 = this.completion;
        this._context = aVar2 != null ? aVar2.getContext() : null;
    }

    @NotNull
    public kotlin.coroutines.d.a<l> create(@NotNull kotlin.coroutines.d.a<?> aVar) {
        f.b(aVar, "completion");
        throw new IllegalStateException("create(Continuation) has not been overridden");
    }

    @Nullable
    protected abstract Object doResume(@Nullable Object obj, @Nullable Throwable th);

    @Override // kotlin.coroutines.d.a
    @NotNull
    public c getContext() {
        c cVar = this._context;
        if (cVar != null) {
            return cVar;
        }
        f.a();
        throw null;
    }

    @NotNull
    public final kotlin.coroutines.d.a<Object> getFacade() {
        if (this._facade == null) {
            c cVar = this._context;
            if (cVar == null) {
                f.a();
                throw null;
            }
            this._facade = a.a(cVar, this);
        }
        kotlin.coroutines.d.a<Object> aVar = this._facade;
        if (aVar != null) {
            return aVar;
        }
        f.a();
        throw null;
    }

    @Override // kotlin.coroutines.d.a
    public void resume(@Nullable Object obj) {
        Object a2;
        kotlin.coroutines.d.a<Object> aVar = this.completion;
        if (aVar == null) {
            f.a();
            throw null;
        }
        try {
            Object doResume = doResume(obj, null);
            a2 = b.a();
            if (doResume != a2) {
                if (aVar == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                aVar.resume(doResume);
            }
        } catch (Throwable th) {
            aVar.resumeWithException(th);
        }
    }

    @Override // kotlin.coroutines.d.a
    public void resumeWithException(@NotNull Throwable th) {
        Object a2;
        f.b(th, ErrMessage.ERRCODE_EXCEPTION);
        kotlin.coroutines.d.a<Object> aVar = this.completion;
        if (aVar == null) {
            f.a();
            throw null;
        }
        try {
            Object doResume = doResume(null, th);
            a2 = b.a();
            if (doResume != a2) {
                if (aVar == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                aVar.resume(doResume);
            }
        } catch (Throwable th2) {
            aVar.resumeWithException(th2);
        }
    }

    @NotNull
    public kotlin.coroutines.d.a<l> create(@Nullable Object obj, @NotNull kotlin.coroutines.d.a<?> aVar) {
        f.b(aVar, "completion");
        throw new IllegalStateException("create(Any?;Continuation) has not been overridden");
    }
}
