package kotlin.coroutines.intrinsics;

import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.h;
import kotlin.jvm.b.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IntrinsicsJvm.kt */
/* loaded from: classes2.dex */
public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1 extends RestrictedContinuationImpl {
    final /* synthetic */ l $block;
    final /* synthetic */ kotlin.coroutines.a $completion;
    private int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1(l lVar, kotlin.coroutines.a aVar, kotlin.coroutines.a aVar2) {
        super(aVar2);
        this.$block = lVar;
        this.$completion = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    protected Object invokeSuspend(@NotNull Object obj) {
        int i = this.label;
        if (i == 0) {
            this.label = 1;
            h.a(obj);
            return this.$block.invoke(this);
        }
        if (i == 1) {
            this.label = 2;
            h.a(obj);
            return obj;
        }
        throw new IllegalStateException("This coroutine had already completed".toString());
    }
}
