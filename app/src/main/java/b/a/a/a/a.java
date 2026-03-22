package b.a.a.a;

import java.util.concurrent.Executor;

/* compiled from: ArchTaskExecutor.java */
/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f1778c;

    /* renamed from: a, reason: collision with root package name */
    private c f1779a;

    /* renamed from: b, reason: collision with root package name */
    private c f1780b;

    /* compiled from: ArchTaskExecutor.java */
    /* renamed from: b.a.a.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class ExecutorC0054a implements Executor {
        ExecutorC0054a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.b().b(runnable);
        }
    }

    /* compiled from: ArchTaskExecutor.java */
    /* loaded from: classes.dex */
    static class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.b().a(runnable);
        }
    }

    static {
        new ExecutorC0054a();
        new b();
    }

    private a() {
        b.a.a.a.b bVar = new b.a.a.a.b();
        this.f1780b = bVar;
        this.f1779a = bVar;
    }

    public static a b() {
        if (f1778c != null) {
            return f1778c;
        }
        synchronized (a.class) {
            if (f1778c == null) {
                f1778c = new a();
            }
        }
        return f1778c;
    }

    @Override // b.a.a.a.c
    public void a(Runnable runnable) {
        this.f1779a.a(runnable);
    }

    @Override // b.a.a.a.c
    public boolean a() {
        return this.f1779a.a();
    }

    @Override // b.a.a.a.c
    public void b(Runnable runnable) {
        this.f1779a.b(runnable);
    }
}
