package okhttp3.c0.f;

import javax.annotation.Nullable;
import okhttp3.a0;
import okhttp3.u;

/* compiled from: RealResponseBody.java */
/* loaded from: classes.dex */
public final class h extends a0 {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f8294a;

    /* renamed from: b, reason: collision with root package name */
    private final long f8295b;

    /* renamed from: c, reason: collision with root package name */
    private final okio.e f8296c;

    public h(@Nullable String str, long j, okio.e eVar) {
        this.f8294a = str;
        this.f8295b = j;
        this.f8296c = eVar;
    }

    @Override // okhttp3.a0
    public long k() {
        return this.f8295b;
    }

    @Override // okhttp3.a0
    public u l() {
        String str = this.f8294a;
        if (str != null) {
            return u.b(str);
        }
        return null;
    }

    @Override // okhttp3.a0
    public okio.e m() {
        return this.f8296c;
    }
}
