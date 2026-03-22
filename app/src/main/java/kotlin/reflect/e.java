package kotlin.reflect;

/* compiled from: KFunction.kt */
/* loaded from: classes2.dex */
public interface e<R> extends b<R>, kotlin.c<R> {
    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    @Override // kotlin.reflect.b
    boolean isSuspend();
}
