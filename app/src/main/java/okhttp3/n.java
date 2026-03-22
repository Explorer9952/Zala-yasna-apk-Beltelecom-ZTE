package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.w;

/* compiled from: Dispatcher.java */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private Runnable f8508c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private ExecutorService f8509d;

    /* renamed from: a, reason: collision with root package name */
    private int f8506a = 64;

    /* renamed from: b, reason: collision with root package name */
    private int f8507b = 5;
    private final Deque<w.b> e = new ArrayDeque();
    private final Deque<w.b> f = new ArrayDeque();
    private final Deque<w> g = new ArrayDeque();

    private int b(w.b bVar) {
        int i = 0;
        for (w.b bVar2 : this.f) {
            if (!bVar2.c().f && bVar2.d().equals(bVar.d())) {
                i++;
            }
        }
        return i;
    }

    private boolean c() {
        int i;
        boolean z;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<w.b> it2 = this.e.iterator();
            while (it2.hasNext()) {
                w.b next = it2.next();
                if (this.f.size() >= this.f8506a) {
                    break;
                }
                if (b(next) < this.f8507b) {
                    it2.remove();
                    arrayList.add(next);
                    this.f.add(next);
                }
            }
            z = b() > 0;
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((w.b) arrayList.get(i)).a(a());
        }
        return z;
    }

    public synchronized ExecutorService a() {
        if (this.f8509d == null) {
            this.f8509d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.c0.c.a("OkHttp Dispatcher", false));
        }
        return this.f8509d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(w wVar) {
        a(this.g, wVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(w wVar) {
        this.g.add(wVar);
    }

    public synchronized int b() {
        return this.f.size() + this.g.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(w.b bVar) {
        a(this.f, bVar);
    }

    private <T> void a(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                runnable = this.f8508c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (c() || runnable == null) {
            return;
        }
        runnable.run();
    }
}
