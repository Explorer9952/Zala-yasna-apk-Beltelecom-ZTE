package com.zte.iptvclient.android.common.k;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ConcurrentThreadUtil.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    ThreadPoolExecutor f4810a = new ThreadPoolExecutor(3, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(10));

    /* compiled from: ConcurrentThreadUtil.java */
    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static h f4811a = new h();
    }

    public static h a() {
        return a.f4811a;
    }

    public Future<?> a(Runnable runnable) {
        return this.f4810a.submit(runnable);
    }
}
