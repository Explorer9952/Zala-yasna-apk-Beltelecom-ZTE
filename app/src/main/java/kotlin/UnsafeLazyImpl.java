package kotlin;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* compiled from: Lazy.kt */
/* loaded from: classes2.dex */
public final class UnsafeLazyImpl<T> implements d<T>, Serializable {
    private Object _value;
    private kotlin.jvm.b.a<? extends T> initializer;

    public UnsafeLazyImpl(@NotNull kotlin.jvm.b.a<? extends T> aVar) {
        kotlin.jvm.internal.f.b(aVar, "initializer");
        this.initializer = aVar;
        this._value = k.f8185a;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.d
    public T getValue() {
        if (this._value == k.f8185a) {
            kotlin.jvm.b.a<? extends T> aVar = this.initializer;
            if (aVar != null) {
                this._value = aVar.invoke();
                this.initializer = null;
            } else {
                kotlin.jvm.internal.f.a();
                throw null;
            }
        }
        return (T) this._value;
    }

    public boolean isInitialized() {
        return this._value != k.f8185a;
    }

    @NotNull
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
