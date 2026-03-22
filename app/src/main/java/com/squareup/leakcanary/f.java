package com.squareup.leakcanary;

import com.squareup.leakcanary.HeapDump;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/* compiled from: RefWatcher.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f2816a = new f(new a(), new b(), com.squareup.leakcanary.b.f2815a, new c(), new d());

    /* compiled from: RefWatcher.java */
    /* loaded from: classes.dex */
    static class a implements Executor {
        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
        }
    }

    /* compiled from: RefWatcher.java */
    /* loaded from: classes.dex */
    static class b implements com.squareup.leakcanary.a {
        b() {
        }
    }

    /* compiled from: RefWatcher.java */
    /* loaded from: classes.dex */
    static class c implements com.squareup.leakcanary.c {
        c() {
        }
    }

    /* compiled from: RefWatcher.java */
    /* loaded from: classes.dex */
    static class d implements HeapDump.a {
        d() {
        }
    }

    public f(Executor executor, com.squareup.leakcanary.a aVar, com.squareup.leakcanary.b bVar, com.squareup.leakcanary.c cVar, HeapDump.a aVar2) {
        e.a(executor, "watchExecutor");
        e.a(aVar, "debuggerControl");
        e.a(bVar, "gcTrigger");
        e.a(cVar, "heapDumper");
        e.a(aVar2, "heapdumpListener");
        new CopyOnWriteArraySet();
        new ReferenceQueue();
    }
}
