package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;

/* compiled from: EngineRunnable.java */
/* loaded from: classes.dex */
class h implements Runnable, com.bumptech.glide.load.engine.executor.a {

    /* renamed from: a, reason: collision with root package name */
    private final Priority f2002a;

    /* renamed from: b, reason: collision with root package name */
    private final a f2003b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a<?, ?, ?> f2004c;

    /* renamed from: d, reason: collision with root package name */
    private b f2005d = b.CACHE;
    private volatile boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineRunnable.java */
    /* loaded from: classes.dex */
    public interface a extends com.bumptech.glide.q.g {
        void a(h hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EngineRunnable.java */
    /* loaded from: classes.dex */
    public enum b {
        CACHE,
        SOURCE
    }

    public h(a aVar, com.bumptech.glide.load.engine.a<?, ?, ?> aVar2, Priority priority) {
        this.f2003b = aVar;
        this.f2004c = aVar2;
        this.f2002a = priority;
    }

    private void a(j jVar) {
        this.f2003b.a((j<?>) jVar);
    }

    private j<?> c() throws Exception {
        if (f()) {
            return d();
        }
        return e();
    }

    private j<?> d() throws Exception {
        j<?> jVar;
        try {
            jVar = this.f2004c.c();
        } catch (Exception e) {
            if (Log.isLoggable("EngineRunnable", 3)) {
                Log.d("EngineRunnable", "Exception decoding result from cache: " + e);
            }
            jVar = null;
        }
        return jVar == null ? this.f2004c.d() : jVar;
    }

    private j<?> e() throws Exception {
        return this.f2004c.b();
    }

    private boolean f() {
        return this.f2005d == b.CACHE;
    }

    public void b() {
        this.e = true;
        this.f2004c.a();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.e) {
            return;
        }
        j<?> jVar = null;
        try {
            e = null;
            jVar = c();
        } catch (Exception e) {
            e = e;
            if (Log.isLoggable("EngineRunnable", 2)) {
                Log.v("EngineRunnable", "Exception decoding", e);
            }
        }
        if (this.e) {
            if (jVar != null) {
                jVar.a();
            }
        } else if (jVar == null) {
            a(e);
        } else {
            a(jVar);
        }
    }

    private void a(Exception exc) {
        if (f()) {
            this.f2005d = b.SOURCE;
            this.f2003b.a(this);
        } else {
            this.f2003b.onException(exc);
        }
    }

    @Override // com.bumptech.glide.load.engine.executor.a
    public int a() {
        return this.f2002a.ordinal();
    }
}
