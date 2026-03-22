package kotlin.reflect;

import kotlin.reflect.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KProperty.kt */
/* loaded from: classes2.dex */
public interface k<R> extends j<R>, kotlin.jvm.b.a<R> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes2.dex */
    public interface a<R> extends j.a<R>, kotlin.jvm.b.a<R> {
    }

    R get();

    @Nullable
    Object getDelegate();

    @NotNull
    /* renamed from: getGetter */
    a<R> mo29getGetter();
}
