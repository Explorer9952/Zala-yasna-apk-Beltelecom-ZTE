package kotlin.n;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Ranges.kt */
/* loaded from: classes2.dex */
public final class c extends kotlin.n.a {
    public static final a f = new a(null);

    @NotNull
    private static final c e = new c(1, 0);

    /* compiled from: Ranges.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        @NotNull
        public final c a() {
            return c.e;
        }

        public /* synthetic */ a(kotlin.jvm.internal.d dVar) {
            this();
        }
    }

    public c(int i, int i2) {
        super(i, i2, 1);
    }

    @NotNull
    public Integer d() {
        return Integer.valueOf(b());
    }

    @NotNull
    public Integer e() {
        return Integer.valueOf(a());
    }

    @Override // kotlin.n.a
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (a() != cVar.a() || b() != cVar.b()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.n.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // kotlin.n.a
    public boolean isEmpty() {
        return a() > b();
    }

    @Override // kotlin.n.a
    @NotNull
    public String toString() {
        return a() + ".." + b();
    }
}
