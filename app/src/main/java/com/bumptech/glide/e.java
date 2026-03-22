package com.bumptech.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.manager.l;

/* compiled from: GenericRequestBuilder.java */
/* loaded from: classes.dex */
public class e<ModelType, DataType, ResourceType, TranscodeType> implements Cloneable {
    private boolean A;
    private Drawable B;
    private int C;

    /* renamed from: a, reason: collision with root package name */
    protected final Class<ModelType> f1912a;

    /* renamed from: b, reason: collision with root package name */
    protected final Context f1913b;

    /* renamed from: c, reason: collision with root package name */
    protected final i f1914c;

    /* renamed from: d, reason: collision with root package name */
    protected final Class<TranscodeType> f1915d;
    protected final l e;
    protected final com.bumptech.glide.manager.g f;
    private com.bumptech.glide.p.a<ModelType, DataType, ResourceType, TranscodeType> g;
    private ModelType h;
    private com.bumptech.glide.load.b i;
    private boolean j;
    private int k;
    private int l;
    private com.bumptech.glide.q.f<? super ModelType, TranscodeType> m;
    private Float n;
    private e<?, ?, ?, TranscodeType> o;
    private Float p;
    private Drawable q;
    private Drawable r;
    private Priority s;
    private boolean t;
    private com.bumptech.glide.q.i.d<TranscodeType> u;
    private int v;
    private int w;
    private DiskCacheStrategy x;
    private com.bumptech.glide.load.f<ResourceType> y;
    private boolean z;

    /* compiled from: GenericRequestBuilder.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.q.e f1916a;

        a(com.bumptech.glide.q.e eVar) {
            this.f1916a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1916a.isCancelled()) {
                return;
            }
            e.this.a((e) this.f1916a);
        }
    }

    /* compiled from: GenericRequestBuilder.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1918a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f1918a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1918a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1918a[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1918a[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.bumptech.glide.p.f<ModelType, DataType, ResourceType, TranscodeType> fVar, Class<TranscodeType> cls, e<ModelType, ?, ?, ?> eVar) {
        this(eVar.f1913b, eVar.f1912a, fVar, cls, eVar.f1914c, eVar.e, eVar.f);
        this.h = eVar.h;
        this.j = eVar.j;
        this.i = eVar.i;
        this.x = eVar.x;
        this.t = eVar.t;
    }

    private Priority c() {
        Priority priority = this.s;
        if (priority == Priority.LOW) {
            return Priority.NORMAL;
        }
        if (priority == Priority.NORMAL) {
            return Priority.HIGH;
        }
        return Priority.IMMEDIATE;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> a(com.bumptech.glide.load.d<DataType, ResourceType> dVar) {
        com.bumptech.glide.p.a<ModelType, DataType, ResourceType, TranscodeType> aVar = this.g;
        if (aVar != null) {
            aVar.a(dVar);
        }
        return this;
    }

    void a() {
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> b(int i) {
        this.k = i;
        return this;
    }

    void b() {
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> b(int i, int i2) {
        if (com.bumptech.glide.s.h.a(i, i2)) {
            this.w = i;
            this.v = i2;
            return this;
        }
        throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public e<ModelType, DataType, ResourceType, TranscodeType> mo3clone() {
        try {
            e<ModelType, DataType, ResourceType, TranscodeType> eVar = (e) super.clone();
            eVar.g = this.g != null ? this.g.m4clone() : null;
            return eVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> a(com.bumptech.glide.load.a<DataType> aVar) {
        com.bumptech.glide.p.a<ModelType, DataType, ResourceType, TranscodeType> aVar2 = this.g;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> a(DiskCacheStrategy diskCacheStrategy) {
        this.x = diskCacheStrategy;
        return this;
    }

    private com.bumptech.glide.q.c b(com.bumptech.glide.q.j.j<TranscodeType> jVar) {
        if (this.s == null) {
            this.s = Priority.NORMAL;
        }
        return a(jVar, (com.bumptech.glide.q.h) null);
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> a(com.bumptech.glide.load.f<ResourceType>... fVarArr) {
        this.z = true;
        if (fVarArr.length == 1) {
            this.y = fVarArr[0];
        } else {
            this.y = new com.bumptech.glide.load.c(fVarArr);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, Class<ModelType> cls, com.bumptech.glide.p.f<ModelType, DataType, ResourceType, TranscodeType> fVar, Class<TranscodeType> cls2, i iVar, l lVar, com.bumptech.glide.manager.g gVar) {
        this.i = com.bumptech.glide.r.b.a();
        this.p = Float.valueOf(1.0f);
        this.s = null;
        this.t = true;
        this.u = com.bumptech.glide.q.i.e.c();
        this.v = -1;
        this.w = -1;
        this.x = DiskCacheStrategy.RESULT;
        this.y = com.bumptech.glide.load.i.d.b();
        this.f1913b = context;
        this.f1912a = cls;
        this.f1915d = cls2;
        this.f1914c = iVar;
        this.e = lVar;
        this.f = gVar;
        this.g = fVar != null ? new com.bumptech.glide.p.a<>(fVar) : null;
        if (context == null) {
            throw new NullPointerException("Context can't be null");
        }
        if (cls != null && fVar == null) {
            throw new NullPointerException("LoadProvider must not be null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e<ModelType, DataType, ResourceType, TranscodeType> a(com.bumptech.glide.q.i.d<TranscodeType> dVar) {
        if (dVar != null) {
            this.u = dVar;
            return this;
        }
        throw new NullPointerException("Animation factory must not be null!");
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> a(int i) {
        this.l = i;
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> a(com.bumptech.glide.q.f<? super ModelType, TranscodeType> fVar) {
        this.m = fVar;
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> a(boolean z) {
        this.t = !z;
        return this;
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> a(com.bumptech.glide.load.b bVar) {
        if (bVar != null) {
            this.i = bVar;
            return this;
        }
        throw new NullPointerException("Signature must not be null");
    }

    public e<ModelType, DataType, ResourceType, TranscodeType> a(ModelType modeltype) {
        this.h = modeltype;
        this.j = true;
        return this;
    }

    public <Y extends com.bumptech.glide.q.j.j<TranscodeType>> Y a(Y y) {
        com.bumptech.glide.s.h.b();
        if (y != null) {
            if (this.j) {
                com.bumptech.glide.q.c d2 = y.d();
                if (d2 != null) {
                    d2.clear();
                    this.e.a(d2);
                    d2.a();
                }
                com.bumptech.glide.q.c b2 = b(y);
                y.a(b2);
                this.f.a(y);
                this.e.b(b2);
                return y;
            }
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
        throw new IllegalArgumentException("You must pass in a non null Target");
    }

    public com.bumptech.glide.q.j.j<TranscodeType> a(ImageView imageView) {
        com.bumptech.glide.s.h.b();
        if (imageView != null) {
            if (!this.z && imageView.getScaleType() != null) {
                int i = b.f1918a[imageView.getScaleType().ordinal()];
                if (i == 1) {
                    a();
                } else if (i == 2 || i == 3 || i == 4) {
                    b();
                }
            }
            com.bumptech.glide.q.j.j<TranscodeType> a2 = this.f1914c.a(imageView, this.f1915d);
            a((e<ModelType, DataType, ResourceType, TranscodeType>) a2);
            return a2;
        }
        throw new IllegalArgumentException("You must pass in a non null View");
    }

    public com.bumptech.glide.q.a<TranscodeType> a(int i, int i2) {
        com.bumptech.glide.q.e eVar = new com.bumptech.glide.q.e(this.f1914c.i(), i, i2);
        this.f1914c.i().post(new a(eVar));
        return eVar;
    }

    private com.bumptech.glide.q.c a(com.bumptech.glide.q.j.j<TranscodeType> jVar, com.bumptech.glide.q.h hVar) {
        e<?, ?, ?, TranscodeType> eVar = this.o;
        if (eVar != null) {
            if (!this.A) {
                if (eVar.u.equals(com.bumptech.glide.q.i.e.c())) {
                    this.o.u = this.u;
                }
                e<?, ?, ?, TranscodeType> eVar2 = this.o;
                if (eVar2.s == null) {
                    eVar2.s = c();
                }
                if (com.bumptech.glide.s.h.a(this.w, this.v)) {
                    e<?, ?, ?, TranscodeType> eVar3 = this.o;
                    if (!com.bumptech.glide.s.h.a(eVar3.w, eVar3.v)) {
                        this.o.b(this.w, this.v);
                    }
                }
                com.bumptech.glide.q.h hVar2 = new com.bumptech.glide.q.h(hVar);
                com.bumptech.glide.q.c a2 = a(jVar, this.p.floatValue(), this.s, hVar2);
                this.A = true;
                com.bumptech.glide.q.c a3 = this.o.a(jVar, hVar2);
                this.A = false;
                hVar2.a(a2, a3);
                return hVar2;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        if (this.n != null) {
            com.bumptech.glide.q.h hVar3 = new com.bumptech.glide.q.h(hVar);
            hVar3.a(a(jVar, this.p.floatValue(), this.s, hVar3), a(jVar, this.n.floatValue(), c(), hVar3));
            return hVar3;
        }
        return a(jVar, this.p.floatValue(), this.s, hVar);
    }

    private com.bumptech.glide.q.c a(com.bumptech.glide.q.j.j<TranscodeType> jVar, float f, Priority priority, com.bumptech.glide.q.d dVar) {
        return com.bumptech.glide.q.b.b(this.g, this.h, this.i, this.f1913b, priority, jVar, f, this.q, this.k, this.r, this.l, this.B, this.C, this.m, dVar, this.f1914c.h(), this.y, this.f1915d, this.t, this.u, this.w, this.v, this.x);
    }
}
