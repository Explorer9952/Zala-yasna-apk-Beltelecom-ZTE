package com.bumptech.glide.load.engine.m;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DiskCacheWriteLocker.java */
/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Map<com.bumptech.glide.load.b, b> f2038a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final C0066c f2039b = new C0066c();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskCacheWriteLocker.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final Lock f2040a;

        /* renamed from: b, reason: collision with root package name */
        int f2041b;

        private b() {
            this.f2040a = new ReentrantLock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bumptech.glide.load.b bVar) {
        b bVar2;
        synchronized (this) {
            bVar2 = this.f2038a.get(bVar);
            if (bVar2 == null) {
                bVar2 = this.f2039b.a();
                this.f2038a.put(bVar, bVar2);
            }
            bVar2.f2041b++;
        }
        bVar2.f2040a.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(com.bumptech.glide.load.b bVar) {
        b bVar2;
        synchronized (this) {
            bVar2 = this.f2038a.get(bVar);
            if (bVar2 != null && bVar2.f2041b > 0) {
                int i = bVar2.f2041b - 1;
                bVar2.f2041b = i;
                if (i == 0) {
                    b remove = this.f2038a.remove(bVar);
                    if (remove.equals(bVar2)) {
                        this.f2039b.a(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + bVar2 + ", but actually removed: " + remove + ", key: " + bVar);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot release a lock that is not held, key: ");
            sb.append(bVar);
            sb.append(", interestedThreads: ");
            sb.append(bVar2 == null ? 0 : bVar2.f2041b);
            throw new IllegalArgumentException(sb.toString());
        }
        bVar2.f2040a.unlock();
    }

    /* compiled from: DiskCacheWriteLocker.java */
    /* renamed from: com.bumptech.glide.load.engine.m.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0066c {

        /* renamed from: a, reason: collision with root package name */
        private final Queue<b> f2042a;

        private C0066c() {
            this.f2042a = new ArrayDeque();
        }

        b a() {
            b poll;
            synchronized (this.f2042a) {
                poll = this.f2042a.poll();
            }
            return poll == null ? new b() : poll;
        }

        void a(b bVar) {
            synchronized (this.f2042a) {
                if (this.f2042a.size() < 10) {
                    this.f2042a.offer(bVar);
                }
            }
        }
    }
}
