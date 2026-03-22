package com.bumptech.glide.q;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.b;
import com.bumptech.glide.q.j.j;
import java.util.Queue;

/* compiled from: GenericRequest.java */
/* loaded from: classes.dex */
public final class b<A, T, Z, R> implements c, com.bumptech.glide.q.j.h, g {
    private static final Queue<b<?, ?, ?, ?>> D = com.bumptech.glide.s.h.a(0);
    private b.c A;
    private long B;
    private a C;

    /* renamed from: a, reason: collision with root package name */
    private final String f2290a = String.valueOf(hashCode());

    /* renamed from: b, reason: collision with root package name */
    private com.bumptech.glide.load.b f2291b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f2292c;

    /* renamed from: d, reason: collision with root package name */
    private int f2293d;
    private int e;
    private int f;
    private Context g;
    private com.bumptech.glide.load.f<Z> h;
    private com.bumptech.glide.p.f<A, T, Z, R> i;
    private d j;
    private A k;
    private Class<R> l;
    private boolean m;
    private Priority n;
    private j<R> o;
    private f<? super A, R> p;
    private float q;
    private com.bumptech.glide.load.engine.b r;
    private com.bumptech.glide.q.i.d<R> s;
    private int t;
    private int u;
    private DiskCacheStrategy v;
    private Drawable w;
    private Drawable x;
    private boolean y;
    private com.bumptech.glide.load.engine.j<?> z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GenericRequest.java */
    /* loaded from: classes.dex */
    public enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    private b() {
    }

    public static <A, T, Z, R> b<A, T, Z, R> b(com.bumptech.glide.p.f<A, T, Z, R> fVar, A a2, com.bumptech.glide.load.b bVar, Context context, Priority priority, j<R> jVar, float f, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, f<? super A, R> fVar2, d dVar, com.bumptech.glide.load.engine.b bVar2, com.bumptech.glide.load.f<Z> fVar3, Class<R> cls, boolean z, com.bumptech.glide.q.i.d<R> dVar2, int i4, int i5, DiskCacheStrategy diskCacheStrategy) {
        b<A, T, Z, R> bVar3 = (b) D.poll();
        if (bVar3 == null) {
            bVar3 = new b<>();
        }
        bVar3.a(fVar, a2, bVar, context, priority, jVar, f, drawable, i, drawable2, i2, drawable3, i3, fVar2, dVar, bVar2, fVar3, cls, z, dVar2, i4, i5, diskCacheStrategy);
        return bVar3;
    }

    private boolean g() {
        d dVar = this.j;
        return dVar == null || dVar.a(this);
    }

    private boolean h() {
        d dVar = this.j;
        return dVar == null || dVar.b(this);
    }

    private Drawable i() {
        if (this.x == null && this.f > 0) {
            this.x = this.g.getResources().getDrawable(this.f);
        }
        return this.x;
    }

    private Drawable j() {
        if (this.f2292c == null && this.f2293d > 0) {
            this.f2292c = this.g.getResources().getDrawable(this.f2293d);
        }
        return this.f2292c;
    }

    private Drawable k() {
        if (this.w == null && this.e > 0) {
            this.w = this.g.getResources().getDrawable(this.e);
        }
        return this.w;
    }

    private boolean l() {
        d dVar = this.j;
        return dVar == null || !dVar.b();
    }

    private void m() {
        d dVar = this.j;
        if (dVar != null) {
            dVar.c(this);
        }
    }

    @Override // com.bumptech.glide.q.c
    public void a() {
        this.i = null;
        this.k = null;
        this.g = null;
        this.o = null;
        this.w = null;
        this.x = null;
        this.f2292c = null;
        this.p = null;
        this.j = null;
        this.h = null;
        this.s = null;
        this.y = false;
        this.A = null;
        D.offer(this);
    }

    @Override // com.bumptech.glide.q.c
    public boolean c() {
        return e();
    }

    @Override // com.bumptech.glide.q.c
    public void clear() {
        com.bumptech.glide.s.h.b();
        if (this.C == a.CLEARED) {
            return;
        }
        b();
        com.bumptech.glide.load.engine.j<?> jVar = this.z;
        if (jVar != null) {
            b(jVar);
        }
        if (g()) {
            this.o.c(k());
        }
        this.C = a.CLEARED;
    }

    @Override // com.bumptech.glide.q.c
    public void d() {
        this.B = com.bumptech.glide.s.d.a();
        if (this.k == null) {
            onException(null);
            return;
        }
        this.C = a.WAITING_FOR_SIZE;
        if (com.bumptech.glide.s.h.a(this.t, this.u)) {
            a(this.t, this.u);
        } else {
            this.o.a((com.bumptech.glide.q.j.h) this);
        }
        if (!e() && !f() && g()) {
            this.o.b(k());
        }
        if (Log.isLoggable("GenericRequest", 2)) {
            a("finished run method in " + com.bumptech.glide.s.d.a(this.B));
        }
    }

    @Override // com.bumptech.glide.q.c
    public boolean e() {
        return this.C == a.COMPLETE;
    }

    public boolean f() {
        return this.C == a.FAILED;
    }

    @Override // com.bumptech.glide.q.c
    public boolean isCancelled() {
        a aVar = this.C;
        return aVar == a.CANCELLED || aVar == a.CLEARED;
    }

    @Override // com.bumptech.glide.q.c
    public boolean isRunning() {
        a aVar = this.C;
        return aVar == a.RUNNING || aVar == a.WAITING_FOR_SIZE;
    }

    @Override // com.bumptech.glide.q.g
    public void onException(Exception exc) {
        if (Log.isLoggable("GenericRequest", 3)) {
            Log.d("GenericRequest", "load failed", exc);
        }
        this.C = a.FAILED;
        f<? super A, R> fVar = this.p;
        if (fVar == null || !fVar.a(exc, this.k, this.o, l())) {
            a(exc);
        }
    }

    @Override // com.bumptech.glide.q.c
    public void pause() {
        clear();
        this.C = a.PAUSED;
    }

    void b() {
        this.C = a.CANCELLED;
        b.c cVar = this.A;
        if (cVar != null) {
            cVar.a();
            this.A = null;
        }
    }

    private void b(com.bumptech.glide.load.engine.j jVar) {
        this.r.b(jVar);
        this.z = null;
    }

    private void a(com.bumptech.glide.p.f<A, T, Z, R> fVar, A a2, com.bumptech.glide.load.b bVar, Context context, Priority priority, j<R> jVar, float f, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, f<? super A, R> fVar2, d dVar, com.bumptech.glide.load.engine.b bVar2, com.bumptech.glide.load.f<Z> fVar3, Class<R> cls, boolean z, com.bumptech.glide.q.i.d<R> dVar2, int i4, int i5, DiskCacheStrategy diskCacheStrategy) {
        this.i = fVar;
        this.k = a2;
        this.f2291b = bVar;
        this.f2292c = drawable3;
        this.f2293d = i3;
        this.g = context.getApplicationContext();
        this.n = priority;
        this.o = jVar;
        this.q = f;
        this.w = drawable;
        this.e = i;
        this.x = drawable2;
        this.f = i2;
        this.p = fVar2;
        this.j = dVar;
        this.r = bVar2;
        this.h = fVar3;
        this.l = cls;
        this.m = z;
        this.s = dVar2;
        this.t = i4;
        this.u = i5;
        this.v = diskCacheStrategy;
        this.C = a.PENDING;
        if (a2 != null) {
            a("ModelLoader", fVar.f(), "try .using(ModelLoader)");
            a("Transcoder", fVar.b(), "try .as*(Class).transcode(ResourceTranscoder)");
            a("Transformation", fVar3, "try .transform(UnitTransformation.get())");
            if (diskCacheStrategy.cacheSource()) {
                a("SourceEncoder", fVar.a(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
            } else {
                a("SourceDecoder", fVar.d(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
            }
            if (diskCacheStrategy.cacheSource() || diskCacheStrategy.cacheResult()) {
                a("CacheDecoder", fVar.e(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
            }
            if (diskCacheStrategy.cacheResult()) {
                a("Encoder", fVar.c(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
            }
        }
    }

    private static void a(String str, Object obj, String str2) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder(str);
            sb.append(" must not be null");
            if (str2 != null) {
                sb.append(", ");
                sb.append(str2);
            }
            throw new NullPointerException(sb.toString());
        }
    }

    private void a(Exception exc) {
        if (g()) {
            Drawable j = this.k == null ? j() : null;
            if (j == null) {
                j = i();
            }
            if (j == null) {
                j = k();
            }
            this.o.a(exc, j);
        }
    }

    @Override // com.bumptech.glide.q.j.h
    public void a(int i, int i2) {
        if (Log.isLoggable("GenericRequest", 2)) {
            a("Got onSizeReady in " + com.bumptech.glide.s.d.a(this.B));
        }
        if (this.C != a.WAITING_FOR_SIZE) {
            return;
        }
        this.C = a.RUNNING;
        int round = Math.round(this.q * i);
        int round2 = Math.round(this.q * i2);
        com.bumptech.glide.load.g.c<T> a2 = this.i.f().a(this.k, round, round2);
        if (a2 == null) {
            onException(new Exception("Failed to load model: '" + this.k + "'"));
            return;
        }
        com.bumptech.glide.load.i.i.c<Z, R> b2 = this.i.b();
        if (Log.isLoggable("GenericRequest", 2)) {
            a("finished setup for calling load in " + com.bumptech.glide.s.d.a(this.B));
        }
        this.y = true;
        this.A = this.r.a(this.f2291b, round, round2, a2, this.i, this.h, b2, this.n, this.m, this.v, this);
        this.y = this.z != null;
        if (Log.isLoggable("GenericRequest", 2)) {
            a("finished onSizeReady in " + com.bumptech.glide.s.d.a(this.B));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.q.g
    public void a(com.bumptech.glide.load.engine.j<?> jVar) {
        if (jVar == null) {
            onException(new Exception("Expected to receive a Resource<R> with an object of " + this.l + " inside, but instead got null."));
            return;
        }
        Object obj = jVar.get();
        if (obj != null && this.l.isAssignableFrom(obj.getClass())) {
            if (!h()) {
                b(jVar);
                this.C = a.COMPLETE;
                return;
            } else {
                a(jVar, (com.bumptech.glide.load.engine.j<?>) obj);
                return;
            }
        }
        b(jVar);
        StringBuilder sb = new StringBuilder();
        sb.append("Expected to receive an object of ");
        sb.append(this.l);
        sb.append(" but instead got ");
        sb.append(obj != null ? obj.getClass() : "");
        sb.append("{");
        sb.append(obj);
        sb.append("}");
        sb.append(" inside Resource{");
        sb.append(jVar);
        sb.append("}.");
        sb.append(obj == null ? " To indicate failure return a null Resource object, rather than a Resource object containing null data." : "");
        onException(new Exception(sb.toString()));
    }

    private void a(com.bumptech.glide.load.engine.j<?> jVar, R r) {
        boolean l = l();
        this.C = a.COMPLETE;
        this.z = jVar;
        f<? super A, R> fVar = this.p;
        if (fVar == null || !fVar.a(r, this.k, this.o, this.y, l)) {
            this.o.a((j<R>) r, (com.bumptech.glide.q.i.c<? super j<R>>) this.s.a(this.y, l));
        }
        m();
        if (Log.isLoggable("GenericRequest", 2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Resource ready in ");
            sb.append(com.bumptech.glide.s.d.a(this.B));
            sb.append(" size: ");
            double size = jVar.getSize();
            Double.isNaN(size);
            sb.append(size * 9.5367431640625E-7d);
            sb.append(" fromCache: ");
            sb.append(this.y);
            a(sb.toString());
        }
    }

    private void a(String str) {
        Log.v("GenericRequest", str + " this: " + this.f2290a);
    }
}
