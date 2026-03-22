package com.unity3d.player;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f3010a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f3011b = !e.f3000b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3012c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3013d = false;
    private boolean e = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        f3010a = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        f3010a = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        return f3010a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(boolean z) {
        this.f3012c = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(boolean z) {
        this.e = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(boolean z) {
        this.f3013d = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        this.f3011b = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean e() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean f() {
        return f3010a && this.f3012c && this.f3011b && !this.e && !this.f3013d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean g() {
        return this.f3013d;
    }

    public final String toString() {
        return super.toString();
    }
}
