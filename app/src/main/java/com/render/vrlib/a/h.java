package com.render.vrlib.a;

import android.graphics.PointF;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.os.Looper;
import android.util.Log;
import com.render.vrlib.w.o;
import com.render.vrlib.w.p;

/* compiled from: VRUtil.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static float[] f2465a = new float[16];

    /* renamed from: b, reason: collision with root package name */
    private static float[] f2466b = new float[4];

    /* renamed from: c, reason: collision with root package name */
    private static boolean f2467c = false;

    /* renamed from: d, reason: collision with root package name */
    private static int f2468d = -1;

    public static void a(int i) {
        if (i > 3) {
            Log.d("VRUtil", "Rotation is not accessible");
            return;
        }
        if (i < 0) {
            f2468d = -1;
            Log.d("VRUtil", "Using device rotation");
            return;
        }
        Log.d("VRUtil", "setDisplayRotation Surface.ROTATION_" + (i * 90));
        f2468d = i;
    }

    public static void b(String str) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new RuntimeException(str);
        }
    }

    public static void a(SensorEvent sensorEvent, int i, float[] fArr) {
        if (!f2467c) {
            try {
                SensorManager.getRotationMatrixFromVector(f2465a, sensorEvent.values);
            } catch (Exception unused) {
                Log.e("VRUtil", "maybe Samsung bug, will truncate vector");
                f2467c = true;
            }
        }
        if (f2467c) {
            System.arraycopy(sensorEvent.values, 0, f2466b, 0, 4);
            SensorManager.getRotationMatrixFromVector(f2465a, f2466b);
        }
        float[] fArr2 = sensorEvent.values;
        int i2 = f2468d;
        if (i2 != -1) {
            i = i2;
        }
        if (i == 0) {
            SensorManager.getRotationMatrixFromVector(fArr, fArr2);
        } else if (i == 1) {
            SensorManager.getRotationMatrixFromVector(f2465a, fArr2);
            SensorManager.remapCoordinateSystem(f2465a, 2, 129, fArr);
        } else if (i == 2) {
            SensorManager.getRotationMatrixFromVector(f2465a, fArr2);
            SensorManager.remapCoordinateSystem(f2465a, 129, 130, fArr);
        } else if (i == 3) {
            SensorManager.getRotationMatrixFromVector(f2465a, fArr2);
            SensorManager.remapCoordinateSystem(f2465a, 130, 1, fArr);
        }
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new RuntimeException(str);
        }
    }

    public static void a(String str) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new RuntimeException(str);
        }
    }

    public static void a(double d2, double d3, double d4, PointF pointF) {
        double d5 = ((1.0d - d2) - d3) - d4;
        if (pointF.x == 0.0d && pointF.y == 0.0d) {
            return;
        }
        double d6 = pointF.x;
        Double.isNaN(d6);
        double d7 = 1.0f;
        Double.isNaN(d7);
        double d8 = (d6 - 0.0d) / d7;
        double d9 = pointF.y;
        Double.isNaN(d9);
        Double.isNaN(d7);
        double d10 = (d9 - 0.0d) / d7;
        double sqrt = Math.sqrt((d8 * d8) + (d10 * d10));
        double abs = Math.abs(sqrt / (((((((d2 * sqrt) * sqrt) * sqrt) + ((d3 * sqrt) * sqrt)) + (d4 * sqrt)) + d5) * sqrt));
        Double.isNaN(d7);
        Double.isNaN(d7);
        pointF.set((float) ((d8 * abs * d7) + 0.0d), (float) (0.0d + (d10 * abs * d7)));
    }

    public static boolean a(float[] fArr, float[] fArr2) {
        if (fArr2 == fArr) {
            return false;
        }
        return Matrix.invertM(fArr, 0, fArr2, 0);
    }

    public static o a(float f, float f2, com.render.vrlib.w.f fVar) {
        a("point2Ray must called in main Thread");
        float[] a2 = fVar.a();
        float[] fArr = f2465a;
        if (!a(fArr, a2)) {
            return null;
        }
        p pVar = new p();
        float[] b2 = fVar.b();
        pVar.a((-(((f * 2.0f) / fVar.c()) - 1.0f)) / b2[0]);
        pVar.b((((f2 * 2.0f) / fVar.d()) - 1.0f) / b2[5]);
        pVar.c(1.0f);
        p pVar2 = new p();
        p pVar3 = new p();
        pVar2.a((pVar.a() * fArr[0]) + (pVar.b() * fArr[4]) + (pVar.c() * fArr[8]));
        pVar2.b((pVar.a() * fArr[1]) + (pVar.b() * fArr[5]) + (pVar.c() * fArr[9]));
        pVar2.c((pVar.a() * fArr[2]) + (pVar.b() * fArr[6]) + (pVar.c() * fArr[10]));
        pVar3.a(fArr[12]);
        pVar3.b(fArr[13]);
        pVar3.c(fArr[14]);
        return new o(pVar3, pVar2);
    }
}
