package d.d.a.a.a.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.opengl.Matrix;
import android.view.Display;
import d.d.a.a.a.a.a.a;

/* compiled from: HeadTracker.java */
/* loaded from: classes.dex */
public class f implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private final Display f8030a;
    private volatile boolean i;
    private a l;
    private g m;
    private b n;
    private long o;

    /* renamed from: b, reason: collision with root package name */
    private final float[] f8031b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    private final float[] f8032c = new float[16];

    /* renamed from: d, reason: collision with root package name */
    private float f8033d = -1.0f;
    private final float[] e = new float[16];
    private final float[] f = new float[16];
    private final float[] g = new float[16];
    private float h = 1.0f;
    private final Object k = new Object();
    private volatile boolean p = true;
    private float[] q = new float[3];
    private final d.d.a.a.a.a.a.g r = new d.d.a.a.a.a.a.g();
    private final d.d.a.a.a.a.a.g s = new d.d.a.a.a.a.a.g();
    private final d.d.a.a.a.a.a.g t = new d.d.a.a.a.a.a.g();
    private final d.d.a.a.a.a.a.d j = new d.d.a.a.a.a.a.d();

    public f(g gVar, b bVar, Display display) {
        this.n = bVar;
        this.m = gVar;
        this.f8030a = display;
        a(true);
        Matrix.setIdentityM(this.e, 0);
    }

    public void a() {
        if (this.i) {
            return;
        }
        this.j.a();
        synchronized (this.k) {
            if (this.l != null) {
                this.l.a();
            }
        }
        this.p = true;
        this.m.b(this);
        this.m.a();
        this.i = true;
    }

    public void b() {
        if (this.i) {
            this.m.a(this);
            this.m.b();
            this.i = false;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            d.d.a.a.a.a.a.g gVar = this.t;
            float[] fArr = sensorEvent.values;
            gVar.a(fArr[0], fArr[1], fArr[2]);
            this.j.b(this.t, sensorEvent.timestamp);
            synchronized (this.k) {
                if (this.l != null) {
                    this.l.b(this.t, sensorEvent.timestamp);
                }
            }
            return;
        }
        if (sensorEvent.sensor.getType() == 4 || sensorEvent.sensor.getType() == 16) {
            this.o = this.n.a();
            if (sensorEvent.sensor.getType() == 16) {
                if (this.p) {
                    float[] fArr2 = sensorEvent.values;
                    if (fArr2.length == 6) {
                        float[] fArr3 = this.q;
                        fArr3[0] = fArr2[3];
                        fArr3[1] = fArr2[4];
                        fArr3[2] = fArr2[5];
                    }
                }
                d.d.a.a.a.a.a.g gVar2 = this.s;
                float f = sensorEvent.values[0];
                float[] fArr4 = this.q;
                gVar2.a(f - fArr4[0], r2[1] - fArr4[1], r2[2] - fArr4[2]);
            } else {
                d.d.a.a.a.a.a.g gVar3 = this.s;
                float[] fArr5 = sensorEvent.values;
                gVar3.a(fArr5[0], fArr5[1], fArr5[2]);
            }
            this.p = false;
            synchronized (this.k) {
                if (this.l != null) {
                    this.l.a(this.s, sensorEvent.timestamp);
                    this.l.a(this.r);
                    d.d.a.a.a.a.a.g.b(this.s, this.r, this.s);
                }
            }
            this.j.a(this.s, sensorEvent.timestamp);
        }
    }

    public void a(boolean z) {
        synchronized (this.k) {
            if (!z) {
                this.l = null;
            } else if (this.l == null) {
                this.l = new a();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(float[] r17, int r18) {
        /*
            Method dump skipped, instructions count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.d.a.a.a.a.f.a(float[], int):void");
    }
}
