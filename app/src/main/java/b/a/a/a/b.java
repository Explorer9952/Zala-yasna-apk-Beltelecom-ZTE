package b.a.a.a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DefaultTaskExecutor.java */
/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: a, reason: collision with root package name */
    private final Object f1781a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final ExecutorService f1782b = Executors.newFixedThreadPool(4, new a(this));

    /* renamed from: c, reason: collision with root package name */
    private volatile Handler f1783c;

    /* compiled from: DefaultTaskExecutor.java */
    /* loaded from: classes.dex */
    class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f1784a = new AtomicInteger(0);

        a(b bVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f1784a.getAndIncrement())));
            return thread;
        }
    }

    @Override // b.a.a.a.c
    public void a(Runnable runnable) {
        this.f1782b.execute(runnable);
    }

    @Override // b.a.a.a.c
    public void b(Runnable runnable) {
        if (this.f1783c == null) {
            synchronized (this.f1781a) {
                if (this.f1783c == null) {
                    this.f1783c = a(Looper.getMainLooper());
                }
            }
        }
        this.f1783c.post(runnable);
    }

    @Override // b.a.a.a.c
    public boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    private static Handler a(Looper looper) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return Handler.createAsync(looper);
        }
        if (i >= 16) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, true);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            } catch (InvocationTargetException unused2) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }
}
