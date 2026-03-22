package com.render.vrlib.l.c;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.util.Log;
import android.view.WindowManager;
import com.render.vrlib.l.c.g;
import java.util.Iterator;

/* compiled from: CardboardMotionStrategy.java */
/* loaded from: classes.dex */
public class c extends a implements SensorEventListener {

    /* renamed from: c, reason: collision with root package name */
    private boolean f2511c;

    /* renamed from: d, reason: collision with root package name */
    private Boolean f2512d;
    private float[] e;
    private final Object f;
    private d.d.a.a.a.a.f g;
    private d.d.a.a.a.a.c h;
    private boolean i;
    private Runnable j;

    public c(g.a aVar) {
        super(aVar);
        this.f2511c = false;
        this.f2512d = null;
        this.e = new float[16];
        this.f = new Object();
        this.j = new e(this);
    }

    private void g(Context context) {
        if (this.f2511c) {
            return;
        }
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        Sensor defaultSensor2 = sensorManager.getDefaultSensor(4);
        if (defaultSensor == null && defaultSensor2 == null) {
            Log.e("CardboardMotionStrategy", "TYPE_ACCELEROMETER TYPE_GYROSCOPE sensor not support!");
            return;
        }
        if (this.h == null) {
            this.h = new d.d.a.a.a.a.c(sensorManager, c().f2516a);
        }
        if (this.g == null) {
            this.g = new d.d.a.a.a.a.f(this.h, new d.d.a.a.a.a.h(), ((WindowManager) context.getSystemService("window")).getDefaultDisplay());
        }
        this.h.b(this);
        this.g.a();
        this.f2511c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Context context) {
        if (this.f2511c) {
            this.h.a(this);
            this.g.b();
            this.f2511c = false;
        }
    }

    @Override // com.render.vrlib.l.c.f
    public void a() {
    }

    public boolean a(float f, float f2, float f3) {
        return false;
    }

    @Override // com.render.vrlib.l.c.f
    public void b(Context context) {
    }

    @Override // com.render.vrlib.l.b
    public void e(Context context) {
        this.i = false;
        a(new d(this, context));
    }

    @Override // com.render.vrlib.l.c.f
    public void f() {
    }

    @Override // com.render.vrlib.l.b
    public boolean f(Context context) {
        if (this.f2512d == null) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            boolean z = true;
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            Sensor defaultSensor2 = sensorManager.getDefaultSensor(4);
            if (defaultSensor == null && defaultSensor2 == null) {
                z = false;
            }
            this.f2512d = Boolean.valueOf(z);
        }
        return this.f2512d.booleanValue();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        if (c().f2517b != null) {
            c().f2517b.onAccuracyChanged(sensor, i);
        }
        synchronized (this.f) {
            Matrix.setIdentityM(this.e, 0);
            this.g.a(this.e, 0);
        }
        c().f2519d.a(this.j);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (!this.i || sensorEvent.accuracy == 0) {
            return;
        }
        if (c().f2517b != null) {
            c().f2517b.onSensorChanged(sensorEvent);
        }
        synchronized (this.f) {
            Matrix.setIdentityM(this.e, 0);
            this.g.a(this.e, 0);
        }
        c().f2519d.a(this.j);
    }

    @Override // com.render.vrlib.l.b
    public void c(Context context) {
        g(context);
    }

    @Override // com.render.vrlib.l.b
    public void d(Context context) {
        h(context);
    }

    @Override // com.render.vrlib.l.b
    public void a(Context context) {
        this.i = true;
        Iterator<com.render.vrlib.a> it2 = d().iterator();
        while (it2.hasNext()) {
            it2.next().n();
        }
    }
}
