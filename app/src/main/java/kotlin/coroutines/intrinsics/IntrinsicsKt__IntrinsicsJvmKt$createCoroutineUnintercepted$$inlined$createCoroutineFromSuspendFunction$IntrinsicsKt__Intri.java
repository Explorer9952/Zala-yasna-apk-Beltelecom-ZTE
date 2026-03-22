package kotlin.coroutines.intrinsics;

import kotlin.TypeCastException;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.h;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IntrinsicsJvm.kt */
/* loaded from: classes2.dex */
public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4 extends ContinuationImpl {
    final /* synthetic */ kotlin.coroutines.a $completion;
    final /* synthetic */ kotlin.coroutines.c $context;
    final /* synthetic */ Object $receiver$inlined;
    final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
    private int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4(kotlin.coroutines.a aVar, kotlin.coroutines.c cVar, kotlin.coroutines.a aVar2, kotlin.coroutines.c cVar2, p pVar, Object obj) {
        super(aVar2, cVar2);
        this.$completion = aVar;
        this.$context = cVar;
        this.$this_createCoroutineUnintercepted$inlined = pVar;
        this.$receiver$inlined = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    protected Object invokeSuspend(@NotNull Object obj) {
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                this.label = 2;
                h.a(obj);
                return obj;
            }
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
        this.label = 1;
        h.a(obj);
        p pVar = this.$this_createCoroutineUnintercepted$inlined;
        if (pVar == null) {
            throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
        k.a(pVar, 2);
        return pVar.invoke(this.$receiver$inlined, this);
    }
}
