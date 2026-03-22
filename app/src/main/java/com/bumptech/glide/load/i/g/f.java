package com.bumptech.glide.load.i.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.k;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GifFrameLoader.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final c f2136a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.m.a f2137b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f2138c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2139d;
    private boolean e;
    private com.bumptech.glide.e<com.bumptech.glide.m.a, com.bumptech.glide.m.a, Bitmap, Bitmap> f;
    private b g;
    private boolean h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public static class b extends com.bumptech.glide.q.j.g<Bitmap> {

        /* renamed from: d, reason: collision with root package name */
        private final Handler f2140d;
        private final int e;
        private final long f;
        private Bitmap g;

        public b(Handler handler, int i, long j) {
            this.f2140d = handler;
            this.e = i;
            this.f = j;
        }

        public Bitmap e() {
            return this.g;
        }

        @Override // com.bumptech.glide.q.j.j
        public /* bridge */ /* synthetic */ void a(Object obj, com.bumptech.glide.q.i.c cVar) {
            a((Bitmap) obj, (com.bumptech.glide.q.i.c<? super Bitmap>) cVar);
        }

        public void a(Bitmap bitmap, com.bumptech.glide.q.i.c<? super Bitmap> cVar) {
            this.g = bitmap;
            this.f2140d.sendMessageAtTime(this.f2140d.obtainMessage(1, this), this.f);
        }
    }

    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public interface c {
        void a(int i);
    }

    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    private class d implements Handler.Callback {
        private d() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                f.this.a((b) message.obj);
                return true;
            }
            if (i != 2) {
                return false;
            }
            com.bumptech.glide.i.a((b) message.obj);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public static class e implements com.bumptech.glide.load.b {

        /* renamed from: a, reason: collision with root package name */
        private final UUID f2142a;

        public e() {
            this(UUID.randomUUID());
        }

        @Override // com.bumptech.glide.load.b
        public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
            throw new UnsupportedOperationException("Not implemented");
        }

        public boolean equals(Object obj) {
            if (obj instanceof e) {
                return ((e) obj).f2142a.equals(this.f2142a);
            }
            return false;
        }

        public int hashCode() {
            return this.f2142a.hashCode();
        }

        e(UUID uuid) {
            this.f2142a = uuid;
        }
    }

    public f(Context context, c cVar, com.bumptech.glide.m.a aVar, int i, int i2) {
        this(cVar, aVar, null, a(context, aVar, i, i2, com.bumptech.glide.i.a(context).d()));
    }

    private void e() {
        if (!this.f2139d || this.e) {
            return;
        }
        this.e = true;
        this.f2137b.a();
        this.f.a(new e()).a((com.bumptech.glide.e<com.bumptech.glide.m.a, com.bumptech.glide.m.a, Bitmap, Bitmap>) new b(this.f2138c, this.f2137b.c(), SystemClock.uptimeMillis() + this.f2137b.f()));
    }

    public void a(com.bumptech.glide.load.f<Bitmap> fVar) {
        if (fVar == null) {
            throw new NullPointerException("Transformation must not be null");
        }
        this.f = this.f.a(fVar);
    }

    public Bitmap b() {
        b bVar = this.g;
        if (bVar != null) {
            return bVar.e();
        }
        return null;
    }

    public void c() {
        if (this.f2139d) {
            return;
        }
        this.f2139d = true;
        this.h = false;
        e();
    }

    public void d() {
        this.f2139d = false;
    }

    f(c cVar, com.bumptech.glide.m.a aVar, Handler handler, com.bumptech.glide.e<com.bumptech.glide.m.a, com.bumptech.glide.m.a, Bitmap, Bitmap> eVar) {
        this.f2139d = false;
        this.e = false;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new d()) : handler;
        this.f2136a = cVar;
        this.f2137b = aVar;
        this.f2138c = handler;
        this.f = eVar;
    }

    public void a() {
        d();
        b bVar = this.g;
        if (bVar != null) {
            com.bumptech.glide.i.a(bVar);
            this.g = null;
        }
        this.h = true;
    }

    void a(b bVar) {
        if (this.h) {
            this.f2138c.obtainMessage(2, bVar).sendToTarget();
            return;
        }
        b bVar2 = this.g;
        this.g = bVar;
        this.f2136a.a(bVar.e);
        if (bVar2 != null) {
            this.f2138c.obtainMessage(2, bVar2).sendToTarget();
        }
        this.e = false;
        e();
    }

    private static com.bumptech.glide.e<com.bumptech.glide.m.a, com.bumptech.glide.m.a, Bitmap, Bitmap> a(Context context, com.bumptech.glide.m.a aVar, int i, int i2, com.bumptech.glide.load.engine.l.c cVar) {
        h hVar = new h(cVar);
        g gVar = new g();
        com.bumptech.glide.load.a b2 = com.bumptech.glide.load.i.a.b();
        com.bumptech.glide.f a2 = com.bumptech.glide.i.b(context).a(gVar, com.bumptech.glide.m.a.class).a((k.c) aVar).a(Bitmap.class);
        a2.a(b2);
        a2.a((com.bumptech.glide.load.d) hVar);
        a2.a(true);
        a2.a(DiskCacheStrategy.NONE);
        a2.b(i, i2);
        return a2;
    }
}
