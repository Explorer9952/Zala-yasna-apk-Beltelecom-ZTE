package com.bumptech.glide.load.engine.l;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LruBitmapPool.java */
/* loaded from: classes.dex */
public class f implements com.bumptech.glide.load.engine.l.c {
    private static final Bitmap.Config j = Bitmap.Config.ARGB_8888;

    /* renamed from: a, reason: collision with root package name */
    private final g f2026a;

    /* renamed from: b, reason: collision with root package name */
    private final Set<Bitmap.Config> f2027b;

    /* renamed from: c, reason: collision with root package name */
    private final b f2028c;

    /* renamed from: d, reason: collision with root package name */
    private int f2029d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LruBitmapPool.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* compiled from: LruBitmapPool.java */
    /* loaded from: classes.dex */
    private static class c implements b {
        private c() {
        }

        @Override // com.bumptech.glide.load.engine.l.f.b
        public void a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.l.f.b
        public void b(Bitmap bitmap) {
        }
    }

    f(int i, g gVar, Set<Bitmap.Config> set) {
        this.f2029d = i;
        this.f2026a = gVar;
        this.f2027b = set;
        this.f2028c = new c();
    }

    private void c() {
        Log.v("LruBitmapPool", "Hits=" + this.f + ", misses=" + this.g + ", puts=" + this.h + ", evictions=" + this.i + ", currentSize=" + this.e + ", maxSize=" + this.f2029d + "\nStrategy=" + this.f2026a);
    }

    private void d() {
        b(this.f2029d);
    }

    private static Set<Bitmap.Config> e() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static g f() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new i();
        }
        return new com.bumptech.glide.load.engine.l.a();
    }

    @Override // com.bumptech.glide.load.engine.l.c
    public synchronized boolean a(Bitmap bitmap) {
        if (bitmap != null) {
            if (bitmap.isMutable() && this.f2026a.b(bitmap) <= this.f2029d && this.f2027b.contains(bitmap.getConfig())) {
                int b2 = this.f2026a.b(bitmap);
                this.f2026a.a(bitmap);
                this.f2028c.b(bitmap);
                this.h++;
                this.e += b2;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f2026a.c(bitmap));
                }
                b();
                d();
                return true;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f2026a.c(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f2027b.contains(bitmap.getConfig()));
            }
            return false;
        }
        throw new NullPointerException("Bitmap must not be null");
    }

    @Override // com.bumptech.glide.load.engine.l.c
    @TargetApi(12)
    public synchronized Bitmap b(int i, int i2, Bitmap.Config config) {
        Bitmap a2;
        a2 = this.f2026a.a(i, i2, config != null ? config : j);
        if (a2 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f2026a.b(i, i2, config));
            }
            this.g++;
        } else {
            this.f++;
            this.e -= this.f2026a.b(a2);
            this.f2028c.a(a2);
            if (Build.VERSION.SDK_INT >= 12) {
                a2.setHasAlpha(true);
            }
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f2026a.b(i, i2, config));
        }
        b();
        return a2;
    }

    public f(int i) {
        this(i, f(), e());
    }

    private synchronized void b(int i) {
        while (this.e > i) {
            Bitmap a2 = this.f2026a.a();
            if (a2 == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    c();
                }
                this.e = 0;
                return;
            }
            this.f2028c.a(a2);
            this.e -= this.f2026a.b(a2);
            a2.recycle();
            this.i++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f2026a.c(a2));
            }
            b();
        }
    }

    @Override // com.bumptech.glide.load.engine.l.c
    public synchronized Bitmap a(int i, int i2, Bitmap.Config config) {
        Bitmap b2;
        b2 = b(i, i2, config);
        if (b2 != null) {
            b2.eraseColor(0);
        }
        return b2;
    }

    @Override // com.bumptech.glide.load.engine.l.c
    public void a() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        b(0);
    }

    @Override // com.bumptech.glide.load.engine.l.c
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 60) {
            a();
        } else if (i >= 40) {
            b(this.f2029d / 2);
        }
    }

    private void b() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            c();
        }
    }
}
