package kotlin;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LazyJVM.kt */
/* loaded from: classes2.dex */
final class i<T> implements d<T>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    private kotlin.jvm.b.a<? extends T> f8172a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Object f8173b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f8174c;

    public i(@NotNull kotlin.jvm.b.a<? extends T> aVar, @Nullable Object obj) {
        kotlin.jvm.internal.f.b(aVar, "initializer");
        this.f8172a = aVar;
        this.f8173b = k.f8185a;
        this.f8174c = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    public boolean a() {
        return this.f8173b != k.f8185a;
    }

    @Override // kotlin.d
    public T getValue() {
        T t;
        T t2 = (T) this.f8173b;
        if (t2 != k.f8185a) {
            return t2;
        }
        synchronized (this.f8174c) {
            t = (T) this.f8173b;
            if (t == k.f8185a) {
                kotlin.jvm.b.a<? extends T> aVar = this.f8172a;
                if (aVar != null) {
                    t = aVar.invoke();
                    this.f8173b = t;
                    this.f8172a = null;
                } else {
                    kotlin.jvm.internal.f.a();
                    throw null;
                }
            }
        }
        return t;
    }

    @NotNull
    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ i(kotlin.jvm.b.a aVar, Object obj, int i, kotlin.jvm.internal.d dVar) {
        this(aVar, (i & 2) != 0 ? null : obj);
    }
}
