package com.render.vrlib;

import android.content.Context;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.util.SparseArray;
import com.render.vrlib.l.e.b;
import com.render.vrlib.l.e.m;
import com.rendergl.google.android.apps.muzei.GLTextureView;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: MD360Renderer.java */
/* loaded from: classes.dex */
public class i implements GLSurfaceView.Renderer {

    /* renamed from: a, reason: collision with root package name */
    private com.render.vrlib.l.a.b f2480a;

    /* renamed from: b, reason: collision with root package name */
    private com.render.vrlib.l.e.o f2481b;

    /* renamed from: c, reason: collision with root package name */
    private com.render.vrlib.j.i f2482c;

    /* renamed from: d, reason: collision with root package name */
    private com.render.vrlib.j.b f2483d;
    private com.render.vrlib.a.d e;
    private int f;
    private int g;
    private final Context h;

    /* compiled from: MD360Renderer.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Context f2484a;

        /* renamed from: b, reason: collision with root package name */
        private com.render.vrlib.l.a.b f2485b;

        /* renamed from: c, reason: collision with root package name */
        private com.render.vrlib.l.e.o f2486c;

        /* renamed from: d, reason: collision with root package name */
        private com.render.vrlib.a.d f2487d;
        private com.render.vrlib.j.i e;

        private a() {
        }

        public i a() {
            return new i(this);
        }

        public a a(com.render.vrlib.a.d dVar) {
            this.f2487d = dVar;
            return this;
        }

        public a a(com.render.vrlib.j.i iVar) {
            this.e = iVar;
            return this;
        }

        public a a(com.render.vrlib.l.a.b bVar) {
            this.f2485b = bVar;
            return this;
        }

        public a a(com.render.vrlib.l.e.o oVar) {
            this.f2486c = oVar;
            return this;
        }
    }

    /* compiled from: MDAbsObject3D.java */
    /* loaded from: classes.dex */
    public abstract class b {

        /* renamed from: a, reason: collision with root package name */
        private ShortBuffer f2488a;

        /* renamed from: b, reason: collision with root package name */
        private int f2489b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f2490c = false;

        /* renamed from: d, reason: collision with root package name */
        private SparseArray<FloatBuffer> f2491d = new SparseArray<>(2);
        private SparseArray<FloatBuffer> e = new SparseArray<>(2);

        protected abstract void a(Context context);

        public void a(com.render.vrlib.h hVar, int i) {
            FloatBuffer b2 = b(i);
            if (b2 == null) {
                this.f2490c = false;
                return;
            }
            this.f2490c = true;
            b2.position(0);
            int e = hVar.e();
            GLES20.glVertexAttribPointer(e, 3, 5126, false, 0, (Buffer) b2);
            GLES20.glEnableVertexAttribArray(e);
        }

        public void b(com.render.vrlib.h hVar, int i) {
            FloatBuffer c2 = c(i);
            if (c2 == null) {
                return;
            }
            c2.position(0);
            int h = hVar.h();
            GLES20.glVertexAttribPointer(h, 2, 5126, false, 0, (Buffer) c2);
            GLES20.glEnableVertexAttribArray(h);
        }

        public synchronized FloatBuffer c(int i) {
            return this.f2491d.get(i);
        }

        public synchronized void c() {
            if (!this.f2490c) {
                Log.d("Vr", " vertexBuffer null,return");
                return;
            }
            if (b() != null) {
                b().position(0);
                GLES20.glDrawElements(4, a(), 5123, b());
            } else {
                GLES20.glDrawArrays(4, 0, a());
            }
        }

        public synchronized FloatBuffer b(int i) {
            return this.e.get(i);
        }

        public void b(int i, FloatBuffer floatBuffer) {
            this.f2491d.put(i, floatBuffer);
        }

        public synchronized int a() {
            return this.f2489b;
        }

        public synchronized ShortBuffer b() {
            return this.f2488a;
        }

        public synchronized void a(int i) {
            this.f2489b = i;
        }

        public synchronized void a(int i, FloatBuffer floatBuffer) {
            this.e.put(i, floatBuffer);
        }

        public synchronized void a(ShortBuffer shortBuffer) {
            this.f2488a = shortBuffer;
        }
    }

    /* compiled from: MDCone3D.java */
    /* loaded from: classes.dex */
    public class d extends b {
        @Override // com.render.vrlib.i.b
        protected void a(Context context) {
            a(this);
        }

        private static void a(b bVar) {
            a(10.0f, 10, 150, bVar);
        }

        private static void a(float f, int i, int i2, b bVar) {
            float f2 = i;
            float f3 = 1.0f / f2;
            float f4 = 1.0f / i2;
            float f5 = f / f2;
            int i3 = i + 1;
            int i4 = i2 + 1;
            int i5 = i3 * i4;
            int i6 = i5 * 3;
            float[] fArr = new float[i6];
            int i7 = i5 * 2;
            float[] fArr2 = new float[i7];
            int i8 = i5 * 6;
            short[] sArr = new short[i8];
            int i9 = 0;
            int i10 = 0;
            for (short s = 0; s < i3; s = (short) (s + 1)) {
                short s2 = 0;
                while (s2 < i4) {
                    int i11 = i3;
                    float f6 = s;
                    float f7 = f6 * f3;
                    float f8 = f3;
                    float f9 = s2;
                    int i12 = i8;
                    int i13 = i6;
                    double d2 = 6.2831855f * f9 * f4;
                    float f10 = (1.0f - f7) * f5;
                    float cos = ((float) Math.cos(d2)) * f10;
                    float sin = ((float) Math.sin(d2)) * f10;
                    int i14 = i9 + 1;
                    fArr2[i9] = 1.0f - (f9 * f4);
                    i9 = i14 + 1;
                    fArr2[i14] = f7;
                    int i15 = i10 + 1;
                    fArr[i10] = cos * f;
                    int i16 = i15 + 1;
                    fArr[i15] = f6;
                    i10 = i16 + 1;
                    fArr[i16] = sin * f;
                    s2 = (short) (s2 + 1);
                    i3 = i11;
                    i6 = i13;
                    f3 = f8;
                    i8 = i12;
                }
            }
            int i17 = i8;
            int i18 = i6;
            int i19 = 0;
            for (short s3 = 0; s3 < i; s3 = (short) (s3 + 1)) {
                short s4 = 0;
                while (s4 < i2) {
                    int i20 = i19 + 1;
                    int i21 = s3 * i4;
                    sArr[i19] = (short) (i21 + s4);
                    int i22 = i20 + 1;
                    int i23 = (s3 + 1) * i4;
                    short s5 = (short) (i23 + s4);
                    sArr[i20] = s5;
                    int i24 = i22 + 1;
                    int i25 = s4 + 1;
                    short s6 = (short) (i21 + i25);
                    sArr[i22] = s6;
                    int i26 = i24 + 1;
                    sArr[i24] = s6;
                    int i27 = i26 + 1;
                    sArr[i26] = s5;
                    i19 = i27 + 1;
                    sArr[i27] = (short) (i23 + i25);
                    s4 = (short) i25;
                }
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i18 * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr);
            asFloatBuffer.position(0);
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(i7 * 4);
            allocateDirect2.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
            asFloatBuffer2.put(fArr2);
            asFloatBuffer2.position(0);
            ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(i17 * 2);
            allocateDirect3.order(ByteOrder.nativeOrder());
            ShortBuffer asShortBuffer = allocateDirect3.asShortBuffer();
            asShortBuffer.put(sArr);
            asShortBuffer.position(0);
            bVar.a(asShortBuffer);
            bVar.b(0, asFloatBuffer2);
            bVar.b(1, asFloatBuffer2);
            bVar.a(0, asFloatBuffer);
            bVar.a(1, asFloatBuffer);
            bVar.a(i17);
        }
    }

    /* compiled from: MDCubeMap.java */
    /* loaded from: classes.dex */
    public class e extends l {
    }

    /* compiled from: MDCylinder3D.java */
    /* loaded from: classes.dex */
    public class f extends b {
        @Override // com.render.vrlib.i.b
        protected void a(Context context) {
            a(this);
        }

        private static void a(b bVar) {
            a(5.432489f, 8, 150, 150, bVar);
        }

        private static void a(float f, int i, int i2, int i3, b bVar) {
            float f2 = 1.0f / i;
            float f3 = 1.0f / i2;
            float f4 = i3 / 360.0f;
            float f5 = ((180 - i3) / 360.0f) * 3.1415927f;
            Log.d("cylinder", "start_angle " + f5);
            int i4 = i + 1;
            int i5 = i2 + 1;
            int i6 = i4 * i5;
            int i7 = i6 * 3;
            float[] fArr = new float[i7];
            int i8 = i6 * 2;
            float[] fArr2 = new float[i8];
            int i9 = i6 * 6;
            short[] sArr = new short[i9];
            short s = 0;
            int i10 = 0;
            int i11 = 0;
            while (s < i4) {
                int i12 = i4;
                short s2 = 0;
                while (s2 < i5) {
                    float f6 = 6.2831855f * f4;
                    float f7 = f4;
                    float f8 = s2;
                    float f9 = (f6 * f8 * f3) + f5;
                    float f10 = f5;
                    double d2 = f9;
                    int i13 = i9;
                    float cos = (float) Math.cos(d2);
                    float sin = (float) Math.sin(d2);
                    int i14 = i10 + 1;
                    fArr2[i10] = 1.0f - (f8 * f3);
                    i10 = i14 + 1;
                    fArr2[i14] = s * f2;
                    int i15 = i11 + 1;
                    fArr[i11] = cos * f;
                    int i16 = i15 + 1;
                    fArr[i15] = s - (i / 2);
                    i11 = i16 + 1;
                    fArr[i16] = sin * f;
                    s2 = (short) (s2 + 1);
                    f5 = f10;
                    f4 = f7;
                    i7 = i7;
                    i9 = i13;
                }
                s = (short) (s + 1);
                i4 = i12;
            }
            int i17 = i9;
            int i18 = i7;
            int i19 = 0;
            for (short s3 = 0; s3 < i; s3 = (short) (s3 + 1)) {
                short s4 = 0;
                while (s4 < i2) {
                    int i20 = i19 + 1;
                    int i21 = s3 * i5;
                    sArr[i19] = (short) (i21 + s4);
                    int i22 = i20 + 1;
                    int i23 = (s3 + 1) * i5;
                    short s5 = (short) (i23 + s4);
                    sArr[i20] = s5;
                    int i24 = i22 + 1;
                    int i25 = s4 + 1;
                    short s6 = (short) (i21 + i25);
                    sArr[i22] = s6;
                    int i26 = i24 + 1;
                    sArr[i24] = s6;
                    int i27 = i26 + 1;
                    sArr[i26] = s5;
                    i19 = i27 + 1;
                    sArr[i27] = (short) (i23 + i25);
                    s4 = (short) i25;
                }
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i18 * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr);
            asFloatBuffer.position(0);
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(i8 * 4);
            allocateDirect2.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
            asFloatBuffer2.put(fArr2);
            asFloatBuffer2.position(0);
            ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(i17 * 2);
            allocateDirect3.order(ByteOrder.nativeOrder());
            ShortBuffer asShortBuffer = allocateDirect3.asShortBuffer();
            asShortBuffer.put(sArr);
            asShortBuffer.position(0);
            bVar.a(asShortBuffer);
            bVar.b(0, asFloatBuffer2);
            bVar.b(1, asFloatBuffer2);
            bVar.a(0, asFloatBuffer);
            bVar.a(1, asFloatBuffer);
            bVar.a(i17);
        }
    }

    /* compiled from: MDDome3D.java */
    /* loaded from: classes.dex */
    public class g extends b {
        float f;
        boolean g;
        RectF h;
        float i = 1.0f;
        float[] j;

        public g(RectF rectF, float f, boolean z) {
            this.h = rectF;
            this.f = f;
            this.g = z;
        }

        @Override // com.render.vrlib.i.b
        protected void a(Context context) {
            a(this.f, this.g, this);
        }

        @Override // com.render.vrlib.i.b
        public void b(com.render.vrlib.h hVar, int i) {
            if (super.c(i) == null) {
                return;
            }
            if (i == 0) {
                float width = this.h.width() / this.h.height();
                if (width != this.i) {
                    int length = this.j.length;
                    float[] fArr = new float[length];
                    for (int i2 = 0; i2 < length; i2 += 2) {
                        float[] fArr2 = this.j;
                        fArr[i2] = ((fArr2[i2] - 0.5f) / width) + 0.5f;
                        int i3 = i2 + 1;
                        fArr[i3] = fArr2[i3];
                    }
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(length * 4);
                    allocateDirect.order(ByteOrder.nativeOrder());
                    FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
                    asFloatBuffer.put(fArr);
                    asFloatBuffer.position(0);
                    b(0, asFloatBuffer);
                    b(1, asFloatBuffer);
                    this.i = width;
                }
            }
            super.b(hVar, i);
        }

        private static void a(float f, boolean z, g gVar) {
            a(18.0f, 150, f, z, gVar);
        }

        public static void a(float f, int i, float f2, boolean z, g gVar) {
            float f3 = f2 / 360.0f;
            float f4 = i >> 1;
            float f5 = 1.0f / f4;
            float f6 = 1.0f / i;
            int i2 = ((int) (f4 * f3)) + 1;
            int i3 = i + 1;
            int i4 = i2 * i3;
            int i5 = i4 * 3;
            float[] fArr = new float[i5];
            int i6 = i4 * 2;
            float[] fArr2 = new float[i6];
            int i7 = i4 * 6;
            short[] sArr = new short[i7];
            int i8 = z ? 1 : -1;
            short s = 0;
            int i9 = 0;
            int i10 = 0;
            while (s < i2) {
                short s2 = 0;
                while (s2 < i3) {
                    double d2 = s2 * 6.2831855f * f6;
                    float f7 = f6;
                    int i11 = i3;
                    double d3 = s * 3.1415927f * f5;
                    int i12 = i5;
                    float[] fArr3 = fArr;
                    float cos = ((float) (Math.cos(d2) * Math.sin(d3))) * i8;
                    float sin = ((float) Math.sin(r4 - 1.5707964f)) * (-i8);
                    float sin2 = (float) (Math.sin(d2) * Math.sin(d3));
                    double cos2 = Math.cos(d2);
                    short[] sArr2 = sArr;
                    double d4 = s;
                    Double.isNaN(d4);
                    short s3 = s2;
                    double d5 = f5;
                    Double.isNaN(d5);
                    double d6 = f3;
                    Double.isNaN(d6);
                    double sin3 = Math.sin(d2);
                    Double.isNaN(d4);
                    Double.isNaN(d5);
                    Double.isNaN(d6);
                    int i13 = i9 + 1;
                    fArr2[i9] = (((float) (((sin3 * d4) * d5) / d6)) / 2.0f) + 0.5f;
                    i9 = i13 + 1;
                    fArr2[i13] = (((float) (((cos2 * d4) * d5) / d6)) / 2.0f) + 0.5f;
                    int i14 = i10 + 1;
                    fArr3[i10] = cos * f;
                    int i15 = i14 + 1;
                    fArr3[i14] = sin * f;
                    i10 = i15 + 1;
                    fArr3[i15] = sin2 * f;
                    s2 = (short) (s3 + 1);
                    i7 = i7;
                    i6 = i6;
                    i8 = i8;
                    i3 = i11;
                    f6 = f7;
                    s = s;
                    i5 = i12;
                    fArr = fArr3;
                    sArr = sArr2;
                }
                s = (short) (s + 1);
            }
            int i16 = i3;
            int i17 = i7;
            int i18 = i5;
            float[] fArr4 = fArr;
            int i19 = i6;
            short[] sArr3 = sArr;
            int i20 = 0;
            for (short s4 = 0; s4 < i2 - 1; s4 = (short) (s4 + 1)) {
                short s5 = 0;
                while (s5 < i16 - 1) {
                    int i21 = i20 + 1;
                    int i22 = s4 * i16;
                    sArr3[i20] = (short) (i22 + s5);
                    int i23 = i21 + 1;
                    int i24 = (s4 + 1) * i16;
                    short s6 = (short) (i24 + s5);
                    sArr3[i21] = s6;
                    int i25 = i23 + 1;
                    int i26 = s5 + 1;
                    short s7 = (short) (i22 + i26);
                    sArr3[i23] = s7;
                    int i27 = i25 + 1;
                    sArr3[i25] = s7;
                    int i28 = i27 + 1;
                    sArr3[i27] = s6;
                    i20 = i28 + 1;
                    sArr3[i28] = (short) (i24 + i26);
                    s5 = (short) i26;
                }
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i18 * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr4);
            asFloatBuffer.position(0);
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(i19 * 4);
            allocateDirect2.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
            asFloatBuffer2.put(fArr2);
            asFloatBuffer2.position(0);
            ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(i17 * 2);
            allocateDirect3.order(ByteOrder.nativeOrder());
            ShortBuffer asShortBuffer = allocateDirect3.asShortBuffer();
            asShortBuffer.put(sArr3);
            asShortBuffer.position(0);
            gVar.a(asShortBuffer);
            gVar.b(0, asFloatBuffer2);
            gVar.b(1, asFloatBuffer2);
            gVar.a(0, asFloatBuffer);
            gVar.a(1, asFloatBuffer);
            gVar.a(i17);
            gVar.j = fArr2;
        }
    }

    /* compiled from: MDHemiSphere3D.java */
    /* loaded from: classes.dex */
    public class h extends b {
        private static float f = -1.0f;

        public h(boolean z) {
            f = z ? 1.0f : -1.0f;
        }

        @Override // com.render.vrlib.i.b
        protected void a(Context context) {
            a(this);
        }

        private static void a(b bVar) {
            a(4.0f, 75, 150, f, bVar);
        }

        private static void a(float f2, int i, int i2, float f3, b bVar) {
            int i3;
            int i4 = i;
            float f4 = f3;
            float f5 = 1.0f / i4;
            float f6 = 1.0f / i2;
            int i5 = i2 + 1;
            int i6 = (i4 + 1) * i5;
            int i7 = i6 * 3;
            float[] fArr = new float[i7];
            int i8 = i6 * 2;
            float[] fArr2 = new float[i8];
            int i9 = i6 * 6;
            short[] sArr = new short[i9];
            short s = 0;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                i3 = i4 / 2;
                if (s >= i3 + 1) {
                    break;
                }
                short s2 = 0;
                while (s2 < i5) {
                    float f7 = f6;
                    double d2 = s2 * 6.2831855f * f6;
                    int i12 = i5;
                    double d3 = s * 3.1415927f * f5;
                    short s3 = s2;
                    float cos = ((float) (Math.cos(d2) * Math.sin(d3))) * f4;
                    float f8 = -f4;
                    short[] sArr2 = sArr;
                    float sin = ((float) Math.sin(r13 - 1.5707964f)) * f8;
                    float sin2 = f8 * ((float) (Math.sin(d3) * Math.sin(d2)));
                    double cos2 = Math.cos(d2);
                    double d4 = s;
                    Double.isNaN(d4);
                    double d5 = f5;
                    Double.isNaN(d5);
                    double sin3 = Math.sin(d2);
                    Double.isNaN(d4);
                    Double.isNaN(d5);
                    int i13 = i10 + 1;
                    fArr2[i10] = ((float) (sin3 * d4 * d5)) + 0.5f;
                    i10 = i13 + 1;
                    fArr2[i13] = ((float) (cos2 * d4 * d5)) + 0.5f;
                    int i14 = i11 + 1;
                    fArr[i11] = cos * f2;
                    int i15 = i14 + 1;
                    fArr[i14] = sin * f2;
                    i11 = i15 + 1;
                    fArr[i15] = sin2 * f2;
                    s2 = (short) (s3 + 1);
                    f4 = f3;
                    f6 = f7;
                    i9 = i9;
                    sArr = sArr2;
                    i5 = i12;
                    i7 = i7;
                    s = s;
                }
                s = (short) (s + 1);
                i4 = i;
                f4 = f3;
            }
            int i16 = i9;
            int i17 = i5;
            int i18 = i7;
            short[] sArr3 = sArr;
            int i19 = 0;
            for (short s4 = 0; s4 < i3; s4 = (short) (s4 + 1)) {
                short s5 = 0;
                while (s5 < i2) {
                    int i20 = i19 + 1;
                    int i21 = s4 * i17;
                    sArr3[i19] = (short) (i21 + s5);
                    int i22 = i20 + 1;
                    int i23 = (s4 + 1) * i17;
                    short s6 = (short) (i23 + s5);
                    sArr3[i20] = s6;
                    int i24 = i22 + 1;
                    int i25 = s5 + 1;
                    short s7 = (short) (i21 + i25);
                    sArr3[i22] = s7;
                    int i26 = i24 + 1;
                    sArr3[i24] = s7;
                    int i27 = i26 + 1;
                    sArr3[i26] = s6;
                    i19 = i27 + 1;
                    sArr3[i27] = (short) (i23 + i25);
                    s5 = (short) i25;
                }
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i18 * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr);
            asFloatBuffer.position(0);
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(i8 * 4);
            allocateDirect2.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
            asFloatBuffer2.put(fArr2);
            asFloatBuffer2.position(0);
            ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(i16 * 2);
            allocateDirect3.order(ByteOrder.nativeOrder());
            ShortBuffer asShortBuffer = allocateDirect3.asShortBuffer();
            asShortBuffer.put(sArr3);
            asShortBuffer.position(0);
            bVar.a(asShortBuffer);
            bVar.b(0, asFloatBuffer2);
            bVar.b(1, asFloatBuffer2);
            bVar.a(0, asFloatBuffer);
            bVar.a(1, asFloatBuffer);
            bVar.a(i16);
        }
    }

    /* compiled from: MDObject3DHelper.java */
    /* renamed from: com.render.vrlib.i$i, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0079i {

        /* compiled from: MDObject3DHelper.java */
        /* renamed from: com.render.vrlib.i$i$a */
        /* loaded from: classes.dex */
        public interface a {
            void a(b bVar);
        }

        public static void a(Context context, b bVar) {
            a(context, bVar, null);
        }

        public static void a(Context context, b bVar, a aVar) {
            new Thread(new j(bVar, context, aVar)).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MDObject3DHelper.java */
    /* loaded from: classes.dex */
    public final class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f2492a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f2493b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ C0079i.a f2494c;

        j(b bVar, Context context, C0079i.a aVar) {
            this.f2492a = bVar;
            this.f2493b = context;
            this.f2494c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2492a.a(this.f2493b);
            C0079i.a aVar = this.f2494c;
            if (aVar != null) {
                aVar.a(this.f2492a);
            }
        }
    }

    /* compiled from: MDSphere3D.java */
    /* loaded from: classes.dex */
    public class l extends b {
        @Override // com.render.vrlib.i.b
        protected void a(Context context) {
            a(this);
        }

        private static void a(b bVar) {
            a(18.0f, 75, 150, bVar);
        }

        private static void a(float f, int i, int i2, b bVar) {
            float f2 = 1.0f / i;
            float f3 = 1.0f / i2;
            int i3 = i + 1;
            int i4 = i2 + 1;
            int i5 = i3 * i4;
            int i6 = i5 * 3;
            float[] fArr = new float[i6];
            int i7 = i5 * 2;
            float[] fArr2 = new float[i7];
            int i8 = i5 * 6;
            short[] sArr = new short[i8];
            int i9 = 0;
            int i10 = 0;
            for (short s = 0; s < i3; s = (short) (s + 1)) {
                for (short s2 = 0; s2 < i4; s2 = (short) (s2 + 1)) {
                    float f4 = s2;
                    int i11 = i3;
                    int i12 = i8;
                    double d2 = 6.2831855f * f4 * f3;
                    float f5 = s;
                    double d3 = 3.1415927f * f5 * f2;
                    short[] sArr2 = sArr;
                    float cos = (float) (Math.cos(d2) * Math.sin(d3));
                    float f6 = -((float) Math.sin(r6 - 1.5707964f));
                    float sin = (float) (Math.sin(d2) * Math.sin(d3));
                    int i13 = i9 + 1;
                    fArr2[i9] = f4 * f3;
                    i9 = i13 + 1;
                    fArr2[i13] = 1.0f - (f5 * f2);
                    int i14 = i10 + 1;
                    fArr[i10] = cos * f;
                    int i15 = i14 + 1;
                    fArr[i14] = f6 * f;
                    i10 = i15 + 1;
                    fArr[i15] = sin * f;
                    i4 = i4;
                    i6 = i6;
                    i3 = i11;
                    i8 = i12;
                    sArr = sArr2;
                }
            }
            int i16 = i4;
            int i17 = i8;
            int i18 = i6;
            short[] sArr3 = sArr;
            int i19 = 0;
            for (short s3 = 0; s3 < i; s3 = (short) (s3 + 1)) {
                short s4 = 0;
                while (s4 < i2) {
                    int i20 = i19 + 1;
                    int i21 = s3 * i16;
                    sArr3[i19] = (short) (i21 + s4);
                    int i22 = i20 + 1;
                    int i23 = (s3 + 1) * i16;
                    short s5 = (short) (i23 + s4);
                    sArr3[i20] = s5;
                    int i24 = i22 + 1;
                    int i25 = s4 + 1;
                    short s6 = (short) (i21 + i25);
                    sArr3[i22] = s6;
                    int i26 = i24 + 1;
                    sArr3[i24] = s6;
                    int i27 = i26 + 1;
                    sArr3[i26] = s5;
                    i19 = i27 + 1;
                    sArr3[i27] = (short) (i23 + i25);
                    s4 = (short) i25;
                }
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i18 * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr);
            asFloatBuffer.position(0);
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(i7 * 4);
            allocateDirect2.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
            asFloatBuffer2.put(fArr2);
            asFloatBuffer2.position(0);
            ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(i17 * 2);
            allocateDirect3.order(ByteOrder.nativeOrder());
            ShortBuffer asShortBuffer = allocateDirect3.asShortBuffer();
            asShortBuffer.put(sArr3);
            asShortBuffer.position(0);
            bVar.a(asShortBuffer);
            bVar.b(0, asFloatBuffer2);
            bVar.b(1, asFloatBuffer2);
            bVar.a(0, asFloatBuffer);
            bVar.a(1, asFloatBuffer);
            bVar.a(i17);
        }
    }

    /* compiled from: MDSphere3dLeft.java */
    /* loaded from: classes.dex */
    public class m extends b {
        @Override // com.render.vrlib.i.b
        protected void a(Context context) {
            a(this);
        }

        private static void a(b bVar) {
            Log.d("MDSphere3dLeft", "");
            a(18.0f, 75, 150, bVar);
        }

        private static void a(float f, int i, int i2, b bVar) {
            float f2 = 1.0f / i;
            float f3 = 1.0f / i2;
            int i3 = i + 1;
            int i4 = i2 + 1;
            int i5 = i3 * i4;
            int i6 = i5 * 3;
            float[] fArr = new float[i6];
            int i7 = i5 * 2;
            float[] fArr2 = new float[i7];
            int i8 = i5 * 6;
            short[] sArr = new short[i8];
            int i9 = 0;
            int i10 = 0;
            for (short s = 0; s < i3; s = (short) (s + 1)) {
                for (short s2 = 0; s2 < i4; s2 = (short) (s2 + 1)) {
                    float f4 = s2;
                    int i11 = i3;
                    int i12 = i8;
                    double d2 = 6.2831855f * f4 * f3;
                    float f5 = s;
                    double d3 = 3.1415927f * f5 * f2;
                    short[] sArr2 = sArr;
                    float cos = (float) (Math.cos(d2) * Math.sin(d3));
                    float f6 = -((float) Math.sin(r6 - 1.5707964f));
                    float sin = (float) (Math.sin(d2) * Math.sin(d3));
                    int i13 = i9 + 1;
                    fArr2[i9] = f4 * f3 * 0.5f;
                    i9 = i13 + 1;
                    fArr2[i13] = 1.0f - (f5 * f2);
                    int i14 = i10 + 1;
                    fArr[i10] = cos * f;
                    int i15 = i14 + 1;
                    fArr[i14] = f6 * f;
                    i10 = i15 + 1;
                    fArr[i15] = sin * f;
                    i4 = i4;
                    i6 = i6;
                    i3 = i11;
                    i8 = i12;
                    sArr = sArr2;
                }
            }
            int i16 = i4;
            int i17 = i8;
            int i18 = i6;
            short[] sArr3 = sArr;
            int i19 = 0;
            for (short s3 = 0; s3 < i; s3 = (short) (s3 + 1)) {
                short s4 = 0;
                while (s4 < i2) {
                    int i20 = i19 + 1;
                    int i21 = s3 * i16;
                    sArr3[i19] = (short) (i21 + s4);
                    int i22 = i20 + 1;
                    int i23 = (s3 + 1) * i16;
                    short s5 = (short) (i23 + s4);
                    sArr3[i20] = s5;
                    int i24 = i22 + 1;
                    int i25 = s4 + 1;
                    short s6 = (short) (i21 + i25);
                    sArr3[i22] = s6;
                    int i26 = i24 + 1;
                    sArr3[i24] = s6;
                    int i27 = i26 + 1;
                    sArr3[i26] = s5;
                    i19 = i27 + 1;
                    sArr3[i27] = (short) (i23 + i25);
                    s4 = (short) i25;
                }
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i18 * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr);
            asFloatBuffer.position(0);
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(i7 * 4);
            allocateDirect2.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
            asFloatBuffer2.put(fArr2);
            asFloatBuffer2.position(0);
            ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(i17 * 2);
            allocateDirect3.order(ByteOrder.nativeOrder());
            ShortBuffer asShortBuffer = allocateDirect3.asShortBuffer();
            asShortBuffer.put(sArr3);
            asShortBuffer.position(0);
            bVar.a(asShortBuffer);
            bVar.b(0, asFloatBuffer2);
            bVar.b(1, asFloatBuffer2);
            bVar.a(0, asFloatBuffer);
            bVar.a(1, asFloatBuffer);
            bVar.a(i17);
        }
    }

    /* compiled from: MDSphere3dTop.java */
    /* loaded from: classes.dex */
    public class n extends b {
        @Override // com.render.vrlib.i.b
        protected void a(Context context) {
            a(this);
        }

        private static void a(b bVar) {
            Log.d("MDSphere3dTop", "");
            a(18.0f, 75, 150, bVar);
        }

        private static void a(float f, int i, int i2, b bVar) {
            float f2 = 1.0f / i;
            float f3 = 1.0f / i2;
            int i3 = i + 1;
            int i4 = i2 + 1;
            int i5 = i3 * i4;
            int i6 = i5 * 3;
            float[] fArr = new float[i6];
            int i7 = i5 * 2;
            float[] fArr2 = new float[i7];
            int i8 = i5 * 6;
            short[] sArr = new short[i8];
            int i9 = 0;
            int i10 = 0;
            for (short s = 0; s < i3; s = (short) (s + 1)) {
                for (short s2 = 0; s2 < i4; s2 = (short) (s2 + 1)) {
                    float f4 = s2;
                    int i11 = i3;
                    int i12 = i8;
                    double d2 = 6.2831855f * f4 * f3;
                    float f5 = s;
                    double d3 = 3.1415927f * f5 * f2;
                    short[] sArr2 = sArr;
                    float cos = (float) (Math.cos(d2) * Math.sin(d3));
                    float f6 = -((float) Math.sin(r6 - 1.5707964f));
                    float sin = (float) (Math.sin(d2) * Math.sin(d3));
                    int i13 = i9 + 1;
                    fArr2[i9] = f4 * f3;
                    i9 = i13 + 1;
                    fArr2[i13] = ((1.0f - (f5 * f2)) / 2.0f) + 0.5f;
                    int i14 = i10 + 1;
                    fArr[i10] = cos * f;
                    int i15 = i14 + 1;
                    fArr[i14] = f6 * f;
                    i10 = i15 + 1;
                    fArr[i15] = sin * f;
                    i4 = i4;
                    i6 = i6;
                    i3 = i11;
                    i8 = i12;
                    sArr = sArr2;
                }
            }
            int i16 = i4;
            int i17 = i8;
            int i18 = i6;
            short[] sArr3 = sArr;
            int i19 = 0;
            for (short s3 = 0; s3 < i; s3 = (short) (s3 + 1)) {
                short s4 = 0;
                while (s4 < i2) {
                    int i20 = i19 + 1;
                    int i21 = s3 * i16;
                    sArr3[i19] = (short) (i21 + s4);
                    int i22 = i20 + 1;
                    int i23 = (s3 + 1) * i16;
                    short s5 = (short) (i23 + s4);
                    sArr3[i20] = s5;
                    int i24 = i22 + 1;
                    int i25 = s4 + 1;
                    short s6 = (short) (i21 + i25);
                    sArr3[i22] = s6;
                    int i26 = i24 + 1;
                    sArr3[i24] = s6;
                    int i27 = i26 + 1;
                    sArr3[i26] = s5;
                    i19 = i27 + 1;
                    sArr3[i27] = (short) (i23 + i25);
                    s4 = (short) i25;
                }
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i18 * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr);
            asFloatBuffer.position(0);
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(i7 * 4);
            allocateDirect2.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
            asFloatBuffer2.put(fArr2);
            asFloatBuffer2.position(0);
            ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(i17 * 2);
            allocateDirect3.order(ByteOrder.nativeOrder());
            ShortBuffer asShortBuffer = allocateDirect3.asShortBuffer();
            asShortBuffer.put(sArr3);
            asShortBuffer.position(0);
            bVar.a(asShortBuffer);
            bVar.b(0, asFloatBuffer2);
            bVar.b(1, asFloatBuffer2);
            bVar.a(0, asFloatBuffer);
            bVar.a(1, asFloatBuffer);
            bVar.a(i17);
        }
    }

    /* compiled from: MDStereoSphere3D.java */
    /* loaded from: classes.dex */
    public class o extends b {
        private com.render.vrlib.a.c f;

        public o(com.render.vrlib.a.c cVar) {
            this.f = com.render.vrlib.a.c.HORIZONTAL;
            this.f = cVar;
        }

        @Override // com.render.vrlib.i.b
        protected void a(Context context) {
            a(this, this.f);
        }

        private static void a(b bVar, com.render.vrlib.a.c cVar) {
            a(18.0f, 75, 150, bVar, cVar);
        }

        private static void a(float f, int i, int i2, b bVar, com.render.vrlib.a.c cVar) {
            float f2 = 1.0f / i;
            float f3 = 1.0f / i2;
            int i3 = i + 1;
            int i4 = i2 + 1;
            int i5 = i3 * i4;
            int i6 = i5 * 3;
            float[] fArr = new float[i6];
            int i7 = i5 * 2;
            float[] fArr2 = new float[i7];
            float[] fArr3 = new float[i7];
            int i8 = i5 * 6;
            short[] sArr = new short[i8];
            short s = 0;
            int i9 = 0;
            int i10 = 0;
            while (s < i3) {
                short s2 = 0;
                while (s2 < i4) {
                    int i11 = i3;
                    float f4 = s2;
                    int i12 = i8;
                    int i13 = i6;
                    double d2 = 6.2831855f * f4 * f3;
                    int i14 = i7;
                    float f5 = s;
                    double d3 = 3.1415927f * f5 * f2;
                    short[] sArr2 = sArr;
                    short s3 = s;
                    float cos = (float) (Math.cos(d2) * Math.sin(d3));
                    float f6 = -((float) Math.sin(r2 - 1.5707964f));
                    float sin = (float) (Math.sin(d2) * Math.sin(d3));
                    if (com.render.vrlib.a.c.VERTICAL == cVar) {
                        float f7 = f4 * f3;
                        fArr2[i9] = f7;
                        fArr3[i9] = f7;
                        int i15 = i9 + 1;
                        float f8 = (f5 * f2) / 2.0f;
                        fArr2[i15] = 1.0f - f8;
                        fArr3[i15] = 0.5f - f8;
                        i9 = i15 + 1;
                    } else {
                        float f9 = (f4 * f3) / 2.0f;
                        fArr2[i9] = f9;
                        fArr3[i9] = f9 + 0.5f;
                        int i16 = i9 + 1;
                        float f10 = 1.0f - (f5 * f2);
                        fArr2[i16] = f10;
                        fArr3[i16] = f10;
                        i9 = i16 + 1;
                    }
                    int i17 = i10 + 1;
                    fArr[i10] = cos * f;
                    int i18 = i17 + 1;
                    fArr[i17] = f6 * f;
                    i10 = i18 + 1;
                    fArr[i18] = sin * f;
                    s2 = (short) (s2 + 1);
                    i6 = i13;
                    i3 = i11;
                    i8 = i12;
                    i7 = i14;
                    sArr = sArr2;
                    s = s3;
                }
                s = (short) (s + 1);
                sArr = sArr;
            }
            int i19 = i8;
            int i20 = i6;
            int i21 = i7;
            short[] sArr3 = sArr;
            int i22 = 0;
            for (short s4 = 0; s4 < i; s4 = (short) (s4 + 1)) {
                short s5 = 0;
                while (s5 < i2) {
                    int i23 = i22 + 1;
                    int i24 = s4 * i4;
                    sArr3[i22] = (short) (i24 + s5);
                    int i25 = i23 + 1;
                    int i26 = (s4 + 1) * i4;
                    short s6 = (short) (i26 + s5);
                    sArr3[i23] = s6;
                    int i27 = i25 + 1;
                    int i28 = s5 + 1;
                    short s7 = (short) (i24 + i28);
                    sArr3[i25] = s7;
                    int i29 = i27 + 1;
                    sArr3[i27] = s7;
                    int i30 = i29 + 1;
                    sArr3[i29] = s6;
                    i22 = i30 + 1;
                    sArr3[i30] = (short) (i26 + i28);
                    s5 = (short) i28;
                }
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i20 * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr);
            asFloatBuffer.position(0);
            int i31 = i21 * 4;
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(i31);
            allocateDirect2.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
            asFloatBuffer2.put(fArr2);
            asFloatBuffer2.position(0);
            ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(i31);
            allocateDirect3.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer3 = allocateDirect3.asFloatBuffer();
            asFloatBuffer3.put(fArr3);
            asFloatBuffer3.position(0);
            ByteBuffer allocateDirect4 = ByteBuffer.allocateDirect(i19 * 2);
            allocateDirect4.order(ByteOrder.nativeOrder());
            ShortBuffer asShortBuffer = allocateDirect4.asShortBuffer();
            asShortBuffer.put(sArr3);
            asShortBuffer.position(0);
            bVar.a(asShortBuffer);
            bVar.b(0, asFloatBuffer2);
            bVar.b(1, asFloatBuffer3);
            bVar.a(0, asFloatBuffer);
            bVar.a(1, asFloatBuffer);
            bVar.a(i19);
        }
    }

    public void a() {
        com.render.vrlib.j.c a2 = this.f2481b.a();
        if (a2 != null) {
            a2.a();
        }
        Iterator<com.render.vrlib.j.c> it2 = this.f2482c.a().iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        com.render.vrlib.a.d dVar = this.e;
        if (dVar != null) {
            dVar.a();
        }
        GLES20.glClear(16640);
        com.render.vrlib.a.b.a("MD360Renderer onDrawFrame begin. ");
        int a2 = this.f2480a.a();
        int i = (int) ((this.f * 1.0f) / a2);
        int i2 = this.g;
        this.f2483d.b(this.h);
        this.f2483d.a(this.f, this.g, a2);
        ConcurrentLinkedQueue<com.render.vrlib.a> f2 = this.f2481b.f();
        com.render.vrlib.j.c a3 = this.f2481b.a();
        if (a3 != null) {
            a3.a(this.h);
            a3.a(this.f, this.g);
        }
        for (com.render.vrlib.j.c cVar : this.f2482c.a()) {
            cVar.a(this.h);
            cVar.a(this.f, this.g);
        }
        for (int i3 = 0; i3 < a2 && i3 < f2.size(); i3++) {
            f2.peek();
            Iterator<com.render.vrlib.a> it2 = f2.iterator();
            int i4 = i3;
            do {
                i4--;
            } while (i4 >= 0);
            com.render.vrlib.a next = it2.next();
            int i5 = i * i3;
            GLES20.glViewport(i5, 0, i, i2);
            GLES20.glEnable(3089);
            GLES20.glScissor(i5, 0, i, i2);
            if (a3 != null) {
                a3.a(i3, i, i2, next);
            }
            Iterator<com.render.vrlib.j.c> it3 = this.f2482c.a().iterator();
            while (it3.hasNext()) {
                it3.next().a(i3, i, i2, next);
            }
            GLES20.glDisable(3089);
        }
        this.f2483d.b(this.f, this.g, a2);
        com.render.vrlib.a.b.a("MD360Renderer onDrawFrame end. ");
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.f = i;
        this.g = i2;
        com.render.vrlib.a.d dVar = this.e;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glEnable(2884);
    }

    /* compiled from: MDBulletPlane.java */
    /* loaded from: classes.dex */
    public class c extends b {
        private float f;
        private RectF g;
        private boolean h;
        private b.c i;

        private c(b.c cVar, RectF rectF) {
            this.h = false;
            this.i = cVar;
            this.g = rectF;
        }

        private float[] d() {
            this.i.b();
            this.f = this.i.a();
            float c2 = this.i.c() * this.g.width();
            float d2 = this.i.d() * this.g.height();
            float[] fArr = new float[f() * 3];
            int g = g();
            int h = h();
            float f = 1.0f / g;
            float f2 = 1.0f / h;
            int i = 0;
            for (short s = 0; s < g + 1; s = (short) (s + 1)) {
                short s2 = 0;
                while (s2 < h + 1) {
                    int i2 = i + 1;
                    fArr[i] = ((s2 * f2) - 0.5f) * c2;
                    int i3 = i2 + 1;
                    fArr[i2] = ((s * f) - 0.5f) * d2;
                    fArr[i3] = 0;
                    s2 = (short) (s2 + 1);
                    i = i3 + 1;
                }
            }
            return fArr;
        }

        private float[] e() {
            float[] fArr = new float[f() * 2];
            int g = g();
            int h = h();
            float f = 1.0f / g;
            float f2 = 1.0f / h;
            int i = 0;
            for (short s = 0; s < g + 1; s = (short) (s + 1)) {
                for (short s2 = 0; s2 < h + 1; s2 = (short) (s2 + 1)) {
                    int i2 = i + 1;
                    fArr[i] = s2 * f2;
                    i = i2 + 1;
                    fArr[i2] = s * f;
                }
            }
            return fArr;
        }

        private int f() {
            return (g() + 1) * (h() + 1);
        }

        private int g() {
            return 1;
        }

        private int h() {
            return 1;
        }

        public void a(b.c cVar) {
            this.i = cVar;
            this.h = true;
        }

        @Override // com.render.vrlib.i.b
        protected void a(Context context) {
            a(this);
        }

        @Override // com.render.vrlib.i.b
        public void a(com.render.vrlib.h hVar, int i) {
            if (this.h) {
                if (b(i) != null) {
                    b(i).clear();
                }
                this.h = false;
            } else if (super.b(i) == null) {
                return;
            }
            if (i == 0) {
                float a2 = this.i.a();
                if (a2 != this.f) {
                    float[] d2 = d();
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(d2.length * 4);
                    allocateDirect.order(ByteOrder.nativeOrder());
                    FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
                    asFloatBuffer.put(d2);
                    asFloatBuffer.position(0);
                    a(0, asFloatBuffer);
                    a(1, asFloatBuffer);
                    this.f = a2;
                }
            }
            super.a(hVar, i);
        }

        public c(b.c cVar) {
            this(cVar, new RectF(0.0f, 0.0f, 1.0f, 1.0f));
        }

        private void a(b bVar) {
            int g = g();
            int h = h();
            float[] d2 = d();
            float[] e = e();
            int f = f() * 6;
            short[] sArr = new short[f];
            int i = h + 1;
            int i2 = 0;
            for (short s = 0; s < g; s = (short) (s + 1)) {
                short s2 = 0;
                while (s2 < h) {
                    int i3 = s * i;
                    int i4 = s2 + 1;
                    short s3 = (short) (i3 + i4);
                    int i5 = (s + 1) * i;
                    short s4 = (short) (i5 + s2);
                    short s5 = (short) (i3 + s2);
                    short s6 = (short) (i5 + i4);
                    int i6 = i2 + 1;
                    sArr[i2] = s3;
                    int i7 = i6 + 1;
                    sArr[i6] = s4;
                    int i8 = i7 + 1;
                    sArr[i7] = s5;
                    int i9 = i8 + 1;
                    sArr[i8] = s3;
                    int i10 = i9 + 1;
                    sArr[i9] = s6;
                    i2 = i10 + 1;
                    sArr[i10] = s4;
                    s2 = (short) i4;
                }
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(d2.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(d2);
            asFloatBuffer.position(0);
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(e.length * 4);
            allocateDirect2.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
            asFloatBuffer2.put(e);
            asFloatBuffer2.position(0);
            ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(f * 2);
            allocateDirect3.order(ByteOrder.nativeOrder());
            ShortBuffer asShortBuffer = allocateDirect3.asShortBuffer();
            asShortBuffer.put(sArr);
            asShortBuffer.position(0);
            bVar.a(asShortBuffer);
            bVar.b(0, asFloatBuffer2);
            bVar.b(1, asFloatBuffer2);
            bVar.a(0, asFloatBuffer);
            bVar.a(1, asFloatBuffer);
            bVar.a(f);
        }
    }

    /* compiled from: MDPlane.java */
    /* loaded from: classes.dex */
    public class k extends b {
        private float f;
        private RectF g;
        private m.c h;
        private boolean i;

        private k(m.c cVar, RectF rectF) {
            this.i = false;
            this.h = cVar;
            this.g = rectF;
        }

        private float[] d() {
            this.h.b();
            this.f = this.h.a();
            float c2 = this.h.c() * this.g.width();
            float d2 = this.h.d() * this.g.height();
            float[] fArr = new float[f() * 3];
            int g = g();
            int h = h();
            float f = 1.0f / g;
            float f2 = 1.0f / h;
            int i = 0;
            for (short s = 0; s < g + 1; s = (short) (s + 1)) {
                short s2 = 0;
                while (s2 < h + 1) {
                    int i2 = i + 1;
                    fArr[i] = ((s2 * f2) - 0.5f) * c2;
                    int i3 = i2 + 1;
                    fArr[i2] = ((s * f) - 0.5f) * d2;
                    fArr[i3] = 0;
                    s2 = (short) (s2 + 1);
                    i = i3 + 1;
                }
            }
            return fArr;
        }

        private float[] e() {
            float[] fArr = new float[f() * 2];
            int g = g();
            int h = h();
            float f = 1.0f / g;
            float f2 = 1.0f / h;
            int i = 0;
            for (short s = 0; s < g + 1; s = (short) (s + 1)) {
                for (short s2 = 0; s2 < h + 1; s2 = (short) (s2 + 1)) {
                    int i2 = i + 1;
                    fArr[i] = s2 * f2;
                    i = i2 + 1;
                    fArr[i2] = s * f;
                }
            }
            return fArr;
        }

        private int f() {
            return (g() + 1) * (h() + 1);
        }

        private int g() {
            return 1;
        }

        private int h() {
            return 1;
        }

        public void a(m.c cVar) {
            this.h = cVar;
            this.i = true;
        }

        @Override // com.render.vrlib.i.b
        protected void a(Context context) {
            a(this);
        }

        @Override // com.render.vrlib.i.b
        public void a(com.render.vrlib.h hVar, int i) {
            if (this.i) {
                if (b(i) != null) {
                    b(i).clear();
                }
                this.i = false;
            } else if (super.b(i) == null) {
                return;
            }
            if (i == 0) {
                float a2 = this.h.a();
                if (a2 != this.f) {
                    float[] d2 = d();
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(d2.length * 4);
                    allocateDirect.order(ByteOrder.nativeOrder());
                    FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
                    asFloatBuffer.put(d2);
                    asFloatBuffer.position(0);
                    a(0, asFloatBuffer);
                    a(1, asFloatBuffer);
                    this.f = a2;
                }
            }
            super.a(hVar, i);
        }

        public k(m.c cVar) {
            this(cVar, new RectF(0.0f, 0.0f, 1.0f, 1.0f));
        }

        private void a(b bVar) {
            int g = g();
            int h = h();
            float[] d2 = d();
            float[] e = e();
            int f = f() * 6;
            short[] sArr = new short[f];
            int i = h + 1;
            int i2 = 0;
            for (short s = 0; s < g; s = (short) (s + 1)) {
                short s2 = 0;
                while (s2 < h) {
                    int i3 = s * i;
                    int i4 = s2 + 1;
                    short s3 = (short) (i3 + i4);
                    int i5 = (s + 1) * i;
                    short s4 = (short) (i5 + s2);
                    short s5 = (short) (i3 + s2);
                    short s6 = (short) (i5 + i4);
                    int i6 = i2 + 1;
                    sArr[i2] = s3;
                    int i7 = i6 + 1;
                    sArr[i6] = s4;
                    int i8 = i7 + 1;
                    sArr[i7] = s5;
                    int i9 = i8 + 1;
                    sArr[i8] = s3;
                    int i10 = i9 + 1;
                    sArr[i9] = s6;
                    i2 = i10 + 1;
                    sArr[i10] = s4;
                    s2 = (short) i4;
                }
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(d2.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(d2);
            asFloatBuffer.position(0);
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(e.length * 4);
            allocateDirect2.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
            asFloatBuffer2.put(e);
            asFloatBuffer2.position(0);
            ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(f * 2);
            allocateDirect3.order(ByteOrder.nativeOrder());
            ShortBuffer asShortBuffer = allocateDirect3.asShortBuffer();
            asShortBuffer.put(sArr);
            asShortBuffer.position(0);
            bVar.a(asShortBuffer);
            bVar.b(0, asFloatBuffer2);
            bVar.b(1, asFloatBuffer2);
            bVar.a(0, asFloatBuffer);
            bVar.a(1, asFloatBuffer);
            bVar.a(f);
        }
    }

    private i(a aVar) {
        new com.render.vrlib.a.a();
        this.h = aVar.f2484a;
        this.f2480a = aVar.f2485b;
        this.f2481b = aVar.f2486c;
        this.f2482c = aVar.e;
        this.e = aVar.f2487d;
        this.f2483d = new com.render.vrlib.j.d(this.f2480a);
    }

    public void a(GLTextureView.a aVar) {
        com.render.vrlib.j.c a2 = this.f2481b.a();
        if (a2 != null) {
            ((com.render.vrlib.j.g) a2).a(aVar);
        }
    }

    public static a a(Context context) {
        a aVar = new a();
        aVar.f2484a = context;
        return aVar;
    }
}
