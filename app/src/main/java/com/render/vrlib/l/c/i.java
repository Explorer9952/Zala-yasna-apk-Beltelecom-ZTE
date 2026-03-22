package com.render.vrlib.l.c;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.WindowManager;
import com.render.vrlib.l.c.g;
import java.util.Iterator;

/* compiled from: MotionStrategy.java */
/* loaded from: classes.dex */
public class i extends a implements SensorEventListener {

    /* renamed from: c, reason: collision with root package name */
    private WindowManager f2526c;

    /* renamed from: d, reason: collision with root package name */
    private float[] f2527d;
    private float[] e;
    private boolean f;
    private Boolean g;
    private final Object h;
    private boolean i;

    public i(g.a aVar) {
        super(aVar);
        this.f2527d = new float[16];
        this.e = new float[16];
        this.f = false;
        this.g = null;
        this.h = new Object();
        new k(this);
    }

    @Override // com.render.vrlib.l.c.f
    public void a() {
    }

    @Override // com.render.vrlib.l.c.f
    public boolean a(float f, float f2, float f3) {
        return false;
    }

    @Override // com.render.vrlib.l.c.f
    public void b(Context context) {
    }

    @Override // com.render.vrlib.l.b
    public void e(Context context) {
        this.i = false;
        a(new j(this, context));
    }

    @Override // com.render.vrlib.l.c.f
    public void f() {
    }

    @Override // com.render.vrlib.l.b
    public boolean f(Context context) {
        if (this.g == null) {
            this.g = Boolean.valueOf(((SensorManager) context.getSystemService("sensor")).getDefaultSensor(11) != null);
        }
        return this.g.booleanValue();
    }

    protected void g(Context context) {
        if (this.f) {
            return;
        }
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        if (defaultSensor == null) {
            Log.e("MotionStrategy", "TYPE_ROTATION_VECTOR sensor not support!");
        } else {
            sensorManager.registerListener(this, defaultSensor, c().f2516a, com.render.vrlib.a.e.b());
            this.f = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Context context) {
        if (this.f) {
            ((SensorManager) context.getSystemService("sensor")).unregisterListener(this);
            this.f = false;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        if (c().f2517b != null) {
            c().f2517b.onAccuracyChanged(sensor, i);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (!this.i || sensorEvent.accuracy == 0) {
            return;
        }
        if (c().f2517b != null) {
            c().f2517b.onSensorChanged(sensorEvent);
        }
        if (sensorEvent.sensor.getType() != 11) {
            return;
        }
        WindowManager windowManager = this.f2526c;
        if (windowManager != null && windowManager.getDefaultDisplay() != null) {
            com.render.vrlib.a.h.a(sensorEvent, this.f2526c.getDefaultDisplay().getRotation(), this.f2527d);
        }
        System.arraycopy(this.f2527d, 0, this.e, 0, 16);
        if (this.f && this.i) {
            Iterator<com.render.vrlib.a> it2 = d().iterator();
            while (it2.hasNext()) {
                it2.next().a(this.e);
            }
        }
    }

    @Override // com.render.vrlib.l.b
    public void a(Context context) {
        this.i = true;
        this.f2526c = (WindowManager) context.getSystemService("window");
        Iterator<com.render.vrlib.a> it2 = d().iterator();
        while (it2.hasNext()) {
            it2.next().n();
        }
    }

    @Override // com.render.vrlib.l.b
    public void c(Context context) {
        g(context);
    }

    @Override // com.render.vrlib.l.b
    public void d(Context context) {
        h(context);
    }
}
