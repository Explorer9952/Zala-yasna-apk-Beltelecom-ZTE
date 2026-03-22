package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Strings.kt */
/* loaded from: classes2.dex */
public final class d implements kotlin.sequences.b<kotlin.n.c> {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f8214a;

    /* renamed from: b, reason: collision with root package name */
    private final int f8215b;

    /* renamed from: c, reason: collision with root package name */
    private final int f8216c;

    /* renamed from: d, reason: collision with root package name */
    private final kotlin.jvm.b.p<CharSequence, Integer, Pair<Integer, Integer>> f8217d;

    /* compiled from: Strings.kt */
    /* loaded from: classes2.dex */
    public static final class a implements Iterator<kotlin.n.c> {

        /* renamed from: a, reason: collision with root package name */
        private int f8218a = -1;

        /* renamed from: b, reason: collision with root package name */
        private int f8219b;

        /* renamed from: c, reason: collision with root package name */
        private int f8220c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private kotlin.n.c f8221d;
        private int e;

        a() {
            int a2;
            a2 = kotlin.n.f.a(d.this.f8215b, 0, d.this.f8214a.length());
            this.f8219b = a2;
            this.f8220c = a2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        
            if (r0 < r6.f.f8216c) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.f8220c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f8218a = r1
                r0 = 0
                r6.f8221d = r0
                goto L9e
            Lc:
                kotlin.text.d r0 = kotlin.text.d.this
                int r0 = kotlin.text.d.c(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.e
                int r0 = r0 + r3
                r6.e = r0
                kotlin.text.d r4 = kotlin.text.d.this
                int r4 = kotlin.text.d.c(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f8220c
                kotlin.text.d r4 = kotlin.text.d.this
                java.lang.CharSequence r4 = kotlin.text.d.b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                int r0 = r6.f8219b
                kotlin.n.c r1 = new kotlin.n.c
                kotlin.text.d r4 = kotlin.text.d.this
                java.lang.CharSequence r4 = kotlin.text.d.b(r4)
                int r4 = kotlin.text.v.c(r4)
                r1.<init>(r0, r4)
                r6.f8221d = r1
                r6.f8220c = r2
                goto L9c
            L47:
                kotlin.text.d r0 = kotlin.text.d.this
                kotlin.jvm.b.p r0 = kotlin.text.d.a(r0)
                kotlin.text.d r4 = kotlin.text.d.this
                java.lang.CharSequence r4 = kotlin.text.d.b(r4)
                int r5 = r6.f8220c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L77
                int r0 = r6.f8219b
                kotlin.n.c r1 = new kotlin.n.c
                kotlin.text.d r4 = kotlin.text.d.this
                java.lang.CharSequence r4 = kotlin.text.d.b(r4)
                int r4 = kotlin.text.v.c(r4)
                r1.<init>(r0, r4)
                r6.f8221d = r1
                r6.f8220c = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.component1()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.component2()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f8219b
                kotlin.n.c r4 = kotlin.n.d.d(r4, r2)
                r6.f8221d = r4
                int r2 = r2 + r0
                r6.f8219b = r2
                if (r0 != 0) goto L99
                r1 = 1
            L99:
                int r2 = r2 + r1
                r6.f8220c = r2
            L9c:
                r6.f8218a = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.d.a.a():void");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f8218a == -1) {
                a();
            }
            return this.f8218a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        @NotNull
        public kotlin.n.c next() {
            if (this.f8218a == -1) {
                a();
            }
            if (this.f8218a != 0) {
                kotlin.n.c cVar = this.f8221d;
                if (cVar != null) {
                    this.f8221d = null;
                    this.f8218a = -1;
                    return cVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull CharSequence charSequence, int i, int i2, @NotNull kotlin.jvm.b.p<? super CharSequence, ? super Integer, Pair<Integer, Integer>> pVar) {
        kotlin.jvm.internal.f.b(charSequence, "input");
        kotlin.jvm.internal.f.b(pVar, "getNextMatch");
        this.f8214a = charSequence;
        this.f8215b = i;
        this.f8216c = i2;
        this.f8217d = pVar;
    }

    @Override // kotlin.sequences.b
    @NotNull
    public Iterator<kotlin.n.c> iterator() {
        return new a();
    }
}
