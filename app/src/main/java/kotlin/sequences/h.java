package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.b.l;
import kotlin.text.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Sequences.kt */
/* loaded from: classes2.dex */
public class h extends g {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterables.kt */
    /* loaded from: classes2.dex */
    public static final class a<T> implements Iterable<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f8200a;

        public a(b bVar) {
            this.f8200a = bVar;
        }

        @Override // java.lang.Iterable
        @NotNull
        public Iterator<T> iterator() {
            return this.f8200a.iterator();
        }
    }

    @NotNull
    public static <T, R> b<R> a(@NotNull b<? extends T> bVar, @NotNull l<? super T, ? extends R> lVar) {
        kotlin.jvm.internal.f.b(bVar, "$this$map");
        kotlin.jvm.internal.f.b(lVar, "transform");
        return new i(bVar, lVar);
    }

    @NotNull
    public static final <T, A extends Appendable> A a(@NotNull b<? extends T> bVar, @NotNull A a2, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.f.b(bVar, "$this$joinTo");
        kotlin.jvm.internal.f.b(a2, "buffer");
        kotlin.jvm.internal.f.b(charSequence, "separator");
        kotlin.jvm.internal.f.b(charSequence2, "prefix");
        kotlin.jvm.internal.f.b(charSequence3, "postfix");
        kotlin.jvm.internal.f.b(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (T t : bVar) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            m.a(a2, t, lVar);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ String a(b bVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, l lVar, int i2, Object obj) {
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
        return a(bVar, charSequence, charSequence5, charSequence6, i3, charSequence7, lVar);
    }

    @NotNull
    public static final <T> String a(@NotNull b<? extends T> bVar, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.f.b(bVar, "$this$joinToString");
        kotlin.jvm.internal.f.b(charSequence, "separator");
        kotlin.jvm.internal.f.b(charSequence2, "prefix");
        kotlin.jvm.internal.f.b(charSequence3, "postfix");
        kotlin.jvm.internal.f.b(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        a(bVar, sb, charSequence, charSequence2, charSequence3, i, charSequence4, lVar);
        String sb2 = sb.toString();
        kotlin.jvm.internal.f.a((Object) sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    @NotNull
    public static <T> Iterable<T> a(@NotNull b<? extends T> bVar) {
        kotlin.jvm.internal.f.b(bVar, "$this$asIterable");
        return new a(bVar);
    }
}
