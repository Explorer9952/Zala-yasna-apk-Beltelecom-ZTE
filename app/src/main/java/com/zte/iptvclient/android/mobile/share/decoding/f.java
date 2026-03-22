package com.zte.iptvclient.android.mobile.share.decoding;

import android.app.Activity;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: InactivityTimer.java */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    private final Activity f7220b;

    /* renamed from: a, reason: collision with root package name */
    private final ScheduledExecutorService f7219a = Executors.newSingleThreadScheduledExecutor(new b());

    /* renamed from: c, reason: collision with root package name */
    private ScheduledFuture<?> f7221c = null;

    /* compiled from: InactivityTimer.java */
    /* loaded from: classes2.dex */
    private static final class b implements ThreadFactory {
        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        }
    }

    public f(Activity activity) {
        this.f7220b = activity;
        a();
    }

    private void c() {
        ScheduledFuture<?> scheduledFuture = this.f7221c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f7221c = null;
        }
    }

    public void a() {
        c();
        this.f7221c = this.f7219a.schedule(new e(this.f7220b), 300L, TimeUnit.SECONDS);
    }

    public void b() {
        c();
        this.f7219a.shutdown();
    }
}
