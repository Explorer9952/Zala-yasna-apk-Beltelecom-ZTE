package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.b.l;
import org.jetbrains.annotations.NotNull;

/* compiled from: Sequences.kt */
/* loaded from: classes2.dex */
public final class i<T, R> implements b<R> {

    /* renamed from: a, reason: collision with root package name */
    private final b<T> f8201a;

    /* renamed from: b, reason: collision with root package name */
    private final l<T, R> f8202b;

    /* compiled from: Sequences.kt */
    /* loaded from: classes2.dex */
    public static final class a implements Iterator<R> {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final Iterator<T> f8203a;

        a() {
            this.f8203a = i.this.f8201a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f8203a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) i.this.f8202b.invoke(this.f8203a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(@NotNull b<? extends T> bVar, @NotNull l<? super T, ? extends R> lVar) {
        kotlin.jvm.internal.f.b(bVar, "sequence");
        kotlin.jvm.internal.f.b(lVar, "transformer");
        this.f8201a = bVar;
        this.f8202b = lVar;
    }

    @Override // kotlin.sequences.b
    @NotNull
    public Iterator<R> iterator() {
        return new a();
    }
}
