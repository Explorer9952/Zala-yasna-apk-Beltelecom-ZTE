package kotlin.n;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Progressions.kt */
/* loaded from: classes2.dex */
public class a implements Iterable<Integer> {

    /* renamed from: d, reason: collision with root package name */
    public static final C0421a f8187d = new C0421a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f8188a;

    /* renamed from: b, reason: collision with root package name */
    private final int f8189b;

    /* renamed from: c, reason: collision with root package name */
    private final int f8190c;

    /* compiled from: Progressions.kt */
    /* renamed from: kotlin.n.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0421a {
        private C0421a() {
        }

        @NotNull
        public final a a(int i, int i2, int i3) {
            return new a(i, i2, i3);
        }

        public /* synthetic */ C0421a(kotlin.jvm.internal.d dVar) {
            this();
        }
    }

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f8188a = i;
            this.f8189b = kotlin.internal.c.b(i, i2, i3);
            this.f8190c = i3;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }

    public final int a() {
        return this.f8188a;
    }

    public final int b() {
        return this.f8189b;
    }

    public final int c() {
        return this.f8190c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f8188a != aVar.f8188a || this.f8189b != aVar.f8189b || this.f8190c != aVar.f8190c) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f8188a * 31) + this.f8189b) * 31) + this.f8190c;
    }

    public boolean isEmpty() {
        if (this.f8190c > 0) {
            if (this.f8188a > this.f8189b) {
                return true;
            }
        } else if (this.f8188a < this.f8189b) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        int i;
        if (this.f8190c > 0) {
            sb = new StringBuilder();
            sb.append(this.f8188a);
            sb.append("..");
            sb.append(this.f8189b);
            sb.append(" step ");
            i = this.f8190c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f8188a);
            sb.append(" downTo ");
            sb.append(this.f8189b);
            sb.append(" step ");
            i = -this.f8190c;
        }
        sb.append(i);
        return sb.toString();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<Integer> iterator() {
        return new b(this.f8188a, this.f8189b, this.f8190c);
    }
}
