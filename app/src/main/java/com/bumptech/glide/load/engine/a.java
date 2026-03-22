package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.m.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DecodeJob.java */
/* loaded from: classes.dex */
public class a<A, T, Z> {
    private static final b m = new b();

    /* renamed from: a, reason: collision with root package name */
    private final e f1964a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1965b;

    /* renamed from: c, reason: collision with root package name */
    private final int f1966c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.g.c<A> f1967d;
    private final com.bumptech.glide.p.b<A, T> e;
    private final com.bumptech.glide.load.f<T> f;
    private final com.bumptech.glide.load.i.i.c<T, Z> g;
    private final InterfaceC0061a h;
    private final DiskCacheStrategy i;
    private final Priority j;
    private final b k;
    private volatile boolean l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.engine.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0061a {
        com.bumptech.glide.load.engine.m.a a();
    }

    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    static class b {
        b() {
        }

        public OutputStream a(File file) throws FileNotFoundException {
            return new BufferedOutputStream(new FileOutputStream(file));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public class c<DataType> implements a.b {

        /* renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.a<DataType> f1968a;

        /* renamed from: b, reason: collision with root package name */
        private final DataType f1969b;

        public c(com.bumptech.glide.load.a<DataType> aVar, DataType datatype) {
            this.f1968a = aVar;
            this.f1969b = datatype;
        }

        @Override // com.bumptech.glide.load.engine.m.a.b
        public boolean a(File file) {
            OutputStream outputStream = null;
            try {
                try {
                    outputStream = a.this.k.a(file);
                    boolean a2 = this.f1968a.a(this.f1969b, outputStream);
                    if (outputStream == null) {
                        return a2;
                    }
                    try {
                        outputStream.close();
                        return a2;
                    } catch (IOException unused) {
                        return a2;
                    }
                } catch (FileNotFoundException e) {
                    if (Log.isLoggable("DecodeJob", 3)) {
                        Log.d("DecodeJob", "Failed to find file to write to disk cache", e);
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return false;
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        }
    }

    public a(e eVar, int i, int i2, com.bumptech.glide.load.g.c<A> cVar, com.bumptech.glide.p.b<A, T> bVar, com.bumptech.glide.load.f<T> fVar, com.bumptech.glide.load.i.i.c<T, Z> cVar2, InterfaceC0061a interfaceC0061a, DiskCacheStrategy diskCacheStrategy, Priority priority) {
        this(eVar, i, i2, cVar, bVar, fVar, cVar2, interfaceC0061a, diskCacheStrategy, priority, m);
    }

    private j<T> e() throws Exception {
        try {
            long a2 = com.bumptech.glide.s.d.a();
            A a3 = this.f1967d.a(this.j);
            if (Log.isLoggable("DecodeJob", 2)) {
                a("Fetched data", a2);
            }
            if (this.l) {
                return null;
            }
            return b((a<A, T, Z>) a3);
        } finally {
            this.f1967d.b();
        }
    }

    public j<Z> b() throws Exception {
        return c(e());
    }

    public j<Z> c() throws Exception {
        if (!this.i.cacheResult()) {
            return null;
        }
        long a2 = com.bumptech.glide.s.d.a();
        j<T> a3 = a((com.bumptech.glide.load.b) this.f1964a);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Decoded transformed from cache", a2);
        }
        long a4 = com.bumptech.glide.s.d.a();
        j<Z> a5 = a((j) a3);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Transcoded transformed from cache", a4);
        }
        return a5;
    }

    public j<Z> d() throws Exception {
        if (!this.i.cacheSource()) {
            return null;
        }
        long a2 = com.bumptech.glide.s.d.a();
        j<T> a3 = a(this.f1964a.a());
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Decoded source from cache", a2);
        }
        return c(a3);
    }

    a(e eVar, int i, int i2, com.bumptech.glide.load.g.c<A> cVar, com.bumptech.glide.p.b<A, T> bVar, com.bumptech.glide.load.f<T> fVar, com.bumptech.glide.load.i.i.c<T, Z> cVar2, InterfaceC0061a interfaceC0061a, DiskCacheStrategy diskCacheStrategy, Priority priority, b bVar2) {
        this.f1964a = eVar;
        this.f1965b = i;
        this.f1966c = i2;
        this.f1967d = cVar;
        this.e = bVar;
        this.f = fVar;
        this.g = cVar2;
        this.h = interfaceC0061a;
        this.i = diskCacheStrategy;
        this.j = priority;
        this.k = bVar2;
    }

    public void a() {
        this.l = true;
        this.f1967d.cancel();
    }

    private j<T> b(A a2) throws IOException {
        if (this.i.cacheSource()) {
            return a((a<A, T, Z>) a2);
        }
        long a3 = com.bumptech.glide.s.d.a();
        j<T> a4 = this.e.d().a(a2, this.f1965b, this.f1966c);
        if (!Log.isLoggable("DecodeJob", 2)) {
            return a4;
        }
        a("Decoded from source", a3);
        return a4;
    }

    private j<T> a(A a2) throws IOException {
        long a3 = com.bumptech.glide.s.d.a();
        this.h.a().a(this.f1964a.a(), new c(this.e.a(), a2));
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Wrote source to cache", a3);
        }
        long a4 = com.bumptech.glide.s.d.a();
        j<T> a5 = a(this.f1964a.a());
        if (Log.isLoggable("DecodeJob", 2) && a5 != null) {
            a("Decoded source from cache", a4);
        }
        return a5;
    }

    private void d(j<T> jVar) {
        if (jVar == null || !this.i.cacheResult()) {
            return;
        }
        long a2 = com.bumptech.glide.s.d.a();
        this.h.a().a(this.f1964a, new c(this.e.c(), jVar));
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Wrote transformed from source to cache", a2);
        }
    }

    private j<T> b(j<T> jVar) {
        if (jVar == null) {
            return null;
        }
        j<T> a2 = this.f.a(jVar, this.f1965b, this.f1966c);
        if (!jVar.equals(a2)) {
            jVar.a();
        }
        return a2;
    }

    private j<Z> c(j<T> jVar) {
        long a2 = com.bumptech.glide.s.d.a();
        j<T> b2 = b((j) jVar);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Transformed resource from source", a2);
        }
        d(b2);
        long a3 = com.bumptech.glide.s.d.a();
        j<Z> a4 = a((j) b2);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Transcoded transformed from source", a3);
        }
        return a4;
    }

    private j<T> a(com.bumptech.glide.load.b bVar) throws IOException {
        File a2 = this.h.a().a(bVar);
        if (a2 == null) {
            return null;
        }
        try {
            j<T> a3 = this.e.e().a(a2, this.f1965b, this.f1966c);
            if (a3 == null) {
            }
            return a3;
        } finally {
            this.h.a().b(bVar);
        }
    }

    private j<Z> a(j<T> jVar) {
        if (jVar == null) {
            return null;
        }
        return this.g.a(jVar);
    }

    private void a(String str, long j) {
        Log.v("DecodeJob", str + " in " + com.bumptech.glide.s.d.a(j) + ", key: " + this.f1964a);
    }
}
