package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.b0;

/* compiled from: RouteDatabase.java */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final Set<b0> f8371a = new LinkedHashSet();

    public synchronized void a(b0 b0Var) {
        this.f8371a.remove(b0Var);
    }

    public synchronized void b(b0 b0Var) {
        this.f8371a.add(b0Var);
    }

    public synchronized boolean c(b0 b0Var) {
        return this.f8371a.contains(b0Var);
    }
}
