package com.vk.api.sdk.r;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.l;

/* compiled from: VKValidationLocker.kt */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private static final ReentrantLock f3996a;

    /* renamed from: b, reason: collision with root package name */
    private static final Condition f3997b;

    /* renamed from: c, reason: collision with root package name */
    public static final h f3998c = new h();

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f3996a = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        kotlin.jvm.internal.f.a((Object) newCondition, "locker.newCondition()");
        f3997b = newCondition;
    }

    private h() {
    }

    public final void a() {
        try {
            ReentrantLock reentrantLock = f3996a;
            reentrantLock.lock();
            try {
                f3997b.await();
                l lVar = l.f8186a;
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        } catch (InterruptedException unused) {
        }
    }

    public final void b() {
        ReentrantLock reentrantLock = f3996a;
        reentrantLock.lock();
        try {
            f3997b.signalAll();
            l lVar = l.f8186a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
