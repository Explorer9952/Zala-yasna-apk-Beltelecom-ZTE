package com.bumptech.glide.load.engine.m;

import android.util.Log;
import com.bumptech.glide.l.a;
import com.bumptech.glide.load.engine.m.a;
import java.io.File;
import java.io.IOException;

/* compiled from: DiskLruCacheWrapper.java */
/* loaded from: classes.dex */
public class e implements a {
    private static e f;

    /* renamed from: a, reason: collision with root package name */
    private final c f2045a = new c();

    /* renamed from: b, reason: collision with root package name */
    private final j f2046b = new j();

    /* renamed from: c, reason: collision with root package name */
    private final File f2047c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2048d;
    private com.bumptech.glide.l.a e;

    protected e(File file, int i) {
        this.f2047c = file;
        this.f2048d = i;
    }

    public static synchronized a a(File file, int i) {
        e eVar;
        synchronized (e.class) {
            if (f == null) {
                f = new e(file, i);
            }
            eVar = f;
        }
        return eVar;
    }

    @Override // com.bumptech.glide.load.engine.m.a
    public void b(com.bumptech.glide.load.b bVar) {
        try {
            a().d(this.f2046b.a(bVar));
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", e);
            }
        }
    }

    private synchronized com.bumptech.glide.l.a a() throws IOException {
        if (this.e == null) {
            this.e = com.bumptech.glide.l.a.a(this.f2047c, 1, 1, this.f2048d);
        }
        return this.e;
    }

    @Override // com.bumptech.glide.load.engine.m.a
    public File a(com.bumptech.glide.load.b bVar) {
        try {
            a.d c2 = a().c(this.f2046b.a(bVar));
            if (c2 != null) {
                return c2.a(0);
            }
            return null;
        } catch (IOException e) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.engine.m.a
    public void a(com.bumptech.glide.load.b bVar, a.b bVar2) {
        String a2 = this.f2046b.a(bVar);
        this.f2045a.a(bVar);
        try {
            try {
                a.b b2 = a().b(a2);
                if (b2 != null) {
                    try {
                        if (bVar2.a(b2.a(0))) {
                            b2.c();
                        }
                        b2.b();
                    } catch (Throwable th) {
                        b2.b();
                        throw th;
                    }
                }
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            }
        } finally {
            this.f2045a.b(bVar);
        }
    }
}
