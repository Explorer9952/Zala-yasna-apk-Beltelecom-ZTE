package kotlin.reflect;

import kotlin.jvm.b.p;
import kotlin.reflect.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KProperty.kt */
/* loaded from: classes2.dex */
public interface m<D, E, R> extends j<R>, p<D, E, R> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes2.dex */
    public interface a<D, E, R> extends j.a<R>, p<D, E, R> {
    }

    R get(D d2, E e);

    @Nullable
    Object getDelegate(D d2, E e);

    @NotNull
    /* renamed from: getGetter */
    a<D, E, R> mo33getGetter();
}
