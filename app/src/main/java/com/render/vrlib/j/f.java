package com.render.vrlib.j;

import android.content.Context;
import android.opengl.GLES20;
import com.render.vrlib.b;
import com.render.vrlib.i;
import com.render.vrlib.l.e.o;
import com.render.vrlib.w.k;
import com.render.vrlib.w.l;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* compiled from: MDMultiFishEyePlugin.java */
/* loaded from: classes.dex */
public class f extends c {

    /* renamed from: d, reason: collision with root package name */
    private com.render.vrlib.h f2506d;
    private com.render.vrlib.n.c f;
    private o g;
    private a h;
    private com.render.vrlib.h e = new com.render.vrlib.h(2);
    private com.render.vrlib.a i = new b.c().createDirector(0);
    private e j = new e();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MDMultiFishEyePlugin.java */
    /* loaded from: classes.dex */
    public class a extends i.b {
        private final com.render.vrlib.a.c f;
        private final float g;

        public a(f fVar, float f, com.render.vrlib.a.c cVar) {
            this.g = f;
            this.f = cVar;
        }

        @Override // com.render.vrlib.i.b
        protected void a(Context context) {
            a(this);
        }

        private void a(i.b bVar) {
            float f = 1.0f;
            float f2 = 1.0f / 16;
            float[] fArr = new float[867];
            float[] fArr2 = new float[578];
            float[] fArr3 = new float[578];
            short[] sArr = new short[1734];
            short s = 0;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (s >= 17) {
                    break;
                }
                short s2 = 0;
                for (short s3 = 17; s2 < s3; s3 = 17) {
                    int i3 = i2 + 1;
                    float f3 = s2 * f2;
                    fArr[i2] = (f3 * 2.0f) - f;
                    int i4 = i3 + 1;
                    float f4 = s * f2;
                    fArr[i3] = (2.0f * f4) - f;
                    int i5 = i4 + 1;
                    fArr[i4] = -8.0f;
                    float[] fArr4 = fArr;
                    double d2 = (f4 - 0.5f) * 3.1415927f;
                    float f5 = f2;
                    double d3 = (f3 - 0.5f) * 3.1415927f;
                    short s4 = s;
                    float cos = (float) (Math.cos(d2) * Math.sin(d3));
                    float cos2 = (float) (Math.cos(d3) * Math.cos(d2));
                    short s5 = s2;
                    float atan2 = (float) Math.atan2((float) Math.sin(d2), cos);
                    double d4 = 0.5f;
                    double atan22 = (this.g * ((float) Math.atan2(Math.sqrt((cos * cos) + (r3 * r3)), cos2))) / 3.1415927f;
                    double d5 = atan2;
                    double cos3 = Math.cos(d5);
                    Double.isNaN(atan22);
                    Double.isNaN(d4);
                    int i6 = i;
                    float f6 = (float) (d4 + (cos3 * atan22));
                    double sin = Math.sin(d5);
                    Double.isNaN(atan22);
                    Double.isNaN(d4);
                    float f7 = (float) (d4 + (atan22 * sin));
                    if (this.f == com.render.vrlib.a.c.HORIZONTAL) {
                        int i7 = i6 * 2;
                        float f8 = f6 * 0.5f;
                        fArr2[i7] = f8;
                        int i8 = i7 + 1;
                        fArr2[i8] = f7;
                        fArr3[i7] = f8 + 0.5f;
                        fArr3[i8] = f7;
                    } else {
                        int i9 = i6 * 2;
                        fArr2[i9] = f6;
                        int i10 = i9 + 1;
                        float f9 = f7 * 0.5f;
                        fArr2[i10] = f9;
                        fArr3[i9] = f6;
                        fArr3[i10] = f9 + 0.5f;
                    }
                    i = i6 + 1;
                    s2 = (short) (s5 + 1);
                    s = s4;
                    i2 = i5;
                    fArr = fArr4;
                    f2 = f5;
                    f = 1.0f;
                }
                s = (short) (s + 1);
                f = 1.0f;
            }
            float[] fArr5 = fArr;
            int i11 = 0;
            for (short s6 = 0; s6 < 16; s6 = (short) (s6 + 1)) {
                short s7 = 0;
                while (s7 < 16) {
                    int i12 = s6 * 17;
                    int i13 = s7 + 1;
                    short s8 = (short) (i12 + i13);
                    int i14 = (s6 + 1) * 17;
                    short s9 = (short) (i14 + s7);
                    short s10 = (short) (i12 + s7);
                    short s11 = (short) (i14 + i13);
                    int i15 = i11 + 1;
                    sArr[i11] = s8;
                    int i16 = i15 + 1;
                    sArr[i15] = s9;
                    int i17 = i16 + 1;
                    sArr[i16] = s10;
                    int i18 = i17 + 1;
                    sArr[i17] = s8;
                    int i19 = i18 + 1;
                    sArr[i18] = s11;
                    i11 = i19 + 1;
                    sArr[i19] = s9;
                    s7 = (short) i13;
                }
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(3468);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr5);
            asFloatBuffer.position(0);
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(2312);
            allocateDirect2.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
            asFloatBuffer2.put(fArr2);
            asFloatBuffer2.position(0);
            ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(2312);
            allocateDirect3.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer3 = allocateDirect3.asFloatBuffer();
            asFloatBuffer3.put(fArr3);
            asFloatBuffer3.position(0);
            ByteBuffer allocateDirect4 = ByteBuffer.allocateDirect(3468);
            allocateDirect4.order(ByteOrder.nativeOrder());
            ShortBuffer asShortBuffer = allocateDirect4.asShortBuffer();
            asShortBuffer.put(sArr);
            asShortBuffer.position(0);
            bVar.a(asShortBuffer);
            bVar.b(0, asFloatBuffer2);
            bVar.b(1, asFloatBuffer3);
            bVar.a(0, asFloatBuffer);
            bVar.a(1, asFloatBuffer);
            bVar.a(1734);
        }
    }

    public f(k kVar, float f, com.render.vrlib.a.c cVar) {
        this.f = kVar.a();
        this.f2506d = new com.render.vrlib.h(kVar.b());
        this.g = kVar.c();
        this.h = new a(this, f, cVar);
    }

    @Override // com.render.vrlib.j.c
    public void a(Context context, boolean z) {
        this.f2506d.a(context);
        this.e.a(context);
        this.f.g();
        i.C0079i.a(context, this.h);
    }

    @Override // com.render.vrlib.j.c
    public void b() {
        this.f = null;
    }

    protected l c() {
        return this.g.c();
    }

    private void b(int i, int i2) {
        GLES20.glClear(16640);
        com.render.vrlib.a.b.a("MDMultiFisheyeConvertLinePipe glClear");
        int i3 = i / 2;
        for (int i4 = 0; i4 < 2; i4++) {
            int i5 = i3 * i4;
            GLES20.glViewport(i5, 0, i3, i2);
            GLES20.glEnable(3089);
            GLES20.glScissor(i5, 0, i3, i2);
            this.f2506d.a();
            this.f.a(this.f2506d);
            this.i.a(i3, i2);
            this.h.a(this.f2506d, i4);
            this.h.b(this.f2506d, i4);
            this.i.c();
            this.i.a(this.f2506d, l.b());
            this.h.c();
            GLES20.glDisable(3089);
        }
    }

    @Override // com.render.vrlib.j.c
    public void a(int i, int i2) {
        this.i.a(i, i2);
        this.j.a(i, i2);
        b(i, i2);
        this.j.b();
    }

    @Override // com.render.vrlib.j.c
    public void a(int i, int i2, int i3, com.render.vrlib.a aVar) {
        i.b b2 = this.g.b();
        if (b2 == null) {
            return;
        }
        aVar.a(i2, i3);
        this.e.a();
        com.render.vrlib.a.b.a("MDPanoramaPlugin mProgram use");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.j.a());
        b2.a(this.e, i);
        b2.b(this.e, i);
        aVar.c();
        aVar.a(this.e, c());
        b2.c();
    }
}
