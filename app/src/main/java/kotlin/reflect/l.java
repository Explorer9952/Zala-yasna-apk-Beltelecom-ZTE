package kotlin.reflect;

import kotlin.reflect.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KProperty.kt */
/* loaded from: classes2.dex */
public interface l<T, R> extends j<R>, kotlin.jvm.b.l<T, R> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes2.dex */
    public interface a<T, R> extends j.a<R>, kotlin.jvm.b.l<T, R> {
    }

    R get(T t);

    @Nullable
    Object getDelegate(T t);

    @NotNull
    /* renamed from: getGetter */
    a<T, R> mo31getGetter();
}
