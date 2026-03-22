package kotlin.text;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Regex.kt */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f8222a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.n.c f8223b;

    public f(@NotNull String str, @NotNull kotlin.n.c cVar) {
        kotlin.jvm.internal.f.b(str, "value");
        kotlin.jvm.internal.f.b(cVar, "range");
        this.f8222a = str;
        this.f8223b = cVar;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return kotlin.jvm.internal.f.a((Object) this.f8222a, (Object) fVar.f8222a) && kotlin.jvm.internal.f.a(this.f8223b, fVar.f8223b);
    }

    public int hashCode() {
        String str = this.f8222a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        kotlin.n.c cVar = this.f8223b;
        return hashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MatchGroup(value=" + this.f8222a + ", range=" + this.f8223b + ")";
    }
}
