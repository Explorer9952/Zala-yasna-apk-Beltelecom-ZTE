package com.bumptech.glide.load.engine.l;

import com.bumptech.glide.load.engine.l.h;
import java.util.Queue;

/* compiled from: BaseKeyPool.java */
/* loaded from: classes.dex */
abstract class b<T extends h> {

    /* renamed from: a, reason: collision with root package name */
    private final Queue<T> f2019a = com.bumptech.glide.s.h.a(20);

    protected abstract T a();

    public void a(T t) {
        if (this.f2019a.size() < 20) {
            this.f2019a.offer(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T b() {
        T poll = this.f2019a.poll();
        return poll == null ? a() : poll;
    }
}
