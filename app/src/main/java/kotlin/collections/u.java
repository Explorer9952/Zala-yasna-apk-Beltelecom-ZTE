package kotlin.collections;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: Iterators.kt */
/* loaded from: classes2.dex */
public abstract class u implements Iterator<Integer> {
    public abstract int a();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @NotNull
    public final Integer next() {
        return Integer.valueOf(a());
    }
}
