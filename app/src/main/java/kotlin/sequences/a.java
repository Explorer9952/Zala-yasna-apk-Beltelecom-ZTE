package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.b.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sequences.kt */
/* loaded from: classes2.dex */
public final class a<T> implements b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final kotlin.jvm.b.a<T> f8195a;

    /* renamed from: b, reason: collision with root package name */
    private final l<T, T> f8196b;

    /* compiled from: Sequences.kt */
    /* renamed from: kotlin.sequences.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0422a implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private T f8197a;

        /* renamed from: b, reason: collision with root package name */
        private int f8198b = -2;

        C0422a() {
        }

        private final void a() {
            T t;
            if (this.f8198b == -2) {
                t = (T) a.this.f8195a.invoke();
            } else {
                l lVar = a.this.f8196b;
                T t2 = this.f8197a;
                if (t2 == null) {
                    kotlin.jvm.internal.f.a();
                    throw null;
                }
                t = (T) lVar.invoke(t2);
            }
            this.f8197a = t;
            this.f8198b = t == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f8198b < 0) {
                a();
            }
            return this.f8198b == 1;
        }

        @Override // java.util.Iterator
        @NotNull
        public T next() {
            if (this.f8198b < 0) {
                a();
            }
            if (this.f8198b != 0) {
                T t = this.f8197a;
                if (t != null) {
                    this.f8198b = -1;
                    return t;
                }
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull kotlin.jvm.b.a<? extends T> aVar, @NotNull l<? super T, ? extends T> lVar) {
        kotlin.jvm.internal.f.b(aVar, "getInitialValue");
        kotlin.jvm.internal.f.b(lVar, "getNextValue");
        this.f8195a = aVar;
        this.f8196b = lVar;
    }

    @Override // kotlin.sequences.b
    @NotNull
    public Iterator<T> iterator() {
        return new C0422a();
    }
}
