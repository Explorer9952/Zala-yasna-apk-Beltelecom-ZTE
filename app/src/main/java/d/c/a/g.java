package d.c.a;

import android.view.animation.Interpolator;

/* compiled from: Keyframe.java */
/* loaded from: classes.dex */
public abstract class g implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    float f7978a;

    /* renamed from: b, reason: collision with root package name */
    private Interpolator f7979b = null;

    /* renamed from: c, reason: collision with root package name */
    boolean f7980c = false;

    /* compiled from: Keyframe.java */
    /* loaded from: classes.dex */
    static class a extends g {

        /* renamed from: d, reason: collision with root package name */
        float f7981d;

        a(float f, float f2) {
            this.f7978a = f;
            this.f7981d = f2;
            Class cls = Float.TYPE;
            this.f7980c = true;
        }

        @Override // d.c.a.g
        public void a(Object obj) {
            if (obj == null || obj.getClass() != Float.class) {
                return;
            }
            this.f7981d = ((Float) obj).floatValue();
            this.f7980c = true;
        }

        @Override // d.c.a.g
        public Object c() {
            return Float.valueOf(this.f7981d);
        }

        public float e() {
            return this.f7981d;
        }

        @Override // d.c.a.g
        /* renamed from: clone */
        public a m14clone() {
            a aVar = new a(a(), this.f7981d);
            aVar.a(b());
            return aVar;
        }

        a(float f) {
            this.f7978a = f;
            Class cls = Float.TYPE;
        }
    }

    /* compiled from: Keyframe.java */
    /* loaded from: classes.dex */
    static class b extends g {

        /* renamed from: d, reason: collision with root package name */
        Object f7982d;

        b(float f, Object obj) {
            this.f7978a = f;
            this.f7982d = obj;
            boolean z = obj != null;
            this.f7980c = z;
            if (z) {
                obj.getClass();
            }
        }

        @Override // d.c.a.g
        public void a(Object obj) {
            this.f7982d = obj;
            this.f7980c = obj != null;
        }

        @Override // d.c.a.g
        public Object c() {
            return this.f7982d;
        }

        @Override // d.c.a.g
        /* renamed from: clone */
        public b m14clone() {
            b bVar = new b(a(), this.f7982d);
            bVar.a(b());
            return bVar;
        }
    }

    public static g a(float f, float f2) {
        return new a(f, f2);
    }

    public static g b(float f) {
        return new b(f, null);
    }

    public abstract void a(Object obj);

    public abstract Object c();

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public abstract g m14clone();

    public boolean d() {
        return this.f7980c;
    }

    public static g a(float f) {
        return new a(f);
    }

    public Interpolator b() {
        return this.f7979b;
    }

    public static g a(float f, Object obj) {
        return new b(f, obj);
    }

    public float a() {
        return this.f7978a;
    }

    public void a(Interpolator interpolator) {
        this.f7979b = interpolator;
    }
}
