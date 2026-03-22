package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collection;
import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: AbstractCollection.kt */
/* loaded from: classes2.dex */
public abstract class a<E> implements Collection<E> {

    /* compiled from: AbstractCollection.kt */
    /* renamed from: kotlin.collections.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0416a extends Lambda implements kotlin.jvm.b.l<E, CharSequence> {
        C0416a() {
            super(1);
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ CharSequence invoke(Object obj) {
            return invoke((C0416a) obj);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.b.l
        @NotNull
        public final CharSequence invoke(E e) {
            return e == a.this ? "(this Collection)" : String.valueOf(e);
        }
    }

    public abstract int a();

    @Override // java.util.Collection
    public boolean add(E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        Iterator<E> it2 = iterator();
        while (it2.hasNext()) {
            if (kotlin.jvm.internal.f.a(it2.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        kotlin.jvm.internal.f.b(collection, MessengerShareContentUtility.ELEMENTS);
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it2 = collection.iterator();
        while (it2.hasNext()) {
            if (!contains(it2.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    @NotNull
    public Object[] toArray() {
        return kotlin.jvm.internal.c.a(this);
    }

    @NotNull
    public String toString() {
        String a2;
        a2 = r.a(this, ", ", "[", "]", 0, null, new C0416a(), 24, null);
        return a2;
    }

    @Override // java.util.Collection
    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        kotlin.jvm.internal.f.b(tArr, "array");
        T[] tArr2 = (T[]) kotlin.jvm.internal.c.a(this, tArr);
        if (tArr2 != null) {
            return tArr2;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
