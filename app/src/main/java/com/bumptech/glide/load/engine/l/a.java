package com.bumptech.glide.load.engine.l;

import android.graphics.Bitmap;

/* compiled from: AttributeStrategy.java */
/* loaded from: classes.dex */
class a implements g {

    /* renamed from: a, reason: collision with root package name */
    private final b f2013a = new b();

    /* renamed from: b, reason: collision with root package name */
    private final e<C0064a, Bitmap> f2014b = new e<>();

    /* compiled from: AttributeStrategy.java */
    /* loaded from: classes.dex */
    static class b extends com.bumptech.glide.load.engine.l.b<C0064a> {
        b() {
        }

        public C0064a a(int i, int i2, Bitmap.Config config) {
            C0064a b2 = b();
            b2.a(i, i2, config);
            return b2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.engine.l.b
        public C0064a a() {
            return new C0064a(this);
        }
    }

    private static String d(Bitmap bitmap) {
        return d(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.l.g
    public void a(Bitmap bitmap) {
        this.f2014b.a(this.f2013a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.engine.l.g
    public String b(int i, int i2, Bitmap.Config config) {
        return d(i, i2, config);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f2014b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    @Override // com.bumptech.glide.load.engine.l.g
    public int b(Bitmap bitmap) {
        return com.bumptech.glide.s.h.a(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.l.g
    public String c(Bitmap bitmap) {
        return d(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AttributeStrategy.java */
    /* renamed from: com.bumptech.glide.load.engine.l.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0064a implements h {

        /* renamed from: a, reason: collision with root package name */
        private final b f2015a;

        /* renamed from: b, reason: collision with root package name */
        private int f2016b;

        /* renamed from: c, reason: collision with root package name */
        private int f2017c;

        /* renamed from: d, reason: collision with root package name */
        private Bitmap.Config f2018d;

        public C0064a(b bVar) {
            this.f2015a = bVar;
        }

        public void a(int i, int i2, Bitmap.Config config) {
            this.f2016b = i;
            this.f2017c = i2;
            this.f2018d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0064a)) {
                return false;
            }
            C0064a c0064a = (C0064a) obj;
            return this.f2016b == c0064a.f2016b && this.f2017c == c0064a.f2017c && this.f2018d == c0064a.f2018d;
        }

        public int hashCode() {
            int i = ((this.f2016b * 31) + this.f2017c) * 31;
            Bitmap.Config config = this.f2018d;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return a.d(this.f2016b, this.f2017c, this.f2018d);
        }

        @Override // com.bumptech.glide.load.engine.l.h
        public void a() {
            this.f2015a.a(this);
        }
    }

    @Override // com.bumptech.glide.load.engine.l.g
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.f2014b.a((e<C0064a, Bitmap>) this.f2013a.a(i, i2, config));
    }

    @Override // com.bumptech.glide.load.engine.l.g
    public Bitmap a() {
        return this.f2014b.a();
    }
}
