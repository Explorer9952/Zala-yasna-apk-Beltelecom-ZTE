package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: _Collections.kt */
/* loaded from: classes2.dex */
public class r extends q {

    /* compiled from: Sequences.kt */
    /* loaded from: classes2.dex */
    public static final class a<T> implements kotlin.sequences.b<T> {

        /* renamed from: a */
        final /* synthetic */ Iterable f8154a;

        public a(Iterable iterable) {
            this.f8154a = iterable;
        }

        @Override // kotlin.sequences.b
        @NotNull
        public Iterator<T> iterator() {
            return this.f8154a.iterator();
        }
    }

    public static final <T> T a(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.f.b(list, "$this$single");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    @NotNull
    public static <T> kotlin.sequences.b<T> b(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f.b(iterable, "$this$asSequence");
        return new a(iterable);
    }

    public static <T> T c(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f.b(iterable, "$this$single");
        if (iterable instanceof List) {
            return (T) a((List) iterable);
        }
        Iterator<? extends T> it2 = iterable.iterator();
        if (it2.hasNext()) {
            T next = it2.next();
            if (it2.hasNext()) {
                throw new IllegalArgumentException("Collection has more than one element.");
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> boolean a(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f.b(iterable, "$this$any");
        return iterable instanceof Collection ? !((Collection) iterable).isEmpty() : iterable.iterator().hasNext();
    }

    @NotNull
    public static final <T, A extends Appendable> A a(@NotNull Iterable<? extends T> iterable, @NotNull A a2, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable kotlin.jvm.b.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.f.b(iterable, "$this$joinTo");
        kotlin.jvm.internal.f.b(a2, "buffer");
        kotlin.jvm.internal.f.b(charSequence, "separator");
        kotlin.jvm.internal.f.b(charSequence2, "prefix");
        kotlin.jvm.internal.f.b(charSequence3, "postfix");
        kotlin.jvm.internal.f.b(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (T t : iterable) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            kotlin.text.m.a(a2, t, lVar);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ String a(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.b.l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            lVar = null;
        }
        return a(iterable, charSequence, charSequence5, charSequence6, i3, charSequence7, lVar);
    }

    @NotNull
    public static final <T> String a(@NotNull Iterable<? extends T> iterable, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable kotlin.jvm.b.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.f.b(iterable, "$this$joinToString");
        kotlin.jvm.internal.f.b(charSequence, "separator");
        kotlin.jvm.internal.f.b(charSequence2, "prefix");
        kotlin.jvm.internal.f.b(charSequence3, "postfix");
        kotlin.jvm.internal.f.b(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        a(iterable, sb, charSequence, charSequence2, charSequence3, i, charSequence4, lVar);
        String sb2 = sb.toString();
        kotlin.jvm.internal.f.a((Object) sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }
}
