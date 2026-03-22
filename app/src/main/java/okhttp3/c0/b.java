package okhttp3.c0;

/* compiled from: NamedRunnable.java */
/* loaded from: classes2.dex */
public abstract class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    protected final String f8266a;

    public b(String str, Object... objArr) {
        this.f8266a = c.a(str, objArr);
    }

    protected abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f8266a);
        try {
            b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
