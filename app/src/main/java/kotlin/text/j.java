package kotlin.text;

import java.util.Collection;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Regex.kt */
/* loaded from: classes2.dex */
public final class j implements i {

    /* renamed from: a, reason: collision with root package name */
    private final Matcher f8224a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f8225b;

    /* compiled from: Regex.kt */
    /* loaded from: classes2.dex */
    public static final class a extends kotlin.collections.a<f> implements h {

        /* compiled from: Regex.kt */
        /* renamed from: kotlin.text.j$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static final class C0423a extends Lambda implements kotlin.jvm.b.l<Integer, f> {
            C0423a() {
                super(1);
            }

            @Nullable
            public final f a(int i) {
                return a.this.get(i);
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ f invoke(Integer num) {
                return a(num.intValue());
            }
        }

        a() {
        }

        public /* bridge */ boolean a(f fVar) {
            return super.contains(fVar);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj != null ? obj instanceof f : true) {
                return a((f) obj);
            }
            return false;
        }

        @Nullable
        public f get(int i) {
            kotlin.n.c b2;
            b2 = k.b(j.this.b(), i);
            if (b2.e().intValue() < 0) {
                return null;
            }
            String group = j.this.b().group(i);
            kotlin.jvm.internal.f.a((Object) group, "matchResult.group(index)");
            return new f(group, b2);
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        @NotNull
        public Iterator<f> iterator() {
            kotlin.n.c a2;
            kotlin.sequences.b b2;
            kotlin.sequences.b a3;
            a2 = kotlin.collections.j.a((Collection<?>) this);
            b2 = kotlin.collections.r.b(a2);
            a3 = kotlin.sequences.h.a(b2, new C0423a());
            return a3.iterator();
        }

        @Override // kotlin.collections.a
        public int a() {
            return j.this.b().groupCount() + 1;
        }
    }

    public j(@NotNull Matcher matcher, @NotNull CharSequence charSequence) {
        kotlin.jvm.internal.f.b(matcher, "matcher");
        kotlin.jvm.internal.f.b(charSequence, "input");
        this.f8224a = matcher;
        this.f8225b = charSequence;
        new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult b() {
        return this.f8224a;
    }

    @Override // kotlin.text.i
    @Nullable
    public i next() {
        i b2;
        int end = b().end() + (b().end() == b().start() ? 1 : 0);
        if (end > this.f8225b.length()) {
            return null;
        }
        Matcher matcher = this.f8224a.pattern().matcher(this.f8225b);
        kotlin.jvm.internal.f.a((Object) matcher, "matcher.pattern().matcher(input)");
        b2 = k.b(matcher, end, this.f8225b);
        return b2;
    }

    @Override // kotlin.text.i
    @NotNull
    public kotlin.n.c a() {
        kotlin.n.c b2;
        b2 = k.b(b());
        return b2;
    }
}
