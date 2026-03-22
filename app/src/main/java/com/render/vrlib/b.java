package com.render.vrlib;

import android.opengl.Matrix;
import com.render.vrlib.a;

/* compiled from: MD360DirectorFactory.java */
/* loaded from: classes.dex */
public abstract class b {

    /* compiled from: MD360DirectorFactory.java */
    /* loaded from: classes.dex */
    public static class a extends b {
        @Override // com.render.vrlib.b
        public com.render.vrlib.a createDirector(int i) {
            return com.render.vrlib.a.s().a();
        }
    }

    /* compiled from: MD360DirectorFactory.java */
    /* renamed from: com.render.vrlib.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0078b extends com.render.vrlib.a {
        @Override // com.render.vrlib.a
        protected void a() {
            Matrix.orthoM(h(), 0, -1.0f, 1.0f, -1.0f, 1.0f, b(), 500.0f);
        }

        @Override // com.render.vrlib.a
        public void a(float f) {
        }

        @Override // com.render.vrlib.a
        public void a(float[] fArr) {
        }

        @Override // com.render.vrlib.a
        public void b(float f) {
        }

        private C0078b(a.C0077a c0077a) {
            super(c0077a);
        }
    }

    /* compiled from: MD360DirectorFactory.java */
    /* loaded from: classes.dex */
    public static class c extends b {
        @Override // com.render.vrlib.b
        public com.render.vrlib.a createDirector(int i) {
            return new C0078b(new a.C0077a());
        }
    }

    public abstract com.render.vrlib.a createDirector(int i);
}
