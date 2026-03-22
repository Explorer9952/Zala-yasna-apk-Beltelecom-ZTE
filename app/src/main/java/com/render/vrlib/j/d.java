package com.render.vrlib.j;

import android.content.Context;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.render.vrlib.b;
import com.render.vrlib.i;
import com.render.vrlib.w.l;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* compiled from: MDBarrelDistortionLinePipe.java */
/* loaded from: classes.dex */
public class d extends b {
    private boolean f;
    private com.render.vrlib.w.a h;
    private com.render.vrlib.l.a.b i;

    /* renamed from: c, reason: collision with root package name */
    private com.render.vrlib.h f2500c = new com.render.vrlib.h(2);
    private com.render.vrlib.a e = new b.c().createDirector(0);

    /* renamed from: d, reason: collision with root package name */
    private a f2501d = new a();
    private e g = new e();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MDBarrelDistortionLinePipe.java */
    /* loaded from: classes.dex */
    public class a extends i.b {
        private int f;
        private FloatBuffer g;

        public a() {
        }

        @Override // com.render.vrlib.i.b
        protected void a(Context context) {
            a(this);
        }

        @Override // com.render.vrlib.i.b
        public FloatBuffer c(int i) {
            int i2 = this.f;
            if (i2 == 1) {
                return this.g;
            }
            if (i2 == 2) {
                return super.c(i);
            }
            return null;
        }

        public void d(int i) {
            this.f = i;
        }

        private void a(i.b bVar) {
            short s = 10;
            float f = 1.0f / 10;
            float[] fArr = new float[363];
            float[] fArr2 = new float[242];
            float[] fArr3 = new float[242];
            float[] fArr4 = new float[242];
            short[] sArr = new short[726];
            short s2 = 0;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (s2 >= 11) {
                    break;
                }
                short s3 = 0;
                for (short s4 = 11; s3 < s4; s4 = 11) {
                    int i3 = i + 1;
                    float f2 = s3 * f;
                    fArr2[i] = f2;
                    float f3 = s2 * f;
                    fArr2[i3] = f3;
                    float f4 = f2 * 0.5f;
                    fArr3[i] = f4;
                    fArr3[i3] = f3;
                    fArr4[i] = f4 + 0.5f;
                    fArr4[i3] = f3;
                    int i4 = i2 + 1;
                    fArr[i2] = (f2 * 2.0f) - 1.0f;
                    int i5 = i4 + 1;
                    fArr[i4] = (f3 * 2.0f) - 1.0f;
                    i2 = i5 + 1;
                    fArr[i5] = -8.0f;
                    s3 = (short) (s3 + 1);
                    i = i3 + 1;
                }
                s2 = (short) (s2 + 1);
            }
            a(121, fArr);
            short s5 = 0;
            int i6 = 0;
            while (s5 < s) {
                short s6 = 0;
                while (s6 < s) {
                    int i7 = s5 * 11;
                    int i8 = s6 + 1;
                    short s7 = (short) (i7 + i8);
                    int i9 = (s5 + 1) * 11;
                    short s8 = (short) (i9 + s6);
                    short s9 = (short) (i7 + s6);
                    short s10 = (short) (i9 + i8);
                    int i10 = i6 + 1;
                    sArr[i6] = s7;
                    int i11 = i10 + 1;
                    sArr[i10] = s8;
                    int i12 = i11 + 1;
                    sArr[i11] = s9;
                    int i13 = i12 + 1;
                    sArr[i12] = s7;
                    int i14 = i13 + 1;
                    sArr[i13] = s10;
                    i6 = i14 + 1;
                    sArr[i14] = s8;
                    s6 = (short) i8;
                    s = 10;
                }
                s5 = (short) (s5 + 1);
                s = 10;
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1452);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr);
            asFloatBuffer.position(0);
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(968);
            allocateDirect2.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
            asFloatBuffer2.put(fArr2);
            asFloatBuffer2.position(0);
            ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(968);
            allocateDirect3.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer3 = allocateDirect3.asFloatBuffer();
            asFloatBuffer3.put(fArr3);
            asFloatBuffer3.position(0);
            ByteBuffer allocateDirect4 = ByteBuffer.allocateDirect(968);
            allocateDirect4.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer4 = allocateDirect4.asFloatBuffer();
            asFloatBuffer4.put(fArr4);
            asFloatBuffer4.position(0);
            ByteBuffer allocateDirect5 = ByteBuffer.allocateDirect(1452);
            allocateDirect5.order(ByteOrder.nativeOrder());
            ShortBuffer asShortBuffer = allocateDirect5.asShortBuffer();
            asShortBuffer.put(sArr);
            asShortBuffer.position(0);
            bVar.a(asShortBuffer);
            bVar.b(0, asFloatBuffer3);
            bVar.b(1, asFloatBuffer4);
            bVar.a(0, asFloatBuffer);
            bVar.a(1, asFloatBuffer);
            bVar.a(726);
            this.g = asFloatBuffer2;
        }

        private void a(int i, float[] fArr) {
            PointF pointF = new PointF();
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = i2 * 3;
                int i4 = i3 + 1;
                pointF.set(fArr[i3], fArr[i4]);
                com.render.vrlib.a.h.a(d.this.h.a(), d.this.h.b(), d.this.h.c(), pointF);
                fArr[i3] = pointF.x * d.this.h.d();
                fArr[i4] = pointF.y * d.this.h.d();
            }
        }
    }

    public d(com.render.vrlib.l.a.b bVar) {
        this.i = bVar;
        this.h = bVar.h();
    }

    @Override // com.render.vrlib.j.b
    public void b(int i, int i2, int i3) {
        if (this.f) {
            this.g.b();
            int i4 = i / i3;
            for (int i5 = 0; i5 < i3; i5++) {
                int i6 = i4 * i5;
                GLES20.glViewport(i6, 0, i4, i2);
                GLES20.glEnable(3089);
                GLES20.glScissor(i6, 0, i4, i2);
                a(i5);
                GLES20.glDisable(3089);
            }
        }
    }

    @Override // com.render.vrlib.j.b
    public void a(Context context) {
        this.f2500c.a(context);
        i.C0079i.a(context, this.f2501d);
    }

    @Override // com.render.vrlib.j.b
    public void a(int i, int i2, int i3) {
        boolean f = this.i.f();
        this.f = f;
        if (f) {
            this.g.a(i, i2);
            this.e.a(i, i2);
            this.f2501d.d(i3);
            GLES20.glClear(16640);
            com.render.vrlib.a.b.a("MDBarrelDistortionLinePipe glClear");
        }
    }

    private void a(int i) {
        this.f2500c.a();
        com.render.vrlib.a.b.a("MDBarrelDistortionLinePipe mProgram use");
        this.f2501d.a(this.f2500c, i);
        this.f2501d.b(this.f2500c, i);
        this.e.c();
        this.e.a(this.f2500c, l.b());
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.g.a());
        this.f2501d.c();
    }
}
